package com.ogury.p160ed;

import android.app.Activity;
import p118io.presage.C6224ao;
import p118io.presage.C6511hi;
import p118io.presage.Cheddar;
import p118io.presage.EcirdelAubrac;

/* renamed from: com.ogury.ed.OguryThumbnailAd */
public final class OguryThumbnailAd {

    /* renamed from: a */
    public static final CamembertauCalvados f12234a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final Cheddar f12235b;

    /* renamed from: com.ogury.ed.OguryThumbnailAd$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private OguryThumbnailAd(Cheddar cheddar) {
        this.f12235b = cheddar;
    }

    public final boolean isLoaded() {
        return this.f12235b.mo34529a();
    }

    public final void load(int i, int i2) {
        this.f12235b.mo34524a(i, i2);
    }

    @SafeVarargs
    public final void setBlackListActivities(Class<? extends Activity>... clsArr) {
        this.f12235b.mo34527a(clsArr);
    }

    @SafeVarargs
    public final void setBlackListFragments(Class<? extends Object>... clsArr) {
        this.f12235b.mo34530b(clsArr);
    }

    public final void setCallback(OguryThumbnailAdCallback oguryThumbnailAdCallback) {
        this.f12235b.mo34526a((EcirdelAubrac) new C6224ao(oguryThumbnailAdCallback));
    }

    public final void setWhiteListFragmentPackages(String... strArr) {
        this.f12235b.mo34531b(strArr);
    }

    public final void setWhiteListPackages(String... strArr) {
        this.f12235b.mo34528a(strArr);
    }

    public final void show(Activity activity, int i, int i2) {
        this.f12235b.mo34525a(activity, i, i2);
    }

    public /* synthetic */ OguryThumbnailAd(Cheddar cheddar, C6511hi hiVar) {
        this(cheddar);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OguryThumbnailAd(android.content.Context r3, p118io.presage.common.AdConfig r4) {
        /*
            r2 = this;
            io.presage.Cheddar r0 = new io.presage.Cheddar
            android.content.Context r3 = r3.getApplicationContext()
            java.lang.String r1 = "context.applicationContext"
            p118io.presage.C6514hl.m21414a((java.lang.Object) r3, (java.lang.String) r1)
            io.presage.SableduBoulonnais r1 = p118io.presage.SableduBoulonnais.f16673c
            r0.<init>((android.content.Context) r3, (p118io.presage.common.AdConfig) r4, (p118io.presage.SableduBoulonnais) r1)
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ogury.p160ed.OguryThumbnailAd.<init>(android.content.Context, io.presage.common.AdConfig):void");
    }
}
