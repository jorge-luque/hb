package com.criteo.publisher.advancednative;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;

@Keep
public interface CriteoNativeRenderer {
    View createNativeView(Context context, ViewGroup viewGroup);

    void renderNativeView(RendererHelper rendererHelper, View view, CriteoNativeAd criteoNativeAd);
}