package com.loopj.android.http;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import p163cz.msebera.android.httpclient.NoHttpResponseException;
import p163cz.msebera.android.httpclient.client.C5582h;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

/* renamed from: com.loopj.android.http.o */
/* compiled from: RetryHandler */
class C4265o implements C5582h {

    /* renamed from: c */
    private static final HashSet<Class<?>> f11414c = new HashSet<>();

    /* renamed from: d */
    private static final HashSet<Class<?>> f11415d = new HashSet<>();

    /* renamed from: a */
    private final int f11416a;

    /* renamed from: b */
    private final int f11417b;

    static {
        f11414c.add(NoHttpResponseException.class);
        f11414c.add(UnknownHostException.class);
        f11414c.add(SocketException.class);
        f11415d.add(InterruptedIOException.class);
        f11415d.add(SSLException.class);
    }

    public C4265o(int i, int i2) {
        this.f11416a = i;
        this.f11417b = i2;
    }

    /* renamed from: a */
    static void m14394a(Class<?> cls) {
        f11414c.add(cls);
    }

    /* renamed from: a */
    public boolean mo28925a(IOException iOException, int i, C5875e eVar) {
        Boolean bool = (Boolean) eVar.mo33533a("http.request_sent");
        boolean z = true;
        if (bool == null || !bool.booleanValue()) {
        }
        if (i > this.f11416a || (!mo28926a(f11414c, iOException) && mo28926a(f11415d, iOException))) {
            z = false;
        }
        if (z && ((C5600i) eVar.mo33533a("http.request")) == null) {
            return false;
        }
        if (z) {
            SystemClock.sleep((long) this.f11417b);
        } else {
            iOException.printStackTrace();
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo28926a(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }
}
