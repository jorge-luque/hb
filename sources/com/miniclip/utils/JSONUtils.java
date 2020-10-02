package com.miniclip.utils;

import android.os.Bundle;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtils {
    public static Object wrap(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(wrap(Array.get(obj, i)));
                }
                return new JSONArray(arrayList);
            } else if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            } else {
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    JSONObject jSONObject = new JSONObject();
                    for (String str : bundle.keySet()) {
                        jSONObject.put(str, wrap(bundle.get(str)));
                    }
                    return jSONObject;
                } else if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short)) {
                    return obj;
                } else {
                    if (obj instanceof String) {
                        return obj;
                    }
                    if (obj.getClass().getPackage().getName().startsWith("java.")) {
                        return obj.toString();
                    }
                    return null;
                }
            }
        } catch (Exception unused) {
        }
    }
}
