package p118io.branch.referral;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.ogury.p159cm.OguryChoiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.indexing.C5975a;
import p118io.branch.referral.C5999g;
import p118io.branch.referral.C6005g0;
import p118io.branch.referral.C6014j;
import p118io.branch.referral.C6025k;
import p118io.branch.referral.C6036r;
import p118io.branch.referral.InstallListener;
import p118io.branch.referral.network.BranchRemoteInterface;

/* renamed from: io.branch.referral.b */
/* compiled from: Branch */
public class C3555b implements C6014j.C3571d, C6005g0.C3570a, InstallListener.C3554b {

    /* renamed from: A */
    private static boolean f9966A = false;

    /* renamed from: B */
    static boolean f9967B = false;

    /* renamed from: C */
    static Boolean f9968C = null;

    /* renamed from: D */
    static boolean f9969D = false;

    /* renamed from: E */
    static boolean f9970E = true;

    /* renamed from: F */
    private static long f9971F = 1500;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public static C3555b f9972G = null;

    /* renamed from: H */
    private static boolean f9973H = false;

    /* renamed from: I */
    private static boolean f9974I = false;

    /* renamed from: J */
    private static C3564i f9975J = C3564i.USE_DEFAULT;

    /* renamed from: K */
    private static String f9976K = "app.link";

    /* renamed from: L */
    private static final String[] f9977L = {"extra_launch_uri", "branch_intent"};

    /* renamed from: M */
    private static boolean f9978M = true;

    /* renamed from: a */
    private JSONObject f9979a;

    /* renamed from: b */
    private boolean f9980b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BranchRemoteInterface f9981c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C6035q f9982d;

    /* renamed from: e */
    private final C6005g0 f9983e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f9984f;

    /* renamed from: g */
    private Semaphore f9985g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C6052z f9986h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f9987i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f9988j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Map<C5995e, String> f9989k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C3566k f9990l = C3566k.PENDING;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f9991m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C3568m f9992n = C3568m.UNINITIALISED;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C5998f0 f9993o;

    /* renamed from: p */
    WeakReference<Activity> f9994p;

    /* renamed from: q */
    boolean f9995q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final ConcurrentHashMap<String, String> f9996r;

    /* renamed from: s */
    private boolean f9997s = false;

    /* renamed from: t */
    String f9998t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public CountDownLatch f9999u = null;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public CountDownLatch f10000v = null;

    /* renamed from: w */
    private boolean f10001w = false;

    /* renamed from: x */
    boolean f10002x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f10003y = false;

    /* renamed from: z */
    private final C6009h0 f10004z;

    /* renamed from: io.branch.referral.b$a */
    /* compiled from: Branch */
    class C3556a implements C6025k.C6027b {
        C3556a() {
        }

        /* renamed from: a */
        public void mo19640a(String str) {
            C3555b.this.f9982d.mo33950a((Boolean) true);
            if (str != null) {
                String queryParameter = Uri.parse(str).getQueryParameter(C6028l.LinkClickID.mo33920a());
                if (!TextUtils.isEmpty(queryParameter)) {
                    C3555b.this.f9982d.mo33998t(queryParameter);
                }
            }
            C3555b.this.f9986h.mo34063a(C6036r.C6038b.FB_APP_LINK_WAIT_LOCK);
            C3555b.this.m12046r();
        }
    }

    /* renamed from: io.branch.referral.b$b */
    /* compiled from: Branch */
    class C3557b implements C5999g.C6004e {
        C3557b() {
        }

        /* renamed from: a */
        public void mo19641a() {
            C3555b.this.f9986h.mo34063a(C6036r.C6038b.STRONG_MATCH_PENDING_WAIT_LOCK);
            C3555b.this.m12046r();
        }
    }

    /* renamed from: io.branch.referral.b$d */
    /* compiled from: Branch */
    public interface C3559d {
        /* renamed from: a */
        void mo19649a(String str, C5993d dVar);
    }

    /* renamed from: io.branch.referral.b$e */
    /* compiled from: Branch */
    public interface C3560e {
        /* renamed from: a */
        void mo19650a(JSONArray jSONArray, C5993d dVar);
    }

    /* renamed from: io.branch.referral.b$g */
    /* compiled from: Branch */
    public interface C3562g {
        /* renamed from: a */
        void mo19656a(JSONObject jSONObject, C5993d dVar);
    }

    /* renamed from: io.branch.referral.b$h */
    /* compiled from: Branch */
    public interface C3563h {
        /* renamed from: a */
        void mo19657a(boolean z, C5993d dVar);
    }

    /* renamed from: io.branch.referral.b$i */
    /* compiled from: Branch */
    private enum C3564i {
        USE_DEFAULT,
        REFERRABLE,
        NON_REFERRABLE;

        static {
            USE_DEFAULT = new C3564i("USE_DEFAULT", 0);
            REFERRABLE = new C3564i("REFERRABLE", 1);
            NON_REFERRABLE = new C3564i("NON_REFERRABLE", 2);
        }
    }

    /* renamed from: io.branch.referral.b$j */
    /* compiled from: Branch */
    public interface C3565j {
        /* renamed from: a */
        boolean mo19658a();
    }

    /* renamed from: io.branch.referral.b$k */
    /* compiled from: Branch */
    private enum C3566k {
        PENDING,
        READY;

        static {
            PENDING = new C3566k("PENDING", 0);
            READY = new C3566k("READY", 1);
        }
    }

