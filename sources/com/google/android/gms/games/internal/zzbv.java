package com.google.android.gms.games.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.util.PlatformVersion;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzbv implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    private boolean zzha = false;
    private zzg zzjv;
    private zzbw zzjw;
    private WeakReference<View> zzjx;

    private zzbv(zzg zzg, int i) {
        this.zzjv = zzg;
        this.zzjw = new zzbw(i);
    }

    public static zzbv zza(zzg zzg, int i) {
        return new zzbv(zzg, i);
    }

    @TargetApi(17)
    private final void zzc(View view) {
        Display display;
        int i = -1;
        if (PlatformVersion.isAtLeastJellyBeanMR1() && (display = view.getDisplay()) != null) {
            i = display.getDisplayId();
        }
        IBinder windowToken = view.getWindowToken();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        zzbw zzbw = this.zzjw;
        zzbw.zzjy = i;
        zzbw.zzju = windowToken;
        zzbw.left = iArr[0];
        zzbw.top = iArr[1];
        zzbw.right = iArr[0] + width;
        zzbw.bottom = iArr[1] + height;
        if (this.zzha) {
            zzct();
        }
    }

    public final void onGlobalLayout() {
        View view;
        WeakReference<View> weakReference = this.zzjx;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            zzc(view);
        }
    }

    public final void onViewAttachedToWindow(View view) {
        zzc(view);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzjv.zzcl();
        view.removeOnAttachStateChangeListener(this);
    }

    public final void setGravity(int i) {
        this.zzjw.gravity = i;
    }

    @TargetApi(16)
    public final void zzb(View view) {
        this.zzjv.zzcl();
        WeakReference<View> weakReference = this.zzjx;
        if (weakReference != null) {
            View view2 = (View) weakReference.get();
            Context context = this.zzjv.getContext();
            if (view2 == null && (context instanceof Activity)) {
                view2 = ((Activity) context).getWindow().getDecorView();
            }
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this);
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                if (PlatformVersion.isAtLeastJellyBean()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
        this.zzjx = null;
        Context context2 = this.zzjv.getContext();
        if (view == null && (context2 instanceof Activity)) {
            Activity activity = (Activity) context2;
            view = activity.findViewById(16908290);
            if (view == null) {
                view = activity.getWindow().getDecorView();
            }
            zzaz.m10159w("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if (view != null) {
            zzc(view);
            this.zzjx = new WeakReference<>(view);
            view.addOnAttachStateChangeListener(this);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            return;
        }
        zzaz.m10156e("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }

    public final Bundle zzcq() {
        return this.zzjw.zzcu();
    }

    public final IBinder zzcr() {
        return this.zzjw.zzju;
    }

    public final zzbw zzcs() {
        return this.zzjw;
    }

    public final void zzct() {
        zzbw zzbw = this.zzjw;
        IBinder iBinder = zzbw.zzju;
        if (iBinder != null) {
            this.zzjv.zza(iBinder, zzbw.zzcu());
            this.zzha = false;
            return;
        }
        this.zzha = true;
    }
}
