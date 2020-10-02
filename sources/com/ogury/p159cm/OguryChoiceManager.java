package com.ogury.p159cm;

import android.app.Activity;
import android.content.Context;
import com.ogury.p159cm.aabba;

/* renamed from: com.ogury.cm.OguryChoiceManager */
public final class OguryChoiceManager {
    public static final OguryChoiceManager INSTANCE = new OguryChoiceManager();
    public static final int TCF_VERSION_1 = 1;
    public static final int TCF_VERSION_2 = 2;

    /* renamed from: a */
    private static aaaba f11915a;

    /* renamed from: b */
    private static baacc f11916b;

    /* renamed from: c */
    private static Context f11917c;

    /* renamed from: d */
    private static String f11918d;

    /* renamed from: e */
    private static boolean f11919e;

    /* renamed from: f */
    private static boolean f11920f;

    /* renamed from: com.ogury.cm.OguryChoiceManager$Answer */
    public enum Answer {
        FULL_APPROVAL,
        PARTIAL_APPROVAL,
        REFUSAL,
        NO_ANSWER
    }

    /* renamed from: com.ogury.cm.OguryChoiceManager$TcfV1 */
    public static final class TcfV1 {
        public static final TcfV1 INSTANCE = new TcfV1();

        /* renamed from: com.ogury.cm.OguryChoiceManager$TcfV1$Purpose */
        public enum Purpose {
            INFORMATION,
            PERSONALISATION,
            AD,
            CONTENT,
            MEASUREMENT
        }

        /* renamed from: com.ogury.cm.OguryChoiceManager$TcfV1$SpecialFeature */
        public static final class SpecialFeature {
            public static final SpecialFeature INSTANCE = new SpecialFeature();
            public static final int PRECISE_GEOLOCATION = 1;

            private SpecialFeature() {
            }
        }

        private TcfV1() {
        }

        public static final String getIabString() {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 1);
            if (OguryChoiceManager.INSTANCE.getClientConsentImpl() == null) {
                accbb.m15214a();
            }
            return aaaba.m14927d();
        }

        public static final boolean isAccepted(String str) {
            accbb.m15218b(str, "vendorSlug");
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 1);
            if (OguryChoiceManager.INSTANCE.getClientConsentImpl() != null) {
                accbb.m15218b(str, "receiver$0");
                return aaabc.m14950b("\"" + str + "\"");
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV1");
        }

