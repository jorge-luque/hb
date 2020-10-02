package p118io.fabric.sdk.android.p200m.p204d;

import android.content.Context;
import java.io.File;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;

/* renamed from: io.fabric.sdk.android.m.d.b */
/* compiled from: FileStoreImpl */
public class C6131b implements C6130a {

    /* renamed from: a */
    private final Context f16110a;

    public C6131b(C6069h hVar) {
        if (hVar.getContext() != null) {
            this.f16110a = hVar.getContext();
            hVar.getPath();
            "Android/" + this.f16110a.getPackageName();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    /* renamed from: a */
    public File mo34239a() {
        return mo34240a(this.f16110a.getFilesDir());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo34240a(File file) {
        if (file == null) {
            C6059c.m19630f().mo34093d("Fabric", "Null File");
            return null;
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            C6059c.m19630f().mo34086a("Fabric", "Couldn't create file");
            return null;
        }
    }
}
