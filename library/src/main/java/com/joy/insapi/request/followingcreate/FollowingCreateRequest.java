package com.joy.insapi.request.followingcreate;

import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBasePostRequest;
public class FollowingCreateRequest extends InsBasePostRequest<FollowingCreatePayload, FollowingCreateResponseData> {

	private String userId;

	public FollowingCreateRequest(String userId,FollowingCreatePayload requestData) {
		super(requestData);
		this.userId = userId;
	}

	@Override
	protected String getActionUrl() {
		 return String.format(IGConfig.ACTION_GET_FOLLOWING_CREATE, userId);
	}
}
