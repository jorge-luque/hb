package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface zzb extends Parcelable, Freezable<zzb> {
    String getDescription();

    String getId();

    String getTitle();

    String zzaj();

    int zzak();

    Uri zzal();

    Bundle zzam();

    int zzan();

    String zzao();
}
