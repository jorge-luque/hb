package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
import com.adcolony.sdk.C1439u;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.k0 */
class C1359k0 {

    /* renamed from: a */
    static final int f4257a = 128;

    /* renamed from: b */
    static ExecutorService f4258b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    static Handler f4259c;

    /* renamed from: com.adcolony.sdk.k0$a */
    static class C1360a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f4260a;

        /* renamed from: b */
        final /* synthetic */ String f4261b;

        /* renamed from: c */
        final /* synthetic */ int f4262c;

        C1360a(Context context, String str, int i) {
            this.f4260a = context;
            this.f4261b = str;
            this.f4262c = i;
        }

        public void run() {
            Toast.makeText(this.f4260a, this.f4261b, this.f4262c).show();
        }
    }

    C1359k0() {
    }

    /* renamed from: a */
    static int m5295a(Context context, String str) {
        return m5296a(m5315b(context), str);
    }

    /* renamed from: b */
    static SharedPreferences m5315b(Context context) {
        try {
            Class.forName("androidx.preference.PreferenceManager");
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (ClassNotFoundException unused) {
            return context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        }
    }

    /* renamed from: c */
    static boolean m5323c() {
        try {
            C1290h c = C1199a.m4880c();
            File file = new File(c.mo6555v().mo6509a() + "026ae9c9824b3e483fa6c71fa88f57ae27816141");
            File file2 = new File(c.mo6555v().mo6509a() + "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
            boolean a = c.mo6545k().mo6779a(file);
            boolean a2 = c.mo6545k().mo6779a(file2);
            if (!a || !a2) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            new C1439u.C1440a().mo6801a("Unable to delete controller or launch response.").mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: d */
    static String m5324d() {
        Application application;
        Context b = C1199a.m4878b();
        if (b == null) {
            return "";
        }
        if (b instanceof Application) {
            application = (Application) b;
        } else {
            application = ((Activity) b).getApplication();
        }
        PackageManager packageManager = application.getPackageManager();
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(b.getPackageName(), 0));
            if (applicationLabel == null) {
                return "";
            }
            return applicationLabel.toString();
        } catch (Exception unused) {
            new C1439u.C1440a().mo6801a("Failed to retrieve application label.").mo6803a(C1439u.f4517j);
            return "";
        }
    }

    /* renamed from: e */
    static boolean m5329e(String str) {
        Application application;
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        try {
            if (b instanceof Application) {
                application = (Application) b;
            } else {
                application = ((Activity) b).getApplication();
            }
            application.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: f */
    static int m5330f() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return 0;
        }
        try {
            return b.getPackageManager().getPackageInfo(b.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            new C1439u.C1440a().mo6801a("Failed to retrieve package info.").mo6803a(C1439u.f4517j);
            return 0;
        }
    }

    /* renamed from: g */
    static boolean m5333g(String str) {
        if (str != null && str.length() <= 128) {
            return true;
        }
        new C1439u.C1440a().mo6801a("String must be non-null and the max length is 128 characters.").mo6803a(C1439u.f4514g);
        return false;
    }

    /* renamed from: h */
    static int m5334h(String str) {
        try {
            return (int) Long.parseLong(str, 16);
        } catch (NumberFormatException unused) {
            new C1439u.C1440a().mo6801a("Unable to parse '").mo6801a(str).mo6801a("' as a color.").mo6803a(C1439u.f4515h);
            return -16777216;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", java.util.Locale.US).parse(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US).parse(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Date m5336i(java.lang.String r5) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "yyyy-MM-dd'T'HH:mmZ"
            r0.<init>(r2, r1)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r3 = "yyyy-MM-dd'T'HH:mm:ssZ"
            r1.<init>(r3, r2)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r4 = "yyyy-MM-dd"
            r2.<init>(r4, r3)
            java.util.Date r5 = r0.parse(r5)     // Catch:{ Exception -> 0x0020 }
            return r5
        L_0x0020:
            java.util.Date r5 = r1.parse(r5)     // Catch:{ Exception -> 0x0025 }
            return r5
        L_0x0025:
            java.util.Date r5 = r2.parse(r5)     // Catch:{ Exception -> 0x002a }
            return r5
        L_0x002a:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1359k0.m5336i(java.lang.String):java.util.Date");
    }

    /* renamed from: com.adcolony.sdk.k0$b */
    static class C1361b {

        /* renamed from: a */
        double f4263a;

        /* renamed from: b */
        double f4264b = ((double) System.currentTimeMillis());

        C1361b(double d) {
            mo6672a(d);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6672a(double d) {
            this.f4263a = d;
            double currentTimeMillis = (double) System.currentTimeMillis();
            Double.isNaN(currentTimeMillis);
            this.f4264b = (currentTimeMillis / 1000.0d) + this.f4263a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public double mo6674b() {
            double currentTimeMillis = (double) System.currentTimeMillis();
            Double.isNaN(currentTimeMillis);
            double d = this.f4264b - (currentTimeMillis / 1000.0d);
            if (d <= 0.0d) {
                return 0.0d;
            }
            return d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo6675c() {
            mo6672a(this.f4263a);
        }

        public String toString() {
            return C1359k0.m5302a(mo6674b(), 2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6673a() {
            return mo6674b() == 0.0d;
        }
    }

    /* renamed from: a */
    static int m5296a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            C1439u.C1440a aVar = new C1439u.C1440a();
            aVar.mo6801a("Key " + str + " in SharedPreferences ").mo6801a("does not have an int value.").mo6803a(C1439u.f4515h);
            return -1;
        }
    }

    /* renamed from: b */
    static String m5316b(Context context, String str) {
        return m5317b(m5315b(context), str);
    }

    /* renamed from: b */
    static String m5317b(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, (String) null);
        } catch (ClassCastException unused) {
            C1439u.C1440a aVar = new C1439u.C1440a();
            aVar.mo6801a("Key " + str + " in SharedPreferences ").mo6801a("does not have a String value.").mo6803a(C1439u.f4515h);
            return null;
        }
    }

    /* renamed from: g */
    static String m5332g() {
        Context b = C1199a.m4878b();
        return (!(b instanceof Activity) || b.getResources().getConfiguration().orientation != 1) ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT;
    }

    /* renamed from: h */
    static boolean m5335h() {
        Context b = C1199a.m4878b();
        return b != null && Build.VERSION.SDK_INT >= 24 && (b instanceof Activity) && ((Activity) b).isInMultiWindowMode();
    }

    /* renamed from: e */
    static String m5328e() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return "1.0";
        }
        try {
            return b.getPackageManager().getPackageInfo(b.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            new C1439u.C1440a().mo6801a("Failed to retrieve package info.").mo6803a(C1439u.f4517j);
            return "1.0";
        }
    }

    /* renamed from: a */
    static JSONObject m5305a(JSONObject jSONObject) {
        jSONObject.remove(NativeProtocol.RESULT_ARGS_PERMISSIONS);
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m5331f(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 0
            r2 = -1
            r3 = 1
            r4 = 729267099(0x2b77bb9b, float:8.8012383E-13)
            if (r0 == r4) goto L_0x001c
            r4 = 1430647483(0x5545f2bb, float:1.36028944E13)
            if (r0 == r4) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r0 = "landscape"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0026
            r5 = 1
            goto L_0x0027
        L_0x001c:
            java.lang.String r0 = "portrait"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0026
            r5 = 0
            goto L_0x0027
        L_0x0026:
            r5 = -1
        L_0x0027:
            if (r5 == 0) goto L_0x002e
            if (r5 == r3) goto L_0x002d
            r1 = -1
            goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1359k0.m5331f(java.lang.String):int");
    }

    /* renamed from: a */
    static int m5299a(String str) {
        CRC32 crc32 = new CRC32();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            crc32.update(str.charAt(i));
        }
        return (int) crc32.getValue();
    }

    /* renamed from: c */
    static String m5321c(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    /* renamed from: b */
    static String m5318b(String str) {
        try {
            return C1407n0.m5507a(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static void m5322c(String str) {
        Context b = C1199a.m4878b();
        if (b != null) {
            try {
                InputStream open = b.getAssets().open(str);
                FileOutputStream fileOutputStream = new FileOutputStream(C1199a.m4880c().mo6555v().mo6511c() + str);
                byte[] bArr = new byte[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        open.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (Exception e) {
                new C1439u.C1440a().mo6801a("Failed copy hardcoded ad unit file named: ").mo6801a(str).mo6801a(" with error: ").mo6801a(e.getMessage()).mo6803a(C1439u.f4517j);
            }
        }
    }

    /* renamed from: b */
    static double m5313b() {
        double currentTimeMillis = (double) System.currentTimeMillis();
        Double.isNaN(currentTimeMillis);
        return currentTimeMillis / 1000.0d;
    }

    /* renamed from: d */
    public static void m5326d(String str) {
        Context b = C1199a.m4878b();
        if (b != null) {
            try {
                String[] list = b.getAssets().list(str);
                if (list.length == 0) {
                    m5322c(str);
                    return;
                }
                File file = new File(C1199a.m4880c().mo6555v().mo6511c() + str);
                if (!file.exists()) {
                    file.mkdir();
                }
                for (int i = 0; i < list.length; i++) {
                    m5326d(str + "/" + list[i]);
                }
            } catch (IOException e) {
                new C1439u.C1440a().mo6801a("Failed copy hardcoded ad unit with error: ").mo6801a(e.getMessage()).mo6803a(C1439u.f4517j);
            }
        }
    }

    /* renamed from: a */
    static String m5301a() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: b */
    static boolean m5320b(AudioManager audioManager) {
        if (audioManager == null) {
            new C1439u.C1440a().mo6801a("isAudioEnabled() called with a null AudioManager").mo6803a(C1439u.f4517j);
            return false;
        }
        try {
            if (audioManager.getStreamVolume(3) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            new C1439u.C1440a().mo6801a("Exception occurred when accessing AudioManager.getStreamVolume: ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: e */
    static int m5327e(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: a */
    static JSONArray m5304a(int i) {
        JSONArray a = C1437s.m5579a();
        for (int i2 = 0; i2 < i; i2++) {
            C1437s.m5601b(a, m5301a());
        }
        return a;
    }

    /* renamed from: a */
    static boolean m5312a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        Arrays.sort(strArr);
        Arrays.sort(strArr2);
        return Arrays.equals(strArr, strArr2);
    }

    /* renamed from: a */
    static boolean m5309a(Runnable runnable) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return false;
        }
        if (f4259c == null) {
            f4259c = new Handler(mainLooper);
        }
        if (mainLooper == Looper.myLooper()) {
            runnable.run();
            return true;
        }
        f4259c.post(runnable);
        return true;
    }

    /* renamed from: b */
    static String m5319b(JSONArray jSONArray) throws JSONException {
        String str = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                str = str + ",";
            }
            str = str + jSONArray.getInt(i);
        }
        return str;
    }

    /* renamed from: b */
    static int m5314b(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[1]) / C1199a.m4880c().mo6542h().mo6630n());
    }

    /* renamed from: a */
    static double m5294a(AudioManager audioManager) {
        if (audioManager == null) {
            new C1439u.C1440a().mo6801a("getAudioVolume() called with a null AudioManager").mo6803a(C1439u.f4517j);
            return 0.0d;
        }
        try {
            double streamVolume = (double) audioManager.getStreamVolume(3);
            double streamMaxVolume = (double) audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume == 0.0d) {
                return 0.0d;
            }
            Double.isNaN(streamVolume);
            Double.isNaN(streamMaxVolume);
            return streamVolume / streamMaxVolume;
        } catch (Exception e) {
            new C1439u.C1440a().mo6801a("Exception occurred when accessing AudioManager: ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
            return 0.0d;
        }
    }

    /* renamed from: d */
    static JSONArray m5325d(Context context) {
        JSONArray a = C1437s.m5579a();
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE);
                if (packageInfo.requestedPermissions != null) {
                    a = C1437s.m5579a();
                    for (String put : packageInfo.requestedPermissions) {
                        a.put(put);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return a;
    }

    /* renamed from: a */
    static AudioManager m5300a(Context context) {
        if (context != null) {
            return (AudioManager) context.getSystemService("audio");
        }
        new C1439u.C1440a().mo6801a("getAudioManager called with a null Context").mo6803a(C1439u.f4517j);
        return null;
    }

    /* renamed from: a */
    static String m5302a(double d, int i) {
        StringBuilder sb = new StringBuilder();
        m5306a(d, i, sb);
        return sb.toString();
    }

    /* renamed from: a */
    static void m5306a(double d, int i, StringBuilder sb) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            sb.append(d);
            return;
        }
        if (d < 0.0d) {
            d = -d;
            sb.append('-');
        }
        if (i == 0) {
            sb.append(Math.round(d));
            return;
        }
        long pow = (long) Math.pow(10.0d, (double) i);
        double d2 = (double) pow;
        Double.isNaN(d2);
        long round = Math.round(d * d2);
        sb.append(round / pow);
        sb.append('.');
        long j = round % pow;
        if (j == 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append('0');
            }
            return;
        }
        for (long j2 = j * 10; j2 < pow; j2 *= 10) {
            sb.append('0');
        }
        sb.append(j);
    }

    /* renamed from: a */
    static boolean m5311a(String str, File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to process file for MD5", e);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                            new C1439u.C1440a().mo6801a("Exception on closing MD5 input stream").mo6803a(C1439u.f4517j);
                        }
                        throw th;
                    }
                }
                boolean equals = str.equals(String.format("%40s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0'));
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    new C1439u.C1440a().mo6801a("Exception on closing MD5 input stream").mo6803a(C1439u.f4517j);
                }
                return equals;
            } catch (FileNotFoundException unused3) {
                new C1439u.C1440a().mo6801a("Exception while getting FileInputStream").mo6803a(C1439u.f4517j);
                return false;
            }
        } catch (NoSuchAlgorithmException unused4) {
            new C1439u.C1440a().mo6801a("Exception while getting Digest").mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: a */
    static String m5303a(JSONArray jSONArray) throws JSONException {
        String str = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                str = str + ",";
            }
            switch (jSONArray.getInt(i)) {
                case 1:
                    str = str + "MO";
                    break;
                case 2:
                    str = str + "TU";
                    break;
                case 3:
                    str = str + "WE";
                    break;
                case 4:
                    str = str + "TH";
                    break;
                case 5:
                    str = str + "FR";
                    break;
                case 6:
                    str = str + "SA";
                    break;
                case 7:
                    str = str + "SU";
                    break;
            }
        }
        return str;
    }

    /* renamed from: a */
    static boolean m5308a(Intent intent, boolean z) {
        try {
            Context b = C1199a.m4878b();
            if (b == null) {
                return false;
            }
            AdColonyInterstitial d = C1199a.m4880c().mo6536d();
            if (d != null && d.mo6333g()) {
                d.mo6331e().mo6450f();
            }
            if (z) {
                b.startActivity(Intent.createChooser(intent, "Handle this via..."));
                return true;
            }
            b.startActivity(intent);
            return true;
        } catch (Exception e) {
            new C1439u.C1440a().mo6801a(e.toString()).mo6803a(C1439u.f4515h);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m5307a(Intent intent) {
        return m5308a(intent, false);
    }

    /* renamed from: a */
    static boolean m5310a(String str, int i) {
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        m5309a((Runnable) new C1360a(b, str, i));
        return true;
    }

    /* renamed from: a */
    static int m5298a(C1289g0 g0Var) {
        boolean z = false;
        try {
            Context b = C1199a.m4878b();
            if (b == null) {
                return 0;
            }
            int i = (int) (b.getPackageManager().getPackageInfo(b.getPackageName(), 0).lastUpdateTime / 1000);
            int i2 = 1;
            if (new File(g0Var.mo6509a() + "AppVersion").exists()) {
                if (C1437s.m5611f(C1437s.m5605c(g0Var.mo6509a() + "AppVersion"), "last_update") != i) {
                    z = true;
                } else {
                    i2 = 0;
                }
            } else {
                z = true;
                i2 = 2;
            }
            if (z) {
                try {
                    JSONObject b2 = C1437s.m5599b();
                    C1437s.m5602b(b2, "last_update", i);
                    C1437s.m5614i(b2, g0Var.mo6509a() + "AppVersion");
                } catch (Exception unused) {
                    return i2;
                }
            }
            return i2;
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* renamed from: a */
    static int m5297a(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[0]) / C1199a.m4880c().mo6542h().mo6630n());
    }
}
