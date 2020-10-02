package com.ogury.p159cm;

import android.content.Context;

/* renamed from: com.ogury.cm.OguryChoiceManagerExternal */
public final class OguryChoiceManagerExternal {

    /* renamed from: a */
    public static final OguryChoiceManagerExternal f11922a = new OguryChoiceManagerExternal();

    /* renamed from: b */
    private static Integer f11923b;

    /* renamed from: com.ogury.cm.OguryChoiceManagerExternal$TcfV1 */
    public static final class TcfV1 {

        /* renamed from: a */
        public static final TcfV1 f11924a = new TcfV1();

        /* renamed from: b */
        private static aabaa f11925b = new aabaa();

        private TcfV1() {
        }

        public static /* synthetic */ void clientConsentExternalV1$annotations() {
        }

        public static final void setConsent(Context context, String str, String str2, String[] strArr) {
            accbb.m15218b(context, "context");
            accbb.m15218b(str, "assetKey");
            accbb.m15218b(str2, "iabString");
            OguryChoiceManagerExternal.access$checkTcfVersion(OguryChoiceManagerExternal.f11922a, 1);
            OguryChoiceManagerExternal.f11922a.setConsumedTcfVersion$consent_manager_prodRelease(1);
            if (!(!baacc.m15250a((CharSequence) str)) || !(!baacc.m15250a((CharSequence) str2))) {
                aaccc aaccc = aaccc.f12045a;
                aaccc.m15047a("assetKey and iabString must not be empty");
                return;
            }
            f11925b.mo29419a(context, str, str2, strArr);
        }

        public final aabaa getClientConsentExternalV1$consent_manager_prodRelease() {
            return f11925b;
        }

        public final void setClientConsentExternalV1$consent_manager_prodRelease(aabaa aabaa) {
            accbb.m15218b(aabaa, "<set-?>");
            f11925b = aabaa;
        }
    }

    /* renamed from: com.ogury.cm.OguryChoiceManagerExternal$TcfV2 */
    public static final class TcfV2 {

        /* renamed from: a */
        public static final TcfV2 f11926a = new TcfV2();

        /* renamed from: b */
        private static aabab f11927b = new aabab();

        private TcfV2() {
        }

        public static /* synthetic */ void clientConsentExternalV2$annotations() {
        }

        public static final void setConsent(Context context, String str, String str2, Integer[] numArr) {
            accbb.m15218b(context, "context");
            accbb.m15218b(str, "assetKey");
            accbb.m15218b(str2, "iabString");
            OguryChoiceManagerExternal.access$checkTcfVersion(OguryChoiceManagerExternal.f11922a, 2);
            OguryChoiceManagerExternal.f11922a.setConsumedTcfVersion$consent_manager_prodRelease(2);
            if (!(!baacc.m15250a((CharSequence) str)) || !(!baacc.m15250a((CharSequence) str2))) {
                aaccc aaccc = aaccc.f12045a;
                aaccc.m15047a("assetKey and iabString must not be empty");
                return;
            }
            f11927b.mo29420a(context, str, str2, numArr);
        }

        public final aabab getClientConsentExternalV2$consent_manager_prodRelease() {
            return f11927b;
        }

        public final void setClientConsentExternalV2$consent_manager_prodRelease(aabab aabab) {
            accbb.m15218b(aabab, "<set-?>");
            f11927b = aabab;
        }
    }

    private OguryChoiceManagerExternal() {
    }

    public static final /* synthetic */ void access$checkTcfVersion(OguryChoiceManagerExternal oguryChoiceManagerExternal, int i) {
        Integer num = f11923b;
        if (!(num == null || (num != null && num.intValue() == i))) {
            throw new IllegalStateException("You cannot use method from another TCF version.".toString());
        }
    }

    public static /* synthetic */ void consumedTcfVersion$annotations() {
    }

    public final Integer getConsumedTcfVersion$consent_manager_prodRelease() {
        return f11923b;
    }

    public final void setConsumedTcfVersion$consent_manager_prodRelease(Integer num) {
        f11923b = num;
    }
}
