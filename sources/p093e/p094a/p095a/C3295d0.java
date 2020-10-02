package p093e.p094a.p095a;

import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicBoolean;
import p093e.p094a.p095a.p096c1.C3292i;

/* renamed from: e.a.a.d0 */
/* compiled from: InstallReferrer */
public class C3295d0 implements InvocationHandler {

    /* renamed from: a */
    private int f9164a = 3000;

    /* renamed from: b */
    private int f9165b;

    /* renamed from: c */
    private final AtomicBoolean f9166c;

    /* renamed from: d */
    private C3364y f9167d;

    /* renamed from: e */
    private Object f9168e;

    /* renamed from: f */
    private Context f9169f;

    /* renamed from: g */
    private C3292i f9170g;

    /* renamed from: h */
    private final C3298e0 f9171h;

    /* renamed from: i */
    private Object f9172i;

    /* renamed from: e.a.a.d0$a */
    /* compiled from: InstallReferrer */
    class C3296a implements Runnable {
        C3296a() {
        }

        public void run() {
            C3295d0.this.mo19009a();
        }
    }

    public C3295d0(Context context, C3298e0 e0Var) {
        C3364y d = C3309k.m11002d();
        this.f9167d = d;
        this.f9172i = m10944a(context, e0Var, d);
        this.f9169f = context;
        this.f9166c = new AtomicBoolean(false);
        this.f9165b = 0;
        this.f9170g = new C3292i(new C3296a(), "InstallReferrer");
        this.f9171h = e0Var;
    }

    /* renamed from: a */
    private Object m10944a(Context context, C3298e0 e0Var, C3364y yVar) {
        return C3341r0.m11114a("com.adjust.sdk.play.InstallReferrer", new Class[]{Context.class, C3298e0.class, C3364y.class}, context, e0Var, yVar);
    }

    /* renamed from: b */
    private long m10948b(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) C3341r0.m11112a(obj, "getReferrerClickTimestampSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception e) {
            this.f9167d.mo19022c("getReferrerClickTimestampSeconds error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return -1;
        }
    }

