package p118io.presage.core;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import p118io.presage.core.C6290c2;
import p118io.presage.core.IIIIIIlI;
import p118io.presage.core.IIIIIlll;

/* renamed from: io.presage.core.IIIIIIll */
public class IIIIIIll {
    public static final String IIIIIIlI = C6332n0.IIIIIIII;
    public static volatile IIIIIIll IIIIIIll;
    public Context IIIIIIII;
    public IIIIIlll IIIIIIIl;

    /* renamed from: io.presage.core.IIIIIIll$IIIIIIII */
    public class IIIIIIII implements C6290c2.IIIIIIII {
        public final /* synthetic */ int IIIIIIII;
        public final /* synthetic */ IIIIlIlI IIIIIIIl;
        public final /* synthetic */ int IIIIIIlI;
        public final /* synthetic */ Object[] IIIIIIll;

        public IIIIIIII(int i, IIIIlIlI iIIIlIlI, int i2, Object[] objArr) {
            this.IIIIIIII = i;
            this.IIIIIIIl = iIIIlIlI;
            this.IIIIIIlI = i2;
            this.IIIIIIll = objArr;
        }
    }

    /* renamed from: io.presage.core.IIIIIIll$IIIIIIIl */
    public class IIIIIIIl implements IIIIlllI {
        public IIIIIIIl(IIIIIIll iIIIIIll) {
        }

        public void IIIIIIII() {
            IIllllIl IIIIIIlI = IIllllIl.IIIIIIlI();
            IIllllII iIllllII = IIIIIIlI.IIIIIIII;
            if (iIllllII != null) {
                boolean isTerminated = iIllllII.IIIIIIII.isTerminated();
            }
            IIllllII iIllllII2 = IIIIIIlI.IIIIIIIl;
            if (iIllllII2 != null) {
                boolean isTerminated2 = iIllllII2.IIIIIIII.isTerminated();
            }
            IIllllII iIllllII3 = IIIIIIlI.IIIIIIlI;
            if (iIllllII3 != null) {
                boolean isTerminated3 = iIllllII3.IIIIIIII.isTerminated();
            }
            IIIIlIll.IIIIIIII((IIlllIll) IIIIIIlI.IIIIIIII);
            IIIIlIll.IIIIIIII((IIlllIll) IIIIIIlI.IIIIIIIl);
            IIIIlIll.IIIIIIII((IIlllIll) IIIIIIlI.IIIIIIlI);
        }
    }

    public IIIIIIll(Context context) {
        if (context == null) {
            Log.e("Presage.Core", "The provided context is null");
            return;
        }
        this.IIIIIIII = context.getApplicationContext();
        this.IIIIIIIl = new IIIIIlll(this.IIIIIIII);
        Looper.getMainLooper().getThread().setUncaughtExceptionHandler(new IIIIIllI(this, Looper.getMainLooper().getThread().getUncaughtExceptionHandler()));
        if (Build.VERSION.SDK_INT >= 21 && this.IIIIIIIl.IIIIIIll().exists()) {
            try {
                new IIIIIIlI(this.IIIIIIII, (IIIIIIlI.IIIIIIII) null).IIIIIIII(IIllllIl.IIIIIIlI().IIIIIIIl(), false, new IIIIIIlI.IIIIIIIl(this.IIIIIIIl.IIIIIIll(), this.IIIIIIIl.IIIIIIlI()));
            } catch (Exception unused) {
            }
        }
    }

