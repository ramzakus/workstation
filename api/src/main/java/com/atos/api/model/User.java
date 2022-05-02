package com.atos.af.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", message = "User name day is invalid")
	@Size(min = 8, message = "User Registration userName should have at least 8 characters")
	@NotNull
	@Column(name = "user_name")
	private String userName;

	@NotNull
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birth day is invalid")
	@Column(name = "birth_day")
	private String birthDay;

	@NotNull
	@Pattern(regexp = "^(France)", message = "French residents are allowed to create an account")
	@Column(name = "country_of_residence")
	private String countryOfResidence;

	@Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = "Phone number is invalid")
	@Column(name = "phone_number")
	private String phoneNumber;

	@Pattern(regexp = "^(M|F)", message = "Gender should be M or F")
	@Column(name = "gender")
	private String gender;

	public User(
			@Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", message = "User name day is invalid") @Size(min = 8, message = "User Registration userName should have at least 8 characters") @NotNull String userName,
			@NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birth day is invalid") String birthDay,
			@NotNull @Pattern(regexp = "^(France)", message = "French residents are allowed to create an account") String countryOfResidence,
			@Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = "Phone number is invalid") String phoneNumber,
			@Pattern(regexp = "^(M|F)", message = "Gender should be M or F") String gender) {
		super();
		this.userName = userName;
		this.birthDay = birthDay;
		this.countryOfResidence = countryOfResidence;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public User() {
	}

}
