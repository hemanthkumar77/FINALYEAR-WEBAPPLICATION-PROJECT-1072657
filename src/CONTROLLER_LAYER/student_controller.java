package CONTROLLER_LAYER;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import ENTITES.*;
import ENTITES.user;
import SERVICE_LAYER.Service_layer;

@Controller
@RequestMapping("/student")
public class student_controller {
	@Autowired
	private Service_layer SE;
	@GetMapping()
	@RequestMapping("/profile")
	public String profile( @SessionAttribute("user") profile user,Model mod)
	{
		String name=user.getFirstname()+user.getLastname();
		mod.addAttribute("user",name);
		return "student_profile";
	}
	
	@GetMapping
	@RequestMapping("/update_profile")
	public String edit(@SessionAttribute("user") profile details,Model mod)
	{
		mod.addAttribute("save",details);
		return "update";
	}
	
	@PostMapping
	@RequestMapping("/update_pro")
	public String save(@ModelAttribute("save") profile use,Model mod, @SessionAttribute("user") profile user,BindingResult res)
	{	String name=user.getFirstname()+user.getLastname();
		mod.addAttribute("user",name);
		if(res.hasErrors())
		{
	      return "update";
		}
		SE.update_pro(use);
		return "student_profile";
	}
	
	@GetMapping
	@RequestMapping("/search")
	public String method()
	{
		return null;
	}
}
