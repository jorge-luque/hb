package com.tapjoy.internal;

import android.os.SystemClock;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.gf */
public abstract class C3137gf {
    @Nullable

    /* renamed from: a */
    static Set f8730a = null;

    /* renamed from: b */
    private static final ThreadLocal f8731b = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return new HashMap();
        }
    };

    /* renamed from: c */
    private static C3137gf f8732c;

    /* renamed from: d */
    private static volatile boolean f8733d = false;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m10288b(String str, @Nullable String str2, @Nullable Map map) {
        C3137gf gfVar;
        Set set = f8730a;
        if ((set == null || !set.contains(str)) && f8733d && (gfVar = f8732c) != null) {
            gfVar.mo18519a(C5271v.m17676b(), str, str2, map);
        }
    }

    /* renamed from: c */
    public static C3139a m10289c(String str) {
        return (C3139a) ((Map) f8731b.get()).get(str);
    }

    /* renamed from: d */
    public static C3139a m10290d(String str) {
        return (C3139a) ((Map) f8731b.get()).remove(str);
    }

    /* renamed from: e */
    public static C3139a m10291e(String str) {
        return new C3139a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18517a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18518a(long j);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18519a(long j, String str, @Nullable String str2, @Nullable Map map);

    /* renamed from: com.tapjoy.internal.gf$a */
    public static final class C3139a {

        /* renamed from: a */
        final String f8734a;

        /* renamed from: b */
        private final TreeMap f8735b = new TreeMap();

        /* renamed from: c */
        private final Map f8736c = new HashMap();

        /* renamed from: d */
        private volatile long f8737d;

        C3139a(String str) {
            this.f8734a = str;
        }

        /* renamed from: a */
        public final C3139a mo18521a() {
            try {
                this.f8737d = SystemClock.elapsedRealtime();
            } catch (NullPointerException unused) {
                this.f8737d = -1;
            }
            return this;
        }

        /* renamed from: b */
        public final C3139a mo18526b() {
            long j = this.f8737d;
            if (j != -1) {
                try {
                    mo18523a("spent_time", SystemClock.elapsedRealtime() - j);
                } catch (NullPointerException unused) {
                }
            }
            return this;
        }

        /* renamed from: c */
        public final void mo18529c() {
            String str = this.f8734a;
            Map map = null;
            String a = this.f8735b.size() > 0 ? C4910bh.m16696a((Object) this.f8735b) : null;
            if (this.f8736c.size() > 0) {
                map = this.f8736c;
            }
            C3137gf.m10288b(str, a, map);
        }

        /* renamed from: a */
        public final C3139a mo18524a(String str, Object obj) {
            this.f8735b.put(str, obj);
            return this;
        }

        /* renamed from: b */
        public final C3139a mo18527b(String str) {
            this.f8735b.put("misuse", str);
            return this;
        }

        /* renamed from: a */
        public final C3139a mo18525a(Map map) {
            if (map != null) {
                this.f8735b.putAll(map);
            }
            return this;
        }

        /* renamed from: b */
        public final C3139a mo18528b(Map map) {
            if (map != null) {
                this.f8736c.putAll(map);
            }
            return this;
        }

        /* renamed from: a */
        public final C3139a mo18522a(String str) {
            this.f8735b.put("failure", str);
            return this;
        }

        /* renamed from: a */
        public final C3139a mo18523a(String str, long j) {
            this.f8736c.put(str, Long.valueOf(j));
            return this;
        }
    }

    /* renamed from: a */
    public static void m10281a(C5120gh ghVar) {
        if (f8732c == null) {
            f8732c = ghVar;
            if (f8733d) {
                ghVar.mo18518a(C5271v.m17676b());
            }
        }
    }

    /* renamed from: b */
    public static C3139a m10287b(String str) {
        C3139a aVar = (C3139a) ((Map) f8731b.get()).remove(str);
        return aVar != null ? aVar.mo18526b() : new C3139a(str);
    }

    /* renamed from: a */
    public static void m10286a(boolean z) {
        if (f8733d != z) {
            f8733d = z;
            C3137gf gfVar = f8732c;
            if (gfVar == null) {
                return;
            }
            if (z) {
                gfVar.mo18518a(C5271v.m17676b());
            } else {
                gfVar.mo18517a();
            }
        }
    }

    /* renamed from: a */
    public static void m10285a(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            f8730a = null;
        } else {
            f8730a = new HashSet(collection);
        }
    }

    /* renamed from: a */
    public static void m10284a(String str, @Nullable TreeMap treeMap, @Nullable Map map) {
        m10288b(str, treeMap != null ? C4910bh.m16696a((Object) treeMap) : null, map);
    }

    /* renamed from: a */
    public static C3139a m10280a(String str) {
        C3139a a = new C3139a(str).mo18521a();
        ((Map) f8731b.get()).put(str, a);
        return a;
    }

    /* renamed from: a */
    public static void m10282a(String str, C3139a aVar) {
        if (aVar == null) {
            return;
        }
        if (str.equals(aVar.f8734a)) {
            ((Map) f8731b.get()).put(str, aVar);
        } else {
            String str2 = aVar.f8734a;
        }
    }
}
