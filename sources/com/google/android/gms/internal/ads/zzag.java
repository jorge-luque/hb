package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzag {
    private static final String CLASS_NAME = zzag.class.getName();
    public static boolean DEBUG = Log.isLoggable("Volley", 2);
    private static String TAG = "Volley";

    /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
    static class zza {
        public static final boolean zzbl = zzag.DEBUG;
        private final List<zzai> zzbm = new ArrayList();
        private boolean zzbn = false;

        zza() {
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            if (!this.zzbn) {
                zzc("Request on the loose");
                zzag.m12269e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public final synchronized void zza(String str, long j) {
            if (!this.zzbn) {
                this.zzbm.add(new zzai(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public final synchronized void zzc(String str) {
            long j;
            this.zzbn = true;
            if (this.zzbm.size() == 0) {
                j = 0;
            } else {
                j = this.zzbm.get(this.zzbm.size() - 1).time - this.zzbm.get(0).time;
            }
            if (j > 0) {
                long j2 = this.zzbm.get(0).time;
                zzag.m12268d("(%-4d ms) %s", Long.valueOf(j), str);
                for (zzai next : this.zzbm) {
                    long j3 = next.time;
                    zzag.m12268d("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(next.zzbo), next.name);
                    j2 = j3;
                }
            }
        }
    }

    /* renamed from: d */
    public static void m12268d(String str, Object... objArr) {
        zza(str, objArr);
    }

    /* renamed from: e */
    public static void m12269e(String str, Object... objArr) {
        Log.e(TAG, zza(str, objArr));
    }

    /* renamed from: v */
    public static void m12270v(String str, Object... objArr) {
        if (DEBUG) {
            zza(str, objArr);
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zza(str, objArr), th);
    }

    private static String zza(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(CLASS_NAME)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
