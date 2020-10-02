package androidx.browser.p012a;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;

/* renamed from: androidx.browser.a.c */
/* compiled from: CustomTabsClient */
public class C0646c {

    /* renamed from: a */
    private final ICustomTabsService f1599a;

    /* renamed from: b */
    private final ComponentName f1600b;

    /* renamed from: androidx.browser.a.c$a */
    /* compiled from: CustomTabsClient */
    class C0647a extends ICustomTabsCallback.Stub {

        /* renamed from: a */
        private Handler f1601a = new Handler(Looper.getMainLooper());

        /* renamed from: b */
        final /* synthetic */ C0645b f1602b;

        /* renamed from: androidx.browser.a.c$a$a */
        /* compiled from: CustomTabsClient */
        class C0648a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f1603a;

            /* renamed from: b */
            final /* synthetic */ Bundle f1604b;

            C0648a(int i, Bundle bundle) {
                this.f1603a = i;
                this.f1604b = bundle;
            }

            public void run() {
                C0647a.this.f1602b.mo3642a(this.f1603a, this.f1604b);
            }
        }

        /* renamed from: androidx.browser.a.c$a$b */
        /* compiled from: CustomTabsClient */
        class C0649b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f1606a;

            /* renamed from: b */
            final /* synthetic */ Bundle f1607b;

            C0649b(String str, Bundle bundle) {
                this.f1606a = str;
                this.f1607b = bundle;
            }

            public void run() {
                C0647a.this.f1602b.mo3644a(this.f1606a, this.f1607b);
            }
        }

        /* renamed from: androidx.browser.a.c$a$c */
        /* compiled from: CustomTabsClient */
        class C0650c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bundle f1609a;

            C0650c(Bundle bundle) {
                this.f1609a = bundle;
            }

            public void run() {
                C0647a.this.f1602b.mo3643a(this.f1609a);
            }
        }

        /* renamed from: androidx.browser.a.c$a$d */
        /* compiled from: CustomTabsClient */
        class C0651d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f1611a;

            /* renamed from: b */
            final /* synthetic */ Bundle f1612b;

            C0651d(String str, Bundle bundle) {
                this.f1611a = str;
                this.f1612b = bundle;
            }

            public void run() {
                C0647a.this.f1602b.mo3646c(this.f1611a, this.f1612b);
            }
        }

        /* renamed from: androidx.browser.a.c$a$e */
        /* compiled from: CustomTabsClient */
        class C0652e implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f1614a;

            /* renamed from: b */
            final /* synthetic */ Uri f1615b;

            /* renamed from: c */
            final /* synthetic */ boolean f1616c;

            /* renamed from: d */
            final /* synthetic */ Bundle f1617d;

            C0652e(int i, Uri uri, boolean z, Bundle bundle) {
                this.f1614a = i;
                this.f1615b = uri;
                this.f1616c = z;
                this.f1617d = bundle;
            }

            public void run() {
                C0647a.this.f1602b.mo3641a(this.f1614a, this.f1615b, this.f1616c, this.f1617d);
            }
        }

        C0647a(C0646c cVar, C0645b bVar) {
            this.f1602b = bVar;
        }

        public void extraCallback(String str, Bundle bundle) throws RemoteException {
            if (this.f1602b != null) {
                this.f1601a.post(new C0649b(str, bundle));
            }
        }

        public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
            C0645b bVar = this.f1602b;
            if (bVar == null) {
                return null;
            }
            return bVar.mo3645b(str, bundle);
        }

        public void onMessageChannelReady(Bundle bundle) throws RemoteException {
            if (this.f1602b != null) {
                this.f1601a.post(new C0650c(bundle));
            }
        }

        public void onNavigationEvent(int i, Bundle bundle) {
            if (this.f1602b != null) {
                this.f1601a.post(new C0648a(i, bundle));
            }
        }

        public void onPostMessage(String str, Bundle bundle) throws RemoteException {
            if (this.f1602b != null) {
                this.f1601a.post(new C0651d(str, bundle));
            }
        }

        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) throws RemoteException {
            if (this.f1602b != null) {
                this.f1601a.post(new C0652e(i, uri, z, bundle));
            }
        }
    }

    C0646c(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.f1599a = iCustomTabsService;
        this.f1600b = componentName;
    }

    /* renamed from: a */
    public static boolean m1900a(Context context, String str, C0655e eVar) {
        eVar.mo3658a(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, eVar, 33);
    }

    /* renamed from: b */
    private ICustomTabsCallback.Stub m1901b(C0645b bVar) {
        return new C0647a(this, bVar);
    }

    /* renamed from: a */
    public boolean mo3648a(long j) {
        try {
            return this.f1599a.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public C0657f mo3647a(C0645b bVar) {
        return m1899a(bVar, (PendingIntent) null);
    }

    /* renamed from: a */
    private C0657f m1899a(C0645b bVar, PendingIntent pendingIntent) {
        boolean z;
        ICustomTabsCallback.Stub b = m1901b(bVar);
        if (pendingIntent != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                z = this.f1599a.newSessionWithExtras(b, bundle);
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            z = this.f1599a.newSession(b);
        }
        if (!z) {
            return null;
        }
        return new C0657f(this.f1599a, b, this.f1600b, pendingIntent);
    }
}
