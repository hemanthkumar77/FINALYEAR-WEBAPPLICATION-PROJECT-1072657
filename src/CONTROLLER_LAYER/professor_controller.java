package CONTROLLER_LAYER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professor")
public class professor_controller {
	@GetMapping()
	@RequestMapping("/profile")
	public String profile()
	{
		return "professor_profile";
	}
}
