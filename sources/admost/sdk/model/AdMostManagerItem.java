package admost.sdk.model;

import admost.sdk.listener.AdMostManagerListener;
import java.util.Vector;

public class AdMostManagerItem {
    public Vector<AdMostManagerListener> admostManagerListeners = new Vector<>();
    private long bannerLifetime;
    public Vector<AdMostItem> cachedBanners = new Vector<>();
    public boolean noFillMarked = false;
    private String placementName;

    public AdMostManagerItem(AdMostBannerResponseItem adMostBannerResponseItem) {
        this.placementName = adMostBannerResponseItem.PlacementName;
        this.bannerLifetime = (long) adMostBannerResponseItem.LifeTime;
    }

    public void ResetItem() {
        Vector<AdMostItem> vector = this.cachedBanners;
        if (vector != null && vector.size() > 0) {
            this.cachedBanners.removeAllElements();
        }
        Vector<AdMostManagerListener> vector2 = this.admostManagerListeners;
        if (vector2 != null && vector2.size() > 0) {
            this.admostManagerListeners.removeAllElements();
        }
        this.noFillMarked = false;
        this.bannerLifetime = 0;
        this.placementName = "";
    }

    public String getPlacementName() {
        return this.placementName;
    }

    public boolean isSafeForCache() {
        return this.bannerLifetime > 0;
    }

    public void setBannerResponseItem(AdMostBannerResponseItem adMostBannerResponseItem) {
        this.placementName = adMostBannerResponseItem.PlacementName;
        this.bannerLifetime = (long) adMostBannerResponseItem.LifeTime;
    }
}
