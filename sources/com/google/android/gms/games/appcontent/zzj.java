package com.google.android.gms.games.appcontent;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface zzj extends Parcelable, Freezable<zzj> {
    String getName();

    String getValue();
}
