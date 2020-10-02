package p118io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.File;
import p118io.presage.core.C6313i1;
import p118io.presage.core.lIIllIlI;
import p118io.presage.core.llIlIlIl;

/* renamed from: io.presage.core.IIIIIlll */
public class IIIIIlll {
    public static final String IIIIlIlI = lllIllIl.IIIIIIII;
    public static final String IIIIlIll = lllIllIl.IIIIIIIl;
    public static final String IIIIllII = lllIllIl.IIIIIIlI;
    public static final String IIIIllIl = lllIllIl.IIIIIIll;
    public static final String IIIIlllI = lllIllIl.IIIIIlII;
    public static final String IIIIllll = lllIllIl.IIIIIlIl;
    public static final String IIIlIIII = lllIllIl.IIIIIllI;
    public static final String IIIlIIIl = lllIllIl.IIIIIlll;
    public static final String IIIlIIlI = lllIllIl.IIIIlIII;
    public static final String IIIlIIll = lllIllIl.IIIIlIlI;
    public static final String IIIlIlII = lllIllIl.IIIIlIll;
    public static final String IIIlIlIl = lllIllIl.IIIIlIIl;
    public static final String IIIlIllI = C6348r0.IIIIIIII;
    public static final String IIIlIlll = C6348r0.IIIIIIIl;
    public Context IIIIIIII;
    public SharedPreferences IIIIIIIl;
    public SharedPreferences.Editor IIIIIIlI;
    public String IIIIIIll;
    public String IIIIIlII;
    public Boolean IIIIIlIl;
    public Boolean IIIIIllI;
    public lIIllIll IIIIIlll;
    public CoreSdkType IIIIlIII;
    public IIIIIIll IIIIlIIl;

    /* renamed from: io.presage.core.IIIIIlll$IIIIIIII */
    public class IIIIIIII implements C6313i1.IIIIIIII {
        public final /* synthetic */ IIIIIlII IIIIIIII;

        public IIIIIIII(IIIIIlll iIIIIlll, IIIIIlII iIIIIlII) {
            this.IIIIIIII = iIIIIlII;
        }
    }

    /* renamed from: io.presage.core.IIIIIlll$IIIIIIIl */
    public class IIIIIIIl implements lIIllIlI.IIIIIIII {
        public IIIIIIIl() {
        }

        public void IIIIIIII(byte[] bArr, boolean z, lIIllIll liillill, Exception exc) {
            if (z) {
                IIIIIlll.this.IIIIIlll = liillill;
            } else {
                lIIIIlIl.IIIIIIII(exc, 1);
            }
            IIIIIlll iIIIIlll = IIIIIlll.this;
            lIIllIll liillill2 = iIIIIlll.IIIIIlll;
            IIIIIIll iIIIIIll = iIIIIlll.IIIIlIIl;
            if (iIIIIIll != null) {
                iIIIIIll.IIIIIIII(liillill2);
            }
        }
    }

    /* renamed from: io.presage.core.IIIIIlll$IIIIIIlI */
    public class IIIIIIlI implements llIlIlIl.IIIIIIII {
        public IIIIIIlI(IIIIIlll iIIIIlll) {
        }

        public void IIIIIIII(boolean z, long j, Exception exc) {
            if (!z) {
                lIIIIlIl.IIIIIIII(exc, 1);
            }
        }
    }

    /* renamed from: io.presage.core.IIIIIlll$IIIIIIll */
    public interface IIIIIIll {
        void IIIIIIII(lIIllIll liillill);
    }

    /* renamed from: io.presage.core.IIIIIlll$IIIIIlII */
    public interface IIIIIlII {
    }

    public IIIIIlll(Context context) {
        this.IIIIIIII = context;
    }

    public static /* synthetic */ void IIIIIIII(IIIIIlll iIIIIlll, lIIllIll liillill) {
        IIIIIIll iIIIIIll = iIIIIlll.IIIIlIIl;
        if (iIIIIIll != null) {
            iIIIIIll.IIIIIIII(liillill);
        }
    }

    public static int IIIlIIIl() {
        return 40031;
    }

    public static String IIIlIIlI() {
        return "4.3.12";
    }

    public String IIIIIIII() {
        if (!IIIIlllI().contains(IIIlIIIl)) {
            return "";
        }
        String str = this.IIIIIlII;
        if (str == null || str.isEmpty()) {
            this.IIIIIlII = IIIIlllI().getString(IIIlIIIl, "");
        }
        return this.IIIIIlII;
    }

    public void IIIIIIII(IIllllII iIllllII, boolean z, IIIIIlII iIIIIlII) {
        try {
            this.IIIIIlll = null;
            C6313i1.IIIIIIII(iIllllII, z, IIIIlIlI(), new IIIIIIII(this, iIIIIlII));
        } catch (IIlllIII unused) {
            if (iIIIIlII != null) {
                ((IIIlIIII) iIIIIlII).IIIIIIII();
            }
        }
    }

    public final void IIIIIIII(lIIllIll liillill) {
        IIIIIIll iIIIIIll = this.IIIIlIIl;
        if (iIIIIIll != null) {
            iIIIIIll.IIIIIIII(liillill);
        }
    }

