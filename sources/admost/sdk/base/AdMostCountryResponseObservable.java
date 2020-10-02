package admost.sdk.base;

import java.util.Observable;

public class AdMostCountryResponseObservable extends Observable {
    private static AdMostCountryResponseObservable instance = new AdMostCountryResponseObservable();

    public static AdMostCountryResponseObservable getInstance() {
        return instance;
    }

    public void onReceive(Object... objArr) {
        synchronized (this) {
            setChanged();
            notifyObservers(objArr);
        }
    }
}
