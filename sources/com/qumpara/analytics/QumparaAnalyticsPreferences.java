package com.qumpara.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;

public class QumparaAnalyticsPreferences {
    static final String EMPTY_STRING = new JSONObject().toString();
    static final String KEY_QUMPARA_ANALYTICS_POST_DATA = "KEY_QUMPARA_ANALYTICS_POST_DATA_V2";
    private static final Object evenDataLock = new Object();
    private static QumparaAnalyticsPreferences instance;
    private static final Object lock = new Object();
    private SharedPreferences.Editor editor;
    private JSONArray eventData = getAllPostData();
    private SharedPreferences preferences;

    private QumparaAnalyticsPreferences(Context context) {
        this.preferences = context.getSharedPreferences("QUMPARA_ANALYTICS_V2", 0);
    }

    private SharedPreferences.Editor getEditor() {
        if (this.editor == null) {
            this.editor = this.preferences.edit();
        }
        return this.editor;
    }

    public static QumparaAnalyticsPreferences getInstance(Context context) {
        QumparaAnalyticsPreferences qumparaAnalyticsPreferences = instance;
        if (qumparaAnalyticsPreferences != null) {
            return qumparaAnalyticsPreferences;
        }
        return newInstance(context);
    }

    public static QumparaAnalyticsPreferences newInstance(Context context) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new QumparaAnalyticsPreferences(context);
                }
            }
        }
        return instance;
    }

    public JSONArray getAllPostData() {
        JSONArray jSONArray = this.eventData;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            String string = this.preferences.getString(KEY_QUMPARA_ANALYTICS_POST_DATA, (String) null);
            if (string == null) {
                return null;
            }
            return new JSONArray(string);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void keepPostData(JSONObject jSONObject) {
        if (this.eventData == null) {
            this.eventData = new JSONArray();
        }
        if (this.eventData.length() <= 100 && jSONObject != null) {
            synchronized (evenDataLock) {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i < this.eventData.length()) {
                        JSONObject optJSONObject = this.eventData.optJSONObject(i);
                        if (optJSONObject != null && jSONObject.optLong("unique_client_key") == optJSONObject.optLong("unique_client_key")) {
                            z = true;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (!z) {
                    this.eventData.put(jSONObject);
                    getEditor().putString(KEY_QUMPARA_ANALYTICS_POST_DATA, this.eventData.toString());
                    getEditor().apply();
                }
            }
        }
    }

    public void removePostData(JSONObject jSONObject) {
        boolean z;
        if (this.eventData != null && jSONObject != null) {
            synchronized (evenDataLock) {
                JSONArray jSONArray = new JSONArray();
                try {
                    if (jSONObject.has("events")) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("events");
                        if (!(this.eventData == null || this.eventData.length() == 0)) {
                            if (jSONArray2 != null) {
                                for (int i = 0; i < this.eventData.length(); i++) {
                                    long optLong = this.eventData.optJSONObject(i).optLong("unique_client_key", 0);
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= jSONArray2.length()) {
                                            z = false;
                                            break;
                                        }
                                        try {
                                            long optLong2 = jSONArray2.optJSONObject(i2).optLong("unique_client_key", 0);
                                            if (optLong != 0 && optLong == optLong2) {
                                                z = true;
                                                break;
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        i2++;
                                    }
                                    if (!z) {
                                        jSONArray.put(this.eventData.optJSONObject(i));
                                    }
                                }
                            }
                        }
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.eventData = jSONArray;
                getEditor().putString(KEY_QUMPARA_ANALYTICS_POST_DATA, this.eventData.toString());
                getEditor().apply();
            }
        }
    }
}
