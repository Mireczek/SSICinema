package com.ssi.cinema.controler;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.cinema.backend.data.entity.User;
import com.ssi.cinema.backend.service.UserService;

@Controller
public class UserManagementController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/userRegisterProcess", method = RequestMethod.POST)
	public ModelAndView handleUserRegister(HttpServletRequest request, @ModelAttribute("user") User user) {
		
		ModelAndView model = new ModelAndView();
		try {
			userService.save(user);
			model.addObject("message", "User succesfully created/updated");
			
		}
		catch (Exception e) {
			model.addObject("message", "Problems with creating user!");
		}
		
		request.setAttribute("content", "manageUsers");
		model.addObject("selectedUser", null);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/manageUsers", method = RequestMethod.GET)
	public ModelAndView showUserManagement(HttpServletRequest request) {
		request.setAttribute("content", "manageUsers");
		String selected = request.getParameter("item");
		ModelAndView model = new ModelAndView();
		Map<String, User> usersMap = getUserNameUserMap();
		if (!StringUtils.isEmpty(selected)) {
			model.addObject("selectedUser", usersMap.get(selected));
		}
		model.addObject("usersList", usersMap.keySet());
		model.addObject("user", new User());
		model.setViewName("index");
		return model;
	}
	
	private Map<String, User> getUserNameUserMap() {
		Iterable<User> users = userService.findAll();
		Map<String, User> map = new TreeMap<>();
		for (User user : users) {
			map.put(user.getName(), user);
		}
		return map;
	}
}
