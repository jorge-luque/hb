package com.google.android.exoplayer2.p072ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.text.C3047a;
import com.google.android.exoplayer2.text.C3048b;
import com.google.android.exoplayer2.util.C3071c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.ui.SubtitleView */
public final class SubtitleView extends View {

    /* renamed from: a */
    private final List<C3065b> f8569a;

    /* renamed from: b */
    private List<C3048b> f8570b;

    /* renamed from: c */
    private int f8571c;

    /* renamed from: d */
    private float f8572d;

    /* renamed from: e */
    private boolean f8573e;

    /* renamed from: f */
    private boolean f8574f;

    /* renamed from: g */
    private C3047a f8575g;

    /* renamed from: h */
    private float f8576h;

    public SubtitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private float m10087a(int i, float f, int i2, int i3) {
        float f2;
        if (i == 0) {
            f2 = (float) i3;
        } else if (i == 1) {
            f2 = (float) i2;
        } else if (i != 2) {
            return Float.MIN_VALUE;
        } else {
            return f;
        }
        return f * f2;
    }

    @TargetApi(19)
    /* renamed from: c */
    private float m10090c() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    /* renamed from: d */
    private C3047a m10091d() {
        return C3047a.m9986a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }

    /* renamed from: a */
    public void mo13091a(float f) {
        mo13092a(f, false);
    }

    /* renamed from: b */
    public void mo13094b() {
        mo13091a(((C3071c.f8625a < 19 || isInEditMode()) ? 1.0f : m10090c()) * 0.0533f);
    }

    public void dispatchDraw(Canvas canvas) {
        List<C3048b> list = this.f8570b;
        int i = 0;
        int size = list == null ? 0 : list.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = getPaddingTop() + top;
        int right = getRight() - getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            int i2 = bottom - top;
            int i3 = paddingBottom - paddingTop;
            float a = m10087a(this.f8571c, this.f8572d, i2, i3);
            if (a > 0.0f) {
                while (i < size) {
                    C3048b bVar = this.f8570b.get(i);
                    int i4 = paddingBottom;
                    int i5 = right;
                    this.f8569a.get(i).mo13097a(bVar, this.f8573e, this.f8574f, this.f8575g, a, m10088a(bVar, i2, i3), this.f8576h, canvas, left, paddingTop, i5, i4);
                    i++;
                    paddingBottom = i4;
                    right = i5;
                }
            }
        }
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8569a = new ArrayList();
        this.f8571c = 0;
        this.f8572d = 0.0533f;
        this.f8573e = true;
        this.f8574f = true;
        this.f8575g = C3047a.f8436g;
        this.f8576h = 0.08f;
    }

    /* renamed from: a */
    public void mo13092a(float f, boolean z) {
        m10089a(z ? 1 : 0, f);
    }

    /* renamed from: a */
    private void m10089a(int i, float f) {
        if (this.f8571c != i || this.f8572d != f) {
            this.f8571c = i;
            this.f8572d = f;
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo13090a() {
        mo13093a((C3071c.f8625a < 19 || isInEditMode()) ? C3047a.f8436g : m10091d());
    }

    /* renamed from: a */
    public void mo13093a(C3047a aVar) {
        if (this.f8575g != aVar) {
            this.f8575g = aVar;
            invalidate();
        }
    }

    /* renamed from: a */
    private float m10088a(C3048b bVar, int i, int i2) {
        int i3 = bVar.f8455m;
        if (i3 != Integer.MIN_VALUE) {
            float f = bVar.f8456n;
            if (f != Float.MIN_VALUE) {
                return Math.max(m10087a(i3, f, i, i2), 0.0f);
            }
        }
        return 0.0f;
    }
}
