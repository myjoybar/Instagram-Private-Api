package com.joy.insapi.manager.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 2017/7/27.
 */
public class IGGsonUtil {

  /**
   * 将Json数据解析成相应的映射对象
   *
   * @param jsonData the jsonData
   * @param type the class type
   * @param <T> the T
   * @return the object
   */
  public static <T> T parseJsonStrToBean(String jsonData, Class<T> type) {
    Gson gson = new Gson();
    T result = gson.fromJson(jsonData, type);
    return result;
  }

  /**
   * 将Json 数组数据解析成相应的映射对象
   *
   * @param jsonData the jsonData
   * @param type the type
   * @param <T> the T
   * @return the list
   */
  public static <T> List<T> parseJsonArrayStrToList(String jsonData, Class<T> type) {
    Gson gson = new Gson();
    List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {
    }.getType());
    return result;
  }

  /**
   * 将对象解析成Gson字符串
   *
   * @param objBean the objBean
   * @return the string
   */
  public static String parseBeanToStr(Object objBean) {
    Gson gson = new Gson();
    String obj = gson.toJson(objBean);
    return obj;
  }

  /**
   * 将对象解析成Gson对象
   *
   * @param obj the obj
   * @return the JsonObject
   */
  public static JsonObject parseBeanToGson(Object obj) {
    Gson gson = new Gson();
    String jsonStr = gson.toJson(obj);
    JsonObject returnData = new JsonParser().parse(jsonStr).getAsJsonObject();
    return returnData;
  }

  /**
   * 将List对象解析成Gson对象
   *
   * @param list the list
   * @param type the class type
   * @param <T> the T
   * @return the JsonArray
   */
  public static <T> JsonArray parseListBeanToGson(List<T> list, Class<T> type) {

    Gson gson = new Gson();
    String jsonstr = gson.toJson(list);
    JsonParser parser = new JsonParser();
    JsonArray Jarray = parser.parse(jsonstr).getAsJsonArray();
    for (JsonElement obj : Jarray) {
      T cse = gson.fromJson(obj, type);
      list.add(cse);
    }
    return Jarray;
  }

  /**
   *
   */
  public static <T> List<T> getObjectList(String jsonString, Class<T> cls) {
    List<T> list = new ArrayList<T>();
    try {
      Gson gson = new Gson();
      JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
      for (JsonElement jsonElement : arry) {
        list.add(gson.fromJson(jsonElement, cls));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

}
