package p163cz.msebera.android.httpclient.p177d0;

import android.util.Log;

/* renamed from: cz.msebera.android.httpclient.d0.b */
/* compiled from: HttpClientAndroidLog */
public class C5695b {

    /* renamed from: a */
    private String f14707a;

    /* renamed from: b */
    private boolean f14708b = false;

    /* renamed from: c */
    private boolean f14709c = false;

    /* renamed from: d */
    private boolean f14710d = false;

    /* renamed from: e */
    private boolean f14711e = false;

    public C5695b(Object obj) {
        this.f14707a = obj.toString();
    }

    /* renamed from: a */
    public boolean mo33168a() {
        return this.f14708b;
    }

    /* renamed from: b */
    public boolean mo33171b() {
        return this.f14709c;
    }

    /* renamed from: c */
    public boolean mo33173c() {
        return this.f14711e;
    }

    /* renamed from: d */
    public boolean mo33175d() {
        return this.f14710d;
    }

    /* renamed from: a */
    public void mo33166a(Object obj) {
        if (mo33168a()) {
            obj.toString();
        }
    }

    /* renamed from: b */
    public void mo33169b(Object obj) {
        if (mo33171b()) {
            Log.e(this.f14707a, obj.toString());
        }
    }

    /* renamed from: c */
    public void mo33172c(Object obj) {
        if (mo33173c()) {
            obj.toString();
        }
    }

    /* renamed from: d */
    public void mo33174d(Object obj) {
        if (mo33175d()) {
            Log.w(this.f14707a, obj.toString());
        }
    }

    /* renamed from: a */
    public void mo33167a(Object obj, Throwable th) {
        if (mo33168a()) {
            obj.toString();
        }
    }

    /* renamed from: b */
    public void mo33170b(Object obj, Throwable th) {
        if (mo33175d()) {
            Log.w(this.f14707a, obj.toString(), th);
        }
    }
}
