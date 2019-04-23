package com.joy.instagramapi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.joy.insapi.manager.IGCommonFieldsManager;
import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.response.InsBaseResponseData;
import com.joy.insapi.response.InsGsonResponseHandler;
import com.joy.insapi.request.InsRequestCallBack;
import com.joy.insapi.request.api.feed.FeedResponseData;
import com.joy.insapi.request.api.feed.GetAllFeedManager;
import com.joy.insapi.request.api.feed.GetFeedRequest;
import com.joy.insapi.request.api.feed.GetLikedFeedRequest;
import com.joy.insapi.request.api.follower.FollowersResponseData;
import com.joy.insapi.request.api.follower.GetFollowersRequest;
import com.joy.insapi.request.api.following.FollowingResponseData;
import com.joy.insapi.request.api.following.GetFollowingRequest;
import com.joy.insapi.request.api.followingcancel.FollowingCancelRequest;
import com.joy.insapi.request.api.followingcancel.FollowingCancelResponseData;
import com.joy.insapi.request.api.followingcreate.FollowingCreateRequest;
import com.joy.insapi.request.api.followingcreate.FollowingCreateResponseData;
import com.joy.insapi.request.api.header.GetHeaderRequest;
import com.joy.insapi.request.api.login.LoginRequest;
import com.joy.insapi.request.api.login.LoginResponseData;
import com.joy.insapi.request.api.mediacomments.GetMediaCommentsRequest;
import com.joy.insapi.request.api.mediacomments.MediaCommentResponseData;
import com.joy.insapi.request.api.medialike.MedialLikeRequest;
import com.joy.insapi.request.api.medialikers.GetMediaLikersRequest;
import com.joy.insapi.request.api.medialikers.MediaLikersResponseData;
import com.joy.insapi.request.api.mediaunlike.MedialUnLikeRequest;
import com.joy.insapi.request.api.userinfo.UserInfoResponseData;
import com.joy.insapi.request.api.userinfo.UserInfoWithIDRequest;
import com.joy.insapi.request.api.userinfo.UserInfoWithNameRequest;
import com.joy.libok.OkHttpManager;
import com.joy.libok.configdata.OKConfigData;
import com.joy.libok.test.log.LLog;

import java.util.List;

