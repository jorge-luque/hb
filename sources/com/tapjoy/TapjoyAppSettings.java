package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.internal.C3166jq;

public class TapjoyAppSettings {
    public static final String TAG = "TapjoyAppSettings";

    /* renamed from: b */
    private static TapjoyAppSettings f13133b;

    /* renamed from: a */
    String f13134a;

    /* renamed from: c */
    private Context f13135c;

    /* renamed from: d */
    private SharedPreferences f13136d;

    private TapjoyAppSettings(Context context) {
        this.f13135c = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
        this.f13136d = sharedPreferences;
        String string = sharedPreferences.getString(TapjoyConstants.PREF_LOG_LEVEL, (String) null);
        this.f13134a = string;
        if (!C3166jq.m10436c(string)) {
            String str = TAG;
            TapjoyLog.m16649d(str, "restoreLoggingLevel from sharedPref -- loggingLevel=" + this.f13134a);
            TapjoyLog.m16648a(this.f13134a, true);
        }
    }

    public static TapjoyAppSettings getInstance() {
        return f13133b;
    }

    public static void init(Context context) {
        TapjoyLog.m16649d(TAG, "initializing app settings");
        f13133b = new TapjoyAppSettings(context);
    }

    public void clearLoggingLevel() {
        SharedPreferences.Editor edit = this.f13136d.edit();
        edit.remove(TapjoyConstants.PREF_LOG_LEVEL);
        edit.apply();
        this.f13134a = null;
        boolean isLoggingEnabled = TapjoyLog.isLoggingEnabled();
        String str = TAG;
        StringBuilder sb = new StringBuilder("Tapjoy remote device debugging 'Disabled'. The SDK Debug-setting is: ");
        sb.append(isLoggingEnabled ? "'Enabled'" : "'Disabled'");
        TapjoyLog.m16652i(str, sb.toString());
        TapjoyLog.setDebugEnabled(isLoggingEnabled);
    }

    public String getConnectResult(String str, long j) {
        String string = this.f13136d.getString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, (String) null);
        if (!C3166jq.m10436c(string) && !C3166jq.m10436c(str) && str.equals(this.f13136d.getString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, (String) null))) {
            long j2 = this.f13136d.getLong(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES, -1);
            if (j2 < 0 || j2 >= j) {
                return string;
            }
        }
        return null;
    }

    public void removeConnectResult() {
        if (this.f13136d.getString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, (String) null) != null) {
            SharedPreferences.Editor edit = this.f13136d.edit();
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT);
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH);
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES);
            TapjoyLog.m16652i(TAG, "Removed connect result");
            edit.apply();
        }
    }

    public void saveConnectResultAndParams(String str, String str2, long j) {
        if (!C3166jq.m10436c(str) && !C3166jq.m10436c(str2)) {
            SharedPreferences.Editor edit = this.f13136d.edit();
            edit.putString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, str);
            edit.putString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, str2);
            if (j >= 0) {
                edit.putLong(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES, j);
            } else {
                edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES);
            }
            TapjoyLog.m16652i(TAG, "Stored connect result");
            edit.apply();
        }
    }

    public void saveLoggingLevel(String str) {
        if (C3166jq.m10436c(str)) {
            TapjoyLog.m16649d(TAG, "saveLoggingLevel -- server logging level is NULL or Empty string");
            return;
        }
        String str2 = TAG;
        TapjoyLog.m16649d(str2, "saveLoggingLevel -- currentLevel=" + this.f13134a + ";newLevel=" + str);
        if (C3166jq.m10436c(this.f13134a) || !this.f13134a.equals(str)) {
            SharedPreferences.Editor edit = this.f13136d.edit();
            edit.putString(TapjoyConstants.PREF_LOG_LEVEL, str);
            edit.apply();
            this.f13134a = str;
            TapjoyLog.m16648a(str, true);
        }
        boolean isLoggingEnabled = TapjoyLog.isLoggingEnabled();
        String str3 = TAG;
        StringBuilder sb = new StringBuilder("Tapjoy remote device debugging set to '");
        sb.append(str);
        sb.append("'. The SDK Debug-setting is: ");
        sb.append(isLoggingEnabled ? "'Enabled'" : "'Disabled'");
        TapjoyLog.m16652i(str3, sb.toString());
    }
}
