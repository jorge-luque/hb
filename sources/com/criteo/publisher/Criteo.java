package com.criteo.publisher;

import android.app.Application;
import android.util.Log;
import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2455p;
import com.criteo.publisher.model.C2456q;
import com.criteo.publisher.model.C2459r;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p063v.C2570a;
import java.util.List;

public abstract class Criteo {

    /* renamed from: a */
    private static final String f7629a = "Criteo";

    /* renamed from: b */
    private static Criteo f7630b;

    public static class Builder {

        /* renamed from: a */
        private final String f7631a;

        /* renamed from: b */
        private final Application f7632b;

        /* renamed from: c */
        private List<AdUnit> f7633c;

        /* renamed from: d */
        private Boolean f7634d;

        /* renamed from: e */
        private String f7635e;

        public Builder(Application application, String str) {
            this.f7632b = application;
            this.f7631a = str;
        }

        public Builder adUnits(List<AdUnit> list) {
            this.f7633c = list;
            return this;
        }

        public Criteo init() throws CriteoInitException {
            return Criteo.m8921b(this.f7632b, this.f7631a, this.f7633c, this.f7634d, this.f7635e);
        }

        public Builder mopubConsent(String str) {
            this.f7635e = str;
            return this;
        }

        public Builder usPrivacyOptOut(boolean z) {
            this.f7634d = Boolean.valueOf(z);
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Criteo m8921b(Application application, String str, List<AdUnit> list, Boolean bool, String str2) throws CriteoInitException {
        Criteo criteo;
        synchronized (Criteo.class) {
            if (f7630b == null) {
                try {
                    C2387i U = C2387i.m9085U();
                    U.mo10267a(application);
                    U.mo10268a(str);
                    if (U.mo10286s().mo10161g()) {
                        f7630b = new C2382e(application, list, bool, str2, U);
                    } else {
                        f7630b = new C2427j();
                    }
                } catch (IllegalArgumentException e) {
                    throw e;
                } catch (Throwable th) {
                    Log.e(f7629a, "Internal error initializing Criteo instance.", th);
                    throw new CriteoInitException("Internal error initializing Criteo instance.", th);
                }
            }
            criteo = f7630b;
        }
        return criteo;
    }

    public static Criteo getInstance() {
        Criteo criteo = f7630b;
        if (criteo != null) {
            return criteo;
        }
        throw new C2386h("You must initialize the SDK before calling Criteo.getInstance()");
    }

    @Deprecated
    public static Criteo init(Application application, String str, List<AdUnit> list) throws CriteoInitException {
        Builder builder = new Builder(application, str);
        builder.adUnits(list);
        return builder.init();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C2455p mo10076a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C2459r mo10077a(BidToken bidToken, C2321a aVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C2465w mo10078a(AdUnit adUnit);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract C2456q mo10079b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract C2570a mo10080c();

    public abstract C2380d createBannerController(CriteoBannerView criteoBannerView);

    public abstract BidResponse getBidResponse(AdUnit adUnit);

    public abstract void setBidsForAdUnit(Object obj, AdUnit adUnit);

    public abstract void setMopubConsent(String str);

    public abstract void setUsPrivacyOptOut(boolean z);
}
