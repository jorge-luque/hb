package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface zza extends Parcelable, Freezable<zza> {
    String getDescription();

    Uri getIconImageUri();

    String getTitle();

    int getType();
}
