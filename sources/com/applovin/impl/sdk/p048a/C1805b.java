package com.applovin.impl.sdk.p048a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1841c;

/* renamed from: com.applovin.impl.sdk.a.b */
public class C1805b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f5589a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Activity f5590b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialog f5591c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1813a f5592d;

    /* renamed from: com.applovin.impl.sdk.a.b$a */
    public interface C1813a {
        /* renamed from: a */
        void mo7341a();

        /* renamed from: b */
        void mo7342b();
    }

    public C1805b(Activity activity, C1941j jVar) {
        this.f5589a = jVar;
        this.f5590b = activity;
    }

    /* renamed from: a */
    public void mo8089a() {
        this.f5590b.runOnUiThread(new Runnable() {
            public void run() {
                if (C1805b.this.f5591c != null) {
                    C1805b.this.f5591c.dismiss();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo8090a(C1813a aVar) {
        this.f5592d = aVar;
    }

    /* renamed from: b */
    public void mo8091b() {
        this.f5590b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog unused = C1805b.this.f5591c = new AlertDialog.Builder(C1805b.this.f5590b).setTitle((CharSequence) C1805b.this.f5589a.mo8549a(C1841c.f5865bL)).setMessage((CharSequence) C1805b.this.f5589a.mo8549a(C1841c.f5866bM)).setCancelable(false).setPositiveButton((CharSequence) C1805b.this.f5589a.mo8549a(C1841c.f5868bO), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1805b.this.f5592d.mo7341a();
                    }
                }).setNegativeButton((CharSequence) C1805b.this.f5589a.mo8549a(C1841c.f5867bN), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1805b.this.f5592d.mo7342b();
                    }
                }).show();
            }
        });
    }

    /* renamed from: c */
    public void mo8092c() {
        this.f5590b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(C1805b.this.f5590b);
                builder.setTitle((CharSequence) C1805b.this.f5589a.mo8549a(C1841c.f5870bQ));
                builder.setMessage((CharSequence) C1805b.this.f5589a.mo8549a(C1841c.f5871bR));
                builder.setCancelable(false);
                builder.setPositiveButton((CharSequence) C1805b.this.f5589a.mo8549a(C1841c.f5873bT), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1805b.this.f5592d.mo7341a();
                    }
                });
                builder.setNegativeButton((CharSequence) C1805b.this.f5589a.mo8549a(C1841c.f5872bS), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1805b.this.f5592d.mo7342b();
                    }
                });
                AlertDialog unused = C1805b.this.f5591c = builder.show();
            }
        });
    }

    /* renamed from: d */
    public boolean mo8093d() {
        AlertDialog alertDialog = this.f5591c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}
