package admost.sdk;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostBannerResponseFailReason;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.base.AdMostImpressionManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostUtil;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.listener.AdMostBannerInterfaceListener;
import admost.sdk.listener.AdMostManagerListener;
import admost.sdk.listener.AdMostRefreshListener;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostBannerResponseBase;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostFrequencyCappingItem;
import admost.sdk.model.AdMostItem;
import admost.sdk.model.AdMostManagerItem;
import admost.sdk.model.AdMostRandomizerBypassItem;
import admost.sdk.model.AdMostWaterfallLog;
import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tapjoy.TapjoyConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class AdMostManager {
    public static final int AD_BANNER = 50;
    public static final int AD_LEADERBOARD = 90;
    public static final int AD_MEDIUM_RECTANGLE = 250;
    public static final int AD_REMOTE_DEFINED_HEIGHT = 0;
    /* access modifiers changed from: private */
    public static String className = "AdMost Banner Manager";
    private static AdMostManager instance;
    private static final Object lock = new Object();
    public ConcurrentHashMap<String, AdMostFrequencyCappingItem> adFrequencyMap = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, AdMostRandomizerBypassItem> adRandomizerBypassMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final Vector<AdMostView> adRefreshingBanners = new Vector<>();
    public boolean admanagerStarted = false;
    private AtomicBoolean atomicBooleanLock = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final ArrayList<AdMostBannerInterface> bannerInterfaceMap = new ArrayList<>();
    private ArrayList<Object> dummyReference = new ArrayList<>();
    /* access modifiers changed from: private */
    public Handler handler;
    /* access modifiers changed from: private */
    public long lastActiveTime = 0;
    private long lastNetworkCallTime;
    private long networkCallInterval = 250;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Integer> networkRequestCounts = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, AdMostManagerItem> placementListenersAndCacheMap = new ConcurrentHashMap<>();
    private Thread timeoutThread;
    /* access modifiers changed from: private */
    public long timerLastRun = 0;
    /* access modifiers changed from: private */
    public int timerRunCount = 0;
    private Thread timerThread;
    /* access modifiers changed from: private */
    public boolean timerThreadStopped;
    private int topActivityHash;

    static /* synthetic */ int access$108(AdMostManager adMostManager) {
        int i = adMostManager.timerRunCount;
        adMostManager.timerRunCount = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void addListener(AdMostManagerItem adMostManagerItem, AdMostManagerListener adMostManagerListener) {
        if (this.atomicBooleanLock.compareAndSet(false, true)) {
            try {
                adMostManagerListener.requestStartedAt = System.currentTimeMillis();
                adMostManagerItem.admostManagerListeners.add(adMostManagerListener);
                synchronized (this.placementListenersAndCacheMap) {
                    this.placementListenersAndCacheMap.notify();
                }
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                } catch (Throwable th) {
                    this.atomicBooleanLock.set(false);
                    throw th;
                }
            }
            this.atomicBooleanLock.set(false);
        }
    }

    private void clearCache() {
        try {
            for (Map.Entry<String, AdMostManagerItem> value : this.placementListenersAndCacheMap.entrySet()) {
                ((AdMostManagerItem) value.getValue()).ResetItem();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void destroyAllBanners() {
        AdMostAdNetworkManager.getInstance().destroyAllObjects();
    }

    /* access modifiers changed from: private */
    public void failed(String str, AdMostBannerResponseItem adMostBannerResponseItem, Vector<AdMostManagerListener> vector) {
        AdMostUtil.keepFrequencyCapping("NFFC*" + adMostBannerResponseItem.ZoneId + "*" + adMostBannerResponseItem.PlacementId);
        this.placementListenersAndCacheMap.get(str).noFillMarked = true;
        if (vector.size() > 0) {
            try {
                returnFailedToListener(vector.get(0), AdMostBannerResponseFailReason.NO_FILL_RESPONSE_FROM_NETWORK, str, adMostBannerResponseItem);
                removeListener(this.placementListenersAndCacheMap.get(str), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void getBanner(Activity activity, AdMostBannerResponseItem adMostBannerResponseItem, AdMostViewBinder adMostViewBinder, boolean z, AdMostManagerListener adMostManagerListener, String str, boolean z2) {
        final int i;
        AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerResponseItem;
        AdMostManagerListener adMostManagerListener2 = adMostManagerListener;
        final String cacheKey = getCacheKey(adMostBannerResponseItem2);
        int i2 = 0;
        if (AdMost.getInstance().getConfiguration() != null) {
            i = AdMost.getInstance().getConfiguration().getMaxRequestPerWaterfall(adMostBannerResponseItem2.Network, adMostBannerResponseItem2.ZoneId, z2, adMostBannerResponseItem2.IsFirstRequestForNetwork);
        } else {
            boolean z3 = z2;
            i = 0;
        }
        final String str2 = adMostBannerResponseItem2.Network + str;
        if (i > 0) {
            ConcurrentHashMap<String, Integer> concurrentHashMap = this.networkRequestCounts;
            if (!(concurrentHashMap == null || concurrentHashMap.get(str2) == null)) {
                i2 = this.networkRequestCounts.get(str2).intValue();
            }
            if (i2 >= i) {
                AdMostLog.m299i(className + " : Network request blocked because of network request limit. Item Key: " + cacheKey);
                if (adMostManagerListener2 != null) {
                    returnFailedToListener(adMostManagerListener2, AdMostBannerResponseFailReason.REQUEST_LIMIT_PER_WATERFALL, cacheKey, adMostBannerResponseItem2);
                    return;
                }
                return;
            }
        }
        final AdMostBannerInterface bannerAdapter = AdMostAdNetworkManager.getInstance().getBannerAdapter(adMostBannerResponseItem2);
        Activity activity2 = activity;
        if (bannerAdapter != null && !bannerAdapter.isActivityRequiredForLoad(activity2)) {
            activity2 = null;
        }
        final Activity activity3 = activity2;
        final boolean z4 = z;
        final AdMostManagerListener adMostManagerListener3 = adMostManagerListener;
        final AdMostBannerResponseItem adMostBannerResponseItem3 = adMostBannerResponseItem;
        final AdMostViewBinder adMostViewBinder2 = adMostViewBinder;
        final String str3 = str;
        final boolean z5 = z2;
        this.handler.postDelayed(new Runnable() {
            public void run() {
                if (z4 && adMostManagerListener3 != null) {
                    AdMostManager adMostManager = AdMostManager.this;
                    adMostManager.addListener((AdMostManagerItem) adMostManager.placementListenersAndCacheMap.get(cacheKey), adMostManagerListener3);
                }
                if (((AdMostManagerItem) AdMostManager.this.placementListenersAndCacheMap.get(cacheKey)).cachedBanners == null || ((AdMostManagerItem) AdMostManager.this.placementListenersAndCacheMap.get(cacheKey)).cachedBanners.size() <= 0) {
                    int i = 0;
                    if (!z4 && !AdMostUtil.checkFrequencyCapping(adMostBannerResponseItem3, false)) {
                        AdMostLog.m299i(AdMostManager.className + " : Network request not started because of FREQUENCY CAPPING " + cacheKey);
                    } else if (bannerAdapter == null) {
                        AdMostManager adMostManager2 = AdMostManager.this;
                        adMostManager2.failed(cacheKey, adMostBannerResponseItem3, ((AdMostManagerItem) adMostManager2.placementListenersAndCacheMap.get(cacheKey)).admostManagerListeners);
                    } else {
                        if (adMostBannerResponseItem3.Network.equals(AdMostAdNetwork.MOPUB)) {
                            bannerAdapter.setNativeBinder(adMostViewBinder2);
                        }
                        if (i > 0) {
                            if (!(AdMostManager.this.networkRequestCounts == null || AdMostManager.this.networkRequestCounts.get(str2) == null)) {
                                i = ((Integer) AdMostManager.this.networkRequestCounts.get(str2)).intValue();
                            }
                            if (i >= i) {
                                if (z4) {
                                    AdMostManager adMostManager3 = AdMostManager.this;
                                    adMostManager3.failed(cacheKey, adMostBannerResponseItem3, ((AdMostManagerItem) adMostManager3.placementListenersAndCacheMap.get(cacheKey)).admostManagerListeners);
                                }
                                AdMostLog.m299i(AdMostManager.className + " : Network request blocked because of network request limit. Item Key: " + cacheKey);
                                return;
                            }
                            AdMostManager.this.networkRequestCounts.put(str2, Integer.valueOf(i + 1));
                        }
                        if (activity3 != null) {
                            synchronized (AdMostManager.this.bannerInterfaceMap) {
                                bannerAdapter.expiresAt = System.currentTimeMillis() + 20000;
                                AdMostManager.this.bannerInterfaceMap.add(bannerAdapter);
                            }
                        }
                        AdMostLog.m299i(AdMostManager.className + " : Network request started Item Key: " + cacheKey);
                        bannerAdapter.load(adMostBannerResponseItem3, new WeakReference(activity3), new AdMostBannerInterfaceListener() {
                            public void onFail() {
                                AdMostImpressionManager.getInstance().setPlacementImpressionData(5, adMostBannerResponseItem3);
                                C01434 r0 = C01434.this;
                                AdMostManager adMostManager = AdMostManager.this;
                                adMostManager.failed(cacheKey, adMostBannerResponseItem3, ((AdMostManagerItem) adMostManager.placementListenersAndCacheMap.get(cacheKey)).admostManagerListeners);
                            }

                            public void onReady(AdMostBannerInterface adMostBannerInterface) {
                                if (AdMostManager.this.setAd(adMostBannerInterface)) {
                                    C01434 r0 = C01434.this;
                                    AdMostManager.this.getBanner(activity3, adMostBannerResponseItem3, adMostViewBinder2, false, (AdMostManagerListener) null, str3, z5);
                                }
                                adMostBannerInterface.mInterfaceListener = null;
                            }
                        });
                    }
                } else if (z4) {
                    AdMostManager adMostManager4 = AdMostManager.this;
                    adMostManager4.failed(cacheKey, adMostBannerResponseItem3, ((AdMostManagerItem) adMostManager4.placementListenersAndCacheMap.get(cacheKey)).admostManagerListeners);
                }
            }
        }, getCallDelay());
    }

    private long getCallDelay() {
        long currentTimeMillis = (this.lastNetworkCallTime - System.currentTimeMillis()) + this.networkCallInterval;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 1;
        }
        if (currentTimeMillis > TapjoyConstants.TIMER_INCREMENT) {
            currentTimeMillis = 10000;
        }
        this.lastNetworkCallTime = System.currentTimeMillis() + currentTimeMillis;
        return currentTimeMillis;
    }

    public static AdMostManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostManager();
                }
            }
        }
        return instance;
    }

    private void removeListener(AdMostManagerItem adMostManagerItem, int i) {
        if (this.atomicBooleanLock.compareAndSet(false, true)) {
            try {
                adMostManagerItem.admostManagerListeners.remove(i);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                this.atomicBooleanLock.set(false);
                throw th;
            }
            this.atomicBooleanLock.set(false);
        }
    }

    private void returnBannerToListener(String str, String str2, AdMostManagerListener adMostManagerListener, AdMostItem adMostItem, boolean z, AdMostBannerResponseItem adMostBannerResponseItem) {
        if (z) {
            String str3 = str;
            this.placementListenersAndCacheMap.get(str).cachedBanners.remove(0);
        } else {
            String str4 = str;
        }
        final AdMostManagerListener adMostManagerListener2 = adMostManagerListener;
        final AdMostItem adMostItem2 = adMostItem;
        final boolean z2 = z;
        final String str5 = str;
        final AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerResponseItem;
        final String str6 = str2;
        this.handler.post(new Runnable() {
            public void run() {
                int onAdLoad = adMostManagerListener2.onAdLoad(adMostItem2.getNetwork(), adMostItem2);
                if (onAdLoad == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(AdMostManager.className);
                    sb.append(" : listenerId: ");
                    sb.append(adMostManagerListener2.listenerId);
                    sb.append(" Returned to listener ");
                    sb.append(z2 ? "From CACHE " : "");
                    sb.append("*");
                    sb.append(str5);
                    sb.append("* , PlacementName: ");
                    sb.append(adMostBannerResponseItem2.PlacementName);
                    sb.append(" , Ecpm: ");
                    sb.append(adMostBannerResponseItem2.PureWeight);
                    AdMostLog.m299i(sb.toString());
                    if (z2) {
                        AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem2.WaterFallLogItem;
                        adMostWaterfallLog.isCached = true;
                        adMostWaterfallLog.isFilled = false;
                    }
                    AdMostUtil.keepFrequencyCapping(str6);
                } else if (onAdLoad == 1) {
                    AdMostManager.this.putItemToCache(str5, adMostItem2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void returnFailedToListener(final AdMostManagerListener adMostManagerListener, final String str, String str2, AdMostBannerResponseItem adMostBannerResponseItem) {
        StringBuilder sb = new StringBuilder();
        sb.append(className);
        sb.append(" : listenerId: ");
        sb.append(adMostManagerListener.listenerId);
        sb.append(" Failed : ");
        sb.append(str);
        sb.append(" for Item Key: *");
        sb.append(str2);
        sb.append("* , placement: ");
        sb.append(adMostBannerResponseItem != null ? adMostBannerResponseItem.toString() : "bannerResponseItem null");
        AdMostLog.m299i(sb.toString());
        this.handler.post(new Runnable() {
            public void run() {
                adMostManagerListener.onAdFailed(str);
                if (str.equals(AdMostBannerResponseFailReason.NO_FILL_MARKED)) {
                    adMostManagerListener.dontTryNextWaterfallItem = true;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean setAd(AdMostBannerInterface adMostBannerInterface) {
        if (adMostBannerInterface == null) {
            AdMostLog.m296e("AdMostManager.setAd(...) - bannerInterface is null");
            return false;
        }
        AdMostBannerResponseItem adMostBannerResponseItem = adMostBannerInterface.mBannerResponseItem;
        if (adMostBannerResponseItem == null) {
            AdMostLog.m296e("AdMostManager.setAd(...) - bannerResponseItem is null");
            return false;
        }
        String cacheKey = getCacheKey(adMostBannerResponseItem);
        AdMostUtil.clearNffc("NFFC*" + adMostBannerResponseItem.ZoneId + "*" + adMostBannerResponseItem.PlacementId);
        AdMostImpressionManager.getInstance().setPlacementImpressionData(3, adMostBannerResponseItem);
        AdMostManagerItem adMostManagerItem = this.placementListenersAndCacheMap.get(cacheKey);
        if (adMostManagerItem == null) {
            AdMostLog.m296e("AdMostManager.setAd(...) - adManagerItem is null");
            return false;
        }
        adMostManagerItem.noFillMarked = false;
        AdMostItem adMostItem = new AdMostItem(adMostBannerResponseItem.Network, (long) adMostBannerResponseItem.LifeTime, adMostBannerInterface);
        adMostItem.cacheKey = cacheKey;
        if (this.placementListenersAndCacheMap.get(cacheKey).admostManagerListeners.size() > 0) {
            try {
                returnBannerToListener(cacheKey, adMostBannerResponseItem.ZoneId + "*" + adMostBannerResponseItem.PlacementId, this.placementListenersAndCacheMap.get(cacheKey).admostManagerListeners.get(0), adMostItem, false, adMostBannerResponseItem);
                removeListener(adMostManagerItem, 0);
                if (!adMostItem.isSafeForCache() || this.placementListenersAndCacheMap.get(cacheKey).admostManagerListeners.size() != 0 || adMostManagerItem.cachedBanners.size() != 0 || ((AdMostBannerInterface) adMostItem.getAd()).mBannerResponseItem.IsBoostedItem) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (adMostItem.isSafeForCache()) {
            AdMostLog.m294d(className + " : Cache Success! Item Key: " + cacheKey);
            adMostBannerResponseItem.WaterFallLogItem.isCached = true;
            adMostManagerItem.cachedBanners.add(adMostItem);
        } else {
            adMostBannerInterface.destroy();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void stopTimer() {
        if (this.timerThread != null) {
            this.timerThreadStopped = true;
            this.timerThread = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void addRefreshingBanner(AdMostView adMostView) {
        try {
            synchronized (this.adRefreshingBanners) {
                int i = 0;
                while (i < this.adRefreshingBanners.size()) {
                    if (!adMostView.equals(this.adRefreshingBanners.get(i))) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.adRefreshingBanners.add(adMostView);
            }
        } catch (Exception unused) {
        }
    }

    public void addToDummyReference(Object obj) {
        this.dummyReference.add(obj);
    }

    /* access modifiers changed from: package-private */
    public String getCacheKey(AdMostBannerResponseItem adMostBannerResponseItem) {
        if (adMostBannerResponseItem == null) {
            return "no_key";
        }
        return adMostBannerResponseItem.Network + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostBannerResponseItem.Type + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostBannerResponseItem.ZoneSize + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostBannerResponseItem.AdSpaceId + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostBannerResponseItem.LocalCustomLayoutId;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getNextAd(android.app.Activity r15, admost.sdk.model.AdMostBannerResponseItem r16, admost.sdk.listener.AdMostManagerListener r17, admost.sdk.AdMostViewBinder r18, boolean r19) {
        /*
            r14 = this;
            r8 = r14
            r7 = r16
            r9 = r17
            r14.start()
            java.lang.String r10 = r14.getCacheKey(r7)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.model.AdMostManagerItem> r0 = r8.placementListenersAndCacheMap
            boolean r0 = r0.containsKey(r10)
            if (r0 == 0) goto L_0x0020
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.model.AdMostManagerItem> r0 = r8.placementListenersAndCacheMap
            java.lang.Object r0 = r0.get(r10)
            admost.sdk.model.AdMostManagerItem r0 = (admost.sdk.model.AdMostManagerItem) r0
            r0.setBannerResponseItem(r7)
            goto L_0x002a
        L_0x0020:
            admost.sdk.model.AdMostManagerItem r0 = new admost.sdk.model.AdMostManagerItem
            r0.<init>(r7)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.model.AdMostManagerItem> r1 = r8.placementListenersAndCacheMap
            r1.put(r10, r0)
        L_0x002a:
            r11 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = className
            r0.append(r1)
            java.lang.String r1 = " getNextAd method : listenerId : "
            r0.append(r1)
            int r1 = r9.listenerId
            r0.append(r1)
            java.lang.String r1 = " , key: *"
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = "* , Placement : "
            r0.append(r1)
            if (r7 == 0) goto L_0x0053
            java.lang.String r1 = r16.toString()
            goto L_0x0055
        L_0x0053:
            java.lang.String r1 = "bannerResponseItem null"
        L_0x0055:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            admost.sdk.base.AdMostLog.m294d(r0)
            java.util.Vector<admost.sdk.listener.AdMostManagerListener> r0 = r11.admostManagerListeners
            int r0 = r0.size()
            r1 = 10
            if (r0 <= r1) goto L_0x006f
            java.lang.String r0 = "TOO_MANY_LISTENER_FOR_THIS_ADSPACE"
            r14.returnFailedToListener(r9, r0, r10, r7)
            return
        L_0x006f:
            boolean r0 = r7.IsTestItem
            if (r0 != 0) goto L_0x0081
            boolean r0 = r9.isSecondRun
            boolean r0 = admost.sdk.base.AdMostUtil.checkFrequencyCapping(r7, r0)
            if (r0 != 0) goto L_0x0081
            java.lang.String r0 = "FREQUENCY_CAPPING"
            r14.returnFailedToListener(r9, r0, r10, r7)
            return
        L_0x0081:
            java.util.Vector<admost.sdk.model.AdMostItem> r0 = r11.cachedBanners
            int r0 = r0.size()
            r12 = 1
            r13 = 0
            if (r0 <= 0) goto L_0x00e1
            java.util.Vector<admost.sdk.model.AdMostItem> r0 = r11.cachedBanners
            java.lang.Object r0 = r0.get(r13)
            r4 = r0
            admost.sdk.model.AdMostItem r4 = (admost.sdk.model.AdMostItem) r4
            java.lang.Object r0 = r4.getAd()
            if (r0 == 0) goto L_0x00e1
            long r0 = r4.expiresAt
            long r2 = java.lang.System.currentTimeMillis()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x00d8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r7.ZoneId
            r0.append(r1)
            java.lang.String r1 = "*"
            r0.append(r1)
            java.lang.String r1 = r7.PlacementId
            r0.append(r1)
            java.lang.String r2 = r0.toString()
            r5 = 1
            r0 = r14
            r1 = r10
            r3 = r17
            r6 = r16
            r0.returnBannerToListener(r1, r2, r3, r4, r5, r6)
            boolean r0 = r11.isSafeForCache()
            if (r0 == 0) goto L_0x00d7
            java.util.Vector<admost.sdk.model.AdMostItem> r0 = r11.cachedBanners
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00d5
            goto L_0x00d7
        L_0x00d5:
            r0 = 1
            goto L_0x00e2
        L_0x00d7:
            return
        L_0x00d8:
            java.util.Vector<admost.sdk.model.AdMostItem> r0 = r11.cachedBanners
            r0.remove(r13)
            r14.getNextAd(r15, r16, r17, r18, r19)
            return
        L_0x00e1:
            r0 = 0
        L_0x00e2:
            boolean r1 = r7.IsTestItem
            if (r1 != 0) goto L_0x010a
            boolean r1 = r11.isSafeForCache()
            if (r1 == 0) goto L_0x010a
            java.util.Vector<admost.sdk.model.AdMostItem> r1 = r11.cachedBanners
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00fd
            java.util.Vector<admost.sdk.model.AdMostItem> r1 = r11.cachedBanners
            java.lang.Object r1 = r1.get(r13)
            if (r1 == 0) goto L_0x00fd
            return
        L_0x00fd:
            boolean r1 = r11.noFillMarked
            if (r1 == 0) goto L_0x010a
            boolean r1 = r9.isSecondRun
            if (r1 != 0) goto L_0x010a
            java.lang.String r1 = "NO_FILL_MARKED"
            r14.returnFailedToListener(r9, r1, r10, r7)
        L_0x010a:
            r4 = r0 ^ 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r9.listenerId
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            int r1 = r9.requestNumber
            r0.append(r1)
            java.lang.String r6 = r0.toString()
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r18
            r5 = r17
            r7 = r19
            r0.getBanner(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostManager.getNextAd(android.app.Activity, admost.sdk.model.AdMostBannerResponseItem, admost.sdk.listener.AdMostManagerListener, admost.sdk.AdMostViewBinder, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public int getTopActivityHash() {
        return this.topActivityHash;
    }

    public void pauseAllBanners() {
    }

    /* access modifiers changed from: package-private */
    public void putItemToCache(String str, AdMostItem adMostItem) {
        try {
            if (adMostItem.isSafeForCache()) {
                AdMostLog.m299i(className + " : Banner Re-cached - Item Key: " + str);
                ((AdMostBannerInterface) adMostItem.getAd()).mBannerResponseItem.WaterFallLogItem.isCached = true;
                this.placementListenersAndCacheMap.get(str).cachedBanners.add(adMostItem);
                return;
            }
            ((AdMostBannerInterface) adMostItem.getAd()).destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshAd(Activity activity, String str, int i, final AdMostRefreshListener adMostRefreshListener) {
        AdMostLog.m294d(className + " : admostViewId : " + i + " ,  Refresh request Started for zoneId : " + str);
        if (AdMostUtil.isNetworkAvailable(activity) == 1) {
            new AdMostGenericRequest(AdMostGenericRequest.RequestType.ZONE_RESPONSE, str, new AdmostResponseListener<AdMostBannerResponseBase>() {
                public void onError(String str, Exception exc) {
                    adMostRefreshListener.onError(500);
                }

                public void onResponse(AdMostBannerResponseBase adMostBannerResponseBase) {
                    if (adMostBannerResponseBase != null) {
                        if (adMostBannerResponseBase.Result == -1 || adMostBannerResponseBase.isEmpty()) {
                            adMostRefreshListener.onError(AdMost.AD_ERROR_WATERFALL_EMPTY);
                            return;
                        }
                        String str = adMostBannerResponseBase.ApplicationId;
                        if (str != null && !str.equals("") && !adMostBannerResponseBase.ApplicationId.equals(AdMost.getInstance().getAppId())) {
                            adMostRefreshListener.onError(AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID);
                            AdMostLog.m296e("Application ID and Zone ID is not compatible, please CHECK your definitions..!");
                        } else if (AdMostUtil.checkZoneFrequencyCapping(adMostBannerResponseBase, false).isCapAvailable) {
                            adMostRefreshListener.onError(AdMost.AD_ERROR_FREQ_CAP);
                        } else {
                            adMostRefreshListener.onAdMediation(adMostBannerResponseBase);
                        }
                    }
                }
            }).mo611go(new String[0]);
            return;
        }
        AdMostLog.m303w(className + " :  Ad could not be called, please check network state.");
        adMostRefreshListener.onError(500);
    }

    public void removeFromDummyReference(Object obj) {
        this.dummyReference.remove(obj);
    }

    public void resumeAllBanners() {
    }

    public void setTopActivityHash(Activity activity) {
        this.topActivityHash = activity.getClass().hashCode();
    }

    public void start() {
        if (AdMost.getInstance().isInitStarted()) {
            this.lastActiveTime = System.currentTimeMillis();
            if (this.timerThread == null) {
                this.timerRunCount = 0;
                this.admanagerStarted = true;
                this.networkCallInterval = Build.VERSION.SDK_INT >= 21 ? this.networkCallInterval : 250;
                this.handler = new Handler(Looper.getMainLooper());
                this.timerThreadStopped = false;
                Thread thread = new Thread(new Runnable() {
                    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
                        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
                        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
                        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
                        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
                        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
                        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
                        */
                    public void run() {
                        /*
                            r10 = this;
                            r0 = 10
                            android.os.Process.setThreadPriority(r0)
                            java.lang.Thread r0 = java.lang.Thread.currentThread()
                            java.lang.String r1 = "AdMostTimer"
                            r0.setName(r1)
                            monitor-enter(r10)
                        L_0x000f:
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x0152 }
                            boolean r0 = r0.timerThreadStopped     // Catch:{ all -> 0x0152 }
                            if (r0 != 0) goto L_0x0150
                            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()     // Catch:{ all -> 0x0152 }
                            boolean r0 = r0.isInitStarted()     // Catch:{ all -> 0x0152 }
                            if (r0 != 0) goto L_0x0023
                            goto L_0x0150
                        L_0x0023:
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0145 }
                            int r0 = r0.timerRunCount     // Catch:{ Exception -> 0x0145 }
                            r1 = 5
                            int r0 = r0 % r1
                            r2 = 0
                            if (r0 != 0) goto L_0x00c9
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0145 }
                            java.util.Vector r0 = r0.adRefreshingBanners     // Catch:{ Exception -> 0x0145 }
                            monitor-enter(r0)     // Catch:{ Exception -> 0x0145 }
                            r3 = 0
                        L_0x0036:
                            admost.sdk.AdMostManager r4 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x00c6 }
                            java.util.Vector r4 = r4.adRefreshingBanners     // Catch:{ all -> 0x00c6 }
                            int r4 = r4.size()     // Catch:{ all -> 0x00c6 }
                            if (r3 >= r4) goto L_0x0075
                            admost.sdk.AdMostManager r4 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x006e }
                            java.util.Vector r4 = r4.adRefreshingBanners     // Catch:{ Exception -> 0x006e }
                            java.lang.Object r4 = r4.get(r3)     // Catch:{ Exception -> 0x006e }
                            admost.sdk.AdMostView r4 = (admost.sdk.AdMostView) r4     // Catch:{ Exception -> 0x006e }
                            boolean r4 = r4.isDestroyed()     // Catch:{ Exception -> 0x006e }
                            if (r4 == 0) goto L_0x005e
                            admost.sdk.AdMostManager r4 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x006e }
                            java.util.Vector r4 = r4.adRefreshingBanners     // Catch:{ Exception -> 0x006e }
                            r4.remove(r3)     // Catch:{ Exception -> 0x006e }
                            goto L_0x0072
                        L_0x005e:
                            admost.sdk.AdMostManager r4 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x006e }
                            java.util.Vector r4 = r4.adRefreshingBanners     // Catch:{ Exception -> 0x006e }
                            java.lang.Object r4 = r4.get(r3)     // Catch:{ Exception -> 0x006e }
                            admost.sdk.AdMostView r4 = (admost.sdk.AdMostView) r4     // Catch:{ Exception -> 0x006e }
                            r4.refreshAd()     // Catch:{ Exception -> 0x006e }
                            goto L_0x0072
                        L_0x006e:
                            r4 = move-exception
                            r4.printStackTrace()     // Catch:{ all -> 0x00c6 }
                        L_0x0072:
                            int r3 = r3 + 1
                            goto L_0x0036
                        L_0x0075:
                            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0145 }
                            java.util.ArrayList r0 = r0.bannerInterfaceMap     // Catch:{ Exception -> 0x0145 }
                            monitor-enter(r0)     // Catch:{ Exception -> 0x0145 }
                            admost.sdk.AdMostManager r3 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x00c3 }
                            java.util.ArrayList r3 = r3.bannerInterfaceMap     // Catch:{ all -> 0x00c3 }
                            int r3 = r3.size()     // Catch:{ all -> 0x00c3 }
                            if (r3 <= 0) goto L_0x00ba
                            admost.sdk.AdMostManager r3 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x00c3 }
                            java.util.ArrayList r3 = r3.bannerInterfaceMap     // Catch:{ all -> 0x00c3 }
                            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00c3 }
                        L_0x0093:
                            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00c3 }
                            if (r4 == 0) goto L_0x00ba
                            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00c3 }
                            admost.sdk.interfaces.AdMostBannerInterface r4 = (admost.sdk.interfaces.AdMostBannerInterface) r4     // Catch:{ all -> 0x00c3 }
                            if (r4 != 0) goto L_0x00a5
                            r3.remove()     // Catch:{ all -> 0x00c3 }
                            goto L_0x0093
                        L_0x00a5:
                            long r5 = r4.expiresAt     // Catch:{ all -> 0x00c3 }
                            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00c3 }
                            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                            if (r9 >= 0) goto L_0x0093
                            boolean r5 = r4.hasResponse     // Catch:{ all -> 0x00c3 }
                            if (r5 != 0) goto L_0x00b6
                            r4.destroy()     // Catch:{ all -> 0x00c3 }
                        L_0x00b6:
                            r3.remove()     // Catch:{ all -> 0x00c3 }
                            goto L_0x0093
                        L_0x00ba:
                            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
                            admost.sdk.base.AdMostUserDataManager r0 = admost.sdk.base.AdMostUserDataManager.getInstance()     // Catch:{ Exception -> 0x0145 }
                            r0.storeData()     // Catch:{ Exception -> 0x0145 }
                            goto L_0x00c9
                        L_0x00c3:
                            r1 = move-exception
                            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
                            throw r1     // Catch:{ Exception -> 0x0145 }
                        L_0x00c6:
                            r1 = move-exception
                            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
                            throw r1     // Catch:{ Exception -> 0x0145 }
                        L_0x00c9:
                            admost.sdk.base.AdMostPreferences r0 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ Exception -> 0x0145 }
                            if (r0 != 0) goto L_0x00de
                            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()     // Catch:{ Exception -> 0x0145 }
                            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0145 }
                            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x0145 }
                            admost.sdk.base.AdMostPreferences.newInstance(r0)     // Catch:{ Exception -> 0x0145 }
                        L_0x00de:
                            admost.sdk.base.AdMostImpressionManager r0 = admost.sdk.base.AdMostImpressionManager.getInstance()     // Catch:{ Exception -> 0x0145 }
                            r0.storeAdNetworkDataIntoSharedPrefs()     // Catch:{ Exception -> 0x0145 }
                            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0145 }
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0145 }
                            long r5 = r0.lastActiveTime     // Catch:{ Exception -> 0x0145 }
                            long r3 = r3 - r5
                            r5 = 600000(0x927c0, double:2.964394E-318)
                            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                            if (r0 <= 0) goto L_0x0105
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0145 }
                            android.os.Handler r0 = r0.handler     // Catch:{ Exception -> 0x0145 }
                            admost.sdk.AdMostManager$2$1 r3 = new admost.sdk.AdMostManager$2$1     // Catch:{ Exception -> 0x0145 }
                            r3.<init>()     // Catch:{ Exception -> 0x0145 }
                            r0.post(r3)     // Catch:{ Exception -> 0x0145 }
                        L_0x0105:
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0145 }
                            admost.sdk.AdMostManager.access$108(r0)     // Catch:{ Exception -> 0x0145 }
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0135 }
                            int r0 = r0.timerRunCount     // Catch:{ Exception -> 0x0135 }
                            if (r0 == r1) goto L_0x011c
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0135 }
                            int r0 = r0.timerRunCount     // Catch:{ Exception -> 0x0135 }
                            int r0 = r0 % 30
                            if (r0 != 0) goto L_0x0135
                        L_0x011c:
                            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()     // Catch:{ Exception -> 0x0135 }
                            boolean r0 = r0.isOnForeGround()     // Catch:{ Exception -> 0x0135 }
                            if (r0 == 0) goto L_0x0135
                            admost.sdk.base.AdMostAnalyticsManager r0 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ Exception -> 0x0135 }
                            r0.setSessionData(r2)     // Catch:{ Exception -> 0x0135 }
                            admost.sdk.base.AdMostAnalyticsManager r0 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ Exception -> 0x0135 }
                            r1 = 1
                            r0.setSessionData(r1)     // Catch:{ Exception -> 0x0135 }
                        L_0x0135:
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0145 }
                            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0145 }
                            long unused = r0.timerLastRun = r1     // Catch:{ Exception -> 0x0145 }
                            r0 = 1000(0x3e8, double:4.94E-321)
                            r10.wait(r0)     // Catch:{ Exception -> 0x0145 }
                            goto L_0x000f
                        L_0x0145:
                            r0 = move-exception
                            r0.printStackTrace()     // Catch:{ all -> 0x0152 }
                            admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x0152 }
                            r0.stopTimer()     // Catch:{ all -> 0x0152 }
                            goto L_0x000f
                        L_0x0150:
                            monitor-exit(r10)     // Catch:{ all -> 0x0152 }
                            return
                        L_0x0152:
                            r0 = move-exception
                            monitor-exit(r10)     // Catch:{ all -> 0x0152 }
                            goto L_0x0156
                        L_0x0155:
                            throw r0
                        L_0x0156:
                            goto L_0x0155
                        */
                        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostManager.C01402.run():void");
                    }
                });
                this.timerThread = thread;
                thread.setName("AdMostTimer");
                this.timerThread.start();
                if (this.timeoutThread == null) {
                    Thread thread2 = new Thread(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0156, code lost:
                            r2 = r2;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r19 = this;
                                r1 = r19
                                java.lang.Thread r0 = java.lang.Thread.currentThread()
                                java.lang.String r2 = "AdMostBannerTimeoutThread"
                                r0.setName(r2)
                                r0 = 10
                                android.os.Process.setThreadPriority(r0)
                                r2 = 100
                                r3 = 0
                                r6 = r3
                                r5 = 100
                            L_0x0017:
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
                                r0.<init>()     // Catch:{ Exception -> 0x0151 }
                                java.lang.String r8 = admost.sdk.AdMostManager.className     // Catch:{ Exception -> 0x0151 }
                                r0.append(r8)     // Catch:{ Exception -> 0x0151 }
                                java.lang.String r8 = " : Timeout Thread running"
                                r0.append(r8)     // Catch:{ Exception -> 0x0151 }
                                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0151 }
                                admost.sdk.base.AdMostLog.m301v(r0)     // Catch:{ Exception -> 0x0151 }
                                int r5 = r5 + 1
                                if (r5 < r2) goto L_0x0058
                                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0151 }
                                long r8 = r8 - r6
                                r10 = 10000(0x2710, double:4.9407E-320)
                                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                                if (r12 >= 0) goto L_0x0053
                                admost.sdk.AdMostManager r8 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0151 }
                                java.util.concurrent.ConcurrentHashMap r8 = r8.placementListenersAndCacheMap     // Catch:{ Exception -> 0x0151 }
                                monitor-enter(r8)     // Catch:{ Exception -> 0x0151 }
                                admost.sdk.AdMostManager r9 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x0050 }
                                java.util.concurrent.ConcurrentHashMap r9 = r9.placementListenersAndCacheMap     // Catch:{ all -> 0x0050 }
                                r9.wait(r10)     // Catch:{ all -> 0x0050 }
                                monitor-exit(r8)     // Catch:{ all -> 0x0050 }
                                goto L_0x0053
                            L_0x0050:
                                r0 = move-exception
                                monitor-exit(r8)     // Catch:{ all -> 0x0050 }
                                throw r0     // Catch:{ Exception -> 0x0151 }
                            L_0x0053:
                                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0151 }
                                r5 = 0
                            L_0x0058:
                                admost.sdk.AdMostManager r8 = admost.sdk.AdMostManager.this     // Catch:{ Exception -> 0x0151 }
                                java.util.concurrent.ConcurrentHashMap r8 = r8.placementListenersAndCacheMap     // Catch:{ Exception -> 0x0151 }
                                monitor-enter(r8)     // Catch:{ Exception -> 0x0151 }
                                admost.sdk.AdMostManager r9 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x0149 }
                                java.util.concurrent.ConcurrentHashMap r9 = r9.placementListenersAndCacheMap     // Catch:{ all -> 0x0149 }
                                java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0149 }
                                java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0149 }
                                r12 = 120000(0x1d4c0, double:5.9288E-319)
                            L_0x0070:
                                boolean r14 = r9.hasNext()     // Catch:{ all -> 0x0149 }
                                if (r14 == 0) goto L_0x00ec
                                java.lang.Object r14 = r9.next()     // Catch:{ all -> 0x0149 }
                                java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ all -> 0x0149 }
                                java.lang.Object r15 = r14.getValue()     // Catch:{ all -> 0x0149 }
                                admost.sdk.model.AdMostManagerItem r15 = (admost.sdk.model.AdMostManagerItem) r15     // Catch:{ all -> 0x0149 }
                                r0 = 0
                            L_0x0083:
                                java.util.Vector<admost.sdk.listener.AdMostManagerListener> r2 = r15.admostManagerListeners     // Catch:{ all -> 0x0149 }
                                int r2 = r2.size()     // Catch:{ all -> 0x0149 }
                                if (r0 >= r2) goto L_0x00e7
                                java.util.Vector<admost.sdk.listener.AdMostManagerListener> r2 = r15.admostManagerListeners     // Catch:{ all -> 0x0149 }
                                java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0149 }
                                admost.sdk.listener.AdMostManagerListener r2 = (admost.sdk.listener.AdMostManagerListener) r2     // Catch:{ all -> 0x0149 }
                                long r10 = r2.requestStartedAt     // Catch:{ all -> 0x0149 }
                                int r16 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                                if (r16 == 0) goto L_0x00c6
                                long r16 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0149 }
                                int r3 = r2.timeoutPeriod     // Catch:{ all -> 0x00c1 }
                                long r3 = (long) r3     // Catch:{ all -> 0x00c1 }
                                long r3 = r3 + r10
                                int r18 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
                                if (r18 <= 0) goto L_0x00be
                                r3 = 1
                                r15.noFillMarked = r3     // Catch:{ all -> 0x00c1 }
                                r3 = 10000000(0x989680, float:1.4012985E-38)
                                r2.timeoutPeriod = r3     // Catch:{ all -> 0x00c1 }
                                admost.sdk.AdMostManager r3 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x00c1 }
                                java.lang.String r4 = "TIMEOUT"
                                java.lang.Object r10 = r14.getKey()     // Catch:{ all -> 0x00c1 }
                                java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00c1 }
                                r11 = 0
                                r3.returnFailedToListener(r2, r4, r10, r11)     // Catch:{ all -> 0x00c1 }
                                r2 = 0
                                goto L_0x00e3
                            L_0x00be:
                                r3 = 0
                                goto L_0x00c6
                            L_0x00c1:
                                r0 = move-exception
                                r2 = 0
                                goto L_0x014b
                            L_0x00c6:
                                int r16 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                                if (r16 <= 0) goto L_0x00e2
                                int r2 = r2.timeoutPeriod     // Catch:{ all -> 0x0149 }
                                long r3 = (long) r2
                                long r10 = r10 + r3
                                r2 = 10
                                long r10 = r10 + r2
                                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00c1 }
                                long r10 = r10 - r2
                                r2 = 0
                                int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
                                if (r4 <= 0) goto L_0x00e3
                                int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                                if (r4 >= 0) goto L_0x00e3
                                r12 = r10
                                goto L_0x00e3
                            L_0x00e2:
                                r2 = r3
                            L_0x00e3:
                                int r0 = r0 + 1
                                r3 = r2
                                goto L_0x0083
                            L_0x00e7:
                                r2 = r3
                                r3 = r2
                                r2 = 100
                                goto L_0x0070
                            L_0x00ec:
                                r2 = r3
                                admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x014f }
                                java.util.concurrent.ConcurrentHashMap r0 = r0.placementListenersAndCacheMap     // Catch:{ all -> 0x014f }
                                int r0 = r0.size()     // Catch:{ all -> 0x014f }
                                if (r0 <= 0) goto L_0x0126
                                r9 = 120000(0x1d4c0, double:5.9288E-319)
                                int r0 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
                                if (r0 < 0) goto L_0x0101
                                goto L_0x0126
                            L_0x0101:
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x014f }
                                r0.<init>()     // Catch:{ all -> 0x014f }
                                java.lang.String r4 = admost.sdk.AdMostManager.className     // Catch:{ all -> 0x014f }
                                r0.append(r4)     // Catch:{ all -> 0x014f }
                                java.lang.String r4 = " : Timeout Thread waitForNext : "
                                r0.append(r4)     // Catch:{ all -> 0x014f }
                                r0.append(r12)     // Catch:{ all -> 0x014f }
                                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x014f }
                                admost.sdk.base.AdMostLog.m301v(r0)     // Catch:{ all -> 0x014f }
                                admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x014f }
                                java.util.concurrent.ConcurrentHashMap r0 = r0.placementListenersAndCacheMap     // Catch:{ all -> 0x014f }
                                r0.wait(r12)     // Catch:{ all -> 0x014f }
                                goto L_0x0147
                            L_0x0126:
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x014f }
                                r0.<init>()     // Catch:{ all -> 0x014f }
                                java.lang.String r4 = admost.sdk.AdMostManager.className     // Catch:{ all -> 0x014f }
                                r0.append(r4)     // Catch:{ all -> 0x014f }
                                java.lang.String r4 = ": Timeout Thread wait infinite"
                                r0.append(r4)     // Catch:{ all -> 0x014f }
                                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x014f }
                                admost.sdk.base.AdMostLog.m301v(r0)     // Catch:{ all -> 0x014f }
                                admost.sdk.AdMostManager r0 = admost.sdk.AdMostManager.this     // Catch:{ all -> 0x014f }
                                java.util.concurrent.ConcurrentHashMap r0 = r0.placementListenersAndCacheMap     // Catch:{ all -> 0x014f }
                                r0.wait()     // Catch:{ all -> 0x014f }
                            L_0x0147:
                                monitor-exit(r8)     // Catch:{ all -> 0x014f }
                                goto L_0x0156
                            L_0x0149:
                                r0 = move-exception
                                r2 = r3
                            L_0x014b:
                                monitor-exit(r8)     // Catch:{ all -> 0x014f }
                                throw r0     // Catch:{ Exception -> 0x014d }
                            L_0x014d:
                                r0 = move-exception
                                goto L_0x0153
                            L_0x014f:
                                r0 = move-exception
                                goto L_0x014b
                            L_0x0151:
                                r0 = move-exception
                                r2 = r3
                            L_0x0153:
                                r0.printStackTrace()
                            L_0x0156:
                                r3 = r2
                                r2 = 100
                                goto L_0x0017
                            */
                            throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostManager.C01423.run():void");
                        }
                    });
                    this.timeoutThread = thread2;
                    thread2.setName("AdMostManagerTimeoutThread");
                    this.timeoutThread.start();
                }
            } else if (this.timerLastRun != 0 && System.currentTimeMillis() - this.timerLastRun > 5000) {
                stopTimer();
            }
        }
    }

    public void stop() {
        this.admanagerStarted = false;
        try {
            this.networkRequestCounts.clear();
            AdMostInterstitialManager.getInstance().networkRequestCounts.clear();
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        stopTimer();
        destroyAllBanners();
        clearCache();
    }
}
