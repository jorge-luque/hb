package com.google.firebase.encoders.p125f;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.C3670b;
import com.google.firebase.encoders.C3671c;
import com.google.firebase.encoders.C3672d;
import com.google.firebase.encoders.C3673e;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.google.firebase.encoders.f.d */
/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
final class C3679d implements C3671c, C3673e {

    /* renamed from: a */
    private C3679d f10250a = null;

    /* renamed from: b */
    private boolean f10251b = true;

    /* renamed from: c */
    private final JsonWriter f10252c;

    /* renamed from: d */
    private final Map<Class<?>, C3670b<?>> f10253d;

    /* renamed from: e */
    private final Map<Class<?>, C3672d<?>> f10254e;

    C3679d(Writer writer, Map<Class<?>, C3670b<?>> map, Map<Class<?>, C3672d<?>> map2) {
        this.f10252c = new JsonWriter(writer);
        this.f10253d = map;
        this.f10254e = map2;
    }

    /* renamed from: b */
    private void m12492b() throws IOException {
        if (this.f10251b) {
            C3679d dVar = this.f10250a;
            if (dVar != null) {
                dVar.m12492b();
                this.f10250a.f10251b = false;
                this.f10250a = null;
                this.f10252c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    /* renamed from: a */
    public C3679d m12504a(String str, Object obj) throws IOException, EncodingException {
        m12492b();
        this.f10252c.name(str);
        if (obj == null) {
            this.f10252c.nullValue();
            return this;
        }
        mo27283a(obj);
        return this;
    }

    /* renamed from: a */
    public C3679d m12502a(String str, int i) throws IOException, EncodingException {
        m12492b();
        this.f10252c.name(str);
        mo27281a(i);
        return this;
    }

    /* renamed from: a */
    public C3679d m12503a(String str, long j) throws IOException, EncodingException {
        m12492b();
        this.f10252c.name(str);
        mo27282a(j);
        return this;
    }

    /* renamed from: a */
    public C3679d m12501a(String str) throws IOException, EncodingException {
        m12492b();
        this.f10252c.value(str);
        return this;
    }

    /* renamed from: a */
    public C3679d mo27281a(int i) throws IOException, EncodingException {
        m12492b();
        this.f10252c.value((long) i);
        return this;
    }

    /* renamed from: a */
    public C3679d mo27282a(long j) throws IOException, EncodingException {
        m12492b();
        this.f10252c.value(j);
        return this;
    }

    /* renamed from: a */
    public C3679d m12505a(boolean z) throws IOException, EncodingException {
        m12492b();
        this.f10252c.value(z);
        return this;
    }

    /* renamed from: a */
    public C3679d mo27284a(byte[] bArr) throws IOException, EncodingException {
        m12492b();
        if (bArr == null) {
            this.f10252c.nullValue();
        } else {
            this.f10252c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3679d mo27283a(Object obj) throws IOException, EncodingException {
        if (obj == null) {
            this.f10252c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f10252c.value((Number) obj);
            return this;
        } else {
            int i = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof byte[]) {
                    mo27284a((byte[]) obj);
                    return this;
                }
                this.f10252c.beginArray();
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    int length = iArr.length;
                    while (i < length) {
                        this.f10252c.value((long) iArr[i]);
                        i++;
                    }
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    int length2 = jArr.length;
                    while (i < length2) {
                        mo27282a(jArr[i]);
                        i++;
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    int length3 = dArr.length;
                    while (i < length3) {
                        this.f10252c.value(dArr[i]);
                        i++;
                    }
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    int length4 = zArr.length;
                    while (i < length4) {
                        this.f10252c.value(zArr[i]);
                        i++;
                    }
                } else if (obj instanceof Number[]) {
                    Number[] numberArr = (Number[]) obj;
                    int length5 = numberArr.length;
                    while (i < length5) {
                        mo27283a((Object) numberArr[i]);
                        i++;
                    }
                } else {
                    Object[] objArr = (Object[]) obj;
                    int length6 = objArr.length;
                    while (i < length6) {
                        mo27283a(objArr[i]);
                        i++;
                    }
                }
                this.f10252c.endArray();
                return this;
            } else if (obj instanceof Collection) {
                this.f10252c.beginArray();
                for (Object a : (Collection) obj) {
                    mo27283a(a);
                }
                this.f10252c.endArray();
                return this;
            } else if (obj instanceof Map) {
                this.f10252c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        mo27273a((String) key, entry.getValue());
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e);
                    }
                }
                this.f10252c.endObject();
                return this;
            } else {
                C3670b bVar = this.f10253d.get(obj.getClass());
                if (bVar != null) {
                    this.f10252c.beginObject();
                    bVar.mo12866a(obj, this);
                    this.f10252c.endObject();
                    return this;
                }
                C3672d dVar = this.f10254e.get(obj.getClass());
                if (dVar != null) {
                    dVar.mo27274a(obj, this);
                    return this;
                } else if (obj instanceof Enum) {
                    mo27275a(((Enum) obj).name());
                    return this;
                } else {
                    throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27285a() throws IOException {
        m12492b();
        this.f10252c.flush();
    }
}
