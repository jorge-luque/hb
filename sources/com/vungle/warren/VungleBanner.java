package com.vungle.warren;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.vungle.warren.AdConfig;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p074ui.view.VungleNativeView;
import com.vungle.warren.utility.RefreshHandler;
import com.vungle.warren.utility.ViewUtility;
import com.vungle.warren.utility.WeakLoadAdCallback;
import com.vungle.warren.utility.WeakRunnable;

public class VungleBanner extends RelativeLayout {
    /* access modifiers changed from: private */
    public static final String TAG = VungleBanner.class.getSimpleName();
    /* access modifiers changed from: private */
    public AdConfig.AdSize adSize;
    /* access modifiers changed from: private */
    public VungleNativeView bannerAd;
    private int calculatedPixelHeight;
    private int calculatedPixelWidth;
    private boolean destroyed;
    private boolean disableRenderManagement;
    private LoadAdCallback loadAdCallback = new LoadAdCallback() {
        public void onAdLoad(String str) {
            String unused = VungleBanner.TAG;
            "Ad Loaded : " + str;
            if (VungleBanner.this.renderWhenAvailable && VungleBanner.this.canRender()) {
                boolean unused2 = VungleBanner.this.renderWhenAvailable = false;
                VungleBanner.this.finishAdInternal(false);
                AdConfig adConfig = new AdConfig();
                adConfig.setAdSize(VungleBanner.this.adSize);
                VungleNativeView nativeAdInternal = Vungle.getNativeAdInternal(str, adConfig, VungleBanner.this.playAdCallback);
                if (nativeAdInternal != null) {
                    VungleNativeView unused3 = VungleBanner.this.bannerAd = nativeAdInternal;
                    VungleBanner.this.renderAd();
                    return;
                }
                onError(VungleBanner.this.placementId, new VungleException(10));
            }
        }

        public void onError(String str, VungleException vungleException) {
            String unused = VungleBanner.TAG;
            "Ad Load Error : " + str + " Message : " + vungleException.getLocalizedMessage();
            if (VungleBanner.this.getVisibility() == 0 && VungleBanner.this.canRender()) {
                VungleBanner.this.refreshHandler.start();
            }
        }
    };
    /* access modifiers changed from: private */
    public String placementId;
    /* access modifiers changed from: private */
    public PlayAdCallback playAdCallback;
    private Runnable refreshAdRunnable = new Runnable() {
        public void run() {
            String unused = VungleBanner.TAG;
            boolean unused2 = VungleBanner.this.renderWhenAvailable = true;
            VungleBanner.this.loadAdInternal();
        }
    };
    /* access modifiers changed from: private */
    public RefreshHandler refreshHandler;
    private boolean renderAdRequested;
    /* access modifiers changed from: private */
    public boolean renderWhenAvailable;

    protected VungleBanner(Context context, String str, int i, AdConfig.AdSize adSize2, PlayAdCallback playAdCallback2) {
        super(context);
        this.placementId = str;
        this.adSize = adSize2;
        this.playAdCallback = playAdCallback2;
        this.calculatedPixelHeight = ViewUtility.dpToPixels(context, adSize2.getHeight());
        this.calculatedPixelWidth = ViewUtility.dpToPixels(context, adSize2.getWidth());
        AdConfig adConfig = new AdConfig();
        adConfig.setAdSize(adSize2);
        this.bannerAd = Vungle.getNativeAdInternal(str, adConfig, this.playAdCallback);
        this.refreshHandler = new RefreshHandler(new WeakRunnable(this.refreshAdRunnable), ((long) i) * 1000);
    }

    /* access modifiers changed from: private */
    public boolean canRender() {
        return !this.destroyed && (!this.disableRenderManagement || this.renderAdRequested);
    }

    /* access modifiers changed from: private */
    public void finishAdInternal(boolean z) {
        synchronized (this) {
            this.refreshHandler.clean();
            if (this.bannerAd != null) {
                this.bannerAd.finishDisplayingAdInternal(z);
                this.bannerAd = null;
                removeAllViews();
            }
        }
    }

    public void destroyAd() {
        finishAdInternal(true);
        this.destroyed = true;
        this.playAdCallback = null;
    }

    public void disableLifeCycleManagement(boolean z) {
        this.disableRenderManagement = z;
    }

    public void finishAd() {
        finishAdInternal(true);
    }

    /* access modifiers changed from: protected */
    public void loadAdInternal() {
        Banners.loadBanner(this.placementId, this.adSize, new WeakLoadAdCallback(this.loadAdCallback));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.disableRenderManagement) {
            renderAd();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.disableRenderManagement) {
            finishAdInternal(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        setAdVisibility(i == 0);
    }

    public void onWindowFocusChanged(boolean z) {
        setAdVisibility(z);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        "Banner onWindowVisibilityChanged: " + i;
        setAdVisibility(i == 0);
    }

    public void renderAd() {
        this.renderAdRequested = true;
        if (getVisibility() == 0) {
            VungleNativeView vungleNativeView = this.bannerAd;
            if (vungleNativeView != null) {
                View renderNativeView = vungleNativeView.renderNativeView();
                if (renderNativeView.getParent() != this) {
                    addView(renderNativeView, this.calculatedPixelWidth, this.calculatedPixelHeight);
                }
                "Rendering new ad for: " + this.placementId;
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.calculatedPixelHeight;
                    layoutParams.width = this.calculatedPixelWidth;
                    requestLayout();
                }
                this.refreshHandler.start();
            } else if (canRender()) {
                this.renderWhenAvailable = true;
                loadAdInternal();
            }
        }
    }

    public void setAdVisibility(boolean z) {
        if (!z || !canRender()) {
            this.refreshHandler.pause();
        } else {
            this.refreshHandler.start();
        }
        VungleNativeView vungleNativeView = this.bannerAd;
        if (vungleNativeView != null) {
            vungleNativeView.setAdVisibility(z);
        }
    }
}
