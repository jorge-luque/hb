package androidx.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.C0711e;
import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0968f;
import androidx.lifecycle.C0970h;
import androidx.lifecycle.C0971i;
import androidx.lifecycle.C0980p;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.C0987t;
import androidx.savedstate.C1122a;
import androidx.savedstate.C1123b;
import androidx.savedstate.SavedStateRegistry;

public class ComponentActivity extends C0711e implements C0970h, C0987t, C1123b, C0382c {
    private int mContentLayoutId;
    private final C0971i mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final C1122a mSavedStateRegistryController;
    private C0986s mViewModelStore;

    /* renamed from: androidx.activity.ComponentActivity$a */
    class C0377a implements Runnable {
        C0377a() {
        }

        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$b */
    static final class C0378b {

        /* renamed from: a */
        Object f261a;

        /* renamed from: b */
        C0986s f262b;

        C0378b() {
        }
    }

    public ComponentActivity() {
        this.mLifecycleRegistry = new C0971i(this);
        this.mSavedStateRegistryController = C1122a.m4589a((C1123b) this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new C0377a());
        if (getLifecycle() != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getLifecycle().mo4996a(new C0968f() {
                    /* renamed from: a */
                    public void mo1895a(C0970h hVar, C0965e.C0966a aVar) {
                        if (aVar == C0965e.C0966a.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                peekDecorView.cancelPendingInputEvents();
                            }
                        }
                    }
                });
            }
            getLifecycle().mo4996a(new C0968f() {
                /* renamed from: a */
                public void mo1895a(C0970h hVar, C0965e.C0966a aVar) {
                    if (aVar == C0965e.C0966a.ON_DESTROY && !ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().mo5019a();
                    }
                }
            });
            int i = Build.VERSION.SDK_INT;
            if (19 <= i && i <= 23) {
                getLifecycle().mo4996a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        C0378b bVar = (C0378b) getLastNonConfigurationInstance();
        if (bVar != null) {
            return bVar.f261a;
        }
        return null;
    }

    public C0965e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.mo5943a();
    }

    public C0986s getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                C0378b bVar = (C0378b) getLastNonConfigurationInstance();
                if (bVar != null) {
                    this.mViewModelStore = bVar.f262b;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new C0986s();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.mo1898a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.mo5944a(bundle);
        C0980p.m3489a((Activity) this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        C0378b bVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        C0986s sVar = this.mViewModelStore;
        if (sVar == null && (bVar = (C0378b) getLastNonConfigurationInstance()) != null) {
            sVar = bVar.f262b;
        }
        if (sVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        C0378b bVar2 = new C0378b();
        bVar2.f261a = onRetainCustomNonConfigurationInstance;
        bVar2.f262b = sVar;
        return bVar2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        C0965e lifecycle = getLifecycle();
        if (lifecycle instanceof C0971i) {
            ((C0971i) lifecycle).mo5001b(C0965e.C0967b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.mo5945b(bundle);
    }

    public ComponentActivity(int i) {
        this();
        this.mContentLayoutId = i;
    }
}
