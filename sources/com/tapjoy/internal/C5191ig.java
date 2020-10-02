package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.nio.ByteBuffer;

/* renamed from: com.tapjoy.internal.ig */
public final class C5191ig extends ImageView implements Runnable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C3161ic f14243a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Bitmap f14244b;

    /* renamed from: c */
    private final Handler f14245c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private boolean f14246d;

    /* renamed from: e */
    private boolean f14247e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f14248f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Thread f14249g;

    /* renamed from: h */
    private C5195b f14250h = null;

    /* renamed from: i */
    private long f14251i = -1;

    /* renamed from: j */
    private C5194a f14252j = null;

    /* renamed from: k */
    private final Runnable f14253k = new Runnable() {
        public final void run() {
            if (C5191ig.this.f14244b != null && !C5191ig.this.f14244b.isRecycled()) {
                C5191ig igVar = C5191ig.this;
                igVar.setImageBitmap(igVar.f14244b);
            }
        }
    };

    /* renamed from: l */
    private final Runnable f14254l = new Runnable() {
        public final void run() {
            Bitmap unused = C5191ig.this.f14244b = null;
            C3161ic unused2 = C5191ig.this.f14243a = null;
            Thread unused3 = C5191ig.this.f14249g = null;
            boolean unused4 = C5191ig.this.f14248f = false;
        }
    };

    /* renamed from: com.tapjoy.internal.ig$a */
    public interface C5194a {
    }

    /* renamed from: com.tapjoy.internal.ig$b */
    public interface C5195b {
        /* renamed from: a */
        Bitmap mo31371a();
    }

    public C5191ig(Context context) {
        super(context);
    }

    public final long getFramesDisplayDuration() {
        return this.f14251i;
    }

    public final int getGifHeight() {
        return this.f14243a.f8822c.f14232g;
    }

    public final int getGifWidth() {
        return this.f14243a.f8822c.f14231f;
    }

    public final C5194a getOnAnimationStop() {
        return this.f14252j;
    }

    public final C5195b getOnFrameAvailable() {
        return this.f14250h;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo31357c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047 A[Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0008  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
        L_0x0000:
            boolean r0 = r9.f14246d
            if (r0 != 0) goto L_0x0008
            boolean r0 = r9.f14247e
            if (r0 == 0) goto L_0x00ab
        L_0x0008:
            com.tapjoy.internal.ic r0 = r9.f14243a
            com.tapjoy.internal.ie r1 = r0.f8822c
            int r1 = r1.f14228c
            r2 = -1
            r3 = 1
            r4 = 0
            if (r1 > 0) goto L_0x0015
        L_0x0013:
            r3 = 0
            goto L_0x0035
        L_0x0015:
            int r5 = r0.f8820a
            int r1 = r1 + -1
            if (r5 != r1) goto L_0x0020
            int r1 = r0.f8821b
            int r1 = r1 + r3
            r0.f8821b = r1
        L_0x0020:
            com.tapjoy.internal.ie r1 = r0.f8822c
            int r1 = r1.f14238m
            if (r1 == r2) goto L_0x002b
            int r5 = r0.f8821b
            if (r5 <= r1) goto L_0x002b
            goto L_0x0013
        L_0x002b:
            int r1 = r0.f8820a
            int r1 = r1 + r3
            com.tapjoy.internal.ie r5 = r0.f8822c
            int r5 = r5.f14228c
            int r1 = r1 % r5
            r0.f8820a = r1
        L_0x0035:
            r0 = 0
            long r5 = java.lang.System.nanoTime()     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }
            com.tapjoy.internal.ic r7 = r9.f14243a     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }
            android.graphics.Bitmap r7 = r7.mo18616a()     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }
            r9.f14244b = r7     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }
            com.tapjoy.internal.ig$b r7 = r9.f14250h     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }
            if (r7 == 0) goto L_0x004f
            com.tapjoy.internal.ig$b r7 = r9.f14250h     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }
            android.graphics.Bitmap r7 = r7.mo31371a()     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }
            r9.f14244b = r7     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }
        L_0x004f:
            long r7 = java.lang.System.nanoTime()     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0062 }
            long r7 = r7 - r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r7 / r5
            android.os.Handler r5 = r9.f14245c     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0060 }
            java.lang.Runnable r6 = r9.f14253k     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0060 }
            r5.post(r6)     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0060 }
            goto L_0x0063
        L_0x0060:
            goto L_0x0063
        L_0x0062:
            r7 = r0
        L_0x0063:
            r9.f14247e = r4
            boolean r5 = r9.f14246d
            if (r5 == 0) goto L_0x00a9
            if (r3 != 0) goto L_0x006c
            goto L_0x00a9
        L_0x006c:
            com.tapjoy.internal.ic r3 = r9.f14243a     // Catch:{ InterruptedException -> 0x00a3 }
            com.tapjoy.internal.ie r5 = r3.f8822c     // Catch:{ InterruptedException -> 0x00a3 }
            int r5 = r5.f14228c     // Catch:{ InterruptedException -> 0x00a3 }
            if (r5 <= 0) goto L_0x0090
            int r5 = r3.f8820a     // Catch:{ InterruptedException -> 0x00a3 }
            if (r5 >= 0) goto L_0x0079
            goto L_0x0090
        L_0x0079:
            int r4 = r3.f8820a     // Catch:{ InterruptedException -> 0x00a3 }
            if (r4 < 0) goto L_0x008f
            com.tapjoy.internal.ie r5 = r3.f8822c     // Catch:{ InterruptedException -> 0x00a3 }
            int r5 = r5.f14228c     // Catch:{ InterruptedException -> 0x00a3 }
            if (r4 >= r5) goto L_0x008f
            com.tapjoy.internal.ie r2 = r3.f8822c     // Catch:{ InterruptedException -> 0x00a3 }
            java.util.List r2 = r2.f14230e     // Catch:{ InterruptedException -> 0x00a3 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ InterruptedException -> 0x00a3 }
            com.tapjoy.internal.id r2 = (com.tapjoy.internal.C5188id) r2     // Catch:{ InterruptedException -> 0x00a3 }
            int r2 = r2.f14223i     // Catch:{ InterruptedException -> 0x00a3 }
        L_0x008f:
            r4 = r2
        L_0x0090:
            long r2 = (long) r4     // Catch:{ InterruptedException -> 0x00a3 }
            long r2 = r2 - r7
            int r3 = (int) r2     // Catch:{ InterruptedException -> 0x00a3 }
            if (r3 <= 0) goto L_0x00a4
            long r4 = r9.f14251i     // Catch:{ InterruptedException -> 0x00a3 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x009e
            long r0 = r9.f14251i     // Catch:{ InterruptedException -> 0x00a3 }
            goto L_0x009f
        L_0x009e:
            long r0 = (long) r3     // Catch:{ InterruptedException -> 0x00a3 }
        L_0x009f:
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00a3 }
            goto L_0x00a4
        L_0x00a3:
        L_0x00a4:
            boolean r0 = r9.f14246d
            if (r0 != 0) goto L_0x0000
            goto L_0x00ab
        L_0x00a9:
            r9.f14246d = r4
        L_0x00ab:
            boolean r0 = r9.f14248f
            if (r0 == 0) goto L_0x00b6
            android.os.Handler r0 = r9.f14245c
            java.lang.Runnable r1 = r9.f14254l
            r0.post(r1)
        L_0x00b6:
            r0 = 0
            r9.f14249g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5191ig.run():void");
    }

    public final void setBytes(byte[] bArr) {
        C3161ic icVar = new C3161ic();
        this.f14243a = icVar;
        try {
            icVar.mo18615a(bArr);
            if (this.f14246d) {
                m17444e();
            } else {
                m17443d();
            }
        } catch (Exception unused) {
            this.f14243a = null;
        }
    }

    public final void setFramesDisplayDuration(long j) {
        this.f14251i = j;
    }

    public final void setOnAnimationStop(C5194a aVar) {
        this.f14252j = aVar;
    }

    public final void setOnFrameAvailable(C5195b bVar) {
        this.f14250h = bVar;
    }

    /* renamed from: d */
    private void m17443d() {
        boolean z;
        C3161ic icVar = this.f14243a;
        if (icVar.f8820a != 0) {
            if (-1 >= icVar.f8822c.f14228c) {
                z = false;
            } else {
                icVar.f8820a = -1;
                z = true;
            }
            if (z && !this.f14246d) {
                this.f14247e = true;
                m17444e();
            }
        }
    }

    /* renamed from: e */
    private void m17444e() {
        if ((this.f14246d || this.f14247e) && this.f14243a != null && this.f14249g == null) {
            Thread thread = new Thread(this);
            this.f14249g = thread;
            thread.start();
        }
    }

    /* renamed from: a */
    public final void mo31355a(C5189ie ieVar, byte[] bArr) {
        try {
            this.f14243a = new C3161ic(new C3163ih(), ieVar, ByteBuffer.wrap(bArr));
            if (this.f14246d) {
                m17444e();
            } else {
                m17443d();
            }
        } catch (Exception unused) {
            this.f14243a = null;
        }
    }

    /* renamed from: b */
    public final void mo31356b() {
        this.f14246d = false;
        Thread thread = this.f14249g;
        if (thread != null) {
            thread.interrupt();
            this.f14249g = null;
        }
    }

    /* renamed from: c */
    public final void mo31357c() {
        this.f14246d = false;
        this.f14247e = false;
        this.f14248f = true;
        mo31356b();
        this.f14245c.post(this.f14254l);
    }

    /* renamed from: a */
    public final void mo31354a() {
        this.f14246d = true;
        m17444e();
    }
}
