package com.joy.instagramapi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.widget.EditText;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.joy.insapi.manager.IGCommonFieldsManager;
import com.joy.insapi.manager.utils.IGGsonUtil;
import com.joy.insapi.manager.utils.Utils;
import com.joy.insapi.request.InsRequestCallBack;
import com.joy.insapi.request.api.currentuser.CurrentUserInfoRequest;
import com.joy.insapi.request.api.currentuser.CurrentUserInfoResponse;
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
import com.joy.insapi.request.api.userinfo.UserInfoWebRequest;
import com.joy.insapi.request.api.userinfo.UserInfoWithIDRequest;
import com.joy.insapi.request.api.userinfo.UserInfoWithNameRequest;
import com.joy.insapi.response.InsBaseResponseData;
import com.joy.insapi.response.exception.ChallengeRequired;
import com.joy.insapi.response.exception.InactiveUser;
import com.joy.instagramapi.webview.CustomPersistentCookieJar;
import com.joy.instagramapi.webview.InVisibleWebViewHelper;
import com.joy.instagramapi.webview.WebViewUtils;
import com.joy.instagramapi.webview.WebviewActivity;
import com.joy.libok.OkHttpManager;
import com.joy.libok.configdata.OKConfigData;
import com.joy.libok.test.log.LLog;
import java.util.Arrays;
import java.util.List;
import me.dt.libbase.mmkv.MMKVManager;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final String TAG = "MainActivity";
  private Context mContext;
  private EditText etSmsCode;

  FeedResponseData mFeedResponseDataAll = new FeedResponseData();
  FeedResponseData mFeedResponseDataLiked = new FeedResponseData();
  FollowersResponseData mFollowersResponseData = new FollowersResponseData();
  FollowingResponseData mFollowingResponseData = new FollowingResponseData();

  //public static String webviewUserAgent = "Mozilla/5.0 (Linux; Android 10; Pixel Build/QP1A.191005.007.A3; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/79.0.3945.116 Mobile Safari/537.36";
  String webviewUserAgent = WebViewUtils.getUserAgent(mContext);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_ins);
    mContext = this;
    initOkManager();
    initInsFiledManger();
    initListener();
    MMKVManager.getInstance().init(mContext);

    Log.d(TAG, "getCodeName =  " + Utils.getCodeName());
    Log.d(TAG, "getCpuAbi =  " + Utils.getCpuAbi());
    Log.d(TAG, "getCpuAbi2 =  " + Utils.getCpuAbi2());
    Log.d(TAG, "getFingerprint =  " + Utils.getFingerprint());
    Log.d(TAG, "getManufacturer =  " + Utils.getManufacturer());
    Log.d(TAG, "getProduct =  " + Utils.getProduct());
    Log.d(TAG, "getBoard =  " + Utils.getBoard());
    Log.d(TAG, "getDisplay =  " + Utils.getDisplay());
    Log.d(TAG, "getDevice =  " + Utils.getDevice());
    Log.d(TAG, "getSystemModel =  " + Utils.getSystemModel());
    Log.d(TAG, "getDeviceBrand =  " + Utils.getDeviceBrand());
    Log.d(TAG, "getCpuName =  " + Utils.getCpuName());
    Log.d(TAG, "getCpuInfo =  " + Arrays.toString(Utils.getCpuInfo()));

  }

  private void initInsFiledManger() {
    IGCommonFieldsManager.getInstance().init(this);
  }

  private void initListener() {
    findViewById(R.id.btn_webview).setOnClickListener(this);
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
    findViewById(R.id.btn_following_create_users).setOnClickListener(this);
    findViewById(R.id.btn_current).setOnClickListener(this);
    findViewById(R.id.btn_confirm_sms_code).setOnClickListener(this);
    etSmsCode = findViewById(R.id.et_sms_code);

  }

  private void initOkManager() {
    OKConfigData okConfigData = new OKConfigData();
    SharedPrefsCookiePersistor sharedPrefsCookiePersistor = new SharedPrefsCookiePersistor(
        MainActivity.this);
    ClearableCookieJar cookieJar = new CustomPersistentCookieJar(new SetCookieCache(),
        sharedPrefsCookiePersistor);
//    sharedPrefsCookiePersistor.clear();
    okConfigData.setCookiesJar(cookieJar);
    OkHttpManager.getInstance().init(okConfigData);

//    IGCommonFieldsManager.getInstance().saveCsrftoken("gUdHaMgyW8ZKt5Ewz05oEqH1gDfPwTyw");
//
//    IGCommonFieldsManager.getInstance().savePKID("10171477409");

//    IGCommonFieldsManager.getInstance().saveCsrftoken("gUdHaMgyW8ZKt5Ewz05oEqH1gDfPwTyw");
//
//    IGCommonFieldsManager.getInstance().savePKID("32834908");



  }


  @Override
  public void onClick(View v) {
    int id = v.getId();
    switch (id) {
      case R.id.btn_webview:
        String url = "https://www.instagram.com/";
        // String url = "https://www.instagram.com/accounts/login/";


        WebviewActivity.launch(MainActivity.this, url);
        // InVisibleWebViewHelper.getInstance().initWebView(mContext,url);

        // WebViewUtils.tryIns();
        break;
      case R.id.btn_getcsftoken:
        getCsftoken();
        // addTestCookie22();
        break;

      case R.id.btn_login:
//       login("joy.dingtone", "123456inst"); //10171477409
        //   login("hansj_1009", "hansj10099");
//       login("rainysunshine123", "Rainy521");

        // login("bandelinis55_g", "H7jXuhZkFG");
       login("zb102030_hf", "913C2V057f");

        //    webLogin("hansj_1009", "hansj10099");

//        login("zinkaya5", "12345qwert"); //10171477409
        // login("pandachun666", "instagram_610261"); //10171477409
//        login("2908_jose", "2908jose2"); //10171477409
        //     login("hansj_1002", "hansj1002"); //10171477409
//        login("squallcpp", "Zhcsnow_1"); //10171477409
//        login("2908_jose", "2908jose2"); //10171477409
        //    login("galia.5737", "1234qwer"); //10171477409
        //login("squallcpp", "Zhcsnow_1"); //10171477409
        //   login("princebanana12", "wangf1234"); //10171477409
        //login("baily.teesy", "bj12345678");
        // login("wwwaitinglwt", "669845lwt");  //pkId = 322961280
        //login("pidan_baby", "destiny411"); // pkId = 6500982440
        //login("pidan_baby", "destiny411"); // pkId = 6500982440
        break;

      case R.id.btn_current:
        getCurrentInfo();
        break;

      case R.id.btn_getfeed:
        // getFeed(true, "");
       getAllFeed();
        break;
      case R.id.btn_getfeedlike:
        getFeedLiked(true, "");
        break;

      case R.id.btn_followers:
        getFollowers(true, "");
        break;
      case R.id.btn_following:
        getFollowing(true, "");
        break;

      case R.id.btn_media_likers:
        getMediaLikers();
        break;

      case R.id.btn_media_comments:
        getMediaComments();
        break;

      case R.id.btn_getUserInfo:
        // getUserInfoByUserId("322961280");
        //getUserInfoByUserName("shutongjia0425265");
        for (int i = 0; i < 500; i++) {
          try {
            Thread.sleep(1 * 100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          getUserInfoByUserName("Jack" + i);
        }

        // getUserInfoByUserNameWeb("squallcpp");
//
//        String requestUrl = "https://www.instagram.com/web/search/topsearch/?context=blended&query=joy.dingtone";
//        OkHttpManager.getInstance().get(requestUrl).execute(new StringResponseHandler() {
//
//          @Override
//          public void onSuccess(int statusCode, String response) {
//          }
//
//          @Override
//          public void onFailure(int errorCode, String errorMsg) {
//            super.onFailure(errorCode, errorMsg);
//          }
//        });
//

        break;

      case R.id.btn_following_create:
        followingCreate("10171477409");
        break;
      case R.id.btn_following_create_users:
        followingCreateUsers();
        break;

      case R.id.btn_following_cancel:
        followingCancel("10171477409");
        break;

      case R.id.btn_media_like:
        mediaLike("1986863750145515832_10171477409");
        break;

      case R.id.btn_media_unlike:
        mediaUnLike("1986863750145515832_10171477409");
        break;
      case R.id.btn_confirm_sms_code:
       String code = etSmsCode.getText().toString();
        WebViewUtils.passingSmsCodeParameter(InVisibleWebViewHelper.getInstance().getWebView(),code);
        break;
      default:
        break;
    }
  }


  /**
   * first step getCsftoken
   */
  private void getCsftoken() {
    final GetHeaderRequest getHeaderRequest = new GetHeaderRequest();
    getHeaderRequest.execute(new InsRequestCallBack() {
      @Override
      public void onSuccess(int statusCode, InsBaseResponseData insBaseData) {
        if (null != getHeaderRequest) {
          String csrfCookie = getHeaderRequest.getCsrfCookie();
          Log.d(TAG, "get Csftoken onSuccess，csrfCookie =  " + csrfCookie);
//          addTestCookie();
//          addTestCookie22();

        }
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "get Csftoken onFailure ： " + errorMsg);
        ChallengeRequired challengeRequired = IGGsonUtil
            .parseJsonStrToBean(errorMsg, ChallengeRequired.class);
        WebviewActivity.launch(MainActivity.this, challengeRequired.getChallenge().getUrl());
      }
    });

  }




  /**
   * Login
   */
  private void login(String userName, String pwd) {
    LoginRequest loginRequest = new LoginRequest(userName, pwd);
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

        CookieManager cookieManager = CookieManager.getInstance();
        String CookieStr = cookieManager
            .getCookie("https://i.instagram.com/api/v1/accounts/login/");
        Log.d(TAG, "CookieStr = " + CookieStr);
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        LLog.d(TAG, String.format("errorCode= %s , errorMsg = %s", errorCode, errorMsg));
        if(!TextUtils.isEmpty(errorMsg) && errorMsg.contains("inactive user")){
          InactiveUser inactiveUser =  IGGsonUtil
              .parseJsonStrToBean(errorMsg, InactiveUser.class);
          //WebviewActivity.launch(MainActivity.this, inactiveUser.getHelp_url());
        }

//        ChallengeRequired challengeRequired = IGGsonUtil
//            .parseJsonStrToBean(errorMsg, ChallengeRequired.class);
//        WebviewActivity.launch(MainActivity.this, challengeRequired.getChallenge().getUrl());
      }
    });

  }


  private void getCurrentInfo(){
    CurrentUserInfoRequest currentUserInfoRequest = new CurrentUserInfoRequest();
    currentUserInfoRequest.execute(new InsRequestCallBack<CurrentUserInfoResponse>() {
      @Override
      public void onSuccess(int statusCode, CurrentUserInfoResponse insBaseData) {
        Log.d(TAG, "currentUserInfoRequest onSuccess= " + insBaseData.getUser().getFull_name());

      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "currentUserInfoRequest onFailure= " + errorMsg);
      }
    });
  }
  private void webLogin(String userName, String pwd) {
    me.dt.inswebapi.request.api.login.LoginRequest loginRequest =
        new me.dt.inswebapi.request.api.login.LoginRequest(userName, pwd);
    loginRequest.execute(
        new me.dt.inswebapi.request.InsRequestCallBack<me.dt.inswebapi.request.api.login.LoginResponseData>() {
          @Override
          public void onSuccess(int i,
              me.dt.inswebapi.request.api.login.LoginResponseData loginResponseData) {
            Log.d(TAG, "web api login 成功 = ");
          }

          @Override
          public void onFailure(int i, String s) {
            Log.d(TAG, "web api login 失败 = " + s);

          }
        });
  }


  /**
   * 获取所有帖子
   */
  private void getAllFeed() {
    String userId = IGCommonFieldsManager.getInstance().getPKID();
    GetAllFeedManager.getInstance().getAllFeed(userId, new GetAllFeedManager.GetAllFeedCallBack() {
      @Override
      public void onSuccess(FeedResponseData feedResponseData) {
        Log.d(TAG, String
            .format("getFeed request end and the size = %s ", feedResponseData.getItems().size()));
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "getFeed onFailure = " + errorMsg);
      }
    });

  }

  /**
   * 获取帖子
   */

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

        for (int i = 0; i < response.getItems().size(); i++) {
          Log.d(TAG, response.getItems().get(i).getMedia_type() + "");
          if (response.getItems().get(i).getMedia_type() == 2) {
            Log.d(TAG, response.getItems().get(i).getView_count() + "");
          }
        }

        if (response.isMore_available()) {
          getFeed(false, mFeedResponseDataAll.getNext_max_id());
        } else {
          Log.d(TAG, String.format("getFeed request end and the size = %s ",
              mFeedResponseDataAll.getItems().size()));
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
   */
  private void getFeedLiked(boolean isFirstPage, String nextMaxId) {

    if (isFirstPage) {
      mFeedResponseDataLiked.getItems().clear();
    }
    GetLikedFeedRequest getFeedLikedRequest = new GetLikedFeedRequest(isFirstPage, nextMaxId);
    getFeedLikedRequest.execute(new InsRequestCallBack<FeedResponseData>() {
      @Override
      public void onSuccess(int statusCode, FeedResponseData response) {
        Log.d(TAG, "getFeedLiked onSuccess ");
        mFeedResponseDataLiked.setAuto_load_more_enabled(response.isAuto_load_more_enabled());
        mFeedResponseDataLiked
            .setNum_results(response.getNum_results() + response.getNum_results());
        mFeedResponseDataLiked.setNext_max_id(response.getNext_max_id());
        mFeedResponseDataLiked.setMore_available(response.isMore_available());
        mFeedResponseDataLiked.getItems().addAll(response.getItems());

        if (response.isMore_available()) {
          getFeedLiked(false, mFeedResponseDataLiked.getNext_max_id());
        } else {
          Log.d(TAG, String.format("getFeedLiked request end and the size = %s ",
              mFeedResponseDataLiked.getItems().size()));
        }

      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "getFeedLiked onFailure = " + errorMsg);
      }
    });


  }


  /**
   * 获取Followers
   */
  private void getFollowers(boolean isFirstPage, String nextMaxId) {

    if (isFirstPage) {
      mFollowersResponseData.getUsers().clear();
    }
    String userId = IGCommonFieldsManager.getInstance().getPKID();
    String userId1 = " 7761457415";
    GetFollowersRequest getFollowersRequest = new GetFollowersRequest(isFirstPage, userId,
        nextMaxId);
    getFollowersRequest.execute(new InsRequestCallBack<FollowersResponseData>() {
      @Override
      public void onSuccess(int statusCode, FollowersResponseData response) {
        Log.d(TAG, "getFollowers onSuccess ");
        mFollowersResponseData.setBig_list(response.isBig_list());
        mFollowersResponseData.setNext_max_id(response.getNext_max_id());
        mFollowersResponseData
            .setPage_size(mFollowersResponseData.getPage_size() + response.getPage_size());
        mFollowersResponseData.getUsers().addAll(response.getUsers());

        if (!TextUtils.isEmpty(response.getNext_max_id())) {
          getFollowers(false, mFollowersResponseData.getNext_max_id());
        } else {
          Log.d(TAG, String.format("getFollowers request end and the size = %s ",
              mFollowersResponseData.getUsers().size()));
        }

      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "getFollowers onFailure = " + errorMsg);
      }
    });


  }

  /**
   * 获取Following
   */
  private void getFollowing(boolean isFirstPage, String nextMaxId) {

    if (isFirstPage) {
      mFollowingResponseData.getUsers().clear();
    }

    String userId = IGCommonFieldsManager.getInstance().getPKID();

    GetFollowingRequest request = new GetFollowingRequest(isFirstPage, userId, nextMaxId);
    request.execute(new InsRequestCallBack<FollowingResponseData>() {
      @Override
      public void onSuccess(int statusCode, FollowingResponseData response) {
        Log.d(TAG, "getFollowing onSuccess ");
        mFollowingResponseData.setBig_list(response.isBig_list());
        mFollowingResponseData.setNext_max_id(response.getNext_max_id());
        mFollowingResponseData
            .setPage_size(mFollowingResponseData.getPage_size() + response.getPage_size());
        mFollowingResponseData.getUsers().addAll(response.getUsers());

        if (!TextUtils.isEmpty(response.getNext_max_id())) {
          getFollowing(false, mFollowingResponseData.getNext_max_id());
        } else {
          Log.d(TAG, String.format("getFollowing request end and the size = %s ",
              mFollowingResponseData.getUsers().size()));
        }
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "getFollowers onFailure = " + errorMsg);
      }
    });


  }


  /**
   * 获取点赞信息
   */
  private void getMediaLikers() {
    List<FeedResponseData.ItemsBean> itemsBeanList = mFeedResponseDataAll.getItems();
    int size = itemsBeanList.size();
    getLikersCount = 0;
    getLikersCount_amount = 0;
    for (int i = 0; i < size; i++) {
      FeedResponseData.ItemsBean itemsBean = itemsBeanList.get(i);
      Log.d(TAG, "ItemsBean = " + itemsBean.getId());
      //getMediaLikers(itemsBean);
      getMediaLikersByItem(itemsBean);
    }
  }

  private int getLikersCount = 0;
  private int getLikersCount_amount = 0;

  /**
   * 获取某一条帖子的Likers
   */
  private void getMediaLikersByItem(final FeedResponseData.ItemsBean itemsBean) {

    GetMediaLikersRequest getMediaLikersRequest = new GetMediaLikersRequest(itemsBean.getId());
    getMediaLikersRequest.execute(new InsRequestCallBack<MediaLikersResponseData>() {
      @Override
      public void onSuccess(int statusCode, MediaLikersResponseData response) {
        itemsBean.getLikers().clear();
        itemsBean.getLikers().addAll(response.getUsers());
        getLikersCount++;
        getLikersCount_amount = getLikersCount_amount + response.getUser_count();

        Log.d(TAG,
            "getMediaLikers onSuccess,  getLikersCount=" + getLikersCount + ",response.getUsers() ="
                + response.getUsers().size() + ", " +
                "getLikersCount_amount =" + getLikersCount_amount);
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "getMediaLikers onFailure = " + errorMsg);
      }
    });


  }


  /**
   * 获取Comments
   */
  private void getMediaComments() {
    List<FeedResponseData.ItemsBean> itemsBeanList = mFeedResponseDataAll.getItems();
    int size = itemsBeanList.size();
    MediaComments = 0;
    MediaComments_amout = 0;
    for (int i = 0; i < size; i++) {
      FeedResponseData.ItemsBean itemsBean = itemsBeanList.get(i);
      Log.d(TAG, "ItemsBean =  " + itemsBean.getId());

      //getMediaComments(itemsBean);
      getMediaCommentsByItem(itemsBean);
    }
  }

  private int MediaComments = 0;
  private int MediaComments_amout = 0;


  private void getMediaCommentsByItem(final FeedResponseData.ItemsBean itemsBean) {

    GetMediaCommentsRequest commentsRequest = new GetMediaCommentsRequest(itemsBean.getId());
    commentsRequest.execute(new InsRequestCallBack<MediaCommentResponseData>() {
      @Override
      public void onSuccess(int statusCode, MediaCommentResponseData response) {

        itemsBean.getComments().clear();
        itemsBean.getComments().addAll(response.getComments());
        MediaComments++;
        MediaComments_amout = MediaComments_amout + response.getComment_count();
        Log.d(TAG, "getMediaComments onSuccess, " + MediaComments + ",MediaComments_amout="
            + MediaComments_amout);
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "getMediaLikers onFailure = " + errorMsg);
      }
    });

  }


  /**
   * 根据userId获取用户信息
   */
  private void getUserInfoByUserId(String userId) {
    UserInfoWithIDRequest userInfoRequest = new UserInfoWithIDRequest(userId);
    userInfoRequest.execute(new InsRequestCallBack<UserInfoResponseData>() {
      @Override
      public void onSuccess(int statusCode, UserInfoResponseData insBaseData) {
        Log.d(TAG, "getUserInfo onSuccess " + insBaseData.getUser().getUsername());
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "getUserInfo onFailure = " + errorMsg);
      }
    });
  }

  /**
   * 根据userName获取用户信息
   */
  private void getUserInfoByUserName(String userName) {
    UserInfoWithNameRequest userInfoRequest = new UserInfoWithNameRequest(userName);
    userInfoRequest.execute(new InsRequestCallBack<UserInfoResponseData>() {
      @Override
      public void onSuccess(int statusCode, UserInfoResponseData insBaseData) {
        Log.d(TAG, "getUserInfo onSuccess " + insBaseData.getUser().getUsername());
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "getUserInfo onFailure = " + errorMsg);
        //getUserInfo onFailure = {"message": "User not found", "status": "fail"}
      }
    });
  }

  private void getUserInfoByUserNameWeb(String userName) {
    UserInfoWebRequest webRequest = new UserInfoWebRequest();
    webRequest.execute(userName);
  }

  /**
   * 关注某人
   */
  private void followingCreate(String userId) {

    FollowingCreateRequest followingCreateRequest = new FollowingCreateRequest(userId);
    followingCreateRequest.execute(new InsRequestCallBack<FollowingCreateResponseData>() {
      @Override
      public void onSuccess(int statusCode, FollowingCreateResponseData insBaseData) {
        if (insBaseData.getFriendship_status().isFollowing()) {
          Log.d(TAG, "follow onSuccess ");
        } else {
          Log.d(TAG, "follow Failure ");
        }


      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "follow onFailure = " + errorMsg);
      }
    });
  }


  private void followingCreateUsers() {

  }


  /**
   * 取关某人
   */
  private void followingCancel(String userId) {

    FollowingCancelRequest followingCreateRequest = new FollowingCancelRequest(userId);
    followingCreateRequest.execute(new InsRequestCallBack<FollowingCancelResponseData>() {
      @Override
      public void onSuccess(int statusCode, FollowingCancelResponseData insBaseData) {
        if (insBaseData.getFriendship_status().isFollowing()) {
          Log.d(TAG, "unfollow onSuccess ");
        } else {
          Log.d(TAG, "unfollow onSuccess ");
        }
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "unfollow onFailure = " + errorMsg);
      }
    });
  }


  /**
   * 喜欢某条帖子
   */
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

  /**
   * 取消喜欢某条帖子
   */
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
