package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* renamed from: com.tapjoy.internal.bt */
public final class C4924bt implements Closeable {

    /* renamed from: a */
    final Writer f13418a;

    /* renamed from: b */
    private final List f13419b;

    /* renamed from: c */
    private String f13420c;

    /* renamed from: d */
    private String f13421d = ":";

    /* renamed from: e */
    private boolean f13422e;

    /* renamed from: com.tapjoy.internal.bt$1 */
    static /* synthetic */ class C49251 {

        /* renamed from: a */
        static final /* synthetic */ int[] f13423a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tapjoy.internal.bq[] r0 = com.tapjoy.internal.C4921bq.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13423a = r0
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.EMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13423a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.EMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f13423a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.NONEMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f13423a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.DANGLING_NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f13423a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.NONEMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4924bt.C49251.<clinit>():void");
        }
    }

    public C4924bt(Writer writer) {
        ArrayList arrayList = new ArrayList();
        this.f13419b = arrayList;
        arrayList.add(C4921bq.EMPTY_DOCUMENT);
        if (writer != null) {
            this.f13418a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    /* renamed from: e */
    private C4921bq m16754e() {
        List list = this.f13419b;
        return (C4921bq) list.get(list.size() - 1);
    }

    /* renamed from: f */
    private C4924bt m16755f() {
        m16752a(false);
        this.f13418a.write("null");
        return this;
    }

    /* renamed from: g */
    private void m16756g() {
        if (this.f13420c != null) {
            this.f13418a.write("\n");
            for (int i = 1; i < this.f13419b.size(); i++) {
                this.f13418a.write(this.f13420c);
            }
        }
    }

    /* renamed from: a */
    public final C4924bt mo31003a() {
        return m16749a(C4921bq.EMPTY_ARRAY, "[");
    }

    /* renamed from: b */
    public final C4924bt mo31011b() {
        return m16748a(C4921bq.EMPTY_ARRAY, C4921bq.NONEMPTY_ARRAY, "]");
    }

    /* renamed from: c */
    public final C4924bt mo31013c() {
        return m16749a(C4921bq.EMPTY_OBJECT, "{");
    }

    public final void close() {
        this.f13418a.close();
        if (m16754e() != C4921bq.NONEMPTY_DOCUMENT) {
            throw new IOException("Incomplete document");
        }
    }

    /* renamed from: d */
    public final C4924bt mo31015d() {
        return m16748a(C4921bq.EMPTY_OBJECT, C4921bq.NONEMPTY_OBJECT, "}");
    }

    /* renamed from: a */
    private C4924bt m16749a(C4921bq bqVar, String str) {
        m16752a(true);
        this.f13419b.add(bqVar);
        this.f13418a.write(str);
        return this;
    }

    /* renamed from: c */
    private void m16753c(String str) {
        this.f13418a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                this.f13418a.write("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '\\') {
                    if (charAt != 8232 && charAt != 8233) {
                        switch (charAt) {
                            case 8:
                                this.f13418a.write("\\b");
                                continue;
                            case 9:
                                this.f13418a.write("\\t");
                                continue;
                            case 10:
                                this.f13418a.write("\\n");
                                continue;
                            default:
                                if (charAt <= 31) {
                                    this.f13418a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                                    continue;
                                }
                                break;
                        }
                    } else {
                        this.f13418a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    }
                } else {
                    this.f13418a.write(92);
                }
                this.f13418a.write(charAt);
            } else {
                this.f13418a.write("\\r");
            }
        }
        this.f13418a.write("\"");
    }

    /* renamed from: b */
    public final C4924bt mo31012b(String str) {
        if (str == null) {
            return m16755f();
        }
        m16752a(false);
        m16753c(str);
        return this;
    }

    /* renamed from: a */
    private C4924bt m16748a(C4921bq bqVar, C4921bq bqVar2, String str) {
        C4921bq e = m16754e();
        if (e == bqVar2 || e == bqVar) {
            List list = this.f13419b;
            list.remove(list.size() - 1);
            if (e == bqVar2) {
                m16756g();
            }
            this.f13418a.write(str);
            return this;
        }
        throw new IllegalStateException("Nesting problem: " + this.f13419b);
    }

    /* renamed from: a */
    private void m16751a(C4921bq bqVar) {
        List list = this.f13419b;
        list.set(list.size() - 1, bqVar);
    }

    /* renamed from: a */
    public final C4924bt mo31004a(long j) {
        m16752a(false);
        this.f13418a.write(Long.toString(j));
        return this;
    }

    /* renamed from: a */
    public final C4924bt mo31006a(Number number) {
        if (number == null) {
            return m16755f();
        }
        String obj = number.toString();
        if (this.f13422e || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            m16752a(false);
            this.f13418a.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    /* renamed from: a */
    private void m16752a(boolean z) {
        int i = C49251.f13423a[m16754e().ordinal()];
        if (i != 1) {
            if (i == 2) {
                m16751a(C4921bq.NONEMPTY_ARRAY);
                m16756g();
            } else if (i == 3) {
                this.f13418a.append(',');
                m16756g();
            } else if (i == 4) {
                this.f13418a.append(this.f13421d);
                m16751a(C4921bq.NONEMPTY_OBJECT);
            } else if (i != 5) {
                throw new IllegalStateException("Nesting problem: " + this.f13419b);
            } else {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        } else if (this.f13422e || z) {
            m16751a(C4921bq.NONEMPTY_DOCUMENT);
        } else {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
    }

    /* renamed from: a */
    public final C4924bt mo31007a(Object obj) {
        if (obj == null) {
            return m16755f();
        }
        if (obj instanceof C4922br) {
            if (this.f13419b.size() == this.f13419b.size()) {
                return this;
            }
            throw new IllegalStateException(obj.getClass().getName() + ".writeToJson(JsonWriter) wrote incomplete value");
        } else if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            m16752a(false);
            this.f13418a.write(booleanValue ? "true" : "false");
            return this;
        } else if (obj instanceof Number) {
            if (obj instanceof Long) {
                return mo31004a(((Number) obj).longValue());
            }
            if (!(obj instanceof Double)) {
                return mo31006a((Number) obj);
            }
            double doubleValue = ((Number) obj).doubleValue();
            if (this.f13422e || (!Double.isNaN(doubleValue) && !Double.isInfinite(doubleValue))) {
                m16752a(false);
                this.f13418a.append(Double.toString(doubleValue));
                return this;
            }
            throw new IllegalArgumentException("Numeric values must be finite, but was " + doubleValue);
        } else if (obj instanceof String) {
            return mo31012b((String) obj);
        } else {
            if (obj instanceof C4916bl) {
                return mo31005a((C4916bl) obj);
            }
            if (obj instanceof Collection) {
                return mo31009a((Collection) obj);
            }
            if (obj instanceof Map) {
                return mo31010a((Map) obj);
            }
            if (obj instanceof Date) {
                Date date = (Date) obj;
                if (date == null) {
                    return m16755f();
                }
                return mo31012b(C5272w.m17678a(date));
            } else if (obj instanceof Object[]) {
                return m16750a((Object[]) obj);
            } else {
                throw new IllegalArgumentException("Unknown type: " + obj.getClass().getName());
            }
        }
    }

    /* renamed from: a */
    private C4924bt m16750a(Object[] objArr) {
        if (objArr == null) {
            return m16755f();
        }
        mo31003a();
        for (Object a : objArr) {
            mo31007a(a);
        }
        mo31011b();
        return this;
    }

    /* renamed from: a */
    public final C4924bt mo31005a(C4916bl blVar) {
        m16752a(false);
        blVar.mo30993a(this.f13418a);
        return this;
    }

    /* renamed from: a */
    public final C4924bt mo31009a(Collection collection) {
        if (collection == null) {
            return m16755f();
        }
        mo31003a();
        for (Object a : collection) {
            mo31007a(a);
        }
        mo31011b();
        return this;
    }

    /* renamed from: a */
    public final C4924bt mo31008a(String str) {
        if (str != null) {
            C4921bq e = m16754e();
            if (e == C4921bq.NONEMPTY_OBJECT) {
                this.f13418a.write(44);
            } else if (e != C4921bq.EMPTY_OBJECT) {
                throw new IllegalStateException("Nesting problem: " + this.f13419b);
            }
            m16756g();
            m16751a(C4921bq.DANGLING_NAME);
            m16753c(str);
            return this;
        }
        throw new NullPointerException("name == null");
    }

    /* renamed from: a */
    public final C4924bt mo31010a(Map map) {
        if (map == null) {
            return m16755f();
        }
        mo31013c();
        for (Map.Entry entry : map.entrySet()) {
            mo31008a(String.valueOf(entry.getKey()));
            mo31007a(entry.getValue());
        }
        mo31015d();
        return this;
    }
}
