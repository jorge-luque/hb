package com.criteo.publisher.advancednative;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.criteo.publisher.BidToken;
import com.criteo.publisher.C2376b;
import com.criteo.publisher.C2387i;
import com.criteo.publisher.C2432l;
import com.criteo.publisher.CriteoErrorCode;
import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.model.NativeAdUnit;
import com.criteo.publisher.model.p055z.C2488n;
import com.criteo.publisher.model.p055z.C2494s;
import com.criteo.publisher.p054a0.C2341p;
import com.criteo.publisher.p060s.C2508a;
import java.lang.ref.WeakReference;

@Keep
public class CriteoNativeLoader {
    private final NativeAdUnit adUnit;
    /* access modifiers changed from: private */
    public final CriteoNativeAdListener listener;
    private final CriteoNativeRenderer publisherRenderer;
    private CriteoNativeRenderer renderer;

    /* renamed from: com.criteo.publisher.advancednative.CriteoNativeLoader$a */
    class C2348a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CriteoNativeAd f7714a;

        C2348a(CriteoNativeAd criteoNativeAd) {
            this.f7714a = criteoNativeAd;
        }

        public void run() {
            CriteoNativeLoader.this.listener.onAdReceived(this.f7714a);
        }
    }

    /* renamed from: com.criteo.publisher.advancednative.CriteoNativeLoader$b */
    class C2349b implements Runnable {
        C2349b() {
        }

        public void run() {
            CriteoNativeLoader.this.listener.onAdFailedToReceive(CriteoErrorCode.ERROR_CODE_NO_FILL);
        }
    }

    public CriteoNativeLoader(NativeAdUnit nativeAdUnit, CriteoNativeAdListener criteoNativeAdListener, CriteoNativeRenderer criteoNativeRenderer) {
        this.adUnit = nativeAdUnit;
        this.listener = criteoNativeAdListener;
        this.publisherRenderer = criteoNativeRenderer;
    }

    private void doLoad() {
        C2488n nVar;
        C2465w a = getBidManager().mo10232a((AdUnit) this.adUnit);
        if (a == null) {
            nVar = null;
        } else {
            nVar = a.mo10410f();
        }
        handleNativeAssets(nVar);
    }

    private C2354b getAdChoiceOverlay() {
        return C2387i.m9085U().mo10266a();
    }

    private C2376b getBidManager() {
        return C2387i.m9085U().mo10275h();
    }

    private static C2365h getImageLoaderHolder() {
        return C2387i.m9085U().mo10289v();
    }

    private C2432l getInHouse() {
        return C2387i.m9085U().mo10290w();
    }

    private C2370k getNativeAdMapper() {
        return C2387i.m9085U().mo10252E();
    }

    private CriteoNativeRenderer getRenderer() {
        if (this.renderer == null) {
            this.renderer = new AdChoiceOverlayNativeRenderer(this.publisherRenderer, getAdChoiceOverlay());
        }
        return this.renderer;
    }

    private C2508a getUiThreadExecutor() {
        return C2387i.m9085U().mo10260M();
    }

    private void handleNativeAssets(C2488n nVar) {
        if (nVar == null) {
            notifyForFailureAsync();
        } else {
            notifyForAdAsync(getNativeAdMapper().mo10227a(nVar, new WeakReference(this.listener), getRenderer()));
        }
    }

    private void notifyForAdAsync(CriteoNativeAd criteoNativeAd) {
        getUiThreadExecutor().mo10520a(new C2348a(criteoNativeAd));
    }

    private void notifyForFailureAsync() {
        getUiThreadExecutor().mo10520a(new C2349b());
    }

    public static void setImageLoader(ImageLoader imageLoader) {
        getImageLoaderHolder().mo10222a(imageLoader);
    }

    public View createEmptyNativeView(Context context, ViewGroup viewGroup) {
        return getRenderer().createNativeView(context, viewGroup);
    }

    public void loadAd() {
        try {
            doLoad();
        } catch (Throwable th) {
            C2341p.m8996a(th);
        }
    }

    public void loadAd(BidToken bidToken) {
        try {
            doLoad(bidToken);
        } catch (Throwable th) {
            C2341p.m8996a(th);
        }
    }

    private void doLoad(BidToken bidToken) {
        C2488n nVar;
        C2494s a = getInHouse().mo10301a(bidToken);
        if (a == null) {
            nVar = null;
        } else {
            nVar = a.mo10494b();
        }
        handleNativeAssets(nVar);
    }
}
