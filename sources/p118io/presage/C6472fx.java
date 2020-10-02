package p118io.presage;

import java.io.Closeable;

/* renamed from: io.presage.fx */
public final class C6472fx {
    /* renamed from: a */
    public static final void m21362a(Closeable closeable, Throwable th) {
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            C6423eb.m21295a(th, th2);
        }
    }
}
