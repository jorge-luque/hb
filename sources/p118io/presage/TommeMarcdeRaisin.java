package p118io.presage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyConstants;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* renamed from: io.presage.TommeMarcdeRaisin */
public final class TommeMarcdeRaisin {

    /* renamed from: a */
    public static final TommeMarcdeRaisin f16705a = new TommeMarcdeRaisin();

    /* renamed from: io.presage.TommeMarcdeRaisin$CamembertauCalvados */
    static final class CamembertauCalvados<T> implements Comparator<ApplicationInfo> {

        /* renamed from: a */
        public static final CamembertauCalvados f16706a = new CamembertauCalvados();

        CamembertauCalvados() {
        }

        /* renamed from: a */
        private static int m20718a(ApplicationInfo applicationInfo, ApplicationInfo applicationInfo2) {
            String str = applicationInfo.packageName;
            String str2 = applicationInfo2.packageName;
            C6514hl.m21414a((Object) str2, "rhs.packageName");
            return str.compareTo(str2);
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return m20718a((ApplicationInfo) obj, (ApplicationInfo) obj2);
        }
    }

    private TommeMarcdeRaisin() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        return m20714b(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        return new p118io.presage.C6263c(m20715c(r5), true, true);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0025 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p118io.presage.C6263c m20712a(android.content.Context r5) {
        /*
            r0 = 1
            io.presage.a r1 = p118io.presage.C6209a.f16744a     // Catch:{ Exception -> 0x0025 }
            io.presage.TrouduCru r1 = p118io.presage.C6209a.m20761a(r5)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = r1.mo34723a()     // Catch:{ Exception -> 0x0025 }
            if (r2 == 0) goto L_0x001d
            boolean r1 = r1.mo34724b()     // Catch:{ Exception -> 0x0025 }
            r3 = 0
            if (r1 != 0) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            io.presage.c r4 = new io.presage.c     // Catch:{ Exception -> 0x0025 }
            r4.<init>(r2, r1, r3)     // Catch:{ Exception -> 0x0025 }
            return r4
        L_0x001d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = "androidAdvertisingId is null"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0025 }
            throw r1     // Catch:{ Exception -> 0x0025 }
        L_0x0025:
            io.presage.c r5 = m20714b(r5)     // Catch:{ Exception -> 0x002a }
            return r5
        L_0x002a:
            java.lang.String r5 = m20715c(r5)
            io.presage.c r1 = new io.presage.c
            r1.<init>(r5, r0, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.TommeMarcdeRaisin.m20712a(android.content.Context):io.presage.c");
    }

    /* renamed from: b */
    private static C6263c m20714b(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID);
        boolean z = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0;
        if (string != null) {
            return new C6263c(string, z, false);
        }
        throw new IllegalStateException("Amazon Fire TV aaid is null".toString());
    }

    /* renamed from: c */
    private static String m20715c(Context context) {
        ApplicationInfo d = m20716d(context);
        if (d == null) {
            return "00000000-0000-0000-0000-000000000000";
        }
        return m20713a(context, d);
    }

    /* renamed from: d */
    private static ApplicationInfo m20716d(Context context) {
        try {
            return m20717e(context);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: e */
    private static ApplicationInfo m20717e(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        ArrayList arrayList = new ArrayList();
        if (installedApplications.size() == 0) {
            return null;
        }
        C6514hl.m21414a((Object) installedApplications, "apps");
        for (int i = 0; i < installedApplications.size(); i++) {
            ApplicationInfo applicationInfo = installedApplications.get(i);
            if (!((applicationInfo.flags & 1) == 0 || applicationInfo.packageName == null)) {
                arrayList.add(applicationInfo);
            }
        }
        C6452fd.m21333a(arrayList, CamembertauCalvados.f16706a);
        return (ApplicationInfo) arrayList.get(0);
    }

    /* renamed from: a */
    private static String m20713a(Context context, ApplicationInfo applicationInfo) {
        try {
            long j = context.getPackageManager().getPackageInfo(applicationInfo.packageName, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).firstInstallTime;
            String str = String.valueOf(j);
            Charset charset = C6548is.f17074a;
            if (str != null) {
                byte[] bytes = str.getBytes(charset);
                C6514hl.m21414a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                String uuid = UUID.nameUUIDFromBytes(bytes).toString();
                C6514hl.m21414a((Object) uuid, "UUID.nameUUIDFromBytes((…toByteArray()).toString()");
                return uuid;
            }
            throw new C6434em("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
            return "00000000-0000-0000-0000-000000000000";
        }
    }
}
