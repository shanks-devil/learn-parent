package com.shanks.learn.user.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shanks.learn.user.mvc.domain.User;
import com.shanks.learn.user.mvc.repository.UserRepository;

@Service
public class UserService {

	@Resource
	private UserRepository userRepository;

	public void create(User user) {
		userRepository.create(user);
	}

	public void delete(Integer id) {
		userRepository.delete(id);
	}

	public void update(User user) {
		userRepository.update(user);
	}

	public List<User> listUser() {
		return userRepository.listUser();
	}

	public User findById(Integer id) {
		return userRepository.findById(id);
	}

}
