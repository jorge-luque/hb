package com.applovin.impl.adview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.sdk.AppLovinMediationProvider;

/* renamed from: com.applovin.impl.adview.f */
public class C1560f extends View {

    /* renamed from: s */
    private static final int f4884s = Color.rgb(66, 145, 241);

    /* renamed from: t */
    private static final int f4885t = Color.rgb(66, 145, 241);

    /* renamed from: u */
    private static final int f4886u = Color.rgb(66, 145, 241);

    /* renamed from: a */
    protected Paint f4887a;

    /* renamed from: b */
    protected Paint f4888b;

    /* renamed from: c */
    private Paint f4889c;

    /* renamed from: d */
    private Paint f4890d;

    /* renamed from: e */
    private RectF f4891e;

    /* renamed from: f */
    private float f4892f;

    /* renamed from: g */
    private int f4893g;

    /* renamed from: h */
    private int f4894h;

    /* renamed from: i */
    private int f4895i;

    /* renamed from: j */
    private int f4896j;

    /* renamed from: k */
    private int f4897k;

    /* renamed from: l */
    private float f4898l;

    /* renamed from: m */
    private int f4899m;

    /* renamed from: n */
    private String f4900n;

    /* renamed from: o */
    private String f4901o;

    /* renamed from: p */
    private float f4902p;

    /* renamed from: q */
    private String f4903q;

    /* renamed from: r */
    private float f4904r;

    /* renamed from: v */
    private final float f4905v;

    /* renamed from: w */
    private final float f4906w;

    /* renamed from: x */
    private final float f4907x;

    /* renamed from: y */
    private final int f4908y;

    /* renamed from: com.applovin.impl.adview.f$a */
    private static class C1561a {
        /* access modifiers changed from: private */
        /* renamed from: c */
        public static float m6014c(Resources resources, float f) {
            return (f * resources.getDisplayMetrics().density) + 0.5f;
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public static float m6015d(Resources resources, float f) {
            return f * resources.getDisplayMetrics().scaledDensity;
        }
    }

    public C1560f(Context context) {
        this(context, (AttributeSet) null);
    }

    public C1560f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1560f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4891e = new RectF();
        this.f4895i = 0;
        this.f4900n = "";
        this.f4901o = "";
        this.f4903q = "";
        this.f4906w = C1561a.m6015d(getResources(), 14.0f);
        this.f4908y = (int) C1561a.m6014c(getResources(), 100.0f);
        this.f4905v = C1561a.m6014c(getResources(), 4.0f);
        this.f4907x = C1561a.m6015d(getResources(), 18.0f);
        mo7404b();
        mo7403a();
    }

    /* renamed from: a */
    private int m6009a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f4908y;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    private float getProgressAngle() {
        return (((float) getProgress()) / ((float) this.f4896j)) * 360.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7403a() {
        TextPaint textPaint = new TextPaint();
        this.f4887a = textPaint;
        textPaint.setColor(this.f4893g);
        this.f4887a.setTextSize(this.f4892f);
        this.f4887a.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.f4888b = textPaint2;
        textPaint2.setColor(this.f4894h);
        this.f4888b.setTextSize(this.f4902p);
        this.f4888b.setAntiAlias(true);
        Paint paint = new Paint();
        this.f4889c = paint;
        paint.setColor(this.f4897k);
        this.f4889c.setStyle(Paint.Style.STROKE);
        this.f4889c.setAntiAlias(true);
        this.f4889c.setStrokeWidth(this.f4898l);
        Paint paint2 = new Paint();
        this.f4890d = paint2;
        paint2.setColor(this.f4899m);
        this.f4890d.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7404b() {
        this.f4897k = f4884s;
        this.f4893g = f4885t;
        this.f4892f = this.f4906w;
        setMax(100);
        setProgress(0);
        this.f4898l = this.f4905v;
        this.f4899m = 0;
        this.f4902p = this.f4907x;
        this.f4894h = f4886u;
    }

    public int getFinishedStrokeColor() {
        return this.f4897k;
    }

    public float getFinishedStrokeWidth() {
        return this.f4898l;
    }

    public int getInnerBackgroundColor() {
        return this.f4899m;
    }

    public String getInnerBottomText() {
        return this.f4903q;
    }

    public int getInnerBottomTextColor() {
        return this.f4894h;
    }

    public float getInnerBottomTextSize() {
        return this.f4902p;
    }

    public int getMax() {
        return this.f4896j;
    }

    public String getPrefixText() {
        return this.f4900n;
    }

    public int getProgress() {
        return this.f4895i;
    }

    public String getSuffixText() {
        return this.f4901o;
    }

    public int getTextColor() {
        return this.f4893g;
    }

    public float getTextSize() {
        return this.f4892f;
    }

    public void invalidate() {
        mo7403a();
        super.invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f4898l;
        this.f4891e.set(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        float f2 = this.f4898l;
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((((float) getWidth()) - f2) + f2) / 2.0f, this.f4890d);
        canvas.drawArc(this.f4891e, 270.0f, -getProgressAngle(), false, this.f4889c);
        String str = this.f4900n + this.f4895i + this.f4901o;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (((float) getWidth()) - this.f4887a.measureText(str)) / 2.0f, (((float) getWidth()) - (this.f4887a.descent() + this.f4887a.ascent())) / 2.0f, this.f4887a);
        }
        if (!TextUtils.isEmpty(getInnerBottomText())) {
            this.f4888b.setTextSize(this.f4902p);
            canvas.drawText(getInnerBottomText(), (((float) getWidth()) - this.f4888b.measureText(getInnerBottomText())) / 2.0f, (((float) getHeight()) - this.f4904r) - ((this.f4887a.descent() + this.f4887a.ascent()) / 2.0f), this.f4888b);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m6009a(i), m6009a(i2));
        this.f4904r = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f4893g = bundle.getInt("text_color");
            this.f4892f = bundle.getFloat("text_size");
            this.f4902p = bundle.getFloat("inner_bottom_text_size");
            this.f4903q = bundle.getString("inner_bottom_text");
            this.f4894h = bundle.getInt("inner_bottom_text_color");
            this.f4897k = bundle.getInt("finished_stroke_color");
            this.f4898l = bundle.getFloat("finished_stroke_width");
            this.f4899m = bundle.getInt("inner_background_color");
            mo7403a();
            setMax(bundle.getInt(AppLovinMediationProvider.MAX));
            setProgress(bundle.getInt("progress"));
            this.f4900n = bundle.getString("prefix");
            this.f4901o = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", (float) getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt(AppLovinMediationProvider.MAX, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        return bundle;
    }

    public void setFinishedStrokeColor(int i) {
        this.f4897k = i;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f) {
        this.f4898l = f;
        invalidate();
    }

    public void setInnerBackgroundColor(int i) {
        this.f4899m = i;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.f4903q = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i) {
        this.f4894h = i;
        invalidate();
    }

    public void setInnerBottomTextSize(float f) {
        this.f4902p = f;
        invalidate();
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f4896j = i;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.f4900n = str;
        invalidate();
    }

    public void setProgress(int i) {
        this.f4895i = i;
        if (i > getMax()) {
            this.f4895i %= getMax();
        }
        invalidate();
    }

    public void setSuffixText(String str) {
        this.f4901o = str;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f4893g = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f4892f = f;
        invalidate();
    }
}
