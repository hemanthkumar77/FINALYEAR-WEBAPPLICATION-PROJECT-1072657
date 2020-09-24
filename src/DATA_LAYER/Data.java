package DATA_LAYER;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import ENTITES.approval;
import ENTITES.courses;
import ENTITES.profile;
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

	public void drop_course(String id) {
		try(Session session=getSf().openSession())
		{
		session.beginTransaction();
		String HQL="delete from approval where course_id=?";
		Query query=session.createQuery(HQL);
		 query.setParameter(0,id);
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
}
