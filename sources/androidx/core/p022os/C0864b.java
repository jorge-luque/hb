package androidx.core.p022os;

import android.os.Build;
import android.os.Trace;

/* renamed from: androidx.core.os.b */
/* compiled from: TraceCompat */
public final class C0864b {
    static {
        Class<String> cls = String.class;
        int i = Build.VERSION.SDK_INT;
        if (i >= 18 && i < 29) {
            try {
                Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
                Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, cls, Integer.TYPE});
                Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, cls, Integer.TYPE});
                Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, cls, Integer.TYPE});
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m2832a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    /* renamed from: a */
    public static void m2831a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
