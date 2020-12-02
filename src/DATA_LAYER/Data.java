package DATA_LAYER;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ENTITES.approval;
import ENTITES.courses;
import ENTITES.grades;
import ENTITES.profile;
import ENTITES.registered;
import ENTITES.user;

@Repository
public class Data {
	  @Autowired
		private SessionFactory sf;
	  
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public int save_value(user use) {
		int value=0;
		try(Session session=getSf().openSession())
		{
		  profile pro=use.getPro();
		  // child refernce
		  use.setPro(pro);
		  // parent refernce 
		  pro.setObj(use);
		  // checking the username and University Id and email_id exist
		  //user object=session.get(user.class,use.getUsername());
		  //profile instance=session.get(profile.class,pro.getId());
		  String HQL="from user e inner join Fetch e.pro a where e.username=? or a.id=? or a.email_id=?";
	        Query<user> query=session.createQuery(HQL);
	        query.setParameter(0,use.getUsername());
	        query.setParameter(1,pro.getId());
	        query.setParameter(2,pro.getEmail_id());
	        user object=query.uniqueResult();
		  if(object==null)
		  {
		  session.beginTransaction();
	      session.save(use);
		  session.save(pro);
		  session.getTransaction().commit();
		  value=1;
	       }
		}  
		catch(Exception e)
		{
			e.printStackTrace();
		}
	     return value;   
	}

