package com.joy.insapi.request;

import android.util.Log;
import com.google.gson.internal.$Gson$Types;
import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.manager.utils.IGGsonUtil;
import com.joy.insapi.manager.utils.sign.IgSignatureUtils;
import com.joy.insapi.response.InsBaseResponseData;
import com.joy.insapi.response.InsGsonResponseHandler;
import com.joy.libok.OkHttpManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.MediaType;

public abstract class InsBasePostRequest<T, R extends InsBaseResponseData> extends
    InsBaseRequest<R> {

  private static final String TAG = "InsBasePostRequest";
  private static final MediaType MEDIA_TYPE_FORM = MediaType
      .parse("application/x-www-form-urlencoded; charset=utf-8");//mdiatype 这个需要和服务端保持一致

  protected abstract T getRequestData();


  @Override
  void execute() {

    String payload = IgSignatureUtils
        .buildBodySignContent(IGGsonUtil.parseBeanToStr(getRequestData()));
    OkHttpManager.getInstance()
        .postBodyContent(getRequestUrl())
        .addMediaType(MEDIA_TYPE_FORM)
        .addBodyContent(payload)
        .addHeaders(IGConfig.getHeaders())
        .tag(getTag())
        .execute(new InsGsonResponseHandler<R>(getType()) {
          @Override
          public void onSuccess(int statusCode, R insBaseData) {
            Log.d(TAG,
                String.format("request %s success, statusCode = %s", getActionUrl(), statusCode));
            if (null != mInsRequestCallBack) {
              mInsRequestCallBack.onSuccess(statusCode, insBaseData);
            }
          }

          @Override
          public void onFailure(int errorCode, String errorMsg) {
            super.onFailure(errorCode, errorMsg);
            if (null != mInsRequestCallBack) {
              mInsRequestCallBack.onFailure(errorCode, errorMsg);
            }
          }
        });
  }

  protected Type getType() {
    Class<?> classZ = getClass();
    Type type = classZ.getGenericSuperclass();
    if (type instanceof Class) {
      throw new RuntimeException("miss the type parameter");
    }
    ParameterizedType parameter = (ParameterizedType) type;
    return $Gson$Types.canonicalize(parameter.getActualTypeArguments()[1]);
  }


}
