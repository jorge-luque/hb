package com.vungle.warren;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p074ui.CloseDelegate;
import com.vungle.warren.p074ui.OrientationDelegate;
import com.vungle.warren.p074ui.contract.AdContract;
import com.vungle.warren.p074ui.contract.WebAdContract;
import com.vungle.warren.p074ui.state.OptionsState;
import com.vungle.warren.p074ui.view.FullAdWidget;
import com.vungle.warren.p074ui.view.VungleWebClient;

public interface PresentationFactory {

    public interface FullScreenCallback {
        void onResult(Pair<AdContract.AdView, AdContract.AdvertisementPresenter> pair, VungleException vungleException);
    }

    public interface ViewCallback {
        void onResult(Pair<WebAdContract.WebAdPresenter, VungleWebClient> pair, VungleException vungleException);
    }

    void destroy();

    void getFullScreenPresentation(Context context, String str, FullAdWidget fullAdWidget, OptionsState optionsState, CloseDelegate closeDelegate, OrientationDelegate orientationDelegate, Bundle bundle, FullScreenCallback fullScreenCallback);

    void getNativeViewPresentation(String str, AdConfig adConfig, CloseDelegate closeDelegate, ViewCallback viewCallback);

    void saveState(Bundle bundle);
}
