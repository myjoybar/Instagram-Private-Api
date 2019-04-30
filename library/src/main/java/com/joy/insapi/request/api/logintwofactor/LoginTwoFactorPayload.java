package com.joy.insapi.request.api.logintwofactor;

public class LoginTwoFactorPayload {

	private String device_id;
	private String two_factor_identifier;
	private String verification_code;
	private String username;
	private String password;

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getTwo_factor_identifier() {
		return two_factor_identifier;
	}

	public void setTwo_factor_identifier(String two_factor_identifier) {
		this.two_factor_identifier = two_factor_identifier;
	}

	public String getVerification_code() {
		return verification_code;
	}

	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
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
}
