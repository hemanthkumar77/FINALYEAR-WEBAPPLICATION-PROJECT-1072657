package CONTROLLER_LAYER;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import ENTITES.approval;
import ENTITES.courses;
import ENTITES.profile;
import ENTITES.registered;
import SERVICE_LAYER.Service_layer;

@Controller
@RequestMapping("/admin")
public class admin_controller {
    @Autowired
	private Service_layer SE;
	@GetMapping()
	@RequestMapping("/profile")
	public String profile( @SessionAttribute("user") profile user,Model mod)
	{
		String name=user.getFirstname()+user.getLastname();
		mod.addAttribute("user",name);
		return "admin_profile";
	}
	
	@GetMapping()
	@RequestMapping("/add_course")
	public String add(Model mod)
	{
		mod.addAttribute("details",new courses());
		return "courses";
	}
	
	@PostMapping
	@RequestMapping("/data_capture")
	public String add(@Valid @ModelAttribute("details") courses cou,BindingResult res,Model mod,@SessionAttribute ("user") profile user)
	{
		String name=user.getFirstname()+user.getLastname();
		mod.addAttribute("user",name);
		if(res.hasErrors())
		{
			return "courses";
		}
		boolean val=SE.insert_course(cou);
		if(val==true)
		{
			return "admin_profile";
		}
		else
		{
			mod.addAttribute("val","course already exist");
			return "courses";
		}
	}
	
	@GetMapping
	@RequestMapping("/course")
	public String list_users(Model mod)
	{
	  List<courses>object=SE.getdetails();
	  mod.addAttribute("obj",object);
		return "course_info";
	}
	
	@RequestMapping(value="/update_val",method=RequestMethod.GET)
	public String update_val(@RequestParam("set_id") String id,Model mod)
	{
		courses object=SE.getcourse_id(id);
		mod.addAttribute("object",object);
		return "edit";
	}
	
	@RequestMapping("/data_update")
	@GetMapping
	public String update_method(@ModelAttribute("object")courses cour,BindingResult res)
	{
		if(res.hasErrors())
		{
			return "edit";
		}
		SE.update_course(cour);
		return "redirect:/admin/course";
	}
	
	@RequestMapping(value="/delete_val",method=RequestMethod.GET)
	public String delete_method(@RequestParam("del_id") String id)
	{
	    SE.delete_id(id);
		return "redirect:/admin/course";
	}
	
	@RequestMapping(value="/confirmation",method=RequestMethod.GET)
	public String confirmations(@SessionAttribute("user") profile user,Model mod)
	{
		String name=user.getFirstname()+user.getLastname();
	   List<approval>app=SE.get_approvals();
	    mod.addAttribute("obj",app);
		return "final_approval";
	}
	
	@GetMapping
	@RequestMapping("/add")
	public String insert(@RequestParam Map<String,String>map)
	{
		String stu_id=map.get("id");
		String stu_name=map.get("name");
		String dept=map.get("dept");
		String course_id=map.get("cou_id");
		String course_name=map.get("cou_name");
		String staff=map.get("staff");
		int credits=Integer.valueOf(map.get("cred"));
		String semester=map.get("sem");
		registered reg=new registered(stu_id,stu_name,dept,course_id,course_name,staff,credits,semester);
		SE.add_registered(reg,stu_id,course_id);
		return "redirect:/admin/profile";
	}
	
	@DeleteMapping
	@RequestMapping("/dropped")
	public String delete_app(@RequestParam Map<String,String>map)
	{
		String stu_id=map.get("id");
		String course_id=map.get("cou_id");
		SE.drop_course(course_id,stu_id);
		return "redirect:/admin/profile";
	}
	
	@GetMapping
	@RequestMapping("/pro_details")
	public String pro_details(Model mod)
	{
		List<profile>use=SE.get_pro();
		mod.addAttribute("obj",use);
		return "prof_records";
	}
	
	@ModelAttribute
	public void values(Model mod)
	{
		List<String>role=new ArrayList<String>();
		List<String>sem=new ArrayList<String>();
		role.add("mon");
		role.add("tue");
		role.add("wed");
		role.add("thu");
		role.add("fri");
		sem.add("fall");
		sem.add("spring");
		sem.add("summer");
		mod.addAttribute("role",role);
		mod.addAttribute("sem",sem);
		
	}
	
}
