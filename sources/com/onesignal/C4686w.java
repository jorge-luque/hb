package com.onesignal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.onesignal.C4564n1;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.onesignal.w */
/* compiled from: LocationGMS */
class C4686w {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static C4640s f12737a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Location f12738b;

    /* renamed from: c */
    static String f12739c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Context f12740d;

    /* renamed from: e */
    private static C4692f f12741e;

    /* renamed from: f */
    protected static final Object f12742f = new C4687a();

    /* renamed from: g */
    private static ConcurrentHashMap<C4696j, C4691e> f12743g = new ConcurrentHashMap<>();

    /* renamed from: h */
    private static final List<C4694h> f12744h = new ArrayList();

    /* renamed from: i */
    private static Thread f12745i;

    /* renamed from: j */
    private static boolean f12746j;

    /* renamed from: k */
    static C4695i f12747k;

    /* renamed from: com.onesignal.w$a */
    /* compiled from: LocationGMS */
    static class C4687a {
        C4687a() {
        }
    }

    /* renamed from: com.onesignal.w$b */
    /* compiled from: LocationGMS */
    static class C4688b implements Runnable {
        C4688b() {
        }

        public void run() {
            try {
                Thread.sleep((long) C4686w.m16331f());
                C4564n1.m15789a(C4564n1.C4566a0.WARN, "Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.");
                C4686w.m16330e();
                C4686w.m16326b(C4686w.f12740d);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: com.onesignal.w$d */
    /* compiled from: LocationGMS */
    private static class C4690d implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private C4690d() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onConnected(android.os.Bundle r3) {
            /*
                r2 = this;
                java.lang.Object r3 = com.onesignal.C4686w.f12742f
                monitor-enter(r3)
                r0 = 0
                com.onesignal.PermissionsActivity.f12251c = r0     // Catch:{ all -> 0x004c }
                com.onesignal.s r0 = com.onesignal.C4686w.f12737a     // Catch:{ all -> 0x004c }
                if (r0 == 0) goto L_0x004a
                com.onesignal.s r0 = com.onesignal.C4686w.f12737a     // Catch:{ all -> 0x004c }
                com.google.android.gms.common.api.GoogleApiClient r0 = r0.mo29942c()     // Catch:{ all -> 0x004c }
                if (r0 != 0) goto L_0x0017
                goto L_0x004a
            L_0x0017:
                android.location.Location r0 = com.onesignal.C4686w.f12738b     // Catch:{ all -> 0x004c }
                if (r0 != 0) goto L_0x0039
                com.onesignal.s r0 = com.onesignal.C4686w.f12737a     // Catch:{ all -> 0x004c }
                com.google.android.gms.common.api.GoogleApiClient r0 = r0.mo29942c()     // Catch:{ all -> 0x004c }
                android.location.Location r0 = com.onesignal.C4686w.C4689c.m16336a(r0)     // Catch:{ all -> 0x004c }
                android.location.Location unused = com.onesignal.C4686w.f12738b = r0     // Catch:{ all -> 0x004c }
                android.location.Location r0 = com.onesignal.C4686w.f12738b     // Catch:{ all -> 0x004c }
                if (r0 == 0) goto L_0x0039
                android.location.Location r0 = com.onesignal.C4686w.f12738b     // Catch:{ all -> 0x004c }
                com.onesignal.C4686w.m16328c(r0)     // Catch:{ all -> 0x004c }
            L_0x0039:
                com.onesignal.w$i r0 = new com.onesignal.w$i     // Catch:{ all -> 0x004c }
                com.onesignal.s r1 = com.onesignal.C4686w.f12737a     // Catch:{ all -> 0x004c }
                com.google.android.gms.common.api.GoogleApiClient r1 = r1.mo29942c()     // Catch:{ all -> 0x004c }
                r0.<init>(r1)     // Catch:{ all -> 0x004c }
                com.onesignal.C4686w.f12747k = r0     // Catch:{ all -> 0x004c }
                monitor-exit(r3)     // Catch:{ all -> 0x004c }
                return
            L_0x004a:
                monitor-exit(r3)     // Catch:{ all -> 0x004c }
                return
            L_0x004c:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x004c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4686w.C4690d.onConnected(android.os.Bundle):void");
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            C4686w.m16330e();
        }

        public void onConnectionSuspended(int i) {
            C4686w.m16330e();
        }

        /* synthetic */ C4690d(C4687a aVar) {
            this();
        }
    }

    /* renamed from: com.onesignal.w$e */
    /* compiled from: LocationGMS */
    interface C4691e {
        /* renamed from: a */
        void mo29709a(C4693g gVar);

        C4696j getType();
    }

    /* renamed from: com.onesignal.w$f */
    /* compiled from: LocationGMS */
    private static class C4692f extends HandlerThread {

        /* renamed from: a */
        Handler f12748a = new Handler(getLooper());

        C4692f() {
            super("OSH_LocationHandlerThread");
            start();
        }
    }

    /* renamed from: com.onesignal.w$g */
    /* compiled from: LocationGMS */
    static class C4693g {

        /* renamed from: a */
        Double f12749a;

        /* renamed from: b */
        Double f12750b;

        /* renamed from: c */
        Float f12751c;

        /* renamed from: d */
        Integer f12752d;

        /* renamed from: e */
        Boolean f12753e;

        /* renamed from: f */
        Long f12754f;

        C4693g() {
        }
    }

    /* renamed from: com.onesignal.w$h */
    /* compiled from: LocationGMS */
    static abstract class C4694h implements C4691e {
        C4694h() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29869a(boolean z) {
        }
    }

    /* renamed from: com.onesignal.w$i */
    /* compiled from: LocationGMS */
    static class C4695i implements LocationListener {

        /* renamed from: a */
        private GoogleApiClient f12755a;

        C4695i(GoogleApiClient googleApiClient) {
            this.f12755a = googleApiClient;
            long j = C4564n1.m15770T() ? 270000 : 570000;
            LocationRequest interval = LocationRequest.create().setFastestInterval(j).setInterval(j);
            double d = (double) j;
            Double.isNaN(d);
            C4689c.m16337a(this.f12755a, interval.setMaxWaitTime((long) (d * 1.5d)).setPriority(102), this);
        }

        public void onLocationChanged(Location location) {
            Location unused = C4686w.f12738b = location;
            C4564n1.m15789a(C4564n1.C4566a0.INFO, "Location Change Detected");
        }
    }

    /* renamed from: com.onesignal.w$j */
    /* compiled from: LocationGMS */
    enum C4696j {
        STARTUP,
        PROMPT_LOCATION,
        SYNC_SERVICE;

        static {
            STARTUP = new C4696j("STARTUP", 0);
            PROMPT_LOCATION = new C4696j("PROMPT_LOCATION", 1);
            SYNC_SERVICE = new C4696j("SYNC_SERVICE", 2);
        }
    }

    C4686w() {
    }

    /* renamed from: e */
    static void m16330e() {
        PermissionsActivity.f12251c = false;
        synchronized (f12742f) {
            if (f12737a != null) {
                f12737a.mo29941b();
            }
            f12737a = null;
        }
        m16321a((C4693g) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static int m16331f() {
        return QumparaOfferwallModels.OfferwallStatus.VIRTUAL_CURRENCY_MIN_INTERVAL;
    }

    /* renamed from: g */
    private static long m16332g() {
        return C4698w1.m16341a(C4698w1.f12761a, "OS_LAST_LOCATION_TIME", -600000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        return;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m16333h() {
        /*
            java.lang.Object r0 = f12742f
            monitor-enter(r0)
            com.onesignal.s r1 = f12737a     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
            com.onesignal.s r1 = f12737a     // Catch:{ all -> 0x0030 }
            com.google.android.gms.common.api.GoogleApiClient r1 = r1.mo29942c()     // Catch:{ all -> 0x0030 }
            boolean r1 = r1.isConnected()     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x0014
            goto L_0x002e
        L_0x0014:
            com.onesignal.s r1 = f12737a     // Catch:{ all -> 0x0030 }
            com.google.android.gms.common.api.GoogleApiClient r1 = r1.mo29942c()     // Catch:{ all -> 0x0030 }
            com.onesignal.w$i r2 = f12747k     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x0025
            com.google.android.gms.location.FusedLocationProviderApi r2 = com.google.android.gms.location.LocationServices.FusedLocationApi     // Catch:{ all -> 0x0030 }
            com.onesignal.w$i r3 = f12747k     // Catch:{ all -> 0x0030 }
            r2.removeLocationUpdates((com.google.android.gms.common.api.GoogleApiClient) r1, (com.google.android.gms.location.LocationListener) r3)     // Catch:{ all -> 0x0030 }
        L_0x0025:
            com.onesignal.w$i r2 = new com.onesignal.w$i     // Catch:{ all -> 0x0030 }
            r2.<init>(r1)     // Catch:{ all -> 0x0030 }
            f12747k = r2     // Catch:{ all -> 0x0030 }
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4686w.m16333h():void");
    }

    /* renamed from: i */
    private static void m16334i() {
        Thread thread = new Thread(new C4688b(), "OS_GMS_LOCATION_FALLBACK");
        f12745i = thread;
        thread.start();
    }

    /* renamed from: j */
    static void m16335j() {
        if (f12745i == null) {
            try {
                synchronized (f12742f) {
                    m16334i();
                    if (f12741e == null) {
                        f12741e = new C4692f();
                    }
                    if (f12737a != null) {
                        if (f12738b != null) {
                            if (f12738b != null) {
                                m16328c(f12738b);
                            }
                        }
                    }
                    C4690d dVar = new C4690d((C4687a) null);
                    C4640s sVar = new C4640s(new GoogleApiClient.Builder(f12740d).addApi(LocationServices.API).addConnectionCallbacks(dVar).addOnConnectionFailedListener(dVar).setHandler(f12741e.f12748a).build());
                    f12737a = sVar;
                    sVar.mo29940a();
                }
            } catch (Throwable th) {
                C4564n1.m15790a(C4564n1.C4566a0.WARN, "Location permission exists but there was an error initializing: ", th);
                m16330e();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m16328c(Location location) {
        C4693g gVar = new C4693g();
        gVar.f12751c = Float.valueOf(location.getAccuracy());
        gVar.f12753e = Boolean.valueOf(!C4564n1.m15770T());
        gVar.f12752d = Integer.valueOf(f12746j ^ true ? 1 : 0);
        gVar.f12754f = Long.valueOf(location.getTime());
        if (f12746j) {
            gVar.f12749a = Double.valueOf(new BigDecimal(location.getLatitude()).setScale(7, RoundingMode.HALF_UP).doubleValue());
            gVar.f12750b = Double.valueOf(new BigDecimal(location.getLongitude()).setScale(7, RoundingMode.HALF_UP).doubleValue());
        } else {
            gVar.f12749a = Double.valueOf(location.getLatitude());
            gVar.f12750b = Double.valueOf(location.getLongitude());
        }
        m16321a(gVar);
        m16326b(f12740d);
    }

    /* renamed from: a */
    private static void m16318a(long j) {
        C4698w1.m16352b(C4698w1.f12761a, "OS_LAST_LOCATION_TIME", j);
    }

    /* renamed from: b */
    static boolean m16326b(Context context) {
        if (!m16323a(context) || !C4564n1.f12473E) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - m16332g();
        long j = C4564n1.m15770T() ? 300 : 600;
        Long.signum(j);
        C4469a2.m15408a(context, (j * 1000) - currentTimeMillis);
        return true;
    }

    /* renamed from: a */
    private static boolean m16323a(Context context) {
        return C4507g.m15529a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || C4507g.m15529a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    /* renamed from: com.onesignal.w$c */
    /* compiled from: LocationGMS */
    static class C4689c {
        /* renamed from: a */
        static void m16337a(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            try {
                synchronized (C4686w.f12742f) {
                    if (googleApiClient.isConnected()) {
                        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, locationListener);
                    }
                }
            } catch (Throwable th) {
                C4564n1.m15790a(C4564n1.C4566a0.WARN, "FusedLocationApi.requestLocationUpdates failed!", th);
            }
        }

        /* renamed from: a */
        static Location m16336a(GoogleApiClient googleApiClient) {
            synchronized (C4686w.f12742f) {
                if (!googleApiClient.isConnected()) {
                    return null;
                }
                Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                return lastLocation;
            }
        }
    }

    /* renamed from: a */
    static void m16320a(C4691e eVar) {
        if (eVar instanceof C4694h) {
            synchronized (f12744h) {
                f12744h.add((C4694h) eVar);
            }
        }
    }

    /* renamed from: a */
    static void m16322a(boolean z, boolean z2) {
        if (!z) {
            C4564n1.m15815b(C4564n1.C4566a0.DEBUG, "LocationGMS sendAndClearPromptHandlers from non prompt flow");
            return;
        }
        synchronized (f12744h) {
            C4564n1.m15815b(C4564n1.C4566a0.DEBUG, "LocationGMS calling prompt handlers");
            for (C4694h a : f12744h) {
                a.mo29869a(z2);
            }
            f12744h.clear();
        }
    }

    /* renamed from: a */
    static void m16319a(Context context, boolean z, C4691e eVar) {
        m16320a(eVar);
        f12740d = context;
        f12743g.put(eVar.getType(), eVar);
        if (!C4564n1.f12473E) {
            m16322a(z, false);
            m16330e();
            return;
        }
        int a = C4507g.m15529a(context, "android.permission.ACCESS_FINE_LOCATION");
        int i = -1;
        if (a == -1) {
            i = C4507g.m15529a(context, "android.permission.ACCESS_COARSE_LOCATION");
            f12746j = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a == 0 || i == 0) {
                m16322a(z, true);
                m16335j();
                return;
            }
            m16322a(z, false);
            eVar.mo29709a((C4693g) null);
        } else if (a != 0) {
            try {
                List asList = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE).requestedPermissions);
                if (asList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                    f12739c = "android.permission.ACCESS_FINE_LOCATION";
                } else if (!asList.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                    C4564n1.m15815b(C4564n1.C4566a0.INFO, "Location permissions not added on AndroidManifest file");
                } else if (i != 0) {
                    f12739c = "android.permission.ACCESS_COARSE_LOCATION";
                }
                if (f12739c != null && z) {
                    PermissionsActivity.m15367b();
                } else if (i == 0) {
                    m16322a(z, true);
                    m16335j();
                } else {
                    m16322a(z, false);
                    m16330e();
                }
            } catch (PackageManager.NameNotFoundException e) {
                m16322a(z, false);
                e.printStackTrace();
            }
        } else {
            m16322a(z, true);
            m16335j();
        }
    }

    /* renamed from: a */
    private static void m16321a(C4693g gVar) {
        Thread thread;
        Class<C4686w> cls = C4686w.class;
        HashMap hashMap = new HashMap();
        synchronized (cls) {
            hashMap.putAll(f12743g);
            f12743g.clear();
            thread = f12745i;
        }
        for (C4696j jVar : hashMap.keySet()) {
            ((C4691e) hashMap.get(jVar)).mo29709a(gVar);
        }
        if (thread != null && !Thread.currentThread().equals(thread)) {
            thread.interrupt();
        }
        if (thread == f12745i) {
            synchronized (cls) {
                if (thread == f12745i) {
                    f12745i = null;
                }
            }
        }
        m16318a(System.currentTimeMillis());
    }
}
