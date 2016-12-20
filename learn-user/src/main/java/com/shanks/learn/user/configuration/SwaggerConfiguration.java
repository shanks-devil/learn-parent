package com.shanks.learn.user.configuration;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import com.google.common.base.Predicates;

@Configuration
public class SwaggerConfiguration {

	@Resource
	private Environment env;

	@Bean
	public Docket userDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("User")
				.apiInfo(apiInfo()).select()
				.paths(PathSelectors.regex("/learn/.*")).build();
	}

	@Bean
	public Docket systemDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("System")
				.apiInfo(apiInfo()).select()
				.paths(Predicates.not(PathSelectors.regex("/learn/.*")))
				.build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact(env.getProperty("application.api.contact.name"),
				env.getProperty("application.api.contact.url"),
				env.getProperty("application.api.contact.email"));
		return new ApiInfoBuilder()
				.description(env.getProperty("${application.api.desc}"))
				.license(env.getProperty("application.api.license.name"))
				.licenseUrl(env.getProperty("application.api.license.url"))
				.title(env.getProperty("application.api.title"))
				.version(env.getProperty("application.api.version"))
				.contact(contact).build();
	}
}
