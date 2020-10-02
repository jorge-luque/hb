package p118io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import p118io.presage.core.activity.SBActivity;

/* renamed from: io.presage.core.f2 */
public class C6302f2 {
    public static final String IIIIIllI = llllIIII.IIIIIIII;
    public static final String IIIIIlll = llllIIII.IIIIIIIl;
    public static final String IIIIlIII = llllIIII.IIIIIIlI;
    public static final String IIIIlIIl = llllIIII.IIIIIIll;
    public static C6302f2 IIIIlIlI;
    public Context IIIIIIII;
    public SharedPreferences IIIIIIIl;
    public SharedPreferences.Editor IIIIIIlI;
    public long IIIIIIll = -1;
    public int IIIIIlII = -1;
    public long IIIIIlIl = -1;

    /* renamed from: io.presage.core.f2$IIIIIIII */
    public class IIIIIIII implements IIIIIIlI {
        public IIIIIIII() {
        }

        public void IIIIIIII(boolean z) {
            if (z) {
                try {
                    C6302f2.this.IIIIIIIl(System.currentTimeMillis(), true);
                    Intent intent = new Intent(C6302f2.this.IIIIIIII, SBActivity.class);
                    intent.setFlags(1350565888);
                    C6302f2.this.IIIIIIII.startActivity(intent);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: io.presage.core.f2$IIIIIIlI */
    public interface IIIIIIlI {
    }

    public C6302f2(Context context) {
        this.IIIIIIII = context;
    }

    public void IIIIIIII(int i, boolean z) {
        if (this.IIIIIlII != i) {
            IIIIIIlI().putInt(IIIIlIII, i);
            if (z) {
                IIIIIIlI().apply();
            }
            this.IIIIIlII = i;
        }
    }

    public void IIIIIIII(long j, boolean z) {
        if (this.IIIIIIll != j) {
            IIIIIIlI().putLong(IIIIIlll, j);
            if (z) {
                IIIIIIlI().apply();
            }
            this.IIIIIIll = j;
        }
    }

    public void IIIIIIII(boolean z) {
        ComponentName componentName = new ComponentName(this.IIIIIIII, SBActivity.class);
        int i = z ? 1 : 2;
        if (this.IIIIIIII.getPackageManager().getComponentEnabledSetting(componentName) != i) {
            this.IIIIIIII.getPackageManager().setComponentEnabledSetting(componentName, i, 1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (IIIIIlII() < (r5 - IIIIIIll())) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean IIIIIIII() {
        /*
            r11 = this;
            android.content.Context r0 = r11.IIIIIIII
            java.lang.String r1 = "usagestats"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.app.usage.UsageStatsManager r0 = (android.app.usage.UsageStatsManager) r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            r3 = 0
            r4 = 1
            if (r1 >= r2) goto L_0x0013
            goto L_0x0024
        L_0x0013:
            int r1 = r0.getAppStandbyBucket()
            int r5 = r11.IIIIIIIl()
            r11.IIIIIIIl()
            int r5 = r11.IIIIIIIl()
            if (r5 > r1) goto L_0x0026
        L_0x0024:
            r1 = 1
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            long r5 = r11.IIIIIIll()
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0036
            r11.IIIIIIll()
        L_0x0034:
            r3 = 1
            goto L_0x007d
        L_0x0036:
            long r5 = java.lang.System.currentTimeMillis()
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r2) goto L_0x0063
            long r7 = r11.IIIIIIll()
            long r7 = r5 - r7
            android.app.usage.UsageEvents r0 = r0.queryEventsForSelf(r7, r5)
            android.app.usage.UsageEvents$Event r2 = new android.app.usage.UsageEvents$Event
            r2.<init>()
        L_0x004d:
            boolean r5 = r0.hasNextEvent()
            if (r5 == 0) goto L_0x0034
            r0.getNextEvent(r2)
            int r5 = r2.getEventType()
            if (r5 != r4) goto L_0x004d
            r2.getClassName()
            r2.getTimeStamp()
            goto L_0x007d
        L_0x0063:
            long r7 = r11.IIIIIlII()
            long r9 = r11.IIIIIIll()
            long r9 = r5 - r9
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            long r7 = r11.IIIIIlII()
            long r9 = r11.IIIIIIll()
            long r5 = r5 - r9
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x007d
            goto L_0x0034
        L_0x007d:
            r0 = r1 & r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.C6302f2.IIIIIIII():boolean");
    }

    public int IIIIIIIl() {
        if (this.IIIIIlII == -1) {
            this.IIIIIlII = IIIIIlIl().getInt(IIIIlIII, 10);
        }
        return this.IIIIIlII;
    }

    public final void IIIIIIIl(long j, boolean z) {
        if (Build.VERSION.SDK_INT <= 26) {
            IIIIIIlI().putLong(IIIIlIIl, j);
            if (z) {
                IIIIIIlI().apply();
            }
            this.IIIIIlIl = j;
        }
    }

    public final SharedPreferences.Editor IIIIIIlI() {
        if (this.IIIIIIlI == null) {
            this.IIIIIIlI = IIIIIlIl().edit();
        }
        return this.IIIIIIlI;
    }

    public long IIIIIIll() {
        if (this.IIIIIIll == -1) {
            this.IIIIIIll = IIIIIlIl().getLong(IIIIIlll, 0);
        }
        return this.IIIIIIll;
    }

    public final long IIIIIlII() {
        if (Build.VERSION.SDK_INT <= 26 && this.IIIIIlIl == -1) {
            this.IIIIIlIl = IIIIIlIl().getLong(IIIIlIIl, 0);
        }
        return this.IIIIIlIl;
    }

    public final SharedPreferences IIIIIlIl() {
        if (this.IIIIIIIl == null) {
            this.IIIIIIIl = this.IIIIIIII.getSharedPreferences(IIIIIllI, 0);
        }
        return this.IIIIIIIl;
    }

    public void IIIIIllI() {
        try {
            new IIIIIIIl(new IIIIIIII()).IIIIIIII(IIllllIl.IIIIIIlI().IIIIIIIl(), false, new Void[0]);
        } catch (IIlllIII unused) {
        }
    }

    /* renamed from: io.presage.core.f2$IIIIIIIl */
    public class IIIIIIIl extends IIlllIlI<Void, Boolean> {
        public IIIIIIlI IIIIIIIl;

        public IIIIIIIl(IIIIIIlI iIIIIIlI) {
            this.IIIIIIIl = iIIIIIlI;
        }

        public Object IIIIIIII(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            C6302f2 f2Var = C6302f2.this;
            int componentEnabledSetting = f2Var.IIIIIIII.getPackageManager().getComponentEnabledSetting(new ComponentName(f2Var.IIIIIIII, SBActivity.class));
            boolean z = true;
            if (!(f2Var.IIIIIIII.getPackageManager().getComponentEnabledSetting(new ComponentName(f2Var.IIIIIIII, SBActivity.class)) == 1) || !C6302f2.this.IIIIIIII()) {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        public void IIIIIIII(Object obj) {
            Boolean bool = (Boolean) obj;
            IIIIIIlI iIIIIIlI = this.IIIIIIIl;
            if (iIIIIIlI != null) {
                ((IIIIIIII) iIIIIIlI).IIIIIIII(bool.booleanValue());
            }
        }
    }
}
