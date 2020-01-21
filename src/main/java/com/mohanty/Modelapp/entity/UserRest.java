package com.mohanty.Modelapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_rest_data")
public class UserRest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "first_name")
	@NotNull(message = "first name cannot be null")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "last name cannot be null")
	private String lastName;

	@Column(name = "user_email")
	@NotNull(message = "user email cannot be null")
	@Email
	private String userEmail;

	@Column(name = "user_password")
	@NotNull(message = "password cannot be null")
	@Size(min = 3, max = 8, message = "Password has to be minimum of 3 to maximum of 8 charecters")
	private String password;

	public UserRest() {
	}

	public UserRest(String firstName, String lastName, String userEmail, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
