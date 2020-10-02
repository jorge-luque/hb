package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;

/* renamed from: com.tapjoy.internal.ae */
public final class C4882ae extends C4879ad {

    /* renamed from: b */
    private final AnimationSet f13324b = ((AnimationSet) this.f13317a);

    public C4882ae() {
        super(new AnimationSet(true));
    }

    /* renamed from: a */
    public final C4882ae mo30910a(Animation animation) {
        this.f13324b.addAnimation(animation);
        return this;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Animation mo30908a() {
        return this.f13324b;
    }
}
