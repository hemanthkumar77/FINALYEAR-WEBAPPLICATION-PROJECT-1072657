package SERVICE_LAYER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DATA_LAYER.Data;
import ENTITES.courses;
import ENTITES.profile;
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



	

}
