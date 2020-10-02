package admost.sdk.model;

import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.interfaces.AdMostFullScreenInterface;

public class AdMostItem {
    private Object adInterface;
    public String cacheKey;
    public long expiresAt;
    private long lifeTime;
    private String network;
    public String oldEventListener;

    public AdMostItem(String str, long j, AdMostBannerInterface adMostBannerInterface) {
        this.adInterface = adMostBannerInterface;
        this.lifeTime = j;
        this.network = str;
        this.expiresAt = System.currentTimeMillis() + ((j <= 0 ? 30 : j) * 1000 * 60);
    }

    public Object getAd() {
        return this.adInterface;
    }

    public String getNetwork() {
        return this.network;
    }

    public boolean isSafeForCache() {
        Object obj = this.adInterface;
        if (obj instanceof AdMostBannerInterface) {
            if (this.lifeTime <= 0 || !((AdMostBannerInterface) obj).isSafeForCache()) {
                return false;
            }
            return true;
        } else if (this.lifeTime > 0) {
            return true;
        } else {
            return false;
        }
    }

    public AdMostItem(AdMostBannerResponseItem adMostBannerResponseItem, String str, long j, AdMostFullScreenInterface adMostFullScreenInterface) {
        this.adInterface = adMostFullScreenInterface;
        this.network = adMostBannerResponseItem.Network;
        this.expiresAt = j;
        this.oldEventListener = str;
    }
}
