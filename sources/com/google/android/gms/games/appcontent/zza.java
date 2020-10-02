package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface zza extends Parcelable, Freezable<zza> {
    Bundle getExtras();

    String getId();

    String getType();

    zzb zzaf();

    List<zzf> zzag();

    String zzah();

    String zzai();
}
