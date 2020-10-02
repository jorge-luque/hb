package admost.sdk;

import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostImpressionManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostAdInterface;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.interfaces.AdMostBiddingInterface;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostBiddingEventListener;
import admost.sdk.listener.AdMostBiddingListener;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.networkadapter.AdMostAdmobFullScreenAdapter;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class AdMostBiddingManager {
    public static int LOSS_REASON_BID_TIMEOUT = 2;
    public static int LOSS_REASON_INVALID_BID_RESPONSE = 3;
    public static int LOSS_REASON_NOT_HIGHER_THAN_WATERFALL = 103;
    public static int LOSS_REASON_NOT_HIGHEST_RTB_BIDDER = 102;
    public static int LOSS_REASON_UNEXPECTED_ERROR = 1;
    private static AdMostBiddingManager biddingManagerInstance;
    /* access modifiers changed from: private */
    public static HashMap<String, AdMostBiddingEventListener> eventListeners = new HashMap<>();
    private static final Object lock = new Object();
    private static final Object lock2 = new Object();
    private static final Object lock3 = new Object();
    /* access modifiers changed from: private */
    public static final ArrayList<AdMostBiddingEventListener> timeoutList = new ArrayList<>();
    private static Thread timeoutThread;
    private Handler handler = new Handler(Looper.getMainLooper());
    private ArrayList<String> singletonWaitingResponse = new ArrayList<>();

    private boolean addSingletonArray(AdMostFullScreenInterface adMostFullScreenInterface) {
        String singletonKey = getSingletonKey(adMostFullScreenInterface);
        if (singletonKey.equals("")) {
            return true;
        }
        synchronized (lock2) {
            if (this.singletonWaitingResponse.contains(singletonKey)) {
                AdMostLog.m294d(AdMostBiddingManager.class.getSimpleName() + " : Interstitial BIDDING request stopped because of SINGLETON " + adMostFullScreenInterface.mBannerResponseItem.Network + " " + adMostFullScreenInterface.mBannerResponseItem.Type);
                return false;
            }
            this.singletonWaitingResponse.add(singletonKey);
            return true;
        }
    }

    private synchronized void addToEventListeners(AdMostBiddingEventListener adMostBiddingEventListener) {
        synchronized (lock3) {
            eventListeners.put(String.valueOf(adMostBiddingEventListener.hashCode()), adMostBiddingEventListener);
        }
    }

    /* access modifiers changed from: private */
    public void addToTimeoutList(AdMostBiddingEventListener adMostBiddingEventListener) {
        synchronized (timeoutList) {
            if (adMostBiddingEventListener != null) {
                adMostBiddingEventListener.setTimeoutAt();
            }
            timeoutList.add(adMostBiddingEventListener);
            timeoutList.notify();
        }
    }

    /* access modifiers changed from: private */
    public void bidFail(final AdMostBannerResponseItem adMostBannerResponseItem, final String str, final String str2) {
        this.handler.post(new Runnable() {
            public void run() {
                AdMostBiddingEventListener adMostBiddingEventListener = (AdMostBiddingEventListener) AdMostBiddingManager.eventListeners.get(str);
                if (adMostBiddingEventListener != null) {
                    adMostBiddingEventListener.onBiddingFail(adMostBannerResponseItem, str2);
                    AdMostBiddingManager.removeFromEventListeners(adMostBiddingEventListener);
                }
            }
        });
    }

    private void bidForBanner(AdMostBannerResponseItem adMostBannerResponseItem, String str, AdMostBiddingEventListener adMostBiddingEventListener) {
        try {
            final AdMostBannerInterface bannerAdapter = AdMostAdNetworkManager.getInstance().getBannerAdapter(adMostBannerResponseItem);
            if (bannerAdapter == null) {
                bidFail(adMostBannerResponseItem, str, AdMostBiddingEventListener.ERROR_STATUS_CHANGED);
            } else if (AdMostAdNetworkManager.getInstance().getInitAdapter(adMostBannerResponseItem).hasInitializationError) {
                bidFail(adMostBannerResponseItem, str, AdMostBiddingEventListener.ERROR_INITIALIZATION_ERROR);
            } else {
                final AdMostBiddingEventListener adMostBiddingEventListener2 = adMostBiddingEventListener;
                final AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerResponseItem;
                final String str2 = str;
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        AdMostBiddingEventListener adMostBiddingEventListener = adMostBiddingEventListener2;
                        adMostBiddingEventListener.biddingInterface = (AdMostBiddingInterface) bannerAdapter;
                        AdMostBiddingManager.this.addToTimeoutList(adMostBiddingEventListener);
                        AdMostLog.m299i(AdMostBiddingManager.class.getSimpleName() + " : (" + adMostBannerResponseItem2.ZoneId + ") BIDDING request started " + adMostBannerResponseItem2.Network + " " + adMostBannerResponseItem2.Type + " " + adMostBannerResponseItem2.PlacementName + "-ecpm:" + adMostBannerResponseItem2.PureWeight);
                        AdMostImpressionManager.getInstance().setPlacementBidData(11, adMostBannerResponseItem2);
                        adMostBannerResponseItem2.WaterFallLogItem.isBidRequested = true;
                        ((AdMostBiddingInterface) bannerAdapter).bid(new AdMostBiddingListener() {
                            public void onFail(String str) {
                                C01073 r0 = C01073.this;
                                AdMostBiddingManager.this.bidFail(adMostBannerResponseItem2, str2, str);
                            }

                            public void onSuccess(double d) {
                                C01073 r0 = C01073.this;
                                AdMostBiddingManager.this.bidSuccess(bannerAdapter, str2, d);
                            }
                        });
                    }
                }, 10);
            }
        } catch (Exception e) {
            bidFail(adMostBannerResponseItem, str, AdMostBiddingEventListener.ERROR_UNKNOWN_REASON);
            e.printStackTrace();
        }
    }

    private void bidForFullScreen(AdMostBannerResponseItem adMostBannerResponseItem, String str, AdMostBiddingEventListener adMostBiddingEventListener) {
        try {
            int fullScreenAdapterStatus = AdMostAdNetworkManager.getInstance().getFullScreenAdapterStatus(adMostBannerResponseItem, false);
            if (fullScreenAdapterStatus != 0) {
                bidFail(adMostBannerResponseItem, str, fullScreenAdapterStatus + "");
                return;
            }
            final AdMostFullScreenInterface fullScreenAdapter = AdMostAdNetworkManager.getInstance().getFullScreenAdapter(adMostBannerResponseItem, false, true);
            if (fullScreenAdapter == null) {
                bidFail(adMostBannerResponseItem, str, AdMostBiddingEventListener.ERROR_STATUS_CHANGED);
            } else if (!addSingletonArray(fullScreenAdapter)) {
                bidFail(adMostBannerResponseItem, str, AdMostBiddingEventListener.ERROR_SINGLETON);
            } else if (AdMostAdNetworkManager.getInstance().getInitAdapter(adMostBannerResponseItem).hasInitializationError) {
                removeFromSingletonArray(fullScreenAdapter);
                bidFail(adMostBannerResponseItem, str, AdMostBiddingEventListener.ERROR_INITIALIZATION_ERROR);
            } else {
                final AdMostBiddingEventListener adMostBiddingEventListener2 = adMostBiddingEventListener;
                final AdMostBannerResponseItem adMostBannerResponseItem2 = adMostBannerResponseItem;
                final String str2 = str;
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        AdMostBiddingEventListener adMostBiddingEventListener = adMostBiddingEventListener2;
                        adMostBiddingEventListener.biddingInterface = (AdMostBiddingInterface) fullScreenAdapter;
                        AdMostBiddingManager.this.addToTimeoutList(adMostBiddingEventListener);
                        AdMostLog.m299i(AdMostBiddingManager.class.getSimpleName() + " : (" + adMostBannerResponseItem2.ZoneId + ") BIDDING request started " + adMostBannerResponseItem2.Network + " " + adMostBannerResponseItem2.Type + " " + adMostBannerResponseItem2.PlacementName + "-ecpm:" + adMostBannerResponseItem2.PureWeight);
                        AdMostImpressionManager.getInstance().setPlacementBidData(11, adMostBannerResponseItem2);
                        adMostBannerResponseItem2.WaterFallLogItem.isBidRequested = true;
                        ((AdMostBiddingInterface) fullScreenAdapter).bid(new AdMostBiddingListener() {
                            public void onFail(String str) {
                                C01052 r0 = C01052.this;
                                AdMostBiddingManager.this.removeFromSingletonArray(fullScreenAdapter);
                                C01052 r02 = C01052.this;
                                AdMostBiddingManager.this.bidFail(adMostBannerResponseItem2, str2, str);
                            }

                            public void onSuccess(double d) {
                                C01052 r0 = C01052.this;
                                AdMostBiddingManager.this.bidSuccess(fullScreenAdapter, str2, d);
                            }
                        });
                    }
                }, 10);
            }
        } catch (Exception e) {
            bidFail(adMostBannerResponseItem, str, AdMostBiddingEventListener.ERROR_UNKNOWN_REASON);
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void bidSuccess(final AdMostAdInterface adMostAdInterface, final String str, double d) {
        adMostAdInterface.getBannerResponseItem().WaterFallLogItem.isBidFill = true;
        adMostAdInterface.getBannerResponseItem().BiddingPriceFromNetworkInCent = (d * 100.0d) / adMostAdInterface.getBannerResponseItem().BidScore;
        this.handler.post(new Runnable() {
            public void run() {
                AdMostBiddingEventListener adMostBiddingEventListener = (AdMostBiddingEventListener) AdMostBiddingManager.eventListeners.get(str);
                if (adMostBiddingEventListener != null) {
                    AdMostImpressionManager.getInstance().setPlacementBidData(14, adMostAdInterface.getBannerResponseItem());
                    adMostBiddingEventListener.onBiddingSuccess((AdMostBiddingInterface) adMostAdInterface);
                    AdMostBiddingManager.removeFromEventListeners(adMostBiddingEventListener);
                    return;
                }
                AdMostAdInterface adMostAdInterface = adMostAdInterface;
                if (adMostAdInterface instanceof AdMostFullScreenInterface) {
                    AdMostBiddingManager.this.removeFromSingletonArray((AdMostFullScreenInterface) adMostAdInterface);
                }
            }
        });
    }

    public static AdMostBiddingManager getInstance() {
        if (biddingManagerInstance == null) {
            synchronized (lock) {
                if (biddingManagerInstance == null) {
                    biddingManagerInstance = new AdMostBiddingManager();
                }
            }
        }
        if (timeoutThread == null) {
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
                    	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
                    	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                    	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
                    */
                public void run() {
                    /*
                        r16 = this;
                        java.lang.Class<admost.sdk.AdMostBiddingManager> r1 = admost.sdk.AdMostBiddingManager.class
                        java.lang.Thread r0 = java.lang.Thread.currentThread()
                        java.lang.String r2 = "AdMostBiddingTimeoutThread"
                        r0.setName(r2)
                        r0 = 10
                        android.os.Process.setThreadPriority(r0)
                        r2 = 0
                        r4 = 100
                        r6 = r2
                        r5 = 100
                    L_0x0017:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0136 }
                        r0.<init>()     // Catch:{ Exception -> 0x0136 }
                        java.lang.String r8 = r1.getSimpleName()     // Catch:{ Exception -> 0x0136 }
                        r0.append(r8)     // Catch:{ Exception -> 0x0136 }
                        java.lang.String r8 = " : Timeout thread running"
                        r0.append(r8)     // Catch:{ Exception -> 0x0136 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0136 }
                        admost.sdk.base.AdMostLog.m301v(r0)     // Catch:{ Exception -> 0x0136 }
                        int r5 = r5 + 1
                        r0 = 0
                        if (r5 < r4) goto L_0x0055
                        long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0136 }
                        long r8 = r8 - r6
                        r10 = 10000(0x2710, double:4.9407E-320)
                        int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                        if (r12 >= 0) goto L_0x0050
                        java.util.ArrayList r8 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ Exception -> 0x0136 }
                        monitor-enter(r8)     // Catch:{ Exception -> 0x0136 }
                        java.util.ArrayList r9 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x004d }
                        r9.wait(r10)     // Catch:{ all -> 0x004d }
                        monitor-exit(r8)     // Catch:{ all -> 0x004d }
                        goto L_0x0050
                    L_0x004d:
                        r0 = move-exception
                        monitor-exit(r8)     // Catch:{ all -> 0x004d }
                        throw r0     // Catch:{ Exception -> 0x0136 }
                    L_0x0050:
                        long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0136 }
                        r5 = 0
                    L_0x0055:
                        java.util.ArrayList r8 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ Exception -> 0x0136 }
                        monitor-enter(r8)     // Catch:{ Exception -> 0x0136 }
                        r9 = 20000(0x4e20, double:9.8813E-320)
                        java.util.ArrayList r11 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0133 }
                    L_0x0064:
                        boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0133 }
                        if (r12 == 0) goto L_0x0078
                        java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0133 }
                        admost.sdk.listener.AdMostBiddingEventListener r12 = (admost.sdk.listener.AdMostBiddingEventListener) r12     // Catch:{ all -> 0x0133 }
                        boolean r12 = r12.waitingResponse     // Catch:{ all -> 0x0133 }
                        if (r12 != 0) goto L_0x0064
                        r11.remove()     // Catch:{ all -> 0x0133 }
                        goto L_0x0064
                    L_0x0078:
                        java.util.ArrayList r11 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        int r11 = r11.size()     // Catch:{ all -> 0x0133 }
                        if (r0 >= r11) goto L_0x00fc
                        java.util.ArrayList r11 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0133 }
                        admost.sdk.listener.AdMostBiddingEventListener r11 = (admost.sdk.listener.AdMostBiddingEventListener) r11     // Catch:{ all -> 0x0133 }
                        boolean r11 = r11.waitingResponse     // Catch:{ all -> 0x0133 }
                        if (r11 == 0) goto L_0x00db
                        java.util.ArrayList r11 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0133 }
                        admost.sdk.listener.AdMostBiddingEventListener r11 = (admost.sdk.listener.AdMostBiddingEventListener) r11     // Catch:{ all -> 0x0133 }
                        boolean r11 = r11.failedOnce     // Catch:{ all -> 0x0133 }
                        if (r11 != 0) goto L_0x00db
                        java.util.ArrayList r11 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0133 }
                        admost.sdk.listener.AdMostBiddingEventListener r11 = (admost.sdk.listener.AdMostBiddingEventListener) r11     // Catch:{ all -> 0x0133 }
                        long r11 = r11.timeoutAt     // Catch:{ all -> 0x0133 }
                        long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0133 }
                        int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                        if (r15 >= 0) goto L_0x00db
                        java.util.ArrayList r11 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0133 }
                        admost.sdk.listener.AdMostBiddingEventListener r11 = (admost.sdk.listener.AdMostBiddingEventListener) r11     // Catch:{ all -> 0x0133 }
                        java.util.ArrayList r12 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        java.lang.Object r12 = r12.get(r0)     // Catch:{ all -> 0x0133 }
                        admost.sdk.listener.AdMostBiddingEventListener r12 = (admost.sdk.listener.AdMostBiddingEventListener) r12     // Catch:{ all -> 0x0133 }
                        admost.sdk.model.AdMostBannerResponseItem r12 = r12.responseItem     // Catch:{ all -> 0x0133 }
                        java.lang.String r13 = "ERROR_REQUEST_TIMEOUT"
                        r11.onBiddingFail(r12, r13)     // Catch:{ all -> 0x0133 }
                        java.util.ArrayList r11 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0133 }
                        admost.sdk.listener.AdMostBiddingEventListener r11 = (admost.sdk.listener.AdMostBiddingEventListener) r11     // Catch:{ all -> 0x0133 }
                        admost.sdk.AdMostBiddingManager.removeFromEventListeners(r11)     // Catch:{ all -> 0x0133 }
                        goto L_0x00f8
                    L_0x00db:
                        java.util.ArrayList r11 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0133 }
                        admost.sdk.listener.AdMostBiddingEventListener r11 = (admost.sdk.listener.AdMostBiddingEventListener) r11     // Catch:{ all -> 0x0133 }
                        long r11 = r11.timeoutAt     // Catch:{ all -> 0x0133 }
                        r13 = 10
                        long r11 = r11 + r13
                        long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0133 }
                        long r11 = r11 - r13
                        int r13 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                        if (r13 <= 0) goto L_0x00f8
                        int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                        if (r13 >= 0) goto L_0x00f8
                        r9 = r11
                    L_0x00f8:
                        int r0 = r0 + 1
                        goto L_0x0078
                    L_0x00fc:
                        java.util.ArrayList r0 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        int r0 = r0.size()     // Catch:{ all -> 0x0133 }
                        if (r0 > 0) goto L_0x010e
                        java.util.ArrayList r0 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        r0.wait()     // Catch:{ all -> 0x0133 }
                        goto L_0x0130
                    L_0x010e:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
                        r0.<init>()     // Catch:{ all -> 0x0133 }
                        java.lang.String r11 = r1.getSimpleName()     // Catch:{ all -> 0x0133 }
                        r0.append(r11)     // Catch:{ all -> 0x0133 }
                        java.lang.String r11 = " : Timeout Thread Wait For Next : "
                        r0.append(r11)     // Catch:{ all -> 0x0133 }
                        r0.append(r9)     // Catch:{ all -> 0x0133 }
                        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0133 }
                        admost.sdk.base.AdMostLog.m301v(r0)     // Catch:{ all -> 0x0133 }
                        java.util.ArrayList r0 = admost.sdk.AdMostBiddingManager.timeoutList     // Catch:{ all -> 0x0133 }
                        r0.wait(r9)     // Catch:{ all -> 0x0133 }
                    L_0x0130:
                        monitor-exit(r8)     // Catch:{ all -> 0x0133 }
                        goto L_0x0017
                    L_0x0133:
                        r0 = move-exception
                        monitor-exit(r8)     // Catch:{ all -> 0x0133 }
                        throw r0     // Catch:{ Exception -> 0x0136 }
                    L_0x0136:
                        r0 = move-exception
                        r0.printStackTrace()
                        goto L_0x0017
                    */
                    throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostBiddingManager.C01041.run():void");
                }
            });
            timeoutThread = thread;
            thread.setName("AdMostBiddingTimeoutThread");
            timeoutThread.start();
        }
        return biddingManagerInstance;
    }

    private String getSingletonKey(AdMostFullScreenInterface adMostFullScreenInterface) {
        if (adMostFullScreenInterface == null) {
            return "";
        }
        try {
            if (adMostFullScreenInterface.isSingleton) {
                if (adMostFullScreenInterface.mBannerResponseItem != null) {
                    if (adMostFullScreenInterface.isSingletonForIntAndRewardedBoth) {
                        return adMostFullScreenInterface.mBannerResponseItem.Network;
                    }
                    if (adMostFullScreenInterface.mBannerResponseItem.Network.equals(AdMostAdNetwork.ADMOB)) {
                        if (adMostFullScreenInterface.mBannerResponseItem.Type.equals("video") && (adMostFullScreenInterface instanceof AdMostAdmobFullScreenAdapter)) {
                            return adMostFullScreenInterface.mBannerResponseItem.Network + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostFullScreenInterface.mBannerResponseItem.Type;
                        }
                    }
                    if (adMostFullScreenInterface.isSingletonForPlacement) {
                        return adMostFullScreenInterface.mBannerResponseItem.Network + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostFullScreenInterface.mBannerResponseItem.Type + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostFullScreenInterface.mBannerResponseItem.AdSpaceId;
                    }
                    return adMostFullScreenInterface.mBannerResponseItem.Network + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostFullScreenInterface.mBannerResponseItem.Type;
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void removeFromEventListeners(AdMostBiddingEventListener adMostBiddingEventListener) {
        synchronized (AdMostBiddingManager.class) {
            synchronized (lock3) {
                eventListeners.remove(String.valueOf(adMostBiddingEventListener.hashCode()));
            }
        }
    }

    public void appendTestData(JSONObject jSONObject) {
    }

    /* access modifiers changed from: package-private */
    public void bid(AdMostBannerResponseItem adMostBannerResponseItem, boolean z, AdMostBiddingEventListener adMostBiddingEventListener) {
        String valueOf = String.valueOf(adMostBiddingEventListener.hashCode());
        addToEventListeners(adMostBiddingEventListener);
        if (z) {
            bidForFullScreen(adMostBannerResponseItem, valueOf, adMostBiddingEventListener);
        } else {
            bidForBanner(adMostBannerResponseItem, valueOf, adMostBiddingEventListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void destroyBidding(String str) {
        AdMostLog.m294d(AdMostBiddingManager.class.getSimpleName() + " : Destroy Bidding HASH: " + str);
        synchronized (lock3) {
            Iterator<String> it = eventListeners.keySet().iterator();
            while (it.hasNext()) {
                try {
                    AdMostBiddingEventListener adMostBiddingEventListener = eventListeners.get(it.next());
                    if (adMostBiddingEventListener != null && adMostBiddingEventListener.advId.equals(str)) {
                        it.remove();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFromSingletonArray(AdMostFullScreenInterface adMostFullScreenInterface) {
        synchronized (lock2) {
            this.singletonWaitingResponse.remove(getSingletonKey(adMostFullScreenInterface));
        }
    }

    public void sendLossNotice(AdMostBiddingInterface adMostBiddingInterface, double d, int i) {
        if (adMostBiddingInterface != null) {
            if (adMostBiddingInterface instanceof AdMostAdInterface) {
                AdMostAdInterface adMostAdInterface = (AdMostAdInterface) adMostBiddingInterface;
                if (adMostAdInterface.getBannerResponseItem() != null) {
                    AdMostLog.m299i("Bidding sendLossNotice : " + adMostAdInterface.getBannerResponseItem().Network + " - reason : " + i + " - clearingPrice : " + d);
                }
            }
            adMostBiddingInterface.sendLossNotice(d, i);
        }
    }

    public void sendWinNotice(AdMostBiddingInterface adMostBiddingInterface, double d) {
        if (adMostBiddingInterface != null) {
            if (adMostBiddingInterface instanceof AdMostAdInterface) {
                AdMostAdInterface adMostAdInterface = (AdMostAdInterface) adMostBiddingInterface;
                if (adMostAdInterface.getBannerResponseItem() != null) {
                    AdMostLog.m299i("Bidding sendWinNotice : " + adMostAdInterface.getBannerResponseItem().Network + " - clearingPrice : " + d);
                }
            }
            adMostBiddingInterface.sendWinNotice(d);
        }
    }
}
