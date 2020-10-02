package com.vungle.warren.downloader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.p019e.C0791d;
import com.vungle.warren.downloader.AssetDownloadListener;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.NetworkProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3487c;
import p113i.C3537r;
import p113i.C3542v;
import p113i.C3548y;
import p113i.p114e0.p116f.C3512h;
import p113i.p114e0.p116f.C5940e;
import p119j.C3586u;
import p119j.C6587l;
import p119j.C6589n;

@SuppressLint({"LogNotTimber"})
public class AssetDownloader implements Downloader {
    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    private static final String ACCEPT_RANGES = "Accept-Ranges";
    private static final String BYTES = "bytes";
    private static final int CONNECTION_RETRY_TIMEOUT = 300;
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_RANGE = "Content-Range";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final int DOWNLOAD_CHUNK_SIZE = 2048;
    static final String DOWNLOAD_COMPLETE = "DOWNLOAD_COMPLETE";
    static final String DOWNLOAD_URL = "Download_URL";
    static final String ETAG = "ETag";
    private static final String GZIP = "gzip";
    private static final String IDENTITY = "identity";
    private static final String IF_MODIFIED_SINCE = "If-Modified-Since";
    private static final String IF_NONE_MATCH = "If-None-Match";
    private static final String IF_RANGE = "If-Range";
    static final String LAST_CACHE_VERIFICATION = "Last-Cache-Verification";
    static final String LAST_DOWNLOAD = "Last-Download";
    static final String LAST_MODIFIED = "Last-Modified";
    private static final long MAX_PERCENT = 100;
    private static final int MAX_RECONNECT_ATTEMPTS = 10;
    private static final String META_POSTFIX_EXT = ".vng_meta";
    private static final int PROGRESS_STEP = 5;
    private static final String RANGE = "Range";
    private static final int RANGE_NOT_SATISFIABLE = 416;
    private static final int RETRY_COUNT_ON_CONNECTION_LOST = 5;
    /* access modifiers changed from: private */
    public static final String TAG = AssetDownloader.class.getSimpleName();
    private static final int TIMEOUT = 30;
    public static final long VERIFICATION_WINDOW = TimeUnit.HOURS.toMillis(24);
    private final Object addLock;
    /* access modifiers changed from: private */
    public final DownloaderCache cache;
    private final ThreadPoolExecutor downloadExecutor;
    private boolean isCacheEnabled;
    int maxReconnectAttempts;
    private Map<String, DownloadRequestMediator> mediators;
    private final NetworkProvider.NetworkListener networkListener;
    private final NetworkProvider networkProvider;
    /* access modifiers changed from: private */
    public final C3542v okHttpClient;
    /* access modifiers changed from: private */
    public volatile int progressStep;
    int reconnectTimeout;
    int retryCountOnConnectionLost;
    private final long timeWindow;
    private List<DownloadRequest> transitioning;
    private final ExecutorService uiExecutor;

    public @interface NetworkType {
        public static final int ANY = 3;
        public static final int CELLULAR = 1;
        public static final int WIFI = 2;
    }

    public AssetDownloader(int i, NetworkProvider networkProvider2, ExecutorService executorService) {
        this((DownloaderCache) null, 0, i, networkProvider2, executorService);
    }

    private void addNetworkListener() {
        this.networkProvider.addListener(this.networkListener);
    }

