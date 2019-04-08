package com.joy.insapi.request.followingcancel;

import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBasePostRequest;

public class FollowingCancelRequest extends InsBasePostRequest<FollowingCancelPayload, FollowingCancelResponseData> {

	private String userId;

	public FollowingCancelRequest(String userId, FollowingCancelPayload requestData) {
		super(requestData);
		this.userId = userId;
	}

	@Override
	protected String getActionUrl() {
		 return String.format(IGConfig.ACTION_GET_FOLLOWING_CANCEL, userId);
	}
}
