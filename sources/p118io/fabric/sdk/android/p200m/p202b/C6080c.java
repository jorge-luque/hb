package p118io.fabric.sdk.android.p200m.p202b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.p200m.p204d.C6132c;
import p118io.fabric.sdk.android.p200m.p204d.C6133d;

/* renamed from: io.fabric.sdk.android.m.b.c */
/* compiled from: AdvertisingInfoProvider */
class C6080c {

    /* renamed from: a */
    private final Context f16008a;

    /* renamed from: b */
    private final C6132c f16009b;

    /* renamed from: io.fabric.sdk.android.m.b.c$a */
    /* compiled from: AdvertisingInfoProvider */
    class C6081a extends C6089h {

        /* renamed from: a */
        final /* synthetic */ C6079b f16010a;

        C6081a(C6079b bVar) {
            this.f16010a = bVar;
        }

        public void onRun() {
            C6079b a = C6080c.this.m19695e();
            if (!this.f16010a.equals(a)) {
                C6059c.m19630f().mo34093d("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                C6080c.this.m19694c(a);
            }
        }
    }

    public C6080c(Context context) {
        this.f16008a = context.getApplicationContext();
        this.f16009b = new C6133d(context, "TwitterAdvertisingInfoPreferences");
    }

    /* renamed from: b */
    private void m19693b(C6079b bVar) {
        new Thread(new C6081a(bVar)).start();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: c */
    public void m19694c(C6079b bVar) {
        if (m19692a(bVar)) {
            C6132c cVar = this.f16009b;
            cVar.mo34242a(cVar.mo34241a().putString(TapjoyConstants.TJC_ADVERTISING_ID, bVar.f16006a).putBoolean("limit_ad_tracking_enabled", bVar.f16007b));
            return;
        }
        C6132c cVar2 = this.f16009b;
        cVar2.mo34242a(cVar2.mo34241a().remove(TapjoyConstants.TJC_ADVERTISING_ID).remove("limit_ad_tracking_enabled"));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public C6079b m19695e() {
        C6079b a = mo34154c().mo34156a();
        if (!m19692a(a)) {
            a = mo34155d().mo34156a();
            if (!m19692a(a)) {
                C6059c.m19630f().mo34093d("Fabric", "AdvertisingInfo not present");
            } else {
                C6059c.m19630f().mo34093d("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            C6059c.m19630f().mo34093d("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return a;
    }

    /* renamed from: d */
    public C6087f mo34155d() {
        return new C6083e(this.f16008a);
    }

    /* renamed from: a */
    public C6079b mo34152a() {
        C6079b b = mo34153b();
        if (m19692a(b)) {
            C6059c.m19630f().mo34093d("Fabric", "Using AdvertisingInfo from Preference Store");
            m19693b(b);
            return b;
        }
        C6079b e = m19695e();
        m19694c(e);
        return e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C6079b mo34153b() {
        return new C6079b(this.f16009b.get().getString(TapjoyConstants.TJC_ADVERTISING_ID, ""), this.f16009b.get().getBoolean("limit_ad_tracking_enabled", false));
    }

    /* renamed from: a */
    private boolean m19692a(C6079b bVar) {
        return bVar != null && !TextUtils.isEmpty(bVar.f16006a);
    }

    /* renamed from: c */
    public C6087f mo34154c() {
        return new C6082d(this.f16008a);
    }
}
