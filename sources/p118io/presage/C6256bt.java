package p118io.presage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import p118io.presage.mraid.browser.listeners.CloseSystemDialogsListener$1;

/* renamed from: io.presage.bt */
public final class C6256bt {

    /* renamed from: a */
    private final BroadcastReceiver f16857a = new CloseSystemDialogsListener$1(this);

    /* renamed from: b */
    private final Context f16858b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C6247bk f16859c;

    public C6256bt(Context context, C6247bk bkVar) {
        this.f16858b = context;
        this.f16859c = bkVar;
        m21004b();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m21006c() {
        this.f16859c.mo34803b();
    }

    /* renamed from: b */
    private final void m21004b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.f16858b.registerReceiver(this.f16857a, intentFilter);
    }

    /* renamed from: a */
    public final void mo34844a() {
        try {
            this.f16858b.unregisterReceiver(this.f16857a);
        } catch (Throwable unused) {
        }
    }
}
