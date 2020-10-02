package com.moat.analytics.mobile.ogury;

import admost.sdk.base.AdMostExperimentManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.content.C0768a;
import com.facebook.places.model.PlaceFields;
import com.moat.analytics.mobile.ogury.C4315e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.moat.analytics.mobile.ogury.m */
final class C4333m implements LocationListener {

    /* renamed from: ˊ */
    private static C4333m f11600;

    /* renamed from: ʻ */
    private boolean f11601;

    /* renamed from: ʽ */
    private Location f11602;

    /* renamed from: ˋ */
    private ScheduledFuture<?> f11603;

    /* renamed from: ˎ */
    private ScheduledFuture<?> f11604;

    /* renamed from: ˏ */
    private ScheduledExecutorService f11605;

    /* renamed from: ॱ */
    private LocationManager f11606;

    /* renamed from: ॱॱ */
    private boolean f11607;

    private C4333m() {
        try {
            boolean z = ((C4328i) MoatAnalytics.getInstance()).f11580;
            this.f11601 = z;
            if (z) {
                C4315e.C43161.m14442(3, "LocationManager", this, "Moat location services disabled");
                return;
            }
            this.f11605 = Executors.newScheduledThreadPool(1);
            LocationManager locationManager = (LocationManager) C4307a.m14408().getSystemService(PlaceFields.LOCATION);
            this.f11606 = locationManager;
            if (locationManager.getAllProviders().size() == 0) {
                C4315e.C43161.m14442(3, "LocationManager", this, "Device has no location providers");
            } else {
                m14521();
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    /* renamed from: ʻ */
    private void m14510() {
        ScheduledFuture<?> scheduledFuture = this.f11603;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f11603.cancel(true);
            this.f11603 = null;
        }
    }

    /* renamed from: ʼ */
    private void m14511() {
        ScheduledFuture<?> scheduledFuture = this.f11604;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f11604.cancel(true);
            this.f11604 = null;
        }
    }

    /* renamed from: ʽ */
    private void m14512() {
        try {
            if (!this.f11607) {
                C4315e.C43161.m14442(3, "LocationManager", this, "Attempting to start update");
                if (m14515()) {
                    C4315e.C43161.m14442(3, "LocationManager", this, "start updating gps location");
                    this.f11606.requestLocationUpdates("gps", 0, 0.0f, this, Looper.getMainLooper());
                    this.f11607 = true;
                }
                if (m14520()) {
                    C4315e.C43161.m14442(3, "LocationManager", this, "start updating network location");
                    this.f11606.requestLocationUpdates(AdMostExperimentManager.TYPE_NETWORK, 0, 0.0f, this, Looper.getMainLooper());
                    this.f11607 = true;
                }
                if (this.f11607) {
                    m14511();
                    this.f11604 = this.f11605.schedule(new Runnable() {
                        public final void run() {
                            try {
                                C4315e.C43161.m14442(3, "LocationManager", this, "fetchTimedOut");
                                C4333m.this.m14522(true);
                            } catch (Exception e) {
                                C4332l.m14509(e);
                            }
                        }
                    }, 60, TimeUnit.SECONDS);
                }
            }
        } catch (SecurityException e) {
            C4332l.m14509(e);
        }
    }

    /* renamed from: ˊॱ */
    private void m14513() {
        C4315e.C43161.m14442(3, "LocationManager", this, "Resetting fetch timer");
        m14510();
        Location location = this.f11602;
        float f = 600.0f;
        if (location != null) {
            f = Math.max(600.0f - ((float) ((System.currentTimeMillis() - location.getTime()) / 1000)), 0.0f);
        }
        this.f11603 = this.f11605.schedule(new Runnable() {
            public final void run() {
                try {
                    C4315e.C43161.m14442(3, "LocationManager", this, "fetchTimerCompleted");
                    C4333m.this.m14521();
                } catch (Exception e) {
                    C4332l.m14509(e);
                }
            }
        }, (long) f, TimeUnit.SECONDS);
    }

    /* renamed from: ˋॱ */
    private boolean m14515() {
        return (C0768a.m2403a(C4307a.m14408().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) && this.f11606.getProvider("gps") != null && this.f11606.isProviderEnabled("gps");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045 A[RETURN] */
    /* renamed from: ˏॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m14520() {
        /*
            r4 = this;
            android.app.Application r0 = com.moat.analytics.mobile.ogury.C4307a.m14408()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            int r0 = androidx.core.content.C0768a.m2403a((android.content.Context) r0, (java.lang.String) r1)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 != 0) goto L_0x002f
            android.app.Application r0 = com.moat.analytics.mobile.ogury.C4307a.m14408()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            int r0 = androidx.core.content.C0768a.m2403a((android.content.Context) r0, (java.lang.String) r3)
            if (r0 != 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            if (r0 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r0 = 0
            goto L_0x0030
        L_0x002f:
            r0 = 1
        L_0x0030:
            if (r0 == 0) goto L_0x0045
            android.location.LocationManager r0 = r4.f11606
            java.lang.String r3 = "network"
            android.location.LocationProvider r0 = r0.getProvider(r3)
            if (r0 == 0) goto L_0x0045
            android.location.LocationManager r0 = r4.f11606
            boolean r0 = r0.isProviderEnabled(r3)
            if (r0 == 0) goto L_0x0045
            return r1
        L_0x0045:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4333m.m14520():boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ */
    public void m14521() {
        try {
            if (this.f11601) {
                return;
            }
            if (this.f11606 != null) {
                if (this.f11607) {
                    C4315e.C43161.m14442(3, "LocationManager", this, "already updating location");
                }
                C4315e.C43161.m14442(3, "LocationManager", this, "starting location fetch");
                Location r0 = m14516(this.f11602, m14524());
                this.f11602 = r0;
                if (r0 != null) {
                    StringBuilder sb = new StringBuilder("Have a valid location, won't fetch = ");
                    sb.append(this.f11602.toString());
                    C4315e.C43161.m14442(3, "LocationManager", this, sb.toString());
                    m14513();
                    return;
                }
                m14512();
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    /* renamed from: ॱॱ */
    private Location m14524() {
        try {
            boolean r1 = m14515();
            boolean r2 = m14520();
            if (r1 && r2) {
                return m14516(this.f11606.getLastKnownLocation("gps"), this.f11606.getLastKnownLocation(AdMostExperimentManager.TYPE_NETWORK));
            }
            if (r1) {
                return this.f11606.getLastKnownLocation("gps");
            }
            if (r2) {
                return this.f11606.getLastKnownLocation(AdMostExperimentManager.TYPE_NETWORK);
            }
            return null;
        } catch (SecurityException e) {
            C4332l.m14509(e);
            return null;
        }
    }

    /* renamed from: ᐝ */
    private void m14525() {
        try {
            C4315e.C43161.m14442(3, "LocationManager", this, "Stopping to update location");
            boolean z = true;
            if (!(C0768a.m2403a(C4307a.m14408().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0)) {
                if (!(C0768a.m2403a(C4307a.m14408().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                    z = false;
                }
            }
            if (z && this.f11606 != null) {
                this.f11606.removeUpdates(this);
                this.f11607 = false;
            }
        } catch (SecurityException e) {
            C4332l.m14509(e);
        }
    }

    public final void onLocationChanged(Location location) {
        try {
            StringBuilder sb = new StringBuilder("Received an updated location = ");
            sb.append(location.toString());
            C4315e.C43161.m14442(3, "LocationManager", this, sb.toString());
            float currentTimeMillis = (float) ((System.currentTimeMillis() - location.getTime()) / 1000);
            if (location.hasAccuracy() && location.getAccuracy() <= 100.0f && currentTimeMillis < 600.0f) {
                this.f11602 = m14516(this.f11602, location);
                C4315e.C43161.m14442(3, "LocationManager", this, "fetchCompleted");
                m14522(true);
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public final void mo29175() {
        m14521();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public final void mo29176() {
        m14522(false);
    }

    /* renamed from: ˋ */
    private static boolean m14514(Location location) {
        if (location == null) {
            return false;
        }
        if ((location.getLatitude() != 0.0d || location.getLongitude() != 0.0d) && location.getAccuracy() >= 0.0f && ((float) ((System.currentTimeMillis() - location.getTime()) / 1000)) < 600.0f) {
            return true;
        }
        return false;
    }

    /* renamed from: ˎ */
    static C4333m m14517() {
        if (f11600 == null) {
            f11600 = new C4333m();
        }
        return f11600;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public final Location mo29177() {
        if (this.f11601 || this.f11606 == null) {
            return null;
        }
        return this.f11602;
    }

    /* renamed from: ˎ */
    private static Location m14516(Location location, Location location2) {
        boolean r0 = m14514(location);
        boolean r1 = m14514(location2);
        if (r0) {
            return (r1 && location.getAccuracy() >= location.getAccuracy()) ? location2 : location;
        }
        if (!r1) {
            return null;
        }
        return location2;
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ */
    public void m14522(boolean z) {
        try {
            C4315e.C43161.m14442(3, "LocationManager", this, "stopping location fetch");
            m14525();
            m14511();
            if (z) {
                m14513();
            } else {
                m14510();
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    /* renamed from: ॱ */
    static boolean m14523(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return (location == null || location2 == null || location.getTime() != location2.getTime()) ? false : true;
    }
}
