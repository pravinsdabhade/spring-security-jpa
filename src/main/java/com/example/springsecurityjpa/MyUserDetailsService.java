package com.example.springsecurityjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurityjpa.entity.MyUserDetails;
import com.example.springsecurityjpa.entity.User;
import com.example.springsecurityjpa.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("User " + userName + " Not Found"));
		return user.map(MyUserDetails::new).get();
	}

}
