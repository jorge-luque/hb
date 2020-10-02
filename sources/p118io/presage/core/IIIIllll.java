package p118io.presage.core;

import android.content.Context;
import android.os.Build;
import android.support.p004v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import p118io.presage.core.C6337o1;
import p118io.presage.core.IIIIIIlI;
import p118io.presage.core.lIlllIlI;

/* renamed from: io.presage.core.IIIIllll */
public class IIIIllll implements IIIIlllI {
    public static final String IIIIlIII = lllIIlll.IIIIIIII;
    public static final String IIIIlIIl = lllIIlll.IIIIIIIl;
    public static final String IIIIlIlI = lllIIlll.IIIIIIlI;
    public static final String IIIIlIll = lllIIlll.IIIIIIll;
    public static final String IIIIllII = C6332n0.IIIIIIIl;
    public static IIIIllll IIIIllIl;
    public IIIIIlIl IIIIIIII;
    public final Context IIIIIIIl;
    public AtomicInteger IIIIIIlI = new AtomicInteger(0);
    public boolean IIIIIIll = false;
    public IIlllIIl IIIIIlII;
    public lIlIIlIl IIIIIlIl;
    public IlIIIlIl IIIIIllI;
    public IIIIIlll IIIIIlll;

    /* renamed from: io.presage.core.IIIIllll$IIIIIIII */
    public class IIIIIIII implements IIIIIIlI.IIIIIIII {
        public IIIIIIII() {
        }
    }

    /* renamed from: io.presage.core.IIIIllll$IIIIIIIl */
    public class IIIIIIIl implements C6337o1.IIIIIIlI {
        public IIIIIIIl() {
        }

        public void IIIIIIII(C6337o1 o1Var, C6333n1 n1Var) {
            try {
                String IIIIIIII2 = IIIIllll.this.IIIIIlll.IIIIIIII();
                IIIIIlll iIIIIlll = IIIIllll.this.IIIIIlll;
                String str = n1Var.IIIIIIII;
                String str2 = iIIIIlll.IIIIIlII;
                if (str2 == null || str2.isEmpty() || !iIIIIlll.IIIIIlII.equals(str)) {
                    iIIIIlll.IIIIlIII().putString(IIIIIlll.IIIlIIIl, str);
                    iIIIIlll.IIIIIlII = str;
                }
                IIIIIlll iIIIIlll2 = IIIIllll.this.IIIIIlll;
                boolean z = n1Var.IIIIIIlI;
                Boolean bool = iIIIIlll2.IIIIIllI;
                if (bool == null || bool.booleanValue() != z) {
                    iIIIIlll2.IIIIlIII().putBoolean(IIIIIlll.IIIlIlIl, z);
                    iIIIIlll2.IIIIIllI = Boolean.valueOf(z);
                }
                boolean z2 = false;
                boolean z3 = IIIIIIII2 != null && !IIIIIIII2.isEmpty() && !IIIIIIII2.equals(n1Var.IIIIIIII);
                boolean IIIlIIII = IIIIllll.this.IIIIIlll.IIIlIIII();
                boolean z4 = !n1Var.IIIIIIIl;
                IIIIIlll iIIIIlll3 = IIIIllll.this.IIIIIlll;
                Boolean bool2 = iIIIIlll3.IIIIIlIl;
                if (bool2 == null || bool2.booleanValue() != z4) {
                    iIIIIlll3.IIIIlIII().putBoolean(IIIIIlll.IIIlIIlI, z4);
                    iIIIIlll3.IIIIlIII().apply();
                    iIIIIlll3.IIIIIlIl = Boolean.valueOf(z4);
                }
                if (z4 != IIIlIIII) {
                    z2 = true;
                }
                if (z3) {
                    boolean unused = IIIIllll.this.IIIIIIll = true;
                    IIIIllll.this.IIIIIlIl();
                } else if (z2) {
                    boolean unused2 = IIIIllll.this.IIIIIIll = true;
                    IIIIllll.this.IIIIIlll.IIIIIIII(IIIIllll.this.IIIIIlII.IIIIIIlI, false, new IIIlIIII(IIIIllll.this));
                } else {
                    IIIIllll.IIIIIIll(IIIIllll.this);
                }
            } catch (Exception e) {
                IIIIllll.this.IIIIIIII(e, 1);
            }
        }

        public void IIIIIIII(C6337o1 o1Var, Exception exc, int i) {
            IIIIllll.this.IIIIIIII(exc, i);
        }
    }

