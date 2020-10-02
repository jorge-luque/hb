package p118io.presage.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p118io.presage.core.C6313i1;
import p118io.presage.core.llIlIIll;
import p118io.presage.core.llIlIlIl;

/* renamed from: io.presage.core.llIlIlII */
public abstract class llIlIlII {
    public lIllllll IIIIIIII;
    public lIllllII IIIIIIIl;
    public C6309h1 IIIIIIlI;
    public IIIIIlII IIIIIIll;
    public final List<llIlIIlI> IIIIIlII;
    public IIIIIIll IIIIIlIl;
    public int IIIIIllI;

    /* renamed from: io.presage.core.llIlIlII$IIIIIIII */
    public class IIIIIIII implements C6313i1.IIIIIIll {
        public final /* synthetic */ llIlIIlI IIIIIIII;

        public IIIIIIII(llIlIIlI lliliili) {
            this.IIIIIIII = lliliili;
        }
    }

    /* renamed from: io.presage.core.llIlIlII$IIIIIIIl */
    public class IIIIIIIl implements llIlIIll.IIIIIIII {
        public final /* synthetic */ llIlIIlI IIIIIIII;

        public IIIIIIIl(llIlIIlI lliliili) {
            this.IIIIIIII = lliliili;
        }

        public void IIIIIIII(FileOutputStream fileOutputStream) {
            if (fileOutputStream != null) {
                llIlIlII.this.IIIIIIII(fileOutputStream, this.IIIIIIII);
            } else {
                llIlIlII.this.IIIIIIII(this.IIIIIIII, false, new IOException(), 0);
            }
        }
    }

    /* renamed from: io.presage.core.llIlIlII$IIIIIIlI */
    public class IIIIIIlI implements llIlIlIl.IIIIIIII {
        public final /* synthetic */ llIlIIlI IIIIIIII;

        public IIIIIIlI(llIlIIlI lliliili) {
            this.IIIIIIII = lliliili;
        }

        public void IIIIIIII(boolean z, long j, Exception exc) {
            llIlIlII.this.IIIIIIII(z, j, exc);
            llIlIlII.this.IIIIIIII(this.IIIIIIII, z, exc, 1);
        }
    }

    /* renamed from: io.presage.core.llIlIlII$IIIIIIll */
    public interface IIIIIIll {
    }

    /* renamed from: io.presage.core.llIlIlII$IIIIIlII */
    public interface IIIIIlII {
    }

    public llIlIlII(lIllllll lillllll) {
        C6309h1 h1Var = new C6309h1();
        if (lillllll == null) {
            throw new IllegalArgumentException();
        } else if (lillllll.IIIIIIIl == null) {
            throw new IllegalArgumentException();
        } else if (lillllll.IIIIIIII != null) {
            this.IIIIIIII = lillllll;
            this.IIIIIIlI = h1Var;
            this.IIIIIlII = Collections.synchronizedList(new ArrayList());
            this.IIIIIllI = 0;
        } else {
            throw new IllegalStateException();
        }
    }

    public abstract void IIIIIIII();

    public abstract void IIIIIIII(IIllllII iIllllII, boolean z, llIlIIll.IIIIIIII iiiiiiii);

    public void IIIIIIII(llIlIIlI lliliili) {
        this.IIIIIlII.size();
        try {
            if (lliliili.IIIIIIlI != null) {
                if (lliliili.IIIIIIlI.length != 0) {
                    this.IIIIIIlI.IIIIIIII(lliliili.IIIIIIII, false, this.IIIIIIII.IIIIIIIl, new IIIIIIII(lliliili));
                    return;
                }
            }
            IIIIIIII(lliliili, false, new IllegalArgumentException(), 0);
        } catch (IIlllIII e) {
            IIIIIIII(lliliili, false, e, 0);
        } catch (Exception e2) {
            IIIIIIII(lliliili, false, e2, 1);
        }
    }

    public abstract void IIIIIIII(boolean z, long j, Exception exc);

    public boolean IIIIIIII(long j) {
        return j < 10485760;
    }

