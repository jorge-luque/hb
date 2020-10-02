package com.vungle.warren;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p074ui.CloseDelegate;
import com.vungle.warren.p074ui.OrientationDelegate;
import com.vungle.warren.p074ui.contract.AdContract;
import com.vungle.warren.p074ui.state.BundleOptionsState;
import com.vungle.warren.p074ui.state.OptionsState;
import com.vungle.warren.p074ui.view.FullAdWidget;
import java.util.concurrent.atomic.AtomicBoolean;
import p075d.p090g.p091a.C3218a;

public abstract class AdActivity extends Activity {
    public static final String PLACEMENT_EXTRA = "placement";
    public static final String PRESENTER_STATE = "presenter_state";
    private static final String TAG = "VungleActivity";
    /* access modifiers changed from: private */
    public static AdContract.AdvertisementPresenter.EventListener bus;
    private BroadcastReceiver broadcastReceiver;
    private PresentationFactory.FullScreenCallback fullscreenCallback = new PresentationFactory.FullScreenCallback() {
        public void onResult(Pair<AdContract.AdView, AdContract.AdvertisementPresenter> pair, VungleException vungleException) {
            if (pair == null || vungleException != null) {
                PresentationFactory unused = AdActivity.this.presenterFactory = null;
                AdActivity adActivity = AdActivity.this;
                adActivity.deliverError(10, adActivity.placementId);
                AdActivity.this.finish();
                return;
            }
            AdContract.AdvertisementPresenter unused2 = AdActivity.this.presenter = (AdContract.AdvertisementPresenter) pair.second;
            AdActivity.this.presenter.setEventListener(AdActivity.bus);
            AdActivity.this.presenter.attach((AdContract.AdView) pair.first, AdActivity.this.state);
            if (AdActivity.this.pendingStart.getAndSet(false)) {
                AdActivity.this.start();
            }
        }
    };
    /* access modifiers changed from: private */
    public AtomicBoolean pendingStart = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public String placementId;
    /* access modifiers changed from: private */
    public AdContract.AdvertisementPresenter presenter;
    /* access modifiers changed from: private */
    public PresentationFactory presenterFactory;
    private boolean resumed = false;
    private boolean started = false;
    /* access modifiers changed from: private */
    public OptionsState state;

