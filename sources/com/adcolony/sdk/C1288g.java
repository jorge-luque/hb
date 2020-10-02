package com.adcolony.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.g */
class C1288g extends ContentObserver {

    /* renamed from: a */
    private AudioManager f4076a;

    /* renamed from: b */
    private AdColonyInterstitial f4077b;

    C1288g(Handler handler, AdColonyInterstitial adColonyInterstitial) {
        super(handler);
        Context b = C1199a.m4878b();
        if (b != null) {
            this.f4076a = (AudioManager) b.getSystemService("audio");
            this.f4077b = adColonyInterstitial;
            b.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6505a() {
        Context b = C1199a.m4878b();
        if (b != null) {
            b.getApplicationContext().getContentResolver().unregisterContentObserver(this);
        }
        this.f4077b = null;
        this.f4076a = null;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z) {
        AdColonyInterstitial adColonyInterstitial;
        if (this.f4076a != null && (adColonyInterstitial = this.f4077b) != null && adColonyInterstitial.mo6327c() != null) {
            double streamVolume = (double) ((((float) this.f4076a.getStreamVolume(3)) / 15.0f) * 100.0f);
            JSONObject b = C1437s.m5599b();
            C1437s.m5590a(b, "audio_percentage", streamVolume);
            C1437s.m5592a(b, "ad_session_id", this.f4077b.mo6327c().mo6400a());
            C1437s.m5602b(b, "id", this.f4077b.mo6327c().mo6410c());
            new C1454x("AdContainer.on_audio_change", this.f4077b.mo6327c().mo6428k(), b).mo6834d();
        }
    }
}
