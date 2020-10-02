package admost.adserver.core;

import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import p030c.p031a.p032a.C1180c;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: admost.adserver.core.c */
/* compiled from: AdMostGenericRequest */
public class C0051c<T> extends AsyncTask<String, Integer, T> {

    /* renamed from: a */
    private C1180c<T> f145a;

    /* renamed from: b */
    private String f146b;

    /* renamed from: c */
    private C0053b f147c;

    /* renamed from: d */
    private int f148d;

    /* renamed from: admost.adserver.core.c$a */
    /* compiled from: AdMostGenericRequest */
    static /* synthetic */ class C0052a {

        /* renamed from: a */
        static final /* synthetic */ int[] f149a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                admost.adserver.core.c$b[] r0 = admost.adserver.core.C0051c.C0053b.m142a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f149a = r0
                admost.adserver.core.c$b r1 = admost.adserver.core.C0051c.C0053b.CP_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f149a     // Catch:{ NoSuchFieldError -> 0x001d }
                admost.adserver.core.c$b r1 = admost.adserver.core.C0051c.C0053b.COUNTRY_RESPONSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f149a     // Catch:{ NoSuchFieldError -> 0x0028 }
                admost.adserver.core.c$b r1 = admost.adserver.core.C0051c.C0053b.ADMOST_ADSERVER_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f149a     // Catch:{ NoSuchFieldError -> 0x0033 }
                admost.adserver.core.c$b r1 = admost.adserver.core.C0051c.C0053b.ADMOST_TRACKER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: admost.adserver.core.C0051c.C0052a.<clinit>():void");
        }
    }

    /* renamed from: admost.adserver.core.c$b */
    /* compiled from: AdMostGenericRequest */
    public enum C0053b {
        CP_RESPONSE,
        COUNTRY_RESPONSE,
        ADMOST_ADSERVER_RESPONSE,
        ADMOST_TRACKER;

        /* renamed from: a */
        public static C0053b[] m142a() {
            return (C0053b[]) f154e.clone();
        }
    }

    public C0051c(C0053b bVar, String str, C1180c<T> cVar) {
        this.f147c = bVar;
        this.f148d = m132a(bVar);
        this.f146b = m133a(bVar, str);
        this.f145a = cVar;
    }

    /* renamed from: a */
    private String m133a(C0053b bVar, String str) {
        int i = C0052a.f149a[bVar.ordinal()];
        if (i == 1) {
            return "http://go.admost.com/v2/adx/get.ashx";
        }
        if (i == 2) {
            return "http://med-api.admost.com/v4/country";
        }
        if (i != 3) {
            return i != 4 ? "" : str;
        }
        return "http://go.admost.com/v2/adx/getmobile.ashx";
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010b  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m137b(java.lang.String... r9) {
        /*
            r8 = this;
            java.lang.String r0 = "ADMOST-VIDEO"
            java.lang.String r1 = "UTF-8"
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            r6.<init>()     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            java.lang.String r7 = r8.f146b     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            r6.append(r7)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            r7 = 0
            r9 = r9[r7]     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            r6.append(r9)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            java.lang.String r9 = r6.toString()     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            r5.<init>(r9)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            java.net.URLConnection r9 = r5.openConnection()     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
            int r5 = r8.f148d     // Catch:{ Exception -> 0x00f3 }
            r9.setConnectTimeout(r5)     // Catch:{ Exception -> 0x00f3 }
            int r5 = r8.f148d     // Catch:{ Exception -> 0x00f3 }
            r9.setReadTimeout(r5)     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r5 = "Accept-Charset"
            r9.setRequestProperty(r5, r1)     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r5 = "Content-Language"
            java.lang.String r6 = "tr-TR"
            r9.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x00f3 }
            int r5 = r9.getResponseCode()     // Catch:{ Exception -> 0x00f3 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 == r6) goto L_0x00c4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f3 }
            r5.<init>()     // Catch:{ Exception -> 0x00f3 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f3 }
            long r6 = r6 - r3
            r5.append(r6)     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r3 = " ms Error:"
            r5.append(r3)     // Catch:{ Exception -> 0x00f3 }
            int r3 = r9.getResponseCode()     // Catch:{ Exception -> 0x00f3 }
            r5.append(r3)     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r3 = " "
            r5.append(r3)     // Catch:{ Exception -> 0x00f3 }
            java.net.URL r3 = r9.getURL()     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00f3 }
            r5.append(r3)     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x00f3 }
            android.util.Log.w(r0, r3)     // Catch:{ Exception -> 0x00f3 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00ba }
            java.io.InputStream r5 = r9.getErrorStream()     // Catch:{ Exception -> 0x00ba }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00ba }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ba }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00ba }
            r6.<init>(r4, r1)     // Catch:{ Exception -> 0x00ba }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00ba }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r1.<init>()     // Catch:{ Exception -> 0x00ba }
        L_0x008e:
            java.lang.String r4 = r5.readLine()     // Catch:{ Exception -> 0x00ba }
            if (r4 == 0) goto L_0x0098
            r1.append(r4)     // Catch:{ Exception -> 0x00ba }
            goto L_0x008e
        L_0x0098:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r4.<init>()     // Catch:{ Exception -> 0x00ba }
            admost.adserver.core.c$b r5 = r8.f147c     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x00ba }
            r4.append(r5)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = " : "
            r4.append(r5)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ba }
            r4.append(r1)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x00ba }
            android.util.Log.w(r0, r1)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00be
        L_0x00ba:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x00f3 }
        L_0x00be:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x00f3 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00f3 }
            throw r0     // Catch:{ Exception -> 0x00f3 }
        L_0x00c4:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00f3 }
            java.io.InputStream r3 = r9.getInputStream()     // Catch:{ Exception -> 0x00f3 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00f3 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00f3 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00f3 }
            r4.<init>(r0, r1)     // Catch:{ Exception -> 0x00f3 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00f3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f3 }
            r1.<init>()     // Catch:{ Exception -> 0x00f3 }
        L_0x00dc:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x00f3 }
            if (r4 == 0) goto L_0x00e6
            r1.append(r4)     // Catch:{ Exception -> 0x00f3 }
            goto L_0x00dc
        L_0x00e6:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00f3 }
            r0.close()     // Catch:{ Exception -> 0x00f3 }
            if (r9 == 0) goto L_0x00f2
            r9.disconnect()
        L_0x00f2:
            return r1
        L_0x00f3:
            r0 = move-exception
            goto L_0x00f9
        L_0x00f5:
            r0 = move-exception
            goto L_0x0109
        L_0x00f7:
            r0 = move-exception
            r9 = r2
        L_0x00f9:
            r0.printStackTrace()     // Catch:{ all -> 0x0107 }
            java.lang.String r1 = ""
            r8.m136a((java.lang.String) r1, (java.lang.Exception) r0)     // Catch:{ all -> 0x0107 }
            if (r9 == 0) goto L_0x0106
            r9.disconnect()
        L_0x0106:
            return r2
        L_0x0107:
            r0 = move-exception
            r2 = r9
        L_0x0109:
            if (r2 == 0) goto L_0x010e
            r2.disconnect()
        L_0x010e:
            goto L_0x0110
        L_0x010f:
            throw r0
        L_0x0110:
            goto L_0x010f
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.adserver.core.C0051c.m137b(java.lang.String[]):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0110  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject m138c(java.lang.String... r9) {
        /*
            r8 = this;
            java.lang.String r0 = "ADMOST-VIDEO"
            java.lang.String r1 = "UTF-8"
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            r6.<init>()     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            java.lang.String r7 = r8.f146b     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            r6.append(r7)     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            r7 = 0
            r9 = r9[r7]     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            r6.append(r9)     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            java.lang.String r9 = r6.toString()     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            r5.<init>(r9)     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            java.net.URLConnection r9 = r5.openConnection()     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Exception -> 0x00fc, all -> 0x00fa }
            int r5 = r8.f148d     // Catch:{ Exception -> 0x00f8 }
            r9.setConnectTimeout(r5)     // Catch:{ Exception -> 0x00f8 }
            int r5 = r8.f148d     // Catch:{ Exception -> 0x00f8 }
            r9.setReadTimeout(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "Accept-Charset"
            r9.setRequestProperty(r5, r1)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "Content-Language"
            java.lang.String r6 = "tr-TR"
            r9.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x00f8 }
            int r5 = r9.getResponseCode()     // Catch:{ Exception -> 0x00f8 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 == r6) goto L_0x00c4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f8 }
            r5.<init>()     // Catch:{ Exception -> 0x00f8 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f8 }
            long r6 = r6 - r3
            r5.append(r6)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r3 = " ms Error:"
            r5.append(r3)     // Catch:{ Exception -> 0x00f8 }
            int r3 = r9.getResponseCode()     // Catch:{ Exception -> 0x00f8 }
            r5.append(r3)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r3 = " "
            r5.append(r3)     // Catch:{ Exception -> 0x00f8 }
            java.net.URL r3 = r9.getURL()     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00f8 }
            r5.append(r3)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x00f8 }
            android.util.Log.w(r0, r3)     // Catch:{ Exception -> 0x00f8 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00ba }
            java.io.InputStream r5 = r9.getErrorStream()     // Catch:{ Exception -> 0x00ba }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00ba }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ba }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00ba }
            r6.<init>(r4, r1)     // Catch:{ Exception -> 0x00ba }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00ba }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r1.<init>()     // Catch:{ Exception -> 0x00ba }
        L_0x008e:
            java.lang.String r4 = r5.readLine()     // Catch:{ Exception -> 0x00ba }
            if (r4 == 0) goto L_0x0098
            r1.append(r4)     // Catch:{ Exception -> 0x00ba }
            goto L_0x008e
        L_0x0098:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r4.<init>()     // Catch:{ Exception -> 0x00ba }
            admost.adserver.core.c$b r5 = r8.f147c     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x00ba }
            r4.append(r5)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = " : "
            r4.append(r5)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ba }
            r4.append(r1)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x00ba }
            android.util.Log.w(r0, r1)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00be
        L_0x00ba:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x00f8 }
        L_0x00be:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x00f8 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00f8 }
            throw r0     // Catch:{ Exception -> 0x00f8 }
        L_0x00c4:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00f8 }
            java.io.InputStream r3 = r9.getInputStream()     // Catch:{ Exception -> 0x00f8 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00f8 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00f8 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00f8 }
            r4.<init>(r0, r1)     // Catch:{ Exception -> 0x00f8 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00f8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f8 }
            r1.<init>()     // Catch:{ Exception -> 0x00f8 }
        L_0x00dc:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x00f8 }
            if (r4 == 0) goto L_0x00e6
            r1.append(r4)     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00dc
        L_0x00e6:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00f8 }
            r0.close()     // Catch:{ Exception -> 0x00f8 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00f8 }
            if (r9 == 0) goto L_0x00f7
            r9.disconnect()
        L_0x00f7:
            return r0
        L_0x00f8:
            r0 = move-exception
            goto L_0x00fe
        L_0x00fa:
            r0 = move-exception
            goto L_0x010e
        L_0x00fc:
            r0 = move-exception
            r9 = r2
        L_0x00fe:
            r0.printStackTrace()     // Catch:{ all -> 0x010c }
            java.lang.String r1 = ""
            r8.m136a((java.lang.String) r1, (java.lang.Exception) r0)     // Catch:{ all -> 0x010c }
            if (r9 == 0) goto L_0x010b
            r9.disconnect()
        L_0x010b:
            return r2
        L_0x010c:
            r0 = move-exception
            r2 = r9
        L_0x010e:
            if (r2 == 0) goto L_0x0113
            r2.disconnect()
        L_0x0113:
            goto L_0x0115
        L_0x0114:
            throw r0
        L_0x0115:
            goto L_0x0114
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.adserver.core.C0051c.m138c(java.lang.String[]):org.json.JSONObject");
    }

    /* renamed from: d */
    private String m139d(String... strArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f146b).openConnection();
            "AdMostTracker host : " + this.f146b + " responseCode: " + httpURLConnection.getResponseCode();
            httpURLConnection.disconnect();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(T t) {
        C1180c<T> cVar;
        if (!(t == null || (cVar = this.f145a) == null)) {
            cVar.onResponse(t);
        }
        this.f145a = null;
    }

    /* renamed from: a */
    private int m132a(C0053b bVar) {
        int i = C0052a.f149a[bVar.ordinal()];
        if (i == 1 || i == 2) {
            return 5000;
        }
        return C6078a.DEFAULT_TIMEOUT;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public T doInBackground(String... strArr) {
        int i = C0052a.f149a[this.f147c.ordinal()];
        if (i == 1) {
            return m137b(strArr);
        }
        if (i == 2) {
            return m135a();
        }
        if (i == 3) {
            return m138c(strArr);
        }
        if (i != 4) {
            return null;
        }
        return m139d(strArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject m135a() {
        /*
            r5 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            java.lang.String r2 = r5.f146b     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0039, all -> 0x0034 }
            int r2 = r5.f148d     // Catch:{ Exception -> 0x0032 }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x0032 }
            int r2 = r5.f148d     // Catch:{ Exception -> 0x0032 }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = "Accept-Charset"
            java.lang.String r3 = "UTF-8"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x0032 }
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = r5.m134a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0032 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0032 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0032 }
            if (r1 == 0) goto L_0x0031
            r1.disconnect()
        L_0x0031:
            return r3
        L_0x0032:
            r2 = move-exception
            goto L_0x003b
        L_0x0034:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x004a
        L_0x0039:
            r2 = move-exception
            r1 = r0
        L_0x003b:
            r2.printStackTrace()     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = ""
            r5.m136a((java.lang.String) r3, (java.lang.Exception) r2)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0048
            r1.disconnect()
        L_0x0048:
            return r0
        L_0x0049:
            r0 = move-exception
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.disconnect()
        L_0x004f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.adserver.core.C0051c.m135a():org.json.JSONObject");
    }

    /* renamed from: a */
    public void mo91a(Context context, String... strArr) {
        if (C0049a.m124a(context).mo87a() != null) {
            executeOnExecutor(C0049a.m124a(context).mo87a(), strArr);
        } else {
            execute(strArr);
        }
    }

    /* renamed from: a */
    private void m136a(String str, Exception exc) {
        C1180c<T> cVar = this.f145a;
        if (cVar != null) {
            cVar.onError(str, exc);
        }
    }

    /* renamed from: a */
    private String m134a(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(13);
                } else {
                    bufferedReader.close();
                    return stringBuffer.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
