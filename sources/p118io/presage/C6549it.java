package p118io.presage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: io.presage.it */
final class C6549it implements C6538ii<C6530ia> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final CharSequence f17081a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f17082b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f17083c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C6493gr<CharSequence, Integer, C6431ej<Integer, Integer>> f17084d;

    /* renamed from: io.presage.it$CamembertauCalvados */
    public static final class CamembertauCalvados implements C6520hr, Iterator<C6530ia> {

        /* renamed from: a */
        final /* synthetic */ C6549it f17085a;

        /* renamed from: b */
        private int f17086b = -1;

        /* renamed from: c */
        private int f17087c;

        /* renamed from: d */
        private int f17088d;

        /* renamed from: e */
        private C6530ia f17089e;

        /* renamed from: f */
        private int f17090f;

        CamembertauCalvados(C6549it itVar) {
            this.f17085a = itVar;
            int c = C6533id.m21448c(itVar.f17082b, itVar.f17081a.length());
            this.f17087c = c;
            this.f17088d = c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (r0 < p118io.presage.C6549it.m21466a(r6.f17085a)) goto L_0x0022;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void m21471a() {
            /*
                r6 = this;
                int r0 = r6.f17088d
                r1 = 0
                if (r0 >= 0) goto L_0x000b
                r6.f17086b = r1
                r0 = 0
                r6.f17089e = r0
                return
            L_0x000b:
                io.presage.it r0 = r6.f17085a
                int r0 = r0.f17083c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0022
                int r0 = r6.f17090f
                int r0 = r0 + r3
                r6.f17090f = r0
                io.presage.it r4 = r6.f17085a
                int r4 = r4.f17083c
                if (r0 >= r4) goto L_0x0030
            L_0x0022:
                int r0 = r6.f17088d
                io.presage.it r4 = r6.f17085a
                java.lang.CharSequence r4 = r4.f17081a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0046
            L_0x0030:
                int r0 = r6.f17087c
                io.presage.ia r1 = new io.presage.ia
                io.presage.it r4 = r6.f17085a
                java.lang.CharSequence r4 = r4.f17081a
                int r4 = p118io.presage.C6562jf.m21513a((java.lang.CharSequence) r4)
                r1.<init>(r0, r4)
                r6.f17089e = r1
                r6.f17088d = r2
                goto L_0x009b
            L_0x0046:
                io.presage.it r0 = r6.f17085a
                io.presage.gr r0 = r0.f17084d
                io.presage.it r4 = r6.f17085a
                java.lang.CharSequence r4 = r4.f17081a
                int r5 = r6.f17088d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.mo34520a(r4, r5)
                io.presage.ej r0 = (p118io.presage.C6431ej) r0
                if (r0 != 0) goto L_0x0076
                int r0 = r6.f17087c
                io.presage.ia r1 = new io.presage.ia
                io.presage.it r4 = r6.f17085a
                java.lang.CharSequence r4 = r4.f17081a
                int r4 = p118io.presage.C6562jf.m21513a((java.lang.CharSequence) r4)
                r1.<init>(r0, r4)
                r6.f17089e = r1
                r6.f17088d = r2
                goto L_0x009b
            L_0x0076:
                java.lang.Object r2 = r0.mo35395c()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.mo35396d()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f17087c
                io.presage.ia r4 = p118io.presage.C6533id.m21446a(r4, r2)
                r6.f17089e = r4
                int r2 = r2 + r0
                r6.f17087c = r2
                if (r0 != 0) goto L_0x0098
                r1 = 1
            L_0x0098:
                int r2 = r2 + r1
                r6.f17088d = r2
            L_0x009b:
                r6.f17086b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.presage.C6549it.CamembertauCalvados.m21471a():void");
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public C6530ia next() {
            if (this.f17086b == -1) {
                m21471a();
            }
            if (this.f17086b != 0) {
                C6530ia iaVar = this.f17089e;
                if (iaVar != null) {
                    this.f17089e = null;
                    this.f17086b = -1;
                    return iaVar;
                }
                throw new C6434em("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }

        public final boolean hasNext() {
            if (this.f17086b == -1) {
                m21471a();
            }
            return this.f17086b == 1;
        }

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C6549it(CharSequence charSequence, int i, C6493gr<? super CharSequence, ? super Integer, C6431ej<Integer, Integer>> grVar) {
        this.f17081a = charSequence;
        this.f17084d = grVar;
    }

    /* renamed from: a */
    public final Iterator<C6530ia> mo35540a() {
        return new CamembertauCalvados(this);
    }
}
