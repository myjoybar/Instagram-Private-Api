package com.joy.instagramapi.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.joy.instagramapi.R;

/**
 * Created by Joy on 2019-08-16
 */
public class WebviewActivity extends AppCompatActivity {
  private WebView webView;
  private ProgressBar progressBar;
  private static String TAG  = "WebviewActivity";
  private FrameLayout fl;

  private String url = "";

  String insertJavaScript ="javascript:(function() { "

 +"document.getElementById(\"image\").style.display = 'none';（JS主要逻辑） "

 +"document.body.appendChild(script); "

 +"})();";






  public static void launch(Context context,String url) {
    Intent intent = new Intent(context, WebviewActivity.class);
    intent.putExtra("url",url);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_webview);
    url = getIntent().getStringExtra("url");
    progressBar= (ProgressBar)findViewById(R.id.progressbar);//进度条
    fl = findViewById(R.id.fl);
    InVisibleWebViewHelper.getInstance().initWebView(WebviewActivity.this);
    InVisibleWebViewHelper.getInstance().loadUrl(url);

    webView = InVisibleWebViewHelper.getInstance().getWebView();
    fl.addView(webView);

  }


}
