package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2551t;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.criteo.publisher.t.h */
final class C2524h extends C2517d {

    /* renamed from: com.criteo.publisher.t.h$a */
    static final class C2525a extends TypeAdapter<C2551t.C2553b> {

        /* renamed from: a */
        private volatile TypeAdapter<String> f8044a;

        /* renamed from: b */
        private volatile TypeAdapter<Boolean> f8045b;

        /* renamed from: c */
        private final Gson f8046c;

        C2525a(Gson gson) {
            this.f8046c = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2551t.C2553b bVar) throws IOException {
            if (bVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("impressionId");
            if (bVar.mo10560b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.f8044a;
                if (typeAdapter == null) {
                    typeAdapter = this.f8046c.getAdapter(String.class);
                    this.f8044a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, bVar.mo10560b());
            }
            jsonWriter.name("cachedBidUsed");
            TypeAdapter<Boolean> typeAdapter2 = this.f8045b;
            if (typeAdapter2 == null) {
                typeAdapter2 = this.f8046c.getAdapter(Boolean.class);
                this.f8045b = typeAdapter2;
            }
            typeAdapter2.write(jsonWriter, Boolean.valueOf(bVar.mo10559a()));
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "MetricRequest.MetricRequestSlot" + ")";
        }

        public C2551t.C2553b read(JsonReader jsonReader) throws IOException {
            String str = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("impressionId".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.f8044a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f8046c.getAdapter(String.class);
                            this.f8044a = typeAdapter;
                        }
                        str = typeAdapter.read(jsonReader);
                    } else if ("cachedBidUsed".equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter2 = this.f8045b;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f8046c.getAdapter(Boolean.class);
                            this.f8045b = typeAdapter2;
                        }
                        z = typeAdapter2.read(jsonReader).booleanValue();
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2524h(str, z);
        }
    }

    C2524h(String str, boolean z) {
        super(str, z);
    }
}
