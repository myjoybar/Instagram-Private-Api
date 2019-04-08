package com.joy.insapi.request.medialikers;


import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBaseGetRequest;

import java.util.Map;

public class GetMediaLikersRequest extends InsBaseGetRequest<MediaLikersResponseData> {

	private String itemID;

	public GetMediaLikersRequest(String itemID) {
		this.itemID = itemID;
	}

	@Override
	protected Map<String, String> getMapParams() {
		return null;
	}

	@Override
	protected String getActionUrl() {
		return String.format(IGConfig.ACTION_GET_MEDIA_LIKERS, itemID);
	}
}
