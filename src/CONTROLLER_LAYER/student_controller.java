package CONTROLLER_LAYER;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import ENTITES.*;
import SERVICE_LAYER.Service_layer;

@Controller
@RequestMapping("/student")
public class student_controller {
	@Autowired
	private Service_layer SE;
	@GetMapping()
	@RequestMapping("/profile")
	public String profile( @SessionAttribute("user") profile use,Model mod)
	{
		String name=use.getFirstname()+use.getLastname();
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
	public String save(@ModelAttribute("save") profile use,Model mod, @SessionAttribute("user") profile obj,BindingResult res)
	{	String name=obj.getFirstname()+obj.getLastname();
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
	public String method(Model mod)
	{
		List<courses>object=SE.getdetails();
		mod.addAttribute("obj",object);
		return "student_course";
	}
	
	@GetMapping
	@RequestMapping("/add_course")
	public String approval(@RequestParam("set_id") String id,@SessionAttribute("user") profile obj,Model mod)
	{
	   boolean val=SE.add_approval(id,obj);
	   if(val==false)
	   {
		  mod.addAttribute("invalid","already you registered for the course");
		  return "student_course";
	   }
		String name=obj.getFirstname()+obj.getLastname();
		mod.addAttribute("user", name);
		return "student_profile";
	}
	
	@GetMapping
	@RequestMapping("/drop_course")
	public String drop(@RequestParam("del_id") String id,@RequestParam ("stu_id") String stu_id,@SessionAttribute("user") profile obj,Model mod)
	{
	    SE.drop_course(id,stu_id);
		String name=obj.getFirstname()+obj.getLastname();
		mod.addAttribute("user", name);
		return "student_profile";
	}
	
	
	@GetMapping
	@RequestMapping("/pending_approval")
	public String retirve_val(Model mod,@SessionAttribute("user") profile use)
	{
	  String id=use.getId();
	  List<approval>object=SE.getval(id);
	  mod.addAttribute("obj", object);
	  return "approval_pending";
	}
	
	@GetMapping
	@RequestMapping("/register")
	public String getall(Model mod,@SessionAttribute("user") profile obj)
	{
	  String name=obj.getFirstname()+obj.getLastname();
      mod.addAttribute("user", name);
      List<registered>reg=SE.getregistered(obj.getId());
      mod.addAttribute("obj",reg);
      return "registered";
      
	}
}
