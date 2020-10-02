package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.datatransport.cct.p070b.C2942a;
import com.google.android.datatransport.cct.p070b.C2944b;
import com.google.android.datatransport.cct.p070b.C2963k;
import com.google.android.datatransport.cct.p070b.C2965m;
import com.google.android.datatransport.cct.p070b.C2969o;
import com.google.android.datatransport.cct.p070b.C2970p;
import com.google.android.datatransport.cct.p070b.C2973r;
import com.google.android.datatransport.cct.p070b.C2976t;
import com.google.android.datatransport.cct.p070b.C2977u;
import com.google.android.datatransport.runtime.backends.C2995f;
import com.google.android.datatransport.runtime.backends.C2997g;
import com.google.android.datatransport.runtime.backends.C3005m;
import com.google.firebase.encoders.C3669a;
import com.google.firebase.encoders.EncodingException;
import com.loopj.android.http.C4250c;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import p093e.p101c.p102a.p103a.C3378b;
import p093e.p101c.p102a.p103a.p104i.C3399g;
import p093e.p101c.p102a.p103a.p104i.C3400h;
import p093e.p101c.p102a.p103a.p104i.p105t.C3416a;
import p093e.p101c.p102a.p103a.p104i.p106u.C3418b;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.google.android.datatransport.cct.e */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final class C2984e implements C3005m {

    /* renamed from: a */
    private final C3669a f8328a = C2969o.m9803a();

    /* renamed from: b */
    private final ConnectivityManager f8329b;

    /* renamed from: c */
    final URL f8330c;

    /* renamed from: d */
    private final C3469a f8331d;

    /* renamed from: e */
    private final C3469a f8332e;

    /* renamed from: f */
    private final int f8333f;

    /* renamed from: com.google.android.datatransport.cct.e$a */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    static final class C2985a {

        /* renamed from: a */
        final URL f8334a;

        /* renamed from: b */
        final C2963k f8335b;

        /* renamed from: c */
        final String f8336c;

        C2985a(URL url, C2963k kVar, String str) {
            this.f8334a = url;
            this.f8335b = kVar;
            this.f8336c = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2985a mo12945a(URL url) {
            return new C2985a(url, this.f8335b, this.f8336c);
        }
    }

    /* renamed from: com.google.android.datatransport.cct.e$b */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    static final class C2986b {

        /* renamed from: a */
        final int f8337a;

        /* renamed from: b */
        final URL f8338b;

        /* renamed from: c */
        final long f8339c;

        C2986b(int i, URL url, long j) {
            this.f8337a = i;
            this.f8338b = url;
            this.f8339c = j;
        }
    }

    C2984e(Context context, C3469a aVar, C3469a aVar2) {
        this.f8329b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f8330c = m9845a(C2941a.f8212c);
        this.f8331d = aVar2;
        this.f8332e = aVar;
        this.f8333f = 40000;
    }

    /* renamed from: a */
    public C3400h mo12944a(C3400h hVar) {
        int i;
        int i2;
        NetworkInfo activeNetworkInfo = this.f8329b.getActiveNetworkInfo();
        C3400h.C3401a h = hVar.mo19206h();
        h.mo19207a("sdk-version", Build.VERSION.SDK_INT);
        h.mo19209a("model", Build.MODEL);
        h.mo19209a("hardware", Build.HARDWARE);
        h.mo19209a(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, Build.DEVICE);
        h.mo19209a(AppLovinEventTypes.USER_VIEWED_PRODUCT, Build.PRODUCT);
        h.mo19209a("os-uild", Build.ID);
        h.mo19209a("manufacturer", Build.MANUFACTURER);
        h.mo19209a("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        h.mo19208a("tz-offset", (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        if (activeNetworkInfo == null) {
            i = C2977u.C2980c.NONE.zza();
        } else {
            i = activeNetworkInfo.getType();
        }
        h.mo19207a("net-type", i);
        if (activeNetworkInfo == null) {
            i2 = C2977u.C2979b.UNKNOWN_MOBILE_SUBTYPE.zza();
        } else {
            i2 = activeNetworkInfo.getSubtype();
            if (i2 == -1) {
                i2 = C2977u.C2979b.COMBINED.zza();
            } else if (C2977u.C2979b.m9836a(i2) == null) {
                i2 = 0;
            }
        }
        h.mo19207a("mobile-subtype", i2);
        return h.mo19167a();
    }

    /* renamed from: a */
    public C2997g mo12943a(C2995f fVar) {
        C2970p.C2971a aVar;
        HashMap hashMap = new HashMap();
        for (C3400h next : fVar.mo12947a()) {
            String f = next.mo19158f();
            if (!hashMap.containsKey(f)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(f, arrayList);
            } else {
                ((List) hashMap.get(f)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            C3400h hVar = (C3400h) ((List) entry.getValue()).get(0);
            C2973r.C2974a a = C2973r.m9818a();
            a.mo12919a(C2944b.f8219a);
            a.mo12918a(this.f8332e.mo19256a());
            a.mo12924b(this.f8331d.mo19256a());
            C2965m.C2966a a2 = C2965m.m9798a();
            a2.mo12888a(C2965m.C2967b.ANDROID);
            C2942a.C2943a a3 = C2942a.m9726a();
            a3.mo12857a(hVar.mo19203b("sdk-version"));
            a3.mo12863e(hVar.mo19202a("model"));
            a3.mo12861c(hVar.mo19202a("hardware"));
            a3.mo12858a(hVar.mo19202a(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX));
            a3.mo12865g(hVar.mo19202a(AppLovinEventTypes.USER_VIEWED_PRODUCT));
            a3.mo12864f(hVar.mo19202a("os-uild"));
            a3.mo12862d(hVar.mo19202a("manufacturer"));
            a3.mo12860b(hVar.mo19202a("fingerprint"));
            a2.mo12887a(a3.mo12859a());
            a.mo12920a(a2.mo12889a());
            try {
                a.mo12937b(Integer.valueOf((String) entry.getKey()).intValue());
            } catch (NumberFormatException unused) {
                a.mo12938b((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (C3400h hVar2 : (List) entry.getValue()) {
                C3399g c = hVar2.mo19155c();
                C3378b b = c.mo19198b();
                if (b.equals(C3378b.m11260a("proto"))) {
                    aVar = C2970p.m9805a(c.mo19197a());
                } else if (b.equals(C3378b.m11260a("json"))) {
                    aVar = C2970p.m9804a(new String(c.mo19197a(), Charset.forName(C4250c.DEFAULT_CHARSET)));
                } else {
                    C3416a.m11382b("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b);
                }
                aVar.mo12901a(hVar2.mo19156d());
                aVar.mo12906b(hVar2.mo19159g());
                aVar.mo12907c(hVar2.mo19204c("tz-offset"));
                C2977u.C2978a a4 = C2977u.m9832a();
                a4.mo12935a(C2977u.C2980c.m9837a(hVar2.mo19203b("net-type")));
                a4.mo12934a(C2977u.C2979b.m9836a(hVar2.mo19203b("mobile-subtype")));
                aVar.mo12902a(a4.mo12936a());
                if (hVar2.mo19154b() != null) {
                    aVar.mo12900a(hVar2.mo19154b().intValue());
                }
                arrayList3.add(aVar.mo12905a());
            }
            a.mo12922a((List<C2970p>) arrayList3);
            arrayList2.add(a.mo12923a());
        }
        C2963k a5 = C2963k.m9795a(arrayList2);
        String str = null;
        URL url = this.f8330c;
        if (fVar.mo12948b() != null) {
            try {
                C2941a a6 = C2941a.m9721a(fVar.mo12948b());
                if (a6.mo12853c() != null) {
                    str = a6.mo12853c();
                }
                if (a6.mo12854d() != null) {
                    url = m9845a(a6.mo12854d());
                }
            } catch (IllegalArgumentException unused2) {
                return C2997g.m9868c();
            }
        }
        try {
            C2986b bVar = (C2986b) C3418b.m11383a(5, new C2985a(url, a5, str), C2982c.m9839a(this), C2983d.m9840a());
            if (bVar.f8337a == 200) {
                return C2997g.m9867a(bVar.f8339c);
            }
            int i = bVar.f8337a;
            if (i < 500) {
                if (i != 404) {
                    return C2997g.m9868c();
                }
            }
            return C2997g.m9869d();
        } catch (IOException e) {
            C3416a.m11380a("CctTransportBackend", "Could not make request to the backend", (Throwable) e);
            return C2997g.m9869d();
        }
    }

    /* renamed from: a */
    private static URL m9845a(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C2986b m9843a(C2985a aVar) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        InputStream inputStream;
        C3416a.m11379a("CctTransportBackend", "Making request to: %s", (Object) aVar.f8334a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f8334a.openConnection();
        httpURLConnection.setConnectTimeout(QumparaOfferwallModels.OfferwallStatus.VIRTUAL_CURRENCY_MIN_INTERVAL);
        httpURLConnection.setReadTimeout(this.f8333f);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(C6078a.HEADER_USER_AGENT, String.format("datatransport/%s android/", new Object[]{"2.2.0"}));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", C6078a.ACCEPT_JSON_VALUE);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f8336c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        WritableByteChannel newChannel = Channels.newChannel(httpURLConnection.getOutputStream());
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                this.f8328a.mo27270a(aVar.f8335b, new OutputStreamWriter(gZIPOutputStream));
                gZIPOutputStream.close();
                newChannel.write(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
                int responseCode = httpURLConnection.getResponseCode();
                StringBuilder sb = new StringBuilder();
                sb.append("Status Code: ");
                sb.append(responseCode);
                C3416a.m11378a("CctTransportBackend", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Content-Type: ");
                sb2.append(httpURLConnection.getHeaderField("Content-Type"));
                C3416a.m11378a("CctTransportBackend", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Content-Encoding: ");
                sb3.append(httpURLConnection.getHeaderField("Content-Encoding"));
                C3416a.m11378a("CctTransportBackend", sb3.toString());
                if (!(responseCode == 302 || responseCode == 301)) {
                    if (responseCode != 307) {
                        if (responseCode != 200) {
                            C2986b bVar = new C2986b(responseCode, (URL) null, 0);
                            newChannel.close();
                            return bVar;
                        }
                        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                        if (headerField == null || !headerField.equals("gzip")) {
                            inputStream = httpURLConnection.getInputStream();
                        } else {
                            inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                        }
                        C2986b bVar2 = new C2986b(responseCode, (URL) null, C2976t.m9830a(new InputStreamReader(inputStream)).mo12925a());
                        inputStream.close();
                        newChannel.close();
                        return bVar2;
                    }
                }
                C2986b bVar3 = new C2986b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0);
                newChannel.close();
                return bVar3;
            } catch (EncodingException | IOException e) {
                C3416a.m11380a("CctTransportBackend", "Couldn't encode request, returning with 400", e);
                C2986b bVar4 = new C2986b(400, (URL) null, 0);
                gZIPOutputStream.close();
                newChannel.close();
                return bVar4;
            }
        } catch (Throwable th) {
            newChannel.close();
            throw th;
        }
    }

    /* renamed from: a */
    static /* synthetic */ C2985a m9842a(C2985a aVar, C2986b bVar) {
        URL url = bVar.f8338b;
        if (url == null) {
            return null;
        }
        C3416a.m11379a("CctTransportBackend", "Following redirect to: %s", (Object) url);
        return aVar.mo12945a(bVar.f8338b);
    }
}
