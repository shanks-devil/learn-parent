package com.shanks.learn.user.mvc.web;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.shanks.learn.user.mvc.domain.User;
import com.shanks.learn.user.mvc.service.UserService;

@RestController
@RequestMapping("/learn")
public class UserController {
	
	@Resource
	private UserService userService;

	@ApiOperation(value = "创建用户")
	@PostMapping(value = "/user")
	public User create(@Validated @RequestBody User user) {
		return userService.create(user);
	}
	
	@ApiOperation(value = "删除用户")
	@DeleteMapping(value = "/user/{id}")
	public void delete(@PathVariable Integer id) {
		userService.delete(id);
	}
	
	@ApiOperation(value = "更新用户")
	@PutMapping(value = "/user/{id}")
	public void update(@PathVariable Integer id, @Validated @RequestBody User user) {
		userService.update(id, user);
	}
	
	@ApiOperation(value = "检索所有用户")
	@GetMapping(value = "/user")
	public List<User> listUser() {
		return userService.listUser();
	}
	
	@ApiOperation(value = "查询某个用户")
	@GetMapping(value = "/user/{id}")
	public User user(@PathVariable Integer id) {
		return userService.findById(id);
	}
	
}
