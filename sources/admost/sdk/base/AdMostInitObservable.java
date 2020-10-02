package admost.sdk.base;

import java.util.Observable;

public class AdMostInitObservable extends Observable {
    private static AdMostInitObservable instance = new AdMostInitObservable();

    public static AdMostInitObservable getInstance() {
        return instance;
    }

    public void onReceive(Object... objArr) {
        synchronized (this) {
            setChanged();
            notifyObservers(objArr);
        }
    }
}
