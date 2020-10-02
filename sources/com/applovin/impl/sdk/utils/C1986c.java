package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.applovin.impl.sdk.C1977q;
import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: com.applovin.impl.sdk.utils.c */
public class C1986c {

    /* renamed from: a */
    private static C1986c f6641a;

    /* renamed from: b */
    private static final Object f6642b = new Object();

    /* renamed from: c */
    private final Bundle f6643c;

    /* renamed from: d */
    private final int f6644d;

    private C1986c(Context context) {
        Bundle bundle = null;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            C1977q.m7747c("AndroidManifest", "Failed to get meta data.", e);
        } catch (Throwable th) {
            this.f6643c = null;
            throw th;
        }
        this.f6643c = bundle;
        int i = 0;
        try {
            XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = openXmlResourceParser.getEventType();
            int i2 = 0;
            do {
                if (2 == eventType) {
                    try {
                        if (openXmlResourceParser.getName().equals("application")) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= openXmlResourceParser.getAttributeCount()) {
                                    break;
                                }
                                String attributeName = openXmlResourceParser.getAttributeName(i3);
                                String attributeValue = openXmlResourceParser.getAttributeValue(i3);
                                if (attributeName.equals("networkSecurityConfig")) {
                                    i2 = Integer.valueOf(attributeValue.substring(1)).intValue();
                                    break;
                                }
                                i3++;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i = i2;
                        try {
                            C1977q.m7747c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
                        } finally {
                            this.f6644d = i;
                        }
                    }
                }
                eventType = openXmlResourceParser.next();
            } while (eventType != 1);
            this.f6644d = i2;
        } catch (Throwable th3) {
            th = th3;
            C1977q.m7747c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
        }
    }

    /* renamed from: a */
    public static C1986c m7820a(Context context) {
        C1986c cVar;
        synchronized (f6642b) {
            if (f6641a == null) {
                f6641a = new C1986c(context);
            }
            cVar = f6641a;
        }
        return cVar;
    }

    /* renamed from: a */
    public String mo8769a(String str, String str2) {
        return this.f6643c.getString(str, str2);
    }

    /* renamed from: a */
    public boolean mo8770a() {
        return this.f6644d != 0;
    }

    /* renamed from: a */
    public boolean mo8771a(String str) {
        return this.f6643c.containsKey(str);
    }

    /* renamed from: a */
    public boolean mo8772a(String str, boolean z) {
        return this.f6643c.getBoolean(str, z);
    }
}
