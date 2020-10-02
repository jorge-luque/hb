package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C2029r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppLovinSdkSettings {

    /* renamed from: a */
    private boolean f6801a;

    /* renamed from: b */
    private long f6802b;

    /* renamed from: c */
    private boolean f6803c;

    /* renamed from: d */
    private final Map<String, String> f6804d;

    /* renamed from: e */
    private List<String> f6805e;
    private final Map<String, Object> localSettings;

    public AppLovinSdkSettings() {
        this((Context) null);
    }

    public AppLovinSdkSettings(Context context) {
        this.localSettings = new HashMap();
        this.f6804d = new HashMap();
        this.f6805e = Collections.emptyList();
        this.f6801a = C2029r.m8015a(context);
        this.f6802b = -1;
    }

    @Deprecated
    public long getBannerAdRefreshSeconds() {
        return this.f6802b;
    }

    public List<String> getTestDeviceAdvertisingIds() {
        return this.f6805e;
    }

    public boolean isMuted() {
        return this.f6803c;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f6801a;
    }

    @Deprecated
    public void setBannerAdRefreshSeconds(long j) {
        this.f6802b = j;
    }

    public void setMuted(boolean z) {
        this.f6803c = z;
    }

    public void setTestDeviceAdvertisingIds(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (next == null || next.length() != 36) {
                    C1977q.m7751i("AppLovinSdkSettings", "Unable to set test device advertising id (" + next + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
                } else {
                    arrayList.add(next);
                }
            }
            this.f6805e = arrayList;
            return;
        }
        this.f6805e = Collections.emptyList();
    }

    public void setVerboseLogging(boolean z) {
        if (C2029r.m8013a()) {
            C1977q.m7751i("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already or AppLovinSdkSettings was initialized without a context.");
        } else {
            this.f6801a = z;
        }
    }

    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.f6801a + ", muted=" + this.f6803c + ", testDeviceAdvertisingIds=" + this.f6805e.toString() + '}';
    }
}
