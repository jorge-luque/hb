package com.criteo.publisher.model.p055z;

import com.criteo.publisher.model.p055z.C2488n;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.io.IOException;
import java.util.List;

/* renamed from: com.criteo.publisher.model.z.h */
final class C2477h extends C2469b {

    /* renamed from: com.criteo.publisher.model.z.h$a */
    static final class C2478a extends TypeAdapter<C2488n> {

        /* renamed from: a */
        private volatile TypeAdapter<List<C2493r>> f7967a;

        /* renamed from: b */
        private volatile TypeAdapter<C2487m> f7968b;

        /* renamed from: c */
        private volatile TypeAdapter<C2492q> f7969c;

        /* renamed from: d */
        private volatile TypeAdapter<List<C2491p>> f7970d;

        /* renamed from: e */
        private final Gson f7971e;

        C2478a(Gson gson) {
            this.f7971e = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2488n nVar) throws IOException {
            if (nVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("products");
            if (nVar.mo10436g() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<C2493r>> typeAdapter = this.f7967a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7971e.getAdapter(TypeToken.getParameterized(List.class, C2493r.class));
                    this.f7967a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, nVar.mo10436g());
            }
            jsonWriter.name(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER);
            if (nVar.mo10434a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<C2487m> typeAdapter2 = this.f7968b;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f7971e.getAdapter(C2487m.class);
                    this.f7968b = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, nVar.mo10434a());
            }
            jsonWriter.name("privacy");
            if (nVar.mo10439i() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<C2492q> typeAdapter3 = this.f7969c;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.f7971e.getAdapter(C2492q.class);
                    this.f7969c = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, nVar.mo10439i());
            }
            jsonWriter.name("impressionPixels");
            if (nVar.mo10437h() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<C2491p>> typeAdapter4 = this.f7970d;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.f7971e.getAdapter(TypeToken.getParameterized(List.class, C2491p.class));
                    this.f7970d = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, nVar.mo10437h());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "NativeAssets" + ")";
        }

        public C2488n read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            C2488n.C2489a n = C2488n.m9388n();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    int hashCode = nextName.hashCode();
                    if (hashCode != -1684631018) {
                        if (hashCode == -1003761308 && nextName.equals("products")) {
                            c = 0;
                        }
                    } else if (nextName.equals("impressionPixels")) {
                        c = 1;
                    }
                    if (c == 0) {
                        TypeAdapter<List<C2493r>> typeAdapter = this.f7967a;
                        if (typeAdapter == null) {
                            typeAdapter = this.f7971e.getAdapter(TypeToken.getParameterized(List.class, C2493r.class));
                            this.f7967a = typeAdapter;
                        }
                        n.mo10443a(typeAdapter.read(jsonReader));
                    } else if (c == 1) {
                        TypeAdapter<List<C2491p>> typeAdapter2 = this.f7970d;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.f7971e.getAdapter(TypeToken.getParameterized(List.class, C2491p.class));
                            this.f7970d = typeAdapter2;
                        }
                        n.mo10445b(typeAdapter2.read(jsonReader));
                    } else if (VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER.equals(nextName)) {
                        TypeAdapter<C2487m> typeAdapter3 = this.f7968b;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.f7971e.getAdapter(C2487m.class);
                            this.f7968b = typeAdapter3;
                        }
                        n.mo10441a(typeAdapter3.read(jsonReader));
                    } else if ("privacy".equals(nextName)) {
                        TypeAdapter<C2492q> typeAdapter4 = this.f7969c;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.f7971e.getAdapter(C2492q.class);
                            this.f7969c = typeAdapter4;
                        }
                        n.mo10442a(typeAdapter4.read(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return n.mo10492b();
        }
    }

    C2477h(List<C2493r> list, C2487m mVar, C2492q qVar, List<C2491p> list2) {
        super(list, mVar, qVar, list2);
    }
}
