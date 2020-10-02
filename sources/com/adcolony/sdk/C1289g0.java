package com.adcolony.sdk;

import android.content.Context;
import android.os.StatFs;
import com.adcolony.sdk.C1439u;
import java.io.File;

/* renamed from: com.adcolony.sdk.g0 */
class C1289g0 {

    /* renamed from: a */
    private String f4078a;

    /* renamed from: b */
    private String f4079b;

    /* renamed from: c */
    private String f4080c;

    /* renamed from: d */
    private String f4081d;

    /* renamed from: e */
    private File f4082e;

    /* renamed from: f */
    private File f4083f;

    /* renamed from: g */
    private File f4084g;

    C1289g0() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public double mo6508a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return (double) (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()));
        } catch (RuntimeException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo6510b() {
        return this.f4080c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo6511c() {
        return this.f4079b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo6512d() {
        return this.f4081d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo6513e() {
        C1290h c = C1199a.m4880c();
        this.f4078a = mo6514f() + "/adc3/";
        this.f4079b = this.f4078a + "media/";
        File file = new File(this.f4079b);
        this.f4082e = file;
        if (!file.isDirectory()) {
            this.f4082e.delete();
            this.f4082e.mkdirs();
        }
        if (!this.f4082e.isDirectory()) {
            c.mo6533b(true);
            return false;
        } else if (mo6508a(this.f4079b) < 2.097152E7d) {
            new C1439u.C1440a().mo6801a("Not enough memory available at media path, disabling AdColony.").mo6803a(C1439u.f4514g);
            c.mo6533b(true);
            return false;
        } else {
            this.f4080c = mo6514f() + "/adc3/data/";
            File file2 = new File(this.f4080c);
            this.f4083f = file2;
            if (!file2.isDirectory()) {
                this.f4083f.delete();
            }
            this.f4083f.mkdirs();
            this.f4081d = this.f4078a + "tmp/";
            File file3 = new File(this.f4081d);
            this.f4084g = file3;
            if (!file3.isDirectory()) {
                this.f4084g.delete();
                this.f4084g.mkdirs();
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo6514f() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return "";
        }
        return b.getFilesDir().getAbsolutePath();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo6515g() {
        File file = this.f4082e;
        if (file == null || this.f4083f == null || this.f4084g == null) {
            return false;
        }
        if (!file.isDirectory()) {
            this.f4082e.delete();
        }
        if (!this.f4083f.isDirectory()) {
            this.f4083f.delete();
        }
        if (!this.f4084g.isDirectory()) {
            this.f4084g.delete();
        }
        this.f4082e.mkdirs();
        this.f4083f.mkdirs();
        this.f4084g.mkdirs();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo6509a() {
        return this.f4078a;
    }
}
