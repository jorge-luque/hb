package com.criteo.publisher.advancednative;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.criteo.publisher.model.p055z.C2488n;

@Keep
public class CriteoNativeAd {
    private final C2354b adChoiceOverlay;
    private final C2488n assets;
    private final C2358e clickDetection;
    private final C2371l clickOnAdChoiceHandler;
    private final C2371l clickOnProductHandler;
    private final C2369j impressionTask;
    private CriteoNativeRenderer renderer;
    private final RendererHelper rendererHelper;
    private final C2374o visibilityTracker;

    public CriteoNativeAd(C2488n nVar, C2374o oVar, C2369j jVar, C2358e eVar, C2371l lVar, C2371l lVar2, C2354b bVar, CriteoNativeRenderer criteoNativeRenderer, RendererHelper rendererHelper2) {
        this.assets = nVar;
        this.visibilityTracker = oVar;
        this.impressionTask = jVar;
        this.clickDetection = eVar;
        this.clickOnProductHandler = lVar;
        this.clickOnAdChoiceHandler = lVar2;
        this.adChoiceOverlay = bVar;
        this.renderer = criteoNativeRenderer;
        this.rendererHelper = rendererHelper2;
    }

    public View createNativeRenderedView(Context context, ViewGroup viewGroup) {
        View createNativeView = this.renderer.createNativeView(context, viewGroup);
        renderNativeView(createNativeView);
        return createNativeView;
    }

    /* access modifiers changed from: package-private */
    public ImageView getAdChoiceView(View view) {
        return this.adChoiceOverlay.mo10207b(view);
    }

    public String getAdvertiserDescription() {
        return this.assets.mo10483b();
    }

    public String getAdvertiserDomain() {
        return this.assets.mo10484c();
    }

    public CriteoMedia getAdvertiserLogoMedia() {
        return CriteoMedia.create(this.assets.mo10486e());
    }

    public String getCallToAction() {
        return this.assets.mo10491m().mo10462a();
    }

    public String getDescription() {
        return this.assets.mo10491m().mo10464c();
    }

    public String getPrice() {
        return this.assets.mo10491m().mo10467f();
    }

    public CriteoMedia getProductMedia() {
        return CriteoMedia.create(this.assets.mo10491m().mo10493e());
    }

    public String getTitle() {
        return this.assets.mo10491m().mo10468g();
    }

    public void renderNativeView(View view) {
        this.renderer.renderNativeView(this.rendererHelper, view, this);
        watchForImpression(view);
        setProductClickableView(view);
        ImageView b = this.adChoiceOverlay.mo10207b(view);
        if (b != null) {
            setAdChoiceClickableView(b);
            this.rendererHelper.setMediaInView(this.assets.mo10490l(), b, (Drawable) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAdChoiceClickableView(View view) {
        this.clickDetection.mo10212a(view, this.clickOnAdChoiceHandler);
    }

    /* access modifiers changed from: package-private */
    public void setProductClickableView(View view) {
        this.clickDetection.mo10212a(view, this.clickOnProductHandler);
    }

    /* access modifiers changed from: package-private */
    public void setRenderer(CriteoNativeRenderer criteoNativeRenderer) {
        this.renderer = criteoNativeRenderer;
    }

    /* access modifiers changed from: package-private */
    public void watchForImpression(View view) {
        this.visibilityTracker.mo10229a(view, this.impressionTask);
    }
}
