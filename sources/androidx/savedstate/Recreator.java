package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.C0964d;
import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0970h;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"RestrictedApi"})
final class Recreator implements C0964d {

    /* renamed from: a */
    private final C1123b f3034a;

    Recreator(C1123b bVar) {
        this.f3034a = bVar;
    }

    /* renamed from: a */
    public void mo1895a(C0970h hVar, C0965e.C0966a aVar) {
        if (aVar == C0965e.C0966a.ON_CREATE) {
            hVar.getLifecycle().mo4997b(this);
            Bundle a = this.f3034a.getSavedStateRegistry().mo5938a("androidx.savedstate.Restarter");
            if (a != null) {
                ArrayList<String> stringArrayList = a.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        m4581a(it.next());
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }

    /* renamed from: a */
    private void m4581a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.C1120a.class);
            try {
                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.C1120a) declaredConstructor.newInstance(new Object[0])).mo5941a(this.f3034a);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }
}
