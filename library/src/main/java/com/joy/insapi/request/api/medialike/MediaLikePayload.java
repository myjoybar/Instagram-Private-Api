package com.joy.insapi.request.api.medialike;

/**
 * from php
 */
public class MediaLikePayload {

  private String _uid;
  private String _uuid;
  private String _csrftoken;
  private String media_id;
  private String radio_type = "wifi-none";
  private String module_name = "feed_timeline";

  public String get_uid() {
    return _uid;
  }

  public void set_uid(String _uid) {
    this._uid = _uid;
  }

  public String get_uuid() {
    return _uuid;
  }

  public void set_uuid(String _uuid) {
    this._uuid = _uuid;
  }

  public String get_csrftoken() {
    return _csrftoken;
  }

  public void set_csrftoken(String _csrftoken) {
    this._csrftoken = _csrftoken;
  }

  public String getMedia_id() {
    return media_id;
  }

  public void setMedia_id(String media_id) {
    this.media_id = media_id;
  }

  public String getRadio_type() {
    return radio_type;
  }

  public void setRadio_type(String radio_type) {
    this.radio_type = radio_type;
  }

  public String getModule_name() {
    return module_name;
  }

  public void setModule_name(String module_name) {
    this.module_name = module_name;
  }
}
