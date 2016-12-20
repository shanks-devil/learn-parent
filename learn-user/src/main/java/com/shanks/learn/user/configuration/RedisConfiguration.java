package com.shanks.learn.user.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

@Configuration
public class RedisConfiguration {
	@Bean
	@ConfigurationProperties(prefix = "spring.cache.redis")
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager redisCacheManager = new RedisCacheManager(
				redisTemplate);
		return redisCacheManager;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.cache.redis")
	public RedisTemplate<String, String> redisTemplate(
			RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		ObjectMapper om = new ObjectMapper();
		om.enableDefaultTyping(DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.setKeySerializer(new StringRedisSerializer());
		return template;
	}
}