        public static final boolean isPurposeAccepted(int i) {
            Purpose purpose;
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 1);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                aaabc aaabc = (aaabc) clientConsentImpl;
                if (i < 0 || 4 < i) {
                    return false;
                }
                if (i == Purpose.INFORMATION.ordinal()) {
                    purpose = Purpose.INFORMATION;
                } else if (i == Purpose.PERSONALISATION.ordinal()) {
                    purpose = Purpose.PERSONALISATION;
                } else if (i == Purpose.AD.ordinal()) {
                    purpose = Purpose.AD;
                } else if (i == Purpose.CONTENT.ordinal()) {
                    purpose = Purpose.CONTENT;
                } else if (i == Purpose.MEASUREMENT.ordinal()) {
                    purpose = Purpose.MEASUREMENT;
                } else {
                    throw new IllegalArgumentException("Bad purpose number used! Please use one of the declared ones in OguryChoiceManager TcfV1 class.");
                }
                return aaabc.mo29405a(purpose);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV1");
        }

        public static final boolean isPurposeAccepted(Purpose purpose) {
            accbb.m15218b(purpose, "purpose");
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 1);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaabc) clientConsentImpl).mo29405a(purpose);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV1");
        }

        public static final boolean isSpecialFeatureAccepted(int i) {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 1);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaabc) clientConsentImpl).mo29396a(i);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV1");
        }
    }

    /* renamed from: com.ogury.cm.OguryChoiceManager$TcfV2 */
    public static final class TcfV2 {
        public static final TcfV2 INSTANCE = new TcfV2();

        /* renamed from: com.ogury.cm.OguryChoiceManager$TcfV2$Purpose */
        public static final class Purpose {
            public static final int CREATE_PERSONALISED_ADS = 8;
            public static final int CREATE_PERSONALISED_CONTENT = 32;
            public static final int DEVELOP_AND_IMPROVE_PRODUCTS = 1024;
            public static final Purpose INSTANCE = new Purpose();
            public static final int MARKET_RESEARCH = 512;
            public static final int MEASURE_AD_PERFORMANCE = 128;
            public static final int MEASURE_CONTENT_PERFORMANCE = 256;
            public static final int SELECT_BASIC_ADS = 4;
            public static final int SELECT_PERSONALISED_ADS = 16;
            public static final int SELECT_PERSONALISED_CONTENT = 64;
            public static final int STORE_INFORMATION = 2;

            private Purpose() {
            }
        }

        /* renamed from: com.ogury.cm.OguryChoiceManager$TcfV2$SpecialFeature */
        public static final class SpecialFeature {
            public static final SpecialFeature INSTANCE = new SpecialFeature();
            public static final int PRECISE_GEOLOCATION = 2;
            public static final int SCAN_DEVICE_CHARACTERISTICS = 4;

            private SpecialFeature() {
            }
        }

        private TcfV2() {
        }

        public static final String getIabString() {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 2);
            if (OguryChoiceManager.INSTANCE.getClientConsentImpl() == null) {
                accbb.m15214a();
            }
            return aaaba.m14927d();
        }

        public static final boolean isAccepted(int i) {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 2);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaacb) clientConsentImpl).mo29407c(i);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV2");
        }

        public static final boolean isAllVendorConditionsMet(int i) {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 2);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaacb) clientConsentImpl).mo29412h(i);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV2");
        }

        public static final boolean isLiPurposeMet(int i) {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 2);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaacb) clientConsentImpl).mo29409e(i);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV2");
        }

        public static final boolean isLiVendorMet(int i) {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 2);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaacb) clientConsentImpl).mo29408d(i);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV2");
        }

        public static final boolean isPurposeAccepted(int i) {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 2);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaacb) clientConsentImpl).mo29406b(i);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV2");
        }

        public static final boolean isSpecialFeatureAccepted(int i) {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 2);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaacb) clientConsentImpl).mo29396a(i);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV2");
        }

        public static final boolean isVendorAndItsPurposesAccepted(int i) {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 2);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaacb) clientConsentImpl).mo29410f(i);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV2");
        }

        public static final boolean isVendorsLiAndLiPurposeMet(int i) {
            OguryChoiceManager.access$checkInstance(OguryChoiceManager.INSTANCE, 2);
            aaaba clientConsentImpl = OguryChoiceManager.INSTANCE.getClientConsentImpl();
            if (clientConsentImpl != null) {
                return ((aaacb) clientConsentImpl).mo29411g(i);
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.choiceManager.ClientConsentImplV2");
        }
    }

    private OguryChoiceManager() {
    }

    /* renamed from: a */
    private static void m14887a() {
        if (f11920f) {
            m14890d();
        } else {
            m14888b();
        }
    }

    public static final /* synthetic */ void access$checkInstance(OguryChoiceManager oguryChoiceManager, int i) {
        m14887a();
        if (i != 1) {
            if (i != 2) {
                throw new IllegalArgumentException("Bad TCF version is passed, you can use one of versions declared in class OguryChoiceManager.");
            } else if (!(f11915a instanceof aaacb)) {
                throw new IllegalStateException("You cannot use method from another TCF version.".toString());
            }
        } else if (!(f11915a instanceof aaabc)) {
            throw new IllegalStateException("You cannot use method from another TCF version.".toString());
        }
    }

    public static final void ask(Activity activity, OguryConsentListener oguryConsentListener) {
        accbb.m15218b(activity, "activity");
        accbb.m15218b(oguryConsentListener, "oguryConsentListener");
        f11919e = true;
        m14887a();
        aaaba aaaba = f11915a;
        if (aaaba == null) {
            accbb.m15214a();
        }
        String str = f11918d;
        if (str == null) {
            accbb.m15214a();
        }
        aaaba.mo29390a((Context) activity, str, oguryConsentListener);
    }

    /* renamed from: b */
    private static void m14888b() {
        if (f11917c != null) {
            String str = f11918d;
            if (str == null || baacc.m15250a((CharSequence) str)) {
                throw new IllegalStateException("AssetKey is not allowed to be empty.");
            } else if (!f11919e) {
                m14889c();
                Context context = f11917c;
                if (context == null) {
                    accbb.m15214a();
                }
                if (!baacc.m15249a(context)) {
                    aaccc aaccc = aaccc.f12045a;
                    aaccc.m15047a("You must first call ask to get config.");
                    return;
                }
                throw new IllegalStateException("You must first call ask to get config.");
            }
        } else {
            throw new IllegalStateException("You must first call initialize method.");
        }
    }

    /* renamed from: c */
    private static baacc m14889c() {
        if (f11916b == null) {
            f11916b = new baacc();
        }
        baacc baacc = f11916b;
        if (baacc == null) {
            accbb.m15214a();
        }
        return baacc;
    }

    public static /* synthetic */ void clientConsentImpl$annotations() {
    }

    /* renamed from: d */
    private static void m14890d() {
        String str = f11918d;
        if (str == null) {
            aaccc aaccc = aaccc.f12045a;
            aaccc.m15047a("You must first call ask to initialize SDK.");
            return;
        }
        if (str == null) {
            accbb.m15214a();
        }
        if (baacc.m15250a((CharSequence) str)) {
            aaccc aaccc2 = aaccc.f12045a;
            aaccc.m15047a("AssetKey is not allowed to be empty.");
        }
    }

    public static /* synthetic */ void debugUtilVal$annotations() {
    }

    public static final void edit(Activity activity, OguryConsentListener oguryConsentListener) {
        accbb.m15218b(activity, "activity");
        accbb.m15218b(oguryConsentListener, "oguryConsentListener");
        f11919e = true;
        m14887a();
        aaaba aaaba = f11915a;
        if (aaaba == null) {
            accbb.m15214a();
        }
        String str = f11918d;
        if (str == null) {
            accbb.m15214a();
        }
        aaaba.mo29398b(activity, str, oguryConsentListener);
    }

    public static final boolean gdprApplies() {
        m14887a();
        if (f11915a == null) {
            accbb.m15214a();
        }
        return aaaba.m14928e();
    }

    public static final boolean hasPaid() {
        m14887a();
        aaaba aaaba = f11915a;
        if (aaaba == null) {
            accbb.m15214a();
        }
        Context context = f11917c;
        if (context == null) {
            accbb.m15214a();
        }
        accbb.m15218b(context, "context");
        abbcb abbcb = aaaba.f11948a;
        if (abbcb == null) {
            accbb.m15216a("sharedPrefsHandler");
        }
        return abbcb.mo29489a(context);
    }

    public static final void initialize(Context context, String str, OguryCmConfig oguryCmConfig) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(oguryCmConfig, "oguryCmConfig");
        aabba.aaaaa aaaaa = aabba.f12009a;
        aabba.aaaaa.m14998a(context, oguryCmConfig.getTcfVersion());
        if (f11915a == null) {
            f11917c = context.getApplicationContext();
            f11918d = str;
            aaabb aaabb = aaabb.f11975a;
            f11915a = aaabb.m14949a(oguryCmConfig.getTcfVersion());
            return;
        }
        aaccc aaccc = aaccc.f12045a;
        aaccc.m15047a("SDK initialize is already done.");
    }

    public static /* synthetic */ void initialize$default(Context context, String str, OguryCmConfig oguryCmConfig, int i, Object obj) {
        if ((i & 4) != 0) {
            oguryCmConfig = new OguryCmConfig();
        }
        initialize(context, str, oguryCmConfig);
    }

    public static final boolean isEditAvailable() {
        m14887a();
        aaaba aaaba = f11915a;
        if (aaaba == null) {
            accbb.m15214a();
        }
        Context context = f11917c;
        if (context == null) {
            accbb.m15214a();
        }
        accbb.m15218b(context, "context");
        abbcb abbcb = aaaba.f11948a;
        if (abbcb == null) {
            accbb.m15216a("sharedPrefsHandler");
        }
        accbb.m15218b(context, "context");
        return context.getSharedPreferences(abbcb.mo29487a(), 0).getBoolean("isEditAvailable", true);
    }

    public static final void updateOguryCmConfig(OguryCmConfig oguryCmConfig) {
        accbb.m15218b(oguryCmConfig, "oguryCmConfig");
        int tcfVersion = oguryCmConfig.getTcfVersion();
        if (!f11919e && f11917c != null) {
            aacca aacca = aacca.f12035a;
            if (aacca.m15027a() != tcfVersion) {
                aabba.aaaaa aaaaa = aabba.f12009a;
                Context context = f11917c;
                if (context == null) {
                    accbb.m15214a();
                }
                aabba.aaaaa.m14998a(context, tcfVersion);
                aaabb aaabb = aaabb.f11975a;
                f11915a = aaabb.m14949a(tcfVersion);
                return;
            }
        }
        if (f11917c == null) {
            aaccc aaccc = aaccc.f12045a;
            aaccc.m15047a("Initialization is required before changing TCF version.");
        } else if (f11919e) {
            aaccc aaccc2 = aaccc.f12045a;
            aaccc.m15047a("Ask method is already called.");
        }
    }

    public final aaaba getClientConsentImpl() {
        return f11915a;
    }

    public final baacc getDebugUtilVal$3dacfc6e$16412e62() {
        return f11916b;
    }

    public final void initializeTcfV1$consent_manager_prodRelease(Context context) {
        f11920f = true;
        aacca aacca = aacca.f12035a;
        aacca.m15028a(1);
        if (f11917c == null) {
            f11917c = context != null ? context.getApplicationContext() : null;
        }
        if (f11915a == null) {
            aaabb aaabb = aaabb.f11975a;
            f11915a = aaabb.m14949a(1);
        }
    }

    public final void resetClientConsentImpl$consent_manager_prodRelease() {
        f11915a = null;
    }

    public final void resetFieldsForTests() {
        f11917c = null;
        f11918d = null;
        f11919e = false;
        f11920f = false;
    }

    public final void setClientConsentImpl(aaaba aaaba) {
        f11915a = aaaba;
    }

    public final void setDebugUtilVal$47bacc58$5428575c(baacc baacc) {
        f11916b = baacc;
    }
}
