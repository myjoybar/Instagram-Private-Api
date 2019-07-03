package com.joy.insapi.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class IGConfig {

  private static final Map<String, String> HEADER_MAP = new HashMap<>();
  private static final List<String> RANDOM_DEVICES = new ArrayList<>();
  public static String USER_AGENT = "";
  public static final String API_V1 = "https://i.instagram.com/api/v1/";
  public static final String API_V2 = "https://i.instagram.com/api/v2/";

  public static final String ACTION_GET_HEADER = "si/fetch_headers/?challenge_type=signup&guid=%s"; //获取token
  public static final String ACTION_LOGIN = "accounts/login/"; //登录
  public static final String ACTION_LOGIN_TWO_FACTOR = "accounts/two_factor_login/"; //登录
  public static final String ACTION_GET_FEED = "feed/user/%s/";//获取post
  public static final String ACTION_GET_FEED_LIKED = "feed/liked/";//获取喜欢的post
  public static final String ACTION_GET_FOLLOWERS = "friendships/%s/followers/";//获取followers
  public static final String ACTION_GET_FOLLOWING = "friendships/%s/following/";//获取following
  public static final String ACTION_GET_FOLLOWING_CANCEL = "friendships/destroy/%s/";//关注某人
  public static final String ACTION_GET_FOLLOWING_CREATE = "friendships/create/%s/";//取关某人
  public static final String ACTION_GET_MEDIA_LIKERS = "media/%s/likers/";//获取某条post的followers
  public static final String ACTION_GET_MEDIA_COMMENTS = "media/%s/comments/";//获取某条post的comment
  public static final String ACTION_GET_MEDIA_LIKE = "media/%s/like/";//like某条post
  public static final String ACTION_GET_MEDIA_UNLIKE = "media/%s/unlike/";//unlike某条post
  public static final String ACTION_GET_USER_INFO_WITH_ID = "users/%s/info/";//根据userId获取用户信息
  public static final String ACTION_GET_USER_INFO_WITH_USER_NAME = "users/%s/usernameinfo/";//根据userName获取用户信息


  public static final String SIG_KEY_VERSION = "4";
  public static final String IG_SIG_KEY = "4f8732eb9ba7d1c8e8897a75d6474d4eb3f5279137431b2aafb71fafe2abe178";
  public static final String USER_AGENT_FORMAT = "Instagram %s Android (%s/%s; %s; %s; %s; %s; %s; %s; %s; %s)";
  public static final String IG_VERSION = "76.0.0.15.395";
  public static final String VERSION_CODE = "138226743";
  public static final String USER_AGENT_LOCALE = "en_US"; // "language_COUNTRY".

  static {
    HEADER_MAP.put("Connection", "keep-alive");
    HEADER_MAP.put("Content-Type", "application/json");
    HEADER_MAP.put("X-IG-Connection-Type", "mobile(UMTS)");
    HEADER_MAP.put("X-IG-Capabilities", "3ToAAA==");
    HEADER_MAP.put("Accept-Language", "en-US");
    HEADER_MAP.put("User-Agent", USER_AGENT);
  }

  static {
    RANDOM_DEVICES.add("24/7.0; 380dpi; 1080x1920; OnePlus; ONEPLUS A3010; OnePlus3T; qcom");
    RANDOM_DEVICES.add("23/6.0.1; 640dpi; 1440x2392; LGE/lge; RS988; h1; h1");
    RANDOM_DEVICES.add("24/7.0; 640dpi; 1440x2560; HUAWEI; LON-L29; HWLON; hi3660");
    RANDOM_DEVICES.add("23/6.0.1; 640dpi; 1440x2560; ZTE; ZTE A2017U; ailsa_ii; qcom");
    RANDOM_DEVICES.add("23/6.0.1; 640dpi; 1440x2560; samsung; SM-G935F; hero2lte; samsungexynos8890");
    RANDOM_DEVICES.add("23/6.0.1; 640dpi; 1440x2560; samsung; SM-G930F; herolte; samsungexynos8890");

  }


  public static Map<String, String> getHeaders() {
    return HEADER_MAP;

  }


  static {
    int length = RANDOM_DEVICES.size();
    int index = new Random().nextInt(length);
    String userAgentStr = RANDOM_DEVICES.get(index);
    userAgentStr = userAgentStr.replace("/", ";");
    String[] deviceInfos = userAgentStr.split(";");
    USER_AGENT = String
        .format(USER_AGENT_FORMAT, IG_VERSION, deviceInfos[0], deviceInfos[1], deviceInfos[2],
            deviceInfos[3], deviceInfos[4],
            deviceInfos[5], deviceInfos[6], deviceInfos[7], USER_AGENT_LOCALE, VERSION_CODE);
  }


}
