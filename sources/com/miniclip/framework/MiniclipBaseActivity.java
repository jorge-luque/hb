package com.miniclip.framework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public abstract class MiniclipBaseActivity extends Activity implements MiniclipFacilitator {
    private LinkedHashSet<ActivityListener> activityListeners = new LinkedHashSet<>();

    /* renamed from: com.miniclip.framework.MiniclipBaseActivity$a */
    static /* synthetic */ class C4272a {

        /* renamed from: a */
        static final /* synthetic */ int[] f11432a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.miniclip.framework.ThreadingContext[] r0 = com.miniclip.framework.ThreadingContext.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11432a = r0
                com.miniclip.framework.ThreadingContext r1 = com.miniclip.framework.ThreadingContext.AndroidUi     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11432a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.miniclip.framework.ThreadingContext r1 = com.miniclip.framework.ThreadingContext.Main     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.miniclip.framework.MiniclipBaseActivity.C4272a.<clinit>():void");
        }
    }

    public boolean addListener(ActivityListener activityListener) {
        return this.activityListeners.add(activityListener);
    }

    public Activity getActivity() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Iterator it = new ArrayList(this.activityListeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Miniclip.setFacilitator(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Iterator it = new ArrayList(this.activityListeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onDestroy();
        }
        super.onDestroy();
    }

    public void onLowMemory() {
        Iterator it = this.activityListeners.iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onLowMemory();
        }
        super.onLowMemory();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Iterator it = new ArrayList(this.activityListeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Iterator it = new ArrayList(this.activityListeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onPause();
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Iterator it = this.activityListeners.iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onRequestPermissionsResult(i, strArr, iArr);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        Iterator it = new ArrayList(this.activityListeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onRestart();
        }
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Iterator it = new ArrayList(this.activityListeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onResume();
        }
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        Iterator it = this.activityListeners.iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onSaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        Iterator it = new ArrayList(this.activityListeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onStart();
        }
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        Iterator it = new ArrayList(this.activityListeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onStop();
        }
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        Iterator it = new ArrayList(this.activityListeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onWindowFocusChanged(z);
        }
        super.onWindowFocusChanged(z);
    }

    public void queueEvent(ThreadingContext threadingContext, Runnable runnable) {
        if (C4272a.f11432a[threadingContext.ordinal()] != 1) {
            runOnUiThread(runnable);
        } else {
            runOnUiThread(runnable);
        }
    }

    public boolean removeListener(ActivityListener activityListener) {
        return this.activityListeners.remove(activityListener);
    }
}
