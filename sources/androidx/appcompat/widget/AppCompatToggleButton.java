package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class AppCompatToggleButton extends ToggleButton {

    /* renamed from: a */
    private final C0613m f1106a;

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0613m mVar = new C0613m(this);
        this.f1106a = mVar;
        mVar.mo3519a(attributeSet, i);
    }
}
