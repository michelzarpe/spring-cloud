package com.appsdeveloperblog.photoapp.user;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseModel {

	
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private List<AlbumResponseModel> albums;
	
	
}
