package com.joy.insapi.request.userinfo;


import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBaseGetRequest;
import com.joy.insapi.request.InsBaseResponseData;

import java.util.Map;

public class UserInfoRequest extends InsBaseGetRequest<InsBaseResponseData> {

	private String userId;

	public UserInfoRequest(String userId) {
		this.userId = userId;
	}

	@Override
	protected Map<String, String> getMapParams() {
		return null;
	}

	@Override
	protected String getActionUrl() {
		 return String.format(IGConfig.ACTION_GET_USER_INFO, userId);
	}
}
