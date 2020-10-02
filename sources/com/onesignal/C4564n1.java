package com.onesignal;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostExperimentManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.ogury.p159cm.OguryChoiceManager;
import com.onesignal.C4497e1;
import com.onesignal.C4519h2;
import com.onesignal.C4667u0;
import com.onesignal.C4674v0;
import com.onesignal.C4677v2;
import com.onesignal.C4686w;
import com.onesignal.C4720x1;
import com.onesignal.C4731y1;
import com.tapjoy.TapjoyConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.n1 */
/* compiled from: OneSignal */
public class C4564n1 {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public static boolean f12469A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public static boolean f12470B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public static boolean f12471C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public static C4686w.C4693g f12472D;

    /* renamed from: E */
    static boolean f12473E = true;

    /* renamed from: F */
    static C4592r f12474F = new C4592r((C4575f) null);

    /* renamed from: G */
    private static Collection<JSONArray> f12475G = new ArrayList();

    /* renamed from: H */
    private static HashSet<String> f12476H = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: I */
    public static ArrayList<C4597w> f12477I = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: J */
    public static boolean f12478J;

    /* renamed from: K */
    private static boolean f12479K;

    /* renamed from: L */
    static boolean f12480L = false;

    /* renamed from: M */
    static C4720x1.C4727f f12481M;

    /* renamed from: N */
    private static C4741z0 f12482N;

    /* renamed from: O */
    static C4741z0 f12483O;

    /* renamed from: P */
    private static C4729y0<Object, C4468a1> f12484P;

    /* renamed from: Q */
    private static OSSubscriptionState f12485Q;

    /* renamed from: R */
    static OSSubscriptionState f12486R;

    /* renamed from: S */
    private static C4729y0<C4505f1, C4512g1> f12487S;

    /* renamed from: T */
    private static C4529j0 f12488T;

    /* renamed from: U */
    private static C4598x f12489U;

    /* renamed from: V */
    private static C4519h2 f12490V;

    /* renamed from: a */
    private static C4596v f12491a;

    /* renamed from: b */
    private static C4596v f12492b;

    /* renamed from: c */
    static String f12493c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f12494d;

    /* renamed from: e */
    static Context f12495e;

    /* renamed from: f */
    private static C4566a0 f12496f = C4566a0.NONE;

    /* renamed from: g */
    private static C4566a0 f12497g = C4566a0.WARN;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static String f12498h = null;

    /* renamed from: i */
    private static String f12499i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static int f12500j;

    /* renamed from: k */
    private static boolean f12501k;

    /* renamed from: l */
    private static boolean f12502l;

    /* renamed from: m */
    private static C4591q f12503m = C4591q.APP_CLOSE;

    /* renamed from: n */
    static ExecutorService f12504n;

    /* renamed from: o */
    public static ConcurrentLinkedQueue<Runnable> f12505o = new ConcurrentLinkedQueue<>();

    /* renamed from: p */
    static AtomicLong f12506p = new AtomicLong();

    /* renamed from: q */
    private static C4599y f12507q;

    /* renamed from: r */
    private static C4615p2 f12508r;

    /* renamed from: s */
    private static C4601n2 f12509s;

    /* renamed from: t */
    private static C4608o2 f12510t;

    /* renamed from: u */
    private static C4497e1 f12511u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public static C4487d2 f12512v;

    /* renamed from: w */
    private static C4484d f12513w = new C4479c();

    /* renamed from: x */
    public static String f12514x = "native";

    /* renamed from: y */
    private static C4536k1 f12515y = new C4536k1();
    /* access modifiers changed from: private */

    /* renamed from: z */
    public static String f12516z;

    /* renamed from: com.onesignal.n1$a */
    /* compiled from: OneSignal */
    static class C4565a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ JSONObject f12517a;

        /* renamed from: b */
        final /* synthetic */ C4593s f12518b;

        C4565a(JSONObject jSONObject, C4593s sVar) {
            this.f12517a = jSONObject;
            this.f12518b = sVar;
        }

