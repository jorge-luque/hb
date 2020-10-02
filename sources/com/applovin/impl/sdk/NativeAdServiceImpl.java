package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p049ad.NativeAdImpl;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1883e;
import com.applovin.impl.sdk.p052d.C1885g;
import com.applovin.impl.sdk.p052d.C1898n;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NativeAdServiceImpl implements AppLovinNativeAdService {

    /* renamed from: a */
    private final C1941j f5539a;

    NativeAdServiceImpl(C1941j jVar) {
        this.f5539a = jVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6755a(AppLovinNativeAd appLovinNativeAd, final AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isVideoPrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            return;
        }
        this.f5539a.mo8533L().mo8475a((C1864a) new C1885g((List<NativeAdImpl>) Arrays.asList(new NativeAdImpl[]{(NativeAdImpl) appLovinNativeAd}), this.f5539a, (AppLovinNativeAdPrecacheListener) new AppLovinNativeAdPrecacheListener() {
            public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
            }

            public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
            }

            public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                NativeAdServiceImpl.this.m6758a(appLovinNativeAdPrecacheListener, appLovinNativeAd, i, true);
            }

            public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
                NativeAdServiceImpl.this.m6759a(appLovinNativeAdPrecacheListener, appLovinNativeAd, true);
            }
        }), C1907s.C1909a.CACHING_OTHER);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6756a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, int i) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
            } catch (Exception e) {
                C1977q.m7747c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6757a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List<AppLovinNativeAd> list) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
            } catch (Exception e) {
                C1977q.m7747c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6758a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, int i, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPrecachingFailed(appLovinNativeAd, i);
            } catch (Exception e) {
                C1977q.m7747c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            appLovinNativeAdPrecacheListener.onNativeAdImagePrecachingFailed(appLovinNativeAd, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6759a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            } catch (Exception e) {
                C1977q.m7747c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6760a(List<AppLovinNativeAd> list, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        int intValue = ((Integer) this.f5539a.mo8549a(C1841c.f5995dl)).intValue();
        if (intValue > 0) {
            int size = list.size();
            if (size != 0) {
                int min = Math.min(intValue, size);
                final List<AppLovinNativeAd> subList = list.subList(0, min);
                final List<AppLovinNativeAd> subList2 = list.subList(min, size);
                m6762b(subList, new AppLovinNativeAdLoadListener() {
                    public void onNativeAdsFailedToLoad(int i) {
                        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = appLovinNativeAdLoadListener;
                        if (appLovinNativeAdLoadListener != null) {
                            appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
                        }
                    }

                    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                        NativeAdServiceImpl.this.m6763c(subList, new AppLovinNativeAdLoadListener() {
                            public void onNativeAdsFailedToLoad(int i) {
                                AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = appLovinNativeAdLoadListener;
                                if (appLovinNativeAdLoadListener != null) {
                                    appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
                                }
                            }

                            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                                if (appLovinNativeAdLoadListener != null) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.addAll(subList);
                                    arrayList.addAll(subList2);
                                    appLovinNativeAdLoadListener.onNativeAdsLoaded(arrayList);
                                }
                            }
                        });
                    }
                });
            } else if (appLovinNativeAdLoadListener != null) {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            }
        } else if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
        }
    }

    /* renamed from: b */
    private void m6762b(List<NativeAdImpl> list, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f5539a.mo8533L().mo8475a((C1864a) new C1883e(list, this.f5539a, (AppLovinNativeAdLoadListener) new AppLovinNativeAdLoadListener() {
            public void onNativeAdsFailedToLoad(int i) {
                AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = appLovinNativeAdLoadListener;
                if (appLovinNativeAdLoadListener != null) {
                    appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
                }
            }

            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = appLovinNativeAdLoadListener;
                if (appLovinNativeAdLoadListener != null) {
                    appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
                }
            }
        }), C1907s.C1909a.CACHING_OTHER);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6763c(List<NativeAdImpl> list, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f5539a.mo8533L().mo8475a((C1864a) new C1885g(list, this.f5539a, (AppLovinNativeAdLoadListener) new AppLovinNativeAdLoadListener() {
            public void onNativeAdsFailedToLoad(int i) {
                NativeAdServiceImpl.this.m6756a(appLovinNativeAdLoadListener, i);
            }

            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                NativeAdServiceImpl.this.m6757a(appLovinNativeAdLoadListener, list);
            }
        }), C1907s.C1909a.CACHING_OTHER);
    }

    public void loadNativeAds(int i, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        if (i > 0) {
            this.f5539a.mo8552a();
            if (i == 1) {
                C1821d g = C1821d.m6871g(this.f5539a);
                AppLovinNativeAd appLovinNativeAd = (AppLovinNativeAd) this.f5539a.mo8542U().mo8335e(g);
                if (appLovinNativeAd != null) {
                    m6757a(appLovinNativeAdLoadListener, (List<AppLovinNativeAd>) Arrays.asList(new AppLovinNativeAd[]{appLovinNativeAd}));
                } else {
                    this.f5539a.mo8533L().mo8475a((C1864a) new C1898n(this.f5539a, new AppLovinNativeAdLoadListener() {
                        public void onNativeAdsFailedToLoad(int i) {
                            NativeAdServiceImpl.this.m6756a(appLovinNativeAdLoadListener, i);
                        }

                        public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                            NativeAdServiceImpl.this.m6760a(list, appLovinNativeAdLoadListener);
                        }
                    }), C1907s.C1909a.MAIN);
                }
                if (((Boolean) this.f5539a.mo8549a(C1841c.f5883bd)).booleanValue()) {
                    this.f5539a.mo8542U().mo8339i(g);
                    return;
                }
                return;
            }
            loadNextAd(appLovinNativeAdLoadListener);
            return;
        }
        C1977q.m7751i("NativeAdService", "Requested invalid number of native ads: " + i);
    }

    public void loadNextAd(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        loadNativeAds(1, appLovinNativeAdLoadListener);
    }

    public void precacheResources(AppLovinNativeAd appLovinNativeAd, final AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.f5539a.mo8552a();
        if (appLovinNativeAd.isImagePrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
            m6755a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            return;
        }
        this.f5539a.mo8533L().mo8475a((C1864a) new C1883e((List<NativeAdImpl>) Arrays.asList(new NativeAdImpl[]{(NativeAdImpl) appLovinNativeAd}), this.f5539a, (AppLovinNativeAdPrecacheListener) new AppLovinNativeAdPrecacheListener() {
            public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                NativeAdServiceImpl.this.m6758a(appLovinNativeAdPrecacheListener, appLovinNativeAd, i, false);
            }

            public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
                NativeAdServiceImpl.this.m6759a(appLovinNativeAdPrecacheListener, appLovinNativeAd, false);
                NativeAdServiceImpl.this.m6755a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            }

            public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
            }

            public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
            }
        }), C1907s.C1909a.CACHING_OTHER);
    }

    public void preloadAds(C1821d dVar) {
        this.f5539a.mo8541T().mo8338h(dVar);
        int h = dVar.mo8182h();
        if (h == 0 && this.f5539a.mo8541T().mo8332b(dVar)) {
            h = 1;
        }
        this.f5539a.mo8541T().mo8331b(dVar, h);
    }

    public String toString() {
        return "NativeAdServiceImpl{}";
    }
}
