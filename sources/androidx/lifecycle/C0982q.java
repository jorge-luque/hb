package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.lifecycle.q */
/* compiled from: ViewModel */
public abstract class C0982q {

    /* renamed from: a */
    private final Map<String, Object> f2535a = new HashMap();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo5014a() {
        Map<String, Object> map = this.f2535a;
        if (map != null) {
            synchronized (map) {
                for (Object a : this.f2535a.values()) {
                    m3495a(a);
                }
            }
        }
        mo4905b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4905b() {
    }

    /* renamed from: a */
    private static void m3495a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
