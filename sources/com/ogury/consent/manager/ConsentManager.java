package com.ogury.consent.manager;

import android.app.Activity;
import android.content.Context;
import com.ogury.p159cm.OguryChoiceManager;
import com.ogury.p159cm.OguryCmConfig;
import com.ogury.p159cm.OguryConsentListener;
import com.ogury.p159cm.acacc;
import com.ogury.p159cm.accbb;
import com.ogury.p159cm.baaca;

public final class ConsentManager {
    public static final ConsentManager INSTANCE = new ConsentManager();
    public static ConsentListener consentListener;

    public enum Answer {
        FULL_APPROVAL,
        PARTIAL_APPROVAL,
        REFUSAL,
        NO_ANSWER
    }

    public enum Purpose {
        INFORMATION,
        PERSONALISATION,
        AD,
        CONTENT,
        MEASUREMENT
    }

    public static final class SpecialFeature {
        public static final Companion Companion = new Companion((baaca) null);
        public static final int PRECISE_GEOLOCATION = 1;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(baaca baaca) {
                this();
            }
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OguryChoiceManager.Answer.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[OguryChoiceManager.Answer.FULL_APPROVAL.ordinal()] = 1;
            $EnumSwitchMapping$0[OguryChoiceManager.Answer.PARTIAL_APPROVAL.ordinal()] = 2;
            $EnumSwitchMapping$0[OguryChoiceManager.Answer.REFUSAL.ordinal()] = 3;
            $EnumSwitchMapping$0[OguryChoiceManager.Answer.NO_ANSWER.ordinal()] = 4;
            int[] iArr2 = new int[Purpose.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Purpose.INFORMATION.ordinal()] = 1;
            $EnumSwitchMapping$1[Purpose.PERSONALISATION.ordinal()] = 2;
            $EnumSwitchMapping$1[Purpose.AD.ordinal()] = 3;
            $EnumSwitchMapping$1[Purpose.CONTENT.ordinal()] = 4;
            $EnumSwitchMapping$1[Purpose.MEASUREMENT.ordinal()] = 5;
        }
    }

    private ConsentManager() {
    }

    /* renamed from: a */
    private static OguryChoiceManager.TcfV1.Purpose m15270a(Purpose purpose) {
        int i = WhenMappings.$EnumSwitchMapping$1[purpose.ordinal()];
        if (i == 1) {
            return OguryChoiceManager.TcfV1.Purpose.INFORMATION;
        }
        if (i == 2) {
            return OguryChoiceManager.TcfV1.Purpose.PERSONALISATION;
        }
        if (i == 3) {
            return OguryChoiceManager.TcfV1.Purpose.AD;
        }
        if (i == 4) {
            return OguryChoiceManager.TcfV1.Purpose.CONTENT;
        }
        if (i == 5) {
            return OguryChoiceManager.TcfV1.Purpose.MEASUREMENT;
        }
        throw new acacc();
    }

    /* renamed from: a */
    private static OguryConsentListener m15271a() {
        return new ConsentManager$getOguryConsentListener$1();
    }

    /* renamed from: a */
    private static void m15272a(Context context) {
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("Context must be instance of activity.");
        }
    }

    public static final /* synthetic */ Answer access$mapAnswer(ConsentManager consentManager, OguryChoiceManager.Answer answer) {
        int i = WhenMappings.$EnumSwitchMapping$0[answer.ordinal()];
        if (i == 1) {
            return Answer.FULL_APPROVAL;
        }
        if (i == 2) {
            return Answer.PARTIAL_APPROVAL;
        }
        if (i == 3) {
            return Answer.REFUSAL;
        }
        if (i == 4) {
            return Answer.NO_ANSWER;
        }
        throw new acacc();
    }

    public static final void ask(Context context, String str, ConsentListener consentListener2) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(consentListener2, "consentListener");
        m15272a(context);
        consentListener = consentListener2;
        OguryChoiceManager.INSTANCE.resetClientConsentImpl$consent_manager_prodRelease();
        OguryChoiceManager.initialize(context, str, new OguryCmConfig(1));
        OguryChoiceManager.ask((Activity) context, m15271a());
    }

    public static final void edit(Context context, String str, ConsentListener consentListener2) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(consentListener2, "consentListener");
        m15272a(context);
        consentListener = consentListener2;
        OguryChoiceManager.INSTANCE.resetClientConsentImpl$consent_manager_prodRelease();
        OguryChoiceManager.initialize(context, str, new OguryCmConfig(1));
        OguryChoiceManager.edit((Activity) context, m15271a());
    }

    public static final boolean gdprApplies() {
        OguryChoiceManager.INSTANCE.initializeTcfV1$consent_manager_prodRelease((Context) null);
        return OguryChoiceManager.gdprApplies();
    }

    public static final String getIabString() {
        OguryChoiceManager.INSTANCE.initializeTcfV1$consent_manager_prodRelease((Context) null);
        return OguryChoiceManager.TcfV1.getIabString();
    }

    public static final boolean hasPaid(Context context) {
        accbb.m15218b(context, "context");
        OguryChoiceManager.INSTANCE.initializeTcfV1$consent_manager_prodRelease(context);
        return OguryChoiceManager.hasPaid();
    }

    public static final boolean isAccepted(String str) {
        accbb.m15218b(str, "vendorSlug");
        OguryChoiceManager.INSTANCE.initializeTcfV1$consent_manager_prodRelease((Context) null);
        return OguryChoiceManager.TcfV1.isAccepted(str);
    }

    public static final boolean isEditAvailable(Context context) {
        accbb.m15218b(context, "context");
        OguryChoiceManager.INSTANCE.initializeTcfV1$consent_manager_prodRelease(context);
        return OguryChoiceManager.isEditAvailable();
    }

    public static final boolean isPurposeAccepted(int i) {
        if (i < 0 || 4 < i) {
            return false;
        }
        OguryChoiceManager.INSTANCE.initializeTcfV1$consent_manager_prodRelease((Context) null);
        return OguryChoiceManager.TcfV1.isPurposeAccepted(m15270a(i == Purpose.INFORMATION.ordinal() ? Purpose.INFORMATION : i == Purpose.PERSONALISATION.ordinal() ? Purpose.PERSONALISATION : i == Purpose.AD.ordinal() ? Purpose.AD : i == Purpose.CONTENT.ordinal() ? Purpose.CONTENT : Purpose.MEASUREMENT));
    }

    public static final boolean isPurposeAccepted(Purpose purpose) {
        accbb.m15218b(purpose, "purpose");
        OguryChoiceManager.INSTANCE.initializeTcfV1$consent_manager_prodRelease((Context) null);
        return OguryChoiceManager.TcfV1.isPurposeAccepted(m15270a(purpose));
    }

    public static final boolean isSpecialFeatureAccepted(int i) {
        OguryChoiceManager.INSTANCE.initializeTcfV1$consent_manager_prodRelease((Context) null);
        return OguryChoiceManager.TcfV1.isSpecialFeatureAccepted(i);
    }

    public final ConsentListener getConsentListener() {
        ConsentListener consentListener2 = consentListener;
        if (consentListener2 == null) {
            accbb.m15216a("consentListener");
        }
        return consentListener2;
    }

    public final void setConsentListener(ConsentListener consentListener2) {
        accbb.m15218b(consentListener2, "<set-?>");
        consentListener = consentListener2;
    }
}
