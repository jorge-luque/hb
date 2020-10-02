package com.vungle.warren;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vungle.warren.AdConfig;
import com.vungle.warren.OperationSequence;
import com.vungle.warren.downloader.AssetDownloadListener;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.AdAsset;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.model.Placement;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.Callback;
import com.vungle.warren.network.Response;
import com.vungle.warren.p074ui.HackMraid;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.UnzipUtility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class AdLoader implements OperationSequence.Callback {
    public static final long EXPONENTIAL_RATE = 2;
    public static final int RETRY_COUNT = 5;
    public static final long RETRY_DELAY = 2000;
    /* access modifiers changed from: private */
    public static final String TAG = "com.vungle.warren.AdLoader";
    /* access modifiers changed from: private */
    public final CacheManager cacheManager;
    private final Downloader downloader;
    private JobRunner jobRunner;
    /* access modifiers changed from: private */
    public final Map<String, Operation> loadOperations = new ConcurrentHashMap();
    private final Map<String, Operation> pendingOperations = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Repository repository;
    /* access modifiers changed from: private */
    public final RuntimeValues runtimeValues;
    /* access modifiers changed from: private */
    public final Executors sdkExecutors;
    /* access modifiers changed from: private */
    public final OperationSequence sequence;
    /* access modifiers changed from: private */
    public final VisionController visionController;
    /* access modifiers changed from: private */
    public final VungleStaticApi vungleApi;
    /* access modifiers changed from: private */
    public final VungleApiClient vungleApiClient;

    public @interface Priority {
        public static final int HIGH = 1;
        public static final int HIGHEST = 0;
        public static final int LOWEST = Integer.MAX_VALUE;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReschedulePolicy {
        public static final int EXPONENTIAL = 0;
        public static final int EXPONENTIAL_ENDLESS_AD = 1;
    }

    private class DownloadAdCallback implements DownloadCallback {
        private DownloadAdCallback() {
        }

        public void onDownloadCompleted(String str, String str2) {
            Advertisement advertisement;
            synchronized (AdLoader.this) {
                String unused = AdLoader.TAG;
                "download completed " + str;
                Placement placement = AdLoader.this.repository.load(str, Placement.class).get();
                if (placement == null) {
                    onDownloadFailed(new VungleException(13), str, str2);
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    advertisement = null;
                } else {
                    advertisement = AdLoader.this.repository.load(str2, Advertisement.class).get();
                }
                if (advertisement == null) {
                    onDownloadFailed(new VungleException(11), str, str2);
                    return;
                }
                advertisement.setFinishedDownloadingTime(System.currentTimeMillis());
                try {
                    AdLoader.this.repository.saveAndApplyState(advertisement, str, 1);
                    onReady(str, placement, advertisement);
                } catch (DatabaseHelper.DBException unused2) {
                    onDownloadFailed(new VungleException(26), str, str2);
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:75|76|77|78) */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x015d, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0141 */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00cb A[SYNTHETIC, Splitter:B:48:0x00cb] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:77:0x0141=Splitter:B:77:0x0141, B:12:0x0052=Splitter:B:12:0x0052} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDownloadFailed(com.vungle.warren.error.VungleException r13, java.lang.String r14, java.lang.String r15) {
            /*
                r12 = this;
                com.vungle.warren.AdLoader r0 = com.vungle.warren.AdLoader.this
                monitor-enter(r0)
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x015e }
                java.util.Map r1 = r1.loadOperations     // Catch:{ all -> 0x015e }
                java.lang.Object r1 = r1.remove(r14)     // Catch:{ all -> 0x015e }
                com.vungle.warren.AdLoader$Operation r1 = (com.vungle.warren.AdLoader.Operation) r1     // Catch:{ all -> 0x015e }
                com.vungle.warren.AdLoader r2 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x015e }
                com.vungle.warren.OperationSequence r2 = r2.sequence     // Catch:{ all -> 0x015e }
                r2.reportFinished(r14)     // Catch:{ all -> 0x015e }
                com.vungle.warren.AdLoader r2 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x015e }
                com.vungle.warren.persistence.Repository r2 = r2.repository     // Catch:{ all -> 0x015e }
                java.lang.Class<com.vungle.warren.model.Placement> r3 = com.vungle.warren.model.Placement.class
                com.vungle.warren.persistence.FutureResult r2 = r2.load(r14, r3)     // Catch:{ all -> 0x015e }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x015e }
                com.vungle.warren.model.Placement r2 = (com.vungle.warren.model.Placement) r2     // Catch:{ all -> 0x015e }
                if (r15 != 0) goto L_0x002e
                r15 = 0
                goto L_0x0040
            L_0x002e:
                com.vungle.warren.AdLoader r3 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x015e }
                com.vungle.warren.persistence.Repository r3 = r3.repository     // Catch:{ all -> 0x015e }
                java.lang.Class<com.vungle.warren.model.Advertisement> r4 = com.vungle.warren.model.Advertisement.class
                com.vungle.warren.persistence.FutureResult r15 = r3.load(r15, r4)     // Catch:{ all -> 0x015e }
                java.lang.Object r15 = r15.get()     // Catch:{ all -> 0x015e }
                com.vungle.warren.model.Advertisement r15 = (com.vungle.warren.model.Advertisement) r15     // Catch:{ all -> 0x015e }
            L_0x0040:
                r3 = 26
                r4 = 4
                r5 = 0
                if (r2 != 0) goto L_0x0076
                if (r15 == 0) goto L_0x0057
                com.vungle.warren.AdLoader r2 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0052 }
                com.vungle.warren.persistence.Repository r2 = r2.repository     // Catch:{ DBException -> 0x0052 }
                r2.saveAndApplyState(r15, r14, r4)     // Catch:{ DBException -> 0x0052 }
                goto L_0x0057
            L_0x0052:
                com.vungle.warren.error.VungleException r13 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x015e }
                r13.<init>(r3)     // Catch:{ all -> 0x015e }
            L_0x0057:
                if (r1 == 0) goto L_0x006f
                java.util.Set<com.vungle.warren.LoadAdCallback> r15 = r1.loadAdCallbacks     // Catch:{ all -> 0x015e }
                java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x015e }
            L_0x005f:
                boolean r1 = r15.hasNext()     // Catch:{ all -> 0x015e }
                if (r1 == 0) goto L_0x006f
                java.lang.Object r1 = r15.next()     // Catch:{ all -> 0x015e }
                com.vungle.warren.LoadAdCallback r1 = (com.vungle.warren.LoadAdCallback) r1     // Catch:{ all -> 0x015e }
                r1.onError(r14, r13)     // Catch:{ all -> 0x015e }
                goto L_0x005f
            L_0x006f:
                com.vungle.warren.AdLoader r13 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x015e }
                r13.setLoading(r14, r5)     // Catch:{ all -> 0x015e }
                monitor-exit(r0)     // Catch:{ all -> 0x015e }
                return
            L_0x0076:
                int r2 = r13.getExceptionCode()     // Catch:{ all -> 0x015e }
                r6 = 1
                if (r2 == r6) goto L_0x009f
                r7 = 14
                if (r2 == r7) goto L_0x009f
                r7 = 20
                if (r2 == r7) goto L_0x009c
                r7 = 25
                if (r2 == r7) goto L_0x009f
                r7 = 22
                if (r2 == r7) goto L_0x009c
                r7 = 23
                if (r2 == r7) goto L_0x0092
                goto L_0x0098
            L_0x0092:
                if (r15 == 0) goto L_0x0098
                r2 = 0
                r7 = 1
                r8 = 0
                goto L_0x00a1
            L_0x0098:
                r2 = 0
            L_0x0099:
                r7 = 0
            L_0x009a:
                r8 = 4
                goto L_0x00a1
            L_0x009c:
                r2 = 0
                r7 = 1
                goto L_0x009a
            L_0x009f:
                r2 = 1
                goto L_0x0099
            L_0x00a1:
                if (r1 == 0) goto L_0x00a7
                boolean r9 = r1.logError     // Catch:{ all -> 0x015e }
                if (r9 == 0) goto L_0x00c4
            L_0x00a7:
                java.lang.String r9 = com.vungle.warren.AdLoader.TAG     // Catch:{ all -> 0x015e }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x015e }
                r10.<init>()     // Catch:{ all -> 0x015e }
                java.lang.String r11 = "Failed to load Ad/Assets for "
                r10.append(r11)     // Catch:{ all -> 0x015e }
                r10.append(r14)     // Catch:{ all -> 0x015e }
                java.lang.String r11 = ". Cause : "
                r10.append(r11)     // Catch:{ all -> 0x015e }
                java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x015e }
                android.util.Log.e(r9, r10, r13)     // Catch:{ all -> 0x015e }
            L_0x00c4:
                com.vungle.warren.AdLoader r9 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x015e }
                r9.setLoading(r14, r5)     // Catch:{ all -> 0x015e }
                if (r1 == 0) goto L_0x015c
                int r9 = r1.policy     // Catch:{ DBException -> 0x0141 }
                r10 = 2
                if (r9 != 0) goto L_0x0100
                int r2 = r1.retry     // Catch:{ DBException -> 0x0141 }
                int r5 = r1.retryLimit     // Catch:{ DBException -> 0x0141 }
                if (r2 >= r5) goto L_0x0135
                if (r7 == 0) goto L_0x0135
                if (r15 == 0) goto L_0x00e4
                com.vungle.warren.AdLoader r13 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0141 }
                com.vungle.warren.persistence.Repository r13 = r13.repository     // Catch:{ DBException -> 0x0141 }
                r13.saveAndApplyState(r15, r14, r8)     // Catch:{ DBException -> 0x0141 }
            L_0x00e4:
                com.vungle.warren.AdLoader r13 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0141 }
                long r4 = r1.retryDelay     // Catch:{ DBException -> 0x0141 }
                com.vungle.warren.AdLoader$Operation r15 = r1.delay(r4)     // Catch:{ DBException -> 0x0141 }
                long r4 = r1.retryDelay     // Catch:{ DBException -> 0x0141 }
                long r4 = r4 * r10
                com.vungle.warren.AdLoader$Operation r15 = r15.retryDelay(r4)     // Catch:{ DBException -> 0x0141 }
                int r2 = r1.retry     // Catch:{ DBException -> 0x0141 }
                int r2 = r2 + r6
                com.vungle.warren.AdLoader$Operation r15 = r15.retry(r2)     // Catch:{ DBException -> 0x0141 }
                r13.load(r15)     // Catch:{ DBException -> 0x0141 }
                monitor-exit(r0)     // Catch:{ all -> 0x015e }
                return
            L_0x0100:
                int r9 = r1.policy     // Catch:{ DBException -> 0x0141 }
                if (r9 != r6) goto L_0x0135
                if (r2 != 0) goto L_0x0135
                int r13 = r1.retry     // Catch:{ DBException -> 0x0141 }
                int r2 = r1.retryLimit     // Catch:{ DBException -> 0x0141 }
                if (r13 >= r2) goto L_0x0111
                if (r7 == 0) goto L_0x0111
                int r5 = r13 + 1
                r4 = r8
            L_0x0111:
                if (r15 == 0) goto L_0x011c
                com.vungle.warren.AdLoader r13 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0141 }
                com.vungle.warren.persistence.Repository r13 = r13.repository     // Catch:{ DBException -> 0x0141 }
                r13.saveAndApplyState(r15, r14, r4)     // Catch:{ DBException -> 0x0141 }
            L_0x011c:
                com.vungle.warren.AdLoader r13 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0141 }
                long r6 = r1.retryDelay     // Catch:{ DBException -> 0x0141 }
                com.vungle.warren.AdLoader$Operation r15 = r1.delay(r6)     // Catch:{ DBException -> 0x0141 }
                long r6 = r1.retryDelay     // Catch:{ DBException -> 0x0141 }
                long r6 = r6 * r10
                com.vungle.warren.AdLoader$Operation r15 = r15.retryDelay(r6)     // Catch:{ DBException -> 0x0141 }
                com.vungle.warren.AdLoader$Operation r15 = r15.retry(r5)     // Catch:{ DBException -> 0x0141 }
                r13.load(r15)     // Catch:{ DBException -> 0x0141 }
                monitor-exit(r0)     // Catch:{ all -> 0x015e }
                return
            L_0x0135:
                if (r15 == 0) goto L_0x0146
                com.vungle.warren.AdLoader r2 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0141 }
                com.vungle.warren.persistence.Repository r2 = r2.repository     // Catch:{ DBException -> 0x0141 }
                r2.saveAndApplyState(r15, r14, r4)     // Catch:{ DBException -> 0x0141 }
                goto L_0x0146
            L_0x0141:
                com.vungle.warren.error.VungleException r13 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x015e }
                r13.<init>(r3)     // Catch:{ all -> 0x015e }
            L_0x0146:
                java.util.Set<com.vungle.warren.LoadAdCallback> r15 = r1.loadAdCallbacks     // Catch:{ all -> 0x015e }
                java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x015e }
            L_0x014c:
                boolean r1 = r15.hasNext()     // Catch:{ all -> 0x015e }
                if (r1 == 0) goto L_0x015c
                java.lang.Object r1 = r15.next()     // Catch:{ all -> 0x015e }
                com.vungle.warren.LoadAdCallback r1 = (com.vungle.warren.LoadAdCallback) r1     // Catch:{ all -> 0x015e }
                r1.onError(r14, r13)     // Catch:{ all -> 0x015e }
                goto L_0x014c
            L_0x015c:
                monitor-exit(r0)     // Catch:{ all -> 0x015e }
                return
            L_0x015e:
                r13 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x015e }
                goto L_0x0162
            L_0x0161:
                throw r13
            L_0x0162:
                goto L_0x0161
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.DownloadAdCallback.onDownloadFailed(com.vungle.warren.error.VungleException, java.lang.String, java.lang.String):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:13|14|15|16|17|18|(2:21|19)|27) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0074 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReady(java.lang.String r4, com.vungle.warren.model.Placement r5, com.vungle.warren.model.Advertisement r6) {
            /*
                r3 = this;
                com.vungle.warren.AdLoader r0 = com.vungle.warren.AdLoader.this
                monitor-enter(r0)
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x009a }
                r2 = 0
                r1.setLoading(r4, r2)     // Catch:{ all -> 0x009a }
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x009a }
                com.vungle.warren.RuntimeValues r1 = r1.runtimeValues     // Catch:{ all -> 0x009a }
                java.util.concurrent.atomic.AtomicReference<com.vungle.warren.HeaderBiddingCallback> r1 = r1.headerBiddingCallback     // Catch:{ all -> 0x009a }
                java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x009a }
                com.vungle.warren.HeaderBiddingCallback r1 = (com.vungle.warren.HeaderBiddingCallback) r1     // Catch:{ all -> 0x009a }
                boolean r2 = r5.isHeaderBidding()     // Catch:{ all -> 0x009a }
                if (r2 == 0) goto L_0x0026
                if (r1 == 0) goto L_0x0026
                java.lang.String r2 = r6.getBidToken()     // Catch:{ all -> 0x009a }
                r1.adAvailableForBidToken(r4, r2)     // Catch:{ all -> 0x009a }
            L_0x0026:
                java.lang.String unused = com.vungle.warren.AdLoader.TAG     // Catch:{ all -> 0x009a }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
                r1.<init>()     // Catch:{ all -> 0x009a }
                java.lang.String r2 = "found already cached valid adv, calling onAdLoad "
                r1.append(r2)     // Catch:{ all -> 0x009a }
                r1.append(r4)     // Catch:{ all -> 0x009a }
                java.lang.String r2 = " callback "
                r1.append(r2)     // Catch:{ all -> 0x009a }
                r1.toString()     // Catch:{ all -> 0x009a }
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x009a }
                com.vungle.warren.RuntimeValues r1 = r1.runtimeValues     // Catch:{ all -> 0x009a }
                java.util.concurrent.atomic.AtomicReference<com.vungle.warren.InitCallback> r1 = r1.initCallback     // Catch:{ all -> 0x009a }
                java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x009a }
                com.vungle.warren.InitCallback r1 = (com.vungle.warren.InitCallback) r1     // Catch:{ all -> 0x009a }
                boolean r2 = r5.isAutoCached()     // Catch:{ all -> 0x009a }
                if (r2 == 0) goto L_0x0057
                if (r1 == 0) goto L_0x0057
                r1.onAutoCacheAdAvailable(r4)     // Catch:{ all -> 0x009a }
            L_0x0057:
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this     // Catch:{ all -> 0x009a }
                java.util.Map r1 = r1.loadOperations     // Catch:{ all -> 0x009a }
                java.lang.Object r1 = r1.remove(r4)     // Catch:{ all -> 0x009a }
                com.vungle.warren.AdLoader$Operation r1 = (com.vungle.warren.AdLoader.Operation) r1     // Catch:{ all -> 0x009a }
                if (r1 == 0) goto L_0x0098
                com.vungle.warren.AdConfig$AdSize r2 = r1.size     // Catch:{ all -> 0x009a }
                r5.setAdSize(r2)     // Catch:{ all -> 0x009a }
                com.vungle.warren.AdLoader r2 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0074 }
                com.vungle.warren.persistence.Repository r2 = r2.repository     // Catch:{ DBException -> 0x0074 }
                r2.save(r5)     // Catch:{ DBException -> 0x0074 }
                goto L_0x0082
            L_0x0074:
                com.vungle.warren.error.VungleException r5 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x009a }
                r2 = 26
                r5.<init>(r2)     // Catch:{ all -> 0x009a }
                java.lang.String r6 = r6.getId()     // Catch:{ all -> 0x009a }
                r3.onDownloadFailed(r5, r4, r6)     // Catch:{ all -> 0x009a }
            L_0x0082:
                java.util.Set<com.vungle.warren.LoadAdCallback> r5 = r1.loadAdCallbacks     // Catch:{ all -> 0x009a }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x009a }
            L_0x0088:
                boolean r6 = r5.hasNext()     // Catch:{ all -> 0x009a }
                if (r6 == 0) goto L_0x0098
                java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x009a }
                com.vungle.warren.LoadAdCallback r6 = (com.vungle.warren.LoadAdCallback) r6     // Catch:{ all -> 0x009a }
                r6.onAdLoad(r4)     // Catch:{ all -> 0x009a }
                goto L_0x0088
            L_0x0098:
                monitor-exit(r0)     // Catch:{ all -> 0x009a }
                return
            L_0x009a:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x009a }
                goto L_0x009e
            L_0x009d:
                throw r4
            L_0x009e:
                goto L_0x009d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.DownloadAdCallback.onReady(java.lang.String, com.vungle.warren.model.Placement, com.vungle.warren.model.Advertisement):void");
        }
    }

    interface DownloadCallback {
        void onDownloadCompleted(String str, String str2);

        void onDownloadFailed(VungleException vungleException, String str, String str2);

        void onReady(String str, Placement placement, Advertisement advertisement);
    }

    public static class Operation {
        long delay;

        /* renamed from: id */
        final String f14484id;
        final Set<LoadAdCallback> loadAdCallbacks = new CopyOnWriteArraySet();
        final AtomicBoolean loading;
        boolean logError;
        int policy;
        @Priority
        int priority;
        List<DownloadRequest> requests = new CopyOnWriteArrayList();
        int retry;
        long retryDelay;
        int retryLimit;
        final AdConfig.AdSize size;

        Operation(String str, AdConfig.AdSize adSize, long j, long j2, int i, int i2, int i3, boolean z, @Priority int i4, LoadAdCallback... loadAdCallbackArr) {
            this.f14484id = str;
            this.delay = j;
            this.retryDelay = j2;
            this.retryLimit = i;
            this.policy = i2;
            this.retry = i3;
            this.loading = new AtomicBoolean();
            this.size = adSize;
            this.logError = z;
            this.priority = i4;
            if (loadAdCallbackArr != null) {
                this.loadAdCallbacks.addAll(Arrays.asList(loadAdCallbackArr));
            }
        }

        /* access modifiers changed from: package-private */
        public Operation delay(long j) {
            return new Operation(this.f14484id, this.size, j, this.retryDelay, this.retryLimit, this.policy, this.retry, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        /* access modifiers changed from: package-private */
        public void merge(Operation operation) {
            this.delay = Math.min(this.delay, operation.delay);
            this.retryDelay = Math.min(this.retryDelay, operation.retryDelay);
            this.retryLimit = Math.min(this.retryLimit, operation.retryLimit);
            int i = operation.policy;
            if (i != 0) {
                i = this.policy;
            }
            this.policy = i;
            this.retry = Math.min(this.retry, operation.retry);
            this.logError |= operation.logError;
            this.priority = Math.min(this.priority, operation.priority);
            this.loadAdCallbacks.addAll(operation.loadAdCallbacks);
        }

        /* access modifiers changed from: package-private */
        public Operation retry(int i) {
            return new Operation(this.f14484id, this.size, this.delay, this.retryDelay, this.retryLimit, this.policy, i, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        /* access modifiers changed from: package-private */
        public Operation retryDelay(long j) {
            return new Operation(this.f14484id, this.size, this.delay, j, this.retryLimit, this.policy, this.retry, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        public String toString() {
            return "id=" + this.f14484id + " size=" + this.size.toString() + " priority=" + this.priority + " policy=" + this.policy + " retry=" + this.retry + "/" + this.retryLimit + " delay=" + this.delay + "->" + this.retryDelay + " log=" + this.logError;
        }
    }

    public AdLoader(Executors executors, Repository repository2, VungleApiClient vungleApiClient2, CacheManager cacheManager2, Downloader downloader2, RuntimeValues runtimeValues2, VungleStaticApi vungleStaticApi, VisionController visionController2, OperationSequence operationSequence) {
        this.sdkExecutors = executors;
        this.repository = repository2;
        this.vungleApiClient = vungleApiClient2;
        this.cacheManager = cacheManager2;
        this.downloader = downloader2;
        this.runtimeValues = runtimeValues2;
        this.vungleApi = vungleStaticApi;
        this.visionController = visionController2;
        this.sequence = operationSequence;
        operationSequence.init(this, this.loadOperations);
    }

    /* access modifiers changed from: private */
    public boolean canReDownload(Advertisement advertisement) {
        List<AdAsset> list;
        if (advertisement == null || ((advertisement.getState() != 0 && advertisement.getState() != 1) || (list = this.repository.loadAllAdAssets(advertisement.getId()).get()) == null || list.size() == 0)) {
            return false;
        }
        for (AdAsset adAsset : list) {
            if (adAsset.fileType == 1) {
                if (!fileIsValid(new File(adAsset.localPath), adAsset)) {
                    return false;
                }
            } else if (TextUtils.isEmpty(adAsset.serverPath)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downloadAdAssets(com.vungle.warren.AdLoader.Operation r10, com.vungle.warren.model.Advertisement r11, com.vungle.warren.AdLoader.DownloadCallback r12) {
        /*
            r9 = this;
            com.vungle.warren.OperationSequence r0 = r9.sequence
            java.lang.String r1 = r10.f14484id
            r0.reportFinished(r1)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r0 = r10.requests
            r0.clear()
            java.util.Map r0 = r11.getDownloadableUrls()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0070
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0048
            java.lang.Object r2 = r1.getValue()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0048
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = android.webkit.URLUtil.isValidUrl(r1)
            if (r1 != 0) goto L_0x0018
        L_0x0048:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r1 = 11
            r0.<init>(r1)
            java.lang.String r10 = r10.f14484id
            r1 = 0
            r12.onDownloadFailed(r0, r10, r1)
            java.lang.String r10 = TAG
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Aborting, Failed to download Ad assets for: "
            r12.append(r0)
            java.lang.String r11 = r11.getId()
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            android.util.Log.e(r10, r11)
            return
        L_0x0070:
            com.vungle.warren.DownloadCallbackWrapper r0 = new com.vungle.warren.DownloadCallbackWrapper
            com.vungle.warren.utility.Executors r1 = r9.sdkExecutors
            java.util.concurrent.ExecutorService r1 = r1.getUIExecutor()
            r0.<init>(r1, r12)
            r1 = 26
            com.vungle.warren.persistence.Repository r2 = r9.repository     // Catch:{ DBException -> 0x016e }
            r2.save(r11)     // Catch:{ DBException -> 0x016e }
            com.vungle.warren.persistence.Repository r12 = r9.repository
            java.lang.String r2 = r11.getId()
            com.vungle.warren.persistence.FutureResult r12 = r12.loadAllAdAssets(r2)
            java.lang.Object r12 = r12.get()
            java.util.List r12 = (java.util.List) r12
            if (r12 != 0) goto L_0x00a3
            com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
            r12.<init>(r1)
            java.lang.String r10 = r10.f14484id
            java.lang.String r11 = r11.getId()
            r0.onDownloadFailed(r12, r10, r11)
            return
        L_0x00a3:
            java.util.Iterator r12 = r12.iterator()
        L_0x00a7:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x0141
            java.lang.Object r2 = r12.next()
            com.vungle.warren.model.AdAsset r2 = (com.vungle.warren.model.AdAsset) r2
            int r3 = r2.status
            r4 = 3
            r5 = 24
            r6 = 1
            if (r3 != r4) goto L_0x00dc
            java.io.File r3 = new java.io.File
            java.lang.String r4 = r2.localPath
            r3.<init>(r4)
            boolean r3 = r9.fileIsValid(r3, r2)
            if (r3 == 0) goto L_0x00c9
            goto L_0x00a7
        L_0x00c9:
            int r3 = r2.fileType
            if (r3 != r6) goto L_0x00dc
            com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
            r12.<init>(r5)
            java.lang.String r10 = r10.f14484id
            java.lang.String r11 = r11.getId()
            r0.onDownloadFailed(r12, r10, r11)
            return
        L_0x00dc:
            int r3 = r2.status
            r4 = 4
            if (r3 != r4) goto L_0x00e6
            int r3 = r2.fileType
            if (r3 != 0) goto L_0x00e6
            goto L_0x00a7
        L_0x00e6:
            java.lang.String r3 = r2.serverPath
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x00fd
            com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
            r12.<init>(r5)
            java.lang.String r10 = r10.f14484id
            java.lang.String r11 = r11.getId()
            r0.onDownloadFailed(r12, r10, r11)
            return
        L_0x00fd:
            int r3 = r10.priority
            com.vungle.warren.downloader.DownloadRequest r3 = r9.getDownloadRequest(r2, r3)
            int r4 = r2.status
            if (r4 != r6) goto L_0x0114
            com.vungle.warren.downloader.Downloader r4 = r9.downloader
            r7 = 1000(0x3e8, double:4.94E-321)
            r4.cancelAndAwait(r3, r7)
            int r3 = r10.priority
            com.vungle.warren.downloader.DownloadRequest r3 = r9.getDownloadRequest(r2, r3)
        L_0x0114:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Starting download for "
            r4.append(r5)
            r4.append(r2)
            r4.toString()
            r2.status = r6
            com.vungle.warren.persistence.Repository r4 = r9.repository     // Catch:{ DBException -> 0x0132 }
            r4.save(r2)     // Catch:{ DBException -> 0x0132 }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r2 = r10.requests
            r2.add(r3)
            goto L_0x00a7
        L_0x0132:
            com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
            r12.<init>(r1)
            java.lang.String r10 = r10.f14484id
            java.lang.String r11 = r11.getId()
            r0.onDownloadFailed(r12, r10, r11)
            return
        L_0x0141:
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r12 = r10.requests
            int r12 = r12.size()
            if (r12 != 0) goto L_0x0151
            java.lang.String r10 = r10.f14484id
            java.util.List r12 = java.util.Collections.EMPTY_LIST
            r9.onAssetDownloadFinished(r10, r0, r11, r12)
            return
        L_0x0151:
            com.vungle.warren.downloader.AssetDownloadListener r11 = r9.getAssetDownloadListener(r11, r10, r0)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r10 = r10.requests
            java.util.Iterator r10 = r10.iterator()
        L_0x015b:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x016d
            java.lang.Object r12 = r10.next()
            com.vungle.warren.downloader.DownloadRequest r12 = (com.vungle.warren.downloader.DownloadRequest) r12
            com.vungle.warren.downloader.Downloader r0 = r9.downloader
            r0.download(r12, r11)
            goto L_0x015b
        L_0x016d:
            return
        L_0x016e:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r0.<init>(r1)
            java.lang.String r10 = r10.f14484id
            java.lang.String r11 = r11.getId()
            r12.onDownloadFailed(r0, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.downloadAdAssets(com.vungle.warren.AdLoader$Operation, com.vungle.warren.model.Advertisement, com.vungle.warren.AdLoader$DownloadCallback):void");
    }

    /* access modifiers changed from: private */
    public void fetchAdMetadata(Operation operation, Placement placement, DownloadCallback downloadCallback) {
        final HeaderBiddingCallback headerBiddingCallback = this.runtimeValues.headerBiddingCallback.get();
        final long currentTimeMillis = System.currentTimeMillis();
        final DownloadCallback downloadCallback2 = downloadCallback;
        final Operation operation2 = operation;
        this.vungleApiClient.requestAd(operation.f14484id, AdConfig.AdSize.isBannerAdSize(operation.size) ? operation.size.getName() : "", placement.isHeaderBidding(), this.visionController.isEnabled() ? this.visionController.getPayload() : null).enqueue(new Callback<JsonObject>() {
            public void onFailure(Call<JsonObject> call, Throwable th) {
                downloadCallback2.onDownloadFailed(AdLoader.this.retrofitToVungleException(th), operation2.f14484id, (String) null);
            }

            public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        int state;
                        Placement placement = AdLoader.this.repository.load(operation2.f14484id, Placement.class).get();
                        if (placement == null) {
                            Log.e(AdLoader.TAG, "Placement metadata not found for requested advertisement.");
                            downloadCallback2.onDownloadFailed(new VungleException(2), operation2.f14484id, (String) null);
                        } else if (!response.isSuccessful()) {
                            long retryAfterHeaderValue = AdLoader.this.vungleApiClient.getRetryAfterHeaderValue(response);
                            if (retryAfterHeaderValue <= 0 || !placement.isAutoCached()) {
                                Log.e(AdLoader.TAG, "Failed to retrieve advertisement information");
                                C53892 r0 = C53892.this;
                                downloadCallback2.onDownloadFailed(AdLoader.this.reposeCodeToVungleException(response.code()), operation2.f14484id, (String) null);
                                return;
                            }
                            C53892 r3 = C53892.this;
                            AdLoader.this.loadEndless(placement, operation2.size, retryAfterHeaderValue);
                            downloadCallback2.onDownloadFailed(new VungleException(14), operation2.f14484id, (String) null);
                        } else {
                            JsonObject jsonObject = (JsonObject) response.body();
                            String unused = AdLoader.TAG;
                            "Ads Response: " + jsonObject;
                            if (jsonObject == null || !jsonObject.has("ads") || jsonObject.get("ads").isJsonNull()) {
                                downloadCallback2.onDownloadFailed(new VungleException(1), operation2.f14484id, (String) null);
                                return;
                            }
                            JsonArray asJsonArray = jsonObject.getAsJsonArray("ads");
                            if (asJsonArray == null || asJsonArray.size() == 0) {
                                downloadCallback2.onDownloadFailed(new VungleException(1), operation2.f14484id, (String) null);
                                return;
                            }
                            JsonObject asJsonObject = asJsonArray.get(0).getAsJsonObject();
                            try {
                                Advertisement advertisement = new Advertisement(asJsonObject);
                                if (AdLoader.this.visionController.isEnabled()) {
                                    JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("ad_markup");
                                    if (JsonUtil.hasNonNull(asJsonObject2, "data_science_cache")) {
                                        AdLoader.this.visionController.setDataScienceCache(asJsonObject2.get("data_science_cache").getAsString());
                                    } else {
                                        AdLoader.this.visionController.setDataScienceCache((String) null);
                                    }
                                }
                                Advertisement advertisement2 = AdLoader.this.repository.load(advertisement.getId(), Advertisement.class).get();
                                if (advertisement2 == null || !((state = advertisement2.getState()) == 0 || state == 1 || state == 2)) {
                                    if (placement.isHeaderBidding() && headerBiddingCallback != null) {
                                        headerBiddingCallback.onBidTokenAvailable(operation2.f14484id, advertisement.getBidToken());
                                    }
                                    AdLoader.this.repository.deleteAdvertisement(advertisement.getId());
                                    Set<Map.Entry<String, String>> entrySet = advertisement.getDownloadableUrls().entrySet();
                                    File destinationDir = AdLoader.this.getDestinationDir(advertisement);
                                    if (destinationDir != null) {
                                        if (destinationDir.isDirectory()) {
                                            for (Map.Entry next : entrySet) {
                                                if (!URLUtil.isHttpsUrl((String) next.getValue())) {
                                                    if (!URLUtil.isHttpUrl((String) next.getValue())) {
                                                        downloadCallback2.onDownloadFailed(new VungleException(11), operation2.f14484id, advertisement.getId());
                                                        return;
                                                    }
                                                }
                                                AdLoader.this.saveAsset(advertisement, destinationDir, (String) next.getKey(), (String) next.getValue());
                                            }
                                            if (placement.getPlacementAdType() != 1 || (advertisement.getAdType() == 1 && "banner".equals(advertisement.getTemplateType()))) {
                                                advertisement.getAdConfig().setAdSize(operation2.size);
                                                advertisement.setAdRequestStartTime(currentTimeMillis);
                                                advertisement.setAssetDownloadStartTime(System.currentTimeMillis());
                                                AdLoader.this.repository.saveAndApplyState(advertisement, operation2.f14484id, 0);
                                                AdLoader.this.downloadAdAssets(operation2, advertisement, downloadCallback2);
                                                return;
                                            }
                                            downloadCallback2.onDownloadFailed(new VungleException(1), operation2.f14484id, advertisement.getId());
                                            return;
                                        }
                                    }
                                    downloadCallback2.onDownloadFailed(new VungleException(26), operation2.f14484id, advertisement.getId());
                                    return;
                                }
                                String unused2 = AdLoader.TAG;
                                downloadCallback2.onDownloadFailed(new VungleException(25), operation2.f14484id, (String) null);
                            } catch (IllegalArgumentException unused3) {
                                JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("ad_markup");
                                if (asJsonObject3.has("sleep")) {
                                    long asInt = (long) asJsonObject3.get("sleep").getAsInt();
                                    placement.snooze(asInt);
                                    try {
                                        AdLoader.this.repository.save(placement);
                                        if (placement.isAutoCached()) {
                                            C53892 r32 = C53892.this;
                                            AdLoader.this.loadEndless(placement, operation2.size, asInt * 1000);
                                        }
                                    } catch (DatabaseHelper.DBException unused4) {
                                        downloadCallback2.onDownloadFailed(new VungleException(26), operation2.f14484id, (String) null);
                                        return;
                                    }
                                }
                                downloadCallback2.onDownloadFailed(new VungleException(1), operation2.f14484id, (String) null);
                            } catch (DatabaseHelper.DBException unused5) {
                                downloadCallback2.onDownloadFailed(new VungleException(26), operation2.f14484id, (String) null);
                            }
                        }
                    }
                });
            }
        });
    }

    private boolean fileIsValid(File file, AdAsset adAsset) {
        return file.exists() && file.length() == adAsset.fileSize;
    }

    private AssetDownloadListener getAssetDownloadListener(final Advertisement advertisement, final Operation operation, final DownloadCallback downloadCallback) {
        return new AssetDownloadListener() {
            AtomicLong downloadCount = new AtomicLong((long) operation.requests.size());
            List<AssetDownloadListener.DownloadError> errors = Collections.synchronizedList(new ArrayList());

            public void onError(final AssetDownloadListener.DownloadError downloadError, final DownloadRequest downloadRequest) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        AdAsset adAsset;
                        Log.e(AdLoader.TAG, "Download Failed");
                        DownloadRequest downloadRequest = downloadRequest;
                        if (downloadRequest != null) {
                            String str = downloadRequest.cookieString;
                            if (TextUtils.isEmpty(str)) {
                                adAsset = null;
                            } else {
                                adAsset = AdLoader.this.repository.load(str, AdAsset.class).get();
                            }
                            if (adAsset != null) {
                                C53913.this.errors.add(downloadError);
                                adAsset.status = 2;
                                try {
                                    AdLoader.this.repository.save(adAsset);
                                } catch (DatabaseHelper.DBException unused) {
                                    C53913.this.errors.add(new AssetDownloadListener.DownloadError(-1, new VungleException(26), 4));
                                }
                            } else {
                                C53913.this.errors.add(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 1));
                            }
                        } else {
                            C53913.this.errors.add(new AssetDownloadListener.DownloadError(-1, new RuntimeException("error in request"), 4));
                        }
                        if (C53913.this.downloadCount.decrementAndGet() <= 0) {
                            C53913 r0 = C53913.this;
                            AdLoader.this.onAssetDownloadFinished(operation.f14484id, downloadCallback, advertisement, r0.errors);
                        }
                    }
                });
            }

            public void onProgress(AssetDownloadListener.Progress progress, DownloadRequest downloadRequest) {
            }

            public void onSuccess(final File file, final DownloadRequest downloadRequest) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        AdAsset adAsset;
                        if (!file.exists()) {
                            C53913.this.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 3), downloadRequest);
                            return;
                        }
                        String str = downloadRequest.cookieString;
                        if (str == null) {
                            adAsset = null;
                        } else {
                            adAsset = AdLoader.this.repository.load(str, AdAsset.class).get();
                        }
                        if (adAsset == null) {
                            C53913.this.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 1), downloadRequest);
                            return;
                        }
                        adAsset.fileType = AdLoader.this.isZip(file) ? 0 : 2;
                        adAsset.fileSize = file.length();
                        adAsset.status = 3;
                        try {
                            AdLoader.this.repository.save(adAsset);
                            if (C53913.this.downloadCount.decrementAndGet() <= 0) {
                                C53913 r0 = C53913.this;
                                AdLoader.this.onAssetDownloadFinished(operation.f14484id, downloadCallback, advertisement, r0.errors);
                            }
                        } catch (DatabaseHelper.DBException unused) {
                            C53913.this.onError(new AssetDownloadListener.DownloadError(-1, new VungleException(26), 4), downloadRequest);
                        }
                    }
                });
            }
        };
    }

    @DownloadRequest.Priority
    private int getAssetPriority(@Priority int i) {
        return Math.max(-2147483646, i);
    }

    private DownloadRequest getDownloadRequest(AdAsset adAsset, @Priority int i) {
        return new DownloadRequest(3, getAssetPriority(i), adAsset.serverPath, adAsset.localPath, false, adAsset.identifier);
    }

    /* access modifiers changed from: private */
    public boolean isSizeInvalid(Placement placement, AdConfig.AdSize adSize) {
        if (placement.getPlacementAdType() == 1 && !AdConfig.AdSize.isBannerAdSize(adSize)) {
            return true;
        }
        if (placement.getPlacementAdType() != 0 || !AdConfig.AdSize.isBannerAdSize(adSize)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean isZip(File file) {
        return file.getName().equals(Advertisement.KEY_POSTROLL) || file.getName().equals("template");
    }

    private void loadAd(Operation operation, DownloadCallbackWrapper downloadCallbackWrapper) {
        final long currentTimeMillis = System.currentTimeMillis();
        final DownloadCallbackWrapper downloadCallbackWrapper2 = downloadCallbackWrapper;
        final Operation operation2 = operation;
        this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                if (!AdLoader.this.vungleApi.isInitialized()) {
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(9), operation2.f14484id, (String) null);
                    return;
                }
                Placement placement = AdLoader.this.repository.load(operation2.f14484id, Placement.class).get();
                if (placement == null) {
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(13), operation2.f14484id, (String) null);
                } else if (AdLoader.this.isSizeInvalid(placement, operation2.size)) {
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(28), operation2.f14484id, (String) null);
                } else {
                    Advertisement advertisement = AdLoader.this.repository.findValidAdvertisementForPlacement(placement.getId()).get();
                    if (!(placement.getPlacementAdType() != 1 || advertisement == null || advertisement.getAdConfig().getAdSize() == operation2.size)) {
                        try {
                            AdLoader.this.repository.deleteAdvertisement(advertisement.getId());
                        } catch (DatabaseHelper.DBException unused) {
                            downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.f14484id, (String) null);
                            return;
                        }
                    }
                    if (advertisement != null && AdLoader.this.canPlayAd(advertisement)) {
                        AdLoader.this.sequence.reportFinished(operation2.f14484id);
                        downloadCallbackWrapper2.onReady(operation2.f14484id, placement, advertisement);
                    } else if (AdLoader.this.canReDownload(advertisement)) {
                        String unused2 = AdLoader.TAG;
                        VungleSettings vungleSettings = AdLoader.this.runtimeValues.settings.get();
                        if (vungleSettings == null || AdLoader.this.cacheManager.getBytesAvailable() < vungleSettings.getMinimumSpaceForAd()) {
                            if (advertisement.getState() != 4) {
                                try {
                                    AdLoader.this.repository.saveAndApplyState(advertisement, operation2.f14484id, 4);
                                } catch (DatabaseHelper.DBException unused3) {
                                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.f14484id, (String) null);
                                    return;
                                }
                            }
                            downloadCallbackWrapper2.onDownloadFailed(new VungleException(19), operation2.f14484id, (String) null);
                            return;
                        }
                        AdLoader.this.setLoading(operation2.f14484id, true);
                        if (advertisement.getState() != 0) {
                            try {
                                AdLoader.this.repository.saveAndApplyState(advertisement, operation2.f14484id, 0);
                            } catch (DatabaseHelper.DBException unused4) {
                                downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.f14484id, (String) null);
                                return;
                            }
                        }
                        advertisement.setAdRequestStartTime(currentTimeMillis);
                        advertisement.setAssetDownloadStartTime(System.currentTimeMillis());
                        AdLoader.this.downloadAdAssets(operation2, advertisement, downloadCallbackWrapper2);
                    } else if (placement.getWakeupTime() > System.currentTimeMillis()) {
                        downloadCallbackWrapper2.onDownloadFailed(new VungleException(1), operation2.f14484id, (String) null);
                        Log.w(AdLoader.TAG, "Placement " + placement.getId() + " is  snoozed");
                        if (placement.isAutoCached()) {
                            String unused5 = AdLoader.TAG;
                            "Placement " + placement.getId() + " is sleeping rescheduling it ";
                            AdLoader.this.loadEndless(placement, operation2.size, placement.getWakeupTime() - System.currentTimeMillis());
                        }
                    } else {
                        String unused6 = AdLoader.TAG;
                        "didn't find cached adv for " + operation2.f14484id + " downloading ";
                        if (advertisement != null) {
                            try {
                                AdLoader.this.repository.saveAndApplyState(advertisement, operation2.f14484id, 4);
                            } catch (DatabaseHelper.DBException unused7) {
                                downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.f14484id, (String) null);
                                return;
                            }
                        }
                        VungleSettings vungleSettings2 = AdLoader.this.runtimeValues.settings.get();
                        if (vungleSettings2 == null || AdLoader.this.cacheManager.getBytesAvailable() >= vungleSettings2.getMinimumSpaceForAd()) {
                            String unused8 = AdLoader.TAG;
                            "No adv for placement " + placement.getId() + " getting new data ";
                            AdLoader.this.setLoading(operation2.f14484id, true);
                            AdLoader.this.fetchAdMetadata(operation2, placement, downloadCallbackWrapper2);
                            return;
                        }
                        downloadCallbackWrapper2.onDownloadFailed(new VungleException(placement.isAutoCached() ? 18 : 17), operation2.f14484id, (String) null);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void onAssetDownloadFinished(String str, DownloadCallback downloadCallback, Advertisement advertisement, List<AssetDownloadListener.DownloadError> list) {
        if (list.isEmpty()) {
            List<AdAsset> list2 = this.repository.loadAllAdAssets(advertisement.getId()).get();
            if (list2 == null || list2.size() == 0) {
                downloadCallback.onDownloadFailed(new VungleException(24), str, advertisement.getId());
                return;
            }
            for (AdAsset adAsset : list2) {
                int i = adAsset.status;
                if (i == 3) {
                    File file = new File(adAsset.localPath);
                    if (!fileIsValid(file, adAsset)) {
                        downloadCallback.onDownloadFailed(new VungleException(24), str, advertisement.getId());
                        return;
                    } else if (adAsset.fileType == 0) {
                        try {
                            unzipFile(advertisement, adAsset, file, list2);
                        } catch (IOException unused) {
                            this.downloader.dropCache(adAsset.serverPath);
                            downloadCallback.onDownloadFailed(new VungleException(24), str, advertisement.getId());
                            return;
                        } catch (DatabaseHelper.DBException unused2) {
                            downloadCallback.onDownloadFailed(new VungleException(26), str, advertisement.getId());
                            return;
                        }
                    }
                } else if (adAsset.fileType == 0 && i != 4) {
                    downloadCallback.onDownloadFailed(new VungleException(24), str, advertisement.getId());
                    return;
                }
            }
            if (advertisement.getAdType() == 1) {
                File destinationDir = getDestinationDir(advertisement);
                if (destinationDir == null || !destinationDir.isDirectory()) {
                    downloadCallback.onDownloadFailed(new VungleException(26), str, advertisement.getId());
                    return;
                }
                "saving MRAID for " + advertisement.getId();
                advertisement.setMraidAssetDir(destinationDir);
                try {
                    this.repository.save(advertisement);
                } catch (DatabaseHelper.DBException unused3) {
                    downloadCallback.onDownloadFailed(new VungleException(26), str, advertisement.getId());
                    return;
                }
            }
            downloadCallback.onDownloadCompleted(str, advertisement.getId());
            return;
        }
        VungleException vungleException = null;
        Iterator<AssetDownloadListener.DownloadError> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AssetDownloadListener.DownloadError next = it.next();
            if (VungleException.getExceptionCode(next.cause) != 26) {
                if (recoverableServerCode(next.serverCode) && next.reason == 1) {
                    vungleException = new VungleException(23);
                } else if (next.reason == 0) {
                    vungleException = new VungleException(23);
                } else {
                    vungleException = new VungleException(24);
                }
                if (vungleException.getExceptionCode() == 24) {
                    break;
                }
            } else {
                vungleException = new VungleException(26);
                break;
            }
        }
        downloadCallback.onDownloadFailed(vungleException, str, advertisement.getId());
    }

    private void onError(Operation operation, @VungleException.ExceptionCode int i) {
        if (operation != null) {
            for (LoadAdCallback onError : operation.loadAdCallbacks) {
                onError.onError(operation.f14484id, new VungleException(i));
            }
        }
    }

    private boolean recoverableServerCode(int i) {
        return i == 408 || (500 <= i && i < 600);
    }

    /* access modifiers changed from: private */
    public VungleException reposeCodeToVungleException(int i) {
        if (recoverableServerCode(i)) {
            return new VungleException(22);
        }
        return new VungleException(21);
    }

    /* access modifiers changed from: private */
    public VungleException retrofitToVungleException(Throwable th) {
        if (th instanceof UnknownHostException) {
            return new VungleException(11);
        }
        if (th instanceof IOException) {
            return new VungleException(20);
        }
        return new VungleException(11);
    }

    /* access modifiers changed from: private */
    public void setLoading(String str, boolean z) {
        Operation operation = this.loadOperations.get(str);
        if (operation != null) {
            operation.loading.set(z);
        }
    }

    private void unzipFile(Advertisement advertisement, AdAsset adAsset, final File file, List<AdAsset> list) throws IOException, DatabaseHelper.DBException {
        final ArrayList arrayList = new ArrayList();
        for (AdAsset next : list) {
            if (next.fileType == 2) {
                arrayList.add(next.localPath);
            }
        }
        File destinationDir = getDestinationDir(advertisement);
        if (destinationDir == null || !destinationDir.isDirectory()) {
            throw new IOException("Unable to access Destination Directory");
        }
        List<File> unzip = UnzipUtility.unzip(file.getPath(), destinationDir.getPath(), new UnzipUtility.Filter() {
            public boolean matches(String str) {
                File file = new File(str);
                for (String file2 : arrayList) {
                    File file3 = new File(file2);
                    if (file3.equals(file)) {
                        return false;
                    }
                    String path = file.getPath();
                    if (path.startsWith(file3.getPath() + File.separator)) {
                        return false;
                    }
                }
                return true;
            }
        });
        if (file.getName().equals("template")) {
            File file2 = new File(destinationDir.getPath() + File.separator + "mraid.js");
            if (file2.exists()) {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2, true)));
                HackMraid.apply(printWriter);
                printWriter.close();
            }
        }
        for (File next2 : unzip) {
            AdAsset adAsset2 = new AdAsset(advertisement.getId(), (String) null, next2.getPath());
            adAsset2.fileSize = next2.length();
            adAsset2.fileType = 1;
            adAsset2.parentId = adAsset.identifier;
            adAsset2.status = 3;
            this.repository.save(adAsset2);
        }
        "Uzipped " + destinationDir;
        FileUtility.printDirectoryTree(destinationDir);
        adAsset.status = 4;
        this.repository.save(adAsset, new Repository.SaveCallback() {
            public void onError(Exception exc) {
            }

            public void onSaved() {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        try {
                            FileUtility.delete(file);
                        } catch (IOException e) {
                            Log.e(AdLoader.TAG, "Error on deleting zip assets archive", e);
                        }
                    }
                });
            }
        });
    }

    public boolean canPlayAd(Advertisement advertisement) {
        if (advertisement == null || advertisement.getState() != 1) {
            return false;
        }
        return hasAssetsFor(advertisement.getId());
    }

    public boolean canRenderAd(Advertisement advertisement) {
        if (advertisement == null) {
            return false;
        }
        if (advertisement.getState() == 1 || advertisement.getState() == 2) {
            return hasAssetsFor(advertisement.getId());
        }
        return false;
    }

    public synchronized void clear() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(this.loadOperations.keySet());
        hashSet.addAll(this.pendingOperations.keySet());
        for (String str : hashSet) {
            onError(this.loadOperations.remove(str), 25);
            onError(this.pendingOperations.remove(str), 25);
        }
        for (Operation onError : this.sequence.removeAll()) {
            onError(onError, 25);
        }
    }

    public void dropCache(String str) {
        List<AdAsset> list = this.repository.loadAllAdAssets(str).get();
        if (list == null) {
            Log.w(TAG, "No assets found in ad cache to cleanup");
            return;
        }
        for (AdAsset adAsset : list) {
            this.downloader.dropCache(adAsset.serverPath);
        }
    }

    /* access modifiers changed from: package-private */
    public File getDestinationDir(Advertisement advertisement) {
        return this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
    }

    /* access modifiers changed from: package-private */
    public Collection<Operation> getPendingOperations() {
        return this.pendingOperations.values();
    }

    /* access modifiers changed from: package-private */
    public Collection<Operation> getRunningOperations() {
        return this.loadOperations.values();
    }

    /* access modifiers changed from: package-private */
    public boolean hasAssetsFor(String str) throws IllegalStateException {
        List<AdAsset> list = this.repository.loadAllAdAssets(str).get();
        if (list == null || list.size() == 0) {
            return false;
        }
        for (AdAsset adAsset : list) {
            if (adAsset.fileType == 0) {
                if (adAsset.status != 4) {
                    return false;
                }
            } else if (adAsset.status != 3 || !fileIsValid(new File(adAsset.localPath), adAsset)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void init(JobRunner jobRunner2) {
        this.jobRunner = jobRunner2;
        this.downloader.init();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isLoading(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.vungle.warren.OperationSequence r0 = r2.sequence     // Catch:{ all -> 0x0022 }
            boolean r0 = r0.contains(r3)     // Catch:{ all -> 0x0022 }
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r2)
            return r1
        L_0x000c:
            java.util.Map<java.lang.String, com.vungle.warren.AdLoader$Operation> r0 = r2.loadOperations     // Catch:{ all -> 0x0022 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0022 }
            com.vungle.warren.AdLoader$Operation r3 = (com.vungle.warren.AdLoader.Operation) r3     // Catch:{ all -> 0x0022 }
            if (r3 == 0) goto L_0x001f
            java.util.concurrent.atomic.AtomicBoolean r3 = r3.loading     // Catch:{ all -> 0x0022 }
            boolean r3 = r3.get()     // Catch:{ all -> 0x0022 }
            if (r3 == 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            monitor-exit(r2)
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.isLoading(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void load(com.vungle.warren.AdLoader.Operation r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.vungle.warren.tasks.JobRunner r0 = r5.jobRunner     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x000c
            r0 = 9
            r5.onError(r6, r0)     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)
            return
        L_0x000c:
            java.util.Map<java.lang.String, com.vungle.warren.AdLoader$Operation> r0 = r5.pendingOperations     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = r6.f14484id     // Catch:{ all -> 0x0048 }
            java.lang.Object r0 = r0.remove(r1)     // Catch:{ all -> 0x0048 }
            com.vungle.warren.AdLoader$Operation r0 = (com.vungle.warren.AdLoader.Operation) r0     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x001b
            r6.merge(r0)     // Catch:{ all -> 0x0048 }
        L_0x001b:
            long r0 = r6.delay     // Catch:{ all -> 0x0048 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0029
            com.vungle.warren.OperationSequence r0 = r5.sequence     // Catch:{ all -> 0x0048 }
            r0.offer(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0029:
            java.util.Map<java.lang.String, com.vungle.warren.AdLoader$Operation> r0 = r5.pendingOperations     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = r6.f14484id     // Catch:{ all -> 0x0048 }
            r0.put(r1, r6)     // Catch:{ all -> 0x0048 }
            com.vungle.warren.tasks.JobRunner r0 = r5.jobRunner     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = r6.f14484id     // Catch:{ all -> 0x0048 }
            com.vungle.warren.tasks.JobInfo r1 = com.vungle.warren.tasks.DownloadJob.makeJobInfo(r1)     // Catch:{ all -> 0x0048 }
            long r2 = r6.delay     // Catch:{ all -> 0x0048 }
            com.vungle.warren.tasks.JobInfo r6 = r1.setDelay(r2)     // Catch:{ all -> 0x0048 }
            r1 = 1
            com.vungle.warren.tasks.JobInfo r6 = r6.setUpdateCurrent(r1)     // Catch:{ all -> 0x0048 }
            r0.execute(r6)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r5)
            return
        L_0x0048:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.load(com.vungle.warren.AdLoader$Operation):void");
    }

    public void loadEndless(Placement placement, AdConfig.AdSize adSize, long j) {
        if (!isSizeInvalid(placement, adSize)) {
            load(new Operation(placement.getId(), adSize, j, RETRY_DELAY, 5, 1, 0, false, placement.getAutoCachePriority(), new LoadAdCallback[0]));
        }
    }

    public synchronized void loadPendingInternal(String str) {
        Operation remove = this.pendingOperations.remove(str);
        if (remove != null) {
            load(remove.delay(0));
        }
    }

    public void onChangePriority(Operation operation) {
        for (DownloadRequest next : operation.requests) {
            next.setPriority(getAssetPriority(operation.priority));
            this.downloader.updatePriority(next);
        }
    }

    public void onLoadNext(Operation operation) {
        this.loadOperations.put(operation.f14484id, operation);
        loadAd(operation, new DownloadCallbackWrapper(this.sdkExecutors.getBackgroundExecutor(), new DownloadAdCallback()));
    }

    /* access modifiers changed from: package-private */
    public void saveAsset(Advertisement advertisement, File file, String str, String str2) throws DatabaseHelper.DBException {
        String str3 = file.getPath() + File.separator + str;
        int i = (str3.endsWith(Advertisement.KEY_POSTROLL) || str3.endsWith("template")) ? 0 : 2;
        AdAsset adAsset = new AdAsset(advertisement.getId(), str2, str3);
        adAsset.status = 0;
        adAsset.fileType = i;
        this.repository.save(adAsset);
    }

    public void loadEndless(Placement placement, long j) {
        loadEndless(placement, placement.getAdSize(), j);
    }

    public void load(String str, LoadAdCallback loadAdCallback) {
        load(new Operation(str, AdConfig.AdSize.VUNGLE_DEFAULT, 0, RETRY_DELAY, 5, 0, 0, true, 0, loadAdCallback));
    }

    public void load(String str, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        load(new Operation(str, adConfig.getAdSize(), 0, RETRY_DELAY, 5, 0, 0, true, 0, loadAdCallback));
    }
}
