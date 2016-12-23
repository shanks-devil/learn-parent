package com.shanks.learn.ui.mvc.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

import com.github.blackshadowwalker.spring.retrofit.RetrofitService;
import com.shanks.learn.ui.mvc.domain.User;

/**
 * call service via Retrofit
 * @author shanks
 *
 */
@RetrofitService(retrofit = "userRetrofit")
public interface UserServiceRetrofit {
	
	@GET(value = "/learn/user")
	Call<List<User>> listUser();
	
	@GET(value = "/learn/user/{id}")
	Call<User> findById(@Path("id") Integer id);

	@DELETE(value = "/learn/user/{id}")
	Call<Void> delete(@Path("id") Integer id);

	@POST(value = "/learn/user")
	Call<Void> create(@Body User user);
}
