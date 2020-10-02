package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;

public class AppCompatRatingBar extends RatingBar {

    /* renamed from: a */
    private final C0605j f1071a;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.ratingBarStyle);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f1071a.mo3490a();
        if (a != null) {
            setMeasuredDimension(View.resolveSizeAndState(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0605j jVar = new C0605j(this);
        this.f1071a = jVar;
        jVar.mo3491a(attributeSet, i);
    }
}
