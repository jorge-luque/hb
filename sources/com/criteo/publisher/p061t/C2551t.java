package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2520f;
import com.criteo.publisher.p061t.C2522g;
import com.criteo.publisher.p061t.C2524h;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: com.criteo.publisher.t.t */
public abstract class C2551t {

    /* renamed from: com.criteo.publisher.t.t$b */
    public static abstract class C2553b {
        /* renamed from: a */
        static C2553b m9593a(String str, boolean z) {
            return new C2524h(str, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract boolean mo10559a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract String mo10560b();

        /* renamed from: a */
        public static TypeAdapter<C2553b> m9594a(Gson gson) {
            return new C2524h.C2525a(gson);
        }
    }

    /* renamed from: a */
    static C2551t m9579a(Collection<C2540m> collection, String str, int i) {
        ArrayList arrayList = new ArrayList();
        for (C2540m a : collection) {
            arrayList.add(C2552a.m9584a(a));
        }
        return new C2520f(arrayList, str, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract List<C2552a> mo10544a();

    /* access modifiers changed from: package-private */
    @SerializedName("profile_id")
    /* renamed from: b */
    public abstract int mo10545b();

    /* access modifiers changed from: package-private */
    @SerializedName("wrapper_version")
    /* renamed from: c */
    public abstract String mo10546c();

    /* renamed from: a */
    public static TypeAdapter<C2551t> m9580a(Gson gson) {
        return new C2520f.C2521a(gson);
    }

    /* renamed from: com.criteo.publisher.t.t$a */
    public static abstract class C2552a {
        /* renamed from: a */
        static C2552a m9584a(C2540m mVar) {
            return new C2522g(Collections.singletonList(C2553b.m9593a(mVar.mo10526d(), mVar.mo10529f())), m9586a(mVar.mo10525c(), mVar.mo10524b()), mVar.mo10530g(), 0, m9586a(mVar.mo10523a(), mVar.mo10524b()), mVar.mo10527e());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract Long mo10550a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract long mo10551b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract Long mo10552c();

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract String mo10553d();

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public abstract List<C2553b> mo10554e();

        /* access modifiers changed from: package-private */
        @SerializedName("isTimeout")
        /* renamed from: f */
        public abstract boolean mo10556f();

        /* renamed from: a */
        public static TypeAdapter<C2552a> m9585a(Gson gson) {
            return new C2522g.C2523a(gson);
        }

        /* renamed from: a */
        private static Long m9586a(Long l, Long l2) {
            if (l == null || l2 == null) {
                return null;
            }
            return Long.valueOf(l.longValue() - l2.longValue());
        }
    }
}
