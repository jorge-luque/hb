package p118io.presage.core;

import android.content.BroadcastReceiver;

/* renamed from: io.presage.core.lIllIIIl */
public class lIllIIIl implements Runnable {
    public final /* synthetic */ lIllIlII IIIIIIII;

    public lIllIIIl(lIllIlII lillilii) {
        this.IIIIIIII = lillilii;
    }

    public void run() {
        try {
            BroadcastReceiver broadcastReceiver = this.IIIIIIII.IIIIIlll;
            Thread.currentThread().getName();
            this.IIIIIIII.IIIIIIII.unregisterReceiver(this.IIIIIIII.IIIIIlll);
        } catch (IllegalArgumentException unused) {
        }
        lIllIlII.IIIIIIII(this.IIIIIIII);
    }
}
