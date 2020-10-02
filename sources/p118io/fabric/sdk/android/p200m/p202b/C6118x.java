package p118io.fabric.sdk.android.p200m.p202b;

import android.os.SystemClock;
import android.util.Log;

/* renamed from: io.fabric.sdk.android.m.b.x */
/* compiled from: TimingMetric */
public class C6118x {

    /* renamed from: a */
    private final String f16095a;

    /* renamed from: b */
    private final String f16096b;

    /* renamed from: c */
    private final boolean f16097c;

    /* renamed from: d */
    private long f16098d;

    /* renamed from: e */
    private long f16099e;

    public C6118x(String str, String str2) {
        this.f16095a = str;
        this.f16096b = str2;
        this.f16097c = !Log.isLoggable(str2, 2);
    }

    /* renamed from: c */
    private void m19835c() {
        this.f16095a + ": " + this.f16099e + "ms";
    }

    /* renamed from: a */
    public synchronized void mo34215a() {
        if (!this.f16097c) {
            this.f16098d = SystemClock.elapsedRealtime();
            this.f16099e = 0;
        }
    }

    /* renamed from: b */
    public synchronized void mo34216b() {
        if (!this.f16097c) {
            if (this.f16099e == 0) {
                this.f16099e = SystemClock.elapsedRealtime() - this.f16098d;
                m19835c();
            }
        }
    }
}
