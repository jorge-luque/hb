package p118io.fabric.sdk.android.p200m.p203c;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p202b.C6111u;

/* renamed from: io.fabric.sdk.android.m.c.h */
/* compiled from: QueueFileEventStorage */
public class C6128h implements C6123c {

    /* renamed from: a */
    private final Context f16102a;

    /* renamed from: b */
    private final File f16103b;

    /* renamed from: c */
    private final String f16104c;

    /* renamed from: d */
    private final File f16105d;

    /* renamed from: e */
    private C6111u f16106e = new C6111u(this.f16105d);

    /* renamed from: f */
    private File f16107f;

    public C6128h(Context context, File file, String str, String str2) throws IOException {
        this.f16102a = context;
        this.f16103b = file;
        this.f16104c = str2;
        this.f16105d = new File(this.f16103b, str);
        m19850e();
    }

    /* renamed from: e */
    private void m19850e() {
        File file = new File(this.f16103b, this.f16104c);
        this.f16107f = file;
        if (!file.exists()) {
            this.f16107f.mkdirs();
        }
    }

    /* renamed from: a */
    public OutputStream mo34237a(File file) throws IOException {
        throw null;
    }

    /* renamed from: a */
    public void mo34232a(byte[] bArr) throws IOException {
        this.f16106e.mo34203a(bArr);
    }

    /* renamed from: b */
    public boolean mo34234b() {
        return this.f16106e.mo34208t();
    }

    /* renamed from: c */
    public List<File> mo34235c() {
        return Arrays.asList(this.f16107f.listFiles());
    }

    /* renamed from: d */
    public void mo34236d() {
        try {
            this.f16106e.close();
        } catch (IOException unused) {
        }
        this.f16105d.delete();
    }

    /* renamed from: a */
    public int mo34228a() {
        return this.f16106e.mo34211v();
    }

    /* renamed from: a */
    public void mo34230a(String str) throws IOException {
        this.f16106e.close();
        m19849a(this.f16105d, new File(this.f16107f, str));
        this.f16106e = new C6111u(this.f16105d);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m19849a(java.io.File r6, java.io.File r7) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "Failed to close output stream"
            java.lang.String r1 = "Failed to close file input stream"
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0024 }
            r3.<init>(r6)     // Catch:{ all -> 0x0024 }
            java.io.OutputStream r2 = r5.mo34237a((java.io.File) r7)     // Catch:{ all -> 0x001f }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x001f }
            p118io.fabric.sdk.android.p200m.p202b.C6090i.m19735a((java.io.InputStream) r3, (java.io.OutputStream) r2, (byte[]) r7)     // Catch:{ all -> 0x001f }
            p118io.fabric.sdk.android.p200m.p202b.C6090i.m19733a((java.io.Closeable) r3, (java.lang.String) r1)
            p118io.fabric.sdk.android.p200m.p202b.C6090i.m19733a((java.io.Closeable) r2, (java.lang.String) r0)
            r6.delete()
            return
        L_0x001f:
            r7 = move-exception
            r4 = r3
            r3 = r2
            r2 = r4
            goto L_0x0026
        L_0x0024:
            r7 = move-exception
            r3 = r2
        L_0x0026:
            p118io.fabric.sdk.android.p200m.p202b.C6090i.m19733a((java.io.Closeable) r2, (java.lang.String) r1)
            p118io.fabric.sdk.android.p200m.p202b.C6090i.m19733a((java.io.Closeable) r3, (java.lang.String) r0)
            r6.delete()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.p200m.p203c.C6128h.m19849a(java.io.File, java.io.File):void");
    }

    /* renamed from: a */
    public List<File> mo34229a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File add : this.f16107f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo34231a(List<File> list) {
        for (File next : list) {
            C6090i.m19746c(this.f16102a, String.format("deleting sent analytics file %s", new Object[]{next.getName()}));
            next.delete();
        }
    }

    /* renamed from: a */
    public boolean mo34233a(int i, int i2) {
        return this.f16106e.mo34205a(i, i2);
    }
}
