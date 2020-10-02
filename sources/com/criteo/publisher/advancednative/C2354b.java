package com.criteo.publisher.advancednative;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.criteo.publisher.p054a0.C2323c;
import com.criteo.publisher.p054a0.C2330h;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.criteo.publisher.advancednative.b */
public class C2354b {

    /* renamed from: a */
    private final Map<View, WeakReference<ImageView>> f7727a = new WeakHashMap();

    /* renamed from: b */
    private final C2330h f7728b;

    /* renamed from: c */
    private final C2323c f7729c;

    public C2354b(C2330h hVar, C2323c cVar) {
        this.f7728b = hVar;
        this.f7729c = cVar;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"RtlHardcoded"})
    /* renamed from: a */
    public ViewGroup mo10206a(View view) {
        Context context = view.getContext();
        ImageView imageView = new ImageView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            frameLayout.setLayoutParams(layoutParams);
        }
        frameLayout.addView(view);
        frameLayout.addView(imageView);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.gravity = 5;
        layoutParams2.width = this.f7729c.mo10118a(this.f7728b.mo10129b());
        layoutParams2.height = this.f7729c.mo10118a(this.f7728b.mo10128a());
        imageView.setMinimumWidth(layoutParams2.width);
        imageView.setMinimumHeight(layoutParams2.height);
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setElevation(1000.0f);
            imageView.setOutlineProvider((ViewOutlineProvider) null);
        }
        this.f7727a.put(frameLayout, new WeakReference(imageView));
        return frameLayout;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ImageView mo10207b(View view) {
        WeakReference weakReference = this.f7727a.get(view);
        if (weakReference == null) {
            return null;
        }
        return (ImageView) weakReference.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo10208c(View view) {
        if (mo10207b(view) == null) {
            return null;
        }
        return ((ViewGroup) view).getChildAt(0);
    }
}
