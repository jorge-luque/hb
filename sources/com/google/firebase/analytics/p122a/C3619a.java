package com.google.firebase.analytics.p122a;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.firebase.analytics.a.a */
public interface C3619a {

    @KeepForSdk
    /* renamed from: com.google.firebase.analytics.a.a$a */
    public static class C3620a {
        @KeepForSdk

        /* renamed from: a */
        public String f10139a;
        @KeepForSdk

        /* renamed from: b */
        public String f10140b;
        @KeepForSdk

        /* renamed from: c */
        public Object f10141c;
        @KeepForSdk

        /* renamed from: d */
        public String f10142d;
        @KeepForSdk

        /* renamed from: e */
        public long f10143e;
        @KeepForSdk

        /* renamed from: f */
        public String f10144f;
        @KeepForSdk

        /* renamed from: g */
        public Bundle f10145g;
        @KeepForSdk

        /* renamed from: h */
        public String f10146h;
        @KeepForSdk

        /* renamed from: i */
        public Bundle f10147i;
        @KeepForSdk

        /* renamed from: j */
        public long f10148j;
        @KeepForSdk

        /* renamed from: k */
        public String f10149k;
        @KeepForSdk

        /* renamed from: l */
        public Bundle f10150l;
        @KeepForSdk

        /* renamed from: m */
        public long f10151m;
        @KeepForSdk

        /* renamed from: n */
        public boolean f10152n;
        @KeepForSdk

        /* renamed from: o */
        public long f10153o;
    }

    @KeepForSdk
    /* renamed from: a */
    Map<String, Object> mo27197a(boolean z);

    @KeepForSdk
    /* renamed from: a */
    void mo27198a(C3620a aVar);

    @KeepForSdk
    /* renamed from: a */
    void mo27199a(String str, String str2, Object obj);

    @KeepForSdk
    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    @KeepForSdk
    List<C3620a> getConditionalUserProperties(String str, String str2);

    @KeepForSdk
    int getMaxUserProperties(String str);

    @KeepForSdk
    void logEvent(String str, String str2, Bundle bundle);
}
