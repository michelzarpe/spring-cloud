package com.appsdeveloperblog.photoapp.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestModel{
	@NotNull(message = "First name cannot be null")
	@Size(min=2, message = "First name must not be less than two characters")
	private String firstName;
	@NotNull(message = "Last name cannot be null")
	@Size(min=2, message = "Last name must not be less than two characters")
	private String lastName;
	@NotNull(message = "Password name cannot be null")
	@Size(min=8,max=16, message = "Password name must be equal or grater than 8 characters and less than 16 characters")
	private String password;
	@NotNull(message = "Email name cannot be null")
	@Email(message ="Email not valid")
	private String email;
}