    /* access modifiers changed from: private */
    public void appendHeaders(long j, File file, HashMap<String, String> hashMap, C3548y.C3549a aVar) {
        aVar.mo19615a(ACCEPT_ENCODING, IDENTITY);
        if (file.exists() && !hashMap.isEmpty()) {
            String str = hashMap.get(ETAG);
            String str2 = hashMap.get(LAST_MODIFIED);
            if (Boolean.parseBoolean(hashMap.get(DOWNLOAD_COMPLETE))) {
                if (!TextUtils.isEmpty(str)) {
                    aVar.mo19615a(IF_NONE_MATCH, str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    aVar.mo19615a(IF_MODIFIED_SINCE, str2);
                }
            } else if (BYTES.equalsIgnoreCase(hashMap.get(ACCEPT_RANGES))) {
                if (hashMap.get(CONTENT_ENCODING) == null || IDENTITY.equalsIgnoreCase(hashMap.get(CONTENT_ENCODING))) {
                    aVar.mo19615a(RANGE, "bytes=" + j + "-");
                    if (!TextUtils.isEmpty(str)) {
                        aVar.mo19615a(IF_RANGE, str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        aVar.mo19615a(IF_RANGE, str2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkEncoding(File file, File file2, C3537r rVar) throws IOException {
        String a = rVar.mo19502a(CONTENT_ENCODING);
        if (a != null && !GZIP.equalsIgnoreCase(a) && !IDENTITY.equalsIgnoreCase(a)) {
            deleteFileAndMeta(file, file2, false);
            throw new IOException("Unknown Content-Encoding");
        }
    }

    private void copyToDestination(File file, File file2, C0791d<DownloadRequest, AssetDownloadListener> dVar) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        IOException e;
        if (file2.exists()) {
            file2.delete();
        }
        if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    channel.transferTo(0, channel.size(), fileOutputStream.getChannel());
                    "Copying: finished " + ((DownloadRequest) dVar.f1996a).url + " copying to " + file2.getPath();
                } catch (IOException e2) {
                    e = e2;
                    try {
                        deliverError((DownloadRequest) dVar.f1996a, (AssetDownloadListener) dVar.f1997b, new AssetDownloadListener.DownloadError(-1, e, 2));
                        "Copying: error" + ((DownloadRequest) dVar.f1996a).url + " copying to " + file2.getPath();
                        FileUtility.closeQuietly(fileInputStream);
                        FileUtility.closeQuietly(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                deliverError((DownloadRequest) dVar.f1996a, (AssetDownloadListener) dVar.f1997b, new AssetDownloadListener.DownloadError(-1, e, 2));
                "Copying: error" + ((DownloadRequest) dVar.f1996a).url + " copying to " + file2.getPath();
                FileUtility.closeQuietly(fileInputStream);
                FileUtility.closeQuietly(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                FileUtility.closeQuietly(fileInputStream2);
                FileUtility.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            fileInputStream = null;
            e = e4;
            fileOutputStream = null;
            deliverError((DownloadRequest) dVar.f1996a, (AssetDownloadListener) dVar.f1997b, new AssetDownloadListener.DownloadError(-1, e, 2));
            "Copying: error" + ((DownloadRequest) dVar.f1996a).url + " copying to " + file2.getPath();
            FileUtility.closeQuietly(fileInputStream);
            FileUtility.closeQuietly(fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            FileUtility.closeQuietly(fileInputStream2);
            FileUtility.closeQuietly(fileOutputStream);
            throw th;
        }
        FileUtility.closeQuietly(fileInputStream);
        FileUtility.closeQuietly(fileOutputStream);
    }

    /* access modifiers changed from: private */
    public String debugString(DownloadRequestMediator downloadRequestMediator) {
        return ", mediator url - " + downloadRequestMediator.url + ", path - " + downloadRequestMediator.filePath + ", th - " + Thread.currentThread().getName() + "id " + downloadRequestMediator;
    }

    /* access modifiers changed from: private */
    public C3484b0 decodeGzipIfNeeded(C3480a0 a0Var) {
        if (!GZIP.equalsIgnoreCase(a0Var.mo19278a(CONTENT_ENCODING)) || !C5940e.m19035b(a0Var) || a0Var.mo19284d() == null) {
            return a0Var.mo19284d();
        }
        return new C3512h(a0Var.mo19278a(CONTENT_TYPE), -1, C6589n.m21610a((C3586u) new C6587l(a0Var.mo19284d().source())));
    }

    /* access modifiers changed from: private */
    public void deleteFileAndMeta(File file, File file2, boolean z) {
        if (file != null) {
            file.delete();
            if (file2 != null) {
                file2.delete();
            }
            if (this.cache != null && isCacheEnabled()) {
                if (z) {
                    this.cache.deleteAndRemove(file);
                } else {
                    this.cache.deleteContents(file);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void deliverError(final DownloadRequest downloadRequest, final AssetDownloadListener assetDownloadListener, final AssetDownloadListener.DownloadError downloadError) {
        if (assetDownloadListener != null) {
            this.uiExecutor.execute(new Runnable() {
                public void run() {
                    assetDownloadListener.onError(downloadError, downloadRequest);
                }
            });
        }
    }

    private void deliverProgress(final AssetDownloadListener.Progress progress, final DownloadRequest downloadRequest, final AssetDownloadListener assetDownloadListener) {
        if (assetDownloadListener != null) {
            this.uiExecutor.execute(new Runnable() {
                public void run() {
                    String unused = AssetDownloader.TAG;
                    "On progress " + downloadRequest;
                    assetDownloadListener.onProgress(progress, downloadRequest);
                }
            });
        }
    }

    private void deliverSuccess(C0791d<DownloadRequest, AssetDownloadListener> dVar, File file) {
        S s = dVar.f1997b;
        if (s != null) {
            ((AssetDownloadListener) s).onSuccess(file, (DownloadRequest) dVar.f1996a);
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> extractMeta(File file) {
        return FileUtility.readMap(file.getPath());
    }

    private synchronized DownloadRequestMediator findMediatorForCancellation(DownloadRequest downloadRequest) {
        ArrayList<DownloadRequestMediator> arrayList = new ArrayList<>(2);
        arrayList.add(this.mediators.get(getCacheableKey(downloadRequest)));
        arrayList.add(this.mediators.get(getNonCacheableKey(downloadRequest)));
        for (DownloadRequestMediator downloadRequestMediator : arrayList) {
            if (downloadRequestMediator != null) {
                for (DownloadRequest equals : downloadRequestMediator.requests()) {
                    if (equals.equals(downloadRequest)) {
                        return downloadRequestMediator;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private String getCacheableKey(DownloadRequest downloadRequest) {
        return downloadRequest.url;
    }

    /* access modifiers changed from: private */
    public long getContentLength(C3480a0 a0Var) {
        if (a0Var == null) {
            return -1;
        }
        String a = a0Var.mo19290x().mo19502a("Content-Length");
        if (TextUtils.isEmpty(a)) {
            return -1;
        }
        try {
            return Long.parseLong(a);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private String getNonCacheableKey(DownloadRequest downloadRequest) {
        return downloadRequest.url + " " + downloadRequest.path;
    }

    /* access modifiers changed from: private */
    public boolean isAnyConnected(DownloadRequestMediator downloadRequestMediator) {
        for (DownloadRequest next : downloadRequestMediator.requests()) {
            if (next != null && isConnected(next)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(21)
    private boolean isConnected(DownloadRequest downloadRequest) {
        int i;
        int currentNetworkType = this.networkProvider.getCurrentNetworkType();
        boolean z = true;
        if (currentNetworkType >= 0 && downloadRequest.networkType == 3) {
            return true;
        }
        if (currentNetworkType != 0) {
            if (currentNetworkType != 1) {
                if (currentNetworkType != 4) {
                    if (currentNetworkType != 9) {
                        if (currentNetworkType != 17) {
                            if (currentNetworkType != 6) {
                                if (currentNetworkType != 7) {
                                    i = -1;
                                    if (i <= 0 || (downloadRequest.networkType & i) != i) {
                                        z = false;
                                    }
                                    "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest);
                                    return z;
                                }
                            }
                        }
                    }
                }
            }
            i = 2;
            z = false;
            "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest);
            return z;
        }
        i = 1;
        z = false;
        "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest);
        return z;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r7.transitioning.remove(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
        if (r1.mo32386is(6) != false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
        if (r1.mo32386is(3) == false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0081, code lost:
        if (r8.isCancelled() != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        if (r1.isCacheable == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        r1.add(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0090, code lost:
        if (r1.mo32386is(2) == false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0092, code lost:
        load(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
        deliverError(r8, r9, new com.vungle.warren.downloader.AssetDownloadListener.DownloadError(-1, new java.lang.IllegalArgumentException("DownloadRequest is already running"), 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        r8 = makeNewMediator(r8, r9);
        r7.mediators.put(r1.key, r8);
        load(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b4, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bd, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c1, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void launchRequest(com.vungle.warren.downloader.DownloadRequest r8, com.vungle.warren.downloader.AssetDownloadListener r9) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.Object r0 = r7.addLock
            monitor-enter(r0)
            monitor-enter(r7)     // Catch:{ all -> 0x00c5 }
            boolean r1 = r8.isCancelled()     // Catch:{ all -> 0x00c2 }
            r2 = 1
            r3 = -1
            r4 = 3
            if (r1 == 0) goto L_0x0042
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r1 = r7.transitioning     // Catch:{ all -> 0x00c2 }
            r1.remove(r8)     // Catch:{ all -> 0x00c2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            r1.<init>()     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = "Request "
            r1.append(r5)     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = r8.url     // Catch:{ all -> 0x00c2 }
            r1.append(r5)     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = " is cancelled before starting"
            r1.append(r5)     // Catch:{ all -> 0x00c2 }
            r1.toString()     // Catch:{ all -> 0x00c2 }
            com.vungle.warren.downloader.AssetDownloadListener$Progress r1 = new com.vungle.warren.downloader.AssetDownloadListener$Progress     // Catch:{ all -> 0x00c2 }
            r1.<init>()     // Catch:{ all -> 0x00c2 }
            r1.status = r4     // Catch:{ all -> 0x00c2 }
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r1 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x00c2 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = "Cancelled"
            r4.<init>(r5)     // Catch:{ all -> 0x00c2 }
            r1.<init>(r3, r4, r2)     // Catch:{ all -> 0x00c2 }
            r7.deliverError(r8, r9, r1)     // Catch:{ all -> 0x00c2 }
            monitor-exit(r7)     // Catch:{ all -> 0x00c2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c5 }
            return
        L_0x0042:
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r1 = r7.mediators     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = r7.mediatorKeyFromRequest(r8)     // Catch:{ all -> 0x00c2 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00c2 }
            com.vungle.warren.downloader.DownloadRequestMediator r1 = (com.vungle.warren.downloader.DownloadRequestMediator) r1     // Catch:{ all -> 0x00c2 }
            if (r1 != 0) goto L_0x0066
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r1 = r7.transitioning     // Catch:{ all -> 0x00c2 }
            r1.remove(r8)     // Catch:{ all -> 0x00c2 }
            com.vungle.warren.downloader.DownloadRequestMediator r8 = r7.makeNewMediator(r8, r9)     // Catch:{ all -> 0x00c2 }
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r9 = r7.mediators     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = r8.key     // Catch:{ all -> 0x00c2 }
            r9.put(r1, r8)     // Catch:{ all -> 0x00c2 }
            r7.load(r8)     // Catch:{ all -> 0x00c2 }
            monitor-exit(r7)     // Catch:{ all -> 0x00c2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c5 }
            return
        L_0x0066:
            monitor-exit(r7)     // Catch:{ all -> 0x00c2 }
            r1.lock()     // Catch:{ all -> 0x00bd }
            monitor-enter(r7)     // Catch:{ all -> 0x00bd }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r5 = r7.transitioning     // Catch:{ all -> 0x00ba }
            r5.remove(r8)     // Catch:{ all -> 0x00ba }
            r5 = 6
            boolean r5 = r1.mo32386is(r5)     // Catch:{ all -> 0x00ba }
            if (r5 != 0) goto L_0x00a6
            boolean r4 = r1.mo32386is(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x0084
            boolean r4 = r8.isCancelled()     // Catch:{ all -> 0x00ba }
            if (r4 != 0) goto L_0x0084
            goto L_0x00a6
        L_0x0084:
            boolean r4 = r1.isCacheable     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x0096
            r1.add(r8, r9)     // Catch:{ all -> 0x00ba }
            r8 = 2
            boolean r8 = r1.mo32386is(r8)     // Catch:{ all -> 0x00ba }
            if (r8 == 0) goto L_0x00b4
            r7.load(r1)     // Catch:{ all -> 0x00ba }
            goto L_0x00b4
        L_0x0096:
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r4 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x00ba }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = "DownloadRequest is already running"
            r5.<init>(r6)     // Catch:{ all -> 0x00ba }
            r4.<init>(r3, r5, r2)     // Catch:{ all -> 0x00ba }
            r7.deliverError(r8, r9, r4)     // Catch:{ all -> 0x00ba }
            goto L_0x00b4
        L_0x00a6:
            com.vungle.warren.downloader.DownloadRequestMediator r8 = r7.makeNewMediator(r8, r9)     // Catch:{ all -> 0x00ba }
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r9 = r7.mediators     // Catch:{ all -> 0x00ba }
            java.lang.String r2 = r1.key     // Catch:{ all -> 0x00ba }
            r9.put(r2, r8)     // Catch:{ all -> 0x00ba }
            r7.load(r8)     // Catch:{ all -> 0x00ba }
        L_0x00b4:
            monitor-exit(r7)     // Catch:{ all -> 0x00ba }
            r1.unlock()     // Catch:{ all -> 0x00c5 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c5 }
            return
        L_0x00ba:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00ba }
            throw r8     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r8 = move-exception
            r1.unlock()     // Catch:{ all -> 0x00c5 }
            throw r8     // Catch:{ all -> 0x00c5 }
        L_0x00c2:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00c2 }
            throw r8     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c5 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.launchRequest(com.vungle.warren.downloader.DownloadRequest, com.vungle.warren.downloader.AssetDownloadListener):void");
    }

    private synchronized void load(final DownloadRequestMediator downloadRequestMediator) {
        addNetworkListener();
        downloadRequestMediator.set(1);
        this.downloadExecutor.execute(new DownloadPriorityRunnable(downloadRequestMediator) {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v4, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v5, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v26, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v7, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v8, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v9, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: com.vungle.warren.downloader.DownloadRequestMediator} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v10, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v15, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v31, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v16, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v32, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v13, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v14, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v34, resolved type: com.vungle.warren.downloader.AssetDownloadListener$DownloadError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v15, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v19, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v35, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v16, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v36, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v17, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v37, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v38, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v41, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v19, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v39, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v20, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v21, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v40, resolved type: com.vungle.warren.downloader.AssetDownloadListener$DownloadError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v22, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v23, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v24, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v122, resolved type: j.d} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v25, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v7, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v26, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v27, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v46, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v28, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v29, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v30, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v32, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v9, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v33, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v10, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v34, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v11, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v35, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v36, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v59, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v37, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v39, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v69, resolved type: com.vungle.warren.downloader.AssetDownloadListener$DownloadError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v41, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v42, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v43, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v44, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v39, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v65, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v40, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v75, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v41, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v76, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v83, resolved type: i.e} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v79, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v45, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v80, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v52, resolved type: long} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v69, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v71, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v46, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v47, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v48, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v81, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v82, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v83, resolved type: i.a0} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v16, resolved type: i.a0} */
            /* JADX WARNING: type inference failed for: r29v1 */
            /* JADX WARNING: type inference failed for: r29v2 */
            /* JADX WARNING: type inference failed for: r29v3, types: [i.e] */
            /* JADX WARNING: type inference failed for: r8v21 */
            /* JADX WARNING: type inference failed for: r29v11 */
            /* JADX WARNING: type inference failed for: r6v22 */
            /* JADX WARNING: type inference failed for: r29v12 */
            /* JADX WARNING: type inference failed for: r6v23 */
            /* JADX WARNING: type inference failed for: r29v18 */
            /* JADX WARNING: type inference failed for: r5v21, types: [j.e, j.u, java.io.Closeable] */
            /* JADX WARNING: type inference failed for: r6v39 */
            /* JADX WARNING: type inference failed for: r29v31 */
            /* JADX WARNING: type inference failed for: r29v38 */
            /* JADX WARNING: type inference failed for: r29v40 */
            /* JADX WARNING: type inference failed for: r4v101 */
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
                	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
                	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
                */
            /* JADX WARNING: Multi-variable type inference failed */
            public void run() {
                /*
                    r32 = this;
                    r1 = r32
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    r2 = 0
                    r0.setRunnable(r2)
                    com.vungle.warren.downloader.AssetDownloadListener$Progress r3 = new com.vungle.warren.downloader.AssetDownloadListener$Progress
                    r3.<init>()
                    long r4 = java.lang.System.currentTimeMillis()
                    r3.timestampDownloadStart = r4
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    java.lang.String r4 = r0.url
                    java.lang.String r5 = r0.filePath
                    java.lang.String r0 = r0.metaPath
                    java.io.File r12 = new java.io.File
                    r12.<init>(r5)
                    java.io.File r5 = new java.io.File
                    r5.<init>(r0)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x003c
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x003c
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.startTracking(r12)
                L_0x003c:
                    r14 = r2
                    r0 = 0
                    r11 = 0
                    r15 = 0
                L_0x0040:
                    if (r0 != 0) goto L_0x0cf1
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r6 = "Start load: url: "
                    r0.append(r6)
                    r0.append(r4)
                    r0.toString()
                    r9 = 2
                    r7 = 5
                    r8 = 3
                    r6 = 4
                    r13 = 1
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x08db }
                    boolean r0 = r0.mo32386is(r13)     // Catch:{ all -> 0x08db }
                    if (r0 != 0) goto L_0x014f
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x013b }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x013b }
                    r10.<init>()     // Catch:{ all -> 0x013b }
                    java.lang.String r13 = "Abort download, wrong state "
                    r10.append(r13)     // Catch:{ all -> 0x013b }
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x013b }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x013b }
                    java.lang.String r2 = r13.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r2)     // Catch:{ all -> 0x013b }
                    r10.append(r2)     // Catch:{ all -> 0x013b }
                    java.lang.String r2 = r10.toString()     // Catch:{ all -> 0x013b }
                    android.util.Log.w(r0, r2)     // Catch:{ all -> 0x013b }
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "request is done "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r3)
                    r0.append(r2)
                    r0.toString()
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    if (r0 == r9) goto L_0x00cc
                    if (r0 == r8) goto L_0x00c5
                    if (r0 == r6) goto L_0x00bd
                    if (r0 == r7) goto L_0x00b5
                    if (r15 != 0) goto L_0x00cc
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x00cc
                L_0x00b5:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r14, r2)
                    goto L_0x00cc
                L_0x00bd:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x00cc
                L_0x00c5:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x00cc:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "Done with request in state "
                    r0.append(r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r0.append(r2)
                    java.lang.String r2 = " "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r3)
                    r0.append(r2)
                    r0.toString()
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0138 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0138 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0138 }
                    r2 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0137
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0137
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x012e
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0137
                L_0x012e:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0137:
                    return
                L_0x0138:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0138 }
                    throw r0
                L_0x013b:
                    r0 = move-exception
                    r9 = r0
                    r23 = r4
                    r6 = r5
                    r0 = r11
                    r7 = r14
                    r28 = r15
                    r2 = 0
                    r4 = 3
                    r5 = 0
                    r8 = 0
                    r10 = -1
                    r17 = 0
                    r29 = 0
                    goto L_0x08ef
                L_0x014f:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08cd }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x08cd }
                    boolean r0 = r0.isAnyConnected(r2)     // Catch:{ all -> 0x08cd }
                    if (r0 == 0) goto L_0x08b6
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x08cd }
                    r2 = 1
                    r0.setConnected(r2)     // Catch:{ all -> 0x08cd }
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x08cd }
                    if (r0 == 0) goto L_0x0176
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x013b }
                    boolean r0 = r0.exists()     // Catch:{ all -> 0x013b }
                    if (r0 != 0) goto L_0x0176
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x013b }
                    r0.mkdirs()     // Catch:{ all -> 0x013b }
                L_0x0176:
                    boolean r0 = r12.exists()     // Catch:{ all -> 0x08cd }
                    r18 = 0
                    if (r0 == 0) goto L_0x0185
                    long r20 = r12.length()     // Catch:{ all -> 0x013b }
                    r7 = r20
                    goto L_0x0187
                L_0x0185:
                    r7 = r18
                L_0x0187:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x08cd }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x08cd }
                    r0.<init>()     // Catch:{ all -> 0x08cd }
                    java.lang.String r13 = "already downloaded : "
                    r0.append(r13)     // Catch:{ all -> 0x08cd }
                    r0.append(r7)     // Catch:{ all -> 0x08cd }
                    java.lang.String r13 = ", file exists = "
                    r0.append(r13)     // Catch:{ all -> 0x08cd }
                    boolean r13 = r12.exists()     // Catch:{ all -> 0x08cd }
                    r0.append(r13)     // Catch:{ all -> 0x08cd }
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08cd }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x08cd }
                    java.lang.String r2 = r13.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r2)     // Catch:{ all -> 0x08cd }
                    r0.append(r2)     // Catch:{ all -> 0x08cd }
                    r0.toString()     // Catch:{ all -> 0x08cd }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08cd }
                    java.util.HashMap r0 = r0.extractMeta(r5)     // Catch:{ all -> 0x08cd }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08cd }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x08cd }
                    boolean r2 = r2.useCacheWithoutVerification(r13, r12, r0)     // Catch:{ all -> 0x08cd }
                    if (r2 == 0) goto L_0x0284
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x013b }
                    r0.set(r6)     // Catch:{ all -> 0x013b }
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x013b }
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "request is done "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r3)
                    r0.append(r2)
                    r0.toString()
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    if (r0 == r9) goto L_0x0215
                    r2 = 3
                    if (r0 == r2) goto L_0x020e
                    if (r0 == r6) goto L_0x0206
                    r10 = 5
                    if (r0 == r10) goto L_0x01fe
                    if (r15 != 0) goto L_0x0215
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x0215
                L_0x01fe:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r14, r2)
                    goto L_0x0215
                L_0x0206:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x0215
                L_0x020e:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x0215:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "Done with request in state "
                    r0.append(r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r0.append(r2)
                    java.lang.String r2 = " "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r3)
                    r0.append(r2)
                    r0.toString()
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r7)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0281 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0281 }
                    monitor-exit(r7)     // Catch:{ all -> 0x0281 }
                    r2 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0280
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0280
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0277
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0280
                L_0x0277:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0280:
                    return
                L_0x0281:
                    r0 = move-exception
                    monitor-exit(r7)     // Catch:{ all -> 0x0281 }
                    throw r0
                L_0x0284:
                    r2 = 3
                    r10 = 5
                    i.y$a r13 = new i.y$a     // Catch:{ all -> 0x08cd }
                    r13.<init>()     // Catch:{ all -> 0x08cd }
                    r13.mo19618b(r4)     // Catch:{ all -> 0x08cd }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08cd }
                    r21 = r14
                    r14 = 4
                    r6 = r2
                    r28 = r7
                    r2 = 5
                    r10 = 3
                    r2 = 2
                    r9 = r12
                    r10 = r0
                    r2 = r11
                    r11 = r13
                    r6.appendHeaders(r7, r9, r10, r11)     // Catch:{ all -> 0x08ab }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08ab }
                    i.v r6 = r6.okHttpClient     // Catch:{ all -> 0x08ab }
                    i.y r7 = r13.mo19616a()     // Catch:{ all -> 0x08ab }
                    i.e r6 = r6.mo19365a((p113i.C3548y) r7)     // Catch:{ all -> 0x08ab }
                    i.a0 r7 = r6.execute()     // Catch:{ all -> 0x0897 }
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0881 }
                    long r8 = r8.getContentLength(r7)     // Catch:{ all -> 0x0881 }
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0881 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0881 }
                    r10.<init>()     // Catch:{ all -> 0x0881 }
                    java.lang.String r11 = "Response code: "
                    r10.append(r11)     // Catch:{ all -> 0x0881 }
                    int r11 = r7.mo19288v()     // Catch:{ all -> 0x0881 }
                    r10.append(r11)     // Catch:{ all -> 0x0881 }
                    java.lang.String r11 = " "
                    r10.append(r11)     // Catch:{ all -> 0x0881 }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r3     // Catch:{ all -> 0x0881 }
                    r10.append(r11)     // Catch:{ all -> 0x0881 }
                    r10.toString()     // Catch:{ all -> 0x0881 }
                    int r10 = r7.mo19288v()     // Catch:{ all -> 0x0881 }
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0868 }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0868 }
                    boolean r11 = r11.notModified(r12, r7, r13, r0)     // Catch:{ all -> 0x0868 }
                    if (r11 != 0) goto L_0x074a
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0731 }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0731 }
                    boolean r11 = r11.useCacheOnFail(r13, r12, r0, r10)     // Catch:{ all -> 0x0731 }
                    if (r11 == 0) goto L_0x02f3
                    goto L_0x074a
                L_0x02f3:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0731 }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r3     // Catch:{ all -> 0x0731 }
                    r22 = r0
                    r23 = r28
                    r25 = r10
                    r26 = r7
                    r27 = r11
                    boolean r0 = r22.partialMalformed(r23, r25, r26, r27)     // Catch:{ all -> 0x0731 }
                    if (r0 == 0) goto L_0x03a2
                    int r11 = r2 + 1
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x038e }
                    int r0 = r0.maxReconnectAttempts     // Catch:{ all -> 0x038e }
                    if (r2 >= r0) goto L_0x0377
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x038e }
                    r2 = 0
                    r0.deleteFileAndMeta(r12, r5, r2)     // Catch:{ all -> 0x038e }
                    if (r7 == 0) goto L_0x0324
                    i.b0 r0 = r7.mo19284d()
                    if (r0 == 0) goto L_0x0324
                    i.b0 r0 = r7.mo19284d()
                    r0.close()
                L_0x0324:
                    if (r6 == 0) goto L_0x0329
                    r6.cancel()
                L_0x0329:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "request is done "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r0.append(r2)
                    r0.toString()
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "Not removing connections and listener "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r0.append(r2)
                    r0.toString()
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0374 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0374 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0374 }
                    r2 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    r14 = r21
                    r0 = 0
                    goto L_0x0bf6
                L_0x0374:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0374 }
                    throw r0
                L_0x0377:
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x038e }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x038e }
                    r2.<init>()     // Catch:{ all -> 0x038e }
                    java.lang.String r8 = "Code: "
                    r2.append(r8)     // Catch:{ all -> 0x038e }
                    r2.append(r10)     // Catch:{ all -> 0x038e }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x038e }
                    r0.<init>(r2)     // Catch:{ all -> 0x038e }
                    throw r0     // Catch:{ all -> 0x038e }
                L_0x038e:
                    r0 = move-exception
                    r9 = r0
                    r23 = r4
                    r29 = r6
                    r2 = r7
                    r0 = r11
                L_0x0396:
                    r28 = r15
                L_0x0398:
                    r7 = r21
                    r4 = 3
                    r8 = 0
                    r17 = 0
                    r6 = r5
                    r5 = 0
                    goto L_0x08ef
                L_0x03a2:
                    boolean r0 = r7.mo19291y()     // Catch:{ all -> 0x0731 }
                    if (r0 == 0) goto L_0x0705
                    r0 = 206(0xce, float:2.89E-43)
                    if (r10 == r0) goto L_0x03bf
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x03b6 }
                    r11 = 0
                    r0.deleteFileAndMeta(r12, r5, r11)     // Catch:{ all -> 0x03b6 }
                    r13 = r15
                    r14 = r18
                    goto L_0x03c2
                L_0x03b6:
                    r0 = move-exception
                    r9 = r0
                    r0 = r2
                    r23 = r4
                    r29 = r6
                    r2 = r7
                    goto L_0x0396
                L_0x03bf:
                    r13 = r15
                    r14 = r28
                L_0x03c2:
                    r5.delete()     // Catch:{ all -> 0x06f4 }
                    i.r r0 = r7.mo19290x()     // Catch:{ all -> 0x06f4 }
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06f4 }
                    r11.checkEncoding(r12, r5, r0)     // Catch:{ all -> 0x06f4 }
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06f4 }
                    java.util.HashMap r0 = r11.makeMeta(r5, r0, r4)     // Catch:{ all -> 0x06f4 }
                    boolean r11 = p113i.p114e0.p116f.C5940e.m19035b((p113i.C3480a0) r7)     // Catch:{ all -> 0x06f4 }
                    if (r11 == 0) goto L_0x06d5
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06f4 }
                    com.vungle.warren.downloader.DownloaderCache r11 = r11.cache     // Catch:{ all -> 0x06f4 }
                    if (r11 == 0) goto L_0x040e
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0403 }
                    com.vungle.warren.downloader.DownloaderCache r11 = r11.cache     // Catch:{ all -> 0x0403 }
                    r23 = r4
                    r24 = r5
                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x03f4 }
                    r11.setCacheLastUpdateTimestamp(r12, r4)     // Catch:{ all -> 0x03f4 }
                    goto L_0x0412
                L_0x03f4:
                    r0 = move-exception
                    r9 = r0
                    r0 = r2
                    r29 = r6
                    r2 = r7
                    r28 = r13
                    r7 = r21
                    r6 = r24
                    r4 = 3
                    goto L_0x0744
                L_0x0403:
                    r0 = move-exception
                    r23 = r4
                    r9 = r0
                    r0 = r2
                    r29 = r6
                    r2 = r7
                    r28 = r13
                    goto L_0x0398
                L_0x040e:
                    r23 = r4
                    r24 = r5
                L_0x0412:
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06c8 }
                    i.b0 r4 = r4.decodeGzipIfNeeded(r7)     // Catch:{ all -> 0x06c8 }
                    j.e r5 = r4.source()     // Catch:{ all -> 0x06c8 }
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x06b3 }
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x06b3 }
                    r11.<init>()     // Catch:{ all -> 0x06b3 }
                    r25 = r2
                    java.lang.String r2 = "Start download from bytes: "
                    r11.append(r2)     // Catch:{ all -> 0x06b1 }
                    r11.append(r14)     // Catch:{ all -> 0x06b1 }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06b1 }
                    r26 = r10
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x069e }
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r10)     // Catch:{ all -> 0x069e }
                    r11.append(r2)     // Catch:{ all -> 0x069e }
                    r11.toString()     // Catch:{ all -> 0x069e }
                    long r8 = r8 + r14
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x069e }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x069e }
                    r2.<init>()     // Catch:{ all -> 0x069e }
                    java.lang.String r10 = "final offset = "
                    r2.append(r10)     // Catch:{ all -> 0x069e }
                    r2.append(r14)     // Catch:{ all -> 0x069e }
                    r2.toString()     // Catch:{ all -> 0x069e }
                    int r2 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
                    if (r2 != 0) goto L_0x046d
                    j.t r2 = p119j.C6589n.m21619b((java.io.File) r12)     // Catch:{ all -> 0x045b }
                    goto L_0x0471
                L_0x045b:
                    r0 = move-exception
                    r9 = r0
                    r29 = r6
                    r2 = r7
                    r28 = r13
                    r7 = r21
                    r6 = r24
                    r0 = r25
                    r10 = r26
                    r4 = 3
                    goto L_0x0745
                L_0x046d:
                    j.t r2 = p119j.C6589n.m21612a((java.io.File) r12)     // Catch:{ all -> 0x069e }
                L_0x0471:
                    j.d r2 = p119j.C6589n.m21609a((p119j.C3585t) r2)     // Catch:{ all -> 0x069e }
                    r10 = 0
                    r3.status = r10     // Catch:{ all -> 0x0688 }
                    long r10 = r4.contentLength()     // Catch:{ all -> 0x0688 }
                    r3.sizeBytes = r10     // Catch:{ all -> 0x0688 }
                    r3.startBytes = r14     // Catch:{ all -> 0x0688 }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0688 }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x0688 }
                    r4.onProgressMediator(r10, r3)     // Catch:{ all -> 0x0688 }
                    r10 = r18
                    r27 = 0
                L_0x048b:
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3     // Catch:{ all -> 0x0688 }
                    r28 = r13
                    r13 = 1
                    boolean r4 = r4.mo32386is(r13)     // Catch:{ all -> 0x067e }
                    if (r4 == 0) goto L_0x0526
                    j.c r4 = r2.mo19678C()     // Catch:{ all -> 0x0513 }
                    r29 = r6
                    r13 = r7
                    r6 = 2048(0x800, double:1.0118E-320)
                    long r6 = r5.read(r4, r6)     // Catch:{ all -> 0x0511 }
                    r30 = -1
                    int r4 = (r6 > r30 ? 1 : (r6 == r30 ? 0 : -1))
                    if (r4 == 0) goto L_0x0529
                    boolean r4 = r12.exists()     // Catch:{ all -> 0x0511 }
                    if (r4 == 0) goto L_0x0509
                    r2.mo19679F()     // Catch:{ all -> 0x0511 }
                    long r10 = r10 + r6
                    long r6 = r14 + r10
                    r30 = 100
                    int r4 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
                    if (r4 <= 0) goto L_0x04c0
                    long r6 = r6 * r30
                    long r6 = r6 / r8
                    int r4 = (int) r6     // Catch:{ all -> 0x0511 }
                    goto L_0x04c2
                L_0x04c0:
                    r4 = r27
                L_0x04c2:
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3     // Catch:{ all -> 0x0511 }
                    boolean r6 = r6.isConnected()     // Catch:{ all -> 0x0511 }
                    if (r6 == 0) goto L_0x0501
                L_0x04ca:
                    int r6 = r3.progressPercent     // Catch:{ all -> 0x0511 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0511 }
                    int r7 = r7.progressStep     // Catch:{ all -> 0x0511 }
                    int r6 = r6 + r7
                    if (r6 > r4) goto L_0x04f9
                    int r6 = r3.progressPercent     // Catch:{ all -> 0x0511 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0511 }
                    int r7 = r7.progressStep     // Catch:{ all -> 0x0511 }
                    int r6 = r6 + r7
                    long r6 = (long) r6     // Catch:{ all -> 0x0511 }
                    int r27 = (r6 > r30 ? 1 : (r6 == r30 ? 0 : -1))
                    if (r27 > 0) goto L_0x04f9
                    r6 = 1
                    r3.status = r6     // Catch:{ all -> 0x0511 }
                    int r6 = r3.progressPercent     // Catch:{ all -> 0x0511 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0511 }
                    int r7 = r7.progressStep     // Catch:{ all -> 0x0511 }
                    int r6 = r6 + r7
                    r3.progressPercent = r6     // Catch:{ all -> 0x0511 }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0511 }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3     // Catch:{ all -> 0x0511 }
                    r6.onProgressMediator(r7, r3)     // Catch:{ all -> 0x0511 }
                    goto L_0x04ca
                L_0x04f9:
                    r27 = r4
                    r7 = r13
                    r13 = r28
                    r6 = r29
                    goto L_0x048b
                L_0x0501:
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0511 }
                    java.lang.String r4 = "Request is not connected"
                    r0.<init>(r4)     // Catch:{ all -> 0x0511 }
                    throw r0     // Catch:{ all -> 0x0511 }
                L_0x0509:
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x0511 }
                    java.lang.String r4 = "File is not existing"
                    r0.<init>(r4)     // Catch:{ all -> 0x0511 }
                    throw r0     // Catch:{ all -> 0x0511 }
                L_0x0511:
                    r0 = move-exception
                    goto L_0x0517
                L_0x0513:
                    r0 = move-exception
                    r29 = r6
                    r13 = r7
                L_0x0517:
                    r9 = r0
                    r17 = r2
                    r2 = r13
                    r7 = r21
                    r6 = r24
                L_0x051f:
                    r0 = r25
                    r10 = r26
                    r4 = 3
                    goto L_0x069b
                L_0x0526:
                    r29 = r6
                    r13 = r7
                L_0x0529:
                    r2.flush()     // Catch:{ all -> 0x067c }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3     // Catch:{ all -> 0x067c }
                    r6 = 1
                    boolean r4 = r4.mo32386is(r6)     // Catch:{ all -> 0x067c }
                    if (r4 == 0) goto L_0x0570
                    long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0566 }
                    java.lang.String r4 = "DOWNLOAD_COMPLETE"
                    java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0566 }
                    java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0566 }
                    r0.put(r4, r8)     // Catch:{ all -> 0x0566 }
                    java.lang.String r4 = "Last-Cache-Verification"
                    java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0566 }
                    r0.put(r4, r8)     // Catch:{ all -> 0x0566 }
                    java.lang.String r4 = "Last-Download"
                    java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0566 }
                    r0.put(r4, r6)     // Catch:{ all -> 0x0566 }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0566 }
                    r6 = r24
                    r4.saveMeta(r6, r0)     // Catch:{ all -> 0x0564 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0564 }
                    r4 = 4
                    r0.set(r4)     // Catch:{ all -> 0x0564 }
                    goto L_0x0597
                L_0x0564:
                    r0 = move-exception
                    goto L_0x0569
                L_0x0566:
                    r0 = move-exception
                    r6 = r24
                L_0x0569:
                    r9 = r0
                    r17 = r2
                    r2 = r13
                    r7 = r21
                    goto L_0x051f
                L_0x0570:
                    r6 = r24
                    r0 = 6
                    r3.status = r0     // Catch:{ all -> 0x0678 }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0678 }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3     // Catch:{ all -> 0x0678 }
                    r0.onProgressMediator(r4, r3)     // Catch:{ all -> 0x0678 }
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0678 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0678 }
                    r0.<init>()     // Catch:{ all -> 0x0678 }
                    java.lang.String r4 = "State has changed, cancelling download "
                    r0.append(r4)     // Catch:{ all -> 0x0678 }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0678 }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3     // Catch:{ all -> 0x0678 }
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)     // Catch:{ all -> 0x0678 }
                    r0.append(r4)     // Catch:{ all -> 0x0678 }
                    r0.toString()     // Catch:{ all -> 0x0678 }
                L_0x0597:
                    if (r13 == 0) goto L_0x05a6
                    i.b0 r0 = r13.mo19284d()
                    if (r0 == 0) goto L_0x05a6
                    i.b0 r0 = r13.mo19284d()
                    r0.close()
                L_0x05a6:
                    if (r29 == 0) goto L_0x05ab
                    r29.cancel()
                L_0x05ab:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r4 = "request is done "
                    r0.append(r4)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)
                    r0.append(r4)
                    r0.toString()
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    r4 = 2
                    if (r0 == r4) goto L_0x0600
                    r4 = 3
                    if (r0 == r4) goto L_0x05f6
                    r4 = 4
                    if (r0 == r4) goto L_0x05ec
                    r4 = 5
                    if (r0 == r4) goto L_0x05e2
                    if (r28 != 0) goto L_0x0600
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r0.removeMediator(r4)
                    goto L_0x0600
                L_0x05e2:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r7 = r21
                    r0.onErrorMediator(r7, r4)
                    goto L_0x0602
                L_0x05ec:
                    r7 = r21
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r0.onSuccessMediator(r12, r4)
                    goto L_0x0602
                L_0x05f6:
                    r7 = r21
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r0.onCancelledMediator(r4)
                    goto L_0x0602
                L_0x0600:
                    r7 = r21
                L_0x0602:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r4 = "Done with request in state "
                    r0.append(r4)
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    int r4 = r4.getStatus()
                    r0.append(r4)
                    java.lang.String r4 = " "
                    r0.append(r4)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)
                    r0.append(r4)
                    r0.toString()
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r8)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0675 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0675 }
                    monitor-exit(r8)     // Catch:{ all -> 0x0675 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x066c
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x066c
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0663
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x066c
                L_0x0663:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x066c:
                    r14 = r7
                    r11 = r25
                    r15 = r28
                    r0 = 1
                    r13 = 0
                    goto L_0x0bf3
                L_0x0675:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x0675 }
                    throw r0
                L_0x0678:
                    r0 = move-exception
                    r7 = r21
                    goto L_0x0686
                L_0x067c:
                    r0 = move-exception
                    goto L_0x0682
                L_0x067e:
                    r0 = move-exception
                    r29 = r6
                    r13 = r7
                L_0x0682:
                    r7 = r21
                    r6 = r24
                L_0x0686:
                    r4 = 3
                    goto L_0x0693
                L_0x0688:
                    r0 = move-exception
                    r29 = r6
                    r28 = r13
                    r6 = r24
                    r4 = 3
                    r13 = r7
                    r7 = r21
                L_0x0693:
                    r9 = r0
                    r17 = r2
                    r2 = r13
                    r0 = r25
                    r10 = r26
                L_0x069b:
                    r8 = 0
                    goto L_0x08ef
                L_0x069e:
                    r0 = move-exception
                    r29 = r6
                    r28 = r13
                    r6 = r24
                    r4 = 3
                    r13 = r7
                    r7 = r21
                    r9 = r0
                    r2 = r13
                    r0 = r25
                    r10 = r26
                    goto L_0x0745
                L_0x06b1:
                    r0 = move-exception
                    goto L_0x06b6
                L_0x06b3:
                    r0 = move-exception
                    r25 = r2
                L_0x06b6:
                    r29 = r6
                    r26 = r10
                    r28 = r13
                    r6 = r24
                    r4 = 3
                    r13 = r7
                    r7 = r21
                    r9 = r0
                    r2 = r13
                    r0 = r25
                    goto L_0x0745
                L_0x06c8:
                    r0 = move-exception
                    r25 = r2
                    r29 = r6
                    r26 = r10
                    r28 = r13
                    r6 = r24
                    r4 = 3
                    goto L_0x0701
                L_0x06d5:
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r26 = r10
                    r28 = r13
                    r4 = 3
                    r6 = r5
                    r13 = r7
                    r7 = r21
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x06ec }
                    java.lang.String r2 = "Response body is null"
                    r0.<init>(r2)     // Catch:{ all -> 0x06ec }
                    throw r0     // Catch:{ all -> 0x06ec }
                L_0x06ec:
                    r0 = move-exception
                    r9 = r0
                    r2 = r13
                    r0 = r25
                    r10 = r26
                    goto L_0x0744
                L_0x06f4:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r26 = r10
                    r28 = r13
                    r4 = 3
                    r6 = r5
                L_0x0701:
                    r13 = r7
                    r7 = r21
                    goto L_0x0740
                L_0x0705:
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r26 = r10
                    r28 = r15
                    r7 = r21
                    r4 = 3
                    r6 = r5
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x072d }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x072d }
                    r2.<init>()     // Catch:{ all -> 0x072d }
                    java.lang.String r5 = "Code: "
                    r2.append(r5)     // Catch:{ all -> 0x072d }
                    r5 = r26
                    r2.append(r5)     // Catch:{ all -> 0x0772 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0772 }
                    r0.<init>(r2)     // Catch:{ all -> 0x0772 }
                    throw r0     // Catch:{ all -> 0x0772 }
                L_0x072d:
                    r0 = move-exception
                    r5 = r26
                    goto L_0x0773
                L_0x0731:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r28 = r15
                    r7 = r21
                    r4 = 3
                    r6 = r5
                    r5 = r10
                L_0x0740:
                    r9 = r0
                L_0x0741:
                    r2 = r13
                    r0 = r25
                L_0x0744:
                    r5 = 0
                L_0x0745:
                    r8 = 0
                    r17 = 0
                    goto L_0x08ef
                L_0x074a:
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r28 = r15
                    r7 = r21
                    r4 = 3
                    r6 = r5
                    r5 = r10
                    r2 = 304(0x130, float:4.26E-43)
                    if (r5 != r2) goto L_0x0776
                    java.lang.String r2 = "Last-Cache-Verification"
                    long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0772 }
                    java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0772 }
                    r0.put(r2, r8)     // Catch:{ all -> 0x0772 }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0772 }
                    r2.saveMeta(r6, r0)     // Catch:{ all -> 0x0772 }
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0772 }
                    goto L_0x078d
                L_0x0772:
                    r0 = move-exception
                L_0x0773:
                    r9 = r0
                    r10 = r5
                    goto L_0x0741
                L_0x0776:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0863 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0863 }
                    r0.<init>()     // Catch:{ all -> 0x0863 }
                    java.lang.String r2 = "Using local cache file despite response code = "
                    r0.append(r2)     // Catch:{ all -> 0x0863 }
                    int r2 = r13.mo19288v()     // Catch:{ all -> 0x0863 }
                    r0.append(r2)     // Catch:{ all -> 0x0863 }
                    r0.toString()     // Catch:{ all -> 0x0863 }
                L_0x078d:
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0863 }
                    r2 = 4
                    r0.set(r2)     // Catch:{ all -> 0x0863 }
                    if (r13 == 0) goto L_0x07a2
                    i.b0 r0 = r13.mo19284d()
                    if (r0 == 0) goto L_0x07a2
                    i.b0 r0 = r13.mo19284d()
                    r0.close()
                L_0x07a2:
                    if (r29 == 0) goto L_0x07a7
                    r29.cancel()
                L_0x07a7:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "request is done "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r3)
                    r0.append(r2)
                    r0.toString()
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    r2 = 2
                    if (r0 == r2) goto L_0x07f4
                    if (r0 == r4) goto L_0x07ed
                    r2 = 4
                    if (r0 == r2) goto L_0x07e5
                    r2 = 5
                    if (r0 == r2) goto L_0x07dd
                    if (r28 != 0) goto L_0x07f4
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x07f4
                L_0x07dd:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r7, r2)
                    goto L_0x07f4
                L_0x07e5:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x07f4
                L_0x07ed:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x07f4:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "Done with request in state "
                    r0.append(r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r0.append(r2)
                    java.lang.String r2 = " "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r3)
                    r0.append(r2)
                    r0.toString()
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0860 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0860 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0860 }
                    r8 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r8)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r8)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x085f
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x085f
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0856
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x085f
                L_0x0856:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x085f:
                    return
                L_0x0860:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0860 }
                    throw r0
                L_0x0863:
                    r0 = move-exception
                    r8 = 0
                    r9 = r0
                    r10 = r5
                    goto L_0x0879
                L_0x0868:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r28 = r15
                    r7 = r21
                    r4 = 3
                    r8 = 0
                    r6 = r5
                    r5 = r10
                    r9 = r0
                L_0x0879:
                    r5 = r8
                    r17 = r5
                    r2 = r13
                    r0 = r25
                    goto L_0x08ef
                L_0x0881:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r28 = r15
                    r7 = r21
                    r4 = 3
                    r8 = 0
                    r6 = r5
                    r9 = r0
                    r5 = r8
                    r17 = r5
                    r2 = r13
                    goto L_0x08ec
                L_0x0897:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r28 = r15
                    r7 = r21
                    r4 = 3
                    r8 = 0
                    r6 = r5
                    r9 = r0
                    r2 = r8
                    r5 = r2
                    r17 = r5
                    goto L_0x08ec
                L_0x08ab:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r6 = r5
                    r28 = r15
                    r7 = r21
                    goto L_0x08d6
                L_0x08b6:
                    r23 = r4
                    r6 = r5
                    r25 = r11
                    r7 = r14
                    r28 = r15
                    r4 = 3
                    r8 = 0
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x08cb }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x08cb }
                    java.lang.String r2 = "Not connected to correct network"
                    r0.<init>(r2)     // Catch:{ all -> 0x08cb }
                    throw r0     // Catch:{ all -> 0x08cb }
                L_0x08cb:
                    r0 = move-exception
                    goto L_0x08d8
                L_0x08cd:
                    r0 = move-exception
                    r23 = r4
                    r6 = r5
                    r25 = r11
                    r7 = r14
                    r28 = r15
                L_0x08d6:
                    r4 = 3
                    r8 = 0
                L_0x08d8:
                    r9 = r0
                    r2 = r8
                    goto L_0x08e7
                L_0x08db:
                    r0 = move-exception
                    r8 = r2
                    r23 = r4
                    r6 = r5
                    r25 = r11
                    r7 = r14
                    r28 = r15
                    r4 = 3
                    r9 = r0
                L_0x08e7:
                    r5 = r2
                    r17 = r5
                    r29 = r17
                L_0x08ec:
                    r0 = r25
                    r10 = -1
                L_0x08ef:
                    java.lang.String r13 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0bfc }
                    java.lang.String r14 = "Exception on download"
                    android.util.Log.e(r13, r14, r9)     // Catch:{ all -> 0x0bfc }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0bfc }
                    boolean r13 = r13.mo32386is(r4)     // Catch:{ all -> 0x0bfc }
                    if (r13 != 0) goto L_0x090a
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0907 }
                    r14 = 5
                    r13.set(r14)     // Catch:{ all -> 0x0907 }
                    goto L_0x090a
                L_0x0907:
                    r0 = move-exception
                    goto L_0x0bfe
                L_0x090a:
                    boolean r13 = r9 instanceof java.io.IOException     // Catch:{ all -> 0x0bfc }
                    if (r13 == 0) goto L_0x0ae3
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0907 }
                    com.vungle.warren.downloader.DownloadRequestMediator r14 = r3     // Catch:{ all -> 0x0907 }
                    boolean r13 = r13.isAnyConnected(r14)     // Catch:{ all -> 0x0907 }
                    if (r13 != 0) goto L_0x0a08
                    if (r2 != 0) goto L_0x0a08
                    com.vungle.warren.downloader.AssetDownloader r14 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0907 }
                    com.vungle.warren.downloader.DownloadRequestMediator r15 = r3     // Catch:{ all -> 0x0907 }
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0907 }
                    java.util.HashMap r8 = r8.extractMeta(r6)     // Catch:{ all -> 0x0907 }
                    r11 = -1
                    boolean r8 = r14.useCacheOnFail(r15, r12, r8, r11)     // Catch:{ all -> 0x0907 }
                    if (r8 == 0) goto L_0x0a08
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0907 }
                    boolean r0 = r0.mo32386is(r4)     // Catch:{ all -> 0x0907 }
                    if (r0 != 0) goto L_0x0939
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0907 }
                    r3 = 4
                    r0.set(r3)     // Catch:{ all -> 0x0907 }
                L_0x0939:
                    if (r2 == 0) goto L_0x0948
                    i.b0 r0 = r2.mo19284d()
                    if (r0 == 0) goto L_0x0948
                    i.b0 r0 = r2.mo19284d()
                    r0.close()
                L_0x0948:
                    if (r29 == 0) goto L_0x094d
                    r29.cancel()
                L_0x094d:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "request is done "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r3)
                    r0.append(r2)
                    r0.toString()
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    r2 = 2
                    if (r0 == r2) goto L_0x099a
                    if (r0 == r4) goto L_0x0993
                    r2 = 4
                    if (r0 == r2) goto L_0x098b
                    r2 = 5
                    if (r0 == r2) goto L_0x0983
                    if (r28 != 0) goto L_0x099a
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x099a
                L_0x0983:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r7, r2)
                    goto L_0x099a
                L_0x098b:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x099a
                L_0x0993:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x099a:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "Done with request in state "
                    r0.append(r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r0.append(r2)
                    java.lang.String r2 = " "
                    r0.append(r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r3)
                    r0.append(r2)
                    r0.toString()
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r3)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a05 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0a05 }
                    monitor-exit(r3)     // Catch:{ all -> 0x0a05 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r17)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0a04
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0a04
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x09fb
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0a04
                L_0x09fb:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0a04:
                    return
                L_0x0a05:
                    r0 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x0a05 }
                    throw r0
                L_0x0a08:
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0907 }
                    r8.setConnected(r13)     // Catch:{ all -> 0x0907 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r8 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0907 }
                    com.vungle.warren.downloader.AssetDownloader r14 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0907 }
                    int r14 = r14.mapExceptionToReason(r9, r13)     // Catch:{ all -> 0x0907 }
                    r8.<init>(r10, r9, r14)     // Catch:{ all -> 0x0907 }
                    if (r13 != 0) goto L_0x0a85
                    r7 = 5
                    r3.status = r7     // Catch:{ all -> 0x0a81 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a81 }
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0a81 }
                    r7.onProgressMediator(r9, r3)     // Catch:{ all -> 0x0a81 }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3     // Catch:{ all -> 0x0a81 }
                    boolean r7 = r7.mo32386is(r4)     // Catch:{ all -> 0x0a81 }
                    if (r7 != 0) goto L_0x0a85
                    int r7 = r0 + 1
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a81 }
                    int r9 = r9.maxReconnectAttempts     // Catch:{ all -> 0x0a81 }
                    if (r0 >= r9) goto L_0x0a7e
                    r0 = 0
                L_0x0a35:
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a81 }
                    int r9 = r9.retryCountOnConnectionLost     // Catch:{ all -> 0x0a81 }
                    if (r0 >= r9) goto L_0x0a7e
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a81 }
                    com.vungle.warren.downloader.AssetDownloader r10 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a81 }
                    int r10 = r10.reconnectTimeout     // Catch:{ all -> 0x0a81 }
                    long r13 = (long) r10     // Catch:{ all -> 0x0a81 }
                    r9.sleep(r13)     // Catch:{ all -> 0x0a81 }
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0a81 }
                    boolean r9 = r9.mo32386is(r4)     // Catch:{ all -> 0x0a81 }
                    if (r9 == 0) goto L_0x0a4e
                    goto L_0x0a7e
                L_0x0a4e:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0a81 }
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a81 }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x0a81 }
                    boolean r9 = r9.isAnyConnected(r10)     // Catch:{ all -> 0x0a81 }
                    if (r9 == 0) goto L_0x0a75
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0a81 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0a6e }
                    r9 = 1
                    r0.setConnected(r9)     // Catch:{ all -> 0x0a6e }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0a6e }
                    r0.set(r9)     // Catch:{ all -> 0x0a6e }
                    r0 = r7
                    r13 = 0
                    r16 = 0
                    goto L_0x0a88
                L_0x0a6e:
                    r0 = move-exception
                    r14 = r8
                    r15 = r28
                    r13 = 0
                    goto L_0x0c02
                L_0x0a75:
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0a81 }
                    r13 = 0
                    r9.setConnected(r13)     // Catch:{ all -> 0x0a81 }
                    int r0 = r0 + 1
                    goto L_0x0a35
                L_0x0a7e:
                    r13 = 0
                    r0 = r7
                    goto L_0x0a86
                L_0x0a81:
                    r0 = move-exception
                    r14 = r8
                    goto L_0x0bff
                L_0x0a85:
                    r13 = 0
                L_0x0a86:
                    r16 = 1
                L_0x0a88:
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0adb }
                    monitor-enter(r7)     // Catch:{ all -> 0x0adb }
                    if (r16 == 0) goto L_0x0acc
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0ac6 }
                    boolean r9 = r9.isConnected()     // Catch:{ all -> 0x0ac6 }
                    if (r9 != 0) goto L_0x0acc
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0ac6 }
                    boolean r9 = r9.isPausable()     // Catch:{ all -> 0x0ac6 }
                    if (r9 == 0) goto L_0x0acc
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ac6 }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x0ac6 }
                    boolean r9 = r9.isAnyConnected(r10)     // Catch:{ all -> 0x0ac6 }
                    if (r9 == 0) goto L_0x0abc
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0ac6 }
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0aba }
                    r10 = 1
                    r9.setConnected(r10)     // Catch:{ all -> 0x0aba }
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0aba }
                    r9.set(r10)     // Catch:{ all -> 0x0aba }
                    r15 = r28
                    r16 = 0
                    goto L_0x0ace
                L_0x0aba:
                    r0 = move-exception
                    goto L_0x0ac9
                L_0x0abc:
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ac6 }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x0ac6 }
                    boolean r9 = r9.pause(r10, r3, r8)     // Catch:{ all -> 0x0ac6 }
                    r15 = r9
                    goto L_0x0ace
                L_0x0ac6:
                    r0 = move-exception
                    r13 = r16
                L_0x0ac9:
                    r15 = r28
                    goto L_0x0ad3
                L_0x0acc:
                    r15 = r28
                L_0x0ace:
                    monitor-exit(r7)     // Catch:{ all -> 0x0ad0 }
                    goto L_0x0b04
                L_0x0ad0:
                    r0 = move-exception
                    r13 = r16
                L_0x0ad3:
                    monitor-exit(r7)     // Catch:{ all -> 0x0ad9 }
                    throw r0     // Catch:{ all -> 0x0ad5 }
                L_0x0ad5:
                    r0 = move-exception
                    r14 = r8
                    goto L_0x0c02
                L_0x0ad9:
                    r0 = move-exception
                    goto L_0x0ad3
                L_0x0adb:
                    r0 = move-exception
                    r14 = r8
                    r13 = r16
                    r15 = r28
                    goto L_0x0c02
                L_0x0ae3:
                    r13 = 0
                    boolean r8 = r9 instanceof com.vungle.warren.downloader.Downloader.RequestException     // Catch:{ all -> 0x0bfc }
                    if (r8 == 0) goto L_0x0af4
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0907 }
                    r14 = 1
                    r8.deleteFileAndMeta(r12, r6, r14)     // Catch:{ all -> 0x0907 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r8 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0907 }
                    r8.<init>(r10, r9, r14)     // Catch:{ all -> 0x0907 }
                    goto L_0x0b00
                L_0x0af4:
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0bfc }
                    r14 = 1
                    r8.deleteFileAndMeta(r12, r6, r14)     // Catch:{ all -> 0x0907 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r8 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0907 }
                    r11 = 4
                    r8.<init>(r10, r9, r11)     // Catch:{ all -> 0x0907 }
                L_0x0b00:
                    r15 = r28
                    r16 = 1
                L_0x0b04:
                    if (r2 == 0) goto L_0x0b13
                    i.b0 r7 = r2.mo19284d()
                    if (r7 == 0) goto L_0x0b13
                    i.b0 r2 = r2.mo19284d()
                    r2.close()
                L_0x0b13:
                    if (r29 == 0) goto L_0x0b18
                    r29.cancel()
                L_0x0b18:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r7 = "request is done "
                    r2.append(r7)
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3
                    java.lang.String r7 = r7.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r9)
                    r2.append(r7)
                    r2.toString()
                    if (r16 == 0) goto L_0x0b91
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r7 = 2
                    if (r2 == r7) goto L_0x0b67
                    if (r2 == r4) goto L_0x0b60
                    r4 = 4
                    if (r2 == r4) goto L_0x0b58
                    r4 = 5
                    if (r2 == r4) goto L_0x0b50
                    if (r15 != 0) goto L_0x0b67
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.removeMediator(r4)
                    goto L_0x0b67
                L_0x0b50:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.onErrorMediator(r8, r4)
                    goto L_0x0b67
                L_0x0b58:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.onSuccessMediator(r12, r4)
                    goto L_0x0b67
                L_0x0b60:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.onCancelledMediator(r4)
                L_0x0b67:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r4 = "Done with request in state "
                    r2.append(r4)
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    int r4 = r4.getStatus()
                    r2.append(r4)
                    java.lang.String r4 = " "
                    r2.append(r4)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)
                    r2.append(r4)
                    r2.toString()
                    goto L_0x0bac
                L_0x0b91:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r4 = "Not removing connections and listener "
                    r2.append(r4)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)
                    r2.append(r4)
                    r2.toString()
                L_0x0bac:
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r9)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0bf9 }
                    r2.removeNetworkListener()     // Catch:{ all -> 0x0bf9 }
                    monitor-exit(r9)     // Catch:{ all -> 0x0bf9 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r17)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    if (r16 == 0) goto L_0x0bef
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    if (r2 == 0) goto L_0x0bef
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    boolean r2 = r2.isCacheable
                    if (r2 == 0) goto L_0x0bef
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r2 = r2.isCacheEnabled()
                    if (r2 != 0) goto L_0x0be6
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.clear()
                    goto L_0x0bef
                L_0x0be6:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.purge()
                L_0x0bef:
                    r11 = r0
                    r14 = r8
                    r0 = r16
                L_0x0bf3:
                    r5 = r6
                    r4 = r23
                L_0x0bf6:
                    r2 = 0
                    goto L_0x0040
                L_0x0bf9:
                    r0 = move-exception
                    monitor-exit(r9)     // Catch:{ all -> 0x0bf9 }
                    throw r0
                L_0x0bfc:
                    r0 = move-exception
                    r14 = 1
                L_0x0bfe:
                    r14 = r7
                L_0x0bff:
                    r15 = r28
                    r13 = 1
                L_0x0c02:
                    if (r2 == 0) goto L_0x0c11
                    i.b0 r3 = r2.mo19284d()
                    if (r3 == 0) goto L_0x0c11
                    i.b0 r2 = r2.mo19284d()
                    r2.close()
                L_0x0c11:
                    if (r29 == 0) goto L_0x0c16
                    r29.cancel()
                L_0x0c16:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "request is done "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r2.append(r3)
                    r2.toString()
                    if (r13 == 0) goto L_0x0c8f
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r3 = 2
                    if (r2 == r3) goto L_0x0c65
                    if (r2 == r4) goto L_0x0c5e
                    r3 = 4
                    if (r2 == r3) goto L_0x0c56
                    r3 = 5
                    if (r2 == r3) goto L_0x0c4e
                    if (r15 != 0) goto L_0x0c65
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    r2.removeMediator(r3)
                    goto L_0x0c65
                L_0x0c4e:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    r2.onErrorMediator(r14, r3)
                    goto L_0x0c65
                L_0x0c56:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    r2.onSuccessMediator(r12, r3)
                    goto L_0x0c65
                L_0x0c5e:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    r2.onCancelledMediator(r3)
                L_0x0c65:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Done with request in state "
                    r2.append(r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    r2.toString()
                    goto L_0x0caa
                L_0x0c8f:
                    java.lang.String unused = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Not removing connections and listener "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    r2.toString()
                L_0x0caa:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0cee }
                    r3.removeNetworkListener()     // Catch:{ all -> 0x0cee }
                    monitor-exit(r2)     // Catch:{ all -> 0x0cee }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r17)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    if (r13 == 0) goto L_0x0ced
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    if (r2 == 0) goto L_0x0ced
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    boolean r2 = r2.isCacheable
                    if (r2 == 0) goto L_0x0ced
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r2 = r2.isCacheEnabled()
                    if (r2 != 0) goto L_0x0ce4
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.clear()
                    goto L_0x0ced
                L_0x0ce4:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.purge()
                L_0x0ced:
                    throw r0
                L_0x0cee:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0cee }
                    throw r0
                L_0x0cf1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.C54672.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> makeMeta(File file, C3537r rVar, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(DOWNLOAD_URL, str);
        hashMap.put(ETAG, rVar.mo19502a(ETAG));
        hashMap.put(LAST_MODIFIED, rVar.mo19502a(LAST_MODIFIED));
        hashMap.put(ACCEPT_RANGES, rVar.mo19502a(ACCEPT_RANGES));
        hashMap.put(CONTENT_ENCODING, rVar.mo19502a(CONTENT_ENCODING));
        saveMeta(file, hashMap);
        return hashMap;
    }

    private DownloadRequestMediator makeNewMediator(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) throws IOException {
        String str;
        boolean z;
        File file;
        File file2;
        if (!isCacheEnabled()) {
            file2 = new File(downloadRequest.path);
            file = new File(file2.getPath() + META_POSTFIX_EXT);
            str = downloadRequest.url + " " + downloadRequest.path;
            z = false;
        } else {
            file2 = this.cache.getFile(downloadRequest.url);
            file = this.cache.getMetaFile(file2);
            str = downloadRequest.url;
            z = true;
        }
        "Destination file " + file2.getPath();
        return new DownloadRequestMediator(downloadRequest, assetDownloadListener, file2.getPath(), file.getPath(), z, str);
    }

    /* access modifiers changed from: private */
    public int mapExceptionToReason(Throwable th, boolean z) {
        if (th instanceof RuntimeException) {
            return 4;
        }
        if (!z || (th instanceof SocketException) || (th instanceof SocketTimeoutException)) {
            return 0;
        }
        return ((th instanceof UnknownHostException) || (th instanceof SSLException)) ? 1 : 2;
    }

    private String mediatorKeyFromRequest(DownloadRequest downloadRequest) {
        if (isCacheEnabled()) {
            return getCacheableKey(downloadRequest);
        }
        return getNonCacheableKey(downloadRequest);
    }

    /* access modifiers changed from: private */
    public boolean notModified(File file, C3480a0 a0Var, DownloadRequestMediator downloadRequestMediator, HashMap<String, String> hashMap) {
        if (a0Var != null && file.exists() && file.length() > 0 && downloadRequestMediator.isCacheable) {
            int v = a0Var.mo19288v();
            if (Boolean.parseBoolean(hashMap.get(DOWNLOAD_COMPLETE)) && v == 304) {
                "304 code, data size matches file size " + debugString(downloadRequestMediator);
                return true;
            }
        }
        return false;
    }

    private void onCancelled(DownloadRequest downloadRequest) {
        DownloadRequest downloadRequest2;
        if (!downloadRequest.isCancelled()) {
            downloadRequest.cancel();
            DownloadRequestMediator findMediatorForCancellation = findMediatorForCancellation(downloadRequest);
            if (!(findMediatorForCancellation == null || findMediatorForCancellation.getStatus() == 3)) {
                C0791d<DownloadRequest, AssetDownloadListener> remove = findMediatorForCancellation.remove(downloadRequest);
                AssetDownloadListener assetDownloadListener = null;
                if (remove == null) {
                    downloadRequest2 = null;
                } else {
                    downloadRequest2 = (DownloadRequest) remove.f1996a;
                }
                if (remove != null) {
                    assetDownloadListener = (AssetDownloadListener) remove.f1997b;
                }
                if (findMediatorForCancellation.values().isEmpty()) {
                    findMediatorForCancellation.set(3);
                }
                if (downloadRequest2 != null) {
                    AssetDownloadListener.Progress progress = new AssetDownloadListener.Progress();
                    progress.status = 3;
                    deliverProgress(progress, downloadRequest2, assetDownloadListener);
                } else {
                    return;
                }
            }
            removeNetworkListener();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onCancelledMediator(DownloadRequestMediator downloadRequestMediator) {
        for (DownloadRequest onCancelled : downloadRequestMediator.requests()) {
            onCancelled(onCancelled);
        }
    }

    /* access modifiers changed from: private */
    public void onErrorMediator(AssetDownloadListener.DownloadError downloadError, DownloadRequestMediator downloadRequestMediator) {
        if (downloadError == null) {
            downloadError = new AssetDownloadListener.DownloadError(-1, new RuntimeException(), 4);
        }
        try {
            downloadRequestMediator.lock();
            for (C0791d next : downloadRequestMediator.values()) {
                deliverError((DownloadRequest) next.f1996a, (AssetDownloadListener) next.f1997b, downloadError);
            }
            removeMediator(downloadRequestMediator);
            downloadRequestMediator.set(6);
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onNetworkChanged(int i) {
        "Num of connections: " + this.mediators.values().size();
        for (DownloadRequestMediator next : this.mediators.values()) {
            if (!next.mo32386is(3)) {
                boolean isAnyConnected = isAnyConnected(next);
                "Connected = " + isAnyConnected + " for " + i;
                next.setConnected(isAnyConnected);
                if (next.isPausable() && isAnyConnected && next.mo32386is(2)) {
                    load(next);
                    "resumed " + next.key + " " + next;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onProgressMediator(DownloadRequestMediator downloadRequestMediator, AssetDownloadListener.Progress progress) {
        if (downloadRequestMediator != null) {
            AssetDownloadListener.Progress copy = AssetDownloadListener.Progress.copy(progress);
            "Progress " + progress.progressPercent + " status " + progress.status + " " + downloadRequestMediator + " " + downloadRequestMediator.filePath;
            for (C0791d next : downloadRequestMediator.values()) {
                deliverProgress(copy, (DownloadRequest) next.f1996a, (AssetDownloadListener) next.f1997b);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onSuccessMediator(File file, DownloadRequestMediator downloadRequestMediator) {
        "OnComplete - Removing connections and listener " + downloadRequestMediator;
        try {
            downloadRequestMediator.lock();
            List<C0791d<DownloadRequest, AssetDownloadListener>> values = downloadRequestMediator.values();
            if (!file.exists()) {
                onErrorMediator(new AssetDownloadListener.DownloadError(-1, new IOException("File is deleted"), 2), downloadRequestMediator);
                return;
            }
            if (this.cache != null && downloadRequestMediator.isCacheable) {
                this.cache.onCacheHit(file, (long) values.size());
                this.cache.setCacheLastUpdateTimestamp(file, System.currentTimeMillis());
            }
            for (C0791d next : values) {
                File file2 = new File(((DownloadRequest) next.f1996a).path);
                if (!file2.equals(file)) {
                    copyToDestination(file, file2, next);
                } else {
                    file2 = file;
                }
                "Deliver success:" + ((DownloadRequest) next.f1996a).url + " dest file: " + file2.getPath();
                deliverSuccess(next, file2);
            }
            removeMediator(downloadRequestMediator);
            downloadRequestMediator.set(6);
            "Finished " + debugString(downloadRequestMediator);
            downloadRequestMediator.unlock();
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    /* access modifiers changed from: private */
    public boolean partialMalformed(long j, int i, C3480a0 a0Var, DownloadRequestMediator downloadRequestMediator) {
        return (i == 206 && !satisfiesPartialDownload(a0Var, j, downloadRequestMediator)) || i == RANGE_NOT_SATISFIABLE;
    }

    /* access modifiers changed from: private */
    public boolean pause(DownloadRequestMediator downloadRequestMediator, AssetDownloadListener.Progress progress, AssetDownloadListener.DownloadError downloadError) {
        boolean z = false;
        if (downloadRequestMediator.mo32386is(3) || isAnyConnected(downloadRequestMediator)) {
            return false;
        }
        progress.status = 2;
        AssetDownloadListener.Progress copy = AssetDownloadListener.Progress.copy(progress);
        boolean z2 = false;
        for (C0791d next : downloadRequestMediator.values()) {
            DownloadRequest downloadRequest = (DownloadRequest) next.f1996a;
            if (downloadRequest != null) {
                if (!downloadRequest.pauseOnConnectionLost) {
                    downloadRequestMediator.remove(downloadRequest);
                    deliverError(downloadRequest, (AssetDownloadListener) next.f1997b, downloadError);
                } else {
                    downloadRequestMediator.set(2);
                    "Pausing download " + debugString(downloadRequest);
                    deliverProgress(copy, (DownloadRequest) next.f1996a, (AssetDownloadListener) next.f1997b);
                    z2 = true;
                }
            }
        }
        if (!z2) {
            downloadRequestMediator.set(5);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Attempted to pause - ");
        if (downloadRequestMediator.getStatus() == 2) {
            z = true;
        }
        sb.append(z);
        sb.toString();
        return z2;
    }

    /* access modifiers changed from: private */
    public synchronized void removeMediator(DownloadRequestMediator downloadRequestMediator) {
        this.mediators.remove(downloadRequestMediator.key);
    }

    /* access modifiers changed from: private */
    public void removeNetworkListener() {
        if (this.mediators.isEmpty()) {
            this.networkProvider.removeListener(this.networkListener);
        }
    }

    private boolean responseVersionMatches(C3480a0 a0Var, HashMap<String, String> hashMap) {
        C3537r x = a0Var.mo19290x();
        String a = x.mo19502a(ETAG);
        String a2 = x.mo19502a(LAST_MODIFIED);
        "server etag: " + a;
        "server lastModified: " + a2;
        if (a != null && !a.equals(hashMap.get(ETAG))) {
            "etags miss match current: " + hashMap.get(ETAG);
            return false;
        } else if (a2 == null || a2.equals(hashMap.get(LAST_MODIFIED))) {
            return true;
        } else {
            "lastModified miss match current: " + hashMap.get(LAST_MODIFIED);
            return false;
        }
    }

    private boolean satisfiesPartialDownload(C3480a0 a0Var, long j, DownloadRequestMediator downloadRequestMediator) {
        boolean z;
        RangeResponse rangeResponse = new RangeResponse(a0Var.mo19290x().mo19502a(CONTENT_RANGE));
        if (a0Var.mo19288v() == 206 && BYTES.equalsIgnoreCase(rangeResponse.dimension)) {
            long j2 = rangeResponse.rangeStart;
            if (j2 >= 0 && j == j2) {
                z = true;
                "satisfies partial download: " + z + " " + debugString(downloadRequestMediator);
                return z;
            }
        }
        z = false;
        "satisfies partial download: " + z + " " + debugString(downloadRequestMediator);
        return z;
    }

    /* access modifiers changed from: private */
    public void saveMeta(File file, HashMap<String, String> hashMap) {
        FileUtility.writeMap(file.getPath(), hashMap);
    }

    /* access modifiers changed from: private */
    public void sleep(long j) {
        try {
            Thread.sleep(Math.max(0, j));
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException ", e);
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: private */
    public boolean useCacheOnFail(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map, int i) {
        return this.cache != null && downloadRequestMediator.isCacheable && i != 200 && i != RANGE_NOT_SATISFIABLE && i != 206 && Boolean.parseBoolean(map.get(DOWNLOAD_COMPLETE)) && file.exists() && file.length() > 0;
    }

    /* access modifiers changed from: private */
    public boolean useCacheWithoutVerification(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map) {
        String str;
        if (map == null || this.cache == null || !downloadRequestMediator.isCacheable || (str = map.get(LAST_CACHE_VERIFICATION)) == null || !file.exists() || !Boolean.parseBoolean(map.get(DOWNLOAD_COMPLETE))) {
            return false;
        }
        try {
            long parseLong = Long.parseLong(str);
            long j = this.timeWindow;
            if (j >= Long.MAX_VALUE - parseLong || parseLong + j >= System.currentTimeMillis()) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public synchronized void cancel(DownloadRequest downloadRequest) {
        if (downloadRequest != null) {
            onCancelled(downloadRequest);
        }
    }

    public synchronized void cancelAll() {
        for (DownloadRequest next : this.transitioning) {
            "Cancel in transtiotion " + next.url;
            cancel(next);
        }
        "Cancel in mediator " + this.mediators.values().size();
        for (DownloadRequestMediator next2 : this.mediators.values()) {
            "Cancel in mediator " + next2.key;
            onCancelledMediator(next2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        sleep(10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancelAndAwait(com.vungle.warren.downloader.DownloadRequest r6, long r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r5.cancel(r6)
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            long r7 = java.lang.Math.max(r3, r7)
            long r1 = r1 + r7
        L_0x0012:
            long r7 = java.lang.System.currentTimeMillis()
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0040
            com.vungle.warren.downloader.DownloadRequestMediator r7 = r5.findMediatorForCancellation(r6)
            monitor-enter(r5)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r8 = r5.transitioning     // Catch:{ all -> 0x003d }
            boolean r8 = r8.contains(r6)     // Catch:{ all -> 0x003d }
            if (r8 != 0) goto L_0x0036
            if (r7 == 0) goto L_0x0033
            java.util.List r7 = r7.requests()     // Catch:{ all -> 0x003d }
            boolean r7 = r7.contains(r6)     // Catch:{ all -> 0x003d }
            if (r7 != 0) goto L_0x0036
        L_0x0033:
            r6 = 1
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            return r6
        L_0x0036:
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            r7 = 10
            r5.sleep(r7)
            goto L_0x0012
        L_0x003d:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            throw r6
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.cancelAndAwait(com.vungle.warren.downloader.DownloadRequest, long):boolean");
    }

    public synchronized void clearCache() {
        if (this.cache != null) {
            this.cache.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void download(final com.vungle.warren.downloader.DownloadRequest r5, final com.vungle.warren.downloader.AssetDownloadListener r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L_0x0019
            if (r6 == 0) goto L_0x0017
            r5 = 0
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r0 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x002d }
            r1 = -1
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x002d }
            java.lang.String r3 = "DownloadRequest is null"
            r2.<init>(r3)     // Catch:{ all -> 0x002d }
            r3 = 1
            r0.<init>(r1, r2, r3)     // Catch:{ all -> 0x002d }
            r4.deliverError(r5, r6, r0)     // Catch:{ all -> 0x002d }
        L_0x0017:
            monitor-exit(r4)
            return
        L_0x0019:
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r0 = r4.transitioning     // Catch:{ all -> 0x002d }
            r0.add(r5)     // Catch:{ all -> 0x002d }
            java.util.concurrent.ThreadPoolExecutor r0 = r4.downloadExecutor     // Catch:{ all -> 0x002d }
            com.vungle.warren.downloader.AssetDownloader$1 r1 = new com.vungle.warren.downloader.AssetDownloader$1     // Catch:{ all -> 0x002d }
            r2 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r1.<init>(r2, r5, r6)     // Catch:{ all -> 0x002d }
            r0.execute(r1)     // Catch:{ all -> 0x002d }
            monitor-exit(r4)
            return
        L_0x002d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.download(com.vungle.warren.downloader.DownloadRequest, com.vungle.warren.downloader.AssetDownloadListener):void");
    }

    public boolean dropCache(String str) {
        DownloaderCache downloaderCache = this.cache;
        if (downloaderCache == null || str == null) {
            return false;
        }
        try {
            File file = downloaderCache.getFile(str);
            "Broken asset, deleting " + file.getPath();
            return this.cache.deleteAndRemove(file);
        } catch (IOException e) {
            Log.e(TAG, "There was an error to get file", e);
            return false;
        }
    }

    public synchronized List<DownloadRequest> getAllRequests() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (DownloadRequestMediator requests : new ArrayList(this.mediators.values())) {
            arrayList.addAll(requests.requests());
        }
        arrayList.addAll(this.transitioning);
        return arrayList;
    }

    public synchronized void init() {
        if (this.cache != null) {
            this.cache.init();
        }
    }

    public synchronized boolean isCacheEnabled() {
        return this.cache != null && this.isCacheEnabled;
    }

    public synchronized void setCacheEnabled(boolean z) {
        this.isCacheEnabled = z;
    }

    /* access modifiers changed from: package-private */
    public synchronized void setDownloadedForTests(boolean z, String str, String str2) {
        ArrayList<File> arrayList = new ArrayList<>(2);
        if (this.cache != null) {
            try {
                arrayList.add(this.cache.getMetaFile(this.cache.getFile(str)));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to get file for request");
            }
        }
        arrayList.add(new File(str2 + META_POSTFIX_EXT));
        for (File file : arrayList) {
            HashMap<String, String> extractMeta = extractMeta(file);
            extractMeta.put(DOWNLOAD_COMPLETE, Boolean.valueOf(z).toString());
            FileUtility.writeSerializable(file, extractMeta);
        }
    }

    public void setProgressStep(int i) {
        if (i != 0) {
            this.progressStep = i;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void shutdown() {
        cancel((DownloadRequest) null);
        this.transitioning.clear();
        this.mediators.clear();
        this.uiExecutor.shutdownNow();
        this.downloadExecutor.shutdownNow();
        try {
            this.downloadExecutor.awaitTermination(2, TimeUnit.SECONDS);
            this.uiExecutor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException ", e);
            Thread.currentThread().interrupt();
        }
        return;
    }

    public void updatePriority(DownloadRequest downloadRequest) {
        Runnable runnable;
        DownloadRequestMediator findMediatorForCancellation = findMediatorForCancellation(downloadRequest);
        if (findMediatorForCancellation != null && (runnable = findMediatorForCancellation.getRunnable()) != null && this.downloadExecutor.remove(runnable)) {
            "prio: updated to " + findMediatorForCancellation.getPriority();
            this.downloadExecutor.execute(runnable);
        }
    }

    public AssetDownloader(DownloaderCache downloaderCache, long j, int i, NetworkProvider networkProvider2, ExecutorService executorService) {
        this.retryCountOnConnectionLost = 5;
        this.maxReconnectAttempts = 10;
        this.reconnectTimeout = 300;
        this.mediators = new ConcurrentHashMap();
        this.transitioning = new ArrayList();
        this.addLock = new Object();
        this.progressStep = 5;
        this.isCacheEnabled = true;
        this.networkListener = new NetworkProvider.NetworkListener() {
            public void onChanged(int i) {
                String unused = AssetDownloader.TAG;
                "Network changed: " + i;
                AssetDownloader.this.onNetworkChanged(i);
            }
        };
        this.cache = downloaderCache;
        int max = Math.max(i, 1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, max, 1, TimeUnit.SECONDS, new PriorityBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.timeWindow = j;
        this.downloadExecutor = threadPoolExecutor;
        this.networkProvider = networkProvider2;
        this.uiExecutor = executorService;
        C3542v.C3544b bVar = new C3542v.C3544b();
        bVar.mo19586b(30, TimeUnit.SECONDS);
        bVar.mo19581a(30, TimeUnit.SECONDS);
        bVar.mo19582a((C3487c) null);
        bVar.mo19584a(true);
        bVar.mo19587b(true);
        this.okHttpClient = bVar.mo19585a();
    }

    private String debugString(DownloadRequest downloadRequest) {
        return ", single request url - " + downloadRequest.url + ", path - " + downloadRequest.path + ", th - " + Thread.currentThread().getName() + "id " + downloadRequest.f14485id;
    }

    public static abstract class DownloadPriorityRunnable implements Comparable, Runnable {
        private static final AtomicInteger seq = new AtomicInteger();
        private final DownloadRequestMediator mediator;
        private final int order = seq.incrementAndGet();
        private final int priority;

        DownloadPriorityRunnable(DownloadRequestMediator downloadRequestMediator) {
            this.mediator = downloadRequestMediator;
            this.priority = 0;
            downloadRequestMediator.setRunnable(this);
        }

        public int compareTo(Object obj) {
            if (!(obj instanceof DownloadPriorityRunnable)) {
                return -1;
            }
            DownloadPriorityRunnable downloadPriorityRunnable = (DownloadPriorityRunnable) obj;
            int compareTo = getPriority().compareTo(downloadPriorityRunnable.getPriority());
            return compareTo == 0 ? Integer.valueOf(this.order).compareTo(Integer.valueOf(downloadPriorityRunnable.order)) : compareTo;
        }

        /* access modifiers changed from: package-private */
        public Integer getPriority() {
            DownloadRequestMediator downloadRequestMediator = this.mediator;
            return Integer.valueOf(downloadRequestMediator != null ? downloadRequestMediator.getPriority() : this.priority);
        }

        DownloadPriorityRunnable(@DownloadRequest.Priority int i) {
            this.priority = i;
            this.mediator = null;
        }
    }
}
