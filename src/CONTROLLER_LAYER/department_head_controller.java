package CONTROLLER_LAYER;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import ENTITES.approval;
import ENTITES.profile;
import SERVICE_LAYER.Service_layer;

@Controller
@RequestMapping("/Head")
public class department_head_controller {
	@Autowired
	private Service_layer SE;
	@GetMapping()
	@RequestMapping("/profile")
	public String profile( @SessionAttribute("user") profile use,Model mod)
	{
		String name=use.getFirstname()+use.getLastname();
		mod.addAttribute("user",name);
		return "Head_profile";
	}
	
	@GetMapping
	@RequestMapping("/approvals")
	public String courses( @SessionAttribute("user") profile use,Model mod)
	{
	   List<approval>cour=SE.getcourses(use);
	   mod.addAttribute("obj",cour);
	   return "head_approval";
	}
	@GetMapping
	@RequestMapping("/approval")
	public String add_approval( @SessionAttribute("user") profile use,Model mod,@RequestParam Map<String,String>map )
	{
		String val=map.get("approve");
		String id=map.get("id");
		String cou_id=map.get("cou_id");
		SE.update_Head_approval(val,id,cou_id);
		String name=use.getFirstname()+use.getLastname();
		mod.addAttribute("user",name);
		return "Head_profile";
	}
	
	@GetMapping
	@RequestMapping("/decline")
	public String add_decline( @SessionAttribute("user") profile use,Model mod,@RequestParam Map<String,String>map )
	{
		String val=map.get("decline");
		String id=map.get("id");
		String cou_id=map.get("cou_id");
		SE.update_Head_approval(val,id,cou_id);
		String name=use.getFirstname()+use.getLastname();
		mod.addAttribute("user",name);
		return "Head_profile";
	}
	
}
