package com.criteo.publisher.advancednative;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.criteo.publisher.C2387i;

@Keep
class AdChoiceOverlayNativeRenderer implements CriteoNativeRenderer {
    private final C2354b adChoiceOverlay;
    private final CriteoNativeRenderer delegate;

    AdChoiceOverlayNativeRenderer(CriteoNativeRenderer criteoNativeRenderer) {
        this(criteoNativeRenderer, C2387i.m9085U().mo10266a());
    }

    public View createNativeView(Context context, ViewGroup viewGroup) {
        return this.adChoiceOverlay.mo10206a(this.delegate.createNativeView(context, viewGroup));
    }

    public void renderNativeView(RendererHelper rendererHelper, View view, CriteoNativeAd criteoNativeAd) {
        View c = this.adChoiceOverlay.mo10208c(view);
        if (c != null) {
            this.delegate.renderNativeView(rendererHelper, c, criteoNativeAd);
        }
    }

    AdChoiceOverlayNativeRenderer(CriteoNativeRenderer criteoNativeRenderer, C2354b bVar) {
        this.delegate = criteoNativeRenderer;
        this.adChoiceOverlay = bVar;
    }
}
