package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.NativeDisplayTracker;
import java.util.Map;

abstract class NoOp {

    public static class MoatAnalytics extends MoatAnalytics {
        public void prepareNativeDisplayTracking(String str) {
        }

        public void start(Application application) {
        }

        public void start(MoatOptions moatOptions, Application application) {
        }
    }

    public static class MoatFactory extends MoatFactory {
        public <T> T createCustomTracker(C4336n<T> nVar) {
            return nVar.createNoOp();
        }

        public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
            return new C4304d();
        }

        public NativeVideoTracker createNativeVideoTracker(String str) {
            return new C4302a();
        }

        public WebAdTracker createWebAdTracker(WebView webView) {
            return new C4303b();
        }

        public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
            return new C4303b();
        }
    }

    /* renamed from: com.moat.analytics.mobile.ogury.NoOp$a */
    static class C4302a implements NativeVideoTracker {
        C4302a() {
        }

        public final void changeTargetView(View view) {
        }

        public final void dispatchEvent(MoatAdEvent moatAdEvent) {
        }

        public final void removeListener() {
        }

        public final void removeVideoListener() {
        }

        public final void setActivity(Activity activity) {
        }

        public final void setListener(TrackerListener trackerListener) {
        }

        public final void setPlayerVolume(Double d) {
        }

        public final void setVideoListener(VideoTrackerListener videoTrackerListener) {
        }

        public final void stopTracking() {
        }

        public final boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
            return false;
        }
    }

    /* renamed from: com.moat.analytics.mobile.ogury.NoOp$b */
    static class C4303b implements WebAdTracker {
        C4303b() {
        }

        public final void removeListener() {
        }

        public final void setActivity(Activity activity) {
        }

        public final void setListener(TrackerListener trackerListener) {
        }

        public final void startTracking() {
        }

        public final void stopTracking() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.ogury.NoOp$d */
    static class C4304d implements NativeDisplayTracker {
        C4304d() {
        }

        public final void removeListener() {
        }

        public final void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType moatUserInteractionType) {
        }

        public final void setActivity(Activity activity) {
        }

        public final void setListener(TrackerListener trackerListener) {
        }

        public final void startTracking() {
        }

        public final void stopTracking() {
        }
    }

    NoOp() {
    }
}
