package com.joy.insapi.request.api.follower;

import android.text.TextUtils;

import com.joy.insapi.request.InsRequestCallBack;

public class GetAllFollowersManager {

  private GetAllFollowersCallBack mGetAllFollowersCallBack;
  private String mUserId;
  private FollowersResponseData mFollowersResponseData;

  private static final class GetAllFollowersManagerHolder {

    public static final GetAllFollowersManager INSTANCE = new GetAllFollowersManager();
  }

  public static GetAllFollowersManager getInstance() {
    return GetAllFollowersManagerHolder.INSTANCE;
  }


  public void getAllFollowers(String userId, GetAllFollowersCallBack getlFollowersFeedCallBack) {
    this.mUserId = userId;
    this.mGetAllFollowersCallBack = getlFollowersFeedCallBack;
    getFollowers(true, "");
  }


  private void getFollowers(boolean isFirstPage, String nextMaxId) {
    if (isFirstPage) {
      mFollowersResponseData = new FollowersResponseData();
    }
    GetFollowersRequest getFollowersRequest = new GetFollowersRequest(isFirstPage, mUserId,
        nextMaxId);
    getFollowersRequest.execute(new InsRequestCallBack<FollowersResponseData>() {
      @Override
      public void onSuccess(int statusCode, FollowersResponseData response) {
        if (null != mFollowersResponseData) {
          mFollowersResponseData.setBig_list(response.isBig_list());
          mFollowersResponseData.setNext_max_id(response.getNext_max_id());
          mFollowersResponseData
              .setPage_size(mFollowersResponseData.getPage_size() + response.getPage_size());
          mFollowersResponseData.getUsers().addAll(response.getUsers());

          if (!TextUtils.isEmpty(response.getNext_max_id())) {
            getFollowers(false, mFollowersResponseData.getNext_max_id());
          } else {
            if (null != mGetAllFollowersCallBack) {
              mGetAllFollowersCallBack.onSuccess(mFollowersResponseData);

            }
            clearData();

          }
        } else {
          if (null != mGetAllFollowersCallBack) {
            mGetAllFollowersCallBack.onFailure(0, "mFollowersResponseData is null");
          }
        }

      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        if (null != mGetAllFollowersCallBack) {
          mGetAllFollowersCallBack.onFailure(errorCode, errorMsg);
        }
        clearData();
      }

    });

  }

  private void clearData() {
    //mFollowersResponseData = null;
    //mGetAllFollowersCallBack = null;
    //mUserId = null;
  }

  public interface GetAllFollowersCallBack {

    void onSuccess(FollowersResponseData followersResponseData);

    void onFailure(int errorCode, String errorMsg);
  }


}
