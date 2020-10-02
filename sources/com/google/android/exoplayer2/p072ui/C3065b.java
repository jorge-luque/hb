package com.google.android.exoplayer2.p072ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.C3047a;
import com.google.android.exoplayer2.text.C3048b;
import com.google.android.exoplayer2.util.C3071c;

/* renamed from: com.google.android.exoplayer2.ui.b */
/* compiled from: SubtitlePainter */
final class C3065b {

    /* renamed from: A */
    private float f8587A;

    /* renamed from: B */
    private float f8588B;

    /* renamed from: C */
    private float f8589C;

    /* renamed from: D */
    private int f8590D;

    /* renamed from: E */
    private int f8591E;

    /* renamed from: F */
    private int f8592F;

    /* renamed from: G */
    private int f8593G;

    /* renamed from: H */
    private StaticLayout f8594H;

    /* renamed from: I */
    private int f8595I;

    /* renamed from: J */
    private int f8596J;

    /* renamed from: K */
    private int f8597K;

    /* renamed from: L */
    private Rect f8598L;

    /* renamed from: a */
    private final RectF f8599a;

    /* renamed from: b */
    private final float f8600b;

    /* renamed from: c */
    private final float f8601c;

    /* renamed from: d */
    private final float f8602d;

    /* renamed from: e */
    private final float f8603e;

    /* renamed from: f */
    private final float f8604f;

    /* renamed from: g */
    private final float f8605g;

    /* renamed from: h */
    private final TextPaint f8606h;

    /* renamed from: i */
    private final Paint f8607i;

    /* renamed from: j */
    private CharSequence f8608j;

    /* renamed from: k */
    private Layout.Alignment f8609k;

    /* renamed from: l */
    private Bitmap f8610l;

    /* renamed from: m */
    private float f8611m;

    /* renamed from: n */
    private int f8612n;

    /* renamed from: o */
    private int f8613o;

    /* renamed from: p */
    private float f8614p;

    /* renamed from: q */
    private int f8615q;

    /* renamed from: r */
    private float f8616r;

    /* renamed from: s */
    private float f8617s;

    /* renamed from: t */
    private boolean f8618t;

    /* renamed from: u */
    private boolean f8619u;

    /* renamed from: v */
    private int f8620v;

    /* renamed from: w */
    private int f8621w;

    /* renamed from: x */
    private int f8622x;

    /* renamed from: y */
    private int f8623y;

