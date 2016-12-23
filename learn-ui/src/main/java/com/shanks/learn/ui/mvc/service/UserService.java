package com.shanks.learn.ui.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shanks.learn.ui.mvc.domain.User;

/**
 * call service via resTemplatet
 * @author shanks
 *
 */
@Service
public class UserService {

	@Value("${learn.api.user}")
	private String userApi;

	private final static String LIST_USER_URI = "/learn/user";

	private final static String FIND_USER_URI = "/learn/user/{id}";

	private final static String CREATE_USER_URI = "/learn/user";

	private final static String DELETE_USER_URI = "/learn/user/{id}";

	private final static String UPDATE_USER_URI = "/learn/user/{id}";

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

	public User create(User user) {
		return template.postForObject(userApi + CREATE_USER_URI, user, User.class);
	}

	public void delete(Integer id) {
		template.delete(userApi + DELETE_USER_URI, id);
	}

	public void update(Integer id, User user) {
		template.put(userApi + UPDATE_USER_URI, user, id);
	}
}
