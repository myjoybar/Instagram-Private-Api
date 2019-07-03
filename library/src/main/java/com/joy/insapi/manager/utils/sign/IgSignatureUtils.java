package com.joy.insapi.manager.utils.sign;

import com.joy.insapi.manager.IGConfig;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class IgSignatureUtils {

  public static String buildBodySignContent(String bodyContent) {
    String parsedData = null;
    try {
      parsedData = URLEncoder.encode(bodyContent, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    String signedBody = hmacSha256(IGConfig.IG_SIG_KEY, bodyContent);
    return String
        .format("ig_sig_key_version=%s&signed_body=%s.%s", IGConfig.SIG_KEY_VERSION, signedBody,
            parsedData);
    //return "ig_sig_key_version=" + IGConfig.SIG_KEY_VERSION + "&signed_body=" + signedBody + '.' + parsedData;

  }


  public static String hmacSha256(String key, String value) {
    return hmacSha(key, value, "HmacSHA256");
  }

  private static String hmacSha(String key, String value, String SHA_TYPE) {
    try {
      SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("UTF-8"), SHA_TYPE);
      Mac mac = Mac.getInstance(SHA_TYPE);
      mac.init(signingKey);
      byte[] rawHmac = mac.doFinal(value.getBytes("UTF-8"));

      byte[] hexArray = {(byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4', (byte) '5',
          (byte) '6', (byte) '7', (byte) '8',
          (byte) '9', (byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f'};
      byte[] hexChars = new byte[rawHmac.length * 2];
      for (int j = 0; j < rawHmac.length; j++) {
        int v = rawHmac[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
      }
      return new String(hexChars);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }


}
