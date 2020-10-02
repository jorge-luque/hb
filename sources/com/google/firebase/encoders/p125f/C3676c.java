package com.google.firebase.encoders.p125f;

import com.google.firebase.encoders.C3669a;
import com.google.firebase.encoders.C3670b;
import com.google.firebase.encoders.C3672d;
import com.google.firebase.encoders.C3673e;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: com.google.firebase.encoders.f.c */
/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public final class C3676c {

    /* renamed from: c */
    private static final C3672d<String> f10243c = C3674a.m12477a();

    /* renamed from: d */
    private static final C3672d<Boolean> f10244d = C3675b.m12479a();

    /* renamed from: e */
    private static final C3678b f10245e = new C3678b((C3677a) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Map<Class<?>, C3670b<?>> f10246a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<Class<?>, C3672d<?>> f10247b = new HashMap();

    /* renamed from: com.google.firebase.encoders.f.c$b */
    /* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
    private static final class C3678b implements C3672d<Date> {

        /* renamed from: a */
        private static final DateFormat f10249a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f10249a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private C3678b() {
        }

        /* synthetic */ C3678b(C3677a aVar) {
            this();
        }

        /* renamed from: a */
        public void mo27274a(Date date, C3673e eVar) throws EncodingException, IOException {
            eVar.mo27275a(f10249a.format(date));
        }
    }

    public C3676c() {
        mo27279a(String.class, f10243c);
        mo27279a(Boolean.class, f10244d);
        mo27279a(Date.class, f10245e);
    }

    /* renamed from: com.google.firebase.encoders.f.c$a */
    /* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
    class C3677a implements C3669a {
        C3677a() {
        }

        /* renamed from: a */
        public void mo27270a(Object obj, Writer writer) throws IOException, EncodingException {
            C3679d dVar = new C3679d(writer, C3676c.this.f10246a, C3676c.this.f10247b);
            dVar.mo27283a(obj);
            dVar.mo27285a();
        }

        /* renamed from: a */
        public String mo27269a(Object obj) throws EncodingException {
            StringWriter stringWriter = new StringWriter();
            try {
                mo27270a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* renamed from: a */
    public <T> C3676c mo27278a(Class<T> cls, C3670b<? super T> bVar) {
        if (!this.f10246a.containsKey(cls)) {
            this.f10246a.put(cls, bVar);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + cls.getName());
    }

    /* renamed from: a */
    public <T> C3676c mo27279a(Class<T> cls, C3672d<? super T> dVar) {
        if (!this.f10247b.containsKey(cls)) {
            this.f10247b.put(cls, dVar);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + cls.getName());
    }

    /* renamed from: a */
    public C3669a mo27277a() {
        return new C3677a();
    }
}
