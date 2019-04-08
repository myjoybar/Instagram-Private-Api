package com.joy.insapi.manager.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class IGUtils {

	public static String generateUuid(boolean dash) {
		String uuid = UUID.randomUUID().toString();
		if(dash) {
			return uuid;
		}
		uuid = uuid.replaceAll("-", "");
		return uuid;

	}

	public static String generateDeviceId(String username, String password) {
		String seed = md5hex(username + password);
		String volatileSeed = "12345";
		return "android-" + md5hex(seed + volatileSeed).substring(0, 16);
	}

	public static String md5hex(String source) {
		return digest("MD5", source);
	}

	protected static String digest(String codec, String source) {
		try {
			MessageDigest digest = MessageDigest.getInstance(codec);
			byte[] digestBytes = digest.digest(source.getBytes(Charset.forName("UTF-8")));
			return hexlate(digestBytes, digestBytes.length);
		} catch (NoSuchAlgorithmException var4) {
			throw new RuntimeException(codec + " codec not available");
		}
	}

	protected static String hexlate(byte[] bytes, int initialCount) {
		if (bytes == null) {
			return "";
		} else {
			int count = Math.min(initialCount, bytes.length);
			char[] chars = new char[count * 2];

			for(int i = 0; i < count; ++i) {
				int val = bytes[i];
				if (val < 0) {
					val += 256;
				}

				chars[2 * i] = "0123456789abcdef".charAt(val / 16);
				chars[2 * i + 1] = "0123456789abcdef".charAt(val % 16);
			}

			return new String(chars);
		}
	}

}