    /* renamed from: c */
    private Object m10950c() {
        Object obj = this.f9168e;
        if (obj == null) {
            return null;
        }
        try {
            return C3341r0.m11112a(obj, "getInstallReferrer", (Class[]) null, new Object[0]);
        } catch (Exception e) {
            this.f9167d.mo19022c("getInstallReferrer error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return null;
        }
    }

    /* renamed from: d */
    private Class m10952d() {
        try {
            return Class.forName("e.b.a.a.c");
        } catch (Exception e) {
            this.f9167d.mo19022c("getInstallReferrerStateListenerClass error (%s) from (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return null;
        }
    }

    /* renamed from: e */
    private void m10953e() {
        if (this.f9166c.get()) {
            this.f9167d.mo19023d("Install referrer has already been read", new Object[0]);
            m10949b();
        } else if (this.f9165b + 1 > 2) {
            this.f9167d.mo19023d("Limit number of retry of %d for install referrer surpassed", 2);
        } else {
            long b = this.f9170g.mo19001b();
            if (b > 0) {
                this.f9167d.mo19023d("Already waiting to retry to read install referrer in %d milliseconds", Long.valueOf(b));
                return;
            }
            int i = this.f9165b + 1;
            this.f9165b = i;
            this.f9167d.mo19023d("Retry number %d to connect to install referrer API", Integer.valueOf(i));
            this.f9170g.mo19000a((long) this.f9164a);
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method == null) {
            this.f9167d.mo19022c("InstallReferrer invoke method null", new Object[0]);
            return null;
        }
        String name = method.getName();
        if (name == null) {
            this.f9167d.mo19022c("InstallReferrer invoke method name null", new Object[0]);
            return null;
        }
        this.f9167d.mo19023d("InstallReferrer invoke method name: %s", name);
        if (objArr == null) {
            this.f9167d.mo19021b("InstallReferrer invoke args null", new Object[0]);
            objArr = new Object[0];
        }
        for (Object obj2 : objArr) {
            this.f9167d.mo19023d("InstallReferrer invoke arg: %s", obj2);
        }
        if (name.equals("onInstallReferrerSetupFinished")) {
            if (objArr.length != 1) {
                this.f9167d.mo19022c("InstallReferrer invoke onInstallReferrerSetupFinished args lenght not 1: %d", Integer.valueOf(objArr.length));
                return null;
            }
            Object obj3 = objArr[0];
            if (!(obj3 instanceof Integer)) {
                this.f9167d.mo19022c("InstallReferrer invoke onInstallReferrerSetupFinished arg not int", new Object[0]);
                return null;
            }
            Integer num = (Integer) obj3;
            if (num == null) {
                this.f9167d.mo19022c("InstallReferrer invoke onInstallReferrerSetupFinished responseCode arg is null", new Object[0]);
                return null;
            }
            m10946a(num.intValue());
        } else if (name.equals("onInstallReferrerServiceDisconnected")) {
            this.f9167d.mo19023d("Connection to install referrer service was lost. Retrying ...", new Object[0]);
            m10953e();
        }
        return null;
    }

    /* renamed from: a */
    public void mo19009a() {
        Class d;
        Object a;
        Object obj = this.f9172i;
        if (obj != null) {
            try {
                C3341r0.m11112a(obj, "startConnection", (Class[]) null, new Object[0]);
                return;
            } catch (Exception e) {
                this.f9167d.mo19022c("Call to Play startConnection error: %s", e.getMessage());
            }
        }
        if (C3309k.m11010l()) {
            m10949b();
            if (this.f9166c.get()) {
                this.f9167d.mo19023d("Install referrer has already been read", new Object[0]);
                return;
            }
            Context context = this.f9169f;
            if (context != null) {
                Object a2 = m10943a(context);
                this.f9168e = a2;
                if (a2 != null && (d = m10952d()) != null && (a = m10945a(d)) != null) {
                    m10947a(d, a);
                }
            }
        }
    }

    /* renamed from: b */
    private void m10949b() {
        Object obj = this.f9168e;
        if (obj != null) {
            try {
                C3341r0.m11112a(obj, "endConnection", (Class[]) null, new Object[0]);
                this.f9167d.mo19023d("Install Referrer API connection closed", new Object[0]);
            } catch (Exception e) {
                this.f9167d.mo19022c("closeReferrerClient error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            }
            this.f9168e = null;
        }
    }

    /* renamed from: c */
    private String m10951c(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) C3341r0.m11112a(obj, "getInstallReferrer", (Class[]) null, new Object[0]);
        } catch (Exception e) {
            this.f9167d.mo19022c("getStringInstallReferrer error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return null;
        }
    }

    /* renamed from: a */
    private Object m10943a(Context context) {
        try {
            return C3341r0.m11112a(C3341r0.m11113a("com.android.installreferrer.api.InstallReferrerClient", "newBuilder", new Class[]{Context.class}, context), "build", (Class[]) null, new Object[0]);
        } catch (ClassNotFoundException e) {
            this.f9167d.mo19021b("InstallReferrer not integrated in project (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return null;
        } catch (Exception e2) {
            this.f9167d.mo19022c("createInstallReferrerClient error (%s) from (%s)", e2.getMessage(), e2.getClass().getCanonicalName());
            return null;
        }
    }

    /* renamed from: a */
    private Object m10945a(Class cls) {
        try {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
        } catch (IllegalArgumentException unused) {
            this.f9167d.mo19022c("InstallReferrer proxy violating parameter restrictions", new Object[0]);
            return null;
        } catch (NullPointerException unused2) {
            this.f9167d.mo19022c("Null argument passed to InstallReferrer proxy", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private void m10947a(Class cls, Object obj) {
        try {
            C3341r0.m11112a(this.f9168e, "startConnection", new Class[]{cls}, obj);
        } catch (InvocationTargetException e) {
            if (C3268a1.m10855b((Exception) e)) {
                this.f9167d.mo19022c("InstallReferrer encountered an InvocationTargetException %s", C3268a1.m10831a((Exception) e));
            }
        } catch (Exception e2) {
            this.f9167d.mo19022c("startConnection error (%s) thrown by (%s)", e2.getMessage(), e2.getClass().getCanonicalName());
        }
    }

    /* renamed from: a */
    private void m10946a(int i) {
        boolean z = true;
        if (i != -1) {
            if (i == 0) {
                try {
                    Object c = m10950c();
                    String c2 = m10951c(c);
                    long b = m10948b(c);
                    long a = m10942a(c);
                    this.f9167d.mo19023d("installReferrer: %s, clickTime: %d, installBeginTime: %d", c2, Long.valueOf(b), Long.valueOf(a));
                    this.f9167d.mo19023d("Install Referrer read successfully. Closing connection", new Object[0]);
                    this.f9171h.mo18940a(c2, b, a);
                    this.f9166c.set(true);
                } catch (Exception e) {
                    this.f9167d.mo19021b("Couldn't get install referrer from client (%s). Retrying...", e.getMessage());
                }
            } else if (i == 1) {
                this.f9167d.mo19023d("Could not initiate connection to the Install Referrer service. Retrying...", new Object[0]);
            } else if (i == 2) {
                this.f9167d.mo19023d("Install Referrer API not supported by the installed Play Store app. Closing connection", new Object[0]);
            } else if (i != 3) {
                this.f9167d.mo19023d("Unexpected response code of install referrer response: %d. Closing connection", Integer.valueOf(i));
            } else {
                this.f9167d.mo19023d("Install Referrer API general errors caused by incorrect usage. Retrying...", new Object[0]);
            }
            z = false;
        } else {
            this.f9167d.mo19023d("Play Store service is not connected now. Retrying...", new Object[0]);
        }
        if (z) {
            m10953e();
        } else {
            m10949b();
        }
    }

    /* renamed from: a */
    private long m10942a(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) C3341r0.m11112a(obj, "getInstallBeginTimestampSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception e) {
            this.f9167d.mo19022c("getInstallBeginTimestampSeconds error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return -1;
        }
    }
}