	public profile get(String username, String password, String role) {
		profile object=null;
		try(Session session=getSf().openSession())
		{
			session.beginTransaction();
	        String HQL="from user e inner join Fetch e.pro a where e.username=? and e.password=? and a.role=?";
	        Query<user> query=session.createQuery(HQL);
	        query.setParameter(0,username);
	        query.setParameter(1,password);
	        query.setParameter(2,role);
	        user list=query.uniqueResult();
	        if(list!=null)
	        {
				profile objc=list.getPro();
				System.out.println(objc);
				object=objc;
	        }
	        else
	        {
	        	object=null;
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return object;
	}

	public void save(profile  use) {
		try(Session session=getSf().openSession())
		{
		 String HQL="update profile set firstname=?,lastname=?,number=?,address=? where id=?";
		 Query query=session.createQuery(HQL);
		 query.setParameter(0,use.getFirstname());
		 query.setParameter(1,use.getLastname());
		 query.setParameter(2,use.getNumber());
		 query.setParameter(3,use.getAddress());
		 query.setParameter(4,use.getId());
		 session.beginTransaction();
		 int value=query.executeUpdate();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean course_insert(courses cou) {
		boolean val=false;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String id=cou.getCourse_id();
		courses cour=session.get(courses.class,id);
		if(cour==null)
		{
			session.save(cou);
			val=true;
		}
		else
		{
			val=false;
		}
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}

	public List<courses> getdetails_course() {
		List<courses>val=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="from courses";
		Query<courses>query=session.createQuery(HQL,courses.class);
		 val=query.list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}

	public courses course_id(String id) {
		courses our=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		our=session.get(courses.class,id);
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return our;
	}

	public void update_course(courses cour) {
		try(Session session=getSf().openSession())
		{
		 String HQL="update courses set course_name=?,credits=?,staffname=?,days=?,timings=?,semester=? where course_id=?";
		 Query query=session.createQuery(HQL);
		 query.setParameter(0,cour.getCourse_name());
		 query.setParameter(1,cour.getCredits());
		 query.setParameter(2,cour.getStaffname());
		 query.setParameter(3,cour.getDays());
		 query.setParameter(4,cour.getTimings());
		 query.setParameter(5,cour.getSemester());
		 query.setParameter(6,cour.getCourse_id());
		 session.beginTransaction();
		 int value=query.executeUpdate();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void delete(String id) {
		try(Session session=getSf().openSession())
		{
		 String HQL="delete from courses where course_id=?";
		 Query query=session.createQuery(HQL);
		 query.setParameter(0,id);
		 session.beginTransaction();
		 int value=query.executeUpdate();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public boolean approval_table(String id, profile obj) {
		boolean data=false;
		try(Session session=getSf().openSession())
		{
		 //approval object=session.get(approval.class,id);
			 String HQL="from approval where id=? and course_id=?";
		        Query<user> query=session.createQuery(HQL);
		        query.setParameter(0,obj.getId());
		        query.setParameter(1,id);
		        user object=query.uniqueResult();
		 if(object==null)
		 {
         courses cour=session.get(courses.class,id);
         approval app=new approval();
         // setting the values in the approval table student details
         app.setId(obj.getId());
         app.setFirstname(obj.getFirstname()+obj.getLastname());
         app.setDepartment(obj.getDepartment());
         // setting the values in the approval table course details
         app.setCourse_id(cour.getCourse_id());
         app.setCourse_name(cour.getCourse_name());
         app.setCredits(cour.getCredits());
         app.setStaffname(cour.getStaffname());
         app.setDays(cour.getDays());
         app.setTimings(cour.getTimings());
         app.setSemester(cour.getSemester());
		 session.beginTransaction();
		 session.save(app);
		 session.getTransaction().commit();
		 data=true;
		 }
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}			
		return data;
	}

	public List<approval> approval_pending(String id) {
		List<approval>val=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="from approval where id=?";
		Query<approval>query=session.createQuery(HQL,approval.class);
		 query.setParameter(0,id);
		 val=query.list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}

	public void drop_course(String id, String stu_id) {
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="delete from approval where course_id=? and id=?";
		Query query=session.createQuery(HQL);
		 query.setParameter(0,id);
		 query.setParameter(1,stu_id);
		 query.executeUpdate();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<approval> getcourses(profile use) {
		List<approval>val=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String dept=use.getDepartment();
		String HQL="from approval where department=?";
		Query<approval>query=session.createQuery(HQL,approval.class);
		query.setParameter(0,dept);
	    val=query.list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}

	public void update_approval(String val,String id,String cou_id) {
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="update approval  set head=? where id=? and course_id=?";
		 Query query=session.createQuery(HQL);
		query.setParameter(0,val);
		query.setParameter(1,id);
		query.setParameter(2,cou_id);
	    query.executeUpdate();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<approval> get_approvals() {
		
		List<approval>val=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="from approval";
		Query<approval>query=session.createQuery(HQL,approval.class);
	    val=query.list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}

	public void add_registered(registered reg, String stu_id, String course_id) {
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		session.save(reg);
		String HQL="delete from approval where course_id=? and id=?";
		Query query=session.createQuery(HQL);
		 query.setParameter(0,course_id);
		 query.setParameter(1,stu_id);
		 query.executeUpdate();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<registered> getregistered(String id) {
		List<registered>reg=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="from registered where id=?";
		Query<registered> query=session.createQuery(HQL);
		 query.setParameter(0,id);
		 reg=query.list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return reg;
	}

	public List<profile> get_pro() {
		List<profile>reg=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="from profile where role LIKE '%PROFESSOR' ";
		Query<profile> query=session.createQuery(HQL);
		 reg=query.list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return reg;
	}

	public List<registered> get_details(String cour_id, String role, String name) {
		List<registered>val=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="from registered where course_id=? and staff_name=? and semester=? ";
		Query<registered> query=session.createQuery(HQL);
		query.setParameter(0,cour_id);
		query.setParameter(1,name);
		query.setParameter(2,role);
		 val=query.list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}

	public void add_grades(grades grs, String cou) {
		try(Session session=getSf().openSession())
		{
			session.beginTransaction();
			String HQL="from grades where course_id=? and id=?";
			Query<grades> query=session.createQuery(HQL);
			query.setParameter(0,cou);
			query.setParameter(1,grs.getId());
			grades obj=query.uniqueResult();
			if(obj==null)
			{
			session.save(grs);
			}
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<grades> get_grades(String cour_id, String role) {
		List<grades>val=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="from grades where course_id=? and semester=? ";
		Query<grades> query=session.createQuery(HQL);
		query.setParameter(0,cour_id);
		query.setParameter(1,role);
		 val=query.list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}

	public grades get_values(String stu_id, String course_id, String semester) {
		grades grs=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="from grades where course_id=? and semester=? and id=?";
		Query<grades> query=session.createQuery(HQL);
		query.setParameter(0,course_id);
		query.setParameter(1,semester);
		query.setParameter(2,stu_id);
		 grs=query.uniqueResult();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return grs;
	}

	public void update_grades(grades use) {
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="update grades set assignment=?,project=?, midterm=?,finals=?,final_grade=? where id=? and course_id=?";
		 Query query=session.createQuery(HQL);
		query.setParameter(0,use.getAssignment());
		query.setParameter(1,use.getProject());
		query.setParameter(2,use.getMidterm());
		query.setParameter(3,use.getFinals());
		query.setParameter(4,use.getFinal_grade());
		query.setParameter(5,use.getId());
		query.setParameter(6,use.getCourse_id());
	    query.executeUpdate();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public List<grades> get_gardes(String id) {
		List<grades>val=null;
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="from grades where id=?";
		Query<grades> query=session.createQuery(HQL);
		query.setParameter(0,id);
		 val=query.list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}

	public double getgpa(String id, String name) {
		 double total=0.00;
		 double total_gpa=0.00;
		List<String>data=new ArrayList<String>();
		List<Double>calculate=new ArrayList<Double>();
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="select course_id,final_grade from grades where id=?";
		Query<Object[]> query=session.createQuery(HQL);
		query.setParameter(0,id);
		List<Object[]>obj=query.list();
		
        // collecting each subject marks
		for(Object[] ob:obj)
        {
           data.add((String) ob[1]);
        }
        for(String value:data)
        {
        	switch(value)
        	{
        	case "A":
        		   calculate.add(4.00);
        		   break;
        	case "A-":
        		   calculate.add(3.70);
        		   break;
        	case "B+":
        		   calculate.add(3.30);
        	       break;
        	case "B":
        		   calculate.add(3.00);
        		   break;
        	case "B-":
        		    calculate.add(2.70);
        		    break;
        	case "C+":
        		    calculate.add(2.30);
        		    break;
        	case "C":
        		   calculate.add(2.0);
        		   break;
        	case "F":
        		    calculate.add(0.00);
        		    break;
        	default:
        	     	break;
        	}
        }
        // suming all the grades
        for(Double gra:calculate)
        {
        	total=total+gra;
        }
        // finally figuring out the average marks of gpa
        total_gpa=total / calculate.size();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return total_gpa;
	}
}
