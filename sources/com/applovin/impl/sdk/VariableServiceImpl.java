package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1900p;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinVariableService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class VariableServiceImpl implements AppLovinVariableService {

    /* renamed from: a */
    private final C1941j f5557a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AtomicBoolean f5558b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f5559c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppLovinVariableService.OnVariablesUpdateListener f5560d;

    /* renamed from: e */
    private Bundle f5561e;

    /* renamed from: f */
    private final Object f5562f = new Object();

    VariableServiceImpl(C1941j jVar) {
        this.f5557a = jVar;
        String str = (String) jVar.mo8550a(C1843e.f6095i);
        if (C2025o.m7963b(str)) {
            updateVariables(C1993i.m7880a(str, jVar));
        }
    }

    /* renamed from: a */
    private Object m6764a(String str, Object obj, Class<?> cls) {
        if (TextUtils.isEmpty(str)) {
            C1977q.m7751i("AppLovinVariableService", "Unable to retrieve variable value for empty name");
            return obj;
        }
        if (!this.f5557a.mo8583d()) {
            C1977q.m7750h("AppLovinSdk", "Attempted to retrieve variable before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        synchronized (this.f5562f) {
            if (this.f5561e == null) {
                C1977q.m7751i("AppLovinVariableService", "Unable to retrieve variable value for name \"" + str + "\", none retrieved from server yet. Please set a listener to be notified when values are retrieved from the server.");
                return obj;
            } else if (cls.equals(String.class)) {
                String string = this.f5561e.getString(str, (String) obj);
                return string;
            } else if (cls.equals(Boolean.class)) {
                Boolean valueOf = Boolean.valueOf(this.f5561e.getBoolean(str, ((Boolean) obj).booleanValue()));
                return valueOf;
            } else {
                throw new IllegalStateException("Unable to retrieve variable value for " + str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6766a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f5562f
            monitor-enter(r0)
            com.applovin.sdk.AppLovinVariableService$OnVariablesUpdateListener r1 = r4.f5560d     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x001f
            android.os.Bundle r1 = r4.f5561e     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x000c
            goto L_0x001f
        L_0x000c:
            android.os.Bundle r1 = r4.f5561e     // Catch:{ all -> 0x0021 }
            java.lang.Object r1 = r1.clone()     // Catch:{ all -> 0x0021 }
            android.os.Bundle r1 = (android.os.Bundle) r1     // Catch:{ all -> 0x0021 }
            r2 = 1
            com.applovin.impl.sdk.VariableServiceImpl$2 r3 = new com.applovin.impl.sdk.VariableServiceImpl$2     // Catch:{ all -> 0x0021 }
            r3.<init>(r1)     // Catch:{ all -> 0x0021 }
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r2, r3)     // Catch:{ all -> 0x0021 }
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return
        L_0x0021:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.VariableServiceImpl.m6766a():void");
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return ((Boolean) m6764a(str, Boolean.valueOf(z), Boolean.class)).booleanValue();
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        return (String) m6764a(str, str2, String.class);
    }

    @Deprecated
    public void loadVariables() {
        String str;
        if (!this.f5557a.mo8583d()) {
            str = "The AppLovin SDK is waiting for the initial variables to be returned upon completing initialization.";
        } else if (this.f5558b.compareAndSet(false, true)) {
            this.f5557a.mo8533L().mo8475a((C1864a) new C1900p(this.f5557a, new C1900p.C1902a() {
                /* renamed from: a */
                public void mo8068a() {
                    VariableServiceImpl.this.f5558b.set(false);
                }
            }), C1907s.C1909a.BACKGROUND);
            return;
        } else {
            str = "Ignored explicit variables load. Service is already in the process of retrieving the latest set of variables.";
        }
        C1977q.m7751i("AppLovinVariableService", str);
    }

    @Deprecated
    public void setOnVariablesUpdateListener(AppLovinVariableService.OnVariablesUpdateListener onVariablesUpdateListener) {
        this.f5560d = onVariablesUpdateListener;
        synchronized (this.f5562f) {
            if (onVariablesUpdateListener != null) {
                if (this.f5561e != null && this.f5559c.compareAndSet(false, true)) {
                    this.f5557a.mo8602v().mo8742b("AppLovinVariableService", "Setting initial listener");
                    m6766a();
                }
            }
        }
    }

    public String toString() {
        return "VariableService{variables=" + this.f5561e + ", listener=" + this.f5560d + '}';
    }

    public void updateVariables(JSONObject jSONObject) {
        C1977q v = this.f5557a.mo8602v();
        v.mo8742b("AppLovinVariableService", "Updating variables: " + jSONObject + "...");
        synchronized (this.f5562f) {
            this.f5561e = C1993i.m7903c(jSONObject);
            m6766a();
            this.f5557a.mo8556a(C1843e.f6095i, jSONObject.toString());
        }
    }
}
