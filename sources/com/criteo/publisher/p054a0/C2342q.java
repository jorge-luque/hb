package com.criteo.publisher.p054a0;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.criteo.publisher.a0.q */
public class C2342q {
    /* renamed from: a */
    public static Class m8998a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            Log.e("ReflectionUtil", "Failed to get Class: " + str + " : " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m8999a(Object obj, String str, Object... objArr) {
        if (!(obj == null || str == null || objArr == null)) {
            try {
                int length = objArr.length;
                Class[] clsArr = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr[i] = objArr[i].getClass();
                }
                return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Object m9000a(String str, Context context) {
        if (!(str == null || context == null)) {
            try {
                Class a = m8998a("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                Object invoke = a.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(a, new Object[]{context});
                return invoke.getClass().getDeclaredMethod(str, new Class[0]).invoke(invoke, new Object[0]);
            } catch (Exception e) {
                Log.e("ReflectionUtil", "Failed to callAdvertisingIdClient method: " + str + " with context: " + context.getClass().getName() + " : " + e.getMessage());
            }
        }
        return null;
    }
}
