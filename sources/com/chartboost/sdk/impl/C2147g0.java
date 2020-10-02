package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.g0 */
public class C2147g0 extends C2178m0 {

    /* renamed from: d */
    private LinearLayout f7207d;

    /* renamed from: e */
    private LinearLayout f7208e;

    /* renamed from: f */
    private C2201q1 f7209f;

    /* renamed from: g */
    private C2204r1 f7210g;

    /* renamed from: h */
    private TextView f7211h;

    /* renamed from: i */
    private TextView f7212i;

    /* renamed from: com.chartboost.sdk.impl.g0$a */
    class C2148a extends C2204r1 {
        C2148a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9350a(MotionEvent motionEvent) {
            C2147g0.this.f7349a.mo9249i().mo9372b(motionEvent.getX(), motionEvent.getY(), (float) super.getWidth(), (float) super.getHeight());
        }
    }

    public C2147g0(Context context, C2158i0 i0Var) {
        super(context, i0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo9347a() {
        Context context = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 6.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f7207d = linearLayout;
        linearLayout.setOrientation(0);
        this.f7207d.setGravity(17);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.f7208e = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f7208e.setGravity(8388627);
        C2201q1 q1Var = new C2201q1(context);
        this.f7209f = q1Var;
        q1Var.setPadding(round, round, round, round);
        if (this.f7349a.f7272O.mo9104e()) {
            this.f7209f.mo9496a(this.f7349a.f7272O);
        }
        C2148a aVar = new C2148a(context);
        this.f7210g = aVar;
        aVar.setPadding(round, round, round, round);
        if (this.f7349a.f7273P.mo9104e()) {
            this.f7210g.mo9502a(this.f7349a.f7273P);
        }
        TextView textView = new TextView(getContext());
        this.f7211h = textView;
        textView.setTextColor(-15264491);
        this.f7211h.setTypeface((Typeface) null, 1);
        this.f7211h.setGravity(8388611);
        this.f7211h.setPadding(round, round, round, round / 2);
        TextView textView2 = new TextView(getContext());
        this.f7212i = textView2;
        textView2.setTextColor(-15264491);
        this.f7212i.setTypeface((Typeface) null, 1);
        this.f7212i.setGravity(8388611);
        this.f7212i.setPadding(round, 0, round, round);
        this.f7211h.setTextSize(2, 14.0f);
        this.f7212i.setTextSize(2, 11.0f);
        this.f7208e.addView(this.f7211h);
        this.f7208e.addView(this.f7212i);
        this.f7207d.addView(this.f7209f);
        this.f7207d.addView(this.f7208e, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f7207d.addView(this.f7210g);
        return this.f7207d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo9349b() {
        return 72;
    }

    /* renamed from: a */
    public void mo9348a(String str, String str2) {
        this.f7211h.setText(str);
        this.f7212i.setText(str2);
    }
}
