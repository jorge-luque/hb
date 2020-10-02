package com.tapjoy.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.WindowManager;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TJContentActivity;

/* renamed from: com.tapjoy.internal.he */
public class C5151he extends C3151hg {

    /* renamed from: h */
    private static final String f14081h = "he";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static C5151he f14082i;

    /* renamed from: a */
    final String f14083a;

    /* renamed from: b */
    final C3159hu f14084b;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C3145gz f14085j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C4931c f14086k;

    /* renamed from: l */
    private boolean f14087l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f14088m;

    /* renamed from: n */
    private Context f14089n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f14090o = false;

    public C5151he(C3145gz gzVar, String str, C3159hu huVar, Context context) {
        this.f14085j = gzVar;
        this.f14083a = str;
        this.f14084b = huVar;
        this.f14089n = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m17361e() {
        C4931c cVar = this.f14086k;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    /* renamed from: b */
    public final void mo18599b() {
        C5178hx hxVar;
        C3159hu huVar = this.f14084b;
        C5178hx hxVar2 = huVar.f8806a;
        if (hxVar2 != null) {
            hxVar2.mo31347b();
        }
        C5178hx hxVar3 = huVar.f8807b;
        if (hxVar3 != null) {
            hxVar3.mo31347b();
        }
        huVar.f8808c.mo31347b();
        C5178hx hxVar4 = huVar.f8810e;
        if (hxVar4 != null) {
            hxVar4.mo31347b();
        }
        C5178hx hxVar5 = huVar.f8811f;
        if (hxVar5 != null) {
            hxVar5.mo31347b();
        }
        C5174hv hvVar = huVar.f8818m;
        if (hvVar != null && (hxVar = hvVar.f14177a) != null) {
            hxVar.mo31347b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        r0 = r0.f8810e;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo18600c() {
        /*
            r3 = this;
            com.tapjoy.internal.hu r0 = r3.f14084b
            com.tapjoy.internal.hx r1 = r0.f8808c
            if (r1 == 0) goto L_0x0038
            android.graphics.Bitmap r1 = r1.f14186b
            if (r1 == 0) goto L_0x0038
            com.tapjoy.internal.hv r1 = r0.f8818m
            if (r1 == 0) goto L_0x0016
            com.tapjoy.internal.hx r1 = r1.f14177a
            if (r1 == 0) goto L_0x0016
            android.graphics.Bitmap r1 = r1.f14186b
            if (r1 == 0) goto L_0x0038
        L_0x0016:
            com.tapjoy.internal.hx r1 = r0.f8807b
            if (r1 == 0) goto L_0x0026
            com.tapjoy.internal.hx r2 = r0.f8811f
            if (r2 == 0) goto L_0x0026
            android.graphics.Bitmap r1 = r1.f14186b
            if (r1 == 0) goto L_0x0026
            android.graphics.Bitmap r1 = r2.f14186b
            if (r1 != 0) goto L_0x0036
        L_0x0026:
            com.tapjoy.internal.hx r1 = r0.f8806a
            if (r1 == 0) goto L_0x0038
            com.tapjoy.internal.hx r0 = r0.f8810e
            if (r0 == 0) goto L_0x0038
            android.graphics.Bitmap r1 = r1.f14186b
            if (r1 == 0) goto L_0x0038
            android.graphics.Bitmap r0 = r0.f14186b
            if (r0 == 0) goto L_0x0038
        L_0x0036:
            r0 = 1
            return r0
        L_0x0038:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5151he.mo18600c():boolean");
    }

    /* renamed from: a */
    public static void m17351a() {
        C5151he heVar = f14082i;
        if (heVar != null) {
            heVar.m17361e();
        }
    }

    /* renamed from: a */
    public final void mo18598a(final C5143ha haVar, final C5100fw fwVar) {
        Activity a = C3120a.m10211a(this.f14089n);
        if (a != null && !a.isFinishing()) {
            try {
                m17352a(a, haVar, fwVar);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        Activity a2 = C5129gr.m17302a();
        try {
            TJContentActivity.start(C3145gz.m10321a().f8761e, new TJContentActivity.AbstractContentProducer() {
                public final void dismiss(Activity activity) {
                    C5151he.this.m17361e();
                }

                public final void show(Activity activity) {
                    try {
                        C5151he.this.m17352a(activity, haVar, fwVar);
                    } catch (WindowManager.BadTokenException unused) {
                        C5139gw.m17329b("Failed to show the content for \"{}\" caused by invalid activity", C5151he.this.f14083a);
                        C5143ha haVar = haVar;
                        C5151he heVar = C5151he.this;
                        haVar.mo30545a(heVar.f14083a, heVar.f8791f, (C3143gl) null);
                    }
                }
            }, (a2 == null || (a2.getWindow().getAttributes().flags & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) == 0) ? false : true);
        } catch (ActivityNotFoundException unused2) {
            if (a2 != null && !a2.isFinishing()) {
                try {
                    m17352a(a2, haVar, fwVar);
                    return;
                } catch (WindowManager.BadTokenException unused3) {
                    C5139gw.m17329b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.f14083a);
                    haVar.mo30545a(this.f14083a, this.f8791f, (C3143gl) null);
                }
            }
            C5139gw.m17329b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.f14083a);
            haVar.mo30545a(this.f14083a, this.f8791f, (C3143gl) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m17352a(final android.app.Activity r13, final com.tapjoy.internal.C5143ha r14, com.tapjoy.internal.C5100fw r15) {
        /*
            r12 = this;
            boolean r0 = r12.f14087l
            if (r0 == 0) goto L_0x0013
            java.lang.String r13 = f14081h
            com.tapjoy.TapjoyErrorMessage r14 = new com.tapjoy.TapjoyErrorMessage
            com.tapjoy.TapjoyErrorMessage$ErrorType r15 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR
            java.lang.String r0 = "Content is already displayed"
            r14.<init>(r15, r0)
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r13, (com.tapjoy.TapjoyErrorMessage) r14)
            return
        L_0x0013:
            r0 = 1
            r12.f14087l = r0
            f14082i = r12
            com.tapjoy.internal.fq r1 = r15.f13955a
            r12.f8792g = r1
            com.tapjoy.internal.c r1 = new com.tapjoy.internal.c
            r1.<init>(r13)
            r12.f14086k = r1
            com.tapjoy.internal.he$2 r2 = new com.tapjoy.internal.he$2
            r2.<init>(r14)
            r1.setOnCancelListener(r2)
            com.tapjoy.internal.c r1 = r12.f14086k
            com.tapjoy.internal.he$3 r2 = new com.tapjoy.internal.he$3
            r2.<init>(r13, r14)
            r1.setOnDismissListener(r2)
            com.tapjoy.internal.c r1 = r12.f14086k
            r2 = 0
            r1.setCanceledOnTouchOutside(r2)
            com.tapjoy.internal.iq r1 = new com.tapjoy.internal.iq
            com.tapjoy.internal.hu r3 = r12.f14084b
            com.tapjoy.internal.he$4 r4 = new com.tapjoy.internal.he$4
            r4.<init>(r13, r14)
            r1.<init>(r13, r3, r4)
            com.tapjoy.internal.ip r3 = new com.tapjoy.internal.ip
            com.tapjoy.internal.hu r4 = r12.f14084b
            r3.<init>(r13, r4, r1)
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r1.<init>(r13)
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            r5 = 17
            r6 = -2
            r4.<init>(r6, r6, r5)
            r1.addView(r3, r4)
            com.tapjoy.internal.c r4 = r12.f14086k
            r4.setContentView(r1)
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x018a
            com.tapjoy.internal.c r1 = r12.f14086k
            android.view.Window r1 = r1.getWindow()
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 16
            if (r4 != r5) goto L_0x0098
            java.lang.String r4 = android.os.Build.VERSION.RELEASE
            java.lang.String r5 = "4.1.2"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0098
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            android.content.Context r5 = r1.getContext()
            java.lang.Boolean r5 = m17350a((android.content.Context) r5)
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0093
            r1 = 0
            goto L_0x0099
        L_0x0093:
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            r1.setFlags(r4, r4)
        L_0x0098:
            r1 = 1
        L_0x0099:
            if (r1 == 0) goto L_0x018a
            int r1 = com.tapjoy.internal.C4879ad.C4881a.f13320b
            com.tapjoy.internal.ae r4 = new com.tapjoy.internal.ae
            r4.<init>()
            int[] r5 = com.tapjoy.internal.C4879ad.C48801.f13318a
            int r1 = r1 - r0
            r1 = r5[r1]
            r5 = 1114636288(0x42700000, float:60.0)
            r6 = 1050253722(0x3e99999a, float:0.3)
            r7 = 1053609165(0x3ecccccd, float:0.4)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r1 == r0) goto L_0x0151
            r9 = 2
            r10 = -1093874483(0xffffffffbecccccd, float:-0.4)
            r11 = -1032847360(0xffffffffc2700000, float:-60.0)
            if (r1 == r9) goto L_0x0122
            r2 = 3
            if (r1 == r2) goto L_0x00f3
            r2 = 4
            if (r1 == r2) goto L_0x00c3
            goto L_0x017f
        L_0x00c3:
            com.tapjoy.internal.ag r1 = new com.tapjoy.internal.ag
            r1.<init>()
            r1.f13335a = r0
            r1.f13336b = r5
            com.tapjoy.internal.af r0 = r1.mo30913a()
            com.tapjoy.internal.ae r0 = r4.mo30910a(r0)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r7, r8, r7, r8)
            com.tapjoy.internal.ae r0 = r0.mo30910a(r1)
            com.tapjoy.internal.ah r1 = new com.tapjoy.internal.ah
            r1.<init>()
            com.tapjoy.internal.ah r1 = r1.mo30915a(r6)
            com.tapjoy.internal.ah r1 = r1.mo30916b(r10)
            android.view.animation.Animation r1 = r1.mo30914a()
            r0.mo30910a(r1)
            goto L_0x017f
        L_0x00f3:
            com.tapjoy.internal.ag r1 = new com.tapjoy.internal.ag
            r1.<init>()
            r1.f13335a = r0
            r1.f13336b = r11
            com.tapjoy.internal.af r0 = r1.mo30913a()
            com.tapjoy.internal.ae r0 = r4.mo30910a(r0)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r7, r8, r7, r8)
            com.tapjoy.internal.ae r0 = r0.mo30910a(r1)
            com.tapjoy.internal.ah r1 = new com.tapjoy.internal.ah
            r1.<init>()
            com.tapjoy.internal.ah r1 = r1.mo30915a(r6)
            com.tapjoy.internal.ah r1 = r1.mo30916b(r8)
            android.view.animation.Animation r1 = r1.mo30914a()
            r0.mo30910a(r1)
            goto L_0x017f
        L_0x0122:
            com.tapjoy.internal.ag r0 = new com.tapjoy.internal.ag
            r0.<init>()
            r0.f13335a = r2
            r0.f13336b = r11
            com.tapjoy.internal.af r0 = r0.mo30913a()
            com.tapjoy.internal.ae r0 = r4.mo30910a(r0)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r7, r8, r7, r8)
            com.tapjoy.internal.ae r0 = r0.mo30910a(r1)
            com.tapjoy.internal.ah r1 = new com.tapjoy.internal.ah
            r1.<init>()
            com.tapjoy.internal.ah r1 = r1.mo30915a(r10)
            com.tapjoy.internal.ah r1 = r1.mo30916b(r6)
            android.view.animation.Animation r1 = r1.mo30914a()
            r0.mo30910a(r1)
            goto L_0x017f
        L_0x0151:
            com.tapjoy.internal.ag r0 = new com.tapjoy.internal.ag
            r0.<init>()
            r0.f13335a = r2
            r0.f13336b = r5
            com.tapjoy.internal.af r0 = r0.mo30913a()
            com.tapjoy.internal.ae r0 = r4.mo30910a(r0)
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r7, r8, r7, r8)
            com.tapjoy.internal.ae r0 = r0.mo30910a(r1)
            com.tapjoy.internal.ah r1 = new com.tapjoy.internal.ah
            r1.<init>()
            com.tapjoy.internal.ah r1 = r1.mo30915a(r8)
            com.tapjoy.internal.ah r1 = r1.mo30916b(r6)
            android.view.animation.Animation r1 = r1.mo30914a()
            r0.mo30910a(r1)
        L_0x017f:
            com.tapjoy.internal.ad r0 = r4.mo30909b()
            android.view.animation.Animation r0 = r0.mo30908a()
            r3.startAnimation(r0)
        L_0x018a:
            com.tapjoy.internal.c r0 = r12.f14086k     // Catch:{ BadTokenException -> 0x01d0 }
            r0.show()     // Catch:{ BadTokenException -> 0x01d0 }
            com.tapjoy.internal.c r0 = r12.f14086k
            android.view.Window r0 = r0.getWindow()
            r1 = -1
            r0.setLayout(r1, r1)
            android.view.Window r13 = r13.getWindow()
            android.view.WindowManager$LayoutParams r13 = r13.getAttributes()
            int r13 = r13.flags
            r0 = 1024(0x400, float:1.435E-42)
            r13 = r13 & r0
            if (r13 == 0) goto L_0x01b1
            com.tapjoy.internal.c r13 = r12.f14086k
            android.view.Window r13 = r13.getWindow()
            r13.setFlags(r0, r0)
        L_0x01b1:
            long r0 = android.os.SystemClock.elapsedRealtime()
            r12.f14088m = r0
            com.tapjoy.internal.gz r13 = r12.f14085j
            com.tapjoy.internal.hu r0 = r12.f14084b
            java.util.Map r0 = r0.f8816k
            r13.mo18546a((java.util.Map) r0)
            r15.mo31263a()
            com.tapjoy.internal.fq r13 = r12.f8792g
            if (r13 == 0) goto L_0x01ca
            r13.mo31259b()
        L_0x01ca:
            java.lang.String r13 = r12.f14083a
            r14.mo30547c(r13)
            return
        L_0x01d0:
            r13 = move-exception
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5151he.m17352a(android.app.Activity, com.tapjoy.internal.ha, com.tapjoy.internal.fw):void");
    }

    /* renamed from: a */
    private static Boolean m17350a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData;
            if (bundle == null) {
                return null;
            }
            Object obj = bundle.get("tapjoy:hardwareAccelerated");
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