    /* renamed from: io.presage.core.IIIIllll$IIIIIIlI */
    public class IIIIIIlI implements lIlllIlI.IIIIIIII {
        public IIIIIIlI() {
        }

        public void IIIIIIII(Set<lIlllIll> set) {
            IIIIllll.this.IIIIIlll.IIIIIIII(IIIIllll.this.IIIIIlII.IIIIIIlI, false, new IIIlIIII(IIIIllll.this));
        }
    }

    /* renamed from: io.presage.core.IIIIllll$IIIIIIll */
    public class IIIIIIll implements lIlllIlI.IIIIIIII {
        public IIIIIIll() {
        }

        public void IIIIIIII(Set<lIlllIll> set) {
            boolean unused = IIIIllll.this.IIIIIIll = false;
            if (IIIIllll.this.IIIIIIll()) {
                IIIIllll.this.IIIIIIIl();
            }
        }
    }

    /* renamed from: io.presage.core.IIIIllll$IIIIIlII */
    public class IIIIIlII implements IIIIlllI {
        public final /* synthetic */ lIlllIlI.IIIIIIII IIIIIIII;

        public IIIIIlII(lIlllIlI.IIIIIIII iiiiiiii) {
            this.IIIIIIII = iiiiiiii;
        }

        public void IIIIIIII() {
            IIIIllll.this.IIIIIIIl(this.IIIIIIII);
        }
    }

    /* renamed from: io.presage.core.IIIIllll$IIIIIlIl */
    public interface IIIIIlIl {
    }

    public IIIIllll(Context context) {
        this.IIIIIIIl = context.getApplicationContext();
    }

    public static IIIIllll IIIIIIII(Context context) {
        if (IIIIllIl == null) {
            IIIIllIl = new IIIIllll(context);
        }
        return IIIIllIl;
    }

    public static /* synthetic */ void IIIIIIll(IIIIllll iIIIllll) {
        if (iIIIllll.IIIIIIlI()) {
            lIIllIll liillill = iIIIllll.IIIIIlll.IIIIIlll;
            try {
                IIIIIlll iIIIIlll = iIIIllll.IIIIIlll;
                if ((iIIIIlll.IIIIIlll == null || iIIIIlll.IIIIIlll.IIIIIIIl()) && llllIlIl.IIIIIIlI(iIIIllll.IIIIIIIl)) {
                    IIIIIlll iIIIIlll2 = iIIIllll.IIIIIlll;
                    boolean z = false;
                    if (iIIIIlll2.IIIIlllI().getInt(IIIIIlll.IIIlIIll, 0) == ((int) Math.floor((double) (((float) System.currentTimeMillis()) / 8.64E7f))) && iIIIIlll2.IIIIlllI().getInt(IIIIIlll.IIIlIlII, 0) >= 10) {
                        llIlIlll.IIIIIIII(IIIIlIll.IIIIIIII(500));
                        z = true;
                    }
                    if (!z) {
                        new lIlIIlII(iIIIllll.IIIIIIIl, iIIIllll.IIIIIlll).IIIIIIII(iIIIllll.IIIIIlII.IIIIIIll, new IIIlIIIl(iIIIllll));
                        return;
                    }
                }
                IIIIIlll iIIIIlll3 = iIIIllll.IIIIIlll;
                if (iIIIIlll3.IIIIIlll != null) {
                    iIIIIlll3.IIIIIlll.IIIIIIII();
                    iIIIllll.IIIIIlll.IIIIIlll.IIIIIIIl();
                    iIIIllll.IIIIIllI();
                    return;
                }
                iIIIllll.IIIIlIII();
            } catch (Exception e) {
                iIIIllll.IIIIIIII(e);
            }
        }
    }

    public void IIIIIIII() {
        IIIIIIIl();
    }

    public final void IIIIIIII(IIIIlllI iIIIlllI) {
        if (iIIIlllI != null) {
            iIIIlllI.IIIIIIII();
        }
    }

    public final void IIIIIIII(Exception exc, int i) {
        lIIIIlIl.IIIIIIII(exc, i);
        IIIIlIII();
    }

