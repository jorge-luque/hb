package com.qumpara.offerwall.sdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class QumparaOfferwallPreferences {
    static final String EMPTY_STRING = new JSONObject().toString();
    static final String KEY_OFFERWALL_IDENTIFIERS = "KEY_OFFERWALL_IDENTIFIERS";
    static final String KEY_QUMPARA_IMP_DATA = "KEY_QUMPARA_IMP_DATA";
    static final String KEY_QUMPARA_IMP_GET_SYNONYM = "KEY_QUMPARA_IMP_GET_SYNONYM";
    static final String KEY_QUMPARA_INCREMENT_SYNONYM = "KEY_QUMPARA_INCREMENT_SYNONYM";
    static final String KEY_QUMPARA_OFFERWALL_STATUS_JSON = "KEY_QUMPARA_OFFERWALL_STATUS_JSON";
    static final String KEY_QUMPARA_USER_ID = "KEY_QUMPARA_USER_ID";
    private static QumparaOfferwallPreferences instance;
    private static final Object lock = new Object();
    private SharedPreferences.Editor editor;
    private ThreadPoolExecutor executer = new ThreadPoolExecutor(10, 50, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(20));
    private SharedPreferences preferences;

    private QumparaOfferwallPreferences(Context context) {
        this.preferences = context.getSharedPreferences("QUMPARA_ADS", 0);
    }

    private SharedPreferences.Editor getEditor() {
        if (this.editor == null) {
            this.editor = this.preferences.edit();
        }
        return this.editor;
    }

    public static QumparaOfferwallPreferences getInstance(Context context) {
        QumparaOfferwallPreferences qumparaOfferwallPreferences = instance;
        if (qumparaOfferwallPreferences != null) {
            return qumparaOfferwallPreferences;
        }
        return newInstance(context);
    }

    public static QumparaOfferwallPreferences newInstance(Context context) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new QumparaOfferwallPreferences(context);
                }
            }
        }
        return instance;
    }

    private void set(String str, String str2) {
        getEditor().putString(str, str2);
        getEditor().apply();
    }

    /* access modifiers changed from: package-private */
    public JSONObject getCountDataForSending() throws Exception {
        int i = 1;
        int i2 = this.preferences.getInt(KEY_QUMPARA_IMP_GET_SYNONYM, 1);
        if (i2 == 1) {
            i = 2;
        }
        set(KEY_QUMPARA_INCREMENT_SYNONYM, i);
        return new JSONObject(this.preferences.getString(KEY_QUMPARA_IMP_DATA + i2, EMPTY_STRING));
    }

    /* access modifiers changed from: package-private */
    public JSONObject getCurrentCountData(String str) throws Exception {
        return new JSONObject(this.preferences.getString(str, EMPTY_STRING));
    }

    /* access modifiers changed from: package-private */
    public String getCurrentCountPreferenceKey() throws Exception {
        return KEY_QUMPARA_IMP_DATA + this.preferences.getInt(KEY_QUMPARA_INCREMENT_SYNONYM, 1);
    }

    public ThreadPoolExecutor getExecutor() {
        return this.executer;
    }

    public String getGUID() {
        String string = this.preferences.getString(KEY_QUMPARA_USER_ID, "");
        if (string.length() >= 1) {
            return string;
        }
        String hexString = Long.toHexString(Math.abs(new Random().nextLong() % 10000000000L));
        set(KEY_QUMPARA_USER_ID, hexString);
        return hexString;
    }

    /* access modifiers changed from: package-private */
    public String getItem(String str) {
        try {
            String string = this.preferences.getString(str, "");
            if (string.equals("")) {
                return null;
            }
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public QumparaOfferwallResponseCache getResponseCacheFromPrefs(String str) {
        try {
            String string = this.preferences.getString(str, "");
            if (string.length() > 0) {
                return new QumparaOfferwallResponseCache(string);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void putItem(String str, String str2) {
        if (getEditor() != null && str != null) {
            getEditor().putString(str, str2);
            getEditor().apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void removeCountData() {
        try {
            set(KEY_QUMPARA_IMP_DATA + this.preferences.getInt(KEY_QUMPARA_IMP_GET_SYNONYM, 1), new JSONObject().toString());
            set(KEY_QUMPARA_IMP_GET_SYNONYM, this.preferences.getInt(KEY_QUMPARA_INCREMENT_SYNONYM, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void setResponseCache(String str, QumparaOfferwallResponseCache qumparaOfferwallResponseCache) {
        if (getEditor() != null && qumparaOfferwallResponseCache != null && qumparaOfferwallResponseCache.getJsonObject() != null) {
            getEditor().putString(str, qumparaOfferwallResponseCache.getJsonObject().toString());
            getEditor().apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void storeCountData(String str, String str2) throws Exception {
        set(str, str2);
    }

    private void set(String str, int i) {
        getEditor().putInt(str, i);
        getEditor().apply();
    }

    private void set(String str, long j) {
        getEditor().putLong(str, j);
        getEditor().apply();
    }

    private void set(String str, boolean z) {
        getEditor().putBoolean(str, z);
        getEditor().apply();
    }
}
