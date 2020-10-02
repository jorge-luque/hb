package com.ogury.consent.manager;

import com.ogury.consent.manager.util.consent.ConsentException;
import com.ogury.core.OguryError;
import com.ogury.p159cm.OguryChoiceManager;
import com.ogury.p159cm.OguryConsentListener;
import com.ogury.p159cm.aaccb;
import com.ogury.p159cm.accbb;

public final class ConsentManager$getOguryConsentListener$1 implements OguryConsentListener {
    ConsentManager$getOguryConsentListener$1() {
    }

    public final void onComplete(OguryChoiceManager.Answer answer) {
        accbb.m15218b(answer, "answer");
        ConsentManager.INSTANCE.getConsentListener().onComplete(ConsentManager.access$mapAnswer(ConsentManager.INSTANCE, answer));
    }

    public final void onError(OguryError oguryError) {
        accbb.m15218b(oguryError, "error");
        ConsentListener consentListener = ConsentManager.INSTANCE.getConsentListener();
        aaccb aaccb = aaccb.f12044a;
        String a = aaccb.m15046a(oguryError);
        String message = oguryError.getMessage();
        if (message == null) {
            message = "";
        }
        consentListener.onError(new ConsentException(a, message));
    }
}
