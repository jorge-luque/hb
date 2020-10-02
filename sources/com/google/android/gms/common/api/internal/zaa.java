package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C6820zaa> zacl;

    public zaa(Activity activity) {
        this(C6820zaa.zaa(activity));
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C6820zaa zaa = (C6820zaa) this.zacl.get();
        if (zaa != null) {
            zaa.zaa(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }

    private zaa(C6820zaa zaa) {
        this.zacl = new WeakReference<>(zaa);
    }

    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa  reason: collision with other inner class name */
    static class C6820zaa extends LifecycleCallback {
        private List<Runnable> zacm = new ArrayList();

        private C6820zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* access modifiers changed from: private */
        public static C6820zaa zaa(Activity activity) {
            C6820zaa zaa;
            synchronized (activity) {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                zaa = (C6820zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C6820zaa.class);
                if (zaa == null) {
                    zaa = new C6820zaa(fragment);
                }
            }
            return zaa;
        }

        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zacm;
                this.zacm = new ArrayList();
            }
            for (Runnable run : list) {
                run.run();
            }
        }

        /* access modifiers changed from: private */
        public final synchronized void zaa(Runnable runnable) {
            this.zacm.add(runnable);
        }
    }
}
