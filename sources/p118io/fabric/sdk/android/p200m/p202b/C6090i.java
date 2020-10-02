package p118io.fabric.sdk.android.p200m.p202b;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyConstants;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;

/* renamed from: io.fabric.sdk.android.m.b.i */
/* compiled from: CommonUtils */
public class C6090i {

    /* renamed from: a */
    private static Boolean f16017a;

    /* renamed from: b */
    private static final char[] f16018b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c */
    private static long f16019c = -1;

    /* renamed from: d */
    public static final Comparator<File> f16020d = new C6091a();

    /* renamed from: io.fabric.sdk.android.m.b.i$a */
    /* compiled from: CommonUtils */
    static class C6091a implements Comparator<File> {
        C6091a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* renamed from: io.fabric.sdk.android.m.b.i$b */
    /* compiled from: CommonUtils */
    enum C6092b {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        

        /* renamed from: k */
        private static final Map<String, C6092b> f16031k = null;

        static {
            X86_32 = new C6092b("X86_32", 0);
            X86_64 = new C6092b("X86_64", 1);
            ARM_UNKNOWN = new C6092b("ARM_UNKNOWN", 2);
            PPC = new C6092b("PPC", 3);
            PPC64 = new C6092b("PPC64", 4);
            ARMV6 = new C6092b("ARMV6", 5);
            ARMV7 = new C6092b("ARMV7", 6);
            UNKNOWN = new C6092b("UNKNOWN", 7);
            ARMV7S = new C6092b("ARMV7S", 8);
            ARM64 = new C6092b("ARM64", 9);
            HashMap hashMap = new HashMap(4);
            f16031k = hashMap;
            hashMap.put("armeabi-v7a", ARMV7);
            f16031k.put("armeabi", ARMV6);
            f16031k.put("arm64-v8a", ARM64);
            f16031k.put("x86", X86_32);
        }

        /* renamed from: a */
        static C6092b m19762a() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                C6059c.m19630f().mo34093d("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            C6092b bVar = f16031k.get(str.toLowerCase(Locale.US));
            return bVar == null ? UNKNOWN : bVar;
        }
    }

    /* renamed from: a */
    public static String m19722a(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m19723a(java.io.File r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "Failed to close system file reader."
            boolean r1 = r7.exists()
            r2 = 0
            if (r1 == 0) goto L_0x0061
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r3.<init>(r7)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
        L_0x0015:
            java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x003a }
            if (r3 == 0) goto L_0x0036
            java.lang.String r4 = "\\s*:\\s*"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch:{ Exception -> 0x003a }
            r5 = 2
            java.lang.String[] r3 = r4.split(r3, r5)     // Catch:{ Exception -> 0x003a }
            int r4 = r3.length     // Catch:{ Exception -> 0x003a }
            r5 = 1
            if (r4 <= r5) goto L_0x0015
            r4 = 0
            r4 = r3[r4]     // Catch:{ Exception -> 0x003a }
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x003a }
            if (r4 == 0) goto L_0x0015
            r7 = r3[r5]     // Catch:{ Exception -> 0x003a }
            r2 = r7
        L_0x0036:
            m19733a((java.io.Closeable) r1, (java.lang.String) r0)
            goto L_0x0061
        L_0x003a:
            r8 = move-exception
            goto L_0x0040
        L_0x003c:
            r7 = move-exception
            goto L_0x005d
        L_0x003e:
            r8 = move-exception
            r1 = r2
        L_0x0040:
            io.fabric.sdk.android.k r3 = p118io.fabric.sdk.android.C6059c.m19630f()     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "Fabric"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            r5.<init>()     // Catch:{ all -> 0x005b }
            java.lang.String r6 = "Error parsing "
            r5.append(r6)     // Catch:{ all -> 0x005b }
            r5.append(r7)     // Catch:{ all -> 0x005b }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x005b }
            r3.mo34090b(r4, r7, r8)     // Catch:{ all -> 0x005b }
            goto L_0x0036
        L_0x005b:
            r7 = move-exception
            r2 = r1
        L_0x005d:
            m19733a((java.io.Closeable) r2, (java.lang.String) r0)
            throw r7
        L_0x0061:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.p200m.p202b.C6090i.m19723a(java.io.File, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static synchronized long m19738b() {
        long j;
        synchronized (C6090i.class) {
            if (f16019c == -1) {
                long j2 = 0;
                String a = m19723a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a)) {
                    String upperCase = a.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            j2 = m19720a(upperCase, "KB", (int) OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
                        } else if (upperCase.endsWith("MB")) {
                            j2 = m19720a(upperCase, "MB", 1048576);
                        } else if (upperCase.endsWith("GB")) {
                            j2 = m19720a(upperCase, "GB", 1073741824);
                        } else {
                            C6072k f = C6059c.m19630f();
                            f.mo34093d("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase);
                        }
                    } catch (NumberFormatException e) {
                        C6072k f2 = C6059c.m19630f();
                        f2.mo34090b("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase, e);
                    }
                }
                f16019c = j2;
            }
            j = f16019c;
        }
        return j;
    }

    /* renamed from: c */
    public static String m19745c(String str) {
        return m19726a(str, "SHA-1");
    }

    /* renamed from: d */
    public static String m19749d(String str) {
        return m19726a(str, "SHA-256");
    }

