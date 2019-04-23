package com.joy.insapi.request.api.following;

import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.manager.IGCommonFieldsManager;
import com.joy.insapi.request.InsBaseGetRequest;
import com.joy.insapi.manager.utils.IGDeviceUtils;

import java.util.HashMap;
import java.util.Map;

public class GetFollowingRequest extends InsBaseGetRequest<FollowingResponseData> {

	private boolean isFirstPage;
	private String userId;
	private String nextMaxId;

	public GetFollowingRequest(boolean isFirstPage, String userId, String nextMaxId) {
		this.isFirstPage = isFirstPage;
		this.userId = userId;
		this.nextMaxId = nextMaxId;
	}


	@Override
	protected Map<String, String> getMapParams() {
		HashMap<String, String> paramsMap = new HashMap<>();
		paramsMap.put("rank_token", String.format("%s_%s", userId, IGDeviceUtils.getAndroidId(IGCommonFieldsManager.getInstance().getContext())));//rank_token本地拼接的userid_deviceID （
		paramsMap.put("ranked_content", "true");

		if(!isFirstPage){
			paramsMap.put("max_id", nextMaxId);
		}
		return paramsMap;
	}

	@Override
	protected String getActionUrl() {
		return String.format(IGConfig.ACTION_GET_FOLLOWING, userId);
	}
}
