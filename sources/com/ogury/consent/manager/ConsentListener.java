package com.ogury.consent.manager;

import com.ogury.consent.manager.ConsentManager;
import com.ogury.consent.manager.util.consent.ConsentException;

public interface ConsentListener {
    void onComplete(ConsentManager.Answer answer);

    void onError(ConsentException consentException);
}
