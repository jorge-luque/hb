package admost.sdk.model;

import admost.sdk.listener.AdMostInterstitialEventListener;
import java.util.Vector;

public class AdMostInterstitialManagerItem {
    public Vector<AdMostInterstitialEventListener> EVENT_LISTENER = new Vector<>();
    public long TIMEOUT;

    public void ResetItem() {
        Vector<AdMostInterstitialEventListener> vector = this.EVENT_LISTENER;
        if (vector != null && vector.size() > 0) {
            this.EVENT_LISTENER.removeAllElements();
        }
        this.TIMEOUT = 0;
    }
}
