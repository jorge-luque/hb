package com.android.volley;

import android.os.Process;
import com.android.volley.Cache;
import com.android.volley.Request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher extends Thread {
    private static final boolean DEBUG = VolleyLog.DEBUG;
    private final Cache mCache;
    private final BlockingQueue<Request<?>> mCacheQueue;
    /* access modifiers changed from: private */
    public final ResponseDelivery mDelivery;
    /* access modifiers changed from: private */
    public final BlockingQueue<Request<?>> mNetworkQueue;
    private volatile boolean mQuit = false;
    private final WaitingRequestManager mWaitingRequestManager;

    private static class WaitingRequestManager implements Request.NetworkRequestCompleteListener {
        private final CacheDispatcher mCacheDispatcher;
        private final Map<String, List<Request<?>>> mWaitingRequests = new HashMap();

        WaitingRequestManager(CacheDispatcher cacheDispatcher) {
            this.mCacheDispatcher = cacheDispatcher;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean maybeAddToWaitingRequests(com.android.volley.Request<?> r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                java.lang.String r0 = r6.getCacheKey()     // Catch:{ all -> 0x0052 }
                java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r1 = r5.mWaitingRequests     // Catch:{ all -> 0x0052 }
                boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0052 }
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x003a
                java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r1 = r5.mWaitingRequests     // Catch:{ all -> 0x0052 }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0052 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0052 }
                if (r1 != 0) goto L_0x001e
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
                r1.<init>()     // Catch:{ all -> 0x0052 }
            L_0x001e:
                java.lang.String r4 = "waiting-for-response"
                r6.addMarker(r4)     // Catch:{ all -> 0x0052 }
                r1.add(r6)     // Catch:{ all -> 0x0052 }
                java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r6 = r5.mWaitingRequests     // Catch:{ all -> 0x0052 }
                r6.put(r0, r1)     // Catch:{ all -> 0x0052 }
                boolean r6 = com.android.volley.VolleyLog.DEBUG     // Catch:{ all -> 0x0052 }
                if (r6 == 0) goto L_0x0038
                java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
                java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
                r1[r3] = r0     // Catch:{ all -> 0x0052 }
                com.android.volley.VolleyLog.m5686d(r6, r1)     // Catch:{ all -> 0x0052 }
            L_0x0038:
                monitor-exit(r5)
                return r2
            L_0x003a:
                java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r1 = r5.mWaitingRequests     // Catch:{ all -> 0x0052 }
                r4 = 0
                r1.put(r0, r4)     // Catch:{ all -> 0x0052 }
                r6.setNetworkRequestCompleteListener(r5)     // Catch:{ all -> 0x0052 }
                boolean r6 = com.android.volley.VolleyLog.DEBUG     // Catch:{ all -> 0x0052 }
                if (r6 == 0) goto L_0x0050
                java.lang.String r6 = "new request, sending to network %s"
                java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
                r1[r3] = r0     // Catch:{ all -> 0x0052 }
                com.android.volley.VolleyLog.m5686d(r6, r1)     // Catch:{ all -> 0x0052 }
            L_0x0050:
                monitor-exit(r5)
                return r3
            L_0x0052:
                r6 = move-exception
                monitor-exit(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.volley.CacheDispatcher.WaitingRequestManager.maybeAddToWaitingRequests(com.android.volley.Request):boolean");
        }

        public synchronized void onNoUsableResponseReceived(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List remove = this.mWaitingRequests.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.m5689v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request request2 = (Request) remove.remove(0);
                this.mWaitingRequests.put(cacheKey, remove);
                request2.setNetworkRequestCompleteListener(this);
                try {
                    this.mCacheDispatcher.mNetworkQueue.put(request2);
                } catch (InterruptedException e) {
                    VolleyLog.m5687e("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.mCacheDispatcher.quit();
                }
            }
            return;
        }

        public void onResponseReceived(Request<?> request, Response<?> response) {
            List<Request> remove;
            Cache.Entry entry = response.cacheEntry;
            if (entry == null || entry.isExpired()) {
                onNoUsableResponseReceived(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                remove = this.mWaitingRequests.remove(cacheKey);
            }
            if (remove != null) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.m5689v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                }
                for (Request postResponse : remove) {
                    this.mCacheDispatcher.mDelivery.postResponse(postResponse, response);
                }
            }
        }
    }

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.mCacheQueue = blockingQueue;
        this.mNetworkQueue = blockingQueue2;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
        this.mWaitingRequestManager = new WaitingRequestManager(this);
    }

    private void processRequest() throws InterruptedException {
        final Request take = this.mCacheQueue.take();
        take.addMarker("cache-queue-take");
        if (take.isCanceled()) {
            take.finish("cache-discard-canceled");
            return;
        }
        Cache.Entry entry = this.mCache.get(take.getCacheKey());
        if (entry == null) {
            take.addMarker("cache-miss");
            if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(take)) {
                this.mNetworkQueue.put(take);
            }
        } else if (entry.isExpired()) {
            take.addMarker("cache-hit-expired");
            take.setCacheEntry(entry);
            if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(take)) {
                this.mNetworkQueue.put(take);
            }
        } else {
            take.addMarker("cache-hit");
            Response parseNetworkResponse = take.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
            take.addMarker("cache-hit-parsed");
            if (!entry.refreshNeeded()) {
                this.mDelivery.postResponse(take, parseNetworkResponse);
                return;
            }
            take.addMarker("cache-hit-refresh-needed");
            take.setCacheEntry(entry);
            parseNetworkResponse.intermediate = true;
            if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(take)) {
                this.mDelivery.postResponse(take, parseNetworkResponse, new Runnable() {
                    public void run() {
                        try {
                            CacheDispatcher.this.mNetworkQueue.put(take);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });
            } else {
                this.mDelivery.postResponse(take, parseNetworkResponse);
            }
        }
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    public void run() {
        if (DEBUG) {
            VolleyLog.m5689v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.mCache.initialize();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    return;
                }
            }
        }
    }
}
