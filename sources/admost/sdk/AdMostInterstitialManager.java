package admost.sdk;

import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostImpressionManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostUtil;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostInterstitialEventListener;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.networkadapter.AdMostAdmobFullScreenAdapter;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class AdMostInterstitialManager {
    private static AdMostInterstitialManager interstitialManagerInstance;
    private static final Object lock = new Object();
    private static final Object lock2 = new Object();
    /* access modifiers changed from: private */
    public static final ArrayList<AdMostInterstitialEventListener> timeoutList = new ArrayList<>();
    private static Thread timeoutThread;
    private ConcurrentHashMap<String, String> eventListenerMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, AdMostInterstitialEventListener> eventListeners = new ConcurrentHashMap<>();
    private Handler handler = new Handler(Looper.getMainLooper());
    ConcurrentHashMap<String, Integer> networkRequestCounts = new ConcurrentHashMap<>();
    private ArrayList<String> singletonWaitingResponse = new ArrayList<>();

    private boolean addSingletonArray(AdMostFullScreenInterface adMostFullScreenInterface) {
        String singletonKey = getSingletonKey(adMostFullScreenInterface);
        if (singletonKey.equals("")) {
            return true;
        }
        synchronized (lock2) {
            if (this.singletonWaitingResponse.contains(singletonKey)) {
                AdMostLog.m294d(AdMostInterstitialManager.class.getSimpleName() + " : Interstitial request stopped because of SINGLETON " + adMostFullScreenInterface.mBannerResponseItem.Network + " " + adMostFullScreenInterface.mBannerResponseItem.Type);
                return false;
            }
            this.singletonWaitingResponse.add(singletonKey);
            return true;
        }
    }

    private void addToEventListenerMap(String str, String str2) {
        if (!str.equals(str2)) {
            this.eventListenerMap.put(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public void clicked(final AdMostBannerResponseItem adMostBannerResponseItem, final String str) {
        this.handler.post(new Runnable() {
            public void run() {
                AdMostInterstitialEventListener access$800 = AdMostInterstitialManager.this.getMainEventListener(str);
                if (access$800 != null) {
                    access$800.onClick(adMostBannerResponseItem);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void closed(final AdMostFullScreenInterface adMostFullScreenInterface, final String str) {
        removeFromSingletonArray(adMostFullScreenInterface);
        this.handler.post(new Runnable() {
            public void run() {
                AdMostInterstitialEventListener access$800 = AdMostInterstitialManager.this.getMainEventListener(str);
                if (access$800 != null) {
                    access$800.onDismiss(adMostFullScreenInterface.mBannerResponseItem);
                }
                AdMostInterstitialManager.this.eventListeners.remove(str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void completed(final AdMostBannerResponseItem adMostBannerResponseItem, final String str) {
        this.handler.post(new Runnable() {
            public void run() {
                AdMostInterstitialEventListener access$800 = AdMostInterstitialManager.this.getMainEventListener(str);
                if (access$800 != null) {
                    access$800.onComplete(adMostBannerResponseItem);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void failToShow(AdMostFullScreenInterface adMostFullScreenInterface, final String str) {
        removeFromSingletonArray(adMostFullScreenInterface);
        this.handler.post(new Runnable() {
            public void run() {
                AdMostInterstitialEventListener access$800 = AdMostInterstitialManager.this.getMainEventListener(str);
                if (access$800 != null) {
                    access$800.onFailToShow();
                }
                AdMostInterstitialManager.this.eventListeners.remove(str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void failed(final AdMostBannerResponseItem adMostBannerResponseItem, final String str, final int i) {
        this.handler.post(new Runnable() {
            public void run() {
                AdMostInterstitialEventListener access$800 = AdMostInterstitialManager.this.getMainEventListener(str);
                if (access$800 != null) {
                    access$800.onFail(adMostBannerResponseItem, i);
                }
            }
        });
    }

    public static AdMostInterstitialManager getInstance() {
        if (interstitialManagerInstance == null) {
            synchronized (lock) {
                if (interstitialManagerInstance == null) {
                    interstitialManagerInstance = new AdMostInterstitialManager();
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
                        java.lang.Class<admost.sdk.AdMostInterstitialManager> r1 = admost.sdk.AdMostInterstitialManager.class
                        java.lang.Thread r0 = java.lang.Thread.currentThread()
                        java.lang.String r2 = "AdMostIntTimeoutThread"
                        r0.setName(r2)
                        r0 = 10
                        android.os.Process.setThreadPriority(r0)
                        r2 = 0
                        r4 = 100
                        r6 = r2
                        r5 = 100
                    L_0x0017:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
                        r0.<init>()     // Catch:{ Exception -> 0x0130 }
                        java.lang.String r8 = r1.getSimpleName()     // Catch:{ Exception -> 0x0130 }
                        r0.append(r8)     // Catch:{ Exception -> 0x0130 }
                        java.lang.String r8 = " : Timeout thread running"
                        r0.append(r8)     // Catch:{ Exception -> 0x0130 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0130 }
                        admost.sdk.base.AdMostLog.m301v(r0)     // Catch:{ Exception -> 0x0130 }
                        int r5 = r5 + 1
                        r0 = 0
                        if (r5 < r4) goto L_0x0055
                        long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0130 }
                        long r8 = r8 - r6
                        r10 = 10000(0x2710, double:4.9407E-320)
                        int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                        if (r12 >= 0) goto L_0x0050
                        java.util.ArrayList r8 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ Exception -> 0x0130 }
                        monitor-enter(r8)     // Catch:{ Exception -> 0x0130 }
                        java.util.ArrayList r9 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x004d }
                        r9.wait(r10)     // Catch:{ all -> 0x004d }
                        monitor-exit(r8)     // Catch:{ all -> 0x004d }
                        goto L_0x0050
                    L_0x004d:
                        r0 = move-exception
                        monitor-exit(r8)     // Catch:{ all -> 0x004d }
                        throw r0     // Catch:{ Exception -> 0x0130 }
                    L_0x0050:
                        long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0130 }
                        r5 = 0
                    L_0x0055:
                        java.util.ArrayList r8 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ Exception -> 0x0130 }
                        monitor-enter(r8)     // Catch:{ Exception -> 0x0130 }
                        r9 = 20000(0x4e20, double:9.8813E-320)
                        java.util.ArrayList r11 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x012d }
                    L_0x0064:
                        boolean r12 = r11.hasNext()     // Catch:{ all -> 0x012d }
                        if (r12 == 0) goto L_0x0080
                        java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x012d }
                        admost.sdk.listener.AdMostInterstitialEventListener r12 = (admost.sdk.listener.AdMostInterstitialEventListener) r12     // Catch:{ all -> 0x012d }
                        boolean r13 = r12.waitingResponse     // Catch:{ all -> 0x012d }
                        if (r13 == 0) goto L_0x007c
                        boolean r13 = r12.failedOnce     // Catch:{ all -> 0x012d }
                        if (r13 != 0) goto L_0x007c
                        boolean r12 = r12.isTimeoutFail     // Catch:{ all -> 0x012d }
                        if (r12 == 0) goto L_0x0064
                    L_0x007c:
                        r11.remove()     // Catch:{ all -> 0x012d }
                        goto L_0x0064
                    L_0x0080:
                        java.util.ArrayList r11 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        int r11 = r11.size()     // Catch:{ all -> 0x012d }
                        if (r0 >= r11) goto L_0x00f6
                        java.util.ArrayList r11 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x012d }
                        admost.sdk.listener.AdMostInterstitialEventListener r11 = (admost.sdk.listener.AdMostInterstitialEventListener) r11     // Catch:{ all -> 0x012d }
                        boolean r11 = r11.waitingResponse     // Catch:{ all -> 0x012d }
                        if (r11 == 0) goto L_0x00d6
                        java.util.ArrayList r11 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x012d }
                        admost.sdk.listener.AdMostInterstitialEventListener r11 = (admost.sdk.listener.AdMostInterstitialEventListener) r11     // Catch:{ all -> 0x012d }
                        boolean r11 = r11.failedOnce     // Catch:{ all -> 0x012d }
                        if (r11 != 0) goto L_0x00d6
                        java.util.ArrayList r11 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x012d }
                        admost.sdk.listener.AdMostInterstitialEventListener r11 = (admost.sdk.listener.AdMostInterstitialEventListener) r11     // Catch:{ all -> 0x012d }
                        long r11 = r11.timeoutAt     // Catch:{ all -> 0x012d }
                        long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x012d }
                        int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                        if (r15 >= 0) goto L_0x00d6
                        java.util.ArrayList r11 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x012d }
                        admost.sdk.listener.AdMostInterstitialEventListener r11 = (admost.sdk.listener.AdMostInterstitialEventListener) r11     // Catch:{ all -> 0x012d }
                        java.util.ArrayList r12 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        java.lang.Object r12 = r12.get(r0)     // Catch:{ all -> 0x012d }
                        admost.sdk.listener.AdMostInterstitialEventListener r12 = (admost.sdk.listener.AdMostInterstitialEventListener) r12     // Catch:{ all -> 0x012d }
                        admost.sdk.model.AdMostBannerResponseItem r12 = r12.responseItem     // Catch:{ all -> 0x012d }
                        r13 = 8
                        r11.onFail(r12, r13)     // Catch:{ all -> 0x012d }
                        goto L_0x00f3
                    L_0x00d6:
                        java.util.ArrayList r11 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x012d }
                        admost.sdk.listener.AdMostInterstitialEventListener r11 = (admost.sdk.listener.AdMostInterstitialEventListener) r11     // Catch:{ all -> 0x012d }
                        long r11 = r11.timeoutAt     // Catch:{ all -> 0x012d }
                        r13 = 10
                        long r11 = r11 + r13
                        long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x012d }
                        long r11 = r11 - r13
                        int r13 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                        if (r13 <= 0) goto L_0x00f3
                        int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                        if (r13 >= 0) goto L_0x00f3
                        r9 = r11
                    L_0x00f3:
                        int r0 = r0 + 1
                        goto L_0x0080
                    L_0x00f6:
                        java.util.ArrayList r0 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        int r0 = r0.size()     // Catch:{ all -> 0x012d }
                        if (r0 > 0) goto L_0x0108
                        java.util.ArrayList r0 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        r0.wait()     // Catch:{ all -> 0x012d }
                        goto L_0x012a
                    L_0x0108:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x012d }
                        r0.<init>()     // Catch:{ all -> 0x012d }
                        java.lang.String r11 = r1.getSimpleName()     // Catch:{ all -> 0x012d }
                        r0.append(r11)     // Catch:{ all -> 0x012d }
                        java.lang.String r11 = " : Timeout Thread Wait For Next : "
                        r0.append(r11)     // Catch:{ all -> 0x012d }
                        r0.append(r9)     // Catch:{ all -> 0x012d }
                        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x012d }
                        admost.sdk.base.AdMostLog.m301v(r0)     // Catch:{ all -> 0x012d }
                        java.util.ArrayList r0 = admost.sdk.AdMostInterstitialManager.timeoutList     // Catch:{ all -> 0x012d }
                        r0.wait(r9)     // Catch:{ all -> 0x012d }
                    L_0x012a:
                        monitor-exit(r8)     // Catch:{ all -> 0x012d }
                        goto L_0x0017
                    L_0x012d:
                        r0 = move-exception
                        monitor-exit(r8)     // Catch:{ all -> 0x012d }
                        throw r0     // Catch:{ Exception -> 0x0130 }
                    L_0x0130:
                        r0 = move-exception
                        r0.printStackTrace()
                        goto L_0x0017
                    */
                    throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostInterstitialManager.C01291.run():void");
                }
            });
            timeoutThread = thread;
            thread.setName("AdMostInterstitialTimeoutThread");
            timeoutThread.start();
        }
        return interstitialManagerInstance;
    }

    /* access modifiers changed from: private */
    public AdMostInterstitialEventListener getMainEventListener(String str) {
        while (this.eventListenerMap.containsKey(str) && !this.eventListenerMap.get(str).equals(str)) {
            str = this.eventListenerMap.get(str);
        }
        return this.eventListeners.get(str);
    }

    private String getSingletonKey(AdMostFullScreenInterface adMostFullScreenInterface) {
        if (adMostFullScreenInterface == null) {
            return "";
        }
        try {
            if (!adMostFullScreenInterface.isSingleton) {
                return "";
            }
            String baseNetwork = AdMostAdNetwork.getBaseNetwork(adMostFullScreenInterface.mBannerResponseItem.Network);
            if (adMostFullScreenInterface.isSingletonForIntAndRewardedBoth) {
                return adMostFullScreenInterface.mBannerResponseItem.Network;
            }
            if (baseNetwork != null) {
                if (baseNetwork.equals(AdMostAdNetwork.ADMOB) && adMostFullScreenInterface.mBannerResponseItem.Type.equals("video") && (adMostFullScreenInterface instanceof AdMostAdmobFullScreenAdapter)) {
                    return baseNetwork + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostFullScreenInterface.mBannerResponseItem.Type;
                }
            }
            if (adMostFullScreenInterface.isSingletonForPlacement) {
                return adMostFullScreenInterface.mBannerResponseItem.Network + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostFullScreenInterface.mBannerResponseItem.Type + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostFullScreenInterface.mBannerResponseItem.AdSpaceId;
            }
            return adMostFullScreenInterface.mBannerResponseItem.Network + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + adMostFullScreenInterface.mBannerResponseItem.Type;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void loaded(AdMostFullScreenInterface adMostFullScreenInterface, String str) {
        AdMostImpressionManager.getInstance().setPlacementImpressionData(3, adMostFullScreenInterface.mBannerResponseItem);
        AdMostUtil.clearNffc("NFFC*" + adMostFullScreenInterface.mBannerResponseItem.ZoneId + "*" + adMostFullScreenInterface.mBannerResponseItem.PlacementId);
        returnInterstitial(adMostFullScreenInterface, str, 0);
    }

    /* access modifiers changed from: private */
    public void noFill(final AdMostFullScreenInterface adMostFullScreenInterface, final String str) {
        AdMostUtil.keepFrequencyCapping("NFFC*" + adMostFullScreenInterface.mBannerResponseItem.ZoneId + "*" + adMostFullScreenInterface.mBannerResponseItem.PlacementId);
        removeFromSingletonArray(adMostFullScreenInterface);
        AdMostImpressionManager.getInstance().setPlacementImpressionData(5, adMostFullScreenInterface.mBannerResponseItem);
        this.handler.post(new Runnable() {
            public void run() {
                AdMostInterstitialEventListener access$800 = AdMostInterstitialManager.this.getMainEventListener(str);
                if (access$800 != null) {
                    access$800.onFail(adMostFullScreenInterface.mBannerResponseItem, 6);
                }
                AdMostInterstitialManager.this.eventListeners.remove(str);
            }
        });
    }

    private void returnInterstitial(AdMostFullScreenInterface adMostFullScreenInterface, String str, long j) {
        final String str2 = str;
        final AdMostFullScreenInterface adMostFullScreenInterface2 = adMostFullScreenInterface;
        final long j2 = j;
        this.handler.post(new Runnable() {
            public void run() {
                AdMostInterstitialEventListener access$800 = AdMostInterstitialManager.this.getMainEventListener(str2);
                if (access$800 != null) {
                    access$800.onLoad(adMostFullScreenInterface2, j2);
                } else {
                    AdMostInterstitialManager.this.removeFromSingletonArray(adMostFullScreenInterface2);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void destroyInterstitial(String str) {
        AdMostLog.m294d(AdMostInterstitialManager.class.getSimpleName() + " : Destroy Interstitial HASH: " + str);
        Iterator<String> it = this.eventListeners.keySet().iterator();
        while (it.hasNext()) {
            try {
                AdMostInterstitialEventListener adMostInterstitialEventListener = this.eventListeners.get(it.next());
                if (adMostInterstitialEventListener != null && adMostInterstitialEventListener.interstitialHash.equals(str)) {
                    it.remove();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bc A[Catch:{ Exception -> 0x0138 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getInterstitial(admost.sdk.model.AdMostBannerResponseItem r12, java.lang.ref.WeakReference<android.app.Activity> r13, admost.sdk.listener.AdMostInterstitialEventListener r14, boolean r15) {
        /*
            r11 = this;
            int r0 = r14.hashCode()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, admost.sdk.listener.AdMostInterstitialEventListener> r1 = r11.eventListeners
            r1.put(r0, r14)
            admost.sdk.base.AdMostInterstitialCacheManager r1 = admost.sdk.base.AdMostInterstitialCacheManager.getInstance()
            java.lang.String r2 = r12.PlacementId
            admost.sdk.model.AdMostItem r1 = r1.getFromCache(r2)
            r8 = 1
            r9 = 0
            if (r1 == 0) goto L_0x0067
            admost.sdk.model.AdMostWaterfallLog r13 = r12.WaterFallLogItem
            r13.isCached = r8
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.Class<admost.sdk.AdMostInterstitialManager> r14 = admost.sdk.AdMostInterstitialManager.class
            java.lang.String r14 = r14.getSimpleName()
            r13.append(r14)
            java.lang.String r14 = " : Interstitial Response from CACHE : "
            r13.append(r14)
            java.lang.String r14 = r12.Network
            r13.append(r14)
            java.lang.String r14 = " "
            r13.append(r14)
            java.lang.String r12 = r12.Type
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            admost.sdk.base.AdMostLog.m294d(r12)
            java.lang.String r12 = r1.oldEventListener
            r11.addToEventListenerMap(r12, r0)
            java.lang.Object r12 = r1.getAd()
            if (r12 == 0) goto L_0x0060
            java.lang.Object r12 = r1.getAd()
            if (r12 == 0) goto L_0x0060
            java.lang.Object r12 = r1.getAd()
            admost.sdk.interfaces.AdMostFullScreenInterface r12 = (admost.sdk.interfaces.AdMostFullScreenInterface) r12
            goto L_0x0061
        L_0x0060:
            r12 = 0
        L_0x0061:
            long r13 = r1.expiresAt
            r11.returnInterstitial(r12, r0, r13)
            return r9
        L_0x0067:
            admost.sdk.base.AdMost r1 = admost.sdk.base.AdMost.getInstance()     // Catch:{ Exception -> 0x0138 }
            admost.sdk.base.AdMostConfiguration r1 = r1.getConfiguration()     // Catch:{ Exception -> 0x0138 }
            if (r1 == 0) goto L_0x0084
            admost.sdk.base.AdMost r1 = admost.sdk.base.AdMost.getInstance()     // Catch:{ Exception -> 0x0138 }
            admost.sdk.base.AdMostConfiguration r1 = r1.getConfiguration()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r2 = r12.Network     // Catch:{ Exception -> 0x0138 }
            java.lang.String r3 = r12.ZoneId     // Catch:{ Exception -> 0x0138 }
            boolean r4 = r12.IsFirstRequestForNetwork     // Catch:{ Exception -> 0x0138 }
            int r15 = r1.getMaxRequestPerWaterfall(r2, r3, r15, r4)     // Catch:{ Exception -> 0x0138 }
            goto L_0x0085
        L_0x0084:
            r15 = 0
        L_0x0085:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r1.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r2 = r12.Network     // Catch:{ Exception -> 0x0138 }
            r1.append(r2)     // Catch:{ Exception -> 0x0138 }
            if (r14 == 0) goto L_0x0094
            java.lang.String r2 = r14.waitingInterstitialWaterfallKey     // Catch:{ Exception -> 0x0138 }
            goto L_0x0096
        L_0x0094:
            java.lang.String r2 = "1"
        L_0x0096:
            r1.append(r2)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0138 }
            if (r15 <= 0) goto L_0x00f0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r2 = r11.networkRequestCounts     // Catch:{ Exception -> 0x0138 }
            if (r2 == 0) goto L_0x00b9
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r2 = r11.networkRequestCounts     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0138 }
            if (r2 != 0) goto L_0x00ac
            goto L_0x00b9
        L_0x00ac:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r2 = r11.networkRequestCounts     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0138 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0138 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0138 }
            goto L_0x00ba
        L_0x00b9:
            r2 = 0
        L_0x00ba:
            if (r2 < r15) goto L_0x00f1
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r13.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r14 = "AdMost Interstitial Manager : "
            r13.append(r14)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r14 = r12.Network     // Catch:{ Exception -> 0x0138 }
            r13.append(r14)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r14 = " Network request blocked because of network request limit. Item Key: "
            r13.append(r14)     // Catch:{ Exception -> 0x0138 }
            r13.append(r1)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r14 = " , current: "
            r13.append(r14)     // Catch:{ Exception -> 0x0138 }
            r13.append(r2)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r14 = " , limit: "
            r13.append(r14)     // Catch:{ Exception -> 0x0138 }
            r13.append(r15)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0138 }
            admost.sdk.base.AdMostLog.m299i(r13)     // Catch:{ Exception -> 0x0138 }
            r13 = 9
            r11.failed(r12, r0, r13)     // Catch:{ Exception -> 0x0138 }
            return r9
        L_0x00f0:
            r2 = 0
        L_0x00f1:
            admost.sdk.base.AdMostAdNetworkManager r3 = admost.sdk.base.AdMostAdNetworkManager.getInstance()     // Catch:{ Exception -> 0x0138 }
            int r3 = r3.getFullScreenAdapterStatus(r12, r9)     // Catch:{ Exception -> 0x0138 }
            if (r3 == 0) goto L_0x00ff
            r11.failed(r12, r0, r3)     // Catch:{ Exception -> 0x0138 }
            goto L_0x0140
        L_0x00ff:
            admost.sdk.base.AdMostAdNetworkManager r3 = admost.sdk.base.AdMostAdNetworkManager.getInstance()     // Catch:{ Exception -> 0x0138 }
            admost.sdk.interfaces.AdMostFullScreenInterface r6 = r3.getFullScreenAdapter(r12, r9, r9)     // Catch:{ Exception -> 0x0138 }
            if (r6 != 0) goto L_0x010e
            r13 = 4
            r11.failed(r12, r0, r13)     // Catch:{ Exception -> 0x0138 }
            return r9
        L_0x010e:
            boolean r3 = r11.addSingletonArray(r6)     // Catch:{ Exception -> 0x0138 }
            if (r3 != 0) goto L_0x0119
            r13 = 5
            r11.failed(r12, r0, r13)     // Catch:{ Exception -> 0x0138 }
            return r9
        L_0x0119:
            if (r15 <= 0) goto L_0x0125
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r15 = r11.networkRequestCounts     // Catch:{ Exception -> 0x0138 }
            int r2 = r2 + r8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0138 }
            r15.put(r1, r2)     // Catch:{ Exception -> 0x0138 }
        L_0x0125:
            android.os.Handler r15 = r11.handler     // Catch:{ Exception -> 0x0138 }
            admost.sdk.AdMostInterstitialManager$2 r10 = new admost.sdk.AdMostInterstitialManager$2     // Catch:{ Exception -> 0x0138 }
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r0
            r5 = r14
            r7 = r13
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0138 }
            long r13 = r14.requestInterval     // Catch:{ Exception -> 0x0138 }
            r15.postDelayed(r10, r13)     // Catch:{ Exception -> 0x0138 }
            return r8
        L_0x0138:
            r13 = move-exception
            r14 = 7
            r11.failed(r12, r0, r14)
            r13.printStackTrace()
        L_0x0140:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.AdMostInterstitialManager.getInterstitial(admost.sdk.model.AdMostBannerResponseItem, java.lang.ref.WeakReference, admost.sdk.listener.AdMostInterstitialEventListener, boolean):boolean");
    }

    public boolean isInSingletonArray(AdMostFullScreenInterface adMostFullScreenInterface) {
        String singletonKey = getSingletonKey(adMostFullScreenInterface);
        if (singletonKey.equals("")) {
            return false;
        }
        synchronized (lock2) {
            if (this.singletonWaitingResponse.contains(singletonKey)) {
                return true;
            }
            return false;
        }
    }

    public void removeEventListener(String str) {
        this.eventListeners.remove(str);
    }

    /* access modifiers changed from: protected */
    public void removeFromSingletonArray(AdMostFullScreenInterface adMostFullScreenInterface) {
        synchronized (lock2) {
            this.singletonWaitingResponse.remove(getSingletonKey(adMostFullScreenInterface));
        }
    }
}
