package p093e.p094a.p095a;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: e.a.a.r0 */
/* compiled from: Reflection */
public class C3341r0 {
    /* renamed from: a */
    private static Object m11110a(Context context) throws Exception {
        return m11113a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, context);
    }

    /* renamed from: b */
    public static String m11116b(Context context) {
        try {
            return (String) m11112a(m11110a(context), "getId", (Class[]) null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static Boolean m11117c(Context context) {
        try {
            boolean z = false;
            Boolean bool = (Boolean) m11112a(m11110a(context), "isLimitAdTrackingEnabled", (Class[]) null, new Object[0]);
            if (bool == null) {
                return null;
            }
            if (!bool.booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    static Map<String, String> m11115a(Context context, C3364y yVar) {
        try {
            Object a = m11113a("com.adjust.sdk.imei.Util", "getImeiParameters", new Class[]{Context.class, C3364y.class}, context, yVar);
            Class<Map> cls = Map.class;
            if (a == null || !cls.isInstance(a)) {
                return null;
            }
            return (Map) a;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m11114a(String str, Class[] clsArr, Object... objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m11113a(String str, String str2, Class[] clsArr, Object... objArr) throws Exception {
        return m11111a(Class.forName(str), str2, (Object) null, clsArr, objArr);
    }

    /* renamed from: a */
    public static Object m11112a(Object obj, String str, Class[] clsArr, Object... objArr) throws Exception {
        return m11111a(obj.getClass(), str, obj, clsArr, objArr);
    }

    /* renamed from: a */
    public static Object m11111a(Class cls, String str, Object obj, Class[] clsArr, Object... objArr) throws Exception {
        Method method = cls.getMethod(str, clsArr);
        if (method == null) {
            return null;
        }
        return method.invoke(obj, objArr);
    }
}
