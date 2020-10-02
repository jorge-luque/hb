package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C2080h;
import com.chartboost.sdk.Libraries.CBUtility;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.j0 */
public class C2168j0 extends C2178m0 {

    /* renamed from: d */
    private LinearLayout f7299d;

    /* renamed from: e */
    private C2201q1 f7300e;

    /* renamed from: f */
    private TextView f7301f;

    public C2168j0(Context context, C2158i0 i0Var) {
        super(context, i0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo9347a() {
        Context context = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 8.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f7299d = linearLayout;
        linearLayout.setOrientation(0);
        this.f7299d.setGravity(17);
        int a = CBUtility.m8162a(36, context);
        C2201q1 q1Var = new C2201q1(context);
        this.f7300e = q1Var;
        q1Var.setPadding(round, round, round, round);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
        this.f7300e.setScaleType(ImageView.ScaleType.FIT_CENTER);
        TextView textView = new TextView(context);
        this.f7301f = textView;
        textView.setPadding(round / 2, round, round, round);
        this.f7301f.setTextColor(-15264491);
        this.f7301f.setTextSize(2, 16.0f);
        this.f7301f.setTypeface((Typeface) null, 1);
        this.f7301f.setGravity(17);
        this.f7299d.addView(this.f7300e, layoutParams);
        this.f7299d.addView(this.f7301f, new LinearLayout.LayoutParams(-2, -1));
        return this.f7299d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo9349b() {
        return 48;
    }

    /* renamed from: a */
    public void mo9381a(C2080h hVar) {
        this.f7300e.mo9496a(hVar);
        this.f7300e.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    /* renamed from: a */
    public void mo9382a(String str) {
        this.f7301f.setText(str);
    }
}
