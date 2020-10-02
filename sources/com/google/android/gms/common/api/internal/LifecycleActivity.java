package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.C0911c;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public class LifecycleActivity {
    private final Object zzbk;

    public LifecycleActivity(Activity activity) {
        this.zzbk = Preconditions.checkNotNull(activity, "Activity must not be null");
    }

    @KeepForSdk
    public Activity asActivity() {
        return (Activity) this.zzbk;
    }

    @KeepForSdk
    public C0911c asFragmentActivity() {
        return (C0911c) this.zzbk;
    }

    @KeepForSdk
    public Object asObject() {
        return this.zzbk;
    }

    @KeepForSdk
    public boolean isChimera() {
        return false;
    }

    @KeepForSdk
    public boolean isSupport() {
        return this.zzbk instanceof C0911c;
    }

    public final boolean zzh() {
        return this.zzbk instanceof Activity;
    }

    @KeepForSdk
    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