    public final void IIIIIIII(byte[] bArr) {
        int i = 0;
        try {
            new lIIllIlI(this.IIIIIIII, bArr, IIIlIllI, new IIIIIIIl()).IIIIIIII(IIllllIl.IIIIIIlI().IIIIIIIl(), false, new Void[0]);
            return;
        } catch (IIlllIII e) {
            e = e;
        } catch (Exception e2) {
            e = e2;
            i = 1;
        }
        lIIIIlIl.IIIIIIII(e, i);
        IIIIIIII(this.IIIIIlll);
    }

    public String IIIIIIIl() {
        String str;
        if (IIIIlllI().contains(IIIlIIII) && ((str = this.IIIIIIll) == null || str.isEmpty())) {
            this.IIIIIIll = IIIIlllI().getString(IIIlIIII, "");
        }
        return this.IIIIIIll;
    }

    public final void IIIIIIIl(byte[] bArr) {
        try {
            IIllllII IIIIIIII2 = IIllllIl.IIIIIIlI().IIIIIIII();
            new llIlIlIl(IIIIlIlI(), new IIIIIIlI(this)).IIIIIIII(IIIIIIII2, false, bArr);
        } catch (IIlllIII e) {
            lIIIIlIl.IIIIIIII(e, 0);
        } catch (Exception e2) {
            lIIIIlIl.IIIIIIII(e2, 1);
        }
    }

    public File IIIIIIlI() {
        return Build.VERSION.SDK_INT >= 21 ? new File(this.IIIIIIII.getNoBackupFilesDir(), IIIIlllI) : new File(this.IIIIIIII.getFilesDir(), IIIIlllI);
    }

    public File IIIIIIll() {
        return new File(this.IIIIIIII.getFilesDir(), IIIIlllI);
    }

    public File IIIIIlII() {
        return new File(this.IIIIIIII.getFilesDir(), IIIIllIl);
    }

    public File IIIIIlIl() {
        return new File(this.IIIIIIII.getFilesDir(), IIIIlIll);
    }

    public File IIIIIllI() {
        return new File(this.IIIIIIII.getFilesDir(), IIIIllII);
    }

    public File IIIIIlll() {
        return new File(this.IIIIIIII.getFilesDir(), IIIIllll);
    }

    public final SharedPreferences.Editor IIIIlIII() {
        if (this.IIIIIIlI == null) {
            this.IIIIIIlI = IIIIlllI().edit();
        }
        return this.IIIIIIlI;
    }

    public File IIIIlIIl() {
        return Build.VERSION.SDK_INT >= 21 ? new File(this.IIIIIIII.getNoBackupFilesDir(), IIIIllIl) : new File(this.IIIIIIII.getFilesDir(), IIIIllIl);
    }

    public File IIIIlIlI() {
        return Build.VERSION.SDK_INT >= 21 ? new File(this.IIIIIIII.getNoBackupFilesDir(), IIIIlIll) : new File(this.IIIIIIII.getFilesDir(), IIIIlIll);
    }

    public File IIIIlIll() {
        return Build.VERSION.SDK_INT >= 21 ? new File(this.IIIIIIII.getNoBackupFilesDir(), IIIIllII) : new File(this.IIIIIIII.getFilesDir(), IIIIllII);
    }

    public String IIIIllII() {
        return IIIlIlll;
    }

    public int IIIIllIl() {
        if (this.IIIIlIII == null) {
            this.IIIIlIII = new CoreSdkType(this.IIIIIIII);
        }
        return this.IIIIlIII.getType();
    }

    public final SharedPreferences IIIIlllI() {
        if (this.IIIIIIIl == null) {
            this.IIIIIIIl = this.IIIIIIII.getSharedPreferences(IIIIlIlI, 0);
        }
        return this.IIIIIIIl;
    }

    public File IIIIllll() {
        return Build.VERSION.SDK_INT >= 21 ? new File(this.IIIIIIII.getNoBackupFilesDir(), IIIIllll) : new File(this.IIIIIIII.getFilesDir(), IIIIllll);
    }

    public boolean IIIlIIII() {
        if (!IIIIlllI().contains(IIIlIIlI)) {
            return false;
        }
        if (this.IIIIIlIl == null) {
            this.IIIIIlIl = Boolean.valueOf(IIIIlllI().getBoolean(IIIlIIlI, false));
        }
        return this.IIIIIlIl.booleanValue();
    }

    public void IIIIIIIl(lIIllIll liillill) {
        if (liillill == null) {
            lIIIIlIl.IIIIIIII(new lIIlllIl(), 1);
            return;
        }
        this.IIIIIlll = liillill;
        try {
            new lIIllIIl(this.IIIIIIII, liillill, IIIlIllI, new IIIIlIIl(this)).IIIIIIII(IIllllIl.IIIIIIlI().IIIIIIIl(), false, new Void[0]);
        } catch (IIlllIII e) {
            lIIIIlIl.IIIIIIII(e, 0);
        } catch (Exception e2) {
            lIIIIlIl.IIIIIIII(e2, 1);
        }
    }
}
