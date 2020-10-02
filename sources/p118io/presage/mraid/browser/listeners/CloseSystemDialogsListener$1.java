package p118io.presage.mraid.browser.listeners;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p118io.presage.C6256bt;

/* renamed from: io.presage.mraid.browser.listeners.CloseSystemDialogsListener$1 */
public final class CloseSystemDialogsListener$1 extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C6256bt f17125a;

    public CloseSystemDialogsListener$1(C6256bt btVar) {
        this.f17125a = btVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f17125a.f16859c.mo34805d()) {
            this.f17125a.m21006c();
        }
    }
}
