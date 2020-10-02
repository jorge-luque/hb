package com.tapjoy;

import com.tapjoy.internal.C3143gl;
import com.tapjoy.internal.C3145gz;
import com.tapjoy.internal.C4903az;
import com.tapjoy.internal.C5124gm;
import com.tapjoy.internal.C5126go;
import com.tapjoy.internal.C5143ha;

public class FiveRocksIntegration {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static C4903az f12904a = new C4903az();

    /* renamed from: a */
    public static void m16525a() {
        C3145gz a = C3145gz.m10321a();
        if (!a.f8759c) {
            a.f8759c = true;
        }
        C48161 r0 = new C5126go() {
            /* renamed from: e */
            private C5124gm m16527e(final String str) {
                return new C5124gm() {
                    /* renamed from: a */
                    public final void mo30549a(final String str, String str2) {
                        TJPlacement tJPlacement;
                        synchronized (FiveRocksIntegration.f12904a) {
                            tJPlacement = (TJPlacement) FiveRocksIntegration.f12904a.get(str);
                        }
                        if (tJPlacement != null && tJPlacement.f13057a != null) {
                            tJPlacement.f13057a.onPurchaseRequest(tJPlacement, new TJActionRequest() {
                                public final void cancelled() {
                                }

                                public final void completed() {
                                }

                                public final String getRequestId() {
                                    return str;
                                }

                                public final String getToken() {
                                    return null;
                                }
                            }, str2);
                        }
                    }

                    /* renamed from: a */
                    public final void mo30550a(final String str, String str2, int i, final String str3) {
                        TJPlacement tJPlacement;
                        synchronized (FiveRocksIntegration.f12904a) {
                            tJPlacement = (TJPlacement) FiveRocksIntegration.f12904a.get(str);
                        }
                        if (tJPlacement != null && tJPlacement.f13057a != null) {
                            tJPlacement.f13057a.onRewardRequest(tJPlacement, new TJActionRequest() {
                                public final void cancelled() {
                                }

                                public final void completed() {
                                }

                                public final String getRequestId() {
                                    return str;
                                }

                                public final String getToken() {
                                    return str3;
                                }
                            }, str2, i);
                        }
                    }
                };
            }

            /* renamed from: a */
            public final void mo30543a(String str) {
            }

            /* renamed from: a */
            public final void mo30544a(String str, C3143gl glVar) {
                if (glVar != null) {
                    glVar.mo18537a(m16527e(str));
                }
            }

            /* renamed from: b */
            public final void mo30546b(String str) {
                TJPlacement tJPlacement;
                TJPlacementListener tJPlacementListener;
                synchronized (FiveRocksIntegration.f12904a) {
                    tJPlacement = (TJPlacement) FiveRocksIntegration.f12904a.get(str);
                }
                if (tJPlacement != null && (tJPlacementListener = tJPlacement.f13057a) != null) {
                    tJPlacementListener.onContentReady(tJPlacement);
                }
            }

            /* renamed from: c */
            public final void mo30547c(String str) {
                TJPlacement tJPlacement;
                TJPlacementListener tJPlacementListener;
                synchronized (FiveRocksIntegration.f12904a) {
                    tJPlacement = (TJPlacement) FiveRocksIntegration.f12904a.get(str);
                }
                if (tJPlacement != null && (tJPlacementListener = tJPlacement.f13057a) != null) {
                    tJPlacementListener.onContentShow(tJPlacement);
                }
            }

            /* renamed from: d */
            public final void mo30548d(String str) {
            }

            /* renamed from: a */
            public final void mo30545a(String str, String str2, C3143gl glVar) {
                TJPlacement tJPlacement;
                if (glVar != null) {
                    glVar.mo18537a(m16527e(str));
                }
                synchronized (FiveRocksIntegration.f12904a) {
                    tJPlacement = (TJPlacement) FiveRocksIntegration.f12904a.get(str);
                }
                if (tJPlacement != null) {
                    TapjoyConnectCore.viewDidClose(str2);
                    TJPlacementListener tJPlacementListener = tJPlacement.f13057a;
                    if (tJPlacementListener != null) {
                        tJPlacementListener.onContentDismiss(tJPlacement);
                    }
                }
            }
        };
        C3145gz.m10321a().f8772p = C5143ha.m17337a((C5126go) r0);
    }

    public static void addPlacementCallback(String str, TJPlacement tJPlacement) {
        synchronized (f12904a) {
            f12904a.put(str, tJPlacement);
        }
    }
}
