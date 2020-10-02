package com.criteo.publisher.model.p055z;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;

/* renamed from: com.criteo.publisher.model.z.l */
final class C2485l extends C2474f {

    /* renamed from: com.criteo.publisher.model.z.l$a */
    static final class C2486a extends TypeAdapter<C2493r> {

        /* renamed from: a */
        private volatile TypeAdapter<String> f7980a;

        /* renamed from: b */
        private volatile TypeAdapter<URI> f7981b;

        /* renamed from: c */
        private volatile TypeAdapter<C2490o> f7982c;

        /* renamed from: d */
        private final Gson f7983d;

        C2486a(Gson gson) {
            this.f7983d = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2493r rVar) throws IOException {
            Class<String> cls = String.class;
            if (rVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("title");
            if (rVar.mo10468g() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.f7980a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7983d.getAdapter(cls);
                    this.f7980a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, rVar.mo10468g());
            }
            jsonWriter.name("description");
            if (rVar.mo10464c() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.f7980a;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f7983d.getAdapter(cls);
                    this.f7980a = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, rVar.mo10464c());
            }
            jsonWriter.name("price");
            if (rVar.mo10467f() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.f7980a;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.f7983d.getAdapter(cls);
                    this.f7980a = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, rVar.mo10467f());
            }
            jsonWriter.name("clickUrl");
            if (rVar.mo10463b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<URI> typeAdapter4 = this.f7981b;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.f7983d.getAdapter(URI.class);
                    this.f7981b = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, rVar.mo10463b());
            }
            jsonWriter.name("callToAction");
            if (rVar.mo10462a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.f7980a;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.f7983d.getAdapter(cls);
                    this.f7980a = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, rVar.mo10462a());
            }
            jsonWriter.name(MessengerShareContentUtility.MEDIA_IMAGE);
            if (rVar.mo10465d() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<C2490o> typeAdapter6 = this.f7982c;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.f7983d.getAdapter(C2490o.class);
                    this.f7982c = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, rVar.mo10465d());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "NativeProduct" + ")";
        }

        public C2493r read(JsonReader jsonReader) throws IOException {
            Class<String> cls = String.class;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            URI uri = null;
            String str4 = null;
            C2490o oVar = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("title".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.f7980a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f7983d.getAdapter(cls);
                            this.f7980a = typeAdapter;
                        }
                        str = typeAdapter.read(jsonReader);
                    } else if ("description".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.f7980a;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f7983d.getAdapter(cls);
                            this.f7980a = typeAdapter2;
                        }
                        str2 = typeAdapter2.read(jsonReader);
                    } else if ("price".equals(nextName)) {
                        TypeAdapter<String> typeAdapter3 = this.f7980a;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f7983d.getAdapter(cls);
                            this.f7980a = typeAdapter3;
                        }
                        str3 = typeAdapter3.read(jsonReader);
                    } else if ("clickUrl".equals(nextName)) {
                        TypeAdapter<URI> typeAdapter4 = this.f7981b;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.f7983d.getAdapter(URI.class);
                            this.f7981b = typeAdapter4;
                        }
                        uri = typeAdapter4.read(jsonReader);
                    } else if ("callToAction".equals(nextName)) {
                        TypeAdapter<String> typeAdapter5 = this.f7980a;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.f7983d.getAdapter(cls);
                            this.f7980a = typeAdapter5;
                        }
                        str4 = typeAdapter5.read(jsonReader);
                    } else if (MessengerShareContentUtility.MEDIA_IMAGE.equals(nextName)) {
                        TypeAdapter<C2490o> typeAdapter6 = this.f7982c;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.f7983d.getAdapter(C2490o.class);
                            this.f7982c = typeAdapter6;
                        }
                        oVar = typeAdapter6.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2485l(str, str2, str3, uri, str4, oVar);
        }
    }

    C2485l(String str, String str2, String str3, URI uri, String str4, C2490o oVar) {
        super(str, str2, str3, uri, str4, oVar);
    }
}
