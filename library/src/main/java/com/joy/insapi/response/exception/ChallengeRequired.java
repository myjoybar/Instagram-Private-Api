package com.joy.insapi.response.exception;

/**
 * Created by Joy on 2019-08-16
 */
public class ChallengeRequired {

  /**
   * message : challenge_required
   * challenge : {"url":"https://i.instagram.com/challenge/?next=/api/v1/si/fetch_headers/%253Fchallenge_type%253Dsignup%2526guid%253Db1fa7fd9fb274e29b5ea0e84ac59e381","api_path":"/challenge/","hide_webview_header":true,"lock":true,"logout":false,"native_flow":true}
   * status : fail
   */

  private String message;
  private ChallengeBean challenge;
  private String status;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ChallengeBean getChallenge() {
    return challenge;
  }

  public void setChallenge(ChallengeBean challenge) {
    this.challenge = challenge;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public static class ChallengeBean {

    /**
     * url : https://i.instagram.com/challenge/?next=/api/v1/si/fetch_headers/%253Fchallenge_type%253Dsignup%2526guid%253Db1fa7fd9fb274e29b5ea0e84ac59e381
     * api_path : /challenge/
     * hide_webview_header : true
     * lock : true
     * logout : false
     * native_flow : true
     */

    private String url;
    private String api_path;
    private boolean hide_webview_header;
    private boolean lock;
    private boolean logout;
    private boolean native_flow;

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public String getApi_path() {
      return api_path;
    }

    public void setApi_path(String api_path) {
      this.api_path = api_path;
    }

    public boolean isHide_webview_header() {
      return hide_webview_header;
    }

    public void setHide_webview_header(boolean hide_webview_header) {
      this.hide_webview_header = hide_webview_header;
    }

    public boolean isLock() {
      return lock;
    }

    public void setLock(boolean lock) {
      this.lock = lock;
    }

    public boolean isLogout() {
      return logout;
    }

    public void setLogout(boolean logout) {
      this.logout = logout;
    }

    public boolean isNative_flow() {
      return native_flow;
    }

    public void setNative_flow(boolean native_flow) {
      this.native_flow = native_flow;
    }
  }
}
