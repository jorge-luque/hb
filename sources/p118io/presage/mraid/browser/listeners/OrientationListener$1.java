package p118io.presage.mraid.browser.listeners;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import p118io.presage.C6258bv;
import p118io.presage.C6514hl;

/* renamed from: io.presage.mraid.browser.listeners.OrientationListener$1 */
public final class OrientationListener$1 extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C6258bv f17126a;

    public OrientationListener$1(C6258bv bvVar) {
        this.f17126a = bvVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (C6514hl.m21416a((Object) "android.intent.action.CONFIGURATION_CHANGED", (Object) intent.getAction())) {
            Resources resources = context.getResources();
            C6514hl.m21414a((Object) resources, "context.resources");
            int i = resources.getConfiguration().orientation;
            if (this.f17126a.f16861a != i) {
                this.f17126a.f16861a = i;
                this.f17126a.m21012c();
            }
        }
    }
}
