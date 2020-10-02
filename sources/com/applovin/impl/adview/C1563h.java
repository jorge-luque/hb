package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.applovin.impl.adview.h */
public abstract class C1563h extends View {

    /* renamed from: a */
    protected float f4910a = 1.0f;

    /* renamed from: b */
    protected final Context f4911b;

    /* renamed from: com.applovin.impl.adview.h$a */
    public enum C1564a {
        WHITE_ON_BLACK(0),
        WHITE_ON_TRANSPARENT(1),
        INVISIBLE(2);
        

        /* renamed from: d */
        private final int f4916d;

        private C1564a(int i) {
            this.f4916d = i;
        }

        /* renamed from: a */
        public int mo7440a() {
            return this.f4916d;
        }
    }

    protected C1563h(Context context) {
        super(context);
        this.f4911b = context;
    }

    /* renamed from: a */
    public static C1563h m6016a(C1564a aVar, Context context) {
        return aVar.equals(C1564a.INVISIBLE) ? new C1624p(context) : aVar.equals(C1564a.WHITE_ON_TRANSPARENT) ? new C1625q(context) : new C1633w(context);
    }

    /* renamed from: a */
    public void mo7436a(int i) {
        setViewScale(((float) i) / 30.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) getSize();
            layoutParams.height = (int) getSize();
        }
    }

    public float getSize() {
        return this.f4910a * 30.0f;
    }

    public abstract C1564a getStyle();

    public void setViewScale(float f) {
        this.f4910a = f;
    }
}
