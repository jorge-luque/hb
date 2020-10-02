package com.tapjoy.internal;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.plus.PlusShare;
import com.tapjoy.internal.C5230ji;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tapjoy.internal.jk */
final class C5236jk {

    /* renamed from: a */
    private static final Object f14407a = new Object();

    /* renamed from: b */
    private static Field f14408b;

    /* renamed from: c */
    private static boolean f14409c;

    /* renamed from: d */
    private static final Object f14410d = new Object();

    /* renamed from: a */
    public static SparseArray m17604a(List list) {
        int size = list.size();
        SparseArray sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public static Bundle m17603a(Notification notification) {
        synchronized (f14407a) {
            if (f14409c) {
                return null;
            }
            try {
                if (f14408b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f14409c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f14408b = declaredField;
                }
                Bundle bundle = (Bundle) f14408b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f14408b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f14409c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f14409c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    private static Bundle[] m17605a(C5237jl[] jlVarArr) {
        if (jlVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[jlVarArr.length];
        for (int i = 0; i < jlVarArr.length; i++) {
            C5237jl jlVar = jlVarArr[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", jlVar.f14411a);
            bundle.putCharSequence(PlusShare.KEY_CALL_TO_ACTION_LABEL, jlVar.f14412b);
            bundle.putCharSequenceArray("choices", jlVar.f14413c);
            bundle.putBoolean("allowFreeFormInput", jlVar.f14414d);
            bundle.putBundle("extras", jlVar.f14415e);
            Set<String> set = jlVar.f14416f;
            if (set != null && !set.isEmpty()) {
                ArrayList arrayList = new ArrayList(set.size());
                for (String add : set) {
                    arrayList.add(add);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i] = bundle;
        }
        return bundleArr;
    }

    /* renamed from: a */
    public static Bundle m17602a(Notification.Builder builder, C5230ji.C5231a aVar) {
        builder.addAction(aVar.f14351e, aVar.f14352f, aVar.f14353g);
        Bundle bundle = new Bundle(aVar.f14347a);
        C5237jl[] jlVarArr = aVar.f14348b;
        if (jlVarArr != null) {
            bundle.putParcelableArray("android.support.remoteInputs", m17605a(jlVarArr));
        }
        C5237jl[] jlVarArr2 = aVar.f14349c;
        if (jlVarArr2 != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m17605a(jlVarArr2));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f14350d);
        return bundle;
    }
}
