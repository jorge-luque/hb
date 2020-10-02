package com.adcolony.sdk;

import com.adcolony.sdk.C1439u;
import com.facebook.GraphResponse;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.p */
class C1413p {

    /* renamed from: a */
    private LinkedList<Runnable> f4461a = new LinkedList<>();

    /* renamed from: b */
    private boolean f4462b;

    /* renamed from: com.adcolony.sdk.p$a */
    class C1414a implements C1458z {

        /* renamed from: com.adcolony.sdk.p$a$a */
        class C1415a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4464a;

            C1415a(C1454x xVar) {
                this.f4464a = xVar;
            }

            public void run() {
                boolean unused = C1413p.this.m5546g(this.f4464a);
                C1413p.this.m5526a();
            }
        }

        C1414a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1413p.this.m5529a((Runnable) new C1415a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$b */
    class C1416b implements C1458z {

        /* renamed from: com.adcolony.sdk.p$b$a */
        class C1417a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4467a;

            C1417a(C1454x xVar) {
                this.f4467a = xVar;
            }

            public void run() {
                boolean unused = C1413p.this.m5533a(this.f4467a, new File(C1437s.m5613h(this.f4467a.mo6830b(), "filepath")));
                C1413p.this.m5526a();
            }
        }

        C1416b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1413p.this.m5529a((Runnable) new C1417a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$c */
    class C1418c implements C1458z {

        /* renamed from: com.adcolony.sdk.p$c$a */
        class C1419a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4470a;

            C1419a(C1454x xVar) {
                this.f4470a = xVar;
            }

            public void run() {
                boolean unused = C1413p.this.m5540d(this.f4470a);
                C1413p.this.m5526a();
            }
        }

        C1418c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1413p.this.m5529a((Runnable) new C1419a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$d */
    class C1420d implements C1458z {

        /* renamed from: com.adcolony.sdk.p$d$a */
        class C1421a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4473a;

            C1421a(C1454x xVar) {
                this.f4473a = xVar;
            }

            public void run() {
                String unused = C1413p.this.m5541e(this.f4473a);
                C1413p.this.m5526a();
            }
        }

        C1420d() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1413p.this.m5529a((Runnable) new C1421a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$e */
    class C1422e implements C1458z {

        /* renamed from: com.adcolony.sdk.p$e$a */
        class C1423a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4476a;

            C1423a(C1454x xVar) {
                this.f4476a = xVar;
            }

            public void run() {
                boolean unused = C1413p.this.m5544f(this.f4476a);
                C1413p.this.m5526a();
            }
        }

        C1422e() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1413p.this.m5529a((Runnable) new C1423a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$f */
    class C1424f implements C1458z {

        /* renamed from: com.adcolony.sdk.p$f$a */
        class C1425a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4479a;

            C1425a(C1454x xVar) {
                this.f4479a = xVar;
            }

            public void run() {
                boolean unused = C1413p.this.m5536b(this.f4479a);
                C1413p.this.m5526a();
            }
        }

        C1424f() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1413p.this.m5529a((Runnable) new C1425a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$g */
    class C1426g implements C1458z {

        /* renamed from: com.adcolony.sdk.p$g$a */
        class C1427a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4482a;

            C1427a(C1454x xVar) {
                this.f4482a = xVar;
            }

            public void run() {
                boolean unused = C1413p.this.m5538c(this.f4482a);
                C1413p.this.m5526a();
            }
        }

        C1426g() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1413p.this.m5529a((Runnable) new C1427a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$h */
    class C1428h implements C1458z {

        /* renamed from: com.adcolony.sdk.p$h$a */
        class C1429a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4485a;

            C1429a(C1454x xVar) {
                this.f4485a = xVar;
            }

            public void run() {
                boolean unused = C1413p.this.m5548h(this.f4485a);
                C1413p.this.m5526a();
            }
        }

        C1428h() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1413p.this.m5529a((Runnable) new C1429a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$i */
    class C1430i implements C1458z {

        /* renamed from: com.adcolony.sdk.p$i$a */
        class C1431a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4488a;

            C1431a(C1454x xVar) {
                this.f4488a = xVar;
            }

            public void run() {
                boolean unused = C1413p.this.m5532a(this.f4488a);
                C1413p.this.m5526a();
            }
        }

        C1430i() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1413p.this.m5529a((Runnable) new C1431a(xVar));
        }
    }

    C1413p() {
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m5538c(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        String h = C1437s.m5613h(b, "filepath");
        C1199a.m4880c().mo6555v().mo6515g();
        JSONObject b2 = C1437s.m5599b();
        try {
            int f = C1437s.m5611f(b, "offset");
            int f2 = C1437s.m5611f(b, "size");
            boolean d = C1437s.m5608d(b, "gunzip");
            String h2 = C1437s.m5613h(b, "output_filepath");
            InputStream h0Var = new C1313h0(new FileInputStream(h), f, f2);
            if (d) {
                h0Var = new GZIPInputStream(h0Var, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            }
            if (h2.equals("")) {
                StringBuilder sb = new StringBuilder(h0Var.available());
                byte[] bArr = new byte[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
                while (true) {
                    int read = h0Var.read(bArr, 0, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
                    if (read < 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, StandardCharsets.ISO_8859_1));
                }
                C1437s.m5602b(b2, "size", sb.length());
                C1437s.m5592a(b2, "data", sb.toString());
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(h2);
                byte[] bArr2 = new byte[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
                int i = 0;
                while (true) {
                    int read2 = h0Var.read(bArr2, 0, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
                    if (read2 < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr2, 0, read2);
                    i += read2;
                }
                fileOutputStream.close();
                C1437s.m5602b(b2, "size", i);
            }
            h0Var.close();
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b2).mo6834d();
            return true;
        } catch (IOException unused) {
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, false);
            xVar.mo6829a(b2).mo6834d();
            return false;
        } catch (OutOfMemoryError unused2) {
            new C1439u.C1440a().mo6801a("Out of memory error - disabling AdColony.").mo6803a(C1439u.f4516i);
            C1199a.m4880c().mo6533b(true);
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, false);
            xVar.mo6829a(b2).mo6834d();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m5540d(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "filepath");
        C1199a.m4880c().mo6555v().mo6515g();
        JSONObject b = C1437s.m5599b();
        String[] list = new File(h).list();
        if (list != null) {
            JSONArray a = C1437s.m5579a();
            for (String str : list) {
                JSONObject b2 = C1437s.m5599b();
                C1437s.m5592a(b2, "filename", str);
                if (new File(h + str).isDirectory()) {
                    C1437s.m5603b(b2, "is_folder", true);
                } else {
                    C1437s.m5603b(b2, "is_folder", false);
                }
                C1437s.m5586a(a, (Object) b2);
            }
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            C1437s.m5593a(b, "entries", a);
            xVar.mo6829a(b).mo6834d();
            return true;
        }
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b).mo6834d();
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public String m5541e(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        String h = C1437s.m5613h(b, "filepath");
        String h2 = C1437s.m5613h(b, "encoding");
        boolean z = h2 != null && h2.equals("utf8");
        C1199a.m4880c().mo6555v().mo6515g();
        JSONObject b2 = C1437s.m5599b();
        try {
            StringBuilder a = mo6777a(h, z);
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, true);
            C1437s.m5592a(b2, "data", a.toString());
            xVar.mo6829a(b2).mo6834d();
            return a.toString();
        } catch (IOException unused) {
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, false);
            xVar.mo6829a(b2).mo6834d();
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m5544f(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        String h = C1437s.m5613h(b, "filepath");
        String h2 = C1437s.m5613h(b, "new_filepath");
        C1199a.m4880c().mo6555v().mo6515g();
        JSONObject b2 = C1437s.m5599b();
        try {
            if (new File(h).renameTo(new File(h2))) {
                C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, true);
                xVar.mo6829a(b2).mo6834d();
                return true;
            }
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, false);
            xVar.mo6829a(b2).mo6834d();
            return false;
        } catch (Exception unused) {
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, false);
            xVar.mo6829a(b2).mo6834d();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m5546g(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        String h = C1437s.m5613h(b, "filepath");
        String h2 = C1437s.m5613h(b, "data");
        boolean equals = C1437s.m5613h(b, "encoding").equals("utf8");
        C1199a.m4880c().mo6555v().mo6515g();
        JSONObject b2 = C1437s.m5599b();
        try {
            mo6778a(h, h2, equals);
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b2).mo6834d();
            return true;
        } catch (IOException unused) {
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, false);
            xVar.mo6829a(b2).mo6834d();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f7, code lost:
        new com.adcolony.sdk.C1439u.C1440a().mo6801a("Out of memory error - disabling AdColony.").mo6803a(com.adcolony.sdk.C1439u.f4516i);
        com.adcolony.sdk.C1199a.m4880c().mo6533b(true);
        com.adcolony.sdk.C1437s.m5603b(r5, com.facebook.GraphResponse.SUCCESS_KEY, false);
        r0.mo6829a(r5).mo6834d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x011a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x011b, code lost:
        r2 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:1:0x0029] */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m5548h(com.adcolony.sdk.C1454x r20) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "success"
            org.json.JSONObject r2 = r20.mo6830b()
            java.lang.String r3 = "filepath"
            java.lang.String r3 = com.adcolony.sdk.C1437s.m5613h(r2, r3)
            java.lang.String r4 = "bundle_path"
            java.lang.String r4 = com.adcolony.sdk.C1437s.m5613h(r2, r4)
            java.lang.String r5 = "bundle_filenames"
            org.json.JSONArray r2 = com.adcolony.sdk.C1437s.m5604c((org.json.JSONObject) r2, (java.lang.String) r5)
            com.adcolony.sdk.h r5 = com.adcolony.sdk.C1199a.m4880c()
            com.adcolony.sdk.g0 r5 = r5.mo6555v()
            r5.mo6515g()
            org.json.JSONObject r5 = com.adcolony.sdk.C1437s.m5599b()
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r8.<init>(r4)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.String r10 = "r"
            r9.<init>(r8, r10)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r10 = 32
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r11 = r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r12.<init>()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r14 = new byte[r13]     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r15 = 0
        L_0x004a:
            if (r15 >= r11) goto L_0x00dd
            int r16 = r15 * 44
            int r6 = r16 + 8
            r17 = r8
            long r7 = (long) r6     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r9.seek(r7)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r9.read(r10)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r6 = r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r7 = r9.readInt()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r12.put(r7)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00b3 }
            r8.<init>()     // Catch:{ JSONException -> 0x00b3 }
            r8.append(r3)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.Object r13 = r2.get(r15)     // Catch:{ JSONException -> 0x00b3 }
            r8.append(r13)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00b3 }
            r18 = r2
            r13 = r3
            long r2 = (long) r6
            r9.seek(r2)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.<init>(r8)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r3 = r7 / 1024
            int r7 = r7 % 1024
            r6 = 0
        L_0x008b:
            if (r6 >= r3) goto L_0x009d
            r16 = r3
            r3 = 1024(0x400, float:1.435E-42)
            r8 = 0
            r9.read(r14, r8, r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.write(r14, r8, r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r6 = r6 + 1
            r3 = r16
            goto L_0x008b
        L_0x009d:
            r3 = 1024(0x400, float:1.435E-42)
            r8 = 0
            r9.read(r14, r8, r7)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.write(r14, r8, r7)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.close()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            int r15 = r15 + 1
            r3 = r13
            r8 = r17
            r2 = r18
            r13 = 1024(0x400, float:1.435E-42)
            goto L_0x004a
        L_0x00b3:
            com.adcolony.sdk.u$a r2 = new com.adcolony.sdk.u$a     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.<init>()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.String r3 = "Couldn't extract file name at index "
            com.adcolony.sdk.u$a r2 = r2.mo6801a((java.lang.String) r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.u$a r2 = r2.mo6799a((int) r15)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.String r3 = " unpacking ad unit bundle at "
            com.adcolony.sdk.u$a r2 = r2.mo6801a((java.lang.String) r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.u$a r2 = r2.mo6801a((java.lang.String) r4)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.u r3 = com.adcolony.sdk.C1439u.f4516i     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.mo6803a((com.adcolony.sdk.C1439u) r3)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2 = 0
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r5, (java.lang.String) r1, (boolean) r2)     // Catch:{ IOException -> 0x011c, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.x r3 = r0.mo6829a((org.json.JSONObject) r5)     // Catch:{ IOException -> 0x011c, OutOfMemoryError -> 0x00f7 }
            r3.mo6834d()     // Catch:{ IOException -> 0x011c, OutOfMemoryError -> 0x00f7 }
            return r2
        L_0x00dd:
            r17 = r8
            r9.close()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r17.delete()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2 = 1
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r5, (java.lang.String) r1, (boolean) r2)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            java.lang.String r2 = "file_sizes"
            com.adcolony.sdk.C1437s.m5593a((org.json.JSONObject) r5, (java.lang.String) r2, (org.json.JSONArray) r12)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            com.adcolony.sdk.x r2 = r0.mo6829a((org.json.JSONObject) r5)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r2.mo6834d()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f7 }
            r0 = 1
            return r0
        L_0x00f7:
            com.adcolony.sdk.u$a r2 = new com.adcolony.sdk.u$a
            r2.<init>()
            java.lang.String r3 = "Out of memory error - disabling AdColony."
            com.adcolony.sdk.u$a r2 = r2.mo6801a((java.lang.String) r3)
            com.adcolony.sdk.u r3 = com.adcolony.sdk.C1439u.f4516i
            r2.mo6803a((com.adcolony.sdk.C1439u) r3)
            com.adcolony.sdk.h r2 = com.adcolony.sdk.C1199a.m4880c()
            r3 = 1
            r2.mo6533b((boolean) r3)
            r2 = 0
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r5, (java.lang.String) r1, (boolean) r2)
            com.adcolony.sdk.x r0 = r0.mo6829a((org.json.JSONObject) r5)
            r0.mo6834d()
            return r2
        L_0x011b:
            r2 = 0
        L_0x011c:
            com.adcolony.sdk.u$a r3 = new com.adcolony.sdk.u$a
            r3.<init>()
            java.lang.String r6 = "Failed to find or open ad unit bundle at path: "
            com.adcolony.sdk.u$a r3 = r3.mo6801a((java.lang.String) r6)
            com.adcolony.sdk.u$a r3 = r3.mo6801a((java.lang.String) r4)
            com.adcolony.sdk.u r4 = com.adcolony.sdk.C1439u.f4517j
            r3.mo6803a((com.adcolony.sdk.C1439u) r4)
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r5, (java.lang.String) r1, (boolean) r2)
            com.adcolony.sdk.x r0 = r0.mo6829a((org.json.JSONObject) r5)
            r0.mo6834d()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1413p.m5548h(com.adcolony.sdk.x):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6780b() {
        C1199a.m4876a("FileSystem.save", (C1458z) new C1414a());
        C1199a.m4876a("FileSystem.delete", (C1458z) new C1416b());
        C1199a.m4876a("FileSystem.listing", (C1458z) new C1418c());
        C1199a.m4876a("FileSystem.load", (C1458z) new C1420d());
        C1199a.m4876a("FileSystem.rename", (C1458z) new C1422e());
        C1199a.m4876a("FileSystem.exists", (C1458z) new C1424f());
        C1199a.m4876a("FileSystem.extract", (C1458z) new C1426g());
        C1199a.m4876a("FileSystem.unpack_bundle", (C1458z) new C1428h());
        C1199a.m4876a("FileSystem.create_directory", (C1458z) new C1430i());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6778a(String str, String str2, boolean z) throws IOException {
        BufferedWriter bufferedWriter = z ? new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str), StandardCharsets.UTF_8)) : new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str)));
        bufferedWriter.write(str2);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5533a(C1454x xVar, File file) {
        C1199a.m4880c().mo6555v().mo6515g();
        JSONObject b = C1437s.m5599b();
        if (mo6779a(file)) {
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
            return true;
        }
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b).mo6834d();
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m5536b(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "filepath");
        C1199a.m4880c().mo6555v().mo6515g();
        JSONObject b = C1437s.m5599b();
        try {
            boolean a = m5534a(h);
            C1437s.m5603b(b, "result", a);
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
            return a;
        } catch (Exception e) {
            C1437s.m5603b(b, "result", false);
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
            xVar.mo6829a(b).mo6834d();
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6779a(File file) {
        try {
            if (!file.isDirectory()) {
                return file.delete();
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            String[] list = file.list();
            if (list.length > 0) {
                return mo6779a(new File(file, list[0]));
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public StringBuilder mo6777a(String str, boolean z) throws IOException {
        BufferedReader bufferedReader;
        File file = new File(str);
        StringBuilder sb = new StringBuilder((int) file.length());
        if (z) {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), StandardCharsets.UTF_8));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append("\n");
            } else {
                bufferedReader.close();
                return sb;
            }
        }
    }

    /* renamed from: a */
    private boolean m5534a(String str) {
        return new File(str).exists();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5532a(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "filepath");
        C1199a.m4880c().mo6555v().mo6515g();
        JSONObject b = C1437s.m5599b();
        try {
            if (new File(h).mkdir()) {
                C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
                xVar.mo6829a(b).mo6834d();
                return true;
            }
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
            return false;
        } catch (Exception unused) {
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
            xVar.mo6829a(b).mo6834d();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5529a(Runnable runnable) {
        if (!this.f4461a.isEmpty() || this.f4462b) {
            this.f4461a.push(runnable);
            return;
        }
        this.f4462b = true;
        runnable.run();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5526a() {
        this.f4462b = false;
        if (!this.f4461a.isEmpty()) {
            this.f4462b = true;
            this.f4461a.removeLast().run();
        }
    }
}
