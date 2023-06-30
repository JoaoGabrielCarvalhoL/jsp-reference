package br.com.carv.app.dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.carv.app.payload.LoginRequest;

public class LoginDAOTest {
	
	private LoginDAO dao = new LoginDAO();
	private LoginRequest valid = new LoginRequest("27.joaogabriel@gmail.com", "123");
	private LoginRequest invalid = new LoginRequest("27777.joaogabriel@gmail.com", "213");
	
	@Test
	public void should_validate_valid_email() throws SQLException {
		Boolean validEmail = this.dao.validateEmail(this.invalid);
		Assertions.assertTrue(validEmail);
	}
	
	@Test
	public void should_validate_invalid_email() throws SQLException {
		Boolean invalidEmail = this.dao.validateEmail(this.valid);
		Assertions.assertFalse(invalidEmail);
	}
	
	@Test
	public void should_authenticate_valid_login() throws SQLException {
		Boolean valid = this.dao.authenticate(this.valid);
		Assertions.assertTrue(valid);
	}
	
	@Test
	public void should_authenticate_invalid_login() throws SQLException {
		Boolean invalid = this.dao.authenticate(this.invalid);
		Assertions.assertFalse(invalid);
	}

}
