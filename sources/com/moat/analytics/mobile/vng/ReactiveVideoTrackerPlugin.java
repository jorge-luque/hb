package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.view.View;
import com.moat.analytics.mobile.vng.C4434x;
import com.moat.analytics.mobile.vng.p156a.p158b.C4374a;
import java.util.Map;

public class ReactiveVideoTrackerPlugin implements MoatPlugin<ReactiveVideoTracker> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f11710a;

    /* renamed from: com.moat.analytics.mobile.vng.ReactiveVideoTrackerPlugin$a */
    static class C4370a implements ReactiveVideoTracker {
        C4370a() {
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

        public boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
            return false;
        }
    }

    public ReactiveVideoTrackerPlugin(String str) {
        this.f11710a = str;
    }

    /* renamed from: c */
    public ReactiveVideoTracker mo29204a() {
        return (ReactiveVideoTracker) C4434x.m14829a(new C4434x.C4436a<ReactiveVideoTracker>() {
            /* renamed from: a */
            public C4374a<ReactiveVideoTracker> mo29234a() {
                C4409p.m14775a("[INFO] ", "Attempting to create ReactiveVideoTracker");
                return C4374a.m14625a(new C4438y(ReactiveVideoTrackerPlugin.this.f11710a));
            }
        }, ReactiveVideoTracker.class);
    }

    /* renamed from: d */
    public ReactiveVideoTracker mo29205b() {
        return new C4370a();
    }
}
