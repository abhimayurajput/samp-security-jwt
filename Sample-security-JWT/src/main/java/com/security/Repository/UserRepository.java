package com.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	public UserEntity findByUsername(String name);

}
