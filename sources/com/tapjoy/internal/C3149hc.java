package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.facebook.places.model.PlaceFields;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.C5038eu;
import com.tapjoy.internal.C5056fa;
import com.tapjoy.internal.C5068fe;
import com.tapjoy.internal.C5077fh;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

/* renamed from: com.tapjoy.internal.hc */
public final class C3149hc {

    /* renamed from: a */
    public static final String f8780a = UUID.randomUUID().toString();

    /* renamed from: d */
    private static C3149hc f8781d;

    /* renamed from: b */
    public final C5077fh.C5078a f8782b = new C5077fh.C5078a();

    /* renamed from: c */
    public final C5159hj f8783c;

    /* renamed from: e */
    private final C5056fa.C5057a f8784e = new C5056fa.C5057a();

    /* renamed from: f */
    private final C5038eu.C5039a f8785f = new C5038eu.C5039a();

    /* renamed from: g */
    private final Context f8786g;

    private C3149hc(Context context, C5159hj hjVar) {
        C5162hn.m17385a();
        C5056fa.C5057a aVar = this.f8784e;
        aVar.f13779p = "12.6.0/Android";
        aVar.f13770g = "Android";
        aVar.f13771h = Build.VERSION.RELEASE;
        aVar.f13768e = Build.MANUFACTURER;
        aVar.f13769f = Build.MODEL;
        aVar.f13775l = Locale.getDefault().toString();
        this.f8784e.f13776m = TimeZone.getDefault().getID();
        Context applicationContext = context.getApplicationContext();
        this.f8786g = applicationContext;
        C5056fa.C5057a aVar2 = this.f8784e;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
        File file = new File(C3145gz.m10326c(applicationContext), "deviceid");
        String string = sharedPreferences.getString(TapjoyConstants.PREF_ANALYTICS_ID, (String) null);
        if (C3166jq.m10436c(string)) {
            String b = file.exists() ? C3166jq.m10435b(C3124bg.m10224a(file)) : null;
            string = b == null ? UUID.randomUUID().toString() : b;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(TapjoyConstants.PREF_ANALYTICS_ID, string);
            edit.apply();
        }
        aVar2.f13767d = string;
        if (!C5106ga.m17239b().mo18532a(TapjoyConnectFlag.DISABLE_ANDROID_ID_AS_ANALYTICS_ID, true)) {
            C5056fa.C5057a aVar3 = this.f8784e;
            String string2 = Settings.Secure.getString(applicationContext.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
            aVar3.f13783t = !"9774d56d682e549c".equals(string2) ? C3166jq.m10435b(string2) : null;
        }
        PackageManager packageManager = applicationContext.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService(PlaceFields.PHONE);
        if (telephonyManager != null) {
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (!C3166jq.m10436c(simCountryIso)) {
                this.f8784e.f13780q = simCountryIso.toUpperCase(Locale.US);
            }
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!C3166jq.m10436c(networkCountryIso)) {
                this.f8784e.f13781r = networkCountryIso.toUpperCase(Locale.US);
            }
        }
        String packageName = applicationContext.getPackageName();
        C5056fa.C5057a aVar4 = this.f8784e;
        aVar4.f13777n = packageName;
        Signature[] e = C3176z.m10472e(packageManager, packageName);
        aVar4.f13778o = C3166jq.m10434a((e == null || e.length <= 0) ? null : Base64.encodeToString(C4937ch.m16776a(e[0].toByteArray()), 2));
        this.f8785f.f13652c = C3176z.m10468a(packageManager, packageName);
        this.f8785f.f13653d = Integer.valueOf(C3176z.m10469b(packageManager, packageName));
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (!C3166jq.m10436c(installerPackageName)) {
            this.f8785f.f13655f = installerPackageName;
        }
        String a = m10375a(packageManager, packageName);
        if (!C3166jq.m10436c(a)) {
            this.f8785f.f13656g = a;
        }
        mo18582a();
        this.f8783c = hjVar;
        String a2 = hjVar.f14115c.mo31485a();
        if (a2 != null && a2.length() > 0) {
            C5056fa.C5057a aVar5 = this.f8784e;
            aVar5.f13779p = a2 + " 12.6.0/Android";
        }
        String b2 = this.f8783c.mo31336b();
        if (b2 != null) {
            this.f8782b.f13891d = b2;
        }
        C5077fh.C5078a aVar6 = this.f8782b;
        C5159hj hjVar2 = this.f8783c;
        long j = hjVar2.f14114b.getLong("it", 0);
        if (j == 0) {
            Context context2 = hjVar2.f14113a;
            j = C3176z.m10470c(context2.getPackageManager(), context2.getPackageName());
            if (j == 0) {
                j = C3145gz.m10327d(hjVar2.f14113a).lastModified();
                if (j == 0) {
                    Context context3 = hjVar2.f14113a;
                    j = new File(C3176z.m10471d(context3.getPackageManager(), context3.getPackageName())).lastModified();
                    if (j == 0) {
                        j = System.currentTimeMillis();
                    }
                }
            }
            hjVar2.f14114b.edit().putLong("it", j).apply();
        }
        aVar6.f13890c = Long.valueOf(j);
        int b3 = this.f8783c.f14118f.mo31466b();
        this.f8782b.f13892e = Integer.valueOf(m10373a(7, b3));
        this.f8782b.f13893f = Integer.valueOf(m10373a(30, b3));
        int b4 = this.f8783c.f14120h.mo31466b();
        if (b4 > 0) {
            this.f8782b.f13895h = Integer.valueOf(b4);
        }
        long a3 = this.f8783c.f14121i.mo31479a();
        if (a3 > 0) {
            this.f8782b.f13896i = Long.valueOf(a3);
        }
        long a4 = this.f8783c.f14122j.mo31479a();
        if (a4 > 0) {
            this.f8782b.f13897j = Long.valueOf(a4);
        }
        long a5 = this.f8783c.f14123k.mo31479a();
        if (a5 > 0) {
            this.f8782b.f13898k = Long.valueOf(a5);
        }
        String a6 = this.f8783c.f14124l.mo31485a();
        if (a6 != null) {
            this.f8782b.f13899l = a6;
        }
        int b5 = this.f8783c.f14125m.mo31466b();
        if (b5 > 0) {
            this.f8782b.f13900m = Integer.valueOf(b5);
        }
        double a7 = this.f8783c.f14126n.mo31348a();
        if (a7 != 0.0d) {
            this.f8782b.f13901n = Double.valueOf(a7);
        }
        long a8 = this.f8783c.f14127o.mo31479a();
        if (a8 > 0) {
            this.f8782b.f13902o = Long.valueOf(a8);
        }
        double a9 = this.f8783c.f14128p.mo31348a();
        if (a9 != 0.0d) {
            this.f8782b.f13903p = Double.valueOf(a9);
        }
        String a10 = this.f8783c.f14119g.mo31485a();
        if (a10 != null) {
            try {
                byte[] decode = Base64.decode(a10, 2);
                this.f8782b.f13894g.clear();
                this.f8782b.f13894g.addAll(((C5071ff) C5071ff.f13840c.mo31105a(decode)).f13841d);
            } catch (IllegalArgumentException unused) {
                this.f8783c.f14119g.mo31483c();
            } catch (IOException unused2) {
                this.f8783c.f14119g.mo31483c();
            }
        }
        this.f8785f.f13654e = this.f8783c.f14129q.mo31485a();
        this.f8782b.f13906s = this.f8783c.f14130r.mo31485a();
        int intValue = this.f8783c.f14131s.mo31463a().intValue();
        this.f8782b.f13907t = intValue != -1 ? Integer.valueOf(intValue) : null;
        int intValue2 = this.f8783c.f14132t.mo31463a().intValue();
        this.f8782b.f13908u = intValue2 != -1 ? Integer.valueOf(intValue2) : null;
        this.f8782b.f13909v = this.f8783c.f14133u.mo31485a();
        this.f8782b.f13910w = this.f8783c.f14134v.mo31485a();
        this.f8782b.f13911x = this.f8783c.f14135w.mo31485a();
        this.f8782b.f13912y = this.f8783c.f14136x.mo31485a();
        this.f8782b.f13913z = this.f8783c.f14137y.mo31485a();
        String a11 = this.f8783c.f14138z.mo31485a();
        if (a11 != null) {
            try {
                byte[] decode2 = Base64.decode(a11, 2);
                this.f8782b.f13888A.clear();
                this.f8782b.f13888A.addAll(((C5074fg) C5074fg.f13843c.mo31105a(decode2)).f13844d);
            } catch (IllegalArgumentException unused3) {
                this.f8783c.f14138z.mo31483c();
            } catch (IOException unused4) {
                this.f8783c.f14138z.mo31483c();
            }
        }
        String a12 = this.f8783c.f14109A.mo31485a();
        boolean booleanValue = this.f8783c.f14110B.mo31320a().booleanValue();
        if (a12 != null) {
            C5077fh.C5078a aVar7 = this.f8782b;
            aVar7.f13904q = a12;
            aVar7.f13905r = Boolean.valueOf(booleanValue);
        } else {
            C5077fh.C5078a aVar8 = this.f8782b;
            aVar8.f13904q = null;
            aVar8.f13905r = null;
        }
        this.f8782b.f13889B = this.f8783c.f14111C.mo31320a();
    }

