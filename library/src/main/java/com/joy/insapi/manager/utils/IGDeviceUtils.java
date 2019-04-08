package com.joy.insapi.manager.utils;

import android.content.Context;
import android.provider.Settings;

public class IGDeviceUtils {
	public static String getAndroidId(Context context) {
		return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
	}

}
