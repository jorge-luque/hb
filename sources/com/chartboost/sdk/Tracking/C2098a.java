package com.chartboost.sdk.Tracking;

import android.text.TextUtils;
import com.chartboost.sdk.C2101c;
import com.chartboost.sdk.Libraries.C2072b;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2093h;
import com.facebook.places.model.PlaceFields;
import com.tapjoy.TJAdUnitConstants;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Tracking.a */
public class C2098a implements C2072b {

    /* renamed from: f */
    private static C2098a f7036f;

    /* renamed from: g */
    private static final Long f7037g = Long.valueOf(TimeUnit.MINUTES.toMillis(5));

    /* renamed from: c */
    private final AtomicReference<C2093h> f7038c;

    /* renamed from: d */
    private boolean f7039d = false;

    /* renamed from: e */
    private long f7040e = (System.currentTimeMillis() - f7037g.longValue());

    public C2098a(AtomicReference<C2093h> atomicReference) {
        f7036f = this;
        this.f7038c = atomicReference;
    }

    /* renamed from: a */
    private void m8289a(String str) {
        if (this.f7038c.get().f7013m) {
            m8290a("session", str, (String) null, (String) null, (String) null, false);
        }
    }

    /* renamed from: c */
    private void m8292c() {
        if (this.f7038c.get().f7013m) {
            mo9166a("session", "end", (String) null, (String) null, (String) null, (String) null, (JSONObject) null, false);
            m8289a("did-become-active");
        }
    }

    /* renamed from: b */
    public void mo9169b() {
        m8289a(TJAdUnitConstants.String.VIDEO_START);
        m8289a("did-become-active");
    }

    /* renamed from: d */
    public void mo9176d(String str, String str2, String str3) {
        if (this.f7038c.get().f7014n) {
            m8290a("ad-show", str, str2, str3, (String) null, false);
        }
    }

    /* renamed from: e */
    public void mo9178e(String str, String str2, String str3) {
        if (this.f7038c.get().f7014n) {
            m8290a("load", str, str2, str3, (String) null, false);
        }
    }

    /* renamed from: a */
    public void mo9158a() {
        m8292c();
    }

    /* renamed from: b */
    public void mo9172b(String str, String str2, String str3, String str4) {
        if (this.f7038c.get().f7014n) {
            mo9166a("webview-track", str, str2, str3, str4, (String) null, (JSONObject) null, false);
        }
    }

    /* renamed from: d */
    public void mo9175d(String str, String str2) {
        if (this.f7038c.get().f7014n) {
            m8290a("replay", str, str2, (String) null, (String) null, false);
        }
    }

    /* renamed from: e */
    public void mo9177e(String str, String str2) {
        if (this.f7038c.get().f7014n) {
            m8290a("playback-start", str, str2, (String) null, (String) null, false);
        }
    }

    /* renamed from: a */
    public void mo9168a(JSONObject jSONObject) {
        C2093h hVar = this.f7038c.get();
        if (hVar.f7014n) {
            mo9166a("folder", C2101c.m8323a(hVar), (String) null, (String) null, (String) null, (String) null, jSONObject, false);
        }
    }

    /* renamed from: c */
    public void mo9174c(String str, String str2, String str3) {
        if (this.f7038c.get().f7014n) {
            m8290a("ad-dismiss", str, str2, str3, (String) null, false);
        }
    }

    /* renamed from: b */
    public void mo9171b(String str, String str2, String str3) {
        if (this.f7038c.get().f7014n) {
            m8290a("ad-close", str, str2, str3, (String) null, false);
        }
    }

    /* renamed from: c */
    public void mo9173c(String str, String str2) {
        if (this.f7038c.get().f7014n) {
            m8290a("playback-stop", str, str2, (String) null, (String) null, false);
        }
    }

    /* renamed from: b */
    public void mo9170b(String str, String str2) {
        if (this.f7038c.get().f7014n) {
            m8290a("playback-complete", str, str2, (String) null, (String) null, false);
        }
    }

