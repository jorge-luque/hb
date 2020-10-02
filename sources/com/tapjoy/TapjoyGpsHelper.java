package com.tapjoy;

import android.content.Context;
import com.ogury.p159cm.OguryChoiceManager;

public class TapjoyGpsHelper {

    /* renamed from: a */
    private Context f13269a;

    /* renamed from: b */
    private String f13270b;

    /* renamed from: c */
    private boolean f13271c;

    /* renamed from: d */
    private int f13272d = 0;

    /* renamed from: e */
    private int f13273e = 0;

    /* renamed from: f */
    private boolean f13274f;

    /* renamed from: g */
    private Boolean f13275g;

    /* renamed from: h */
    private Boolean f13276h;

    public TapjoyGpsHelper(Context context) {
        this.f13269a = context;
    }

    public void checkGooglePlayIntegration() {
        if (!isGooglePlayServicesAvailable()) {
            throw new TapjoyIntegrationException("Tapjoy SDK is disabled because Google Play Services was not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
        } else if (!isGooglePlayManifestConfigured()) {
            throw new TapjoyIntegrationException("Failed to load manifest.xml meta-data, 'com.google.android.gms.version' not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
        }
    }

    public String getAdvertisingId() {
        return this.f13270b;
    }

    public int getDeviceGooglePlayServicesVersion() {
        return this.f13272d;
    }

    public int getPackagedGooglePlayServicesVersion() {
        return this.f13273e;
    }

    public boolean isAdIdAvailable() {
        return this.f13274f;
    }

    public boolean isAdTrackingEnabled() {
        return this.f13271c;
    }

    public boolean isGooglePlayManifestConfigured() {
        if (this.f13276h == null) {
            try {
                this.f13273e = this.f13269a.getPackageManager().getApplicationInfo(this.f13269a.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData.getInt("com.google.android.gms.version");
                this.f13276h = true;
            } catch (Exception unused) {
                this.f13276h = false;
            }
        }
        return this.f13276h.booleanValue();
    }

    public boolean isGooglePlayServicesAvailable() {
        if (this.f13275g == null) {
            try {
                this.f13269a.getClassLoader().loadClass("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                this.f13275g = true;
            } catch (Exception unused) {
                this.f13275g = false;
            } catch (Error unused2) {
                this.f13275g = false;
            }
        }
        return this.f13275g.booleanValue();
    }

    public void loadAdvertisingId(boolean z) {
        TapjoyLog.m16652i("TapjoyGpsHelper", "Looking for Google Play Services...");
        if (!isGooglePlayServicesAvailable() || !isGooglePlayManifestConfigured()) {
            TapjoyLog.m16652i("TapjoyGpsHelper", "Google Play Services not found");
            return;
        }
        TapjoyLog.m16652i("TapjoyGpsHelper", "Packaged Google Play Services found, fetching advertisingID...");
        TapjoyLog.m16652i("TapjoyGpsHelper", "Packaged Google Play Services version: " + this.f13273e);
        TapjoyAdIdClient tapjoyAdIdClient = new TapjoyAdIdClient(this.f13269a);
        this.f13274f = tapjoyAdIdClient.setupAdIdInfo();
        try {
            this.f13272d = this.f13269a.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            TapjoyLog.m16652i("TapjoyGpsHelper", "Device's Google Play Services version: " + this.f13272d);
        } catch (Exception unused) {
            TapjoyLog.m16652i("TapjoyGpsHelper", "Error getting device's Google Play Services version");
        }
        if (this.f13274f) {
            this.f13271c = tapjoyAdIdClient.isAdTrackingEnabled();
            this.f13270b = tapjoyAdIdClient.getAdvertisingId();
            TapjoyLog.m16652i("TapjoyGpsHelper", "Found advertising ID: " + this.f13270b);
            TapjoyLog.m16652i("TapjoyGpsHelper", "Is ad tracking enabled: " + Boolean.toString(this.f13271c));
            return;
        }
        TapjoyLog.m16652i("TapjoyGpsHelper", "Error getting advertisingID from Google Play Services");
        if (z) {
            this.f13271c = false;
            this.f13270b = "00000000-0000-0000-0000-000000000000";
            this.f13274f = true;
        }
    }
}
