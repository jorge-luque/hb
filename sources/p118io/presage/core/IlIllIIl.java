package p118io.presage.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.facebook.places.model.PlaceFields;

@SuppressLint({"MissingPermission"})
/* renamed from: io.presage.core.IlIllIIl */
public class IlIllIIl extends IIllllll {
    public Context IIIIlllI;
    public LocationManager IIIIllll;
    public LocationListener IIIlIIII;
    public long IIIlIIIl;

    /* renamed from: io.presage.core.IlIllIIl$IIIIIIII */
    public class IIIIIIII implements LocationListener {

        /* renamed from: io.presage.core.IlIllIIl$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6857IIIIIIII implements Runnable {
            public final /* synthetic */ Location IIIIIIII;

            public C6857IIIIIIII(Location location) {
                this.IIIIIIII = location;
            }

            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                IlIllIIl ilIllIIl = IlIllIIl.this;
                if (currentTimeMillis - ilIllIIl.IIIlIIIl >= ilIllIIl.IIIIlIlI) {
                    ilIllIIl.IIIIIIII((IIIlIIlI) new IIlIllIl(C6325l1.IIIIIIII(), this.IIIIIIII));
                }
            }
        }

        public IIIIIIII() {
        }

        public void onLocationChanged(Location location) {
            location.toString();
            IlIllIIl.this.IIIIIIII((Runnable) new C6857IIIIIIII(location));
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public IlIllIIl(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
        this.IIIIlllI = context;
        this.IIIIlIlI = j2 == 0 ? Math.max(j2, 5) : j2;
        this.IIIIllll = (LocationManager) this.IIIIlllI.getSystemService(PlaceFields.LOCATION);
    }

    public int IIIIIIII() {
        return 15;
    }

    public Object IIIIIIll() {
        return IlIllIIl.class;
    }

    public void IIIIIlIl() {
        this.IIIlIIIl = 0;
        if (IIIIlIll.IIIIIIII(this.IIIIlllI, "android.permission.ACCESS_FINE_LOCATION") || IIIIlIll.IIIIIIII(this.IIIIlllI, "android.permission.ACCESS_COARSE_LOCATION")) {
            Looper.prepare();
            IIIIIIII iiiiiiii = new IIIIIIII();
            this.IIIlIIII = iiiiiiii;
            this.IIIIllll.requestLocationUpdates("passive", 0, 0.0f, iiiiiiii, Looper.myLooper());
            Looper.loop();
            return;
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
        if (IIIIlIll.IIIIIIII(this.IIIIlllI, "android.permission.ACCESS_FINE_LOCATION")) {
            this.IIIIllll.removeUpdates(this.IIIlIIII);
        }
    }
}
