package CONTROLLER_LAYER;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;


import ENTITES.grades;
import ENTITES.profile;
import ENTITES.registered;
import SERVICE_LAYER.Service_layer;

@Controller
@RequestMapping("/professor")
public class professor_controller {
	@Autowired
	private Service_layer SE;
	@GetMapping()
	@RequestMapping("/profile")
	public String profile(@SessionAttribute("user") profile use,Model mod)
	{
		String name=use.getFirstname()+use.getLastname();
		mod.addAttribute("user",name);
		return "professor_profile";
	}
	
	@GetMapping()
	@RequestMapping("/list")
	public String Details()
	{
		return "stu_list";
	}
	
	@PostMapping
	@RequestMapping("/search_student")
	public String retrive(@SessionAttribute("user") profile use,HttpServletRequest request, HttpServletResponse response,Model mod)
	{
		String cour_id=request.getParameter("CD");
		String role=request.getParameter("dropdown");
		String name=use.getLastname();
		List<registered> val=SE.retrived(cour_id,role,name);
		if(val==null)
		{
			mod.addAttribute("errors","no one registered or not authorized");
			return "stu_list";
		}
		else
		{
			mod.addAttribute("obj",val);
			return "list_stu";
		}
	}
	
	@RequestMapping("grade_pro")
	@GetMapping
	public String gardes_save(@SessionAttribute("user") profile use,Model mod,@RequestParam Map<String,String>map)
	{
		String name=use.getFirstname()+use.getLastname();
		mod.addAttribute("user",name);
		String stu_id=map.get("id");
		String stu_name=map.get("name");
		String dept=map.get("dept");
		String semester=map.get("semester");
		String cou=map.get("cou_id");
		grades grs=new grades();
		grs.setSemester(semester);
		grs.setId(stu_id);
		grs.setName(stu_name);
		grs.setDept(dept);
		grs.setCourse_id(cou);
		SE.add_grades(grs,cou);
		return "professor_profile"; 
	}
	
	@RequestMapping("/grades")
	@GetMapping()
	public String evaluations()
	{
		return "grad_eval";
	}
	
	@RequestMapping("/calculations")
	@PostMapping()
	public String students(@SessionAttribute("user") profile use,HttpServletRequest request, HttpServletResponse response,Model mod)
	{
		String cour_id=request.getParameter("CD");
		String role=request.getParameter("dropdown");
		List<grades> val=SE.get_gardes(cour_id,role);
		if(val==null)
		{
			mod.addAttribute("errors","no one registered or not authorized");
			return "stu_list";
		}
		else
		{
			mod.addAttribute("obj",val);
			return "stu_grades";
		}
	}
	@RequestMapping("/update")
	@GetMapping
	public String values(Model mod,@RequestParam Map<String,String>map)
	{
		String stu_id=map.get("id");
		String cou_id=map.get("cou_id");
		String semester=map.get("semester");
		grades grs=SE.get_values(stu_id, cou_id, semester);
		List<String>gra=new ArrayList();
		gra.add("A");
		gra.add("A-");
		gra.add("B+");
		gra.add("B");
		gra.add("B-");
		gra.add("C+");
		gra.add("C");
		gra.add("F");
		gra.add("NG");
		mod.addAttribute("gra", gra);
	    mod.addAttribute("obj",grs);
	    return "grade_form";
	}
	@RequestMapping("/update_stugrades")
	@PostMapping
	public String saved(@ModelAttribute("obj") grades gree) 
	{
		SE.update_grades(gree);
		return "redirect:/professor/profile";
	}
}
