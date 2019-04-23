package com.joy.insapi.request.api.feed;


import com.joy.insapi.request.InsRequestCallBack;

public class GetAllFeedManager {

	private FeedResponseData mFeedResponseDataAll;
	private GetAllFeedCallBack mGetAllFeedCallBack;
	private String mUserId;

	private static final class GetAllFeedManagerHolder {
		public static final GetAllFeedManager INSTANCE = new GetAllFeedManager();
	}

	public static GetAllFeedManager getInstance() {
		return GetAllFeedManagerHolder.INSTANCE;
	}


	public void getAllFeed(String userId, GetAllFeedCallBack feedResponseDataAll) {
		mUserId = userId;
		mGetAllFeedCallBack = feedResponseDataAll;
		getAllFeed(true, "");
	}


	private void getAllFeed(boolean isFirstPage, String nextMaxId) {
		if (isFirstPage) {
			mFeedResponseDataAll = new FeedResponseData();
		}
		GetFeedRequest getFeedRequest = new GetFeedRequest(isFirstPage, mUserId, nextMaxId);
		getFeedRequest.execute(new InsRequestCallBack<FeedResponseData>() {
			@Override
			public void onSuccess(int statusCode, FeedResponseData response) {

				if (null != mFeedResponseDataAll) {
					mFeedResponseDataAll.setAuto_load_more_enabled(response.isAuto_load_more_enabled());
					mFeedResponseDataAll.setNum_results(response.getNum_results() + response.getNum_results());
					mFeedResponseDataAll.setNext_max_id(response.getNext_max_id());
					mFeedResponseDataAll.setMore_available(response.isMore_available());
					mFeedResponseDataAll.getItems().addAll(response.getItems());
					if (response.isMore_available()) {
						getAllFeed(false, mFeedResponseDataAll.getNext_max_id());
					} else {
						if (null != mGetAllFeedCallBack) {
							mGetAllFeedCallBack.onSuccess(mFeedResponseDataAll);

						}
						clearData();

					}

				}else{
					if (null != mGetAllFeedCallBack) {
						mGetAllFeedCallBack.onFailure(0, "mFeedResponseDataAll is null");
					}
				}

			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				if (null != mGetAllFeedCallBack) {
					mGetAllFeedCallBack.onFailure(errorCode, errorMsg);
				}
				clearData();
			}
		});


	}

	private void clearData() {
		//mGetAllFeedCallBack = null;
		//mFeedResponseDataAll = null;
		//mUserId = null;
	}

	public interface GetAllFeedCallBack {
		void onSuccess(FeedResponseData feedResponseData);

		void onFailure(int errorCode, String errorMsg);
	}

}