    /* renamed from: io.branch.referral.b$l */
    /* compiled from: Branch */
    public interface C3567l {
        /* renamed from: a */
        void mo19659a(boolean z, C5993d dVar);
    }

    /* renamed from: io.branch.referral.b$m */
    /* compiled from: Branch */
    private enum C3568m {
        INITIALISED,
        INITIALISING,
        UNINITIALISED;

        static {
            INITIALISED = new C3568m("INITIALISED", 0);
            INITIALISING = new C3568m("INITIALISING", 1);
            UNINITIALISED = new C3568m("UNINITIALISED", 2);
        }
    }

    /* renamed from: io.branch.referral.b$n */
    /* compiled from: Branch */
    private class C3569n extends AsyncTask<C6036r, Void, C5996e0> {
        private C3569n() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C5996e0 doInBackground(C6036r... rVarArr) {
            BranchRemoteInterface c = C3555b.this.f9981c;
            JSONObject f = rVarArr[0].mo34020f();
            return c.mo33927a(f, C3555b.this.f9982d.mo33964d() + "v1/url", C6030n.GetURL.mo33924a(), C3555b.this.f9982d.mo33973h());
        }

        /* synthetic */ C3569n(C3555b bVar, C3556a aVar) {
            this();
        }
    }

    private C3555b(Context context) {
        this.f9982d = C6035q.m19395a(context);
        this.f10004z = new C6009h0(context);
        this.f9981c = BranchRemoteInterface.m19364a(context);
        this.f9983e = new C6005g0(context);
        this.f9986h = C6052z.m19581a(context);
        this.f9985g = new Semaphore(1);
        this.f9987i = 0;
        this.f9988j = true;
        this.f9989k = new HashMap();
        this.f9996r = new ConcurrentHashMap<>();
        if (!this.f10004z.mo33892a()) {
            this.f9997s = this.f9983e.mo33871a((C6005g0.C3570a) this);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            this.f9991m = true;
            this.f9990l = C3566k.PENDING;
            return;
        }
        this.f9991m = false;
        this.f9990l = C3566k.READY;
    }

    /* renamed from: p */
    public static boolean m12044p() {
        return f9969D;
    }

