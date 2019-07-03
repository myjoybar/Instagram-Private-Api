package com.joy.insapi.request;

import android.util.Log;

import com.google.gson.internal.$Gson$Types;
import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.response.InsBaseResponseData;
import com.joy.insapi.response.InsGsonResponseHandler;
import com.joy.libok.OkHttpManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import okhttp3.Headers;

public abstract class InsBaseGetRequest<R extends InsBaseResponseData> extends InsBaseRequest<R> {
	protected static final String TAG = "InsBaseGetRequest";

	@Override
	void execute() {
		OkHttpManager.getInstance()
				.get(getRequestUrl())
				.addHeaders(IGConfig.getHeaders())
				.addParams(getMapParams())
				.tag(getTag())
				.execute(new InsGsonResponseHandler<R>(getType()) {

					@Override
					public void onFailure(int errorCode, String errorMsg) {
						super.onFailure(errorCode, errorMsg);
						Log.d(TAG, String.format("request %s success ,errorCode= %s , errorMsg = %s", getActionUrl(), errorCode,
								errorMsg));
						if (null != mInsRequestCallBack) {
							mInsRequestCallBack.onFailure(errorCode, errorMsg);
						}
					}



					@Override
					public void onSuccess(int statusCode, R insBaseData) {
						if (null != mInsRequestCallBack) {
							mInsRequestCallBack.onSuccess(statusCode, insBaseData);
						}
					}
				});
	}


	protected abstract Map<String, String> getMapParams();

	protected Type getType() {
		Class<?> classZ = getClass();
		Type type = classZ.getGenericSuperclass();
		if (type instanceof Class) {
			throw new RuntimeException("miss the type parameter");
		}
		ParameterizedType parameter = (ParameterizedType) type;
		return $Gson$Types.canonicalize(parameter.getActualTypeArguments()[0]);
	}


}
