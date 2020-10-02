package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2540m;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.criteo.publisher.t.e */
final class C2518e extends C2512a {

    /* renamed from: com.criteo.publisher.t.e$a */
    static final class C2519a extends TypeAdapter<C2540m> {

        /* renamed from: a */
        private volatile TypeAdapter<Long> f8030a;

        /* renamed from: b */
        private volatile TypeAdapter<Boolean> f8031b;

        /* renamed from: c */
        private volatile TypeAdapter<String> f8032c;

        /* renamed from: d */
        private final Gson f8033d;

        C2519a(Gson gson) {
            this.f8033d = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2540m mVar) throws IOException {
            Class<String> cls = String.class;
            Class<Boolean> cls2 = Boolean.class;
            Class<Long> cls3 = Long.class;
            if (mVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("cdbCallStartTimestamp");
            if (mVar.mo10524b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Long> typeAdapter = this.f8030a;
                if (typeAdapter == null) {
                    typeAdapter = this.f8033d.getAdapter(cls3);
                    this.f8030a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, mVar.mo10524b());
            }
            jsonWriter.name("cdbCallEndTimestamp");
            if (mVar.mo10523a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Long> typeAdapter2 = this.f8030a;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f8033d.getAdapter(cls3);
                    this.f8030a = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, mVar.mo10523a());
            }
            jsonWriter.name("cdbCallTimeout");
            TypeAdapter<Boolean> typeAdapter3 = this.f8031b;
            if (typeAdapter3 == null) {
                typeAdapter3 = this.f8033d.getAdapter(cls2);
                this.f8031b = typeAdapter3;
            }
            typeAdapter3.write(jsonWriter, Boolean.valueOf(mVar.mo10530g()));
            jsonWriter.name("cachedBidUsed");
            TypeAdapter<Boolean> typeAdapter4 = this.f8031b;
            if (typeAdapter4 == null) {
                typeAdapter4 = this.f8033d.getAdapter(cls2);
                this.f8031b = typeAdapter4;
            }
            typeAdapter4.write(jsonWriter, Boolean.valueOf(mVar.mo10529f()));
            jsonWriter.name("elapsedTimestamp");
            if (mVar.mo10525c() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Long> typeAdapter5 = this.f8030a;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.f8033d.getAdapter(cls3);
                    this.f8030a = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, mVar.mo10525c());
            }
            jsonWriter.name("impressionId");
            if (mVar.mo10526d() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.f8032c;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.f8033d.getAdapter(cls);
                    this.f8032c = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, mVar.mo10526d());
            }
            jsonWriter.name("requestGroupId");
            if (mVar.mo10527e() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter7 = this.f8032c;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.f8033d.getAdapter(cls);
                    this.f8032c = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, mVar.mo10527e());
            }
            jsonWriter.name("readyToSend");
            TypeAdapter<Boolean> typeAdapter8 = this.f8031b;
            if (typeAdapter8 == null) {
                typeAdapter8 = this.f8033d.getAdapter(cls2);
                this.f8031b = typeAdapter8;
            }
            typeAdapter8.write(jsonWriter, Boolean.valueOf(mVar.mo10531h()));
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "Metric" + ")";
        }

        public C2540m read(JsonReader jsonReader) throws IOException {
            Class<String> cls = String.class;
            Class<Boolean> cls2 = Boolean.class;
            Class<Long> cls3 = Long.class;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            C2540m.C2541a j = C2540m.m9538j();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("cdbCallStartTimestamp".equals(nextName)) {
                        TypeAdapter<Long> typeAdapter = this.f8030a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f8033d.getAdapter(cls3);
                            this.f8030a = typeAdapter;
                        }
                        j.mo10539b(typeAdapter.read(jsonReader));
                    } else if ("cdbCallEndTimestamp".equals(nextName)) {
                        TypeAdapter<Long> typeAdapter2 = this.f8030a;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f8033d.getAdapter(cls3);
                            this.f8030a = typeAdapter2;
                        }
                        j.mo10535a(typeAdapter2.read(jsonReader));
                    } else if ("cdbCallTimeout".equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter3 = this.f8031b;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f8033d.getAdapter(cls2);
                            this.f8031b = typeAdapter3;
                        }
                        j.mo10541b(typeAdapter3.read(jsonReader).booleanValue());
                    } else if ("cachedBidUsed".equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter4 = this.f8031b;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.f8033d.getAdapter(cls2);
                            this.f8031b = typeAdapter4;
                        }
                        j.mo10537a(typeAdapter4.read(jsonReader).booleanValue());
                    } else if ("elapsedTimestamp".equals(nextName)) {
                        TypeAdapter<Long> typeAdapter5 = this.f8030a;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.f8033d.getAdapter(cls3);
                            this.f8030a = typeAdapter5;
                        }
                        j.mo10542c(typeAdapter5.read(jsonReader));
                    } else if ("impressionId".equals(nextName)) {
                        TypeAdapter<String> typeAdapter6 = this.f8032c;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.f8033d.getAdapter(cls);
                            this.f8032c = typeAdapter6;
                        }
                        j.mo10536a(typeAdapter6.read(jsonReader));
                    } else if ("requestGroupId".equals(nextName)) {
                        TypeAdapter<String> typeAdapter7 = this.f8032c;
                        if (typeAdapter7 == null) {
                            typeAdapter7 = this.f8033d.getAdapter(cls);
                            this.f8032c = typeAdapter7;
                        }
                        j.mo10540b(typeAdapter7.read(jsonReader));
                    } else if ("readyToSend".equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter8 = this.f8031b;
                        if (typeAdapter8 == null) {
                            typeAdapter8 = this.f8033d.getAdapter(cls2);
                            this.f8031b = typeAdapter8;
                        }
                        j.mo10543c(typeAdapter8.read(jsonReader).booleanValue());
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return j.mo10538a();
        }
    }

    C2518e(Long l, Long l2, boolean z, boolean z2, Long l3, String str, String str2, boolean z3) {
        super(l, l2, z, z2, l3, str, str2, z3);
    }
}
