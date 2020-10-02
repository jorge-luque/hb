package com.criteo.publisher.model;

import android.util.Log;
import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p054a0.C2323c;
import com.criteo.publisher.p054a0.C2338m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.criteo.publisher.model.f */
public class C2440f {

    /* renamed from: c */
    private static final String f7875c = "f";

    /* renamed from: a */
    private final C2323c f7876a;

    /* renamed from: b */
    private final C2338m f7877b;

    /* renamed from: com.criteo.publisher.model.f$a */
    static /* synthetic */ class C2441a {

        /* renamed from: a */
        static final /* synthetic */ int[] f7878a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.criteo.publisher.a0.a[] r0 = com.criteo.publisher.p054a0.C2321a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7878a = r0
                com.criteo.publisher.a0.a r1 = com.criteo.publisher.p054a0.C2321a.CRITEO_BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7878a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.criteo.publisher.a0.a r1 = com.criteo.publisher.p054a0.C2321a.CRITEO_INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7878a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.criteo.publisher.a0.a r1 = com.criteo.publisher.p054a0.C2321a.CRITEO_CUSTOM_NATIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.model.C2440f.C2441a.<clinit>():void");
        }
    }

    public C2440f(C2323c cVar, C2338m mVar) {
        this.f7876a = cVar;
        this.f7877b = mVar;
    }

    /* renamed from: a */
    public List<List<C2450k>> mo10354a(List<AdUnit> list) {
        HashSet hashSet = new HashSet();
        for (AdUnit next : list) {
            if (next != null) {
                int i = C2441a.f7878a[next.getAdUnitType().ordinal()];
                if (i == 1) {
                    BannerAdUnit bannerAdUnit = (BannerAdUnit) next;
                    hashSet.add(new C2450k(bannerAdUnit.getSize(), bannerAdUnit.getAdUnitId(), C2321a.CRITEO_BANNER));
                } else if (i == 2) {
                    hashSet.add(m9246a(((InterstitialAdUnit) next).getAdUnitId()));
                } else if (i == 3) {
                    NativeAdUnit nativeAdUnit = (NativeAdUnit) next;
                    hashSet.add(new C2450k(nativeAdUnit.getAdSize(), nativeAdUnit.getAdUnitId(), C2321a.CRITEO_CUSTOM_NATIVE));
                } else {
                    throw new IllegalArgumentException("Found an invalid AdUnit");
                }
            }
        }
        return m9248a(m9247a((Collection<C2450k>) hashSet), 8);
    }

    /* renamed from: a */
    public C2450k mo10353a(AdUnit adUnit) {
        List<List<C2450k>> a = mo10354a((List<AdUnit>) Collections.singletonList(adUnit));
        if (a.isEmpty() || a.get(0).isEmpty()) {
            return null;
        }
        return (C2450k) a.get(0).get(0);
    }

    /* renamed from: a */
    private C2450k m9246a(String str) {
        if (this.f7876a.mo10117a() == 1) {
            return new C2450k(this.f7877b.mo10158d(), str, C2321a.CRITEO_INTERSTITIAL);
        }
        return new C2450k(this.f7877b.mo10157c(), str, C2321a.CRITEO_INTERSTITIAL);
    }

    /* renamed from: a */
    private List<C2450k> m9247a(Collection<C2450k> collection) {
        ArrayList arrayList = new ArrayList();
        for (C2450k next : collection) {
            if (next.mo10366b() == null || next.mo10366b().isEmpty() || next.mo10367c() == null || next.mo10367c().getWidth() <= 0 || next.mo10367c().getHeight() <= 0) {
                String str = f7875c;
                Log.e(str, "Found an invalid AdUnit: " + next);
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static <T> List<List<T>> m9248a(List<T> list, int i) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + i;
            arrayList.add(list.subList(i2, Math.min(i3, list.size())));
            i2 = i3;
        }
        return arrayList;
    }
}
