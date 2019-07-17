package br.com.bg.stok.payload;

import br.com.bg.stok.orm.model.User;

public class JwtAuthenticationResponse {
	
	private String username;
	private String password;
	private String token;

	public JwtAuthenticationResponse(String accessToken, User user) {
		this.token = "Bearer " + accessToken;
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}