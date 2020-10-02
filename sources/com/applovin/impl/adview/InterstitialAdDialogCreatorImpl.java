package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.impl.sdk.C1977q;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class InterstitialAdDialogCreatorImpl implements InterstitialAdDialogCreator {

    /* renamed from: a */
    private static final Object f4769a = new Object();

    /* renamed from: b */
    private static WeakReference<C1615o> f4770b = new WeakReference<>((Object) null);

    /* renamed from: c */
    private static WeakReference<Context> f4771c = new WeakReference<>((Object) null);

    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk appLovinSdk, Context context) {
        C1615o oVar;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        synchronized (f4769a) {
            oVar = (C1615o) f4770b.get();
            if (oVar != null) {
                if (f4771c.get() == context) {
                    C1977q.m7751i("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
                }
            }
            oVar = new C1615o(appLovinSdk, context);
            f4770b = new WeakReference<>(oVar);
            f4771c = new WeakReference<>(context);
        }
        return oVar;
    }
}
