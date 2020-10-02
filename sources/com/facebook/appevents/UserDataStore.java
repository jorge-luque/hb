package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    private static final String DATA_SEPARATOR = ",";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    public static final String LAST_NAME = "ln";
    private static final int MAX_NUM = 5;
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    /* access modifiers changed from: private */
    public static final String TAG = "UserDataStore";
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public static AtomicBoolean initialized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public static SharedPreferences sharedPreferences;

    static void clear() {
        InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public void run() {
                if (!UserDataStore.initialized.get()) {
                    Log.w(UserDataStore.TAG, "initStore should have been called before calling setUserData");
                    UserDataStore.initAndWait();
                }
                UserDataStore.externalHashedUserData.clear();
                UserDataStore.sharedPreferences.edit().putString(UserDataStore.USER_DATA_KEY, (String) null).apply();
            }
        });
    }

    public static String getAllHashedUserData() {
        if (!initialized.get()) {
            initAndWait();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(externalHashedUserData);
        hashMap.putAll(internalHashedUserData);
        return Utility.mapToJsonStr(hashMap);
    }

    static String getHashedUserData() {
        if (!initialized.get()) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            initAndWait();
        }
        return Utility.mapToJsonStr(externalHashedUserData);
    }

    public static Map<String, String> getInternalHashedUserData() {
        if (!initialized.get()) {
            initAndWait();
        }
        return new HashMap(internalHashedUserData);
    }

    /* access modifiers changed from: private */
    public static synchronized void initAndWait() {
        synchronized (UserDataStore.class) {
            if (!initialized.get()) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                sharedPreferences = defaultSharedPreferences;
                String string = defaultSharedPreferences.getString(USER_DATA_KEY, "");
                String string2 = sharedPreferences.getString(INTERNAL_USER_DATA_KEY, "");
                externalHashedUserData.putAll(Utility.JsonStrToMap(string));
                internalHashedUserData.putAll(Utility.JsonStrToMap(string2));
                initialized.set(true);
            }
        }
    }

    static void initStore() {
        if (!initialized.get()) {
            initAndWait();
        }
    }

    private static boolean maybeSHA256Hashed(String str) {
        return str.matches("[A-Fa-f0-9]{64}");
    }

    private static String normalizeData(String str, String str2) {
        String str3;
        String lowerCase = str2.trim().toLowerCase();
        if (EMAIL.equals(str)) {
            if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                return lowerCase;
            }
            Log.e(TAG, "Setting email failure: this is not a valid email address");
            return "";
        } else if (PHONE.equals(str)) {
            return lowerCase.replaceAll("[^0-9]", "");
        } else {
            if (!GENDER.equals(str)) {
                return lowerCase;
            }
            if (lowerCase.length() > 0) {
                str3 = lowerCase.substring(0, 1);
            } else {
                str3 = "";
            }
            if ("f".equals(str3) || "m".equals(str3)) {
                return str3;
            }
            Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
            return "";
        }
    }

    public static void removeRules(List<String> list) {
        if (!initialized.get()) {
            initAndWait();
        }
        for (String next : list) {
            if (internalHashedUserData.containsKey(next)) {
                internalHashedUserData.remove(next);
            }
        }
        writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
    }

    static void setInternalUd(Map<String, String> map) {
        if (!initialized.get()) {
            initAndWait();
        }
        for (Map.Entry<String, String> key : map.entrySet()) {
            String str = (String) key.getKey();
            String sha256hash = Utility.sha256hash(normalizeData(str, map.get(str).trim()));
            if (internalHashedUserData.containsKey(str)) {
                String str2 = internalHashedUserData.get(str);
                String[] split = str2 != null ? str2.split(DATA_SEPARATOR) : new String[0];
                HashSet hashSet = new HashSet(Arrays.asList(split));
                if (!hashSet.contains(sha256hash)) {
                    StringBuilder sb = new StringBuilder();
                    if (split.length == 0) {
                        sb.append(sha256hash);
                    } else if (split.length < 5) {
                        sb.append(str2);
                        sb.append(DATA_SEPARATOR);
                        sb.append(sha256hash);
                    } else {
                        for (int i = 1; i < 5; i++) {
                            sb.append(split[i]);
                            sb.append(DATA_SEPARATOR);
                        }
                        sb.append(sha256hash);
                        hashSet.remove(split[0]);
                    }
                    internalHashedUserData.put(str, sb.toString());
                } else {
                    return;
                }
            } else {
                internalHashedUserData.put(str, sha256hash);
            }
        }
        writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
    }

    static void setUserDataAndHash(final Bundle bundle) {
        InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public void run() {
                if (!UserDataStore.initialized.get()) {
                    Log.w(UserDataStore.TAG, "initStore should have been called before calling setUserData");
                    UserDataStore.initAndWait();
                }
                UserDataStore.updateHashUserData(bundle);
                UserDataStore.writeDataIntoCache(UserDataStore.USER_DATA_KEY, Utility.mapToJsonStr(UserDataStore.externalHashedUserData));
                UserDataStore.writeDataIntoCache(UserDataStore.INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(UserDataStore.internalHashedUserData));
            }
        });
    }

    /* access modifiers changed from: private */
    public static void updateHashUserData(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (maybeSHA256Hashed(obj2)) {
                        externalHashedUserData.put(str, obj2.toLowerCase());
                    } else {
                        String sha256hash = Utility.sha256hash(normalizeData(str, obj2));
                        if (sha256hash != null) {
                            externalHashedUserData.put(str, sha256hash);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void writeDataIntoCache(final String str, final String str2) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                if (!UserDataStore.initialized.get()) {
                    UserDataStore.initAndWait();
                }
                UserDataStore.sharedPreferences.edit().putString(str, str2).apply();
            }
        });
    }

    static void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(EMAIL, str);
        }
        if (str2 != null) {
            bundle.putString(FIRST_NAME, str2);
        }
        if (str3 != null) {
            bundle.putString(LAST_NAME, str3);
        }
        if (str4 != null) {
            bundle.putString(PHONE, str4);
        }
        if (str5 != null) {
            bundle.putString(DATE_OF_BIRTH, str5);
        }
        if (str6 != null) {
            bundle.putString(GENDER, str6);
        }
        if (str7 != null) {
            bundle.putString(CITY, str7);
        }
        if (str8 != null) {
            bundle.putString(STATE, str8);
        }
        if (str9 != null) {
            bundle.putString(ZIP, str9);
        }
        if (str10 != null) {
            bundle.putString(COUNTRY, str10);
        }
        setUserDataAndHash(bundle);
    }
}