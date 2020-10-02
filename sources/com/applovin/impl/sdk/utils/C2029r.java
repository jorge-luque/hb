package com.applovin.impl.sdk.utils;

import admost.sdk.AdMostInterstitial;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1955n;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p049ad.C1833h;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1846a;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.drive.DriveFile;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.r */
public abstract class C2029r {
    /* renamed from: a */
    public static double m7984a(long j) {
        double d = (double) j;
        Double.isNaN(d);
        return d / 1000.0d;
    }

    /* renamed from: a */
    public static float m7985a(float f) {
        return f * 1000.0f;
    }

    /* renamed from: a */
    public static int m7986a(JSONObject jSONObject) {
        int b = C1993i.m7894b(jSONObject, "video_completion_percent", -1, (C1941j) null);
        if (b < 0 || b > 100) {
            return 95;
        }
        return b;
    }

    /* renamed from: a */
    public static long m7987a(C1941j jVar) {
        long longValue = ((Long) jVar.mo8549a(C1841c.f6022eM)).longValue();
        long longValue2 = ((Long) jVar.mo8549a(C1841c.f6023eN)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        return (longValue <= 0 || longValue2 <= 0) ? currentTimeMillis : currentTimeMillis + (longValue - longValue2);
    }

    /* renamed from: a */
    public static Activity m7988a(View view, C1941j jVar) {
        if (view == null) {
            return null;
        }
        int i = 0;
        while (i < 1000) {
            i++;
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                jVar.mo8602v().mo8743b("Utils", "Encountered error while retrieving activity from view", th);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Bitmap m7989a(Context context, int i, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i3 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), i);
            if (options.outHeight > i2 || options.outWidth > i2) {
                double d = (double) i2;
                double max = (double) Math.max(options.outHeight, options.outWidth);
                Double.isNaN(d);
                Double.isNaN(max);
                i3 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(d / max) / Math.log(0.5d))));
            }
            new BitmapFactory.Options().inSampleSize = i3;
            return BitmapFactory.decodeResource(context.getResources(), i);
        } catch (Exception unused) {
            return null;
        } finally {
            m8009a((Closeable) null, (C1941j) null);
            m8009a((Closeable) null, (C1941j) null);
        }
    }

    /* renamed from: a */
    public static Bitmap m7990a(File file, int i) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BitmapFactory.Options options;
        try {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            int i2 = 1;
            options2.inJustDecodeBounds = true;
            fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.decodeStream(fileInputStream, (Rect) null, options2);
                fileInputStream.close();
                if (options2.outHeight > i || options2.outWidth > i) {
                    double d = (double) i;
                    double max = (double) Math.max(options2.outHeight, options2.outWidth);
                    Double.isNaN(d);
                    Double.isNaN(max);
                    i2 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(d / max) / Math.log(0.5d))));
                }
                options = new BitmapFactory.Options();
                options.inSampleSize = i2;
                fileInputStream2 = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream2 = null;
                m8009a((Closeable) fileInputStream, (C1941j) null);
                m8009a((Closeable) fileInputStream2, (C1941j) null);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = null;
                m8009a((Closeable) fileInputStream, (C1941j) null);
                m8009a((Closeable) fileInputStream2, (C1941j) null);
                throw th;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, (Rect) null, options);
                fileInputStream2.close();
                m8009a((Closeable) fileInputStream, (C1941j) null);
                m8009a((Closeable) fileInputStream2, (C1941j) null);
                return decodeStream;
            } catch (Exception unused2) {
                m8009a((Closeable) fileInputStream, (C1941j) null);
                m8009a((Closeable) fileInputStream2, (C1941j) null);
                return null;
            } catch (Throwable th2) {
                th = th2;
                m8009a((Closeable) fileInputStream, (C1941j) null);
                m8009a((Closeable) fileInputStream2, (C1941j) null);
                throw th;
            }
        } catch (Exception unused3) {
            fileInputStream2 = null;
            fileInputStream = null;
            m8009a((Closeable) fileInputStream, (C1941j) null);
            m8009a((Closeable) fileInputStream2, (C1941j) null);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            fileInputStream = null;
            m8009a((Closeable) fileInputStream, (C1941j) null);
            m8009a((Closeable) fileInputStream2, (C1941j) null);
            throw th;
        }
    }

    /* renamed from: a */
    public static View m7991a(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        return findViewById != null ? findViewById : rootView;
    }

    /* renamed from: a */
    public static C1821d m7992a(JSONObject jSONObject, C1941j jVar) {
        return C1821d.m6858a(AppLovinAdSize.fromString(C1993i.m7896b(jSONObject, "ad_size", (String) null, jVar)), AppLovinAdType.fromString(C1993i.m7896b(jSONObject, "ad_type", (String) null, jVar)), C1993i.m7896b(jSONObject, "zone_id", (String) null, jVar), jVar);
    }

    /* renamed from: a */
    public static C1941j m7993a(AppLovinSdk appLovinSdk) {
        try {
            Field declaredField = appLovinSdk.getClass().getDeclaredField("mSdkImpl");
            declaredField.setAccessible(true);
            return (C1941j) declaredField.get(appLovinSdk);
        } catch (Throwable th) {
            throw new IllegalStateException("Internal error - unable to retrieve SDK implementation: " + th);
        }
    }

    /* renamed from: a */
    public static AppLovinAd m7994a(AppLovinAd appLovinAd, C1941j jVar) {
        if (!(appLovinAd instanceof C1833h)) {
            return appLovinAd;
        }
        C1833h hVar = (C1833h) appLovinAd;
        AppLovinAd dequeueAd = jVar.mo8594o().dequeueAd(hVar.getAdZone());
        C1977q v = jVar.mo8602v();
        v.mo8742b("Utils", "Dequeued ad for dummy ad: " + dequeueAd);
        if (dequeueAd == null) {
            return hVar.mo8289a();
        }
        hVar.mo8290a(dequeueAd);
        ((AppLovinAdBase) dequeueAd).setDummyAd(hVar);
        return dequeueAd;
    }

    /* renamed from: a */
    public static Object m7995a(Object obj, C1941j jVar) {
        int i;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            HashMap hashMap = new HashMap(map.size());
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                hashMap.put(key instanceof String ? (String) key : String.valueOf(key), m7995a(entry.getValue(), jVar));
            }
            return hashMap;
        } else if (obj instanceof List) {
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (Object a : list) {
                arrayList.add(m7995a(a, jVar));
            }
            return arrayList;
        } else if (obj instanceof Date) {
            return String.valueOf(((Date) obj).getTime());
        } else {
            String valueOf = String.valueOf(obj);
            if (obj instanceof String) {
                i = ((Integer) jVar.mo8549a(C1841c.f5823aW)).intValue();
                if (i <= 0 || valueOf.length() <= i) {
                    return valueOf;
                }
            } else if (!(obj instanceof Uri) || (i = ((Integer) jVar.mo8549a(C1841c.f5824aX)).intValue()) <= 0 || valueOf.length() <= i) {
                return valueOf;
            }
            return valueOf.substring(0, i);
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.applovin.impl.sdk.b.e, com.applovin.impl.sdk.b.e<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m7996a(com.applovin.impl.sdk.p050b.C1843e<java.lang.String> r1, com.applovin.impl.sdk.C1941j r2) {
        /*
            java.lang.String r0 = ""
            java.lang.Object r1 = r2.mo8574b(r1, r0)
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C2029r.m7996a(com.applovin.impl.sdk.b.e, com.applovin.impl.sdk.j):java.lang.String");
    }

    /* renamed from: a */
    public static String m7997a(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    /* renamed from: a */
    public static String m7998a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(next.getKey());
            sb.append('=');
            sb.append(next.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m7999a(boolean z, String str) {
        return str.replace("{PLACEMENT}", "").replace("{SOC}", String.valueOf(z));
    }

    /* renamed from: a */
    public static Field m8000a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return m8000a(superclass, str);
        }
    }

    /* renamed from: a */
    public static List<C1846a> m8001a(String str, JSONObject jSONObject, String str2, String str3, C1941j jVar) {
        return m8002a(str, jSONObject, str2, (Map<String, String>) null, str3, jVar);
    }

    /* renamed from: a */
    public static List<C1846a> m8002a(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, C1941j jVar) {
        return m8003a(str, jSONObject, str2, map, str3, (Map<String, String>) null, jVar);
    }

    /* renamed from: a */
    public static List<C1846a> m8003a(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, Map<String, String> map2, C1941j jVar) {
        if (map == null) {
            map = new HashMap<>(1);
        }
        Map<String, String> map3 = map;
        map3.put("{CLCODE}", str2);
        return m8004a(str, jSONObject, map3, str3, map2, jVar);
    }

    /* renamed from: a */
    public static List<C1846a> m8004a(String str, JSONObject jSONObject, Map<String, String> map, String str2, Map<String, String> map2, C1941j jVar) {
        JSONObject b = C1993i.m7901b(jSONObject, str, new JSONObject(), jVar);
        ArrayList arrayList = new ArrayList(b.length() + 1);
        if (C2025o.m7963b(str2)) {
            arrayList.add(new C1846a(str2, (String) null, map2));
        }
        if (b.length() > 0) {
            Iterator<String> keys = b.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String optString = b.optString(next);
                        String a = C2025o.m7958a(next, map);
                        if (!TextUtils.isEmpty(optString)) {
                            optString = C2025o.m7958a(optString, map);
                        }
                        arrayList.add(new C1846a(a, optString, map2));
                    }
                } catch (Throwable th) {
                    jVar.mo8602v().mo8743b("Utils", "Failed to create and add postback url.", th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<Class> m8005a(List<String> list, C1941j jVar) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String next : list) {
            try {
                arrayList.add(Class.forName(next));
            } catch (ClassNotFoundException unused) {
                C1977q v = jVar.mo8602v();
                v.mo8746e("Utils", "Failed to create class for name: " + next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Uri> m8006a(boolean z, C1827g gVar, C1941j jVar, Context context) {
        if (gVar instanceof C1476a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Uri next : gVar.mo8286w()) {
            if (!jVar.mo8543V().mo8730b(next.getLastPathSegment(), context)) {
                C1977q v = jVar.mo8602v();
                v.mo8746e("Utils", "Cached HTML asset missing: " + next);
                arrayList.add(next);
            }
        }
        if (z) {
            Uri f = gVar.mo7157f();
            if (!jVar.mo8543V().mo8730b(f.getLastPathSegment(), context)) {
                C1977q v2 = jVar.mo8602v();
                v2.mo8746e("Utils", "Cached video missing: " + f);
                arrayList.add(f);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.applovin.impl.sdk.b.e, com.applovin.impl.sdk.b.e<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m8007a(com.applovin.impl.sdk.p050b.C1843e<java.lang.String> r4, int r5, com.applovin.impl.sdk.C1941j r6) {
        /*
            java.lang.Object r0 = r6.mo8550a(r4)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0020
            double r0 = java.lang.Math.random()
            double r2 = (double) r5
            java.lang.Double.isNaN(r2)
            double r0 = r0 * r2
            int r5 = (int) r0
            int r5 = r5 + 1
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r6.mo8556a(r4, r5)
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C2029r.m8007a(com.applovin.impl.sdk.b.e, int, com.applovin.impl.sdk.j):void");
    }

    /* renamed from: a */
    public static void m8008a(AppLovinAdLoadListener appLovinAdLoadListener, C1821d dVar, int i, C1941j jVar) {
        if (appLovinAdLoadListener != null) {
            try {
                if (appLovinAdLoadListener instanceof C1955n) {
                    ((C1955n) appLovinAdLoadListener).mo8326a(dVar, i);
                } else {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                }
            } catch (Throwable th) {
                jVar.mo8602v().mo8743b("Utils", "Unable process a failure to receive an ad", th);
            }
        }
    }

    /* renamed from: a */
    public static void m8009a(Closeable closeable, C1941j jVar) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                if (jVar != null) {
                    C1977q v = jVar.mo8602v();
                    v.mo8743b("Utils", "Unable to close stream: " + closeable, th);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m8010a(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, C1941j jVar) {
        if (jSONObject.has("no_fill_reason")) {
            Object b = C1993i.m7895b(jSONObject, "no_fill_reason", new Object(), jVar);
            C1977q.m7751i("AppLovinSdk", "\n**************************************************\nNO FILL received:\n..ID: \"" + str + "\"\n..FORMAT: \"" + maxAdFormat.getLabel() + "\"\n..SDK KEY: \"" + jVar.mo8599t() + "\"\n..PACKAGE NAME: \"" + jVar.mo8527E().getPackageName() + "\"\n..Reason: " + b + "\n**************************************************\n");
        }
    }

    /* renamed from: a */
    public static void m8011a(String str, String str2, Map<String, String> map) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    public static void m8012a(HttpURLConnection httpURLConnection, C1941j jVar) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                if (jVar != null) {
                    C1977q v = jVar.mo8602v();
                    v.mo8743b("Utils", "Unable to disconnect connection: " + httpURLConnection, th);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m8013a() {
        Context F = C1941j.m7443F();
        if (F != null) {
            return C1986c.m7820a(F).mo8771a("applovin.sdk.verbose_logging");
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m8014a(long j, long j2) {
        return (j & j2) != 0;
    }

    /* renamed from: a */
    public static boolean m8015a(Context context) {
        if (context == null) {
            context = C1941j.m7443F();
        }
        if (context != null) {
            return C1986c.m7820a(context).mo8772a("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m8016a(Context context, Uri uri, C1941j jVar) {
        boolean z;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
            }
            if (((Boolean) jVar.mo8549a(C1841c.f6035eZ)).booleanValue() && "market".equals(intent.getScheme())) {
                intent.setPackage("com.android.vending");
            }
            jVar.mo8546Y().mo8847b();
            context.startActivity(intent);
            z = true;
        } catch (Throwable th) {
            C1977q v = jVar.mo8602v();
            v.mo8743b("Utils", "Unable to open \"" + uri + "\".", th);
            z = false;
        }
        if (!z) {
            jVar.mo8546Y().mo8848c();
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m8017a(View view, Activity activity) {
        View rootView;
        if (!(activity == null || view == null)) {
            Window window = activity.getWindow();
            if (window != null) {
                rootView = window.getDecorView();
            } else {
                View findViewById = activity.findViewById(16908290);
                if (findViewById != null) {
                    rootView = findViewById.getRootView();
                }
            }
            return m8018a(view, rootView);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m8018a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (m8018a(view, viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m8019a(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER;
    }

    /* renamed from: a */
    public static boolean m8020a(Object obj, List<String> list, C1941j jVar) {
        if (list == null) {
            return false;
        }
        for (Class isInstance : m8005a(list, jVar)) {
            if (isInstance.isInstance(obj)) {
                if (obj instanceof Map) {
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        if (!(entry.getKey() instanceof String)) {
                            jVar.mo8602v().mo8742b("Utils", "Invalid key type used. Map keys should be of type String.");
                            return false;
                        } else if (!m8020a(entry.getValue(), list, jVar)) {
                            return false;
                        }
                    }
                    return true;
                } else if (!(obj instanceof List)) {
                    return true;
                } else {
                    for (Object a : (List) obj) {
                        if (!m8020a(a, list, jVar)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        C1977q v = jVar.mo8602v();
        v.mo8742b("Utils", "Object '" + obj + "' does not match any of the required types '" + list + "'.");
        return false;
    }

    /* renamed from: a */
    public static boolean m8021a(String str, List<String> list) {
        for (String startsWith : list) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m8022b(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    /* renamed from: b */
    public static long m8023b(float f) {
        return m8030c(m7985a(f));
    }

    /* renamed from: b */
    public static String m8024b(Class cls, String str) {
        try {
            Field a = m8000a(cls, str);
            a.setAccessible(true);
            return (String) a.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m8025b(String str) {
        return m7999a(false, str);
    }

    /* renamed from: b */
    public static Map<String, String> m8026b(Map<String, String> map) {
        HashMap hashMap = new HashMap(map);
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (str2 != null) {
                hashMap.put(str, C2025o.m7966e(str2));
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static void m8027b(AppLovinAd appLovinAd, C1941j jVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            String t = jVar.mo8599t();
            String t2 = ((AppLovinAdBase) appLovinAd).getSdk().mo8599t();
            if (!t.equals(t2)) {
                C1977q.m7751i("AppLovinAd", "Ad was loaded from sdk with key: " + t2 + ", but is being rendered from sdk with key: " + t);
                jVar.mo8534M().mo8387a(C1859g.f6197l);
            }
        }
    }

    /* renamed from: b */
    public static boolean m8028b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: b */
    public static boolean m8029b(C1941j jVar) {
        return (jVar.mo8527E().getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: c */
    private static long m8030c(float f) {
        return (long) Math.round(f);
    }

    /* renamed from: c */
    public static MaxAdFormat m8031c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("banner")) {
            return MaxAdFormat.BANNER;
        }
        if (str.equalsIgnoreCase("mrec")) {
            return MaxAdFormat.MREC;
        }
        if (str.equalsIgnoreCase("leaderboard") || str.equalsIgnoreCase("leader")) {
            return MaxAdFormat.LEADER;
        }
        if (str.equalsIgnoreCase(AdMostInterstitial.ZONE_TYPE_INTERSTITIAL) || str.equalsIgnoreCase("inter")) {
            return MaxAdFormat.INTERSTITIAL;
        }
        if (str.equalsIgnoreCase(AdMostInterstitial.ZONE_TYPE_REWARDED) || str.equalsIgnoreCase("reward")) {
            return MaxAdFormat.REWARDED;
        }
        throw new IllegalArgumentException("Unknown format: " + str);
    }

    /* renamed from: c */
    public static String m8032c(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (!queryIntentActivities.isEmpty()) {
            return queryIntentActivities.get(0).activityInfo.name;
        }
        return null;
    }

    /* renamed from: c */
    public static boolean m8033c() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th) {
            C1977q.m7747c("Utils", "Exception thrown while getting memory state.", th);
        }
        int i = runningAppProcessInfo.importance;
        return i == 100 || i == 200;
    }

    /* renamed from: d */
    public static int m8034d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    /* renamed from: d */
    public static String m8035d(String str) {
        Uri parse = Uri.parse(str);
        return new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).build().toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000a A[Catch:{ all -> 0x002e }] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m8036d() {
        /*
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ all -> 0x002e }
        L_0x0004:
            boolean r1 = r0.hasMoreElements()     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.nextElement()     // Catch:{ all -> 0x002e }
            java.net.NetworkInterface r1 = (java.net.NetworkInterface) r1     // Catch:{ all -> 0x002e }
            java.lang.String r1 = r1.getDisplayName()     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "tun"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = "ppp"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = "ipsec"
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0004
        L_0x002c:
            r0 = 1
            return r0
        L_0x002e:
            r0 = move-exception
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "Unable to check Network Interfaces"
            com.applovin.impl.sdk.C1977q.m7747c(r1, r2, r0)
        L_0x0036:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C2029r.m8036d():boolean");
    }

    /* renamed from: e */
    public static String m8037e() {
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt((Object) null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th) {
            C1977q.m7747c("Utils", "Unable to get Android SDK codename", th);
            return "";
        }
    }

    /* renamed from: e */
    public static boolean m8038e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static long m8039f(String str) {
        if (!C2025o.m7963b(str)) {
            return Long.MAX_VALUE;
        }
        try {
            return (long) Color.parseColor(str);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    /* renamed from: f */
    public static String m8040f() {
        try {
            return (String) Class.forName("com.safedk.android.SafeDK").getMethod("getVersion", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }
}