    /* renamed from: a */
    public static synchronized C3149hc m10374a(Context context) {
        C3149hc hcVar;
        synchronized (C3149hc.class) {
            if (f8781d == null) {
                f8781d = new C3149hc(context, C5159hj.m17376a(context));
            }
            hcVar = f8781d;
        }
        return hcVar;
    }

    /* renamed from: g */
    private void m10376g() {
        this.f8783c.f14119g.mo31486a(Base64.encodeToString(C5071ff.f13840c.mo31108b(new C5071ff(this.f8782b.f13894g)), 2));
    }

    /* renamed from: b */
    public final C5059fb mo18588b() {
        C5059fb fbVar;
        synchronized (this) {
            this.f8784e.f13775l = Locale.getDefault().toString();
            this.f8784e.f13776m = TimeZone.getDefault().getID();
            boolean z = false;
            long currentTimeMillis = System.currentTimeMillis() - 259200000;
            Iterator it = this.f8782b.f13894g.iterator();
            while (it.hasNext()) {
                if (((C5068fe) it.next()).f13835g.longValue() <= currentTimeMillis) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                m10376g();
            }
            fbVar = new C5059fb(this.f8784e.mo31212b(), this.f8785f.mo31197b(), this.f8782b.mo31234b());
        }
        return fbVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final String mo18591c() {
        String a;
        synchronized (this) {
            a = this.f8783c.f14116d.mo31485a();
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00dc  */
    @javax.annotation.Nullable
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tapjoy.internal.C5062fc mo18593d() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x0141 }
            r2 = 1
            int r3 = r0.get(r2)     // Catch:{ all -> 0x0141 }
            int r3 = r3 * 10000
            r4 = 2
            int r5 = r0.get(r4)     // Catch:{ all -> 0x0141 }
            int r5 = r5 * 100
            int r3 = r3 + r5
            int r3 = r3 + 100
            r5 = 5
            int r6 = r0.get(r5)     // Catch:{ all -> 0x0141 }
            int r3 = r3 + r6
            com.tapjoy.internal.hj r6 = r1.f8783c     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.k r6 = r6.f14117e     // Catch:{ all -> 0x0141 }
            java.lang.Integer r6 = r6.mo31463a()     // Catch:{ all -> 0x0141 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0141 }
            r7 = 0
            if (r6 == r3) goto L_0x013f
            if (r6 != 0) goto L_0x004a
            com.tapjoy.internal.fh$a r0 = r1.f8782b     // Catch:{ all -> 0x0141 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0141 }
            r0.f13892e = r4     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fh$a r0 = r1.f8782b     // Catch:{ all -> 0x0141 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0141 }
            r0.f13893f = r4     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fc r0 = new com.tapjoy.internal.fc     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = "fq7_0_1"
            java.lang.String r5 = "fq30_0_1"
            r0.<init>(r4, r5, r7)     // Catch:{ all -> 0x0141 }
            goto L_0x012f
        L_0x004a:
            com.tapjoy.internal.hj r8 = r1.f8783c     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.k r8 = r8.f14118f     // Catch:{ all -> 0x0141 }
            java.lang.Integer r8 = r8.mo31463a()     // Catch:{ all -> 0x0141 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0141 }
            r9 = 7
            int r10 = m10373a((int) r9, (int) r8)     // Catch:{ all -> 0x0141 }
            r11 = 30
            int r12 = m10373a((int) r11, (int) r8)     // Catch:{ all -> 0x0141 }
            java.util.Calendar r13 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x0141 }
            int r14 = r6 / 10000
            int r15 = r6 / 100
            int r15 = r15 % 100
            int r15 = r15 - r2
            int r6 = r6 % 100
            r13.set(r14, r15, r6)     // Catch:{ all -> 0x0141 }
            int r6 = r0.get(r2)     // Catch:{ all -> 0x0141 }
            int r14 = r13.get(r2)     // Catch:{ all -> 0x0141 }
            int r6 = r6 - r14
            int r6 = java.lang.Integer.signum(r6)     // Catch:{ all -> 0x0141 }
            r14 = -1
            if (r6 == r14) goto L_0x00a8
            if (r6 == r2) goto L_0x008e
            r4 = 6
            int r0 = r0.get(r4)     // Catch:{ all -> 0x0141 }
            int r4 = r13.get(r4)     // Catch:{ all -> 0x0141 }
            int r0 = r0 - r4
            goto L_0x00d4
        L_0x008e:
            java.lang.Object r14 = r0.clone()     // Catch:{ all -> 0x0141 }
            java.util.Calendar r14 = (java.util.Calendar) r14     // Catch:{ all -> 0x0141 }
            int r15 = r13.get(r2)     // Catch:{ all -> 0x0141 }
            int r4 = r13.get(r4)     // Catch:{ all -> 0x0141 }
            int r13 = r13.get(r5)     // Catch:{ all -> 0x0141 }
            r14.set(r15, r4, r13)     // Catch:{ all -> 0x0141 }
            long r16 = r0.getTimeInMillis()     // Catch:{ all -> 0x0141 }
            goto L_0x00c1
        L_0x00a8:
            java.lang.Object r14 = r13.clone()     // Catch:{ all -> 0x0141 }
            java.util.Calendar r14 = (java.util.Calendar) r14     // Catch:{ all -> 0x0141 }
            int r15 = r0.get(r2)     // Catch:{ all -> 0x0141 }
            int r4 = r0.get(r4)     // Catch:{ all -> 0x0141 }
            int r0 = r0.get(r5)     // Catch:{ all -> 0x0141 }
            r14.set(r15, r4, r0)     // Catch:{ all -> 0x0141 }
            long r16 = r13.getTimeInMillis()     // Catch:{ all -> 0x0141 }
        L_0x00c1:
            r0 = 0
        L_0x00c2:
            long r18 = r14.getTimeInMillis()     // Catch:{ all -> 0x0141 }
            int r4 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r4 >= 0) goto L_0x00d0
            r14.add(r5, r2)     // Catch:{ all -> 0x0141 }
            int r0 = r0 + 1
            goto L_0x00c2
        L_0x00d0:
            if (r6 <= 0) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            int r0 = -r0
        L_0x00d4:
            int r4 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x0141 }
            if (r4 < r11) goto L_0x00dc
            r15 = 0
            goto L_0x00e4
        L_0x00dc:
            if (r0 < 0) goto L_0x00e1
            int r15 = r8 << r0
            goto L_0x00e4
        L_0x00e1:
            int r0 = -r0
            int r15 = r8 >> r0
        L_0x00e4:
            r2 = r2 | r15
            int r0 = m10373a((int) r9, (int) r2)     // Catch:{ all -> 0x0141 }
            int r4 = m10373a((int) r11, (int) r2)     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fh$a r5 = r1.f8782b     // Catch:{ all -> 0x0141 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0141 }
            r5.f13892e = r6     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fh$a r5 = r1.f8782b     // Catch:{ all -> 0x0141 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0141 }
            r5.f13893f = r6     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.fc r5 = new com.tapjoy.internal.fc     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            java.lang.String r8 = "fq7_"
            r6.<init>(r8)     // Catch:{ all -> 0x0141 }
            r6.append(r10)     // Catch:{ all -> 0x0141 }
            java.lang.String r8 = "_"
            r6.append(r8)     // Catch:{ all -> 0x0141 }
            r6.append(r0)     // Catch:{ all -> 0x0141 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            java.lang.String r8 = "fq30_"
            r6.<init>(r8)     // Catch:{ all -> 0x0141 }
            r6.append(r12)     // Catch:{ all -> 0x0141 }
            java.lang.String r8 = "_"
            r6.append(r8)     // Catch:{ all -> 0x0141 }
            r6.append(r4)     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0141 }
            r5.<init>(r0, r4, r7)     // Catch:{ all -> 0x0141 }
            r0 = r5
        L_0x012f:
            com.tapjoy.internal.hj r4 = r1.f8783c     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.k r4 = r4.f14117e     // Catch:{ all -> 0x0141 }
            r4.mo31464a((int) r3)     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.hj r3 = r1.f8783c     // Catch:{ all -> 0x0141 }
            com.tapjoy.internal.k r3 = r3.f14118f     // Catch:{ all -> 0x0141 }
            r3.mo31464a((int) r2)     // Catch:{ all -> 0x0141 }
            monitor-exit(r20)     // Catch:{ all -> 0x0141 }
            return r0
        L_0x013f:
            monitor-exit(r20)     // Catch:{ all -> 0x0141 }
            return r7
        L_0x0141:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x0141 }
            goto L_0x0145
        L_0x0144:
            throw r0
        L_0x0145:
            goto L_0x0144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3149hc.mo18593d():com.tapjoy.internal.fc");
    }

    /* renamed from: e */
    public final Set mo18594e() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f8782b.f13888A);
        }
        return hashSet;
    }

    /* renamed from: f */
    public final boolean mo18595f() {
        return ((Boolean) C3165jo.m10433b(this.f8782b.f13889B, C5077fh.f13861r)).booleanValue();
    }

    /* renamed from: a */
    private static String m10375a(PackageManager packageManager, String str) {
        Object obj;
        try {
            Bundle bundle = packageManager.getApplicationInfo(str, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData;
            if (bundle == null || (obj = bundle.get("com.tapjoy.appstore")) == null) {
                return null;
            }
            return obj.toString().trim();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public final boolean mo18592c(String str) {
        synchronized (this) {
            for (int size = this.f8782b.f13894g.size() - 1; size >= 0; size--) {
                C5068fe feVar = (C5068fe) this.f8782b.f13894g.get(size);
                if (feVar.f13834f.equals(str)) {
                    C5068fe.C5069a b = feVar.mo31222b();
                    b.f13839e = Long.valueOf(System.currentTimeMillis());
                    this.f8782b.f13894g.set(size, b.mo31225b());
                    m10376g();
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0057 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo18582a() {
        /*
            r4 = this;
            monitor-enter(r4)
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x0057 }
            android.content.Context r1 = r4.f8786g     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = "window"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x0057 }
            android.view.WindowManager r1 = (android.view.WindowManager) r1     // Catch:{ Exception -> 0x0057 }
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ Exception -> 0x0057 }
            r1.getMetrics(r0)     // Catch:{ Exception -> 0x0057 }
            android.app.Activity r1 = com.tapjoy.internal.C5129gr.m17302a()     // Catch:{ Exception -> 0x0057 }
            if (r1 == 0) goto L_0x0036
            android.view.Window r1 = r1.getWindow()     // Catch:{ Exception -> 0x0057 }
            if (r1 == 0) goto L_0x0036
            int r2 = r0.heightPixels     // Catch:{ Exception -> 0x0057 }
            android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ Exception -> 0x0057 }
            r3.<init>()     // Catch:{ Exception -> 0x0057 }
            android.view.View r1 = r1.getDecorView()     // Catch:{ Exception -> 0x0057 }
            r1.getWindowVisibleDisplayFrame(r3)     // Catch:{ Exception -> 0x0057 }
            int r1 = r3.top     // Catch:{ Exception -> 0x0057 }
            int r2 = r2 - r1
            r0.heightPixels = r2     // Catch:{ Exception -> 0x0057 }
        L_0x0036:
            com.tapjoy.internal.fa$a r1 = r4.f8784e     // Catch:{ Exception -> 0x0057 }
            int r2 = r0.densityDpi     // Catch:{ Exception -> 0x0057 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0057 }
            r1.f13772i = r2     // Catch:{ Exception -> 0x0057 }
            com.tapjoy.internal.fa$a r1 = r4.f8784e     // Catch:{ Exception -> 0x0057 }
            int r2 = r0.widthPixels     // Catch:{ Exception -> 0x0057 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0057 }
            r1.f13773j = r2     // Catch:{ Exception -> 0x0057 }
            com.tapjoy.internal.fa$a r1 = r4.f8784e     // Catch:{ Exception -> 0x0057 }
            int r0 = r0.heightPixels     // Catch:{ Exception -> 0x0057 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0057 }
            r1.f13774k = r0     // Catch:{ Exception -> 0x0057 }
            goto L_0x0057
        L_0x0055:
            r0 = move-exception
            goto L_0x0059
        L_0x0057:
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            return
        L_0x0059:
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3149hc.mo18582a():void");
    }

    /* renamed from: b */
    public final boolean mo18590b(String str) {
        boolean z;
        synchronized (this) {
            this.f8783c.f14130r.mo31486a(str);
            z = !C3165jo.m10432a(this.f8782b.f13906s, str);
            if (z) {
                this.f8782b.f13906s = str;
            }
        }
        return z;
    }

    /* renamed from: b */
    public final boolean mo18589b(Integer num) {
        boolean z;
        synchronized (this) {
            this.f8783c.f14132t.mo31465a(num);
            z = !C3165jo.m10432a(this.f8782b.f13908u, num);
            if (z) {
                this.f8782b.f13908u = num;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static int m10373a(int i, int i2) {
        return Integer.bitCount(((1 << i) - 1) & i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo18586a(String str, long j, boolean z) {
        synchronized (this) {
            int size = this.f8782b.f13894g.size();
            int i = 0;
            while (i < size) {
                C5068fe feVar = (C5068fe) this.f8782b.f13894g.get(i);
                if (!feVar.f13834f.equals(str)) {
                    i++;
                } else if (!z) {
                    return false;
                } else {
                    C5068fe.C5069a b = feVar.mo31222b();
                    b.f13838d = Long.valueOf(j);
                    this.f8782b.f13894g.set(i, b.mo31225b());
                    return true;
                }
            }
            this.f8782b.f13894g.add(new C5068fe(str, Long.valueOf(j)));
            m10376g();
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo18585a(String str) {
        boolean z;
        synchronized (this) {
            this.f8783c.f14129q.mo31486a(str);
            z = true;
            if (str != null) {
                if (C3165jo.m10432a(this.f8785f.f13654e, str)) {
                    z = false;
                }
                this.f8785f.f13654e = str;
            } else {
                if (this.f8785f.f13654e == null) {
                    z = false;
                }
                this.f8785f.f13654e = null;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo18584a(Integer num) {
        boolean z;
        synchronized (this) {
            this.f8783c.f14131s.mo31465a(num);
            z = !C3165jo.m10432a(this.f8782b.f13907t, num);
            if (z) {
                this.f8782b.f13907t = num;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo18583a(int i, String str) {
        boolean z;
        synchronized (this) {
            z = false;
            if (i == 1) {
                this.f8783c.f14133u.mo31486a(str);
                z = !C3165jo.m10432a(this.f8782b.f13909v, str);
                if (z) {
                    this.f8782b.f13909v = str;
                }
            } else if (i == 2) {
                this.f8783c.f14134v.mo31486a(str);
                z = !C3165jo.m10432a(this.f8782b.f13910w, str);
                if (z) {
                    this.f8782b.f13910w = str;
                }
            } else if (i == 3) {
                this.f8783c.f14135w.mo31486a(str);
                z = !C3165jo.m10432a(this.f8782b.f13911x, str);
                if (z) {
                    this.f8782b.f13911x = str;
                }
            } else if (i == 4) {
                this.f8783c.f14136x.mo31486a(str);
                z = !C3165jo.m10432a(this.f8782b.f13912y, str);
                if (z) {
                    this.f8782b.f13912y = str;
                }
            } else if (i == 5) {
                this.f8783c.f14137y.mo31486a(str);
                z = !C3165jo.m10432a(this.f8782b.f13913z, str);
                if (z) {
                    this.f8782b.f13913z = str;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo18587a(boolean z) {
        boolean z2;
        synchronized (this) {
            this.f8783c.f14111C.mo31321a(z);
            z2 = z != ((Boolean) C3165jo.m10433b(this.f8782b.f13889B, C5077fh.f13861r)).booleanValue();
            this.f8782b.f13889B = Boolean.valueOf(z);
        }
        return z2;
    }
}
