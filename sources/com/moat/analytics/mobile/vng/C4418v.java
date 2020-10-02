package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.app.Application;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.vng.NativeDisplayTracker;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.vng.v */
abstract class C4418v {

    /* renamed from: com.moat.analytics.mobile.vng.v$a */
    public static class C4419a extends MoatAnalytics {
        public void prepareNativeDisplayTracking(String str) {
        }

        public void start(Application application) {
        }

        public void start(MoatOptions moatOptions, Application application) {
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.v$b */
    public static class C4420b extends MoatFactory {
        public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
            return moatPlugin.mo29205b();
        }

        public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
            return new C4421c();
        }

        public NativeVideoTracker createNativeVideoTracker(String str) {
            return new C4422d();
        }

        public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
            return new C4423e();
        }

        public WebAdTracker createWebAdTracker(WebView webView) {
            return new C4423e();
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.v$c */
    static class C4421c implements NativeDisplayTracker {
        C4421c() {
        }

        public void removeListener() {
        }

        public void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType moatUserInteractionType) {
        }

        public void setActivity(Activity activity) {
        }

        public void setListener(TrackerListener trackerListener) {
        }

        public void startTracking() {
        }

        public void stopTracking() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.v$d */
    static class C4422d implements NativeVideoTracker {
        C4422d() {
        }

        public void changeTargetView(View view) {
        }

        public void dispatchEvent(MoatAdEvent moatAdEvent) {
        }

        public void removeListener() {
        }

        public void removeVideoListener() {
        }

        public void setActivity(Activity activity) {
        }

        public void setListener(TrackerListener trackerListener) {
        }

        public void setPlayerVolume(Double d) {
        }

        public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        }

        public void stopTracking() {
        }

        public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
            return false;
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.v$e */
    static class C4423e implements WebAdTracker {
        C4423e() {
        }

        public void removeListener() {
        }

        public void setActivity(Activity activity) {
        }

        public void setListener(TrackerListener trackerListener) {
        }

        public void startTracking() {
        }

        public void stopTracking() {
        }
    }

    C4418v() {
    }
}
