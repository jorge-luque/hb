package androidx.browser.p012a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.browser.p012a.C0643a;
import androidx.core.app.C0709d;
import androidx.core.content.C0768a;
import java.util.ArrayList;

/* renamed from: androidx.browser.a.d */
/* compiled from: CustomTabsIntent */
public final class C0653d {

    /* renamed from: a */
    public final Intent f1619a;

    /* renamed from: b */
    public final Bundle f1620b;

    C0653d(Intent intent, Bundle bundle) {
        this.f1619a = intent;
        this.f1620b = bundle;
    }

    /* renamed from: a */
    public void mo3654a(Context context, Uri uri) {
        this.f1619a.setData(uri);
        C0768a.m2406a(context, this.f1619a, this.f1620b);
    }

    /* renamed from: androidx.browser.a.d$a */
    /* compiled from: CustomTabsIntent */
    public static final class C0654a {

        /* renamed from: a */
        private final Intent f1621a = new Intent("android.intent.action.VIEW");

        /* renamed from: b */
        private final C0643a.C0644a f1622b = new C0643a.C0644a();

        /* renamed from: c */
        private ArrayList<Bundle> f1623c;

        /* renamed from: d */
        private Bundle f1624d;

        /* renamed from: e */
        private ArrayList<Bundle> f1625e;

        /* renamed from: f */
        private boolean f1626f = true;

        /* renamed from: g */
        private SparseArray<Bundle> f1627g;

        public C0654a() {
        }

        /* renamed from: a */
        public C0654a mo3655a(C0657f fVar) {
            this.f1621a.setPackage(fVar.mo3662b().getPackageName());
            m1905a(fVar.mo3660a(), fVar.mo3663c());
            return this;
        }

        /* renamed from: a */
        private void m1905a(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            C0709d.m2214a(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f1621a.putExtras(bundle);
        }

        public C0654a(C0657f fVar) {
            if (fVar != null) {
                mo3655a(fVar);
            }
        }

        /* renamed from: a */
        public C0653d mo3656a() {
            if (!this.f1621a.hasExtra("android.support.customtabs.extra.SESSION")) {
                m1905a((IBinder) null, (PendingIntent) null);
            }
            ArrayList<Bundle> arrayList = this.f1623c;
            if (arrayList != null) {
                this.f1621a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f1625e;
            if (arrayList2 != null) {
                this.f1621a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f1621a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1626f);
            this.f1621a.putExtras(this.f1622b.mo3640a().mo3639a());
            if (this.f1627g != null) {
                Bundle bundle = new Bundle();
                bundle.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f1627g);
                this.f1621a.putExtras(bundle);
            }
            return new C0653d(this.f1621a, this.f1624d);
        }
    }
}
