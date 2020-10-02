package com.criteo.publisher.advancednative;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.criteo.publisher.advancednative.h */
public class C2365h {

    /* renamed from: a */
    private final AtomicReference<ImageLoader> f7743a;

    public C2365h(ImageLoader imageLoader) {
        this.f7743a = new AtomicReference<>(imageLoader);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ImageLoader mo10221a() {
        return this.f7743a.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10222a(ImageLoader imageLoader) {
        this.f7743a.set(imageLoader);
    }
}
