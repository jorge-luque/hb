package com.criteo.publisher.advancednative;

import androidx.annotation.Keep;
import java.net.URL;

@Keep
public abstract class CriteoMedia {
    static CriteoMedia create(URL url) {
        return new C2357d(url);
    }

    /* access modifiers changed from: package-private */
    public abstract URL getImageUrl();
}
