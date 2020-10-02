package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.p020f.C0822d;
import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0970h;
import androidx.lifecycle.C0971i;
import androidx.lifecycle.C0980p;
import p075d.p080b.C3204g;

/* renamed from: androidx.core.app.e */
/* compiled from: ComponentActivity */
public class C0711e extends Activity implements C0970h, C0822d.C0823a {
    private C3204g<Class<? extends C0712a>, C0712a> mExtraDataMap = new C3204g<>();
    private C0971i mLifecycleRegistry = new C0971i(this);

    @Deprecated
    /* renamed from: androidx.core.app.e$a */
    /* compiled from: ComponentActivity */
    public static class C0712a {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0822d.m2630a(decorView, keyEvent)) {
            return C0822d.m2631a(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0822d.m2630a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends C0712a> T getExtraData(Class<T> cls) {
        return (C0712a) this.mExtraDataMap.get(cls);
    }

    public C0965e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0980p.m3489a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.mo5000a(C0965e.C0967b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(C0712a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
