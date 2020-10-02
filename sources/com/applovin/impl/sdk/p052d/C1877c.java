package com.applovin.impl.sdk.p052d;

import android.net.Uri;
import com.applovin.impl.mediation.C1779k;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1973o;
import com.applovin.impl.sdk.network.C1956a;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1854d;
import com.applovin.impl.sdk.p051c.C1855e;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.loopj.android.http.C4250c;
import com.vungle.warren.analytics.AnalyticsEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

/* renamed from: com.applovin.impl.sdk.d.c */
abstract class C1877c extends C1864a implements C1779k.C1780a {

    /* renamed from: a */
    protected final C1827g f6232a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AppLovinAdLoadListener f6233c;

    /* renamed from: d */
    private final C1973o f6234d;

    /* renamed from: e */
    private final Collection<Character> f6235e;

    /* renamed from: f */
    private final C1855e f6236f;

    /* renamed from: g */
    private boolean f6237g;

    C1877c(String str, C1827g gVar, C1941j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, jVar);
        if (gVar != null) {
            this.f6232a = gVar;
            this.f6233c = appLovinAdLoadListener;
            this.f6234d = jVar.mo8543V();
            this.f6235e = m7243j();
            this.f6236f = new C1855e();
            return;
        }
        throw new IllegalArgumentException("No ad specified.");
    }

    /* renamed from: a */
    private Uri m7238a(Uri uri, String str) {
        String str2;
        StringBuilder sb;
        if (uri != null) {
            String uri2 = uri.toString();
            if (C2025o.m7963b(uri2)) {
                mo8405a("Caching " + str + " image...");
                return m7242g(uri2);
            }
            sb = new StringBuilder();
            sb.append("Failed to cache ");
            sb.append(str);
            str2 = " image";
        } else {
            sb = new StringBuilder();
            sb.append("No ");
            sb.append(str);
            str2 = " image to cache";
        }
        sb.append(str2);
        mo8405a(sb.toString());
        return null;
    }

    /* renamed from: a */
    private Uri m7239a(String str, String str2) {
        StringBuilder sb;
        String replace = str2.replace("/", C6120b.ROLL_OVER_FILE_NAME_SEPARATOR);
        String L = this.f6232a.mo8212L();
        if (C2025o.m7963b(L)) {
            replace = L + replace;
        }
        File a = this.f6234d.mo8723a(replace, this.f6217b.mo8527E());
        if (a == null) {
            return null;
        }
        if (a.exists()) {
            this.f6236f.mo8372b(a.length());
            sb = new StringBuilder();
        } else {
            if (!this.f6234d.mo8728a(a, str + str2, Arrays.asList(new String[]{str}), this.f6236f)) {
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append("file://");
        sb.append(a.getAbsolutePath());
        return Uri.parse(sb.toString());
    }

    /* renamed from: g */
    private Uri m7242g(String str) {
        return mo8432b(str, this.f6232a.mo8211K(), true);
    }

    /* renamed from: j */
    private Collection<Character> m7243j() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.f6217b.mo8549a(C1841c.f5856bC)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Uri mo8427a(String str, List<String> list, boolean z) {
        String str2;
        if (!C2025o.m7963b(str)) {
            return null;
        }
        mo8405a("Caching video " + str + "...");
        String a = this.f6234d.mo8724a(mo8412f(), str, this.f6232a.mo8212L(), list, z, this.f6236f);
        if (C2025o.m7963b(a)) {
            File a2 = this.f6234d.mo8723a(a, mo8412f());
            if (a2 != null) {
                Uri fromFile = Uri.fromFile(a2);
                if (fromFile != null) {
                    mo8405a("Finish caching video for ad #" + this.f6232a.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a);
                    return fromFile;
                }
                str2 = "Unable to create URI from cached video file = " + a2;
            } else {
                str2 = "Unable to cache video = " + str + "Video file was missing or null";
            }
        } else if (((Boolean) this.f6217b.mo8549a(C1841c.f5859bF)).booleanValue()) {
            mo8410d("Failed to cache video");
            mo8437h();
            return null;
        } else {
            str2 = "Failed to cache video, but not failing ad load";
        }
        mo8410d(str2);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8428a(String str, List<String> list) {
        if (C2025o.m7963b(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                mo8405a("Nothing to cache, skipping...");
                return null;
            }
            String lastPathSegment = parse.getLastPathSegment();
            if (C2025o.m7963b(this.f6232a.mo8212L())) {
                lastPathSegment = this.f6232a.mo8212L() + lastPathSegment;
            }
            File a = this.f6234d.mo8723a(lastPathSegment, mo8412f());
            ByteArrayOutputStream a2 = (a == null || !a.exists()) ? null : this.f6234d.mo8721a(a);
            if (a2 == null) {
                a2 = this.f6234d.mo8722a(str, list, true);
                if (a2 != null) {
                    this.f6234d.mo8727a(a2, a);
                    this.f6236f.mo8371a((long) a2.size());
                }
            } else {
                this.f6236f.mo8372b((long) a2.size());
            }
            try {
                return a2.toString(C4250c.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                mo8406a("UTF-8 encoding not supported.", e);
            } catch (Throwable th) {
                mo8406a("String resource at " + str + " failed to load.", th);
                return null;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8429a(String str, List<String> list, C1827g gVar) {
        if (!C2025o.m7963b(str)) {
            return str;
        }
        if (!((Boolean) this.f6217b.mo8549a(C1841c.f5858bE)).booleanValue()) {
            mo8405a("Resource caching is disabled, skipping cache...");
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        boolean shouldCancelHtmlCachingIfShown = gVar.shouldCancelHtmlCachingIfShown();
        for (String next : list) {
            int i = 0;
            int i2 = 0;
            while (i < sb.length()) {
                if (mo8433b()) {
                    return str;
                }
                i = sb.indexOf(next, i2);
                if (i == -1) {
                    continue;
                    break;
                }
                int length = sb.length();
                int i3 = i;
                while (!this.f6235e.contains(Character.valueOf(sb.charAt(i3))) && i3 < length) {
                    i3++;
                }
                if (i3 <= i || i3 == length) {
                    mo8410d("Unable to cache resource; ad HTML is invalid.");
                    return str;
                }
                String substring = sb.substring(next.length() + i, i3);
                if (!C2025o.m7963b(substring)) {
                    mo8405a("Skip caching of non-resource " + substring);
                } else if (!shouldCancelHtmlCachingIfShown || !gVar.hasShown()) {
                    Uri a = m7239a(next, substring);
                    if (a != null) {
                        sb.replace(i, i3, a.toString());
                        gVar.mo8273b(a);
                        this.f6236f.mo8376e();
                    } else {
                        this.f6236f.mo8377f();
                    }
                } else {
                    mo8405a("Cancelling HTML caching due to ad being shown already");
                    this.f6236f.mo8370a();
                    return str;
                }
                i2 = i3;
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8430a() {
        this.f6217b.mo8524B().mo7968b(this);
    }

    /* renamed from: a */
    public void mo7969a(C1697a aVar) {
        if (aVar.mo7766b().equalsIgnoreCase(this.f6232a.mo8216P())) {
            mo8410d("Updating flag for timeout...");
            this.f6237g = true;
        }
        this.f6217b.mo8524B().mo7968b(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8431a(AppLovinAdBase appLovinAdBase) {
        C1854d.m7125a(this.f6236f, appLovinAdBase, this.f6217b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Uri mo8432b(String str, List<String> list, boolean z) {
        String str2;
        try {
            String a = this.f6234d.mo8724a(mo8412f(), str, this.f6232a.mo8212L(), list, z, this.f6236f);
            if (!C2025o.m7963b(a)) {
                return null;
            }
            File a2 = this.f6234d.mo8723a(a, mo8412f());
            if (a2 != null) {
                Uri fromFile = Uri.fromFile(a2);
                if (fromFile != null) {
                    return fromFile;
                }
                str2 = "Unable to extract Uri from image file";
            } else {
                str2 = "Unable to retrieve File from cached image filename = " + a;
            }
            mo8410d(str2);
            return null;
        } catch (Throwable th) {
            mo8406a("Failed to cache image at url = " + str, th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo8433b() {
        return this.f6237g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8434c() {
        mo8405a("Caching mute images...");
        Uri a = m7238a(this.f6232a.mo8241aK(), AnalyticsEvent.C5464Ad.mute);
        if (a != null) {
            this.f6232a.mo8275c(a);
        }
        Uri a2 = m7238a(this.f6232a.mo8242aL(), AnalyticsEvent.C5464Ad.unmute);
        if (a2 != null) {
            this.f6232a.mo8276d(a2);
        }
        mo8405a("Ad updated with muteImageFilename = " + this.f6232a.mo8241aK() + ", unmuteImageFilename = " + this.f6232a.mo8242aL());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Uri mo8435e(String str) {
        return mo8427a(str, this.f6232a.mo8211K(), true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo8436f(final String str) {
        if (!C2025o.m7963b(str)) {
            return null;
        }
        C1960b a = C1960b.m7596a(this.f6217b).mo8663a(str).mo8669b("GET").mo8662a("").mo8661a(0).mo8667a();
        final AtomicReference atomicReference = new AtomicReference((Object) null);
        this.f6217b.mo8532K().mo8633a(a, new C1956a.C1957a(), new C1956a.C1959c<String>() {
            /* renamed from: a */
            public void mo7627a(int i) {
                C1877c cVar = C1877c.this;
                cVar.mo8410d("Failed to load resource from '" + str + "'");
            }

            /* renamed from: a */
            public void mo7628a(String str, int i) {
                atomicReference.set(str);
            }
        });
        String str2 = (String) atomicReference.get();
        if (str2 != null) {
            this.f6236f.mo8371a((long) str2.length());
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo8437h() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C1877c.this.f6233c != null) {
                    C2029r.m8008a(C1877c.this.f6233c, C1877c.this.f6232a.getAdZone(), (int) AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES, C1877c.this.f6217b);
                    AppLovinAdLoadListener unused = C1877c.this.f6233c = null;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo8438i() {
        mo8405a("Rendered new ad:" + this.f6232a);
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C1877c.this.f6233c != null) {
                    C1877c.this.f6233c.adReceived(C1877c.this.f6232a);
                    AppLovinAdLoadListener unused = C1877c.this.f6233c = null;
                }
            }
        });
    }

    public void run() {
        if (this.f6232a.mo8215O()) {
            mo8405a("Subscribing to timeout events...");
            this.f6217b.mo8524B().mo7967a((C1779k.C1780a) this);
        }
    }
}
