package com.criteo.publisher.p066y.p067b;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.criteo.publisher.y.b.b */
final class C2582b extends C2581a {

    /* renamed from: com.criteo.publisher.y.b.b$a */
    static final class C2583a extends TypeAdapter<C2584c> {

        /* renamed from: a */
        private volatile TypeAdapter<String> f8156a;

        /* renamed from: b */
        private volatile TypeAdapter<Boolean> f8157b;

        /* renamed from: c */
        private volatile TypeAdapter<Integer> f8158c;

        /* renamed from: d */
        private final Gson f8159d;

        C2583a(Gson gson) {
            this.f8159d = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2584c cVar) throws IOException {
            if (cVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("consentData");
            if (cVar.mo10636a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.f8156a;
                if (typeAdapter == null) {
                    typeAdapter = this.f8159d.getAdapter(String.class);
                    this.f8156a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, cVar.mo10636a());
            }
            jsonWriter.name("gdprApplies");
            if (cVar.mo10637b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter2 = this.f8157b;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f8159d.getAdapter(Boolean.class);
                    this.f8157b = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, cVar.mo10637b());
            }
            jsonWriter.name("version");
            if (cVar.mo10638d() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter3 = this.f8158c;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.f8159d.getAdapter(Integer.class);
                    this.f8158c = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, cVar.mo10638d());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "GdprData" + ")";
        }

        public C2584c read(JsonReader jsonReader) throws IOException {
            String str = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Boolean bool = null;
            Integer num = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("consentData".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.f8156a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f8159d.getAdapter(String.class);
                            this.f8156a = typeAdapter;
                        }
                        str = typeAdapter.read(jsonReader);
                    } else if ("gdprApplies".equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter2 = this.f8157b;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f8159d.getAdapter(Boolean.class);
                            this.f8157b = typeAdapter2;
                        }
                        bool = typeAdapter2.read(jsonReader);
                    } else if ("version".equals(nextName)) {
                        TypeAdapter<Integer> typeAdapter3 = this.f8158c;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f8159d.getAdapter(Integer.class);
                            this.f8158c = typeAdapter3;
                        }
                        num = typeAdapter3.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2582b(str, bool, num);
        }
    }

    C2582b(String str, Boolean bool, Integer num) {
        super(str, bool, num);
    }
}
