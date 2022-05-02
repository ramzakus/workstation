package com.atos.af.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.atos.af.api.model.User;
import com.atos.af.api.repository.UserRepository;

public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	private User user1 = new User("SFSDFDSF", "1990-12-11", "France", "0656456787", "M");
	private User user2 = new User("ATUS45655", "1992-11-12", "Italie", "0744567893", "F");
	private User user3 = new User("ATUS45634", "1993-12-11", "Inde", "063478678934", "F");

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		user1.setId(1L);
		user2.setId(2L);
		user3.setId(3L);
	}

	@Test
	public void testGetUserById() {
		// given
		given(userRepository.findById(1L)).willReturn(Optional.of(user1));

		// calling method under the test
		Optional<User> result = userService.getUser(1L);

		// assert
		assertThat(result.isPresent()).isTrue();

		// assert
		assertuserFields(result.orElseGet(null));

		// verify that repository was called
		verify(userRepository, times(1)).findById(1L);
	}

	@Test
	public void testInsertUser() {
		// given
		given(userRepository.save(user1)).willReturn(user1);

		// calling method under the test
		User result = userService.saveUser(user1);

		// assert
		assertuserFields(result);

		// verify that repository was called
		verify(userRepository, times(1)).save(user1);
	}

	// verify that user 'user1' object have same fields
	private void assertuserFields(User user) {
		assertThat(user.getId()).isInstanceOf(Long.class);
		assertThat(user.getId()).isEqualTo(1);
		assertThat(user.getUserName()).isEqualTo("SFSDFDSF");
		assertThat(user.getPhoneNumber()).isEqualTo("0656456787");
	}

}