    public abstract long IIIIIIIl();

    public void IIIIIIIl(llIlIIlI lliliili) {
        try {
            IIIIIIII(lliliili.IIIIIIII, false, (llIlIIll.IIIIIIII) new IIIIIIIl(lliliili));
        } catch (IIlllIII e) {
            IIIIIIII(lliliili, false, e, 0);
        }
    }

    public File IIIIIIlI() {
        File file = this.IIIIIIII.IIIIIIIl;
        return new File(file, this.IIIIIIII.IIIIIlIl + System.currentTimeMillis() + this.IIIIIIII.IIIIIllI);
    }

    public void IIIIIIll() {
        synchronized (this.IIIIIlII) {
            if (!this.IIIIIlII.isEmpty()) {
                this.IIIIIlII.remove(0);
            }
        }
        this.IIIIIlII.size();
        if (!this.IIIIIlII.isEmpty()) {
            IIIIIIII(this.IIIIIlII.get(0));
        } else if (this.IIIIIllI == 2) {
            IIIIIIII(false);
        }
    }

    public void IIIIIIII(boolean z) {
        if (this.IIIIIllI == 0) {
            return;
        }
        if (!this.IIIIIlII.isEmpty()) {
            if (z) {
                this.IIIIIlII.clear();
            }
            this.IIIIIllI = 2;
            return;
        }
        this.IIIIIllI = 0;
        IIIIIIII();
        this.IIIIIIIl = null;
        IIIIIIll iIIIIIll = this.IIIIIlIl;
        if (iIIIIIll != null) {
            llIIIllI.this.IIIIIIll();
        }
    }

    public void IIIIIIII(lIllllII lillllii) {
        IIIIIlII iIIIIlII = this.IIIIIIll;
        if (iIIIIlII != null) {
            llIIIllI lliiilli = llIIIllI.this;
            if (lliiilli.IIIIlIII == 2) {
                lliiilli.IIIIIlll.put(lillllii, new lIlllllI());
                for (lIlllllI next : lliiilli.IIIIIlll.values()) {
                    if (next.IIIIIIII()) {
                        if (next.IIIIIIIl == 3) {
                            next.IIIIIIlI();
                        }
                    }
                }
                if (lliiilli.IIIIIIII.IIIIlIII) {
                    lliiilli.IIIIIIlI();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r2 = (p118io.presage.core.llIIIllI.IIIIIIIl) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void IIIIIIII(p118io.presage.core.llIlIIlI r2, boolean r3, java.lang.Exception r4, int r5) {
        /*
            r1 = this;
            boolean r0 = r2.IIIIIIIl
            if (r0 == 0) goto L_0x0009
            io.presage.core.IIllllII r0 = r2.IIIIIIII
            p118io.presage.core.IIIIlIll.IIIIIIII((p118io.presage.core.IIlllIll) r0)
        L_0x0009:
            io.presage.core.llIlIIIl r2 = r2.IIIIIIll
            if (r2 == 0) goto L_0x0018
            io.presage.core.llIIIllI$IIIIIIIl r2 = (p118io.presage.core.llIIIllI.IIIIIIIl) r2
            io.presage.core.llIIlIll r0 = r2.IIIIIIII
            if (r0 == 0) goto L_0x0018
            byte[] r2 = r2.IIIIIIIl
            r0.IIIIIIII(r2, r3, r4, r5)
        L_0x0018:
            r1.IIIIIIll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.llIlIlII.IIIIIIII(io.presage.core.llIlIIlI, boolean, java.lang.Exception, int):void");
    }

    public void IIIIIIII(FileOutputStream fileOutputStream, llIlIIlI lliliili) {
        try {
            new llIlIlIl(fileOutputStream, false, new IIIIIIlI(lliliili)).IIIIIIII(lliliili.IIIIIIII, false, lliliili.IIIIIIlI);
        } catch (IIlllIII e) {
            IIIIIIII(lliliili, false, e, 0);
        } catch (Exception e2) {
            IIIIIIII(lliliili, false, e2, 1);
        }
    }
}
