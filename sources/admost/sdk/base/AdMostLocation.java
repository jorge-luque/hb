package admost.sdk.base;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.facebook.places.model.PlaceFields;

public class AdMostLocation {
    private static AdMostLocation instance;
    private float acc;
    private double lat;
    private Location location;
    private double lon;

    private AdMostLocation(Context context) {
        try {
            AdMostLog.m299i("AdMostLocation service is starting.");
            Location lastKnownLocation = ((LocationManager) context.getSystemService(PlaceFields.LOCATION)).getLastKnownLocation(AdMostExperimentManager.TYPE_NETWORK);
            this.location = lastKnownLocation;
            if (lastKnownLocation != null) {
                this.lat = lastKnownLocation.getLatitude();
                this.lon = this.location.getLongitude();
                this.acc = this.location.getAccuracy();
            }
        } catch (Exception unused) {
            Log.w(AdMostAdNetwork.ADMOST, "AdMostLocation (ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION) permissions not available.");
        }
    }

    public static AdMostLocation getInstance() {
        AdMostLocation adMostLocation = instance;
        if (adMostLocation != null) {
            return adMostLocation;
        }
        return null;
    }

    public static boolean isStarted() {
        return instance != null;
    }

    public static AdMostLocation newInstance(Context context) {
        if (instance == null) {
            instance = new AdMostLocation(context);
        }
        return instance;
    }

    public String accuracy() {
        return String.valueOf(this.acc);
    }

    public boolean isFound() {
        return this.location != null;
    }

    public String latitude() {
        return String.valueOf(this.lat);
    }

    public Location location() {
        return this.location;
    }

    public String longitude() {
        return String.valueOf(this.lon);
    }
}
