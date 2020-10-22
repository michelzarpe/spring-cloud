package com.appsdeveloperblog.photoapp.user;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

	public UserEntity findByEmail(String email);
	public UserEntity findByUserId(String userId);
}