import okhttp3.Headers;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private static final String TAG = "MainActivity";
	private Context mContext;
	FeedResponseData mFeedResponseDataAll = new FeedResponseData();
	FeedResponseData mFeedResponseDataLiked = new FeedResponseData();
	FollowersResponseData mFollowersResponseData = new FollowersResponseData();
	FollowingResponseData mFollowingResponseData = new FollowingResponseData();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_ins);
		mContext = this;
		initInsFiledManger();
		initListener();
		initOkManager();

	}

	private void initInsFiledManger() {
		IGCommonFieldsManager.getInstance().init(this);
	}

	private void initListener() {
		findViewById(R.id.btn_getcsftoken).setOnClickListener(this);
		findViewById(R.id.btn_login).setOnClickListener(this);
		findViewById(R.id.btn_getfeed).setOnClickListener(this);
		findViewById(R.id.btn_getfeedlike).setOnClickListener(this);
		findViewById(R.id.btn_followers).setOnClickListener(this);
		findViewById(R.id.btn_following).setOnClickListener(this);
		findViewById(R.id.btn_media_likers).setOnClickListener(this);
		findViewById(R.id.btn_media_comments).setOnClickListener(this);
		findViewById(R.id.btn_getUserInfo).setOnClickListener(this);
		findViewById(R.id.btn_following_create).setOnClickListener(this);
		findViewById(R.id.btn_following_cancel).setOnClickListener(this);
		findViewById(R.id.btn_media_like).setOnClickListener(this);
		findViewById(R.id.btn_media_unlike).setOnClickListener(this);


	}

	private void initOkManager() {
		OKConfigData okConfigData = new OKConfigData();
		ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(mContext));
		okConfigData.setCookiesJar(cookieJar);
		OkHttpManager.getInstance().init(okConfigData);
		//OkHttpManager2.getInstance().init(okConfigData);

	}


	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.btn_getcsftoken:
				getCsftoken();
				break;

			case R.id.btn_login:
				//login("joy.dingtone", "123456inst"); //10171477409
				//login("baily.teesy", "bj12345678");
				login("wwwaitinglwt", "669845lwt");  //pkId = 322961280
				//login("pidan_baby", "destiny411"); // pkId = 6500982440
				//login("pidan_baby", "destiny411"); // pkId = 6500982440
				break;
			case R.id.btn_getfeed:
				getFeed(true, "");
				//getAllFeed();
				break;
			case R.id.btn_getfeedlike:
				getFeedLiked(true,"");
				break;

			case R.id.btn_followers:
				getFollowers(true, "");
				break;
			case R.id.btn_following:
				getFollowing(true, "");
				break;

			case R.id.btn_media_likers:
				getMediaLikers();
				//getMediaLikers("1912206998860865471_322961280");
				//getMediaLikers("1809442075797084161_6500982440");
				//getMediaLikers("1815244845150013945_6500982440");

				break;

			case R.id.btn_media_comments:
				getMediaComments();
				break;

			case R.id.btn_getUserInfo:
				//getUserInfo("322961280");
				//getUserInfo2("shutongjia0425265");
				getUserInfo2("shutongjia04252653333");
				break;

			case R.id.btn_following_create:
				following_create("10171477409");
				break;


			case R.id.btn_following_cancel:
				following_cancel("10171477409");
				break;


			case R.id.btn_media_like:
				mediaLike("1986863750145515832_10171477409");
				break;


			case R.id.btn_media_unlike:
				mediaUnLike("1986863750145515832_10171477409");
				break;

			default:
				break;
		}
	}


	private void getCsftokenTest() {
		String url = IGConfig.API_V1 + IGConfig.ACTION_GET_HEADER;
		OkHttpManager.getInstance().get(url).addHeaders(IGConfig.getHeadersPHp3()).execute(new InsGsonResponseHandler<InsBaseResponseData>() {

			@Override
			public void onSuccess(int statusCode, InsBaseResponseData insBaseData) {
				//LLog.d(TAG, huoYingData.toString());
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {

			}

			@Override
			public void onGetHeaders(Headers headers) {
				super.onGetHeaders(headers);
				List<String> cookies = headers.values("Set-Cookie");
				int length = 0;
				if (cookies != null && (length = cookies.size()) != 0) {
					for (int i = 0; i < length; i++) {
						String session = cookies.get(i);

						char semicolon = ';';
						if (session.contains("csrftoken")) {
							int startIndex = session.indexOf("csrftoken") + "csrftoken".length() + 1;
							int endIndex = 0;
							char[] chars = session.toCharArray();
							for (int j = startIndex; j < chars.length; j++) {
								if (chars[j] == semicolon) {
									endIndex = j;
									break;
								}
							}
							String result = session.substring(startIndex, endIndex);
							IGCommonFieldsManager.getInstance().saveCsrftoken(result);
							Log.d(TAG, "result= " + result);
						}

					}

				}


			}
		});


	}

	private void getCsftoken() {
		final GetHeaderRequest getHeaderRequest = new GetHeaderRequest();
		getHeaderRequest.execute(new InsRequestCallBack() {
			@Override
			public void onSuccess(int statusCode, InsBaseResponseData insBaseData) {
				if (null != getHeaderRequest) {
					String csrfCookie = getHeaderRequest.getCsrfCookie();
					Log.d(TAG, "get Csftoken onSuccess，csrfCookie =  "+csrfCookie);
				}
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "get Csftoken onFailure ");
			}
		});


	}


	private void login(String userName, String pwd) {

		LoginRequest loginRequest = new LoginRequest(userName,pwd);
		loginRequest.execute(new InsRequestCallBack<LoginResponseData>() {
			@Override
			public void onSuccess(int statusCode, LoginResponseData insBaseData) {
				LLog.d(TAG, insBaseData.toString());
				LoginResponseData.LoggedInUserBean loggedInUserBean = null;
				if (insBaseData != null && (loggedInUserBean = insBaseData.getLogged_in_user()) != null) {
					String pkId = loggedInUserBean.getPk() + "";
					if (!TextUtils.isEmpty(pkId)) {
						IGCommonFieldsManager.getInstance().savePKID(pkId);
					}
					Log.d(TAG, "pkId = " + pkId);
				}
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				LLog.d(TAG, String.format("errorCode= %s , errorMsg = %s", errorCode, errorMsg));
			}
		});


	}


	private void getAllFeed() {
		String userId = IGCommonFieldsManager.getInstance().getPKID();
		GetAllFeedManager.getInstance().getAllFeed(userId,new GetAllFeedManager.GetAllFeedCallBack() {
			@Override
			public void onSuccess(FeedResponseData feedResponseData) {
				Log.d(TAG, String.format("getFeed request end and the size = %s ", feedResponseData.getItems().size()));
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getFeed onFailure = " + errorMsg);
			}
		});


	}


	private void getFeed(boolean isFirstPage, String nextMaxId) {

		if (isFirstPage) {
			mFeedResponseDataAll.getItems().clear();
		}
		String userId = IGCommonFieldsManager.getInstance().getPKID();
		GetFeedRequest getFeedRequest = new GetFeedRequest(isFirstPage, userId, nextMaxId);
		getFeedRequest.execute(new InsRequestCallBack<FeedResponseData>() {
			@Override
			public void onSuccess(int statusCode, FeedResponseData response) {

				mFeedResponseDataAll.setAuto_load_more_enabled(response.isAuto_load_more_enabled());
				mFeedResponseDataAll.setNum_results(response.getNum_results() + response.getNum_results());
				mFeedResponseDataAll.setNext_max_id(response.getNext_max_id());
				mFeedResponseDataAll.setMore_available(response.isMore_available());
				mFeedResponseDataAll.getItems().addAll(response.getItems());

				for (int i = 0; i <response.getItems().size() ; i++) {
					Log.d(TAG, String.format("--------www------- %s", response.getItems().get(i).getMedia_type()));

					if (response.getItems().get(i).getMedia_type()==2){
						Log.d(TAG, String.format("--------------- %s", response.getItems().get(i).getView_count()));
					}
				}

				if (response.isMore_available()) {
					getFeed(false, mFeedResponseDataAll.getNext_max_id());
				} else {
					Log.d(TAG, String.format("getFeed request end and the size = %s ", mFeedResponseDataAll.getItems().size()));
				}


			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getFeed onFailure = " + errorMsg);
			}
		});


	}


	/**
	 * 获取点赞的post
	 *
	 * @param isFirstPage
	 */
	private void getFeedLiked(boolean isFirstPage, String nextMaxId) {


		if (isFirstPage) {
			mFeedResponseDataLiked.getItems().clear();
		}
		GetLikedFeedRequest getFeedLikedRequest = new GetLikedFeedRequest(isFirstPage,nextMaxId);
		getFeedLikedRequest.execute(new InsRequestCallBack<FeedResponseData>() {
			@Override
			public void onSuccess(int statusCode, FeedResponseData response) {
				Log.d(TAG, "getFeedLiked onSuccess ");

				mFeedResponseDataLiked.setAuto_load_more_enabled(response.isAuto_load_more_enabled());
				mFeedResponseDataLiked.setNum_results(response.getNum_results() + response.getNum_results());
				mFeedResponseDataLiked.setNext_max_id(response.getNext_max_id());
				mFeedResponseDataLiked.setMore_available(response.isMore_available());
				mFeedResponseDataLiked.getItems().addAll(response.getItems());

				if (response.isMore_available()) {
					getFeedLiked(false,mFeedResponseDataLiked.getNext_max_id());
				} else {
					Log.d(TAG, String.format("getFeedLiked request end and the size = %s ", mFeedResponseDataLiked.getItems().size()));
				}

			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getFeedLiked onFailure = " + errorMsg);
			}
		});




	}


	private void getFollowers(boolean isFirstPage, String nextMaxId) {

		if (isFirstPage) {
			mFollowersResponseData.getUsers().clear();
		}
		 String userId = IGCommonFieldsManager.getInstance().getPKID();

		String userId1 = " 7761457415";
		GetFollowersRequest getFollowersRequest = new GetFollowersRequest(isFirstPage, userId1, nextMaxId);
		getFollowersRequest.execute(new InsRequestCallBack<FollowersResponseData>() {
			@Override
			public void onSuccess(int statusCode, FollowersResponseData response) {
				Log.d(TAG, "getFollowers onSuccess ");
				mFollowersResponseData.setBig_list(response.isBig_list());
				mFollowersResponseData.setNext_max_id(response.getNext_max_id());
				mFollowersResponseData.setPage_size(mFollowersResponseData.getPage_size() + response.getPage_size());
				mFollowersResponseData.getUsers().addAll(response.getUsers());

				if (!TextUtils.isEmpty(response.getNext_max_id())) {
					getFollowers(false, mFollowersResponseData.getNext_max_id());
				} else {
					Log.d(TAG, String.format("getFollowers request end and the size = %s ", mFollowersResponseData.getUsers().size()));
				}

			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getFollowers onFailure = " + errorMsg);
			}
		});


	}


	private void getFollowing(boolean isFirstPage, String nextMaxId) {

		if (isFirstPage) {
			mFollowingResponseData.getUsers().clear();
		}


		String userId = IGCommonFieldsManager.getInstance().getPKID();

		GetFollowingRequest request = new GetFollowingRequest(isFirstPage, userId, nextMaxId);
		request.execute(new InsRequestCallBack<FollowingResponseData>() {
			@Override
			public void onSuccess(int statusCode, FollowingResponseData response) {
				Log.d(TAG, "getFollowers onSuccess ");
				mFollowingResponseData.setBig_list(response.isBig_list());
				mFollowingResponseData.setNext_max_id(response.getNext_max_id());
				mFollowingResponseData.setPage_size(mFollowingResponseData.getPage_size() + response.getPage_size());
				mFollowingResponseData.getUsers().addAll(response.getUsers());

				if (!TextUtils.isEmpty(response.getNext_max_id())) {
					getFollowing(false, mFollowingResponseData.getNext_max_id());
				} else {
					Log.d(TAG, String.format("getFollowers request end and the size = %s ", mFollowingResponseData.getUsers().size()));
				}
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getFollowers onFailure = " + errorMsg);
			}
		});


	}


	private void getMediaLikers() {
		List<FeedResponseData.ItemsBean> itemsBeanList = mFeedResponseDataAll.getItems();
		int size = itemsBeanList.size();
		getLikersCount = 0;
		getLikersCount_amount =0;
		for (int i = 0; i < size; i++) {
			Log.d(TAG, "ItemsBean---------- " + i);
			FeedResponseData.ItemsBean itemsBean = itemsBeanList.get(i);
			//getMediaLikers(itemsBean);
			getMediaLikers222(itemsBean);
		}
	}

	private int getLikersCount = 0;
	private int getLikersCount_amount = 0;

	private void getMediaLikers222(final FeedResponseData.ItemsBean itemsBean) {

		GetMediaLikersRequest getMediaLikersRequest = new GetMediaLikersRequest(itemsBean.getId());
		getMediaLikersRequest.execute(new InsRequestCallBack<MediaLikersResponseData>() {
			@Override
			public void onSuccess(int statusCode, MediaLikersResponseData response) {
				itemsBean.getLikers().clear();
				itemsBean.getLikers().addAll(response.getUsers());
				getLikersCount++;
				getLikersCount_amount = getLikersCount_amount+response.getUser_count();


				Log.d(TAG,
						"getMediaLikers onSuccess,  getLikersCount=" + getLikersCount+",response.getUsers() ="+response.getUsers().size()+", " +
								"getLikersCount_amount ="+getLikersCount_amount);
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getMediaLikers onFailure = " + errorMsg);
			}
		});


	}


	private void getMediaComments() {
		List<FeedResponseData.ItemsBean> itemsBeanList = mFeedResponseDataAll.getItems();
		int size = itemsBeanList.size();
		MediaComments = 0;
		MediaComments_amout = 0;
		for (int i = 0; i < size; i++) {
			Log.d(TAG, "ItemsBean---------- " + i);
			FeedResponseData.ItemsBean itemsBean = itemsBeanList.get(i);
			//getMediaComments(itemsBean);
			getMediaComments222(itemsBean);
		}
	}

	private int MediaComments = 0;
	private int MediaComments_amout = 0;


	private void getMediaComments222(final FeedResponseData.ItemsBean itemsBean) {

		GetMediaCommentsRequest commentsRequest = new GetMediaCommentsRequest(itemsBean.getId());
		commentsRequest.execute(new InsRequestCallBack<MediaCommentResponseData>() {
			@Override
			public void onSuccess(int statusCode, MediaCommentResponseData response) {

				itemsBean.getComments().clear();
				itemsBean.getComments().addAll(response.getComments());
				MediaComments++;
				MediaComments_amout = MediaComments_amout+response.getComment_count();
				Log.d(TAG, "getMediaComments onSuccess, " + MediaComments+",MediaComments_amout="+MediaComments_amout);
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getMediaLikers onFailure = " + errorMsg);
			}
		});

	}


	private void getUserInfo(String userId) {
		UserInfoWithIDRequest userInfoRequest = new UserInfoWithIDRequest(userId);
		userInfoRequest.execute(new InsRequestCallBack<UserInfoResponseData>() {
			@Override
			public void onSuccess(int statusCode, UserInfoResponseData insBaseData) {
				Log.d(TAG, "getUserInfo onSuccess "+insBaseData.getUser().getUsername());
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getUserInfo onFailure = " + errorMsg);
			}
		});
	}

	private void getUserInfo2(String userId) {
		UserInfoWithNameRequest userInfoRequest = new UserInfoWithNameRequest(userId);
		userInfoRequest.execute(new InsRequestCallBack<UserInfoResponseData>() {
			@Override
			public void onSuccess(int statusCode, UserInfoResponseData insBaseData) {
				Log.d(TAG, "getUserInfo onSuccess "+insBaseData.getUser().getUsername());
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getUserInfo onFailure = " + errorMsg);
				//getUserInfo onFailure = {"message": "User not found", "status": "fail"}
			}
		});
	}






	private void following_create(String userId) {


		FollowingCreateRequest followingCreateRequest = new FollowingCreateRequest(userId);
		followingCreateRequest.execute(new InsRequestCallBack<FollowingCreateResponseData>() {
			@Override
			public void onSuccess(int statusCode, FollowingCreateResponseData insBaseData) {
				if (insBaseData.getFriendship_status().isFollowing()) {
					Log.d(TAG, "关注 onSuccess ");
				} else {
					Log.d(TAG, "关注 失败 ");
				}


			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getUserInfo onFailure = " + errorMsg);
			}
		});
	}


	private void following_cancel(String userId) {

		FollowingCancelRequest followingCreateRequest = new FollowingCancelRequest(userId);
		followingCreateRequest.execute(new InsRequestCallBack<FollowingCancelResponseData>() {
			@Override
			public void onSuccess(int statusCode, FollowingCancelResponseData insBaseData) {
				if (insBaseData.getFriendship_status().isFollowing()) {
					Log.d(TAG, "取消关注 失败 ");
				} else {
					Log.d(TAG, "取消关注 成功");
				}
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "getUserInfo onFailure = " + errorMsg);
			}
		});
	}


	private void mediaLike(String mediaID) {




		MedialLikeRequest medialLikeRequest = new MedialLikeRequest(mediaID);
		medialLikeRequest.execute(new InsRequestCallBack<InsBaseResponseData>() {
			@Override
			public void onSuccess(int statusCode, InsBaseResponseData insBaseData) {
				Log.d(TAG, "mediaLike onSuccess = ");
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "mediaLike onFailure = " + errorMsg);
			}
		});
	}

	private void mediaUnLike(String mediaID) {


		MedialUnLikeRequest medialUnLikeRequest = new MedialUnLikeRequest(mediaID);
		medialUnLikeRequest.execute(new InsRequestCallBack<InsBaseResponseData>() {
			@Override
			public void onSuccess(int statusCode, InsBaseResponseData insBaseData) {
				Log.d(TAG, "mediaUnLike onSuccess  ");
			}

			@Override
			public void onFailure(int errorCode, String errorMsg) {
				Log.d(TAG, "mediaUnLike onFailure = " + errorMsg);
			}
		});
	}


}
