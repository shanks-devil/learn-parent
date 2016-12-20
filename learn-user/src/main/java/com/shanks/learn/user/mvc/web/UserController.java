package com.shanks.learn.user.mvc.web;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shanks.learn.user.mvc.domain.User;
import com.shanks.learn.user.mvc.service.UserService;

@RestController
@RequestMapping("/learn")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ApiOperation(value = "创建用户")
	public void create(User user) {
		userService.create(user);
	}
	
	@ApiOperation(value = "删除用户")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		userService.delete(id);
	}
	
	@ApiOperation(value = "更新用户")
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public void update(User user) {
		userService.update(user);
	}
	
	@ApiOperation(value = "检索所有用户")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> listUser() {
		return userService.listUser();
	}
	
	@ApiOperation(value = "查询某个用户")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User user(@PathVariable Integer id) {
		return userService.findById(id);
	}
	
}
