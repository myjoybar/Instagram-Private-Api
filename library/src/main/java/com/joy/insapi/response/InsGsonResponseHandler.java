package com.joy.insapi.response;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Types;
import com.joy.libok.handler.OKGlobalHandler;
import com.joy.libok.response.callback.IResponseCallBackHandler;
import com.joy.libok.test.log.LLog;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class InsGsonResponseHandler<T extends InsBaseResponseData> implements
    IResponseCallBackHandler {

  private static String TAG = "InsGsonResponseHandler";
  private static final String INS_API_SUCCESS_STATUS = "ok";
  private Type mType;

  private Type getType() {
    return mType;
  }

  public InsGsonResponseHandler() {
    generateType();
  }

  public InsGsonResponseHandler(Type type) {
    mType = type;
  }

  public void generateType() {
    Type type = getClass().getGenericSuperclass();
    if (type instanceof Class) {
      throw new RuntimeException("miss the type parameter");
    }
    ParameterizedType parameter = (ParameterizedType) type;
    mType = $Gson$Types.canonicalize(parameter.getActualTypeArguments()[0]);
  }

  @Override
  public void onStart() {

  }

  @Override
  public void onSuccess(final Response response) {
    ResponseBody responseBody = response.body();
    if (null == responseBody) {
      onFailure(0, "response.body is empty");
      return;
    }
    String responseBodyStr = "";
    try {
      responseBodyStr = responseBody.string();
    } catch (IOException e) {
      e.printStackTrace();
      onFailure(0,
          String.format("responseBody.string() occurs error, error msg = %s", e.getMessage()));
      return;
    } finally {
      responseBody.close();
    }
    LLog.d(TAG, "responseBody.string =   " + responseBodyStr);
    try {

      Gson gson = new Gson();
      final T insBaseData = (T) gson.fromJson(responseBodyStr, getType());
      OKGlobalHandler.getInstance().post(new Runnable() {
        @Override
        public void run() {
          LLog.d(TAG, "parse the json response data success");
          if (INS_API_SUCCESS_STATUS.equals(insBaseData.getStatus())) {
            onSuccess(response.code(), insBaseData);
          } else {
            onFailure(0, "the status is fail ");
          }
        }
      });


    } catch (final Exception e) {
      OKGlobalHandler.getInstance().post(new Runnable() {
        @Override
        public void run() {
          LLog.d(TAG, "parse the json response data  occurs error");
          onFailure(0, String
              .format("parse the json response data occurs error, error msg = %s", e.getMessage()));

        }
      });

    }
  }

  /**
   * {"message": "Your version of Instagram is out of date. Please upgrade your app to log in to
   * Instagram.", "status": "fail", "error_type": "needs_upgrade"}
   */
  @Override
  public void onFailure(int errorCode, String errorMsg) {
    LLog.e(TAG, String.format("errorCode= %s , errorMsg = %s", errorCode, errorMsg));
  }

  public abstract void onSuccess(int statusCode, T response);


  @Override
  public void onProgress(long currentBytes, long totalBytes) {

  }

  @Override
  public void onCancel() {

  }

  @Override
  public void onFinish() {

  }
}
