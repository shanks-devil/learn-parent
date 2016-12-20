package com.shanks.learn.ui.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shanks.learn.ui.mvc.domain.User;

@Service
public class UserService {

	@Value("${learn.api.user}")
	private String userApi;

	private final static String LIST_USER_URI = "/learn/user";

	private final static String FIND_USER_URI = "/learn/user/{id}";

	@Resource
	private RestTemplate template;

	public List<User> listUser() {
		return template.exchange(userApi + LIST_USER_URI,
				HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				}).getBody();
	}

	public User findById(Integer id) {
		return template.getForObject(userApi + FIND_USER_URI, User.class, id);
	}

}
