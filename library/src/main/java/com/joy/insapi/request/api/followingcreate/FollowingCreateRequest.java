package com.joy.insapi.request.api.followingcreate;

import com.joy.insapi.manager.IGCommonFieldsManager;
import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.manager.utils.IGUtils;
import com.joy.insapi.request.InsBasePostRequest;

public class FollowingCreateRequest extends
    InsBasePostRequest<FollowingCreatePayload, FollowingCreateResponseData> {

  private String userId;

  public FollowingCreateRequest(String userId) {
    this.userId = userId;
  }

  @Override
  protected String getActionUrl() {
    return String.format(IGConfig.ACTION_GET_FOLLOWING_CREATE, userId);
  }

  @Override
  protected FollowingCreatePayload getRequestData() {

    String csrftoken = IGCommonFieldsManager.getInstance().getCsrftoken();
    String pkid = IGCommonFieldsManager.getInstance().getPKID();

    FollowingCreatePayload followingCreatePayload = new FollowingCreatePayload();

    followingCreatePayload.set_csrftoken(csrftoken);
    followingCreatePayload.set_uid(pkid);
    followingCreatePayload.set_uuid(IGUtils.generateUuid(true));
    followingCreatePayload.setUser_id(userId);
    followingCreatePayload.setRadio_type("wifi-none");

    return followingCreatePayload;
  }
}
