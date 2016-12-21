package com.shanks.learn.ui.configuration;

import java.io.IOException;
import java.net.URI;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

import com.github.blackshadowwalker.spring.retrofit.RetrofitServiceScannerConfigurer;

@Configuration
public class Retrofit2Configuration {

	@Bean
	public RetrofitServiceScannerConfigurer config() {
		RetrofitServiceScannerConfigurer configurer = new RetrofitServiceScannerConfigurer();
		configurer.setBasePackage("com.shanks.learn.ui.mvc.service");
		configurer.setRetrofit("");
		return configurer;
	}

	@Bean
	public Retrofit userRetrofit(OkHttpClient okHttpClient, Environment env,
			LoadBalancerClient loadBalancerClient) {
		return new Retrofit.Builder()
				.baseUrl(env.getProperty("learn.api.user"))
				.addConverterFactory(FastJsonConverterFactory.create())
				.client(okHttpClient(loadBalancerClient)).build();
	}

	@Bean
	public OkHttpClient okHttpClient(LoadBalancerClient loadBalancerClient) {
		return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				ServiceInstance serviceInstance = loadBalancerClient
						.choose(chain.request().url().host());
				URI original = URI
						.create(chain.request().url().uri().getPath());
				URI uri = loadBalancerClient.reconstructURI(serviceInstance,
						original);
				Request request = chain.request().newBuilder().url(HttpUrl.get(uri)).build();
				return chain.proceed(request);
			}
		}).build();
	}
}
