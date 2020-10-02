package androidx.appcompat.p010c;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* renamed from: androidx.appcompat.c.a */
/* compiled from: AllCapsTransformationMethod */
public class C0453a implements TransformationMethod {

    /* renamed from: a */
    private Locale f641a;

    public C0453a(Context context) {
        this.f641a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f641a);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
