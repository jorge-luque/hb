package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.sdk.AppLovinSdkConfiguration;

public class SdkConfigurationImpl implements AppLovinSdkConfiguration {

    /* renamed from: a */
    private final C1941j f5555a;

    public SdkConfigurationImpl(C1941j jVar) {
        this.f5555a = jVar;
    }

    public AppLovinSdkConfiguration.ConsentDialogState getConsentDialogState() {
        String str = (String) this.f5555a.mo8549a(C1841c.f6065fd);
        return "applies".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.APPLIES : "does_not_apply".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.DOES_NOT_APPLY : AppLovinSdkConfiguration.ConsentDialogState.UNKNOWN;
    }

    public String toString() {
        return "AppLovinSdkConfiguration{consentDialogState=" + getConsentDialogState() + '}';
    }
}
