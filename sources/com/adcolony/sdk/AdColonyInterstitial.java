package com.adcolony.sdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.adcolony.sdk.C1439u;
import com.google.android.gms.drive.DriveFile;
import org.json.JSONObject;

public class AdColonyInterstitial {
    public static final int ADCOLONY_IAP_ENGAGEMENT_END_CARD = 0;
    public static final int ADCOLONY_IAP_ENGAGEMENT_OVERLAY = 1;

    /* renamed from: a */
    private AdColonyInterstitialListener f3299a;

    /* renamed from: b */
    private C1205c f3300b;

    /* renamed from: c */
    private AdColonyAdOptions f3301c;

    /* renamed from: d */
    private C1218c0 f3302d;

    /* renamed from: e */
    private int f3303e;

    /* renamed from: f */
    private String f3304f;

    /* renamed from: g */
    private String f3305g;

    /* renamed from: h */
    private String f3306h;

    /* renamed from: i */
    private String f3307i;

    /* renamed from: j */
    private boolean f3308j;

    /* renamed from: k */
    private boolean f3309k;

    /* renamed from: l */
    private boolean f3310l;

    AdColonyInterstitial(String str, AdColonyInterstitialListener adColonyInterstitialListener, String str2) {
        this.f3299a = adColonyInterstitialListener;
        this.f3307i = str2;
        this.f3304f = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6323a(AdColonyZone adColonyZone) {
        if (adColonyZone != null) {
            if (adColonyZone.getPlayFrequency() <= 1) {
                return false;
            }
            if (adColonyZone.mo6371a() == 0) {
                adColonyZone.mo6373b(adColonyZone.getPlayFrequency() - 1);
                return false;
            }
            adColonyZone.mo6373b(adColonyZone.mo6371a() - 1);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6325b(String str) {
        this.f3306h = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C1205c mo6327c() {
        return this.f3300b;
    }

    public boolean cancel() {
        if (this.f3300b == null) {
            return false;
        }
        Context b = C1199a.m4878b();
        if (b != null && !(b instanceof AdColonyInterstitialActivity)) {
            return false;
        }
        JSONObject b2 = C1437s.m5599b();
        C1437s.m5592a(b2, "id", this.f3300b.mo6400a());
        new C1454x("AdSession.on_request_close", this.f3300b.mo6428k(), b2).mo6834d();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo6329d() {
        String str = this.f3306h;
        return str == null ? "" : str;
    }

    public boolean destroy() {
        C1199a.m4880c().mo6530b().mo6453a().remove(this.f3304f);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C1218c0 mo6331e() {
        return this.f3302d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo6332f() {
        return this.f3303e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo6333g() {
        return this.f3302d != null;
    }

    public AdColonyInterstitialListener getListener() {
        return this.f3299a;
    }

    public String getZoneID() {
        return this.f3307i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo6336h() {
        return this.f3310l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo6337i() {
        Context b = C1199a.m4878b();
        if (b == null || !C1199a.m4882e()) {
            return false;
        }
        C1199a.m4880c().mo6538d(true);
        C1199a.m4880c().mo6526a(this.f3300b);
        C1199a.m4880c().mo6524a(this);
        Intent intent = new Intent(b, AdColonyInterstitialActivity.class);
        if (b instanceof Application) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        b.startActivity(intent);
        this.f3309k = true;
        return true;
    }

    public boolean isExpired() {
        return this.f3308j || this.f3309k;
    }

    public void setListener(AdColonyInterstitialListener adColonyInterstitialListener) {
        this.f3299a = adColonyInterstitialListener;
    }

    public boolean show() {
        if (!C1199a.m4882e()) {
            return false;
        }
        C1290h c = C1199a.m4880c();
        if (this.f3309k) {
            new C1439u.C1440a().mo6801a("This ad object has already been shown. Please request a new ad ").mo6801a("via AdColony.requestInterstitial.").mo6803a(C1439u.f4514g);
            return false;
        } else if (this.f3308j) {
            new C1439u.C1440a().mo6801a("This ad object has expired. Please request a new ad via AdColony").mo6801a(".requestInterstitial.").mo6803a(C1439u.f4514g);
            return false;
        } else if (c.mo6519D()) {
            new C1439u.C1440a().mo6801a("Can not show ad while an interstitial is already active.").mo6803a(C1439u.f4514g);
            return false;
        } else if (mo6323a(c.mo6558y().get(this.f3307i))) {
            return false;
        } else {
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "zone_id", this.f3307i);
            C1437s.m5602b(b, "type", 0);
            C1437s.m5592a(b, "id", this.f3304f);
            AdColonyAdOptions adColonyAdOptions = this.f3301c;
            if (adColonyAdOptions != null) {
                C1437s.m5603b(b, "pre_popup", adColonyAdOptions.f3257a);
                C1437s.m5603b(b, "post_popup", this.f3301c.f3258b);
            }
            AdColonyZone adColonyZone = c.mo6558y().get(this.f3307i);
            if (adColonyZone != null && adColonyZone.isRewarded() && c.mo6553t() == null) {
                new C1439u.C1440a().mo6801a("Rewarded ad: show() called with no reward listener set.").mo6803a(C1439u.f4514g);
            }
            new C1454x("AdSession.launch_ad_unit", 1, b).mo6834d();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo6324b() {
        return this.f3304f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6326b(boolean z) {
        this.f3310l = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6321a(JSONObject jSONObject) {
        if (jSONObject.length() > 0) {
            this.f3302d = new C1218c0(jSONObject, this.f3304f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6319a(C1205c cVar) {
        this.f3300b = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6322a(boolean z) {
        this.f3308j = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6318a(AdColonyAdOptions adColonyAdOptions) {
        this.f3301c = adColonyAdOptions;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6317a(int i) {
        this.f3303e = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo6316a() {
        String str = this.f3305g;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6320a(String str) {
        this.f3305g = str;
    }
}
