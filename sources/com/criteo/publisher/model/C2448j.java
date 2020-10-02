package com.criteo.publisher.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.criteo.publisher.model.j */
final class C2448j extends C2438d {

    /* renamed from: com.criteo.publisher.model.j$a */
    static final class C2449a extends TypeAdapter<C2466x> {

        /* renamed from: a */
        private volatile TypeAdapter<String> f7889a;

        /* renamed from: b */
        private final Gson f7890b;

        C2449a(Gson gson) {
            this.f7890b = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2466x xVar) throws IOException {
            Class<String> cls = String.class;
            if (xVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("deviceId");
            if (xVar.mo10343a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.f7889a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7890b.getAdapter(cls);
                    this.f7889a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, xVar.mo10343a());
            }
            jsonWriter.name("deviceIdType");
            if (xVar.mo10344b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.f7889a;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f7890b.getAdapter(cls);
                    this.f7889a = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, xVar.mo10344b());
            }
            jsonWriter.name("deviceOs");
            if (xVar.mo10345c() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.f7889a;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.f7890b.getAdapter(cls);
                    this.f7889a = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, xVar.mo10345c());
            }
            jsonWriter.name("mopubConsent");
            if (xVar.mo10346d() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.f7889a;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.f7890b.getAdapter(cls);
                    this.f7889a = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, xVar.mo10346d());
            }
            jsonWriter.name("uspIab");
            if (xVar.mo10348f() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.f7889a;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.f7890b.getAdapter(cls);
                    this.f7889a = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, xVar.mo10348f());
            }
            jsonWriter.name("uspOptout");
            if (xVar.mo10349g() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.f7889a;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.f7890b.getAdapter(cls);
                    this.f7889a = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, xVar.mo10349g());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "User" + ")";
        }

        public C2466x read(JsonReader jsonReader) throws IOException {
            Class<String> cls = String.class;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("deviceId".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.f7889a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f7890b.getAdapter(cls);
                            this.f7889a = typeAdapter;
                        }
                        str = typeAdapter.read(jsonReader);
                    } else if ("deviceIdType".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.f7889a;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f7890b.getAdapter(cls);
                            this.f7889a = typeAdapter2;
                        }
                        str2 = typeAdapter2.read(jsonReader);
                    } else if ("deviceOs".equals(nextName)) {
                        TypeAdapter<String> typeAdapter3 = this.f7889a;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f7890b.getAdapter(cls);
                            this.f7889a = typeAdapter3;
                        }
                        str3 = typeAdapter3.read(jsonReader);
                    } else if ("mopubConsent".equals(nextName)) {
                        TypeAdapter<String> typeAdapter4 = this.f7889a;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.f7890b.getAdapter(cls);
                            this.f7889a = typeAdapter4;
                        }
                        str4 = typeAdapter4.read(jsonReader);
                    } else if ("uspIab".equals(nextName)) {
                        TypeAdapter<String> typeAdapter5 = this.f7889a;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.f7890b.getAdapter(cls);
                            this.f7889a = typeAdapter5;
                        }
                        str5 = typeAdapter5.read(jsonReader);
                    } else if ("uspOptout".equals(nextName)) {
                        TypeAdapter<String> typeAdapter6 = this.f7889a;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.f7890b.getAdapter(cls);
                            this.f7889a = typeAdapter6;
                        }
                        str6 = typeAdapter6.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2448j(str, str2, str3, str4, str5, str6);
        }
    }

    C2448j(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str, str2, str3, str4, str5, str6);
    }
}
