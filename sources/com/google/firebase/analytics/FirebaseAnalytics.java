package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.measurement.internal.zzfx;
import com.google.android.gms.measurement.internal.zzhz;
import com.google.android.gms.measurement.internal.zzv;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
public final class FirebaseAnalytics {

    /* renamed from: d */
    private static volatile FirebaseAnalytics f10135d;

    /* renamed from: a */
    private final zzfx f10136a;

    /* renamed from: b */
    private final zzac f10137b;

    /* renamed from: c */
    private final boolean f10138c;

    private FirebaseAnalytics(zzfx zzfx) {
        Preconditions.checkNotNull(zzfx);
        this.f10136a = zzfx;
        this.f10137b = null;
        this.f10138c = false;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f10135d == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f10135d == null) {
                    if (zzac.zzb(context)) {
                        f10135d = new FirebaseAnalytics(zzac.zza(context));
                    } else {
                        f10135d = new FirebaseAnalytics(zzfx.zza(context, (zzaa) null, (Long) null));
                    }
                }
            }
        }
        return f10135d;
    }

    @Keep
    public static zzhz getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzac zza;
        if (zzac.zzb(context) && (zza = zzac.zza(context, (String) null, (String) null, (String) null, bundle)) != null) {
            return new C3624b(zza);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo27193a(String str, Bundle bundle) {
        if (this.f10138c) {
            this.f10137b.zza(str, bundle);
        } else {
            this.f10136a.zzh().zza(TapjoyConstants.TJC_APP_PLACEMENT, str, bundle, true);
        }
    }

    @Keep
    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.m12531k().mo27292a();
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.f10138c) {
            this.f10137b.zza(activity, str, str2);
        } else if (!zzv.zza()) {
            this.f10136a.zzr().zzi().zza("setCurrentScreen must be called from the main thread");
        } else {
            this.f10136a.zzv().zza(activity, str, str2);
        }
    }

    /* renamed from: a */
    public final void mo27194a(String str, String str2) {
        if (this.f10138c) {
            this.f10137b.zza(str, str2);
        } else {
            this.f10136a.zzh().zza(TapjoyConstants.TJC_APP_PLACEMENT, str, (Object) str2, false);
        }
    }

    private FirebaseAnalytics(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        this.f10136a = null;
        this.f10137b = zzac;
        this.f10138c = true;
    }
}
