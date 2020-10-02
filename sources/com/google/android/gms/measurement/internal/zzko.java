package com.google.android.gms.measurement.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzko extends zzgr {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd = new AtomicLong(0);
    private int zze;
    private Integer zzf = null;

    zzko(zzfx zzfx) {
        super(zzfx);
    }

    static boolean zza(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    static boolean zze(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR);
    }

    private final int zzi(String str) {
        if (!zzb("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        if (!zza("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    @VisibleForTesting
    private static boolean zzj(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int zzk(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (!zzt().zza(zzas.zzbl) || !"_lgclid".equals(str)) ? 36 : 100;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f_ */
    public final void mo26456f_() {
        zzd();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzr().zzi().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(nextLong);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzr().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzr().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzr().zzh().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzc(String str) {
        if (!zzb("user property", str)) {
            return 6;
        }
        if (!zza("user property", zzgy.zza, str)) {
            return 15;
        }
        if (!zza("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(String str) {
        zzd();
        if (Wrappers.packageManager(zzn()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzr().zzw().zza("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzw = zzt().zzw();
        zzu();
        return zzw.equals(str);
    }

    public final long zzg() {
        long andIncrement;
        long j;
        if (this.zzd.get() == 0) {
            synchronized (this.zzd) {
                long nextLong = new Random(System.nanoTime() ^ zzm().currentTimeMillis()).nextLong();
                int i = this.zze + 1;
                this.zze = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzd) {
            this.zzd.compareAndSet(-1, 1);
            andIncrement = this.zzd.getAndIncrement();
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    public final SecureRandom zzh() {
        zzd();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzak zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzer zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzko zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfu zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzet zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzff zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzaa zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzv zzu() {
        return super.zzu();
    }

    public final boolean zzv() {
        try {
            zzn().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("campaign", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(ShareConstants.FEED_SOURCE_PARAM, str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("medium", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(AppLovinEventTypes.USER_VIEWED_CONTENT, queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzr().zzi().zza("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final int zzj() {
        if (this.zzf == null) {
            this.zzf = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zzn()) / 1000);
        }
        return this.zzf.intValue();
    }

    static MessageDigest zzi() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Object zzc(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzk(str), obj, true, false);
        }
        return zza(zzk(str), obj, false, false);
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    private final int zzh(String str) {
        if (!zza("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        if (!zza("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final String zzk() {
        byte[] bArr = new byte[16];
        zzh().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    static boolean zzc(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    @VisibleForTesting
    private final boolean zzc(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            zzr().zzf().zza("Error obtaining certificate", e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            zzr().zzf().zza("Package name not found", e2);
            return true;
        }
    }

    public static boolean zzg(String str) {
        for (String equals : zzb) {
            if (equals.equals(str)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        if (!zzb(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, str)) {
            return 2;
        }
        if (!zza(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, zzgw.zza, str)) {
            return 13;
        }
        if (!zza(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, 40, str)) {
            return 2;
        }
        return 0;
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    private final boolean zzb(String str, String str2, int i, Object obj) {
        int i2;
        if (obj instanceof Parcelable[]) {
            i2 = ((Parcelable[]) obj).length;
        } else {
            if (obj instanceof ArrayList) {
                i2 = ((ArrayList) obj).size();
            }
            return true;
        }
        if (i2 > i) {
            zzr().zzk().zza("Parameter array is too long; discarded. Value kind, name, array length", str, str2, Integer.valueOf(i2));
            return false;
        }
        return true;
    }

    static Bundle[] zzb(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    static boolean zzb(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    static boolean zza(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = zza("user property referrer", str, zzk(str), obj);
        } else {
            z = zza("user property", str, zzk(str), obj);
        }
        return z ? 0 : 7;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzr().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzr().zzh().zza("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzr().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean zzb(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static Bundle zzb(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String str2) {
        boolean z;
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr2 = zza;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr2[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzr().zzh().zza("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (strArr == null || !zza(str2, strArr)) {
            return true;
        } else {
            zzr().zzh().zza("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public static ArrayList<Bundle> zzb(List<zzy> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzy next : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", next.zza);
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN, next.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, next.zzd);
            bundle.putString("name", next.zzc.zza);
            zzgt.zza(bundle, next.zzc.zza());
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, next.zze);
            String str = next.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzaq zzaq = next.zzg;
            if (zzaq != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzaq.zza);
                zzal zzal = next.zzg.zzb;
                if (zzal != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzal.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, next.zzh);
            zzaq zzaq2 = next.zzi;
            if (zzaq2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzaq2.zza);
                zzal zzal2 = next.zzi.zzb;
                if (zzal2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzal2.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, next.zzc.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, next.zzj);
            zzaq zzaq3 = next.zzk;
            if (zzaq3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzaq3.zza);
                zzal zzal3 = next.zzk.zzb;
                if (zzal3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzal3.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzr().zzh().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    static boolean zza(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                zzr().zzk().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    static boolean zza(Bundle bundle, int i) {
        int i2 = 0;
        if (bundle.size() <= i) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i2++;
            if (i2 > i) {
                bundle.remove(str);
            }
        }
        return true;
    }

    private final void zza(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int i;
        int i2;
        String str4;
        int i3;
        String str5;
        String str6 = str2;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        if (bundle2 != null) {
            boolean zza2 = zzt().zza(zzas.zzci);
            if (zza2) {
                i = 0;
            } else {
                i = zzt().zze();
            }
            int i4 = 0;
            for (String str7 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str7)) {
                    i2 = z ? zzh(str7) : 0;
                    if (i2 == 0) {
                        i2 = zzi(str7);
                    }
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                    zza(bundle2, i2, str7, str7, (Object) i2 == 3 ? str7 : null);
                    bundle2.remove(str7);
                } else {
                    if (zza(bundle2.get(str7))) {
                        zzr().zzk().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str6, str3, str7);
                        i3 = 22;
                        str4 = str7;
                    } else {
                        String str8 = str3;
                        str4 = str7;
                        i3 = zza(str, str2, str7, bundle2.get(str7), bundle, list, z, false);
                    }
                    if (i3 != 0 && !"_ev".equals(str4)) {
                        zza(bundle2, i3, str4, str4, bundle2.get(str4));
                        bundle2.remove(str4);
                    } else if (zza(str4) && (!zza2 || !zza(str4, zzgv.zzd))) {
                        int i5 = i4 + 1;
                        if (i5 > i) {
                            if (zza2) {
                                str5 = "Item cannot contain custom parameters";
                            } else {
                                StringBuilder sb = new StringBuilder(63);
                                sb.append("Child bundles can't contain more than ");
                                sb.append(i);
                                sb.append(" custom params");
                                str5 = sb.toString();
                            }
                            zzr().zzh().zza(str5, zzo().zza(str6), zzo().zza(bundle2));
                            zzb(bundle2, zza2 ? 23 : 5);
                            bundle2.remove(str4);
                        }
                        i4 = i5;
                    }
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (zzj(str)) {
                return true;
            }
            if (this.zzz.zzl()) {
                zzr().zzh().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzet.zza(str));
            }
            return false;
        } else if (zzle.zzb() && zzt().zza(zzas.zzbo) && !TextUtils.isEmpty(str3)) {
            return true;
        } else {
            if (TextUtils.isEmpty(str2)) {
                if (this.zzz.zzl()) {
                    zzr().zzh().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                }
                return false;
            } else if (zzj(str2)) {
                return true;
            } else {
                zzr().zzh().zza("Invalid admob_app_id. Analytics disabled.", zzet.zza(str2));
                return false;
            }
        }
    }

    static boolean zza(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    private final Object zza(int i, Object obj, boolean z, boolean z2) {
        Bundle zza2;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            if (!zzjt.zzb() || !zzt().zza(zzas.zzch) || !zzt().zza(zzas.zzcg) || !z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if ((parcelable instanceof Bundle) && (zza2 = zza((Bundle) parcelable)) != null && !zza2.isEmpty()) {
                    arrayList.add(zza2);
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0166 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Object r21, android.os.Bundle r22, java.util.List<java.lang.String> r23, boolean r24, boolean r25) {
        /*
            r17 = this;
            r7 = r17
            r8 = r20
            r0 = r21
            r1 = r22
            r17.zzd()
            boolean r2 = com.google.android.gms.internal.measurement.zzjt.zzb()
            r3 = 17
            java.lang.String r4 = "param"
            r9 = 0
            if (r2 == 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzaa r2 = r17.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzas.zzci
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r5)
            if (r2 == 0) goto L_0x007f
            boolean r2 = zza((java.lang.Object) r21)
            if (r2 == 0) goto L_0x008a
            if (r25 == 0) goto L_0x007c
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzgv.zzc
            boolean r2 = zza((java.lang.String) r8, (java.lang.String[]) r2)
            if (r2 != 0) goto L_0x0035
            r0 = 20
            return r0
        L_0x0035:
            com.google.android.gms.measurement.internal.zzfx r2 = r7.zzz
            com.google.android.gms.measurement.internal.zzin r2 = r2.zzw()
            boolean r2 = r2.zzai()
            if (r2 != 0) goto L_0x0044
            r0 = 25
            return r0
        L_0x0044:
            r2 = 200(0xc8, float:2.8E-43)
            boolean r5 = r7.zzb(r4, r8, r2, r0)
            if (r5 != 0) goto L_0x008a
            boolean r5 = r0 instanceof android.os.Parcelable[]
            if (r5 == 0) goto L_0x0060
            r5 = r0
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r6 = r5.length
            if (r6 <= r2) goto L_0x0079
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r2)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
            goto L_0x0079
        L_0x0060:
            boolean r5 = r0 instanceof java.util.ArrayList
            if (r5 == 0) goto L_0x0079
            r5 = r0
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            if (r6 <= r2) goto L_0x0079
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r2 = r5.subList(r9, r2)
            r6.<init>(r2)
            r1.putParcelableArrayList(r8, r6)
        L_0x0079:
            r10 = 17
            goto L_0x008b
        L_0x007c:
            r0 = 21
            return r0
        L_0x007f:
            if (r25 == 0) goto L_0x008a
            r1 = 1000(0x3e8, float:1.401E-42)
            boolean r1 = r7.zzb(r4, r8, r1, r0)
            if (r1 != 0) goto L_0x008a
            return r3
        L_0x008a:
            r10 = 0
        L_0x008b:
            com.google.android.gms.measurement.internal.zzaa r1 = r17.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzaq
            r11 = r18
            boolean r1 = r1.zze(r11, r2)
            if (r1 == 0) goto L_0x009f
            boolean r1 = zze(r19)
            if (r1 != 0) goto L_0x00a5
        L_0x009f:
            boolean r1 = zze(r20)
            if (r1 == 0) goto L_0x00a8
        L_0x00a5:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x00aa
        L_0x00a8:
            r1 = 100
        L_0x00aa:
            boolean r1 = r7.zza((java.lang.String) r4, (java.lang.String) r8, (int) r1, (java.lang.Object) r0)
            if (r1 == 0) goto L_0x00b1
            return r10
        L_0x00b1:
            if (r25 == 0) goto L_0x0167
            boolean r1 = com.google.android.gms.internal.measurement.zzjt.zzb()
            r12 = 1
            if (r1 == 0) goto L_0x00c8
            com.google.android.gms.measurement.internal.zzaa r1 = r17.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzch
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            if (r1 == 0) goto L_0x00c8
            r13 = 1
            goto L_0x00c9
        L_0x00c8:
            r13 = 0
        L_0x00c9:
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00e4
            if (r13 == 0) goto L_0x00e1
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r5 = r23
            r6 = r24
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6)
        L_0x00e1:
            r9 = 1
            goto L_0x0164
        L_0x00e4:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x0123
            r14 = r0
            android.os.Parcelable[] r14 = (android.os.Parcelable[]) r14
            int r15 = r14.length
            r6 = 0
        L_0x00ed:
            if (r6 >= r15) goto L_0x00e1
            r0 = r14[r6]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x0107
            com.google.android.gms.measurement.internal.zzet r1 = r17.zzr()
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzk()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.zza(r2, r0, r8)
            goto L_0x0164
        L_0x0107:
            if (r13 == 0) goto L_0x011e
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r5 = r23
            r16 = r6
            r6 = r24
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6)
            goto L_0x0120
        L_0x011e:
            r16 = r6
        L_0x0120:
            int r6 = r16 + 1
            goto L_0x00ed
        L_0x0123:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x0164
            r14 = r0
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            int r15 = r14.size()
            r0 = 0
        L_0x012f:
            if (r0 >= r15) goto L_0x00e1
            java.lang.Object r1 = r14.get(r0)
            int r16 = r0 + 1
            boolean r0 = r1 instanceof android.os.Bundle
            if (r0 != 0) goto L_0x014d
            com.google.android.gms.measurement.internal.zzet r0 = r17.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzk()
            java.lang.Class r1 = r1.getClass()
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r0.zza(r2, r1, r8)
            goto L_0x0164
        L_0x014d:
            if (r13 == 0) goto L_0x0161
            r4 = r1
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r5 = r23
            r6 = r24
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6)
        L_0x0161:
            r0 = r16
            goto L_0x012f
        L_0x0164:
            if (r9 == 0) goto L_0x0167
            return r10
        L_0x0167:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzko.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* access modifiers changed from: package-private */
    public final Object zza(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return zza(256, obj, true, true);
        }
        if (!zze(str)) {
            i = 100;
        }
        return zza(i, obj, false, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza(java.lang.String r23, java.lang.String r24, android.os.Bundle r25, java.util.List<java.lang.String> r26, boolean r27, boolean r28) {
        /*
            r22 = this;
            r9 = r22
            r10 = r24
            r11 = r25
            r12 = r26
            boolean r0 = com.google.android.gms.internal.measurement.zzjt.zzb()
            r13 = 0
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.measurement.internal.zzaa r0 = r22.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzci
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x001e
            r0 = 1
            r14 = 1
            goto L_0x001f
        L_0x001e:
            r14 = 0
        L_0x001f:
            if (r14 == 0) goto L_0x0029
            java.lang.String[] r0 = com.google.android.gms.measurement.internal.zzgw.zzc
            boolean r0 = zza((java.lang.String) r10, (java.lang.String[]) r0)
            r15 = r0
            goto L_0x002b
        L_0x0029:
            r15 = r28
        L_0x002b:
            r16 = 0
            if (r11 == 0) goto L_0x0143
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>(r11)
            com.google.android.gms.measurement.internal.zzaa r0 = r22.zzt()
            int r7 = r0.zze()
            com.google.android.gms.measurement.internal.zzaa r0 = r22.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzbb
            r6 = r23
            boolean r0 = r0.zze(r6, r1)
            if (r0 == 0) goto L_0x0054
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r25.keySet()
            r0.<init>(r1)
            goto L_0x0058
        L_0x0054:
            java.util.Set r0 = r25.keySet()
        L_0x0058:
            java.util.Iterator r17 = r0.iterator()
            r18 = 0
        L_0x005e:
            boolean r0 = r17.hasNext()
            if (r0 == 0) goto L_0x0140
            java.lang.Object r0 = r17.next()
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5
            if (r12 == 0) goto L_0x0076
            boolean r0 = r12.contains(r5)
            if (r0 != 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r0 = 0
            goto L_0x0084
        L_0x0076:
            if (r27 == 0) goto L_0x007d
            int r0 = r9.zzh(r5)
            goto L_0x007e
        L_0x007d:
            r0 = 0
        L_0x007e:
            if (r0 != 0) goto L_0x0084
            int r0 = r9.zzi(r5)
        L_0x0084:
            if (r0 == 0) goto L_0x0097
            r1 = 3
            if (r0 != r1) goto L_0x008b
            r1 = r5
            goto L_0x008d
        L_0x008b:
            r1 = r16
        L_0x008d:
            zza((android.os.Bundle) r8, (int) r0, (java.lang.String) r5, (java.lang.String) r5, (java.lang.Object) r1)
            r8.remove(r5)
            r20 = r7
            r2 = r8
            goto L_0x00e3
        L_0x0097:
            java.lang.Object r4 = r11.get(r5)
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r5
            r19 = r5
            r5 = r8
            r6 = r26
            r20 = r7
            r7 = r27
            r21 = r8
            r8 = r15
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r14 == 0) goto L_0x00c4
            r1 = 17
            if (r0 != r1) goto L_0x00c4
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r13)
            r3 = r19
            r2 = r21
            zza((android.os.Bundle) r2, (int) r0, (java.lang.String) r3, (java.lang.String) r3, (java.lang.Object) r1)
            goto L_0x00ea
        L_0x00c4:
            r3 = r19
            r2 = r21
            if (r0 == 0) goto L_0x00ea
            java.lang.String r1 = "_ev"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00ea
            r1 = 21
            if (r0 != r1) goto L_0x00d8
            r5 = r10
            goto L_0x00d9
        L_0x00d8:
            r5 = r3
        L_0x00d9:
            java.lang.Object r1 = r11.get(r3)
            zza((android.os.Bundle) r2, (int) r0, (java.lang.String) r5, (java.lang.String) r3, (java.lang.Object) r1)
            r2.remove(r3)
        L_0x00e3:
            r6 = r23
            r8 = r2
            r7 = r20
            goto L_0x005e
        L_0x00ea:
            boolean r0 = zza((java.lang.String) r3)
            if (r0 == 0) goto L_0x0138
            int r0 = r18 + 1
            r1 = r20
            if (r0 <= r1) goto L_0x0135
            r4 = 48
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Event can't contain more than "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r4 = " params"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.google.android.gms.measurement.internal.zzet r5 = r22.zzr()
            com.google.android.gms.measurement.internal.zzev r5 = r5.zzh()
            com.google.android.gms.measurement.internal.zzer r6 = r22.zzo()
            java.lang.String r6 = r6.zza((java.lang.String) r10)
            com.google.android.gms.measurement.internal.zzer r7 = r22.zzo()
            java.lang.String r7 = r7.zza((android.os.Bundle) r11)
            r5.zza(r4, r6, r7)
            r4 = 5
            zzb((android.os.Bundle) r2, (int) r4)
            r2.remove(r3)
            r6 = r23
            r18 = r0
            goto L_0x013c
        L_0x0135:
            r18 = r0
            goto L_0x013a
        L_0x0138:
            r1 = r20
        L_0x013a:
            r6 = r23
        L_0x013c:
            r7 = r1
            r8 = r2
            goto L_0x005e
        L_0x0140:
            r2 = r8
            r16 = r2
        L_0x0143:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzko.zza(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    private static void zza(Bundle bundle, int i, String str, String str2, Object obj) {
        if (zzb(bundle, i)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if (obj == null) {
                    return;
                }
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) String.valueOf(obj).length());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (zzjt.zzb() && zzt().zza(zzas.zzch) && zzt().zza(zzas.zzcg) && (obj instanceof Bundle[])) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                zzr().zzk().zza("Not putting event parameter. Invalid value type. name, type", zzo().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza((String) null, i, str, str2, i2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzb(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzz.zzu();
        this.zzz.zzh().zza("auto", "_err", bundle);
    }

    @VisibleForTesting
    static long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return zzb(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzb(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    static boolean zza(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    static boolean zza(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zza2 = zza(str, bundle.get(str));
                if (zza2 == null) {
                    zzr().zzk().zza("Param value can't be null", zzo().zzb(str));
                } else {
                    zza(bundle2, str, zza2);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final zzaq zza(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzb(str2) == 0) {
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            return new zzaq(str2, new zzal(zza(zza(str, str2, bundle3, (List<String>) CollectionUtils.listOf("_o"), false, false))), str3, j);
        }
        zzr().zzf().zza("Invalid conditional property event name", zzo().zzc(str2));
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final long zza(Context context, String str) {
        zzd();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzi = zzi();
        if (zzi == null) {
            zzr().zzf().zza("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zzc(context, str)) {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(zzn().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zza(zzi.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzr().zzi().zza("Could not get signatures");
                    return -1;
                }
            } catch (PackageManager.NameNotFoundException e) {
                zzr().zzf().zza("Package name not found", e);
            }
        }
        return 0;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    private static boolean zza(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String zzc2 : strArr) {
            if (zzc(str, zzc2)) {
                return true;
            }
        }
        return false;
    }

    public final int zza(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzn(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public static long zza(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzr().zzi().zza("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zza(zzs zzs, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzs.zza(bundle);
        } catch (RemoteException e) {
            this.zzz.zzr().zzi().zza("Error returning string value to wrapper", e);
        }
    }

    public final void zza(zzs zzs, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzs.zza(bundle);
        } catch (RemoteException e) {
            this.zzz.zzr().zzi().zza("Error returning long value to wrapper", e);
        }
    }

    public final void zza(zzs zzs, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzs.zza(bundle);
        } catch (RemoteException e) {
            this.zzz.zzr().zzi().zza("Error returning int value to wrapper", e);
        }
    }

    public final void zza(zzs zzs, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzs.zza(bundle);
        } catch (RemoteException e) {
            this.zzz.zzr().zzi().zza("Error returning byte array to wrapper", e);
        }
    }

    public final void zza(zzs zzs, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzs.zza(bundle);
        } catch (RemoteException e) {
            this.zzz.zzr().zzi().zza("Error returning boolean value to wrapper", e);
        }
    }

    public final void zza(zzs zzs, Bundle bundle) {
        try {
            zzs.zza(bundle);
        } catch (RemoteException e) {
            this.zzz.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    public static Bundle zza(List<zzkn> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzkn next : list) {
            String str = next.zzd;
            if (str != null) {
                bundle.putString(next.zza, str);
            } else {
                Long l = next.zzc;
                if (l != null) {
                    bundle.putLong(next.zza, l.longValue());
                } else {
                    Double d = next.zzf;
                    if (d != null) {
                        bundle.putDouble(next.zza, d.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public final void zza(zzs zzs, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzs.zza(bundle);
        } catch (RemoteException e) {
            this.zzz.zzr().zzi().zza("Error returning bundle list to wrapper", e);
        }
    }

    public final URL zza(long j, String str, String str2, long j2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{Long.valueOf(j), Integer.valueOf(zzj())}), str2, str, Long.valueOf(j2)});
            if (str.equals(zzt().zzx())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e) {
            zzr().zzf().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ApplySharedPref"})
    public final boolean zza(String str, double d) {
        try {
            SharedPreferences.Editor edit = zzn().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return edit.commit();
        } catch (Exception e) {
            zzr().zzf().zza("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    public static long zza(zzal zzal) {
        long j = 0;
        if (zzal == null) {
            return 0;
        }
        Iterator<String> it = zzal.iterator();
        while (it.hasNext()) {
            Object zza2 = zzal.zza(it.next());
            if (zza2 instanceof Parcelable[]) {
                j += (long) ((Parcelable[]) zza2).length;
            }
        }
        return j;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
