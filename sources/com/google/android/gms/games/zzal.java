package com.google.android.gms.games;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class zzal implements Parcelable.Creator<PlayerEntity> {
    public /* synthetic */ Object[] newArray(int i) {
        return new PlayerEntity[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v8, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v9, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: zzc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.games.PlayerEntity createFromParcel(android.os.Parcel r39) {
        /*
            r38 = this;
            r0 = r39
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r39)
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = -1
            r13 = r2
            r16 = r13
            r32 = r16
            r9 = r5
            r10 = r9
            r11 = r10
            r12 = r11
            r18 = r12
            r19 = r18
            r20 = r19
            r21 = r20
            r22 = r21
            r25 = r22
            r26 = r25
            r27 = r26
            r28 = r27
            r29 = r28
            r30 = r29
            r37 = r30
            r35 = r6
            r15 = 0
            r23 = 0
            r24 = 0
            r31 = 0
            r34 = 0
        L_0x0038:
            int r2 = r39.dataPosition()
            if (r2 >= r1) goto L_0x00fc
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r39)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x00f6;
                case 2: goto L_0x00f0;
                case 3: goto L_0x00e5;
                case 4: goto L_0x00da;
                case 5: goto L_0x00d4;
                case 6: goto L_0x00ce;
                case 7: goto L_0x00c8;
                case 8: goto L_0x00c2;
                case 9: goto L_0x00bc;
                case 10: goto L_0x0049;
                case 11: goto L_0x0049;
                case 12: goto L_0x0049;
                case 13: goto L_0x0049;
                case 14: goto L_0x00b6;
                case 15: goto L_0x00ab;
                case 16: goto L_0x00a0;
                case 17: goto L_0x0049;
                case 18: goto L_0x009b;
                case 19: goto L_0x0096;
                case 20: goto L_0x0091;
                case 21: goto L_0x008c;
                case 22: goto L_0x0081;
                case 23: goto L_0x007c;
                case 24: goto L_0x0071;
                case 25: goto L_0x006c;
                case 26: goto L_0x0067;
                case 27: goto L_0x0062;
                case 28: goto L_0x005d;
                case 29: goto L_0x0058;
                case 30: goto L_0x0049;
                case 31: goto L_0x0049;
                case 32: goto L_0x0049;
                case 33: goto L_0x004d;
                default: goto L_0x0049;
            }
        L_0x0049:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0038
        L_0x004d:
            android.os.Parcelable$Creator<com.google.android.gms.games.zzao> r3 = com.google.android.gms.games.zzao.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r37 = r2
            com.google.android.gms.games.zzao r37 = (com.google.android.gms.games.zzao) r37
            goto L_0x0038
        L_0x0058:
            long r35 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0038
        L_0x005d:
            boolean r34 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0038
        L_0x0062:
            long r32 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0038
        L_0x0067:
            int r31 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0038
        L_0x006c:
            java.lang.String r30 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0038
        L_0x0071:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r29 = r2
            android.net.Uri r29 = (android.net.Uri) r29
            goto L_0x0038
        L_0x007c:
            java.lang.String r28 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0038
        L_0x0081:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r27 = r2
            android.net.Uri r27 = (android.net.Uri) r27
            goto L_0x0038
        L_0x008c:
            java.lang.String r26 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0038
        L_0x0091:
            java.lang.String r25 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0038
        L_0x0096:
            boolean r24 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0038
        L_0x009b:
            boolean r23 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0038
        L_0x00a0:
            android.os.Parcelable$Creator<com.google.android.gms.games.PlayerLevelInfo> r3 = com.google.android.gms.games.PlayerLevelInfo.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r22 = r2
            com.google.android.gms.games.PlayerLevelInfo r22 = (com.google.android.gms.games.PlayerLevelInfo) r22
            goto L_0x0038
        L_0x00ab:
            android.os.Parcelable$Creator<com.google.android.gms.games.internal.player.MostRecentGameInfoEntity> r3 = com.google.android.gms.games.internal.player.MostRecentGameInfoEntity.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r21 = r2
            com.google.android.gms.games.internal.player.MostRecentGameInfoEntity r21 = (com.google.android.gms.games.internal.player.MostRecentGameInfoEntity) r21
            goto L_0x0038
        L_0x00b6:
            java.lang.String r20 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0038
        L_0x00bc:
            java.lang.String r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0038
        L_0x00c2:
            java.lang.String r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0038
        L_0x00c8:
            long r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0038
        L_0x00ce:
            int r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0038
        L_0x00d4:
            long r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0038
        L_0x00da:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            android.net.Uri r12 = (android.net.Uri) r12
            goto L_0x0038
        L_0x00e5:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r11 = r2
            android.net.Uri r11 = (android.net.Uri) r11
            goto L_0x0038
        L_0x00f0:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0038
        L_0x00f6:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0038
        L_0x00fc:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.games.PlayerEntity r0 = new com.google.android.gms.games.PlayerEntity
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34, r35, r37)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.zzal.createFromParcel(android.os.Parcel):com.google.android.gms.games.PlayerEntity");
    }
}
