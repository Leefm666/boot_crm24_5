package c24.boot.core.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import c24.boot.core.po.Customer;
import c24.boot.core.po.User;
import c24.boot.core.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String usercode,String password,Model model,HttpSession session){
		User user=userService.findUser(usercode, password);
		if(user!=null){
			session.setAttribute("USER_SESSION", user);
			return "redirect:customer/list.action";
			
		}
		model.addAttribute("msg","账号或密码错误，请重新登录");
		return "login";
		
	}
	@RequestMapping(value="/toCustomer.action")
	public String toCustomer(){
		return "customer";
	}
	@RequestMapping(value="/logout.action")
	public String logout(HttpSession session){
		session.invalidate();
		
		return "redirect:login.action";		
	}
	@RequestMapping(value="/login.action",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	/*@RequestMapping(value="/syso.action")
	public String syso(){
		
		return "system"; 
	}*/
	@RequestMapping(value = "/syso.action")
	public String list(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage ,Model model){
		
		List<User> user=userService.selectUserList();
		
			System.out.println(user);
			model.addAttribute("userList", user);
			model.addAttribute("pagemsg", userService.findByPage(currentPage));
		return "system";		
	}
	@RequestMapping(value = "/user/delete.action")
	@ResponseBody
	public String deleteUser(Integer id){
		 int rows = userService.deleteUser(id);
		    if(rows > 0){			
		        return "OK";
		    }else{
		        return "FAIL";			
		    }		
	}
	
	@RequestMapping(value ="/user/getUserById.action")
	@ResponseBody
	public User getUserById(Integer id) {
	   User user = userService.getUserById(id);
	    return user;
	}
	
	@RequestMapping(value ="/user/update.action")
	@ResponseBody
	public String userUpdate(User user) {
	    int rows = userService.updateUser(user);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	@RequestMapping(value = "/reg.action")
	public String reg(){
		
		return "reg";
		
	}
	@RequestMapping(value = "/regdo.action",method=RequestMethod.POST)
	
	public String regdo(String usercode,String username,String password){
		int rows=userService.createUser(usercode,username,password);		
	  return "login";
	
		
		
	}
	
}
