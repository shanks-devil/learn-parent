package com.shanks.learn.ui.mvc.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import com.github.blackshadowwalker.spring.retrofit.RetrofitService;
import com.shanks.learn.ui.mvc.domain.User;

@RetrofitService(retrofit = "userRetrofit")
public interface UserServiceRetrofit {
	
	@GET(value = "/learn/user")
	Call<List<User>> listUser();
	
	@GET(value = "/learn/user/{id}")
	Call<User> findById(@Path("id") Integer id);
	
}