    /* renamed from: a */
    public void mo9162a(String str, String str2, String str3) {
        if (this.f7038c.get().f7014n) {
            m8290a("ad-click", str, str2, str3, (String) null, false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m8291b(java.lang.Class r15, java.lang.String r16, java.lang.Exception r17) {
        /*
            r14 = this;
            r10 = r14
            monitor-enter(r14)
            java.util.concurrent.atomic.AtomicReference<com.chartboost.sdk.Model.h> r0 = r10.f7038c     // Catch:{ all -> 0x0064 }
            if (r0 != 0) goto L_0x0008
            monitor-exit(r14)
            return
        L_0x0008:
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0064 }
            com.chartboost.sdk.Model.h r0 = (com.chartboost.sdk.Model.C2093h) r0     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x0062
            boolean r1 = r0.f7011k     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0062
            boolean r1 = r10.f7039d     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0062
            r1 = 1
            r10.f7039d = r1     // Catch:{ all -> 0x0064 }
            r11 = 0
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0058 }
            long r1 = r10.f7040e     // Catch:{ Exception -> 0x0058 }
            long r1 = r12 - r1
            java.lang.Long r3 = f7037g     // Catch:{ Exception -> 0x0058 }
            long r3 = r3.longValue()     // Catch:{ Exception -> 0x0058 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x005c
            boolean r0 = r0.f7016p     // Catch:{ Exception -> 0x0058 }
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = android.util.Log.getStackTraceString(r17)     // Catch:{ Exception -> 0x0058 }
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            r7 = r0
            java.lang.String r2 = "exception"
            java.lang.String r3 = r15.getName()     // Catch:{ Exception -> 0x0058 }
            java.lang.Class r0 = r17.getClass()     // Catch:{ Exception -> 0x0058 }
            java.lang.String r5 = r0.getName()     // Catch:{ Exception -> 0x0058 }
            java.lang.String r6 = r17.getMessage()     // Catch:{ Exception -> 0x0058 }
            r8 = 0
            r9 = 1
            r1 = r14
            r4 = r16
            r1.mo9166a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0058 }
            r10.f7040e = r12     // Catch:{ Exception -> 0x0058 }
            goto L_0x005c
        L_0x0056:
            r0 = move-exception
            goto L_0x005f
        L_0x0058:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0056 }
        L_0x005c:
            r10.f7039d = r11     // Catch:{ all -> 0x0064 }
            goto L_0x0062
        L_0x005f:
            r10.f7039d = r11     // Catch:{ all -> 0x0064 }
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r14)
            return
        L_0x0064:
            r0 = move-exception
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Tracking.C2098a.m8291b(java.lang.Class, java.lang.String, java.lang.Exception):void");
    }

    /* renamed from: a */
    public void mo9167a(String str, String str2, String str3, String str4, boolean z) {
        if (this.f7038c.get().f7014n) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "empty-adid";
            }
            m8290a("ad-error", str, str2, str3, str4, z);
        }
    }

    /* renamed from: a */
    public void mo9164a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (this.f7038c.get().f7012l) {
            String str8 = str5;
            mo9166a("ad-unit-error", str, str2, str3, str4, (String) null, C2076e.m8186a(C2076e.m8184a("adId", (Object) str5), C2076e.m8184a((String) PlaceFields.LOCATION, (Object) str6), C2076e.m8184a("state", (Object) str7)), true);
        }
    }

    /* renamed from: a */
    public void mo9163a(String str, String str2, String str3, String str4) {
        if (this.f7038c.get().f7014n) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "empty-adid";
            }
            m8290a("ad-warning", str, str2, str3, str4, false);
        }
    }

    /* renamed from: a */
    public void mo9160a(String str, String str2) {
        C2093h hVar = this.f7038c.get();
        if (hVar.f7014n) {
            mo9166a("download-asset-start", C2101c.m8323a(hVar), str, str2, (String) null, (String) null, (JSONObject) null, false);
        }
    }

    /* renamed from: a */
    public void mo9161a(String str, String str2, long j, long j2, long j3) {
        if (this.f7038c.get().f7015o) {
            mo9166a("download-asset-failure", str, str2, (String) null, (String) null, (String) null, C2076e.m8186a(C2076e.m8184a("processingMs", (Object) Long.valueOf(j)), C2076e.m8184a("getResponseCodeMs", (Object) Long.valueOf(j2)), C2076e.m8184a("readDataMs", (Object) Long.valueOf(j3))), false);
        }
    }

    /* renamed from: a */
    public void mo9159a(String str, long j, long j2, long j3) {
        if (this.f7038c.get().f7015o) {
            mo9166a("download-asset-success", str, (String) null, (String) null, (String) null, (String) null, C2076e.m8186a(C2076e.m8184a("processingMs", (Object) Long.valueOf(j)), C2076e.m8184a("getResposeCodeMs", (Object) Long.valueOf(j2)), C2076e.m8184a("readDataMs", (Object) Long.valueOf(j3))), false);
        }
    }

    /* renamed from: a */
    public static void m8288a(Class cls, String str, Exception exc) {
        exc.printStackTrace();
        C2098a aVar = f7036f;
        if (aVar != null) {
            aVar.m8291b(cls, str, exc);
        }
    }

    /* renamed from: a */
    public void mo9165a(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        if (this.f7038c.get().f7014n) {
            mo9166a(str, str2, str3, str4, str5, str6, jSONObject, false);
        }
    }

    /* renamed from: a */
    private void m8290a(String str, String str2, String str3, String str4, String str5, boolean z) {
        mo9166a(str, str2, str3, str4, str5, (String) null, new JSONObject(), z);
    }

    /* renamed from: a */
    public void mo9166a(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject, boolean z) {
        if (this.f7038c.get().f7014n) {
            if (str == null) {
                str = "unknown event";
            }
            CBLogging.m8152a("CBTrack", str);
        }
    }
}
