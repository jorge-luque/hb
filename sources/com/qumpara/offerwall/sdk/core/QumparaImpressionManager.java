package com.qumpara.offerwall.sdk.core;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.qumpara.analytics.QumparaAnalytics;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.tapjoy.TapjoyConstants;
import com.vungle.warren.AdLoader;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class QumparaImpressionManager {
    public static final int COUNT_TYPE_ENGAGEMENT = 3;
    public static final int COUNT_TYPE_IMPRESSION = 2;
    public static final int COUNT_TYPE_LAUNCH = 5;
    public static final int COUNT_TYPE_LOAD = 1;
    public static final int COUNT_TYPE_REDEEM = 4;
    private static final int STORED_DATA_COUNT = 5;
    private static QumparaImpressionManager instance;
    private static final Object lock = new Object();
    /* access modifiers changed from: private */
    public int errorCount = 0;
    private final ConcurrentHashMap<String, int[]> impressionKeeper = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public long lastImpressionSentAt = 0;
    /* access modifiers changed from: private */
    public long launchWait = TapjoyConstants.TIMER_INCREMENT;
    /* access modifiers changed from: private */
    public long period = 60000;
    private boolean sendingImpression;
    private Thread thread;

    public static class SharedCountData {
        public int ENGAGEMENT = 0;
        public int IMPRESSION = 0;
        public int LAUNCH = 0;
        public int LOAD = 0;
        public int REDEEM = 0;

        public JSONObject getData() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("im", this.IMPRESSION);
                jSONObject.put("ld", this.LOAD);
                jSONObject.put("rd", this.REDEEM);
                jSONObject.put("en", this.ENGAGEMENT);
                jSONObject.put("in", this.LAUNCH);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        public void setData(JSONObject jSONObject) {
            try {
                this.IMPRESSION = jSONObject.optInt("im", 0);
                this.LOAD = jSONObject.optInt("ld", 0);
                this.REDEEM = jSONObject.optInt("rd", 0);
                this.ENGAGEMENT = jSONObject.optInt("en", 0);
                this.LAUNCH = jSONObject.optInt("in", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static /* synthetic */ int access$008(QumparaImpressionManager qumparaImpressionManager) {
        int i = qumparaImpressionManager.errorCount;
        qumparaImpressionManager.errorCount = i + 1;
        return i;
    }

    public static QumparaImpressionManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new QumparaImpressionManager();
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void sendImpression() {
        int i;
        String str = "";
        try {
            if (!this.sendingImpression) {
                char c = 1;
                this.sendingImpression = true;
                JSONObject countDataForSending = QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).getCountDataForSending();
                if (countDataForSending == null || countDataForSending.length() <= 0) {
                    QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).removeCountData();
                    this.sendingImpression = false;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                char c2 = 2;
                if (countDataForSending != null && countDataForSending.length() > 0) {
                    Iterator<String> keys = countDataForSending.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String[] split = next.split("\\*");
                        JSONObject jSONObject = countDataForSending.getJSONObject(next);
                        SharedCountData sharedCountData = new SharedCountData();
                        sharedCountData.setData(jSONObject);
                        if ("CAMPAIGN".equals(split[0])) {
                            sb2.append(String.format(Locale.ENGLISH, "{\"id\":\"%s\",\"customer\":\"%s\",\"impression\":%s,\"click\":%s,\"conversion\":%s},", new Object[]{split[c], split[c2], Integer.valueOf(sharedCountData.IMPRESSION), Integer.valueOf(sharedCountData.ENGAGEMENT), Integer.valueOf(sharedCountData.REDEEM)}));
                        } else if ("APP".equals(split[0])) {
                            sb.append(String.format(Locale.ENGLISH, "\"launch\":%s,\"load\":%s,\"impression\":%s", new Object[]{Integer.valueOf(sharedCountData.LAUNCH), Integer.valueOf(sharedCountData.LOAD), Integer.valueOf(sharedCountData.IMPRESSION)}));
                        }
                        c = 1;
                        c2 = 2;
                    }
                }
                try {
                    i = QumparaOfferwall.getContext().getPackageManager().getPackageInfo(QumparaOfferwall.getContext().getPackageName(), 0).versionCode;
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[8];
                objArr[0] = QumparaOfferwallModels.Identifiers.getInstance().getApplicationId();
                objArr[1] = QumparaOfferwallModels.Identifiers.getInstance().getApplicationAdMostId();
                objArr[2] = QumparaOfferwallModels.Identifiers.getInstance().getApplicationUserId();
                objArr[3] = i + str;
                objArr[4] = QumparaOfferwall.getVersion();
                objArr[5] = Build.VERSION.SDK_INT + str;
                objArr[6] = sb.length() > 0 ? sb : "\"launch\":0";
                if (sb2.length() > 0) {
                    str = sb2.toString().substring(0, sb2.length() - 1);
                }
                objArr[7] = str;
                QumparaOfferwallAPI.postCountData(String.format(locale, "{\"application\":\"%s\",\"admostId\":\"%s\",\"appUserId\":\"%s\",\"appVersion\":\"%s\",\"sdkVersion\":\"%s\",\"osVersion\":\"%s\",%s,\"campaigns\":[%s]}", objArr));
            }
        } catch (IllegalStateException unused) {
            this.sendingImpression = false;
        } catch (Exception e2) {
            e2.printStackTrace();
            this.sendingImpression = false;
        }
    }

    private void storeDataIntoSharedPrefs() {
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
                        if (i >= 5) {
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
                            str = QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).getCurrentCountPreferenceKey();
                            jSONObject = QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).getCurrentCountData(str);
                            z2 = true;
                        }
                        if (!jSONObject.has(str2)) {
                            jSONObject.put(str2, new JSONObject());
                        }
                        JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                        SharedCountData sharedCountData = new SharedCountData();
                        sharedCountData.setData(jSONObject2);
                        sharedCountData.IMPRESSION += iArr[1];
                        sharedCountData.LOAD += iArr[0];
                        sharedCountData.ENGAGEMENT += iArr[2];
                        sharedCountData.REDEEM += iArr[3];
                        sharedCountData.LAUNCH += iArr[4];
                        jSONObject.put(str2, sharedCountData.getData());
                        next.setValue(new int[5]);
                    }
                }
                if (z2) {
                    QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).storeCountData(str, jSONObject.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementCountData(int i, String str, String str2) {
        String str3;
        if (str == null) {
            str3 = "APP*0";
        } else {
            try {
                str3 = "CAMPAIGN*" + str + "*" + str2;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        synchronized (this.impressionKeeper) {
            int[] iArr = this.impressionKeeper.containsKey(str3) ? this.impressionKeeper.get(str3) : new int[5];
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
            this.impressionKeeper.put(str3, iArr);
        }
        storeDataIntoSharedPrefs();
    }

    /* access modifiers changed from: package-private */
    public void setSendingImpressionFalse() {
        this.sendingImpression = false;
    }

    /* access modifiers changed from: package-private */
    public void start(Context context) {
        Thread thread2 = this.thread;
        if (thread2 == null || !thread2.isAlive()) {
            Thread thread3 = new Thread(new Runnable() {
                public void run() {
                    Thread.currentThread().setName("QumparaImpThread");
                    Process.setThreadPriority(10);
                    synchronized (this) {
                        while (QumparaImpressionManager.this.errorCount <= 10) {
                            try {
                                if (QumparaImpressionManager.this.launchWait > 0) {
                                    wait(QumparaImpressionManager.this.launchWait);
                                }
                                if (QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()) == null || QumparaImpressionManager.this.lastImpressionSentAt >= System.currentTimeMillis() - AdLoader.RETRY_DELAY || QumparaOfferwallUtil.isNetworkAvailable(QumparaOfferwall.getContext()) != 1) {
                                    wait(TapjoyConstants.TIMER_INCREMENT);
                                } else {
                                    long unused = QumparaImpressionManager.this.launchWait = 0;
                                    QumparaImpressionManager.this.sendImpression();
                                    QumparaAnalytics.getInstance().sendEventsToServer(QumparaOfferwall.getContext());
                                    long unused2 = QumparaImpressionManager.this.lastImpressionSentAt = System.currentTimeMillis();
                                    wait(QumparaImpressionManager.this.period);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                QumparaImpressionManager.access$008(QumparaImpressionManager.this);
                            }
                        }
                    }
                }
            });
            this.thread = thread3;
            thread3.start();
        }
    }
}
