package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.ap */
public final class C4892ap {

    /* renamed from: com.tapjoy.internal.ap$a */
    public static final class C4893a implements C4895as {

        /* renamed from: a */
        private final C3122aq f13361a;

        public C4893a(C3122aq aqVar) {
            this.f13361a = aqVar;
        }

        /* renamed from: a */
        public final Object mo18472a(Object obj) {
            C4891ao a;
            Object a2;
            synchronized (this.f13361a) {
                a = this.f13361a.mo18474a(obj, false);
            }
            if (a == null) {
                return null;
            }
            synchronized (a) {
                a2 = a.mo30925a();
            }
            return a2;
        }

        /* renamed from: a */
        public final void mo18473a(Object obj, Object obj2) {
            C4891ao a;
            synchronized (this.f13361a) {
                a = this.f13361a.mo18474a(obj, true);
            }
            synchronized (a) {
                a.mo30926a(obj2);
            }
        }
    }
}
