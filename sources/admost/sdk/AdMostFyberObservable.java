package admost.sdk;

import java.util.Observable;

public class AdMostFyberObservable extends Observable {
    private static AdMostFyberObservable instance = new AdMostFyberObservable();

    public static AdMostFyberObservable getInstance() {
        return instance;
    }

    public void onReceive(int i) {
        synchronized (this) {
            setChanged();
            notifyObservers(Integer.valueOf(i));
        }
    }
}
