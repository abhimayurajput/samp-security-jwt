package com.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.security.Repository.UserRepository;
import com.security.model.UserEntity;
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	 	@Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    	UserEntity userEntity = userRepository.findByUsername(username);

	        if (userEntity == null) {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }

	        return new User(((UserEntity) userEntity).getName(), userEntity.getPassword(), new ArrayList<>());
	    }

	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { // TODO Auto-generated method stub return new
	 * User("abhi","abhi",new ArrayList<>()); }
	 */
	

}
