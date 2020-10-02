package com.ogury.crashreport;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: CrashReportDao.kt */
public final class fonttbl {

    /* renamed from: a */
    private final SharedPreferences f12205a;

    /* compiled from: CrashReportDao.kt */
    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte b) {
            this();
        }
    }

    static {
        new rtf1((byte) 0);
    }

    public fonttbl(Context context) {
        tx7920.m15333b(context, "context");
        this.f12205a = context.getSharedPreferences("crashreport", 0);
    }

    /* renamed from: a */
    public final void mo29597a(String str, String str2) {
        tx7920.m15333b(str, "key");
        tx7920.m15333b(str2, "uploadUrl");
        this.f12205a.edit().putString(str, str2).apply();
    }

    /* renamed from: a */
    public final String mo29596a(String str) {
        tx7920.m15333b(str, "key");
        String string = this.f12205a.getString(str, "");
        return string == null ? "" : string;
    }
}
