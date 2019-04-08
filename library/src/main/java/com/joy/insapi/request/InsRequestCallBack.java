package com.joy.insapi.request;

public interface InsRequestCallBack<R extends InsBaseResponseData> {

	void onSuccess(int statusCode, R insBaseData);
	 void onFailure(int errorCode, String errorMsg) ;
}
