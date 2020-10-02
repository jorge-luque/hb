package com.moat.analytics.mobile.vng;

import android.media.MediaPlayer;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.vng.u */
class C4417u extends C4389h implements NativeVideoTracker {

    /* renamed from: m */
    private WeakReference<MediaPlayer> f11853m;

    C4417u(String str) {
        super(str);
        C4409p.m14772a(3, "NativeVideoTracker", (Object) this, "In initialization method.");
        if (str == null || str.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("PartnerCode is ");
            sb.append(str == null ? "null" : "empty");
            String sb2 = sb.toString();
            C4409p.m14773a("[ERROR] ", 3, "NativeVideoTracker", this, "NativeDisplayTracker creation problem, " + sb2);
            this.f11720a = new C4403n(sb2);
        }
        C4409p.m14775a("[SUCCESS] ", mo29257a() + " created");
    }

    /* renamed from: a */
    private void m14799a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.getCurrentPosition();
            } catch (Exception unused) {
                throw new C4403n("Playback has already completed");
            }
        } else {
            throw new C4403n("Null player instance");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo29257a() {
        return "NativeVideoTracker";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29261a(List<String> list) {
        if (!mo29296n()) {
            list.add("Player is null");
        }
        super.mo29261a(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Map<String, Object> mo29279i() {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f11853m.get();
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(mediaPlayer.getVideoWidth()));
        hashMap.put("height", Integer.valueOf(mediaPlayer.getVideoHeight()));
        hashMap.put("duration", Integer.valueOf(mediaPlayer.getDuration()));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo29296n() {
        WeakReference<MediaPlayer> weakReference = this.f11853m;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public Integer mo29297o() {
        return Integer.valueOf(((MediaPlayer) this.f11853m.get()).getCurrentPosition());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo29299q() {
        return ((MediaPlayer) this.f11853m.get()).isPlaying();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public Integer mo29300r() {
        return Integer.valueOf(((MediaPlayer) this.f11853m.get()).getDuration());
    }

    public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        try {
            mo29263c();
            mo29265d();
            m14799a(mediaPlayer);
            this.f11853m = new WeakReference<>(mediaPlayer);
            return super.mo29277a(map, view);
        } catch (Exception e) {
            C4403n.m14758a(e);
            String a = C4403n.m14756a("trackVideoAd", e);
            TrackerListener trackerListener = this.f11723d;
            if (trackerListener != null) {
                trackerListener.onTrackingFailedToStart(a);
            }
            C4409p.m14772a(3, "NativeVideoTracker", (Object) this, a);
            C4409p.m14775a("[ERROR] ", mo29257a() + " " + a);
            return false;
        }
    }
}
