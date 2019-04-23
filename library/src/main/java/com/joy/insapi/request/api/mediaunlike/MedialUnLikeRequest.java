package com.joy.insapi.request.api.mediaunlike;


import com.joy.insapi.manager.IGCommonFieldsManager;
import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.manager.utils.IGUtils;
import com.joy.insapi.request.InsBasePostRequest;
import com.joy.insapi.response.InsBaseResponseData;

public class MedialUnLikeRequest extends InsBasePostRequest<MediaUnLikePayload, InsBaseResponseData> {

	private String mediaId;

	public MedialUnLikeRequest(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	protected String getActionUrl() {
		return String.format(IGConfig.ACTION_GET_MEDIA_UNLIKE, mediaId);
	}

	@Override
	protected MediaUnLikePayload getRequestData() {
		String csrftoken = IGCommonFieldsManager.getInstance().getCsrftoken();
		String pkid = IGCommonFieldsManager.getInstance().getPKID();

		MediaUnLikePayload mediaUnLikePayload = new MediaUnLikePayload();

		mediaUnLikePayload.set_csrftoken(csrftoken);
		mediaUnLikePayload.set_uid(pkid);
		mediaUnLikePayload.set_uuid(IGUtils.generateUuid(true));
		mediaUnLikePayload.setRadio_type("wifi-none");
		mediaUnLikePayload.setMedia_id(mediaId);
		return mediaUnLikePayload;
	}
}
