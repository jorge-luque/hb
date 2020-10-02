package com.loopj.android.http;

import android.os.Looper;
import java.lang.ref.WeakReference;

/* renamed from: com.loopj.android.http.l */
/* compiled from: RequestHandle */
public class C4261l {

    /* renamed from: a */
    private final WeakReference<C4249b> f11411a;

    /* renamed from: com.loopj.android.http.l$a */
    /* compiled from: RequestHandle */
    class C4262a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4249b f11412a;

        /* renamed from: b */
        final /* synthetic */ boolean f11413b;

        C4262a(C4261l lVar, C4249b bVar, boolean z) {
            this.f11412a = bVar;
            this.f11413b = z;
        }

        public void run() {
            this.f11412a.mo28852a(this.f11413b);
        }
    }

    public C4261l(C4249b bVar) {
        this.f11411a = new WeakReference<>(bVar);
    }

    /* renamed from: a */
    public boolean mo28920a(boolean z) {
        C4249b bVar = (C4249b) this.f11411a.get();
        if (bVar == null) {
            return false;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return bVar.mo28852a(z);
        }
        new Thread(new C4262a(this, bVar, z)).start();
        return true;
    }

    /* renamed from: b */
    public boolean mo28921b() {
        C4249b bVar = (C4249b) this.f11411a.get();
        return bVar == null || bVar.mo28854b();
    }

    /* renamed from: c */
    public boolean mo28922c() {
        boolean z = mo28919a() || mo28921b();
        if (z) {
            this.f11411a.clear();
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo28919a() {
        C4249b bVar = (C4249b) this.f11411a.get();
        return bVar == null || bVar.mo28851a();
    }
}
