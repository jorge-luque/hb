package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C2109f;
import com.chartboost.sdk.Model.C2088c;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.u1 */
public class C2216u1 extends RelativeLayout {

    /* renamed from: a */
    private C2109f.C2111b f7466a;

    /* renamed from: b */
    private C2197p1 f7467b;

    /* renamed from: c */
    private C2197p1 f7468c;

    /* renamed from: d */
    private final C2088c f7469d;

    public C2216u1(Context context, C2088c cVar) {
        super(context);
        this.f7469d = cVar;
        if (cVar.f6938r.f6896b == 0) {
            C2197p1 p1Var = new C2197p1(context);
            this.f7467b = p1Var;
            addView(p1Var, new RelativeLayout.LayoutParams(-1, -1));
            C2197p1 p1Var2 = new C2197p1(context);
            this.f7468c = p1Var2;
            addView(p1Var2, new RelativeLayout.LayoutParams(-1, -1));
            this.f7468c.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo9516a() {
    }

    /* renamed from: b */
    public C2197p1 mo9517b() {
        return this.f7467b;
    }

    /* renamed from: c */
    public View mo9518c() {
        return this.f7466a;
    }

    /* renamed from: d */
    public C2088c mo9519d() {
        return this.f7469d;
    }

    /* renamed from: e */
    public boolean mo9520e() {
        C2109f.C2111b bVar = this.f7466a;
        return bVar != null && bVar.getVisibility() == 0;
    }

    /* renamed from: f */
    public void mo9521f() {
        if (this.f7466a == null) {
            C2109f.C2111b f = this.f7469d.mo9129f();
            this.f7466a = f;
            if (f != null) {
                addView(f, new RelativeLayout.LayoutParams(-1, -1));
                this.f7466a.mo9261b();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        performClick();
        return true;
    }

    public boolean performClick() {
        super.performClick();
        return true;
    }
}