    public final void IIIIIIIl() {
        if (IIIIIIll() && !this.IIIIIIll) {
            IlIIIlIl ilIIIlIl = this.IIIIIllI;
            if (ilIIIlIl != null) {
                if (ilIIIlIl.IIIIIIlI == 0) {
                }
            }
            llIlIlll.IIIIIlII();
            IlIIIlIl ilIIIlIl2 = this.IIIIIllI;
            if (ilIIIlIl2 != null) {
                if (!(ilIIIlIl2.IIIIIIlI == 0)) {
                    return;
                }
            }
            if (llIlIlll.IIIIIlII()) {
                try {
                    if (this.IIIIIlII != null) {
                        this.IIIIIlII.IIIIIIII();
                    }
                } catch (Exception e) {
                    lIIIIlIl.IIIIIIII(e, 1);
                }
                this.IIIIIIlI.set(0);
            }
        }
    }

    public boolean IIIIIIlI() {
        return this.IIIIIIlI.get() == 1;
    }

    public boolean IIIIIIll() {
        return this.IIIIIIlI.get() == 2;
    }

    public final void IIIIIlII() {
        if (IIIIIIlI()) {
            try {
                new C6337o1(this.IIIIIIIl).IIIIIIII(this.IIIIIlII.IIIIIlII, false, new IIIIIIIl());
            } catch (Exception e) {
                IIIIIIII(e, 1);
            }
        }
    }

    public final void IIIIIlIl() {
        IIIIIIII((lIlllIlI.IIIIIIII) new IIIIIIlI());
    }

    public final void IIIIIllI() {
        String str;
        if (IIIIIIlI()) {
            lIIllIll liillill = this.IIIIIlll.IIIIIlll;
            if (liillill.IIIIIllI && liillill.IIIIIlll.equals(IIIIllII) && (str = this.IIIIIlll.IIIIIlll.IIIIlIII) != null && !str.isEmpty()) {
                Log.e("Ogury", this.IIIIIlll.IIIIIlll.IIIIlIII);
            }
            lIIllIll liillill2 = this.IIIIIlll.IIIIIlll;
            if (liillill2 != null) {
                if (!liillill2.IIIIIlIl) {
                    this.IIIIIIll = true;
                    IIIIIIII((lIlllIlI.IIIIIIII) new IIIIIIll());
                } else {
                    if (!liillill2.IIIIIIlI) {
                        IIIIIIIl((IIIIlllI) null);
                    } else if (IIIIIIlI()) {
                        lIIIIlIl.IIIIIIll().post(new lIIIIIII(this.IIIIIIIl, this.IIIIIlll));
                    }
                    if (!this.IIIIIlll.IIIIIlll.IIIIllll) {
                        llIlIlll.IIIIIlIl();
                    } else if (IIIIIIlI()) {
                        try {
                            llIlIlll.IIIIIIII(this.IIIIIIIl, new llIlllIl(this.IIIIIlII.IIIIIlII, this.IIIIIlll.IIIIIlll.IIIlIIIl), new lIllllll(this.IIIIIlII.IIIIIIlI, this.IIIIIlll.IIIIllll(), IIIIlIlI, IIIIlIll, 100, 10240, false, true, true), new lIlllIIl(this.IIIIIlII.IIIIIIll, this.IIIIIlll.IIIIIIIl(), this.IIIIIlll.IIIIIIII(), this.IIIIIlll.IIIIllIl(), this.IIIIIlll.IIIIIlll.IIIlIIII));
                        } catch (Exception e) {
                            lIIIIlIl.IIIIIIII(e, 1);
                        }
                    }
                    if (this.IIIIIlll.IIIIIlll.IIIIlIIl && IIIIIIlI()) {
                        try {
                            IlIIIlIl ilIIIlIl = new IlIIIlIl(this.IIIIIIIl, new IlIIIIII(this.IIIIIlII.IIIIIIIl, this.IIIIIlII.IIIIIlII, this.IIIIIlll.IIIIlIIl(), this.IIIIIlll.IIIIIlll.IIIIlIll), new lIllllll(this.IIIIIlII.IIIIIIlI, this.IIIIIlll.IIIIlIll(), IIIIlIII, IIIIlIIl, this.IIIIIlll.IIIIIlll.IIIIlIlI.IIIIIIII, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID * this.IIIIIlll.IIIIIlll.IIIIlIlI.IIIIIIIl, true, true, true), new lIlllIIl(this.IIIIIlII.IIIIIIll, this.IIIIIlll.IIIIIIIl(), this.IIIIIlll.IIIIIIII(), this.IIIIIlll.IIIIllIl(), this.IIIIIlll.IIIIIlll.IIIIIIIl), new lIIlIIll(this.IIIIIlII.IIIIIIlI, this.IIIIIlll.IIIIIlll.IIIlIIlI, this.IIIIIlll.IIIIIlll.IIIlIIll, this.IIIIIlll.IIIIIlll.IIIlIlII, this.IIIIIlll.IIIIIlll.IIIlIlIl, this.IIIIIlll.IIIIIlll.IIIlIllI));
                            this.IIIIIllI = ilIIIlIl;
                            ilIIIlIl.IIIIIIlI();
                        } catch (Exception e2) {
                            lIIIIlIl.IIIIIIII(e2, 1);
                        }
                    }
                }
                if (!this.IIIIIlll.IIIIIlll.IIIIllIl.isEmpty()) {
                    lIIllIll liillill3 = this.IIIIIlll.IIIIIlll;
                    Set<Integer> set = liillill3.IIIIllIl;
                    Set<Integer> set2 = liillill3.IIIIlllI;
                    if (IIIIIIlI()) {
                        try {
                            this.IIIIIlIl = new lIlIIlIl(this.IIIIIIIl);
                            this.IIIIIlIl.IIIIIIII(set2.iterator().next().intValue(), new lIlIlIII(this.IIIIIIIl, set), this.IIIIIlII.IIIIIlIl, false);
                        } catch (Exception e3) {
                            lIIIIlIl.IIIIIIII(e3, 1);
                        }
                    }
                }
                for (C6350r2 next : this.IIIIIlll.IIIIIlll.IIIIllII) {
                    if (next.IIIIIIIl) {
                        try {
                            next.IIIIIIlI();
                        } catch (Exception unused) {
                        }
                    } else {
                        next.IIIIIIIl();
                    }
                }
                if (this.IIIIIlll.IIIIIlll.IIIIllIl.isEmpty()) {
                    lIIllIll liillill4 = this.IIIIIlll.IIIIIlll;
                    boolean z = liillill4.IIIIIlIl;
                    if (!z || (z && !liillill4.IIIIIIlI && !liillill4.IIIIllll && !liillill4.IIIIlIIl)) {
                        IIIIlIII();
                        return;
                    }
                    return;
                }
                return;
            }
            IIIIIIII((Exception) new lIIlllIl());
        }
    }

