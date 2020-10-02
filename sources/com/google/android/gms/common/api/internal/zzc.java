package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.C0911c;
import androidx.fragment.app.C0937k;
import androidx.fragment.app.Fragment;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import p075d.p080b.C3191a;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public final class zzc extends Fragment implements LifecycleFragment {
    private static WeakHashMap<C0911c, WeakReference<zzc>> zzbt = new WeakHashMap<>();
    private Map<String, LifecycleCallback> zzbu = new C3191a();
    /* access modifiers changed from: private */
    public int zzbv = 0;
    /* access modifiers changed from: private */
    public Bundle zzbw;

    public static zzc zza(C0911c cVar) {
        zzc zzc;
        WeakReference weakReference = zzbt.get(cVar);
        if (weakReference != null && (zzc = (zzc) weakReference.get()) != null) {
            return zzc;
        }
        try {
            zzc zzc2 = (zzc) cVar.getSupportFragmentManager().mo4777a("SupportLifecycleFragmentImpl");
            if (zzc2 == null || zzc2.isRemoving()) {
                zzc2 = new zzc();
                C0937k a = cVar.getSupportFragmentManager().mo4778a();
                a.mo4918a(zzc2, "SupportLifecycleFragmentImpl");
                a.mo4675b();
            }
            zzbt.put(cVar, new WeakReference(zzc2));
            return zzc2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        if (!this.zzbu.containsKey(str)) {
            this.zzbu.put(str, lifecycleCallback);
            if (this.zzbv > 0) {
                new zzi(Looper.getMainLooper()).post(new zzd(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.zzbu.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.zzbu.get(str));
    }

    public final /* synthetic */ Activity getLifecycleActivity() {
        return getActivity();
    }

    public final boolean isCreated() {
        return this.zzbv > 0;
    }

    public final boolean isStarted() {
        return this.zzbv >= 2;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback onActivityResult : this.zzbu.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbv = 1;
        this.zzbw = bundle;
        for (Map.Entry next : this.zzbu.entrySet()) {
            ((LifecycleCallback) next.getValue()).onCreate(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zzbv = 5;
        for (LifecycleCallback onDestroy : this.zzbu.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.zzbv = 3;
        for (LifecycleCallback onResume : this.zzbu.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.zzbu.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.zzbv = 2;
        for (LifecycleCallback onStart : this.zzbu.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.zzbv = 4;
        for (LifecycleCallback onStop : this.zzbu.values()) {
            onStop.onStop();
        }
    }
}
