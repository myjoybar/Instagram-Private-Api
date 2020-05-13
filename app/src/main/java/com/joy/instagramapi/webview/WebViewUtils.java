package com.joy.instagramapi.webview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.joy.insapi.manager.IGCommonFieldsManager;
import com.joy.instagramapi.webview.data.TransmitInfo;
import com.joy.instagramapi.webview.data.TransmitInfo.Birth;
import com.joy.libok.OkHttpManager;
import com.joy.libok.response.responsehandler.StringResponseHandler;
import java.util.ArrayList;
import java.util.List;
import me.dt.libbase.mmkv.MMKVManager;
import okhttp3.Cookie;
import okhttp3.internal.http.HttpDate;

/**
 * Created by Joy on 2020-03-27
 */
public class WebViewUtils {

  private static String TAG = "WebviewActivity";
  //0327 public static String cookieStrTemp = "ig_did=5370BF88-5169-4CC7-AF2E-4AF8B4FA000A; mid=Xn3pPQABAAFCJsnT-9-KMIwRh3eU; csrftoken=YWGOjvDDwHUCj6kA1sGwYRblPQypkaWP; shbid=14271; shbts=1585310109.4845276; ds_user_id=18093275983; sessionid=18093275983%3AESBOdptP1w3KR8%3A10; rur=VLL; urlgen=\"{\\\"13.52.168.85\\\": 16509}:1jHnnU:gPEoUqMyZYQmD-4MhPyrWl1pxEM\"";
  //0328 public static String cookieStrTemp =  ig_did=5370BF88-5169-4CC7-AF2E-4AF8B4FA000A; mid=Xn3pPQABAAFCJsnT-9-KMIwRh3eU; csrftoken=YWGOjvDDwHUCj6kA1sGwYRblPQypkaWP; shbid=14271; shbts=1585310109.4845276; ds_user_id=18093275983; sessionid=18093275983%3AESBOdptP1w3KR8%3A10; rur=VLL; urlgen="{\"13.52.168.85\": 16509}:1jI0X9:KD3zOL2vLt9uKGnLb6dmo_Z1m3U"

  public static String MK_KEY_COOKIE = "mk_key_cookieStr";


  public static String getUserAgent(Context context) {

    try {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        return WebSettings.getDefaultUserAgent(context);
      } else {
        WebView webview = new WebView(context);
        String userAgent = webview.getSettings().getUserAgentString();
        webview.removeAllViews();
        webview.destroy();
        webview = null;
        return userAgent;
      }
    } catch (Throwable e) {
      return "";
    }

  }

  //cookie的domain和path与请求的URL匹配才会发送这个cookie。

  public static void saveAndHandleInsFirstWebViewOpenCookies(String cookieStr) {
    //Cookies = ig_did=19759F29-BDDF-49EA-AFB1-D98E0A793B85; csrftoken=mcWWRPMxAqitpAxR8yjgIuDGTBtLOth7; rur=FRC; mid=XnyXEgABAAHl-YaA_jV7COb4hmYO
    // String cookieStr = "ig_did=19759F29-BDDF-49EA-AFB1-D98E0A793B85; mid=XnyXEgABAAHl-YaA_jV7COb4hmYO; csrftoken=5lA5Bm4fI09rVpD85OCUk6HIKQApIjQI; shbid=14271; shbts=1585284594.5999696; ds_user_id=18093275983; sessionid=18093275983%3AC4znuWtmXnQSho%3A11; rur=VLL; urlgen=\"{\\\"13.52.168.85\\\": 16509}:1jHh94:TTPijHNlYfpvgrnjCFx5piYBcXI\"";
//    IGConfig.getHeaders().put("Cookie",cookieStr);
    MMKVManager.getInstance().put(MK_KEY_COOKIE, cookieStr);
    String cookieStrTemp = cookieStr.replace(" ", "");
    String[] cookies = cookieStrTemp.split(";");

    // just for printing
    for (int i = 0; i < cookies.length; i++) {
      String str = cookies[i];
      int indexSplit = str.indexOf("=");
      String cookieName = str.substring(0, indexSplit);
      String cookieValue = str.substring(indexSplit + 1, str.length());
      //重置csrftoken
      if (cookieName.equals("csrftoken")) {
        IGCommonFieldsManager.getInstance().saveCsrftoken(cookieValue);
      }
      //获取PK，Web cookie的ds_user_id就是私有API的PK
      if (cookieName.equals("ds_user_id")) {
        IGCommonFieldsManager.getInstance().savePKID(cookieValue);
      }
      Log.d(TAG, "key = " + cookieName + ", cookieValue = " + cookieValue);
    }

    tryToOpenInsWebPage();


  }


  public static List<Cookie> getWebAPICookies() {

    List<Cookie> cookieList = new ArrayList<>();
    String cookieLocal = MMKVManager.getInstance().getString(MK_KEY_COOKIE, "");
    if (!TextUtils.isEmpty(cookieLocal)) {
      String cookieStr = cookieLocal.replace(" ", "");
      String[] cookies = cookieStr.split(";");
      for (int i = 0; i < cookies.length; i++) {
        String str = cookies[i];
        int indexSplit = str.indexOf("=");
        String cookieName = str.substring(0, indexSplit);
        String cookieValue = str.substring(indexSplit + 1, str.length());

        //重置csrftoken
        if (cookieName.equals("csrftoken")) {
          IGCommonFieldsManager.getInstance().saveCsrftoken(cookieValue);
          // Log.d(TAG, "ds_user_id = " + cookieValue);
        }
        //获取PK，Web cookie的ds_user_id就是私有API的PK
        if (cookieName.equals("ds_user_id")) {
          IGCommonFieldsManager.getInstance().savePKID(cookieValue);
          //Log.d(TAG, "pkId = " + cookieValue);
        }
        Log.d(TAG, "key = " + cookieName + ", cookieValue = " + cookieValue);

        //
        Cookie.Builder builder = new Cookie.Builder();
        builder.name(cookieName);
        builder.value(cookieValue);
//      builder.expiresAt(System.currentTimeMillis()+3600*24*3650);
        builder.expiresAt(HttpDate.MAX_DATE);

        builder.domain("instagram.com");
        builder.path("/");
        builder.secure();
        builder.httpOnly();
//      builder.hostOnlyDomain()
        cookieList.add(builder.build());

      }

    }

    return cookieList;

  }


  /**
   * 连接i.instagram.com，并在CustomPersistentCookieJar$saveFromResponse中，把cookie写入
   */
  public static void tryToOpenInsWebPage() {
    OkHttpManager.getInstance()
        .get("https://i.instagram.com/").execute(new StringResponseHandler() {
      @Override
      public void onSuccess(int statusCode, String response) {
        Log.d(TAG, "tryToOpenInsWebPage onSuccess ");

      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        super.onFailure(errorCode, errorMsg);
        Log.d(TAG, "tryToOpenInsWebPage onFailure  " + errorMsg);
      }
    });
  }


