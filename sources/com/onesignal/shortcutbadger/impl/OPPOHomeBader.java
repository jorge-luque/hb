package com.onesignal.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.ogury.p159cm.OguryChoiceManager;
import com.onesignal.shortcutbadger.C4644a;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import com.onesignal.shortcutbadger.p161c.C4646a;
import com.onesignal.shortcutbadger.p161c.C4647b;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class OPPOHomeBader implements C4644a {

    /* renamed from: a */
    private static int f12651a = -1;

    /* renamed from: b */
    private int m16126b() {
        int i;
        int i2 = f12651a;
        if (i2 >= 0) {
            return i2;
        }
        try {
            i = ((Integer) m16123a(m16122a("com.color.os.ColorBuild"), "getColorOSVERSION", (Class[]) null, (Object[]) null)).intValue();
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            try {
                String b = m16127b("ro.build.version.opporom");
                if (b.startsWith("V1.4")) {
                    return 3;
                }
                if (b.startsWith("V2.0")) {
                    return 4;
                }
                if (b.startsWith("V2.1")) {
                    return 5;
                }
            } catch (Exception unused2) {
            }
        }
        f12651a = i;
        return i;
    }

    @TargetApi(11)
    /* renamed from: a */
    public void mo29955a(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        if (i == 0) {
            i = -1;
        }
        Intent intent = new Intent("com.oppo.unsettledevent");
        intent.putExtra("pakeageName", componentName.getPackageName());
        intent.putExtra("number", i);
        intent.putExtra("upgradeNumber", i);
        if (C4646a.m16102a(context, intent)) {
            context.sendBroadcast(intent);
        } else if (m16126b() == 6) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("app_badge_count", i);
                context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
            } catch (Throwable unused) {
                throw new ShortcutBadgeException("unable to resolve intent: " + intent.toString());
            }
        }
    }

    /* renamed from: b */
    private String m16127b(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                C4647b.m16104a((Closeable) bufferedReader);
                return readLine;
            } catch (IOException unused) {
                C4647b.m16104a((Closeable) bufferedReader);
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                C4647b.m16104a((Closeable) bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
            C4647b.m16104a((Closeable) bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            C4647b.m16104a((Closeable) bufferedReader2);
            throw th;
        }
    }

    /* renamed from: a */
    public List<String> mo29954a() {
        return Collections.singletonList("com.oppo.launcher");
    }

    /* renamed from: a */
    private Object m16123a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        Method a;
        if (cls == null || m16125a((Object) str) || (a = m16124a(cls, str, clsArr)) == null) {
            return null;
        }
        a.setAccessible(true);
        try {
            return a.invoke((Object) null, objArr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r3.getSuperclass() != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return m16124a(r3.getSuperclass(), r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        return r3.getMethod(r4, r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.reflect.Method m16124a(java.lang.Class r3, java.lang.String r4, java.lang.Class[] r5) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0028
            boolean r1 = r2.m16125a((java.lang.Object) r4)
            if (r1 == 0) goto L_0x000a
            goto L_0x0028
        L_0x000a:
            r3.getMethods()     // Catch:{ Exception -> 0x0015 }
            r3.getDeclaredMethods()     // Catch:{ Exception -> 0x0015 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0015 }
            return r3
        L_0x0015:
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ Exception -> 0x001a }
            return r3
        L_0x001a:
            java.lang.Class r1 = r3.getSuperclass()
            if (r1 == 0) goto L_0x0028
            java.lang.Class r3 = r3.getSuperclass()
            java.lang.reflect.Method r0 = r2.m16124a((java.lang.Class) r3, (java.lang.String) r4, (java.lang.Class[]) r5)
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.m16124a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* renamed from: a */
    private Class m16122a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m16125a(Object obj) {
        return obj == null || obj.toString().equals("") || obj.toString().trim().equals("null");
    }
}
