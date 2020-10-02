package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.internal.bench.Benchmark;

@Keep
public interface AdListener {
    @Benchmark
    void onAdClicked(C2630Ad ad);

    @Benchmark
    void onAdLoaded(C2630Ad ad);

    @Benchmark
    void onError(C2630Ad ad, AdError adError);

    @Benchmark
    void onLoggingImpression(C2630Ad ad);
}
