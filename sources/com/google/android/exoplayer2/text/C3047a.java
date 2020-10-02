package com.google.android.exoplayer2.text;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.C3071c;

/* renamed from: com.google.android.exoplayer2.text.a */
/* compiled from: CaptionStyleCompat */
public final class C3047a {

    /* renamed from: g */
    public static final C3047a f8436g = new C3047a(-1, -16777216, 0, 0, -1, (Typeface) null);

    /* renamed from: a */
    public final int f8437a;

    /* renamed from: b */
    public final int f8438b;

    /* renamed from: c */
    public final int f8439c;

    /* renamed from: d */
    public final int f8440d;

    /* renamed from: e */
    public final int f8441e;

    /* renamed from: f */
    public final Typeface f8442f;

    public C3047a(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.f8437a = i;
        this.f8438b = i2;
        this.f8439c = i3;
        this.f8440d = i4;
        this.f8441e = i5;
        this.f8442f = typeface;
    }

    @TargetApi(19)
    /* renamed from: a */
    public static C3047a m9986a(CaptioningManager.CaptionStyle captionStyle) {
        if (C3071c.f8625a >= 21) {
            return m9988c(captionStyle);
        }
        return m9987b(captionStyle);
    }

    @TargetApi(19)
    /* renamed from: b */
    private static C3047a m9987b(CaptioningManager.CaptionStyle captionStyle) {
        return new C3047a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    /* renamed from: c */
    private static C3047a m9988c(CaptioningManager.CaptionStyle captionStyle) {
        return new C3047a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f8436g.f8437a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f8436g.f8438b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f8436g.f8439c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f8436g.f8440d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f8436g.f8441e, captionStyle.getTypeface());
    }
}
