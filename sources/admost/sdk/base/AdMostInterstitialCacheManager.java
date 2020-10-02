package admost.sdk.base;

import admost.sdk.AdMostInterstitialManager;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostItem;
import java.util.concurrent.ConcurrentHashMap;

public class AdMostInterstitialCacheManager {
    private static AdMostInterstitialCacheManager INSTANCE;
    private static final Object lock = new Object();
    private ConcurrentHashMap<String, AdMostItem> CACHE_MAP = new ConcurrentHashMap<>();

    public static AdMostInterstitialCacheManager getInstance() {
        if (INSTANCE == null) {
            synchronized (lock) {
                if (INSTANCE == null) {
                    INSTANCE = new AdMostInterstitialCacheManager();
                }
            }
        }
        return INSTANCE;
    }

    public boolean addToCache(String str, long j, AdMostFullScreenInterface adMostFullScreenInterface) {
        AdMostBannerResponseItem adMostBannerResponseItem;
        if (adMostFullScreenInterface == null || (adMostBannerResponseItem = adMostFullScreenInterface.mBannerResponseItem) == null || adMostBannerResponseItem.LifeTime <= 0 || !adMostFullScreenInterface.isSafeForCache()) {
            return false;
        }
        AdMostInterstitialManager.getInstance().removeEventListener(str);
        AdMostBannerResponseItem adMostBannerResponseItem2 = adMostFullScreenInterface.mBannerResponseItem;
        adMostBannerResponseItem2.WaterFallLogItem.isCached = true;
        if (adMostBannerResponseItem2 != null) {
            AdMostLog.m294d(AdMostInterstitialManager.class.getSimpleName() + " : Interstitial CACHED : " + adMostFullScreenInterface.mBannerResponseItem.toString());
        }
        ConcurrentHashMap<String, AdMostItem> concurrentHashMap = this.CACHE_MAP;
        AdMostBannerResponseItem adMostBannerResponseItem3 = adMostFullScreenInterface.mBannerResponseItem;
        String str2 = adMostBannerResponseItem3.PlacementId;
        if (j <= 0) {
            j = getExpiresAt(adMostBannerResponseItem3);
        }
        concurrentHashMap.put(str2, new AdMostItem(adMostBannerResponseItem3, str, j, adMostFullScreenInterface));
        return true;
    }

    public long getExpiresAt(AdMostBannerResponseItem adMostBannerResponseItem) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        if (adMostBannerResponseItem == null || (i = adMostBannerResponseItem.LifeTime) <= 0) {
            i = 30;
        }
        return currentTimeMillis + ((long) (i * 1000 * 60));
    }

    public AdMostItem getFromCache(String str) {
        AdMostItem adMostItem = this.CACHE_MAP.get(str);
        this.CACHE_MAP.remove(str);
        if (adMostItem == null || adMostItem.expiresAt <= System.currentTimeMillis()) {
            return null;
        }
        return adMostItem;
    }
}
