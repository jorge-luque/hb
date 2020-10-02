package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.C3145gz;
import com.tapjoy.internal.C5086fm;
import com.tapjoy.internal.C5093fq;
import com.tapjoy.internal.C5125gn;

public class TJAdUnitActivity extends Activity implements View.OnClickListener {

    /* renamed from: c */
    private static TJAdUnitActivity f12914c;
    /* access modifiers changed from: package-private */

    /* renamed from: a */
    public TJAdUnit f12915a;

    /* renamed from: b */
    private final Handler f12916b = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private TJPlacementData f12917d;

    /* renamed from: e */
    private TJAdUnitSaveStateData f12918e = new TJAdUnitSaveStateData();

    /* renamed from: f */
    private RelativeLayout f12919f = null;

    /* renamed from: g */
    private TJCloseButton f12920g;

    /* renamed from: h */
    private ProgressBar f12921h;

    /* renamed from: i */
    private boolean f12922i = false;

    public void handleClose() {
        handleClose(false);
    }

    public void onBackPressed() {
        handleClose();
    }

    public void onClick(View view) {
        handleClose();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f12915a.notifyOrientationChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        TapjoyLog.m16649d("TJAdUnitActivity", "TJAdUnitActivity onCreate: " + bundle);
        super.onCreate(bundle);
        f12914c = this;
        if (bundle != null) {
            TJAdUnitSaveStateData tJAdUnitSaveStateData = (TJAdUnitSaveStateData) bundle.getSerializable("ad_unit_bundle");
            this.f12918e = tJAdUnitSaveStateData;
            if (tJAdUnitSaveStateData != null && tJAdUnitSaveStateData.isVideoComplete) {
                TapjoyLog.m16649d("TJAdUnitActivity", "finishing TJAdUnitActivity");
                finish();
                return;
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null || extras.getSerializable(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA) == null) {
            TapjoyLog.m16650e("TJAdUnitActivity", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Failed to launch AdUnit Activity"));
            finish();
            return;
        }
        TJPlacementData tJPlacementData = (TJPlacementData) extras.getSerializable(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA);
        this.f12917d = tJPlacementData;
        if (tJPlacementData.getContentViewId() != null) {
            TapjoyConnectCore.viewWillOpen(this.f12917d.getContentViewId(), 1);
        }
        if (TJPlacementManager.m16592a(this.f12917d.getKey()) != null) {
            this.f12915a = TJPlacementManager.m16592a(this.f12917d.getKey()).getAdUnit();
        } else {
            this.f12915a = new TJAdUnit();
            this.f12915a.setAdContentTracker(new C5086fm(this.f12917d.getPlacementName(), this.f12917d.getPlacementType()));
        }
        if (!this.f12915a.hasCalledLoad()) {
            TapjoyLog.m16649d("TJAdUnitActivity", "No content loaded for ad unit -- loading now");
            this.f12915a.load(this.f12917d, false, this);
        }
        this.f12915a.setAdUnitActivity(this);
        if (Build.VERSION.SDK_INT < 11) {
            setTheme(16973829);
        } else {
            requestWindowFeature(1);
            getWindow().setFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f12919f = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f12919f.setBackgroundColor(0);
        TJWebView backgroundWebView = this.f12915a.getBackgroundWebView();
        backgroundWebView.setLayoutParams(layoutParams);
        if (backgroundWebView.getParent() != null) {
            ((ViewGroup) backgroundWebView.getParent()).removeView(backgroundWebView);
        }
        TJWebView webView = this.f12915a.getWebView();
        webView.setLayoutParams(layoutParams);
        if (webView.getParent() != null) {
            ((ViewGroup) webView.getParent()).removeView(webView);
        }
        this.f12919f.addView(backgroundWebView);
        VideoView videoView = this.f12915a.getVideoView();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        if (videoView.getParent() != null) {
            ((ViewGroup) videoView.getParent()).removeView(videoView);
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(17);
        linearLayout.addView(videoView, new LinearLayout.LayoutParams(-1, -1));
        this.f12919f.addView(linearLayout, layoutParams2);
        this.f12919f.addView(webView);
        this.f12921h = new ProgressBar(this, (AttributeSet) null, 16842874);
        if (this.f12917d.hasProgressSpinner()) {
            setProgressSpinnerVisibility(true);
        } else {
            setProgressSpinnerVisibility(false);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.f12921h.setLayoutParams(layoutParams3);
        this.f12919f.addView(this.f12921h);
        TJCloseButton tJCloseButton = new TJCloseButton(this);
        this.f12920g = tJCloseButton;
        tJCloseButton.setOnClickListener(this);
        this.f12919f.addView(this.f12920g);
        setContentView(this.f12919f);
        this.f12915a.setVisible(true);
        TJCorePlacement a = TJPlacementManager.m16592a(this.f12917d.getKey());
        if (a != null) {
            String str = TJCorePlacement.f12993a;
            TapjoyLog.m16652i(str, "Content shown for placement " + a.f12996c.getPlacementName());
            a.f12999f.mo31263a();
            TJPlacement a2 = a.mo30682a("SHOW");
            if (a2 != null && a2.getListener() != null) {
                a2.getListener().onContentShow(a2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        TJPlacement a;
        TJPlacementListener tJPlacementListener;
        super.onDestroy();
        f12914c = null;
        TapjoyLog.m16649d("TJAdUnitActivity", "onDestroy");
        TJAdUnit tJAdUnit = this.f12915a;
        if (tJAdUnit != null) {
            tJAdUnit.destroy();
        }
        TJPlacementData tJPlacementData = this.f12917d;
        if (tJPlacementData != null && tJPlacementData.isBaseActivity()) {
            if (this.f12917d.getContentViewId() != null) {
                TapjoyConnectCore.viewDidClose(this.f12917d.getContentViewId());
            }
            TJCorePlacement a2 = TJPlacementManager.m16592a(this.f12917d.getKey());
            if (a2 != null && (a = a2.mo30682a("SHOW")) != null && a.getListener() != null) {
                String str = TJCorePlacement.f12993a;
                TapjoyLog.m16652i(str, "Content dismissed for placement " + a2.f12996c.getPlacementName());
                C5093fq fqVar = a2.f12999f.f13955a;
                if (fqVar != null) {
                    fqVar.f13946b.clear();
                }
                if (a != null && (tJPlacementListener = a.f13057a) != null) {
                    tJPlacementListener.onContentDismiss(a);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        TapjoyLog.m16649d("TJAdUnitActivity", "onPause");
        this.f12915a.pause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        TapjoyLog.m16649d("TJAdUnitActivity", "onResume");
        super.onResume();
        if (this.f12915a.isLockedOrientation()) {
            setRequestedOrientation(this.f12915a.getLockedOrientation());
        }
        this.f12915a.resume(this.f12918e);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TapjoyLog.m16649d("TJAdUnitActivity", "onSaveInstanceState");
        this.f12918e.seekTime = this.f12915a.getVideoSeekTime();
        this.f12918e.isVideoComplete = this.f12915a.isVideoComplete();
        this.f12918e.isVideoMuted = this.f12915a.isMuted();
        bundle.putSerializable("ad_unit_bundle", this.f12918e);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        TapjoyLog.m16649d("TJAdUnitActivity", "onStart");
        if (C3145gz.m10321a().f8770n) {
            this.f12922i = true;
            C5125gn.m17284a(this);
        }
        if (!this.f12917d.isBaseActivity()) {
            setResult(-1, getIntent());
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (this.f12922i) {
            this.f12922i = false;
            C5125gn.m17289b(this);
        }
        super.onStop();
        TapjoyLog.m16649d("TJAdUnitActivity", "onStop");
    }

    public void setCloseButtonClickable(boolean z) {
        this.f12920g.setClickableRequested(z);
    }

    public void setCloseButtonVisibility(boolean z) {
        if (z) {
            this.f12920g.setVisibility(0);
        } else {
            this.f12920g.setVisibility(4);
        }
    }

    public void setProgressSpinnerVisibility(boolean z) {
        if (z) {
            this.f12921h.setVisibility(0);
        } else {
            this.f12921h.setVisibility(4);
        }
    }

    public void showErrorDialog() {
        if (isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            new AlertDialog.Builder(this, 16974394).setMessage("An error occured. Please try again later.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TJAdUnitActivity.this.handleClose();
                    dialogInterface.cancel();
                }
            }).create().show();
        } else {
            new AlertDialog.Builder(this).setMessage("An error occured. Please try again later.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TJAdUnitActivity.this.handleClose();
                    dialogInterface.cancel();
                }
            }).create().show();
        }
    }

    /* renamed from: a */
    static void m16538a() {
        TJAdUnitActivity tJAdUnitActivity = f12914c;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.handleClose(true);
        }
    }

    public void handleClose(boolean z) {
        if (!this.f12915a.getCloseRequested()) {
            TapjoyLog.m16649d("TJAdUnitActivity", TJAdUnitConstants.String.CLOSE_REQUESTED);
            this.f12915a.closeRequested(z);
            this.f12916b.postDelayed(new Runnable() {
                public final void run() {
                    if (TJAdUnitActivity.this.f12915a.getCloseRequested()) {
                        TapjoyLog.m16649d("TJAdUnitActivity", "Did not receive callback from content. Closing ad.");
                        TJAdUnitActivity.this.finish();
                    }
                }
            }, 1000);
        }
    }
}
