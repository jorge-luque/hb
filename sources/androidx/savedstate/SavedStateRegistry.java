package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.C0964d;
import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0970h;
import java.util.Map;
import p075d.p076a.p077a.p079b.C3184b;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* renamed from: a */
    private C3184b<String, C1121b> f3035a = new C3184b<>();

    /* renamed from: b */
    private Bundle f3036b;

    /* renamed from: c */
    private boolean f3037c;

    /* renamed from: d */
    boolean f3038d;

    /* renamed from: androidx.savedstate.SavedStateRegistry$a */
    public interface C1120a {
        /* renamed from: a */
        void mo5941a(C1123b bVar);
    }

    /* renamed from: androidx.savedstate.SavedStateRegistry$b */
    public interface C1121b {
        /* renamed from: a */
        Bundle mo5942a();
    }

    SavedStateRegistry() {
    }

    /* renamed from: a */
    public Bundle mo5938a(String str) {
        if (this.f3037c) {
            Bundle bundle = this.f3036b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f3036b.remove(str);
            if (this.f3036b.isEmpty()) {
                this.f3036b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5940a(C0965e eVar, Bundle bundle) {
        if (!this.f3037c) {
            if (bundle != null) {
                this.f3036b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            eVar.mo4996a(new C0964d() {
                /* renamed from: a */
                public void mo1895a(C0970h hVar, C0965e.C0966a aVar) {
                    if (aVar == C0965e.C0966a.ON_START) {
                        SavedStateRegistry.this.f3038d = true;
                    } else if (aVar == C0965e.C0966a.ON_STOP) {
                        SavedStateRegistry.this.f3038d = false;
                    }
                }
            });
            this.f3037c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5939a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f3036b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C3184b<K, V>.d c = this.f3035a.mo18652c();
        while (c.hasNext()) {
            Map.Entry entry = (Map.Entry) c.next();
            bundle2.putBundle((String) entry.getKey(), ((C1121b) entry.getValue()).mo5942a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
