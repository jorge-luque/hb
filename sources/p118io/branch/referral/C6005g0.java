package p118io.branch.referral;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tapjoy.TapjoyConstants;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: io.branch.referral.g0 */
/* compiled from: SystemObserver */
class C6005g0 {

    /* renamed from: d */
    static String f15367d;

    /* renamed from: a */
    int f15368a = 0;

    /* renamed from: b */
    private Context f15369b;

    /* renamed from: c */
    private boolean f15370c;

    /* renamed from: io.branch.referral.g0$a */
    /* compiled from: SystemObserver */
    interface C3570a {
        /* renamed from: b */
        void mo19631b();
    }

    C6005g0(Context context) {
        this.f15369b = context;
        this.f15370c = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public Object m19286m() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{this.f15369b});
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: n */
    static String m19287n() {
        String str = "";
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    InetAddress inetAddress = (InetAddress) it.next();
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress.indexOf(58) < 0) {
                            str = hostAddress;
                            break;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo33873c() {
        return Locale.getDefault() != null ? Locale.getDefault().getLanguage() : "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo33874d() {
        return "Android";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo33875e() {
        return Build.VERSION.SDK_INT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo33876f() {
        try {
            return this.f15369b.getPackageManager().getPackageInfo(this.f15369b.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public String mo33877g() {
        return Build.MANUFACTURER;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public String mo33878h() {
        return Build.MODEL;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public DisplayMetrics mo33879i() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f15369b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public String mo33880j() {
        switch (((UiModeManager) this.f15369b.getSystemService("uimode")).getCurrentModeType()) {
            case 1:
                return "UI_MODE_TYPE_NORMAL";
            case 2:
                return "UI_MODE_TYPE_DESK";
            case 3:
                return "UI_MODE_TYPE_CAR";
            case 4:
                return "UI_MODE_TYPE_TELEVISION";
            case 5:
                return "UI_MODE_TYPE_APPLIANCE";
            case 6:
                return "UI_MODE_TYPE_WATCH";
            default:
                return "UI_MODE_TYPE_UNDEFINED";
        }
    }

    /* renamed from: k */
    public boolean mo33881k() {
        NetworkInfo networkInfo;
        if (this.f15369b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (networkInfo = ((ConnectivityManager) this.f15369b.getSystemService("connectivity")).getNetworkInfo(1)) == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo33882l() {
        return this.f15370c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo33872b() {
        return Locale.getDefault() != null ? Locale.getDefault().getCountry() : "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo33870a(boolean z) {
        Context context = this.f15369b;
        if (context == null) {
            return "bnc_no_value";
        }
        String str = null;
        if (!z && !C3555b.f9967B) {
            str = Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        }
        if (str != null) {
            return str;
        }
        String uuid = UUID.randomUUID().toString();
        this.f15370c = false;
        return uuid;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m19285b(Object obj) {
        try {
            int i = 0;
            if (((Boolean) obj.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                i = 1;
            }
            this.f15368a = i;
        } catch (Exception unused) {
        }
        return this.f15368a;
    }

    /* renamed from: io.branch.referral.g0$b */
    /* compiled from: SystemObserver */
    private class C6006b extends C5991c<Void, Void, Void> {

        /* renamed from: a */
        private final C3570a f15371a;

        /* renamed from: io.branch.referral.g0$b$a */
        /* compiled from: SystemObserver */
        class C6007a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ CountDownLatch f15373a;

            C6007a(CountDownLatch countDownLatch) {
                this.f15373a = countDownLatch;
            }

            public void run() {
                Process.setThreadPriority(-19);
                Object a = C6005g0.this.m19286m();
                String unused = C6005g0.this.m19283a(a);
                int unused2 = C6005g0.this.m19285b(a);
                this.f15373a.countDown();
            }
        }

        public C6006b(C3570a aVar) {
            this.f15371a = aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new C6007a(countDownLatch)).start();
            try {
                countDownLatch.await(1500, TimeUnit.MILLISECONDS);
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            C3570a aVar = this.f15371a;
            if (aVar != null) {
                aVar.mo19631b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo33869a() {
        try {
            PackageInfo packageInfo = this.f15369b.getPackageManager().getPackageInfo(this.f15369b.getPackageName(), 0);
            if (packageInfo.versionName != null) {
                return packageInfo.versionName;
            }
            return "bnc_no_value";
        } catch (PackageManager.NameNotFoundException unused) {
            return "bnc_no_value";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m19283a(Object obj) {
        try {
            f15367d = (String) obj.getClass().getMethod("getId", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
        }
        return f15367d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo33871a(C3570a aVar) {
        if (!TextUtils.isEmpty(f15367d)) {
            return false;
        }
        new C6006b(aVar).mo33821a(new Void[0]);
        return true;
    }
}
