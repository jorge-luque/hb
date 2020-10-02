package org.cocos2dx.cpp;

import android.content.Context;
import p075d.p092h.C3230b;
import p093e.p094a.p095a.C3297e;
import p093e.p094a.p095a.C3301g;
import p093e.p094a.p095a.C3306i0;
import p118io.branch.referral.C3555b;

public class MyApplication extends C3230b {

    /* renamed from: org.cocos2dx.cpp.MyApplication$a */
    class C3596a implements C3306i0 {
        C3596a(MyApplication myApplication) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r1 = r8.f9182h;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo19031a(p093e.p094a.p095a.C3299f r8) {
            /*
                r7 = this;
                java.lang.String r0 = "-"
                if (r8 == 0) goto L_0x0012
                java.lang.String r1 = r8.f9182h
                if (r1 == 0) goto L_0x0012
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x000f
                goto L_0x0012
            L_0x000f:
                java.lang.String r1 = r8.f9182h
                goto L_0x0013
            L_0x0012:
                r1 = r0
            L_0x0013:
                if (r8 == 0) goto L_0x0023
                java.lang.String r2 = r8.f9176b
                if (r2 == 0) goto L_0x0023
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0020
                goto L_0x0023
            L_0x0020:
                java.lang.String r2 = r8.f9176b
                goto L_0x0024
            L_0x0023:
                r2 = r0
            L_0x0024:
                if (r8 == 0) goto L_0x0034
                java.lang.String r3 = r8.f9177c
                if (r3 == 0) goto L_0x0034
                boolean r3 = r3.isEmpty()
                if (r3 == 0) goto L_0x0031
                goto L_0x0034
            L_0x0031:
                java.lang.String r3 = r8.f9177c
                goto L_0x0035
            L_0x0034:
                r3 = r0
            L_0x0035:
                if (r8 == 0) goto L_0x0045
                java.lang.String r4 = r8.f9178d
                if (r4 == 0) goto L_0x0045
                boolean r4 = r4.isEmpty()
                if (r4 == 0) goto L_0x0042
                goto L_0x0045
            L_0x0042:
                java.lang.String r4 = r8.f9178d
                goto L_0x0046
            L_0x0045:
                r4 = r0
            L_0x0046:
                if (r8 == 0) goto L_0x0056
                java.lang.String r5 = r8.f9179e
                if (r5 == 0) goto L_0x0056
                boolean r5 = r5.isEmpty()
                if (r5 == 0) goto L_0x0053
                goto L_0x0056
            L_0x0053:
                java.lang.String r5 = r8.f9179e
                goto L_0x0057
            L_0x0056:
                r5 = r0
            L_0x0057:
                if (r8 == 0) goto L_0x0066
                java.lang.String r6 = r8.f9175a
                if (r6 == 0) goto L_0x0066
                boolean r6 = r6.isEmpty()
                if (r6 == 0) goto L_0x0064
                goto L_0x0066
            L_0x0064:
                java.lang.String r0 = r8.f9175a
            L_0x0066:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r1)
                java.lang.String r6 = "{split}"
                r8.append(r6)
                r8.append(r2)
                r8.append(r6)
                r8.append(r3)
                r8.append(r6)
                r8.append(r4)
                r8.append(r6)
                r8.append(r5)
                r8.append(r6)
                r8.append(r0)
                java.lang.String r8 = r8.toString()
                org.cocos2dx.cpp.AppActivity.adjustInfoAvailable(r8)
                org.cocos2dx.cpp.a r8 = org.cocos2dx.cpp.C6702a.m21947j()
                r8.mo35834a((java.lang.String) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.cpp.MyApplication.C3596a.mo19031a(e.a.a.f):void");
        }
    }

    public void onCreate() {
        super.onCreate();
        C3301g gVar = new C3301g(this, "qgahq9ev4xkw", "production");
        gVar.mo19015a(1, 2083210677, 603560892, 1814912222, 1487335162);
        gVar.mo19016a((C3306i0) new C3596a(this));
        C3297e.m10956a(gVar);
        C3597b.m12267a().f10093b = !getSharedPreferences("HB2", 0).getBoolean("savedBranchURL", false);
        if (C3597b.m12267a().f10093b) {
            C3555b.m11989a((Context) this);
        }
    }
}
