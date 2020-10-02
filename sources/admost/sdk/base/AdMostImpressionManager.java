package admost.sdk.base;

import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostNetworkItem;
import android.content.Context;
import android.os.Process;
import com.tapjoy.TapjoyConstants;
import com.vungle.warren.AdLoader;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class AdMostImpressionManager {
    private static final int IMPRESSION_ITEM_COUNT = 17;
    private static AdMostImpressionManager instance;
    private static final Object lock = new Object();
    /* access modifiers changed from: private */
    public boolean callCampaignTracker = true;
    /* access modifiers changed from: private */
    public int errorCount = 0;
    private final ConcurrentHashMap<String, int[]> impressionKeeper = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public long lastImpressionSentAt = 0;
    /* access modifiers changed from: private */
    public long launchWait = TapjoyConstants.TIMER_INCREMENT;
    /* access modifiers changed from: private */
    public long period = ((long) (AdMost.getInstance().getImpressionSendPeriod() * 1000));
    /* access modifiers changed from: private */
    public boolean sendingImpression;
    /* access modifiers changed from: private */
    public long serviceStartedAt = 0;
    private Vector<String> sessionRequestedNetworkList = new Vector<>();
    private Vector<String> sessionRequestedZoneList = new Vector<>();
    private Thread thread;

    static /* synthetic */ int access$008(AdMostImpressionManager adMostImpressionManager) {
        int i = adMostImpressionManager.errorCount;
        adMostImpressionManager.errorCount = i + 1;
        return i;
    }

    public static AdMostImpressionManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostImpressionManager();
                }
            }
        }
        return instance;
    }

    public boolean isNetworksFirstRequestForSession(String str) {
        return !this.sessionRequestedNetworkList.contains(str);
    }

    public boolean isZoneFirstRequestForSession(String str) {
        return !this.sessionRequestedZoneList.contains(str);
    }

    /* access modifiers changed from: package-private */
    public void sendImpression() {
        sendImpression(false);
    }

    public void setNetworkRequested(String str) {
        this.sessionRequestedNetworkList.add(str);
    }

    public void setPlacementBidData(int i, AdMostBannerResponseItem adMostBannerResponseItem) {
        String str;
        if (adMostBannerResponseItem != null && (str = adMostBannerResponseItem.Network) != null && !str.equals(AdMostAdNetwork.NO_NETWORK)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("BID*");
                sb.append(adMostBannerResponseItem.Type.equals(AdMostAdType.NATIVE_INSTALL) ? "native" : adMostBannerResponseItem.Type);
                sb.append("*");
                sb.append(adMostBannerResponseItem.PlacementId);
                sb.append("**");
                sb.append(adMostBannerResponseItem.ZoneType);
                sb.append("*");
                sb.append(adMostBannerResponseItem.Network);
                String sb2 = sb.toString();
                synchronized (this.impressionKeeper) {
                    int[] iArr = this.impressionKeeper.containsKey(sb2) ? this.impressionKeeper.get(sb2) : new int[17];
                    if (i == 2) {
                        if (adMostBannerResponseItem.IsBiddingItem) {
                            double d = (double) iArr[7];
                            double d2 = adMostBannerResponseItem.BiddingPriceFromNetworkInCent * 100.0d;
                            Double.isNaN(d);
                            iArr[7] = (int) (d + d2);
                        }
                    } else if (i == 14) {
                        double d3 = (double) iArr[14];
                        double d4 = adMostBannerResponseItem.BiddingPriceFromNetworkInCent * 100.0d;
                        Double.isNaN(d3);
                        iArr[14] = (int) (d3 + d4);
                    }
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                    this.impressionKeeper.put(sb2, iArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setPlacementImpressionData(int i, AdMostBannerResponseItem adMostBannerResponseItem) {
        String str;
        if (adMostBannerResponseItem != null && (str = adMostBannerResponseItem.Network) != null && !str.equals(AdMostAdNetwork.NO_NETWORK)) {
            if (i == 5) {
                AdMostFloorPriceManager.getInstance().setNoFill(adMostBannerResponseItem);
            } else if (i == 3) {
                AdMostFloorPriceManager.getInstance().setFill(adMostBannerResponseItem);
            }
            if (i == 1) {
                AdMostExperimentManager.getInstance().keepZoneNetworkFirstRequest(adMostBannerResponseItem.ZoneId, adMostBannerResponseItem.Network, false);
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("PLACEMENT*");
                sb.append(adMostBannerResponseItem.Type.equals(AdMostAdType.NATIVE_INSTALL) ? "native" : adMostBannerResponseItem.Type);
                sb.append("*");
                sb.append(adMostBannerResponseItem.PlacementId);
                sb.append("**");
                sb.append(adMostBannerResponseItem.ZoneType);
                sb.append("*");
                sb.append(adMostBannerResponseItem.Network);
                String sb2 = sb.toString();
                synchronized (this.impressionKeeper) {
                    int[] iArr = this.impressionKeeper.containsKey(sb2) ? this.impressionKeeper.get(sb2) : new int[17];
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                    if (i == 2) {
                        iArr[5] = iArr[5] + adMostBannerResponseItem.PureWeight;
                    }
                    if (i == 9) {
                        iArr[9] = iArr[9] + adMostBannerResponseItem.CompletionReward;
                    }
                    this.impressionKeeper.put(sb2, iArr);
                }
                if (i == 4) {
                    AdMostUserDataManager.getInstance().setAdsData(adMostBannerResponseItem.SubZoneType, (double) adMostBannerResponseItem.PureWeight, i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setPlacementTagData(int i, String str, AdMostBannerResponseItem adMostBannerResponseItem) {
        try {
            String str2 = "TAG*" + adMostBannerResponseItem.PlacementId + "*" + str;
            synchronized (this.impressionKeeper) {
                int[] iArr = this.impressionKeeper.containsKey(str2) ? this.impressionKeeper.get(str2) : new int[17];
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
                if (i == 9) {
                    iArr[9] = iArr[9] + adMostBannerResponseItem.CompletionReward;
                }
                this.impressionKeeper.put(str2, iArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setZoneImpressionData(int i, String str, int i2, String str2) {
        setZoneImpressionData(i, str, i2, str2, 0);
    }

    public void setZoneRequested(String str) {
        this.sessionRequestedZoneList.add(str);
    }

    public void start(Context context) {
        AdMostPreferences.newInstance(context);
        Thread thread2 = this.thread;
        if (thread2 == null || !thread2.isAlive()) {
            this.serviceStartedAt = System.currentTimeMillis();
            Thread thread3 = new Thread(new Runnable() {
                public void run() {
                    Thread.currentThread().setName("AdMostImpThread");
                    Process.setThreadPriority(10);
                    synchronized (this) {
                        while (AdMostImpressionManager.this.errorCount <= 10) {
                            try {
                                if (AdMostImpressionManager.this.launchWait > 0) {
                                    wait(AdMostImpressionManager.this.launchWait);
                                }
                                if (AdMostPreferences.getInstance() == null || AdMost.getInstance().getConfiguration() == null || AdMostImpressionManager.this.lastImpressionSentAt >= System.currentTimeMillis() - AdLoader.RETRY_DELAY || AdMostUtil.isNetworkAvailable(AdMost.getInstance().getContext()) != 1) {
                                    wait(TapjoyConstants.TIMER_INCREMENT);
                                } else {
                                    long unused = AdMostImpressionManager.this.launchWait = 0;
                                    AdMostAdStatsManager.getInstance().sendData();
                                    AdMostImpressionManager.this.sendImpression();
                                    long unused2 = AdMostImpressionManager.this.lastImpressionSentAt = System.currentTimeMillis();
                                    if (AdMostImpressionManager.this.callCampaignTracker && AdMostImpressionManager.this.serviceStartedAt != 0) {
                                        boolean unused3 = AdMostImpressionManager.this.callCampaignTracker = false;
                                        InstallReferrerReceiver.trackCampaign(true);
                                    }
                                    wait(AdMostImpressionManager.this.period);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                AdMostImpressionManager.access$008(AdMostImpressionManager.this);
                            }
                        }
                    }
                }
            });
            this.thread = thread3;
            thread3.start();
        }
    }

    public void storeAdNetworkDataIntoSharedPrefs() {
        boolean z;
        JSONObject jSONObject = null;
        String str = "";
        try {
            synchronized (this.impressionKeeper) {
                boolean z2 = false;
                for (Map.Entry next : this.impressionKeeper.entrySet()) {
                    int[] iArr = (int[]) next.getValue();
                    String str2 = (String) next.getKey();
                    int i = 0;
                    while (true) {
                        if (i >= iArr.length) {
                            z = false;
                            break;
                        } else if (iArr[i] > 0) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z) {
                        if (!z2) {
                            str = AdMostPreferences.getInstance().getCurrentImpressionPreferenceKey();
                            jSONObject = AdMostPreferences.getInstance().getCurrentAdNetworkData(str);
                            z2 = true;
                        }
                        if (!jSONObject.has(str2)) {
                            jSONObject.put(str2, new JSONObject());
                        }
                        JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                        AdMostNetworkItem adMostNetworkItem = new AdMostNetworkItem();
                        adMostNetworkItem.setData(jSONObject2);
                        adMostNetworkItem.IMPRESSION += iArr[1];
                        adMostNetworkItem.REQUEST += iArr[0];
                        adMostNetworkItem.CLICK += iArr[3];
                        adMostNetworkItem.FILLED += iArr[2];
                        adMostNetworkItem.NO_FILL += iArr[4];
                        adMostNetworkItem.WEIGHT += iArr[5];
                        adMostNetworkItem.FAIL_TO_SHOW += iArr.length > 6 ? iArr[6] : 0;
                        adMostNetworkItem.BID_PRICE_IMP += iArr.length > 7 ? iArr[7] : 0;
                        adMostNetworkItem.COMPLETE += iArr.length > 8 ? iArr[8] : 0;
                        adMostNetworkItem.REWARD += iArr.length > 9 ? iArr[9] : 0;
                        adMostNetworkItem.BID_REQUEST += iArr.length > 10 ? iArr[10] : 0;
                        adMostNetworkItem.BID_WON += iArr.length > 11 ? iArr[11] : 0;
                        adMostNetworkItem.BID_TIMEOUT += iArr.length > 12 ? iArr[12] : 0;
                        adMostNetworkItem.BID_FILL += iArr.length > 13 ? iArr[13] : 0;
                        adMostNetworkItem.BID_PRICE_FILL += iArr.length > 14 ? iArr[14] : 0;
                        adMostNetworkItem.BID_FAIL_TO_LOAD += iArr.length > 15 ? iArr[15] : 0;
                        adMostNetworkItem.BID_WON_ZONE += iArr.length > 16 ? iArr[16] : 0;
                        jSONObject.put(str2, adMostNetworkItem.getData());
                        next.setValue(new int[17]);
                    }
                }
                if (z2) {
                    AdMostPreferences.getInstance().storeAdNetworkData(str, jSONObject.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x03ed, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x03ee, code lost:
        r1 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03f1, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x041e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0420, code lost:
        r1 = r33;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:11:0x0030, B:125:0x03f5] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x03ed A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:11:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x041e A[ExcHandler: Exception (e java.lang.Exception), PHI: r1 
      PHI: (r1v7 admost.sdk.base.AdMostImpressionManager) = (r1v8 admost.sdk.base.AdMostImpressionManager), (r1v8 admost.sdk.base.AdMostImpressionManager), (r1v28 admost.sdk.base.AdMostImpressionManager), (r1v28 admost.sdk.base.AdMostImpressionManager) binds: [B:130:0x0401, B:131:?, B:128:0x03ff, B:129:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:128:0x03ff] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendImpression(boolean r34) {
        /*
            r33 = this;
            r7 = r33
            boolean r0 = r7.sendingImpression     // Catch:{ IllegalStateException -> 0x042c, Exception -> 0x0423 }
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 1
            r7.sendingImpression = r0     // Catch:{ IllegalStateException -> 0x042c, Exception -> 0x0423 }
            admost.sdk.base.AdMostPreferences r1 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ IllegalStateException -> 0x042c, Exception -> 0x0423 }
            org.json.JSONObject r1 = r1.getAdNetworkDataForSending()     // Catch:{ IllegalStateException -> 0x042c, Exception -> 0x0423 }
            admost.sdk.base.AdMostAnalyticsManager r2 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ IllegalStateException -> 0x042c, Exception -> 0x0423 }
            boolean r2 = r2.hasSessionPiecesToSend()     // Catch:{ IllegalStateException -> 0x042c, Exception -> 0x0423 }
            if (r1 == 0) goto L_0x0022
            int r3 = r1.length()     // Catch:{ IllegalStateException -> 0x042c, Exception -> 0x0423 }
            if (r3 > 0) goto L_0x0024
        L_0x0022:
            if (r2 == 0) goto L_0x03f5
        L_0x0024:
            java.lang.String r3 = "{\"User\":\"%s\",\"SDKVersion\":\"%s\",\"Experiment\":\"%s\",\"Group\":\"%s\",\"Sessions\":[%s],\"Placement\":[%s],\"Zone\":[%s],\"Tag\":[%s],\"Bid\":[%s]}"
            java.lang.String r4 = "{\"Impression\":%s,\"Click\":%s,\"Request\":%s,\"Filled\":%s,\"NotFilled\":%s,\"Weight\":%s,\"PlacementID\":\"%s\",\"PlacementType\":\"%s\",\"ZoneType\":\"%s\",\"Network\":\"%s\",\"FailToShow\":%s,\"Complete\":%s,\"Reward\":%s},"
            java.lang.String r5 = "{\"Impression\":%s,\"Filled\":%s,\"NotFilled\":%s,\"Request\":%s,\"ZoneID\":\"%s\",\"FailToShow\":%s,\"Complete\":%s,\"Reward\":%s},"
            java.lang.String r6 = "{\"Impression\":%s,\"PlacementID\":\"%s\",\"Tag\":\"%s\",\"Complete\":%s,\"Reward\":%s},"
            java.lang.String r9 = "{\"PlacementID\":\"%s\",\"PlacementType\":\"%s\",\"ZoneType\":\"%s\",\"Network\":\"%s\",\"PriceImp\":%f,\"Request\":%s,\"Won\":%s,\"WonZone\":%s,\"Timeout\":%s,\"Filled\":%s,\"Imp\":%s,\"PriceFilled\":%f,\"FailToLoad\":%s},"
            java.lang.String r10 = "{\"Date\":\"%s\",\"Count\":%s,\"Duration\":%s},"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r11.<init>()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r12.<init>()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r13.<init>()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r14.<init>()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r15.<init>()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r17 = 7
            r18 = 6
            java.lang.String r0 = ""
            if (r1 == 0) goto L_0x0288
            int r23 = r1.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r23 <= 0) goto L_0x0288
            java.util.Iterator r23 = r1.keys()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
        L_0x005b:
            boolean r24 = r23.hasNext()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r24 == 0) goto L_0x0288
            java.lang.Object r24 = r23.next()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r8 = r24
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r7 = "\\*"
            java.lang.String[] r7 = r8.split(r7)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            org.json.JSONObject r8 = r1.getJSONObject(r8)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r24 = r1
            admost.sdk.model.AdMostNetworkItem r1 = new admost.sdk.model.AdMostNetworkItem     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r1.<init>()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r1.setData(r8)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r8 = "ZONE"
            r26 = r0
            r25 = 0
            r0 = r7[r25]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            boolean r0 = r8.equals(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r0 == 0) goto L_0x00e2
            r0 = 1
            r7 = r7[r0]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 8
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.IMPRESSION     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r25 = 0
            r8[r25] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.FILLED     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r16 = 1
            r8[r16] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.NO_FILL     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r22 = 2
            r8[r22] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.REQUEST     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r19 = 3
            r8[r19] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 4
            r8[r0] = r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.FAIL_TO_SHOW     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r7 = 5
            r8[r7] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.COMPLETE     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r8[r18] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.REWARD     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r8[r17] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r0 = java.lang.String.format(r5, r8)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r12.append(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r30 = r3
            r27 = r5
            goto L_0x0123
        L_0x00e2:
            java.lang.String r0 = "TAG"
            r27 = r5
            r8 = 0
            r5 = r7[r8]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            boolean r0 = r0.equals(r5)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r0 == 0) goto L_0x0127
            r0 = 1
            r5 = r7[r0]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 2
            r7 = r7[r0]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 5
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.IMPRESSION     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r25 = 0
            r8[r25] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 1
            r8[r0] = r5     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 2
            r8[r0] = r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.COMPLETE     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 3
            r8[r5] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.REWARD     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r1 = 4
            r8[r1] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r0 = java.lang.String.format(r6, r8)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r14.append(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r30 = r3
        L_0x0123:
            r29 = r6
            goto L_0x027a
        L_0x0127:
            java.lang.String r0 = "PLACEMENT"
            r5 = 0
            r8 = r7[r5]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            boolean r0 = r0.equals(r8)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r28 = 10
            if (r0 == 0) goto L_0x01cd
            int r0 = r7.length     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r8 = 1
            if (r0 <= r8) goto L_0x013b
            r0 = r7[r8]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x013d
        L_0x013b:
            r0 = r26
        L_0x013d:
            int r8 = r7.length     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 2
            if (r8 <= r5) goto L_0x0144
            r8 = r7[r5]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x0146
        L_0x0144:
            r8 = r26
        L_0x0146:
            int r5 = r7.length     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r29 = r6
            r6 = 4
            if (r5 <= r6) goto L_0x014f
            r5 = r7[r6]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x0151
        L_0x014f:
            r5 = r26
        L_0x0151:
            int r6 = r7.length     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r30 = r3
            r3 = 5
            if (r6 <= r3) goto L_0x015a
            r6 = r7[r3]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x015c
        L_0x015a:
            r6 = r26
        L_0x015c:
            r3 = 13
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r7 = r1.IMPRESSION     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r25 = 0
            r3[r25] = r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r7 = r1.CLICK     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r16 = 1
            r3[r16] = r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r7 = r1.REQUEST     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r22 = 2
            r3[r22] = r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r7 = r1.FILLED     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r19 = 3
            r3[r19] = r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r7 = r1.NO_FILL     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r21 = 4
            r3[r21] = r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r7 = r1.WEIGHT     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r20 = 5
            r3[r20] = r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3[r18] = r8     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3[r17] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 8
            r3[r0] = r5     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 9
            r3[r0] = r6     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.FAIL_TO_SHOW     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3[r28] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.COMPLETE     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 11
            r3[r5] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.REWARD     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r1 = 12
            r3[r1] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r0 = java.lang.String.format(r4, r3)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r11.append(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x027a
        L_0x01cd:
            r30 = r3
            r29 = r6
            java.lang.String r0 = "BID"
            r3 = 0
            r5 = r7[r3]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            boolean r0 = r0.equals(r5)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r0 == 0) goto L_0x027a
            int r0 = r7.length     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3 = 1
            if (r0 <= r3) goto L_0x01e3
            r0 = r7[r3]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x01e5
        L_0x01e3:
            r0 = r26
        L_0x01e5:
            int r3 = r7.length     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 2
            if (r3 <= r5) goto L_0x01ec
            r3 = r7[r5]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x01ee
        L_0x01ec:
            r3 = r26
        L_0x01ee:
            int r5 = r7.length     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r6 = 4
            if (r5 <= r6) goto L_0x01f5
            r5 = r7[r6]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x01f7
        L_0x01f5:
            r5 = r26
        L_0x01f7:
            int r6 = r7.length     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r8 = 5
            if (r6 <= r8) goto L_0x01fe
            r6 = r7[r8]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x0200
        L_0x01fe:
            r6 = r26
        L_0x0200:
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r8 = 13
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r25 = 0
            r8[r25] = r3     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3 = 1
            r8[r3] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 2
            r8[r0] = r5     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = 3
            r8[r0] = r6     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.BID_PRICE_IMP     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            double r5 = (double) r0
            r31 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r31
            java.lang.Double r0 = java.lang.Double.valueOf(r5)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3 = 4
            r8[r3] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.BID_REQUEST     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3 = 5
            r8[r3] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.BID_WON     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r8[r18] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.BID_WON_ZONE     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r8[r17] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.BID_TIMEOUT     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3 = 8
            r8[r3] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.BID_FILL     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3 = 9
            r8[r3] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.IMPRESSION     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r8[r28] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.BID_PRICE_FILL     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            double r5 = (double) r0
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r31
            java.lang.Double r0 = java.lang.Double.valueOf(r5)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r3 = 11
            r8[r3] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r1.BID_FAIL_TO_LOAD     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r1 = 12
            r8[r1] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r0 = java.lang.String.format(r7, r9, r8)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r15.append(r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
        L_0x027a:
            r7 = r33
            r1 = r24
            r0 = r26
            r5 = r27
            r6 = r29
            r3 = r30
            goto L_0x005b
        L_0x0288:
            r26 = r0
            r30 = r3
            r0 = 0
            if (r2 == 0) goto L_0x02fd
            admost.sdk.base.AdMostAnalyticsManager r2 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.util.concurrent.ConcurrentHashMap r2 = r2.cumulateSessionPieces()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.util.Set r2 = r2.entrySet()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
        L_0x02a0:
            boolean r3 = r2.hasNext()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r3 == 0) goto L_0x02fd
            java.lang.Object r3 = r2.next()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Object r4 = r3.getValue()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            admost.sdk.base.AdMostAnalyticsSession r4 = (admost.sdk.base.AdMostAnalyticsSession) r4     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Object r3 = r3.getKey()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            admost.sdk.base.AdMostAnalyticsManager r5 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.text.SimpleDateFormat r5 = r5.dateFormat     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.util.Date r5 = r5.parse(r3)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            long r5 = r5.getTime()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            long r0 = java.lang.Math.max(r5, r0)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 3
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 0
            r6[r5] = r3     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r5 = r4.SessionCount     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r7 = 1
            r6[r7] = r5     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            long r7 = r4.TotalDuration     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r23 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r23
            int r5 = (int) r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r7 = 2
            r6[r7] = r5     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r5 = java.lang.String.format(r10, r6)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r13.append(r5)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            admost.sdk.base.AdMostUserDataManager r5 = admost.sdk.base.AdMostUserDataManager.getInstance()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r6 = r4.SessionCount     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            long r7 = r4.TotalDuration     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            long r7 = r7 / r23
            int r4 = (int) r7     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5.setActivityData(r3, r6, r4)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x02a0
        L_0x02fd:
            r3 = r0
            admost.sdk.base.AdMostPreferences r0 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            boolean r0 = r0.isUserRegistered()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r0 == 0) goto L_0x0311
            admost.sdk.base.AdMostAnalyticsManager r0 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r0 = r0.getUserId()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x0313
        L_0x0311:
            java.lang.String r0 = "AMRAnalyticsNotRegistered"
        L_0x0313:
            r1 = 9
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r2 = 0
            r1[r2] = r0     // Catch:{ IllegalStateException -> 0x03f2, Exception -> 0x03ed }
            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r0 = r0.getVersion()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r2 = 1
            r1[r2] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            admost.sdk.base.AdMostExperimentManager r0 = admost.sdk.base.AdMostExperimentManager.getInstance()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r0 = r0.getCurrentExperiment()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r2 = 2
            r1[r2] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            admost.sdk.base.AdMostExperimentManager r0 = admost.sdk.base.AdMostExperimentManager.getInstance()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            java.lang.String r0 = r0.getCurrentGroup()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r2 = 3
            r1[r2] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r13.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r0 <= 0) goto L_0x0351
            java.lang.String r0 = r13.toString()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r2 = r13.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 1
            int r2 = r2 - r5
            r5 = 0
            java.lang.String r0 = r0.substring(r5, r2)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x0353
        L_0x0351:
            r0 = r26
        L_0x0353:
            r2 = 4
            r1[r2] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r11.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r0 <= 0) goto L_0x036c
            java.lang.String r0 = r11.toString()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r2 = r11.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 1
            int r2 = r2 - r5
            r5 = 0
            java.lang.String r0 = r0.substring(r5, r2)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x036e
        L_0x036c:
            r0 = r26
        L_0x036e:
            r2 = 5
            r1[r2] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r12.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r0 <= 0) goto L_0x0387
            java.lang.String r0 = r12.toString()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r2 = r12.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 1
            int r2 = r2 - r5
            r5 = 0
            java.lang.String r0 = r0.substring(r5, r2)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x0389
        L_0x0387:
            r0 = r26
        L_0x0389:
            r1[r18] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r14.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r0 <= 0) goto L_0x03a1
            java.lang.String r0 = r14.toString()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r2 = r14.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 1
            int r2 = r2 - r5
            r5 = 0
            java.lang.String r0 = r0.substring(r5, r2)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x03a3
        L_0x03a1:
            r0 = r26
        L_0x03a3:
            r1[r17] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r0 = r15.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r0 <= 0) goto L_0x03bb
            java.lang.String r0 = r15.toString()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            int r2 = r15.length()     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r5 = 1
            int r2 = r2 - r5
            r5 = 0
            java.lang.String r0 = r0.substring(r5, r2)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x03bd
        L_0x03bb:
            r0 = r26
        L_0x03bd:
            r2 = 8
            r1[r2] = r0     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r0 = r30
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            if (r34 == 0) goto L_0x03cc
            admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.SEND_UNKNOWN_HOST_IMPRESSION     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            goto L_0x03ce
        L_0x03cc:
            admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.SEND_IMPRESSION     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
        L_0x03ce:
            r7 = r1
            admost.sdk.base.AdMostGenericRequest r8 = new admost.sdk.base.AdMostGenericRequest     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            admost.sdk.base.AdMostImpressionManager$2 r9 = new admost.sdk.base.AdMostImpressionManager$2     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r1 = r9
            r2 = r33
            r5 = r0
            r6 = r34
            r1.<init>(r3, r5, r6)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r1 = r26
            r8.<init>(r7, r1, r9)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r2 = 0
            r1[r2] = r0     // Catch:{ IllegalStateException -> 0x03f2, Exception -> 0x03ed }
            r8.mo611go(r1)     // Catch:{ IllegalStateException -> 0x03f1, Exception -> 0x03ed }
            r1 = r33
            goto L_0x0401
        L_0x03ed:
            r0 = move-exception
            r1 = r33
            goto L_0x0425
        L_0x03f1:
            r2 = 0
        L_0x03f2:
            r1 = r33
            goto L_0x042e
        L_0x03f5:
            admost.sdk.base.AdMostPreferences r0 = admost.sdk.base.AdMostPreferences.getInstance()     // Catch:{ IllegalStateException -> 0x0420, Exception -> 0x03ed }
            r0.removeAdNetworkData()     // Catch:{ IllegalStateException -> 0x0420, Exception -> 0x03ed }
            r2 = 0
            r1 = r33
            r1.sendingImpression = r2     // Catch:{ IllegalStateException -> 0x042e, Exception -> 0x041e }
        L_0x0401:
            admost.sdk.base.AdMostIAP r0 = admost.sdk.base.AdMostIAP.getInstance()     // Catch:{ IllegalStateException -> 0x042d, Exception -> 0x041e }
            r0.sendInAppPurchasesToServer()     // Catch:{ IllegalStateException -> 0x042d, Exception -> 0x041e }
            admost.sdk.base.AdMostSSVManager r0 = admost.sdk.base.AdMostSSVManager.getInstance()     // Catch:{ IllegalStateException -> 0x042d, Exception -> 0x041e }
            r0.sendAll()     // Catch:{ IllegalStateException -> 0x042d, Exception -> 0x041e }
            admost.sdk.base.AdMostAnalyticsManager r0 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ IllegalStateException -> 0x042d, Exception -> 0x041e }
            r0.setAdjustUserIdWithAdapter()     // Catch:{ IllegalStateException -> 0x042d, Exception -> 0x041e }
            admost.sdk.base.AdMostAnalyticsManager r0 = admost.sdk.base.AdMostAnalyticsManager.getInstance()     // Catch:{ IllegalStateException -> 0x042d, Exception -> 0x041e }
            r0.setAppsflyerUserIdWithAdapter()     // Catch:{ IllegalStateException -> 0x042d, Exception -> 0x041e }
            goto L_0x0430
        L_0x041e:
            r0 = move-exception
            goto L_0x0425
        L_0x0420:
            r1 = r33
            goto L_0x042d
        L_0x0423:
            r0 = move-exception
            r1 = r7
        L_0x0425:
            r0.printStackTrace()
            r2 = 0
            r1.sendingImpression = r2
            goto L_0x0430
        L_0x042c:
            r1 = r7
        L_0x042d:
            r2 = 0
        L_0x042e:
            r1.sendingImpression = r2
        L_0x0430:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostImpressionManager.sendImpression(boolean):void");
    }

    public void setZoneImpressionData(int i, String str, int i2, String str2, int i3) {
        try {
            String str3 = "ZONE*" + str;
            synchronized (this.impressionKeeper) {
                int[] iArr = this.impressionKeeper.containsKey(str3) ? this.impressionKeeper.get(str3) : new int[17];
                int i4 = i - 1;
                iArr[i4] = iArr[i4] + 1;
                if (i == 9) {
                    iArr[9] = iArr[9] + i3;
                }
                this.impressionKeeper.put(str3, iArr);
            }
            AdMostUserDataManager.getInstance().setAdsData(str2, (double) i2, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
