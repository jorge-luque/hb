package com.vungle.warren.p074ui.view;

import android.content.Context;
import com.vungle.warren.p074ui.CloseDelegate;
import com.vungle.warren.p074ui.OrientationDelegate;
import com.vungle.warren.p074ui.contract.WebAdContract;

/* renamed from: com.vungle.warren.ui.view.MRAIDAdView */
public class MRAIDAdView extends BaseAdView<WebAdContract.WebAdPresenter> implements WebAdContract.WebAdView {
    private WebAdContract.WebAdPresenter presenter;

    public MRAIDAdView(Context context, FullAdWidget fullAdWidget, OrientationDelegate orientationDelegate, CloseDelegate closeDelegate) {
        super(context, fullAdWidget, orientationDelegate, closeDelegate);
    }

    public void setVisibility(boolean z) {
        this.view.setVisibility(z ? 0 : 8);
    }

    public void showWebsite(String str) {
        this.view.showWebsite(str);
    }

    public void updateWindow(boolean z) {
        this.view.updateWindow(z);
    }

    public void setPresenter(WebAdContract.WebAdPresenter webAdPresenter) {
        this.presenter = webAdPresenter;
    }
}
