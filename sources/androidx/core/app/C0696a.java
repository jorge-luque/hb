package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.core.app.C0744n;
import androidx.core.content.C0768a;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.core.app.a */
/* compiled from: ActivityCompat */
public class C0696a extends C0768a {

    /* renamed from: c */
    private static C0699c f1756c;

    /* renamed from: androidx.core.app.a$a */
    /* compiled from: ActivityCompat */
    static class C0697a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String[] f1757a;

        /* renamed from: b */
        final /* synthetic */ Activity f1758b;

        /* renamed from: c */
        final /* synthetic */ int f1759c;

        C0697a(String[] strArr, Activity activity, int i) {
            this.f1757a = strArr;
            this.f1758b = activity;
            this.f1759c = i;
        }

        public void run() {
            int[] iArr = new int[this.f1757a.length];
            PackageManager packageManager = this.f1758b.getPackageManager();
            String packageName = this.f1758b.getPackageName();
            int length = this.f1757a.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f1757a[i], packageName);
            }
            ((C0698b) this.f1758b).onRequestPermissionsResult(this.f1759c, this.f1757a, iArr);
        }
    }

    /* renamed from: androidx.core.app.a$b */
    /* compiled from: ActivityCompat */
    public interface C0698b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: androidx.core.app.a$c */
    /* compiled from: ActivityCompat */
    public interface C0699c {
        /* renamed from: a */
        boolean mo3851a(Activity activity, String[] strArr, int i);

        boolean onActivityResult(Activity activity, int i, int i2, Intent intent);
    }

    /* renamed from: androidx.core.app.a$d */
    /* compiled from: ActivityCompat */
    public interface C0700d {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* renamed from: androidx.core.app.a$e */
    /* compiled from: ActivityCompat */
    private static class C0701e extends SharedElementCallback {

        /* renamed from: a */
        private final C0744n f1760a;

        /* renamed from: androidx.core.app.a$e$a */
        /* compiled from: ActivityCompat */
        class C0702a implements C0744n.C0745a {
            C0702a(C0701e eVar, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            }
        }

        C0701e(C0744n nVar) {
            this.f1760a = nVar;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f1760a.mo3971a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f1760a.mo3972a(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f1760a.mo3976a(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f1760a.mo3973a(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f1760a.mo3975a(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f1760a.mo3977b(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f1760a.mo3974a(list, list2, (C0744n.C0745a) new C0702a(this, onSharedElementsReadyListener));
        }
    }

    /* renamed from: a */
    public static C0699c m2189a() {
        return f1756c;
    }

    /* renamed from: b */
    public static void m2196b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    /* renamed from: c */
    public static void m2198c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    /* renamed from: d */
    public static void m2199d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else if (!C0703b.m2204a(activity)) {
            activity.recreate();
        }
    }

    /* renamed from: e */
    public static void m2200e(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    /* renamed from: a */
    public static void m2191a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    /* renamed from: b */
    public static void m2197b(Activity activity, C0744n nVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(nVar != null ? new C0701e(nVar) : null);
        }
    }

    /* renamed from: a */
    public static void m2192a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m2190a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* renamed from: a */
    public static void m2193a(Activity activity, C0744n nVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(nVar != null ? new C0701e(nVar) : null);
        }
    }

    /* renamed from: a */
    public static void m2194a(Activity activity, String[] strArr, int i) {
        C0699c cVar = f1756c;
        if (cVar != null && cVar.mo3851a(activity, strArr, i)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof C0700d) {
                ((C0700d) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof C0698b) {
            new Handler(Looper.getMainLooper()).post(new C0697a(strArr, activity, i));
        }
    }

    /* renamed from: a */
    public static boolean m2195a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
