package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.C4342p;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import java.util.Map;

public class ReactiveVideoTrackerPlugin implements C4336n<ReactiveVideoTracker> {
    /* access modifiers changed from: private */

    /* renamed from: ˎ */
    public final String f11481;

    /* renamed from: com.moat.analytics.mobile.ogury.ReactiveVideoTrackerPlugin$c */
    static class C4306c implements ReactiveVideoTracker {
        C4306c() {
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

        public final boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
            return false;
        }
    }

    public ReactiveVideoTrackerPlugin(String str) {
        this.f11481 = str;
    }

    public ReactiveVideoTracker create() throws C4332l {
        return (ReactiveVideoTracker) C4342p.m14534(new C4342p.C4344b<ReactiveVideoTracker>() {
            /* renamed from: ˏ */
            public final Optional<ReactiveVideoTracker> mo29084() {
                C4315e.C43161.m14446("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return Optional.m14414of(new C4368y(ReactiveVideoTrackerPlugin.this.f11481));
            }
        }, ReactiveVideoTracker.class);
    }

    public ReactiveVideoTracker createNoOp() {
        return new C4306c();
    }
}
