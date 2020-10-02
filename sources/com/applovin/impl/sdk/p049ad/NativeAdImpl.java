package com.applovin.impl.sdk.p049ad;

import android.content.Context;
import android.net.Uri;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.network.C1968f;
import com.applovin.impl.sdk.p051c.C1846a;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.ad.NativeAdImpl */
public class NativeAdImpl implements C1835j, AppLovinNativeAd {
    public static final String QUERY_PARAM_IS_FIRST_PLAY = "fp";
    public static final String QUERY_PARAM_VIDEO_PERCENT_VIEWED = "pv";

    /* renamed from: a */
    private final C1941j f5602a;

    /* renamed from: b */
    private final C1821d f5603b;

    /* renamed from: c */
    private final String f5604c;

    /* renamed from: d */
    private final String f5605d;

    /* renamed from: e */
    private final String f5606e;

    /* renamed from: f */
    private final String f5607f;

    /* renamed from: g */
    private final String f5608g;

    /* renamed from: h */
    private final String f5609h;

    /* renamed from: i */
    private final String f5610i;

    /* renamed from: j */
    private final String f5611j;

    /* renamed from: k */
    private final String f5612k;

    /* renamed from: l */
    private final String f5613l;

    /* renamed from: m */
    private final String f5614m;

    /* renamed from: n */
    private final String f5615n;

    /* renamed from: o */
    private final List<C1846a> f5616o;

    /* renamed from: p */
    private final List<C1846a> f5617p;

    /* renamed from: q */
    private final String f5618q;

    /* renamed from: r */
    private final long f5619r;

    /* renamed from: s */
    private final List<String> f5620s;

    /* renamed from: t */
    private String f5621t;

    /* renamed from: u */
    private String f5622u;

    /* renamed from: v */
    private float f5623v;

    /* renamed from: w */
    private String f5624w;

    /* renamed from: x */
    private AtomicBoolean f5625x;

    /* renamed from: com.applovin.impl.sdk.ad.NativeAdImpl$a */
    public static class C1816a {

        /* renamed from: a */
        private C1821d f5626a;

        /* renamed from: b */
        private String f5627b;

        /* renamed from: c */
        private String f5628c;

        /* renamed from: d */
        private String f5629d;

        /* renamed from: e */
        private String f5630e;

        /* renamed from: f */
        private String f5631f;

        /* renamed from: g */
        private String f5632g;

        /* renamed from: h */
        private String f5633h;

        /* renamed from: i */
        private String f5634i;

        /* renamed from: j */
        private String f5635j;

        /* renamed from: k */
        private float f5636k;

        /* renamed from: l */
        private String f5637l;

        /* renamed from: m */
        private String f5638m;

        /* renamed from: n */
        private String f5639n;

        /* renamed from: o */
        private String f5640o;

        /* renamed from: p */
        private String f5641p;

        /* renamed from: q */
        private List<C1846a> f5642q;

        /* renamed from: r */
        private List<C1846a> f5643r;

        /* renamed from: s */
        private String f5644s;

        /* renamed from: t */
        private String f5645t;

        /* renamed from: u */
        private long f5646u;

        /* renamed from: v */
        private List<String> f5647v;

        /* renamed from: w */
        private C1941j f5648w;

        /* renamed from: a */
        public C1816a mo8134a(float f) {
            this.f5636k = f;
            return this;
        }

        /* renamed from: a */
        public C1816a mo8135a(long j) {
            this.f5646u = j;
            return this;
        }

        /* renamed from: a */
        public C1816a mo8136a(C1821d dVar) {
            this.f5626a = dVar;
            return this;
        }

        /* renamed from: a */
        public C1816a mo8137a(C1941j jVar) {
            this.f5648w = jVar;
            return this;
        }

        /* renamed from: a */
        public C1816a mo8138a(String str) {
            this.f5627b = str;
            return this;
        }

        /* renamed from: a */
        public C1816a mo8139a(List<C1846a> list) {
            this.f5642q = list;
            return this;
        }

