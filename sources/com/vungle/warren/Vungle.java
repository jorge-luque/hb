package com.vungle.warren;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.tapjoy.TapjoyAuctionFlags;
import com.vungle.warren.AdConfig;
import com.vungle.warren.VungleSettings;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.Callback;
import com.vungle.warren.network.Response;
import com.vungle.warren.p074ui.contract.AdContract;
import com.vungle.warren.p074ui.view.VungleNativeView;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.FutureResult;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.TimeoutProvider;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p075d.p090g.p091a.C3218a;

@Keep
public class Vungle {
    private static final String COM_VUNGLE_SDK = "com.vungle.sdk";
    /* access modifiers changed from: private */
    public static final String TAG = Vungle.class.getCanonicalName();
    static final Vungle _instance = new Vungle();
    /* access modifiers changed from: private */
    public static CacheManager.Listener cacheListener = new CacheManager.Listener() {
        public void onCacheChanged() {
            if (Vungle._instance.context != null) {
                Vungle.stopPlaying();
                ServiceLocator instance = ServiceLocator.getInstance(Vungle._instance.context);
                CacheManager cacheManager = (CacheManager) instance.getService(CacheManager.class);
                Downloader downloader = (Downloader) instance.getService(Downloader.class);
                if (cacheManager.getCache() != null) {
                    List<DownloadRequest> allRequests = downloader.getAllRequests();
                    String path = cacheManager.getCache().getPath();
                    for (DownloadRequest next : allRequests) {
                        if (!next.path.startsWith(path)) {
                            downloader.cancel(next);
                        }
                    }
                }
                downloader.init();
            }
        }
    };
    /* access modifiers changed from: private */
    public static AtomicBoolean isDepInit = new AtomicBoolean(false);
    private static volatile boolean isInitialized;
    private static AtomicBoolean isInitializing = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public volatile String appID;
    /* access modifiers changed from: private */
    public volatile Consent ccpaStatus;
    /* access modifiers changed from: private */
    public final AtomicReference<Consent> consent = new AtomicReference<>();
    /* access modifiers changed from: private */
    public volatile String consentVersion;
    /* access modifiers changed from: private */
    public Context context;
    private Gson gson = new GsonBuilder().create();
    /* access modifiers changed from: private */
    public AtomicInteger hbpOrdinalViewCount = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public Map<String, Boolean> playOperations = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public volatile boolean shouldTransmitIMEI;
    /* access modifiers changed from: private */
    public volatile String userIMEI;

    @Keep
    public enum Consent {
        OPTED_IN,
        OPTED_OUT
    }

    private Vungle() {
    }

    static Context appContext() {
        Vungle vungle = _instance;
        if (vungle != null) {
            return vungle.context;
        }
        return null;
    }

