package p118io.fabric.sdk.android.p200m.p202b;

import android.content.Context;
import java.lang.reflect.Method;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;

/* renamed from: io.fabric.sdk.android.m.b.q */
/* compiled from: FirebaseAppImpl */
final class C6105q implements C6104p {

    /* renamed from: a */
    private final Method f16053a;

    /* renamed from: b */
    private final Object f16054b;

    private C6105q(Class cls, Object obj) throws NoSuchMethodException {
        this.f16054b = obj;
        this.f16053a = cls.getDeclaredMethod("isDataCollectionDefaultEnabled", new Class[0]);
    }

    /* renamed from: a */
    public static C6104p m19778a(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.google.firebase.FirebaseApp");
            return new C6105q(loadClass, loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
        } catch (ClassNotFoundException unused) {
            C6059c.m19630f().mo34093d("Fabric", "Could not find class: com.google.firebase.FirebaseApp");
            return null;
        } catch (NoSuchMethodException e) {
            C6072k f = C6059c.m19630f();
            f.mo34093d("Fabric", "Could not find method: " + e.getMessage());
            return null;
        } catch (Exception e2) {
            C6059c.m19630f().mo34092c("Fabric", "Unexpected error loading FirebaseApp instance.", e2);
            return null;
        }
    }

    /* renamed from: a */
    public boolean mo34182a() {
        try {
            return ((Boolean) this.f16053a.invoke(this.f16054b, new Object[0])).booleanValue();
        } catch (Exception e) {
            C6059c.m19630f().mo34092c("Fabric", "Cannot check isDataCollectionDefaultEnabled on FirebaseApp.", e);
            return false;
        }
    }
}
