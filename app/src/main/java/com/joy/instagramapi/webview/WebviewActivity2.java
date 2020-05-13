package com.joy.instagramapi.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.joy.instagramapi.R;

/**
 * Created by Joy on 2019-08-16
 */
public class WebviewActivity2 extends AppCompatActivity {
  private WebView webView;
  private ProgressBar progressBar;
  private static String TAG  = "WebviewActivity";

  private String url = "";

  String insertJavaScript ="javascript:(function() { "

 +"document.getElementById(\"image\").style.display = 'none';（JS主要逻辑） "

 +"document.body.appendChild(script); "

 +"})();";






  public static void launch(Context context,String url) {
    Intent intent = new Intent(context, WebviewActivity2.class);
    intent.putExtra("url",url);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_webview);
    url = getIntent().getStringExtra("url");
    progressBar= (ProgressBar)findViewById(R.id.progressbar);//进度条

    webView = (WebView) findViewById(R.id.webview);
    webView.loadUrl(url);//加载url

    webView.setWebChromeClient(webChromeClient);
    webView.setWebViewClient(webViewClient);

    WebSettings webSettings=webView.getSettings();
    webSettings.setJavaScriptEnabled(true);//允许使用js
    String userAgentString = webSettings.getUserAgentString();
    Log.i(TAG, "userAgentString = " + userAgentString);
    webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//（默认）根据cache-control决定是否从网络上取数据。
     webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);  //不使用缓存:
    //支持屏幕缩放
    webSettings.setSupportZoom(true);
    webSettings.setBuiltInZoomControls(true);

  }

  ///WebViewClient主要帮助WebView处理各种通知、请求事件
  private WebViewClient webViewClient = new WebViewClient() {


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {//页面开始加载
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      Log.i(TAG, "拦截url:" + url);

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
//
//        webView.postDelayed(new Runnable() {
//          @Override
//          public void run() {
//            finish();
//          }
//        },3*1000);

      }
      //csrftoken，userid，rur，urlgen，sessionid，shbid，shbts，mid

//      webView.loadUrl("javascript:" + "window.alert('Js injection success')" );
     // webView.loadUrl("javascript:" + "function waitForSelector(e){return new Promise(t=>{const l=setInterval(()=>{document.querySelectorAll(e).length>0&&(clearInterval(l),t(document.querySelectorAll(e)))},500)})}function setValue(e,t){let l=e.value;e.value=t;let n=new Event(\"input\",{bubbles:!0});n.simulated=!0;let a=e._valueTracker;a&&a.setValue(l),e.dispatchEvent(n)}function sleep(e){return new Promise(t=>{setTimeout(()=>{t()},e)})}!async function(){\"use strict\";function e(){waitForSelector('button[type=\"submit\"]').then(async e=>{if(e.length>1)return;setValue(document.querySelectorAll('input[name=\"username\"]')[0],\"hahali5\"),await sleep(1700),setValue(document.querySelectorAll('input[name=\"password\"]')[0],\"alskdj\"),await sleep(800),e[0].removeAttribute(\"disabled\"),e[0].click()})}console.log(\"ins login 789\"),waitForSelector('span>button[type=\"button\"]').then(async t=>{t.length>1||(await sleep(1100),t[0].click(),await sleep(1600),e())}),await sleep(100),e()}();" );
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


  };



  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK){//点击返回按钮的时候判断有没有上一页
      webView.goBack(); // goBack()表示返回webView的上一页面
      return true;
    }
    return super.onKeyDown(keyCode,event);
  }



  @Override
  protected void onDestroy() {
    super.onDestroy();
    //释放资源
    webView.destroy();
    webView=null;
  }
}
