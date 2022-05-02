package com.atos.af.api.service;

import java.util.Optional;

import com.atos.af.api.model.User;

public interface UserService {

	public Optional<User> getUser(final Long id);

	public User saveUser(User userDto);

}
