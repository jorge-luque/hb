package com.criteo.publisher.model.p055z;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;

/* renamed from: com.criteo.publisher.model.z.j */
final class C2481j extends C2472d {

    /* renamed from: com.criteo.publisher.model.z.j$a */
    static final class C2482a extends TypeAdapter<C2491p> {

        /* renamed from: a */
        private volatile TypeAdapter<URL> f7974a;

        /* renamed from: b */
        private final Gson f7975b;

        C2482a(Gson gson) {
            this.f7975b = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2491p pVar) throws IOException {
            if (pVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("url");
            if (pVar.mo10452a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<URL> typeAdapter = this.f7974a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7975b.getAdapter(URL.class);
                    this.f7974a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, pVar.mo10452a());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "NativeImpressionPixel" + ")";
        }

        public C2491p read(JsonReader jsonReader) throws IOException {
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
                        TypeAdapter<URL> typeAdapter = this.f7974a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f7975b.getAdapter(URL.class);
                            this.f7974a = typeAdapter;
                        }
                        url = typeAdapter.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2481j(url);
        }
    }

    C2481j(URL url) {
        super(url);
    }
}
