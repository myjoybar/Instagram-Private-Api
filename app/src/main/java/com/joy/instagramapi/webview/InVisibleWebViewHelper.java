package com.joy.instagramapi.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.joy.instagramapi.webview.data.TransmitInfo;

/**
 * Created by Joy on 2020-03-27
 */
public class InVisibleWebViewHelper {

  private static String TAG = "InVisibleWebViewHelper";

  private WebView webView;

  public static final String SCHEME = "js";
  public static final String AUTHOR = "funs";
  public static final String ARG = "arg";


  private static class InVisibleWebViewHelperHolder {

    private static InVisibleWebViewHelper INSTANCE = new InVisibleWebViewHelper();
  }

  public static InVisibleWebViewHelper getInstance() {
    return InVisibleWebViewHelperHolder.INSTANCE;
  }


  public void initWebView(Context context) {
    if (null == webView) {
      webView = new WebView(context.getApplicationContext());
      initWebViewSetting();
    }

  }


  private void initWebViewSetting() {

    webView.setWebChromeClient(webChromeClient);
    webView.setWebViewClient(webViewClient);
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);//允许使用js
    String userAgentString = webSettings.getUserAgentString();
    Log.i(TAG, "userAgentString = " + userAgentString);
    webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//（默认）根据cache-control决定是否从网络上取数据。
    // webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);  //不使用缓存:
    //支持屏幕缩放
    webSettings.setSupportZoom(true);
    webSettings.setBuiltInZoomControls(true);

  }


  public void loadUrl(String url) {
    //加载url
    webView.loadUrl(url);
  }


  //WebViewClient主要帮助WebView处理各种通知、请求事件
  private WebViewClient webViewClient = new WebViewClient() {


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {//页面开始加载
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      // //返回值是true的时候WebView打开，为false则系统浏览器或第三方浏览器打开。
      //            //如果要下载页面中的游戏或者继续点击网页中的链接进入下一个网页的话，
      //            重写此方法下，不然就会跳到手机自带的浏览器了，而不继续在你这个webview里面展现了
      CookieManager cookieManager = CookieManager.getInstance();
      String cookieStr = cookieManager.getCookie(url);
      Log.i(TAG, "shouldOverrideUrlLoading url  " + url + ", Cookies = " + cookieStr);
//      return super.shouldOverrideUrlLoading(view, url);
      view.loadUrl(url);
      return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
      CookieManager cookieManager = CookieManager.getInstance();
      String cookieStr = cookieManager.getCookie(url);
      Log.i(TAG, "onPageFinished url  " + url + ", Cookies = " + cookieStr);
           if (!TextUtils.isEmpty(cookieStr) && cookieStr.contains("ds_user_id")) {
        //表示web登录成功，并且获取到cookie
        //ig_did=19759F29-BDDF-49EA-AFB1-D98E0A793B85; mid=XnyXEgABAAHl-YaA_jV7COb4hmYO; csrftoken=5lA5Bm4fI09rVpD85OCUk6HIKQApIjQI; shbid=14271; shbts=1585284594.5999696; ds_user_id=18093275983; sessionid=18093275983%3AC4znuWtmXnQSho%3A11; rur=VLL; urlgen="{\"13.52.168.85\": 16509}:1jHh94:TTPijHNlYfpvgrnjCFx5piYBcXI"
        WebViewUtils.saveAndHandleInsFirstWebViewOpenCookies(cookieStr);
        //csrftoken，userid，rur，urlgen，sessionid，shbid，shbts，mid
//      webView.loadUrl("javascript:" + "window.alert('Js injection success')" );
      }

      // 注入jS

      WebViewUtils.injectRegisterJs(webView);
      //WebViewUtils.injectLoginJs(webView);

      super.onPageFinished(view, url);
    }


    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
      //handler.proceed();    //表示等待证书响应
      handler.cancel();      //表示挂起连接，为默认方式
      // handler.handleMessage(null);    //可做其他处理
    }


  };

  //WebChromeClient主要辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度等
  private WebChromeClient webChromeClient = new WebChromeClient() {
    //不支持js的alert弹窗，需要自己监听然后通过dialog弹窗
    @Override
    public boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(webView.getContext());
      localBuilder.setMessage(message).setPositiveButton("confirm", null);
      localBuilder.setCancelable(false);
      localBuilder.create().show();
      //注意:
      //必须要这一句代码:result.confirm()表示:
      //处理结果为确定状态同时唤醒WebCore线程
      //否则不能继续点击按钮
      result.confirm();
      return true;
    }

    //获取网页标题
    @Override
    public void onReceivedTitle(WebView view, String title) {
      super.onReceivedTitle(view, title);
      Log.i(TAG, "title: " + title);
    }

    //加载进度回调
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue,
        JsPromptResult result) {

      Log.d(TAG, "onJsPrompt message = " + message);
      Uri uri = Uri.parse(message);
      if (uri.getScheme().equals(SCHEME)) {
        if (uri.getAuthority().equals(AUTHOR)) {
          String value = uri.getQueryParameter(ARG);
          //js://funs?arg={"clientForwardPageType":"0"}
          if (!TextUtils.isEmpty(value)) {
            try {

              TransmitInfo transmitInfo = WebViewUtils
                  .parseJsonStrToBean(value, TransmitInfo.class);
              if ("2001".equals(transmitInfo.getType())){
                //注册成功
                Log.d(TAG, "register success： " + transmitInfo.toString());
              } else if ("2002".equals(transmitInfo.getType())){
                //登录成功
                Log.d(TAG, "login success： " + transmitInfo.toString());
              } else if ("2003".equals(transmitInfo.getType())){
                //获取验证码
                Log.d(TAG, "H5 need sms code ");
              } else if ("2004".equals(transmitInfo.getType())){
                //汇报异常
                Log.d(TAG, "H5 exception： " + transmitInfo.getErrorMsg());
              } else if ("2005".equals(transmitInfo.getType())){
                //表示H5页面log信息，字段：logInfo
                Log.d(TAG, "H5 log ino： " + transmitInfo.getLogInfo());
              } else if("2006".equals(transmitInfo.getType())){
                //表示Webview页面信息，字段：pageUrl
                Log.d(TAG, "H5 pageUrl： " + transmitInfo.getPageUrl());
              } else if ("2007".equals(transmitInfo.getType())){
                //表示Follow成功，字段：followUserName
                Log.d(TAG, "H5 Follow  success： " + transmitInfo.getFollowUserName());
              } else if ("2008".equals(transmitInfo.getType())){
                //表示Like成功，字段：likeShortCode
                Log.d(TAG, "H5 like  success： " + transmitInfo.getLikeShortCode());
              } else if ("2009".equals(transmitInfo.getType())){
                //表示注册js注入完成
                Log.d(TAG, "register js inject success,and start to pass  RegisterParameter");
                WebViewUtils.passingRegisterParameter(webView);
              } else if ("2010".equals(transmitInfo.getType())){
                //表示登录js注入完成
                Log.d(TAG, "login js inject success,and start to pass LoginParameter");
                WebViewUtils.passingLoginParameter(webView);
              }

            } catch (Exception e) {

            }

          }
          result.cancel();
          return true;
        }

      }
      return super.onJsPrompt(view, url, message, defaultValue, result);
    }
  };

  public void destroyWebView() {
    if (null != webView) {
      webView.destroy();
      webView = null;
    }

  }

  public WebView getWebView() {
    return webView;
  }
}

