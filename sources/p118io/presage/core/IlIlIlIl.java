package p118io.presage.core;

import admost.sdk.base.AdMostExperimentManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.facebook.places.model.PlaceFields;

/* renamed from: io.presage.core.IlIlIlIl */
public class IlIlIlIl extends IIllllll {
    public Context IIIIlllI;

    public IlIlIlIl(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
        this.IIIIlllI = context;
    }

    public int IIIIIIII() {
        return 14;
    }

    public Object IIIIIIll() {
        return IlIlIlIl.class;
    }

    @SuppressLint({"MissingPermission"})
    public void IIIIIlIl() {
        IIlIIllI iIlIIllI;
        long currentTimeMillis = System.currentTimeMillis();
        if (!IIIIlIll.IIIIIIII(this.IIIIlllI, "android.permission.ACCESS_FINE_LOCATION") && !IIIIlIll.IIIIIIII(this.IIIIlllI, "android.permission.ACCESS_COARSE_LOCATION")) {
            IIIIIIII(0);
        }
        LocationManager locationManager = (LocationManager) this.IIIIlllI.getSystemService(PlaceFields.LOCATION);
        Location location = null;
        Location lastKnownLocation = IIIIlIll.IIIIIIII(this.IIIIlllI, "android.permission.ACCESS_COARSE_LOCATION") ? locationManager.getLastKnownLocation(AdMostExperimentManager.TYPE_NETWORK) : null;
        if (IIIIlIll.IIIIIIII(this.IIIIlllI, "android.permission.ACCESS_FINE_LOCATION")) {
            lastKnownLocation = locationManager.getLastKnownLocation(AdMostExperimentManager.TYPE_NETWORK);
            location = locationManager.getLastKnownLocation("gps");
        }
        if (location != null && lastKnownLocation != null) {
            iIlIIllI = location.getAccuracy() > lastKnownLocation.getAccuracy() ? new IIlIIllI(currentTimeMillis, location) : new IIlIIllI(currentTimeMillis, lastKnownLocation);
        } else if (location != null) {
            iIlIIllI = new IIlIIllI(currentTimeMillis, location);
        } else if (lastKnownLocation != null) {
            iIlIIllI = new IIlIIllI(currentTimeMillis, lastKnownLocation);
        } else {
            IIIIIIII(0);
            return;
        }
        IIIIIIIl(iIlIIllI);
    }

    public void IIIIIllI() {
    }
}
