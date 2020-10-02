package com.ogury.crashreport;

import com.tapjoy.TapjoyConstants;
import java.io.File;
import org.json.JSONObject;

/* compiled from: CrashFormatter.kt */
public final class cocoasubrtf100 {

    /* renamed from: a */
    private String f12196a;

    /* renamed from: b */
    private String f12197b;

    /* renamed from: c */
    private final SdkInfo f12198c;

    /* compiled from: CrashFormatter.kt */
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

    public cocoasubrtf100(SdkInfo sdkInfo) {
        tx7920.m15333b(sdkInfo, "sdkInfo");
        this.f12198c = sdkInfo;
    }

    /* renamed from: a */
    public final ansi mo29593a(Throwable th, red255 red255, rtf1 rtf12, Helvetica helvetica) {
        boolean z;
        String str;
        tx7920.m15333b(th, "throwable");
        tx7920.m15333b(red255, "phoneInfo");
        tx7920.m15333b(rtf12, "appInfo");
        tx7920.m15333b(helvetica, "fileStore");
        File[] a = helvetica.mo29578a();
        StackTraceElement[] stackTrace = th.getStackTrace();
        tx7920.m15330a((Object) stackTrace, "throwable.stackTrace");
        this.f12196a = pard.m15303a((Object[]) stackTrace, (CharSequence) "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (tx7200) null, 62);
        int length = a.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            File file = a[i];
            String str2 = this.f12196a;
            if (str2 == null) {
                tx7920.m15331a("stackTrace");
            }
            String name = file.getName();
            tx7920.m15330a((Object) name, "file.name");
            if (C4457hh.m15301a(str2, name, false, 2)) {
                String name2 = file.getName();
                tx7920.m15330a((Object) name2, "file.name");
                this.f12197b = name2;
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            return colortbl.f12199a;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("created_at", System.currentTimeMillis());
        jSONObject.put("sdk_version", this.f12198c.getSdkVersion());
        jSONObject.put(TapjoyConstants.TJC_API_KEY, this.f12198c.getApiKey());
        jSONObject.put("aaid", this.f12198c.getAaid());
        jSONObject.put("package_name", rtf12.mo29613b());
        jSONObject.put("package_version", rtf12.mo29612a());
        String a2 = red255.mo29609a();
        if (a2.length() > 16) {
            if (a2 != null) {
                a2 = a2.substring(0, 16);
                tx7920.m15330a((Object) a2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new margl1440("null cannot be cast to non-null type java.lang.String");
            }
        }
        jSONObject.put("phone_model", a2);
        jSONObject.put("android_version", red255.mo29610b());
        jSONObject.put("exception_type", th.getClass().getCanonicalName());
        green255 c = red255.mo29611c();
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        sb.append(" : ");
        sb.append(th.getMessage());
        if (c.mo29604d()) {
            str = " : Free[" + c.mo29601a() + "] Total[" + c.mo29602b() + "] Max[" + c.mo29603c() + "]";
        } else {
            str = "";
        }
        sb.append(str);
        jSONObject.put("message", sb.toString());
        String str3 = this.f12196a;
        if (str3 == null) {
            tx7920.m15331a("stackTrace");
        }
        jSONObject.put("stacktrace", str3);
        String jSONObject2 = jSONObject.toString();
        tx7920.m15330a((Object) jSONObject2, "jsonObject.toString()");
        String str4 = this.f12197b;
        if (str4 == null) {
            tx7920.m15331a("packageName");
        }
        return new blue255(jSONObject2, str4);
    }
}
