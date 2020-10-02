package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.adcolony.sdk.C1439u;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.k */
class C1353k {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1454x f4245a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AlertDialog f4246b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f4247c;

    /* renamed from: com.adcolony.sdk.k$a */
    class C1354a implements C1458z {
        C1354a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (!C1199a.m4881d() || !(C1199a.m4878b() instanceof Activity)) {
                new C1439u.C1440a().mo6801a("Missing Activity reference, can't build AlertDialog.").mo6803a(C1439u.f4517j);
            } else if (C1437s.m5608d(xVar.mo6830b(), "on_resume")) {
                C1454x unused = C1353k.this.f4245a = xVar;
            } else {
                C1353k.this.m5286a(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.k$b */
    class C1355b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C1454x f4249a;

        C1355b(C1454x xVar) {
            this.f4249a = xVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog unused = C1353k.this.f4246b = null;
            dialogInterface.dismiss();
            JSONObject b = C1437s.m5599b();
            C1437s.m5603b(b, "positive", true);
            boolean unused2 = C1353k.this.f4247c = false;
            this.f4249a.mo6829a(b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.k$c */
    class C1356c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C1454x f4251a;

        C1356c(C1454x xVar) {
            this.f4251a = xVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog unused = C1353k.this.f4246b = null;
            dialogInterface.dismiss();
            JSONObject b = C1437s.m5599b();
            C1437s.m5603b(b, "positive", false);
            boolean unused2 = C1353k.this.f4247c = false;
            this.f4251a.mo6829a(b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.k$d */
    class C1357d implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        final /* synthetic */ C1454x f4253a;

        C1357d(C1454x xVar) {
            this.f4253a = xVar;
        }

        public void onCancel(DialogInterface dialogInterface) {
            AlertDialog unused = C1353k.this.f4246b = null;
            boolean unused2 = C1353k.this.f4247c = false;
            JSONObject b = C1437s.m5599b();
            C1437s.m5603b(b, "positive", false);
            this.f4253a.mo6829a(b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.k$e */
    class C1358e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AlertDialog.Builder f4255a;

        C1358e(AlertDialog.Builder builder) {
            this.f4255a = builder;
        }

        public void run() {
            boolean unused = C1353k.this.f4247c = true;
            AlertDialog unused2 = C1353k.this.f4246b = this.f4255a.show();
        }
    }

    C1353k() {
        C1199a.m4876a("Alert.show", (C1458z) new C1354a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6666c() {
        C1454x xVar = this.f4245a;
        if (xVar != null) {
            m5286a(xVar);
            this.f4245a = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6665b() {
        return this.f4247c;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void m5286a(C1454x xVar) {
        Context b = C1199a.m4878b();
        if (b != null) {
            AlertDialog.Builder builder = Build.VERSION.SDK_INT >= 21 ? new AlertDialog.Builder(b, 16974374) : new AlertDialog.Builder(b, 16974126);
            JSONObject b2 = xVar.mo6830b();
            String h = C1437s.m5613h(b2, "message");
            String h2 = C1437s.m5613h(b2, "title");
            String h3 = C1437s.m5613h(b2, "positive");
            String h4 = C1437s.m5613h(b2, "negative");
            builder.setMessage(h);
            builder.setTitle(h2);
            builder.setPositiveButton(h3, new C1355b(xVar));
            if (!h4.equals("")) {
                builder.setNegativeButton(h4, new C1356c(xVar));
            }
            builder.setOnCancelListener(new C1357d(xVar));
            C1359k0.m5309a((Runnable) new C1358e(builder));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AlertDialog mo6663a() {
        return this.f4246b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6664a(AlertDialog alertDialog) {
        this.f4246b = alertDialog;
    }
}
