package com.tapjoy.internal;

import android.os.SystemClock;

/* renamed from: com.tapjoy.internal.hk */
public abstract class C5160hk {

    /* renamed from: a */
    protected static C5161a f14139a;

    /* renamed from: b */
    private static C5160hk f14140b;

    /* renamed from: com.tapjoy.internal.hk$a */
    public static class C5161a {

        /* renamed from: a */
        public final String f14141a;

        /* renamed from: b */
        public final String f14142b;

        /* renamed from: c */
        public final long f14143c = SystemClock.elapsedRealtime();

        /* renamed from: d */
        public final C5080fi f14144d = new C5080fi(60000);

        public C5161a(String str, String str2) {
            this.f14141a = str;
            this.f14142b = str2;
        }
    }

    /* renamed from: a */
    protected static void m17380a(C5160hk hkVar) {
        synchronized (C5160hk.class) {
            f14140b = hkVar;
            C5161a aVar = f14139a;
            if (aVar != null) {
                f14139a = null;
                hkVar.mo31265a(aVar);
            }
        }
    }

    /* renamed from: c */
    public static boolean m17382c() {
        C5160hk hkVar = f14140b;
        if (hkVar != null && hkVar.mo31266b()) {
            return true;
        }
        C5161a aVar = f14139a;
        if (aVar == null || aVar.f14144d.mo31235a()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public abstract void mo31265a(C5161a aVar);

    /* renamed from: b */
    public abstract boolean mo31266b();

    /* renamed from: a */
    public static void m17381a(String str, String str2) {
        synchronized (C5160hk.class) {
            C5161a aVar = new C5161a(str, str2);
            if (f14140b != null) {
                f14139a = null;
                f14140b.mo31265a(aVar);
            } else {
                f14139a = aVar;
            }
        }
    }
}
