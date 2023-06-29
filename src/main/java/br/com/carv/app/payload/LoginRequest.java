package br.com.carv.app.payload;

import java.io.Serial;
import java.io.Serializable;

public class LoginRequest implements Serializable{
	
	@Serial
	private static final long serialVersionUID = 0L;
	
	private String email; 
	private String password;
	
	public LoginRequest() {	}
	
	public LoginRequest(String email, String password) {
		this.email = email; 
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Email: " + email;
	}

}
