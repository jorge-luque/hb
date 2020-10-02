package admost.sdk.base;

import admost.sdk.AdMostView;
import admost.sdk.AdMostViewBinder;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.listener.AdMostViewListener;
import admost.sdk.model.AdMostBannerResponseBase;
import admost.sdk.model.AdMostItem;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class AdMostBannerZoneCacheManager {
    private static AdMostBannerZoneCacheManager instance;
    private static final Object lock = new Object();
    private AdMostBannerZoneCache[] cacheZones;
    /* access modifiers changed from: private */
    public Observer observer;
    private ConcurrentHashMap<String, Object[]> zoneCache = new ConcurrentHashMap<>();

    public static AdMostBannerZoneCacheManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostBannerZoneCacheManager();
                }
            }
        }
        return instance;
    }

    public void addToZoneCache(String str, AdMostItem adMostItem, AdMostBannerResponseBase adMostBannerResponseBase, int i, int i2) {
        AdMostLog.m294d(" Zone Cached : " + str + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + i + " key : " + adMostItem.cacheKey);
        ((AdMostBannerInterface) adMostItem.getAd()).pause();
        ConcurrentHashMap<String, Object[]> concurrentHashMap = this.zoneCache;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR);
        sb.append(i);
        concurrentHashMap.put(sb.toString(), new Object[]{adMostItem, adMostBannerResponseBase, Integer.valueOf(i2)});
    }

    public void clearZoneCache() {
        this.zoneCache.clear();
    }

    public Object[] getFromZoneCache(String str, int i) {
        String str2 = str + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + i;
        if (!this.zoneCache.containsKey(str2)) {
            return null;
        }
        Object[] objArr = this.zoneCache.get(str2);
        ((AdMostBannerInterface) ((AdMostItem) objArr[0]).getAd()).resume();
        this.zoneCache.remove(str2);
        return objArr;
    }

    /* access modifiers changed from: package-private */
    public void registerInit(AdMostBannerZoneCache[] adMostBannerZoneCacheArr) {
        this.cacheZones = adMostBannerZoneCacheArr;
        this.observer = new Observer() {
            public void update(Observable observable, Object obj) {
                if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                    AdMostInitObservable.getInstance().deleteObserver(AdMostBannerZoneCacheManager.this.observer);
                    AdMostBannerZoneCacheManager.this.startAllCacheRequests();
                    Observer unused = AdMostBannerZoneCacheManager.this.observer = null;
                }
            }
        };
        AdMostInitObservable.getInstance().addObserver(this.observer);
    }

    /* access modifiers changed from: package-private */
    public void startAllCacheRequests() {
        AdMostBannerZoneCache[] adMostBannerZoneCacheArr = this.cacheZones;
        if (adMostBannerZoneCacheArr != null && adMostBannerZoneCacheArr.length > 0) {
            for (AdMostBannerZoneCache adMostBannerZoneCache : adMostBannerZoneCacheArr) {
                startCacheRequest(adMostBannerZoneCache.ZoneId, adMostBannerZoneCache.Binder);
            }
        }
    }

    public void startCacheRequest(String str, AdMostViewBinder adMostViewBinder) {
        AdMostView adMostView = new AdMostView(AdMost.getInstance().getActivity(), str, 0, (AdMostViewListener) null, adMostViewBinder);
        adMostView.startRequestForZoneCache();
        adMostView.load();
    }
}