    public final void IIIIIlll() {
        try {
            if (this.IIIIIlIl != null) {
                lIlIIlIl liliilil = this.IIIIIlIl;
                if (liliilil.IIIIIIIl) {
                    Thread.currentThread().getName();
                    liliilil.IIIIIIIl = false;
                    liliilil.IIIIIIlI.IIIIIIII();
                    liliilil.IIIIIIll.IIIIIIIl();
                    if (liliilil.IIIIIlII) {
                        IIIIlIll.IIIIIIII((IIlllIll) liliilil.IIIIIIll);
                    }
                }
            }
        } catch (Exception e) {
            lIIIIlIl.IIIIIIII(e, 1);
        }
    }

    public final void IIIIlIII() {
        IIIIIIII(601);
        IIIIIlIl iIIIIlIl = this.IIIIIIII;
        if (iIIIIlIl != null) {
            IIIIIlII iIIIIlII = IIIIIlII.this;
            iIIIIlII.IIIIIIlI.IIIIIIII(iIIIIlII.IIIIIIIl);
        }
    }

    public final void IIIIIIII(Exception exc) {
        lIIIIlIl.IIIIIIII(exc, 1);
        IIIIlIII();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        if ((r0.IIIIIllI == 0) != false) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void IIIIIIII(p118io.presage.core.lIlllIlI.IIIIIIII r4) {
        /*
            r3 = this;
            p118io.presage.core.llIlIlll.IIIIIlIl()
            io.presage.core.lIIIIlIl r0 = p118io.presage.core.lIIIIlIl.IIIIlIlI
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0012
            int r0 = r0.IIIIIllI
            if (r0 != 0) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 == 0) goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            if (r1 != 0) goto L_0x001e
            io.presage.core.IIIIllll$IIIIIlII r0 = new io.presage.core.IIIIllll$IIIIIlII
            r0.<init>(r4)
            r3.IIIIIIIl((p118io.presage.core.IIIIlllI) r0)
            goto L_0x0021
        L_0x001e:
            r3.IIIIIIIl((p118io.presage.core.lIlllIlI.IIIIIIII) r4)
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IIIIllll.IIIIIIII(io.presage.core.lIlllIlI$IIIIIIII):void");
    }

    public final void IIIIIIIl(lIlllIlI.IIIIIIII iiiiiiii) {
        HashSet hashSet = new HashSet();
        this.IIIIIlll.IIIIlIIl();
        hashSet.add(new lIlllIll(this.IIIIIlll.IIIIlIIl().getAbsolutePath(), 0));
        this.IIIIIlll.IIIIlIll();
        hashSet.add(new lIlllIll(this.IIIIIlll.IIIIlIll().getAbsolutePath(), 0));
        this.IIIIIlll.IIIIIIlI();
        hashSet.add(new lIlllIll(this.IIIIIlll.IIIIIIlI().getAbsolutePath(), 0));
        this.IIIIIlll.IIIIllll();
        hashSet.add(new lIlllIll(this.IIIIIlll.IIIIllll().getAbsolutePath(), 0));
        String str = IIllllll.IIIIllIl;
        if (str != null) {
            hashSet.add(new lIlllIll(str, 1));
        }
        hashSet.size();
        try {
            new lIlllIlI(this.IIIIIIIl, hashSet, iiiiiiii).IIIIIIII(this.IIIIIlII.IIIIIIlI, false, new Void[0]);
        } catch (IIlllIII unused) {
            if (iiiiiiii != null) {
                iiiiiiii.IIIIIIII(hashSet);
            }
        }
    }

    public void IIIIIIII(IIIIIlll iIIIIlll, int i, IIIIIlIl iIIIIlIl) {
        if (iIIIIlll == null) {
            lIIIIlIl.IIIIIIII(new NullPointerException(), 1);
            IIIIlIII();
        }
        try {
            if (this.IIIIIIlI.compareAndSet(0, 1)) {
                llIlIlll.IIIIIIII(IIIIlIll.IIIIIIII(i));
                llIlIlll.IIIIIIII(IIIIlIll.IIIIIIII(100));
                this.IIIIIIII = iIIIIlIl;
                this.IIIIIlll = iIIIIlll;
                this.IIIIIlII = new IIlllIIl();
                if (Build.VERSION.SDK_INT < 21 || !this.IIIIIlll.IIIIIlIl().exists()) {
                    IIIIIlII();
                    return;
                }
                new IIIIIIlI(this.IIIIIIIl, new IIIIIIII()).IIIIIIII(this.IIIIIlII.IIIIIlII, false, new IIIIIIlI.IIIIIIIl(this.IIIIIlll.IIIIIlIl(), this.IIIIIlll.IIIIlIlI()), new IIIIIIlI.IIIIIIIl(this.IIIIIlll.IIIIIllI(), this.IIIIIlll.IIIIlIll()), new IIIIIIlI.IIIIIIIl(this.IIIIIlll.IIIIIlII(), this.IIIIIlll.IIIIlIIl()), new IIIIIIlI.IIIIIIIl(this.IIIIIlll.IIIIIlll(), this.IIIIIlll.IIIIllll()));
            }
        } catch (Exception e) {
            lIIIIlIl.IIIIIIII(e, 1);
            IIIIlIII();
        }
    }

    public final void IIIIIIIl(IIIIlllI iIIIlllI) {
        lIIIIlIl.IIIIIIll().post(new lIIIIIll(iIIIlllI));
    }

    public void IIIIIIII(int i) {
        if (this.IIIIIIlI.compareAndSet(1, 2)) {
            llIlIlll.IIIIIIII(IIIIlIll.IIIIIIII(i));
            llIlIlll.IIIIIIII(IIIIlIll.IIIIIIII(101));
            try {
                if (this.IIIIIllI == null || !this.IIIIIllI.IIIIIIII()) {
                    IIIIIIII((IIIIlllI) this);
                } else {
                    this.IIIIIllI.IIIIIIIl(this);
                }
            } catch (Exception e) {
                try {
                    lIIIIlIl.IIIIIIII(e, 1);
                    IIIIIIII((IIIIlllI) this);
                } catch (Exception e2) {
                    lIIIIlIl.IIIIIIII(e2, 1);
                    IIIIIIIl();
                    return;
                }
            }
            IIIIIlll();
            llIlIlll.IIIIIlIl();
            if (llIlIlll.IIIIIIll()) {
                llIlIlll llililll = llIlIlll.IIIIlIII;
                llIlIllI llililli = new llIlIllI(this);
                if (llililll.IIIIIllI != 0) {
                    llililll.IIIIIlll = llililli;
                    llililll.IIIIIIII();
                    return;
                }
                return;
            }
            IIIIIIII();
        }
    }
}
