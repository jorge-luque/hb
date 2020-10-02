package p118io.fabric.sdk.android;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import p118io.fabric.sdk.android.p200m.p202b.C6107s;
import p118io.fabric.sdk.android.services.concurrency.C3572d;
import p118io.fabric.sdk.android.services.concurrency.C6184l;

/* renamed from: io.fabric.sdk.android.h */
/* compiled from: Kit */
public abstract class C6069h<Result> implements Comparable<C6069h> {
    Context context;
    final C3572d dependsOnAnnotation = ((C3572d) getClass().getAnnotation(C3572d.class));
    C6059c fabric;
    C6107s idManager;
    C6065f<Result> initializationCallback;
    C6068g<Result> initializationTask = new C6068g<>(this);

    /* access modifiers changed from: package-private */
    public boolean containsAnnotatedDependency(C6069h hVar) {
        if (hasAnnotatedDependency()) {
            for (Class isAssignableFrom : this.dependsOnAnnotation.value()) {
                if (isAssignableFrom.isAssignableFrom(hVar.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackground();

    public Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public Collection<C6184l> getDependencies() {
        return this.initializationTask.getDependencies();
    }

    public C6059c getFabric() {
        return this.fabric;
    }

    /* access modifiers changed from: protected */
    public C6107s getIdManager() {
        return this.idManager;
    }

    public abstract String getIdentifier();

    public String getPath() {
        return ".Fabric" + File.separator + getIdentifier();
    }

    public abstract String getVersion();

    /* access modifiers changed from: package-private */
    public boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    /* access modifiers changed from: package-private */
    public final void initialize() {
        this.initializationTask.mo34299a(this.fabric.mo34102b(), null);
    }

    /* access modifiers changed from: package-private */
    public void injectParameters(Context context2, C6059c cVar, C6065f<Result> fVar, C6107s sVar) {
        this.fabric = cVar;
        this.context = new C6063d(context2, getIdentifier(), getPath());
        this.initializationCallback = fVar;
        this.idManager = sVar;
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        return true;
    }

    public int compareTo(C6069h hVar) {
        if (containsAnnotatedDependency(hVar)) {
            return 1;
        }
        if (hVar.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (hasAnnotatedDependency() && !hVar.hasAnnotatedDependency()) {
            return 1;
        }
        if (hasAnnotatedDependency() || !hVar.hasAnnotatedDependency()) {
            return 0;
        }
        return -1;
    }
}
