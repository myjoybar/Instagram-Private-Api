package com.joy.insapi.request.mediaunlike;


import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBasePostRequest;
import com.joy.insapi.request.InsBaseResponseData;

public class MedialUnLikeRequest extends InsBasePostRequest<MediaUnLikePayload, InsBaseResponseData> {

	private String mediaId;

	public MedialUnLikeRequest(String mediaId, MediaUnLikePayload requestData) {
		super(requestData);
		this.mediaId = mediaId;
	}

	@Override
	protected String getActionUrl() {
		return String.format(IGConfig.ACTION_GET_MEDIA_UNLIKE, mediaId);
	}
}
