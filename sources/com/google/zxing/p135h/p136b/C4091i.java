package com.google.zxing.p135h.p136b;

import admost.sdk.AdMostManager;
import admost.sdk.base.AdMost;
import admost.sdk.listener.AdMostAdListener;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.games.Notifications;

/* renamed from: com.google.zxing.h.b.i */
/* compiled from: ErrorCorrection */
public final class C4091i {

    /* renamed from: a */
    private static final int[] f10987a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};

    /* renamed from: b */
    private static final int[][] f10988b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, AdMostAdListener.STATUS_CHANGED, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, Notifications.NOTIFICATION_TYPES_ALL, 242, 218, 130, AdMostManager.AD_MEDIUM_RECTANGLE, AdMostAdListener.COMPLETED, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, AdMostAdListener.CLOSED, 13, 137, 245, Notifications.NOTIFICATION_TYPES_ALL, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, FacebookRequestErrorClassification.EC_INVALID_TOKEN, AdMostManager.AD_MEDIUM_RECTANGLE, 106, 185, 221, 175, 64, 114, 71, AdMostAdListener.FAILED, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, AdMostAdListener.LOADED, 31, 176, 170, 4, 107, 232, 7, 94, AdMostAdListener.STATUS_CHANGED, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, Notifications.NOTIFICATION_TYPES_ALL, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};

    /* renamed from: c */
    private static final int[] f10989c = new int[256];

    /* renamed from: d */
    private static final int[] f10990d = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            f10990d[i2] = i;
            f10989c[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN;
            }
        }
    }

    /* renamed from: a */
    public static String m13674a(String str, C4093k kVar) {
        if (str.length() == kVar.mo28368a()) {
            StringBuilder sb = new StringBuilder(kVar.mo28368a() + kVar.mo28369b());
            sb.append(str);
            int c = kVar.mo28346c();
            if (c == 1) {
                sb.append(m13672a((CharSequence) str, kVar.mo28369b()));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[c];
                int[] iArr2 = new int[c];
                int[] iArr3 = new int[c];
                int i = 0;
                while (i < c) {
                    int i2 = i + 1;
                    iArr[i] = kVar.mo28345a(i2);
                    iArr2[i] = kVar.mo28370b(i2);
                    iArr3[i] = 0;
                    if (i > 0) {
                        iArr3[i] = iArr3[i - 1] + iArr[i];
                    }
                    i = i2;
                }
                for (int i3 = 0; i3 < c; i3++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i3]);
                    for (int i4 = i3; i4 < kVar.mo28368a(); i4 += c) {
                        sb2.append(str.charAt(i4));
                    }
                    String a = m13672a((CharSequence) sb2.toString(), iArr2[i3]);
                    int i5 = i3;
                    int i6 = 0;
                    while (i5 < iArr2[i3] * c) {
                        sb.setCharAt(kVar.mo28368a() + i5, a.charAt(i6));
                        i5 += c;
                        i6++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    /* renamed from: a */
    private static String m13672a(CharSequence charSequence, int i) {
        return m13673a(charSequence, 0, charSequence.length(), i);
    }

    /* renamed from: a */
    private static String m13673a(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = f10987a;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            } else if (iArr[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            int[] iArr2 = f10988b[i4];
            char[] cArr = new char[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                cArr[i5] = 0;
            }
            for (int i6 = i; i6 < i + i2; i6++) {
                int i7 = i3 - 1;
                char charAt = cArr[i7] ^ charSequence.charAt(i6);
                while (i7 > 0) {
                    if (charAt == 0 || iArr2[i7] == 0) {
                        cArr[i7] = cArr[i7 - 1];
                    } else {
                        char c = cArr[i7 - 1];
                        int[] iArr3 = f10990d;
                        int[] iArr4 = f10989c;
                        cArr[i7] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                    }
                    i7--;
                }
                if (charAt == 0 || iArr2[0] == 0) {
                    cArr[0] = 0;
                } else {
                    int[] iArr5 = f10990d;
                    int[] iArr6 = f10989c;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                }
            }
            char[] cArr2 = new char[i3];
            for (int i8 = 0; i8 < i3; i8++) {
                cArr2[i8] = cArr[(i3 - i8) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
    }
}
