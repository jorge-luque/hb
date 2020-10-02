package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;

public class AppCompatSeekBar extends SeekBar {

    /* renamed from: a */
    private final C0609k f1072a;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.seekBarStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1072a.mo3502b();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1072a.mo3503c();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1072a.mo3500a(canvas);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0609k kVar = new C0609k(this);
        this.f1072a = kVar;
        kVar.mo3491a(attributeSet, i);
    }
}
