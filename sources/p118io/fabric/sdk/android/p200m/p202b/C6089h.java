package p118io.fabric.sdk.android.p200m.p202b;

import android.os.Process;

/* renamed from: io.fabric.sdk.android.m.b.h */
/* compiled from: BackgroundPriorityRunnable */
public abstract class C6089h implements Runnable {
    /* access modifiers changed from: protected */
    public abstract void onRun();

    public final void run() {
        Process.setThreadPriority(10);
        onRun();
    }
}
