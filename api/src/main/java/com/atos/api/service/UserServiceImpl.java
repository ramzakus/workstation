package com.atos.af.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.af.api.model.User;
import com.atos.af.api.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public Optional<User> getUser(final Long id) {
		return userRepository.findById(id);
	}

	public User saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
}
