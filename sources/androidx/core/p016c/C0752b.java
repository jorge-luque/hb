package androidx.core.p016c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.p017c.C0772c;
import androidx.core.content.p017c.C0780f;
import androidx.core.p013a.C0684c;
import androidx.core.p013a.C0694j;
import androidx.core.p016c.C0760c;
import androidx.core.p019e.C0795h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import p075d.p080b.C3197e;
import p075d.p080b.C3204g;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: androidx.core.c.b */
/* compiled from: FontsContractCompat */
public class C0752b {

    /* renamed from: a */
    static final C3197e<String, Typeface> f1916a = new C3197e<>(16);

    /* renamed from: b */
    private static final C0760c f1917b = new C0760c("fonts", 10, C6078a.DEFAULT_TIMEOUT);

    /* renamed from: c */
    static final Object f1918c = new Object();

    /* renamed from: d */
    static final C3204g<String, ArrayList<C0760c.C0765d<C0759g>>> f1919d = new C3204g<>();

    /* renamed from: e */
    private static final Comparator<byte[]> f1920e = new C0756d();

    /* renamed from: androidx.core.c.b$a */
    /* compiled from: FontsContractCompat */
    static class C0753a implements Callable<C0759g> {

        /* renamed from: a */
        final /* synthetic */ Context f1921a;

        /* renamed from: b */
        final /* synthetic */ C0751a f1922b;

        /* renamed from: c */
        final /* synthetic */ int f1923c;

        /* renamed from: d */
        final /* synthetic */ String f1924d;

        C0753a(Context context, C0751a aVar, int i, String str) {
            this.f1921a = context;
            this.f1922b = aVar;
            this.f1923c = i;
            this.f1924d = str;
        }

        public C0759g call() throws Exception {
            C0759g a = C0752b.m2366a(this.f1921a, this.f1922b, this.f1923c);
            Typeface typeface = a.f1935a;
            if (typeface != null) {
                C0752b.f1916a.put(this.f1924d, typeface);
            }
            return a;
        }
    }

    /* renamed from: androidx.core.c.b$b */
    /* compiled from: FontsContractCompat */
    static class C0754b implements C0760c.C0765d<C0759g> {

        /* renamed from: a */
        final /* synthetic */ C0780f.C0781a f1925a;

        /* renamed from: b */
        final /* synthetic */ Handler f1926b;

        C0754b(C0780f.C0781a aVar, Handler handler) {
            this.f1925a = aVar;
            this.f1926b = handler;
        }

        /* renamed from: a */
        public void mo3993a(C0759g gVar) {
            if (gVar == null) {
                this.f1925a.mo4040a(1, this.f1926b);
                return;
            }
            int i = gVar.f1936b;
            if (i == 0) {
                this.f1925a.mo4041a(gVar.f1935a, this.f1926b);
            } else {
                this.f1925a.mo4040a(i, this.f1926b);
            }
        }
    }

    /* renamed from: androidx.core.c.b$c */
    /* compiled from: FontsContractCompat */
    static class C0755c implements C0760c.C0765d<C0759g> {

        /* renamed from: a */
        final /* synthetic */ String f1927a;

