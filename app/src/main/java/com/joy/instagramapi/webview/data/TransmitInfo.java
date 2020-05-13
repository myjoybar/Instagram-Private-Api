package com.joy.instagramapi.webview.data;

import android.support.annotation.Keep;

/**
 * Created by Joy on 2020-04-07
 */
@Keep
public class TransmitInfo {

  private String type;
  private String userName;
  private String fullName;
  private String pwd;
  private String phoneNumber;
  private String smsCode;
  private String insid;
  private String avatar;
  private String bio;
  private Birth birth;
  private String countryCode = "+1"; //默认美国
  private String country = "us"; //默认美国
  private String url;
  private String errorMsg;
  private String logInfo;
  private String pageUrl;
  private String followUserName;
  private String likeShortCode;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getSmsCode() {
    return smsCode;
  }

  public void setSmsCode(String smsCode) {
    this.smsCode = smsCode;
  }

  public String getInsid() {
    return insid;
  }

  public void setInsid(String insid) {
    this.insid = insid;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Birth getBirth() {
    return birth;
  }

  public void setBirth(Birth birth) {
    this.birth = birth;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getLogInfo() {
    return logInfo;
  }

  public void setLogInfo(String logInfo) {
    this.logInfo = logInfo;
  }

  public String getPageUrl() {
    return pageUrl;
  }

  public void setPageUrl(String pageUrl) {
    this.pageUrl = pageUrl;
  }

  public String getFollowUserName() {
    return followUserName;
  }

  public void setFollowUserName(String followUserName) {
    this.followUserName = followUserName;
  }

  public String getLikeShortCode() {
    return likeShortCode;
  }

  public void setLikeShortCode(String likeShortCode) {
    this.likeShortCode = likeShortCode;
  }

  @Keep
  public static class Birth {

    public Birth(String year, String month, String day) {
      this.year = year;
      this.month = month;
      this.day = day;
    }

    String year;
    String month;
    String day;

    public String getYear() {
      return year;
    }

    public void setYear(String year) {
      this.year = year;
    }

    public String getMonth() {
      return month;
    }

    public void setMonth(String month) {
      this.month = month;
    }

    public String getDay() {
      return day;
    }

    public void setDay(String day) {
      this.day = day;
    }
  }

  @Override
  public String toString() {
    return "TransmitInfo{" +
        "type='" + type + '\'' +
        ", userName='" + userName + '\'' +
        ", fullName='" + fullName + '\'' +
        ", pwd='" + pwd + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", smsCode='" + smsCode + '\'' +
        ", insid='" + insid + '\'' +
        ", avatar='" + avatar + '\'' +
        ", bio='" + bio + '\'' +
        ", birth=" + birth +
        ", countryCode='" + countryCode + '\'' +
        ", country='" + country + '\'' +
        ", url='" + url + '\'' +
        ", errorMsg='" + errorMsg + '\'' +
        ", logInfo='" + logInfo + '\'' +
        ", pageUrl='" + pageUrl + '\'' +
        ", followUserName='" + followUserName + '\'' +
        ", likeShortCode='" + likeShortCode + '\'' +
        '}';
  }
}
