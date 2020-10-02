package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.C0725i;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: androidx.core.app.k */
/* compiled from: NotificationCompatJellybean */
class C0735k {

    /* renamed from: a */
    private static final Object f1878a = new Object();

    /* renamed from: b */
    private static Field f1879b;

    /* renamed from: c */
    private static boolean f1880c;

    /* renamed from: a */
    public static SparseArray<Bundle> m2314a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public static Bundle m2311a(Notification notification) {
        synchronized (f1878a) {
            if (f1880c) {
                return null;
            }
            try {
                if (f1879b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1880c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f1879b = declaredField;
                }
                Bundle bundle = (Bundle) f1879b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1879b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f1880c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1880c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Bundle m2310a(Notification.Builder builder, C0725i.C0726a aVar) {
        builder.addAction(aVar.mo3905e(), aVar.mo3910j(), aVar.mo3901a());
        Bundle bundle = new Bundle(aVar.mo3904d());
        if (aVar.mo3907g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", m2315a(aVar.mo3907g()));
        }
        if (aVar.mo3903c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m2315a(aVar.mo3903c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo3902b());
        return bundle;
    }

    /* renamed from: a */
    static Bundle m2312a(C0725i.C0726a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", aVar.mo3905e());
        bundle2.putCharSequence("title", aVar.mo3910j());
        bundle2.putParcelable("actionIntent", aVar.mo3901a());
        if (aVar.mo3904d() != null) {
            bundle = new Bundle(aVar.mo3904d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo3902b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", m2315a(aVar.mo3907g()));
        bundle2.putBoolean("showsUserInterface", aVar.mo3909i());
        bundle2.putInt("semanticAction", aVar.mo3908h());
        return bundle2;
    }

    /* renamed from: a */
    private static Bundle m2313a(C0743m mVar) {
        new Bundle();
        mVar.mo3970a();
        throw null;
    }

    /* renamed from: a */
    private static Bundle[] m2315a(C0743m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[mVarArr.length];
        if (mVarArr.length <= 0) {
            return bundleArr;
        }
        m2313a(mVarArr[0]);
        throw null;
    }
}