        C0755c(String str) {
            this.f1927a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            if (r0 >= r1.size()) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            ((androidx.core.p016c.C0760c.C0765d) r1.get(r0)).mo3993a(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
            r0 = 0;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo3993a(androidx.core.p016c.C0752b.C0759g r5) {
            /*
                r4 = this;
                java.lang.Object r0 = androidx.core.p016c.C0752b.f1918c
                monitor-enter(r0)
                d.b.g<java.lang.String, java.util.ArrayList<androidx.core.c.c$d<androidx.core.c.b$g>>> r1 = androidx.core.p016c.C0752b.f1919d     // Catch:{ all -> 0x002d }
                java.lang.String r2 = r4.f1927a     // Catch:{ all -> 0x002d }
                java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x002d }
                java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x002d }
                if (r1 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return
            L_0x0011:
                d.b.g<java.lang.String, java.util.ArrayList<androidx.core.c.c$d<androidx.core.c.b$g>>> r2 = androidx.core.p016c.C0752b.f1919d     // Catch:{ all -> 0x002d }
                java.lang.String r3 = r4.f1927a     // Catch:{ all -> 0x002d }
                r2.remove(r3)     // Catch:{ all -> 0x002d }
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                r0 = 0
            L_0x001a:
                int r2 = r1.size()
                if (r0 >= r2) goto L_0x002c
                java.lang.Object r2 = r1.get(r0)
                androidx.core.c.c$d r2 = (androidx.core.p016c.C0760c.C0765d) r2
                r2.mo3993a(r5)
                int r0 = r0 + 1
                goto L_0x001a
            L_0x002c:
                return
            L_0x002d:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                goto L_0x0031
            L_0x0030:
                throw r5
            L_0x0031:
                goto L_0x0030
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p016c.C0752b.C0755c.mo3993a(androidx.core.c.b$g):void");
        }
    }

    /* renamed from: androidx.core.c.b$d */
    /* compiled from: FontsContractCompat */
    static class C0756d implements Comparator<byte[]> {
        C0756d() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(byte[] r5, byte[] r6) {
            /*
                r4 = this;
                int r0 = r5.length
                int r1 = r6.length
                if (r0 == r1) goto L_0x0008
                int r5 = r5.length
                int r6 = r6.length
            L_0x0006:
                int r5 = r5 - r6
                return r5
            L_0x0008:
                r0 = 0
                r1 = 0
            L_0x000a:
                int r2 = r5.length
                if (r1 >= r2) goto L_0x001b
                byte r2 = r5[r1]
                byte r3 = r6[r1]
                if (r2 == r3) goto L_0x0018
                byte r5 = r5[r1]
                byte r6 = r6[r1]
                goto L_0x0006
            L_0x0018:
                int r1 = r1 + 1
                goto L_0x000a
            L_0x001b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p016c.C0752b.C0756d.compare(byte[], byte[]):int");
        }
    }

    /* renamed from: androidx.core.c.b$e */
    /* compiled from: FontsContractCompat */
    public static class C0757e {

        /* renamed from: a */
        private final int f1928a;

        /* renamed from: b */
        private final C0758f[] f1929b;

        public C0757e(int i, C0758f[] fVarArr) {
            this.f1928a = i;
            this.f1929b = fVarArr;
        }

        /* renamed from: a */
        public C0758f[] mo3997a() {
            return this.f1929b;
        }

        /* renamed from: b */
        public int mo3998b() {
            return this.f1928a;
        }
    }

    /* renamed from: androidx.core.c.b$f */
    /* compiled from: FontsContractCompat */
    public static class C0758f {

        /* renamed from: a */
        private final Uri f1930a;

        /* renamed from: b */
        private final int f1931b;

        /* renamed from: c */
        private final int f1932c;

        /* renamed from: d */
        private final boolean f1933d;

        /* renamed from: e */
        private final int f1934e;

        public C0758f(Uri uri, int i, int i2, boolean z, int i3) {
            C0795h.m2503a(uri);
            this.f1930a = uri;
            this.f1931b = i;
            this.f1932c = i2;
            this.f1933d = z;
            this.f1934e = i3;
        }

        /* renamed from: a */
        public int mo3999a() {
            return this.f1934e;
        }

        /* renamed from: b */
        public int mo4000b() {
            return this.f1931b;
        }

        /* renamed from: c */
        public Uri mo4001c() {
            return this.f1930a;
        }

        /* renamed from: d */
        public int mo4002d() {
            return this.f1932c;
        }

        /* renamed from: e */
        public boolean mo4003e() {
            return this.f1933d;
        }
    }

    /* renamed from: androidx.core.c.b$g */
    /* compiled from: FontsContractCompat */
    private static final class C0759g {

        /* renamed from: a */
        final Typeface f1935a;

        /* renamed from: b */
        final int f1936b;

        C0759g(Typeface typeface, int i) {
            this.f1935a = typeface;
            this.f1936b = i;
        }
    }

    /* renamed from: a */
    static C0759g m2366a(Context context, C0751a aVar, int i) {
        try {
            C0757e a = m2365a(context, (CancellationSignal) null, aVar);
            int i2 = -3;
            if (a.mo3998b() == 0) {
                Typeface a2 = C0684c.m2118a(context, (CancellationSignal) null, a.mo3997a(), i);
                if (a2 != null) {
                    i2 = 0;
                }
                return new C0759g(a2, i2);
            }
            if (a.mo3998b() == 1) {
                i2 = -2;
            }
            return new C0759g((Typeface) null, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0759g((Typeface) null, -1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        f1917b.mo4007a(r1, new androidx.core.p016c.C0752b.C0755c(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008d, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface m2364a(android.content.Context r2, androidx.core.p016c.C0751a r3, androidx.core.content.p017c.C0780f.C0781a r4, android.os.Handler r5, boolean r6, int r7, int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.mo3986c()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            d.b.e<java.lang.String, android.graphics.Typeface> r1 = f1916a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0028
            if (r4 == 0) goto L_0x0027
            r4.mo3533a((android.graphics.Typeface) r1)
        L_0x0027:
            return r1
        L_0x0028:
            if (r6 == 0) goto L_0x0043
            r1 = -1
            if (r7 != r1) goto L_0x0043
            androidx.core.c.b$g r2 = m2366a((android.content.Context) r2, (androidx.core.p016c.C0751a) r3, (int) r8)
            if (r4 == 0) goto L_0x0040
            int r3 = r2.f1936b
            if (r3 != 0) goto L_0x003d
            android.graphics.Typeface r3 = r2.f1935a
            r4.mo4041a((android.graphics.Typeface) r3, (android.os.Handler) r5)
            goto L_0x0040
        L_0x003d:
            r4.mo4040a((int) r3, (android.os.Handler) r5)
        L_0x0040:
            android.graphics.Typeface r2 = r2.f1935a
            return r2
        L_0x0043:
            androidx.core.c.b$a r1 = new androidx.core.c.b$a
            r1.<init>(r2, r3, r8, r0)
            r2 = 0
            if (r6 == 0) goto L_0x0056
            androidx.core.c.c r3 = f1917b     // Catch:{ InterruptedException -> 0x0055 }
            java.lang.Object r3 = r3.mo4004a(r1, (int) r7)     // Catch:{ InterruptedException -> 0x0055 }
            androidx.core.c.b$g r3 = (androidx.core.p016c.C0752b.C0759g) r3     // Catch:{ InterruptedException -> 0x0055 }
            android.graphics.Typeface r2 = r3.f1935a     // Catch:{ InterruptedException -> 0x0055 }
        L_0x0055:
            return r2
        L_0x0056:
            if (r4 != 0) goto L_0x005a
            r3 = r2
            goto L_0x005f
        L_0x005a:
            androidx.core.c.b$b r3 = new androidx.core.c.b$b
            r3.<init>(r4, r5)
        L_0x005f:
            java.lang.Object r4 = f1918c
            monitor-enter(r4)
            d.b.g<java.lang.String, java.util.ArrayList<androidx.core.c.c$d<androidx.core.c.b$g>>> r5 = f1919d     // Catch:{ all -> 0x008e }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x008e }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x0073
            if (r3 == 0) goto L_0x0071
            r5.add(r3)     // Catch:{ all -> 0x008e }
        L_0x0071:
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            return r2
        L_0x0073:
            if (r3 == 0) goto L_0x0082
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x008e }
            r5.<init>()     // Catch:{ all -> 0x008e }
            r5.add(r3)     // Catch:{ all -> 0x008e }
            d.b.g<java.lang.String, java.util.ArrayList<androidx.core.c.c$d<androidx.core.c.b$g>>> r3 = f1919d     // Catch:{ all -> 0x008e }
            r3.put(r0, r5)     // Catch:{ all -> 0x008e }
        L_0x0082:
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            androidx.core.c.c r3 = f1917b
            androidx.core.c.b$c r4 = new androidx.core.c.b$c
            r4.<init>(r0)
            r3.mo4007a(r1, r4)
            return r2
        L_0x008e:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p016c.C0752b.m2364a(android.content.Context, androidx.core.c.a, androidx.core.content.c.f$a, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public static Map<Uri, ByteBuffer> m2369a(Context context, C0758f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0758f fVar : fVarArr) {
            if (fVar.mo3999a() == 0) {
                Uri c = fVar.mo4001c();
                if (!hashMap.containsKey(c)) {
                    hashMap.put(c, C0694j.m2182a(context, cancellationSignal, c));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static C0757e m2365a(Context context, CancellationSignal cancellationSignal, C0751a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo a = m2363a(context.getPackageManager(), aVar, context.getResources());
        if (a == null) {
            return new C0757e(1, (C0758f[]) null);
        }
        return new C0757e(0, m2371a(context, aVar, a.authority, cancellationSignal));
    }

    /* renamed from: a */
    public static ProviderInfo m2363a(PackageManager packageManager, C0751a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String d = aVar.mo3987d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + d);
        } else if (resolveContentProvider.packageName.equals(aVar.mo3988e())) {
            List<byte[]> a = m2368a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a, f1920e);
            List<List<byte[]>> a2 = m2367a(aVar, resources);
            for (int i = 0; i < a2.size(); i++) {
                ArrayList arrayList = new ArrayList(a2.get(i));
                Collections.sort(arrayList, f1920e);
                if (m2370a(a, (List<byte[]>) arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + d + ", but package was not " + aVar.mo3988e());
        }
    }

    /* renamed from: a */
    private static List<List<byte[]>> m2367a(C0751a aVar, Resources resources) {
        if (aVar.mo3984a() != null) {
            return aVar.mo3984a();
        }
        return C0772c.m2437a(resources, aVar.mo3985b());
    }

    /* renamed from: a */
    private static boolean m2370a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static List<byte[]> m2368a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x014b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.core.p016c.C0752b.C0758f[] m2371a(android.content.Context r23, androidx.core.p016c.C0751a r24, java.lang.String r25, android.os.CancellationSignal r26) {
        /*
            r0 = r25
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = "content"
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r2 = r2.authority(r0)
            android.net.Uri r2 = r2.build()
            android.net.Uri$Builder r4 = new android.net.Uri$Builder
            r4.<init>()
            android.net.Uri$Builder r3 = r4.scheme(r3)
            android.net.Uri$Builder r0 = r3.authority(r0)
            java.lang.String r3 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r3)
            android.net.Uri r0 = r0.build()
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0147 }
            r5 = 16
            java.lang.String r9 = "font_variation_settings"
            r11 = 2
            r12 = 7
            java.lang.String r13 = "result_code"
            java.lang.String r14 = "font_italic"
            java.lang.String r15 = "font_weight"
            java.lang.String r3 = "font_ttc_index"
            java.lang.String r6 = "file_id"
            java.lang.String r7 = "_id"
            r8 = 1
            r10 = 0
            if (r4 <= r5) goto L_0x0083
            android.content.ContentResolver r4 = r23.getContentResolver()     // Catch:{ all -> 0x0147 }
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ all -> 0x0147 }
            r12[r10] = r7     // Catch:{ all -> 0x0147 }
            r12[r8] = r6     // Catch:{ all -> 0x0147 }
            r12[r11] = r3     // Catch:{ all -> 0x0147 }
            r5 = 3
            r12[r5] = r9     // Catch:{ all -> 0x0147 }
            r5 = 4
            r12[r5] = r15     // Catch:{ all -> 0x0147 }
            r5 = 5
            r12[r5] = r14     // Catch:{ all -> 0x0147 }
            r5 = 6
            r12[r5] = r13     // Catch:{ all -> 0x0147 }
            java.lang.String r9 = "query = ?"
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ all -> 0x0147 }
            java.lang.String r5 = r24.mo3989f()     // Catch:{ all -> 0x0147 }
            r11[r10] = r5     // Catch:{ all -> 0x0147 }
            r16 = 0
            r5 = r2
            r20 = r1
            r1 = r6
            r6 = r12
            r12 = r7
            r7 = r9
            r9 = 1
            r8 = r11
            r11 = 1
            r9 = r16
            r11 = 0
            r10 = r26
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0147 }
            r10 = r12
            r11 = 1
            goto L_0x00b5
        L_0x0083:
            r20 = r1
            r1 = r6
            r10 = r7
            r4 = 2
            r11 = 0
            android.content.ContentResolver r5 = r23.getContentResolver()     // Catch:{ all -> 0x0147 }
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ all -> 0x0147 }
            r6[r11] = r10     // Catch:{ all -> 0x0147 }
            r6[r8] = r1     // Catch:{ all -> 0x0147 }
            r6[r4] = r3     // Catch:{ all -> 0x0147 }
            r4 = 3
            r6[r4] = r9     // Catch:{ all -> 0x0147 }
            r4 = 4
            r6[r4] = r15     // Catch:{ all -> 0x0147 }
            r4 = 5
            r6[r4] = r14     // Catch:{ all -> 0x0147 }
            r4 = 6
            r6[r4] = r13     // Catch:{ all -> 0x0147 }
            java.lang.String r7 = "query = ?"
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ all -> 0x0147 }
            java.lang.String r4 = r24.mo3989f()     // Catch:{ all -> 0x0147 }
            r9[r11] = r4     // Catch:{ all -> 0x0147 }
            r12 = 0
            r4 = r5
            r5 = r2
            r11 = 1
            r8 = r9
            r9 = r12
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0147 }
        L_0x00b5:
            if (r4 == 0) goto L_0x0136
            int r5 = r4.getCount()     // Catch:{ all -> 0x0133 }
            if (r5 <= 0) goto L_0x0136
            int r5 = r4.getColumnIndex(r13)     // Catch:{ all -> 0x0133 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0133 }
            r6.<init>()     // Catch:{ all -> 0x0133 }
            int r7 = r4.getColumnIndex(r10)     // Catch:{ all -> 0x0133 }
            int r1 = r4.getColumnIndex(r1)     // Catch:{ all -> 0x0133 }
            int r3 = r4.getColumnIndex(r3)     // Catch:{ all -> 0x0133 }
            int r8 = r4.getColumnIndex(r15)     // Catch:{ all -> 0x0133 }
            int r9 = r4.getColumnIndex(r14)     // Catch:{ all -> 0x0133 }
        L_0x00da:
            boolean r10 = r4.moveToNext()     // Catch:{ all -> 0x0133 }
            if (r10 == 0) goto L_0x0131
            r10 = -1
            if (r5 == r10) goto L_0x00ea
            int r12 = r4.getInt(r5)     // Catch:{ all -> 0x0133 }
            r22 = r12
            goto L_0x00ec
        L_0x00ea:
            r22 = 0
        L_0x00ec:
            if (r3 == r10) goto L_0x00f5
            int r12 = r4.getInt(r3)     // Catch:{ all -> 0x0133 }
            r19 = r12
            goto L_0x00f7
        L_0x00f5:
            r19 = 0
        L_0x00f7:
            if (r1 != r10) goto L_0x0102
            long r12 = r4.getLong(r7)     // Catch:{ all -> 0x0133 }
            android.net.Uri r12 = android.content.ContentUris.withAppendedId(r2, r12)     // Catch:{ all -> 0x0133 }
            goto L_0x010a
        L_0x0102:
            long r12 = r4.getLong(r1)     // Catch:{ all -> 0x0133 }
            android.net.Uri r12 = android.content.ContentUris.withAppendedId(r0, r12)     // Catch:{ all -> 0x0133 }
        L_0x010a:
            r18 = r12
            if (r8 == r10) goto L_0x0115
            int r12 = r4.getInt(r8)     // Catch:{ all -> 0x0133 }
            r20 = r12
            goto L_0x0119
        L_0x0115:
            r12 = 400(0x190, float:5.6E-43)
            r20 = 400(0x190, float:5.6E-43)
        L_0x0119:
            if (r9 == r10) goto L_0x0124
            int r10 = r4.getInt(r9)     // Catch:{ all -> 0x0133 }
            if (r10 != r11) goto L_0x0124
            r21 = 1
            goto L_0x0126
        L_0x0124:
            r21 = 0
        L_0x0126:
            androidx.core.c.b$f r10 = new androidx.core.c.b$f     // Catch:{ all -> 0x0133 }
            r17 = r10
            r17.<init>(r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0133 }
            r6.add(r10)     // Catch:{ all -> 0x0133 }
            goto L_0x00da
        L_0x0131:
            r1 = r6
            goto L_0x0138
        L_0x0133:
            r0 = move-exception
            r3 = r4
            goto L_0x0149
        L_0x0136:
            r1 = r20
        L_0x0138:
            if (r4 == 0) goto L_0x013d
            r4.close()
        L_0x013d:
            r0 = 0
            androidx.core.c.b$f[] r0 = new androidx.core.p016c.C0752b.C0758f[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            androidx.core.c.b$f[] r0 = (androidx.core.p016c.C0752b.C0758f[]) r0
            return r0
        L_0x0147:
            r0 = move-exception
            r3 = 0
        L_0x0149:
            if (r3 == 0) goto L_0x014e
            r3.close()
        L_0x014e:
            goto L_0x0150
        L_0x014f:
            throw r0
        L_0x0150:
            goto L_0x014f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p016c.C0752b.m2371a(android.content.Context, androidx.core.c.a, java.lang.String, android.os.CancellationSignal):androidx.core.c.b$f[]");
    }
}
