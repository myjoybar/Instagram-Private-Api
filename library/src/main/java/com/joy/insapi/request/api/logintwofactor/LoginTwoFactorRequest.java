package com.joy.insapi.request.api.logintwofactor;


import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.manager.utils.IGUtils;
import com.joy.insapi.request.InsBasePostRequest;
import com.joy.insapi.request.api.login.LoginResponseData;

public class LoginTwoFactorRequest extends InsBasePostRequest<LoginTwoFactorPayload, LoginResponseData> {

	String userName;
	String pwd;

	private String twoFactorIdentifier;
	private String verificationCode;

	public LoginTwoFactorRequest(String userName, String pwd, String twoFactorIdentifier, String verificationCode) {
		this.userName = userName;
		this.pwd = pwd;
		this.twoFactorIdentifier = twoFactorIdentifier;
		this.verificationCode = verificationCode;
	}

	@Override
	protected String getActionUrl() {
		return IGConfig.ACTION_LOGIN_TWO_FACTOR;
	}

	@Override
	protected LoginTwoFactorPayload getRequestData() {
		LoginTwoFactorPayload loginPayload = new LoginTwoFactorPayload();
		loginPayload.setUsername(userName);
		loginPayload.setPassword(pwd);
		loginPayload.setDevice_id(IGUtils.generateDeviceId(userName, pwd));
		loginPayload.setTwo_factor_identifier(twoFactorIdentifier);
		loginPayload.setVerification_code(verificationCode);

		return loginPayload;
	}
}
