package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2551t;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* renamed from: com.criteo.publisher.t.f */
final class C2520f extends C2515b {

    /* renamed from: com.criteo.publisher.t.f$a */
    static final class C2521a extends TypeAdapter<C2551t> {

        /* renamed from: a */
        private volatile TypeAdapter<List<C2551t.C2552a>> f8034a;

        /* renamed from: b */
        private volatile TypeAdapter<String> f8035b;

        /* renamed from: c */
        private volatile TypeAdapter<Integer> f8036c;

        /* renamed from: d */
        private final Gson f8037d;

        C2521a(Gson gson) {
            this.f8037d = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2551t tVar) throws IOException {
            if (tVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("feedbacks");
            if (tVar.mo10544a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<C2551t.C2552a>> typeAdapter = this.f8034a;
                if (typeAdapter == null) {
                    typeAdapter = this.f8037d.getAdapter(TypeToken.getParameterized(List.class, C2551t.C2552a.class));
                    this.f8034a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, tVar.mo10544a());
            }
            jsonWriter.name("wrapper_version");
            if (tVar.mo10546c() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.f8035b;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f8037d.getAdapter(String.class);
                    this.f8035b = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, tVar.mo10546c());
            }
            jsonWriter.name("profile_id");
            TypeAdapter<Integer> typeAdapter3 = this.f8036c;
            if (typeAdapter3 == null) {
                typeAdapter3 = this.f8037d.getAdapter(Integer.class);
                this.f8036c = typeAdapter3;
            }
            typeAdapter3.write(jsonWriter, Integer.valueOf(tVar.mo10545b()));
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "MetricRequest" + ")";
        }

        public C2551t read(JsonReader jsonReader) throws IOException {
            List list = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = null;
            int i = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    int hashCode = nextName.hashCode();
                    if (hashCode != -1102636175) {
                        if (hashCode == 1143342380 && nextName.equals("wrapper_version")) {
                            c = 0;
                        }
                    } else if (nextName.equals("profile_id")) {
                        c = 1;
                    }
                    if (c == 0) {
                        TypeAdapter<String> typeAdapter = this.f8035b;
                        if (typeAdapter == null) {
                            typeAdapter = this.f8037d.getAdapter(String.class);
                            this.f8035b = typeAdapter;
                        }
                        str = typeAdapter.read(jsonReader);
                    } else if (c == 1) {
                        TypeAdapter<Integer> typeAdapter2 = this.f8036c;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f8037d.getAdapter(Integer.class);
                            this.f8036c = typeAdapter2;
                        }
                        i = typeAdapter2.read(jsonReader).intValue();
                    } else if ("feedbacks".equals(nextName)) {
                        TypeAdapter<List<C2551t.C2552a>> typeAdapter3 = this.f8034a;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f8037d.getAdapter(TypeToken.getParameterized(List.class, C2551t.C2552a.class));
                            this.f8034a = typeAdapter3;
                        }
                        list = typeAdapter3.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2520f(list, str, i);
        }
    }

    C2520f(List<C2551t.C2552a> list, String str, int i) {
        super(list, str, i);
    }
}
