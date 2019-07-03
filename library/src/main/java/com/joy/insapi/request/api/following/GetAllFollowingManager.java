package com.joy.insapi.request.api.following;

import android.text.TextUtils;

import com.joy.insapi.request.InsRequestCallBack;

public class GetAllFollowingManager {

  private GetAllFollowingCallBack mGetAllFollowingCallBack;
  private String mUserId;
  private FollowingResponseData mFollowingResponseData;

  private static final class GetAllFollowersManagerHolder {

    public static final GetAllFollowingManager INSTANCE = new GetAllFollowingManager();
  }

  public static GetAllFollowingManager getInstance() {
    return GetAllFollowersManagerHolder.INSTANCE;
  }


  public void getAllFollowers(String userId, GetAllFollowingCallBack getAllFollowingCallBack) {
    this.mUserId = userId;
    this.mGetAllFollowingCallBack = getAllFollowingCallBack;
    getFollowing(true, "");
  }


  private void getFollowing(boolean isFirstPage, String nextMaxId) {
    if (isFirstPage) {
      mFollowingResponseData = new FollowingResponseData();
    }

    GetFollowingRequest request = new GetFollowingRequest(isFirstPage, mUserId, nextMaxId);
    request.execute(new InsRequestCallBack<FollowingResponseData>() {
      @Override
      public void onSuccess(int statusCode, FollowingResponseData response) {
        mFollowingResponseData.setBig_list(response.isBig_list());
        mFollowingResponseData.setNext_max_id(response.getNext_max_id());
        mFollowingResponseData
            .setPage_size(mFollowingResponseData.getPage_size() + response.getPage_size());
        mFollowingResponseData.getUsers().addAll(response.getUsers());

        if (!TextUtils.isEmpty(response.getNext_max_id())) {
          getFollowing(false, mFollowingResponseData.getNext_max_id());
        } else {
          if (null != mGetAllFollowingCallBack) {
            mGetAllFollowingCallBack.onSuccess(mFollowingResponseData);

          }
          clearData();

        }
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        if (null != mGetAllFollowingCallBack) {
          mGetAllFollowingCallBack.onFailure(errorCode, errorMsg);
        }
        clearData();
      }
    });


  }


  private void clearData() {
    mGetAllFollowingCallBack = null;
    mFollowingResponseData = null;
    mUserId = null;
  }

  public interface GetAllFollowingCallBack {

    void onSuccess(FollowingResponseData followingResponseData);

    void onFailure(int errorCode, String errorMsg);
  }


}
