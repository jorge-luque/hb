package p163cz.msebera.android.httpclient.impl.conn.p185r;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.r.h */
/* compiled from: WaitingThread */
public class C5832h {

    /* renamed from: a */
    private final Condition f15064a;

    /* renamed from: b */
    private Thread f15065b;

    /* renamed from: c */
    private boolean f15066c;

    public C5832h(Condition condition, C5829f fVar) {
        C5886a.m18894a(condition, "Condition");
        this.f15064a = condition;
    }

    /* renamed from: a */
    public boolean mo33609a(Date date) throws InterruptedException {
        boolean z;
        if (this.f15065b != null) {
            throw new IllegalStateException("A thread is already waiting on this object.\ncaller: " + Thread.currentThread() + "\nwaiter: " + this.f15065b);
        } else if (!this.f15066c) {
            this.f15065b = Thread.currentThread();
            if (date != null) {
                try {
                    z = this.f15064a.awaitUntil(date);
                } catch (Throwable th) {
                    this.f15065b = null;
                    throw th;
                }
            } else {
                this.f15064a.await();
                z = true;
            }
            if (!this.f15066c) {
                this.f15065b = null;
                return z;
            }
            throw new InterruptedException("Operation interrupted");
        } else {
            throw new InterruptedException("Operation interrupted");
        }
    }

    /* renamed from: b */
    public void mo33610b() {
        if (this.f15065b != null) {
            this.f15064a.signalAll();
            return;
        }
        throw new IllegalStateException("Nobody waiting on this object.");
    }

    /* renamed from: a */
    public void mo33608a() {
        this.f15066c = true;
        this.f15064a.signalAll();
    }
}
