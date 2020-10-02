package com.criteo.publisher.model.p055z;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;

/* renamed from: com.criteo.publisher.model.z.g */
final class C2475g extends C2468a {

    /* renamed from: com.criteo.publisher.model.z.g$a */
    static final class C2476a extends TypeAdapter<C2487m> {

        /* renamed from: a */
        private volatile TypeAdapter<String> f7963a;

        /* renamed from: b */
        private volatile TypeAdapter<URI> f7964b;

        /* renamed from: c */
        private volatile TypeAdapter<C2490o> f7965c;

        /* renamed from: d */
        private final Gson f7966d;

        C2476a(Gson gson) {
            this.f7966d = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2487m mVar) throws IOException {
            Class<String> cls = String.class;
            if (mVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("domain");
            if (mVar.mo10428b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.f7963a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7966d.getAdapter(cls);
                    this.f7963a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, mVar.mo10428b());
            }
            jsonWriter.name("description");
            if (mVar.mo10427a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.f7963a;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f7966d.getAdapter(cls);
                    this.f7963a = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, mVar.mo10427a());
            }
            jsonWriter.name("logoClickUrl");
            if (mVar.mo10430d() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<URI> typeAdapter3 = this.f7964b;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.f7966d.getAdapter(URI.class);
                    this.f7964b = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, mVar.mo10430d());
            }
            jsonWriter.name("logo");
            if (mVar.mo10429c() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<C2490o> typeAdapter4 = this.f7965c;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.f7966d.getAdapter(C2490o.class);
                    this.f7965c = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, mVar.mo10429c());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "NativeAdvertiser" + ")";
        }

        public C2487m read(JsonReader jsonReader) throws IOException {
            Class<String> cls = String.class;
            String str = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str2 = null;
            URI uri = null;
            C2490o oVar = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("domain".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.f7963a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f7966d.getAdapter(cls);
                            this.f7963a = typeAdapter;
                        }
                        str = typeAdapter.read(jsonReader);
                    } else if ("description".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.f7963a;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f7966d.getAdapter(cls);
                            this.f7963a = typeAdapter2;
                        }
                        str2 = typeAdapter2.read(jsonReader);
                    } else if ("logoClickUrl".equals(nextName)) {
                        TypeAdapter<URI> typeAdapter3 = this.f7964b;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f7966d.getAdapter(URI.class);
                            this.f7964b = typeAdapter3;
                        }
                        uri = typeAdapter3.read(jsonReader);
                    } else if ("logo".equals(nextName)) {
                        TypeAdapter<C2490o> typeAdapter4 = this.f7965c;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.f7966d.getAdapter(C2490o.class);
                            this.f7965c = typeAdapter4;
                        }
                        oVar = typeAdapter4.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2475g(str, str2, uri, oVar);
        }
    }

    C2475g(String str, String str2, URI uri, C2490o oVar) {
        super(str, str2, uri, oVar);
    }
}
