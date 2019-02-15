package com.addressmodule.controllers;
 
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

import com.addressmodule.entities.useraddress;
import com.addressmodule.services.AddressService;
import com.todomodule.model.Todo;
import com.usersmodule.entities.user;
import com.usersmodule.services.UsersService;
 
@Controller
@RequestMapping("useraddress")
public class UserAddressController {
 
    @Autowired
    AddressService addressServices;
    @Autowired
    UsersService userServices;
    
/*	@RequestMapping(value="/springcontent",
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
	}*/
 
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView getPage(ModelMap model, @RequestParam int addrid) {
    	System.out.println("inuseraddress.....");
    	model.addAttribute("user", userServices.load(addrid));
    	model.addAttribute("useraddress", addressServices.load(addrid));
        ModelAndView view = new ModelAndView("useraddress");
        return view;
    }
 

	@RequestMapping(value = "/add-useraddress", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model, @RequestParam int userid, @ModelAttribute("useraddress") useraddress useraddress) {
		System.out.println("add-useraddress......userid."+userid);
		useraddress Uaddr = new useraddress();
		Uaddr.setUserid(userid);
		model.addAttribute("useraddress", Uaddr);
		return "Adduseraddress";
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid useraddress useraddress, BindingResult result) {
System.out.println("saveOrUpdate....");
		if (result.hasErrors())
			return "users";
		int id = useraddress.getUserid();
		addressServices.saveOrUpdate(useraddress);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:../useraddress/page?addrid="+id;
	}

	@RequestMapping(value = "/update-useraddress", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int addrid) {
System.out.println("update-useraddress...."+addrid);
		model.addAttribute("useraddress", addressServices.loadAddress(addrid));

		return "Adduseraddress";
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

    
    @RequestMapping(value = "/delete-useraddress", method = RequestMethod.GET)
	public String deleteUserAddress(@RequestParam int addrid, int userid, useraddress useraddress, ModelMap model) {
    	 System.out.println("DELETE........"+addrid);
    	 useraddress.setAddrid(addrid);
    	 addressServices.delete(useraddress);
    	 
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("status", "200");
        map.put("message", "Your record have been deleted successfully");
        model.addAttribute("status", "200");
        model.addAttribute("message", "Your record have been deleted successfully");
        
        
		return "redirect:../useraddress/page?addrid="+ String.valueOf(userid);
	}

}