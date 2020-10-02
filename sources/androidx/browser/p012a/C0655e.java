package androidx.browser.p012a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;

/* renamed from: androidx.browser.a.e */
/* compiled from: CustomTabsServiceConnection */
public abstract class C0655e implements ServiceConnection {

    /* renamed from: a */
    private Context f1628a;

    /* renamed from: androidx.browser.a.e$a */
    /* compiled from: CustomTabsServiceConnection */
    class C0656a extends C0646c {
        C0656a(C0655e eVar, ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
            super(iCustomTabsService, componentName, context);
        }
    }

    /* renamed from: a */
    public abstract void mo3657a(ComponentName componentName, C0646c cVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3658a(Context context) {
        this.f1628a = context;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f1628a != null) {
            mo3657a(componentName, new C0656a(this, ICustomTabsService.Stub.asInterface(iBinder), componentName, this.f1628a));
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }
}