    private void connectBroadcastReceiver() {
        this.broadcastReceiver = new BroadcastReceiver() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onReceive(android.content.Context r4, android.content.Intent r5) {
                /*
                    r3 = this;
                    java.lang.String r4 = "command"
                    java.lang.String r4 = r5.getStringExtra(r4)
                    int r0 = r4.hashCode()
                    r1 = -1884364225(0xffffffff8faee23f, float:-1.7244872E-29)
                    r2 = 1
                    if (r0 == r1) goto L_0x0020
                    r1 = -482896367(0xffffffffe3379611, float:-3.3865676E21)
                    if (r0 == r1) goto L_0x0016
                    goto L_0x002a
                L_0x0016:
                    java.lang.String r0 = "closeFlex"
                    boolean r0 = r4.equals(r0)
                    if (r0 == 0) goto L_0x002a
                    r0 = 0
                    goto L_0x002b
                L_0x0020:
                    java.lang.String r0 = "stopAll"
                    boolean r0 = r4.equals(r0)
                    if (r0 == 0) goto L_0x002a
                    r0 = 1
                    goto L_0x002b
                L_0x002a:
                    r0 = -1
                L_0x002b:
                    if (r0 == 0) goto L_0x004c
                    if (r0 != r2) goto L_0x0035
                    com.vungle.warren.AdActivity r4 = com.vungle.warren.AdActivity.this
                    r4.finish()
                    goto L_0x0063
                L_0x0035:
                    java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "No such command "
                    r0.append(r1)
                    r0.append(r4)
                    java.lang.String r4 = r0.toString()
                    r5.<init>(r4)
                    throw r5
                L_0x004c:
                    java.lang.String r4 = "placement"
                    java.lang.String r4 = r5.getStringExtra(r4)
                    com.vungle.warren.AdActivity r5 = com.vungle.warren.AdActivity.this
                    com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter r5 = r5.presenter
                    if (r5 == 0) goto L_0x0063
                    com.vungle.warren.AdActivity r5 = com.vungle.warren.AdActivity.this
                    com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter r5 = r5.presenter
                    r5.handleExit(r4)
                L_0x0063:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdActivity.C53863.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        C3218a.m10641a(getApplicationContext()).mo18871a(this.broadcastReceiver, new IntentFilter(AdContract.AdvertisementBus.ACTION));
    }

    /* access modifiers changed from: private */
    public void deliverError(int i, String str) {
        AdContract.AdvertisementPresenter.EventListener eventListener = bus;
        if (eventListener != null) {
            eventListener.onError(new VungleException(i), str);
        }
    }

    protected static AdContract.AdvertisementPresenter.EventListener getEventListener() {
        return bus;
    }

    public static void setEventListener(AdContract.AdvertisementPresenter.EventListener eventListener) {
        bus = eventListener;
    }

    /* access modifiers changed from: private */
    public void start() {
        if (this.presenter == null) {
            this.pendingStart.set(true);
        } else if (!this.started && this.resumed && hasWindowFocus()) {
            this.presenter.start();
            this.started = true;
        }
    }

    private void stop() {
        if (this.presenter != null && this.started) {
            this.presenter.stop(isChangingConfigurations() | (isFinishing() ? (char) 2 : 0) ? 1 : 0);
            this.started = false;
        }
        this.pendingStart.set(false);
    }

    /* access modifiers changed from: protected */
    public abstract boolean canRotate();

    @SuppressLint({"ResourceType"})
    public void onBackPressed() {
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.handleExit((String) null);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != 2) {
        }
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.onViewConfigurationChanged();
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        OptionsState optionsState;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(16777216, 16777216);
        this.placementId = getIntent().getStringExtra("placement");
        ServiceLocator instance = ServiceLocator.getInstance(this);
        if (!((VungleStaticApi) instance.getService(VungleStaticApi.class)).isInitialized() || bus == null || TextUtils.isEmpty(this.placementId)) {
            finish();
            return;
        }
        try {
            FullAdWidget fullAdWidget = new FullAdWidget(this, getWindow());
            this.presenterFactory = (PresentationFactory) instance.getService(PresentationFactory.class);
            if (bundle == null) {
                optionsState = null;
            } else {
                optionsState = (OptionsState) bundle.getParcelable(PRESENTER_STATE);
            }
            OptionsState optionsState2 = optionsState;
            this.state = optionsState2;
            this.presenterFactory.getFullScreenPresentation(this, this.placementId, fullAdWidget, optionsState2, new CloseDelegate() {
                public void close() {
                    AdActivity.this.finish();
                }
            }, new OrientationDelegate() {
                public void setOrientation(int i) {
                    AdActivity.this.setRequestedOrientation(i);
                }
            }, bundle, this.fullscreenCallback);
            setContentView(fullAdWidget, fullAdWidget.getLayoutParams());
            connectBroadcastReceiver();
        } catch (InstantiationException unused) {
            deliverError(10, this.placementId);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C3218a.m10641a(getApplicationContext()).mo18870a(this.broadcastReceiver);
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.detach(isChangingConfigurations());
        } else {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                AdContract.AdvertisementPresenter.EventListener eventListener = bus;
                if (eventListener != null) {
                    eventListener.onError(new VungleException(25), this.placementId);
                }
            }
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = getIntent().getStringExtra("placement");
        String stringExtra2 = intent.getStringExtra("placement");
        if (stringExtra != null && stringExtra2 != null && !stringExtra.equals(stringExtra2)) {
            "Tried to play another placement " + stringExtra2 + " while playing " + stringExtra;
            deliverError(15, stringExtra2);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.resumed = false;
        stop();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AdContract.AdvertisementPresenter advertisementPresenter;
        super.onRestoreInstanceState(bundle);
        "onRestoreInstanceState(" + bundle + ")";
        if (bundle != null && (advertisementPresenter = this.presenter) != null) {
            advertisementPresenter.restoreFromSave((OptionsState) bundle.getParcelable(PRESENTER_STATE));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.resumed = true;
        start();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        BundleOptionsState bundleOptionsState = new BundleOptionsState();
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.generateSaveState(bundleOptionsState);
            bundle.putParcelable(PRESENTER_STATE, bundleOptionsState);
        }
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null) {
            presentationFactory.saveState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            start();
        } else {
            stop();
        }
    }

    public void setRequestedOrientation(int i) {
        if (canRotate()) {
            super.setRequestedOrientation(i);
        }
    }
}
