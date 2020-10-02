package p118io.presage.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p118io.presage.core.llIIIlIl;
import p118io.presage.core.llIIlllI;
import p118io.presage.core.llIlIlII;

/* renamed from: io.presage.core.llIIIllI */
public class llIIIllI {
    public static final String IIIIlIll = C6343q.IIIIIIII;
    public lIllllll IIIIIIII;
    public llIIlllI IIIIIIIl;
    public llIlIlII IIIIIIlI;
    public int IIIIIIll;
    public AtomicBoolean IIIIIlII;
    public Handler IIIIIlIl;
    public final List<llIIlIlI> IIIIIllI;
    public final LinkedHashMap<lIllllII, lIlllllI> IIIIIlll;
    public int IIIIlIII;
    public boolean IIIIlIIl;
    public IIIIIlIl IIIIlIlI;

    /* renamed from: io.presage.core.llIIIllI$IIIIIIII */
    public class IIIIIIII implements llIIIlIl.IIIIIIII {
        public IIIIIIII() {
        }
    }

    /* renamed from: io.presage.core.llIIIllI$IIIIIIIl */
    public class IIIIIIIl implements llIlIIIl {
        public final /* synthetic */ llIIlIll IIIIIIII;
        public final /* synthetic */ byte[] IIIIIIIl;

        public IIIIIIIl(llIIIllI lliiilli, llIIlIll lliilill, byte[] bArr) {
            this.IIIIIIII = lliilill;
            this.IIIIIIIl = bArr;
        }

        public void IIIIIIII(boolean z, Exception exc, int i) {
            llIIlIll lliilill = this.IIIIIIII;
            if (lliilill != null) {
                lliilill.IIIIIIII(this.IIIIIIIl, z, exc, i);
            }
        }
    }

    /* renamed from: io.presage.core.llIIIllI$IIIIIIlI */
    public class IIIIIIlI implements llIlIlII.IIIIIIll {
        public IIIIIIlI() {
        }
    }

    /* renamed from: io.presage.core.llIIIllI$IIIIIIll */
    public class IIIIIIll implements llIlIlII.IIIIIlII {
        public IIIIIIll() {
        }
    }

    /* renamed from: io.presage.core.llIIIllI$IIIIIlII */
    public class IIIIIlII implements Runnable {
        public IIIIIlII() {
        }

        public void run() {
            int i;
            boolean z;
            llIIIllI.this.IIIIIlII.set(false);
            llIIIllI lliiilli = llIIIllI.this;
            int i2 = lliiilli.IIIIlIII;
            if (i2 == 2 || i2 == 3) {
                if (lliiilli.IIIIlIII == 2) {
                    int i3 = 0;
                    for (Map.Entry<lIllllII, lIlllllI> value : lliiilli.IIIIIlll.entrySet()) {
                        if (((lIlllllI) value.getValue()).IIIIIIII()) {
                            i3++;
                        }
                    }
                    int i4 = lliiilli.IIIIIIll;
                    if (i3 > lliiilli.IIIIIIll) {
                        int i5 = 0;
                        for (Map.Entry next : lliiilli.IIIIIlll.entrySet()) {
                            if (((lIlllllI) next.getValue()).IIIIIIII()) {
                                ((lIlllllI) next.getValue()).IIIIIIIl();
                                i5++;
                            }
                            if (i5 >= i3 - lliiilli.IIIIIIll) {
                                break;
                            }
                        }
                    }
                }
                LinkedList linkedList = new LinkedList(lliiilli.IIIIIlll.keySet());
                linkedList.size();
                for (int i6 = 0; i6 < linkedList.size(); i6++) {
                    boolean z2 = true;
                    if (lliiilli.IIIIlIII != 3) {
                        int size = (linkedList.size() - 1) - i6;
                        lIlllllI lillllli = lliiilli.IIIIIlll.get(linkedList.get(size));
                        if (!(lillllli.IIIIIIII == 1 && lillllli.IIIIIIIl == 0)) {
                            z = false;
                        } else {
                            lillllli.IIIIIIIl = 1;
                            z = true;
                        }
                        if (z) {
                            lliiilli.IIIIIIIl.IIIIIIII((lIllllII) linkedList.get(size), (llIIlllI.IIIIIIll) new llIIIlll(lliiilli));
                        }
                    }
                    lIlllllI lillllli2 = lliiilli.IIIIIlll.get(linkedList.get(i6));
                    if (!(lillllli2.IIIIIIII == 2 && ((i = lillllli2.IIIIIIIl) == 0 || i == 3))) {
                        z2 = false;
                    } else {
                        lillllli2.IIIIIIIl = 2;
                    }
                    if (z2) {
                        lIllllII lillllii = (lIllllII) linkedList.get(i6);
                        lillllii.IIIIIIII.getName();
                        int i7 = lliiilli.IIIIlIII;
                        try {
                            lliiilli.IIIIIIII(new llIIIIll(lillllii, new llIIlIII(lliiilli)), (Params[]) new Void[0]);
                        } catch (Exception unused) {
                            lliiilli.IIIIIlll.remove(lillllii);
                            lliiilli.IIIIIIlI();
                        }
                    }
                }
                lliiilli.IIIIIIll();
            }
        }
    }

