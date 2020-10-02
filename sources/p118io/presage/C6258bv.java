package p118io.presage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import p118io.presage.mraid.browser.listeners.OrientationListener$1;

/* renamed from: io.presage.bv */
public final class C6258bv {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f16861a;

    /* renamed from: b */
    private final BroadcastReceiver f16862b = new OrientationListener$1(this);

    /* renamed from: c */
    private final Context f16863c;

    /* renamed from: d */
    private final C6247bk f16864d;

    public C6258bv(Context context, C6247bk bkVar) {
        this.f16863c = context;
        this.f16864d = bkVar;
        Resources resources = context.getResources();
        C6514hl.m21414a((Object) resources, "context.resources");
        this.f16861a = resources.getConfiguration().orientation;
        m21010b();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m21012c() {
        this.f16864d.mo34804c();
    }

    /* renamed from: b */
    private final void m21010b() {
        this.f16863c.registerReceiver(this.f16862b, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    /* renamed from: a */
    public final void mo34846a() {
        try {
            this.f16863c.unregisterReceiver(this.f16862b);
        } catch (Exception unused) {
        }
    }
}