    public final Throwable IIIIIIII(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public final void IIIIIIII(int i, IIIIlIlI iIIIlIlI, int i2, Object... objArr) {
        try {
            new C6290c2(this.IIIIIIII, new IIIIIIII(i, iIIIlIlI, i2, objArr)).IIIIIIII(IIllllIl.IIIIIIlI().IIIIIIIl(), false, new Void[0]);
        } catch (Exception unused) {
            IIIIIIII(iIIIlIlI);
        }
    }

    public final void IIIIIIII(IIIIlIlI iIIIlIlI) {
        lIIIIlIl.IIIIIIll().post(new lIIIIIll(new IIIIIIIl(this)));
        if (iIIIlIlI != null) {
            iIIIlIlI.IIIIIIII();
        }
    }

    public void IIIIIIII(boolean z, IIIIlIlI iIIIlIlI, int i) {
        if (z) {
            IIIIIIII(4, iIIIlIlI, i, new Object[0]);
        } else {
            IIIIIIII(3, iIIIlIlI, i, new Object[0]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00da, code lost:
        if (r7 != 2) goto L_0x00f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void IIIIIIIl(int r7, p118io.presage.core.IIIIlIlI r8, int r9, java.lang.Object... r10) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0094
            if (r10 == 0) goto L_0x0008
            int r1 = r10.length
            if (r1 != 0) goto L_0x000b
        L_0x0008:
            r6.IIIIIIII((p118io.presage.core.IIIIlIlI) r8)
        L_0x000b:
            r10 = r10[r0]
            java.lang.String r10 = (java.lang.String) r10
            r1 = 0
            if (r10 == 0) goto L_0x0018
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L_0x0048
        L_0x0018:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected API key: "
            r2.append(r3)
            if (r10 != 0) goto L_0x0026
            r3 = r1
            goto L_0x003a
        L_0x0026:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "\""
            r3.append(r4)
            r3.append(r10)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x003a:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Presage.Core"
            android.util.Log.e(r3, r2)
            java.lang.String r10 = ""
        L_0x0048:
            io.presage.core.IIIIIlll r2 = r6.IIIIIIIl
            r2.IIIIIIIl()
            io.presage.core.IIIIIlll r2 = r6.IIIIIIIl
            java.lang.String r2 = r2.IIIIIIIl()
            io.presage.core.IIIIIlll r3 = r6.IIIIIIIl
            java.lang.String r4 = r3.IIIIIIll
            if (r4 == 0) goto L_0x0067
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0067
            java.lang.String r4 = r3.IIIIIIll
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x0079
        L_0x0067:
            android.content.SharedPreferences$Editor r4 = r3.IIIIlIII()
            java.lang.String r5 = p118io.presage.core.IIIIIlll.IIIlIIII
            r4.putString(r5, r10)
            android.content.SharedPreferences$Editor r4 = r3.IIIIlIII()
            r4.apply()
            r3.IIIIIIll = r10
        L_0x0079:
            if (r2 == 0) goto L_0x0094
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0094
            boolean r10 = r2.equals(r10)
            if (r10 != 0) goto L_0x0094
            io.presage.core.IIIIIlll r10 = r6.IIIIIIIl
            io.presage.core.IIllllIl r2 = p118io.presage.core.IIllllIl.IIIIIIlI()
            io.presage.core.IIllllII r2 = r2.IIIIIIII()
            r10.IIIIIIII(r2, r0, r1)
        L_0x0094:
            io.presage.core.IIIIIlll r10 = r6.IIIIIIIl
            java.lang.String r10 = r10.IIIIIIIl()
            r1 = 1
            if (r10 == 0) goto L_0x00aa
            io.presage.core.IIIIIlll r10 = r6.IIIIIIIl
            java.lang.String r10 = r10.IIIIIIIl()
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x00aa
            r0 = 1
        L_0x00aa:
            if (r0 == 0) goto L_0x00f5
            android.content.Context r10 = r6.IIIIIIII
            boolean r10 = p118io.presage.core.llllIIll.IIIIIIIl(r10)
            r0 = 2
            r2 = 4
            if (r10 == 0) goto L_0x00d5
            if (r7 == 0) goto L_0x00c0
            if (r7 == r1) goto L_0x00c0
            if (r7 != r0) goto L_0x00bd
            goto L_0x00c0
        L_0x00bd:
            if (r7 != r2) goto L_0x00f8
            goto L_0x00dc
        L_0x00c0:
            android.content.Context r7 = r6.IIIIIIII
            io.presage.core.IIIIllll r7 = p118io.presage.core.IIIIllll.IIIIIIII((android.content.Context) r7)
            boolean r7 = r7.IIIIIIlI()
            if (r7 != 0) goto L_0x00f8
            io.presage.core.IIIIIlII r7 = new io.presage.core.IIIIIlII
            r7.<init>(r6, r9, r8)
            r6.IIIIIIII((p118io.presage.core.IIIIIlll.IIIIIIll) r7)
            goto L_0x00f8
        L_0x00d5:
            if (r7 == r2) goto L_0x00dc
            r10 = 3
            if (r7 == r10) goto L_0x00dc
            if (r7 != r0) goto L_0x00f5
        L_0x00dc:
            android.content.Context r7 = r6.IIIIIIII
            io.presage.core.IIIIllll r7 = p118io.presage.core.IIIIllll.IIIIIIII((android.content.Context) r7)
            boolean r7 = r7.IIIIIIlI()
            if (r7 == 0) goto L_0x00f1
            io.presage.core.IIIIIlIl r7 = new io.presage.core.IIIIIlIl
            r7.<init>(r6, r9, r8)
            r6.IIIIIIII((p118io.presage.core.IIIIIlll.IIIIIIll) r7)
            goto L_0x00f8
        L_0x00f1:
            r6.IIIIIIII((p118io.presage.core.IIIIlIlI) r8)
            goto L_0x00f8
        L_0x00f5:
            r6.IIIIIIII((p118io.presage.core.IIIIlIlI) r8)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IIIIIIll.IIIIIIIl(int, io.presage.core.IIIIlIlI, int, java.lang.Object[]):void");
    }

    public void IIIIIIII(IIIIIlll iIIIIlll) {
        lIIllIll liillill = iIIIIlll.IIIIIlll;
        if (liillill != null && liillill.IIIIIlIl) {
            boolean z = liillill.IIIIIIlI;
        }
        lIIllIll liillill2 = iIIIIlll.IIIIIlll;
        if (liillill2 != null && liillill2.IIIIIlIl && liillill2.IIIIIIlI) {
            lIIIIlIl.IIIIIIll().post(new lIIIIIII(this.IIIIIIII, iIIIIlll));
        }
    }

    public final void IIIIIIII(IIIIIlll.IIIIIIll iIIIIIll) {
        if (iIIIIIll != null) {
            IIIIIlll iIIIIlll = this.IIIIIIIl;
            lIIllIll liillill = iIIIIlll.IIIIIlll;
            if (liillill == null) {
                iIIIIlll.IIIIlIIl = iIIIIIll;
                File IIIIlIlI = iIIIIlll.IIIIlIlI();
                try {
                    new llIIIIII(IIIIlIlI, new IIIIlIII(iIIIIlll)).IIIIIIII(IIllllIl.IIIIIIlI().IIIIIIII(), false, new Void[0]);
                } catch (Exception e) {
                    lIIIIlIl.IIIIIIII(e, 1);
                    iIIIIlll.IIIIIIII(iIIIIlll.IIIIIlll);
                }
            } else {
                iIIIIIll.IIIIIIII(liillill);
            }
        } else {
            throw null;
        }
    }
}
