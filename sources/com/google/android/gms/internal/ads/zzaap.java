package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzaap extends zzaaq {
    private final zze zzcvc;
    private final String zzcvd;
    private final String zzcve;

    public zzaap(zze zze, String str, String str2) {
        this.zzcvc = zze;
        this.zzcvd = str;
        this.zzcve = str2;
    }

    public final String getContent() {
        return this.zzcve;
    }

    public final void recordClick() {
        this.zzcvc.zzjy();
    }

    public final void recordImpression() {
        this.zzcvc.zzjz();
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zzcvc.zzh((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final String zzro() {
        return this.zzcvd;
    }
}
