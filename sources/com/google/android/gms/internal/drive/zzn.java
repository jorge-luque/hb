package com.google.android.gms.internal.drive;

import android.os.Parcelable;

public final class zzn implements Parcelable.Creator<zzm> {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r15) {
        /*
            r14 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r15)
            r1 = 0
            r2 = 0
            r3 = 1
            r5 = r2
            r6 = r5
            r7 = r6
            r9 = r7
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 1
        L_0x0010:
            int r1 = r15.dataPosition()
            if (r1 >= r0) goto L_0x0061
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r15)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 2: goto L_0x0057;
                case 3: goto L_0x004d;
                case 4: goto L_0x0043;
                case 5: goto L_0x003e;
                case 6: goto L_0x0039;
                case 7: goto L_0x0034;
                case 8: goto L_0x002f;
                case 9: goto L_0x002a;
                case 10: goto L_0x0025;
                default: goto L_0x0021;
            }
        L_0x0021:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r15, r1)
            goto L_0x0010
        L_0x0025:
            boolean r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r15, r1)
            goto L_0x0010
        L_0x002a:
            boolean r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r15, r1)
            goto L_0x0010
        L_0x002f:
            int r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r15, r1)
            goto L_0x0010
        L_0x0034:
            int r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r15, r1)
            goto L_0x0010
        L_0x0039:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r15, r1)
            goto L_0x0010
        L_0x003e:
            boolean r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r15, r1)
            goto L_0x0010
        L_0x0043:
            android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r2 = com.google.android.gms.drive.Contents.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r15, r1, r2)
            r7 = r1
            com.google.android.gms.drive.Contents r7 = (com.google.android.gms.drive.Contents) r7
            goto L_0x0010
        L_0x004d:
            android.os.Parcelable$Creator<com.google.android.gms.drive.metadata.internal.MetadataBundle> r2 = com.google.android.gms.drive.metadata.internal.MetadataBundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r15, r1, r2)
            r6 = r1
            com.google.android.gms.drive.metadata.internal.MetadataBundle r6 = (com.google.android.gms.drive.metadata.internal.MetadataBundle) r6
            goto L_0x0010
        L_0x0057:
            android.os.Parcelable$Creator<com.google.android.gms.drive.DriveId> r2 = com.google.android.gms.drive.DriveId.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r15, r1, r2)
            r5 = r1
            com.google.android.gms.drive.DriveId r5 = (com.google.android.gms.drive.DriveId) r5
            goto L_0x0010
        L_0x0061:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r15, r0)
            com.google.android.gms.internal.drive.zzm r15 = new com.google.android.gms.internal.drive.zzm
            r4 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzn.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzm[i];
    }
}
