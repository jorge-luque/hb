package androidx.loader.p025a;

import android.os.Bundle;
import androidx.lifecycle.C0970h;
import androidx.lifecycle.C0987t;
import androidx.loader.p026b.C0997b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.loader.a.a */
/* compiled from: LoaderManager */
public abstract class C0988a {

    /* renamed from: androidx.loader.a.a$a */
    /* compiled from: LoaderManager */
    public interface C0989a<D> {
        C0997b<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(C0997b<D> bVar, D d);

        void onLoaderReset(C0997b<D> bVar);
    }

    /* renamed from: a */
    public static <T extends C0970h & C0987t> C0988a m3506a(T t) {
        return new C0990b(t, ((C0987t) t).getViewModelStore());
    }

    /* renamed from: a */
    public abstract <D> C0997b<D> mo5021a(int i, Bundle bundle, C0989a<D> aVar);

    /* renamed from: a */
    public abstract void mo5022a();

    @Deprecated
    /* renamed from: a */
    public abstract void mo5023a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