        /* renamed from: a */
        public NativeAdImpl mo8140a() {
            return new NativeAdImpl(this.f5626a, this.f5627b, this.f5628c, this.f5629d, this.f5630e, this.f5631f, this.f5632g, this.f5633h, this.f5634i, this.f5635j, this.f5636k, this.f5637l, this.f5638m, this.f5639n, this.f5640o, this.f5641p, this.f5642q, this.f5643r, this.f5644s, this.f5645t, this.f5646u, this.f5647v, this.f5648w);
        }

        /* renamed from: b */
        public C1816a mo8141b(String str) {
            this.f5628c = str;
            return this;
        }

        /* renamed from: b */
        public C1816a mo8142b(List<C1846a> list) {
            this.f5643r = list;
            return this;
        }

        /* renamed from: c */
        public C1816a mo8143c(String str) {
            this.f5629d = str;
            return this;
        }

        /* renamed from: c */
        public C1816a mo8144c(List<String> list) {
            this.f5647v = list;
            return this;
        }

        /* renamed from: d */
        public C1816a mo8145d(String str) {
            this.f5630e = str;
            return this;
        }

        /* renamed from: e */
        public C1816a mo8146e(String str) {
            this.f5631f = str;
            return this;
        }

        /* renamed from: f */
        public C1816a mo8147f(String str) {
            this.f5632g = str;
            return this;
        }

        /* renamed from: g */
        public C1816a mo8148g(String str) {
            this.f5633h = str;
            return this;
        }

        /* renamed from: h */
        public C1816a mo8149h(String str) {
            this.f5634i = str;
            return this;
        }

        /* renamed from: i */
        public C1816a mo8150i(String str) {
            this.f5635j = str;
            return this;
        }

        /* renamed from: j */
        public C1816a mo8151j(String str) {
            this.f5637l = str;
            return this;
        }

        /* renamed from: k */
        public C1816a mo8152k(String str) {
            this.f5638m = str;
            return this;
        }

        /* renamed from: l */
        public C1816a mo8153l(String str) {
            this.f5639n = str;
            return this;
        }

        /* renamed from: m */
        public C1816a mo8154m(String str) {
            this.f5640o = str;
            return this;
        }

        /* renamed from: n */
        public C1816a mo8155n(String str) {
            this.f5641p = str;
            return this;
        }

        /* renamed from: o */
        public C1816a mo8156o(String str) {
            this.f5644s = str;
            return this;
        }

        /* renamed from: p */
        public C1816a mo8157p(String str) {
            this.f5645t = str;
            return this;
        }
    }

