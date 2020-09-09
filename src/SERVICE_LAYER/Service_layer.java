package SERVICE_LAYER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DATA_LAYER.Data;
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

}
