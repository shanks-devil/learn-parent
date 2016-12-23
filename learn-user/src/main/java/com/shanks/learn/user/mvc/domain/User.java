package com.shanks.learn.user.mvc.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class User {

	private Integer id;

	@NotEmpty
	@Length(min = 6, max = 10)
	private String name;

	@Email
	private String mail;

}
