package com.criteo.publisher.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.criteo.publisher.model.h */
final class C2444h extends C2436b {

    /* renamed from: com.criteo.publisher.model.h$a */
    static final class C2445a extends TypeAdapter<C2462t> {

        /* renamed from: a */
        private volatile TypeAdapter<String> f7883a;

        /* renamed from: b */
        private volatile TypeAdapter<Integer> f7884b;

        /* renamed from: c */
        private final Gson f7885c;

        C2445a(Gson gson) {
            this.f7885c = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2462t tVar) throws IOException {
            Class<String> cls = String.class;
            if (tVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("cpId");
            if (tVar.mo10328b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.f7883a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7885c.getAdapter(cls);
                    this.f7883a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, tVar.mo10328b());
            }
            jsonWriter.name("bundleId");
            if (tVar.mo10327a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.f7883a;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f7885c.getAdapter(cls);
                    this.f7883a = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, tVar.mo10327a());
            }
            jsonWriter.name("sdkVersion");
            if (tVar.mo10330d() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.f7883a;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.f7885c.getAdapter(cls);
                    this.f7883a = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, tVar.mo10330d());
            }
            jsonWriter.name("rtbProfileId");
            TypeAdapter<Integer> typeAdapter4 = this.f7884b;
            if (typeAdapter4 == null) {
                typeAdapter4 = this.f7885c.getAdapter(Integer.class);
                this.f7884b = typeAdapter4;
            }
            typeAdapter4.write(jsonWriter, Integer.valueOf(tVar.mo10329c()));
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "RemoteConfigRequest" + ")";
        }

        public C2462t read(JsonReader jsonReader) throws IOException {
            Class<String> cls = String.class;
            String str = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str2 = null;
            String str3 = null;
            int i = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    int hashCode = nextName.hashCode();
                    if (hashCode != -1537286620) {
                        if (hashCode == 3059304 && nextName.equals("cpId")) {
                            c = 0;
                        }
                    } else if (nextName.equals("rtbProfileId")) {
                        c = 1;
                    }
                    if (c == 0) {
                        TypeAdapter<String> typeAdapter = this.f7883a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f7885c.getAdapter(cls);
                            this.f7883a = typeAdapter;
                        }
                        str = typeAdapter.read(jsonReader);
                    } else if (c == 1) {
                        TypeAdapter<Integer> typeAdapter2 = this.f7884b;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f7885c.getAdapter(Integer.class);
                            this.f7884b = typeAdapter2;
                        }
                        i = typeAdapter2.read(jsonReader).intValue();
                    } else if ("bundleId".equals(nextName)) {
                        TypeAdapter<String> typeAdapter3 = this.f7883a;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f7885c.getAdapter(cls);
                            this.f7883a = typeAdapter3;
                        }
                        str2 = typeAdapter3.read(jsonReader);
                    } else if ("sdkVersion".equals(nextName)) {
                        TypeAdapter<String> typeAdapter4 = this.f7883a;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.f7885c.getAdapter(cls);
                            this.f7883a = typeAdapter4;
                        }
                        str3 = typeAdapter4.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2444h(str, str2, str3, i);
        }
    }

    C2444h(String str, String str2, String str3, int i) {
        super(str, str2, str3, i);
    }
}
