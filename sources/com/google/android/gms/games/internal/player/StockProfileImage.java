package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface StockProfileImage extends Parcelable, Freezable<StockProfileImage> {
    String getImageUrl();

    Uri zzal();
}
