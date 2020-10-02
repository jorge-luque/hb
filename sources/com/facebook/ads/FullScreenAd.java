package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.C2630Ad;

public interface FullScreenAd extends C2630Ad {

    @Keep
    public interface ShowAdConfig {
    }

    @Keep
    public interface ShowConfigBuilder {
        ShowAdConfig build();
    }

    C2630Ad.LoadConfigBuilder buildLoadAdConfig();

    ShowConfigBuilder buildShowAdConfig();

    boolean show();
}