//  public static void handleRegisterAndLoginProcedure(WebView webView) {
//
//    passingRegisterParameter(webView);
//  }


  public static void loadInsHomePage(WebView webView){
    String url = "https://www.instagram.com/";
    webView.loadUrl(url);
  }

  public static void loadInsFollowPage(WebView webView,String userName){
    String url = "https://www.instagram.com/"+userName;
    webView.loadUrl(url);
  }

  public static void loadInsLikePage(WebView webView,String shortCode){
    String url = "https://www.instagram.com/p/"+shortCode;
    webView.loadUrl(url);
  }



  public static void injectRegisterJs(WebView webView){
    webView.loadUrl(JsContent.CONTENT_REGISTER);
  }


  public static void injectLoginJs(WebView webView){
    webView.loadUrl(JsContent.CONTENT_LOGIN);
  }


  public static void injectFollowJs(WebView webView){
    webView.loadUrl(JsContent.CONTENT_LOGIN);
  }
  public static void injectLikeJs(WebView webView){
    webView.loadUrl(JsContent.CONTENT_LOGIN);
  }



  public static void passingRegisterParameter(final WebView webView) {
    TransmitInfo transmitInfo = new TransmitInfo();
    transmitInfo.setType("1001"); // "1001" 表示注册 "1002" 表示登录 "1003" 表示验证码
    transmitInfo.setUserName("IgHally2020");
    transmitInfo.setFullName("IgHally2020");
    transmitInfo.setPwd("123456.ig");
    transmitInfo.setPhoneNumber("13235383089");
    transmitInfo.setCountryCode("+1");
    TransmitInfo.Birth birth = new Birth("1995","06","08");
    transmitInfo.setBirth(birth);
    final String msg = parseBeanToGson(transmitInfo).toString();
    WebViewUtils.clientCallJs(webView, msg);


  }


  public static void passingLoginParameter(WebView webView) {

    TransmitInfo transmitInfo = new TransmitInfo();
    transmitInfo.setType("1002"); // "1001" 表示注册 "1002" 表示登录 "1003" 表示验证码
    transmitInfo.setUserName("IgHally20201");
    transmitInfo.setPwd("123456.ig");
    String msg = parseBeanToGson(transmitInfo).toString();
    WebViewUtils.clientCallJs(webView, msg);
  }


  public static void passingSmsCodeParameter(WebView webView,String smsCode) {

    TransmitInfo transmitInfo = new TransmitInfo();
    transmitInfo.setType("1003"); // "1001" 表示注册 "1002" 表示登录 "1003" 表示验证码
    transmitInfo.setSmsCode(smsCode);
    String msg = parseBeanToGson(transmitInfo).toString();
    WebViewUtils.clientCallJs(webView, msg);
  }

  private static void clientCallJs(WebView webView, String msg) {
    if (null == webView) {
      return;
    }
    final int version = Build.VERSION.SDK_INT;
    if (version <= 18) {
      webView.loadUrl("javascript:androidCallJS('" + msg + "')");
    } else {
      webView.evaluateJavascript("javascript:androidCallJS('" + msg + "')",
          new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
              Log.d(TAG, "Client call js result = " + value);
            }
          });
    }

  }

  private static JsonObject parseBeanToGson(Object obj) {
    Gson gson = new Gson();
    String jsonstr = gson.toJson(obj);
    JsonObject returnData = new JsonParser().parse(jsonstr).getAsJsonObject();
    return returnData;
  }

  public static <T> T parseJsonStrToBean(String jsonData, Class<T> type) {
    Gson gson = new Gson();
    T result = gson.fromJson(jsonData, type);
    return result;
  }



}
