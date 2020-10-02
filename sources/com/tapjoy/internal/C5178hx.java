package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

/* renamed from: com.tapjoy.internal.hx */
public final class C5178hx {

    /* renamed from: e */
    public static final C4911bi f14183e = new C4911bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            return new C5178hx(bnVar);
        }
    };

    /* renamed from: f */
    private static final C3121an f14184f;

    /* renamed from: a */
    public URL f14185a;

    /* renamed from: b */
    public Bitmap f14186b;

    /* renamed from: c */
    public byte[] f14187c;

    /* renamed from: d */
    public C5189ie f14188d;

    /* JADX WARNING: type inference failed for: r1v1, types: [com.tapjoy.internal.ap$a] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            com.tapjoy.internal.ar r0 = new com.tapjoy.internal.ar
            r0.<init>()
            boolean r1 = r0 instanceof com.tapjoy.internal.C4895as
            if (r1 == 0) goto L_0x000a
            goto L_0x0010
        L_0x000a:
            com.tapjoy.internal.ap$a r1 = new com.tapjoy.internal.ap$a
            r1.<init>(r0)
            r0 = r1
        L_0x0010:
            f14184f = r0
            com.tapjoy.internal.hx$1 r0 = new com.tapjoy.internal.hx$1
            r0.<init>()
            f14183e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5178hx.<clinit>():void");
    }

    public C5178hx(URL url) {
        this.f14185a = url;
    }

    /* renamed from: a */
    public final boolean mo31346a() {
        return (this.f14186b == null && this.f14187c == null) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0051  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo31347b() {
        /*
            r14 = this;
            com.tapjoy.internal.fy r0 = com.tapjoy.internal.C5106ga.m17239b()
            r1 = 1
            java.lang.String r2 = "mm_external_cache_enabled"
            boolean r0 = r0.mo18532a(r2, r1)
            r1 = r0 ^ 1
            if (r1 == 0) goto L_0x001e
            com.tapjoy.internal.an r2 = f14184f
            java.net.URL r3 = r14.f14185a
            java.lang.Object r2 = r2.mo18472a(r3)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            r14.f14186b = r2
            if (r2 == 0) goto L_0x001e
            return
        L_0x001e:
            if (r0 == 0) goto L_0x005f
            com.tapjoy.internal.ht r2 = com.tapjoy.internal.C5170ht.f14164a
            java.net.URL r3 = r14.f14185a
            java.io.File r2 = r2.mo31339a((java.net.URL) r3)
            if (r2 == 0) goto L_0x005f
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0041, all -> 0x003c }
            r4.<init>(r2)     // Catch:{ IOException -> 0x0041, all -> 0x003c }
            r14.m17413a(r4)     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
            com.tapjoy.internal.C3168jz.m10439a(r4)
            goto L_0x0044
        L_0x0037:
            r0 = move-exception
            r3 = r4
            goto L_0x003d
        L_0x003a:
            r3 = r4
            goto L_0x0041
        L_0x003c:
            r0 = move-exception
        L_0x003d:
            com.tapjoy.internal.C3168jz.m10439a(r3)
            throw r0
        L_0x0041:
            com.tapjoy.internal.C3168jz.m10439a(r3)
        L_0x0044:
            android.graphics.Bitmap r3 = r14.f14186b
            if (r3 != 0) goto L_0x0051
            byte[] r3 = r14.f14187c
            if (r3 == 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            r2.delete()
            goto L_0x005f
        L_0x0051:
            if (r1 == 0) goto L_0x005e
            android.graphics.Bitmap r0 = r14.f14186b
            if (r0 == 0) goto L_0x005e
            com.tapjoy.internal.an r1 = f14184f
            java.net.URL r2 = r14.f14185a
            r1.mo18473a(r2, r0)
        L_0x005e:
            return
        L_0x005f:
            java.net.URL r2 = r14.f14185a
            java.net.URLConnection r2 = com.tapjoy.internal.C5081fj.m17187a(r2)
            r3 = 0
            java.lang.String r5 = "Cache-Control"
            java.lang.String r5 = r2.getHeaderField(r5)
            boolean r6 = com.tapjoy.internal.C3166jq.m10436c(r5)
            if (r6 != 0) goto L_0x0099
            java.lang.String r6 = ","
            java.lang.String[] r5 = r5.split(r6)
            int r6 = r5.length
            r7 = 0
        L_0x007b:
            if (r7 >= r6) goto L_0x0099
            r8 = r5[r7]
            java.lang.String r8 = r8.trim()
            java.lang.String r9 = "max-age="
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0096
            r5 = 8
            java.lang.String r5 = r8.substring(r5)
            long r3 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x0099 }
            goto L_0x0099
        L_0x0096:
            int r7 = r7 + 1
            goto L_0x007b
        L_0x0099:
            r12 = r3
            java.io.InputStream r2 = r2.getInputStream()
            java.io.ByteArrayInputStream r11 = r14.m17413a(r2)
            com.tapjoy.internal.C3168jz.m10439a(r2)
            com.tapjoy.internal.ht r2 = com.tapjoy.internal.C5170ht.f14164a
            boolean r2 = com.tapjoy.internal.C5170ht.m17399a((long) r12)
            if (r2 == 0) goto L_0x00ca
            if (r0 == 0) goto L_0x00ca
            android.graphics.Bitmap r0 = r14.f14186b
            if (r0 != 0) goto L_0x00b7
            byte[] r0 = r14.f14187c
            if (r0 == 0) goto L_0x00ca
        L_0x00b7:
            com.tapjoy.internal.ht r9 = com.tapjoy.internal.C5170ht.f14164a
            java.net.URL r10 = r14.f14185a
            android.content.Context r0 = r9.f14165b
            if (r0 == 0) goto L_0x00ca
            java.util.concurrent.ExecutorService r0 = r9.f14168e
            com.tapjoy.internal.ht$2 r2 = new com.tapjoy.internal.ht$2
            r8 = r2
            r8.<init>(r10, r11, r12)
            r0.submit(r2)
        L_0x00ca:
            if (r1 == 0) goto L_0x00d7
            android.graphics.Bitmap r0 = r14.f14186b
            if (r0 == 0) goto L_0x00d7
            com.tapjoy.internal.an r1 = f14184f
            java.net.URL r2 = r14.f14185a
            r1.mo18473a(r2, r0)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5178hx.mo31347b():void");
    }

    /* renamed from: a */
    private ByteArrayInputStream m17413a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C5249jx.m17613a(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        C5190if ifVar = new C5190if();
        ifVar.mo31353a(byteArray);
        C5189ie a = ifVar.mo31352a();
        if (a.f14227b == 0) {
            this.f14187c = byteArray;
            this.f14188d = a;
        } else {
            C3174s sVar = C3174s.f8852a;
            this.f14186b = C3174s.m10462a((InputStream) byteArrayInputStream);
            byteArrayInputStream.reset();
        }
        return byteArrayInputStream;
    }

    C5178hx(C3126bn bnVar) {
        if (bnVar.mo18495k() == C4923bs.STRING) {
            this.f14185a = bnVar.mo18485e();
            return;
        }
        bnVar.mo18492h();
        String l = bnVar.mo18496l();
        while (bnVar.mo18494j()) {
            if ("url".equals(l)) {
                this.f14185a = bnVar.mo18485e();
            } else {
                bnVar.mo18503s();
            }
        }
        bnVar.mo18493i();
    }
}
