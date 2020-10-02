package com.criteo.publisher.model.p055z;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/* renamed from: com.criteo.publisher.model.z.k */
final class C2483k extends C2473e {

    /* renamed from: com.criteo.publisher.model.z.k$a */
    static final class C2484a extends TypeAdapter<C2492q> {

        /* renamed from: a */
        private volatile TypeAdapter<URI> f7976a;

        /* renamed from: b */
        private volatile TypeAdapter<URL> f7977b;

        /* renamed from: c */
        private volatile TypeAdapter<String> f7978c;

        /* renamed from: d */
        private final Gson f7979d;

        C2484a(Gson gson) {
            this.f7979d = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2492q qVar) throws IOException {
            if (qVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("optoutClickUrl");
            if (qVar.mo10456a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<URI> typeAdapter = this.f7976a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7979d.getAdapter(URI.class);
                    this.f7976a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, qVar.mo10456a());
            }
            jsonWriter.name("optoutImageUrl");
            if (qVar.mo10457b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<URL> typeAdapter2 = this.f7977b;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f7979d.getAdapter(URL.class);
                    this.f7977b = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, qVar.mo10457b());
            }
            jsonWriter.name("longLegalText");
            if (qVar.mo10458c() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.f7978c;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.f7979d.getAdapter(String.class);
                    this.f7978c = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, qVar.mo10458c());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "NativePrivacy" + ")";
        }

        public C2492q read(JsonReader jsonReader) throws IOException {
            URI uri = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            URL url = null;
            String str = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    int hashCode = nextName.hashCode();
                    if (hashCode != -111772945) {
                        if (hashCode != 763886698) {
                            if (hashCode == 1654281122 && nextName.equals("optoutClickUrl")) {
                                c = 0;
                            }
                        } else if (nextName.equals("longLegalText")) {
                            c = 2;
                        }
                    } else if (nextName.equals("optoutImageUrl")) {
                        c = 1;
                    }
                    if (c == 0) {
                        TypeAdapter<URI> typeAdapter = this.f7976a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f7979d.getAdapter(URI.class);
                            this.f7976a = typeAdapter;
                        }
                        uri = typeAdapter.read(jsonReader);
                    } else if (c == 1) {
                        TypeAdapter<URL> typeAdapter2 = this.f7977b;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f7979d.getAdapter(URL.class);
                            this.f7977b = typeAdapter2;
                        }
                        url = typeAdapter2.read(jsonReader);
                    } else if (c != 2) {
                        jsonReader.skipValue();
                    } else {
                        TypeAdapter<String> typeAdapter3 = this.f7978c;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f7979d.getAdapter(String.class);
                            this.f7978c = typeAdapter3;
                        }
                        str = typeAdapter3.read(jsonReader);
                    }
                }
            }
            jsonReader.endObject();
            return new C2483k(uri, url, str);
        }
    }

    C2483k(URI uri, URL url, String str) {
        super(uri, url, str);
    }
}
