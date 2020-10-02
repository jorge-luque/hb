package com.criteo.publisher.model.p055z;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;

/* renamed from: com.criteo.publisher.model.z.i */
final class C2479i extends C2471c {

    /* renamed from: com.criteo.publisher.model.z.i$a */
    static final class C2480a extends TypeAdapter<C2490o> {

        /* renamed from: a */
        private volatile TypeAdapter<URL> f7972a;

        /* renamed from: b */
        private final Gson f7973b;

        C2480a(Gson gson) {
            this.f7973b = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2490o oVar) throws IOException {
            if (oVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("url");
            if (oVar.mo10448a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<URL> typeAdapter = this.f7972a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7973b.getAdapter(URL.class);
                    this.f7972a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, oVar.mo10448a());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "NativeImage" + ")";
        }

        public C2490o read(JsonReader jsonReader) throws IOException {
            URL url = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("url".equals(nextName)) {
                        TypeAdapter<URL> typeAdapter = this.f7972a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f7973b.getAdapter(URL.class);
                            this.f7972a = typeAdapter;
                        }
                        url = typeAdapter.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2479i(url);
        }
    }

    C2479i(URL url) {
        super(url);
    }
}
