package androidx.activity;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.C0968f;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements C0968f {

    /* renamed from: b */
    private static int f263b;

    /* renamed from: c */
    private static Field f264c;

    /* renamed from: d */
    private static Field f265d;

    /* renamed from: e */
    private static Field f266e;

    /* renamed from: a */
    private Activity f267a;

    ImmLeaksCleaner(Activity activity) {
        this.f267a = activity;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0045, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0044 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1895a(androidx.lifecycle.C0970h r3, androidx.lifecycle.C0965e.C0966a r4) {
        /*
            r2 = this;
            androidx.lifecycle.e$a r3 = androidx.lifecycle.C0965e.C0966a.ON_DESTROY
            if (r4 == r3) goto L_0x0005
            return
        L_0x0005:
            int r3 = f263b
            if (r3 != 0) goto L_0x000c
            m307a()
        L_0x000c:
            int r3 = f263b
            r4 = 1
            if (r3 != r4) goto L_0x004e
            android.app.Activity r3 = r2.f267a
            java.lang.String r4 = "input_method"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            java.lang.reflect.Field r4 = f264c     // Catch:{ IllegalAccessException -> 0x004e }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalAccessException -> 0x004e }
            if (r4 != 0) goto L_0x0024
            return
        L_0x0024:
            monitor-enter(r4)
            java.lang.reflect.Field r0 = f265d     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            if (r0 != 0) goto L_0x0031
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x0031:
            boolean r0 = r0.isAttachedToWindow()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0039
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x0039:
            java.lang.reflect.Field r0 = f266e     // Catch:{ IllegalAccessException -> 0x0044 }
            r1 = 0
            r0.set(r3, r1)     // Catch:{ IllegalAccessException -> 0x0044 }
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            r3.isActive()
            goto L_0x004e
        L_0x0044:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x0046:
            r3 = move-exception
            goto L_0x004c
        L_0x0048:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x004a:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x004c:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            throw r3
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ImmLeaksCleaner.mo1895a(androidx.lifecycle.h, androidx.lifecycle.e$a):void");
    }

    /* renamed from: a */
    private static void m307a() {
        try {
            f263b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f265d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f266e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f264c = declaredField3;
            declaredField3.setAccessible(true);
            f263b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }
}
