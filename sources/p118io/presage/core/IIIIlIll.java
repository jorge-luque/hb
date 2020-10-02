package p118io.presage.core;

import admost.sdk.base.AdMost;
import android.app.KeyguardManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.PowerManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.facebook.places.model.PlaceFields;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import p118io.presage.core.service.SMJobService;
import p118io.presage.core.service.SdkJobService;
import p118io.presage.core.service.SdkService;

/* renamed from: io.presage.core.IIIIlIll */
public class IIIIlIll {
    public static IIllllII IIIIIIII;

    public static int IIIIIIII(Context context) {
        UsageStatsManager usageStatsManager;
        if (Build.VERSION.SDK_INT < 28 || (usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats")) == null) {
            return 0;
        }
        return usageStatsManager.getAppStandbyBucket();
    }

    public static final long IIIIIIII(InputStream inputStream, OutputStream outputStream, boolean z, boolean z2) {
        if (inputStream == null || outputStream == null) {
            if (inputStream != null && z) {
                inputStream.close();
            }
            if (outputStream == null || !z2) {
                return -1;
            }
            outputStream.close();
            return -1;
        }
        byte[] bArr = new byte[2048];
        int i = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i += read;
            } finally {
                if (z) {
                    inputStream.close();
                }
                if (z2) {
                    outputStream.close();
                }
            }
        }
        return (long) i;
    }

    public static llIlllII IIIIIIII(int i) {
        if (i == 100) {
            return new llIlllII(1001, C6297e1.IIIlIIII);
        }
        if (i == 101) {
            return new llIlllII(1001, C6297e1.IIIlIIIl);
        }
        if (i == 200) {
            return new llIlllII(1002, C6297e1.IIIlIIlI);
        }
        if (i == 500) {
            return new llIlllII(1005, C6297e1.IIIIlIll);
        }
        if (i == 600) {
            return new llIlllII(1006, C6297e1.IIIIlllI);
        }
        if (i == 601) {
            return new llIlllII(1006, C6297e1.IIIIllll);
        }
        switch (i) {
            case AdMost.AD_ERROR_FREQ_CAP:
                return new llIlllII(1003, C6297e1.IIIIIIII);
            case AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN:
                return new llIlllII(1003, C6297e1.IIIIlIlI);
            case AdMost.AD_ERROR_TAG_PASSIVE:
                return new llIlllII(1003, C6297e1.IIIIIIIl);
            case AdMost.AD_ERROR_ZONE_PASSIVE:
                return new llIlllII(1003, C6297e1.IIIIIIlI);
            case AdMost.AD_ERROR_ZONE_TIMEOUT:
                return new llIlllII(1003, C6297e1.IIIIIIll);
            case AdMost.AD_ERROR_FAILED_TO_SHOW:
                return new llIlllII(1003, C6297e1.IIIIIlII);
            case 306:
                return new llIlllII(1003, C6297e1.IIIIIlIl);
            case 307:
                return new llIlllII(1003, C6297e1.IIIIIllI);
            case 308:
                return new llIlllII(1003, C6297e1.IIIIIlll);
            default:
                switch (i) {
                    case 400:
                        return new llIlllII(1004, C6297e1.IIIIlIII);
                    case AdMost.AD_ERROR_WATERFALL_EMPTY:
                        return new llIlllII(1004, C6297e1.IIIIlIIl);
                    case AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID:
                        return new llIlllII(1004, C6297e1.IIIIllII);
                    case AdMost.AD_ERROR_NOT_CACHABLE:
                        return new llIlllII(1004, C6297e1.IIIIllIl);
                    default:
                        return null;
                }
        }
    }

    public static String IIIIIIII(String str) {
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(new C6345q1());
            byte[] bytes = str.getBytes();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                byte[] IIIIIIlI = ((C6357t1) it.next()).IIIIIIlI(bytes);
                bytes = Arrays.copyOf(IIIIIIlI, IIIIIIlI.length);
            }
            return new String(bytes);
        } catch (C6349r1 | NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static String IIIIIIII(String str, llllIlII llllilii) {
        try {
            return new String(new C6353s1().IIIIIIII(1).IIIIIIlI(llllilii.IIIIIIII()).IIIIIIII(2).IIIIIIII(0).IIIIIIlI(llllilii.IIIIIIIl()).IIIIIIII(str.getBytes()));
        } catch (C6349r1 | C6373x1 | NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static void IIIIIIII() {
        lllIllll.IIIIIIII();
        lllIllIl.IIIIIIII();
        lllIIlll.IIIIIIII();
        lllIlIII.IIIIIIII();
        lllIllII.IIIIIIII();
        lllIIIIl.IIIIIIII();
        lllIIIll.IIIIIIII();
        lllIlIIl.IIIIIIII();
        llllIIIl.IIIIIIII();
        lllIIlII.IIIIIIII();
        lllIlIll.IIIIIIII();
        lllIIlIl.IIIIIIII();
        llllIIlI.IIIIIIII();
        lllIlIlI.IIIIIIII();
        lllIIIlI.IIIIIIII();
        lllIIIII.IIIIIIII();
        lllIlllI.IIIIIIII();
        llIlllll.IIIIIIII();
        llllIIII.IIIIIIII();
        lllIIllI.IIIIIIII();
    }

    public static void IIIIIIII(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("c133dd6f", i);
        IIIIIIII(context.getApplicationContext(), "2b020927", bundle);
    }

    public static void IIIIIIII(Context context, int i, long j, long j2, long j3, int i2, boolean z) {
        long j4 = j / 1000;
        long j5 = j2 / 1000;
        long j6 = j3 / 1000;
        try {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (z) {
                jobScheduler.cancel(475439710);
            }
            if (jobScheduler.getPendingJob(475439710) == null) {
                ComponentName componentName = new ComponentName(context, SMJobService.class);
                boolean IIIIIIII2 = IIIIIIII(context, "android.permission.RECEIVE_BOOT_COMPLETED");
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putBoolean("25dfee1e", i == 0);
                jobScheduler.schedule(new JobInfo.Builder(475439710, componentName).setMinimumLatency(j).setOverrideDeadline(j2).setBackoffCriteria(j3, i2).setPersisted(IIIIIIII2).setExtras(persistableBundle).build());
            }
        } catch (Exception unused) {
        }
    }

    public static void IIIIIIII(IIlllIll iIlllIll) {
        if (iIlllIll != null) {
            iIlllIll.shutdown();
        }
    }

    public static boolean IIIIIIII(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        }
        new IllegalArgumentException();
        return false;
    }

    public static final byte[] IIIIIIII(InputStream inputStream, boolean z) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (z) {
                inputStream.close();
            }
        }
    }

    public static String IIIIIIIl(Context context) {
        String networkCountryIso;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
        String str = "";
        if (!(telephonyManager.getPhoneType() == 4 || (networkCountryIso = telephonyManager.getNetworkCountryIso()) == null || networkCountryIso.isEmpty())) {
            str = new Locale(str, networkCountryIso).getISO3Country();
        }
        return (str == null || str.isEmpty()) ? IIIIIlll(context).getISO3Country() : str;
    }

    public static void IIIIIIIl() {
        C6347r.IIIIIIII();
        C6332n0.IIIIIIII();
        C6348r0.IIIIIIII();
        llllllII.IIIIIIII();
        lllllIlI.IIIIIIII();
        C6291d.IIIIIIII();
        C6292d0.IIIIIIII();
        C6372x0.IIIIIIII();
        C6380z0.IIIIIIII();
        C6289c1.IIIIIIII();
        C6315j.IIIIIIII();
        C6364v0.IIIIIIII();
        C6335o.IIIIIIII();
        C6300f0.IIIIIIII();
        C6283b.IIIIIIII();
        C6336o0.IIIIIIII();
        C6328m0.IIIIIIII();
        lllllllI.IIIIIIII();
        llllllll.IIIIIIII();
        C6344q0.IIIIIIII();
        C6340p0.IIIIIIII();
        C6356t0.IIIIIIII();
        C6324l0.IIIIIIII();
        C6343q.IIIIIIII();
        llllIlll.IIIIIIII();
        lllllIII.IIIIIIII();
        C6327m.IIIIIIII();
        C6351s.IIIIIIII();
        C6288c0.IIIIIIII();
        C6285b1.IIIIIIII();
        C6371x.IIIIIIII();
        C6312i0.IIIIIIII();
        C6320k0.IIIIIIII();
        C6311i.IIIIIIII();
        C6316j0.IIIIIIII();
        C6284b0.IIIIIIII();
        C6359u.IIIIIIII();
        llllIllI.IIIIIIII();
        lllllIll.IIIIIIII();
        llllllIl.IIIIIIII();
        C6295e.IIIIIIII();
        C6319k.IIIIIIII();
        C6368w0.IIIIIIII();
        C6299f.IIIIIIII();
        C6303g.IIIIIIII();
        C6307h.IIIIIIII();
        C6323l.IIIIIIII();
        C6355t.IIIIIIII();
        C6363v.IIIIIIII();
        C6367w.IIIIIIII();
        C6296e0.IIIIIIII();
        C6308h0.IIIIIIII();
        C6352s0.IIIIIIII();
        C6360u0.IIIIIIII();
        C6376y0.IIIIIIII();
        C6281a1.IIIIIIII();
        C6293d1.IIIIIIII();
        C6339p.IIIIIIII();
        C6304g0.IIIIIIII();
        C6287c.IIIIIIII();
        lllllIIl.IIIIIIII();
        C6301f1.IIIIIIII();
        C6379z.IIIIIIII();
        C6375y.IIIIIIII();
        C6280a0.IIIIIIII();
        C6279a.IIIIIIII();
        C6297e1.IIIIIIII();
        C6331n.IIIIIIII();
    }

    public static void IIIIIIIl(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("c133dd6f", i);
        IIIIIIII(context.getApplicationContext(), "df77b6b3", bundle);
    }

    public static List<PackageInfo> IIIIIIlI(Context context) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            return context.getPackageManager().getInstalledPackages(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        } catch (RuntimeException e) {
            e = e;
            i = 0;
            lIIIIlIl.IIIIIIII(e, i);
            arrayList.clear();
            return arrayList;
        } catch (Exception e2) {
            e = e2;
            i = 1;
            lIIIIlIl.IIIIIIII(e, i);
            arrayList.clear();
            return arrayList;
        }
    }

    public static HashSet<String> IIIIIIll(Context context) {
        int i;
        HashSet<String> hashSet = new HashSet<>();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return hashSet;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER"), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE)) {
                hashSet.add(resolveInfo.activityInfo.applicationInfo.packageName);
            }
            return hashSet;
        } catch (RuntimeException e) {
            e = e;
            i = 0;
            lIIIIlIl.IIIIIIII(e, i);
            hashSet.clear();
            return hashSet;
        } catch (Exception e2) {
            e = e2;
            i = 1;
            lIIIIlIl.IIIIIIII(e, i);
            hashSet.clear();
            return hashSet;
        }
    }

    public static List<String> IIIIIlII(Context context) {
        String packageName = context.getPackageName();
        int i = 0;
        if (Build.VERSION.SDK_INT >= 16) {
            ArrayList arrayList = new ArrayList();
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, CodedOutputStream.DEFAULT_BUFFER_SIZE);
                if (!(packageInfo == null || packageInfo.requestedPermissions == null)) {
                    while (true) {
                        String[] strArr = packageInfo.requestedPermissions;
                        if (i >= strArr.length) {
                            return arrayList;
                        }
                        if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                            arrayList.add(strArr[i]);
                        }
                        i++;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return new ArrayList();
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(packageName, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            if (!(packageInfo2 == null || packageInfo2.requestedPermissions == null)) {
                while (true) {
                    String[] strArr2 = packageInfo2.requestedPermissions;
                    if (i >= strArr2.length) {
                        return arrayList2;
                    }
                    arrayList2.add(strArr2[i]);
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return new ArrayList();
    }

    public static List<String> IIIIIlIl(Context context) {
        String packageName = context.getPackageName();
        if (Build.VERSION.SDK_INT < 16) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            if (!(packageInfo == null || packageInfo.requestedPermissions == null)) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        return arrayList;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) == 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return new ArrayList();
    }

    public static String IIIIIllI(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static Locale IIIIIlll(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        Locale locale = context.getResources().getConfiguration().locale;
        return (Build.VERSION.SDK_INT < 24 || configuration.getLocales().isEmpty()) ? locale : configuration.getLocales().get(0);
    }

    public static boolean IIIIlIII(Context context) {
        try {
            return (context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).applicationInfo.flags & 32768) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean IIIIlIIl(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (Build.VERSION.SDK_INT >= 16) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (!(Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn()) || keyguardManager.isKeyguardLocked()) {
                return false;
            }
            return true;
        }
        PowerManager powerManager2 = (PowerManager) context.getSystemService("power");
        if (!(Build.VERSION.SDK_INT >= 20 ? powerManager2.isInteractive() : powerManager2.isScreenOn()) || keyguardManager.inKeyguardRestrictedInputMode()) {
            return false;
        }
        return true;
    }

    public static String IIIIIIII(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            if (digest == null) {
                return null;
            }
            Formatter formatter = new Formatter();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                formatter.format("%02x", new Object[]{Byte.valueOf(digest[i])});
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (FormatterClosedException | IllegalFormatException e) {
            throw new C6373x1(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new C6373x1(e2);
        }
    }

    public static void IIIIIIII(C6317j1 j1Var) {
        try {
            C6321k1 k1Var = new C6321k1(j1Var);
            IIllllII iIllllII = IIIIIIII;
            if (iIllllII == null || iIllllII.IIIIIIII.isTerminated()) {
                IIIIIIII = new IIllllII(Executors.newSingleThreadExecutor());
            }
            k1Var.IIIIIIII(IIIIIIII, false, new Void[0]);
        } catch (IIlllIII unused) {
        }
    }

    public static void IIIIIIII(Context context, IIIIllII iIIIllII, boolean z) {
        int i = iIIIllII.IIIIIIII;
        try {
            int i2 = iIIIllII.IIIIIIII;
            if (i2 != 0) {
                if (i2 == 1) {
                    IIIIIIII(context, iIIIllII.IIIIIIIl, iIIIllII.IIIIIIll, iIIIllII.IIIIIIlI, iIIIllII.IIIIIlII, iIIIllII.IIIIIlIl, z);
                    return;
                }
            }
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (z) {
                jobScheduler.cancel(475439710);
            }
        } catch (Exception unused) {
        }
    }

    public static void IIIIIIII(Context context, String str, Bundle bundle) {
        IIIIlIIl(context);
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (Build.VERSION.SDK_INT >= 23) {
            powerManager.isDeviceIdleMode();
        }
        if (IIIIlIIl(context)) {
            if (Build.VERSION.SDK_INT >= 23 ? ((PowerManager) context.getSystemService("power")).isDeviceIdleMode() : false) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
                    if (jobScheduler.getPendingJob(475439700) == null) {
                        ComponentName componentName = new ComponentName(context, SdkJobService.class);
                        bundle.putString("34eb4c4e", str);
                        jobScheduler.schedule(new JobInfo.Builder(475439700, componentName).setMinimumLatency(500).setOverrideDeadline(1000).setBackoffCriteria(TapjoyConstants.TIMER_INCREMENT, 0).setTransientExtras(bundle).build());
                    }
                } catch (Exception unused) {
                }
                IIIIllIl IIIIIIII2 = IIIIllIl.IIIIIIII(context);
                if (IIIIIIII2.IIIIIIII().IIIIIIII == 1 && IIIIIIII2.IIIIIIII().IIIIIIIl == 1) {
                    IIIIIIII(context, IIIIIIII2.IIIIIIII(), false);
                    return;
                }
                return;
            }
            try {
                Intent intent = new Intent(context, SdkService.class);
                intent.setAction(str);
                intent.putExtras(bundle);
                if (Build.VERSION.SDK_INT < 26) {
                    context.startService(intent);
                }
            } catch (Exception unused2) {
            }
        }
    }

    public static final void IIIIIIII(byte[] bArr, OutputStream outputStream, boolean z) {
        if (bArr != null) {
            int length = bArr.length;
            if (outputStream != null) {
                try {
                    outputStream.write(bArr, 0, length);
                } finally {
                    if (z) {
                        outputStream.close();
                    }
                }
            }
        } else if (z) {
            outputStream.close();
        }
    }
}
