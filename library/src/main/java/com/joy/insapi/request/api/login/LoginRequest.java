package com.joy.insapi.request.api.login;


import com.joy.insapi.manager.IGCommonFieldsManager;
import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.manager.utils.IGUtils;
import com.joy.insapi.request.InsBasePostRequest;

public class LoginRequest extends InsBasePostRequest<LoginPayload,LoginResponseData> {

	String userName;
	String pwd;

	public LoginRequest(String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
	}

	@Override
	protected String getActionUrl() {
		return IGConfig.ACTION_LOGIN;
	}

	@Override
	protected LoginPayload getRequestData() {
		String csrftoken = IGCommonFieldsManager.getInstance().getCsrftoken();
		LoginPayload loginPayload = new LoginPayload();
		loginPayload.set_csrftoken(csrftoken);
		loginPayload.setUsername(userName);
		loginPayload.setPassword(pwd);
		loginPayload.setGuid(IGUtils.generateUuid(true));
		loginPayload.setDevice_id(IGUtils.generateDeviceId(userName, pwd));
		loginPayload.setPhone_id(IGUtils.generateUuid(true));
		loginPayload.setLogin_attempt_account(0);

		return loginPayload;
	}
}
