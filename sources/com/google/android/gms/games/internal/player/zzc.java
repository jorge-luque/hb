package com.google.android.gms.games.internal.player;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzc implements Parcelable.Creator<MostRecentGameInfoEntity> {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r13)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r9 = r6
            r10 = r9
            r11 = r10
            r7 = r2
        L_0x000d:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x004f
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r13)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x004a;
                case 2: goto L_0x0045;
                case 3: goto L_0x0040;
                case 4: goto L_0x0036;
                case 5: goto L_0x002c;
                case 6: goto L_0x0022;
                default: goto L_0x001e;
            }
        L_0x001e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r13, r1)
            goto L_0x000d
        L_0x0022:
            android.os.Parcelable$Creator r2 = android.net.Uri.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r11 = r1
            android.net.Uri r11 = (android.net.Uri) r11
            goto L_0x000d
        L_0x002c:
            android.os.Parcelable$Creator r2 = android.net.Uri.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r10 = r1
            android.net.Uri r10 = (android.net.Uri) r10
            goto L_0x000d
        L_0x0036:
            android.os.Parcelable$Creator r2 = android.net.Uri.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r9 = r1
            android.net.Uri r9 = (android.net.Uri) r9
            goto L_0x000d
        L_0x0040:
            long r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r13, r1)
            goto L_0x000d
        L_0x0045:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000d
        L_0x004a:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000d
        L_0x004f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r13, r0)
            com.google.android.gms.games.internal.player.MostRecentGameInfoEntity r13 = new com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
            r4 = r13
            r4.<init>(r5, r6, r7, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.player.zzc.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}