    /* renamed from: z */
    private int f8624z;

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ce A[LOOP:2: B:27:0x00cc->B:28:0x00ce, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0126  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10109b() {
        /*
            r26 = this;
            r0 = r26
            int r1 = r0.f8592F
            int r2 = r0.f8590D
            int r1 = r1 - r2
            int r2 = r0.f8593G
            int r3 = r0.f8591E
            int r2 = r2 - r3
            android.text.TextPaint r3 = r0.f8606h
            float r4 = r0.f8587A
            r3.setTextSize(r4)
            float r3 = r0.f8587A
            r4 = 1040187392(0x3e000000, float:0.125)
            float r3 = r3 * r4
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r3 = (int) r3
            int r4 = r3 * 2
            int r5 = r1 - r4
            float r6 = r0.f8616r
            r7 = 1
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x002c
            float r5 = (float) r5
            float r5 = r5 * r6
            int r5 = (int) r5
        L_0x002c:
            java.lang.String r6 = "SubtitlePainter"
            if (r5 > 0) goto L_0x0036
            java.lang.String r1 = "Skipped drawing subtitle cue (insufficient space)"
            android.util.Log.w(r6, r1)
            return
        L_0x0036:
            java.lang.CharSequence r8 = r0.f8608j
            boolean r9 = r0.f8618t
            r16 = 0
            r15 = 0
            if (r9 != 0) goto L_0x0046
            java.lang.String r8 = r8.toString()
        L_0x0043:
            r18 = r8
            goto L_0x0099
        L_0x0046:
            boolean r9 = r0.f8619u
            if (r9 != 0) goto L_0x007b
            android.text.SpannableStringBuilder r9 = new android.text.SpannableStringBuilder
            r9.<init>(r8)
            int r8 = r9.length()
            java.lang.Class<android.text.style.AbsoluteSizeSpan> r10 = android.text.style.AbsoluteSizeSpan.class
            java.lang.Object[] r10 = r9.getSpans(r15, r8, r10)
            android.text.style.AbsoluteSizeSpan[] r10 = (android.text.style.AbsoluteSizeSpan[]) r10
            java.lang.Class<android.text.style.RelativeSizeSpan> r11 = android.text.style.RelativeSizeSpan.class
            java.lang.Object[] r8 = r9.getSpans(r15, r8, r11)
            android.text.style.RelativeSizeSpan[] r8 = (android.text.style.RelativeSizeSpan[]) r8
            int r11 = r10.length
            r12 = 0
        L_0x0065:
            if (r12 >= r11) goto L_0x006f
            r13 = r10[r12]
            r9.removeSpan(r13)
            int r12 = r12 + 1
            goto L_0x0065
        L_0x006f:
            int r10 = r8.length
            r11 = 0
        L_0x0071:
            if (r11 >= r10) goto L_0x0097
            r12 = r8[r11]
            r9.removeSpan(r12)
            int r11 = r11 + 1
            goto L_0x0071
        L_0x007b:
            float r9 = r0.f8588B
            int r9 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r9 <= 0) goto L_0x0043
            android.text.SpannableStringBuilder r9 = new android.text.SpannableStringBuilder
            r9.<init>(r8)
            android.text.style.AbsoluteSizeSpan r8 = new android.text.style.AbsoluteSizeSpan
            float r10 = r0.f8588B
            int r10 = (int) r10
            r8.<init>(r10)
            int r10 = r9.length()
            r11 = 16711680(0xff0000, float:2.3418052E-38)
            r9.setSpan(r8, r15, r10, r11)
        L_0x0097:
            r18 = r9
        L_0x0099:
            android.text.Layout$Alignment r8 = r0.f8609k
            if (r8 != 0) goto L_0x009f
            android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_CENTER
        L_0x009f:
            r21 = r8
            android.text.StaticLayout r14 = new android.text.StaticLayout
            android.text.TextPaint r10 = r0.f8606h
            float r13 = r0.f8604f
            float r12 = r0.f8605g
            r17 = 1
            r8 = r14
            r9 = r18
            r11 = r5
            r19 = r12
            r12 = r21
            r7 = r14
            r14 = r19
            r25 = r3
            r3 = 0
            r15 = r17
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            r0.f8594H = r7
            int r7 = r7.getHeight()
            android.text.StaticLayout r8 = r0.f8594H
            int r8 = r8.getLineCount()
            r9 = 0
            r15 = 0
        L_0x00cc:
            if (r15 >= r8) goto L_0x00e1
            android.text.StaticLayout r10 = r0.f8594H
            float r10 = r10.getLineWidth(r15)
            double r10 = (double) r10
            double r10 = java.lang.Math.ceil(r10)
            int r10 = (int) r10
            int r9 = java.lang.Math.max(r10, r9)
            int r15 = r15 + 1
            goto L_0x00cc
        L_0x00e1:
            float r8 = r0.f8616r
            r10 = 1
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x00eb
            if (r9 >= r5) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r5 = r9
        L_0x00ec:
            int r5 = r5 + r4
            float r4 = r0.f8614p
            r8 = 1
            r9 = 2
            int r11 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r11 == 0) goto L_0x0119
            float r1 = (float) r1
            float r1 = r1 * r4
            int r1 = java.lang.Math.round(r1)
            int r4 = r0.f8590D
            int r1 = r1 + r4
            int r4 = r0.f8615q
            if (r4 != r9) goto L_0x0105
            int r1 = r1 - r5
            goto L_0x010b
        L_0x0105:
            if (r4 != r8) goto L_0x010b
            int r1 = r1 * 2
            int r1 = r1 - r5
            int r1 = r1 / r9
        L_0x010b:
            int r4 = r0.f8590D
            int r1 = java.lang.Math.max(r1, r4)
            int r5 = r5 + r1
            int r4 = r0.f8592F
            int r4 = java.lang.Math.min(r5, r4)
            goto L_0x011d
        L_0x0119:
            int r1 = r1 - r5
            int r1 = r1 / r9
            int r4 = r1 + r5
        L_0x011d:
            int r4 = r4 - r1
            if (r4 > 0) goto L_0x0126
            java.lang.String r1 = "Skipped drawing subtitle cue (invalid horizontal positioning)"
            android.util.Log.w(r6, r1)
            return
        L_0x0126:
            float r5 = r0.f8611m
            r6 = 1
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0181
            int r6 = r0.f8612n
            if (r6 != 0) goto L_0x013c
            float r2 = (float) r2
            float r2 = r2 * r5
            int r2 = java.lang.Math.round(r2)
            int r3 = r0.f8591E
        L_0x013a:
            int r2 = r2 + r3
            goto L_0x0166
        L_0x013c:
            android.text.StaticLayout r2 = r0.f8594H
            int r2 = r2.getLineBottom(r3)
            android.text.StaticLayout r5 = r0.f8594H
            int r3 = r5.getLineTop(r3)
            int r2 = r2 - r3
            float r3 = r0.f8611m
            int r5 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r5 < 0) goto L_0x0159
            float r2 = (float) r2
            float r3 = r3 * r2
            int r2 = java.lang.Math.round(r3)
            int r3 = r0.f8591E
            goto L_0x013a
        L_0x0159:
            r5 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 + r5
            float r2 = (float) r2
            float r3 = r3 * r2
            int r2 = java.lang.Math.round(r3)
            int r3 = r0.f8593G
            goto L_0x013a
        L_0x0166:
            int r3 = r0.f8613o
            if (r3 != r9) goto L_0x016c
            int r2 = r2 - r7
            goto L_0x0172
        L_0x016c:
            if (r3 != r8) goto L_0x0172
            int r2 = r2 * 2
            int r2 = r2 - r7
            int r2 = r2 / r9
        L_0x0172:
            int r3 = r2 + r7
            int r5 = r0.f8593G
            if (r3 <= r5) goto L_0x017b
            int r2 = r5 - r7
            goto L_0x018c
        L_0x017b:
            int r3 = r0.f8591E
            if (r2 >= r3) goto L_0x018c
            r2 = r3
            goto L_0x018c
        L_0x0181:
            int r3 = r0.f8593G
            int r3 = r3 - r7
            float r2 = (float) r2
            float r5 = r0.f8589C
            float r2 = r2 * r5
            int r2 = (int) r2
            int r2 = r3 - r2
        L_0x018c:
            android.text.StaticLayout r3 = new android.text.StaticLayout
            android.text.TextPaint r5 = r0.f8606h
            float r6 = r0.f8604f
            float r7 = r0.f8605g
            r24 = 1
            r17 = r3
            r19 = r5
            r20 = r4
            r22 = r6
            r23 = r7
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r0.f8594H = r3
            r0.f8595I = r1
            r0.f8596J = r2
            r1 = r25
            r0.f8597K = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p072ui.C3065b.m10109b():void");
    }

    /* renamed from: a */
    public void mo13097a(C3048b bVar, boolean z, boolean z2, C3047a aVar, float f, float f2, float f3, Canvas canvas, int i, int i2, int i3, int i4) {
        C3048b bVar2 = bVar;
        boolean z3 = z;
        boolean z4 = z2;
        C3047a aVar2 = aVar;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        Canvas canvas2 = canvas;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        boolean z5 = bVar2.f8445c == null;
        int i9 = -16777216;
        if (z5) {
            if (!TextUtils.isEmpty(bVar2.f8443a)) {
                i9 = (!bVar2.f8453k || !z3) ? aVar2.f8439c : bVar2.f8454l;
            } else {
                return;
            }
        }
        if (m10108a(this.f8608j, bVar2.f8443a) && C3071c.m10127a(this.f8609k, bVar2.f8444b) && this.f8610l == bVar2.f8445c && this.f8611m == bVar2.f8446d && this.f8612n == bVar2.f8447e && C3071c.m10127a(Integer.valueOf(this.f8613o), Integer.valueOf(bVar2.f8448f)) && this.f8614p == bVar2.f8449g && C3071c.m10127a(Integer.valueOf(this.f8615q), Integer.valueOf(bVar2.f8450h)) && this.f8616r == bVar2.f8451i && this.f8617s == bVar2.f8452j && this.f8618t == z3 && this.f8619u == z4 && this.f8620v == aVar2.f8437a && this.f8621w == aVar2.f8438b && this.f8622x == i9 && this.f8624z == aVar2.f8440d && this.f8623y == aVar2.f8441e && C3071c.m10127a(this.f8606h.getTypeface(), aVar2.f8442f) && this.f8587A == f4 && this.f8588B == f5 && this.f8589C == f6 && this.f8590D == i5 && this.f8591E == i6 && this.f8592F == i7 && this.f8593G == i8) {
            m10107a(canvas, z5);
            return;
        }
        Canvas canvas3 = canvas;
        this.f8608j = bVar2.f8443a;
        this.f8609k = bVar2.f8444b;
        this.f8610l = bVar2.f8445c;
        this.f8611m = bVar2.f8446d;
        this.f8612n = bVar2.f8447e;
        this.f8613o = bVar2.f8448f;
        this.f8614p = bVar2.f8449g;
        this.f8615q = bVar2.f8450h;
        this.f8616r = bVar2.f8451i;
        this.f8617s = bVar2.f8452j;
        this.f8618t = z3;
        this.f8619u = z4;
        this.f8620v = aVar2.f8437a;
        this.f8621w = aVar2.f8438b;
        this.f8622x = i9;
        this.f8624z = aVar2.f8440d;
        this.f8623y = aVar2.f8441e;
        this.f8606h.setTypeface(aVar2.f8442f);
        this.f8587A = f4;
        this.f8588B = f5;
        this.f8589C = f6;
        this.f8590D = i5;
        this.f8591E = i6;
        this.f8592F = i7;
        this.f8593G = i8;
        if (z5) {
            m10109b();
        } else {
            m10105a();
        }
        m10107a(canvas3, z5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10105a() {
        /*
            r7 = this;
            int r0 = r7.f8592F
            int r1 = r7.f8590D
            int r0 = r0 - r1
            int r2 = r7.f8593G
            int r3 = r7.f8591E
            int r2 = r2 - r3
            float r1 = (float) r1
            float r0 = (float) r0
            float r4 = r7.f8614p
            float r4 = r4 * r0
            float r1 = r1 + r4
            float r3 = (float) r3
            float r2 = (float) r2
            float r4 = r7.f8611m
            float r4 = r4 * r2
            float r3 = r3 + r4
            float r4 = r7.f8616r
            float r0 = r0 * r4
            int r0 = java.lang.Math.round(r0)
            float r4 = r7.f8617s
            r5 = 1
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x002e
            float r2 = r2 * r4
            int r2 = java.lang.Math.round(r2)
            goto L_0x0044
        L_0x002e:
            float r2 = (float) r0
            android.graphics.Bitmap r4 = r7.f8610l
            int r4 = r4.getHeight()
            float r4 = (float) r4
            android.graphics.Bitmap r5 = r7.f8610l
            int r5 = r5.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            float r2 = r2 * r4
            int r2 = java.lang.Math.round(r2)
        L_0x0044:
            int r4 = r7.f8613o
            r5 = 1
            r6 = 2
            if (r4 != r6) goto L_0x004d
            float r4 = (float) r0
        L_0x004b:
            float r1 = r1 - r4
            goto L_0x0053
        L_0x004d:
            if (r4 != r5) goto L_0x0053
            int r4 = r0 / 2
            float r4 = (float) r4
            goto L_0x004b
        L_0x0053:
            int r1 = java.lang.Math.round(r1)
            int r4 = r7.f8615q
            if (r4 != r6) goto L_0x005e
            float r4 = (float) r2
        L_0x005c:
            float r3 = r3 - r4
            goto L_0x0064
        L_0x005e:
            if (r4 != r5) goto L_0x0064
            int r4 = r2 / 2
            float r4 = (float) r4
            goto L_0x005c
        L_0x0064:
            int r3 = java.lang.Math.round(r3)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r0 = r0 + r1
            int r2 = r2 + r3
            r4.<init>(r1, r3, r0, r2)
            r7.f8598L = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p072ui.C3065b.m10105a():void");
    }

    /* renamed from: a */
    private void m10107a(Canvas canvas, boolean z) {
        if (z) {
            m10110b(canvas);
        } else {
            m10106a(canvas);
        }
    }

    /* renamed from: a */
    private void m10106a(Canvas canvas) {
        canvas.drawBitmap(this.f8610l, (Rect) null, this.f8598L, (Paint) null);
    }

    /* renamed from: a */
    private static boolean m10108a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    /* renamed from: b */
    private void m10110b(Canvas canvas) {
        int i;
        StaticLayout staticLayout = this.f8594H;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate((float) this.f8595I, (float) this.f8596J);
            if (Color.alpha(this.f8622x) > 0) {
                this.f8607i.setColor(this.f8622x);
                canvas.drawRect((float) (-this.f8597K), 0.0f, (float) (staticLayout.getWidth() + this.f8597K), (float) staticLayout.getHeight(), this.f8607i);
            }
            if (Color.alpha(this.f8621w) > 0) {
                this.f8607i.setColor(this.f8621w);
                float lineTop = (float) staticLayout.getLineTop(0);
                int lineCount = staticLayout.getLineCount();
                int i2 = 0;
                while (i2 < lineCount) {
                    float lineLeft = staticLayout.getLineLeft(i2);
                    float lineRight = staticLayout.getLineRight(i2);
                    RectF rectF = this.f8599a;
                    int i3 = this.f8597K;
                    rectF.left = lineLeft - ((float) i3);
                    rectF.right = ((float) i3) + lineRight;
                    rectF.top = lineTop;
                    rectF.bottom = (float) staticLayout.getLineBottom(i2);
                    RectF rectF2 = this.f8599a;
                    float f = rectF2.bottom;
                    if (lineRight - lineLeft > 0.0f) {
                        float f2 = this.f8600b;
                        canvas.drawRoundRect(rectF2, f2, f2, this.f8607i);
                    }
                    i2++;
                    lineTop = f;
                }
            }
            int i4 = this.f8624z;
            boolean z = true;
            if (i4 == 1) {
                this.f8606h.setStrokeJoin(Paint.Join.ROUND);
                this.f8606h.setStrokeWidth(this.f8601c);
                this.f8606h.setColor(this.f8623y);
                this.f8606h.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (i4 == 2) {
                TextPaint textPaint = this.f8606h;
                float f3 = this.f8602d;
                float f4 = this.f8603e;
                textPaint.setShadowLayer(f3, f4, f4, this.f8623y);
            } else if (i4 == 3 || i4 == 4) {
                if (this.f8624z != 3) {
                    z = false;
                }
                int i5 = -1;
                if (z) {
                    i = -1;
                } else {
                    i = this.f8623y;
                }
                if (z) {
                    i5 = this.f8623y;
                }
                float f5 = this.f8602d / 2.0f;
                this.f8606h.setColor(this.f8620v);
                this.f8606h.setStyle(Paint.Style.FILL);
                float f6 = -f5;
                this.f8606h.setShadowLayer(this.f8602d, f6, f6, i);
                staticLayout.draw(canvas);
                this.f8606h.setShadowLayer(this.f8602d, f5, f5, i5);
            }
            this.f8606h.setColor(this.f8620v);
            this.f8606h.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.f8606h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }
}
