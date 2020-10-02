package p118io.presage.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: io.presage.core.lIllIIlI */
public class lIllIIlI extends BroadcastReceiver {
    public final /* synthetic */ lIllIlII IIIIIIII;

    public lIllIIlI(lIllIlII lillilii) {
        this.IIIIIIII = lillilii;
    }

    public void onReceive(Context context, Intent intent) {
        intent.getAction();
        Thread.currentThread().getName();
        if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false) && intent.getDataString() != null) {
            intent.getDataString();
            Thread.currentThread().getName();
            if (intent.getDataString().replace(lIllIlII.IIIIlIlI, "").trim().equals(this.IIIIIIII.IIIIIIlI.IIIIIIIl)) {
                try {
                    this.IIIIIIII.IIIIIIII.unregisterReceiver(this);
                    this.IIIIIIII.IIIIIlII.removeCallbacks(this.IIIIIIII.IIIIIlIl);
                } catch (IllegalArgumentException unused) {
                }
                this.IIIIIIII.IIIIIIlI();
            }
        }
    }
}
