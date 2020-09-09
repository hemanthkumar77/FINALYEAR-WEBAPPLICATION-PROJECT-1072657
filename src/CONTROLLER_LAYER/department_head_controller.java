package CONTROLLER_LAYER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Head")
public class department_head_controller {
	@GetMapping()
	@RequestMapping("/profile")
	public String profile()
	{
		return "Head_profile";
	}
}
