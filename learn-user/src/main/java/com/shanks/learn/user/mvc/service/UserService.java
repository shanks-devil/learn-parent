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

	public User create(User user) {
		userRepository.create(user);
		return user;
	}

	public void delete(Integer id) {
		userRepository.delete(id);
	}

	public void update(Integer id, User user) {
		userRepository.update(id, user);
	}

	public List<User> listUser() {
		return userRepository.listUser();
	}

	public User findById(Integer id) {
		return userRepository.findById(id);
	}

}
