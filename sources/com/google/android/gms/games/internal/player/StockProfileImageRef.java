package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.data.DataBufferRef;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class StockProfileImageRef extends DataBufferRef implements StockProfileImage {
    public int describeContents() {
        throw new NoSuchMethodError();
    }

    public /* synthetic */ Object freeze() {
        throw new NoSuchMethodError();
    }

    public String getImageUrl() {
        return getString(MessengerShareContentUtility.IMAGE_URL);
    }

    public void writeToParcel(Parcel parcel, int i) {
        throw new NoSuchMethodError();
    }

    public final Uri zzal() {
        throw new NoSuchMethodError();
    }
}
