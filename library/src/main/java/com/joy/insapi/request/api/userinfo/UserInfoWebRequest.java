package com.joy.insapi.request.api.userinfo;

import com.joy.libok.OkHttpManager;
import com.joy.libok.response.responsehandler.StringResponseHandler;

public class UserInfoWebRequest {
	private static final String url = "https://www.instagram.com/";
	public void execute(String userName) {
		String requestUrl = url + userName;
		OkHttpManager.getInstance().get(requestUrl).execute(new StringResponseHandler() {

			@Override
			public void onSuccess(int statusCode, String response) {
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				super.onFailure(errorCode, errorMsg);
			}
		});
	}


}