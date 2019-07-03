package com.joy.insapi.request.api.feed;

import com.joy.insapi.manager.IGCommonFieldsManager;
import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.request.InsBaseGetRequest;

import java.util.HashMap;
import java.util.Map;

public class GetLikedFeedRequest extends InsBaseGetRequest<FeedResponseData> {

  private boolean isFirstPage;
  private String nextMaxId;

  public GetLikedFeedRequest(boolean isFirstPage, String nextMaxId) {
    this.isFirstPage = isFirstPage;
    this.nextMaxId = nextMaxId;
  }

  @Override
  protected String getActionUrl() {
    return IGConfig.ACTION_GET_FEED_LIKED;
  }

  @Override
  protected Map<String, String> getMapParams() {
    HashMap<String, String> paramsMap = new HashMap<>();
    String userId = IGCommonFieldsManager.getInstance().getPKID();
    paramsMap.put("uid", userId);
    if (!isFirstPage) {
      paramsMap.put("max_id", nextMaxId);
    }
    return paramsMap;
  }
}
