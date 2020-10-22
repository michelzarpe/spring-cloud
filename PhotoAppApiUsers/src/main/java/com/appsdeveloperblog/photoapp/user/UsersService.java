package com.appsdeveloperblog.photoapp.user;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService{
	public UserDto createUser(UserDto userDetails);
	public UserDto getUserDetailsByEmail(String email);
	public UserDto getUserByUserId(String userId);
}
