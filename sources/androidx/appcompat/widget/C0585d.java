package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.loopj.android.http.C4250c;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.appcompat.widget.d */
/* compiled from: ActivityChooserModel */
class C0585d extends DataSetObservable {

    /* renamed from: n */
    static final String f1393n = C0585d.class.getSimpleName();

    /* renamed from: a */
    private final Object f1394a;

    /* renamed from: b */
    private final List<C0586a> f1395b;

    /* renamed from: c */
    private final List<C0588c> f1396c;

    /* renamed from: d */
    final Context f1397d;

    /* renamed from: e */
    final String f1398e;

    /* renamed from: f */
    private Intent f1399f;

    /* renamed from: g */
    private C0587b f1400g;

    /* renamed from: h */
    private int f1401h;

    /* renamed from: i */
    boolean f1402i;

    /* renamed from: j */
    private boolean f1403j;

    /* renamed from: k */
    private boolean f1404k;

    /* renamed from: l */
    private boolean f1405l;

    /* renamed from: m */
    private C0589d f1406m;

    /* renamed from: androidx.appcompat.widget.d$a */
    /* compiled from: ActivityChooserModel */
    public static final class C0586a implements Comparable<C0586a> {

        /* renamed from: a */
        public final ResolveInfo f1407a;

        /* renamed from: b */
        public float f1408b;

        public C0586a(ResolveInfo resolveInfo) {
            this.f1407a = resolveInfo;
        }

        /* renamed from: a */
        public int compareTo(C0586a aVar) {
            return Float.floatToIntBits(aVar.f1408b) - Float.floatToIntBits(this.f1408b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && C0586a.class == obj.getClass() && Float.floatToIntBits(this.f1408b) == Float.floatToIntBits(((C0586a) obj).f1408b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1408b) + 31;
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.f1407a.toString() + "; weight:" + new BigDecimal((double) this.f1408b) + "]";
        }
    }

    /* renamed from: androidx.appcompat.widget.d$b */
    /* compiled from: ActivityChooserModel */
    public interface C0587b {
        /* renamed from: a */
        void mo3394a(Intent intent, List<C0586a> list, List<C0588c> list2);
    }

    /* renamed from: androidx.appcompat.widget.d$c */
    /* compiled from: ActivityChooserModel */
    public static final class C0588c {

        /* renamed from: a */
        public final ComponentName f1409a;

        /* renamed from: b */
        public final long f1410b;

        /* renamed from: c */
        public final float f1411c;

        public C0588c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0588c.class != obj.getClass()) {
                return false;
            }
            C0588c cVar = (C0588c) obj;
            ComponentName componentName = this.f1409a;
            if (componentName == null) {
                if (cVar.f1409a != null) {
                    return false;
                }
            } else if (!componentName.equals(cVar.f1409a)) {
                return false;
            }
            return this.f1410b == cVar.f1410b && Float.floatToIntBits(this.f1411c) == Float.floatToIntBits(cVar.f1411c);
        }

