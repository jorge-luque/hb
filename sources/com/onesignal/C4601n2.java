package com.onesignal;

import android.content.Context;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.ProductDataResponse;
import com.onesignal.C4564n1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.onesignal.n2 */
/* compiled from: TrackAmazonPurchase */
class C4601n2 {

    /* renamed from: a */
    private Context f12558a;

    /* renamed from: b */
    private boolean f12559b = false;

    /* renamed from: c */
    private C4603b f12560c;

    /* renamed from: d */
    private Object f12561d;

    /* renamed from: e */
    private Field f12562e;

    /* renamed from: com.onesignal.n2$a */
    /* compiled from: TrackAmazonPurchase */
    static /* synthetic */ class C4602a {

        /* renamed from: a */
        static final /* synthetic */ int[] f12563a;

        static {
            int[] iArr = new int[ProductDataResponse.RequestStatus.values().length];
            f12563a = iArr;
            try {
                iArr[ProductDataResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: com.onesignal.n2$b */
    /* compiled from: TrackAmazonPurchase */
    private class C4603b implements PurchasingListener {

        /* renamed from: a */
        PurchasingListener f12564a;

        private C4603b(C4601n2 n2Var) {
        }

        /* synthetic */ C4603b(C4601n2 n2Var, C4602a aVar) {
            this(n2Var);
        }
    }

    C4601n2(Context context) {
        this.f12558a = context;
        try {
            Class<?> cls = Class.forName("com.amazon.device.iap.internal.d");
            this.f12561d = cls.getMethod("d", new Class[0]).invoke((Object) null, new Object[0]);
            Field declaredField = cls.getDeclaredField("f");
            this.f12562e = declaredField;
            declaredField.setAccessible(true);
            this.f12560c = new C4603b(this, (C4602a) null);
            PurchasingListener purchasingListener = (PurchasingListener) this.f12562e.get(this.f12561d);
            this.f12559b = true;
            m15911b();
        } catch (ClassNotFoundException e) {
            m15910a(e);
        } catch (IllegalAccessException e2) {
            m15910a(e2);
        } catch (InvocationTargetException e3) {
            m15910a(e3);
        } catch (NoSuchMethodException e4) {
            m15910a(e4);
        } catch (NoSuchFieldException e5) {
            m15910a(e5);
        }
    }

    /* renamed from: a */
    private static void m15910a(Exception exc) {
        C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Error adding Amazon IAP listener.", (Throwable) exc);
        exc.printStackTrace();
    }

    /* renamed from: b */
    private void m15911b() {
        PurchasingService.registerListener(this.f12558a, this.f12560c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29890a() {
        if (this.f12559b) {
            try {
                C4603b bVar = (PurchasingListener) this.f12562e.get(this.f12561d);
                if (bVar != this.f12560c) {
                    this.f12560c.f12564a = bVar;
                    m15911b();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
