package com.miniclip.network;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HttpConnection {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    public static final int HttpConnectionErrorBadURL = -1000;
    public static final int HttpConnectionErrorUnknown = -1;
    public static final int HttpConnectionErrorUnknownHost = -1003;
    private static final int KEEP_ALIVE = 1;
    private static final int MAXIMUM_POOL_SIZE;
    private static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.SECONDS, sPoolWorkQueue);
    private static int defaultTimeout = 60000;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue();
    /* access modifiers changed from: private */
    public boolean canceled;
    protected Integer connectionID;
    /* access modifiers changed from: private */
    public int errorCode;
    protected HashMap<String, String> headerProperties;
    protected String httpCommand;
    protected boolean jniCall;
    protected HttpConnectionListener listener;
    protected int timeout;
    protected String urlBody;
    protected String urlString;

    /* renamed from: com.miniclip.network.HttpConnection$a */
    class C4280a implements Runnable {
        C4280a() {
        }

        public void run() {
            C4281b bVar = new C4281b(HttpConnection.this, (C4280a) null);
            boolean a = bVar.mo28996a(HttpConnection.this.urlString);
            if (!HttpConnection.this.canceled) {
                bVar.mo28995a(a);
            }
        }
    }

    /* renamed from: com.miniclip.network.HttpConnection$b */
    private class C4281b {
        private C4281b() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x01da, code lost:
            r11 = e;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0175 */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x01fd  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x021d  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004f A[Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x007c A[Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }, LOOP:0: B:19:0x0076->B:21:0x007c, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0094 A[Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00ba A[SYNTHETIC, Splitter:B:35:0x00ba] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x01da A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:48:0x011d] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x01f1  */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:109:0x0207=Splitter:B:109:0x0207, B:94:0x01e8=Splitter:B:94:0x01e8, B:101:0x01f8=Splitter:B:101:0x01f8} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo28996a(java.lang.String r11) {
            /*
                r10 = this;
                java.lang.String r0 = "HttpConnection"
                com.miniclip.network.HttpConnection r1 = com.miniclip.network.HttpConnection.this
                boolean r1 = r1.canceled
                r2 = 0
                if (r1 == 0) goto L_0x000c
                return r2
            L_0x000c:
                java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0221 }
                r1.<init>(r11)     // Catch:{ MalformedURLException -> 0x0221 }
                r11 = 0
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ UnknownHostException -> 0x0203, IOException -> 0x01f5, Exception -> 0x01e4, all -> 0x01e0 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ UnknownHostException -> 0x0203, IOException -> 0x01f5, Exception -> 0x01e4, all -> 0x01e0 }
                com.miniclip.network.HttpConnection r3 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r3 = r3.httpCommand     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r1.setRequestMethod(r3)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection r3 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r3 = r3.timeout     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r1.setReadTimeout(r3)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection r3 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r3 = r3.timeout     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r1.setConnectTimeout(r3)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r3 = 1
                r1.setDoInput(r3)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection r4 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r4 = r4.httpCommand     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r5 = "POST"
                boolean r4 = r4.equals(r5)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r4 != 0) goto L_0x004c
                com.miniclip.network.HttpConnection r4 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r4 = r4.httpCommand     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r5 = "PUT"
                boolean r4 = r4.equals(r5)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r4 == 0) goto L_0x004a
                goto L_0x004c
            L_0x004a:
                r4 = 0
                goto L_0x004d
            L_0x004c:
                r4 = 1
            L_0x004d:
                if (r4 == 0) goto L_0x006a
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r11 = r11.urlBody     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r5 = "UTF-8"
                byte[] r11 = r11.getBytes(r5)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r5 = r11.length     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r6 = "Content-Type"
                java.lang.String r7 = "application/x-www-form-urlencoded"
                r1.setRequestProperty(r6, r7)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r6 = "Content-Length"
                java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r1.setRequestProperty(r6, r5)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
            L_0x006a:
                com.miniclip.network.HttpConnection r5 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.HashMap<java.lang.String, java.lang.String> r5 = r5.headerProperties     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.Set r5 = r5.entrySet()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
            L_0x0076:
                boolean r6 = r5.hasNext()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r6 == 0) goto L_0x0092
                java.lang.Object r6 = r5.next()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.Object r7 = r6.getKey()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.Object r6 = r6.getValue()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r1.setRequestProperty(r7, r6)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                goto L_0x0076
            L_0x0092:
                if (r4 == 0) goto L_0x00ac
                com.miniclip.network.HttpConnection r4 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                boolean r4 = r4.canceled     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r4 == 0) goto L_0x00a2
                if (r1 == 0) goto L_0x00a1
                r1.disconnect()
            L_0x00a1:
                return r2
            L_0x00a2:
                r1.setDoOutput(r3)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.io.OutputStream r4 = r1.getOutputStream()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r4.write(r11)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
            L_0x00ac:
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                boolean r11 = r11.canceled     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r11 == 0) goto L_0x00ba
                if (r1 == 0) goto L_0x00b9
                r1.disconnect()
            L_0x00b9:
                return r2
            L_0x00ba:
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r4 = r1.getResponseCode()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int unused = r11.errorCode = r4     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r11 = r11.errorCode     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r4 = 200(0xc8, float:2.8E-43)
                if (r11 == r4) goto L_0x011d
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r11.<init>()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r4 = "Server returned HTTP "
                r11.append(r4)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection r4 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r4 = r4.errorCode     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r11.append(r4)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r4 = " "
                r11.append(r4)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.String r4 = r1.getResponseMessage()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r11.append(r4)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r11.toString()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r11 = r11.errorCode     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r4 = 302(0x12e, float:4.23E-43)
                if (r11 == r4) goto L_0x010d
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r11 = r11.errorCode     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r4 = 301(0x12d, float:4.22E-43)
                if (r11 == r4) goto L_0x010d
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r11 = r11.errorCode     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r4 = 303(0x12f, float:4.25E-43)
                if (r11 != r4) goto L_0x011d
            L_0x010d:
                java.lang.String r11 = "Location"
                java.lang.String r11 = r1.getHeaderField(r11)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                boolean r11 = r10.mo28996a((java.lang.String) r11)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r1 == 0) goto L_0x011c
                r1.disconnect()
            L_0x011c:
                return r11
            L_0x011d:
                java.util.Map r11 = r1.getHeaderFields()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.HashMap r4 = new java.util.HashMap     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r4.<init>()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.Set r11 = r11.entrySet()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.Iterator r11 = r11.iterator()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
            L_0x012e:
                boolean r5 = r11.hasNext()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r5 == 0) goto L_0x015d
                java.lang.Object r5 = r11.next()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.Object r6 = r5.getValue()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.List r6 = (java.util.List) r6     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                boolean r7 = r6.isEmpty()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r7 != 0) goto L_0x012e
                java.lang.Object r7 = r5.getKey()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r7 != 0) goto L_0x014d
                goto L_0x012e
            L_0x014d:
                java.lang.Object r5 = r5.getKey()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.Object r6 = r6.next()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r4.put(r5, r6)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                goto L_0x012e
            L_0x015d:
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                boolean r11 = r11.canceled     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r11 == 0) goto L_0x016b
                if (r1 == 0) goto L_0x016a
                r1.disconnect()
            L_0x016a:
                return r2
            L_0x016b:
                java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0175, Exception -> 0x01da }
                java.io.InputStream r5 = r1.getInputStream()     // Catch:{ IOException -> 0x0175, Exception -> 0x01da }
                r11.<init>(r5)     // Catch:{ IOException -> 0x0175, Exception -> 0x01da }
                goto L_0x017e
            L_0x0175:
                java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.io.InputStream r5 = r1.getErrorStream()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r11.<init>(r5)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
            L_0x017e:
                java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r5.<init>()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r6 = 1024(0x400, float:1.435E-42)
                byte[] r6 = new byte[r6]     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
            L_0x0187:
                com.miniclip.network.HttpConnection r7 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                boolean r7 = r7.canceled     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r7 == 0) goto L_0x0195
                if (r1 == 0) goto L_0x0194
                r1.disconnect()
            L_0x0194:
                return r2
            L_0x0195:
                int r7 = r11.read(r6)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r8 = -1
                if (r7 != r8) goto L_0x01d6
                byte[] r5 = r5.toByteArray()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r6 = r5.length     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r11.close()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                boolean r11 = r11.jniCall     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r11 == 0) goto L_0x01bb
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.Integer r11 = r11.connectionID     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r11 = r11.intValue()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection r7 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r7 = r7.errorCode     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection.downloadComplete(r11, r7, r4, r6, r5)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
            L_0x01bb:
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnectionListener r11 = r11.listener     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                if (r11 == 0) goto L_0x01d0
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnectionListener r11 = r11.listener     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                com.miniclip.network.HttpConnection r4 = com.miniclip.network.HttpConnection.this     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                java.lang.Integer r4 = r4.connectionID     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                int r4 = r4.intValue()     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                r11.downloadComplete(r4, r6, r5)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
            L_0x01d0:
                if (r1 == 0) goto L_0x01d5
                r1.disconnect()
            L_0x01d5:
                return r3
            L_0x01d6:
                r5.write(r6, r2, r7)     // Catch:{ UnknownHostException -> 0x01de, IOException -> 0x01dc, Exception -> 0x01da }
                goto L_0x0187
            L_0x01da:
                r11 = move-exception
                goto L_0x01e8
            L_0x01dc:
                r11 = move-exception
                goto L_0x01f8
            L_0x01de:
                r11 = move-exception
                goto L_0x0207
            L_0x01e0:
                r0 = move-exception
                r1 = r11
                r11 = r0
                goto L_0x021b
            L_0x01e4:
                r1 = move-exception
                r9 = r1
                r1 = r11
                r11 = r9
            L_0x01e8:
                java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0201 }
                android.util.Log.e(r0, r11)     // Catch:{ all -> 0x0201 }
                if (r1 == 0) goto L_0x01f4
                r1.disconnect()
            L_0x01f4:
                return r2
            L_0x01f5:
                r0 = move-exception
                r1 = r11
                r11 = r0
            L_0x01f8:
                r11.printStackTrace()     // Catch:{ all -> 0x0201 }
                if (r1 == 0) goto L_0x0200
                r1.disconnect()
            L_0x0200:
                return r2
            L_0x0201:
                r11 = move-exception
                goto L_0x021b
            L_0x0203:
                r1 = move-exception
                r9 = r1
                r1 = r11
                r11 = r9
            L_0x0207:
                java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0201 }
                android.util.Log.e(r0, r11)     // Catch:{ all -> 0x0201 }
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this     // Catch:{ all -> 0x0201 }
                r0 = -1003(0xfffffffffffffc15, float:NaN)
                int unused = r11.errorCode = r0     // Catch:{ all -> 0x0201 }
                if (r1 == 0) goto L_0x021a
                r1.disconnect()
            L_0x021a:
                return r2
            L_0x021b:
                if (r1 == 0) goto L_0x0220
                r1.disconnect()
            L_0x0220:
                throw r11
            L_0x0221:
                r1 = move-exception
                r1.printStackTrace()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Invalid URL: "
                r1.append(r3)
                r1.append(r11)
                java.lang.String r11 = r1.toString()
                android.util.Log.e(r0, r11)
                com.miniclip.network.HttpConnection r11 = com.miniclip.network.HttpConnection.this
                r0 = -1000(0xfffffffffffffc18, float:NaN)
                int unused = r11.errorCode = r0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.miniclip.network.HttpConnection.C4281b.mo28996a(java.lang.String):boolean");
        }

        /* synthetic */ C4281b(HttpConnection httpConnection, C4280a aVar) {
            this();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo28995a(boolean z) {
            if (!z) {
                String str = "MCHttpURLConnectionTask failed to " + HttpConnection.this.httpCommand + " - " + HttpConnection.this.urlString;
                Log.w("HttpConnection", str);
                HttpConnection httpConnection = HttpConnection.this;
                if (httpConnection.jniCall) {
                    HttpConnection.downloadFailed(httpConnection.connectionID.intValue(), str, HttpConnection.this.errorCode);
                }
                HttpConnection httpConnection2 = HttpConnection.this;
                HttpConnectionListener httpConnectionListener = httpConnection2.listener;
                if (httpConnectionListener != null) {
                    httpConnectionListener.downloadFailed(httpConnection2.connectionID.intValue(), str);
                    return;
                }
                return;
            }
            HttpConnectionsManager.sharedInstance().removeConnection(HttpConnection.this.connectionID);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 1;
        MAXIMUM_POOL_SIZE = (availableProcessors * 2) + 1;
    }

    public HttpConnection(String str, String str2, String str3, HttpConnectionListener httpConnectionListener, int i, HashMap hashMap) {
        this.jniCall = false;
        this.httpCommand = "GET";
        this.urlBody = "";
        this.canceled = false;
        this.errorCode = -1;
        this.connectionID = HttpConnectionsManager.sharedInstance().addConnection(this);
        this.urlString = str;
        this.httpCommand = str2;
        this.urlBody = str3;
        this.listener = httpConnectionListener;
        this.timeout = i;
        this.headerProperties = hashMap;
    }

    private static boolean cancelConnection(int i) {
        HttpConnection connection = HttpConnectionsManager.sharedInstance().getConnection(Integer.valueOf(i));
        if (connection == null) {
            return false;
        }
        return connection.cancel();
    }

    /* access modifiers changed from: private */
    public static native void downloadComplete(int i, int i2, HashMap hashMap, int i3, byte[] bArr);

    /* access modifiers changed from: private */
    public static native void downloadFailed(int i, String str, int i2);

    private static int newConnection(String str, String str2, String str3, int i, HashMap hashMap) {
        return new HttpConnection(str, str2, str3, (HttpConnectionListener) null, i, hashMap).connectionID.intValue();
    }

    private static boolean startConnection(int i) {
        HttpConnection connection = HttpConnectionsManager.sharedInstance().getConnection(Integer.valueOf(i));
        if (connection == null) {
            Log.w("HttpConnection", "Failed to start connection: could not find connection with ID " + i + "!");
            return false;
        }
        connection.jniCall = true;
        return connection.start();
    }

    public boolean cancel() {
        this.canceled = true;
        HttpConnectionsManager.sharedInstance().removeConnection(this.connectionID);
        return true;
    }

    public Integer getConnectionID() {
        return this.connectionID;
    }

    public boolean start() {
        if (this.canceled) {
            Log.w("HttpConnection", "Not starting connection with ID " + this.connectionID + " - cancel was already called.");
            return false;
        }
        THREAD_POOL_EXECUTOR.execute(new C4280a());
        return true;
    }

    public HttpConnection(String str, String str2, String str3, HttpConnectionListener httpConnectionListener, int i) {
        this(str, str2, str3, httpConnectionListener, i, new HashMap());
    }

    public HttpConnection(String str, String str2) {
        this(str, str2, "", (HttpConnectionListener) null, defaultTimeout, new HashMap());
    }

    public HttpConnection(String str, String str2, String str3) {
        this(str, str2, str3, (HttpConnectionListener) null, defaultTimeout, new HashMap());
    }

    public HttpConnection(String str, String str2, HttpConnectionListener httpConnectionListener) {
        this(str, str2, "", httpConnectionListener, defaultTimeout, new HashMap());
    }

    public HttpConnection(String str, String str2, String str3, HttpConnectionListener httpConnectionListener) {
        this(str, str2, str3, httpConnectionListener, defaultTimeout, new HashMap());
    }
}
