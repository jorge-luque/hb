package com.moat.analytics.mobile.ogury;

import android.view.View;
import com.moat.analytics.mobile.ogury.C4315e;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.ogury.h */
abstract class C4325h extends C4315e {

    /* renamed from: ˊॱ */
    private int f11564 = Integer.MIN_VALUE;

    /* renamed from: ˋॱ */
    private int f11565 = Integer.MIN_VALUE;

    /* renamed from: ˏॱ */
    private double f11566 = Double.NaN;

    /* renamed from: ͺ */
    private int f11567 = C4327d.f11573;

    /* renamed from: ॱˊ */
    private int f11568 = Integer.MIN_VALUE;

    /* renamed from: ॱˋ */
    private int f11569 = 0;

    /* renamed from: com.moat.analytics.mobile.ogury.h$d */
    enum C4327d {
        ;
        

        /* renamed from: ˊ */
        public static final int f11572 = 2;

        /* renamed from: ˋ */
        public static final int f11573 = 1;

        /* renamed from: ˎ */
        public static final int f11574 = 3;

        /* renamed from: ˏ */
        public static final int f11575 = 5;

        /* renamed from: ॱ */
        public static final int f11576 = 4;

        static {
            f11571 = new int[]{1, 2, 3, 4, 5};
        }

        public static int[] values$48d63df8() {
            return (int[]) f11571.clone();
        }
    }

    C4325h(String str) {
        super(str);
    }

    public void setPlayerVolume(Double d) {
        super.setPlayerVolume(d);
        this.f11566 = mo29129().doubleValue();
    }

    public void stopTracking() {
        try {
            dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            super.stopTracking();
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʻॱ */
    public abstract Integer mo29156();

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public final JSONObject mo29130(MoatAdEvent moatAdEvent) {
        Integer num;
        int i;
        if (!moatAdEvent.f11475.equals(MoatAdEvent.f11471)) {
            num = moatAdEvent.f11475;
        } else {
            try {
                num = mo29158();
            } catch (Exception unused) {
                num = Integer.valueOf(this.f11568);
            }
            moatAdEvent.f11475 = num;
        }
        if (moatAdEvent.f11475.intValue() < 0 || (moatAdEvent.f11475.intValue() == 0 && moatAdEvent.f11474 == MoatAdEventType.AD_EVT_COMPLETE && this.f11568 > 0)) {
            num = Integer.valueOf(this.f11568);
            moatAdEvent.f11475 = num;
        }
        if (moatAdEvent.f11474 == MoatAdEventType.AD_EVT_COMPLETE) {
            if (num.intValue() == Integer.MIN_VALUE || (i = this.f11564) == Integer.MIN_VALUE || !C4315e.m14432(num, Integer.valueOf(i))) {
                this.f11567 = C4327d.f11576;
                moatAdEvent.f11474 = MoatAdEventType.AD_EVT_STOPPED;
            } else {
                this.f11567 = C4327d.f11575;
            }
        }
        return super.mo29130(moatAdEvent);
    }

    /* renamed from: ˋ */
    public final boolean mo29132(Map<String, String> map, View view) {
        try {
            boolean r4 = super.mo29132(map, view);
            if (!r4) {
                return r4;
            }
            this.f11524.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        if (!C4325h.this.mo29157() || C4325h.this.mo29134()) {
                            C4325h.this.mo29133();
                        } else if (C4325h.this.mo29159()) {
                            C4325h.this.f11524.postDelayed(this, 200);
                        } else {
                            C4325h.this.mo29133();
                        }
                    } catch (Exception e) {
                        C4325h.this.mo29133();
                        C4332l.m14509(e);
                    }
                }
            }, 200);
            return r4;
        } catch (Exception e) {
            C4315e.C43161.m14442(3, "IntervalVideoTracker", this, "Problem with video loop");
            mo29114("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋॱ */
    public abstract boolean mo29157();

    /* access modifiers changed from: package-private */
    /* renamed from: ͺ */
    public abstract Integer mo29158();

    /* access modifiers changed from: package-private */
    /* renamed from: ॱᐝ */
    public final boolean mo29159() throws C4332l {
        if (mo29157() && !mo29134()) {
            try {
                int intValue = mo29158().intValue();
                if (this.f11568 >= 0 && intValue < 0) {
                    return false;
                }
                this.f11568 = intValue;
                if (intValue == 0) {
                    return true;
                }
                int intValue2 = mo29156().intValue();
                boolean r4 = mo29160();
                double d = (double) intValue2;
                Double.isNaN(d);
                double d2 = d / 4.0d;
                double doubleValue = mo29129().doubleValue();
                MoatAdEventType moatAdEventType = null;
                if (intValue > this.f11565) {
                    this.f11565 = intValue;
                }
                if (this.f11564 == Integer.MIN_VALUE) {
                    this.f11564 = intValue2;
                }
                if (r4) {
                    if (this.f11567 == C4327d.f11573) {
                        moatAdEventType = MoatAdEventType.AD_EVT_START;
                        this.f11567 = C4327d.f11574;
                    } else if (this.f11567 == C4327d.f11572) {
                        moatAdEventType = MoatAdEventType.AD_EVT_PLAYING;
                        this.f11567 = C4327d.f11574;
                    } else {
                        double d3 = (double) intValue;
                        Double.isNaN(d3);
                        int floor = ((int) Math.floor(d3 / d2)) - 1;
                        if (floor >= 0 && floor < 3) {
                            MoatAdEventType moatAdEventType2 = C4315e.f11515[floor];
                            if (!this.f11516.containsKey(moatAdEventType2)) {
                                this.f11516.put(moatAdEventType2, 1);
                                moatAdEventType = moatAdEventType2;
                            }
                        }
                    }
                } else if (this.f11567 != C4327d.f11572) {
                    moatAdEventType = MoatAdEventType.AD_EVT_PAUSED;
                    this.f11567 = C4327d.f11572;
                }
                boolean z = moatAdEventType != null;
                if (!z && !Double.isNaN(this.f11566) && Math.abs(this.f11566 - doubleValue) > 0.05d) {
                    moatAdEventType = MoatAdEventType.AD_EVT_VOLUME_CHANGE;
                    z = true;
                }
                if (z) {
                    dispatchEvent(new MoatAdEvent(moatAdEventType, Integer.valueOf(intValue), mo29131()));
                }
                this.f11566 = doubleValue;
                this.f11569 = 0;
                return true;
            } catch (Exception unused) {
                int i = this.f11569;
                this.f11569 = i + 1;
                if (i < 5) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝॱ */
    public abstract boolean mo29160();
}
