package p118io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;

/* renamed from: io.presage.core.IIIIllIl */
public class IIIIllIl {
    public static IIIIllIl IIIIIlII;
    public Context IIIIIIII;
    public SharedPreferences IIIIIIIl;
    public SharedPreferences.Editor IIIIIIlI;
    public IIIIllII IIIIIIll;

    public IIIIllIl(Context context) {
        this.IIIIIIII = context.getApplicationContext();
    }

    public static IIIIllIl IIIIIIII(Context context) {
        if (IIIIIlII == null) {
            IIIIIlII = new IIIIllIl(context);
        }
        return IIIIIlII;
    }

    public IIIIllII IIIIIIII() {
        IIIIllII iIIIllII;
        if (this.IIIIIIll == null) {
            int i = IIIIIIlI().getInt("03abaa66", -1);
            if (i == -1) {
                iIIIllII = new IIIIllII(-1);
            } else if (i == 0) {
                this.IIIIIIll = new IIIIllII(0);
            } else if (i != 1) {
                this.IIIIIIll = new IIIIllII(0);
            } else {
                iIIIllII = new IIIIllII(i, IIIIIIlI().getInt("c04e9c14", 0), IIIIIIlI().getLong("9955955", TapjoyConstants.PAID_APP_TIME), IIIIIIlI().getLong("833b94da", 910000), IIIIIIlI().getLong("58aeb946", 30000), IIIIIIlI().getInt("2bebe142", 1));
            }
            this.IIIIIIll = iIIIllII;
        }
        return this.IIIIIIll;
    }

    public final SharedPreferences.Editor IIIIIIIl() {
        if (this.IIIIIIlI == null) {
            this.IIIIIIlI = IIIIIIlI().edit();
        }
        return this.IIIIIIlI;
    }

    public final SharedPreferences IIIIIIlI() {
        if (this.IIIIIIIl == null) {
            this.IIIIIIIl = this.IIIIIIII.getSharedPreferences("b2a30028", 0);
        }
        return this.IIIIIIIl;
    }

    public final int IIIIIIII(int i) {
        if (i < 0 || i > 1) {
            IIIIIIIl().putInt("03abaa66", 0);
            return 0;
        }
        IIIIIIIl().putInt("03abaa66", i);
        return i;
    }

