package p118io.branch.referral;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.applinks.AppLinkData;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: io.branch.referral.k */
/* compiled from: DeferredAppLinkDataHandler */
class C6025k {

    /* renamed from: io.branch.referral.k$a */
    /* compiled from: DeferredAppLinkDataHandler */
    static class C6026a implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ Class f15422a;

        /* renamed from: b */
        final /* synthetic */ C6027b f15423b;

        C6026a(Class cls, C6027b bVar) {
            this.f15422a = cls;
            this.f15423b = bVar;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!method.getName().equals("onDeferredAppLinkDataFetched") || objArr[0] == null) {
                C6027b bVar = this.f15423b;
                if (bVar != null) {
                    bVar.mo19640a((String) null);
                }
            } else {
                Bundle cast = Bundle.class.cast(this.f15422a.getMethod("getArgumentBundle", new Class[0]).invoke(this.f15422a.cast(objArr[0]), new Object[0]));
                String string = cast != null ? cast.getString(AppLinkData.ARGUMENTS_NATIVE_URL) : null;
                C6027b bVar2 = this.f15423b;
                if (bVar2 != null) {
                    bVar2.mo19640a(string);
                }
            }
            return null;
        }
    }

    /* renamed from: io.branch.referral.k$b */
    /* compiled from: DeferredAppLinkDataHandler */
    public interface C6027b {
        /* renamed from: a */
        void mo19640a(String str);
    }

    /* renamed from: a */
    public static Boolean m19358a(Context context, C6027b bVar) {
        boolean z = false;
        try {
            Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
            Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
            Method method = cls.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls2});
            C6026a aVar = new C6026a(cls, bVar);
            Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, aVar);
            String string = context.getString(context.getResources().getIdentifier("facebook_app_id", "string", context.getPackageName()));
            if (!TextUtils.isEmpty(string)) {
                method.invoke((Object) null, new Object[]{context, string, newProxyInstance});
                z = true;
            }
        } catch (Throwable unused) {
        }
        return Boolean.valueOf(z);
    }
}
