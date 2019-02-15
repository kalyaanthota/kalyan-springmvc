package com.usersmodule.controllers;
 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.todomodule.model.Todo;
import com.usersmodule.entities.user;
import com.usersmodule.services.UsersService;
 
@Controller
@RequestMapping("users")
public class UsersController {
 
    @Autowired
    UsersService userServices;
    
    
	@RequestMapping(value="/springcontent",
			method=RequestMethod.GET,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	user getUser() {
		String username = getLoggedInUserName();
		return userServices.loadwithname(username);
	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
 
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView getPage(ModelMap model) {
    	System.out.println("inusers.....");
    	model.addAttribute("users", userServices.list());
        ModelAndView view = new ModelAndView("users");
        return view;
    }
 

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model, @ModelAttribute("user") user user) {
		System.out.println("add-user.......");
		model.addAttribute("user", new user());
		return "Adduser";
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid user user, BindingResult result) {
System.out.println("saveOrUpdate....");
		if (result.hasErrors())
			return "users";
System.out.println(user);
		//user.setCreatetime(new Date().toString());
		userServices.saveOrUpdate(user);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:../users/page";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
System.out.println("update-user....");
		model.addAttribute("user", userServices.load(id));
System.out.println("user...."+model.get("user"));
		return "Adduser";
	}

	/*@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo,
			BindingResult result) {
		if (result.hasErrors())
			return "todo";

		todo.setUser(getLoggedInUserName());
		service.updateTodo(todo);

		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}*/

    
    @RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteUser(@RequestParam int id, user user, ModelMap model) {
    	 System.out.println("DELETE........"+id);
    	user.setUserid(id);
    	
    	userServices.delete(user);
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("status", "200");
        map.put("message", "Your record have been deleted successfully");
        model.addAttribute("status", "200");
        model.addAttribute("message", "Your record have been deleted successfully");
        
        
		return "redirect:../users/page";
	}

}