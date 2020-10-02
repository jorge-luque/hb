package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public class Logger {
    private final String mTag;
    private final String zzeu;
    private final GmsLogger zzfl;
    private final int zzfm;

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Logger(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L_0x0006
            java.lang.String r8 = ""
            goto L_0x0036
        L_0x0006:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 91
            r0.append(r1)
            int r1 = r8.length
            r2 = 0
        L_0x0012:
            if (r2 >= r1) goto L_0x0028
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L_0x0022
            java.lang.String r4 = ","
            r0.append(r4)
        L_0x0022:
            r0.append(r3)
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0028:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x0036:
            r6.<init>((java.lang.String) r7, (java.lang.String) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.logging.Logger.<init>(java.lang.String, java.lang.String[]):void");
    }

    @KeepForSdk
    /* renamed from: d */
    public void mo15248d(String str, Object... objArr) {
        if (isLoggable(3)) {
            format(str, objArr);
        }
    }

    @KeepForSdk
    /* renamed from: e */
    public void mo15250e(String str, Object... objArr) {
        Log.e(this.mTag, format(str, objArr));
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzeu.concat(str);
    }

    @KeepForSdk
    public String getTag() {
        return this.mTag;
    }

    @KeepForSdk
    /* renamed from: i */
    public void mo15253i(String str, Object... objArr) {
        format(str, objArr);
    }

    @KeepForSdk
    public boolean isLoggable(int i) {
        return this.zzfm <= i;
    }

    @KeepForSdk
    /* renamed from: v */
    public void mo15256v(String str, Object... objArr) {
        if (isLoggable(2)) {
            format(str, objArr);
        }
    }

    @KeepForSdk
    /* renamed from: w */
    public void mo15257w(String str, Object... objArr) {
        Log.w(this.mTag, format(str, objArr));
    }

    @KeepForSdk
    public void wtf(String str, Throwable th, Object... objArr) {
        Log.wtf(this.mTag, format(str, objArr), th);
    }

    @KeepForSdk
    /* renamed from: e */
    public void mo15249e(String str, Throwable th, Object... objArr) {
        Log.e(this.mTag, format(str, objArr), th);
    }

    @KeepForSdk
    public void wtf(Throwable th) {
        Log.wtf(this.mTag, th);
    }

    @KeepForSdk
    /* renamed from: d */
    public void mo15247d(String str, Throwable th, Object... objArr) {
        if (isLoggable(3)) {
            format(str, objArr);
        }
    }

    @KeepForSdk
    /* renamed from: v */
    public void mo15255v(String str, Throwable th, Object... objArr) {
        if (isLoggable(2)) {
            format(str, objArr);
        }
    }

    private Logger(String str, String str2) {
        this.zzeu = str2;
        this.mTag = str;
        this.zzfl = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        this.zzfm = i;
    }
}
