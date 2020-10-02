package androidx.browser.p012a;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import java.util.List;

/* renamed from: androidx.browser.a.f */
/* compiled from: CustomTabsSession */
public final class C0657f {

    /* renamed from: a */
    private final ICustomTabsService f1629a;

    /* renamed from: b */
    private final ICustomTabsCallback f1630b;

    /* renamed from: c */
    private final ComponentName f1631c;

    /* renamed from: d */
    private final PendingIntent f1632d;

    C0657f(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName, PendingIntent pendingIntent) {
        this.f1629a = iCustomTabsService;
        this.f1630b = iCustomTabsCallback;
        this.f1631c = componentName;
        this.f1632d = pendingIntent;
    }

    /* renamed from: b */
    private Bundle m1911b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m1910a(bundle2);
        return bundle2;
    }

    /* renamed from: a */
    public boolean mo3661a(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            return this.f1629a.mayLaunchUrl(this.f1630b, uri, m1911b(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public PendingIntent mo3663c() {
        return this.f1632d;
    }

    /* renamed from: a */
    private void m1910a(Bundle bundle) {
        PendingIntent pendingIntent = this.f1632d;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IBinder mo3660a() {
        return this.f1630b.asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ComponentName mo3662b() {
        return this.f1631c;
    }
}