    public static boolean canPlayAd(final String str) {
        final Context context2 = _instance.context;
        if (context2 == null) {
            Log.e(TAG, "Context is null");
            return false;
        }
        ServiceLocator instance = ServiceLocator.getInstance(context2);
        return Boolean.TRUE.equals(new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<Boolean>() {
            public Boolean call() {
                if (!Vungle.isInitialized()) {
                    Log.e(Vungle.TAG, "Vungle is not initialized");
                    return false;
                }
                Repository repository = (Repository) ServiceLocator.getInstance(context2).getService(Repository.class);
                Advertisement advertisement = repository.findValidAdvertisementForPlacement(str).get();
                Placement placement = repository.load(str, Placement.class).get();
                if (advertisement == null || placement == null || placement.getPlacementAdType() != 0 || (!AdConfig.AdSize.isDefaultAdSize(placement.getAdSize()) && !placement.getAdSize().equals(advertisement.getAdConfig().getAdSize()))) {
                    return false;
                }
                return Boolean.valueOf(Vungle.canPlayAd(advertisement));
            }
        })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS));
    }

    private static void clearAdvertisements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ((Downloader) instance.getService(Downloader.class)).cancelAll();
                ((AdLoader) instance.getService(AdLoader.class)).clear();
                final Repository repository = (Repository) instance.getService(Repository.class);
                ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        List<Advertisement> list = repository.loadAll(Advertisement.class).get();
                        if (list != null) {
                            for (Advertisement id : list) {
                                try {
                                    repository.deleteAdvertisement(id.getId());
                                } catch (DatabaseHelper.DBException unused) {
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    private static void clearCache() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ((Downloader) instance.getService(Downloader.class)).cancelAll();
                ((AdLoader) instance.getService(AdLoader.class)).clear();
                ((Repository) instance.getService(Repository.class)).clearAllData();
                Vungle._instance.playOperations.clear();
                Consent unused = Vungle._instance.ccpaStatus = null;
                Vungle._instance.configure(((RuntimeValues) instance.getService(RuntimeValues.class)).initCallback.get());
            }
        });
    }

    public static boolean closeFlexViewAd(String str) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, can't close flex view ad");
            return false;
        }
        Intent intent = new Intent(AdContract.AdvertisementBus.ACTION);
        intent.putExtra("placement", str);
        intent.putExtra("command", AdContract.AdvertisementBus.CLOSE_FLEX);
        C3218a.m10641a(_instance.context).mo18872a(intent);
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:133|134) */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        android.util.Log.e(TAG, "not able to apply vision data config");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:133:0x0339 */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void configure(com.vungle.warren.InitCallback r31) {
        /*
            r30 = this;
            r1 = r30
            r2 = r31
            java.lang.String r0 = "configSettings"
            java.lang.String r3 = "attribution_reporting"
            java.lang.String r4 = "ri"
            java.lang.Class<com.vungle.warren.model.Cookie> r5 = com.vungle.warren.model.Cookie.class
            java.lang.String r6 = "consentIsImportantToVungle"
            java.lang.String r7 = "gdpr"
            java.lang.String r8 = "clever_cache"
            java.lang.String r9 = "button_deny"
            java.lang.String r10 = "button_accept"
            java.lang.String r11 = "consent_message_version"
            java.lang.String r12 = "consent_message"
            java.lang.String r13 = "consent_title"
            java.lang.String r14 = "is_country_data_protected"
            java.lang.String r15 = "apk_direct_download"
            r16 = r3
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x03b4 }
            if (r3 == 0) goto L_0x03ac
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.ServiceLocator r3 = com.vungle.warren.ServiceLocator.getInstance(r3)     // Catch:{ all -> 0x03b4 }
            r17 = r0
            java.lang.Class<com.vungle.warren.VungleApiClient> r0 = com.vungle.warren.VungleApiClient.class
            java.lang.Object r0 = r3.getService(r0)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.VungleApiClient r0 = (com.vungle.warren.VungleApiClient) r0     // Catch:{ all -> 0x03b4 }
            r18 = r4
            java.lang.Class<com.vungle.warren.persistence.Repository> r4 = com.vungle.warren.persistence.Repository.class
            java.lang.Object r4 = r3.getService(r4)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.persistence.Repository r4 = (com.vungle.warren.persistence.Repository) r4     // Catch:{ all -> 0x03b4 }
            r19 = r15
            java.lang.Class<com.vungle.warren.tasks.JobRunner> r15 = com.vungle.warren.tasks.JobRunner.class
            java.lang.Object r15 = r3.getService(r15)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.tasks.JobRunner r15 = (com.vungle.warren.tasks.JobRunner) r15     // Catch:{ all -> 0x03b4 }
            r20 = r9
            com.vungle.warren.network.Response r9 = r0.config()     // Catch:{ all -> 0x03b4 }
            if (r9 != 0) goto L_0x0062
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x03b4 }
            r3 = 2
            r0.<init>(r3)     // Catch:{ all -> 0x03b4 }
            r2.onError(r0)     // Catch:{ all -> 0x03b4 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x03b4 }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x03b4 }
            return
        L_0x0062:
            boolean r21 = r9.isSuccessful()     // Catch:{ all -> 0x03b4 }
            r22 = 0
            if (r21 != 0) goto L_0x00a2
            long r3 = r0.getRetryAfterHeaderValue(r9)     // Catch:{ all -> 0x03b4 }
            int r0 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r0 <= 0) goto L_0x0092
            com.vungle.warren.Vungle r0 = _instance     // Catch:{ all -> 0x03b4 }
            java.lang.String r0 = r0.appID     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.ReconfigJob.makeJobInfo(r0)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.tasks.JobInfo r0 = r0.setDelay(r3)     // Catch:{ all -> 0x03b4 }
            r15.execute(r0)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x03b4 }
            r3 = 14
            r0.<init>(r3)     // Catch:{ all -> 0x03b4 }
            r2.onError(r0)     // Catch:{ all -> 0x03b4 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x03b4 }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x03b4 }
            return
        L_0x0092:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x03b4 }
            r3 = 3
            r0.<init>(r3)     // Catch:{ all -> 0x03b4 }
            r2.onError(r0)     // Catch:{ all -> 0x03b4 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x03b4 }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x03b4 }
            return
        L_0x00a2:
            r21 = r15
            android.content.Context r15 = r1.context     // Catch:{ all -> 0x03b4 }
            r24 = r10
            java.lang.String r10 = "com.vungle.sdk"
            r25 = r11
            r11 = 0
            android.content.SharedPreferences r10 = r15.getSharedPreferences(r10, r11)     // Catch:{ all -> 0x03b4 }
            java.lang.String r15 = "reported"
            boolean r15 = r10.getBoolean(r15, r11)     // Catch:{ all -> 0x03b4 }
            if (r15 != 0) goto L_0x00c5
            com.vungle.warren.network.Call r0 = r0.reportNew()     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.Vungle$3 r11 = new com.vungle.warren.Vungle$3     // Catch:{ all -> 0x03b4 }
            r11.<init>(r10)     // Catch:{ all -> 0x03b4 }
            r0.enqueue(r11)     // Catch:{ all -> 0x03b4 }
        L_0x00c5:
            java.lang.Object r0 = r9.body()     // Catch:{ all -> 0x03b4 }
            com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ all -> 0x03b4 }
            java.lang.String r9 = "placements"
            com.google.gson.JsonArray r9 = r0.getAsJsonArray(r9)     // Catch:{ all -> 0x03b4 }
            if (r9 != 0) goto L_0x00e3
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x03b4 }
            r3 = 3
            r0.<init>(r3)     // Catch:{ all -> 0x03b4 }
            r2.onError(r0)     // Catch:{ all -> 0x03b4 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x03b4 }
            r3 = 0
            r0.set(r3)     // Catch:{ all -> 0x03b4 }
            return
        L_0x00e3:
            com.vungle.warren.CleverCacheSettings r11 = com.vungle.warren.CleverCacheSettings.fromJson(r0)     // Catch:{ all -> 0x03b4 }
            java.lang.Class<com.vungle.warren.downloader.Downloader> r15 = com.vungle.warren.downloader.Downloader.class
            java.lang.Object r15 = r3.getService(r15)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.downloader.Downloader r15 = (com.vungle.warren.downloader.Downloader) r15     // Catch:{ all -> 0x03b4 }
            if (r11 == 0) goto L_0x012e
            r2 = 0
            java.lang.String r2 = r10.getString(r8, r2)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.CleverCacheSettings r2 = com.vungle.warren.CleverCacheSettings.deserializeFromString(r2)     // Catch:{ all -> 0x03b4 }
            if (r2 == 0) goto L_0x010b
            long r26 = r2.getTimestamp()     // Catch:{ all -> 0x03b4 }
            long r28 = r11.getTimestamp()     // Catch:{ all -> 0x03b4 }
            int r2 = (r26 > r28 ? 1 : (r26 == r28 ? 0 : -1))
            if (r2 == 0) goto L_0x0109
            goto L_0x010b
        L_0x0109:
            r2 = 0
            goto L_0x010c
        L_0x010b:
            r2 = 1
        L_0x010c:
            boolean r26 = r11.isEnabled()     // Catch:{ all -> 0x03b4 }
            if (r26 == 0) goto L_0x0114
            if (r2 == 0) goto L_0x0117
        L_0x0114:
            r15.clearCache()     // Catch:{ all -> 0x03b4 }
        L_0x0117:
            boolean r2 = r11.isEnabled()     // Catch:{ all -> 0x03b4 }
            r15.setCacheEnabled(r2)     // Catch:{ all -> 0x03b4 }
            android.content.SharedPreferences$Editor r2 = r10.edit()     // Catch:{ all -> 0x03b4 }
            java.lang.String r10 = r11.serializeToString()     // Catch:{ all -> 0x03b4 }
            android.content.SharedPreferences$Editor r2 = r2.putString(r8, r10)     // Catch:{ all -> 0x03b4 }
            r2.apply()     // Catch:{ all -> 0x03b4 }
            goto L_0x0132
        L_0x012e:
            r2 = 1
            r15.setCacheEnabled(r2)     // Catch:{ all -> 0x03b4 }
        L_0x0132:
            java.lang.Class<com.vungle.warren.AdLoader> r2 = com.vungle.warren.AdLoader.class
            java.lang.Object r2 = r3.getService(r2)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.AdLoader r2 = (com.vungle.warren.AdLoader) r2     // Catch:{ all -> 0x03b4 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x03b4 }
            r8.<init>()     // Catch:{ all -> 0x03b4 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x03b4 }
        L_0x0143:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x03b4 }
            if (r10 == 0) goto L_0x015c
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x03b4 }
            com.google.gson.JsonElement r10 = (com.google.gson.JsonElement) r10     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.model.Placement r11 = new com.vungle.warren.model.Placement     // Catch:{ all -> 0x03b4 }
            com.google.gson.JsonObject r10 = r10.getAsJsonObject()     // Catch:{ all -> 0x03b4 }
            r11.<init>((com.google.gson.JsonObject) r10)     // Catch:{ all -> 0x03b4 }
            r8.add(r11)     // Catch:{ all -> 0x03b4 }
            goto L_0x0143
        L_0x015c:
            r4.setValidPlacements(r8)     // Catch:{ all -> 0x03b4 }
            boolean r8 = r0.has(r7)     // Catch:{ all -> 0x03b4 }
            if (r8 == 0) goto L_0x0258
            com.vungle.warren.persistence.FutureResult r8 = r4.load(r6, r5)     // Catch:{ all -> 0x03b4 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.model.Cookie r8 = (com.vungle.warren.model.Cookie) r8     // Catch:{ all -> 0x03b4 }
            java.lang.String r9 = "consent_source"
            if (r8 != 0) goto L_0x018d
            com.vungle.warren.model.Cookie r8 = new com.vungle.warren.model.Cookie     // Catch:{ all -> 0x03b4 }
            r8.<init>(r6)     // Catch:{ all -> 0x03b4 }
            java.lang.String r6 = "consent_status"
            java.lang.String r10 = "unknown"
            r8.putValue(r6, r10)     // Catch:{ all -> 0x03b4 }
            java.lang.String r6 = "no_interaction"
            r8.putValue(r9, r6)     // Catch:{ all -> 0x03b4 }
            java.lang.String r6 = "timestamp"
            java.lang.Long r10 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x03b4 }
            r8.putValue(r6, r10)     // Catch:{ all -> 0x03b4 }
        L_0x018d:
            com.google.gson.JsonObject r6 = r0.getAsJsonObject(r7)     // Catch:{ all -> 0x03b4 }
            boolean r7 = com.vungle.warren.model.JsonUtil.hasNonNull(r6, r14)     // Catch:{ all -> 0x03b4 }
            if (r7 == 0) goto L_0x01a3
            com.google.gson.JsonElement r7 = r6.get(r14)     // Catch:{ all -> 0x03b4 }
            boolean r7 = r7.getAsBoolean()     // Catch:{ all -> 0x03b4 }
            if (r7 == 0) goto L_0x01a3
            r7 = 1
            goto L_0x01a4
        L_0x01a3:
            r7 = 0
        L_0x01a4:
            boolean r10 = com.vungle.warren.model.JsonUtil.hasNonNull(r6, r13)     // Catch:{ all -> 0x03b4 }
            java.lang.String r11 = ""
            if (r10 == 0) goto L_0x01b5
            com.google.gson.JsonElement r10 = r6.get(r13)     // Catch:{ all -> 0x03b4 }
            java.lang.String r10 = r10.getAsString()     // Catch:{ all -> 0x03b4 }
            goto L_0x01b6
        L_0x01b5:
            r10 = r11
        L_0x01b6:
            boolean r15 = com.vungle.warren.model.JsonUtil.hasNonNull(r6, r12)     // Catch:{ all -> 0x03b4 }
            if (r15 == 0) goto L_0x01c5
            com.google.gson.JsonElement r15 = r6.get(r12)     // Catch:{ all -> 0x03b4 }
            java.lang.String r15 = r15.getAsString()     // Catch:{ all -> 0x03b4 }
            goto L_0x01c6
        L_0x01c5:
            r15 = r11
        L_0x01c6:
            r22 = r11
            r11 = r25
            boolean r23 = com.vungle.warren.model.JsonUtil.hasNonNull(r6, r11)     // Catch:{ all -> 0x03b4 }
            if (r23 == 0) goto L_0x01d9
            com.google.gson.JsonElement r23 = r6.get(r11)     // Catch:{ all -> 0x03b4 }
            java.lang.String r23 = r23.getAsString()     // Catch:{ all -> 0x03b4 }
            goto L_0x01db
        L_0x01d9:
            r23 = r22
        L_0x01db:
            r25 = r2
            r2 = r24
            boolean r24 = com.vungle.warren.model.JsonUtil.hasNonNull(r6, r2)     // Catch:{ all -> 0x03b4 }
            if (r24 == 0) goto L_0x01ee
            com.google.gson.JsonElement r24 = r6.get(r2)     // Catch:{ all -> 0x03b4 }
            java.lang.String r24 = r24.getAsString()     // Catch:{ all -> 0x03b4 }
            goto L_0x01f0
        L_0x01ee:
            r24 = r22
        L_0x01f0:
            r26 = r3
            r3 = r20
            boolean r20 = com.vungle.warren.model.JsonUtil.hasNonNull(r6, r3)     // Catch:{ all -> 0x03b4 }
            if (r20 == 0) goto L_0x0203
            com.google.gson.JsonElement r6 = r6.get(r3)     // Catch:{ all -> 0x03b4 }
            java.lang.String r6 = r6.getAsString()     // Catch:{ all -> 0x03b4 }
            goto L_0x0205
        L_0x0203:
            r6 = r22
        L_0x0205:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x03b4 }
            r8.putValue(r14, r7)     // Catch:{ all -> 0x03b4 }
            boolean r7 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x03b4 }
            if (r7 == 0) goto L_0x0214
            java.lang.String r10 = "Targeted Ads"
        L_0x0214:
            r8.putValue(r13, r10)     // Catch:{ all -> 0x03b4 }
            boolean r7 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x03b4 }
            if (r7 == 0) goto L_0x021f
            java.lang.String r15 = "To receive more relevant ad content based on your interactions with our ads, click \"I Consent\" below. Either way, you will see the same amount of ads."
        L_0x021f:
            r8.putValue(r12, r15)     // Catch:{ all -> 0x03b4 }
            java.lang.String r7 = r8.getString(r9)     // Catch:{ all -> 0x03b4 }
            java.lang.String r9 = "publisher"
            boolean r7 = r9.equalsIgnoreCase(r7)     // Catch:{ all -> 0x03b4 }
            if (r7 != 0) goto L_0x023c
            boolean r7 = android.text.TextUtils.isEmpty(r23)     // Catch:{ all -> 0x03b4 }
            if (r7 == 0) goto L_0x0237
            r7 = r22
            goto L_0x0239
        L_0x0237:
            r7 = r23
        L_0x0239:
            r8.putValue(r11, r7)     // Catch:{ all -> 0x03b4 }
        L_0x023c:
            boolean r7 = android.text.TextUtils.isEmpty(r24)     // Catch:{ all -> 0x03b4 }
            if (r7 == 0) goto L_0x0244
            java.lang.String r24 = "I Consent"
        L_0x0244:
            r7 = r24
            r8.putValue(r2, r7)     // Catch:{ all -> 0x03b4 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x03b4 }
            if (r2 == 0) goto L_0x0251
            java.lang.String r6 = "I Do Not Consent"
        L_0x0251:
            r8.putValue(r3, r6)     // Catch:{ all -> 0x03b4 }
            r4.save(r8)     // Catch:{ all -> 0x03b4 }
            goto L_0x025c
        L_0x0258:
            r25 = r2
            r26 = r3
        L_0x025c:
            r2 = -1
            r3 = r19
            boolean r6 = r0.has(r3)     // Catch:{ all -> 0x03b4 }
            java.lang.String r7 = "enabled"
            if (r6 == 0) goto L_0x027d
            com.google.gson.JsonObject r6 = r0.getAsJsonObject(r3)     // Catch:{ all -> 0x03b4 }
            boolean r6 = r6.has(r7)     // Catch:{ all -> 0x03b4 }
            if (r6 == 0) goto L_0x027d
            com.google.gson.JsonObject r2 = r0.getAsJsonObject(r3)     // Catch:{ all -> 0x03b4 }
            com.google.gson.JsonElement r2 = r2.get(r7)     // Catch:{ all -> 0x03b4 }
            boolean r2 = r2.getAsBoolean()     // Catch:{ all -> 0x03b4 }
        L_0x027d:
            com.vungle.warren.download.ApkDownloadManager r3 = com.vungle.warren.download.ApkDownloadManager.getInstance()     // Catch:{ all -> 0x03b4 }
            android.content.Context r6 = r1.context     // Catch:{ all -> 0x03b4 }
            r3.init(r6, r2)     // Catch:{ all -> 0x03b4 }
            r2 = r18
            boolean r3 = r0.has(r2)     // Catch:{ all -> 0x03b4 }
            if (r3 == 0) goto L_0x02b9
            r3 = r17
            com.vungle.warren.persistence.FutureResult r5 = r4.load(r3, r5)     // Catch:{ all -> 0x03b4 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.model.Cookie r5 = (com.vungle.warren.model.Cookie) r5     // Catch:{ all -> 0x03b4 }
            if (r5 != 0) goto L_0x02a1
            com.vungle.warren.model.Cookie r5 = new com.vungle.warren.model.Cookie     // Catch:{ all -> 0x03b4 }
            r5.<init>(r3)     // Catch:{ all -> 0x03b4 }
        L_0x02a1:
            com.google.gson.JsonObject r2 = r0.getAsJsonObject(r2)     // Catch:{ all -> 0x03b4 }
            com.google.gson.JsonElement r2 = r2.get(r7)     // Catch:{ all -> 0x03b4 }
            boolean r2 = r2.getAsBoolean()     // Catch:{ all -> 0x03b4 }
            java.lang.String r3 = "isReportIncentivizedEnabled"
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x03b4 }
            r5.putValue(r3, r2)     // Catch:{ all -> 0x03b4 }
            r4.save(r5)     // Catch:{ all -> 0x03b4 }
        L_0x02b9:
            r2 = r16
            boolean r3 = r0.has(r2)     // Catch:{ all -> 0x03b4 }
            if (r3 == 0) goto L_0x02de
            com.google.gson.JsonObject r2 = r0.getAsJsonObject(r2)     // Catch:{ all -> 0x03b4 }
            java.lang.String r3 = "should_transmit_imei"
            boolean r3 = r2.has(r3)     // Catch:{ all -> 0x03b4 }
            if (r3 == 0) goto L_0x02da
            java.lang.String r3 = "should_transmit_imei"
            com.google.gson.JsonElement r2 = r2.get(r3)     // Catch:{ all -> 0x03b4 }
            boolean r2 = r2.getAsBoolean()     // Catch:{ all -> 0x03b4 }
            r1.shouldTransmitIMEI = r2     // Catch:{ all -> 0x03b4 }
            goto L_0x02e1
        L_0x02da:
            r2 = 0
            r1.shouldTransmitIMEI = r2     // Catch:{ all -> 0x03aa }
            goto L_0x02e1
        L_0x02de:
            r2 = 0
            r1.shouldTransmitIMEI = r2     // Catch:{ all -> 0x03aa }
        L_0x02e1:
            java.lang.String r2 = "config"
            boolean r2 = r0.has(r2)     // Catch:{ all -> 0x03b4 }
            if (r2 == 0) goto L_0x0309
            java.lang.String r2 = "config"
            com.google.gson.JsonObject r2 = r0.getAsJsonObject(r2)     // Catch:{ all -> 0x03b4 }
            java.lang.String r3 = "refresh_time"
            com.google.gson.JsonElement r2 = r2.get(r3)     // Catch:{ all -> 0x03b4 }
            long r2 = r2.getAsLong()     // Catch:{ all -> 0x03b4 }
            java.lang.String r5 = r1.appID     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.tasks.JobInfo r5 = com.vungle.warren.tasks.ReconfigJob.makeJobInfo(r5)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.tasks.JobInfo r2 = r5.setDelay(r2)     // Catch:{ all -> 0x03b4 }
            r15 = r21
            r15.execute(r2)     // Catch:{ all -> 0x03b4 }
            goto L_0x030b
        L_0x0309:
            r15 = r21
        L_0x030b:
            java.lang.Class<com.vungle.warren.VisionController> r2 = com.vungle.warren.VisionController.class
            r3 = r26
            java.lang.Object r2 = r3.getService(r2)     // Catch:{ DBException -> 0x0339 }
            com.vungle.warren.VisionController r2 = (com.vungle.warren.VisionController) r2     // Catch:{ DBException -> 0x0339 }
            java.lang.String r5 = "vision"
            boolean r5 = com.vungle.warren.model.JsonUtil.hasNonNull(r0, r5)     // Catch:{ DBException -> 0x0339 }
            if (r5 == 0) goto L_0x032e
            com.google.gson.Gson r5 = r1.gson     // Catch:{ DBException -> 0x0339 }
            java.lang.String r6 = "vision"
            com.google.gson.JsonObject r0 = r0.getAsJsonObject(r6)     // Catch:{ DBException -> 0x0339 }
            java.lang.Class<com.vungle.warren.vision.VisionConfig> r6 = com.vungle.warren.vision.VisionConfig.class
            java.lang.Object r0 = r5.fromJson((com.google.gson.JsonElement) r0, r6)     // Catch:{ DBException -> 0x0339 }
            com.vungle.warren.vision.VisionConfig r0 = (com.vungle.warren.vision.VisionConfig) r0     // Catch:{ DBException -> 0x0339 }
            goto L_0x0333
        L_0x032e:
            com.vungle.warren.vision.VisionConfig r0 = new com.vungle.warren.vision.VisionConfig     // Catch:{ DBException -> 0x0339 }
            r0.<init>()     // Catch:{ DBException -> 0x0339 }
        L_0x0333:
            r2.setConfig(r0)     // Catch:{ DBException -> 0x0339 }
            goto L_0x0340
        L_0x0337:
            r3 = r26
        L_0x0339:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x03b4 }
            java.lang.String r2 = "not able to apply vision data config"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x03b4 }
        L_0x0340:
            r0 = 1
            isInitialized = r0     // Catch:{ all -> 0x03b4 }
            r31.onSuccess()     // Catch:{ all -> 0x03b4 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x03b4 }
            r2 = 0
            r0.set(r2)     // Catch:{ all -> 0x03aa }
            com.vungle.warren.SessionData r0 = new com.vungle.warren.SessionData     // Catch:{ all -> 0x03b4 }
            r0.<init>()     // Catch:{ all -> 0x03b4 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x03b4 }
            r0.setInitTimeStamp(r5)     // Catch:{ all -> 0x03b4 }
            android.content.Context r2 = r1.context     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.ServiceLocator r2 = com.vungle.warren.ServiceLocator.getInstance(r2)     // Catch:{ all -> 0x03b4 }
            java.lang.Class<com.vungle.warren.RuntimeValues> r5 = com.vungle.warren.RuntimeValues.class
            java.lang.Object r2 = r2.getService(r5)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.RuntimeValues r2 = (com.vungle.warren.RuntimeValues) r2     // Catch:{ all -> 0x03b4 }
            java.util.concurrent.atomic.AtomicReference<com.vungle.warren.SessionData> r2 = r2.sessionData     // Catch:{ all -> 0x03b4 }
            r2.set(r0)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.persistence.FutureResult r0 = r4.loadValidPlacements()     // Catch:{ all -> 0x03b4 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x03b4 }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.tasks.JobInfo r2 = com.vungle.warren.tasks.CleanupJob.makeJobInfo()     // Catch:{ all -> 0x03b4 }
            r15.execute(r2)     // Catch:{ all -> 0x03b4 }
            if (r0 == 0) goto L_0x03a1
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x03b4 }
            r2.<init>(r0)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.Vungle$4 r0 = new com.vungle.warren.Vungle$4     // Catch:{ all -> 0x03b4 }
            r0.<init>()     // Catch:{ all -> 0x03b4 }
            java.util.Collections.sort(r2, r0)     // Catch:{ all -> 0x03b4 }
            java.lang.Class<com.vungle.warren.utility.Executors> r0 = com.vungle.warren.utility.Executors.class
            java.lang.Object r0 = r3.getService(r0)     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.utility.Executors r0 = (com.vungle.warren.utility.Executors) r0     // Catch:{ all -> 0x03b4 }
            java.util.concurrent.ExecutorService r0 = r0.getUIExecutor()     // Catch:{ all -> 0x03b4 }
            com.vungle.warren.Vungle$5 r3 = new com.vungle.warren.Vungle$5     // Catch:{ all -> 0x03b4 }
            r4 = r25
            r3.<init>(r2, r4)     // Catch:{ all -> 0x03b4 }
            r0.execute(r3)     // Catch:{ all -> 0x03b4 }
        L_0x03a1:
            r0 = 1
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.SendReportsJob.makeJobInfo(r0)     // Catch:{ all -> 0x03b4 }
            r15.execute(r0)     // Catch:{ all -> 0x03b4 }
            goto L_0x03f0
        L_0x03aa:
            r0 = move-exception
            goto L_0x03b6
        L_0x03ac:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x03b4 }
            java.lang.String r2 = "Context is null"
            r0.<init>(r2)     // Catch:{ all -> 0x03b4 }
            throw r0     // Catch:{ all -> 0x03b4 }
        L_0x03b4:
            r0 = move-exception
            r2 = 0
        L_0x03b6:
            isInitialized = r2
            java.util.concurrent.atomic.AtomicBoolean r3 = isInitializing
            r3.set(r2)
            java.lang.String r2 = TAG
            java.lang.String r3 = android.util.Log.getStackTraceString(r0)
            android.util.Log.e(r2, r3)
            boolean r2 = r0 instanceof com.vungle.warren.network.HttpException
            if (r2 == 0) goto L_0x03d6
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r2 = 3
            r0.<init>(r2)
            r2 = r31
            r2.onError(r0)
            goto L_0x03f0
        L_0x03d6:
            r2 = r31
            boolean r0 = r0 instanceof com.vungle.warren.persistence.DatabaseHelper.DBException
            if (r0 == 0) goto L_0x03e7
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r3 = 26
            r0.<init>(r3)
            r2.onError(r0)
            goto L_0x03f0
        L_0x03e7:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r3 = 2
            r0.<init>(r3)
            r2.onError(r0)
        L_0x03f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.configure(com.vungle.warren.InitCallback):void");
    }

    protected static void deInit() {
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            ((CacheManager) instance.getService(CacheManager.class)).removeListener(cacheListener);
            ((Downloader) instance.getService(Downloader.class)).cancelAll();
            ((AdLoader) instance.getService(AdLoader.class)).clear();
            _instance.playOperations.clear();
        }
        ServiceLocator.deInit();
        isInitialized = false;
        isDepInit.set(false);
        isInitializing.set(false);
    }

    static Context getAppContext() {
        return _instance.context;
    }

    public static String getAvailableBidTokens(final int i) {
        Context context2 = _instance.context;
        if (context2 == null) {
            Log.e(TAG, "Context is null");
            return null;
        }
        ServiceLocator instance = ServiceLocator.getInstance(context2);
        return (String) new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<String>() {
            public String call() throws Exception {
                if (!Vungle.isInitialized()) {
                    Log.e(Vungle.TAG, "Vungle is not initialized, available bid token is null");
                    return null;
                }
                Vungle._instance.hbpOrdinalViewCount.incrementAndGet();
                List list = ((Repository) ServiceLocator.getInstance(Vungle._instance.context).getService(Repository.class)).getAvailableBidTokens(i).get();
                if (list == null || list.isEmpty()) {
                    return null;
                }
                String join = TextUtils.join(",", list);
                String str = new String(Base64.encode((join + ":" + Vungle._instance.hbpOrdinalViewCount.toString()).getBytes(), 2), Charset.defaultCharset());
                return TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE + ":" + str;
            }
        })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
    }

    public static Consent getCCPAStatus() {
        return _instance.ccpaStatus;
    }

    /* access modifiers changed from: private */
    public static Consent getConsent(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return Cookie.CONSENT_STATUS_OPTED_IN.equals(cookie.getString("consent_status")) ? Consent.OPTED_IN : Consent.OPTED_OUT;
    }

    public static String getConsentMessageVersion() {
        return _instance.consentVersion;
    }

    public static Consent getConsentStatus() {
        return _instance.consent.get();
    }

    public static VungleNativeAd getNativeAd(String str, AdConfig adConfig, PlayAdCallback playAdCallback) {
        if (adConfig == null) {
            adConfig = new AdConfig();
        }
        if (AdConfig.AdSize.isDefaultAdSize(adConfig.getAdSize())) {
            return getNativeAdInternal(str, adConfig, playAdCallback);
        }
        if (playAdCallback == null) {
            return null;
        }
        Log.e(TAG, "Please use Banners.getBanner(... ) to retrieve Banner Ad");
        playAdCallback.onError(str, new VungleException(29));
        return null;
    }

    static VungleNativeView getNativeAdInternal(String str, AdConfig adConfig, PlayAdCallback playAdCallback) {
        String str2 = str;
        PlayAdCallback playAdCallback2 = playAdCallback;
        Context context2 = _instance.context;
        if (context2 == null) {
            Log.e(TAG, "Vungle is not initialized, returned VungleNativeAd = null");
            if (playAdCallback2 != null) {
                playAdCallback2.onError(str, new VungleException(9));
            }
            return null;
        }
        ServiceLocator instance = ServiceLocator.getInstance(context2);
        AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
        if (Boolean.TRUE.equals(_instance.playOperations.get(str)) || adLoader.isLoading(str)) {
            String str3 = TAG;
            Log.e(str3, "Playing or Loading operation ongoing. Playing " + _instance.playOperations.get(str) + " Loading: " + adLoader.isLoading(str));
            if (playAdCallback2 != null) {
                playAdCallback2.onError(str, new VungleException(8));
            }
            return null;
        }
        return new VungleNativeView(_instance.context.getApplicationContext(), str, adConfig, (PresentationFactory) instance.getService(PresentationFactory.class), new AdEventListener(str, _instance.playOperations, playAdCallback, (Repository) instance.getService(Repository.class), adLoader, (JobRunner) instance.getService(JobRunner.class), (VisionController) instance.getService(VisionController.class), (Placement) null, (Advertisement) null));
    }

    static Collection<Placement> getValidPlacementModels() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<Placement> collection = ((Repository) instance.getService(Repository.class)).loadValidPlacements().get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    public static Collection<String> getValidPlacements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<String> collection = ((Repository) instance.getService(Repository.class)).getValidPlacementIds().get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    @Deprecated
    public static void init(Collection<String> collection, String str, Context context2, InitCallback initCallback) throws IllegalArgumentException {
        init(str, context2, initCallback, new VungleSettings.Builder().build());
    }

    public static boolean isInitialized() {
        return isInitialized && _instance.context != null;
    }

    public static void loadAd(String str, LoadAdCallback loadAdCallback) {
        loadAd(str, new AdConfig(), loadAdCallback);
    }

    static void loadAdInternal(String str, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            if (loadAdCallback != null) {
                loadAdCallback.onError(str, new VungleException(9));
                return;
            }
            return;
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        LoadAdCallbackWrapper loadAdCallbackWrapper = new LoadAdCallbackWrapper(((Executors) instance.getService(Executors.class)).getUIExecutor(), loadAdCallback);
        AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
        if (adConfig == null) {
            adConfig = new AdConfig();
        }
        adLoader.load(str, adConfig, loadAdCallbackWrapper);
    }

    /* access modifiers changed from: private */
    public static void onError(InitCallback initCallback, VungleException vungleException) {
        if (initCallback != null) {
            initCallback.onError(vungleException);
        }
    }

    public static void playAd(String str, AdConfig adConfig, PlayAdCallback playAdCallback) {
        if (!isInitialized()) {
            Log.e(TAG, "Locator is not initialized");
            if (playAdCallback != null) {
                playAdCallback.onError(str, new VungleException(9));
                return;
            }
            return;
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        final Executors executors = (Executors) instance.getService(Executors.class);
        final Repository repository = (Repository) instance.getService(Repository.class);
        final AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
        final VungleApiClient vungleApiClient = (VungleApiClient) instance.getService(VungleApiClient.class);
        final PlayAdCallbackWrapper playAdCallbackWrapper = new PlayAdCallbackWrapper(executors.getUIExecutor(), playAdCallback);
        final String str2 = str;
        final AdConfig adConfig2 = adConfig;
        executors.getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                String str;
                if (Boolean.TRUE.equals(Vungle._instance.playOperations.get(str2)) || adLoader.isLoading(str2)) {
                    playAdCallbackWrapper.onError(str2, new VungleException(8));
                    return;
                }
                final Placement placement = repository.load(str2, Placement.class).get();
                if (placement == null) {
                    playAdCallbackWrapper.onError(str2, new VungleException(13));
                } else if (AdConfig.AdSize.isBannerAdSize(placement.getAdSize())) {
                    playAdCallbackWrapper.onError(str2, new VungleException(28));
                } else {
                    final boolean z = false;
                    final Advertisement advertisement = repository.findValidAdvertisementForPlacement(str2).get();
                    try {
                        if (!Vungle.canPlayAd(advertisement)) {
                            if (advertisement != null && advertisement.getState() == 1) {
                                repository.saveAndApplyState(advertisement, str2, 4);
                                if (placement.isAutoCached()) {
                                    adLoader.loadEndless(placement, 0);
                                }
                            }
                            z = true;
                        } else {
                            advertisement.configure(adConfig2);
                            repository.save(advertisement);
                        }
                        if (Vungle._instance.context == null) {
                            return;
                        }
                        if (vungleApiClient.canCallWillPlayAd()) {
                            VungleApiClient vungleApiClient = vungleApiClient;
                            String id = placement.getId();
                            boolean isAutoCached = placement.isAutoCached();
                            if (z) {
                                str = "";
                            } else {
                                str = advertisement.getAdToken();
                            }
                            vungleApiClient.willPlayAd(id, isAutoCached, str).enqueue(new Callback<JsonObject>() {
                                public void onFailure(Call<JsonObject> call, Throwable th) {
                                    executors.getBackgroundExecutor().execute(new Runnable() {
                                        public void run() {
                                            C54521 r0 = C54521.this;
                                            if (z) {
                                                C54518 r02 = C54518.this;
                                                playAdCallbackWrapper.onError(str2, new VungleException(1));
                                                return;
                                            }
                                            C54518 r1 = C54518.this;
                                            Vungle.renderAd(str2, playAdCallbackWrapper, placement, advertisement);
                                        }
                                    });
                                }

                                public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
                                    executors.getBackgroundExecutor().execute(new Runnable() {
                                        /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
                                        /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public void run() {
                                            /*
                                                r4 = this;
                                                com.vungle.warren.network.Response r0 = r3
                                                boolean r0 = r0.isSuccessful()
                                                r1 = 0
                                                if (r0 == 0) goto L_0x0052
                                                com.vungle.warren.network.Response r0 = r3
                                                java.lang.Object r0 = r0.body()
                                                com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0
                                                if (r0 == 0) goto L_0x0052
                                                java.lang.String r2 = "ad"
                                                boolean r3 = r0.has(r2)
                                                if (r3 == 0) goto L_0x0052
                                                com.google.gson.JsonObject r0 = r0.getAsJsonObject(r2)     // Catch:{ IllegalArgumentException -> 0x004f, Exception -> 0x0044 }
                                                com.vungle.warren.model.Advertisement r2 = new com.vungle.warren.model.Advertisement     // Catch:{ IllegalArgumentException -> 0x004f, Exception -> 0x0044 }
                                                r2.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x004f, Exception -> 0x0044 }
                                                com.vungle.warren.Vungle$8$1 r0 = com.vungle.warren.Vungle.C54518.C54521.this     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                com.vungle.warren.Vungle$8 r0 = com.vungle.warren.Vungle.C54518.this     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                com.vungle.warren.AdConfig r0 = r7     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                r2.configure(r0)     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                com.vungle.warren.Vungle$8$1 r0 = com.vungle.warren.Vungle.C54518.C54521.this     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                com.vungle.warren.Vungle$8 r0 = com.vungle.warren.Vungle.C54518.this     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                com.vungle.warren.persistence.Repository r0 = r6     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                com.vungle.warren.Vungle$8$1 r1 = com.vungle.warren.Vungle.C54518.C54521.this     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                com.vungle.warren.Vungle$8 r1 = com.vungle.warren.Vungle.C54518.this     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                java.lang.String r1 = r3     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                r3 = 0
                                                r0.saveAndApplyState(r2, r1, r3)     // Catch:{ IllegalArgumentException -> 0x0042, Exception -> 0x003f }
                                                r1 = r2
                                                goto L_0x0052
                                            L_0x003f:
                                                r0 = move-exception
                                                r1 = r2
                                                goto L_0x0045
                                            L_0x0042:
                                                r1 = r2
                                                goto L_0x004f
                                            L_0x0044:
                                                r0 = move-exception
                                            L_0x0045:
                                                java.lang.String r2 = com.vungle.warren.Vungle.TAG
                                                java.lang.String r3 = "Error using will_play_ad!"
                                                android.util.Log.e(r2, r3, r0)
                                                goto L_0x0052
                                            L_0x004f:
                                                java.lang.String unused = com.vungle.warren.Vungle.TAG
                                            L_0x0052:
                                                com.vungle.warren.Vungle$8$1 r0 = com.vungle.warren.Vungle.C54518.C54521.this
                                                boolean r2 = r1
                                                if (r2 == 0) goto L_0x0076
                                                if (r1 != 0) goto L_0x006a
                                                com.vungle.warren.Vungle$8 r0 = com.vungle.warren.Vungle.C54518.this
                                                com.vungle.warren.PlayAdCallback r1 = r5
                                                java.lang.String r0 = r3
                                                com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                                                r3 = 1
                                                r2.<init>(r3)
                                                r1.onError(r0, r2)
                                                goto L_0x0083
                                            L_0x006a:
                                                com.vungle.warren.Vungle$8 r2 = com.vungle.warren.Vungle.C54518.this
                                                java.lang.String r3 = r3
                                                com.vungle.warren.PlayAdCallback r2 = r5
                                                com.vungle.warren.model.Placement r0 = r0
                                                com.vungle.warren.Vungle.renderAd(r3, r2, r0, r1)
                                                goto L_0x0083
                                            L_0x0076:
                                                com.vungle.warren.Vungle$8 r1 = com.vungle.warren.Vungle.C54518.this
                                                java.lang.String r2 = r3
                                                com.vungle.warren.PlayAdCallback r1 = r5
                                                com.vungle.warren.model.Placement r3 = r0
                                                com.vungle.warren.model.Advertisement r0 = r2
                                                com.vungle.warren.Vungle.renderAd(r2, r1, r3, r0)
                                            L_0x0083:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.C54518.C54521.C54531.run():void");
                                        }
                                    });
                                }
                            });
                        } else if (z) {
                            playAdCallbackWrapper.onError(str2, new VungleException(1));
                        } else {
                            Vungle.renderAd(str2, playAdCallbackWrapper, placement, advertisement);
                        }
                    } catch (DatabaseHelper.DBException unused) {
                        playAdCallbackWrapper.onError(str2, new VungleException(26));
                    }
                }
            }
        });
    }

    static void reConfigure() {
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            Executors executors = (Executors) instance.getService(Executors.class);
            final RuntimeValues runtimeValues = (RuntimeValues) instance.getService(RuntimeValues.class);
            if (isInitialized()) {
                executors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        Vungle._instance.configure(runtimeValues.initCallback.get());
                    }
                });
            } else {
                init(_instance.appID, _instance.context, runtimeValues.initCallback.get());
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void renderAd(java.lang.String r13, com.vungle.warren.PlayAdCallback r14, com.vungle.warren.model.Placement r15, com.vungle.warren.model.Advertisement r16) {
        /*
            java.lang.Class<com.vungle.warren.Vungle> r1 = com.vungle.warren.Vungle.class
            monitor-enter(r1)
            boolean r0 = isInitialized()     // Catch:{ all -> 0x0093 }
            if (r0 != 0) goto L_0x0012
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = "Sdk is not initilized"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0093 }
            monitor-exit(r1)
            return
        L_0x0012:
            com.vungle.warren.Vungle r0 = _instance     // Catch:{ all -> 0x0093 }
            android.content.Context r0 = r0.context     // Catch:{ all -> 0x0093 }
            com.vungle.warren.ServiceLocator r0 = com.vungle.warren.ServiceLocator.getInstance(r0)     // Catch:{ all -> 0x0093 }
            com.vungle.warren.Vungle$9 r12 = new com.vungle.warren.Vungle$9     // Catch:{ all -> 0x0093 }
            com.vungle.warren.Vungle r2 = _instance     // Catch:{ all -> 0x0093 }
            java.util.Map<java.lang.String, java.lang.Boolean> r4 = r2.playOperations     // Catch:{ all -> 0x0093 }
            java.lang.Class<com.vungle.warren.persistence.Repository> r2 = com.vungle.warren.persistence.Repository.class
            java.lang.Object r2 = r0.getService(r2)     // Catch:{ all -> 0x0093 }
            r6 = r2
            com.vungle.warren.persistence.Repository r6 = (com.vungle.warren.persistence.Repository) r6     // Catch:{ all -> 0x0093 }
            java.lang.Class<com.vungle.warren.AdLoader> r2 = com.vungle.warren.AdLoader.class
            java.lang.Object r2 = r0.getService(r2)     // Catch:{ all -> 0x0093 }
            r7 = r2
            com.vungle.warren.AdLoader r7 = (com.vungle.warren.AdLoader) r7     // Catch:{ all -> 0x0093 }
            java.lang.Class<com.vungle.warren.tasks.JobRunner> r2 = com.vungle.warren.tasks.JobRunner.class
            java.lang.Object r2 = r0.getService(r2)     // Catch:{ all -> 0x0093 }
            r8 = r2
            com.vungle.warren.tasks.JobRunner r8 = (com.vungle.warren.tasks.JobRunner) r8     // Catch:{ all -> 0x0093 }
            java.lang.Class<com.vungle.warren.VisionController> r2 = com.vungle.warren.VisionController.class
            java.lang.Object r0 = r0.getService(r2)     // Catch:{ all -> 0x0093 }
            r9 = r0
            com.vungle.warren.VisionController r9 = (com.vungle.warren.VisionController) r9     // Catch:{ all -> 0x0093 }
            r2 = r12
            r3 = r13
            r5 = r14
            r10 = r15
            r11 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0093 }
            com.vungle.warren.AdActivity.setEventListener(r12)     // Catch:{ all -> 0x0093 }
            if (r16 == 0) goto L_0x0060
            java.lang.String r0 = "flexview"
            java.lang.String r2 = r16.getTemplateType()     // Catch:{ all -> 0x0093 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0060
            r0 = 1
            goto L_0x0061
        L_0x0060:
            r0 = 0
        L_0x0061:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x0093 }
            com.vungle.warren.Vungle r3 = _instance     // Catch:{ all -> 0x0093 }
            android.content.Context r3 = r3.context     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x006c
            java.lang.Class<com.vungle.warren.ui.VungleFlexViewActivity> r0 = com.vungle.warren.p074ui.VungleFlexViewActivity.class
            goto L_0x006e
        L_0x006c:
            java.lang.Class<com.vungle.warren.ui.VungleActivity> r0 = com.vungle.warren.p074ui.VungleActivity.class
        L_0x006e:
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0093 }
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r2.addFlags(r0)     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = "placement"
            r3 = r13
            r2.putExtra(r0, r13)     // Catch:{ all -> 0x0093 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0093 }
            r3 = 29
            if (r0 < r3) goto L_0x008a
            com.vungle.warren.Vungle r0 = _instance     // Catch:{ all -> 0x0093 }
            android.content.Context r0 = r0.context     // Catch:{ all -> 0x0093 }
            r0.startActivity(r2)     // Catch:{ all -> 0x0093 }
            goto L_0x0091
        L_0x008a:
            com.vungle.warren.Vungle r0 = _instance     // Catch:{ all -> 0x0093 }
            android.content.Context r0 = r0.context     // Catch:{ all -> 0x0093 }
            com.vungle.warren.utility.ActivityManager.startWhenForeground(r0, r2)     // Catch:{ all -> 0x0093 }
        L_0x0091:
            monitor-exit(r1)
            return
        L_0x0093:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.renderAd(java.lang.String, com.vungle.warren.PlayAdCallback, com.vungle.warren.model.Placement, com.vungle.warren.model.Advertisement):void");
    }

    /* access modifiers changed from: private */
    public static void saveGDPRConsent(final Repository repository, final Consent consent2, final String str) {
        repository.load(Cookie.CONSENT_COOKIE, Cookie.class, new Repository.LoadCallback<Cookie>() {
            public void onLoaded(Cookie cookie) {
                if (cookie == null) {
                    cookie = new Cookie(Cookie.CONSENT_COOKIE);
                }
                cookie.putValue("consent_status", consent2 == Consent.OPTED_IN ? Cookie.CONSENT_STATUS_OPTED_IN : Cookie.CONSENT_STATUS_OPTED_OUT);
                cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie.putValue("consent_source", "publisher");
                String str = str;
                if (str == null) {
                    str = "";
                }
                cookie.putValue("consent_message_version", str);
                repository.save(cookie, (Repository.SaveCallback) null);
            }
        });
    }

    public static void setHeaderBiddingCallback(HeaderBiddingCallback headerBiddingCallback) {
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            ((RuntimeValues) instance.getService(RuntimeValues.class)).headerBiddingCallback.set(new HeaderBiddingCallbackWrapper(((Executors) instance.getService(Executors.class)).getUIExecutor(), headerBiddingCallback));
        }
    }

    public static void setIncentivizedFields(String str, String str2, String str3, String str4, String str5) {
        Context context2 = _instance.context;
        if (context2 == null) {
            Log.e(TAG, "Vungle is not initialized, context is null");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(context2);
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final String str9 = str5;
        final String str10 = str;
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                if (!Vungle.isInitialized()) {
                    Log.e(Vungle.TAG, "Vungle is not initialized");
                    return;
                }
                Repository repository = (Repository) instance.getService(Repository.class);
                Cookie cookie = repository.load(Cookie.INCENTIVIZED_TEXT_COOKIE, Cookie.class).get();
                if (cookie == null) {
                    cookie = new Cookie(Cookie.INCENTIVIZED_TEXT_COOKIE);
                }
                boolean z = false;
                boolean z2 = true;
                if (!TextUtils.isEmpty(str6)) {
                    cookie.putValue("title", str6);
                    z = true;
                }
                if (!TextUtils.isEmpty(str7)) {
                    cookie.putValue("body", str7);
                    z = true;
                }
                if (!TextUtils.isEmpty(str8)) {
                    cookie.putValue("continue", str8);
                    z = true;
                }
                if (!TextUtils.isEmpty(str9)) {
                    cookie.putValue("close", str9);
                    z = true;
                }
                if (!TextUtils.isEmpty(str10)) {
                    cookie.putValue("userID", str10);
                } else {
                    z2 = z;
                }
                if (z2) {
                    try {
                        repository.save(cookie);
                    } catch (DatabaseHelper.DBException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void setUserLegacyID(String str) {
        if (isInitialized() || isInitializing.get()) {
            ((VungleApiClient) ServiceLocator.getInstance(_instance.context).getService(VungleApiClient.class)).updateIMEI(str, _instance.shouldTransmitIMEI);
        } else {
            _instance.userIMEI = str;
        }
    }

    /* access modifiers changed from: private */
    public static void stopPlaying() {
        if (_instance.context != null) {
            Intent intent = new Intent(AdContract.AdvertisementBus.ACTION);
            intent.putExtra("command", AdContract.AdvertisementBus.STOP_ALL);
            C3218a.m10641a(_instance.context).mo18872a(intent);
        }
    }

    public static void updateCCPAStatus(Consent consent2) {
        if (consent2 == null) {
            Log.e(TAG, "Unable to update CCPA status, Invalid input parameter.");
            return;
        }
        _instance.ccpaStatus = consent2;
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            updateCCPAStatus((Repository) ServiceLocator.getInstance(_instance.context).getService(Repository.class), consent2);
        }
    }

    public static void updateConsentStatus(Consent consent2, String str) {
        if (consent2 == null) {
            Log.e(TAG, "Cannot set consent with a null consent, please check your code");
            return;
        }
        _instance.consent.set(consent2);
        _instance.consentVersion = str;
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            saveGDPRConsent((Repository) ServiceLocator.getInstance(_instance.context).getService(Repository.class), _instance.consent.get(), _instance.consentVersion);
        }
    }

    /* access modifiers changed from: private */
    public static Consent getCCPAStatus(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return Cookie.CONSENT_STATUS_OPTED_OUT.equals(cookie.getString(Cookie.CCPA_CONSENT_STATUS)) ? Consent.OPTED_OUT : Consent.OPTED_IN;
    }

    /* access modifiers changed from: private */
    public static String getConsentMessageVersion(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return cookie.getString("consent_message_version");
    }

    public static void init(String str, Context context2, InitCallback initCallback) throws IllegalArgumentException {
        init(str, context2, initCallback, new VungleSettings.Builder().build());
    }

    public static void loadAd(String str, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            if (loadAdCallback != null) {
                loadAdCallback.onError(str, new VungleException(9));
                return;
            }
            return;
        }
        if (!(adConfig == null || AdConfig.AdSize.isDefaultAdSize(adConfig.getAdSize()) || loadAdCallback == null)) {
            loadAdCallback.onError(str, new VungleException(29));
        }
        loadAdInternal(str, adConfig, loadAdCallback);
    }

    public static void init(final String str, final Context context2, InitCallback initCallback, VungleSettings vungleSettings) throws IllegalArgumentException {
        if (initCallback == null) {
            throw new IllegalArgumentException("A valid InitCallback required to ensure API calls are being made after initialize is successful");
        } else if (context2 == null) {
            initCallback.onError(new VungleException(6));
        } else {
            final RuntimeValues runtimeValues = (RuntimeValues) ServiceLocator.getInstance(context2).getService(RuntimeValues.class);
            runtimeValues.settings.set(vungleSettings);
            final ServiceLocator instance = ServiceLocator.getInstance(context2);
            Executors executors = (Executors) instance.getService(Executors.class);
            if (!(initCallback instanceof InitCallbackWrapper)) {
                initCallback = new InitCallbackWrapper(executors.getUIExecutor(), initCallback);
            }
            if (str == null || str.isEmpty()) {
                initCallback.onError(new VungleException(6));
            } else if (!(context2 instanceof Application)) {
                initCallback.onError(new VungleException(7));
            } else if (isInitialized()) {
                initCallback.onSuccess();
            } else if (isInitializing.getAndSet(true)) {
                initCallback.onError(new VungleException(8));
            } else {
                runtimeValues.initCallback.set(initCallback);
                executors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        Class<Cookie> cls = Cookie.class;
                        if (!Vungle.isDepInit.getAndSet(true)) {
                            CacheManager cacheManager = (CacheManager) instance.getService(CacheManager.class);
                            VungleSettings vungleSettings = runtimeValues.settings.get();
                            InitCallback initCallback = runtimeValues.initCallback.get();
                            if (vungleSettings == null || cacheManager.getBytesAvailable() >= vungleSettings.getMinimumSpaceForInit()) {
                                cacheManager.addListener(Vungle.cacheListener);
                                Context unused = Vungle._instance.context = context2;
                                String unused2 = Vungle._instance.appID = str;
                                Repository repository = (Repository) instance.getService(Repository.class);
                                try {
                                    repository.init();
                                    VungleApiClient vungleApiClient = (VungleApiClient) instance.getService(VungleApiClient.class);
                                    vungleApiClient.init(str);
                                    if (!TextUtils.isEmpty(Vungle._instance.userIMEI)) {
                                        vungleApiClient.updateIMEI(Vungle._instance.userIMEI, Vungle._instance.shouldTransmitIMEI);
                                    }
                                    if (vungleSettings != null) {
                                        vungleApiClient.setDefaultIdFallbackDisabled(vungleSettings.getAndroidIdOptOut());
                                    }
                                    ((AdLoader) instance.getService(AdLoader.class)).init((JobRunner) instance.getService(JobRunner.class));
                                    if (Vungle._instance.consent.get() != null) {
                                        Vungle.saveGDPRConsent(repository, (Consent) Vungle._instance.consent.get(), Vungle._instance.consentVersion);
                                    } else {
                                        Cookie cookie = repository.load(Cookie.CONSENT_COOKIE, cls).get();
                                        if (cookie == null) {
                                            Vungle._instance.consent.set((Object) null);
                                            String unused3 = Vungle._instance.consentVersion = null;
                                        } else {
                                            Vungle._instance.consent.set(Vungle.getConsent(cookie));
                                            String unused4 = Vungle._instance.consentVersion = Vungle.getConsentMessageVersion(cookie);
                                        }
                                    }
                                    if (Vungle._instance.ccpaStatus != null) {
                                        Vungle.updateCCPAStatus(repository, Vungle._instance.ccpaStatus);
                                    } else {
                                        Consent unused5 = Vungle._instance.ccpaStatus = Vungle.getCCPAStatus(repository.load(Cookie.CCPA_COOKIE, cls).get());
                                    }
                                    Cookie cookie2 = repository.load("appId", cls).get();
                                    if (cookie2 == null) {
                                        cookie2 = new Cookie("appId");
                                    }
                                    cookie2.putValue("appId", str);
                                    try {
                                        repository.save(cookie2);
                                    } catch (DatabaseHelper.DBException unused6) {
                                        if (initCallback != null) {
                                            Vungle.onError(initCallback, new VungleException(16));
                                        }
                                        Vungle.deInit();
                                        return;
                                    }
                                } catch (DatabaseHelper.DBException unused7) {
                                    if (initCallback != null) {
                                        Vungle.onError(initCallback, new VungleException(26));
                                    }
                                    Vungle.deInit();
                                    return;
                                }
                            } else {
                                initCallback.onError(new VungleException(16));
                                Vungle.deInit();
                                return;
                            }
                        }
                        Vungle._instance.configure(runtimeValues.initCallback.get());
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static void updateCCPAStatus(Repository repository, Consent consent2) {
        Cookie cookie = repository.load(Cookie.CCPA_COOKIE, Cookie.class).get();
        if (cookie == null) {
            cookie = new Cookie(Cookie.CCPA_COOKIE);
        }
        cookie.putValue(Cookie.CCPA_CONSENT_STATUS, consent2 == Consent.OPTED_OUT ? Cookie.CONSENT_STATUS_OPTED_OUT : Cookie.CONSENT_STATUS_OPTED_IN);
        try {
            repository.save(cookie);
        } catch (DatabaseHelper.DBException e) {
            String str = TAG;
            Log.e(str, "Unable to update CCPA status: Database exception." + e.getLocalizedMessage());
        }
    }

    static boolean canPlayAd(Advertisement advertisement) {
        Context context2 = _instance.context;
        if (context2 == null) {
            return false;
        }
        return ((AdLoader) ServiceLocator.getInstance(context2).getService(AdLoader.class)).canPlayAd(advertisement);
    }
}
