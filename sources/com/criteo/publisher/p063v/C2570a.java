package com.criteo.publisher.p063v;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.criteo.publisher.CriteoInterstitialActivity;
import com.criteo.publisher.CriteoInterstitialAdListener;
import com.criteo.publisher.p054a0.C2336k;
import com.criteo.publisher.p056o.C2497b;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;

/* renamed from: com.criteo.publisher.v.a */
public class C2570a {

    /* renamed from: a */
    private final Context f8117a;

    /* renamed from: b */
    private final C2497b f8118b;

    public C2570a(Context context, C2497b bVar) {
        this.f8117a = context;
        this.f8118b = bVar;
    }

    /* renamed from: b */
    private Intent m9639b() {
        return new Intent(this.f8117a, CriteoInterstitialActivity.class);
    }

    /* renamed from: a */
    public boolean mo10298a() {
        if (this.f8117a.getPackageManager().resolveActivity(m9639b(), 65536) == null || this.f8117a.getResources().getIdentifier("activity_criteo_interstitial", "layout", this.f8117a.getPackageName()) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void mo10297a(String str, CriteoInterstitialAdListener criteoInterstitialAdListener) {
        if (mo10298a()) {
            C2336k a = mo10608a(criteoInterstitialAdListener);
            ComponentName a2 = this.f8118b.mo10503a();
            Intent b = m9639b();
            b.setFlags(DriveFile.MODE_READ_ONLY);
            b.putExtra("webviewdata", str);
            b.putExtra("resultreceiver", a);
            b.putExtra("callingactivity", a2);
            this.f8117a.startActivity(b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2336k mo10608a(CriteoInterstitialAdListener criteoInterstitialAdListener) {
        return new C2336k(new Handler(Looper.getMainLooper()), new WeakReference(criteoInterstitialAdListener));
    }
}
