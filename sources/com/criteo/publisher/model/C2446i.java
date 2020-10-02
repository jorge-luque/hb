package com.criteo.publisher.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.criteo.publisher.model.i */
final class C2446i extends C2437c {

    /* renamed from: com.criteo.publisher.model.i$a */
    static final class C2447a extends TypeAdapter<C2464v> {

        /* renamed from: a */
        private volatile TypeAdapter<Boolean> f7886a;

        /* renamed from: b */
        private volatile TypeAdapter<String> f7887b;

        /* renamed from: c */
        private final Gson f7888c;

        C2447a(Gson gson) {
            this.f7888c = gson;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, C2464v vVar) throws IOException {
            Class<Boolean> cls = Boolean.class;
            Class<String> cls2 = String.class;
            if (vVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("killSwitch");
            if (vVar.mo10340f() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter = this.f7886a;
                if (typeAdapter == null) {
                    typeAdapter = this.f7888c.getAdapter(cls);
                    this.f7886a = typeAdapter;
                }
                typeAdapter.write(jsonWriter, vVar.mo10340f());
            }
            jsonWriter.name("AndroidDisplayUrlMacro");
            if (vVar.mo10337d() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.f7887b;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.f7888c.getAdapter(cls2);
                    this.f7887b = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, vVar.mo10337d());
            }
            jsonWriter.name("AndroidAdTagUrlMode");
            if (vVar.mo10336c() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.f7887b;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.f7888c.getAdapter(cls2);
                    this.f7887b = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, vVar.mo10336c());
            }
            jsonWriter.name("AndroidAdTagDataMacro");
            if (vVar.mo10334a() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.f7887b;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.f7888c.getAdapter(cls2);
                    this.f7887b = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, vVar.mo10334a());
            }
            jsonWriter.name("AndroidAdTagDataMode");
            if (vVar.mo10335b() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.f7887b;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.f7888c.getAdapter(cls2);
                    this.f7887b = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, vVar.mo10335b());
            }
            jsonWriter.name("csmEnabled");
            if (vVar.mo10338e() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter6 = this.f7886a;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.f7888c.getAdapter(cls);
                    this.f7886a = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, vVar.mo10338e());
            }
            jsonWriter.endObject();
        }

        public String toString() {
            return "TypeAdapter(" + "RemoteConfigResponse" + ")";
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00fe  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.criteo.publisher.model.C2464v read(com.google.gson.stream.JsonReader r17) throws java.io.IOException {
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
                r13 = r12
            L_0x001e:
                boolean r4 = r17.hasNext()
                if (r4 == 0) goto L_0x0113
                java.lang.String r4 = r17.nextName()
                com.google.gson.stream.JsonToken r5 = r17.peek()
                com.google.gson.stream.JsonToken r6 = com.google.gson.stream.JsonToken.NULL
                if (r5 != r6) goto L_0x0034
                r17.nextNull()
                goto L_0x001e
            L_0x0034:
                int r6 = r4.hashCode()
                r7 = -648432651(0xffffffffd959b3f5, float:-3.82987092E15)
                r14 = 2
                r15 = 1
                r5 = 3
                if (r6 == r7) goto L_0x006e
                r7 = 28088106(0x1ac972a, float:6.339973E-38)
                if (r6 == r7) goto L_0x0064
                r7 = 1373006778(0x51d66bba, float:1.15116294E11)
                if (r6 == r7) goto L_0x005a
                r7 = 1395208240(0x53293030, float:7.2665793E11)
                if (r6 == r7) goto L_0x0050
                goto L_0x0078
            L_0x0050:
                java.lang.String r6 = "AndroidDisplayUrlMacro"
                boolean r6 = r4.equals(r6)
                if (r6 == 0) goto L_0x0078
                r6 = 0
                goto L_0x0079
            L_0x005a:
                java.lang.String r6 = "AndroidAdTagDataMacro"
                boolean r6 = r4.equals(r6)
                if (r6 == 0) goto L_0x0078
                r6 = 2
                goto L_0x0079
            L_0x0064:
                java.lang.String r6 = "AndroidAdTagUrlMode"
                boolean r6 = r4.equals(r6)
                if (r6 == 0) goto L_0x0078
                r6 = 1
                goto L_0x0079
            L_0x006e:
                java.lang.String r6 = "AndroidAdTagDataMode"
                boolean r6 = r4.equals(r6)
                if (r6 == 0) goto L_0x0078
                r6 = 3
                goto L_0x0079
            L_0x0078:
                r6 = -1
            L_0x0079:
                if (r6 == 0) goto L_0x00fe
                if (r6 == r15) goto L_0x00e9
                if (r6 == r14) goto L_0x00d4
                if (r6 == r5) goto L_0x00bf
                java.lang.String r5 = "killSwitch"
                boolean r5 = r5.equals(r4)
                if (r5 == 0) goto L_0x009d
                com.google.gson.TypeAdapter<java.lang.Boolean> r4 = r0.f7886a
                if (r4 != 0) goto L_0x0095
                com.google.gson.Gson r4 = r0.f7888c
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r2)
                r0.f7886a = r4
            L_0x0095:
                java.lang.Object r4 = r4.read(r1)
                r8 = r4
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                goto L_0x001e
            L_0x009d:
                java.lang.String r5 = "csmEnabled"
                boolean r4 = r5.equals(r4)
                if (r4 == 0) goto L_0x00ba
                com.google.gson.TypeAdapter<java.lang.Boolean> r4 = r0.f7886a
                if (r4 != 0) goto L_0x00b1
                com.google.gson.Gson r4 = r0.f7888c
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r2)
                r0.f7886a = r4
            L_0x00b1:
                java.lang.Object r4 = r4.read(r1)
                r13 = r4
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                goto L_0x001e
            L_0x00ba:
                r17.skipValue()
                goto L_0x001e
            L_0x00bf:
                com.google.gson.TypeAdapter<java.lang.String> r4 = r0.f7887b
                if (r4 != 0) goto L_0x00cb
                com.google.gson.Gson r4 = r0.f7888c
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r3)
                r0.f7887b = r4
            L_0x00cb:
                java.lang.Object r4 = r4.read(r1)
                java.lang.String r4 = (java.lang.String) r4
                r12 = r4
                goto L_0x001e
            L_0x00d4:
                com.google.gson.TypeAdapter<java.lang.String> r4 = r0.f7887b
                if (r4 != 0) goto L_0x00e0
                com.google.gson.Gson r4 = r0.f7888c
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r3)
                r0.f7887b = r4
            L_0x00e0:
                java.lang.Object r4 = r4.read(r1)
                java.lang.String r4 = (java.lang.String) r4
                r11 = r4
                goto L_0x001e
            L_0x00e9:
                com.google.gson.TypeAdapter<java.lang.String> r4 = r0.f7887b
                if (r4 != 0) goto L_0x00f5
                com.google.gson.Gson r4 = r0.f7888c
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r3)
                r0.f7887b = r4
            L_0x00f5:
                java.lang.Object r4 = r4.read(r1)
                java.lang.String r4 = (java.lang.String) r4
                r10 = r4
                goto L_0x001e
            L_0x00fe:
                com.google.gson.TypeAdapter<java.lang.String> r4 = r0.f7887b
                if (r4 != 0) goto L_0x010a
                com.google.gson.Gson r4 = r0.f7888c
                com.google.gson.TypeAdapter r4 = r4.getAdapter(r3)
                r0.f7887b = r4
            L_0x010a:
                java.lang.Object r4 = r4.read(r1)
                java.lang.String r4 = (java.lang.String) r4
                r9 = r4
                goto L_0x001e
            L_0x0113:
                r17.endObject()
                com.criteo.publisher.model.i r1 = new com.criteo.publisher.model.i
                r7 = r1
                r7.<init>(r8, r9, r10, r11, r12, r13)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.model.C2446i.C2447a.read(com.google.gson.stream.JsonReader):com.criteo.publisher.model.v");
        }
    }

    C2446i(Boolean bool, String str, String str2, String str3, String str4, Boolean bool2) {
        super(bool, str, str2, str3, str4, bool2);
    }
}
