package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.C0667g;

/* renamed from: androidx.cardview.widget.a */
/* compiled from: CardViewApi17Impl */
class C0659a extends C0662c {

    /* renamed from: androidx.cardview.widget.a$a */
    /* compiled from: CardViewApi17Impl */
    class C0660a implements C0667g.C0668a {
        C0660a(C0659a aVar) {
        }

        /* renamed from: a */
        public void mo3683a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    C0659a() {
    }

    /* renamed from: a */
    public void mo3682a() {
        C0667g.f1660r = new C0660a(this);
    }
}
