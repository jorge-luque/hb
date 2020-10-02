package com.criteo.publisher.model;

import admost.sdk.AdMostInterstitial;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import com.vungle.warren.model.ReportDBAdapter;
import java.io.IOException;
import java.util.Collection;

/* renamed from: com.criteo.publisher.model.g */
final class C2442g extends C2435a {

    /* renamed from: com.criteo.publisher.model.g$a */
    static final class C2443a extends TypeAdapter<C2453n> {

        /* renamed from: a */
        private volatile TypeAdapter<String> f7879a;

        /* renamed from: b */
        private volatile TypeAdapter<Boolean> f7880b;

        /* renamed from: c */
        private volatile TypeAdapter<Collection<String>> f7881c;

        /* renamed from: d */
        private final Gson f7882d;

        C2443a(Gson gson) {
            this.f7882d = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2453n nVar) throws IOException {
            Class<Boolean> cls = Boolean.class;
            Class<String> cls2 = String.class;
            if (nVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("impId");
            if (nVar.mo10319a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.f7879a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7882d.getAdapter(cls2);
                    this.f7879a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, nVar.mo10319a());
            }
            jsonWriter.name(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID);
            if (nVar.mo10320b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.f7879a;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f7882d.getAdapter(cls2);
                    this.f7879a = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, nVar.mo10320b());
            }
            jsonWriter.name("isNative");
            if (nVar.mo10323e() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter3 = this.f7880b;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.f7882d.getAdapter(cls);
                    this.f7880b = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, nVar.mo10323e());
            }
            jsonWriter.name(AdMostInterstitial.ZONE_TYPE_INTERSTITIAL);
            if (nVar.mo10322d() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter4 = this.f7880b;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.f7882d.getAdapter(cls);
                    this.f7880b = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, nVar.mo10322d());
            }
            jsonWriter.name("sizes");
            if (nVar.mo10321c() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Collection<String>> typeAdapter5 = this.f7881c;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.f7882d.getAdapter(TypeToken.getParameterized(Collection.class, cls2));
                    this.f7881c = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, nVar.mo10321c());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "CdbRequestSlot" + ")";
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.criteo.publisher.model.C2453n read(com.google.gson.stream.JsonReader r17) throws java.io.IOException {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                java.lang.Class<java.lang.Boolean> r2 = java.lang.Boolean.class
                java.lang.Class<java.lang.String> r3 = java.lang.String.class
                com.google.gson.stream.JsonToken r4 = r17.peek()
                com.google.gson.stream.JsonToken r5 = com.google.gson.stream.JsonToken.NULL
                r6 = 0
                if (r4 != r5) goto L_0x0015
                r17.nextNull()
                return r6
            L_0x0015:
                r17.beginObject()
                r8 = r6
                r9 = r8
                r10 = r9
                r11 = r10
                r12 = r11
            L_0x001d:
                boolean r4 = r17.hasNext()
                if (r4 == 0) goto L_0x00f4
                java.lang.String r4 = r17.nextName()
                com.google.gson.stream.JsonToken r5 = r17.peek()
                com.google.gson.stream.JsonToken r6 = com.google.gson.stream.JsonToken.NULL
                if (r5 != r6) goto L_0x0033
                r17.nextNull()
                goto L_0x001d
            L_0x0033:
                int r6 = r4.hashCode()
                r7 = 0
                r13 = 4
                r14 = 3
                r15 = 2
                r5 = 1
                switch(r6) {
                    case -378584607: goto L_0x0068;
                    case 100326919: goto L_0x005e;
                    case 109453458: goto L_0x0054;
                    case 604727084: goto L_0x004a;
                    case 732231392: goto L_0x0040;
                    default: goto L_0x003f;
                }
            L_0x003f:
                goto L_0x0072
            L_0x0040:
                java.lang.String r6 = "placementId"
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L_0x0072
                r4 = 1
                goto L_0x0073
            L_0x004a:
                java.lang.String r6 = "interstitial"
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L_0x0072
                r4 = 3
                goto L_0x0073
            L_0x0054:
                java.lang.String r6 = "sizes"
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L_0x0072
                r4 = 4
                goto L_0x0073
            L_0x005e:
                java.lang.String r6 = "impId"
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L_0x0072
                r4 = 0
                goto L_0x0073
            L_0x0068:
                java.lang.String r6 = "isNative"
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L_0x0072
                r4 = 2
                goto L_0x0073
            L_0x0072:
                r4 = -1
            L_0x0073:
                if (r4 == 0) goto L_0x00df
                if (r4 == r5) goto L_0x00ca
                if (r4 == r15) goto L_0x00b5
                if (r4 == r14) goto L_0x00a0
                if (r4 == r13) goto L_0x0081
                r17.skipValue()
                goto L_0x001d
            L_0x0081:
                com.google.gson.TypeAdapter<java.util.Collection<java.lang.String>> r4 = r0.f7881c
                if (r4 != 0) goto L_0x0097
                com.google.gson.Gson r4 = r0.f7882d
                java.lang.reflect.Type[] r5 = new java.lang.reflect.Type[r5]
                r5[r7] = r3
                java.lang.Class<java.util.Collection> r6 = java.util.Collection.class
                com.google.gson.reflect.TypeToken r5 = com.google.gson.reflect.TypeToken.getParameterized(r6, r5)
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r5)
                r0.f7881c = r4
            L_0x0097:
                java.lang.Object r4 = r4.read(r1)
                java.util.Collection r4 = (java.util.Collection) r4
                r12 = r4
                goto L_0x001d
            L_0x00a0:
                com.google.gson.TypeAdapter<java.lang.Boolean> r4 = r0.f7880b
                if (r4 != 0) goto L_0x00ac
                com.google.gson.Gson r4 = r0.f7882d
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r2)
                r0.f7880b = r4
            L_0x00ac:
                java.lang.Object r4 = r4.read(r1)
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                r11 = r4
                goto L_0x001d
            L_0x00b5:
                com.google.gson.TypeAdapter<java.lang.Boolean> r4 = r0.f7880b
                if (r4 != 0) goto L_0x00c1
                com.google.gson.Gson r4 = r0.f7882d
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r2)
                r0.f7880b = r4
            L_0x00c1:
                java.lang.Object r4 = r4.read(r1)
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                r10 = r4
                goto L_0x001d
            L_0x00ca:
                com.google.gson.TypeAdapter<java.lang.String> r4 = r0.f7879a
                if (r4 != 0) goto L_0x00d6
                com.google.gson.Gson r4 = r0.f7882d
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r3)
                r0.f7879a = r4
            L_0x00d6:
                java.lang.Object r4 = r4.read(r1)
                java.lang.String r4 = (java.lang.String) r4
                r9 = r4
                goto L_0x001d
            L_0x00df:
                com.google.gson.TypeAdapter<java.lang.String> r4 = r0.f7879a
                if (r4 != 0) goto L_0x00eb
                com.google.gson.Gson r4 = r0.f7882d
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r3)
                r0.f7879a = r4
            L_0x00eb:
                java.lang.Object r4 = r4.read(r1)
                java.lang.String r4 = (java.lang.String) r4
                r8 = r4
                goto L_0x001d
            L_0x00f4:
                r17.endObject()
                com.criteo.publisher.model.g r1 = new com.criteo.publisher.model.g
                r7 = r1
                r7.<init>(r8, r9, r10, r11, r12)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.model.C2442g.C2443a.read(com.google.gson.stream.JsonReader):com.criteo.publisher.model.n");
        }
    }

    C2442g(String str, String str2, Boolean bool, Boolean bool2, Collection<String> collection) {
        super(str, str2, bool, bool2, collection);
    }
}
