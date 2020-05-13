package com.joy.insapi.request.api.currentuser;


import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBaseGetRequest;
import java.util.HashMap;
import java.util.Map;

public class CurrentUserInfoRequest extends
    InsBaseGetRequest<CurrentUserInfoResponse> {


  public CurrentUserInfoRequest() {
  }

  @Override
  protected String getActionUrl() {
    return IGConfig.ACTION_CURRENT_USER;
  }


  @Override
  protected Map<String, String> getMapParams() {
    HashMap<String, String> paramsMap = new HashMap<>();
    paramsMap.put("edit",true+"");
    return paramsMap;
  }
}
