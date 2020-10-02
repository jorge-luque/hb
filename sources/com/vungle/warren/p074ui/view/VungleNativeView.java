package com.vungle.warren.p074ui.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewManager;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.vungle.warren.AdConfig;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.VungleNativeAd;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p074ui.CloseDelegate;
import com.vungle.warren.p074ui.JavascriptBridge;
import com.vungle.warren.p074ui.contract.AdContract;
import com.vungle.warren.p074ui.contract.WebAdContract;
import com.vungle.warren.p074ui.state.OptionsState;
import com.vungle.warren.utility.ExternalRouter;
import java.util.concurrent.atomic.AtomicReference;
import p075d.p090g.p091a.C3218a;

/* renamed from: com.vungle.warren.ui.view.VungleNativeView */
public class VungleNativeView extends WebView implements WebAdContract.WebAdView, VungleNativeAd {
    private static final String TAG = VungleNativeView.class.getName();
    private BroadcastReceiver broadcastReceiver;
    private final AdConfig config;
    /* access modifiers changed from: private */
    public AtomicReference<Boolean> isAdVisible = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final AdContract.AdvertisementPresenter.EventListener listener;
    /* access modifiers changed from: private */
    public final String placementID;
    /* access modifiers changed from: private */
    public WebAdContract.WebAdPresenter presenter;
    PresentationFactory presenterFactory;

    public VungleNativeView(Context context, String str, AdConfig adConfig, PresentationFactory presentationFactory, AdContract.AdvertisementPresenter.EventListener eventListener) {
        super(context);
        this.listener = eventListener;
        this.placementID = str;
        this.config = adConfig;
        this.presenterFactory = presentationFactory;
        setLayerType(2, (Paint) null);
        setBackgroundColor(0);
    }

    /* access modifiers changed from: private */
    public void prepare(Bundle bundle) {
        WebSettingsUtils.applyDefault(this);
        addJavascriptInterface(new JavascriptBridge(this.presenter), "Android");
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT < 17) {
            setAdVisibility(true);
        } else {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    public void close() {
        WebAdContract.WebAdPresenter webAdPresenter = this.presenter;
        if (webAdPresenter == null) {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                this.listener.onError(new VungleException(25), this.placementID);
            }
        } else if (webAdPresenter.handleExit((String) null)) {
            finishDisplayingAdInternal(false);
        }
    }

    public void destroyAdView() {
        removeJavascriptInterface("Android");
        loadUrl("about:blank");
    }

    public void finishDisplayingAd() {
        finishDisplayingAdInternal(true);
    }

    public void finishDisplayingAdInternal(boolean z) {
        if (this.presenter != null) {
            this.presenter.stop((z ? 4 : 0) | 2);
        } else {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                this.listener.onError(new VungleException(25), this.placementID);
            }
        }
        destroyAdView();
    }

    public String getWebsiteUrl() {
        return getUrl();
    }

    public boolean hasWebView() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null && this.presenter == null) {
            presentationFactory.getNativeViewPresentation(this.placementID, this.config, new CloseDelegate() {
                public void close() {
                    VungleNativeView.this.finishDisplayingAdInternal(false);
                }
            }, new PresentationFactory.ViewCallback() {
                public void onResult(Pair<WebAdContract.WebAdPresenter, VungleWebClient> pair, VungleException vungleException) {
                    VungleNativeView vungleNativeView = VungleNativeView.this;
                    vungleNativeView.presenterFactory = null;
                    if (pair != null && vungleException == null) {
                        WebAdContract.WebAdPresenter unused = vungleNativeView.presenter = (WebAdContract.WebAdPresenter) pair.first;
                        VungleNativeView.this.setWebViewClient((VungleWebClient) pair.second);
                        VungleNativeView.this.presenter.setEventListener(VungleNativeView.this.listener);
                        VungleNativeView.this.presenter.attach(VungleNativeView.this, (OptionsState) null);
                        VungleNativeView.this.prepare((Bundle) null);
                        if (VungleNativeView.this.isAdVisible.get() != null) {
                            VungleNativeView vungleNativeView2 = VungleNativeView.this;
                            vungleNativeView2.setAdVisibility(((Boolean) vungleNativeView2.isAdVisible.get()).booleanValue());
                        }
                    } else if (VungleNativeView.this.listener != null) {
                        AdContract.AdvertisementPresenter.EventListener access$000 = VungleNativeView.this.listener;
                        if (vungleException == null) {
                            vungleException = new VungleException(10);
                        }
                        access$000.onError(vungleException, VungleNativeView.this.placementID);
                    }
                }
            });
        }
        this.broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (AdContract.AdvertisementBus.STOP_ALL.equalsIgnoreCase(intent.getStringExtra("command"))) {
                    VungleNativeView.this.finishDisplayingAdInternal(false);
                }
            }
        };
        C3218a.m10641a(getContext()).mo18871a(this.broadcastReceiver, new IntentFilter(AdContract.AdvertisementBus.ACTION));
        resumeWeb();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        C3218a.m10641a(getContext()).mo18870a(this.broadcastReceiver);
        super.onDetachedFromWindow();
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null) {
            presentationFactory.destroy();
        }
        pauseWeb();
    }

    public void onPause() {
        super.onPause();
        setAdVisibility(false);
    }

    public void onResume() {
        super.onResume();
        setAdVisibility(true);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        setAdVisibility(z);
    }

    public void open(String str) {
        "Opening " + str;
        if (!ExternalRouter.launch(str, getContext())) {
            Log.e(TAG, "Cannot open url " + str);
        }
    }

    public void pauseWeb() {
        onPause();
    }

    public void removeWebView() {
        ViewParent parent = getParent();
        if (parent instanceof ViewManager) {
            ((ViewManager) parent).removeView(this);
        }
    }

    public View renderNativeView() {
        return this;
    }

    public void resumeWeb() {
        onResume();
    }

    public void setAdVisibility(boolean z) {
        WebAdContract.WebAdPresenter webAdPresenter = this.presenter;
        if (webAdPresenter != null) {
            webAdPresenter.setAdVisibility(z);
        } else {
            this.isAdVisible.set(Boolean.valueOf(z));
        }
    }

    public void setImmersiveMode() {
    }

    public void setOrientation(int i) {
    }

    public void setPresenter(WebAdContract.WebAdPresenter webAdPresenter) {
    }

    public void setVisibility(boolean z) {
        setVisibility(z ? 0 : 4);
    }

    public void showCloseButton() {
        throw new UnsupportedOperationException("VungleNativeView does not implement a close button");
    }

    public void showDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        throw new UnsupportedOperationException("VungleNativeView does not implement a dialog.");
    }

    public void showWebsite(String str) {
        loadUrl(str);
    }

    public void updateWindow(boolean z) {
    }
}
