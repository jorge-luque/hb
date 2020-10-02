package com.ogury.p159cm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.ogury.cm.babab */
final class babab implements baabc<baabb> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final CharSequence f12172a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f12173b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f12174c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final accba<CharSequence, Integer, acbaa<Integer, Integer>> f12175d;

    /* renamed from: com.ogury.cm.babab$aaaaa */
    public static final class aaaaa implements baaaa, Iterator<baabb> {

        /* renamed from: a */
        final /* synthetic */ babab f12176a;

        /* renamed from: b */
        private int f12177b = -1;

        /* renamed from: c */
        private int f12178c;

        /* renamed from: d */
        private int f12179d;

        /* renamed from: e */
        private baabb f12180e;

        /* renamed from: f */
        private int f12181f;

        aaaaa(babab babab) {
            this.f12176a = babab;
            int d = babab.f12173b;
            int length = babab.f12172a.length();
            if (length >= 0) {
                if (d < 0) {
                    d = 0;
                } else if (d > length) {
                    d = length;
                }
                this.f12178c = d;
                this.f12179d = d;
                return;
            }
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (r0 < com.ogury.p159cm.babab.m15253a(r7.f12176a)) goto L_0x0022;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void m15258a() {
            /*
                r7 = this;
                int r0 = r7.f12179d
                r1 = 0
                if (r0 >= 0) goto L_0x000b
                r7.f12177b = r1
                r0 = 0
                r7.f12180e = r0
                return
            L_0x000b:
                com.ogury.cm.babab r0 = r7.f12176a
                int r0 = r0.f12174c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0022
                int r0 = r7.f12181f
                int r0 = r0 + r3
                r7.f12181f = r0
                com.ogury.cm.babab r4 = r7.f12176a
                int r4 = r4.f12174c
                if (r0 >= r4) goto L_0x0030
            L_0x0022:
                int r0 = r7.f12179d
                com.ogury.cm.babab r4 = r7.f12176a
                java.lang.CharSequence r4 = r4.f12172a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0046
            L_0x0030:
                int r0 = r7.f12178c
                com.ogury.cm.baabb r1 = new com.ogury.cm.baabb
                com.ogury.cm.babab r4 = r7.f12176a
                java.lang.CharSequence r4 = r4.f12172a
                int r4 = com.ogury.p159cm.babac.m15266b(r4)
                r1.<init>(r0, r4)
            L_0x0041:
                r7.f12180e = r1
            L_0x0043:
                r7.f12179d = r2
                goto L_0x00a5
            L_0x0046:
                com.ogury.cm.babab r0 = r7.f12176a
                com.ogury.cm.accba r0 = r0.f12175d
                com.ogury.cm.babab r4 = r7.f12176a
                java.lang.CharSequence r4 = r4.f12172a
                int r5 = r7.f12179d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.mo29538a(r4, r5)
                com.ogury.cm.acbaa r0 = (com.ogury.p159cm.acbaa) r0
                if (r0 != 0) goto L_0x0072
                int r0 = r7.f12178c
                com.ogury.cm.baabb r1 = new com.ogury.cm.baabb
                com.ogury.cm.babab r4 = r7.f12176a
                java.lang.CharSequence r4 = r4.f12172a
                int r4 = com.ogury.p159cm.babac.m15266b(r4)
                r1.<init>(r0, r4)
                goto L_0x0041
            L_0x0072:
                java.lang.Object r2 = r0.mo29526c()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.mo29527d()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r7.f12178c
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r2 > r5) goto L_0x0093
                com.ogury.cm.baabb$aaaaa r4 = com.ogury.p159cm.baabb.f12159b
                com.ogury.cm.baabb r4 = com.ogury.p159cm.baabb.f12160c
                goto L_0x009b
            L_0x0093:
                com.ogury.cm.baabb r5 = new com.ogury.cm.baabb
                int r6 = r2 + -1
                r5.<init>(r4, r6)
                r4 = r5
            L_0x009b:
                r7.f12180e = r4
                int r2 = r2 + r0
                r7.f12178c = r2
                if (r0 != 0) goto L_0x00a3
                r1 = 1
            L_0x00a3:
                int r2 = r2 + r1
                goto L_0x0043
            L_0x00a5:
                r7.f12177b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ogury.p159cm.babab.aaaaa.m15258a():void");
        }

        public final boolean hasNext() {
            if (this.f12177b == -1) {
                m15258a();
            }
            return this.f12177b == 1;
        }

        public final /* synthetic */ Object next() {
            if (this.f12177b == -1) {
                m15258a();
            }
            if (this.f12177b != 0) {
                baabb baabb = this.f12180e;
                if (baabb != null) {
                    this.f12180e = null;
                    this.f12177b = -1;
                    return baabb;
                }
                throw new acbab("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public babab(CharSequence charSequence, int i, int i2, accba<? super CharSequence, ? super Integer, acbaa<Integer, Integer>> accba) {
        accbb.m15218b(charSequence, "input");
        accbb.m15218b(accba, "getNextMatch");
        this.f12172a = charSequence;
        this.f12175d = accba;
    }

    /* renamed from: a */
    public final Iterator<baabb> mo29561a() {
        return new aaaaa(this);
    }
}