    /* renamed from: io.presage.core.llIIIllI$IIIIIlIl */
    public interface IIIIIlIl {
        void IIIIIIII();
    }

    public llIIIllI(Context context, lIllllll lillllll, llIlIlII llililii, llIIlllI lliillli) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (lillllll == null) {
            throw new llIIlIIl();
        } else if (lillllll.IIIIIIIl == null) {
            throw new llIIlIIl();
        } else if (lillllll.IIIIIlIl == null) {
            throw new llIIlIIl();
        } else if (lillllll.IIIIIllI == null) {
            throw new llIIlIIl();
        } else if (lillllll.IIIIIIII == null) {
            throw new llIIlIIl();
        } else if (lliillli == null) {
            throw new llIIlIIl();
        } else if (llililii != null) {
            this.IIIIIIII = lillllll;
            this.IIIIIIIl = lliillli;
            this.IIIIIlIl = handler;
            this.IIIIIIlI = llililii;
            this.IIIIIlII = new AtomicBoolean(false);
            this.IIIIIllI = new ArrayList();
            this.IIIIIlll = new LinkedHashMap<>();
            this.IIIIIIll = Math.min(Math.max(this.IIIIIIII.IIIIIIlI, 1), 100);
            this.IIIIlIII = 0;
        } else {
            throw new llIIlIIl();
        }
    }

    public void IIIIIIII(boolean z, IIIIIlIl iIIIIlIl) {
        int i = this.IIIIlIII;
        if (i != 3 && i != 0) {
            this.IIIIlIII = 3;
            this.IIIIlIlI = iIIIIlIl;
            llIlIlII llililii = this.IIIIIIlI;
            IIIIIIlI iIIIIIlI = new IIIIIIlI();
            if (llililii.IIIIIllI != 0) {
                llililii.IIIIIlIl = iIIIIIlI;
                llililii.IIIIIIII(z);
            }
        }
    }

    public void IIIIIIIl() {
        if (this.IIIIlIII == 0) {
            this.IIIIlIII = 1;
            try {
                this.IIIIIlll.clear();
                File file = this.IIIIIIII.IIIIIIIl;
                long IIIIIIIl2 = this.IIIIIIlI.IIIIIIIl();
                new llIIIlIl(file, IIIIIIIl2, this.IIIIIIII.IIIIIlIl + IIIIlIll + this.IIIIIIII.IIIIIllI, new IIIIIIII()).IIIIIIII(this.IIIIIIII.IIIIIIII, false, new Void[0]);
            } catch (Exception e) {
                this.IIIIlIII = 0;
                throw new llIIlIIl(e);
            }
        }
    }

    public void IIIIIIlI() {
        int i = this.IIIIlIII;
        if ((i == 2 || i == 3) && this.IIIIIlII.compareAndSet(false, true)) {
            this.IIIIIlIl.post(new IIIIIlII());
        }
    }

    public void IIIIIIll() {
        int i = this.IIIIlIII;
        IIIIIIII();
        if (this.IIIIlIII == 3) {
            if ((this.IIIIIIlI.IIIIIllI == 0) && !IIIIIIII()) {
                this.IIIIlIII = 0;
                IIIIIlIl iIIIIlIl = this.IIIIlIlI;
                if (iIIIIlIl != null) {
                    iIIIIlIl.IIIIIIII();
                }
            }
        }
    }

    public <Params, Result> void IIIIIIII(IIlllIlI<Params, Result> iIlllIlI, Params... paramsArr) {
        iIlllIlI.IIIIIIII(this.IIIIIIII.IIIIIIII, false, paramsArr);
    }

    public boolean IIIIIIII() {
        boolean z;
        Iterator<Map.Entry<lIllllII, lIlllllI>> it = this.IIIIIlll.entrySet().iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            Map.Entry next = it.next();
            if (((lIlllllI) next.getValue()).IIIIIIIl == 1) {
                break;
            } else if (((lIlllllI) next.getValue()).IIIIIIII == 2) {
                z = true;
                continue;
            }
        } while (!z);
        return true;
    }

    public void IIIIIIII(lIllllII lillllii, Exception exc) {
        lillllii.IIIIIIII.getName();
        if (exc instanceof FileNotFoundException) {
            this.IIIIIlll.remove(lillllii);
        } else {
            lIlllllI lillllli = this.IIIIIlll.get(lillllii);
            if (lillllli != null && lillllli.IIIIIIIl == 1) {
                lillllli.IIIIIIIl = 3;
            }
        }
        IIIIIIlI();
    }

    public void IIIIIIII(lIllllII lillllii) {
        lillllii.IIIIIIII.getName();
        lIlllllI lillllli = this.IIIIIlll.get(lillllii);
        if (lillllli != null) {
            lillllli.IIIIIIlI();
            lillllli.IIIIIIII = 2;
        }
        IIIIIIlI();
    }

    public void IIIIIIII(lIllllII lillllii, LinkedHashSet<lIllllII> linkedHashSet) {
        if (lillllii != null) {
            lillllii.IIIIIIII.getName();
        }
        linkedHashSet.size();
        if (this.IIIIlIII == 1) {
            llIlIlII llililii = this.IIIIIIlI;
            if (llililii.IIIIIllI == 0) {
                llililii.IIIIIllI = 1;
                llililii.IIIIIIIl = lillllii;
            }
            this.IIIIIIlI.IIIIIIll = new IIIIIIll();
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                this.IIIIIlll.put((lIllllII) it.next(), new lIlllllI());
            }
            this.IIIIlIII = 2;
            for (llIIlIlI next : this.IIIIIllI) {
                IIIIIIII(next.IIIIIIII, next.IIIIIIIl);
            }
            this.IIIIIllI.clear();
            if (this.IIIIlIIl || this.IIIIIIII.IIIIIlll) {
                this.IIIIlIIl = false;
                IIIIIIlI();
            }
        }
    }

    public void IIIIIIII(byte[] bArr, llIIlIll lliilill) {
        llIlIlII llililii;
        int i = this.IIIIlIII;
        if (i == 1) {
            this.IIIIIllI.add(new llIIlIlI(bArr, lliilill));
        } else if (i == 2 && (llililii = this.IIIIIIlI) != null) {
            IIIIIIIl iIIIIIIl = new IIIIIIIl(this, lliilill, bArr);
            if (llililii.IIIIIllI == 1) {
                new String(bArr);
                llililii.IIIIIlII.add(new llIlIIlI(llililii.IIIIIIII.IIIIIIII, false, bArr, iIIIIIIl));
                "StorageFileWriter - write - pending list size: " + llililii.IIIIIlII.size();
                if (llililii.IIIIIlII.size() == 1) {
                    llililii.IIIIIIII(llililii.IIIIIlII.get(0));
                    return;
                }
                return;
            }
            iIIIIIIl.IIIIIIII(false, new IllegalStateException(), 0);
        }
    }
}
