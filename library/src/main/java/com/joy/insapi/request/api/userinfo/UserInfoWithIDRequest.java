package com.joy.insapi.request.api.userinfo;


import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBaseGetRequest;

import java.util.Map;

public class UserInfoWithIDRequest extends InsBaseGetRequest<UserInfoResponseData> {

  private String userId;

  public UserInfoWithIDRequest(String userId) {
    this.userId = userId;
  }

  @Override
  protected Map<String, String> getMapParams() {
    return null;
  }

  @Override
  protected String getActionUrl() {
    return String.format(IGConfig.ACTION_GET_USER_INFO_WITH_ID, userId);
  }
}
