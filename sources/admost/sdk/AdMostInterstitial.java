package admost.sdk;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdStatsManager;
import admost.sdk.base.AdMostAdType;
import admost.sdk.base.AdMostAnalyticsManager;
import admost.sdk.base.AdMostFloorPriceManager;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.base.AdMostImpressionManager;
import admost.sdk.base.AdMostInitObservable;
import admost.sdk.base.AdMostInterstitialCacheManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostPolicyManager;
import admost.sdk.base.AdMostPreferences;
import admost.sdk.base.AdMostSSVManager;
import admost.sdk.base.AdMostUtil;
import admost.sdk.base.AdMostWaterfallStrategyManager;
import admost.sdk.interfaces.AdMostAdInterface;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostAdListener;
import admost.sdk.listener.AdMostBiddingCompeteListener;
import admost.sdk.listener.AdMostFullScreenInterfaceListener;
import admost.sdk.listener.AdMostInterstitialEventListener;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostBannerResponseBase;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostBannerResponseType2;
import admost.sdk.model.AdMostWaterfallLog;
import admost.sdk.model.AdMostZoneFrequencyCapItem;
import android.app.Activity;
import android.os.Build;
import com.tapjoy.TapjoyConstants;
import com.vungle.warren.AdLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class AdMostInterstitial extends AdMostBiddingAdItem {
    private static final int ZONE_MAX_NO_FILL_INTERVAL = 16000;
    private static final int ZONE_START_NO_FILL_INTERVAL = 2000;
    private static final int ZONE_TWO_NO_FILL_USER_RESPONSE = 1000;
    public static final String ZONE_TYPE_INTERSTITIAL = "interstitial";
    public static final String ZONE_TYPE_OFFERWALL = "offerWall";
    public static final String ZONE_TYPE_REWARDED = "rewarded";
    /* access modifiers changed from: private */
    public static String className = "AdMost Interstitial";
    private final int RUN_FINAL = 7;
    private final int RUN_PRIORITY1_1 = 1;
    private final int RUN_PRIORITY1_2 = 2;
    private final int RUN_PRIORITY1_NOT_INITED = 3;
    private final int RUN_PRIORITY1_WAITING_REQUESTS = 4;
    private final int RUN_PRIORITY2_1 = 5;
    private final int RUN_PRIORITY2_NOT_INITED = 6;
    /* access modifiers changed from: private */
    public int adIndex = 0;
    /* access modifiers changed from: private */
    public AdMostAdListener adMostAdListener;
    private int adNumber;
    private boolean autoShow = true;
    /* access modifiers changed from: private */
    public Runnable capStatusRunnable = new Runnable() {
        public void run() {
            boolean unused = AdMostInterstitial.this.capStatusWaiting = false;
            if (AdMostInterstitial.this.adMostAdListener != null) {
                try {
                    AdMostInterstitial.this.adMostAdListener.onStatusChanged(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean capStatusWaiting = false;
    private int completionReward = 0;
    /* access modifiers changed from: private */
    public int currentRun = 1;
    /* access modifiers changed from: private */
    public boolean fillSent = false;
    /* access modifiers changed from: private */
    public FPBoosterItem fpBoosterItem = new FPBoosterItem();
    private ArrayList<String> fpBoosterTriedNetworkList = new ArrayList<>();
    /* access modifiers changed from: private */
    public String interstitialId;
    /* access modifiers changed from: private */
    public String interstitialRequestGUID;
    /* access modifiers changed from: private */
    public int interstitialStatus = 0;
    /* access modifiers changed from: private */
    public final ArrayList<AdMostBannerResponseItem> lastRoundList = new ArrayList<>();
    /* access modifiers changed from: private */
    public Vector<AdMostEventListenerOnLoadResponse> loadResults = new Vector<>();
    /* access modifiers changed from: private */
    public AdMostFullScreenInterface loadedAd;
    private long loadedAdCacheExpiresAt;
    /* access modifiers changed from: private */
    public AdMostBannerResponseItem loadedBannerResponseItem;
    private boolean loadedCallbackSet = false;
    private String loadedEventListener;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Integer> networkMinNoFillWeight = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> networkRequestCount = new ConcurrentHashMap<>();
    private boolean networkRequestStarted;
    private int noFillConsequentInterval = 2000;
    private long noFillIntervalFinishTime = AdLoader.RETRY_DELAY;
    private long noFillIntervalStartTime = 0;
    /* access modifiers changed from: private */
    public int numberOfPlacementRequest;
    /* access modifiers changed from: private */
    public Observer observer;
    /* access modifiers changed from: private */
    public boolean postedCumulativeResults;
    /* access modifiers changed from: private */
    public long refreshAdEndedAt;
    /* access modifiers changed from: private */
    public long refreshAdStartedAt;
    private int requestNumber;
    /* access modifiers changed from: private */
    public long requestTimeout;
    /* access modifiers changed from: private */
    public boolean scheduledShowNextAdWaiting;
    /* access modifiers changed from: private */
    public int showTryCount = 0;
    private boolean shownCallbackSet = false;
    private String shownTag = "";
    private Hashtable<String, Object> ssvCustomData;
    private String ssvServer = "";
    private String ssvUniqueId;
    /* access modifiers changed from: private */
    public String subZoneType = "";
    /* access modifiers changed from: private */
    public long tempCacheExpiresAt;
    /* access modifiers changed from: private */
    public String tempEventListener;
    /* access modifiers changed from: private */
    public String triedButNotShown = "";
    /* access modifiers changed from: private */
    public boolean waitingInitializationToComplete;
    /* access modifiers changed from: private */
    public int waitingResponseCount = 0;
    /* access modifiers changed from: private */
    public String zoneId = "";
    /* access modifiers changed from: private */
    public int zoneOverallTimeout;
    /* access modifiers changed from: private */
    public Timer zoneRequestTimer;
    /* access modifiers changed from: private */
    public long zoneResponseTimeoutAt;

    static class AdMostEventListenerOnLoadResponse {
        long cacheExpiresAt;
        String eventListener;
        AdMostFullScreenInterface fsInterface;

        AdMostEventListenerOnLoadResponse(AdMostFullScreenInterface adMostFullScreenInterface, long j, String str) {
            this.fsInterface = adMostFullScreenInterface;
            this.cacheExpiresAt = j;
            this.eventListener = str;
        }
    }

    public static class CustomComparatorOnLoadResponse implements Comparator<AdMostEventListenerOnLoadResponse> {
        public int compare(AdMostEventListenerOnLoadResponse adMostEventListenerOnLoadResponse, AdMostEventListenerOnLoadResponse adMostEventListenerOnLoadResponse2) {
            return Integer.valueOf(adMostEventListenerOnLoadResponse2.fsInterface.mBannerResponseItem.WeightWithoutMultiplier).compareTo(Integer.valueOf(adMostEventListenerOnLoadResponse.fsInterface.mBannerResponseItem.WeightWithoutMultiplier));
        }
    }

    private static class FPBoosterItem {
        int adPriority;
        int adWeight;
        String network;

        private FPBoosterItem() {
        }

        public void initialize() {
            this.adWeight = 0;
            this.adPriority = 0;
            this.network = "";
        }

        /* access modifiers changed from: package-private */
        public void setMaxValues(AdMostBannerResponseItem adMostBannerResponseItem) {
            int i = adMostBannerResponseItem.WeightWithoutMultiplier;
            if (i > this.adWeight) {
                this.adWeight = i;
                this.network = adMostBannerResponseItem.Network;
                this.adPriority = adMostBannerResponseItem.Priority;
            }
        }
    }

    public AdMostInterstitial(Activity activity, String str, AdMostAdListener adMostAdListener2) {
        initialize(activity, str, "", adMostAdListener2);
    }

    static /* synthetic */ int access$2108(AdMostInterstitial adMostInterstitial) {
        int i = adMostInterstitial.showTryCount;
        adMostInterstitial.showTryCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$2910(AdMostInterstitial adMostInterstitial) {
        int i = adMostInterstitial.waitingResponseCount;
        adMostInterstitial.waitingResponseCount = i - 1;
        return i;
    }

    private void clearZoneTimer() {
        Timer timer = this.zoneRequestTimer;
        if (timer != null) {
            timer.cancel();
            this.zoneRequestTimer.purge();
            this.zoneRequestTimer = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001b, code lost:
        r1 = r1.mBannerResponseItem;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clicked(final admost.sdk.model.AdMostBannerResponseItem r3) {
        /*
            r2 = this;
            admost.sdk.base.AdMostImpressionManager r0 = admost.sdk.base.AdMostImpressionManager.getInstance()
            r1 = 4
            r0.setPlacementImpressionData(r1, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = className
            r0.append(r1)
            java.lang.String r1 = " onClick : "
            r0.append(r1)
            admost.sdk.interfaces.AdMostFullScreenInterface r1 = r2.loadedAd
            if (r1 == 0) goto L_0x0024
            admost.sdk.model.AdMostBannerResponseItem r1 = r1.mBannerResponseItem
            if (r1 == 0) goto L_0x0024
            java.lang.String r1 = r1.toString()
            goto L_0x0026
        L_0x0024:
            java.lang.String r1 = ""
        L_0x0026:
            r0.append(r1)
            java.lang.String r1 = " ,interstitialId: "
            r0.append(r1)
            java.lang.String r1 = r2.interstitialId
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            admost.sdk.base.AdMostLog.m299i(r0)
            admost.sdk.listener.AdMostAdListener r0 = r2.adMostAdListener
            if (r0 != 0) goto L_0x003f
            return
        L_0x003f:
            android.os.Handler r0 = r2.getHandler()
            admost.sdk.AdMostInterstitial$10 r1 = new admost.sdk.AdMostInterstitial$10
            r1.<init>(r3)
            r0.post(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostInterstitial.clicked(admost.sdk.model.AdMostBannerResponseItem):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        r0 = r0.mBannerResponseItem;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void closed(admost.sdk.model.AdMostBannerResponseItem r3) {
        /*
            r2 = this;
            admost.sdk.interfaces.AdMostFullScreenInterface r0 = r2.loadedAd
            if (r0 == 0) goto L_0x000d
            admost.sdk.AdMostInterstitialManager r0 = admost.sdk.AdMostInterstitialManager.getInstance()
            admost.sdk.interfaces.AdMostFullScreenInterface r1 = r2.loadedAd
            r0.removeFromSingletonArray(r1)
        L_0x000d:
            if (r3 == 0) goto L_0x0014
            admost.sdk.model.AdMostWaterfallLog r3 = r3.WaterFallLogItem
            r0 = 1
            r3.isShown = r0
        L_0x0014:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = className
            r3.append(r0)
            java.lang.String r0 = " onDismiss : "
            r3.append(r0)
            admost.sdk.interfaces.AdMostFullScreenInterface r0 = r2.loadedAd
            if (r0 == 0) goto L_0x0030
            admost.sdk.model.AdMostBannerResponseItem r0 = r0.mBannerResponseItem
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = r0.toString()
            goto L_0x0032
        L_0x0030:
            java.lang.String r0 = ""
        L_0x0032:
            r3.append(r0)
            java.lang.String r0 = " ,interstitialId: "
            r3.append(r0)
            java.lang.String r0 = r2.interstitialId
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            admost.sdk.base.AdMostLog.m299i(r3)
            r3 = 0
            r2.interstitialStatus = r3
            r0 = 164(0xa4, float:2.3E-43)
            r2.onAction(r0, r3)
            admost.sdk.model.AdMostBannerResponseBase r3 = r2.waterfallResponse
            admost.sdk.base.AdMostUtil.showDebugActivity(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostInterstitial.closed(admost.sdk.model.AdMostBannerResponseItem):void");
    }

    /* access modifiers changed from: private */
    public void completed() {
        StringBuilder sb = new StringBuilder();
        sb.append(className);
        sb.append(" onComplete : ");
        AdMostBannerResponseItem adMostBannerResponseItem = this.loadedBannerResponseItem;
        sb.append(adMostBannerResponseItem != null ? adMostBannerResponseItem.toString() : "");
        sb.append(" , interstitialId: ");
        sb.append(this.interstitialId);
        AdMostLog.m299i(sb.toString());
        AdMostBannerResponseItem adMostBannerResponseItem2 = this.loadedBannerResponseItem;
        if (adMostBannerResponseItem2 != null) {
            adMostBannerResponseItem2.CompletionReward = this.completionReward;
        }
        AdMostImpressionManager.getInstance().setPlacementImpressionData(9, this.loadedBannerResponseItem);
        AdMostImpressionManager.getInstance().setZoneImpressionData(9, this.loadedBannerResponseItem.ZoneId, 0, this.subZoneType, this.completionReward);
        String str = this.shownTag;
        if (str != null && !"".equals(str)) {
            AdMostImpressionManager.getInstance().setPlacementTagData(9, this.shownTag, this.loadedBannerResponseItem);
        }
        AdMostSSVManager.getInstance().rewardedCompleted(this.ssvUniqueId);
        onAction(AdMostAdListener.COMPLETED, 0);
    }

    private void destroy(boolean z) {
        boolean z2;
        clearZoneTimer();
        if (this.interstitialStatus != 2 || this.loadedEventListener == null) {
            z2 = false;
        } else {
            AdMostLog.m294d(className + " : Destroyed interstitialId: " + this.interstitialId + " , interstitialStatus: " + AdMostUtil.getAdStatusName(this.interstitialStatus));
            z2 = AdMostInterstitialCacheManager.getInstance().addToCache(this.loadedEventListener, this.loadedAdCacheExpiresAt, this.loadedAd);
        }
        if (!z2 && z && this.loadedBannerResponseItem != null) {
            AdMostInterstitialManager.getInstance().removeFromSingletonArray(this.loadedAd);
        }
        this.interstitialStatus = 4;
        if (z) {
            this.adMostAdListener = null;
        }
        getHandler().removeCallbacks(this.capStatusRunnable);
        this.capStatusWaiting = false;
        AdMostInterstitialManager.getInstance().destroyInterstitial(this.interstitialId);
        AdMostBiddingManager.getInstance().destroyBidding(this.interstitialId);
        AdMostFullScreenInterface adMostFullScreenInterface = this.loadedAd;
        if (adMostFullScreenInterface != null && !z2) {
            adMostFullScreenInterface.destroy();
        }
        this.loadedAd = null;
        super.destroy();
        if (z) {
            setNetworkData((Hashtable) null);
            this.ssvCustomData = null;
            this.ssvServer = "";
        }
    }

    /* access modifiers changed from: private */
    public void failedToShow(AdMostBannerResponseItem adMostBannerResponseItem) {
        AdMostBannerResponseItem adMostBannerResponseItem2;
        AdMostImpressionManager instance = AdMostImpressionManager.getInstance();
        String str = this.zoneId;
        AdMostBannerResponseItem adMostBannerResponseItem3 = this.loadedBannerResponseItem;
        instance.setZoneImpressionData(7, str, adMostBannerResponseItem3 != null ? adMostBannerResponseItem3.PureWeight : 0, this.subZoneType);
        if (this.loadedAd != null) {
            AdMostInterstitialManager.getInstance().removeFromSingletonArray(this.loadedAd);
        }
        if (adMostBannerResponseItem != null) {
            adMostBannerResponseItem.WaterFallLogItem.isShown = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(className);
        sb.append(" onFailedToShow : ");
        AdMostFullScreenInterface adMostFullScreenInterface = this.loadedAd;
        sb.append((adMostFullScreenInterface == null || (adMostBannerResponseItem2 = adMostFullScreenInterface.mBannerResponseItem) == null) ? "" : adMostBannerResponseItem2.toString());
        sb.append(" ,interstitialId: ");
        sb.append(this.interstitialId);
        AdMostLog.m299i(sb.toString());
        this.interstitialStatus = 0;
        onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_FAILED_TO_SHOW);
        onAction(AdMostAdListener.CLOSED, AdMost.AD_ERROR_FAILED_TO_SHOW);
        AdMostUtil.showDebugActivity(this.waterfallResponse);
    }

    /* access modifiers changed from: private */
    public boolean getFPBoostedItem() {
        ArrayList<AdMostBannerResponseItem> arrayList;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        boolean z = false;
        if (!(adMostBannerResponseBase == null || (arrayList = adMostBannerResponseBase.NetworkListNotInWaterfall) == null || arrayList.size() <= 0)) {
            int size = this.waterfallResponse.NetworkListNotInWaterfall.size() - 1;
            while (true) {
                if (size >= 0) {
                    AdMostBannerResponseItem adMostBannerResponseItem = this.waterfallResponse.NetworkListNotInWaterfall.get(size);
                    int i = adMostBannerResponseItem.WeightWithoutMultiplier;
                    if (i > this.fpBoosterItem.adWeight && ((double) i) > getMaxBidPrice() && adMostBannerResponseItem.Network.equals(this.fpBoosterItem.network) && this.fpBoosterItem.adPriority == adMostBannerResponseItem.Priority && !adMostBannerResponseItem.WaterFallLogItem.isTried && getNetworkMinNoFillWeight(adMostBannerResponseItem.Network) > adMostBannerResponseItem.WeightWithoutMultiplier) {
                        this.fpBoosterTriedNetworkList.add(adMostBannerResponseItem.Network);
                        startNetworkRequest(adMostBannerResponseItem);
                        z = true;
                        break;
                    }
                    size--;
                } else {
                    break;
                }
            }
            "getFPBoostedItem : " + z;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public int getNetworkMinNoFillWeight(String str) {
        try {
            if (this.networkMinNoFillWeight.containsKey(str)) {
                return this.networkMinNoFillWeight.get(str).intValue();
            }
            return 999999;
        } catch (Exception e) {
            e.printStackTrace();
            return 999999;
        }
    }

    /* access modifiers changed from: private */
    public int getNetworkRequestCount(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        if (str == null || (concurrentHashMap = this.networkRequestCount) == null || !concurrentHashMap.containsKey(str)) {
            return 0;
        }
        return this.networkRequestCount.get(str).intValue();
    }

    private AdMostBannerResponseItem getNextBannerResponseItem(boolean z) {
        ArrayList<AdMostBannerResponseItem> arrayList;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        if (adMostBannerResponseBase == null) {
            return null;
        }
        ArrayList<AdMostBannerResponseItem> arrayList2 = adMostBannerResponseBase.NetworkList;
        if ((arrayList2 == null || arrayList2.size() == 0) && ((arrayList = this.waterfallResponse.NetworkListInHouse) == null || arrayList.size() == 0)) {
            waterfallCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
            return null;
        }
        int i = this.currentRun;
        long j = 0;
        if (i != 1 && i != 2) {
            int i2 = 0;
            if (i == 3) {
                if (this.lastRoundList.size() > 0) {
                    AdMostBannerResponseItem adMostBannerResponseItem = this.lastRoundList.get(0);
                    this.lastRoundList.remove(0);
                    return adMostBannerResponseItem;
                }
                passNextRun(0);
                return null;
            } else if (i == 4) {
                if (this.waitingResponseCount > 0) {
                    AdMostLog.m299i(className + ": Response postponed 5 seconds for waiting network requests. Waiting Request Count : " + this.waitingResponseCount + " , interstitialId: " + this.interstitialId);
                }
                if (this.waitingResponseCount > 0) {
                    j = 5000;
                }
                passNextRun(j);
                return null;
            } else if (i == 5) {
                if (this.adIndex >= this.waterfallResponse.NetworkListInHouse.size()) {
                    if (this.waterfallResponse.NetworkListInHouse.size() != 0) {
                        if (z) {
                            i2 = 2000;
                        }
                        j = (long) i2;
                    }
                    passNextRun(j);
                    return null;
                }
                AdMostBannerResponseItem adMostBannerResponseItem2 = this.waterfallResponse.NetworkListInHouse.get(this.adIndex);
                this.adIndex++;
                return adMostBannerResponseItem2;
            } else if (i != 6) {
                if (i == 7 && this.interstitialStatus == 1) {
                    waterfallCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
                }
                return null;
            } else if (this.lastRoundList.size() > 0) {
                AdMostBannerResponseItem adMostBannerResponseItem3 = this.lastRoundList.get(0);
                this.lastRoundList.remove(0);
                return adMostBannerResponseItem3;
            } else {
                if (this.waterfallResponse.NetworkListInHouse.size() != 0) {
                    if (z) {
                        i2 = 2000;
                    }
                    j = (long) i2;
                }
                passNextRun(j);
                return null;
            }
        } else if (this.adIndex >= this.waterfallResponse.NetworkList.size()) {
            if (z) {
                j = AdLoader.RETRY_DELAY;
            }
            passNextRun(j);
            return null;
        } else {
            AdMostBannerResponseItem adMostBannerResponseItem4 = this.waterfallResponse.NetworkList.get(this.adIndex);
            this.adIndex++;
            return adMostBannerResponseItem4;
        }
    }

    private int getNumberOfPlacementRequest() {
        return this.numberOfPlacementRequest;
    }

    /* access modifiers changed from: private */
    public boolean getOtherNetworkFPBoostedItem() {
        ArrayList<AdMostBannerResponseItem> arrayList;
        int i;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        boolean z = false;
        if (!(adMostBannerResponseBase == null || (arrayList = adMostBannerResponseBase.NetworkListNotInWaterfall) == null || arrayList.size() <= 0)) {
            int size = this.waterfallResponse.NetworkListNotInWaterfall.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                AdMostBannerResponseItem adMostBannerResponseItem = this.waterfallResponse.NetworkListNotInWaterfall.get(size);
                if (adMostBannerResponseItem.IsExtraBoosterNetwork && (i = adMostBannerResponseItem.WeightWithoutMultiplier) > this.fpBoosterItem.adWeight && ((double) i) > getMaxBidPrice() && !this.fpBoosterTriedNetworkList.contains(adMostBannerResponseItem.Network) && this.fpBoosterItem.adPriority == adMostBannerResponseItem.Priority && !adMostBannerResponseItem.WaterFallLogItem.isTried && getNetworkMinNoFillWeight(adMostBannerResponseItem.Network) > adMostBannerResponseItem.WeightWithoutMultiplier) {
                    this.fpBoosterTriedNetworkList.add(adMostBannerResponseItem.Network);
                    startNetworkRequest(adMostBannerResponseItem);
                    z = true;
                    break;
                }
                size--;
            }
            "getOtherNetworkFPBoostedItem : " + z;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getPositionForLoadedNetwork() {
        /*
            r8 = this;
            admost.sdk.interfaces.AdMostFullScreenInterface r0 = r8.loadedAd     // Catch:{ Exception -> 0x0076 }
            r1 = -1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            admost.sdk.model.AdMostBannerResponseBase r0 = r8.waterfallResponse     // Catch:{ Exception -> 0x0076 }
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r0 = r0.NetworkList     // Catch:{ Exception -> 0x0076 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0076 }
            r2 = 0
            r3 = 0
        L_0x0010:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x0076 }
            r5 = 1
            if (r4 == 0) goto L_0x003c
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x0076 }
            admost.sdk.model.AdMostBannerResponseItem r4 = (admost.sdk.model.AdMostBannerResponseItem) r4     // Catch:{ Exception -> 0x0076 }
            java.lang.String r6 = r4.Network     // Catch:{ Exception -> 0x0076 }
            admost.sdk.interfaces.AdMostFullScreenInterface r7 = r8.loadedAd     // Catch:{ Exception -> 0x0076 }
            admost.sdk.model.AdMostBannerResponseItem r7 = r7.mBannerResponseItem     // Catch:{ Exception -> 0x0076 }
            java.lang.String r7 = r7.Network     // Catch:{ Exception -> 0x0076 }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0076 }
            if (r6 == 0) goto L_0x0010
            int r3 = r3 + 1
            java.lang.String r4 = r4.PlacementId     // Catch:{ Exception -> 0x0076 }
            admost.sdk.interfaces.AdMostFullScreenInterface r6 = r8.loadedAd     // Catch:{ Exception -> 0x0076 }
            admost.sdk.model.AdMostBannerResponseItem r6 = r6.mBannerResponseItem     // Catch:{ Exception -> 0x0076 }
            java.lang.String r6 = r6.PlacementId     // Catch:{ Exception -> 0x0076 }
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x0076 }
            if (r4 == 0) goto L_0x0010
            r2 = 1
        L_0x003c:
            if (r2 != 0) goto L_0x0071
            admost.sdk.model.AdMostBannerResponseBase r0 = r8.waterfallResponse     // Catch:{ Exception -> 0x0076 }
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r0 = r0.NetworkListInHouse     // Catch:{ Exception -> 0x0076 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0076 }
        L_0x0046:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x0076 }
            if (r4 == 0) goto L_0x0071
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x0076 }
            admost.sdk.model.AdMostBannerResponseItem r4 = (admost.sdk.model.AdMostBannerResponseItem) r4     // Catch:{ Exception -> 0x0076 }
            java.lang.String r6 = r4.Network     // Catch:{ Exception -> 0x0076 }
            admost.sdk.interfaces.AdMostFullScreenInterface r7 = r8.loadedAd     // Catch:{ Exception -> 0x0076 }
            admost.sdk.model.AdMostBannerResponseItem r7 = r7.mBannerResponseItem     // Catch:{ Exception -> 0x0076 }
            java.lang.String r7 = r7.Network     // Catch:{ Exception -> 0x0076 }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0076 }
            if (r6 == 0) goto L_0x0046
            int r3 = r3 + 1
            java.lang.String r4 = r4.PlacementId     // Catch:{ Exception -> 0x0076 }
            admost.sdk.interfaces.AdMostFullScreenInterface r6 = r8.loadedAd     // Catch:{ Exception -> 0x0076 }
            admost.sdk.model.AdMostBannerResponseItem r6 = r6.mBannerResponseItem     // Catch:{ Exception -> 0x0076 }
            java.lang.String r6 = r6.PlacementId     // Catch:{ Exception -> 0x0076 }
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x0076 }
            if (r4 == 0) goto L_0x0046
            goto L_0x0072
        L_0x0071:
            r5 = r2
        L_0x0072:
            if (r5 == 0) goto L_0x0075
            r1 = r3
        L_0x0075:
            return r1
        L_0x0076:
            r0 = -2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostInterstitial.getPositionForLoadedNetwork():int");
    }

    private void initialize(Activity activity, String str, String str2, AdMostAdListener adMostAdListener2) {
        try {
            if (AdMost.getInstance().getActivity() == null) {
                AdMost.getInstance().getConfiguration().setActivity(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.subZoneType = str2;
        this.zoneId = str;
        this.adMostAdListener = adMostAdListener2;
        this.interstitialId = String.valueOf(hashCode());
        this.requestNumber = 0;
    }

    private boolean isType2() {
        return this.waterfallResponse instanceof AdMostBannerResponseType2;
    }

    /* access modifiers changed from: private */
    public void loaded(AdMostFullScreenInterface adMostFullScreenInterface, final String str, final long j) {
        if (isWaterfallCompleted()) {
            AdMostLog.m299i(className + " status is not appropriate to load ad. Current status is : " + AdMostUtil.getAdStatusName(this.interstitialStatus));
            if (!AdMostInterstitialCacheManager.getInstance().addToCache(str, j, adMostFullScreenInterface)) {
                AdMostInterstitialManager.getInstance().removeFromSingletonArray(adMostFullScreenInterface);
                adMostFullScreenInterface.destroy();
                return;
            }
            return;
        }
        this.tempEventListener = str;
        this.tempCacheExpiresAt = j;
        waterfallCycleCompleted(adMostFullScreenInterface, new AdMostBiddingCompeteListener() {
            public void onBiddingWins(AdMostAdInterface adMostAdInterface, AdMostAdInterface adMostAdInterface2) {
                AdMostLog.m299i("Bidding onBiddingWins *** " + adMostAdInterface.getBannerResponseItem().Network);
                AdMostFullScreenInterface adMostFullScreenInterface = (AdMostFullScreenInterface) adMostAdInterface2;
                if (!AdMostInterstitialCacheManager.getInstance().addToCache(str, j, adMostFullScreenInterface)) {
                    AdMostInterstitialManager.getInstance().removeFromSingletonArray(adMostFullScreenInterface);
                    adMostAdInterface2.destroy();
                }
            }

            public void onWaterfallWins(AdMostAdInterface adMostAdInterface) {
                AdMostLog.m299i("Bidding onWaterfallWins *** " + adMostAdInterface.getBannerResponseItem().Network);
                AdMostInterstitial.this.setWinningAdReturnResponse((AdMostFullScreenInterface) adMostAdInterface, str, j);
            }
        });
    }

    /* access modifiers changed from: private */
    public void logStatisticsData(String str, String str2, int i) {
        try {
            if (this.adNumber > 0 && this.adNumber <= 3) {
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[20];
                objArr[0] = AdMostAnalyticsManager.getInstance().getUserId();
                objArr[1] = AdMost.getInstance().getAppId();
                objArr[2] = this.zoneId;
                objArr[3] = Integer.valueOf(isType2() ? 1 : 0);
                objArr[4] = Build.BRAND;
                objArr[5] = Build.MODEL;
                objArr[6] = Integer.valueOf(Build.VERSION.SDK_INT);
                objArr[7] = AdMost.getInstance().getCountry();
                objArr[8] = Long.valueOf(Build.TIME);
                objArr[9] = Build.CPU_ABI;
                objArr[10] = AdMostUtil.getNetworkClass(AdMost.getInstance().getContext());
                objArr[11] = Integer.valueOf(i);
                objArr[12] = Long.valueOf(System.currentTimeMillis());
                objArr[13] = Integer.valueOf(getNumberOfPlacementRequest());
                objArr[14] = Long.valueOf(this.refreshAdEndedAt - this.refreshAdStartedAt);
                objArr[15] = str;
                objArr[16] = Integer.valueOf(getPositionForLoadedNetwork());
                objArr[17] = str2;
                objArr[18] = Integer.valueOf(this.adNumber);
                objArr[19] = Locale.getDefault().getDisplayLanguage();
                new AdMostGenericRequest(AdMostGenericRequest.RequestType.TEST_USER_DATA, "", new AdmostResponseListener<JSONObject>() {
                    public void onError(String str, Exception exc) {
                    }

                    public void onResponse(JSONObject jSONObject) {
                    }
                }).mo611go(String.format(locale, "{\"User\":\"%s\",\"AppId\":\"%s\",\"ZoneId\":\"%s\",\"IsInTestGroup\":%d,\"Brand\":\"%s\",\"Model\":\"%s\",\"OsV\":%d,\"Country\":\"%s\",\"BuildTime\":%d,\"Cpu\":\"%s\",\"Connection\":\"%s\",\"Ecpm\":%d,\"Date\":\"%s\",\"ReqCount\":%d,\"Duration\":%d,\"Network\":\"%s\",\"NetReqNumber\":%d,\"LogType\":\"%s\",\"AdNumber\":%d,\"Language\":\"%s\"}", objArr));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onAction(final int i, final int i2) {
        if (i == 163) {
            this.refreshAdEndedAt = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(className);
            sb.append(" : (** INTERSTITIAL LOADED **) for ZoneId: ");
            sb.append(this.zoneId);
            sb.append(" responseItem : ");
            AdMostBannerResponseItem adMostBannerResponseItem = this.loadedBannerResponseItem;
            sb.append(adMostBannerResponseItem != null ? adMostBannerResponseItem.toString() : "bannerResponseItem null");
            AdMostLog.m299i(sb.toString());
        } else if (i == 161) {
            this.refreshAdEndedAt = System.currentTimeMillis();
            if (!(i2 == 301 || i2 == 302 || i2 == 303 || i2 == 305)) {
                this.interstitialStatus = 0;
            }
            AdMostLog.m299i(className + " : (** INTERSTITIAL FAILED **) for ZoneId: " + this.zoneId + " , interstitialStatus: " + AdMostUtil.getAdStatusName(this.interstitialStatus) + " , errorCode: " + AdMostUtil.getAdErrorName(i2));
        }
        clearZoneTimer();
        if (this.adMostAdListener != null) {
            C01289 r2 = new Runnable() {
                public void run() {
                    if (AdMostInterstitial.this.adMostAdListener != null) {
                        int i = i;
                        String str = "";
                        if (i == 163) {
                            if (AdMostInterstitial.this.loadedBannerResponseItem != null) {
                                String str2 = AdMostInterstitial.this.loadedBannerResponseItem.Network;
                                AdMostInterstitial adMostInterstitial = AdMostInterstitial.this;
                                adMostInterstitial.logStatisticsData(adMostInterstitial.loadedBannerResponseItem.Network, AdMostFloorPriceManager.FP_ZONE_NETWORK_STATUS_FILL, AdMostInterstitial.this.loadedBannerResponseItem.PureWeight);
                                AdMostAdStatsManager instance = AdMostAdStatsManager.getInstance();
                                String access$1000 = AdMostInterstitial.this.zoneId;
                                String access$2300 = AdMostInterstitial.this.interstitialRequestGUID;
                                AdMostBannerResponseItem access$2400 = AdMostInterstitial.this.loadedBannerResponseItem;
                                AdMostInterstitial adMostInterstitial2 = AdMostInterstitial.this;
                                AdMostBannerResponseBase adMostBannerResponseBase = adMostInterstitial2.waterfallResponse;
                                instance.setZoneRequestData(access$1000, access$2300, access$2400, adMostBannerResponseBase.IsFirstRequestForZone, adMostBannerResponseBase.IsFirstSessionRequestForZone, adMostInterstitial2.numberOfPlacementRequest, AdMostInterstitial.this.getNetworkRequestCount(str2), AdMostInterstitial.this.refreshAdEndedAt - AdMostInterstitial.this.refreshAdStartedAt, AdMostInterstitial.this.getWaterfallCycleCompletedAt() - AdMostInterstitial.this.refreshAdStartedAt, AdMostInterstitial.this.getBiddingCycleCompletedAt() - AdMostInterstitial.this.refreshAdStartedAt);
                                AdMostInterstitial.this.adMostAdListener.onReady(AdMostInterstitial.this.loadedBannerResponseItem.Network, AdMostInterstitial.this.loadedBannerResponseItem.PureWeight);
                                return;
                            }
                            AdMostInterstitial.this.adMostAdListener.onReady(str, 0);
                        } else if (i == 161) {
                            if (i2 == 400) {
                                AdMostInterstitial.this.logStatisticsData(str, "no-fill", 0);
                                AdMostAdStatsManager instance2 = AdMostAdStatsManager.getInstance();
                                String access$10002 = AdMostInterstitial.this.zoneId;
                                String access$23002 = AdMostInterstitial.this.interstitialRequestGUID;
                                AdMostInterstitial adMostInterstitial3 = AdMostInterstitial.this;
                                AdMostBannerResponseBase adMostBannerResponseBase2 = adMostInterstitial3.waterfallResponse;
                                instance2.setZoneRequestData(access$10002, access$23002, (AdMostBannerResponseItem) null, adMostBannerResponseBase2.IsFirstRequestForZone, adMostBannerResponseBase2.IsFirstSessionRequestForZone, adMostInterstitial3.numberOfPlacementRequest, 0, AdMostInterstitial.this.refreshAdEndedAt - AdMostInterstitial.this.refreshAdStartedAt, AdMostInterstitial.this.getWaterfallCycleCompletedAt() - AdMostInterstitial.this.refreshAdStartedAt, AdMostInterstitial.this.getBiddingCycleCompletedAt() - AdMostInterstitial.this.refreshAdStartedAt);
                            }
                            AdMostInterstitial.this.adMostAdListener.onFail(i2);
                        } else if (i == 164) {
                            AdMostAdListener access$200 = AdMostInterstitial.this.adMostAdListener;
                            access$200.onDismiss(str + i2);
                        } else if (i == 162) {
                            AdMostAdListener access$2002 = AdMostInterstitial.this.adMostAdListener;
                            if (AdMostInterstitial.this.loadedBannerResponseItem != null) {
                                str = AdMostInterstitial.this.loadedBannerResponseItem.Network;
                            }
                            access$2002.onComplete(str);
                        }
                    }
                }
            };
            if (i == 161) {
                if (i2 == 400 || i2 == 401) {
                    AdMostImpressionManager.getInstance().setZoneImpressionData(5, this.zoneId, 0, this.subZoneType);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (this.noFillIntervalStartTime == 0) {
                    this.noFillIntervalStartTime = currentTimeMillis;
                    this.noFillConsequentInterval = 2000;
                    this.noFillIntervalFinishTime = currentTimeMillis + ((long) 2000);
                    getHandler().post(r2);
                    return;
                }
                long j = this.noFillIntervalFinishTime;
                if (currentTimeMillis <= j) {
                    getHandler().postDelayed(r2, 1000);
                    return;
                }
                this.noFillIntervalStartTime = j;
                int i3 = this.noFillConsequentInterval;
                if (i3 < ZONE_MAX_NO_FILL_INTERVAL) {
                    int i4 = i3 * 2;
                    this.noFillConsequentInterval = i4;
                    this.noFillIntervalFinishTime = j + ((long) i4);
                } else {
                    this.noFillIntervalFinishTime = j + 16000;
                }
            } else {
                this.noFillConsequentInterval = 2000;
                this.noFillIntervalFinishTime = AdLoader.RETRY_DELAY;
                this.noFillIntervalStartTime = 0;
            }
            getHandler().post(r2);
        }
    }

    private void passNextRun(long j) {
        this.adIndex = 0;
        int i = this.currentRun;
        int i2 = 5;
        if (i == 1) {
            i2 = 2;
        } else if (i == 2) {
            i2 = 3;
        } else if (i == 3) {
            i2 = 4;
        } else if (i != 4) {
            i2 = i == 5 ? 6 : 7;
        }
        this.currentRun = i2;
        if (j > 0) {
            this.scheduledShowNextAdWaiting = true;
            getHandler().postDelayed(new Runnable() {
                public void run() {
                    AdMostLog.m301v(AdMostInterstitial.className + " : New Run for Interstitial : " + AdMostInterstitial.this.interstitialId + " , currentRun " + AdMostInterstitial.this.currentRun);
                    boolean unused = AdMostInterstitial.this.scheduledShowNextAdWaiting = false;
                    AdMostInterstitial.this.tryNextItemInWaterfall(true);
                }
            }, j);
            return;
        }
        AdMostLog.m301v(className + " : New Run for Interstitial : " + this.interstitialId + " , currentRun " + this.currentRun);
        tryNextItemInWaterfall(true);
    }

    /* access modifiers changed from: private */
    public void postCumulativeResults(long j) {
        if (!this.postedCumulativeResults && this.loadResults.size() > 0) {
            this.postedCumulativeResults = true;
            if (this.waitingResponseCount > 0) {
                getHandler().postDelayed(new Runnable() {
                    public void run() {
                        boolean unused = AdMostInterstitial.this.postedCumulativeResults = false;
                        AdMostInterstitial.this.sendCumulativeResults();
                    }
                }, j);
                return;
            }
            this.postedCumulativeResults = false;
            sendCumulativeResults();
        }
    }

    /* access modifiers changed from: private */
    public void refreshAdInner(final boolean z, final boolean z2) {
        int i = this.interstitialStatus;
        if (i != 1 && i != 2 && i != 3) {
            destroy(false);
            if (!AdMost.getInstance().isInitCompleted()) {
                AdMostLog.m299i(AdMostView.class.getSimpleName() + " : Admost Init not completed. AdMostInterstitial is waiting init. interstitialId: " + this.interstitialId);
                this.interstitialStatus = 1;
                this.waitingInitializationToComplete = true;
                this.observer = new Observer() {
                    public void update(Observable observable, Object obj) {
                        if (((Integer) ((Object[]) obj)[0]).intValue() == 1 && AdMostInterstitial.this.waitingInitializationToComplete) {
                            boolean unused = AdMostInterstitial.this.waitingInitializationToComplete = false;
                            AdMostInterstitial.this.getHandler().postDelayed(new Runnable() {
                                public void run() {
                                    if (AdMostInterstitial.this.interstitialStatus == 4) {
                                        AdMostInitObservable.getInstance().deleteObserver(AdMostInterstitial.this.observer);
                                        Observer unused = AdMostInterstitial.this.observer = null;
                                        return;
                                    }
                                    int unused2 = AdMostInterstitial.this.interstitialStatus = 0;
                                    C01192 r0 = C01192.this;
                                    AdMostInterstitial.this.refreshAdInner(z, z2);
                                    AdMostInitObservable.getInstance().deleteObserver(AdMostInterstitial.this.observer);
                                    Observer unused3 = AdMostInterstitial.this.observer = null;
                                }
                            }, AdMost.getInstance().timeWaitForAdNetworksInitiation());
                        }
                    }
                };
                AdMostInitObservable.getInstance().addObserver(this.observer);
                getHandler().postDelayed(new Runnable() {
                    public void run() {
                        if (AdMostInterstitial.this.waitingInitializationToComplete) {
                            boolean unused = AdMostInterstitial.this.waitingInitializationToComplete = false;
                            if (AdMostInterstitial.this.interstitialStatus == 4) {
                                AdMostInitObservable.getInstance().deleteObserver(AdMostInterstitial.this.observer);
                                Observer unused2 = AdMostInterstitial.this.observer = null;
                                return;
                            }
                            AdMostInterstitial.this.onAction(AdMostAdListener.FAILED, 500);
                            AdMostInitObservable.getInstance().deleteObserver(AdMostInterstitial.this.observer);
                            Observer unused3 = AdMostInterstitial.this.observer = null;
                        }
                    }
                }, TapjoyConstants.TIMER_INCREMENT);
                return;
            }
            if (!z2) {
                this.showTryCount = 0;
                this.triedButNotShown = "";
                this.refreshAdStartedAt = System.currentTimeMillis();
                this.refreshAdEndedAt = 0;
            }
            AdMostManager.getInstance().start();
            this.interstitialStatus = 1;
            this.autoShow = z;
            this.currentRun = 1;
            this.requestNumber++;
            this.networkRequestStarted = false;
            this.numberOfPlacementRequest = 0;
            this.networkRequestCount = new ConcurrentHashMap<>();
            this.waitingResponseCount = 0;
            this.networkMinNoFillWeight = new ConcurrentHashMap<>();
            this.fpBoosterItem.initialize();
            this.fpBoosterTriedNetworkList = new ArrayList<>();
            this.tempEventListener = "";
            this.tempCacheExpiresAt = 0;
            this.interstitialRequestGUID = UUID.randomUUID().toString();
            super.init();
            try {
                if (AdMostUtil.isNetworkAvailable(AdMost.getInstance().getContext()) == 1) {
                    AdMostLog.m299i(className + " : zoneId: " + this.zoneId + " Refresh request Started. interstitialId: " + this.interstitialId);
                    new AdMostGenericRequest(AdMostGenericRequest.RequestType.ZONE_RESPONSE, this.zoneId, new AdmostResponseListener<AdMostBannerResponseBase>() {
                        public void onError(String str, Exception exc) {
                            AdMostInterstitial.this.biddingCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
                            AdMostInterstitial.this.tryNextItemInWaterfall(true);
                        }

                        public void onResponse(AdMostBannerResponseBase adMostBannerResponseBase) {
                            if (adMostBannerResponseBase != null) {
                                if (adMostBannerResponseBase.Result == -1 || adMostBannerResponseBase.isEmpty()) {
                                    boolean unused = AdMostInterstitial.this.fillSent = false;
                                    AdMostInterstitial.this.onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_WATERFALL_EMPTY);
                                    return;
                                }
                                String str = adMostBannerResponseBase.ApplicationId;
                                if (str == null || str.equals("") || adMostBannerResponseBase.ApplicationId.equals(AdMost.getInstance().getAppId())) {
                                    AdMostZoneFrequencyCapItem checkZoneFrequencyCapping = AdMostUtil.checkZoneFrequencyCapping(adMostBannerResponseBase, true);
                                    if (checkZoneFrequencyCapping.isCapAvailable) {
                                        if (!AdMostInterstitial.this.capStatusWaiting && !AdMost.getInstance().getConfiguration().disableAdStatusChanged()) {
                                            boolean unused2 = AdMostInterstitial.this.capStatusWaiting = true;
                                            AdMostInterstitial.this.getHandler().postDelayed(AdMostInterstitial.this.capStatusRunnable, checkZoneFrequencyCapping.timeLeftForCap);
                                        }
                                        AdMostInterstitial.this.onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_FREQ_CAP);
                                        return;
                                    }
                                    adMostBannerResponseBase.IsFirstSessionRequestForZone = AdMostImpressionManager.getInstance().isZoneFirstRequestForSession(AdMostInterstitial.this.zoneId);
                                    AdMostImpressionManager.getInstance().setZoneRequested(AdMostInterstitial.this.zoneId);
                                    boolean unused3 = AdMostInterstitial.this.fillSent = false;
                                    AdMostInterstitial adMostInterstitial = AdMostInterstitial.this;
                                    int i = adMostBannerResponseBase.ZoneRequestTimeout;
                                    long unused4 = adMostInterstitial.requestTimeout = i <= 0 ? 5000 : (long) i;
                                    long unused5 = AdMostInterstitial.this.zoneResponseTimeoutAt = System.currentTimeMillis() + ((long) adMostBannerResponseBase.ZoneResponseTimeout);
                                    String unused6 = AdMostInterstitial.this.subZoneType = adMostBannerResponseBase.SubZoneType;
                                    int unused7 = AdMostInterstitial.this.adIndex = 0;
                                    int unused8 = AdMostInterstitial.this.currentRun = 1;
                                    AdMostInterstitial adMostInterstitial2 = AdMostInterstitial.this;
                                    adMostInterstitial2.waterfallResponse = adMostBannerResponseBase;
                                    if (adMostInterstitial2.zoneOverallTimeout == 0) {
                                        AdMostInterstitial adMostInterstitial3 = AdMostInterstitial.this;
                                        int unused9 = adMostInterstitial3.zoneOverallTimeout = adMostInterstitial3.waterfallResponse.ZoneOverallTimeout;
                                    }
                                    if (AdMostInterstitial.this.zoneOverallTimeout > 0) {
                                        Timer unused10 = AdMostInterstitial.this.zoneRequestTimer = new Timer();
                                        AdMostInterstitial.this.zoneRequestTimer.schedule(new TimerTask() {
                                            public void run() {
                                                AdMostInterstitial adMostInterstitial = AdMostInterstitial.this;
                                                if (adMostInterstitial != null && adMostInterstitial.interstitialStatus == 1 && AdMostInterstitial.this.getHandler() != null) {
                                                    AdMostInterstitial.this.onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_ZONE_TIMEOUT);
                                                }
                                            }
                                        }, (long) AdMostInterstitial.this.zoneOverallTimeout);
                                    }
                                    AdMostImpressionManager.getInstance().setZoneImpressionData(1, AdMostInterstitial.this.zoneId, 0, AdMostInterstitial.this.subZoneType);
                                    AdMostInterstitial adMostInterstitial4 = AdMostInterstitial.this;
                                    adMostInterstitial4.startStaticsData(adMostInterstitial4.waterfallResponse);
                                    AdMostInterstitial.this.tryNextItemInWaterfall(true);
                                    AdMostInterstitial adMostInterstitial5 = AdMostInterstitial.this;
                                    adMostInterstitial5.startBiddingCycle(adMostInterstitial5.interstitialId);
                                    return;
                                }
                                AdMostInterstitial.this.onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID);
                                AdMostLog.m296e("Application ID and Zone ID is not compatible, please CHECK your definitions..!");
                            }
                        }
                    }).mo611go(new String[0]);
                    return;
                }
                this.waterfallResponse = null;
                this.adIndex = 0;
                this.currentRun = 1;
                AdMostLog.m303w(className + " : Ad could not be called, please check network state.");
                onAction(AdMostAdListener.FAILED, 500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void sendCumulativeResults() {
        if (this.loadResults.size() > 0) {
            Collections.sort(this.loadResults, new CustomComparatorOnLoadResponse());
            for (int i = 0; i < this.loadResults.size(); i++) {
                AdMostEventListenerOnLoadResponse adMostEventListenerOnLoadResponse = this.loadResults.get(i);
                loaded(adMostEventListenerOnLoadResponse.fsInterface, adMostEventListenerOnLoadResponse.eventListener, adMostEventListenerOnLoadResponse.cacheExpiresAt);
            }
            this.loadResults = new Vector<>();
        }
    }

    /* access modifiers changed from: private */
    public void setWinningAdReturnResponse(AdMostFullScreenInterface adMostFullScreenInterface, String str, long j) {
        this.interstitialStatus = 2;
        this.loadedBannerResponseItem = adMostFullScreenInterface.mBannerResponseItem;
        if (j <= 0) {
            j = AdMostInterstitialCacheManager.getInstance().getExpiresAt(this.loadedBannerResponseItem);
        }
        this.loadedAdCacheExpiresAt = j;
        this.loadedEventListener = str;
        this.loadedAd = adMostFullScreenInterface;
        if (!this.loadedCallbackSet) {
            this.loadedCallbackSet = true;
            onAction(AdMostAdListener.LOADED, 0);
        }
        if (!this.fillSent && this.loadedBannerResponseItem != null) {
            this.fillSent = true;
            AdMostImpressionManager.getInstance().setZoneImpressionData(3, this.zoneId, this.loadedBannerResponseItem.PureWeight, this.subZoneType);
        }
        if (this.autoShow) {
            show();
        }
    }

    private void showInternal(final String str) {
        this.shownTag = str;
        AdMostBannerResponseItem adMostBannerResponseItem = this.loadedBannerResponseItem;
        if (adMostBannerResponseItem == null || adMostBannerResponseItem.Network.equals(AdMostAdNetwork.NO_NETWORK) || this.interstitialStatus != 2) {
            AdMostLog.m303w(className + " : Status is not suitable to show ad. interstitialStatus : " + AdMostUtil.getAdStatusName(this.interstitialStatus));
        } else if (AdMostUtil.isNetworkAvailable(AdMost.getInstance().getActivity()) != 1) {
            failedToShow((AdMostBannerResponseItem) null);
        } else {
            AdMostZoneFrequencyCapItem checkZoneFrequencyCapping = AdMostUtil.checkZoneFrequencyCapping(this.waterfallResponse, false);
            if (this.waterfallResponse != null && checkZoneFrequencyCapping.isCapAvailable) {
                onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN);
            } else if (this.waterfallResponse != null && !AdMostUtil.checkTagFrequencyCapping(str)) {
                onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN);
            } else if (AdMost.getInstance().isTagPassive(str) || AdMostPolicyManager.getInstance().hasTagPolicyForNoAd(str)) {
                onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_TAG_PASSIVE);
            } else {
                AdMostUtil.keepFrequencyCapping(this.loadedBannerResponseItem.ZoneId + "*" + this.loadedBannerResponseItem.PlacementId);
                getHandler().post(new Runnable() {
                    public void run() {
                        try {
                            AdMostInterstitial.access$2108(AdMostInterstitial.this);
                            AdMostInterstitial.this.loadedAd.show();
                            if (AdMostInterstitial.this.loadedAd.isShowSuccessful) {
                                AdMostAdStatsManager.getInstance().setZoneShowData(AdMostInterstitial.this.zoneId, AdMostInterstitial.this.interstitialRequestGUID, str);
                                AdMostInterstitial.this.shown(AdMostInterstitial.this.loadedBannerResponseItem, str);
                            }
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(AdMostInterstitial.className);
                            sb.append(": Show Error: ");
                            sb.append(AdMostInterstitial.this.loadedBannerResponseItem != null ? AdMostInterstitial.this.loadedBannerResponseItem.toString() : "bannerResponseItem null");
                            AdMostLog.m298e(sb.toString(), e, true);
                            AdMostInterstitial adMostInterstitial = AdMostInterstitial.this;
                            adMostInterstitial.failedToShow(adMostInterstitial.loadedBannerResponseItem);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void shown(final AdMostBannerResponseItem adMostBannerResponseItem, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(className);
        sb.append(" onShown :  ");
        sb.append(adMostBannerResponseItem != null ? adMostBannerResponseItem.toString() : "bannerResponseItem null");
        sb.append(" , interstitialId: ");
        sb.append(this.interstitialId);
        sb.append(" tag : ");
        sb.append(str);
        AdMostLog.m299i(sb.toString());
        this.interstitialStatus = 3;
        this.ssvUniqueId = AdMostSSVManager.getInstance().rewardedShown(this.waterfallResponse, this.loadedBannerResponseItem, this.ssvCustomData, this.ssvServer);
        if (!(adMostBannerResponseItem == null || (str2 = adMostBannerResponseItem.Type) == null || !str2.equals(AdMostAdType.OFFERWALL))) {
            AdMostPreferences.getInstance().setOfferWallNetwork(adMostBannerResponseItem.Network);
        }
        AdMostImpressionManager.getInstance().setPlacementImpressionData(2, adMostBannerResponseItem);
        if (adMostBannerResponseItem.IsBiddingItem) {
            AdMostImpressionManager.getInstance().setPlacementBidData(2, adMostBannerResponseItem);
        }
        AdMostImpressionManager.getInstance().setZoneImpressionData(2, adMostBannerResponseItem.ZoneId, 0, this.subZoneType);
        if (str != null && str.length() > 0) {
            AdMostImpressionManager.getInstance().setPlacementTagData(2, str, adMostBannerResponseItem);
        }
        AdMostUtil.keepFrequencyCapping("ZONE*" + adMostBannerResponseItem.ZoneId);
        AdMostUtil.keepFrequencyCapping("TAG*" + str);
        if (!this.shownCallbackSet) {
            this.shownCallbackSet = true;
            getHandler().post(new Runnable() {
                public void run() {
                    if (AdMostInterstitial.this.adMostAdListener != null) {
                        AdMostInterstitial.this.adMostAdListener.onShown(adMostBannerResponseItem.Network);
                    }
                }
            });
        }
        logStatisticsData(adMostBannerResponseItem.Network, "impression", adMostBannerResponseItem.PureWeight);
    }

    private boolean startNetworkRequest(AdMostBannerResponseItem adMostBannerResponseItem) {
        adMostBannerResponseItem.NetworkData = getCustomData();
        AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem.WaterFallLogItem;
        adMostWaterfallLog.isTried = true;
        int i = adMostWaterfallLog.requestCount + 1;
        adMostWaterfallLog.requestCount = i;
        if (i == 1) {
            adMostWaterfallLog.triedAt = System.currentTimeMillis();
        } else {
            adMostWaterfallLog.triedAt2 = System.currentTimeMillis();
        }
        adMostBannerResponseItem.IsFirstSessionRequestForNetwork = AdMostImpressionManager.getInstance().isNetworksFirstRequestForSession(adMostBannerResponseItem.Network);
        this.waitingResponseCount++;
        AdMostInterstitialManager instance = AdMostInterstitialManager.getInstance();
        WeakReference weakReference = new WeakReference(AdMost.getInstance().getActivity());
        long j = this.requestTimeout;
        String str = this.interstitialId + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + this.requestNumber;
        String str2 = this.interstitialId;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        final AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerResponseItem;
        C01267 r4 = new AdMostInterstitialEventListener(this, adMostBannerResponseItem, j, str, str2, (adMostBannerResponseBase == null || !this.networkRequestStarted) ? 0 : adMostBannerResponseBase.RequestInterval) {
            final /* synthetic */ AdMostInterstitial this$0;

            {
                this.this$0 = r10;
            }

            public void onClick(AdMostBannerResponseItem adMostBannerResponseItem) {
                this.this$0.clicked(adMostBannerResponseItem);
            }

            public void onComplete(AdMostBannerResponseItem adMostBannerResponseItem) {
                this.this$0.completed();
            }

            public void onDismiss(AdMostBannerResponseItem adMostBannerResponseItem) {
                this.this$0.closed(adMostBannerResponseItem2);
            }

            public void onFail(AdMostBannerResponseItem adMostBannerResponseItem, int i) {
                if (this.waitingResponse && i != 8) {
                    if (adMostBannerResponseItem != null) {
                        AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem.WaterFallLogItem;
                        adMostWaterfallLog.responseCount++;
                        adMostWaterfallLog.failedAt = System.currentTimeMillis();
                    }
                    AdMostInterstitial.access$2910(this.this$0);
                }
                if (adMostBannerResponseItem != null) {
                    adMostBannerResponseItem.WaterFallLogItem.isFilled = false;
                    AdMostLog.m299i(AdMostInterstitial.className + " onFail method :  " + adMostBannerResponseItem.toString() + " , interstitialId: " + this.this$0.interstitialId + " , interstitialStatus: " + AdMostUtil.getAdStatusName(this.this$0.interstitialStatus) + " , reason: " + AdMostUtil.getEventListenerStatusName(i));
                    if (!this.failedOnce) {
                        if (i == 6) {
                            ConcurrentHashMap access$4200 = this.this$0.networkMinNoFillWeight;
                            String str = adMostBannerResponseItem.Network;
                            access$4200.put(str, Integer.valueOf(adMostBannerResponseItem.WeightWithoutMultiplier <= this.this$0.getNetworkMinNoFillWeight(str) ? adMostBannerResponseItem.WeightWithoutMultiplier : this.this$0.getNetworkMinNoFillWeight(adMostBannerResponseItem.Network)));
                            AdMostAdStatsManager.getInstance().setPlacementRequestData(adMostBannerResponseItem, "NoFill", adMostBannerResponseItem.IsFirstRequestForNetwork, adMostBannerResponseItem.IsFirstSessionRequestForNetwork, this.this$0.zoneId);
                        }
                        super.onFail(adMostBannerResponseItem, i);
                        if ((this.this$0.interstitialStatus == 2 || this.this$0.interstitialStatus == 3 || this.this$0.interstitialStatus == 4) && this.this$0.loadedBannerResponseItem != null && this.this$0.loadedBannerResponseItem.PlacementId.equals(adMostBannerResponseItem.PlacementId)) {
                            this.this$0.closed(adMostBannerResponseItem);
                            return;
                        }
                        if (i == 3 && (this.this$0.currentRun == 2 || this.this$0.currentRun == 5)) {
                            AdMostLog.m299i(AdMostInterstitial.className + ": New item added for 3rd round. :" + adMostBannerResponseItem.toString());
                            synchronized (this.this$0.lastRoundList) {
                                this.this$0.lastRoundList.add(adMostBannerResponseItem);
                            }
                        }
                        this.this$0.tryNextItemInWaterfall(true);
                    }
                }
            }

            public void onFailToShow() {
                AdMostLog.m299i("onAmrFailToShow : " + this.responseItem.Network + " INT : " + this.this$0.interstitialId + " interstitialStatus : " + AdMostUtil.getAdStatusName(this.this$0.interstitialStatus) + " showTryCount : " + this.this$0.showTryCount);
                if ((this.this$0.interstitialStatus == 2 || this.this$0.interstitialStatus == 3 || this.this$0.interstitialStatus == 4) && this.this$0.loadedBannerResponseItem != null && this.this$0.loadedBannerResponseItem.PlacementId.equals(this.responseItem.PlacementId)) {
                    AdMostImpressionManager.getInstance().setPlacementImpressionData(7, this.this$0.loadedBannerResponseItem);
                    if (AdMost.getInstance().getConfiguration().returnOnFailToShowResponseOnFirstFail()) {
                        this.this$0.failedToShow(this.responseItem);
                    } else if (this.this$0.showTryCount == 1) {
                        int unused = this.this$0.interstitialStatus = 0;
                        AdMostInterstitial adMostInterstitial = this.this$0;
                        String unused2 = adMostInterstitial.triedButNotShown = adMostInterstitial.loadedBannerResponseItem.PlacementId;
                        this.this$0.refreshAdInner(true, true);
                    } else {
                        String unused3 = this.this$0.triedButNotShown = "";
                        this.this$0.failedToShow(this.responseItem);
                    }
                }
            }

            public void onLoad(AdMostFullScreenInterface adMostFullScreenInterface, long j) {
                AdMostBannerResponseItem adMostBannerResponseItem;
                if (adMostFullScreenInterface != null && (adMostBannerResponseItem = adMostFullScreenInterface.mBannerResponseItem) != null) {
                    if (this.waitingResponse) {
                        adMostBannerResponseItem.WaterFallLogItem.responseCount++;
                        AdMostInterstitial.access$2910(this.this$0);
                    }
                    AdMostWaterfallLog adMostWaterfallLog = adMostFullScreenInterface.mBannerResponseItem.WaterFallLogItem;
                    adMostWaterfallLog.isFilled = true;
                    adMostWaterfallLog.filledAt = System.currentTimeMillis();
                    AdMostAdStatsManager instance = AdMostAdStatsManager.getInstance();
                    AdMostBannerResponseItem adMostBannerResponseItem2 = adMostFullScreenInterface.mBannerResponseItem;
                    instance.setPlacementRequestData(adMostBannerResponseItem2, "Fill", adMostBannerResponseItem2.IsFirstRequestForNetwork, adMostBannerResponseItem2.IsFirstSessionRequestForNetwork, this.this$0.zoneId);
                    super.onLoad(adMostFullScreenInterface, j);
                    AdMostLog.m299i(AdMostInterstitial.className + " onLoad method : Loaded : " + adMostFullScreenInterface.mBannerResponseItem.toString() + " , interstitialId: " + this.this$0.interstitialId);
                    long access$1200 = this.this$0.zoneResponseTimeoutAt - System.currentTimeMillis();
                    if (access$1200 > 0) {
                        this.this$0.loadResults.add(new AdMostEventListenerOnLoadResponse(adMostFullScreenInterface, j, String.valueOf(hashCode())));
                        this.this$0.fpBoosterItem.setMaxValues(adMostFullScreenInterface.mBannerResponseItem);
                        if (!this.this$0.getFPBoostedItem()) {
                            "FPBooster - waitingResponseCount : " + this.this$0.waitingResponseCount;
                            if (this.this$0.waitingResponseCount > 0) {
                                this.this$0.postCumulativeResults(access$1200);
                            } else if (!this.this$0.getOtherNetworkFPBoostedItem()) {
                                this.this$0.sendCumulativeResults();
                            }
                        } else {
                            this.this$0.postCumulativeResults(access$1200);
                        }
                    } else {
                        this.this$0.loaded(adMostFullScreenInterface, String.valueOf(hashCode()), j);
                    }
                }
            }
        };
        AdMostBannerResponseBase adMostBannerResponseBase2 = this.waterfallResponse;
        boolean z = false;
        boolean interstitial = instance.getInterstitial(adMostBannerResponseItem, weakReference, r4, adMostBannerResponseBase2 != null ? adMostBannerResponseBase2.IsFirstRequestForZone : false);
        if (interstitial) {
            this.numberOfPlacementRequest++;
            this.networkRequestCount.put(adMostBannerResponseItem.Network, Integer.valueOf((!this.networkRequestCount.contains(adMostBannerResponseItem.Network) ? 0 : this.networkRequestCount.get(adMostBannerResponseItem.Network).intValue()) + 1));
            AdMostImpressionManager.getInstance().setNetworkRequested(adMostBannerResponseItem.Network);
        }
        if (this.networkRequestStarted || interstitial) {
            z = true;
        }
        this.networkRequestStarted = z;
        return true;
    }

    /* access modifiers changed from: private */
    public void startStaticsData(AdMostBannerResponseBase adMostBannerResponseBase) {
        if (adMostBannerResponseBase.DebugUserDataPercentage <= 0 || AdMostPreferences.getInstance() == null || AdMostPreferences.getInstance().getPercentile() >= adMostBannerResponseBase.DebugUserDataPercentage) {
            this.adNumber = -1;
        } else if (adMostBannerResponseBase.IsFirstRequestForZone) {
            this.adNumber = 1;
            AdMostPreferences.getInstance().keepZoneImpressionCount(this.zoneId, this.adNumber);
        } else {
            int zoneImpressionCount = AdMostPreferences.getInstance().getZoneImpressionCount(this.zoneId);
            this.adNumber = zoneImpressionCount;
            if (zoneImpressionCount > 0) {
                this.adNumber = zoneImpressionCount + 1;
                AdMostPreferences.getInstance().keepZoneImpressionCount(this.zoneId, this.adNumber);
            }
        }
    }

    /* access modifiers changed from: private */
    public void tryNextItemInWaterfall(boolean z) {
        try {
            if (this.interstitialStatus == 1 && !this.scheduledShowNextAdWaiting) {
                if (this.loadResults.size() <= 0) {
                    AdMostBannerResponseItem nextBannerResponseItem = getNextBannerResponseItem(z);
                    if (nextBannerResponseItem != null) {
                        boolean z2 = false;
                        if (getMaxBidPrice() > ((double) nextBannerResponseItem.WeightWithoutMultiplier)) {
                            tryNextItemInWaterfall(false);
                            return;
                        }
                        if (!nextBannerResponseItem.AdSpaceId.equals("")) {
                            if (!nextBannerResponseItem.PlacementId.equals(this.triedButNotShown)) {
                                if (!nextBannerResponseItem.IsTestItem) {
                                    if (this.currentRun == 2 || this.currentRun == 3) {
                                        z2 = true;
                                    }
                                    if (!AdMostUtil.checkFrequencyCapping(nextBannerResponseItem, z2)) {
                                        AdMostLog.m299i(className + " : FCAP worked for Interstitial. " + nextBannerResponseItem.toString());
                                        tryNextItemInWaterfall(true);
                                        return;
                                    }
                                }
                                startNetworkRequest(nextBannerResponseItem);
                                return;
                            }
                        }
                        tryNextItemInWaterfall(true);
                        return;
                    }
                    return;
                }
            }
            if (this.loadResults.size() > 0 && this.waitingResponseCount <= 0 && !getOtherNetworkFPBoostedItem()) {
                sendCumulativeResults();
            }
        } catch (Exception e) {
            tryNextItemInWaterfall(true);
            e.printStackTrace();
        }
    }

    public AdMostAdListener getAdMostAdListener() {
        return this.adMostAdListener;
    }

    public int getLoadedAdECPM() {
        AdMostBannerResponseItem adMostBannerResponseItem;
        AdMostFullScreenInterface adMostFullScreenInterface = this.loadedAd;
        if (adMostFullScreenInterface == null || (adMostBannerResponseItem = adMostFullScreenInterface.mBannerResponseItem) == null) {
            return 0;
        }
        return adMostBannerResponseItem.PureWeight;
    }

    public String getStatusLog() {
        String str;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        if (adMostBannerResponseBase == null || adMostBannerResponseBase.NetworkList == null || adMostBannerResponseBase.NetworkListInHouse == null || !AdMost.getInstance().isInitStarted()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        if (this.waterfallResponse.NetworkList.size() > 0) {
            for (int i = 0; i < this.waterfallResponse.NetworkList.size(); i++) {
                AdMostBannerResponseItem adMostBannerResponseItem = this.waterfallResponse.NetworkList.get(i);
                if (AdMostAdNetwork.isAdNetworkAvailable(adMostBannerResponseItem.Network) && adMostBannerResponseItem.WaterFallLogItem.isTried) {
                    arrayList.add(adMostBannerResponseItem);
                }
            }
        }
        if (this.waterfallResponse.NetworkListInHouse.size() > 0) {
            for (int i2 = 0; i2 < this.waterfallResponse.NetworkListInHouse.size(); i2++) {
                AdMostBannerResponseItem adMostBannerResponseItem2 = this.waterfallResponse.NetworkListInHouse.get(i2);
                if (AdMostAdNetwork.isAdNetworkAvailable(adMostBannerResponseItem2.Network) && adMostBannerResponseItem2.WaterFallLogItem.isTried) {
                    arrayList.add(adMostBannerResponseItem2);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AdMostBannerResponseItem adMostBannerResponseItem3 = (AdMostBannerResponseItem) it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(adMostBannerResponseItem3.Network);
            sb2.append(" - ");
            sb2.append(adMostBannerResponseItem3.WaterFallLogItem.isFilled ? "Filled" : "NoFill");
            sb2.append(" - ");
            if (adMostBannerResponseItem3.WaterFallLogItem.isShown) {
                str = "Shown";
            } else {
                str = "";
            }
            sb2.append(str);
            sb2.append("\n");
            sb.append(sb2.toString());
        }
        return sb.toString();
    }

    public boolean isDestroyed() {
        return this.interstitialStatus == 4;
    }

    public boolean isLoaded() {
        return this.interstitialStatus == 2;
    }

    public boolean isLoading() {
        return this.interstitialStatus == 1;
    }

    /* access modifiers changed from: package-private */
    public void loadBiddingAd(AdMostAdInterface adMostAdInterface, final AdMostAdInterface adMostAdInterface2) {
        if (adMostAdInterface != null && adMostAdInterface.getBannerResponseItem() != null) {
            adMostAdInterface.getBannerResponseItem().IsFirstSessionRequestForNetwork = AdMostImpressionManager.getInstance().isNetworksFirstRequestForSession(adMostAdInterface.getBannerResponseItem().Network);
            AdMostImpressionManager.getInstance().setNetworkRequested(adMostAdInterface.getBannerResponseItem().Network);
            ((AdMostFullScreenInterface) adMostAdInterface).load(adMostAdInterface.getBannerResponseItem(), (WeakReference<Activity>) null, new AdMostFullScreenInterfaceListener() {
                public void onClick(AdMostFullScreenInterface adMostFullScreenInterface) {
                    AdMostInterstitial.this.clicked(adMostFullScreenInterface.mBannerResponseItem);
                }

                public void onComplete(AdMostFullScreenInterface adMostFullScreenInterface) {
                    AdMostInterstitial.this.completed();
                }

                public void onDismiss(AdMostFullScreenInterface adMostFullScreenInterface) {
                    AdMostBiddingManager.getInstance().removeFromSingletonArray(adMostFullScreenInterface);
                    AdMostInterstitial.this.closed(adMostFullScreenInterface.mBannerResponseItem);
                }

                public void onFail(AdMostFullScreenInterface adMostFullScreenInterface) {
                    AdMostBiddingManager.getInstance().removeFromSingletonArray(adMostFullScreenInterface);
                    AdMostBiddingManager.getInstance().sendLossNotice((AdMostBiddingInterface) adMostFullScreenInterface, 0.0d, AdMostBiddingManager.LOSS_REASON_UNEXPECTED_ERROR);
                    AdMostImpressionManager.getInstance().setPlacementBidData(16, adMostFullScreenInterface.getBannerResponseItem());
                    AdMostImpressionManager.getInstance().setPlacementImpressionData(5, adMostFullScreenInterface.mBannerResponseItem);
                    adMostFullScreenInterface.mBannerResponseItem.WaterFallLogItem.failedAt = System.currentTimeMillis();
                    try {
                        AdMostAdStatsManager.getInstance().setPlacementRequestData(adMostFullScreenInterface.mBannerResponseItem, "NoFill", adMostFullScreenInterface.mBannerResponseItem.IsFirstRequestForNetwork, adMostFullScreenInterface.mBannerResponseItem.IsFirstSessionRequestForNetwork, AdMostInterstitial.this.zoneId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AdMostAdInterface adMostAdInterface = adMostAdInterface2;
                    if (adMostAdInterface != null) {
                        AdMostInterstitial adMostInterstitial = AdMostInterstitial.this;
                        adMostInterstitial.setWinningAdReturnResponse((AdMostFullScreenInterface) adMostAdInterface, adMostInterstitial.tempEventListener, AdMostInterstitial.this.tempCacheExpiresAt);
                        return;
                    }
                    AdMostInterstitial.this.returnNoFillToUser();
                }

                public void onFailToShow(AdMostFullScreenInterface adMostFullScreenInterface) {
                    AdMostBiddingManager.getInstance().removeFromSingletonArray(adMostFullScreenInterface);
                    AdMostImpressionManager.getInstance().setPlacementImpressionData(7, AdMostInterstitial.this.loadedBannerResponseItem);
                }

                public void onReady(AdMostFullScreenInterface adMostFullScreenInterface) {
                    AdMostBiddingInterface adMostBiddingInterface = (AdMostBiddingInterface) adMostFullScreenInterface;
                    adMostFullScreenInterface.mBannerResponseItem.PureWeight = (int) adMostBiddingInterface.getBiddingPrice();
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostFullScreenInterface.mBannerResponseItem;
                    AdMostBannerResponseItem adMostBannerResponseItem2 = adMostFullScreenInterface.mBannerResponseItem;
                    adMostBannerResponseItem.BiddingPriceFromNetworkInCent = (adMostBiddingInterface.getBiddingPrice() * 100.0d) / adMostBannerResponseItem2.BidScore;
                    AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem2.WaterFallLogItem;
                    adMostWaterfallLog.isFilled = true;
                    adMostWaterfallLog.filledAt = System.currentTimeMillis();
                    AdMostImpressionManager.getInstance().setPlacementImpressionData(3, adMostFullScreenInterface.mBannerResponseItem);
                    try {
                        AdMostAdStatsManager.getInstance().setPlacementRequestData(adMostFullScreenInterface.mBannerResponseItem, "Fill", adMostFullScreenInterface.mBannerResponseItem.IsFirstRequestForNetwork, adMostFullScreenInterface.mBannerResponseItem.IsFirstSessionRequestForNetwork, AdMostInterstitial.this.zoneId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AdMostInterstitial.this.setWinningAdReturnResponse(adMostFullScreenInterface, (String) null, 0);
                }
            });
        }
    }

    public void refreshAd(boolean z) {
        AdMostBannerResponseBase adMostBannerResponseBase;
        if (AdMostPolicyManager.getInstance().hasZonePolicyForNoAd(this.zoneId)) {
            onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_ZONE_PASSIVE);
        } else if (this.interstitialStatus != 2 || (adMostBannerResponseBase = this.waterfallResponse) == null) {
            if (this.noFillIntervalStartTime == 0 || System.currentTimeMillis() > this.noFillIntervalFinishTime) {
                int i = this.interstitialStatus;
                if (i != 1 && i != 3) {
                    this.loadedCallbackSet = false;
                    this.shownCallbackSet = false;
                    refreshAdInner(z, false);
                    return;
                }
                return;
            }
            onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_TOO_MANY_REQUEST);
        } else if (!AdMostUtil.checkZoneFrequencyCapping(adMostBannerResponseBase, false).isCapAvailable) {
            onAction(AdMostAdListener.LOADED, 0);
        } else {
            onAction(AdMostAdListener.FAILED, AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN);
        }
    }

    /* access modifiers changed from: package-private */
    public void returnNoFillToUser() {
        if (this.showTryCount == 1) {
            AdMostImpressionManager.getInstance().setZoneImpressionData(5, this.zoneId, 0, this.subZoneType);
            failedToShow((AdMostBannerResponseItem) null);
            return;
        }
        onAction(AdMostAdListener.FAILED, 400);
    }

    public void setCompletionReward(int i) {
        this.completionReward = i;
    }

    public void setListener(AdMostAdListener adMostAdListener2) {
        this.adMostAdListener = adMostAdListener2;
    }

    public /* bridge */ /* synthetic */ void setNetworkData(Hashtable hashtable) {
        super.setNetworkData(hashtable);
    }

    public void setSSVCustomData(Hashtable<String, Object> hashtable) {
        this.ssvCustomData = hashtable;
    }

    public void setSSVServer(String str) {
        this.ssvServer = str;
    }

    public void setZoneOverallTimeout(int i) {
        if (i > 0) {
            this.zoneOverallTimeout = i;
        }
    }

    public void show(String str) {
        showInternal(str);
    }

    public void testAd(String str, String str2, String str3, String str4, int i, String str5, boolean z) {
        this.interstitialStatus = 1;
        this.requestTimeout = i <= 0 ? 5000 : (long) i;
        this.subZoneType = str5;
        this.autoShow = false;
        this.currentRun = 1;
        this.requestNumber++;
        try {
            String format = String.format("{\"ZoneID\":\"%s\",\"Network\":\"%s\",\"Type\":\"%s\",\"PlacementID\":\"%s\",\"AdSpaceID\":\"%s\",\"IsTestItem\":true,\"Status\":\"enabled\",\"Weight\":1}", new Object[]{this.zoneId, str, str2, str3, str4});
            if (!z) {
                setBiddingCompleted();
                this.waterfallResponse = AdMostWaterfallStrategyManager.getInstance().getBannerResponseObject(new JSONObject(String.format(Locale.ENGLISH, "{Result: 1,Zone: {Id: \"%s\",Name: \"TestInt\",Type: \"fullscreen\",\"SubType\":\"%s\",Size: \"50\",NFFTime: 1,FcapD: 0,FcapH: 0,ImpInt: 0,RBC: 10000,RBI: 1,RefInt: 0,ReqTimeout: %d},Data: [{Priority: 1,TotalWeight: 202924,Placements: [%s]}]}", new Object[]{this.zoneId, this.subZoneType, Long.valueOf(this.requestTimeout), format})), false, false);
                AdMostImpressionManager.getInstance().setZoneImpressionData(1, this.zoneId, 0, this.subZoneType);
                tryNextItemInWaterfall(true);
                return;
            }
            waterfallCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
            this.waterfallResponse = AdMostWaterfallStrategyManager.getInstance().getBannerResponseObject(new JSONObject(String.format(Locale.ENGLISH, "{Result: 1,Zone: {Id: \"%s\",Name: \"TestInt\",Type: \"fullscreen\",\"SubType\":\"%s\",Size: \"50\",NFFTime: 1,FcapD: 0,FcapH: 0,ImpInt: 0,RBC: 10000,RBI: 1,RefInt: 0,ReqTimeout: %d},BidPlacements: [%s]}", new Object[]{this.zoneId, this.subZoneType, Long.valueOf(this.requestTimeout), format})), false, false);
            AdMostImpressionManager.getInstance().setZoneImpressionData(1, this.zoneId, 0, this.subZoneType);
            startBiddingCycle(this.interstitialId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        showInternal("");
    }

    public void destroy() {
        destroy(true);
    }
}
