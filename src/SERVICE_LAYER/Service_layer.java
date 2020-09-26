package SERVICE_LAYER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DATA_LAYER.Data;
import ENTITES.approval;
import ENTITES.courses;
import ENTITES.grades;
import ENTITES.profile;
import ENTITES.registered;
import ENTITES.user;

@Service
public class Service_layer {
    @Autowired
	private Data da;
    
	public int usersave(user use) {
		return da.save_value(use);
	}

	public profile check(String username, String password, String role) {
		
		return da.get(username,password,role);
	}

	public void update_pro(profile use) {
		da.save(use);
	}

	public boolean insert_course(courses cou) {
		
		return da.course_insert(cou);
	}

	public List<courses> getdetails() {
		return da.getdetails_course();
	}

	public courses getcourse_id(String id) {
		
		return da.course_id(id);
	}

	public void update_course(courses cour) {
	  da.update_course(cour);	
	}

	public void delete_id(String id) {
		da.delete(id);
	}

	public boolean add_approval(String id, profile obj) {
	return da.approval_table(id,obj);
	}

	public List<approval> getval(String id) {

		return da.approval_pending(id);
	}

	public void drop_course(String id,String stu_id) {
		da.drop_course(id,stu_id);
	}

	public List<approval> getcourses(profile use) {
		
		return da.getcourses(use);
	}

	public void update_Head_approval(String val,String id,String cou_id) {
		da.update_approval(val,id,cou_id);
	}

	public List<approval> get_approvals() {
		return da.get_approvals();
	}

	public void add_registered(registered reg, String stu_id,String course_id) {
		 da.add_registered(reg,stu_id,course_id);
	}

	public List<registered> getregistered(String id) {
		return da.getregistered(id);
	}

	public List<profile> get_pro() {
		
		return da.get_pro();
	}

	public List<registered> retrived(String cour_id, String role, String name) {
		return da.get_details(cour_id,role,name);
	}

	public void add_grades(grades grs, String cou) {
		da.add_grades(grs,cou);
	}

	public List<grades> get_gardes(String cour_id, String role) {
		
		return da.get_grades(cour_id,role);
	}

	public grades get_values(String stu_id, String course_id, String semester) {
	
		return da.get_values(stu_id,course_id,semester);
	}

	public void update_grades(grades use) {
		da.update_grades(use);
	}

	public List<grades> get_gardes(String id) {
		
		return da.get_gardes(id);
	}



	

}
