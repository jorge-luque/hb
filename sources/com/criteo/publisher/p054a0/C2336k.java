package com.criteo.publisher.p054a0;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.criteo.publisher.CriteoInterstitialAdListener;
import java.lang.ref.Reference;

/* renamed from: com.criteo.publisher.a0.k */
public class C2336k extends ResultReceiver {

    /* renamed from: a */
    private final Reference<CriteoInterstitialAdListener> f7701a;

    public C2336k(Handler handler, Reference<CriteoInterstitialAdListener> reference) {
        super(handler);
        this.f7701a = reference;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        if (i == 100) {
            int i2 = bundle.getInt("Action");
            CriteoInterstitialAdListener criteoInterstitialAdListener = this.f7701a.get();
            if (criteoInterstitialAdListener == null) {
                return;
            }
            if (i2 == 201) {
                criteoInterstitialAdListener.onAdClosed();
            } else if (i2 == 202) {
                criteoInterstitialAdListener.onAdClicked();
                criteoInterstitialAdListener.onAdLeftApplication();
            }
        }
    }
}
