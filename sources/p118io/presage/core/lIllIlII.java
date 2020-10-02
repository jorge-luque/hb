package p118io.presage.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import com.ogury.p159cm.OguryChoiceManager;
import p118io.presage.core.lIIIlIII;

/* renamed from: io.presage.core.lIllIlII */
public class lIllIlII {
    public static final String IIIIlIII = C6279a.IIIIIIII;
    public static final String IIIIlIIl = C6279a.IIIIIIIl;
    public static final String IIIIlIlI = C6279a.IIIIlIIl;
    public Context IIIIIIII;
    public IIIIIIlI IIIIIIIl;
    public lIlIlllI IIIIIIlI;
    public IIllllII IIIIIIll;
    public Handler IIIIIlII = new Handler(Looper.getMainLooper());
    public Runnable IIIIIlIl;
    public Runnable IIIIIllI;
    public BroadcastReceiver IIIIIlll;

    /* renamed from: io.presage.core.lIllIlII$IIIIIIII */
    public class IIIIIIII implements Runnable {
        public IIIIIIII() {
        }

        public void run() {
            boolean z;
            boolean z2 = false;
            try {
                lIllIlII.this.IIIIIIII.startActivity(lIllIlII.this.IIIIIIII.getPackageManager().getLaunchIntentForPackage(lIllIlII.this.IIIIIIlI.IIIIIIIl));
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            String str = lIllIlII.this.IIIIIIlI.IIIIIlII;
            if (str != null && !str.isEmpty()) {
                z2 = true;
            }
            if (z2) {
                lIllIlII.this.IIIIIIII(z);
            } else {
                lIllIlII.this.IIIIIIII();
            }
        }
    }

    /* renamed from: io.presage.core.lIllIlII$IIIIIIlI */
    public interface IIIIIIlI {
        void IIIIIIII(lIllIlII lillilii);
    }

    public lIllIlII(Context context, IIIIIIlI iIIIIIlI) {
        this.IIIIIIII = context;
        this.IIIIIIIl = iIIIIIlI;
    }

    public static /* synthetic */ void IIIIIIII(lIllIlII lillilii) {
        IIIIIIlI iIIIIIlI = lillilii.IIIIIIIl;
        if (iIIIIIlI != null) {
            iIIIIIlI.IIIIIIII(lillilii);
        }
    }

    public final void IIIIIIII() {
        IIIIIIlI iIIIIIlI = this.IIIIIIIl;
        if (iIIIIIlI != null) {
            iIIIIIlI.IIIIIIII(this);
        }
    }

    public final boolean IIIIIIIl() {
        return Long.valueOf(this.IIIIIIlI.IIIIIIlI).longValue() + Long.valueOf(this.IIIIIIlI.IIIIIIII).longValue() <= System.currentTimeMillis();
    }

    public final void IIIIIIlI() {
        Thread.currentThread().getName();
        lIlIlllI lilillli = this.IIIIIIlI;
        String str = lilillli.IIIIIlIl;
        boolean z = true;
        if ((str == null || str.isEmpty() || lilillli.IIIIIllI == -1) ? false : true) {
            if (Long.valueOf(this.IIIIIIlI.IIIIIllI).longValue() + Long.valueOf(this.IIIIIIlI.IIIIIIII).longValue() > System.currentTimeMillis()) {
                z = false;
            }
            if (!z) {
                Thread.currentThread().getName();
                lIIIlIII.IIIIIIII(this.IIIIIIll, false, new lIIIlllI(this.IIIIIIlI.IIIIIlIl, lIIIlllI.IIIIIllI, new lIIIlIIl()), (lIIIlIII.IIIIIIII) new lIllIIll(this));
                return;
            }
        }
        if (!IIIIIIIl()) {
            IIIIIIII(Long.valueOf(this.IIIIIIlI.IIIIIIll).longValue());
            return;
        }
        IIIIIIlI iIIIIIlI = this.IIIIIIIl;
        if (iIIIIIlI != null) {
            iIIIIIlI.IIIIIIII(this);
        }
    }

    public void IIIIIIll() {
        Thread.currentThread().getName();
        try {
            if (this.IIIIIlll != null) {
                this.IIIIIIII.unregisterReceiver(this.IIIIIlll);
            }
            if (!(this.IIIIIlII == null || this.IIIIIlIl == null)) {
                this.IIIIIlII.removeCallbacks(this.IIIIIlIl);
            }
            if (this.IIIIIlII != null && this.IIIIIllI != null) {
                this.IIIIIlII.removeCallbacks(this.IIIIIllI);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: io.presage.core.lIllIlII$IIIIIIIl */
    public class IIIIIIIl implements lIIIlIII.IIIIIIII {
        public IIIIIIIl() {
        }

        public void IIIIIIII(lIIIlllI liiillli, Exception exc, int i) {
            String str = liiillli.IIIIIIII;
            lIllIlII.IIIIIIII(lIllIlII.this);
        }

        public void IIIIIIII(lIIIlllI liiillli, lIIlIIII liiliiii) {
            String str = liiillli.IIIIIIII;
            lIllIlII.IIIIIIII(lIllIlII.this);
        }
    }

    public void IIIIIIII(long j) {
        String str = this.IIIIIIlI.IIIIIIIl;
        Thread.currentThread().getName();
        if (this.IIIIIllI == null) {
            this.IIIIIllI = new IIIIIIII();
        }
        this.IIIIIlII.postDelayed(this.IIIIIllI, j);
    }

    public final void IIIIIIII(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.IIIIIIlI.IIIIIlII);
        sb.append(z ? IIIIlIII : IIIIlIIl);
        lIIIlIII.IIIIIIII(this.IIIIIIll, false, new lIIIlllI(sb.toString(), lIIIlllI.IIIIIllI, new lIIIlIIl()), (lIIIlIII.IIIIIIII) new IIIIIIIl());
    }

    public void IIIIIIII(IIllllII iIllllII, lIlIlllI lilillli) {
        Thread.currentThread().getName();
        this.IIIIIIll = iIllllII;
        this.IIIIIIlI = lilillli;
        Thread.currentThread().getName();
        for (PackageInfo packageInfo : this.IIIIIIII.getPackageManager().getInstalledPackages(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE)) {
            if (this.IIIIIIlI.IIIIIIIl.equals(packageInfo.packageName)) {
                IIIIIIlI();
                return;
            }
        }
        this.IIIIIlIl = new lIllIIIl(this);
        this.IIIIIlll = new lIllIIlI(this);
        Thread.currentThread().getName();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme(C6292d0.IIIIIIII);
        this.IIIIIIII.registerReceiver(this.IIIIIlll, intentFilter);
        this.IIIIIlII.postDelayed(this.IIIIIlIl, Math.max(Long.valueOf(this.IIIIIIlI.IIIIIllI).longValue(), Long.valueOf(this.IIIIIIlI.IIIIIIlI).longValue()) - Math.max(0, System.currentTimeMillis() - Long.valueOf(this.IIIIIIlI.IIIIIIII).longValue()));
    }
}
