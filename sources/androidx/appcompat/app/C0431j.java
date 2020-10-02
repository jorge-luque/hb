package androidx.appcompat.app;

import admost.sdk.base.AdMostExperimentManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.C0769b;
import com.facebook.places.model.PlaceFields;
import java.util.Calendar;

/* renamed from: androidx.appcompat.app.j */
/* compiled from: TwilightManager */
class C0431j {

    /* renamed from: d */
    private static C0431j f525d;

    /* renamed from: a */
    private final Context f526a;

    /* renamed from: b */
    private final LocationManager f527b;

    /* renamed from: c */
    private final C0432a f528c = new C0432a();

    /* renamed from: androidx.appcompat.app.j$a */
    /* compiled from: TwilightManager */
    private static class C0432a {

        /* renamed from: a */
        boolean f529a;

        /* renamed from: b */
        long f530b;

        /* renamed from: c */
        long f531c;

        /* renamed from: d */
        long f532d;

        /* renamed from: e */
        long f533e;

        /* renamed from: f */
        long f534f;

        C0432a() {
        }
    }

    C0431j(Context context, LocationManager locationManager) {
        this.f526a = context;
        this.f527b = locationManager;
    }

    /* renamed from: a */
    static C0431j m580a(Context context) {
        if (f525d == null) {
            Context applicationContext = context.getApplicationContext();
            f525d = new C0431j(applicationContext, (LocationManager) applicationContext.getSystemService(PlaceFields.LOCATION));
        }
        return f525d;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private Location m582b() {
        Location location = null;
        Location a = C0769b.m2416b(this.f526a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m579a(AdMostExperimentManager.TYPE_NETWORK) : null;
        if (C0769b.m2416b(this.f526a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m579a("gps");
        }
        return (location == null || a == null) ? location != null ? location : a : location.getTime() > a.getTime() ? location : a;
    }

    /* renamed from: c */
    private boolean m583c() {
        return this.f528c.f534f > System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2132a() {
        C0432a aVar = this.f528c;
        if (m583c()) {
            return aVar.f529a;
        }
        Location b = m582b();
        if (b != null) {
            m581a(b);
            return aVar.f529a;
        }
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    /* renamed from: a */
    private Location m579a(String str) {
        try {
            if (this.f527b.isProviderEnabled(str)) {
                return this.f527b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private void m581a(Location location) {
        long j;
        C0432a aVar = this.f528c;
        long currentTimeMillis = System.currentTimeMillis();
        C0430i a = C0430i.m577a();
        C0430i iVar = a;
        iVar.mo2131a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f522a;
        iVar.mo2131a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f524c == 1;
        long j3 = a.f523b;
        long j4 = j2;
        long j5 = a.f522a;
        long j6 = j3;
        boolean z2 = z;
        a.mo2131a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = a.f523b;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6) + 60000;
        }
        aVar.f529a = z2;
        aVar.f530b = j4;
        aVar.f531c = j6;
        aVar.f532d = j5;
        aVar.f533e = j7;
        aVar.f534f = j;
    }
}