    /* renamed from: e */
    public static Float m19750e(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(((float) registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
    }

    /* renamed from: f */
    public static int m19751f(Context context) {
        int i = m19757l(context) ? 1 : 0;
        if (m19758m(context)) {
            i |= 2;
        }
        return m19747c() ? i | 4 : i;
    }

    /* renamed from: g */
    public static boolean m19752g(Context context) {
        if (!m19757l(context) && ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public static String m19753h(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i <= 0) {
            return context.getPackageName();
        }
        try {
            return context.getResources().getResourcePackageName(i);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    /* renamed from: i */
    public static SharedPreferences m19754i(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* renamed from: j */
    public static boolean m19755j(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: k */
    public static boolean m19756k(Context context) {
        if (f16017a == null) {
            f16017a = Boolean.valueOf(m19737a(context, "com.crashlytics.Trace", false));
        }
        return f16017a.booleanValue();
    }

    /* renamed from: l */
    public static boolean m19757l(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID) == null;
    }

    /* renamed from: m */
    public static boolean m19758m(Context context) {
        boolean l = m19757l(context);
        String str = Build.TAGS;
        if ((!l && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (l || !file.exists()) {
            return false;
        }
        return true;
    }

    /* renamed from: n */
    public static String m19759n(Context context) {
        int a = m19716a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = m19716a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        C6072k f = C6059c.m19630f();
        f.mo34093d("Fabric", "Build ID is: " + string);
        return string;
    }

    /* renamed from: o */
    public static String m19760o(Context context) {
        int a = m19716a(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        C6072k f = C6059c.m19630f();
        f.mo34093d("Fabric", "Unity Editor version is: " + string);
        return string;
    }

    /* renamed from: c */
    public static void m19746c(Context context, String str) {
        if (m19756k(context)) {
            C6059c.m19630f().mo34093d("Fabric", str);
        }
    }

    /* renamed from: d */
    public static int m19748d(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    /* renamed from: c */
    public static boolean m19747c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    /* renamed from: c */
    public static String m19744c(Context context) {
        InputStream inputStream;
        String str = null;
        try {
            inputStream = context.getResources().openRawResource(m19748d(context));
            try {
                String a = m19724a(inputStream);
                if (!m19743b(a)) {
                    str = a;
                }
                m19733a((Closeable) inputStream, "Failed to close icon input stream.");
                return str;
            } catch (Exception e) {
                e = e;
                try {
                    C6059c.m19630f().mo34086a("Fabric", "Could not calculate hash for app icon:" + e.getMessage());
                    m19733a((Closeable) inputStream, "Failed to close icon input stream.");
                    return null;
                } catch (Throwable th) {
                    th = th;
                    m19733a((Closeable) inputStream, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
            C6059c.m19630f().mo34086a("Fabric", "Could not calculate hash for app icon:" + e.getMessage());
            m19733a((Closeable) inputStream, "Failed to close icon input stream.");
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            m19733a((Closeable) inputStream, "Failed to close icon input stream.");
            throw th;
        }
    }

    /* renamed from: a */
    public static int m19715a() {
        return C6092b.m19762a().ordinal();
    }

    /* renamed from: a */
    static long m19720a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    /* renamed from: a */
    public static ActivityManager.RunningAppProcessInfo m19721a(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.processName.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m19741b(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    /* renamed from: b */
    public static String m19740b(Context context, String str) {
        int a = m19716a(context, str, "string");
        return a > 0 ? context.getString(a) : "";
    }

    /* renamed from: a */
    public static String m19724a(InputStream inputStream) {
        return m19725a(inputStream, "SHA-1");
    }

    /* renamed from: a */
    private static String m19726a(String str, String str2) {
        return m19728a(str.getBytes(), str2);
    }

    /* renamed from: b */
    public static boolean m19743b(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: a */
    private static String m19725a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] bArr = new byte[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return m19727a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Exception e) {
            C6059c.m19630f().mo34090b("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    /* renamed from: b */
    public static String m19739b(int i) {
        if (i >= 0) {
            return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i)}).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public static boolean m19742b(Context context) {
        if (!m19736a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static String m19728a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return m19727a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            C6072k f = C6059c.m19630f();
            f.mo34090b("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m19729a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String append : arrayList) {
            sb.append(append);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return m19745c(sb2);
        }
        return null;
    }

    /* renamed from: a */
    public static long m19718a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: a */
    public static long m19719a(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    /* renamed from: a */
    public static void m19731a(Context context, String str, Throwable th) {
        if (m19756k(context)) {
            C6059c.m19630f().mo34089b("Fabric", str);
        }
    }

    /* renamed from: a */
    public static void m19730a(Context context, int i, String str, String str2) {
        if (m19756k(context)) {
            C6059c.m19630f().mo34084a(i, "Fabric", str2);
        }
    }

    /* renamed from: a */
    public static boolean m19737a(Context context, String str, boolean z) {
        Resources resources;
        if (!(context == null || (resources = context.getResources()) == null)) {
            int a = m19716a(context, str, "bool");
            if (a > 0) {
                return resources.getBoolean(a);
            }
            int a2 = m19716a(context, str, "string");
            if (a2 > 0) {
                return Boolean.parseBoolean(context.getString(a2));
            }
        }
        return z;
    }

    /* renamed from: a */
    public static int m19716a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, m19753h(context));
    }

    /* renamed from: a */
    public static int m19717a(Context context, boolean z) {
        Float e = m19750e(context);
        if (!z || e == null) {
            return 1;
        }
        if (((double) e.floatValue()) >= 99.0d) {
            return 3;
        }
        return ((double) e.floatValue()) < 99.0d ? 2 : 0;
    }

    /* renamed from: a */
    public static String m19727a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            char[] cArr2 = f16018b;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static void m19733a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C6059c.m19630f().mo34090b("Fabric", str, e);
            }
        }
    }

    /* renamed from: a */
    public static void m19734a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e) {
                C6059c.m19630f().mo34090b("Fabric", str, e);
            }
        }
    }

    /* renamed from: a */
    public static void m19735a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m19732a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m19736a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }
}
