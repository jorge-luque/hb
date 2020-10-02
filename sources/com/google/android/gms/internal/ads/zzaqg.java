package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzaqg extends zzaqa {
    private final /* synthetic */ UpdateImpressionUrlsCallback zzdlm;

    zzaqg(zzaqd zzaqd, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzdlm = updateImpressionUrlsCallback;
    }

    public final void onError(String str) {
        this.zzdlm.onFailure(str);
    }

    public final void onSuccess(List<Uri> list) {
        this.zzdlm.onSuccess(list);
    }
}
