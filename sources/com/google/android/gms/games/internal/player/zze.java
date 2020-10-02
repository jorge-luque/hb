package com.google.android.gms.games.internal.player;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zze implements Parcelable.Creator<ProfileSettingsEntity> {
    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r18) {
        /*
            r17 = this;
            r0 = r18
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r18)
            r2 = 0
            r3 = 0
            r5 = r2
            r6 = r5
            r10 = r6
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x0015:
            int r2 = r18.dataPosition()
            if (r2 >= r1) goto L_0x0070
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r18)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x0066;
                case 2: goto L_0x0061;
                case 3: goto L_0x005c;
                case 4: goto L_0x0057;
                case 5: goto L_0x0052;
                case 6: goto L_0x0048;
                case 7: goto L_0x0043;
                case 8: goto L_0x003e;
                case 9: goto L_0x0039;
                case 10: goto L_0x0034;
                case 11: goto L_0x002f;
                case 12: goto L_0x002a;
                default: goto L_0x0026;
            }
        L_0x0026:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0015
        L_0x002a:
            int r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0015
        L_0x002f:
            boolean r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0015
        L_0x0034:
            boolean r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0015
        L_0x0039:
            int r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0015
        L_0x003e:
            boolean r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0015
        L_0x0043:
            boolean r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0015
        L_0x0048:
            android.os.Parcelable$Creator<com.google.android.gms.games.internal.player.StockProfileImageEntity> r3 = com.google.android.gms.games.internal.player.StockProfileImageEntity.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r10 = r2
            com.google.android.gms.games.internal.player.StockProfileImageEntity r10 = (com.google.android.gms.games.internal.player.StockProfileImageEntity) r10
            goto L_0x0015
        L_0x0052:
            boolean r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0015
        L_0x0057:
            boolean r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0015
        L_0x005c:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0015
        L_0x0061:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0015
        L_0x0066:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r3 = com.google.android.gms.common.api.Status.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r5 = r2
            com.google.android.gms.common.api.Status r5 = (com.google.android.gms.common.api.Status) r5
            goto L_0x0015
        L_0x0070:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.games.internal.player.ProfileSettingsEntity r0 = new com.google.android.gms.games.internal.player.ProfileSettingsEntity
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.player.zze.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProfileSettingsEntity[i];
    }
}
