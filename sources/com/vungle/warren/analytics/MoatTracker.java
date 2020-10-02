package com.vungle.warren.analytics;

import android.text.TextUtils;
import android.util.Pair;
import android.widget.VideoView;
import com.moat.analytics.mobile.vng.MoatAdEvent;
import com.moat.analytics.mobile.vng.MoatAdEventType;
import com.moat.analytics.mobile.vng.ReactiveVideoTracker;
import com.vungle.warren.model.Advertisement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MoatTracker implements AnalyticsVideoTracker {
    private static final String TAG = "MoatTracker";
    private static final String UNKNOWN = "unknown";
    public static final String VUNGLE_ID = "vunglenativevideo893259554489";
    private Map<String, String> adIds = new HashMap();
    private boolean configured;
    private boolean isMoatEnabled;
    private Queue<Pair<Integer, MoatAdEventType>> moatQuartileTrackers;
    private ReactiveVideoTracker tracker;
    private VideoView videoView;

    private MoatTracker(VideoView videoView2, boolean z) {
        this.isMoatEnabled = z;
        this.videoView = videoView2;
    }

    public static MoatTracker connect(VideoView videoView2, boolean z) {
        return new MoatTracker(videoView2, z);
    }

    public void configure(String str, Advertisement advertisement, String str2, ReactiveVideoTracker reactiveVideoTracker) {
        this.tracker = reactiveVideoTracker;
        boolean z = true;
        boolean z2 = this.isMoatEnabled && !TextUtils.isEmpty(str) && advertisement != null && advertisement.getMoatEnabled();
        this.isMoatEnabled = z2;
        if (z2) {
            LinkedList linkedList = new LinkedList();
            this.moatQuartileTrackers = linkedList;
            linkedList.add(new Pair(0, MoatAdEventType.AD_EVT_START));
            this.moatQuartileTrackers.add(new Pair(25, MoatAdEventType.AD_EVT_FIRST_QUARTILE));
            this.moatQuartileTrackers.add(new Pair(50, MoatAdEventType.AD_EVT_MID_POINT));
            this.moatQuartileTrackers.add(new Pair(75, MoatAdEventType.AD_EVT_THIRD_QUARTILE));
            if (!advertisement.getMoatVastExtra().isEmpty()) {
                this.adIds.put("zMoatVASTIDs", advertisement.getMoatVastExtra());
            }
            this.adIds.put("level1", advertisement.getAdvertiserAppId());
            this.adIds.put("level2", advertisement.getCampaignId());
            this.adIds.put("level3", advertisement.getCreativeId());
            Map<String, String> map = this.adIds;
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("level4", str);
            if (!TextUtils.isEmpty(str2)) {
                this.adIds.put("slicer1", str2);
            }
            this.configured = true;
        }
        if (!this.configured || !this.isMoatEnabled) {
            z = false;
        }
        this.configured = z;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getAdIds() {
        return this.adIds;
    }

    public void onProgress(int i) {
        if (!this.configured) {
            return;
        }
        if (i >= 100) {
            this.tracker.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE, Integer.valueOf(this.videoView.getCurrentPosition())));
            this.tracker.stopTracking();
        } else if (!this.moatQuartileTrackers.isEmpty() && i >= ((Integer) this.moatQuartileTrackers.peek().first).intValue()) {
            this.tracker.dispatchEvent(new MoatAdEvent((MoatAdEventType) this.moatQuartileTrackers.poll().second, Integer.valueOf(i)));
        }
    }

    public void setPlayerVolume(boolean z) {
        if (this.configured) {
            "setPlayerVolume muted: " + z;
            if (z) {
                this.tracker.setPlayerVolume(MoatAdEvent.VOLUME_MUTED);
            } else {
                this.tracker.setPlayerVolume(MoatAdEvent.VOLUME_UNMUTED);
            }
        }
    }

    public void start(int i) {
        if (this.configured) {
            this.tracker.trackVideoAd(this.adIds, Integer.valueOf(i), this.videoView);
        }
    }

    public void stop() {
        if (this.configured) {
            VideoView videoView2 = this.videoView;
            int currentPosition = videoView2 != null ? videoView2.getCurrentPosition() : 0;
            "stopViewabilityTracker: " + currentPosition;
            this.tracker.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_STOPPED, Integer.valueOf(currentPosition)));
            this.tracker.stopTracking();
        }
    }
}
