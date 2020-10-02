package com.moat.analytics.mobile.ogury;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.ogury.C4315e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.ogury.r */
final class C4355r extends C4325h implements NativeVideoTracker {

    /* renamed from: ͺ */
    private WeakReference<MediaPlayer> f11659;

    C4355r(String str) {
        super(str);
        C4315e.C43161.m14442(3, "NativeVideoTracker", this, "In initialization method.");
        if (str == null || str.isEmpty()) {
            StringBuilder sb = new StringBuilder("PartnerCode is ");
            sb.append(str == null ? "null" : "empty");
            String obj = sb.toString();
            String concat = "NativeDisplayTracker creation problem, ".concat(String.valueOf(obj));
            C4315e.C43161.m14442(3, "NativeVideoTracker", this, concat);
            C4315e.C43161.m14446("[ERROR] ", concat);
            this.f11498 = new C4332l(obj);
        }
        C4315e.C43161.m14446("[SUCCESS] ", "NativeVideoTracker created");
    }

    public final boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        try {
            mo29117();
            mo29112();
            if (mediaPlayer != null) {
                mediaPlayer.getCurrentPosition();
                this.f11659 = new WeakReference<>(mediaPlayer);
                return super.mo29132(map, view);
            }
            throw new C4332l("Null player instance");
        } catch (Exception unused) {
            throw new C4332l("Playback has already completed");
        } catch (Exception e) {
            C4332l.m14509(e);
            String r2 = C4332l.m14507("trackVideoAd", e);
            TrackerListener trackerListener = this.f11499;
            if (trackerListener != null) {
                trackerListener.onTrackingFailedToStart(r2);
            }
            C4315e.C43161.m14442(3, "NativeVideoTracker", this, r2);
            C4315e.C43161.m14446("[ERROR] ", "NativeVideoTracker ".concat(String.valueOf(r2)));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʻॱ */
    public final Integer mo29156() {
        return Integer.valueOf(this.f11659.get().getDuration());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public final void mo29110(List<String> list) throws C4332l {
        WeakReference<MediaPlayer> weakReference = this.f11659;
        if (!((weakReference == null || weakReference.get() == null) ? false : true)) {
            list.add("Player is null");
        }
        super.mo29110(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋॱ */
    public final boolean mo29157() {
        WeakReference<MediaPlayer> weakReference = this.f11659;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public final String mo29116() {
        return "NativeVideoTracker";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ͺ */
    public final Integer mo29158() {
        return Integer.valueOf(this.f11659.get().getCurrentPosition());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝ */
    public final Map<String, Object> mo29135() throws C4332l {
        MediaPlayer mediaPlayer = this.f11659.get();
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(mediaPlayer.getVideoWidth()));
        hashMap.put("height", Integer.valueOf(mediaPlayer.getVideoHeight()));
        hashMap.put("duration", Integer.valueOf(mediaPlayer.getDuration()));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝॱ */
    public final boolean mo29160() {
        return this.f11659.get().isPlaying();
    }
}
