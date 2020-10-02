package com.criteo.publisher.p054a0;

import android.content.Context;

/* renamed from: com.criteo.publisher.a0.c */
public class C2323c {

    /* renamed from: a */
    private final Context f7675a;

    public C2323c(Context context) {
        this.f7675a = context;
    }

    /* renamed from: a */
    public int mo10117a() {
        return this.f7675a.getResources().getConfiguration().orientation;
    }

    /* renamed from: a */
    public int mo10118a(int i) {
        return (int) Math.ceil((double) (((float) i) * this.f7675a.getResources().getDisplayMetrics().density));
    }
}
