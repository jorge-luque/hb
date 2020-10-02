package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.iq */
public final class C5207iq extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private boolean f14300a;

    /* renamed from: b */
    private float f14301b = 1.0f;

    /* renamed from: c */
    private View f14302c;

    /* renamed from: d */
    private View f14303d;

    /* renamed from: e */
    private FrameLayout f14304e;

    /* renamed from: f */
    private ImageView f14305f;

    /* renamed from: g */
    private C5201in f14306g;

    /* renamed from: h */
    private C3159hu f14307h;

    /* renamed from: i */
    private C5208a f14308i;

    /* renamed from: com.tapjoy.internal.iq$a */
    public interface C5208a {
        /* renamed from: a */
        void mo31330a();

        /* renamed from: a */
        void mo31331a(C5168hs hsVar);

        /* renamed from: b */
        void mo31332b();
    }

    public C5207iq(Context context, C3159hu huVar, C5208a aVar) {
        super(context);
        C5174hv hvVar;
        C5178hx hxVar;
        this.f14307h = huVar;
        this.f14308i = aVar;
        Context context2 = getContext();
        View view = new View(context2);
        this.f14302c = view;
        boolean z = true;
        view.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.f14302c, layoutParams);
        this.f14303d = new View(context2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams2.addRule(13);
        addView(this.f14303d, layoutParams2);
        this.f14304e = new FrameLayout(context2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams3.addRule(13);
        addView(this.f14304e, layoutParams3);
        ImageView imageView = new ImageView(context2);
        this.f14305f = imageView;
        imageView.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams4.addRule(7, this.f14302c.getId());
        layoutParams4.addRule(6, this.f14302c.getId());
        addView(this.f14305f, layoutParams4);
        C5174hv hvVar2 = this.f14307h.f8818m;
        if (hvVar2 != null) {
            if (hvVar2.f14177a == null || (hvVar2.f14178b == null && hvVar2.f14179c == null)) {
                z = false;
            }
            if (z) {
                C5201in inVar = new C5201in(context2);
                this.f14306g = inVar;
                inVar.setOnClickListener(this);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(0, 0);
                layoutParams5.addRule(5, this.f14303d.getId());
                layoutParams5.addRule(8, this.f14303d.getId());
                addView(this.f14306g, layoutParams5);
            }
        }
        this.f14305f.setImageBitmap(huVar.f8808c.f14186b);
        C5201in inVar2 = this.f14306g;
        if (inVar2 != null && (hvVar = huVar.f8818m) != null && (hxVar = hvVar.f14177a) != null) {
            inVar2.setImageBitmap(hxVar.f14186b);
        }
    }

    /* renamed from: a */
    private int m17467a(int i) {
        return (int) (((float) i) * this.f14301b);
    }

    public final void onClick(View view) {
        C5201in inVar;
        if (view == this.f14305f) {
            this.f14308i.mo31330a();
        } else if (view != null && view == (inVar = this.f14306g)) {
            inVar.f14273a = !inVar.f14273a;
            inVar.mo31375a();
            inVar.invalidate();
            this.f14308i.mo31332b();
        } else if (view.getTag() instanceof C5168hs) {
            this.f14308i.mo31331a((C5168hs) view.getTag());
        }
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        Point point;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.f14300a) {
            this.f14301b = Math.min(((float) size) / 480.0f, ((float) size2) / 320.0f);
        } else {
            this.f14301b = Math.min(((float) size) / 320.0f, ((float) size2) / 480.0f);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14302c.getLayoutParams();
        int i4 = 480;
        layoutParams.width = m17467a(this.f14300a ? 480 : 320);
        if (this.f14300a) {
            i4 = 320;
        }
        layoutParams.height = m17467a(i4);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f14303d.getLayoutParams();
        int i5 = 448;
        layoutParams2.width = m17467a(this.f14300a ? 448 : 290);
        if (this.f14300a) {
            i5 = 290;
        }
        layoutParams2.height = m17467a(i5);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f14304e.getLayoutParams();
        layoutParams3.width = layoutParams2.width;
        layoutParams3.height = layoutParams2.height;
        for (View view : C4876ac.m16662a(this.f14304e)) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) view.getLayoutParams();
            Rect rect = ((C5168hs) view.getTag()).f14157a;
            layoutParams4.width = m17467a(rect.width());
            layoutParams4.height = m17467a(rect.height());
            layoutParams4.leftMargin = m17467a(rect.left);
            layoutParams4.topMargin = m17467a(rect.top);
        }
        int i6 = 0;
        int a = m17467a(0);
        this.f14305f.setPadding(a, a, a, a);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f14305f.getLayoutParams();
        int a2 = m17467a(30);
        layoutParams5.width = a2;
        layoutParams5.height = a2;
        int i7 = -a;
        layoutParams5.rightMargin = m17467a(this.f14307h.f8809d.x) + i7;
        layoutParams5.topMargin = i7 + m17467a(this.f14307h.f8809d.y);
        if (this.f14306g != null) {
            int i8 = 16;
            int a3 = m17467a(this.f14300a ? 16 : 15);
            if (this.f14300a) {
                i8 = 15;
            }
            int a4 = m17467a(i8);
            this.f14306g.setPadding(a, a, a, a);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f14306g.getLayoutParams();
            int a5 = m17467a(26);
            layoutParams6.width = a5;
            layoutParams6.height = a5;
            C5174hv hvVar = this.f14307h.f8818m;
            if (hvVar != null) {
                if (this.f14300a) {
                    point = hvVar.f14178b;
                    if (point == null) {
                        point = hvVar.f14179c;
                    }
                } else {
                    point = hvVar.f14179c;
                    if (point == null) {
                        point = hvVar.f14178b;
                    }
                }
                if (point != null) {
                    i6 = point.x;
                    i3 = point.y;
                    layoutParams6.leftMargin = a3 + m17467a(i6);
                    layoutParams6.topMargin = a4 + m17467a(i3);
                }
            }
            i3 = 0;
            layoutParams6.leftMargin = a3 + m17467a(i6);
            layoutParams6.topMargin = a4 + m17467a(i3);
        }
        super.onMeasure(i, i2);
    }

    public final void setLandscape(boolean z) {
        ArrayList arrayList;
        Bitmap bitmap;
        Bitmap bitmap2;
        this.f14300a = z;
        if (z) {
            C3159hu huVar = this.f14307h;
            bitmap2 = huVar.f8807b.f14186b;
            bitmap = huVar.f8811f.f14186b;
            arrayList = huVar.f8815j;
        } else {
            C3159hu huVar2 = this.f14307h;
            bitmap2 = huVar2.f8806a.f14186b;
            bitmap = huVar2.f8810e.f14186b;
            arrayList = huVar2.f8814i;
        }
        C4875ab.m16661a(this.f14302c, new BitmapDrawable((Resources) null, bitmap2));
        C4875ab.m16661a(this.f14303d, new BitmapDrawable((Resources) null, bitmap));
        if (this.f14304e.getChildCount() > 0) {
            this.f14304e.removeAllViews();
        }
        Context context = getContext();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            View view = new View(context);
            view.setTag((C5168hs) it.next());
            view.setOnClickListener(this);
            this.f14304e.addView(view, new FrameLayout.LayoutParams(0, 0, 51));
        }
    }
}
