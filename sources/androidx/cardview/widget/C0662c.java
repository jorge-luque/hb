package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.widget.C0667g;

/* renamed from: androidx.cardview.widget.c */
/* compiled from: CardViewBaseImpl */
class C0662c implements C0665e {

    /* renamed from: a */
    final RectF f1646a = new RectF();

    /* renamed from: androidx.cardview.widget.c$a */
    /* compiled from: CardViewBaseImpl */
    class C0663a implements C0667g.C0668a {
        C0663a() {
        }

        /* renamed from: a */
        public void mo3683a(Canvas canvas, RectF rectF, float f, Paint paint) {
            Canvas canvas2 = canvas;
            RectF rectF2 = rectF;
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                float f4 = -f3;
                C0662c.this.f1646a.set(f4, f4, f3, f3);
                int save = canvas.save();
                canvas2.translate(rectF2.left + f3, rectF2.top + f3);
                Paint paint2 = paint;
                canvas.drawArc(C0662c.this.f1646a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(width, 0.0f);
                canvas2.rotate(90.0f);
                canvas.drawArc(C0662c.this.f1646a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(height, 0.0f);
                canvas2.rotate(90.0f);
                canvas.drawArc(C0662c.this.f1646a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(width, 0.0f);
                canvas2.rotate(90.0f);
                canvas.drawArc(C0662c.this.f1646a, 180.0f, 90.0f, true, paint2);
                canvas2.restoreToCount(save);
                float f5 = rectF2.top;
                canvas.drawRect((rectF2.left + f3) - 1.0f, f5, (rectF2.right - f3) + 1.0f, f5 + f3, paint2);
                float f6 = rectF2.bottom;
                Canvas canvas3 = canvas;
                canvas3.drawRect((rectF2.left + f3) - 1.0f, f6 - f3, (rectF2.right - f3) + 1.0f, f6, paint2);
            }
            canvas.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
        }
    }

    C0662c() {
    }

    /* renamed from: e */
    private C0667g m1946e(C0664d dVar) {
        return (C0667g) dVar.mo3680c();
    }

    /* renamed from: a */
    public void mo3682a() {
        C0667g.f1660r = new C0663a();
    }

    /* renamed from: b */
    public void mo3688b(C0664d dVar, float f) {
        m1946e(dVar).mo3714b(f);
    }

    /* renamed from: c */
    public void mo3689c(C0664d dVar) {
        m1946e(dVar).mo3712a(dVar.mo3678a());
        mo3694d(dVar);
    }

    /* renamed from: d */
    public void mo3694d(C0664d dVar) {
        Rect rect = new Rect();
        m1946e(dVar).mo3711a(rect);
        dVar.mo3675a((int) Math.ceil((double) mo3687b(dVar)), (int) Math.ceil((double) mo3684a(dVar)));
        dVar.mo3676a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: a */
    public void mo3686a(C0664d dVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C0667g a = m1945a(context, colorStateList, f, f2, f3);
        a.mo3712a(dVar.mo3678a());
        dVar.mo3677a(a);
        mo3694d(dVar);
    }

    /* renamed from: b */
    public float mo3687b(C0664d dVar) {
        return m1946e(dVar).mo3713b();
    }

    /* renamed from: a */
    private C0667g m1945a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new C0667g(context.getResources(), colorStateList, f, f2, f3);
    }

    /* renamed from: a */
    public void mo3685a(C0664d dVar, float f) {
        m1946e(dVar).mo3710a(f);
        mo3694d(dVar);
    }

    /* renamed from: a */
    public float mo3684a(C0664d dVar) {
        return m1946e(dVar).mo3709a();
    }
}
