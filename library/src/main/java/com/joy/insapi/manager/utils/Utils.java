package com.joy.insapi.manager.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.util.DisplayMetrics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/**
 * Created by Joy on 2019-06-24
 */
public class Utils {

  public static long getServerTime() {
    return System.currentTimeMillis() / 1000;
  }

  public static String generateUuid(boolean dash) {
    String uuid = UUID.randomUUID().toString();
    if (dash) {
      return uuid;
    }
    uuid = uuid.replaceAll("-", "");
    return uuid;

  }


  /**
   * 保护android id
   * @param context
   * @return
   */
  private static String getDeviceUUid(Context context)
  {
    String androidId = getAndroidID(context);
    UUID deviceUuid = new UUID(androidId.hashCode(), ((long)androidId.hashCode() << 32));
    return deviceUuid.toString();
  }

  public static String getUUID(Context context) {
    String uuid = getDeviceUUid(context);
    return uuid;
  }


  public static String getAndroidID(Context context) {
    String id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID );
    return id == null ? "" : id;
  }

  public static String getDevicePlatform() {
    return "Android";
  }

  /**
   * @return GMT+08:00
   */
  public static String getTimeZone() {
    TimeZone tz = TimeZone.getDefault();
    return tz.getDisplayName(false, TimeZone.SHORT);
  }

  /**
   * 获取时区
   *
   * @return eg: Asia/Shanghai
   */
  public static String getTimeId() {
    TimeZone tz = TimeZone.getDefault();
    return tz.getID();
  }

  /**
   * 获取country
   *
   * @return eg: CN
   */
  public static String getLocale(Context context) {
    String locale = context.getResources().getConfiguration().locale.getCountry();
    return locale;
  }

  /**
   * 获取语言
   *
   * @return eg: zh
   */
  public static String getLanguage() {
    return Locale.getDefault().getLanguage();
  }


  /**
   * 获取系统版本号
   *
   * @return eg: 6.0.1
   */

  public static String getSystemVersion() {
    return VERSION.RELEASE;

  }

  /**
   * 获取SDK CODE
   *
   * @return eg: 23
   */
  public static int getSDKInt() {
    return VERSION.SDK_INT;

  }



  /**
   * 获取设备当前的系统开发代号，一般使用REL代替
   *
   * @return arm64-v8a
   */
  public static String getCodeName() {
    return  android.os.Build.VERSION.CODENAME;
  }

  /**
   * 获取CPU指令集
   *
   * @return arm64-v8a
   */
  public static String getCpuAbi() {
    return android.os.Build.CPU_ABI;
  }

  /**
   * 获取CPU指令集2
   *
   * @return 手机型号   Nexus 5
   */
  public static String getCpuAbi2() {
    return android.os.Build.CPU_ABI2;
  }

  /**
   * 获取设备唯一识别码
   *
   * @return google/bullhead/bullhead:8.1.0/OPM4.171019.016.A1/4720815:user/release-keys
   */
  public static String getFingerprint() {
    return android.os.Build.FINGERPRINT;
  }


  /**
   * 获取硬件制造商
   *
   * @return LGE
   */
  public static String getManufacturer() {
    return android.os.Build.MANUFACTURER;
  }

  /**
   * 获取产品名称
   *
   * @return bullhead klteuc
   */
  public static String getProduct() {
    return android.os.Build.PRODUCT;
  }


  /**
   * 获取手机型号
   *
   * @return bullhead  klteatt
   */
  public static String getDevice() {
    return android.os.Build.DEVICE;
  }


  /**
   * 获取主板名称
   *
   * @return bullhead
   */
  public static String getBoard() {
    return android.os.Build.BOARD;
  }


  /**
   * 获取显示屏参数
   *
   * @return OPM4.171019.016.A1
   */
  public static String getDisplay() {
    return android.os.Build.DISPLAY;
  }


  /**
   * 获取手机型号
   *
   * @return 手机型号   Nexus 5
   */
  public static String getSystemModel() {
    return android.os.Build.MODEL;
  }


  /**
   * 获取手机厂商
   *
   * @return 手机厂商 google
   */
  public static String getDeviceBrand() {
    return android.os.Build.BRAND;
  }


  /**
   * 加密email,password
   */
  public static String encryptWithXOR(String str) {
    char[] chars = str.toCharArray();
    int length = chars.length;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int value = chars[i];
      Object obj = Integer.toHexString(value ^ 5);
      sb.append(obj.toString());
    }

    return sb.toString();

  }

  /**
   * 获取屏幕分辨率
   */
  public static int getWidthResolution(Context context) {
    DisplayMetrics dm = context.getResources().getDisplayMetrics();
    int width = dm.widthPixels;
    return width;
  }

  /**
   * 获取屏幕分辨率
   */
  public static int getHeightResolution(Context context) {
    DisplayMetrics dm = context.getResources().getDisplayMetrics();
    int height = dm.heightPixels;
    return height;
  }

  /**
   * 获取屏幕分辨率
   *
   * @return eg: 1080*1776
   */
  public static String getResolution(Context context) {
    DisplayMetrics dm = context.getResources().getDisplayMetrics();
    int height = dm.heightPixels;
    int width = dm.widthPixels;
    return width + "*" + height;
  }

  /* 获取 density
   * @param context
   * @return nexus5: 3.0
   */

  public static float getDensity(Context context) {
    DisplayMetrics dm = new DisplayMetrics();
    return context.getResources().getDisplayMetrics().density;
  }

  public static String getCpuName() {
    try {
      FileReader fr = new FileReader("/proc/cpuinfo");
      BufferedReader br = new BufferedReader(fr);
      String text = br.readLine();
      String[] array = text.split(":\\s+", 2);
      for (int i = 0; i < array.length; i++) {
      }
      return array[1];
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String[] getCpuInfo() {
    String str1 = "/proc/cpuinfo";
    String str2="";
    String[] cpuInfo={"",""};
    String[] arrayOfString;
    try {
      FileReader fr = new FileReader(str1);
      BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
      str2 = localBufferedReader.readLine();
      arrayOfString = str2.split("\\s+");
      for (int i = 2; i < arrayOfString.length; i++) {
        cpuInfo[0] = cpuInfo[0] + arrayOfString[i] + " ";
      }
      str2 = localBufferedReader.readLine();
      arrayOfString = str2.split("\\s+");
      cpuInfo[1] += arrayOfString[2];
      localBufferedReader.close();
    } catch (IOException e) {
    }
    return cpuInfo;
  }



}
