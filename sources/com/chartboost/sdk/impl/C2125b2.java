package com.chartboost.sdk.impl;

import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.chartboost.sdk.impl.b2 */
public class C2125b2 extends OutputStream {

    /* renamed from: f */
    private static final byte[] f7114f = new byte[0];

    /* renamed from: a */
    private final List<byte[]> f7115a;

    /* renamed from: b */
    private int f7116b;

    /* renamed from: c */
    private int f7117c;

    /* renamed from: d */
    private byte[] f7118d;

    /* renamed from: e */
    private int f7119e;

    public C2125b2() {
        this(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
    }

    /* renamed from: a */
    private void m8449a(int i) {
        if (this.f7116b < this.f7115a.size() - 1) {
            this.f7117c += this.f7118d.length;
            int i2 = this.f7116b + 1;
            this.f7116b = i2;
            this.f7118d = this.f7115a.get(i2);
            return;
        }
        byte[] bArr = this.f7118d;
        if (bArr == null) {
            this.f7117c = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.f7117c);
            this.f7117c += this.f7118d.length;
        }
        this.f7116b++;
        byte[] bArr2 = new byte[i];
        this.f7118d = bArr2;
        this.f7115a.add(bArr2);
    }

    public void close() throws IOException {
    }

    public String toString() {
        return new String(mo9280a());
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                int i4 = this.f7119e + i2;
                int i5 = this.f7119e - this.f7117c;
                while (i2 > 0) {
                    int min = Math.min(i2, this.f7118d.length - i5);
                    System.arraycopy(bArr, i3 - i2, this.f7118d, i5, min);
                    i2 -= min;
                    if (i2 > 0) {
                        m8449a(i4);
                        i5 = 0;
                    }
                }
                this.f7119e = i4;
            }
        }
    }

    public C2125b2(int i) {
        this.f7115a = new ArrayList();
        if (i >= 0) {
            synchronized (this) {
                m8449a(i);
            }
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    public synchronized void write(int i) {
        int i2 = this.f7119e;
        int i3 = i2 - this.f7117c;
        if (i3 == this.f7118d.length) {
            m8449a(i2 + 1);
            i3 = 0;
        }
        this.f7118d[i3] = (byte) i;
        this.f7119e++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] mo9280a() {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.f7119e     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0009
            byte[] r0 = f7114f     // Catch:{ all -> 0x002d }
            monitor-exit(r7)
            return r0
        L_0x0009:
            byte[] r1 = new byte[r0]     // Catch:{ all -> 0x002d }
            java.util.List<byte[]> r2 = r7.f7115a     // Catch:{ all -> 0x002d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x002d }
            r3 = 0
            r4 = 0
        L_0x0013:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x002d }
            if (r5 == 0) goto L_0x002b
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x002d }
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x002d }
            int r6 = r5.length     // Catch:{ all -> 0x002d }
            int r6 = java.lang.Math.min(r6, r0)     // Catch:{ all -> 0x002d }
            java.lang.System.arraycopy(r5, r3, r1, r4, r6)     // Catch:{ all -> 0x002d }
            int r4 = r4 + r6
            int r0 = r0 - r6
            if (r0 != 0) goto L_0x0013
        L_0x002b:
            monitor-exit(r7)
            return r1
        L_0x002d:
            r0 = move-exception
            monitor-exit(r7)
            goto L_0x0031
        L_0x0030:
            throw r0
        L_0x0031:
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2125b2.mo9280a():byte[]");
    }
}