        public void run() {
            if (this.f12517a == null) {
                C4593s sVar = this.f12518b;
                if (sVar != null) {
                    sVar.mo29883a(new C4583i0(-1, "Attempted to send null tags"));
                    return;
                }
                return;
            }
            JSONObject jSONObject = C4742z1.m16463a(false).f12731b;
            JSONObject jSONObject2 = new JSONObject();
            Iterator<String> keys = this.f12517a.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    Object opt = this.f12517a.opt(next);
                    if (!(opt instanceof JSONArray)) {
                        if (!(opt instanceof JSONObject)) {
                            if (!this.f12517a.isNull(next)) {
                                if (!"".equals(opt)) {
                                    jSONObject2.put(next, opt.toString());
                                }
                            }
                            if (jSONObject != null && jSONObject.has(next)) {
                                jSONObject2.put(next, "");
                            }
                        }
                    }
                    C4566a0 a0Var = C4566a0.ERROR;
                    C4564n1.m15789a(a0Var, "Omitting key '" + next + "'! sendTags DO NOT supported nested values!");
                } catch (Throwable unused) {
                }
            }
            if (!jSONObject2.toString().equals("{}")) {
                C4742z1.m16466a(jSONObject2, this.f12518b);
                return;
            }
            C4593s sVar2 = this.f12518b;
            if (sVar2 != null) {
                sVar2.onSuccess(jSONObject);
            }
        }
    }

    /* renamed from: com.onesignal.n1$a0 */
    /* compiled from: OneSignal */
    public enum C4566a0 {
        NONE,
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE;

        static {
            NONE = new C4566a0("NONE", 0);
            FATAL = new C4566a0("FATAL", 1);
            ERROR = new C4566a0("ERROR", 2);
            WARN = new C4566a0("WARN", 3);
            INFO = new C4566a0("INFO", 4);
            DEBUG = new C4566a0("DEBUG", 5);
            VERBOSE = new C4566a0("VERBOSE", 6);
        }
    }

    /* renamed from: com.onesignal.n1$b */
    /* compiled from: OneSignal */
    static class C4567b implements Runnable {
        C4567b() {
        }

        public void run() {
            JSONObject jSONObject;
            C4677v2.C4683f a = C4742z1.m16463a(!C4564n1.f12478J);
            if (a.f12730a) {
                boolean unused = C4564n1.f12478J = true;
            }
            synchronized (C4564n1.f12477I) {
                Iterator it = C4564n1.f12477I.iterator();
                while (it.hasNext()) {
                    C4597w wVar = (C4597w) it.next();
                    if (a.f12731b != null) {
                        if (!a.toString().equals("{}")) {
                            jSONObject = a.f12731b;
                            wVar.mo29887a(jSONObject);
                        }
                    }
                    jSONObject = null;
                    wVar.mo29887a(jSONObject);
                }
                C4564n1.f12477I.clear();
            }
        }
    }

    /* renamed from: com.onesignal.n1$b0 */
    /* compiled from: OneSignal */
    public interface C4568b0 {
        /* renamed from: a */
        void mo29861a(C4697w0 w0Var);
    }

    /* renamed from: com.onesignal.n1$c */
    /* compiled from: OneSignal */
    static class C4569c implements Runnable {
        C4569c() {
        }

        public void run() {
            C4564n1.m15768R();
        }
    }

    /* renamed from: com.onesignal.n1$c0 */
    /* compiled from: OneSignal */
    public interface C4570c0 {
        /* renamed from: a */
        void mo29863a(C4667u0 u0Var);
    }

    /* renamed from: com.onesignal.n1$d */
    /* compiled from: OneSignal */
    static class C4571d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4697w0 f12526a;

        C4571d(C4697w0 w0Var) {
            this.f12526a = w0Var;
        }

        public void run() {
            C4564n1.f12474F.f12542b.mo29861a(this.f12526a);
        }
    }

    /* renamed from: com.onesignal.n1$d0 */
    /* compiled from: OneSignal */
    public enum C4572d0 {
        f12527a,
        InAppAlert,
        Notification;

        static {
            f12527a = new C4572d0(AdMost.CONSENT_ZONE_NONE, 0);
            InAppAlert = new C4572d0("InAppAlert", 1);
            Notification = new C4572d0("Notification", 2);
        }
    }

    /* renamed from: com.onesignal.n1$e */
    /* compiled from: OneSignal */
    static class C4573e extends C4731y1.C4738g {
        C4573e() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            C4564n1.m15796a("sending Notification Opened Failed", i, th, str);
        }
    }

    /* renamed from: com.onesignal.n1$e0 */
    /* compiled from: OneSignal */
    interface C4574e0 {
        /* renamed from: a */
        void mo29865a(String str, boolean z);
    }

    /* renamed from: com.onesignal.n1$f */
    /* compiled from: OneSignal */
    static class C4575f implements C4497e1.C4499b {
        C4575f() {
        }

        /* renamed from: a */
        public void mo29760a(C4497e1.C4500c cVar) {
            C4564n1.f12512v.mo29739a();
            C4619q.m15979d().mo29911a(cVar);
        }
    }

    /* renamed from: com.onesignal.n1$f0 */
    /* compiled from: OneSignal */
    interface C4576f0 {
        /* renamed from: a */
        void mo29841a(boolean z);
    }

    /* renamed from: com.onesignal.n1$g */
    /* compiled from: OneSignal */
    static class C4577g implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f12530a;

        C4577g(boolean z) {
            this.f12530a = z;
        }

        public void run() {
            C4564n1.m15830d(C4564n1.f12495e).mo29669a(this.f12530a);
            C4742z1.m16472d(this.f12530a);
        }
    }

    /* renamed from: com.onesignal.n1$g0 */
    /* compiled from: OneSignal */
    public interface C4578g0 {
        /* renamed from: a */
        void mo29867a(C4478b2 b2Var);
    }

    /* renamed from: com.onesignal.n1$h */
    /* compiled from: OneSignal */
    static class C4579h implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4576f0 f12531a;

        C4579h(C4576f0 f0Var) {
            this.f12531a = f0Var;
        }

        public void run() {
            C4686w.m16319a(C4564n1.f12495e, true, new C4580a());
            boolean unused = C4564n1.f12471C = true;
        }

        /* renamed from: com.onesignal.n1$h$a */
        /* compiled from: OneSignal */
        class C4580a extends C4686w.C4694h {
            C4580a() {
            }

            /* renamed from: a */
            public void mo29709a(C4686w.C4693g gVar) {
                if (!C4564n1.m15854h("promptLocation()") && gVar != null) {
                    C4742z1.m16464a(gVar);
                }
            }

            public C4686w.C4696j getType() {
                return C4686w.C4696j.PROMPT_LOCATION;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo29869a(boolean z) {
                super.mo29869a(z);
                C4576f0 f0Var = C4579h.this.f12531a;
                if (f0Var != null) {
                    f0Var.mo29841a(z);
                }
            }
        }
    }

    /* renamed from: com.onesignal.n1$h0 */
    /* compiled from: OneSignal */
    private static class C4581h0 implements Runnable {

        /* renamed from: a */
        private Runnable f12533a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public long f12534b;

        C4581h0(Runnable runnable) {
            this.f12533a = runnable;
        }

        public void run() {
            this.f12533a.run();
            C4564n1.m15814b(this.f12534b);
        }
    }

    /* renamed from: com.onesignal.n1$i */
    /* compiled from: OneSignal */
    static class C4582i implements Runnable {
        C4582i() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.database.sqlite.SQLiteDatabase} */
        /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.String[]] */
        /* JADX WARNING: type inference failed for: r4v1, types: [android.database.Cursor] */
        /* JADX WARNING: type inference failed for: r4v2 */
        /* JADX WARNING: type inference failed for: r4v4 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0077 A[SYNTHETIC, Splitter:B:25:0x0077] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00a5 A[DONT_GENERATE] */
        /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r15 = this;
                java.lang.String r0 = "android_notification_id"
                java.lang.String r1 = "Error closing transaction! "
                android.content.Context r2 = com.onesignal.C4564n1.f12495e
                android.app.NotificationManager r2 = com.onesignal.C4676v1.m16257d(r2)
                android.content.Context r3 = com.onesignal.C4564n1.f12495e
                com.onesignal.t1 r3 = com.onesignal.C4655t1.m16157a((android.content.Context) r3)
                r4 = 0
                android.database.sqlite.SQLiteDatabase r5 = r3.mo29963d()     // Catch:{ all -> 0x009b }
                r13 = 1
                java.lang.String[] r7 = new java.lang.String[r13]     // Catch:{ all -> 0x009b }
                r14 = 0
                r7[r14] = r0     // Catch:{ all -> 0x009b }
                java.lang.String r6 = "notification"
                java.lang.String r8 = "dismissed = 0 AND opened = 0"
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x009b }
                boolean r6 = r5.moveToFirst()     // Catch:{ all -> 0x0098 }
                if (r6 == 0) goto L_0x003e
            L_0x002d:
                int r6 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x0098 }
                int r6 = r5.getInt(r6)     // Catch:{ all -> 0x0098 }
                r2.cancel(r6)     // Catch:{ all -> 0x0098 }
                boolean r6 = r5.moveToNext()     // Catch:{ all -> 0x0098 }
                if (r6 != 0) goto L_0x002d
            L_0x003e:
                android.database.sqlite.SQLiteDatabase r0 = r3.mo29967t()     // Catch:{ all -> 0x006d }
                r0.beginTransaction()     // Catch:{ all -> 0x006a }
                java.lang.String r2 = "opened = 0"
                android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ all -> 0x006a }
                r3.<init>()     // Catch:{ all -> 0x006a }
                java.lang.String r6 = "dismissed"
                java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x006a }
                r3.put(r6, r7)     // Catch:{ all -> 0x006a }
                java.lang.String r6 = "notification"
                r0.update(r6, r3, r2, r4)     // Catch:{ all -> 0x006a }
                r0.setTransactionSuccessful()     // Catch:{ all -> 0x006a }
                if (r0 == 0) goto L_0x007f
                r0.endTransaction()     // Catch:{ all -> 0x0063 }
                goto L_0x007f
            L_0x0063:
                r0 = move-exception
                com.onesignal.n1$a0 r2 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0098 }
            L_0x0066:
                com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r2, (java.lang.String) r1, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0098 }
                goto L_0x007f
            L_0x006a:
                r2 = move-exception
                r4 = r0
                goto L_0x006e
            L_0x006d:
                r2 = move-exception
            L_0x006e:
                com.onesignal.n1$a0 r0 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x008a }
                java.lang.String r3 = "Error marking all notifications as dismissed! "
                com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r0, (java.lang.String) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x008a }
                if (r4 == 0) goto L_0x007f
                r4.endTransaction()     // Catch:{ all -> 0x007b }
                goto L_0x007f
            L_0x007b:
                r0 = move-exception
                com.onesignal.n1$a0 r2 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0098 }
                goto L_0x0066
            L_0x007f:
                android.content.Context r0 = com.onesignal.C4564n1.f12495e     // Catch:{ all -> 0x0098 }
                com.onesignal.C4521i.m15557a((int) r14, (android.content.Context) r0)     // Catch:{ all -> 0x0098 }
                if (r5 == 0) goto L_0x00a8
                r5.close()
                goto L_0x00a8
            L_0x008a:
                r0 = move-exception
                if (r4 == 0) goto L_0x0097
                r4.endTransaction()     // Catch:{ all -> 0x0091 }
                goto L_0x0097
            L_0x0091:
                r2 = move-exception
                com.onesignal.n1$a0 r3 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0098 }
                com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r3, (java.lang.String) r1, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0098 }
            L_0x0097:
                throw r0     // Catch:{ all -> 0x0098 }
            L_0x0098:
                r0 = move-exception
                r4 = r5
                goto L_0x009c
            L_0x009b:
                r0 = move-exception
            L_0x009c:
                com.onesignal.n1$a0 r1 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x00a9 }
                java.lang.String r2 = "Error canceling all notifications! "
                com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r1, (java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x00a9 }
                if (r4 == 0) goto L_0x00a8
                r4.close()
            L_0x00a8:
                return
            L_0x00a9:
                r0 = move-exception
                if (r4 == 0) goto L_0x00af
                r4.close()
            L_0x00af:
                goto L_0x00b1
            L_0x00b0:
                throw r0
            L_0x00b1:
                goto L_0x00b0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4564n1.C4582i.run():void");
        }
    }

    /* renamed from: com.onesignal.n1$i0 */
    /* compiled from: OneSignal */
    public static class C4583i0 {
        C4583i0(int i, String str) {
        }
    }

    /* renamed from: com.onesignal.n1$j */
    /* compiled from: OneSignal */
    static class C4584j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f12535a;

        C4584j(int i) {
            this.f12535a = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0089 A[SYNTHETIC, Splitter:B:17:0x0089] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.String r0 = "dismissed"
                java.lang.String r1 = "Error closing transaction! "
                android.content.Context r2 = com.onesignal.C4564n1.f12495e
                com.onesignal.t1 r2 = com.onesignal.C4655t1.m16157a((android.content.Context) r2)
                r3 = 0
                android.database.sqlite.SQLiteDatabase r2 = r2.mo29967t()     // Catch:{ all -> 0x0069 }
                r2.beginTransaction()     // Catch:{ all -> 0x0066 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
                r4.<init>()     // Catch:{ all -> 0x0066 }
                java.lang.String r5 = "android_notification_id = "
                r4.append(r5)     // Catch:{ all -> 0x0066 }
                int r5 = r7.f12535a     // Catch:{ all -> 0x0066 }
                r4.append(r5)     // Catch:{ all -> 0x0066 }
                java.lang.String r5 = " AND "
                r4.append(r5)     // Catch:{ all -> 0x0066 }
                java.lang.String r5 = "opened"
                r4.append(r5)     // Catch:{ all -> 0x0066 }
                java.lang.String r5 = " = 0 AND "
                r4.append(r5)     // Catch:{ all -> 0x0066 }
                r4.append(r0)     // Catch:{ all -> 0x0066 }
                java.lang.String r5 = " = 0"
                r4.append(r5)     // Catch:{ all -> 0x0066 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0066 }
                android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ all -> 0x0066 }
                r5.<init>()     // Catch:{ all -> 0x0066 }
                r6 = 1
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0066 }
                r5.put(r0, r6)     // Catch:{ all -> 0x0066 }
                java.lang.String r0 = "notification"
                int r0 = r2.update(r0, r5, r4, r3)     // Catch:{ all -> 0x0066 }
                if (r0 <= 0) goto L_0x0058
                android.content.Context r0 = com.onesignal.C4564n1.f12495e     // Catch:{ all -> 0x0066 }
                int r3 = r7.f12535a     // Catch:{ all -> 0x0066 }
                com.onesignal.C4504f0.m15523a((android.content.Context) r0, (android.database.sqlite.SQLiteDatabase) r2, (int) r3)     // Catch:{ all -> 0x0066 }
            L_0x0058:
                android.content.Context r0 = com.onesignal.C4564n1.f12495e     // Catch:{ all -> 0x0066 }
                com.onesignal.C4521i.m15558a((android.database.sqlite.SQLiteDatabase) r2, (android.content.Context) r0)     // Catch:{ all -> 0x0066 }
                r2.setTransactionSuccessful()     // Catch:{ all -> 0x0066 }
                if (r2 == 0) goto L_0x0093
                r2.endTransaction()     // Catch:{ all -> 0x008d }
                goto L_0x0093
            L_0x0066:
                r0 = move-exception
                r3 = r2
                goto L_0x006a
            L_0x0069:
                r0 = move-exception
            L_0x006a:
                com.onesignal.n1$a0 r2 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x009f }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
                r4.<init>()     // Catch:{ all -> 0x009f }
                java.lang.String r5 = "Error marking a notification id "
                r4.append(r5)     // Catch:{ all -> 0x009f }
                int r5 = r7.f12535a     // Catch:{ all -> 0x009f }
                r4.append(r5)     // Catch:{ all -> 0x009f }
                java.lang.String r5 = " as dismissed! "
                r4.append(r5)     // Catch:{ all -> 0x009f }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x009f }
                com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r2, (java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x009f }
                if (r3 == 0) goto L_0x0093
                r3.endTransaction()     // Catch:{ all -> 0x008d }
                goto L_0x0093
            L_0x008d:
                r0 = move-exception
                com.onesignal.n1$a0 r2 = com.onesignal.C4564n1.C4566a0.ERROR
                com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r2, (java.lang.String) r1, (java.lang.Throwable) r0)
            L_0x0093:
                android.content.Context r0 = com.onesignal.C4564n1.f12495e
                android.app.NotificationManager r0 = com.onesignal.C4676v1.m16257d(r0)
                int r1 = r7.f12535a
                r0.cancel(r1)
                return
            L_0x009f:
                r0 = move-exception
                if (r3 == 0) goto L_0x00ac
                r3.endTransaction()     // Catch:{ all -> 0x00a6 }
                goto L_0x00ac
            L_0x00a6:
                r2 = move-exception
                com.onesignal.n1$a0 r3 = com.onesignal.C4564n1.C4566a0.ERROR
                com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r3, (java.lang.String) r1, (java.lang.Throwable) r2)
            L_0x00ac:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4564n1.C4584j.run():void");
        }
    }

    /* renamed from: com.onesignal.n1$k */
    /* compiled from: OneSignal */
    static class C4585k implements ThreadFactory {
        C4585k() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OS_PENDING_EXECUTOR_" + thread.getId());
            return thread;
        }
    }

    /* renamed from: com.onesignal.n1$l */
    /* compiled from: OneSignal */
    static class C4586l implements C4686w.C4691e {
        C4586l() {
        }

        /* renamed from: a */
        public void mo29709a(C4686w.C4693g gVar) {
            C4686w.C4693g unused = C4564n1.f12472D = gVar;
            boolean unused2 = C4564n1.f12470B = true;
            C4564n1.m15829c0();
        }

        public C4686w.C4696j getType() {
            return C4686w.C4696j.STARTUP;
        }
    }

    /* renamed from: com.onesignal.n1$m */
    /* compiled from: OneSignal */
    static class C4587m implements C4519h2.C4520a {
        C4587m() {
        }

        /* renamed from: a */
        public void mo29784a(String str, int i) {
            if (i < 1) {
                if (C4742z1.m16470c() == null && (C4564n1.f12500j == 1 || C4564n1.m15834d(C4564n1.f12500j))) {
                    int unused = C4564n1.f12500j = i;
                }
            } else if (C4564n1.m15834d(C4564n1.f12500j)) {
                int unused2 = C4564n1.f12500j = i;
            }
            String unused3 = C4564n1.f12516z = str;
            boolean unused4 = C4564n1.f12469A = true;
            C4564n1.m15830d(C4564n1.f12495e).mo29668a(str);
            C4564n1.m15829c0();
        }
    }

    /* renamed from: com.onesignal.n1$n */
    /* compiled from: OneSignal */
    static class C4588n implements C4720x1.C4724c {
        C4588n() {
        }

        /* renamed from: a */
        public void mo29874a(C4720x1.C4727f fVar) {
            C4564n1.f12481M = fVar;
            String str = fVar.f12827a;
            if (str != null) {
                String unused = C4564n1.f12494d = str;
            }
            C4698w1.m16355b(C4698w1.f12761a, "GT_FIREBASE_TRACKING_ENABLED", C4564n1.f12481M.f12830d);
            C4698w1.m16355b(C4698w1.f12761a, "OS_RESTORE_TTL_FILTER", C4564n1.f12481M.f12831e);
            C4698w1.m16355b(C4698w1.f12761a, "OS_CLEAR_GROUP_SUMMARY_CLICK", C4564n1.f12481M.f12832f);
            C4698w1.m16355b(C4698w1.f12761a, "PREFS_OS_RECEIVE_RECEIPTS_ENABLED", C4564n1.f12481M.f12833g);
            C4513g2.m15540a(fVar.f12834h);
            C4728y.m16435a(C4564n1.f12495e, fVar.f12829c);
            C4564n1.m15820b0();
        }
    }

    /* renamed from: com.onesignal.n1$o */
    /* compiled from: OneSignal */
    static class C4589o implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4566a0 f12536a;

        /* renamed from: b */
        final /* synthetic */ String f12537b;

        C4589o(C4566a0 a0Var, String str) {
            this.f12536a = a0Var;
            this.f12537b = str;
        }

        public void run() {
            if (C4461a.f12260f != null) {
                new AlertDialog.Builder(C4461a.f12260f).setTitle(this.f12536a.toString()).setMessage(this.f12537b).show();
            }
        }
    }

    /* renamed from: com.onesignal.n1$p */
    /* compiled from: OneSignal */
    static class C4590p implements Runnable {
        C4590p() {
        }

        public void run() {
            try {
                C4564n1.m15836d0();
                C4642s1.m16089a(C4564n1.f12493c, C4564n1.f12498h, C4479c.m15437a());
            } catch (JSONException e) {
                C4564n1.m15790a(C4566a0.FATAL, "FATAL Error registering device!", (Throwable) e);
            }
        }
    }

    /* renamed from: com.onesignal.n1$q */
    /* compiled from: OneSignal */
    enum C4591q {
        NOTIFICATION_CLICK,
        APP_OPEN,
        APP_CLOSE;

        static {
            NOTIFICATION_CLICK = new C4591q("NOTIFICATION_CLICK", 0);
            APP_OPEN = new C4591q("APP_OPEN", 1);
            APP_CLOSE = new C4591q("APP_CLOSE", 2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo29877a() {
            return equals(APP_OPEN);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo29878b() {
            return equals(NOTIFICATION_CLICK);
        }
    }

    /* renamed from: com.onesignal.n1$r */
    /* compiled from: OneSignal */
    public static class C4592r {

        /* renamed from: a */
        Context f12541a;

        /* renamed from: b */
        C4568b0 f12542b;

        /* renamed from: c */
        C4570c0 f12543c;

        /* renamed from: d */
        C4600z f12544d;

        /* renamed from: e */
        boolean f12545e;

        /* renamed from: f */
        boolean f12546f;

        /* renamed from: g */
        boolean f12547g;

        /* renamed from: h */
        boolean f12548h;

        /* renamed from: i */
        boolean f12549i;

        /* renamed from: j */
        C4572d0 f12550j;

        /* synthetic */ C4592r(Context context, C4575f fVar) {
            this(context);
        }

        /* renamed from: a */
        public C4592r mo29879a(C4568b0 b0Var) {
            this.f12542b = b0Var;
            return this;
        }

        /* synthetic */ C4592r(C4575f fVar) {
            this();
        }

        /* renamed from: a */
        public C4592r mo29880a(C4572d0 d0Var) {
            this.f12549i = false;
            this.f12550j = d0Var;
            return this;
        }

        private C4592r() {
            this.f12550j = C4572d0.InAppAlert;
        }

        /* renamed from: a */
        public C4592r mo29881a(boolean z) {
            this.f12547g = z;
            return this;
        }

        private C4592r(Context context) {
            this.f12550j = C4572d0.InAppAlert;
            this.f12541a = context;
        }

        /* renamed from: a */
        public void mo29882a() {
            C4564n1.m15816b(this);
        }
    }

    /* renamed from: com.onesignal.n1$s */
    /* compiled from: OneSignal */
    public interface C4593s {
        /* renamed from: a */
        void mo29883a(C4583i0 i0Var);

        void onSuccess(JSONObject jSONObject);
    }

    /* renamed from: com.onesignal.n1$t */
    /* compiled from: OneSignal */
    public enum C4594t {
        VALIDATION,
        REQUIRES_EMAIL_AUTH,
        INVALID_OPERATION,
        NETWORK;

        static {
            VALIDATION = new C4594t("VALIDATION", 0);
            REQUIRES_EMAIL_AUTH = new C4594t("REQUIRES_EMAIL_AUTH", 1);
            INVALID_OPERATION = new C4594t("INVALID_OPERATION", 2);
            NETWORK = new C4594t("NETWORK", 3);
        }
    }

    /* renamed from: com.onesignal.n1$u */
    /* compiled from: OneSignal */
    public static class C4595u {
        C4595u(C4594t tVar, String str) {
        }
    }

    /* renamed from: com.onesignal.n1$v */
    /* compiled from: OneSignal */
    public interface C4596v {
        /* renamed from: a */
        void mo29885a(C4595u uVar);

        void onSuccess();
    }

    /* renamed from: com.onesignal.n1$w */
    /* compiled from: OneSignal */
    public interface C4597w {
        /* renamed from: a */
        void mo29887a(JSONObject jSONObject);
    }

    /* renamed from: com.onesignal.n1$x */
    /* compiled from: OneSignal */
    private static class C4598x {

        /* renamed from: a */
        JSONArray f12555a;

        /* renamed from: b */
        boolean f12556b;

        /* renamed from: c */
        C4731y1.C4738g f12557c;

        C4598x(JSONArray jSONArray) {
            this.f12555a = jSONArray;
        }
    }

    /* renamed from: com.onesignal.n1$y */
    /* compiled from: OneSignal */
    public interface C4599y {
        /* renamed from: a */
        void mo29888a(String str, String str2);
    }

    /* renamed from: com.onesignal.n1$z */
    /* compiled from: OneSignal */
    public interface C4600z {
        /* renamed from: a */
        void mo29889a(C4541l0 l0Var);
    }

    /* renamed from: A */
    public static C4477b1 m15751A() {
        if (m15854h("getPermissionSubscriptionState()")) {
            return null;
        }
        if (f12495e == null) {
            m15789a(C4566a0.ERROR, "OneSignal.init has not been called. Could not get OSPermissionSubscriptionState");
            return null;
        }
        C4477b1 b1Var = new C4477b1();
        b1Var.f12291a = m15830d(f12495e);
        b1Var.f12292b = m15821c(f12495e);
        b1Var.f12293c = m15810b(f12495e);
        return b1Var;
    }

    /* renamed from: B */
    private static C4519h2 m15752B() {
        C4519h2 h2Var = f12490V;
        if (h2Var != null) {
            return h2Var;
        }
        if (f12515y.mo29827c() == 2) {
            f12490V = new C4526i2();
        } else if (C4536k1.m15637f()) {
            f12490V = new C4539k2();
        } else {
            f12490V = new C4546l2();
        }
        return f12490V;
    }

    /* renamed from: C */
    static String m15753C() {
        return m15847g(f12495e);
    }

    /* renamed from: D */
    static boolean m15754D() {
        return C4698w1.m16348a(C4698w1.f12761a, "ONESIGNAL_USER_PROVIDED_CONSENT", false);
    }

    /* renamed from: E */
    static C4497e1 m15755E() {
        return f12511u;
    }

    /* renamed from: F */
    static boolean m15756F() {
        return C4698w1.m16348a(C4698w1.f12761a, "GT_SOUND_ENABLED", true);
    }

    /* renamed from: G */
    static C4729y0<C4505f1, C4512g1> m15757G() {
        if (f12487S == null) {
            f12487S = new C4729y0<>("onOSSubscriptionChanged", true);
        }
        return f12487S;
    }

    /* renamed from: H */
    private static int m15758H() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    /* renamed from: I */
    static String m15759I() {
        Context context;
        if (f12498h == null && (context = f12495e) != null) {
            f12498h = m15852h(context);
        }
        return f12498h;
    }

    /* renamed from: J */
    static boolean m15760J() {
        return C4698w1.m16348a(C4698w1.f12761a, "GT_VIBRATE_ENABLED", true);
    }

    /* renamed from: K */
    private static void m15761K() {
        try {
            Class.forName("com.amazon.device.iap.PurchasingListener");
            f12509s = new C4601n2(f12495e);
        } catch (ClassNotFoundException unused) {
        }
    }

    /* renamed from: L */
    private static void m15762L() {
        String C = m15753C();
        if (C == null) {
            C4521i.m15557a(0, f12495e);
            m15826c(f12493c);
        } else if (!C.equals(f12493c)) {
            m15789a(C4566a0.DEBUG, "APP ID changed, clearing user id as it is no longer valid.");
            m15826c(f12493c);
            C4742z1.m16480j();
            f12481M = null;
        }
    }

    /* renamed from: M */
    static void m15763M() {
        C4596v vVar = f12492b;
        if (vVar != null) {
            vVar.mo29885a(new C4595u(C4594t.NETWORK, "Failed due to network failure. Will retry on next sync."));
            f12492b = null;
        }
    }

    /* renamed from: N */
    static void m15764N() {
        C4596v vVar = f12492b;
        if (vVar != null) {
            vVar.onSuccess();
            f12492b = null;
        }
    }

    /* renamed from: O */
    static boolean m15765O() {
        return !TextUtils.isEmpty(f12499i);
    }

    /* renamed from: P */
    static boolean m15766P() {
        return m15759I() != null;
    }

    /* renamed from: Q */
    private static void m15767Q() {
        synchronized (f12477I) {
            if (f12477I.size() != 0) {
                new Thread(new C4567b(), "OS_GETTAGS_CALLBACK").start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        return;
     */
    /* renamed from: R */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m15768R() {
        /*
            java.lang.Class<com.onesignal.n1> r0 = com.onesignal.C4564n1.class
            monitor-enter(r0)
            com.onesignal.n1$y r1 = f12507q     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            java.lang.String r1 = com.onesignal.C4742z1.m16470c()     // Catch:{ all -> 0x0028 }
            boolean r2 = com.onesignal.C4742z1.m16473d()     // Catch:{ all -> 0x0028 }
            r3 = 0
            if (r2 != 0) goto L_0x0015
            r1 = r3
        L_0x0015:
            java.lang.String r2 = m15759I()     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x001d
            monitor-exit(r0)
            return
        L_0x001d:
            com.onesignal.n1$y r4 = f12507q     // Catch:{ all -> 0x0028 }
            r4.mo29888a(r2, r1)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0026
            f12507q = r3     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r0)
            return
        L_0x0028:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4564n1.m15768R():void");
    }

    /* renamed from: S */
    static boolean m15769S() {
        return f12501k && m15770T();
    }

    /* renamed from: T */
    static boolean m15770T() {
        return f12502l;
    }

    /* renamed from: U */
    private static boolean m15771U() {
        C4720x1.C4727f fVar = f12481M;
        return (fVar == null || fVar.f12827a == null) ? false : true;
    }

    /* renamed from: V */
    static boolean m15772V() {
        return f12501k;
    }

    /* renamed from: W */
    private static boolean m15773W() {
        return System.currentTimeMillis() - m15881w() >= 30000;
    }

    /* renamed from: X */
    private static boolean m15774X() {
        return f12500j == -999;
    }

    /* renamed from: Y */
    private static void m15775Y() {
        if (f12481M != null) {
            m15820b0();
        } else {
            C4720x1.m16424a(new C4588n());
        }
    }

    /* renamed from: Z */
    static void m15776Z() {
        f12502l = true;
        if (!f12503m.equals(C4591q.NOTIFICATION_CLICK)) {
            f12503m = C4591q.APP_OPEN;
        }
        C4686w.m16333h();
        if (!m15854h("onAppFocus") && !C4536k1.m15635c(f12493c)) {
            C4619q.m15979d().mo29912b();
            m15867l();
            C4615p2 p2Var = f12508r;
            if (p2Var != null) {
                p2Var.mo29906a();
            }
            C4495e0.m15481a(f12495e);
            m15821c(f12495e).mo30041c();
            if (f12510t != null && m15879u()) {
                f12510t.mo29892a();
            }
            C4469a2.m15407a(f12495e);
        }
    }

    /* renamed from: a0 */
    static void m15808a0() {
        f12502l = false;
        f12503m = C4591q.APP_CLOSE;
        m15825c(System.currentTimeMillis());
        C4686w.m16333h();
        if (f12501k) {
            C4601n2 n2Var = f12509s;
            if (n2Var != null) {
                n2Var.mo29890a();
            }
            if (f12495e == null) {
                m15789a(C4566a0.ERROR, "Android Context not found, please call OneSignal.init when your app starts.");
                return;
            }
            C4619q.m15979d().mo29910a();
            m15846f0();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b0 */
    public static void m15820b0() {
        m15752B().mo29783a(f12495e, f12494d, new C4587m());
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public static void m15829c0() {
        C4566a0 a0Var = C4566a0.DEBUG;
        m15789a(a0Var, "registerUser:registerForPushFired:" + f12469A + ", locationFired: " + f12470B + ", remoteParams: " + f12481M + ", appId: " + f12493c);
        if (f12469A && f12470B && f12481M != null && f12493c != null) {
            new Thread(new C4590p(), "OS_REG_USER").start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m15834d(int i) {
        return i < -6;
    }

    /* access modifiers changed from: private */
    /* renamed from: d0 */
    public static void m15836d0() throws JSONException {
        C4686w.C4693g gVar;
        String packageName = f12495e.getPackageName();
        PackageManager packageManager = f12495e.getPackageManager();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_id", m15753C());
        String a = f12513w.mo29732a(f12495e);
        if (a != null) {
            jSONObject.put("ad_id", a);
        }
        jSONObject.put("device_os", Build.VERSION.RELEASE);
        jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, m15758H());
        jSONObject.put("language", C4536k1.m15636e());
        jSONObject.put("sdk", "031302");
        jSONObject.put(TapjoyConstants.TJC_SDK_TYPE, f12514x);
        jSONObject.put("android_package", packageName);
        jSONObject.put("device_model", Build.MODEL);
        try {
            jSONObject.put("game_version", packageManager.getPackageInfo(packageName, 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put("net_type", f12515y.mo29828d());
        jSONObject.put("carrier", f12515y.mo29826b());
        jSONObject.put("rooted", C4561m2.m15739a());
        C4742z1.m16465a(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("identifier", f12516z);
        jSONObject2.put("subscribableStatus", f12500j);
        jSONObject2.put("androidPermission", m15861j());
        jSONObject2.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, f12515y.mo29827c());
        C4742z1.m16468b(jSONObject2);
        if (f12473E && (gVar = f12472D) != null) {
            C4742z1.m16464a(gVar);
        }
        C4742z1.m16469b(true);
        f12479K = false;
    }

    /* renamed from: e0 */
    public static boolean m15841e0() {
        return f12480L && !m15866k0();
    }

    /* renamed from: f0 */
    private static boolean m15846f0() {
        boolean h = C4742z1.m16478h();
        if (h) {
            C4469a2.m15414c(f12495e);
        }
        return C4686w.m16326b(f12495e) || h;
    }

    /* renamed from: g0 */
    private static boolean m15851g0() {
        if (f12501k && f12504n == null) {
            return false;
        }
        if (!f12501k && f12504n == null) {
            return true;
        }
        ExecutorService executorService = f12504n;
        if (executorService == null || executorService.isShutdown()) {
            return false;
        }
        return true;
    }

    /* renamed from: h0 */
    private static void m15855h0() {
        C4586l lVar = new C4586l();
        boolean z = true;
        boolean z2 = f12474F.f12545e && !f12471C;
        if (!f12471C && !f12474F.f12545e) {
            z = false;
        }
        f12471C = z;
        C4686w.m16319a(f12495e, z2, lVar);
    }

    /* renamed from: i0 */
    private static void m15859i0() {
        if (!f12505o.isEmpty()) {
            f12504n = Executors.newSingleThreadExecutor(new C4585k());
            while (!f12505o.isEmpty()) {
                f12504n.submit(f12505o.poll());
            }
        }
    }

    /* renamed from: j */
    private static boolean m15862j(Context context) {
        return context instanceof Activity;
    }

    /* renamed from: j0 */
    private static void m15863j0() {
        if (!f12479K) {
            f12479K = true;
            if (C4742z1.m16475e()) {
                f12470B = false;
            }
            m15855h0();
            f12469A = false;
            m15775Y();
        }
    }

    /* renamed from: k */
    public static void m15865k(Context context) {
        if (context == null) {
            m15789a(C4566a0.WARN, "setAppContext(null) is not valid, ignoring!");
            return;
        }
        boolean z = f12495e == null;
        Context applicationContext = context.getApplicationContext();
        f12495e = applicationContext;
        C4474b.m15422a((Application) applicationContext);
        if (z) {
            C4497e1 e1Var = new C4497e1(m15882x());
            f12511u = e1Var;
            f12512v = new C4487d2(e1Var, m15877s());
            C4698w1.m16350b();
            C4627q1.m16014a(context);
        }
    }

    /* renamed from: k0 */
    public static boolean m15866k0() {
        return m15754D();
    }

    /* renamed from: l */
    private static void m15868l(Context context) {
        try {
            m15844f("ENABLE".equalsIgnoreCase(context.getPackageManager().getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData.getString("com.onesignal.PrivacyConsent")));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: m */
    public static C4592r m15869m(Context context) {
        return new C4592r(context, (C4575f) null);
    }

    /* renamed from: n */
    static boolean m15872n(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return false;
        }
        launchIntentForPackage.setFlags(268566528);
        context.startActivity(launchIntentForPackage);
        return true;
    }

    /* renamed from: o */
    static void m15873o() {
        C4596v vVar = f12491a;
        if (vVar != null) {
            vVar.onSuccess();
            f12491a = null;
        }
    }

    /* renamed from: p */
    static void m15874p() {
        if (f12507q != null) {
            C4536k1.m15622a((Runnable) new C4569c());
        }
    }

    /* renamed from: q */
    static C4591q m15875q() {
        return f12503m;
    }

    /* renamed from: r */
    static boolean m15876r() {
        return C4698w1.m16348a(C4698w1.f12761a, "OS_CLEAR_GROUP_SUMMARY_CLICK", true);
    }

    /* renamed from: s */
    static C4655t1 m15877s() {
        return C4655t1.m16157a(f12495e);
    }

    /* renamed from: t */
    static String m15878t() {
        if (TextUtils.isEmpty(f12499i) && f12495e != null) {
            f12499i = C4698w1.m16344a(C4698w1.f12761a, "OS_EMAIL_ID", (String) null);
        }
        return f12499i;
    }

    /* renamed from: u */
    static boolean m15879u() {
        return C4698w1.m16348a(C4698w1.f12761a, "GT_FIREBASE_TRACKING_ENABLED", false);
    }

    /* renamed from: v */
    static boolean m15880v() {
        C4592r rVar = f12474F;
        if (rVar != null && rVar.f12550j == C4572d0.InAppAlert) {
            return true;
        }
        return false;
    }

    /* renamed from: w */
    private static long m15881w() {
        return C4698w1.m16341a(C4698w1.f12761a, "OS_LAST_SESSION_TIME", -31000);
    }

    /* renamed from: x */
    private static C4497e1.C4499b m15882x() {
        return new C4575f();
    }

    /* renamed from: y */
    static boolean m15883y() {
        C4592r rVar = f12474F;
        if (rVar == null || rVar.f12550j == C4572d0.Notification) {
            return true;
        }
        return false;
    }

    /* renamed from: z */
    static C4729y0<Object, C4468a1> m15884z() {
        if (f12484P == null) {
            f12484P = new C4729y0<>("onOSPermissionChanged", true);
        }
        return f12484P;
    }

    /* renamed from: e */
    static void m15838e(String str) {
        f12498h = str;
        if (f12495e != null) {
            C4698w1.m16353b(C4698w1.f12761a, "GT_PLAYER_ID", f12498h);
        }
    }

    /* renamed from: f */
    private static OSSubscriptionState m15842f(Context context) {
        if (context == null) {
            return null;
        }
        if (f12486R == null) {
            f12486R = new OSSubscriptionState(true, false);
        }
        return f12486R;
    }

    /* renamed from: g */
    private static String m15847g(Context context) {
        if (context == null) {
            return null;
        }
        return C4698w1.m16344a(C4698w1.f12761a, "GT_APP_ID", (String) null);
    }

    /* renamed from: h */
    static boolean m15854h(String str) {
        if (!m15841e0()) {
            return false;
        }
        if (str == null) {
            return true;
        }
        C4566a0 a0Var = C4566a0.WARN;
        m15789a(a0Var, "Method " + str + " was called before the user provided privacy consent. Your application is set to require the user's privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.userProvidedPrivacyConsent()");
        return true;
    }

    /* renamed from: i */
    private static void m15857i(Context context) {
        boolean j = m15862j(context);
        f12502l = j;
        if (j) {
            C4461a.f12260f = (Activity) context;
            C4495e0.m15481a(f12495e);
            C4619q.m15979d().mo29912b();
            return;
        }
        C4461a.f12255a = true;
    }

    /* renamed from: j */
    static void m15860j(String str) {
        m15838e(str);
        m15874p();
        m15767Q();
        m15830d(f12495e).mo29671b(str);
        C4598x xVar = f12489U;
        if (xVar != null) {
            m15799a(xVar.f12555a, xVar.f12556b, xVar.f12557c);
            f12489U = null;
        }
        C4742z1.m16479i();
        C4642s1.m16089a(f12493c, str, C4479c.m15437a());
    }

    /* renamed from: m */
    private static void m15870m() {
        for (JSONArray c : f12475G) {
            m15827c(c, true, false);
        }
        f12475G.clear();
    }

    /* renamed from: c */
    private static C4741z0 m15821c(Context context) {
        if (context == null) {
            return null;
        }
        if (f12482N == null) {
            C4741z0 z0Var = new C4741z0(false);
            f12482N = z0Var;
            z0Var.f12867a.mo30030b(new OSPermissionChangedInternalObserver());
        }
        return f12482N;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static OSSubscriptionState m15830d(Context context) {
        if (context == null) {
            return null;
        }
        if (f12485Q == null) {
            f12485Q = new OSSubscriptionState(false, m15821c(context).mo30039a());
            m15821c(context).f12867a.mo30029a(f12485Q);
            f12485Q.f12244a.mo30030b(new OSSubscriptionChangedInternalObserver());
        }
        return f12485Q;
    }

    /* renamed from: g */
    public static void m15850g(boolean z) {
        if (!m15854h("setSubscription()")) {
            C4577g gVar = new C4577g(z);
            if (f12495e == null || m15851g0()) {
                m15789a(C4566a0.ERROR, "OneSignal.init has not been called. Moving subscription action to a waiting task queue.");
                m15792a(new C4581h0(gVar));
                return;
            }
            gVar.run();
        }
    }

    /* renamed from: h */
    private static String m15852h(Context context) {
        if (context == null) {
            return null;
        }
        return C4698w1.m16344a(C4698w1.f12761a, "GT_PLAYER_ID", (String) null);
    }

    /* renamed from: n */
    static void m15871n() {
        C4596v vVar = f12491a;
        if (vVar != null) {
            vVar.mo29885a(new C4595u(C4594t.NETWORK, "Failed due to network failure. Will retry on next sync."));
            f12491a = null;
        }
    }

    /* renamed from: b */
    private static C4529j0 m15810b(Context context) {
        if (context == null) {
            return null;
        }
        if (f12488T == null) {
            C4529j0 j0Var = new C4529j0(false);
            f12488T = j0Var;
            j0Var.f12378a.mo30030b(new C4522i0());
        }
        return f12488T;
    }

    /* renamed from: e */
    static boolean m15840e(Context context) {
        return C4698w1.m16348a(C4698w1.f12761a, "OS_FILTER_OTHER_GCM_RECEIVERS", false);
    }

    /* renamed from: f */
    public static void m15844f(boolean z) {
        if (!f12480L || z) {
            f12480L = z;
        } else {
            m15789a(C4566a0.ERROR, "Cannot change requiresUserPrivacyConsent() from TRUE to FALSE");
        }
    }

    /* renamed from: e */
    static void m15839e(boolean z) {
        if (f12495e != null) {
            C4698w1.m16355b(C4698w1.f12761a, "OS_FILTER_OTHER_GCM_RECEIVERS", z);
        }
    }

    /* renamed from: l */
    private static void m15867l() {
        if (m15773W()) {
            C4742z1.m16481k();
            if (f12502l) {
                f12512v.mo29739a();
                f12511u.mo29754f();
            }
        } else if (f12502l) {
            C4548m0.m15715h().mo29838c();
            f12511u.mo29747a();
        }
        if (f12502l || !m15766P()) {
            m15825c(System.currentTimeMillis());
            m15863j0();
        }
    }

    /* renamed from: c */
    private static void m15827c(JSONArray jSONArray, boolean z, boolean z2) {
        C4592r rVar = f12474F;
        if (rVar == null || rVar.f12542b == null) {
            f12475G.add(jSONArray);
        } else {
            m15794a(m15781a(jSONArray, z, z2));
        }
    }

    /* renamed from: i */
    static void m15858i(String str) {
        m15832d(str);
        m15810b(f12495e).mo29799a(str);
        try {
            C4742z1.m16468b(new JSONObject().put("parent_player_id", str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public static void m15833d(JSONObject jSONObject) {
        m15801a(jSONObject, (C4593s) null);
    }

    /* renamed from: f */
    static void m15843f(String str) {
        m15795a(str, 0.0f);
    }

    /* renamed from: a */
    public static void m15785a(Context context, String str, String str2, C4568b0 b0Var, C4570c0 c0Var) {
        f12474F = m15779a(b0Var, c0Var);
        m15865k(context);
        m15868l(context);
        if (m15841e0()) {
            m15789a(C4566a0.VERBOSE, "OneSignal SDK initialization delayed, user privacy consent is set to required for this application.");
            new C4604o(context, str, str2, b0Var, c0Var);
            return;
        }
        f12474F = m15779a(b0Var, c0Var);
        if (!m15771U()) {
            f12494d = str;
        }
        f12500j = f12515y.mo29824a(context, str2);
        if (!m15774X()) {
            String str3 = f12493c;
            if (str3 != null && !str3.equals(str2)) {
                f12501k = false;
            }
            if (!f12501k) {
                f12493c = str2;
                m15839e(f12474F.f12548h);
                m15857i(context);
                C4742z1.m16477g();
                m15761K();
                m15762L();
                OSPermissionChangedInternalObserver.m15354b(m15821c(f12495e));
                m15867l();
                if (f12474F.f12542b != null) {
                    m15870m();
                }
                if (C4615p2.m15963a(f12495e)) {
                    f12508r = new C4615p2(f12495e);
                }
                if (C4608o2.m15929b()) {
                    f12510t = new C4608o2(f12495e);
                }
                C4539k2.m15650a(f12495e);
                f12501k = true;
                f12512v.mo29742b();
                m15859i0();
            } else if (f12474F.f12542b != null) {
                m15870m();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m15816b(C4592r rVar) {
        C4592r rVar2 = f12474F;
        if (rVar2.f12549i) {
            rVar.f12550j = rVar2.f12550j;
        }
        f12474F = rVar;
        Context context = rVar.f12541a;
        rVar.f12541a = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData;
            String string = bundle.getString("onesignal_google_project_number");
            if (string != null && string.length() > 4) {
                string = string.substring(4);
            }
            m15785a(context, string, bundle.getString("onesignal_app_id"), f12474F.f12542b, f12474F.f12543c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    static void m15832d(String str) {
        f12499i = str;
        if (f12495e != null) {
            C4698w1.m16353b(C4698w1.f12761a, "OS_EMAIL_ID", "".equals(f12499i) ? null : f12499i);
        }
    }

    /* renamed from: g */
    static void m15849g(String str) {
        C4487d2 d2Var = f12512v;
        if (d2Var == null) {
            m15789a(C4566a0.ERROR, "Make sure OneSignal.init is called first");
        } else {
            d2Var.mo29740a(str);
        }
    }

    /* renamed from: k */
    public static void m15864k() {
        C4582i iVar = new C4582i();
        if (f12495e == null || m15851g0()) {
            m15789a(C4566a0.ERROR, "OneSignal.init has not been called. Could not clear notifications at this time - moving this operation toa waiting task queue.");
            m15792a(new C4581h0(iVar));
            return;
        }
        iVar.run();
    }

    /* renamed from: c */
    private static void m15826c(String str) {
        if (f12495e != null) {
            C4698w1.m16353b(C4698w1.f12761a, "GT_APP_ID", str);
        }
    }

    /* renamed from: j */
    static boolean m15861j() {
        if (f12474F.f12547g) {
            return C4536k1.m15626a(f12495e);
        }
        return true;
    }

    /* renamed from: c */
    static void m15825c(long j) {
        C4698w1.m16352b(C4698w1.f12761a, "OS_LAST_SESSION_TIME", j);
    }

    /* renamed from: c */
    public static void m15824c(int i) {
        C4584j jVar = new C4584j(i);
        if (f12495e == null || m15851g0()) {
            C4566a0 a0Var = C4566a0.ERROR;
            m15789a(a0Var, "OneSignal.init has not been called. Could not clear notification id: " + i + " at this time - movingthis operation to a waiting task queue. The notification will still be canceledfrom NotificationManager at this time.");
            f12505o.add(jVar);
            return;
        }
        jVar.run();
    }

    /* renamed from: c */
    private static String m15822c(JSONObject jSONObject) {
        try {
            return new JSONObject(jSONObject.optString("custom")).optString("i", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m15814b(long j) {
        if (f12506p.get() == j) {
            m15789a(C4566a0.INFO, "Last Pending Task has ran, shutting down");
            f12504n.shutdown();
        }
    }

    /* renamed from: b */
    public static void m15815b(C4566a0 a0Var, String str) {
        m15789a(a0Var, str);
    }

    /* renamed from: b */
    private static boolean m15818b(Context context, JSONArray jSONArray) {
        String optString;
        if (m15854h((String) null)) {
            return false;
        }
        int length = jSONArray.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("custom")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
                    if (jSONObject2.has("u") && (optString = jSONObject2.optString("u", (String) null)) != null) {
                        C4536k1.m15632b(optString);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                C4566a0 a0Var = C4566a0.ERROR;
                m15790a(a0Var, "Error parsing JSON item " + i + "/" + length + " for launching a web URL.", th);
            }
        }
        return z;
    }

    /* renamed from: b */
    static void m15817b(JSONArray jSONArray, boolean z, boolean z2) {
        C4570c0 c0Var;
        C4697w0 a = m15781a(jSONArray, z, z2);
        if (f12510t != null && m15879u()) {
            f12510t.mo29894b(a);
        }
        C4592r rVar = f12474F;
        if (rVar != null && (c0Var = rVar.f12543c) != null) {
            c0Var.mo29863a(a.f12759a);
        }
    }

    /* renamed from: b */
    static String m15812b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("custom"));
            if (jSONObject2.has("i")) {
                return jSONObject2.optString("i", (String) null);
            }
            m15789a(C4566a0.DEBUG, "Not a OneSignal formatted GCM message. No 'i' field in custom.");
            return null;
        } catch (JSONException unused) {
            m15789a(C4566a0.DEBUG, "Not a OneSignal formatted GCM message. No 'custom' field in the JSONObject.");
        }
    }

    /* renamed from: a */
    private static C4592r m15779a(C4568b0 b0Var, C4570c0 c0Var) {
        C4592r rVar = f12474F;
        rVar.f12549i = false;
        rVar.f12542b = b0Var;
        rVar.f12543c = c0Var;
        return rVar;
    }

    /* renamed from: a */
    private static void m15792a(C4581h0 h0Var) {
        long unused = h0Var.f12534b = f12506p.incrementAndGet();
        ExecutorService executorService = f12504n;
        if (executorService == null) {
            C4566a0 a0Var = C4566a0.INFO;
            m15789a(a0Var, "Adding a task to the pending queue with ID: " + h0Var.f12534b);
            f12505o.add(h0Var);
        } else if (!executorService.isShutdown()) {
            C4566a0 a0Var2 = C4566a0.INFO;
            m15789a(a0Var2, "Executor is still running, add to the executor with ID: " + h0Var.f12534b);
            try {
                f12504n.submit(h0Var);
            } catch (RejectedExecutionException e) {
                C4566a0 a0Var3 = C4566a0.INFO;
                m15789a(a0Var3, "Executor is shutdown, running task manually with ID: " + h0Var.f12534b);
                h0Var.run();
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static boolean m15805a(C4566a0 a0Var) {
        return a0Var.compareTo(f12496f) < 1 || a0Var.compareTo(f12497g) < 1;
    }

    /* renamed from: a */
    static void m15789a(C4566a0 a0Var, String str) {
        m15790a(a0Var, str, (Throwable) null);
    }

    /* renamed from: a */
    static void m15790a(C4566a0 a0Var, String str, Throwable th) {
        if (!(a0Var.compareTo(f12497g) >= 1 || a0Var == C4566a0.VERBOSE || a0Var == C4566a0.DEBUG || a0Var == C4566a0.INFO)) {
            if (a0Var == C4566a0.WARN) {
                Log.w("OneSignal", str, th);
            } else if (a0Var == C4566a0.ERROR || a0Var == C4566a0.FATAL) {
                Log.e("OneSignal", str, th);
            }
        }
        if (a0Var.compareTo(f12496f) < 1 && C4461a.f12260f != null) {
            try {
                String str2 = str + "\n";
                if (th != null) {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    str2 = (str2 + th.getMessage()) + stringWriter.toString();
                }
                C4536k1.m15622a((Runnable) new C4589o(a0Var, str2));
            } catch (Throwable th2) {
                Log.e("OneSignal", "Error showing logging message.", th2);
            }
        }
    }

    /* renamed from: a */
    static void m15796a(String str, int i, Throwable th, String str2) {
        String str3;
        if (str2 == null || !m15805a(C4566a0.INFO)) {
            str3 = "";
        } else {
            str3 = "\n" + str2 + "\n";
        }
        m15790a(C4566a0.WARN, "HTTP code: " + i + " " + str + str3, th);
    }

    /* renamed from: a */
    static void m15800a(JSONObject jSONObject) {
        try {
            jSONObject.put("net_type", f12515y.mo29828d());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m15797a(String str, String str2) {
        if (!m15854h("sendTag()")) {
            try {
                m15833d(new JSONObject().put(str, str2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m15801a(JSONObject jSONObject, C4593s sVar) {
        if (!m15854h("sendTags()")) {
            C4565a aVar = new C4565a(jSONObject, sVar);
            if (f12495e == null || m15851g0()) {
                m15789a(C4566a0.ERROR, "You must initialize OneSignal before modifying tags!Moving this operation to a pending task queue.");
                if (sVar != null) {
                    sVar.mo29883a(new C4583i0(-1, "You must initialize OneSignal before modifying tags!Moving this operation to a pending task queue."));
                }
                m15792a(new C4581h0(aVar));
                return;
            }
            aVar.run();
        }
    }

    /* renamed from: a */
    public static void m15798a(JSONArray jSONArray, C4593s sVar) {
        if (!m15854h("deleteTags()")) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    jSONObject.put(jSONArray.getString(i), "");
                }
                m15801a(jSONObject, sVar);
            } catch (Throwable th) {
                m15790a(C4566a0.ERROR, "Failed to generate JSON for deleteTags.", th);
            }
        }
    }

    /* renamed from: a */
    static void m15799a(JSONArray jSONArray, boolean z, C4731y1.C4738g gVar) {
        if (!m15854h("sendPurchases()")) {
            if (m15759I() == null) {
                C4598x xVar = new C4598x(jSONArray);
                f12489U = xVar;
                xVar.f12556b = z;
                xVar.f12557c = gVar;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", m15753C());
                if (z) {
                    jSONObject.put(AdMostExperimentManager.EXPERIMENT_TYPE_EXISTING_USER, true);
                }
                jSONObject.put("purchases", jSONArray);
                C4731y1.m16446a("players/" + m15759I() + "/on_purchase", jSONObject, gVar);
                if (m15878t() != null) {
                    C4731y1.m16446a("players/" + m15878t() + "/on_purchase", jSONObject, (C4731y1.C4738g) null);
                }
            } catch (Throwable th) {
                m15790a(C4566a0.ERROR, "Failed to generate JSON for sendPurchases.", th);
            }
        }
    }

    /* renamed from: a */
    private static C4697w0 m15781a(JSONArray jSONArray, boolean z, boolean z2) {
        int length = jSONArray.length();
        C4697w0 w0Var = new C4697w0();
        C4667u0 u0Var = new C4667u0();
        m15769S();
        jSONArray.optJSONObject(0).optInt("notificationId");
        boolean z3 = true;
        String str = null;
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                u0Var.f12698a = C4714x.m16402a(jSONObject);
                if (str == null && jSONObject.has("actionSelected")) {
                    str = jSONObject.optString("actionSelected", (String) null);
                }
                if (z3) {
                    z3 = false;
                } else {
                    if (u0Var.f12700c == null) {
                        u0Var.f12700c = new ArrayList();
                    }
                    u0Var.f12700c.add(u0Var.f12698a);
                }
            } catch (Throwable th) {
                m15790a(C4566a0.ERROR, "Error parsing JSON item " + i + "/" + length + " for callback.", th);
            }
        }
        w0Var.f12759a = u0Var;
        w0Var.f12760b = new C4674v0();
        if (str != null) {
            C4674v0.C4675a aVar = C4674v0.C4675a.ActionTaken;
        } else {
            C4674v0.C4675a aVar2 = C4674v0.C4675a.Opened;
        }
        if (z2) {
            w0Var.f12759a.f12699b = C4667u0.C4668a.InAppAlert;
        } else {
            w0Var.f12759a.f12699b = C4667u0.C4668a.Notification;
        }
        return w0Var;
    }

    /* renamed from: a */
    private static void m15794a(C4697w0 w0Var) {
        C4536k1.m15622a((Runnable) new C4571d(w0Var));
    }

    /* renamed from: a */
    public static void m15787a(Context context, JSONArray jSONArray, boolean z, String str) {
        if (!m15854h((String) null)) {
            m15786a(context, jSONArray);
            if (f12510t != null && m15879u()) {
                f12510t.mo29893a(m15781a(jSONArray, true, z));
            }
            boolean z2 = false;
            boolean equals = "DISABLE".equals(C4536k1.m15630b(context, "com.onesignal.NotificationOpened.DEFAULT"));
            if (!equals) {
                z2 = m15818b(context, jSONArray);
            }
            if (m15804a(context, z, z2, equals)) {
                f12503m = C4591q.NOTIFICATION_CLICK;
                f12511u.mo29748a(str);
            }
            m15827c(jSONArray, true, z);
        }
    }

    /* renamed from: a */
    private static boolean m15804a(Context context, boolean z, boolean z2, boolean z3) {
        return !z && !z2 && !z3 && !f12502l && m15872n(context);
    }

    /* renamed from: a */
    private static void m15786a(Context context, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String optString = new JSONObject(jSONArray.getJSONObject(i).optString("custom", (String) null)).optString("i", (String) null);
                if (!f12476H.contains(optString)) {
                    f12476H.add(optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", m15847g(context));
                    jSONObject.put("player_id", m15852h(context));
                    jSONObject.put("opened", true);
                    jSONObject.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, f12515y.mo29827c());
                    C4731y1.m16451c("notifications/" + optString, jSONObject, new C4573e());
                }
            } catch (Throwable th) {
                m15790a(C4566a0.ERROR, "Failed to generate JSON to send notification opened.", th);
            }
        }
    }

    /* renamed from: a */
    static void m15791a(C4576f0 f0Var) {
        if (!m15854h("promptLocation()")) {
            C4579h hVar = new C4579h(f0Var);
            if (f12495e == null || m15851g0()) {
                m15789a(C4566a0.ERROR, "OneSignal.init has not been called. Could not prompt for location at this time - moving this operation to awaiting queue.");
                m15792a(new C4581h0(hVar));
                return;
            }
            hVar.run();
        }
    }

    /* renamed from: a */
    public static void m15788a(C4505f1 f1Var) {
        if (f12495e == null) {
            m15789a(C4566a0.ERROR, "OneSignal.init has not been called. Could not add subscription observer");
            return;
        }
        m15757G().mo30029a(f1Var);
        if (m15830d(f12495e).mo29670a(m15842f(f12495e))) {
            OSSubscriptionChangedInternalObserver.m15355a(m15830d(f12495e));
        }
    }

    /* renamed from: a */
    private static boolean m15806a(String str, Context context) {
        boolean z;
        if (str == null || "".equals(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            Cursor query = C4655t1.m16157a(context).mo29963d().query("notification", new String[]{TapjoyConstants.TJC_NOTIFICATION_ID}, "notification_id = ?", new String[]{str}, (String) null, (String) null, (String) null);
            z = query.moveToFirst();
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (!z) {
            return false;
        }
        C4566a0 a0Var = C4566a0.DEBUG;
        m15789a(a0Var, "Duplicate GCM message received, skip processing of " + str);
        return true;
    }

    /* renamed from: a */
    static boolean m15803a(Context context, JSONObject jSONObject) {
        String c = m15822c(jSONObject);
        return c == null || m15806a(c, context);
    }

    /* renamed from: a */
    static String m15782a(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            try {
                if (bundle.containsKey("custom")) {
                    JSONObject jSONObject = new JSONObject(bundle.getString("custom"));
                    if (jSONObject.has("i")) {
                        return jSONObject.optString("i", (String) null);
                    }
                    m15789a(C4566a0.DEBUG, "Not a OneSignal formatted GCM message. No 'i' field in custom.");
                } else {
                    m15789a(C4566a0.DEBUG, "Not a OneSignal formatted GCM message. No 'custom' field in the bundle.");
                }
            } catch (Throwable th) {
                m15790a(C4566a0.DEBUG, "Could not parse bundle, probably not a OneSignal notification.", th);
            }
        }
        return null;
    }

    /* renamed from: a */
    static void m15795a(String str, float f) {
        C4487d2 d2Var = f12512v;
        if (d2Var == null) {
            m15789a(C4566a0.ERROR, "Make sure OneSignal.init is called first");
        } else {
            d2Var.mo29741a(str, f);
        }
    }
}
