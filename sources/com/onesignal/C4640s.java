package com.onesignal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.onesignal.s */
/* compiled from: GoogleApiClientCompatProxy */
class C4640s {

    /* renamed from: a */
    private final GoogleApiClient f12644a;

    /* renamed from: b */
    private final Class f12645b;

    C4640s(GoogleApiClient googleApiClient) {
        this.f12644a = googleApiClient;
        this.f12645b = googleApiClient.getClass();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29940a() {
        try {
            this.f12645b.getMethod(TapjoyConstants.TJC_SDK_TYPE_CONNECT, new Class[0]).invoke(this.f12644a, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29941b() {
        try {
            this.f12645b.getMethod("disconnect", new Class[0]).invoke(this.f12644a, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public GoogleApiClient mo29942c() {
        return this.f12644a;
    }
}
