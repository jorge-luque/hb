package org.cocos2dx.lib;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;

public class Cocos2dxReflectionHelper {
    public static <T> T getConstantValue(Class cls, String str) {
        try {
            return cls.getDeclaredField(str).get((Object) null);
        } catch (NoSuchFieldException unused) {
            Log.e("error", "can not find " + str + " in " + cls.getName());
            return null;
        } catch (IllegalAccessException unused2) {
            Log.e("error", str + " is not accessible");
            return null;
        } catch (IllegalArgumentException unused3) {
            Log.e("error", "arguments error when get " + str);
            return null;
        } catch (Exception unused4) {
            Log.e("error", "can not get constant" + str);
            return null;
        }
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Class<?> cls = obj.getClass();
        try {
            return cls.getMethod(str, clsArr).invoke(obj, objArr);
        } catch (NoSuchMethodException unused) {
            Log.e("error", "can not find " + str + " in " + cls.getName());
            return null;
        } catch (IllegalAccessException unused2) {
            Log.e("error", str + " is not accessible");
            return null;
        } catch (IllegalArgumentException unused3) {
            Log.e("error", "arguments are error when invoking " + str);
            return null;
        } catch (InvocationTargetException unused4) {
            Log.e("error", "an exception was thrown by the invoked method when invoking " + str);
            return null;
        }
    }
}