        public int hashCode() {
            ComponentName componentName = this.f1409a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.f1410b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.f1411c);
        }

        public String toString() {
            return "[" + "; activity:" + this.f1409a + "; time:" + this.f1410b + "; weight:" + new BigDecimal((double) this.f1411c) + "]";
        }

        public C0588c(ComponentName componentName, long j, float f) {
            this.f1409a = componentName;
            this.f1410b = j;
            this.f1411c = f;
        }
    }

    /* renamed from: androidx.appcompat.widget.d$d */
    /* compiled from: ActivityChooserModel */
    public interface C0589d {
        /* renamed from: a */
        boolean mo3398a(C0585d dVar, Intent intent);
    }

    /* renamed from: androidx.appcompat.widget.d$e */
    /* compiled from: ActivityChooserModel */
    private final class C0590e extends AsyncTask<Object, Void, Void> {
        C0590e() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006d, code lost:
            if (r15 != null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0092, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b2, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d2, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.d r7 = androidx.appcompat.widget.C0585d.this     // Catch:{ FileNotFoundException -> 0x00e0 }
                android.content.Context r7 = r7.f1397d     // Catch:{ FileNotFoundException -> 0x00e0 }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00e0 }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r9 = 0
            L_0x0031:
                if (r9 >= r8) goto L_0x0063
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                androidx.appcompat.widget.d$c r10 = (androidx.appcompat.widget.C0585d.C0588c) r10     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.f1409a     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "time"
                long r12 = r10.f1410b     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "weight"
                float r10 = r10.f1411c     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                int r9 = r9 + 1
                goto L_0x0031
            L_0x0063:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                androidx.appcompat.widget.d r0 = androidx.appcompat.widget.C0585d.this
                r0.f1402i = r5
                if (r15 == 0) goto L_0x00d5
            L_0x006f:
                r15.close()     // Catch:{ IOException -> 0x00d5 }
                goto L_0x00d5
            L_0x0073:
                r0 = move-exception
                goto L_0x00d6
            L_0x0075:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0585d.f1393n     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.d r2 = androidx.appcompat.widget.C0585d.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.f1398e     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.d r0 = androidx.appcompat.widget.C0585d.this
                r0.f1402i = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x0095:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0585d.f1393n     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.d r2 = androidx.appcompat.widget.C0585d.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.f1398e     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.d r0 = androidx.appcompat.widget.C0585d.this
                r0.f1402i = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x00b5:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0585d.f1393n     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.d r2 = androidx.appcompat.widget.C0585d.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.f1398e     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.d r0 = androidx.appcompat.widget.C0585d.this
                r0.f1402i = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x00d5:
                return r6
            L_0x00d6:
                androidx.appcompat.widget.d r1 = androidx.appcompat.widget.C0585d.this
                r1.f1402i = r5
                if (r15 == 0) goto L_0x00df
                r15.close()     // Catch:{ IOException -> 0x00df }
            L_0x00df:
                throw r0
            L_0x00e0:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0585d.f1393n
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r15)
                java.lang.String r15 = r3.toString()
                android.util.Log.e(r1, r15, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0585d.C0590e.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    static {
        new HashMap();
    }

    /* renamed from: d */
    private void m1550d() {
        boolean e = m1551e() | m1554h();
        m1553g();
        if (e) {
            m1556j();
            notifyChanged();
        }
    }

    /* renamed from: e */
    private boolean m1551e() {
        if (!this.f1405l || this.f1399f == null) {
            return false;
        }
        this.f1405l = false;
        this.f1395b.clear();
        List<ResolveInfo> queryIntentActivities = this.f1397d.getPackageManager().queryIntentActivities(this.f1399f, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1395b.add(new C0586a(queryIntentActivities.get(i)));
        }
        return true;
    }

    /* renamed from: f */
    private void m1552f() {
        if (!this.f1403j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1404k) {
            this.f1404k = false;
            if (!TextUtils.isEmpty(this.f1398e)) {
                new C0590e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f1396c), this.f1398e});
            }
        }
    }

    /* renamed from: g */
    private void m1553g() {
        int size = this.f1396c.size() - this.f1401h;
        if (size > 0) {
            this.f1404k = true;
            for (int i = 0; i < size; i++) {
                C0588c remove = this.f1396c.remove(0);
            }
        }
    }

    /* renamed from: h */
    private boolean m1554h() {
        if (!this.f1402i || !this.f1404k || TextUtils.isEmpty(this.f1398e)) {
            return false;
        }
        this.f1402i = false;
        this.f1403j = true;
        m1555i();
        return true;
    }

    /* renamed from: i */
    private void m1555i() {
        try {
            FileInputStream openFileInput = this.f1397d.openFileInput(this.f1398e);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, C4250c.DEFAULT_CHARSET);
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List<C0588c> list = this.f1396c;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C0588c(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e) {
                String str = f1393n;
                Log.e(str, "Error reading historical recrod file: " + this.f1398e, e);
                if (openFileInput == null) {
                }
            } catch (IOException e2) {
                String str2 = f1393n;
                Log.e(str2, "Error reading historical recrod file: " + this.f1398e, e2);
                if (openFileInput == null) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    /* renamed from: j */
    private boolean m1556j() {
        if (this.f1400g == null || this.f1399f == null || this.f1395b.isEmpty() || this.f1396c.isEmpty()) {
            return false;
        }
        this.f1400g.mo3394a(this.f1399f, this.f1395b, Collections.unmodifiableList(this.f1396c));
        return true;
    }

    /* renamed from: a */
    public int mo3382a() {
        int size;
        synchronized (this.f1394a) {
            m1550d();
            size = this.f1395b.size();
        }
        return size;
    }

    /* renamed from: b */
    public ResolveInfo mo3386b(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1394a) {
            m1550d();
            resolveInfo = this.f1395b.get(i).f1407a;
        }
        return resolveInfo;
    }

    /* renamed from: c */
    public void mo3388c(int i) {
        synchronized (this.f1394a) {
            m1550d();
            C0586a aVar = this.f1395b.get(i);
            C0586a aVar2 = this.f1395b.get(0);
            m1549a(new C0588c(new ComponentName(aVar.f1407a.activityInfo.packageName, aVar.f1407a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f1408b - aVar.f1408b) + 5.0f : 1.0f));
        }
    }

    /* renamed from: a */
    public int mo3383a(ResolveInfo resolveInfo) {
        synchronized (this.f1394a) {
            m1550d();
            List<C0586a> list = this.f1395b;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f1407a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: b */
    public ResolveInfo mo3385b() {
        synchronized (this.f1394a) {
            m1550d();
            if (this.f1395b.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.f1395b.get(0).f1407a;
            return resolveInfo;
        }
    }

    /* renamed from: c */
    public int mo3387c() {
        int size;
        synchronized (this.f1394a) {
            m1550d();
            size = this.f1396c.size();
        }
        return size;
    }

    /* renamed from: a */
    public Intent mo3384a(int i) {
        synchronized (this.f1394a) {
            if (this.f1399f == null) {
                return null;
            }
            m1550d();
            C0586a aVar = this.f1395b.get(i);
            ComponentName componentName = new ComponentName(aVar.f1407a.activityInfo.packageName, aVar.f1407a.activityInfo.name);
            Intent intent = new Intent(this.f1399f);
            intent.setComponent(componentName);
            if (this.f1406m != null) {
                if (this.f1406m.mo3398a(this, new Intent(intent))) {
                    return null;
                }
            }
            m1549a(new C0588c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* renamed from: a */
    private boolean m1549a(C0588c cVar) {
        boolean add = this.f1396c.add(cVar);
        if (add) {
            this.f1404k = true;
            m1553g();
            m1552f();
            m1556j();
            notifyChanged();
        }
        return add;
    }
}
