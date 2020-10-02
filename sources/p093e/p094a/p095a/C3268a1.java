package p093e.p094a.p095a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.LocaleList;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.loopj.android.http.C4250c;
import com.tapjoy.TapjoyConstants;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/* renamed from: e.a.a.a1 */
/* compiled from: Util */
public class C3268a1 {

    /* renamed from: a */
    public static final DecimalFormat f9091a = m10864e();

    /* renamed from: b */
    public static final SimpleDateFormat f9092b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z", Locale.US);

    /* renamed from: e.a.a.a1$a */
    /* compiled from: Util */
    static class C3269a extends AsyncTask<Object, Void, Void> {
        C3269a() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Object... objArr) {
            objArr[0].run();
            return null;
        }
    }

    /* renamed from: a */
    protected static String m10827a() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: b */
    public static String m10854b(String str, String str2) {
        try {
            byte[] bytes = str.getBytes(C4250c.DEFAULT_CHARSET);
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(bytes, 0, bytes.length);
            return m10835a(instance.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static C3364y m10857c() {
        return C3309k.m11002d();
    }

    /* renamed from: d */
    public static String m10860d(String str) {
        return m10854b(str, "MD5");
    }

    /* renamed from: e */
    private static DecimalFormat m10864e() {
        return new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.US));
    }

    /* renamed from: f */
    public static String m10866f(String str) {
        return m10854b(str, "SHA-256");
    }

    /* renamed from: g */
    public static String m10867g(Context context) {
        return C3341r0.m11116b(context);
    }

    /* renamed from: h */
    public static Boolean m10868h(Context context) {
        return C3341r0.m11117c(context);
    }

    /* renamed from: a */
    public static void m10839a(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        new C3269a().execute(new Object[]{runnable});
    }

    /* renamed from: c */
    public static String m10858c(Context context) {
        return C3304h0.m10987a(context);
    }

    /* renamed from: d */
    public static String[] m10861d() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return null;
    }

    /* renamed from: f */
    public static int m10865f(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getNetworkType();
        } catch (Exception e) {
            m10857c().mo19021b("Couldn't read network type (%s)", e.getMessage());
            return -1;
        }
    }

    /* renamed from: c */
    public static int m10856c(String str) {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    /* renamed from: e */
    public static String m10863e(String str) {
        return m10854b(str, "SHA-1");
    }

    /* renamed from: d */
    public static String m10859d(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(0, 3);
            }
            C3309k.m11002d().mo19021b("Couldn't receive networkOperator string to read MCC", new Object[0]);
            return null;
        } catch (Exception unused) {
            C3309k.m11002d().mo19021b("Couldn't return mcc", new Object[0]);
            return null;
        }
    }

    /* renamed from: e */
    public static String m10862e(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(3);
            }
            C3309k.m11002d().mo19021b("Couldn't receive networkOperator string to read MNC", new Object[0]);
            return null;
        } catch (Exception unused) {
            C3309k.m11002d().mo19021b("Couldn't return mnc", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public static String m10829a(Context context) {
        return C3323p.m11054a(context);
    }

    /* renamed from: b */
    public static String m10852b() {
        if (Build.VERSION.SDK_INT < 21) {
            return Build.CPU_ABI;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a2 A[SYNTHETIC, Splitter:B:32:0x00a2] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T m10825a(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.Class<T> r10) {
        /*
            r0 = 0
            r1 = 2
            r2 = 0
            r3 = 1
            java.io.FileInputStream r7 = r7.openFileInput(r8)     // Catch:{ FileNotFoundException -> 0x008f, Exception -> 0x007d }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            java.io.ObjectInputStream r7 = new java.io.ObjectInputStream     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006b }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006b }
            java.lang.Object r8 = r7.readObject()     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            java.lang.Object r0 = r10.cast(r8)     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            e.a.a.y r8 = m10857c()     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            java.lang.String r10 = "Read %s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            r4[r2] = r9     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            r4[r3] = r0     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            r8.mo19023d(r10, r4)     // Catch:{ ClassNotFoundException -> 0x0056, ClassCastException -> 0x0041, Exception -> 0x002b }
            goto L_0x00a0
        L_0x002b:
            r8 = move-exception
            e.a.a.y r10 = m10857c()     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            java.lang.String r4 = "Failed to read %s object (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r5[r2] = r9     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r5[r3] = r8     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r10.mo19022c(r4, r5)     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            goto L_0x00a0
        L_0x0041:
            r8 = move-exception
            e.a.a.y r10 = m10857c()     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            java.lang.String r4 = "Failed to cast %s object (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r5[r2] = r9     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r5[r3] = r8     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r10.mo19022c(r4, r5)     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            goto L_0x00a0
        L_0x0056:
            r8 = move-exception
            e.a.a.y r10 = m10857c()     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            java.lang.String r4 = "Failed to find %s class (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r5[r2] = r9     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r5[r3] = r8     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            r10.mo19022c(r4, r5)     // Catch:{ FileNotFoundException -> 0x0079, Exception -> 0x0074 }
            goto L_0x00a0
        L_0x006b:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r0
            r0 = r6
            goto L_0x007f
        L_0x0071:
            r7 = r0
            r0 = r8
            goto L_0x0090
        L_0x0074:
            r8 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L_0x007f
        L_0x0079:
            r6 = r0
            r0 = r7
            r7 = r6
            goto L_0x0090
        L_0x007d:
            r8 = move-exception
            r7 = r0
        L_0x007f:
            e.a.a.y r10 = m10857c()
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r2] = r9
            r4[r3] = r8
            java.lang.String r8 = "Failed to open %s file for reading (%s)"
            r10.mo19022c(r8, r4)
            goto L_0x009d
        L_0x008f:
            r7 = r0
        L_0x0090:
            e.a.a.y r8 = m10857c()
            java.lang.Object[] r10 = new java.lang.Object[r3]
            r10[r2] = r9
            java.lang.String r4 = "%s file not found"
            r8.mo19023d(r4, r10)
        L_0x009d:
            r6 = r0
            r0 = r7
            r7 = r6
        L_0x00a0:
            if (r7 == 0) goto L_0x00b6
            r7.close()     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00b6
        L_0x00a6:
            r7 = move-exception
            e.a.a.y r8 = m10857c()
            java.lang.Object[] r10 = new java.lang.Object[r1]
            r10[r2] = r9
            r10[r3] = r7
            java.lang.String r7 = "Failed to close %s file for reading (%s)"
            r8.mo19022c(r7, r10)
        L_0x00b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3268a1.m10825a(android.content.Context, java.lang.String, java.lang.String, java.lang.Class):java.lang.Object");
    }

    /* renamed from: b */
    public static Boolean m10851b(ContentResolver contentResolver) {
        try {
            return Boolean.valueOf(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static int m10850b(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        } catch (Exception e) {
            m10857c().mo19021b("Couldn't read connectivity type (%s)", e.getMessage());
            return -1;
        }
    }

    /* renamed from: b */
    public static boolean m10855b(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().contains("Caused by:");
    }

    /* renamed from: b */
    public static String m10853b(String str) {
        String[] split;
        String a = m10832a(str);
        if (a == null || (split = a.split("\\d+", 2)) == null || split.length == 0) {
            return null;
        }
        return split[0];
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a A[SYNTHETIC, Splitter:B:18:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void m10838a(T r5, android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            java.io.FileOutputStream r6 = r6.openFileOutput(r7, r2)     // Catch:{ Exception -> 0x0037 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0035 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0035 }
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0032 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0032 }
            r6.writeObject(r5)     // Catch:{ NotSerializableException -> 0x0024 }
            e.a.a.y r7 = m10857c()     // Catch:{ NotSerializableException -> 0x0024 }
            java.lang.String r3 = "Wrote %s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ NotSerializableException -> 0x0024 }
            r4[r2] = r8     // Catch:{ NotSerializableException -> 0x0024 }
            r4[r1] = r5     // Catch:{ NotSerializableException -> 0x0024 }
            r7.mo19023d(r3, r4)     // Catch:{ NotSerializableException -> 0x0024 }
            goto L_0x0048
        L_0x0024:
            e.a.a.y r5 = m10857c()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r7 = "Failed to serialize %s"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0035 }
            r3[r2] = r8     // Catch:{ Exception -> 0x0035 }
            r5.mo19022c(r7, r3)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0048
        L_0x0032:
            r5 = move-exception
            r6 = r7
            goto L_0x0039
        L_0x0035:
            r5 = move-exception
            goto L_0x0039
        L_0x0037:
            r5 = move-exception
            r6 = 0
        L_0x0039:
            e.a.a.y r7 = m10857c()
            java.lang.Object[] r3 = new java.lang.Object[r0]
            r3[r2] = r8
            r3[r1] = r5
            java.lang.String r5 = "Failed to open %s for writing (%s)"
            r7.mo19022c(r5, r3)
        L_0x0048:
            if (r6 == 0) goto L_0x005e
            r6.close()     // Catch:{ Exception -> 0x004e }
            goto L_0x005e
        L_0x004e:
            r5 = move-exception
            e.a.a.y r6 = m10857c()
            java.lang.Object[] r7 = new java.lang.Object[r0]
            r7[r2] = r8
            r7[r1] = r5
            java.lang.String r5 = "Failed to close %s file for writing (%s)"
            r6.mo19022c(r5, r7)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3268a1.m10838a(java.lang.Object, android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public static boolean m10840a(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            m10857c().mo19023d("Unable to check permission '%s' with message (%s)", str, e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static String m10830a(ObjectInputStream.GetField getField, String str, String str2) {
        return (String) m10826a(getField, str, str2);
    }

    /* renamed from: a */
    public static <T> T m10826a(ObjectInputStream.GetField getField, String str, T t) {
        try {
            return getField.get(str, t);
        } catch (Exception e) {
            m10857c().mo19023d("Unable to read '%s' field in migration device with message (%s)", str, e.getMessage());
            return t;
        }
    }

    /* renamed from: a */
    public static boolean m10842a(ObjectInputStream.GetField getField, String str, boolean z) {
        try {
            return getField.get(str, z);
        } catch (Exception e) {
            m10857c().mo19023d("Unable to read '%s' field in migration device with message (%s)", str, e.getMessage());
            return z;
        }
    }

    /* renamed from: a */
    public static int m10818a(ObjectInputStream.GetField getField, String str, int i) {
        try {
            return getField.get(str, i);
        } catch (Exception e) {
            m10857c().mo19023d("Unable to read '%s' field in migration device with message (%s)", str, e.getMessage());
            return i;
        }
    }

    /* renamed from: a */
    public static long m10824a(ObjectInputStream.GetField getField, String str, long j) {
        try {
            return getField.get(str, j);
        } catch (Exception e) {
            m10857c().mo19023d("Unable to read '%s' field in migration device with message (%s)", str, e.getMessage());
            return j;
        }
    }

    /* renamed from: a */
    public static boolean m10847a(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return obj == null && obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static boolean m10848a(String str, String str2) {
        return m10847a((Object) str, (Object) str2);
    }

    /* renamed from: a */
    public static boolean m10844a(Enum enumR, Enum enumR2) {
        return m10847a((Object) enumR, (Object) enumR2);
    }

    /* renamed from: a */
    public static boolean m10846a(Long l, Long l2) {
        return m10847a((Object) l, (Object) l2);
    }

    /* renamed from: a */
    public static boolean m10845a(Integer num, Integer num2) {
        return m10847a((Object) num, (Object) num2);
    }

    /* renamed from: a */
    public static boolean m10843a(Boolean bool, Boolean bool2) {
        return m10847a((Object) bool, (Object) bool2);
    }

    /* renamed from: a */
    public static int m10819a(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    /* renamed from: a */
    public static int m10821a(Long l) {
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    /* renamed from: a */
    public static int m10820a(Enum enumR) {
        if (enumR == null) {
            return 0;
        }
        return enumR.hashCode();
    }

    /* renamed from: a */
    public static int m10822a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: a */
    public static String m10835a(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        return m10834a("%0" + (bArr.length << 1) + "x", bigInteger);
    }

    /* renamed from: a */
    public static String m10833a(String str, Throwable th) {
        if (th != null) {
            return m10834a("%s: %s", str, th);
        }
        return m10834a("%s", str);
    }

    /* renamed from: a */
    public static long m10823a(int i, C3342s sVar) {
        int i2 = sVar.f9348a;
        if (i < i2) {
            return 0;
        }
        long min = Math.min(((long) Math.pow(2.0d, (double) (i - i2))) * sVar.f9349b, sVar.f9350c);
        double a = m10817a(sVar.f9351d, sVar.f9352e);
        double d = (double) min;
        Double.isNaN(d);
        return (long) (d * a);
    }

    /* renamed from: a */
    private static double m10817a(double d, double d2) {
        return (new Random().nextDouble() * (d2 - d)) + d;
    }

    /* renamed from: a */
    public static boolean m10849a(String str, String str2, String str3) {
        if (str == null) {
            m10857c().mo19022c("%s parameter %s is missing", str3, str2);
            return false;
        } else if (!str.equals("")) {
            return true;
        } else {
            m10857c().mo19022c("%s parameter %s is empty", str3, str2);
            return false;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m10837a(Map<String, String> map, Map<String, String> map2, String str) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        C3364y c = m10857c();
        for (Map.Entry next : map2.entrySet()) {
            String str2 = (String) hashMap.put(next.getKey(), next.getValue());
            if (str2 != null) {
                c.mo19021b("Key %s with value %s from %s parameter was replaced by value %s", next.getKey(), str2, str, next.getValue());
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Locale m10836a(Configuration configuration) {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24 && (locales = configuration.getLocales()) != null && !locales.isEmpty()) {
            return locales.get(0);
        }
        if (Build.VERSION.SDK_INT < 24) {
            return configuration.locale;
        }
        return null;
    }

    /* renamed from: a */
    public static String m10828a(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m10834a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static String m10831a(Exception exc) {
        if (!m10855b(exc)) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int indexOf = stringWriter2.indexOf("Caused by:");
        return stringWriter2.substring(indexOf, stringWriter2.indexOf("\n", indexOf));
    }

    /* renamed from: a */
    private static String m10832a(String str) {
        String[] split;
        if (str != null && str.contains("@") && (split = str.split("@")) != null && split.length == 2) {
            return split[0];
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m10841a(Uri uri) {
        String uri2;
        if (uri == null || (uri2 = uri.toString()) == null || uri2.length() == 0 || uri2.matches("^(fb|vk)[0-9]{5,}[^:]*://authorize.*access_token=.*")) {
            return true;
        }
        return false;
    }
}
