package com.tapjoy;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.reflect.Method;

public class TapjoyAdIdClient {

    /* renamed from: a */
    private Context f13130a;

    /* renamed from: b */
    private String f13131b;

    /* renamed from: c */
    private boolean f13132c;

    public TapjoyAdIdClient(Context context) {
        this.f13130a = context;
    }

    public String getAdvertisingId() {
        return this.f13131b;
    }

    public boolean isAdTrackingEnabled() {
        return this.f13132c;
    }

    public boolean setupAdIdInfo() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f13130a);
            this.f13131b = advertisingIdInfo.getId();
            this.f13132c = !advertisingIdInfo.isLimitAdTrackingEnabled();
            return true;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public boolean setupAdIdInfoReflection() {
        try {
            Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Method method = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class});
            TapjoyLog.m16649d("TapjoyAdIdClient", "Found method: " + method);
            Object invoke = method.invoke(cls, new Object[]{this.f13130a});
            Method method2 = invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
            Method method3 = invoke.getClass().getMethod("getId", new Class[0]);
            this.f13132c = !((Boolean) method2.invoke(invoke, new Object[0])).booleanValue();
            this.f13131b = (String) method3.invoke(invoke, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
