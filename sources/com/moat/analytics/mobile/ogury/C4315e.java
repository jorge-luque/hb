package com.moat.analytics.mobile.ogury;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.moat.analytics.mobile.ogury.C4311d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.ogury.e */
abstract class C4315e extends C4310c {

    /* renamed from: ʽ */
    static final MoatAdEventType[] f11515 = {MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};

    /* renamed from: ʻ */
    final Map<MoatAdEventType, Integer> f11516;

    /* renamed from: ʼ */
    WeakReference<View> f11517;

    /* renamed from: ˊॱ */
    private Map<String, String> f11518;

    /* renamed from: ˋॱ */
    private final Set<MoatAdEventType> f11519;
    /* access modifiers changed from: private */

    /* renamed from: ˏॱ */
    public VideoTrackerListener f11520;

    /* renamed from: ͺ */
    private Double f11521;

    /* renamed from: ॱˊ */
    private boolean f11522;

    /* renamed from: ॱˎ */
    private final String f11523;

    /* renamed from: ॱॱ */
    final Handler f11524;
    /* access modifiers changed from: private */

    /* renamed from: ॱᐝ */
    public final C4311d f11525;

    /* renamed from: com.moat.analytics.mobile.ogury.e$1 */
    class C43161 implements Runnable {
        C43161() {
        }

