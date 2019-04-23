package com.joy.insapi.request.api.mediacomments;


import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBaseGetRequest;

import java.util.Map;

public class GetMediaCommentsRequest  extends InsBaseGetRequest<MediaCommentResponseData> {

	private String itemID;

	public GetMediaCommentsRequest(String itemID) {
		this.itemID = itemID;
	}


	@Override
	protected Map<String, String> getMapParams() {
		return null;
	}

	@Override
	protected String getActionUrl() {
		return String.format(IGConfig.ACTION_GET_MEDIA_COMMENTS, itemID);
	}
}
