package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.tapjoy.internal.aa */
public enum C4874aa {
    UNSPECIFIED,
    PORTRAIT,
    LANDSCAPE,
    SQUARE,
    NATURAL_PORTRAIT(PORTRAIT),
    RIGHT_LANDSCAPE(LANDSCAPE, r0),
    REVERSE_PORTRAIT(PORTRAIT, NATURAL_PORTRAIT),
    LEFT_LANDSCAPE(LANDSCAPE, NATURAL_PORTRAIT),
    NATURAL_LANDSCAPE(LANDSCAPE),
    RIGHT_PORTRAIT(PORTRAIT, r0),
    REVERSE_LANDSCAPE(LANDSCAPE, NATURAL_LANDSCAPE),
    LEFT_PORTRAIT(PORTRAIT, NATURAL_LANDSCAPE),
    NATURAL_SQUARE(SQUARE),
    RIGHT_SQUARE(SQUARE, r0),
    REVERSE_SQUARE(SQUARE, NATURAL_SQUARE),
    LEFT_SQUARE(SQUARE, NATURAL_SQUARE);
    

    /* renamed from: q */
    private final C4874aa f13311q;

    /* renamed from: r */
    private final C4874aa f13312r;

    /* renamed from: a */
    public final boolean mo30901a() {
        C4874aa aaVar = PORTRAIT;
        return this == aaVar || this.f13311q == aaVar;
    }

    /* renamed from: b */
    public final boolean mo30902b() {
        C4874aa aaVar = LANDSCAPE;
        return this == aaVar || this.f13311q == aaVar;
    }

    /* renamed from: c */
    public final int mo30903c() {
        if (this.f13312r != null) {
            return ordinal() - this.f13312r.ordinal();
        }
        return 0;
    }

    /* renamed from: a */
    public static C4874aa m16656a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.x = defaultDisplay.getWidth();
            point.y = defaultDisplay.getHeight();
        }
        int i = point.x;
        int i2 = point.y;
        if (i < i2) {
            int i3 = rotation & 3;
            if (i3 == 1) {
                return RIGHT_PORTRAIT;
            }
            if (i3 == 2) {
                return REVERSE_PORTRAIT;
            }
            if (i3 != 3) {
                return NATURAL_PORTRAIT;
            }
            return LEFT_PORTRAIT;
        } else if (i > i2) {
            int i4 = rotation & 3;
            if (i4 == 1) {
                return RIGHT_LANDSCAPE;
            }
            if (i4 == 2) {
                return REVERSE_LANDSCAPE;
            }
            if (i4 != 3) {
                return NATURAL_LANDSCAPE;
            }
            return LEFT_LANDSCAPE;
        } else {
            int i5 = rotation & 3;
            if (i5 == 1) {
                return RIGHT_SQUARE;
            }
            if (i5 == 2) {
                return REVERSE_SQUARE;
            }
            if (i5 != 3) {
                return NATURAL_SQUARE;
            }
            return LEFT_SQUARE;
        }
    }

    /* renamed from: b */
    public static C4874aa m16657b(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return PORTRAIT;
        }
        if (i != 2) {
            return UNSPECIFIED;
        }
        return LANDSCAPE;
    }

    private C4874aa(C4874aa aaVar) {
        this.f13311q = aaVar;
        this.f13312r = this;
    }

    private C4874aa(C4874aa aaVar, C4874aa aaVar2) {
        this.f13311q = aaVar;
        this.f13312r = aaVar2;
    }
}
