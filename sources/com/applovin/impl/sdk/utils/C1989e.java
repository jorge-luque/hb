package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.e */
public class C1989e {
    /* renamed from: a */
    public static String m7827a(Collection<String> collection, int i) {
        return m7828a(collection, ",", i);
    }

    /* renamed from: a */
    static String m7828a(Collection<String> collection, String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("No glue specified");
        } else if (collection == null || collection.size() < 1) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String next : collection) {
                if (i2 >= i) {
                    break;
                }
                i2++;
                sb.append(next);
                sb.append(str);
            }
            if (sb.length() > str.length()) {
                sb.setLength(sb.length() - str.length());
            }
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static <T> List<T> m7829a() {
        return m7830a(-1);
    }

    /* renamed from: a */
    public static <T> List<T> m7830a(int i) {
        return i >= 0 ? Collections.synchronizedList(new ArrayList(i)) : Collections.synchronizedList(new ArrayList());
    }

    /* renamed from: a */
    public static List<String> m7831a(String str) {
        return m7832a(str, ",\\s*");
    }

    /* renamed from: a */
    public static List<String> m7832a(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : Arrays.asList(str.split(str2));
    }

    /* renamed from: a */
    public static List<String> m7833a(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String trim : list) {
            String trim2 = trim.trim();
            if (!TextUtils.isEmpty(trim2)) {
                arrayList.add(trim2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m7834a(K k, V v) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(k, v);
        return hashMap;
    }
}