    /* renamed from: q */
    private void m12045q() {
        if (!this.f10004z.mo33892a()) {
            C6033o a = C6033o.m19379a(this.f9982d.mo33978j(), this.f9983e, f9966A);
            WeakReference<Activity> weakReference = this.f9994p;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            Context applicationContext = activity != null ? activity.getApplicationContext() : null;
            if (applicationContext != null) {
                this.f9986h.mo34073g();
                C5999g.m19274a().mo33863a(applicationContext, f9976K, a, this.f9982d, this.f9983e, new C3557b());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m12046r() {
        try {
            this.f9985g.acquire();
            if (this.f9987i != 0 || this.f9986h.mo34071e() <= 0) {
                this.f9985g.release();
                return;
            }
            this.f9987i = 1;
            C6036r f = this.f9986h.mo34072f();
            this.f9985g.release();
            if (f == null) {
                this.f9986h.mo34068b((C6036r) null);
            } else if (f.mo34025m()) {
                this.f9987i = 0;
            } else if (!(f instanceof C5992c0) && !m12041n()) {
                this.f9987i = 0;
                m11995a(this.f9986h.mo34071e() - 1, -101);
            } else if ((f instanceof C6050x) || (m12038m() && m12037l())) {
                new C3561f(f).mo33821a(new Void[0]);
            } else {
                this.f9987i = 0;
                m11995a(this.f9986h.mo34071e() - 1, -101);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m12047s() {
        JSONObject f;
        int i = 0;
        while (i < this.f9986h.mo34071e()) {
            try {
                C6036r a = this.f9986h.mo34060a(i);
                if (!(a == null || (f = a.mo34020f()) == null)) {
                    if (f.has(C6028l.SessionID.mo33920a())) {
                        a.mo34020f().put(C6028l.SessionID.mo33920a(), this.f9982d.mo33938B());
                    }
                    if (f.has(C6028l.IdentityID.mo33920a())) {
                        a.mo34020f().put(C6028l.IdentityID.mo33920a(), this.f9982d.mo33989p());
                    }
                    if (f.has(C6028l.DeviceFingerprintID.mo33920a())) {
                        a.mo34020f().put(C6028l.DeviceFingerprintID.mo33920a(), this.f9982d.mo33975i());
                    }
                }
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: c */
    public void mo19634c(String str, String str2) {
    }

    @TargetApi(14)
    /* renamed from: io.branch.referral.b$c */
    /* compiled from: Branch */
    private class C3558c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        private int f10007a;

        private C3558c() {
            this.f10007a = 0;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            C3555b bVar = C3555b.this;
            C3566k unused = bVar.f9990l = bVar.f9991m ? C3566k.PENDING : C3566k.READY;
            boolean unused2 = C3555b.this.f10003y = true;
            if (C6014j.m19321a().mo33900a(activity.getApplicationContext())) {
                C6014j.m19321a().mo33903b((Context) activity);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference = C3555b.this.f9994p;
            if (weakReference != null && weakReference.get() == activity) {
                C3555b.this.f9994p.clear();
            }
            C6014j.m19321a().mo33899a(activity);
        }

        public void onActivityPaused(Activity activity) {
            if (C3555b.this.f9993o != null) {
                C3555b.this.f9993o.mo33862a(true);
                throw null;
            }
        }

        public void onActivityResumed(Activity activity) {
            if (C3555b.this.m12006a(activity.getIntent())) {
                C3568m unused = C3555b.this.f9992n = C3568m.UNINITIALISED;
                C3555b.this.m12020c(activity);
            }
            C3555b.this.f9994p = new WeakReference<>(activity);
            if (C3555b.this.f9991m) {
                C3566k unused2 = C3555b.this.f9990l = C3566k.READY;
                C3555b.this.m11996a(activity, (activity.getIntent() == null || C3555b.this.f9992n == C3568m.INITIALISED) ? false : true);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            C3555b bVar = C3555b.this;
            C3566k unused = bVar.f9990l = bVar.f9991m ? C3566k.PENDING : C3566k.READY;
            if (C3555b.this.f9992n == C3568m.INITIALISED) {
                try {
                    C5975a.m19150a().mo33794a(activity, C3555b.this.f9998t);
                } catch (Exception unused2) {
                }
            }
            if (this.f10007a < 1) {
                if (C3555b.this.f9992n == C3568m.INITIALISED) {
                    C3568m unused3 = C3555b.this.f9992n = C3568m.UNINITIALISED;
                }
                if (C6010i.m19310a(C3555b.this.f9984f)) {
                    C3555b.this.f9982d.mo33944H();
                }
                C3555b.this.m12020c(activity);
            } else if (C3555b.this.m12006a(activity.getIntent())) {
                C3568m unused4 = C3555b.this.f9992n = C3568m.UNINITIALISED;
                C3555b.this.m12020c(activity);
            }
            this.f10007a++;
            boolean unused5 = C3555b.this.f10003y = false;
        }

        public void onActivityStopped(Activity activity) {
            C5975a.m19150a().mo33793a(activity);
            int i = this.f10007a - 1;
            this.f10007a = i;
            if (i < 1) {
                C3555b bVar = C3555b.this;
                bVar.f10002x = false;
                bVar.mo19633c();
            }
        }

        /* synthetic */ C3558c(C3555b bVar, C3556a aVar) {
            this();
        }
    }

    /* renamed from: c */
    private boolean m12022c(C3562g gVar) {
        if (gVar != null) {
            if (!f9973H) {
                gVar.mo19656a(new JSONObject(), (C5993d) null);
            } else if (!this.f9995q) {
                gVar.mo19656a(mo19637e(), (C5993d) null);
                this.f9995q = true;
            } else {
                gVar.mo19656a(new JSONObject(), (C5993d) null);
            }
        }
        return this.f9995q;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m12030i() {
        ActivityInfo activityInfo;
        JSONObject e = mo19637e();
        String str = null;
        try {
            if (!e.has(C6028l.Clicked_Branch_Link.mo33920a())) {
                return;
            }
            if (e.getBoolean(C6028l.Clicked_Branch_Link.mo33920a())) {
                if (e.length() > 0) {
                    ApplicationInfo applicationInfo = this.f9984f.getPackageManager().getApplicationInfo(this.f9984f.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                    int i = 0;
                    if (applicationInfo.metaData == null || !applicationInfo.metaData.getBoolean("io.branch.sdk.auto_link_disable", false)) {
                        ActivityInfo[] activityInfoArr = this.f9984f.getPackageManager().getPackageInfo(this.f9984f.getPackageName(), 129).activities;
                        int i2 = 1501;
                        if (activityInfoArr != null) {
                            int length = activityInfoArr.length;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                activityInfo = activityInfoArr[i];
                                if (activityInfo == null || activityInfo.metaData == null || ((activityInfo.metaData.getString("io.branch.sdk.auto_link_keys") == null && activityInfo.metaData.getString("io.branch.sdk.auto_link_path") == null) || (!m12009a(e, activityInfo) && !m12018b(e, activityInfo)))) {
                                    i++;
                                }
                            }
                            str = activityInfo.name;
                            i2 = activityInfo.metaData.getInt("io.branch.sdk.auto_link_request_code", 1501);
                        }
                        if (str != null && this.f9994p != null) {
                            Activity activity = (Activity) this.f9994p.get();
                            if (activity != null) {
                                Intent intent = new Intent(activity, Class.forName(str));
                                intent.putExtra("io.branch.sdk.auto_linked", "true");
                                intent.putExtra(C6028l.ReferringData.mo33920a(), e.toString());
                                Iterator<String> keys = e.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    intent.putExtra(next, e.getString(next));
                                }
                                activity.startActivityForResult(intent, i2);
                                return;
                            }
                            Log.w("BranchSDK", "No activity reference to launch deep linked activity");
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        } catch (ClassNotFoundException unused2) {
            "Branch Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity " + null;
        }
    }

    /* renamed from: j */
    private void m12033j() {
        if (this.f9992n != C3568m.UNINITIALISED) {
            if (!this.f9988j) {
                C6036r f = this.f9986h.mo34072f();
                if ((f != null && (f instanceof C5992c0)) || (f instanceof C5994d0)) {
                    this.f9986h.mo34070d();
                }
            } else if (!this.f9986h.mo34067b()) {
                mo19626a((C6036r) new C5990b0(this.f9984f));
            }
            this.f9992n = C3568m.UNINITIALISED;
        }
    }

    @TargetApi(14)
    /* renamed from: k */
    public static C3555b m12034k() {
        if (f9972G == null) {
            Log.e("BranchSDK", "Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]");
        } else if (f9973H && !f9974I) {
            Log.e("BranchSDK", "Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()");
        }
        return f9972G;
    }

    /* renamed from: l */
    private boolean m12037l() {
        return !this.f9982d.mo33975i().equals("bnc_no_value");
    }

    /* renamed from: m */
    private boolean m12038m() {
        return !this.f9982d.mo33938B().equals("bnc_no_value");
    }

    /* renamed from: n */
    private boolean m12041n() {
        return !this.f9982d.mo33989p().equals("bnc_no_value");
    }

    /* renamed from: o */
    public static boolean m12043o() {
        return f9966A;
    }

    /* renamed from: d */
    public JSONObject mo19635d() {
        JSONObject a = m11993a(this.f9982d.mo33993r());
        m11994a(a);
        return a;
    }

    /* renamed from: e */
    public JSONObject mo19637e() {
        JSONObject a = m11993a(this.f9982d.mo33939C());
        m11994a(a);
        return a;
    }

    /* renamed from: f */
    public boolean mo19638f() {
        return this.f10004z.mo33892a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo19639g() {
        C6011i0.m19314b(this.f9984f).mo33894a(this.f9984f);
    }

    /* renamed from: b */
    private static C3555b m12010b(Context context) {
        return new C3555b(context.getApplicationContext());
    }

    /* renamed from: b */
    private boolean m12016b(Uri uri, Activity activity) {
        String str;
        String string;
        if (!f9978M && !((this.f9990l != C3566k.READY && !this.f10003y) || activity == null || activity.getIntent() == null || this.f9992n == C3568m.INITIALISED || m12006a(activity.getIntent()))) {
            Intent intent = activity.getIntent();
            if (intent.getData() == null || (!this.f10003y && m12015b(activity))) {
                if (!this.f9982d.mo33993r().equals("bnc_no_value")) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(C6028l.Clicked_Branch_Link.mo33920a(), false);
                        jSONObject.put(C6028l.IsFirstSession.mo33920a(), false);
                        this.f9982d.mo34004w(jSONObject.toString());
                        this.f10002x = true;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (!TextUtils.isEmpty(intent.getStringExtra(C6028l.BranchData.mo33920a()))) {
                try {
                    JSONObject jSONObject2 = new JSONObject(intent.getStringExtra(C6028l.BranchData.mo33920a()));
                    jSONObject2.put(C6028l.Clicked_Branch_Link.mo33920a(), true);
                    this.f9982d.mo34004w(jSONObject2.toString());
                    this.f10002x = true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                intent.removeExtra(C6028l.BranchData.mo33920a());
                activity.setIntent(intent);
            } else if (uri.getQueryParameterNames() != null && Boolean.valueOf(uri.getQueryParameter(C6028l.Instant.mo33920a())).booleanValue()) {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    for (String next : uri.getQueryParameterNames()) {
                        jSONObject3.put(next, uri.getQueryParameter(next));
                    }
                    jSONObject3.put(C6028l.Clicked_Branch_Link.mo33920a(), true);
                    this.f9982d.mo34004w(jSONObject3.toString());
                    this.f10002x = true;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
        }
        if (this.f9990l == C3566k.READY) {
            if (uri != null) {
                try {
                    if (!m12015b(activity)) {
                        String a = C6011i0.m19314b(this.f9984f).mo33893a(uri.toString());
                        this.f9998t = a;
                        this.f9982d.mo33982l(a);
                        if (!(a == null || !a.equals(uri.toString()) || activity == null || activity.getIntent() == null || activity.getIntent().getExtras() == null)) {
                            Bundle extras = activity.getIntent().getExtras();
                            Set keySet = extras.keySet();
                            if (keySet.size() > 0) {
                                JSONObject jSONObject4 = new JSONObject();
                                for (String str2 : f9977L) {
                                    if (keySet.contains(str2)) {
                                        jSONObject4.put(str2, extras.get(str2));
                                    }
                                }
                                if (jSONObject4.length() > 0) {
                                    this.f9982d.mo33980k(jSONObject4.toString());
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (activity != null) {
                try {
                    if (!(activity.getIntent() == null || activity.getIntent().getExtras() == null || m12015b(activity) || (string = activity.getIntent().getExtras().getString(C6028l.AndroidPushNotificationKey.mo33920a())) == null || string.length() <= 0)) {
                        this.f9982d.mo34000u(string);
                        Intent intent2 = activity.getIntent();
                        intent2.putExtra(C6028l.BranchLinkUsed.mo33920a(), true);
                        activity.setIntent(intent2);
                        return false;
                    }
                } catch (Exception unused2) {
                }
            }
            if (uri != null && uri.isHierarchical() && activity != null && !m12005a(activity)) {
                try {
                    if (uri.getQueryParameter(C6028l.LinkClickID.mo33920a()) != null) {
                        this.f9982d.mo33998t(uri.getQueryParameter(C6028l.LinkClickID.mo33920a()));
                        String str3 = "link_click_id=" + uri.getQueryParameter(C6028l.LinkClickID.mo33920a());
                        String str4 = null;
                        if (activity.getIntent() != null) {
                            str4 = activity.getIntent().getDataString();
                        }
                        if (uri.getQuery().length() == str3.length()) {
                            str = "\\?" + str3;
                        } else {
                            if (str4 != null) {
                                if (str4.length() - str3.length() == str4.indexOf(str3)) {
                                    str = "&" + str3;
                                }
                            }
                            str = str3 + "&";
                        }
                        if (str4 != null) {
                            activity.getIntent().setData(Uri.parse(str4.replaceFirst(str, "")));
                            activity.getIntent().putExtra(C6028l.BranchLinkUsed.mo33920a(), true);
                        } else {
                            Log.w("BranchSDK", "Branch Warning. URI for the launcher activity is null. Please make sure that intent data is not set to null before calling Branch#InitSession ");
                        }
                        return true;
                    }
                    String scheme = uri.getScheme();
                    Intent intent3 = activity.getIntent();
                    if (!(scheme == null || intent3 == null || ((!scheme.equalsIgnoreCase("http") && !scheme.equalsIgnoreCase("https")) || uri.getHost() == null || uri.getHost().length() <= 0 || m12015b(activity)))) {
                        if (uri.toString().equalsIgnoreCase(C6011i0.m19314b(this.f9984f).mo33893a(uri.toString()))) {
                            this.f9982d.mo33972g(uri.toString());
                        }
                        intent3.putExtra(C6028l.BranchLinkUsed.mo33920a(), true);
                        activity.setIntent(intent3);
                    }
                } catch (Exception unused3) {
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m12025e(String str, String str2) {
        String[] split = str.split("\\?")[0].split("/");
        String[] split2 = str2.split("\\?")[0].split("/");
        if (split.length != split2.length) {
            return false;
        }
        int i = 0;
        while (i < split.length && i < split2.length) {
            String str3 = split[i];
            if (!str3.equals(split2[i]) && !str3.contains("*")) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: d */
    public void mo19636d(String str, String str2) {
        this.f9996r.put(str, str2);
    }

    /* renamed from: io.branch.referral.b$f */
    /* compiled from: Branch */
    private class C3561f extends C5991c<Void, Void, C5996e0> {

        /* renamed from: a */
        C6036r f10009a;

        public C3561f(C6036r rVar) {
            this.f10009a = rVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C5996e0 doInBackground(Void... voidArr) {
            C3555b bVar = C3555b.this;
            bVar.mo19636d(this.f10009a.mo34022h() + "-" + C6028l.Queue_Wait_Time.mo33920a(), String.valueOf(this.f10009a.mo34021g()));
            this.f10009a.mo34015b();
            if (C3555b.this.mo19638f() && !this.f10009a.mo34027p()) {
                return new C5996e0(this.f10009a.mo34022h(), -117);
            }
            if (this.f10009a.mo33819k()) {
                return C3555b.this.f9981c.mo33926a(this.f10009a.mo34023i(), this.f10009a.mo34019e(), this.f10009a.mo34022h(), C3555b.this.f9982d.mo33973h());
            }
            return C3555b.this.f9981c.mo33927a(this.f10009a.mo34010a((ConcurrentHashMap<String, String>) C3555b.this.f9996r), this.f10009a.mo34023i(), this.f10009a.mo34022h(), C3555b.this.f9982d.mo33973h());
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f10009a.mo33823n();
            this.f10009a.mo34017c();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(C5996e0 e0Var) {
            boolean z;
            super.onPostExecute(e0Var);
            if (e0Var != null) {
                try {
                    int d = e0Var.mo33854d();
                    boolean unused = C3555b.this.f9988j = true;
                    if (e0Var.mo33854d() == -117) {
                        this.f10009a.mo34028q();
                        C3555b.this.f9986h.mo34068b(this.f10009a);
                    } else if (d != 200) {
                        if (this.f10009a instanceof C6050x) {
                            C3568m unused2 = C3555b.this.f9992n = C3568m.UNINITIALISED;
                        }
                        if (d != 400) {
                            if (d != 409) {
                                boolean unused3 = C3555b.this.f9988j = false;
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < C3555b.this.f9986h.mo34071e(); i++) {
                                    arrayList.add(C3555b.this.f9986h.mo34060a(i));
                                }
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    C6036r rVar = (C6036r) it.next();
                                    if (rVar == null || !rVar.mo34029r()) {
                                        C3555b.this.f9986h.mo34068b(rVar);
                                    }
                                }
                                int unused4 = C3555b.this.f9987i = 0;
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    C6036r rVar2 = (C6036r) it2.next();
                                    if (rVar2 != null) {
                                        rVar2.mo33817a(d, e0Var.mo33852b());
                                        if (rVar2.mo34029r()) {
                                            rVar2.mo33816a();
                                        }
                                    }
                                }
                            }
                        }
                        C3555b.this.f9986h.mo34068b(this.f10009a);
                        if (this.f10009a instanceof C6040t) {
                            ((C6040t) this.f10009a).mo34034w();
                        } else {
                            C3555b.this.m11995a(0, d);
                        }
                    } else {
                        boolean unused5 = C3555b.this.f9988j = true;
                        if (this.f10009a instanceof C6040t) {
                            if (e0Var.mo33853c() != null) {
                                C3555b.this.f9989k.put(((C6040t) this.f10009a).mo33824u(), e0Var.mo33853c().getString("url"));
                            }
                        } else if (this.f10009a instanceof C6051y) {
                            C3555b.this.f9989k.clear();
                            C3555b.this.f9986h.mo34061a();
                        }
                        C3555b.this.f9986h.mo34070d();
                        if (!(this.f10009a instanceof C6050x)) {
                            if (!(this.f10009a instanceof C6049w)) {
                                this.f10009a.mo33818a(e0Var, C3555b.f9972G);
                            }
                        }
                        JSONObject c = e0Var.mo33853c();
                        if (c != null) {
                            if (!C3555b.this.mo19638f()) {
                                if (c.has(C6028l.SessionID.mo33920a())) {
                                    C3555b.this.f9982d.mo34002v(c.getString(C6028l.SessionID.mo33920a()));
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (c.has(C6028l.IdentityID.mo33920a())) {
                                    if (!C3555b.this.f9982d.mo33989p().equals(c.getString(C6028l.IdentityID.mo33920a()))) {
                                        C3555b.this.f9989k.clear();
                                        C3555b.this.f9982d.mo33990p(c.getString(C6028l.IdentityID.mo33920a()));
                                        z = true;
                                    }
                                }
                                if (c.has(C6028l.DeviceFingerprintID.mo33920a())) {
                                    C3555b.this.f9982d.mo33977j(c.getString(C6028l.DeviceFingerprintID.mo33920a()));
                                    z = true;
                                }
                            } else {
                                z = false;
                            }
                            if (z) {
                                C3555b.this.m12047s();
                            }
                            if (this.f10009a instanceof C6050x) {
                                C3568m unused6 = C3555b.this.f9992n = C3568m.INITIALISED;
                                this.f10009a.mo33818a(e0Var, C3555b.f9972G);
                                if (!C3555b.this.f9995q && !((C6050x) this.f10009a).mo34058a(e0Var)) {
                                    C3555b.this.m12030i();
                                }
                                if (((C6050x) this.f10009a).mo33825v()) {
                                    C3555b.this.f9995q = true;
                                }
                                if (C3555b.this.f10000v != null) {
                                    C3555b.this.f10000v.countDown();
                                }
                                if (C3555b.this.f9999u != null) {
                                    C3555b.this.f9999u.countDown();
                                }
                            } else {
                                this.f10009a.mo33818a(e0Var, C3555b.f9972G);
                            }
                        }
                    }
                    int unused7 = C3555b.this.f9987i = 0;
                    if (C3555b.this.f9988j && C3555b.this.f9992n != C3568m.UNINITIALISED) {
                        C3555b.this.m12046r();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo19633c() {
        m12033j();
        this.f9998t = null;
        this.f10004z.mo33891a(this.f9984f);
    }

    /* renamed from: a */
    private static C3555b m11990a(Context context, boolean z, String str) {
        boolean z2;
        if (f9972G == null) {
            f9972G = m12010b(context);
            if (TextUtils.isEmpty(str)) {
                str = f9972G.f9982d.mo33947a(z);
            }
            if (str == null || str.equalsIgnoreCase("bnc_no_value")) {
                String str2 = null;
                try {
                    Resources resources = context.getResources();
                    str2 = resources.getString(resources.getIdentifier("io.branch.apiKey", "string", context.getPackageName()));
                } catch (Exception unused) {
                }
                if (!TextUtils.isEmpty(str2)) {
                    z2 = f9972G.f9982d.mo33976i(str2);
                } else {
                    z2 = f9972G.f9982d.mo33976i("bnc_no_value");
                }
            } else {
                z2 = f9972G.f9982d.mo33976i(str);
            }
            if (z2) {
                f9972G.f9989k.clear();
                f9972G.f9986h.mo34061a();
            }
            f9972G.f9984f = context.getApplicationContext();
            if (context instanceof Application) {
                f9973H = true;
                f9972G.m11997a((Application) context);
            }
        }
        return f9972G;
    }

    /* renamed from: c */
    private void m12021c(C6036r rVar) {
        if (this.f9987i == 0) {
            this.f9986h.mo34065a(rVar, 0);
        } else {
            this.f9986h.mo34065a(rVar, 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12020c(Activity activity) {
        Uri data = activity.getIntent() != null ? activity.getIntent().getData() : null;
        this.f9995q = false;
        mo19628a(data, activity);
    }

    @TargetApi(14)
    /* renamed from: a */
    public static C3555b m11989a(Context context) {
        f9973H = true;
        f9975J = C3564i.USE_DEFAULT;
        m11990a(context, true ^ C6010i.m19310a(context), (String) null);
        return f9972G;
    }

    /* renamed from: a */
    public boolean mo19629a(C3562g gVar, Activity activity) {
        if (f9975J == C3564i.USE_DEFAULT) {
            m11998a(gVar, activity, true);
        } else {
            m11998a(gVar, activity, f9975J == C3564i.REFERRABLE);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo19630a(C3562g gVar, Uri uri, Activity activity) {
        m12016b(uri, activity);
        return mo19629a(gVar, activity);
    }

    /* renamed from: a */
    public boolean mo19628a(Uri uri, Activity activity) {
        m12016b(uri, activity);
        return mo19629a((C3562g) null, activity);
    }

    /* renamed from: a */
    private void m11998a(C3562g gVar, Activity activity, boolean z) {
        if (activity != null) {
            this.f9994p = new WeakReference<>(activity);
        }
        if (!m12041n() || !m12038m() || this.f9992n != C3568m.INITIALISED) {
            if (this.f10002x && m12022c(gVar)) {
                mo19636d(C6028l.InstantDeepLinkSession.mo33920a(), "true");
                this.f10002x = false;
                m12030i();
            }
            if (z) {
                this.f9982d.mo33945I();
            } else {
                this.f9982d.mo33957b();
            }
            C3568m mVar = this.f9992n;
            C3568m mVar2 = C3568m.INITIALISING;
            if (mVar != mVar2) {
                this.f9992n = mVar2;
                m12013b(gVar);
            } else if (gVar != null) {
                this.f9986h.mo34062a(gVar);
            }
        } else {
            m12022c(gVar);
            this.f10002x = false;
        }
    }

    /* renamed from: a */
    private boolean m12005a(Activity activity) {
        return (activity == null || activity.getIntent() == null || (activity.getIntent().getFlags() & 1048576) == 0) ? false : true;
    }

    /* renamed from: a */
    public void mo19623a() {
        this.f9986h.mo34063a(C6036r.C6038b.INSTALL_REFERRER_FETCH_WAIT_LOCK);
        m12046r();
    }

    /* renamed from: a */
    private JSONObject m11994a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (this.f9979a != null) {
                    if (this.f9979a.length() > 0) {
                        Log.w("BranchSDK", "You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link");
                    }
                    Iterator<String> keys = this.f9979a.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, this.f9979a.get(next));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo19624a(C6040t tVar) {
        if (tVar.f15658i || tVar.mo34033b(this.f9984f)) {
            return null;
        }
        if (this.f9989k.containsKey(tVar.mo33824u())) {
            String str = this.f9989k.get(tVar.mo33824u());
            tVar.mo34032a(str);
            return str;
        } else if (!tVar.mo34035x()) {
            return m12012b(tVar);
        } else {
            m12014b((C6036r) tVar);
            return null;
        }
    }

    /* renamed from: a */
    private JSONObject m11993a(String str) {
        if (str.equals("bnc_no_value")) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            try {
                return new JSONObject(new String(C5985a.m19206a(str.getBytes(), 2)));
            } catch (JSONException e) {
                e.printStackTrace();
                return new JSONObject();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11995a(int i, int i2) {
        C6036r rVar;
        if (i >= this.f9986h.mo34071e()) {
            C6052z zVar = this.f9986h;
            rVar = zVar.mo34060a(zVar.mo34071e() - 1);
        } else {
            rVar = this.f9986h.mo34060a(i);
        }
        m12003a(rVar, i2);
    }

    /* renamed from: b */
    private boolean m12015b(Activity activity) {
        return (activity == null || activity.getIntent() == null || !activity.getIntent().getBooleanExtra(C6028l.BranchLinkUsed.mo33920a(), false)) ? false : true;
    }

    /* renamed from: b */
    public void mo19631b() {
        this.f9997s = false;
        this.f9986h.mo34063a(C6036r.C6038b.GAID_FETCH_WAIT_LOCK);
        if (this.f10001w) {
            m12045q();
            this.f10001w = false;
            return;
        }
        m12046r();
    }

    /* renamed from: a */
    private void m12003a(C6036r rVar, int i) {
        if (rVar != null) {
            rVar.mo33817a(i, "");
        }
    }

    /* renamed from: a */
    private void m12004a(C6036r rVar, C3562g gVar) {
        if (!this.f9986h.mo34069c()) {
            m12021c(rVar);
        } else {
            if (gVar != null) {
                this.f9986h.mo34062a(gVar);
            }
            this.f9986h.mo34066a(rVar, this.f9987i, gVar);
        }
        m12046r();
    }

    /* renamed from: b */
    private String m12012b(C6040t tVar) {
        C5996e0 e0Var;
        if (this.f10004z.mo33892a()) {
            return tVar.mo33825v();
        }
        String str = null;
        if (this.f9992n == C3568m.INITIALISED) {
            try {
                e0Var = (C5996e0) new C3569n(this, (C3556a) null).execute(new C6036r[]{tVar}).get((long) (this.f9982d.mo33940D() + 2000), TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                e0Var = null;
            }
            if (tVar.mo34036y()) {
                str = tVar.mo33825v();
            }
            if (e0Var != null && e0Var.mo33854d() == 200) {
                try {
                    str = e0Var.mo33853c().getString("url");
                    if (tVar.mo33824u() != null) {
                        this.f9989k.put(tVar.mo33824u(), str);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    private void m11999a(C3562g gVar, C6036r.C6038b bVar) {
        C6036r a = m11992a(gVar);
        a.mo34012a(bVar);
        if (this.f9997s) {
            a.mo34012a(C6036r.C6038b.GAID_FETCH_WAIT_LOCK);
        }
        if (this.f9990l != C3566k.READY && !m12044p()) {
            a.mo34012a(C6036r.C6038b.INTENT_PENDING_WAIT_LOCK);
        }
        if (f9970E && (a instanceof C5992c0) && !InstallListener.f15310e) {
            a.mo34012a(C6036r.C6038b.INSTALL_REFERRER_FETCH_WAIT_LOCK);
            InstallListener.m19194a(this.f9984f, f9971F, this);
        }
        m12004a(a, gVar);
    }

    /* renamed from: a */
    private C6036r m11992a(C3562g gVar) {
        if (m12041n()) {
            return new C5994d0(this.f9984f, gVar, this.f9983e);
        }
        return new C5992c0(this.f9984f, gVar, this.f9983e, InstallListener.m19198c());
    }

    /* renamed from: b */
    private void m12014b(C6036r rVar) {
        mo19626a(rVar);
    }

    /* renamed from: b */
    private void m12013b(C3562g gVar) {
        if (this.f9982d.mo33973h() == null || this.f9982d.mo33973h().equalsIgnoreCase("bnc_no_value")) {
            this.f9992n = C3568m.UNINITIALISED;
            if (gVar != null) {
                gVar.mo19656a((JSONObject) null, new C5993d("Trouble initializing Branch.", -114));
                return;
            }
            return;
        }
        if (this.f9982d.mo33973h() != null) {
            boolean startsWith = this.f9982d.mo33973h().startsWith("key_test_");
        }
        if (!this.f9982d.mo33981l().equals("bnc_no_value") || !this.f9980b) {
            m11999a(gVar, (C6036r.C6038b) null);
        } else if (C6025k.m19358a(this.f9984f, new C3556a()).booleanValue()) {
            m11999a(gVar, C6036r.C6038b.FB_APP_LINK_WAIT_LOCK);
        } else {
            m11999a(gVar, (C6036r.C6038b) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11996a(Activity activity, boolean z) {
        this.f9986h.mo34063a(C6036r.C6038b.INTENT_PENDING_WAIT_LOCK);
        if (z) {
            m12016b(activity.getIntent().getData(), activity);
            if (mo19638f() || f9976K == null || this.f9982d.mo33973h() == null || this.f9982d.mo33973h().equalsIgnoreCase("bnc_no_value")) {
                m12046r();
            } else if (this.f9997s) {
                this.f10001w = true;
            } else {
                m12045q();
            }
        } else {
            m12046r();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m12018b(org.json.JSONObject r5, android.content.pm.ActivityInfo r6) {
        /*
            r4 = this;
            r0 = 0
            io.branch.referral.l r1 = p118io.branch.referral.C6028l.AndroidDeepLinkPath     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r1 = r1.mo33920a()     // Catch:{ JSONException -> 0x0030 }
            boolean r1 = r5.has(r1)     // Catch:{ JSONException -> 0x0030 }
            if (r1 == 0) goto L_0x0019
            io.branch.referral.l r1 = p118io.branch.referral.C6028l.AndroidDeepLinkPath     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r1 = r1.mo33920a()     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r5 = r5.getString(r1)     // Catch:{ JSONException -> 0x0030 }
        L_0x0017:
            r0 = r5
            goto L_0x0031
        L_0x0019:
            io.branch.referral.l r1 = p118io.branch.referral.C6028l.DeepLinkPath     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r1 = r1.mo33920a()     // Catch:{ JSONException -> 0x0030 }
            boolean r1 = r5.has(r1)     // Catch:{ JSONException -> 0x0030 }
            if (r1 == 0) goto L_0x0031
            io.branch.referral.l r1 = p118io.branch.referral.C6028l.DeepLinkPath     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r1 = r1.mo33920a()     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r5 = r5.getString(r1)     // Catch:{ JSONException -> 0x0030 }
            goto L_0x0017
        L_0x0030:
        L_0x0031:
            android.os.Bundle r5 = r6.metaData
            java.lang.String r1 = "io.branch.sdk.auto_link_path"
            java.lang.String r5 = r5.getString(r1)
            r2 = 0
            if (r5 == 0) goto L_0x005f
            if (r0 == 0) goto L_0x005f
            android.os.Bundle r5 = r6.metaData
            java.lang.String r5 = r5.getString(r1)
            java.lang.String r6 = ","
            java.lang.String[] r5 = r5.split(r6)
            int r6 = r5.length
            r1 = 0
        L_0x004c:
            if (r1 >= r6) goto L_0x005f
            r3 = r5[r1]
            java.lang.String r3 = r3.trim()
            boolean r3 = r4.m12025e(r3, r0)
            if (r3 == 0) goto L_0x005c
            r5 = 1
            return r5
        L_0x005c:
            int r1 = r1 + 1
            goto L_0x004c
        L_0x005f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C3555b.m12018b(org.json.JSONObject, android.content.pm.ActivityInfo):boolean");
    }

    /* renamed from: a */
    public void mo19626a(C6036r rVar) {
        if (this.f10004z.mo33892a()) {
            rVar.mo34028q();
            return;
        }
        if (this.f9992n != C3568m.INITIALISED && !(rVar instanceof C6050x)) {
            if (rVar instanceof C6051y) {
                rVar.mo33817a(-101, "");
                return;
            } else if (!(rVar instanceof C5990b0)) {
                WeakReference<Activity> weakReference = this.f9994p;
                Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
                boolean z = true;
                if (f9975J == C3564i.USE_DEFAULT) {
                    m11998a((C3562g) null, activity, true);
                } else {
                    if (f9975J != C3564i.REFERRABLE) {
                        z = false;
                    }
                    m11998a((C3562g) null, activity, z);
                }
            } else {
                return;
            }
        }
        this.f9986h.mo34064a(rVar);
        rVar.mo34026o();
        m12046r();
    }

    /* renamed from: b */
    public void mo19632b(String str, String str2) {
        if (C6050x.m19563a(str)) {
            m12030i();
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    private void m11997a(Application application) {
        try {
            C3558c cVar = new C3558c(this, (C3556a) null);
            application.unregisterActivityLifecycleCallbacks(cVar);
            application.registerActivityLifecycleCallbacks(cVar);
            f9974I = true;
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
            f9974I = false;
            f9973H = false;
            Log.w("BranchSDK", new C5993d("", -108).mo33826a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m12006a(Intent intent) {
        boolean z;
        if (intent == null) {
            return false;
        }
        try {
            z = intent.getBooleanExtra(C6028l.ForceNewBranchSession.mo33920a(), false);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            intent.putExtra(C6028l.ForceNewBranchSession.mo33920a(), false);
        }
        return z;
    }

    /* renamed from: a */
    private boolean m12009a(JSONObject jSONObject, ActivityInfo activityInfo) {
        if (activityInfo.metaData.getString("io.branch.sdk.auto_link_keys") != null) {
            for (String has : activityInfo.metaData.getString("io.branch.sdk.auto_link_keys").split(",")) {
                if (jSONObject.has(has)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo19627a(String str, String str2) {
        if (C6050x.m19563a(str)) {
            m12030i();
        }
    }

    /* renamed from: a */
    public void mo19625a(int i, String str, String str2) {
        if (C6050x.m19563a(str2)) {
            m12030i();
        }
    }
}
