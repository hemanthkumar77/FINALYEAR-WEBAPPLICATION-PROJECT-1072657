package CONTROLLER_LAYER;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ENTITES.profile;
import ENTITES.user;
import SERVICE_LAYER.Service_layer;

@Controller
@RequestMapping("/")
@SessionAttributes({"user"})
public class user_controller { 
	@Autowired
	private Service_layer SE;
	
	@InitBinder
	public void method(WebDataBinder bin)
	{
	   StringTrimmerEditor object=new StringTrimmerEditor(true);
	   bin.registerCustomEditor(String.class,object);	  
	}
	
	@RequestMapping("/")
	@GetMapping
	public String index()
	{
		return "user";
	}
	
	
	@RequestMapping("/register")
	@GetMapping
	public String registeration(Model mod)
	{ 
		mod.addAttribute("save",new user());
		return "register";
	}
	
	
	@RequestMapping("/savedata")
	@PostMapping
	public String save_data(@Valid @ModelAttribute("save") user use ,BindingResult res,Model mod)
	{
		if(res.hasErrors())
		{
			return "register";
		}
		else
		{
			if(SE.usersave(use)!=0)
			{
				return "user";
			}
			else
			{
				mod.addAttribute("message","username or university_id or email_id already exist");
				return "register";
			}
		}
	}
	
	@RequestMapping("/login")
	@GetMapping
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/validate")
	@PostMapping
	public String map(Model mod,HttpServletRequest request, HttpServletResponse response)
	{
		String username=request.getParameter("UN");
		System.out.println(username);
		String password=request.getParameter("PA");
		System.out.println(password);
		String role=request.getParameter("dropdown");
		System.out.println(role);
		profile user=SE.check(username,password,role);
		if(user!=null)
		{
		System.out.println(user.getRole());
		String roles=user.getRole();
		if(roles.equals("GRADUATE") || roles.equals("UNDER-GRADUATE"))
		{
			mod.addAttribute("user", user);
			return "redirect:/student/profile";
		}
		else if(roles.equals("SENIOR-PROFESSOR") || roles.equals("ASSISTANT-PROFESSOR"))
		{
			mod.addAttribute("user", user);
			return "redirect:/professor/profile";
		}
		else if(roles.equals("ADMIN"))
		{
			mod.addAttribute("user", user);
			return "redirect:/admin/profile";
		}
		else if(roles.equals("DEPARTMENT-HEAD"))
		{
			mod.addAttribute("user",user);
			return "redirect:/Head/profile";
		}
		}
	
			mod.addAttribute("users","invalid credentials");
			return "login";
	}
	
	@ModelAttribute
    public void details(Model mod)
    {
		List<String>dept=new ArrayList<String>();
		List<String>rol=new ArrayList<String>();
		List<String>gen=new ArrayList<String>();
		dept.add("CSC");
		dept.add("CS-HARDWARE");
		dept.add("ELECTRICAL");
		dept.add("MECHANICAL");
		dept.add("MBA");
		dept.add("BIOMEDICAL");
		dept.add("AUTOMOBILE");
		dept.add("FINANCE");
		rol.add("GRADUATE");
		rol.add("UNDER-GRADUATE");
		rol.add("SENIOR-PROFESSOR");
		rol.add("ASSISTANT-PROFESSOR");
		rol.add("ADMIN");
		rol.add("DEPARTMENT-HEAD");
		gen.add("MALE");
		gen.add("FEMALE");
		mod.addAttribute("department",dept);
		mod.addAttribute("role",rol);
		mod.addAttribute("gender",gen);
		
    }
	
}
