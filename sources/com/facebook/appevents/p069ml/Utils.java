package com.facebook.appevents.p069ml;

import android.text.TextUtils;
import com.loopj.android.http.C4250c;
import java.nio.charset.Charset;

/* renamed from: com.facebook.appevents.ml.Utils */
public class Utils {
    static String normalizeString(String str) {
        return TextUtils.join(" ", str.trim().split("\\s+"));
    }

    static int[] vectorize(String str, int i) {
        int[] iArr = new int[i];
        byte[] bytes = normalizeString(str).getBytes(Charset.forName(C4250c.DEFAULT_CHARSET));
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < bytes.length) {
                iArr[i2] = bytes[i2] & 255;
            } else {
                iArr[i2] = 0;
            }
        }
        return iArr;
    }
}
