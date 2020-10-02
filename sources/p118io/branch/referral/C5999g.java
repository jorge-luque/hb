package p118io.branch.referral;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/* renamed from: io.branch.referral.g */
/* compiled from: BranchStrongMatchHelper */
class C5999g {

    /* renamed from: j */
    private static C5999g f15345j = null;

    /* renamed from: k */
    private static int f15346k = 750;

    /* renamed from: a */
    Object f15347a = null;

    /* renamed from: b */
    private final Handler f15348b;

    /* renamed from: c */
    private boolean f15349c = true;

    /* renamed from: d */
    boolean f15350d = false;

    /* renamed from: e */
    Class<?> f15351e;

    /* renamed from: f */
    Class<?> f15352f;

    /* renamed from: g */
    Class<?> f15353g;

    /* renamed from: h */
    Class<?> f15354h;

    /* renamed from: i */
    Class<?> f15355i;

    /* renamed from: io.branch.referral.g$a */
    /* compiled from: BranchStrongMatchHelper */
    class C6000a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C6004e f15356a;

        C6000a(C6004e eVar) {
            this.f15356a = eVar;
        }

        public void run() {
            C5999g gVar = C5999g.this;
            gVar.m19275a(this.f15356a, gVar.f15350d);
        }
    }

    /* renamed from: io.branch.referral.g$b */
    /* compiled from: BranchStrongMatchHelper */
    class C6001b extends C6003d {

        /* renamed from: b */
        final /* synthetic */ Method f15358b;

        /* renamed from: c */
        final /* synthetic */ Method f15359c;

        /* renamed from: d */
        final /* synthetic */ Uri f15360d;

        /* renamed from: e */
        final /* synthetic */ Method f15361e;

        /* renamed from: f */
        final /* synthetic */ C6035q f15362f;

        /* renamed from: g */
        final /* synthetic */ C6004e f15363g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6001b(Method method, Method method2, Uri uri, Method method3, C6035q qVar, C6004e eVar) {
            super();
            this.f15358b = method;
            this.f15359c = method2;
            this.f15360d = uri;
            this.f15361e = method3;
            this.f15362f = qVar;
            this.f15363g = eVar;
        }

        /* renamed from: a */
        public void mo33865a(ComponentName componentName, Object obj) {
            C5999g gVar = C5999g.this;
            gVar.f15347a = gVar.f15351e.cast(obj);
            Object obj2 = C5999g.this.f15347a;
            if (obj2 != null) {
                try {
                    this.f15358b.invoke(obj2, new Object[]{0});
                    Object invoke = this.f15359c.invoke(C5999g.this.f15347a, new Object[]{null});
                    if (invoke != null) {
                        C6035q.m19397b("BranchSDK", "Strong match request " + this.f15360d);
                        this.f15361e.invoke(invoke, new Object[]{this.f15360d, null, null});
                        this.f15362f.mo33949a(System.currentTimeMillis());
                        C5999g.this.f15350d = true;
                    }
                } catch (Throwable unused) {
                    C5999g gVar2 = C5999g.this;
                    gVar2.f15347a = null;
                    gVar2.m19275a(this.f15363g, gVar2.f15350d);
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C5999g gVar = C5999g.this;
            gVar.f15347a = null;
            gVar.m19275a(this.f15363g, gVar.f15350d);
        }
    }

    /* renamed from: io.branch.referral.g$c */
    /* compiled from: BranchStrongMatchHelper */
    class C6002c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C6004e f15365a;

        C6002c(C5999g gVar, C6004e eVar) {
            this.f15365a = eVar;
        }

        public void run() {
            this.f15365a.mo19641a();
        }
    }

    /* renamed from: io.branch.referral.g$d */
    /* compiled from: BranchStrongMatchHelper */
    private abstract class C6003d implements ServiceConnection {
        public C6003d() {
        }

        /* renamed from: a */
        public abstract void mo33865a(ComponentName componentName, Object obj);

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Constructor<?> declaredConstructor = C5999g.this.f15351e.getDeclaredConstructor(new Class[]{C5999g.this.f15355i, ComponentName.class});
                declaredConstructor.setAccessible(true);
                mo33865a(componentName, declaredConstructor.newInstance(new Object[]{Class.forName("android.support.customtabs.ICustomTabsService$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder}), componentName}));
            } catch (Throwable unused) {
                mo33865a((ComponentName) null, (Object) null);
            }
        }
    }

    /* renamed from: io.branch.referral.g$e */
    /* compiled from: BranchStrongMatchHelper */
    interface C6004e {
        /* renamed from: a */
        void mo19641a();
    }

    private C5999g() {
        try {
            this.f15351e = Class.forName("androidx.browser.a.c");
            this.f15352f = Class.forName("androidx.browser.a.e");
            this.f15353g = Class.forName("androidx.browser.a.b");
            this.f15354h = Class.forName("androidx.browser.a.f");
            this.f15355i = Class.forName("android.support.customtabs.ICustomTabsService");
        } catch (Throwable unused) {
            this.f15349c = false;
        }
        this.f15348b = new Handler();
    }

    /* renamed from: a */
    public static C5999g m19274a() {
        if (f15345j == null) {
            f15345j = new C5999g();
        }
        return f15345j;
    }

    /* renamed from: a */
    public void mo33863a(Context context, String str, C6033o oVar, C6035q qVar, C6005g0 g0Var, C6004e eVar) {
        C6004e eVar2 = eVar;
        this.f15350d = false;
        if (System.currentTimeMillis() - qVar.mo33999u() < 2592000000L) {
            m19275a(eVar2, this.f15350d);
        } else if (!this.f15349c) {
            m19275a(eVar2, this.f15350d);
        } else {
            try {
                if (oVar.mo33933b() != null) {
                    Uri a = m19273a(str, oVar, qVar, g0Var, context);
                    if (a != null) {
                        this.f15348b.postDelayed(new C6000a(eVar2), 500);
                        this.f15351e.getMethod("bindCustomTabsService", new Class[]{Context.class, String.class, this.f15352f});
                        Method method = this.f15351e.getMethod("warmup", new Class[]{Long.TYPE});
                        Method method2 = this.f15351e.getMethod("newSession", new Class[]{this.f15353g});
                        Method method3 = this.f15354h.getMethod("mayLaunchUrl", new Class[]{Uri.class, Bundle.class, List.class});
                        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
                        intent.setPackage("com.android.chrome");
                        Context context2 = context;
                        context.bindService(intent, new C6001b(method, method2, a, method3, qVar, eVar), 33);
                        return;
                    }
                    m19275a(eVar2, this.f15350d);
                    return;
                }
                m19275a(eVar2, this.f15350d);
            } catch (Throwable unused) {
                m19275a(eVar2, this.f15350d);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19275a(C6004e eVar, boolean z) {
        if (eVar == null) {
            return;
        }
        if (z) {
            new Handler().postDelayed(new C6002c(this, eVar), (long) f15346k);
        } else {
            eVar.mo19641a();
        }
    }

    /* renamed from: a */
    private Uri m19273a(String str, C6033o oVar, C6035q qVar, C6005g0 g0Var, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = ("https://" + str + "/_strong_match?os=" + oVar.mo33934c()) + "&" + C6028l.HardwareID.mo33920a() + "=" + oVar.mo33933b();
        String str3 = str2 + "&" + C6028l.HardwareIDType.mo33920a() + "=" + (oVar.mo33935d() ? C6028l.HardwareIDTypeVendor : C6028l.HardwareIDTypeRandom).mo33920a();
        if (C6005g0.f15367d != null && !C6010i.m19310a(context)) {
            str3 = str3 + "&" + C6028l.GoogleAdvertisingID.mo33920a() + "=" + C6005g0.f15367d;
        }
        if (!qVar.mo33975i().equals("bnc_no_value")) {
            str3 = str3 + "&" + C6028l.DeviceFingerprintID.mo33920a() + "=" + qVar.mo33975i();
        }
        if (!oVar.mo33930a().equals("bnc_no_value")) {
            str3 = str3 + "&" + C6028l.AppVersion.mo33920a() + "=" + oVar.mo33930a();
        }
        if (!qVar.mo33973h().equals("bnc_no_value")) {
            str3 = str3 + "&" + C6028l.BranchKey.mo33920a() + "=" + qVar.mo33973h();
        }
        return Uri.parse(str3 + "&sdk=android2.19.5");
    }
}
