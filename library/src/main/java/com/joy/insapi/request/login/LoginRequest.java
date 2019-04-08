package com.joy.insapi.request.login;


import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBasePostRequest;

public class LoginRequest extends InsBasePostRequest<LoginPayload,LoginResponseData> {


	public LoginRequest(LoginPayload requestData) {
		super(requestData);
	}

	@Override
	protected String getActionUrl() {
		return IGConfig.ACTION_LOGIN;
	}
}
