package DATA_LAYER;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

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
		try(Session session=getSf().openSession())
		{
		 profile pro=use.getPro();
		 // child refernce
		 use.setPro(pro);
		 // parent refernce 
		 pro.setObj(use);
		session.beginTransaction();
	    session.save(use);
		session.save(pro);
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	     return 1;   
	}

	public profile get(String username, String password, String role) {
		profile object=null;
		try(Session session=getSf().openSession())
		{
			session.beginTransaction();
	        String HQL="select a.id,a.firstname from user e inner join e.pro a where e.username=? and e.password=? and a.role=?";
	        Query<Object[]> query=session.createQuery(HQL);
	        query.setParameter(0,username);
	        query.setParameter(1,password);
	        query.setParameter(2,role);
	        List<Object[]>list=query.list();
	        if(list!=null)
	        {
			for(Object[] obj:list)
			{
				String id=(String) obj[0];
				String firstname=(String) obj[1];
				System.out.print(id);
				System.out.println(firstname);
				profile objc=new profile();
				objc.setId(id);
				objc.setFirstname(firstname);
				objc.setRole(role);
				object=objc;
			}
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

}
