package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzaqc {
    private final zzxt zzacc;
    private final AdFormat zzdlh;
    private final Context zzvf;

    public zzaqc(Context context, AdFormat adFormat, zzxt zzxt) {
        this.zzvf = context;
        this.zzdlh = adFormat;
        this.zzacc = zzxt;
    }

    public static zzavn zzr(Context context) {
        try {
            return ((zzavs) zzazv.zza(context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzaqb.zzbvh)).zzf(ObjectWrapper.wrap(context), 201004000);
        } catch (RemoteException | zzazx | NullPointerException unused) {
            return null;
        }
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzuj zzuj;
        zzavn zzr = zzr(this.zzvf);
        if (zzr == null) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzvf);
        zzxt zzxt = this.zzacc;
        if (zzxt == null) {
            zzuj = new zzui().zzpg();
        } else {
            zzuj = zzuk.zza(this.zzvf, zzxt);
        }
        try {
            zzr.zza(wrap, new zzavt((String) null, this.zzdlh.name(), (zzum) null, zzuj), (zzavm) new zzaqe(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