        /* renamed from: ˋ */
        static void m14442(int i, String str, Object obj, String str2) {
            if (!C4346q.m14542().f11638) {
                return;
            }
            if (obj == null) {
                Log.println(i, "Moat".concat(String.valueOf(str)), String.format("message = %s", new Object[]{str2}));
                return;
            }
            Log.println(i, "Moat".concat(String.valueOf(str)), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}));
        }

        /* renamed from: ˎ */
        static void m14443(String str, Object obj, String str2) {
            Object obj2;
            if (C4346q.m14542().f11637) {
                String concat = "Moat".concat(String.valueOf(str));
                Object[] objArr = new Object[2];
                if (obj == null) {
                    obj2 = "null";
                } else {
                    obj2 = Integer.valueOf(obj.hashCode());
                }
                objArr[0] = obj2;
                objArr[1] = str2;
                Log.println(2, concat, String.format("id = %s, message = %s", objArr));
            }
        }

        /* renamed from: ˏ */
        static void m14445(String str, Object obj, String str2, Throwable th) {
            if (C4346q.m14542().f11638) {
                Log.e("Moat".concat(String.valueOf(str)), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}), th);
            }
        }

        /* renamed from: ॱ */
        static void m14446(String str, String str2) {
            if (!C4346q.m14542().f11638 && ((C4328i) MoatAnalytics.getInstance()).f11581) {
                int i = 2;
                if (str.equals("[ERROR] ")) {
                    i = 6;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str2);
                Log.println(i, "MoatAnalytics", sb.toString());
            }
        }

        public final void run() {
            try {
                m14442(3, "BaseVideoTracker", this, "Shutting down.");
                C4311d r0 = C4315e.this.f11525;
                m14442(3, "GlobalWebView", r0, "Cleaning up");
                r0.f11506.mo29140();
                r0.f11506 = null;
                r0.f11507.destroy();
                r0.f11507 = null;
                VideoTrackerListener unused = C4315e.this.f11520 = null;
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }

        C43161() {
        }

        /* renamed from: ˏ */
        static String m14444(View view) {
            if (view == null) {
                return "null";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(view.getClass().getSimpleName());
            sb.append("@");
            sb.append(view.hashCode());
            return sb.toString();
        }
    }

    C4315e(String str) {
        super((View) null, false, true);
        C43161.m14442(3, "BaseVideoTracker", this, "Initializing.");
        this.f11523 = str;
        C4311d dVar = new C4311d(C4307a.m14408(), C4311d.C4314b.f11514);
        this.f11525 = dVar;
        this.f11496 = dVar.f11506;
        try {
            super.mo29113(dVar.f11507);
        } catch (C4332l e) {
            this.f11498 = e;
        }
        this.f11516 = new HashMap();
        this.f11519 = new HashSet();
        this.f11524 = new Handler();
        this.f11522 = false;
        this.f11521 = Double.valueOf(1.0d);
    }

    /* renamed from: ॱ */
    static boolean m14432(Integer num, Integer num2) {
        int abs = Math.abs(num2.intValue() - num.intValue());
        double intValue = (double) num2.intValue();
        Double.isNaN(intValue);
        return ((double) abs) <= Math.min(750.0d, intValue * 0.05d);
    }

    public void changeTargetView(View view) {
        StringBuilder sb = new StringBuilder("changing view to ");
        sb.append(C43161.m14444(view));
        C43161.m14442(3, "BaseVideoTracker", this, sb.toString());
        this.f11517 = new WeakReference<>(view);
        try {
            super.changeTargetView(view);
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        try {
            JSONObject r0 = mo29130(moatAdEvent);
            boolean z = false;
            C43161.m14442(3, "BaseVideoTracker", this, String.format("Received event: %s", new Object[]{r0.toString()}));
            StringBuilder sb = new StringBuilder();
            sb.append(mo29116());
            sb.append(String.format(" Received event: %s", new Object[]{r0.toString()}));
            C43161.m14446("[SUCCESS] ", sb.toString());
            if (mo29111() && this.f11496 != null) {
                this.f11496.mo29146(this.f11525.f11509, r0);
                if (!this.f11519.contains(moatAdEvent.f11474)) {
                    this.f11519.add(moatAdEvent.f11474);
                    if (this.f11520 != null) {
                        this.f11520.onVideoEventReported(moatAdEvent.f11474);
                    }
                }
            }
            MoatAdEventType moatAdEventType = moatAdEvent.f11474;
            if (moatAdEventType == MoatAdEventType.AD_EVT_COMPLETE || moatAdEventType == MoatAdEventType.AD_EVT_STOPPED || moatAdEventType == MoatAdEventType.AD_EVT_SKIPPED) {
                z = true;
            }
            if (z) {
                this.f11516.put(moatAdEventType, 1);
                if (this.f11496 != null) {
                    this.f11496.mo29144((C4310c) this);
                }
                mo29133();
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    public void removeVideoListener() {
        this.f11520 = null;
    }

    public void setPlayerVolume(Double d) {
        Double valueOf = Double.valueOf(this.f11521.doubleValue() * C4356s.m14572());
        if (!d.equals(this.f11521)) {
            C43161.m14442(3, "BaseVideoTracker", this, String.format(Locale.ROOT, "player volume changed to %f ", new Object[]{d}));
            this.f11521 = d;
            if (!valueOf.equals(Double.valueOf(d.doubleValue() * C4356s.m14572()))) {
                dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.f11471, this.f11521));
            }
        }
    }

    public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        this.f11520 = videoTrackerListener;
    }

    public void stopTracking() {
        try {
            super.stopTracking();
            mo29133();
            if (this.f11520 != null) {
                this.f11520 = null;
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʼ */
    public final Double mo29129() {
        return Double.valueOf(this.f11521.doubleValue() * C4356s.m14572());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊॱ */
    public final Double mo29131() {
        return this.f11521;
    }

    /* renamed from: ˋ */
    public boolean mo29132(Map<String, String> map, View view) {
        try {
            mo29117();
            mo29112();
            if (view == null) {
                C43161.m14442(3, "BaseVideoTracker", this, "trackVideoAd received null video view instance");
            }
            this.f11518 = map;
            this.f11517 = new WeakReference<>(view);
            mo29115();
            String format = String.format("trackVideoAd tracking ids: %s | view: %s", new Object[]{new JSONObject(map).toString(), C43161.m14444(view)});
            C43161.m14442(3, "BaseVideoTracker", this, format);
            StringBuilder sb = new StringBuilder();
            sb.append(mo29116());
            sb.append(" ");
            sb.append(format);
            C43161.m14446("[SUCCESS] ", sb.toString());
            if (this.f11499 != null) {
                this.f11499.onTrackingStarted(mo29108());
            }
            return true;
        } catch (Exception e) {
            mo29114("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏॱ */
    public final void mo29133() {
        if (!this.f11522) {
            this.f11522 = true;
            this.f11524.postDelayed(new C43161(), 500);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱˊ */
    public final boolean mo29134() {
        return this.f11516.containsKey(MoatAdEventType.AD_EVT_COMPLETE) || this.f11516.containsKey(MoatAdEventType.AD_EVT_STOPPED) || this.f11516.containsKey(MoatAdEventType.AD_EVT_SKIPPED);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝ */
    public abstract Map<String, Object> mo29135() throws C4332l;

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public void mo29110(List<String> list) throws C4332l {
        if (this.f11518 == null) {
            list.add("Null adIds object");
        }
        if (list.isEmpty()) {
            super.mo29110(list);
            return;
        }
        throw new C4332l(TextUtils.join(" and ", list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ */
    public final void mo29115() throws C4332l {
        super.changeTargetView(this.f11517.get());
        super.mo29115();
        Map<String, Object> r0 = mo29135();
        Integer num = (Integer) r0.get("width");
        Integer num2 = (Integer) r0.get("height");
        Integer num3 = (Integer) r0.get("duration");
        C43161.m14442(3, "BaseVideoTracker", this, String.format(Locale.ROOT, "Player metadata: height = %d, width = %d, duration = %d", new Object[]{num2, num, num3}));
        this.f11525.mo29122(this.f11523, this.f11518, num, num2, num3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public JSONObject mo29130(MoatAdEvent moatAdEvent) {
        if (Double.isNaN(moatAdEvent.f11473.doubleValue())) {
            moatAdEvent.f11473 = this.f11521;
        }
        return new JSONObject(moatAdEvent.mo29041());
    }
}
