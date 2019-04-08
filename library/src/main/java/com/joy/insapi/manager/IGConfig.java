package com.joy.insapi.manager;

import java.util.HashMap;
import java.util.Random;

public class IGConfig {

	private static HashMap<String, String> HEADER_MAP;
	public static final String API_V1 = "https://i.instagram.com/api/v1/";
	public static final String API_V2 = "https://i.instagram.com/api/v2/";

	public static final String ACTION_GET_HEADER = "si/fetch_headers/?challenge_type=signup&guid=%s"; //获取token
	public static final String ACTION_LOGIN = "accounts/login/"; //登录
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
	public static final String ACTION_GET_USER_INFO = "users/%s/info/";//根据userId获取用户信息

	//======constant====

	public static String SIG_KEY_VERSION = "4";
	public static String IG_SIG_KEY = "4f8732eb9ba7d1c8e8897a75d6474d4eb3f5279137431b2aafb71fafe2abe178";
	public static String USER_AGENT_FORMAT = "Instagram %s Android (%s/%s; %s; %s; %s; %s; %s; %s; %s; %s)";
	public static String IG_VERSION = "76.0.0.15.395";
	public static String VERSION_CODE = "138226743";
	public static String USER_AGENT_LOCALE = "en_US"; // "language_COUNTRY".

	public static String getUserAgent() {
		int length = RANDOM_DEVICES.length;
		int index = new Random().nextInt(length);
		String userAgentStr = RANDOM_DEVICES[index];
		userAgentStr = userAgentStr.replace("/", ";");
		String[] deviceInfos = userAgentStr.split(";");
		return String.format(USER_AGENT_FORMAT, IG_VERSION, deviceInfos[0], deviceInfos[1], deviceInfos[2], deviceInfos[3], deviceInfos[4],
				deviceInfos[5], deviceInfos[6], deviceInfos[7], USER_AGENT_LOCALE, VERSION_CODE);
	}

	public static String[] RANDOM_DEVICES = {

			/* OnePlus 3T. Released: November 2016.
			* https://www.amazon.com/OnePlus-A3010-64GB-Gunmetal-International/dp/B01N4H00V8
			* https://www.handsetdetection.com/properties/devices/OnePlus/A3010
			*/
			"24/7.0; 380dpi; 1080x1920; OnePlus; ONEPLUS A3010; OnePlus3T; qcom",

			/* LG G5. Released: April 2016.
			 * https://www.amazon.com/LG-Unlocked-Phone-Titan-Warranty/dp/B01DJE22C2
			 * https://www.handsetdetection.com/properties/devices/LG/RS988
			 */
			"23/6.0.1; 640dpi; 1440x2392; LGE/lge; RS988; h1; h1",

			/* Huawei Mate 9 Pro. Released: January 2017.
			 * https://www.amazon.com/Huawei-Dual-Sim-Titanium-Unlocked-International/dp/B01N9O1L6N
			 * https://www.handsetdetection.com/properties/devices/Huawei/LON-L29
			 */
			"24/7.0; 640dpi; 1440x2560; HUAWEI; LON-L29; HWLON; hi3660",

			/* ZTE Axon 7. Released: June 2016.
			 * https://www.frequencycheck.com/models/OMYDK/zte-axon-7-a2017u-dual-sim-lte-a-64gb
			 * https://www.handsetdetection.com/properties/devices/ZTE/A2017U
			 */
			"23/6.0.1; 640dpi; 1440x2560; ZTE; ZTE A2017U; ailsa_ii; qcom",

			/* Samsung Galaxy S7 Edge SM-G935F. Released: March 2016.
			 * https://www.amazon.com/Samsung-SM-G935F-Factory-Unlocked-Smartphone/dp/B01C5OIINO
			 * https://www.handsetdetection.com/properties/devices/Samsung/SM-G935F
			 */
			"23/6.0.1; 640dpi; 1440x2560; samsung; SM-G935F; hero2lte; samsungexynos8890",

			/* Samsung Galaxy S7 SM-G930F. Released: March 2016.
			 * https://www.amazon.com/Samsung-SM-G930F-Factory-Unlocked-Smartphone/dp/B01J6MS6BC
			 * https://www.handsetdetection.com/properties/devices/Samsung/SM-G930F
			 */
			"23/6.0.1; 640dpi; 1440x2560; samsung; SM-G930F; herolte; samsungexynos8890"};


	public static HashMap<String, String> getHeadersPHp3() {

		if(null==HEADER_MAP){
			HEADER_MAP = new HashMap<>();
		}
		//headsMap.put("Connection","close");
		HEADER_MAP.put("Connection", "keep-alive");
		HEADER_MAP.put("Content-Type", "application/json");
		HEADER_MAP.put("X-IG-Connection-Type", "mobile(UMTS)");
		HEADER_MAP.put("X-IG-Capabilities", "3ToAAA==");
		HEADER_MAP.put("Accept-Language", "en-US");
		//headsMap.put("User-Agent", "Instagram 10.3.0 Android (18/4.3; 320dpi; 720x1280; Xiaomi; HM 1SW; armani; qcom; en_US)");
		HEADER_MAP.put("User-Agent", getUserAgent());
		return HEADER_MAP;

	}

}
