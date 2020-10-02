package com.google.zxing.p132f.p133b;

import com.google.android.gms.games.Notifications;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.zxing.f.b.d */
/* compiled from: HighLevelEncoder */
public final class C4074d {

    /* renamed from: b */
    static final String[] f10922b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: c */
    static final int[][] f10923c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: d */
    private static final int[][] f10924d;

    /* renamed from: e */
    static final int[][] f10925e;

    /* renamed from: a */
    private final byte[] f10926a;

    /* renamed from: com.google.zxing.f.b.d$a */
    /* compiled from: HighLevelEncoder */
    class C4075a implements Comparator<C4077f> {
        C4075a(C4074d dVar) {
        }

        /* renamed from: a */
        public int compare(C4077f fVar, C4077f fVar2) {
            return fVar.mo28307b() - fVar2.mo28307b();
        }
    }

    static {
        Class<int> cls = int.class;
        int[][] iArr = (int[][]) Array.newInstance(cls, new int[]{5, 256});
        f10924d = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            f10924d[0][i] = (i - 65) + 2;
        }
        f10924d[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            f10924d[1][i2] = (i2 - 97) + 2;
        }
        f10924d[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            f10924d[2][i3] = (i3 - 48) + 2;
        }
        int[][] iArr2 = f10924d;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, Notifications.NOTIFICATION_TYPES_ALL};
        for (int i4 = 0; i4 < 28; i4++) {
            f10924d[3][iArr3[i4]] = i4;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i5 = 0; i5 < 31; i5++) {
            if (iArr4[i5] > 0) {
                f10924d[4][iArr4[i5]] = i5;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance(cls, new int[]{6, 6});
        f10925e = iArr5;
        for (int[] fill : iArr5) {
            Arrays.fill(fill, -1);
        }
        int[][] iArr6 = f10925e;
        iArr6[0][4] = 0;
        iArr6[1][4] = 0;
        iArr6[1][0] = 28;
        iArr6[3][4] = 0;
        iArr6[2][4] = 0;
        iArr6[2][0] = 15;
    }

    public C4074d(byte[] bArr) {
        this.f10926a = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0047  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.p134g.C4079a mo28298a() {
        /*
            r8 = this;
            com.google.zxing.f.b.f r0 = com.google.zxing.p132f.p133b.C4077f.f10929e
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = 0
        L_0x0008:
            byte[] r3 = r8.f10926a
            int r4 = r3.length
            if (r2 >= r4) goto L_0x004e
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L_0x0015
            byte r3 = r3[r4]
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            byte[] r5 = r8.f10926a
            byte r5 = r5[r2]
            r6 = 13
            if (r5 == r6) goto L_0x003a
            r6 = 44
            r7 = 32
            if (r5 == r6) goto L_0x0036
            r6 = 46
            if (r5 == r6) goto L_0x0032
            r6 = 58
            if (r5 == r6) goto L_0x002e
        L_0x002c:
            r3 = 0
            goto L_0x003f
        L_0x002e:
            if (r3 != r7) goto L_0x002c
            r3 = 5
            goto L_0x003f
        L_0x0032:
            if (r3 != r7) goto L_0x002c
            r3 = 3
            goto L_0x003f
        L_0x0036:
            if (r3 != r7) goto L_0x002c
            r3 = 4
            goto L_0x003f
        L_0x003a:
            r5 = 10
            if (r3 != r5) goto L_0x002c
            r3 = 2
        L_0x003f:
            if (r3 <= 0) goto L_0x0047
            java.util.Collection r0 = m13579a((java.lang.Iterable<com.google.zxing.p132f.p133b.C4077f>) r0, (int) r2, (int) r3)
            r2 = r4
            goto L_0x004b
        L_0x0047:
            java.util.Collection r0 = r8.m13578a(r0, r2)
        L_0x004b:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x004e:
            com.google.zxing.f.b.d$a r1 = new com.google.zxing.f.b.d$a
            r1.<init>(r8)
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            com.google.zxing.f.b.f r0 = (com.google.zxing.p132f.p133b.C4077f) r0
            byte[] r1 = r8.f10926a
            com.google.zxing.g.a r0 = r0.mo28305a((byte[]) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p132f.p133b.C4074d.mo28298a():com.google.zxing.g.a");
    }

    /* renamed from: a */
    private Collection<C4077f> m13578a(Iterable<C4077f> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        for (C4077f a : iterable) {
            m13581a(a, i, (Collection<C4077f>) linkedList);
        }
        return m13577a(linkedList);
    }

    /* renamed from: a */
    private void m13581a(C4077f fVar, int i, Collection<C4077f> collection) {
        char c = (char) (this.f10926a[i] & 255);
        boolean z = f10924d[fVar.mo28310c()][c] > 0;
        C4077f fVar2 = null;
        for (int i2 = 0; i2 <= 4; i2++) {
            int i3 = f10924d[i2][c];
            if (i3 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.mo28308b(i);
                }
                if (!z || i2 == fVar.mo28310c() || i2 == 2) {
                    collection.add(fVar2.mo28304a(i2, i3));
                }
                if (!z && f10925e[fVar.mo28310c()][i2] >= 0) {
                    collection.add(fVar2.mo28309b(i2, i3));
                }
            }
        }
        if (fVar.mo28302a() > 0 || f10924d[fVar.mo28310c()][c] == 0) {
            collection.add(fVar.mo28303a(i));
        }
    }

    /* renamed from: a */
    private static Collection<C4077f> m13579a(Iterable<C4077f> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        for (C4077f a : iterable) {
            m13580a(a, i, i2, linkedList);
        }
        return m13577a(linkedList);
    }

    /* renamed from: a */
    private static void m13580a(C4077f fVar, int i, int i2, Collection<C4077f> collection) {
        C4077f b = fVar.mo28308b(i);
        collection.add(b.mo28304a(4, i2));
        if (fVar.mo28310c() != 4) {
            collection.add(b.mo28309b(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(b.mo28304a(2, 16 - i2).mo28304a(2, 1));
        }
        if (fVar.mo28302a() > 0) {
            collection.add(fVar.mo28303a(i).mo28303a(i + 1));
        }
    }

    /* renamed from: a */
    private static Collection<C4077f> m13577a(Iterable<C4077f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (C4077f next : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C4077f fVar = (C4077f) it.next();
                if (fVar.mo28306a(next)) {
                    z = false;
                    break;
                } else if (next.mo28306a(fVar)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }
}
