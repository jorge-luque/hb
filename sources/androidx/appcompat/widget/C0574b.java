package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.appcompat.widget.b */
/* compiled from: ActionBarBackgroundDrawable */
class C0574b extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f1357a;

    public C0574b(ActionBarContainer actionBarContainer) {
        this.f1357a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f1357a;
        if (actionBarContainer.f949h) {
            Drawable drawable = actionBarContainer.f948g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f946e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f1357a;
        Drawable drawable3 = actionBarContainer2.f947f;
        if (drawable3 != null && actionBarContainer2.f950i) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f1357a;
        if (actionBarContainer.f949h) {
            Drawable drawable = actionBarContainer.f948g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f946e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
