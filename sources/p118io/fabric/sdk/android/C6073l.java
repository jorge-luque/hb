package p118io.fabric.sdk.android;

import admost.sdk.base.AdMostExperimentManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.appevents.AppEventsConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p118io.fabric.sdk.android.p200m.p202b.C6088g;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p202b.C6097l;
import p118io.fabric.sdk.android.p200m.p202b.C6098m;
import p118io.fabric.sdk.android.p200m.p205e.C6137d;
import p118io.fabric.sdk.android.p200m.p205e.C6138e;
import p118io.fabric.sdk.android.p200m.p205e.C6141h;
import p118io.fabric.sdk.android.p200m.p205e.C6147n;
import p118io.fabric.sdk.android.p200m.p205e.C6150q;
import p118io.fabric.sdk.android.p200m.p205e.C6155t;
import p118io.fabric.sdk.android.p200m.p205e.C6160y;
import p118io.fabric.sdk.android.services.network.C6197b;
import p118io.fabric.sdk.android.services.network.C6200d;

/* renamed from: io.fabric.sdk.android.l */
/* compiled from: Onboarding */
class C6073l extends C6069h<Boolean> {

    /* renamed from: a */
    private final C6200d f15993a = new C6197b();

    /* renamed from: b */
    private PackageManager f15994b;

    /* renamed from: c */
    private String f15995c;

    /* renamed from: d */
    private PackageInfo f15996d;

    /* renamed from: e */
    private String f15997e;

    /* renamed from: f */
    private String f15998f;

    /* renamed from: g */
    private String f15999g;

    /* renamed from: h */
    private String f16000h;

    /* renamed from: i */
    private String f16001i;

    /* renamed from: j */
    private final Future<Map<String, C6071j>> f16002j;

    /* renamed from: k */
    private final Collection<C6069h> f16003k;

    public C6073l(Future<Map<String, C6071j>> future, Collection<C6069h> collection) {
        this.f16002j = future;
        this.f16003k = collection;
    }

    /* renamed from: a */
    private C6155t m19677a() {
        try {
            C6150q d = C6150q.m19903d();
            d.mo34259a(this, this.idManager, this.f15993a, this.f15997e, this.f15998f, getOverridenSpiEndpoint(), C6097l.m19766a(getContext()));
            d.mo34261b();
            return C6150q.m19903d().mo34260a();
        } catch (Exception e) {
            C6059c.m19630f().mo34090b("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    /* renamed from: b */
    private boolean m19680b(String str, C6138e eVar, Collection<C6071j> collection) {
        return new C6141h(this, getOverridenSpiEndpoint(), eVar.f16136b, this.f15993a).mo34245a(m19676a(C6147n.m19901a(getContext(), str), collection));
    }

    /* renamed from: c */
    private boolean m19681c(String str, C6138e eVar, Collection<C6071j> collection) {
        return m19678a(eVar, C6147n.m19901a(getContext(), str), collection);
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    /* access modifiers changed from: package-private */
    public String getOverridenSpiEndpoint() {
        return C6090i.m19740b(getContext(), "com.crashlytics.ApiEndpoint");
    }

    public String getVersion() {
        return "1.4.8.32";
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        try {
            this.f15999g = getIdManager().mo34194f();
            this.f15994b = getContext().getPackageManager();
            String packageName = getContext().getPackageName();
            this.f15995c = packageName;
            PackageInfo packageInfo = this.f15994b.getPackageInfo(packageName, 0);
            this.f15996d = packageInfo;
            this.f15997e = Integer.toString(packageInfo.versionCode);
            this.f15998f = this.f15996d.versionName == null ? "0.0" : this.f15996d.versionName;
            this.f16000h = this.f15994b.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.f16001i = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            C6059c.m19630f().mo34090b("Fabric", "Failed init", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground() {
        boolean z;
        Map map;
        String c = C6090i.m19744c(getContext());
        C6155t a = m19677a();
        if (a != null) {
            try {
                if (this.f16002j != null) {
                    map = this.f16002j.get();
                } else {
                    map = new HashMap();
                }
                mo34142a((Map<String, C6071j>) map, this.f16003k);
                z = m19679a(c, a.f16174a, (Collection<C6071j>) map.values());
            } catch (Exception e) {
                C6059c.m19630f().mo34090b("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(z);
        }
        z = false;
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, C6071j> mo34142a(Map<String, C6071j> map, Collection<C6069h> collection) {
        for (C6069h next : collection) {
            if (!map.containsKey(next.getIdentifier())) {
                map.put(next.getIdentifier(), new C6071j(next.getIdentifier(), next.getVersion(), "binary"));
            }
        }
        return map;
    }

    /* renamed from: a */
    private boolean m19679a(String str, C6138e eVar, Collection<C6071j> collection) {
        if (AdMostExperimentManager.EXPERIMENT_TYPE_NEW_INSTALL.equals(eVar.f16135a)) {
            if (m19680b(str, eVar, collection)) {
                return C6150q.m19903d().mo34262c();
            }
            C6059c.m19630f().mo34090b("Fabric", "Failed to create app with Crashlytics service.", (Throwable) null);
            return false;
        } else if ("configured".equals(eVar.f16135a)) {
            return C6150q.m19903d().mo34262c();
        } else {
            if (eVar.f16139e) {
                C6059c.m19630f().mo34093d("Fabric", "Server says an update is required - forcing a full App update.");
                m19681c(str, eVar, collection);
            }
            return true;
        }
    }

    /* renamed from: a */
    private boolean m19678a(C6138e eVar, C6147n nVar, Collection<C6071j> collection) {
        return new C6160y(this, getOverridenSpiEndpoint(), eVar.f16136b, this.f15993a).mo34245a(m19676a(nVar, collection));
    }

    /* renamed from: a */
    private C6137d m19676a(C6147n nVar, Collection<C6071j> collection) {
        Context context = getContext();
        return new C6137d(new C6088g().mo34168d(context), getIdManager().mo34191c(), this.f15998f, this.f15997e, C6090i.m19729a(C6090i.m19759n(context)), this.f16000h, C6098m.m19770a(this.f15999g).mo34179a(), this.f16001i, AppEventsConstants.EVENT_PARAM_VALUE_NO, nVar, collection);
    }
}
