package p093e.p101c.p102a.p103a.p104i;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;

/* renamed from: e.c.a.a.i.r */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
abstract class C3413r implements Closeable {

    /* renamed from: e.c.a.a.i.r$a */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    interface C3414a {
        /* renamed from: a */
        C3414a mo19195a(Context context);

        C3413r build();
    }

    C3413r() {
    }

    public void close() throws IOException {
        mo19193d().close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract C3435c mo19193d();

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public abstract C3412q mo19194t();
}
