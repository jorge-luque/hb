package com.criteo.publisher;

import android.view.View;

public interface CriteoBannerAdListener extends CriteoAdListener {
    void onAdReceived(View view);
}
