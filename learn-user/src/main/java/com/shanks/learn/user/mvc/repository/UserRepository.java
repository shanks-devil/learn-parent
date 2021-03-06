package com.shanks.learn.user.mvc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import com.shanks.learn.user.mvc.domain.User;

@Mapper
public interface UserRepository {

	@Caching(evict = @CacheEvict(cacheNames = "listUser", allEntries = true))
	void create(User user);

	@Caching(evict = { @CacheEvict(cacheNames = "listUser", allEntries = true),
			@CacheEvict(cacheNames = "user", key = "#p0 + ''") })
	void delete(Integer id);

	@Caching(evict = { @CacheEvict(cacheNames = "listUser", allEntries = true),
			@CacheEvict(cacheNames = "user", key = "#p0 + ''") })
	void update(@Param("id") Integer id, @Param("user") User user);

	@Cacheable(cacheNames = "listUser", key = "'listUser'")
	List<User> listUser();

	@Cacheable(cacheNames = "user", key = "#p0 + ''")
	User findById(Integer id);

}
