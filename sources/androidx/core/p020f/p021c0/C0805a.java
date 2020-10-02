package androidx.core.p020f.p021c0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: androidx.core.f.c0.a */
/* compiled from: AccessibilityClickableSpanCompat */
public final class C0805a extends ClickableSpan {

    /* renamed from: a */
    private final int f2010a;

    /* renamed from: b */
    private final C0807c f2011b;

    /* renamed from: c */
    private final int f2012c;

    public C0805a(int i, C0807c cVar, int i2) {
        this.f2010a = i;
        this.f2011b = cVar;
        this.f2012c = i2;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2010a);
        this.f2011b.mo4118a(this.f2012c, bundle);
    }
}
