package com.joy.insapi.request.api.followingcancel;

/**
 * from php
 */
public class FollowingCancelPayload {

  private String _uid;
  private String _uuid;
  private String user_id;
  private String _csrftoken;
  private String radio_type = "wifi-none";

  public String get_uid() {
    return _uid;
  }

  public void set_uid(String _uid) {
    this._uid = _uid;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String get_csrftoken() {
    return _csrftoken;
  }

  public void set_csrftoken(String _csrftoken) {
    this._csrftoken = _csrftoken;
  }

  public String getRadio_type() {
    return radio_type;
  }

  public void setRadio_type(String radio_type) {
    this.radio_type = radio_type;
  }

  public String get_uuid() {
    return _uuid;
  }

  public void set_uuid(String _uuid) {
    this._uuid = _uuid;
  }
}
