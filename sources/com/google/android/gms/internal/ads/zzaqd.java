package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzaqd {
    @Nonnull
    private final View zzaae;
    private final Map<String, WeakReference<View>> zzdli;
    private final zzavn zzdlj;

    public zzaqd(zzaqi zzaqi) {
        Map<String, WeakReference<View>> map;
        this.zzaae = zzaqi.zzaae;
        this.zzdli = zzaqi.zzdli;
        zzavn zzr = zzaqc.zzr(zzaqi.zzaae.getContext());
        this.zzdlj = zzr;
        if (zzr != null && (map = this.zzdli) != null && !map.isEmpty()) {
            try {
                this.zzdlj.zza(new zzaqh(ObjectWrapper.wrap(this.zzaae).asBinder(), ObjectWrapper.wrap(this.zzdli).asBinder()));
            } catch (RemoteException unused) {
                zzazw.zzfa("Failed to call remote method.");
            }
        }
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        zzavn zzavn = this.zzdlj;
        if (zzavn == null) {
            zzazw.zzfa("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzavn.zzan(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            zzazw.zzfa("Failed to call remote method.");
        }
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzdlj == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdlj.zzb(new ArrayList(Arrays.asList(new Uri[]{uri})), ObjectWrapper.wrap(this.zzaae), new zzaqf(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzdlj == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdlj.zza(list, ObjectWrapper.wrap(this.zzaae), (zzapx) new zzaqg(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }
}
