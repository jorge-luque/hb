package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chartboost.sdk.C2109f;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.l0 */
public class C2174l0 extends LinearLayout {

    /* renamed from: a */
    final C2158i0 f7325a;

    /* renamed from: b */
    private LinearLayout f7326b;

    /* renamed from: c */
    private C2201q1 f7327c;

    /* renamed from: d */
    private TextView f7328d;

    /* renamed from: e */
    final C2204r1 f7329e;

    /* renamed from: f */
    private int f7330f = Integer.MIN_VALUE;

    /* renamed from: com.chartboost.sdk.impl.l0$a */
    class C2175a extends C2204r1 {
        C2175a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9350a(MotionEvent motionEvent) {
            C2174l0.this.f7329e.setEnabled(false);
            C2174l0.this.f7325a.mo9249i().mo9377g();
        }
    }

    public C2174l0(Context context, C2158i0 i0Var) {
        super(context);
        this.f7325a = i0Var;
        int round = Math.round(context.getResources().getDisplayMetrics().density * 8.0f);
        setOrientation(1);
        setGravity(17);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f7326b = linearLayout;
        linearLayout.setGravity(17);
        this.f7326b.setOrientation(0);
        this.f7326b.setPadding(round, round, round, round);
        C2201q1 q1Var = new C2201q1(context);
        this.f7327c = q1Var;
        q1Var.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f7327c.setPadding(0, 0, round, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        i0Var.mo9356a(layoutParams, i0Var.f7270M, 1.0f);
        TextView textView = new TextView(getContext());
        this.f7328d = textView;
        textView.setTextColor(-1);
        this.f7328d.setTypeface((Typeface) null, 1);
        this.f7328d.setGravity(17);
        this.f7328d.setTextSize(2, C2109f.m8376b(context) ? 26.0f : 16.0f);
        this.f7326b.addView(this.f7327c, layoutParams);
        this.f7326b.addView(this.f7328d, new LinearLayout.LayoutParams(-2, -2));
        C2175a aVar = new C2175a(getContext());
        this.f7329e = aVar;
        aVar.setContentDescription("CBWatch");
        this.f7329e.setPadding(0, 0, 0, round);
        this.f7329e.mo9501a(ImageView.ScaleType.FIT_CENTER);
        this.f7329e.setPadding(round, round, round, round);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        i0Var.mo9356a(layoutParams2, i0Var.f7269L, 1.0f);
        this.f7327c.mo9496a(i0Var.f7270M);
        this.f7329e.mo9502a(i0Var.f7269L);
        addView(this.f7326b, new LinearLayout.LayoutParams(-2, -2));
        addView(this.f7329e, layoutParams2);
        mo9393a();
    }

    /* renamed from: a */
    public void mo9395a(boolean z) {
        setBackgroundColor(z ? -16777216 : this.f7330f);
    }

    /* renamed from: a */
    public void mo9394a(String str, int i) {
        this.f7328d.setText(str);
        this.f7330f = i;
        mo9395a(this.f7325a.mo9368s());
    }

    /* renamed from: a */
    public void mo9393a() {
        mo9395a(this.f7325a.mo9368s());
    }
}
