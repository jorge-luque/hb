package com.tapjoy.internal;

import com.google.android.gms.games.Notifications;
import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: com.tapjoy.internal.el */
public final class C5023el {

    /* renamed from: a */
    final C5210is f13611a;

    public C5023el(C5210is isVar) {
        this.f13611a = isVar;
    }

    /* renamed from: a */
    static int m16973a(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: a */
    static int m16974a(int i, C5001eg egVar) {
        return (i << 3) | egVar.f13575e;
    }

    /* renamed from: a */
    static int m16975a(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: b */
    static int m16976b(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: b */
    static long m16977b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: c */
    public final void mo31119c(int i) {
        while ((i & -128) != 0) {
            this.f13611a.mo31410e((i & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            i >>>= 7;
        }
        this.f13611a.mo31410e(i);
    }

    /* renamed from: d */
    public final void mo31121d(int i) {
        this.f13611a.mo31406d(i);
    }

    /* renamed from: a */
    public final void mo31118a(C5212iu iuVar) {
        this.f13611a.mo31396b(iuVar);
    }

    /* renamed from: d */
    public final void mo31122d(long j) {
        this.f13611a.mo31413f(j);
    }

    /* renamed from: c */
    public final void mo31120c(long j) {
        while ((-128 & j) != 0) {
            this.f13611a.mo31410e((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            j >>>= 7;
        }
        this.f13611a.mo31410e((int) j);
    }
}
