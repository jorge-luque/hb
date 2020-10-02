package p118io.presage.core;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.FileOutputStream;
import java.io.IOException;
import p118io.presage.core.llIlIIll;

/* renamed from: io.presage.core.llIlIIII */
public class llIlIIII extends llIlIlII {
    public final lIllIlll IIIIIlll;
    public final long IIIIlIII;
    public FileOutputStream IIIIlIIl;

    /* renamed from: io.presage.core.llIlIIII$IIIIIIII */
    public class IIIIIIII implements llIlIIll.IIIIIIII {
        public final /* synthetic */ llIlIIll.IIIIIIII IIIIIIII;

        public IIIIIIII(llIlIIll.IIIIIIII iiiiiiii) {
            this.IIIIIIII = iiiiiiii;
        }

        public void IIIIIIII(FileOutputStream fileOutputStream) {
            llIlIIII lliliiii = llIlIIII.this;
            lliliiii.IIIIlIIl = fileOutputStream;
            lliliiii.IIIIIIII(this.IIIIIIII);
        }
    }

    public llIlIIII(lIllllll lillllll, lIllIlll lillilll) {
        super(lillllll);
        this.IIIIIlll = lillilll;
        this.IIIIlIII = Math.min(Math.max(lillllll.IIIIIIll, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID), 104857600);
    }

    public void IIIIIIII() {
        FileOutputStream fileOutputStream = this.IIIIlIIl;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
            this.IIIIlIIl = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r2 != false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void IIIIIIII(p118io.presage.core.IIllllII r19, boolean r20, p118io.presage.core.llIlIIll.IIIIIIII r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            io.presage.core.lIllllII r2 = r0.IIIIIIIl
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0018
            long r5 = r2.IIIIIIlI
            long r7 = r0.IIIIlIII
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            if (r2 == 0) goto L_0x0058
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            if (r2 == 0) goto L_0x0037
            io.presage.core.lIllllll r2 = r0.IIIIIIII
            boolean r2 = r2.IIIIIlII
            if (r2 == 0) goto L_0x0024
            r18.IIIIIIII()
        L_0x0024:
            io.presage.core.lIllllII r2 = new io.presage.core.lIllllII
            io.presage.core.lIllllII r5 = r0.IIIIIIIl
            java.io.File r6 = r5.IIIIIIII
            java.lang.String r7 = r5.IIIIIIIl
            long r8 = r5.IIIIIIlI
            long r10 = r5.IIIIIIll
            r5 = r2
            r5.<init>(r6, r7, r8, r10)
            r0.IIIIIIII((p118io.presage.core.lIllllII) r2)
        L_0x0037:
            long r5 = java.lang.System.currentTimeMillis()
            io.presage.core.lIllllII r2 = new io.presage.core.lIllllII
            java.io.File r13 = r18.IIIIIIlI()
            r14 = 0
            r12 = r2
            r16 = r5
            r12.<init>(r13, r14, r16)
            r0.IIIIIIIl = r2
            io.presage.core.lIllIlll r2 = r0.IIIIIlll
            android.content.SharedPreferences$Editor r7 = r2.IIIIIIIl
            java.lang.String r2 = r2.IIIIIIlI
            android.content.SharedPreferences$Editor r2 = r7.putLong(r2, r5)
            r2.apply()
        L_0x0058:
            io.presage.core.lIllllll r2 = r0.IIIIIIII
            boolean r2 = r2.IIIIIlII
            if (r2 == 0) goto L_0x0069
            java.io.FileOutputStream r2 = r0.IIIIlIIl
            if (r2 != 0) goto L_0x0063
            goto L_0x0069
        L_0x0063:
            if (r1 == 0) goto L_0x0080
            r1.IIIIIIII(r2)
            goto L_0x0080
        L_0x0069:
            io.presage.core.llIlIIll r2 = new io.presage.core.llIlIIll
            io.presage.core.lIllllII r5 = r0.IIIIIIIl
            java.io.File r5 = r5.IIIIIIII
            io.presage.core.llIlIIII$IIIIIIII r6 = new io.presage.core.llIlIIII$IIIIIIII
            r6.<init>(r1)
            r2.<init>(r5, r3, r6)
            java.lang.Void[] r1 = new java.lang.Void[r4]
            r3 = r19
            r4 = r20
            r2.IIIIIIII(r3, r4, r1)
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.llIlIIII.IIIIIIII(io.presage.core.IIllllII, boolean, io.presage.core.llIlIIll$IIIIIIII):void");
    }

    public final void IIIIIIII(llIlIIll.IIIIIIII iiiiiiii) {
        if (iiiiiiii != null) {
            iiiiiiii.IIIIIIII(this.IIIIlIIl);
        }
    }

    public long IIIIIIIl() {
        lIllIlll lillilll = this.IIIIIlll;
        return lillilll.IIIIIIII.getLong(lillilll.IIIIIIlI, lillilll.IIIIIIll);
    }

    public void IIIIIIII(boolean z, long j, Exception exc) {
        if (!this.IIIIIIII.IIIIIlII) {
            IIIIIIII();
        }
        if (z) {
            lIllllII lillllii = this.IIIIIIIl;
            lillllii.IIIIIIlI += j;
            lillllii.IIIIIIll = System.currentTimeMillis();
        }
    }
}
