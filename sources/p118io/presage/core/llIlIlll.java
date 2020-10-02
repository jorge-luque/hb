package p118io.presage.core;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import p118io.presage.core.IllllllI;
import p118io.presage.core.llIIIllI;
import p118io.presage.core.llIIlllI;

/* renamed from: io.presage.core.llIlIlll */
public class llIlIlll {
    public static llIlIlll IIIIlIII;
    public static LinkedList<IIllIlll> IIIIlIIl;
    public static final String IIIIlIlI = lllIlllI.IIIIIIII;
    public static final String IIIIlIll = lllIlllI.IIIIIIIl;
    public Context IIIIIIII;
    public llIlllIl IIIIIIIl;
    public lIllIlll IIIIIIlI;
    public llIIlllI IIIIIIll;
    public llIIIllI IIIIIlII;
    public int IIIIIlIl;
    public int IIIIIllI;
    public llIIIllI.IIIIIlIl IIIIIlll;

    /* renamed from: io.presage.core.llIlIlll$IIIIIIII */
    public class IIIIIIII implements IllllllI.IIIIIIII {
        public final /* synthetic */ llIllIll IIIIIIII;

        public IIIIIIII(llIllIll llillill) {
            this.IIIIIIII = llillill;
        }

        public void IIIIIIII(IIIlIIlI iIIlIIlI, byte[] bArr) {
            try {
                boolean z = false;
                if (this.IIIIIIII.IIIIIIIl == 1) {
                    llIlIlll llililll = llIlIlll.this;
                    llililll.IIIIIIll.IIIIIIII(bArr, (llIIlllI.IIIIIIlI) new llIllIIl(llililll));
                    return;
                }
                if (this.IIIIIIII.IIIIIIIl == 0) {
                    z = true;
                }
                if (z) {
                    llIlIlll llililll2 = llIlIlll.this;
                    llililll2.IIIIIlII.IIIIIIII(bArr, (llIIlIll) new llIllIII(llililll2));
                }
            } catch (Exception unused) {
                llIlIlll.this.IIIIIIIl();
            }
        }
    }

    /* renamed from: io.presage.core.llIlIlll$IIIIIIIl */
    public class IIIIIIIl implements llIIIllI.IIIIIlIl {
        public IIIIIIIl() {
        }

        public void IIIIIIII() {
            llIlIlll llililll = llIlIlll.this;
            llililll.IIIIIllI = 0;
            llIIIllI.IIIIIlIl iIIIIlIl = llililll.IIIIIlll;
            if (iIIIIlIl != null) {
                iIIIIlIl.IIIIIIII();
            }
        }
    }

    public llIlIlll(Context context, llIlllIl llilllil, lIllllll lillllll, lIlllIIl lillliil) {
        if (llilllil.IIIIIIII == null) {
            throw new llIllIlI();
        } else if (llilllil.IIIIIIIl != null) {
            this.IIIIIIII = context;
            try {
                this.IIIIIIIl = llilllil;
                this.IIIIIIlI = new lIllIlll(context, IIIIlIlI, IIIIlIll, 0);
                this.IIIIIIll = new llIIllIl(context, lillliil);
                this.IIIIIlII = new llIIIIlI(this.IIIIIIII, lillllll, this.IIIIIIlI, this.IIIIIIll);
            } catch (Exception e) {
                throw new llIllIlI(e);
            }
        } else {
            throw new llIllIlI();
        }
    }

    public static boolean IIIIIIll() {
        llIlIlll llililll = IIIIlIII;
        if (llililll == null) {
            return false;
        }
        return llililll.IIIIIllI == 1;
    }

    public static boolean IIIIIlII() {
        llIlIlll llililll = IIIIlIII;
        if (llililll != null) {
            return llililll.IIIIIllI == 0;
        }
    }

    public static void IIIIIlIl() {
        LinkedList<IIllIlll> linkedList = IIIIlIIl;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    public final void IIIIIIII() {
        if (!(this.IIIIIlIl > 0) || this.IIIIIllI == 2) {
            this.IIIIIlII.IIIIIIII(false, (llIIIllI.IIIIIlIl) new IIIIIIIl());
        } else {
            this.IIIIIllI = 2;
        }
    }

    public final void IIIIIIIl() {
        int i = this.IIIIIlIl - 1;
        this.IIIIIlIl = i;
        if (i == 0 && this.IIIIIllI == 2) {
            IIIIIIII();
        }
    }

    public void IIIIIIlI() {
        try {
            if (this.IIIIIllI == 0) {
                this.IIIIIllI = 1;
                this.IIIIIlIl = 0;
                this.IIIIIlII.IIIIIIIl();
            }
        } catch (Exception e) {
            this.IIIIIllI = 0;
            throw new llIllIlI(e);
        }
    }

    public void IIIIIIII(IIllIlll iIllIlll) {
        llIllIll llillill;
        String str = iIllIlll.IIIIIIIl;
        int i = this.IIIIIllI;
        if (i != 2 && i != 0) {
            int i2 = iIllIlll.IIIIIIlI;
            Iterator<llIllIll> it = this.IIIIIIIl.IIIIIIIl.iterator();
            while (true) {
                if (!it.hasNext()) {
                    llillill = null;
                    break;
                }
                llillill = it.next();
                if (llillill.IIIIIIII == i2) {
                    break;
                }
            }
            if (llillill == null) {
                int i3 = iIllIlll.IIIIIIlI;
                return;
            }
            this.IIIIIlIl++;
            try {
                new IllllllI(this.IIIIIIII, iIllIlll, new IIIIIIII(llillill)).IIIIIIII(this.IIIIIIIl.IIIIIIII, false, new Void[0]);
            } catch (IIlllIII e) {
                IIIIIIIl();
                lIIIIlIl.IIIIIIII(e, 0);
            }
        }
    }

    public static void IIIIIIII(llIlllII llilllii) {
        if (llilllii != null) {
            IIllIlll iIllIlll = new IIllIlll(System.currentTimeMillis(), llilllii.IIIIIIIl, llilllii.IIIIIIII);
            if (IIIIIIll()) {
                IIIIlIII.IIIIIIII(iIllIlll);
                return;
            }
            if (IIIIlIIl == null) {
                IIIIlIIl = new LinkedList<>();
            }
            IIIIlIIl.add(iIllIlll);
            IIIIlIIl.size();
        }
    }

    public static void IIIIIIII(Context context, llIlllIl llilllil, lIllllll lillllll, lIlllIIl lillliil) {
        if (!IIIIIIll()) {
            llIlIlll llililll = new llIlIlll(context, llilllil, lillllll, lillliil);
            IIIIlIII = llililll;
            llililll.IIIIIIlI();
            LinkedList<IIllIlll> linkedList = IIIIlIIl;
            if (linkedList != null) {
                linkedList.size();
                Iterator it = IIIIlIIl.iterator();
                while (it.hasNext()) {
                    IIIIlIII.IIIIIIII((IIllIlll) it.next());
                }
                IIIIIlIl();
            }
        }
    }
}
