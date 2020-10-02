package com.tapjoy.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.bn */
public abstract class C3126bn implements C3125bk, C3129bp {

    /* renamed from: a */
    private HashMap f8714a;

    /* renamed from: com.tapjoy.internal.bn$1 */
    static /* synthetic */ class C31271 {

        /* renamed from: a */
        static final /* synthetic */ int[] f8715a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tapjoy.internal.bs[] r0 = com.tapjoy.internal.C4923bs.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8715a = r0
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C4923bs.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8715a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C4923bs.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8715a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C4923bs.NULL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8715a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C4923bs.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8715a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C4923bs.NUMBER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8715a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C4923bs.STRING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3126bn.C31271.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static C3126bn m10229a(InputStream inputStream) {
        return C3128a.m10246a().mo18486a(inputStream);
    }

    /* renamed from: b */
    public static C3126bn m10231b(String str) {
        return C3128a.m10246a().mo18488a(str);
    }

    /* renamed from: t */
    private boolean m10233t() {
        if (mo18495k() != C4923bs.NULL) {
            return false;
        }
        mo18499o();
        return true;
    }

    /* renamed from: u */
    private Object m10234u() {
        C4923bs k = mo18495k();
        switch (C31271.f8715a[k.ordinal()]) {
            case 1:
                return mo18483c();
            case 2:
                return mo18484d();
            case 3:
                mo18499o();
                return null;
            case 4:
                return Boolean.valueOf(mo18498n());
            case 5:
                return new C4938ci(mo18497m());
            case 6:
                return mo18497m();
            default:
                throw new IllegalStateException("Expected a value but was " + k);
        }
    }

    /* renamed from: c */
    public final String mo18482c(String str) {
        if (m10233t()) {
            return str;
        }
        return mo18497m();
    }

    /* renamed from: d */
    public final Map mo18484d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        mo18479a((Map) linkedHashMap);
        return linkedHashMap;
    }

    /* renamed from: e */
    public final URL mo18485e() {
        URI uri = (URI) mo18475a("BASE_URI");
        if (uri != null) {
            return uri.resolve(m10232d(mo18497m())).toURL();
        }
        return new URL(mo18497m());
    }

    /* renamed from: com.tapjoy.internal.bn$a */
    public static abstract class C3128a {

        /* renamed from: a */
        private static C3128a f8716a;

        /* renamed from: a */
        public static C3128a m10246a() {
            C3128a aVar = f8716a;
            if (aVar != null) {
                return aVar;
            }
            C3128a aVar2 = C4918bo.f13381a;
            f8716a = aVar2;
            return aVar2;
        }

        /* renamed from: a */
        public final C3126bn mo18486a(InputStream inputStream) {
            return mo18487a((Reader) new InputStreamReader(inputStream, C5238jm.f14419c));
        }

        /* renamed from: a */
        public C3126bn mo18487a(Reader reader) {
            return mo18488a(C5250jy.m17615a(reader));
        }

        /* renamed from: a */
        public C3126bn mo18488a(String str) {
            return mo18486a((InputStream) new ByteArrayInputStream(str.getBytes(C5238jm.f14419c.name())));
        }
    }

    /* renamed from: a */
    public final Object mo18475a(String str) {
        HashMap hashMap = this.f8714a;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    /* renamed from: b */
    public final String mo18481b() {
        if (m10233t()) {
            return null;
        }
        return mo18497m();
    }

    /* renamed from: d */
    private static URI m10232d(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new C4927bv(e);
        }
    }

    /* renamed from: a */
    public final void mo18476a(String str, Object obj) {
        if (this.f8714a == null) {
            this.f8714a = new HashMap();
        }
        this.f8714a.put(str, obj);
    }

    /* renamed from: c */
    public final List mo18483c() {
        LinkedList linkedList = new LinkedList();
        m10230a((List) linkedList);
        return linkedList;
    }

    /* renamed from: a */
    public final boolean mo18480a() {
        return mo18495k() == C4923bs.BEGIN_OBJECT;
    }

    /* renamed from: a */
    private void m10230a(List list) {
        mo18490f();
        while (mo18494j()) {
            list.add(m10234u());
        }
        mo18491g();
    }

    /* renamed from: a */
    public final void mo18479a(Map map) {
        mo18492h();
        while (mo18494j()) {
            map.put(mo18496l(), m10234u());
        }
        mo18493i();
    }

    @Nullable
    /* renamed from: a */
    public final Object mo18477a(C4911bi biVar) {
        if (m10233t()) {
            return null;
        }
        return biVar.mo18614a(this);
    }

    /* renamed from: a */
    public final void mo18478a(List list, C4911bi biVar) {
        mo18490f();
        while (mo18494j()) {
            list.add(biVar.mo18614a(this));
        }
        mo18491g();
    }
}
