package com.atos.af.api.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atos.af.api.exception.UserNotAdultException;
import com.atos.af.api.exception.UserNotFoundException;
import com.atos.af.api.model.User;
import com.atos.af.api.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/register")
public class UserController {

    static String URI = "https://localhost:9000/api/register/user/";

	@Autowired
	private UserServiceImpl userService;

	/**
	 * Create - Add a new user
	 * 
	 * @param employee
	 *            An object user
	 * @return The user object saved
	 */
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		if (user.getBirthDay() != null && getAgeFromBithDay(user.getBirthDay()) < 18) {
			throw new UserNotAdultException("User should not have less than 18");
		}
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}

	/**
	 * Read - Get one user
	 * 
	 * @param id
	 *            The id of the user
	 * @return An User object full filled
	 */
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") final Long id) {
		Optional<User> user = userService.getUser(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException("Invalid user id : " + id);
		}
	}

	/**
	 * Get age from birthDay
	 * 
	 * @param birthDayPerson
	 * @return age
	 */
	private int getAgeFromBithDay(String birthDayPerson) {
		LocalDate today = LocalDate.now();
		LocalDate birthDay = LocalDate.parse(birthDayPerson);
		Period p = Period.between(birthDay, today);
		return p.getYears();
	}
}
