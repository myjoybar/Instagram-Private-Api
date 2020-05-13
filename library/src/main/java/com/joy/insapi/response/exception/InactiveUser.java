package com.joy.insapi.response.exception;

/**
 * Created by Joy on 2020-03-28
 */
public class InactiveUser {

  /**
   * message : Your account has been disabled for violating our terms. Learn how you may be able to restore your account.
   * help_url : https://help.instagram.com/521372114683554
   * error_type : inactive user
   * status : fail
   */

  private String message;
  private String help_url;
  private String error_type;
  private String status;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getHelp_url() {
    return help_url;
  }

  public void setHelp_url(String help_url) {
    this.help_url = help_url;
  }

  public String getError_type() {
    return error_type;
  }

  public void setError_type(String error_type) {
    this.error_type = error_type;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
