package com.silkimen.http;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {
  public static LinkedHashMap<String, String> getStringMap(JSONObject object)
      throws JSONException {
    LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

    if (object == null) {
      return map;
    }

    Iterator<?> i = object.keys();

    while (i.hasNext()) {
      String key = (String)i.next();
      map.put(key, object.getString(key));
    }
    return map;
  }

  public static LinkedHashMap<String, Object> getObjectMap(JSONObject object)
      throws JSONException {
    LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

    if (object == null) {
      return map;
    }

    Iterator<?> i = object.keys();

    while (i.hasNext()) {
      String key = (String)i.next();
      Object value = object.get(key);

      if (value instanceof JSONArray) {
        map.put(key, getObjectList((JSONArray)value));
      } else {
        map.put(key, object.get(key));
      }
    }
    return map;
  }

  public static ArrayList<Object> getObjectList(JSONArray array)
      throws JSONException {
    ArrayList<Object> list = new ArrayList<Object>();

    for (int i = 0; i < array.length(); i++) {
      list.add(array.get(i));
    }
    return list;
  }
}
