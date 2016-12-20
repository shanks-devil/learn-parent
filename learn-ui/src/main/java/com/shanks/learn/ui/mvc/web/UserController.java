package com.shanks.learn.ui.mvc.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shanks.learn.ui.mvc.domain.User;
import com.shanks.learn.ui.mvc.service.UserService;

@Controller
@RequestMapping("/ui")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public List<User> listUser() throws IOException {
		return userService.listUser();
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User user(@PathVariable Integer id) throws IOException {
		return userService.findById(id);
	}
	
}
