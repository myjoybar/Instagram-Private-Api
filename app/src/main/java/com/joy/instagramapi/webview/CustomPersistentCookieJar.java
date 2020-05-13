package com.joy.instagramapi.webview;

import android.text.TextUtils;
import android.util.Log;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * Created by Joy on 2020-03-27
 */
public class CustomPersistentCookieJar implements ClearableCookieJar {

  private static String TAG = "CustomPersistentCookieJar";

  private CookieCache cache;
  private CookiePersistor persistor;

  public CustomPersistentCookieJar(CookieCache cache, CookiePersistor persistor) {
    this.cache = cache;
    this.persistor = persistor;

    this.cache.addAll(persistor.loadAll());
  }

  @Override
  synchronized public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

    Log.d(TAG, "url = " + url);
    List<Cookie> cookiesWeb = WebViewUtils.getWebAPICookies();
    if (!TextUtils.isEmpty(url.host()) && url.host().contains("instagram.com")) {
      cookiesWeb.addAll(cookies);
    }
    cache.addAll(cookiesWeb);
    persistor.saveAll(filterPersistentCookies(cookiesWeb));

  }

  private static List<Cookie> filterPersistentCookies(List<Cookie> cookies) {
    List<Cookie> persistentCookies = new ArrayList<>();

    for (Cookie cookie : cookies) {
      if (cookie.persistent()) {
        persistentCookies.add(cookie);
      }
    }
    return persistentCookies;
  }

  @Override
  synchronized public List<Cookie> loadForRequest(HttpUrl url) {
    List<Cookie> cookiesToRemove = new ArrayList<>();
    List<Cookie> validCookies = new ArrayList<>();

    for (Iterator<Cookie> it = cache.iterator(); it.hasNext(); ) {
      Cookie currentCookie = it.next();

      if (isCookieExpired(currentCookie)) {
        cookiesToRemove.add(currentCookie);
        it.remove();

      } else if (currentCookie.matches(url)) {
        validCookies.add(currentCookie);
      }
    }

    persistor.removeAll(cookiesToRemove);

    return validCookies;
  }

  private static boolean isCookieExpired(Cookie cookie) {
    return cookie.expiresAt() < System.currentTimeMillis();
  }

  @Override
  synchronized public void clearSession() {
    cache.clear();
    cache.addAll(persistor.loadAll());
  }

  @Override
  synchronized public void clear() {
    cache.clear();
    persistor.clear();
  }
}