    private NativeAdImpl(C1821d dVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, float f, String str10, String str11, String str12, String str13, String str14, List<C1846a> list, List<C1846a> list2, String str15, String str16, long j, List<String> list3, C1941j jVar) {
        this.f5625x = new AtomicBoolean();
        this.f5603b = dVar;
        this.f5604c = str;
        this.f5605d = str2;
        this.f5606e = str3;
        this.f5607f = str4;
        this.f5608g = str5;
        this.f5609h = str6;
        this.f5610i = str7;
        this.f5621t = str8;
        this.f5622u = str9;
        this.f5623v = f;
        this.f5624w = str10;
        this.f5612k = str11;
        this.f5613l = str12;
        this.f5614m = str13;
        this.f5615n = str14;
        this.f5616o = list;
        this.f5617p = list2;
        this.f5618q = str15;
        this.f5611j = str16;
        this.f5619r = j;
        this.f5620s = list3;
        this.f5602a = jVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NativeAdImpl.class != obj.getClass()) {
            return false;
        }
        NativeAdImpl nativeAdImpl = (NativeAdImpl) obj;
        C1821d dVar = this.f5603b;
        if (dVar == null ? nativeAdImpl.f5603b != null : !dVar.equals(nativeAdImpl.f5603b)) {
            return false;
        }
        String str = this.f5610i;
        if (str == null ? nativeAdImpl.f5610i != null : !str.equals(nativeAdImpl.f5610i)) {
            return false;
        }
        String str2 = this.f5618q;
        if (str2 == null ? nativeAdImpl.f5618q != null : !str2.equals(nativeAdImpl.f5618q)) {
            return false;
        }
        String str3 = this.f5612k;
        if (str3 == null ? nativeAdImpl.f5612k != null : !str3.equals(nativeAdImpl.f5612k)) {
            return false;
        }
        String str4 = this.f5611j;
        if (str4 == null ? nativeAdImpl.f5611j != null : !str4.equals(nativeAdImpl.f5611j)) {
            return false;
        }
        String str5 = this.f5609h;
        if (str5 == null ? nativeAdImpl.f5609h != null : !str5.equals(nativeAdImpl.f5609h)) {
            return false;
        }
        String str6 = this.f5613l;
        if (str6 == null ? nativeAdImpl.f5613l != null : !str6.equals(nativeAdImpl.f5613l)) {
            return false;
        }
        String str7 = this.f5604c;
        if (str7 == null ? nativeAdImpl.f5604c != null : !str7.equals(nativeAdImpl.f5604c)) {
            return false;
        }
        String str8 = this.f5605d;
        if (str8 == null ? nativeAdImpl.f5605d != null : !str8.equals(nativeAdImpl.f5605d)) {
            return false;
        }
        String str9 = this.f5606e;
        if (str9 == null ? nativeAdImpl.f5606e != null : !str9.equals(nativeAdImpl.f5606e)) {
            return false;
        }
        String str10 = this.f5607f;
        if (str10 == null ? nativeAdImpl.f5607f != null : !str10.equals(nativeAdImpl.f5607f)) {
            return false;
        }
        String str11 = this.f5608g;
        if (str11 == null ? nativeAdImpl.f5608g != null : !str11.equals(nativeAdImpl.f5608g)) {
            return false;
        }
        String str12 = this.f5615n;
        if (str12 == null ? nativeAdImpl.f5615n != null : !str12.equals(nativeAdImpl.f5615n)) {
            return false;
        }
        String str13 = this.f5614m;
        if (str13 == null ? nativeAdImpl.f5614m != null : !str13.equals(nativeAdImpl.f5614m)) {
            return false;
        }
        List<C1846a> list = this.f5616o;
        if (list == null ? nativeAdImpl.f5616o != null : !list.equals(nativeAdImpl.f5616o)) {
            return false;
        }
        List<C1846a> list2 = this.f5617p;
        if (list2 == null ? nativeAdImpl.f5617p != null : !list2.equals(nativeAdImpl.f5617p)) {
            return false;
        }
        List<String> list3 = this.f5620s;
        List<String> list4 = nativeAdImpl.f5620s;
        return list3 == null ? list4 == null : list3.equals(list4);
    }

    public long getAdId() {
        return this.f5619r;
    }

    public C1821d getAdZone() {
        return this.f5603b;
    }

    public String getCaptionText() {
        return this.f5610i;
    }

    public String getClCode() {
        return this.f5618q;
    }

    public String getCtaText() {
        return this.f5611j;
    }

    public String getDescriptionText() {
        return this.f5609h;
    }

    public String getIconUrl() {
        return this.f5621t;
    }

    public String getImageUrl() {
        return this.f5622u;
    }

    public List<String> getResourcePrefixes() {
        return this.f5620s;
    }

    public String getSourceIconUrl() {
        return this.f5604c;
    }

    public String getSourceImageUrl() {
        return this.f5605d;
    }

    public String getSourceStarRatingImageUrl() {
        return this.f5606e;
    }

    public String getSourceVideoUrl() {
        return this.f5607f;
    }

    public float getStarRating() {
        return this.f5623v;
    }

    public String getTitle() {
        return this.f5608g;
    }

    public String getVideoEndTrackingUrl(int i, boolean z) {
        Uri build;
        if (this.f5615n == null) {
            build = Uri.EMPTY;
        } else {
            if (i < 0 || i > 100) {
                C1977q.m7747c("AppLovinNativeAd", "Invalid percent viewed supplied.", new IllegalArgumentException("Percent viewed must be an integer between 0 and 100."));
            }
            build = Uri.parse(this.f5615n).buildUpon().appendQueryParameter(QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter("fp", Boolean.toString(z)).build();
        }
        return build.toString();
    }

    public String getVideoStartTrackingUrl() {
        return this.f5614m;
    }

    public String getVideoUrl() {
        return this.f5624w;
    }

    public String getZoneId() {
        return "";
    }

    public int hashCode() {
        String str = this.f5604c;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f5605d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f5606e;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f5607f;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f5608g;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f5609h;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f5610i;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f5611j;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f5612k;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.f5613l;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.f5614m;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.f5615n;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        List<C1846a> list = this.f5616o;
        int hashCode13 = (hashCode12 + (list != null ? list.hashCode() : 0)) * 31;
        List<C1846a> list2 = this.f5617p;
        int hashCode14 = (hashCode13 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str13 = this.f5618q;
        int hashCode15 = (hashCode14 + (str13 != null ? str13.hashCode() : 0)) * 31;
        C1821d dVar = this.f5603b;
        int hashCode16 = (hashCode15 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        List<String> list3 = this.f5620s;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode16 + i;
    }

    public boolean isImagePrecached() {
        String str = this.f5621t;
        boolean z = str != null && !str.equals(this.f5604c);
        String str2 = this.f5622u;
        return z && (str2 != null && !str2.equals(this.f5605d));
    }

    public boolean isVideoPrecached() {
        String str = this.f5624w;
        return str != null && !str.equals(this.f5607f);
    }

    public void launchClickTarget(Context context) {
        for (C1846a next : this.f5617p) {
            this.f5602a.mo8535N().mo8678a(C1968f.m7656m().mo8703c(next.mo8340a()).mo8705d(next.mo8341b()).mo8699a(false).mo8700a());
        }
        C2029r.m8016a(context, Uri.parse(this.f5612k), this.f5602a);
    }

    public void setIconUrl(String str) {
        this.f5621t = str;
    }

    public void setImageUrl(String str) {
        this.f5622u = str;
    }

    public void setStarRating(float f) {
        this.f5623v = f;
    }

    public void setVideoUrl(String str) {
        this.f5624w = str;
    }

    public String toString() {
        return "AppLovinNativeAd{clCode='" + this.f5618q + '\'' + ", adZone='" + this.f5603b + '\'' + ", sourceIconUrl='" + this.f5604c + '\'' + ", sourceImageUrl='" + this.f5605d + '\'' + ", sourceStarRatingImageUrl='" + this.f5606e + '\'' + ", sourceVideoUrl='" + this.f5607f + '\'' + ", title='" + this.f5608g + '\'' + ", descriptionText='" + this.f5609h + '\'' + ", captionText='" + this.f5610i + '\'' + ", ctaText='" + this.f5611j + '\'' + ", iconUrl='" + this.f5621t + '\'' + ", imageUrl='" + this.f5622u + '\'' + ", starRating='" + this.f5623v + '\'' + ", videoUrl='" + this.f5624w + '\'' + ", clickUrl='" + this.f5612k + '\'' + ", impressionTrackingUrl='" + this.f5613l + '\'' + ", videoStartTrackingUrl='" + this.f5614m + '\'' + ", videoEndTrackingUrl='" + this.f5615n + '\'' + ", impressionPostbacks=" + this.f5616o + '\'' + ", clickTrackingPostbacks=" + this.f5617p + '\'' + ", resourcePrefixes=" + this.f5620s + '}';
    }

    public void trackImpression() {
        trackImpression((AppLovinPostbackListener) null);
    }

    public void trackImpression(AppLovinPostbackListener appLovinPostbackListener) {
        if (!this.f5625x.getAndSet(true)) {
            this.f5602a.mo8602v().mo8742b("AppLovinNativeAd", "Tracking impression...");
            for (C1846a next : this.f5616o) {
                this.f5602a.mo8535N().mo8680a(C1968f.m7656m().mo8703c(next.mo8340a()).mo8705d(next.mo8341b()).mo8699a(false).mo8700a(), true, appLovinPostbackListener);
            }
        } else if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(this.f5613l, AppLovinErrorCodes.NATIVE_AD_IMPRESSION_ALREADY_TRACKED);
        }
    }
}