    public boolean IIIIIIII(IIIIllII iIIIllII) {
        boolean z;
        int i = iIIIllII.IIIIIIII;
        IIIIllII IIIIIIII2 = IIIIIIII();
        this.IIIIIIll = IIIIIIII2;
        int i2 = IIIIIIII2.IIIIIIII;
        int i3 = this.IIIIIIll.IIIIIIIl;
        long j = this.IIIIIIll.IIIIIIll;
        long j2 = this.IIIIIIll.IIIIIIlI;
        long j3 = this.IIIIIIll.IIIIIlII;
        int i4 = this.IIIIIIll.IIIIIlIl;
        int i5 = iIIIllII.IIIIIIII;
        int i6 = iIIIllII.IIIIIIIl;
        long j4 = iIIIllII.IIIIIIll;
        long j5 = iIIIllII.IIIIIIlI;
        long j6 = iIIIllII.IIIIIlII;
        int i7 = iIIIllII.IIIIIlIl;
        boolean z2 = false;
        if (i == 0) {
            if (this.IIIIIIll.IIIIIIII != i) {
                iIIIllII.IIIIIIII = IIIIIIII(i);
                int i8 = this.IIIIIIll.IIIIIIII;
            }
            IIIIIIIl().apply();
            this.IIIIIIll = iIIIllII;
            int i9 = iIIIllII.IIIIIIII;
            int i10 = this.IIIIIIll.IIIIIIIl;
            long j7 = this.IIIIIIll.IIIIIIll;
            long j8 = this.IIIIIIll.IIIIIIlI;
            long j9 = this.IIIIIIll.IIIIIlII;
            int i11 = this.IIIIIIll.IIIIIlIl;
            return z2;
        } else if (i != 1) {
            if (this.IIIIIIll.IIIIIIII != 0) {
                iIIIllII.IIIIIIII = IIIIIIII(0);
                int i12 = this.IIIIIIll.IIIIIIII;
            }
            IIIIIIIl().apply();
            this.IIIIIIll = iIIIllII;
            int i92 = iIIIllII.IIIIIIII;
            int i102 = this.IIIIIIll.IIIIIIIl;
            long j72 = this.IIIIIIll.IIIIIIll;
            long j82 = this.IIIIIIll.IIIIIIlI;
            long j92 = this.IIIIIIll.IIIIIlII;
            int i112 = this.IIIIIIll.IIIIIlIl;
            return z2;
        } else {
            if (this.IIIIIIll.IIIIIIII != i) {
                iIIIllII.IIIIIIII = IIIIIIII(i);
                int i13 = this.IIIIIIll.IIIIIIII;
                z = true;
            } else {
                z = false;
            }
            int i14 = this.IIIIIIll.IIIIIIIl;
            int i15 = iIIIllII.IIIIIIIl;
            if (i14 != i15) {
                if (i15 < 0 || i15 > 1) {
                    IIIIIIIl().putInt("c04e9c14", 0);
                } else {
                    IIIIIIIl().putInt("c04e9c14", i15);
                    z2 = i15;
                }
                iIIIllII.IIIIIIIl = z2 ? 1 : 0;
                int i16 = this.IIIIIIll.IIIIIIIl;
                z = true;
            }
            long j10 = this.IIIIIIll.IIIIIIll;
            long j11 = iIIIllII.IIIIIIll;
            if (j10 != j11) {
                if (j11 < 0) {
                    j11 = TapjoyConstants.PAID_APP_TIME;
                }
                IIIIIIIl().putLong("9955955", j11);
                iIIIllII.IIIIIIll = j11;
                long j12 = this.IIIIIIll.IIIIIIll;
                z = true;
            }
            long j13 = this.IIIIIIll.IIIIIIlI;
            long j14 = iIIIllII.IIIIIIlI;
            if (j13 != j14) {
                if (j14 < 1000) {
                    j14 = 910000;
                }
                IIIIIIIl().putLong("833b94da", j14);
                iIIIllII.IIIIIIlI = j14;
                long j15 = this.IIIIIIll.IIIIIIlI;
                z = true;
            }
            long j16 = this.IIIIIIll.IIIIIlII;
            long j17 = iIIIllII.IIIIIlII;
            if (j16 != j17) {
                if (j17 < 0) {
                    j17 = 30000;
                }
                IIIIIIIl().putLong("58aeb946", j17);
                iIIIllII.IIIIIlII = j17;
                long j18 = this.IIIIIIll.IIIIIlII;
                z2 = true;
            } else {
                z2 = z;
            }
            int i17 = this.IIIIIIll.IIIIIlIl;
            int i18 = iIIIllII.IIIIIlIl;
            if (i17 != i18) {
                if (i18 == 0 || i18 == 1) {
                    IIIIIIIl().putInt("2bebe142", i18);
                } else {
                    IIIIIIIl().putInt("2bebe142", 1);
                    i18 = 1;
                }
                iIIIllII.IIIIIlIl = i18;
                int i19 = this.IIIIIIll.IIIIIlIl;
            }
            IIIIIIIl().apply();
            this.IIIIIIll = iIIIllII;
            int i922 = iIIIllII.IIIIIIII;
            int i1022 = this.IIIIIIll.IIIIIIIl;
            long j722 = this.IIIIIIll.IIIIIIll;
            long j822 = this.IIIIIIll.IIIIIIlI;
            long j922 = this.IIIIIIll.IIIIIlII;
            int i1122 = this.IIIIIIll.IIIIIlIl;
            return z2;
        }
        z2 = true;
        IIIIIIIl().apply();
        this.IIIIIIll = iIIIllII;
        int i9222 = iIIIllII.IIIIIIII;
        int i10222 = this.IIIIIIll.IIIIIIIl;
        long j7222 = this.IIIIIIll.IIIIIIll;
        long j8222 = this.IIIIIIll.IIIIIIlI;
        long j9222 = this.IIIIIIll.IIIIIlII;
        int i11222 = this.IIIIIIll.IIIIIlIl;
        return z2;
    }
}
