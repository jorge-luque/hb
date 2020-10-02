package admost.sdk;

import admost.sdk.base.AdMostLog;
import admost.sdk.model.AdMostReferrerObject;
import android.content.Context;
import android.content.Intent;
import java.util.Observable;

public class AdMostInstallReferrer extends Observable {
    private static AdMostInstallReferrer instance = new AdMostInstallReferrer();

    public static AdMostInstallReferrer getInstance() {
        return instance;
    }

    public void onReceive(Context context, Intent intent, String str) {
        synchronized (this) {
            setChanged();
            AdMostLog.m299i(AdMostInstallReferrer.class.getSimpleName() + " : [" + countObservers() + "] observers will be notified now");
            notifyObservers(new AdMostReferrerObject(context, intent, str));
        }
    }
}
