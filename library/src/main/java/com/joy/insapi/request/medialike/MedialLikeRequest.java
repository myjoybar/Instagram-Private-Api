package com.joy.insapi.request.medialike;


import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBasePostRequest;
import com.joy.insapi.request.InsBaseResponseData;

public class MedialLikeRequest extends InsBasePostRequest<MediaLikePayload, InsBaseResponseData> {

	private String mediaId;

	public MedialLikeRequest(String mediaId,MediaLikePayload requestData) {
		super(requestData);
		this.mediaId = mediaId;
	}

	@Override
	protected String getActionUrl() {
		return String.format(IGConfig.ACTION_GET_MEDIA_LIKE, mediaId);
	}
}
