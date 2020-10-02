package com.google.android.gms.games.appcontent;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzd implements Parcelable.Creator<AppContentAnnotationEntity> {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r14)
            r1 = 0
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r12 = r9
            r10 = 0
            r11 = 0
        L_0x000f:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x0056
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x0051;
                case 2: goto L_0x0047;
                case 3: goto L_0x0042;
                case 4: goto L_0x0020;
                case 5: goto L_0x003d;
                case 6: goto L_0x0038;
                case 7: goto L_0x0033;
                case 8: goto L_0x002e;
                case 9: goto L_0x0029;
                case 10: goto L_0x0024;
                default: goto L_0x0020;
            }
        L_0x0020:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x000f
        L_0x0024:
            android.os.Bundle r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r14, r1)
            goto L_0x000f
        L_0x0029:
            int r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x000f
        L_0x002e:
            int r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x000f
        L_0x0033:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000f
        L_0x0038:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000f
        L_0x003d:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000f
        L_0x0042:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000f
        L_0x0047:
            android.os.Parcelable$Creator r2 = android.net.Uri.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r5 = r1
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x000f
        L_0x0051:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000f
        L_0x0056:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.games.appcontent.AppContentAnnotationEntity r14 = new com.google.android.gms.games.appcontent.AppContentAnnotationEntity
            r3 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.appcontent.zzd.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AppContentAnnotationEntity[i];
    }
}
