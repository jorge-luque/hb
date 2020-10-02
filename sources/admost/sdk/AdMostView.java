package admost.sdk;

import admost.sdk.AdMostViewBinder;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdType;
import admost.sdk.base.AdMostBannerResponseFailReason;
import admost.sdk.base.AdMostBannerZoneCacheManager;
import admost.sdk.base.AdMostImpressionManager;
import admost.sdk.base.AdMostInitObservable;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostPolicyManager;
import admost.sdk.base.AdMostUtil;
import admost.sdk.base.AdMostWaterfallStrategyManager;
import admost.sdk.interfaces.AdMostAdInterface;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.listener.AdMostBannerInterfaceClickListener;
import admost.sdk.listener.AdMostBannerInterfaceListener;
import admost.sdk.listener.AdMostBiddingCompeteListener;
import admost.sdk.listener.AdMostManagerListener;
import admost.sdk.listener.AdMostRefreshListener;
import admost.sdk.listener.AdMostViewListener;
import admost.sdk.model.AdMostBannerResponseBase;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostItem;
import admost.sdk.model.AdMostWaterfallLog;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vungle.warren.AdLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class AdMostView extends AdMostBiddingAdItem {
    private static final String ZONE_TYPE_BANNER = "banner";
    private final int RUN_FINAL = 7;
    private final int RUN_PRIORITY1_1 = 1;
    private final int RUN_PRIORITY1_2 = 2;
    private final int RUN_PRIORITY1_WAITING_REQUESTS = 4;
    private final int RUN_PRIORITY2_1 = 5;
    /* access modifiers changed from: private */
    public WeakReference<Activity> activity;
    /* access modifiers changed from: private */
    public int adHeight;
    private int adIndex = 0;
    /* access modifiers changed from: private */
    public int admostViewId;
    private boolean binderSet = false;
    /* access modifiers changed from: private */
    public View containerView;
    /* access modifiers changed from: private */
    public int currentRun = 1;
    /* access modifiers changed from: private */
    public AdMostViewBinder customLayout;
    /* access modifiers changed from: private */
    public int customNativeAdDuration = 5;
    private boolean fillSent = false;
    /* access modifiers changed from: private */
    public FPBoosterItem fpBoosterItem = new FPBoosterItem();
    /* access modifiers changed from: private */
    public int genericNoFillReason;
    /* access modifiers changed from: private */
    public LayoutInflater inflater;
    private int lastNoFillReason = 0;
    /* access modifiers changed from: private */
    public AdMostBannerInterface loadedAd;
    /* access modifiers changed from: private */
    public Vector<AdMostItem> loadedAdList = new Vector<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Integer> networkMinNoFillWeight = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public Observer observer;
    /* access modifiers changed from: private */
    public boolean postedCumulativeResults;
    /* access modifiers changed from: private */
    public int refreshInterval = -1;
    private boolean refreshing;
    private int requestNumber = 1;
    /* access modifiers changed from: private */
    public int requestTimeout;
    private boolean responseOkForOnce;
    /* access modifiers changed from: private */
    public boolean scheduledShowNextAdWaiting;
    private boolean secondTryForDestroy = false;
    /* access modifiers changed from: private */
    public boolean startNewZoneCacheRequest;
    /* access modifiers changed from: private */
    public boolean startRequestForZoneCache;
    private String tag = "";
    /* access modifiers changed from: private */
    public AdMostViewBinder viewBinder;
    /* access modifiers changed from: private */
    public AdMostViewListener viewListener;
    private long viewShownAt = 0;
    /* access modifiers changed from: private */
    public int viewStatus = 0;
    /* access modifiers changed from: private */
    public boolean waitingInit = false;
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

    public static class CustomComparatorAdMostItem implements Comparator<AdMostItem> {
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
            r3 = r3.mBannerResponseItem;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(admost.sdk.model.AdMostItem r2, admost.sdk.model.AdMostItem r3) {
            /*
                r1 = this;
                java.lang.Object r2 = r2.getAd()
                admost.sdk.interfaces.AdMostBannerInterface r2 = (admost.sdk.interfaces.AdMostBannerInterface) r2
                java.lang.Object r3 = r3.getAd()
                admost.sdk.interfaces.AdMostBannerInterface r3 = (admost.sdk.interfaces.AdMostBannerInterface) r3
                r0 = 0
                if (r3 == 0) goto L_0x0017
                admost.sdk.model.AdMostBannerResponseItem r3 = r3.mBannerResponseItem
                if (r3 != 0) goto L_0x0014
                goto L_0x0017
            L_0x0014:
                int r3 = r3.WeightWithoutMultiplier
                goto L_0x0018
            L_0x0017:
                r3 = 0
            L_0x0018:
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                if (r2 == 0) goto L_0x0025
                admost.sdk.model.AdMostBannerResponseItem r2 = r2.mBannerResponseItem
                if (r2 != 0) goto L_0x0023
                goto L_0x0025
            L_0x0023:
                int r0 = r2.WeightWithoutMultiplier
            L_0x0025:
                java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
                int r2 = r3.compareTo(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostView.CustomComparatorAdMostItem.compare(admost.sdk.model.AdMostItem, admost.sdk.model.AdMostItem):int");
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

    public AdMostView(Activity activity2, String str, int i, AdMostViewListener adMostViewListener, AdMostViewBinder adMostViewBinder) {
        this.adHeight = i;
        initView(activity2, str, adMostViewListener, adMostViewBinder);
    }

    static /* synthetic */ int access$3310(AdMostView adMostView) {
        int i = adMostView.waitingResponseCount;
        adMostView.waitingResponseCount = i - 1;
        return i;
    }

    private void addDebugLayer(AdMostBannerResponseItem adMostBannerResponseItem) {
        if (AdMostLog.isEnabled()) {
            int indexOf = this.waterfallResponse.NetworkListNotInWaterfall.indexOf(adMostBannerResponseItem);
            if (indexOf >= 0) {
                this.waterfallResponse.NetworkListNotInWaterfall.get(indexOf).WaterFallLogItem.isShown = true;
            } else {
                int indexOf2 = this.waterfallResponse.NetworkList.indexOf(adMostBannerResponseItem);
                if (indexOf2 >= 0) {
                    this.waterfallResponse.NetworkList.get(indexOf2).WaterFallLogItem.isShown = true;
                } else {
                    int indexOf3 = this.waterfallResponse.NetworkListInHouse.indexOf(adMostBannerResponseItem);
                    if (indexOf3 >= 0) {
                        this.waterfallResponse.NetworkListInHouse.get(indexOf3).WaterFallLogItem.isShown = true;
                    } else {
                        int indexOf4 = this.waterfallResponse.BiddingItems.indexOf(adMostBannerResponseItem);
                        if (indexOf4 >= 0) {
                            this.waterfallResponse.BiddingItems.get(indexOf4).WaterFallLogItem.isShown = true;
                        }
                    }
                }
            }
            final TextView textView = (TextView) this.containerView.findViewById(C0164R.C0166id.ad_debug);
            final View findViewById = this.containerView.findViewById(C0164R.C0166id.ad_debug_info);
            if (textView != null && findViewById != null) {
                textView.setText(adMostBannerResponseItem.Network + " " + adMostBannerResponseItem.Type + "\n" + adMostBannerResponseItem.AdSpaceId);
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        textView.setVisibility(8);
                        findViewById.setVisibility(8);
                    }
                });
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AdMostUtil.showDebugActivity(AdMostView.this.waterfallResponse);
                    }
                });
            }
        }
    }

    private void cleanForZoneCache() {
        this.viewStatus = 4;
        this.inflater = null;
        this.containerView = null;
        this.viewListener = null;
        this.viewBinder = null;
        this.loadedAd = null;
        this.activity = null;
        setNetworkData((Hashtable) null);
        this.customLayout = null;
    }

    /* access modifiers changed from: private */
    public void clearZoneTimer() {
        Timer timer = this.zoneRequestTimer;
        if (timer != null) {
            timer.cancel();
            this.zoneRequestTimer.purge();
            this.zoneRequestTimer = null;
        }
    }

    /* access modifiers changed from: private */
    public void emptyBanners() {
        try {
            if (this.loadedAd != null) {
                try {
                    this.loadedAd.removeAdChoicesView(this.containerView, this.viewBinder);
                    this.loadedAd.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.loadedAd = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public boolean endUpWithZoneCache(AdMostItem adMostItem) {
        if (!this.startRequestForZoneCache) {
            return false;
        }
        this.viewStatus = 2;
        AdMostBannerZoneCacheManager instance = AdMostBannerZoneCacheManager.getInstance();
        String str = this.zoneId;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        AdMostViewBinder adMostViewBinder = this.customLayout;
        instance.addToZoneCache(str, adMostItem, adMostBannerResponseBase, adMostViewBinder != null ? adMostViewBinder.layoutId : 0, this.admostViewId);
        cleanForZoneCache();
        this.startRequestForZoneCache = false;
        return true;
    }

    /* access modifiers changed from: private */
    public boolean getFPBoostedItem() {
        ArrayList<AdMostBannerResponseItem> arrayList;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        if (adMostBannerResponseBase == null || (arrayList = adMostBannerResponseBase.NetworkListNotInWaterfall) == null || arrayList.size() <= 0) {
            return false;
        }
        int size = this.waterfallResponse.NetworkListNotInWaterfall.size() - 1;
        while (size >= 0) {
            AdMostBannerResponseItem adMostBannerResponseItem = this.waterfallResponse.NetworkListNotInWaterfall.get(size);
            int i = adMostBannerResponseItem.WeightWithoutMultiplier;
            FPBoosterItem fPBoosterItem = this.fpBoosterItem;
            if (i <= fPBoosterItem.adWeight || !adMostBannerResponseItem.Network.equals(fPBoosterItem.network) || this.fpBoosterItem.adPriority != adMostBannerResponseItem.Priority || adMostBannerResponseItem.WaterFallLogItem.isTried || getNetworkMinNoFillWeight(adMostBannerResponseItem.Network) <= adMostBannerResponseItem.WeightWithoutMultiplier) {
                size--;
            } else {
                try {
                    adMostBannerResponseItem.IsBoostedItem = true;
                    startNetworkRequest(adMostBannerResponseItem);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
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
    public void getNextAd() {
        if (this.viewStatus == 1 && !this.scheduledShowNextAdWaiting && this.loadedAdList.size() <= 0) {
            AdMostBannerResponseItem nextBannerResponseItem = getNextBannerResponseItem();
            if (nextBannerResponseItem != null) {
                if (!this.refreshing) {
                    emptyBanners();
                }
                if (nextBannerResponseItem.AdSpaceId.equals("")) {
                    getNextAd();
                } else if (nextBannerResponseItem.LifeTime > 0 || !this.startRequestForZoneCache) {
                    AdMostLog.m294d(AdMostView.class.getSimpleName() + " : Banner Request for  " + nextBannerResponseItem.toString());
                    try {
                        String str = nextBannerResponseItem.Type;
                        char c = 65535;
                        int hashCode = str.hashCode();
                        if (hashCode != -1396342996) {
                            if (hashCode != -1052618729) {
                                if (hashCode == 357963123) {
                                    if (str.equals(AdMostAdType.NATIVE_INSTALL)) {
                                        c = 2;
                                    }
                                }
                            } else if (str.equals("native")) {
                                c = 1;
                            }
                        } else if (str.equals("banner")) {
                            c = 0;
                        }
                        if (c == 0 || c == 1 || c == 2) {
                            startNetworkRequest(nextBannerResponseItem);
                        } else {
                            getNextAd();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        getNextAd();
                    }
                } else {
                    getNextAd();
                }
            }
        } else if (this.loadedAdList.size() > 0 && this.waitingResponseCount <= 0) {
            sendCumulativeResults();
        }
    }

    private AdMostBannerResponseItem getNextBannerResponseItem() {
        ArrayList<AdMostBannerResponseItem> arrayList;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        if (adMostBannerResponseBase == null) {
            this.genericNoFillReason = AdMost.AD_ERROR_WATERFALL_EMPTY;
            waterfallCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
            biddingCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
            return null;
        }
        ArrayList<AdMostBannerResponseItem> arrayList2 = adMostBannerResponseBase.NetworkList;
        if ((arrayList2 == null || arrayList2.size() == 0) && ((arrayList = this.waterfallResponse.NetworkListInHouse) == null || arrayList.size() == 0)) {
            waterfallCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
            return null;
        }
        int i = this.currentRun;
        long j = AdLoader.RETRY_DELAY;
        long j2 = 0;
        if (i == 1 || i == 2) {
            if (this.adIndex >= this.waterfallResponse.NetworkList.size()) {
                if (this.waitingResponseCount <= 0) {
                    j = 0;
                }
                passNextRun(j);
                return null;
            }
            AdMostBannerResponseItem adMostBannerResponseItem = this.waterfallResponse.NetworkList.get(this.adIndex);
            this.adIndex++;
            return adMostBannerResponseItem;
        } else if (i == 4) {
            if (this.waitingResponseCount > 0) {
                AdMostLog.m299i(AdMostView.class.getSimpleName() + " : Response postponed 3 seconds for waiting network requests. Waiting Request Count : " + this.waitingResponseCount + " admostViewId : " + this.admostViewId);
            }
            if (this.waitingResponseCount > 0) {
                j2 = 3000;
            }
            passNextRun(j2);
            return null;
        } else if (i != 5) {
            if (i == 7 && this.viewStatus == 1) {
                if (!this.refreshing) {
                    this.genericNoFillReason = 400;
                    waterfallCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
                } else {
                    this.viewStatus = 2;
                    this.viewShownAt = System.currentTimeMillis();
                }
            }
            return null;
        } else if (this.adIndex >= this.waterfallResponse.NetworkListInHouse.size()) {
            if (this.waterfallResponse.NetworkListInHouse.size() == 0 || this.waitingResponseCount <= 0) {
                j = 0;
            }
            passNextRun(j);
            return null;
        } else {
            AdMostBannerResponseItem adMostBannerResponseItem2 = this.waterfallResponse.NetworkListInHouse.get(this.adIndex);
            this.adIndex++;
            return adMostBannerResponseItem2;
        }
    }

    private void initView(Activity activity2, String str, AdMostViewListener adMostViewListener, AdMostViewBinder adMostViewBinder) {
        LayoutInflater layoutInflater;
        this.activity = new WeakReference<>(activity2);
        this.zoneId = str;
        this.viewListener = adMostViewListener;
        if (adMostViewBinder == null || (layoutInflater = adMostViewBinder.inflater) == null) {
            this.inflater = LayoutInflater.from(activity2);
        } else {
            this.inflater = layoutInflater;
        }
        this.admostViewId = new Random().nextInt(1000000) + 1000000;
        this.containerView = this.inflater.inflate(C0164R.layout.admost_loader, (ViewGroup) null);
        this.customLayout = adMostViewBinder;
        if (adMostViewBinder != null) {
            if (adMostViewBinder.layoutId < 1 || adMostViewBinder.iconImageId < 1 || adMostViewBinder.titleId < 1 || adMostViewBinder.callToActionId < 1) {
                throw new IllegalArgumentException(AdMostUtil.ERROR_BINDER);
            }
            this.viewBinder = adMostViewBinder;
        }
        setBinder();
    }

    /* access modifiers changed from: private */
    public boolean isListenerWaiting(AdMostBannerResponseItem adMostBannerResponseItem) {
        int i = this.viewStatus;
        if (!(i == 0 || i == 2)) {
            if (!this.fillSent) {
                AdMostImpressionManager.getInstance().setZoneImpressionData(3, this.zoneId, adMostBannerResponseItem != null ? adMostBannerResponseItem.PureWeight : 0, "banner");
            }
            this.fillSent = true;
            if (this.viewStatus == 4 || this.viewListener == null || this.startRequestForZoneCache) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isOnTop() {
        Activity activity2 = (Activity) this.activity.get();
        if (activity2 != null && AdMostManager.getInstance().getTopActivityHash() == activity2.getClass().hashCode()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void parseNativeContent(AdMostBannerResponseItem adMostBannerResponseItem, AdMostBannerInterface adMostBannerInterface) {
        try {
            setLoadedAd(adMostBannerInterface);
            ViewGroup viewGroup = null;
            if (this.containerView != null) {
                viewGroup = (ViewGroup) this.containerView.findViewById(C0164R.C0166id.ad_progress_layout);
            }
            View adView = this.loadedAd.getAdView(this.inflater, this.viewBinder, this.activity, viewGroup);
            if (adView == null) {
                AdMostLog.m303w(AdMostView.class.getSimpleName() + " : parseNativeContent : View is null for Network: " + adMostBannerResponseItem.Network);
                getNextAd();
                return;
            }
            showBannerAndNative(adView, adMostBannerResponseItem, false, 0);
        } catch (Exception e) {
            e.printStackTrace();
            getNextAd();
        }
    }

    private void passNextRun(long j) {
        this.adIndex = 0;
        int i = this.currentRun;
        int i2 = 4;
        if (i == 1) {
            i2 = 2;
        } else if (i != 2) {
            i2 = i == 4 ? 5 : 7;
        }
        this.currentRun = i2;
        if (j > 0) {
            this.scheduledShowNextAdWaiting = true;
            getHandler().postDelayed(new Runnable() {
                public void run() {
                    AdMostLog.m294d("***New Run for Banner scheduled : " + AdMostView.this.currentRun);
                    boolean unused = AdMostView.this.scheduledShowNextAdWaiting = false;
                    AdMostView.this.getNextAd();
                }
            }, j);
            return;
        }
        AdMostLog.m294d("***New Run for Banner : " + this.currentRun);
        getNextAd();
    }

    /* access modifiers changed from: private */
    public void postCumulativeResults(long j) {
        if (!this.postedCumulativeResults && this.loadedAdList.size() > 0) {
            this.postedCumulativeResults = true;
            if (this.waitingResponseCount > 0) {
                getHandler().postDelayed(new Runnable() {
                    public void run() {
                        boolean unused = AdMostView.this.postedCumulativeResults = false;
                        AdMostView.this.sendCumulativeResults();
                    }
                }, j);
                return;
            }
            this.postedCumulativeResults = false;
            sendCumulativeResults();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void sendCumulativeResults() {
        if (this.loadedAdList.size() > 0) {
            Collections.sort(this.loadedAdList, new CustomComparatorAdMostItem());
            for (int i = 0; i < this.loadedAdList.size(); i++) {
                AdMostItem adMostItem = this.loadedAdList.get(i);
                AdMostBannerInterface adMostBannerInterface = (AdMostBannerInterface) adMostItem.getAd();
                if (adMostBannerInterface.mBannerResponseItem != null) {
                    if (i != 0) {
                        AdMostManager.getInstance().putItemToCache(AdMostManager.getInstance().getCacheKey(adMostBannerInterface.mBannerResponseItem), adMostItem);
                    } else if (isListenerWaiting(adMostBannerInterface.mBannerResponseItem)) {
                        showAd(adMostItem);
                    } else if (!endUpWithZoneCache(adMostItem)) {
                        AdMostManager.getInstance().putItemToCache(AdMostManager.getInstance().getCacheKey(adMostBannerInterface.mBannerResponseItem), adMostItem);
                    }
                }
            }
            this.loadedAdList = new Vector<>();
        }
    }

    /* access modifiers changed from: private */
    public void setBinder() {
        int i = this.adHeight;
        if (i != 0 && !this.binderSet) {
            this.binderSet = true;
            if (this.viewBinder == null) {
                int i2 = C0164R.layout.admost_native_250;
                if (i == 50) {
                    i2 = C0164R.layout.admost_native_50;
                } else if (i == 90) {
                    i2 = C0164R.layout.admost_native_90;
                }
                this.viewBinder = new AdMostViewBinder.Builder(i2).iconImageId(C0164R.C0166id.ad_app_icon).titleId(C0164R.C0166id.ad_headline).callToActionId(C0164R.C0166id.ad_call_to_action).textId(C0164R.C0166id.ad_body).attributionId(C0164R.C0166id.ad_attribution).mainImageId(C0164R.C0166id.ad_image).backImageId(C0164R.C0166id.ad_back).isRoundedMode(true).privacyIconId(C0164R.C0166id.ad_mopub).build();
            }
            if (this.viewBinder.fixed) {
                this.containerView.findViewById(C0164R.C0166id.ad_progress).setVisibility(0);
                ((RelativeLayout.LayoutParams) this.containerView.findViewById(C0164R.C0166id.ad_progress).getLayoutParams()).addRule(13);
                ((RelativeLayout.LayoutParams) this.containerView.findViewById(C0164R.C0166id.ad_progress_layout).getLayoutParams()).height = AdMostUtil.getDip(this.adHeight);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setLoadedAd(AdMostBannerInterface adMostBannerInterface) {
        AdMostBannerResponseItem adMostBannerResponseItem;
        String str;
        AdMostBannerResponseItem adMostBannerResponseItem2;
        AdMostBannerInterface adMostBannerInterface2 = this.loadedAd;
        if (!(adMostBannerInterface2 == null || (adMostBannerResponseItem = adMostBannerInterface2.mBannerResponseItem) == null || (str = adMostBannerResponseItem.PlacementId) == null || adMostBannerInterface == null || (adMostBannerResponseItem2 = adMostBannerInterface.mBannerResponseItem) == null || str.equals(adMostBannerResponseItem2.PlacementId))) {
            emptyBanners();
        }
        this.loadedAd = adMostBannerInterface;
    }

    /* access modifiers changed from: private */
    public void setWinningAdReturnResponse(final AdMostBannerInterface adMostBannerInterface) {
        getHandler().post(new Runnable() {
            public void run() {
                AdMostBannerInterface adMostBannerInterface = adMostBannerInterface;
                if (adMostBannerInterface != null && adMostBannerInterface.mBannerResponseItem != null) {
                    adMostBannerInterface.setOnClickListener(new AdMostBannerInterfaceClickListener() {
                        public void onClick(String str) {
                            if (AdMostView.this.viewListener != null) {
                                AdMostView.this.viewListener.onClick(str);
                            }
                        }
                    });
                    if (adMostBannerInterface.mBannerResponseItem.Type.equals("banner")) {
                        AdMostView.this.setLoadedAd(adMostBannerInterface);
                        if (AdMostAdNetwork.hasBaseNetworkAdapter(AdMostAdNetwork.ADMOB, AdMostView.this.loadedAd.mBannerResponseItem.Network)) {
                            AdMostView.this.loadedAd.resume();
                        }
                        AdMostView adMostView = AdMostView.this;
                        adMostView.showBannerAndNative(adMostView.loadedAd.getAdView(AdMostView.this.inflater, AdMostView.this.viewBinder, AdMostView.this.activity, (ViewGroup) null), adMostBannerInterface.mBannerResponseItem, false, 0);
                    } else {
                        AdMostView adMostView2 = AdMostView.this;
                        AdMostBannerInterface adMostBannerInterface2 = adMostBannerInterface;
                        adMostView2.parseNativeContent(adMostBannerInterface2.mBannerResponseItem, adMostBannerInterface2);
                    }
                    if (AdMostView.this.startNewZoneCacheRequest) {
                        AdMostBannerZoneCacheManager.getInstance().startCacheRequest(AdMostView.this.zoneId, AdMostView.this.customLayout);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void showAd(final AdMostItem adMostItem) {
        AdMostBannerResponseItem adMostBannerResponseItem;
        AdMostBannerInterface adMostBannerInterface = (AdMostBannerInterface) adMostItem.getAd();
        if (adMostBannerInterface != null && (adMostBannerResponseItem = adMostBannerInterface.mBannerResponseItem) != null && adMostBannerResponseItem.Type != null) {
            waterfallCycleCompleted(adMostBannerInterface, new AdMostBiddingCompeteListener() {
                public void onBiddingWins(AdMostAdInterface adMostAdInterface, AdMostAdInterface adMostAdInterface2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Bidding onBiddingWins *** ");
                    sb.append(adMostAdInterface.getBannerResponseItem() != null ? adMostAdInterface.getBannerResponseItem().Network : "");
                    AdMostLog.m299i(sb.toString());
                    if (adMostAdInterface2 != null) {
                        AdMostManager.getInstance().putItemToCache(AdMostManager.getInstance().getCacheKey(adMostAdInterface2.getBannerResponseItem()), adMostItem);
                    }
                }

                public void onWaterfallWins(AdMostAdInterface adMostAdInterface) {
                    AdMostBannerResponseItem bannerResponseItem = adMostAdInterface.getBannerResponseItem();
                    if (bannerResponseItem != null) {
                        AdMostLog.m299i("Bidding onWaterfallWins *** " + bannerResponseItem.Network);
                        AdMostView.this.setWinningAdReturnResponse((AdMostBannerInterface) adMostAdInterface);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showBannerAndNative(View view, AdMostBannerResponseItem adMostBannerResponseItem, boolean z, final int i) {
        if (this.viewStatus != 4) {
            this.lastNoFillReason = i;
            if (!z && adMostBannerResponseItem != null) {
                this.responseOkForOnce = true;
                AdMostImpressionManager.getInstance().setPlacementImpressionData(2, adMostBannerResponseItem);
                AdMostImpressionManager.getInstance().setZoneImpressionData(2, this.zoneId, 0, "banner");
                if (adMostBannerResponseItem.IsBiddingItem) {
                    AdMostImpressionManager.getInstance().setPlacementBidData(2, adMostBannerResponseItem);
                }
                String str = this.tag;
                if (str != null && str.length() > 0) {
                    AdMostImpressionManager.getInstance().setPlacementTagData(2, this.tag, adMostBannerResponseItem);
                }
                AdMostUtil.keepFrequencyCapping("ZONE*" + this.zoneId);
                try {
                    ViewGroup viewGroup = (ViewGroup) this.containerView.findViewById(C0164R.C0166id.ad_progress_layout);
                    if (viewGroup == null) {
                        this.containerView = this.inflater.inflate(C0164R.layout.admost_loader, (ViewGroup) null);
                    }
                    viewGroup.removeAllViews();
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    if (adMostBannerResponseItem.Type.equals("banner")) {
                        int i2 = C0164R.layout.admost_banner_wrap;
                        int i3 = this.adHeight;
                        if (i3 == 50) {
                            i2 = C0164R.layout.admost_banner_50;
                        } else if (i3 == 90) {
                            i2 = C0164R.layout.admost_banner_90;
                        } else if (i3 == 250) {
                            i2 = C0164R.layout.admost_banner_250;
                        }
                        viewGroup.addView(this.inflater.inflate(i2, viewGroup, false));
                        ((RelativeLayout) this.containerView.findViewById(C0164R.C0166id.amr_ad_banner)).setGravity(17);
                        ((RelativeLayout) this.containerView.findViewById(C0164R.C0166id.amr_ad_banner)).addView(view);
                        ((RelativeLayout.LayoutParams) view.getLayoutParams()).addRule(13);
                        if (adMostBannerResponseItem.Network.equals(AdMostAdNetwork.SMAATO) && (this.adHeight == 50 || this.adHeight == 90)) {
                            ((RelativeLayout.LayoutParams) view.getLayoutParams()).width = this.adHeight == 50 ? AdMostUtil.getDip(320) : AdMostUtil.getDip(728);
                        }
                    } else {
                        viewGroup.addView(view);
                        if (this.loadedAd != null) {
                            this.loadedAd.addAdChoivesView(this.containerView, this.viewBinder);
                        }
                    }
                    addDebugLayer(adMostBannerResponseItem);
                    clearZoneTimer();
                    if (this.viewListener != null) {
                        this.viewStatus = 2;
                        if (this.viewBinder != null) {
                            boolean z2 = this.viewBinder.preventClicks;
                        }
                        this.viewListener.onReady(adMostBannerResponseItem.Network, adMostBannerResponseItem.PureWeight, this.containerView);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (this.viewListener != null) {
                if (i == 400 || i == 401) {
                    AdMostImpressionManager.getInstance().setZoneImpressionData(5, this.zoneId, 0, "banner");
                }
                getHandler().post(new Runnable() {
                    public void run() {
                        AdMostView.this.clearZoneTimer();
                        AdMostView.this.viewListener.onFail(i);
                    }
                });
            }
            this.viewShownAt = System.currentTimeMillis();
            this.viewStatus = 2;
            if (this.refreshInterval > 0) {
                AdMostManager.getInstance().addRefreshingBanner(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void startMediationRequest() {
        if (this.viewStatus != 4) {
            this.fpBoosterItem.initialize();
            this.viewStatus = 1;
            this.fillSent = false;
            this.startNewZoneCacheRequest = false;
            this.adIndex = 0;
            this.genericNoFillReason = 0;
            this.currentRun = 1;
            super.init();
            if (!this.waitingInit) {
                if (!AdMost.getInstance().isInitCompleted()) {
                    AdMostLog.m299i(AdMostView.class.getSimpleName() + " : Admost Init not completed. AdMostView is waiting init. admostViewId: " + this.admostViewId);
                    this.waitingInit = true;
                    this.observer = new Observer() {
                        public void update(Observable observable, Object obj) {
                            if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                                AdMostView.this.getHandler().post(new Runnable() {
                                    public void run() {
                                        boolean unused = AdMostView.this.waitingInit = false;
                                        AdMostView.this.startMediationRequest();
                                        AdMostInitObservable.getInstance().deleteObserver(AdMostView.this.observer);
                                        Observer unused2 = AdMostView.this.observer = null;
                                    }
                                });
                            }
                        }
                    };
                    AdMostInitObservable.getInstance().addObserver(this.observer);
                } else if (AdMost.getInstance().isTagPassive(this.tag) || AdMostPolicyManager.getInstance().hasZonePolicyForNoAd(this.zoneId)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Zone or TAG passive ");
                    String str = this.tag;
                    if (str == null) {
                        str = "";
                    }
                    sb.append(str);
                    AdMostLog.m299i(sb.toString());
                    this.viewStatus = 0;
                    clearZoneTimer();
                    AdMostViewListener adMostViewListener = this.viewListener;
                    if (adMostViewListener != null) {
                        adMostViewListener.onFail(AdMost.AD_ERROR_ZONE_PASSIVE);
                    }
                } else {
                    this.requestNumber++;
                    try {
                        final Object[] fromZoneCache = AdMostBannerZoneCacheManager.getInstance().getFromZoneCache(this.zoneId, this.customLayout != null ? this.customLayout.layoutId : 0);
                        if (fromZoneCache != null && fromZoneCache.length > 1) {
                            final AdMostItem adMostItem = (AdMostItem) fromZoneCache[0];
                            AdMostBannerInterface adMostBannerInterface = (AdMostBannerInterface) adMostItem.getAd();
                            if (adMostBannerInterface == null || adMostBannerInterface.mBannerResponseItem == null) {
                                this.startNewZoneCacheRequest = true;
                            } else if (this.startRequestForZoneCache) {
                                destroy();
                                return;
                            } else if (adMostItem.expiresAt > System.currentTimeMillis()) {
                                getHandler().post(new Runnable() {
                                    public void run() {
                                        int i;
                                        AdMostView adMostView = AdMostView.this;
                                        AdMostBannerResponseBase adMostBannerResponseBase = (AdMostBannerResponseBase) fromZoneCache[1];
                                        adMostView.waterfallResponse = adMostBannerResponseBase;
                                        int unused = adMostView.refreshInterval = adMostBannerResponseBase.RefreshInterval;
                                        AdMostView adMostView2 = AdMostView.this;
                                        if (adMostView2.adHeight > 0) {
                                            i = AdMostView.this.adHeight;
                                        } else if (AdMostView.this.waterfallResponse.ZoneSize.equals("250")) {
                                            i = AdMostManager.AD_MEDIUM_RECTANGLE;
                                        } else {
                                            i = AdMostView.this.waterfallResponse.ZoneSize.equals("90") ? 90 : 50;
                                        }
                                        int unused2 = adMostView2.adHeight = i;
                                        AdMostView adMostView3 = AdMostView.this;
                                        int unused3 = adMostView3.requestTimeout = adMostView3.waterfallResponse.ZoneRequestTimeout;
                                        AdMostView adMostView4 = AdMostView.this;
                                        int unused4 = adMostView4.customNativeAdDuration = adMostView4.waterfallResponse.CustomNativeAdDuration;
                                        AdMostView.this.setBinder();
                                        boolean unused5 = AdMostView.this.startNewZoneCacheRequest = true;
                                        AdMostView.this.showAd(adMostItem);
                                    }
                                });
                                return;
                            } else {
                                this.startNewZoneCacheRequest = true;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AdMostManager.getInstance().refreshAd((Activity) this.activity.get(), this.zoneId, this.admostViewId, new AdMostRefreshListener() {
                        public void onAdMediation(AdMostBannerResponseBase adMostBannerResponseBase) {
                            int i;
                            AdMostView.this.waterfallResponse = adMostBannerResponseBase;
                            AdMostImpressionManager.getInstance().setZoneImpressionData(1, AdMostView.this.zoneId, 0, "banner");
                            AdMostView adMostView = AdMostView.this;
                            int unused = adMostView.refreshInterval = !adMostView.startRequestForZoneCache ? AdMostView.this.waterfallResponse.RefreshInterval : -1;
                            AdMostView adMostView2 = AdMostView.this;
                            if (adMostView2.adHeight > 0) {
                                i = AdMostView.this.adHeight;
                            } else if (AdMostView.this.waterfallResponse.ZoneSize.equals("250")) {
                                i = AdMostManager.AD_MEDIUM_RECTANGLE;
                            } else {
                                i = AdMostView.this.waterfallResponse.ZoneSize.equals("90") ? 90 : 50;
                            }
                            int unused2 = adMostView2.adHeight = i;
                            AdMostView adMostView3 = AdMostView.this;
                            int unused3 = adMostView3.requestTimeout = adMostView3.waterfallResponse.ZoneRequestTimeout;
                            long unused4 = AdMostView.this.zoneResponseTimeoutAt = System.currentTimeMillis() + ((long) adMostBannerResponseBase.ZoneResponseTimeout);
                            AdMostView adMostView4 = AdMostView.this;
                            int unused5 = adMostView4.customNativeAdDuration = adMostView4.waterfallResponse.CustomNativeAdDuration;
                            if (AdMostView.this.zoneOverallTimeout == 0) {
                                AdMostView adMostView5 = AdMostView.this;
                                int unused6 = adMostView5.zoneOverallTimeout = adMostView5.waterfallResponse.ZoneOverallTimeout;
                            }
                            if (AdMostView.this.zoneOverallTimeout > 0) {
                                Timer unused7 = AdMostView.this.zoneRequestTimer = new Timer();
                                AdMostView.this.zoneRequestTimer.schedule(new TimerTask() {
                                    public void run() {
                                        AdMostView adMostView = AdMostView.this;
                                        if (adMostView != null && adMostView.getViewStatus() != 2 && AdMostView.this.getHandler() != null) {
                                            int unused = AdMostView.this.genericNoFillReason = AdMost.AD_ERROR_ZONE_TIMEOUT;
                                            AdMostView.this.waterfallCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
                                            AdMostView.this.biddingCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
                                        }
                                    }
                                }, (long) AdMostView.this.zoneOverallTimeout);
                            }
                            AdMostView.this.setBinder();
                            AdMostView adMostView6 = AdMostView.this;
                            adMostView6.startBiddingCycle(AdMostView.this.admostViewId + "");
                            AdMostView.this.getNextAd();
                        }

                        public void onError(int i) {
                            AdMostView adMostView = AdMostView.this;
                            adMostView.waterfallResponse = null;
                            if (adMostView.viewStatus == 1 && !AdMostView.this.scheduledShowNextAdWaiting) {
                                int unused = AdMostView.this.genericNoFillReason = i;
                                AdMostView.this.waterfallCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
                                AdMostView.this.biddingCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
                            }
                        }
                    });
                }
            }
        }
    }

    private void startNetworkRequest(AdMostBannerResponseItem adMostBannerResponseItem) throws Exception {
        adMostBannerResponseItem.ZoneSize = this.adHeight;
        adMostBannerResponseItem.NetworkData = getCustomData();
        adMostBannerResponseItem.LocalCustomLayoutId = this.viewBinder.layoutId;
        AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem.WaterFallLogItem;
        adMostWaterfallLog.isTried = true;
        int i = adMostWaterfallLog.requestCount + 1;
        adMostWaterfallLog.requestCount = i;
        if (i == 1) {
            adMostWaterfallLog.triedAt = System.currentTimeMillis();
        } else {
            adMostWaterfallLog.triedAt2 = System.currentTimeMillis();
        }
        this.waitingResponseCount++;
        AdMostManager instance = AdMostManager.getInstance();
        Activity activity2 = (Activity) this.activity.get();
        final AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerResponseItem;
        C01629 r4 = new AdMostManagerListener(this.admostViewId, this.requestNumber, this.currentRun == 2, this.requestTimeout, this.zoneId) {
            public void onAdClicked() {
                if (AdMostView.this.viewListener != null) {
                    AdMostView.this.viewListener.onClick(AdMostView.this.loadedAd.mBannerResponseItem.Network);
                }
            }

            public boolean onAdFailed(String str) {
                AdMostBannerResponseItem adMostBannerResponseItem;
                boolean onAdFailed = super.onAdFailed(str);
                if (onAdFailed) {
                    AdMostView.access$3310(AdMostView.this);
                }
                if (onAdFailed && (adMostBannerResponseItem = adMostBannerResponseItem2) != null) {
                    AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem.WaterFallLogItem;
                    adMostWaterfallLog.responseCount++;
                    adMostWaterfallLog.failedAt = System.currentTimeMillis();
                }
                if (str.equals(AdMostBannerResponseFailReason.NO_FILL_RESPONSE_FROM_NETWORK)) {
                    ConcurrentHashMap access$4100 = AdMostView.this.networkMinNoFillWeight;
                    AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerResponseItem2;
                    String str2 = adMostBannerResponseItem2.Network;
                    access$4100.put(str2, Integer.valueOf(adMostBannerResponseItem2.WeightWithoutMultiplier <= AdMostView.this.getNetworkMinNoFillWeight(str2) ? adMostBannerResponseItem2.WeightWithoutMultiplier : AdMostView.this.getNetworkMinNoFillWeight(adMostBannerResponseItem2.Network)));
                }
                if (this.dontTryNextWaterfallItem && AdMostView.this.loadedAdList.size() <= 0) {
                    return false;
                }
                AdMostView.this.getNextAd();
                return false;
            }

            public int onAdLoad(String str, AdMostItem adMostItem) {
                if (this.waitingResponse) {
                    AdMostView.access$3310(AdMostView.this);
                }
                AdMostBannerResponseItem adMostBannerResponseItem = adMostBannerResponseItem2;
                if (adMostBannerResponseItem != null) {
                    AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem.WaterFallLogItem;
                    adMostWaterfallLog.responseCount++;
                    adMostWaterfallLog.isFilled = true;
                    adMostWaterfallLog.filledAt = System.currentTimeMillis();
                    AdMostLog.log("AdMostView onAdLoaded : " + adMostBannerResponseItem2.toString());
                }
                super.onAdLoad(str, adMostItem);
                long access$2600 = AdMostView.this.zoneResponseTimeoutAt - System.currentTimeMillis();
                if (access$2600 > 0) {
                    AdMostView.this.loadedAdList.add(adMostItem);
                    AdMostView.this.fpBoosterItem.setMaxValues(adMostBannerResponseItem2);
                    if (AdMostView.this.getFPBoostedItem()) {
                        AdMostView.this.postCumulativeResults(access$2600);
                        return 3;
                    } else if (AdMostView.this.waitingResponseCount <= 0) {
                        AdMostView.this.sendCumulativeResults();
                        return 3;
                    } else {
                        AdMostView.this.postCumulativeResults(access$2600);
                        return 3;
                    }
                } else if (AdMostView.this.isListenerWaiting(adMostBannerResponseItem2)) {
                    AdMostView.this.showAd(adMostItem);
                    return 0;
                } else if (!AdMostView.this.startRequestForZoneCache) {
                    return 1;
                } else {
                    boolean unused = AdMostView.this.endUpWithZoneCache(adMostItem);
                    return 2;
                }
            }
        };
        AdMostViewBinder adMostViewBinder = this.viewBinder;
        AdMostBannerResponseBase adMostBannerResponseBase = this.waterfallResponse;
        instance.getNextAd(activity2, adMostBannerResponseItem, r4, adMostViewBinder, adMostBannerResponseBase != null ? adMostBannerResponseBase.IsFirstRequestForZone : false);
    }

    public void destroy() {
        clearZoneTimer();
        AdMostLog.m294d(AdMostView.class.getSimpleName() + " : Destroyed. admostViewId : " + this.admostViewId);
        if (this.viewStatus != 4) {
            this.viewStatus = 4;
            super.destroy();
            getHandler().post(new Runnable() {
                public void run() {
                    AdMostView.this.emptyBanners();
                    LayoutInflater unused = AdMostView.this.inflater = null;
                    View unused2 = AdMostView.this.containerView = null;
                    AdMostBannerResponseBase adMostBannerResponseBase = AdMostView.this.waterfallResponse;
                    if (adMostBannerResponseBase != null) {
                        adMostBannerResponseBase.destroy();
                    }
                    AdMostView adMostView = AdMostView.this;
                    adMostView.waterfallResponse = null;
                    AdMostViewListener unused3 = adMostView.viewListener = null;
                    AdMostViewBinder unused4 = AdMostView.this.viewBinder = null;
                    AdMostBannerInterface unused5 = AdMostView.this.loadedAd = null;
                    WeakReference unused6 = AdMostView.this.activity = null;
                    AdMostView.this.setNetworkData((Hashtable) null);
                    AdMostViewBinder unused7 = AdMostView.this.customLayout = null;
                    Vector unused8 = AdMostView.this.loadedAdList = new Vector();
                    AdMostView.super.destroy();
                }
            });
        }
    }

    public int getCustomNativeAdDuration() {
        return this.customNativeAdDuration;
    }

    public int getHeight() {
        return this.adHeight;
    }

    public int getLoadedAdECPM() {
        AdMostBannerResponseItem adMostBannerResponseItem;
        AdMostBannerInterface adMostBannerInterface = this.loadedAd;
        if (adMostBannerInterface == null || (adMostBannerResponseItem = adMostBannerInterface.mBannerResponseItem) == null) {
            return 0;
        }
        return adMostBannerResponseItem.PureWeight;
    }

    public View getView() {
        load();
        return this.containerView;
    }

    public AdMostViewBinder getViewBinder() {
        return this.viewBinder;
    }

    public int getViewStatus() {
        return this.viewStatus;
    }

    public boolean hasAdIcon() {
        AdMostBannerInterface adMostBannerInterface = this.loadedAd;
        return adMostBannerInterface != null && adMostBannerInterface.hasAdIcon;
    }

    public boolean hasAdImage() {
        AdMostBannerInterface adMostBannerInterface = this.loadedAd;
        return adMostBannerInterface != null && adMostBannerInterface.hasAdImage;
    }

    public boolean isAdClicked() {
        AdMostBannerInterface adMostBannerInterface = this.loadedAd;
        return adMostBannerInterface != null && adMostBannerInterface.isAdClicked;
    }

    public boolean isAdLoaded() {
        return this.loadedAd != null && this.viewStatus == 2;
    }

    /* access modifiers changed from: package-private */
    public boolean isDestroyed() {
        WeakReference<Activity> weakReference;
        WeakReference<Activity> weakReference2;
        if (Build.VERSION.SDK_INT < 17 || (weakReference2 = this.activity) == null || weakReference2.get() == null || !((Activity) this.activity.get()).isDestroyed()) {
            this.secondTryForDestroy = false;
        } else if (this.secondTryForDestroy) {
            this.secondTryForDestroy = false;
            destroy();
        } else {
            this.secondTryForDestroy = true;
        }
        if (this.viewStatus == 4 || (weakReference = this.activity) == null || weakReference.get() == null) {
            return true;
        }
        return false;
    }

    public void load() {
        if (this.viewStatus == 0) {
            startMediationRequest();
        }
    }

    /* access modifiers changed from: package-private */
    public void loadBiddingAd(final AdMostAdInterface adMostAdInterface, final AdMostAdInterface adMostAdInterface2) {
        if (adMostAdInterface != null && adMostAdInterface.getBannerResponseItem() != null) {
            ((AdMostBannerInterface) adMostAdInterface).load(adMostAdInterface.getBannerResponseItem(), this.activity, new AdMostBannerInterfaceListener() {
                public void onFail() {
                    AdMostImpressionManager.getInstance().setPlacementBidData(16, adMostAdInterface.getBannerResponseItem());
                    AdMostImpressionManager.getInstance().setPlacementImpressionData(5, adMostAdInterface.getBannerResponseItem());
                    AdMostBiddingManager.getInstance().sendLossNotice((AdMostBiddingInterface) adMostAdInterface, 0.0d, AdMostBiddingManager.LOSS_REASON_UNEXPECTED_ERROR);
                    adMostAdInterface.getBannerResponseItem().WaterFallLogItem.failedAt = System.currentTimeMillis();
                    AdMostAdInterface adMostAdInterface = adMostAdInterface2;
                    if (adMostAdInterface == null || adMostAdInterface.getBannerResponseItem() == null) {
                        AdMostView.this.returnNoFillToUser();
                    } else {
                        AdMostView.this.setWinningAdReturnResponse((AdMostBannerInterface) adMostAdInterface2);
                    }
                }

                public void onReady(AdMostBannerInterface adMostBannerInterface) {
                    AdMostBiddingInterface adMostBiddingInterface = (AdMostBiddingInterface) adMostBannerInterface;
                    adMostBannerInterface.mBannerResponseItem.PureWeight = (int) adMostBiddingInterface.getBiddingPrice();
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostBannerInterface.mBannerResponseItem;
                    AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerInterface.mBannerResponseItem;
                    adMostBannerResponseItem.BiddingPriceFromNetworkInCent = (adMostBiddingInterface.getBiddingPrice() * 100.0d) / adMostBannerResponseItem2.BidScore;
                    AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem2.WaterFallLogItem;
                    adMostWaterfallLog.isFilled = true;
                    adMostWaterfallLog.filledAt = System.currentTimeMillis();
                    AdMostImpressionManager.getInstance().setPlacementImpressionData(3, adMostBannerInterface.mBannerResponseItem);
                    if (AdMostView.this.isListenerWaiting(adMostBannerInterface.mBannerResponseItem)) {
                        AdMostUtil.keepFrequencyCapping(adMostBannerInterface.mBannerResponseItem.ZoneId + "*" + adMostBannerInterface.mBannerResponseItem.PlacementId);
                        AdMostView.this.setWinningAdReturnResponse(adMostBannerInterface);
                    }
                }
            });
        }
    }

    public void pause() {
        try {
            if (this.loadedAd != null) {
                this.loadedAd.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshAd() {
        int i;
        Class<AdMostView> cls = AdMostView.class;
        if (!AdMost.getInstance().isOnForeGround()) {
            AdMostLog.m301v(cls.getSimpleName() + " : Refresh Interval app not on foreground. admostViewId : " + this.admostViewId);
        } else if (this.viewStatus != 2 || (i = this.refreshInterval) <= 0) {
            AdMostLog.m301v(cls.getSimpleName() + " : Refresh Interval state problem. admostViewId : " + this.admostViewId + " viewStatus : " + AdMostUtil.getAdStatusName(this.viewStatus) + " refreshInterval : " + this.refreshInterval);
        } else if (this.viewShownAt + ((long) (i * 1000)) > System.currentTimeMillis()) {
            AdMostLog.m301v(cls.getSimpleName() + " : Refresh Interval time waiting. admostViewId : " + this.admostViewId);
        } else if (this.containerView.getVisibility() != 0) {
            AdMostLog.m301v(cls.getSimpleName() + " : Refresh Interval not visible banner. admostViewId : " + this.admostViewId);
        } else if (this.containerView.getParent() == null && this.responseOkForOnce) {
            AdMostLog.m303w(cls.getSimpleName() + " : Refresh Interval not attached. admostViewId : " + this.admostViewId);
        } else if (this.activity.get() == null || !isOnTop()) {
            AdMostLog.m301v(cls.getSimpleName() + " : Refresh Interval activity not on top. admostViewId : " + this.admostViewId);
        } else {
            if (Build.VERSION.SDK_INT >= 13) {
                int[] iArr = new int[2];
                try {
                    this.containerView.getLocationOnScreen(iArr);
                    if (iArr[0] < 0 || iArr[1] < 0) {
                        AdMostLog.m301v(cls.getSimpleName() + " : Refresh Interval view not on screen. admostViewId : " + this.admostViewId);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                WeakReference<Activity> weakReference = this.activity;
                Point screenDims = (weakReference == null || weakReference.get() == null) ? null : AdMostUtil.getScreenDims((Activity) this.activity.get());
                AdMostLog.m294d("PhoneDimensions : " + screenDims.x + " " + screenDims.y + " Location : " + iArr[0] + " " + iArr[1]);
                if (screenDims != null && (iArr[0] > screenDims.x || iArr[1] > screenDims.y + 120)) {
                    AdMostLog.m301v(cls.getSimpleName() + " : Refresh Interval view not on screen out of bounds. admostViewId : " + this.admostViewId);
                    return;
                } else if (!this.containerView.isShown() && this.lastNoFillReason == 0) {
                    AdMostLog.m301v(cls.getSimpleName() + " : Refresh Interval visibility of this view or any of its ancestors not suitable. admostViewId : " + this.admostViewId);
                    return;
                }
            }
            this.refreshing = true;
            startMediationRequest();
        }
    }

    public void resume() {
        if (AdMost.getInstance().isStopped()) {
            startMediationRequest();
            return;
        }
        try {
            if (this.loadedAd != null) {
                this.loadedAd.resume();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void returnNoFillToUser() {
        if (this.inflater != null) {
            int i = this.genericNoFillReason;
            if (i == 0) {
                i = 400;
            }
            this.genericNoFillReason = i;
            showBannerAndNative(this.inflater.inflate(C0164R.layout.admost_loader, (ViewGroup) null), (AdMostBannerResponseItem) null, true, this.genericNoFillReason);
        }
    }

    public void setAttachedActivity(Activity activity2) {
        this.activity = new WeakReference<>(activity2);
    }

    public void setListener(AdMostViewListener adMostViewListener) {
        this.viewListener = adMostViewListener;
    }

    public /* bridge */ /* synthetic */ void setNetworkData(Hashtable hashtable) {
        super.setNetworkData(hashtable);
    }

    public void setZoneOverallTimeout(int i) {
        if (i > 0) {
            this.zoneOverallTimeout = i;
        }
    }

    public void startRequestForZoneCache() {
        this.viewListener = null;
        this.startRequestForZoneCache = true;
    }

    public void testAd(String str, String str2, String str3, String str4, int i, boolean z) {
        this.viewStatus = 1;
        this.requestTimeout = i;
        this.currentRun = 1;
        try {
            String format = String.format("{\"ZoneID\":\"%s\",\"Network\":\"%s\",\"Type\":\"%s\",\"PlacementID\":\"%s\",\"AdSpaceID\":\"%s\",\"IsTestItem\":true,\"Status\":\"enabled\",\"Weight\":1}", new Object[]{this.zoneId, str, str2, str3, str4});
            if (!z) {
                this.waterfallResponse = AdMostWaterfallStrategyManager.getInstance().getBannerResponseObject(new JSONObject(String.format(Locale.ENGLISH, "{Result: 1,Zone: {Id: \"%s\",Name: \"TestInt\",Type: \"banner\",Size: \"50\",NFFTime: 1,FcapD: 0,FcapH: 0,ImpInt: 0,RBC: 10000,RBI: 1,RefInt: 0,ReqTimeout: %d},Data: [{Priority: 1,TotalWeight: 202924,Placements: [%s]}]}", new Object[]{this.zoneId, Integer.valueOf(this.requestTimeout), format})), false, false);
                setBiddingCompleted();
                AdMostImpressionManager.getInstance().setZoneImpressionData(1, this.zoneId, 0, "banner");
                getNextAd();
                return;
            }
            this.waterfallResponse = AdMostWaterfallStrategyManager.getInstance().getBannerResponseObject(new JSONObject(String.format(Locale.ENGLISH, "{Result: 1,Zone: {Id: \"%s\",Name: \"TestInt\",Type: \"banner\",Size: \"50\",NFFTime: 1,FcapD: 0,FcapH: 0,ImpInt: 0,RBC: 10000,RBI: 1,RefInt: 0,ReqTimeout: %d},BidPlacements: [%s]}", new Object[]{this.zoneId, Integer.valueOf(this.requestTimeout), format})), false, false);
            waterfallCycleCompleted((AdMostAdInterface) null, (AdMostBiddingCompeteListener) null);
            AdMostImpressionManager.getInstance().setZoneImpressionData(1, this.zoneId, 0, "banner");
            startBiddingCycle(this.admostViewId + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(String str) {
        this.tag = str;
        load();
    }

    public AdMostView(Activity activity2, String str, AdMostViewListener adMostViewListener, AdMostViewBinder adMostViewBinder) {
        initView(activity2, str, adMostViewListener, adMostViewBinder);
    }
}
