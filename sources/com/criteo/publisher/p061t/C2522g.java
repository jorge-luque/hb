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

/* renamed from: com.criteo.publisher.t.g */
final class C2522g extends C2516c {

    /* renamed from: com.criteo.publisher.t.g$a */
    static final class C2523a extends TypeAdapter<C2551t.C2552a> {

        /* renamed from: a */
        private volatile TypeAdapter<List<C2551t.C2553b>> f8038a;

        /* renamed from: b */
        private volatile TypeAdapter<Long> f8039b;

        /* renamed from: c */
        private volatile TypeAdapter<Boolean> f8040c;

        /* renamed from: d */
        private volatile TypeAdapter<Long> f8041d;

        /* renamed from: e */
        private volatile TypeAdapter<String> f8042e;

        /* renamed from: f */
        private final Gson f8043f;

        C2523a(Gson gson) {
            this.f8043f = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2551t.C2552a aVar) throws IOException {
            Class<Long> cls = Long.class;
            if (aVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("slots");
            if (aVar.mo10554e() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<C2551t.C2553b>> typeAdapter = this.f8038a;
                if (typeAdapter == null) {
                    typeAdapter = this.f8043f.getAdapter(TypeToken.getParameterized(List.class, C2551t.C2553b.class));
                    this.f8038a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, aVar.mo10554e());
            }
            jsonWriter.name("elapsed");
            if (aVar.mo10552c() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Long> typeAdapter2 = this.f8039b;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f8043f.getAdapter(cls);
                    this.f8039b = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, aVar.mo10552c());
            }
            jsonWriter.name("isTimeout");
            TypeAdapter<Boolean> typeAdapter3 = this.f8040c;
            if (typeAdapter3 == null) {
                typeAdapter3 = this.f8043f.getAdapter(Boolean.class);
                this.f8040c = typeAdapter3;
            }
            typeAdapter3.write(jsonWriter, Boolean.valueOf(aVar.mo10556f()));
            jsonWriter.name("cdbCallStartElapsed");
            TypeAdapter<Long> typeAdapter4 = this.f8041d;
            if (typeAdapter4 == null) {
                typeAdapter4 = this.f8043f.getAdapter(cls);
                this.f8041d = typeAdapter4;
            }
            typeAdapter4.write(jsonWriter, Long.valueOf(aVar.mo10551b()));
            jsonWriter.name("cdbCallEndElapsed");
            if (aVar.mo10550a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Long> typeAdapter5 = this.f8039b;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.f8043f.getAdapter(cls);
                    this.f8039b = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, aVar.mo10550a());
            }
            jsonWriter.name("requestGroupId");
            if (aVar.mo10553d() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.f8042e;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.f8043f.getAdapter(String.class);
                    this.f8042e = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, aVar.mo10553d());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "MetricRequest.MetricRequestFeedback" + ")";
        }

        public C2551t.C2552a read(JsonReader jsonReader) throws IOException {
            Class<Long> cls = Long.class;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            long j = 0;
            List list = null;
            Long l = null;
            Long l2 = null;
            String str = null;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    if (nextName.hashCode() == -1893690153 && nextName.equals("isTimeout")) {
                        c = 0;
                    }
                    if (c == 0) {
                        TypeAdapter<Boolean> typeAdapter = this.f8040c;
                        if (typeAdapter == null) {
                            typeAdapter = this.f8043f.getAdapter(Boolean.class);
                            this.f8040c = typeAdapter;
                        }
                        z = typeAdapter.read(jsonReader).booleanValue();
                    } else if ("slots".equals(nextName)) {
                        TypeAdapter<List<C2551t.C2553b>> typeAdapter2 = this.f8038a;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f8043f.getAdapter(TypeToken.getParameterized(List.class, C2551t.C2553b.class));
                            this.f8038a = typeAdapter2;
                        }
                        list = typeAdapter2.read(jsonReader);
                    } else if ("elapsed".equals(nextName)) {
                        TypeAdapter<Long> typeAdapter3 = this.f8039b;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f8043f.getAdapter(cls);
                            this.f8039b = typeAdapter3;
                        }
                        l = typeAdapter3.read(jsonReader);
                    } else if ("cdbCallStartElapsed".equals(nextName)) {
                        TypeAdapter<Long> typeAdapter4 = this.f8041d;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.f8043f.getAdapter(cls);
                            this.f8041d = typeAdapter4;
                        }
                        j = typeAdapter4.read(jsonReader).longValue();
                    } else if ("cdbCallEndElapsed".equals(nextName)) {
                        TypeAdapter<Long> typeAdapter5 = this.f8039b;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.f8043f.getAdapter(cls);
                            this.f8039b = typeAdapter5;
                        }
                        l2 = typeAdapter5.read(jsonReader);
                    } else if ("requestGroupId".equals(nextName)) {
                        TypeAdapter<String> typeAdapter6 = this.f8042e;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.f8043f.getAdapter(String.class);
                            this.f8042e = typeAdapter6;
                        }
                        str = typeAdapter6.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new C2522g(list, l, z, j, l2, str);
        }
    }

    C2522g(List<C2551t.C2553b> list, Long l, boolean z, long j, Long l2, String str) {
        super(list, l, z, j, l2, str);
    }
}
