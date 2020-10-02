package com.criteo.publisher.model;

import java.util.List;

/* renamed from: com.criteo.publisher.model.o */
public class C2454o {

    /* renamed from: c */
    private static final String f7906c = "o";

    /* renamed from: a */
    private final List<C2465w> f7907a;

    /* renamed from: b */
    private final int f7908b;

    public C2454o(List<C2465w> list, int i) {
        this.f7907a = list;
        this.f7908b = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0031  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.criteo.publisher.model.C2454o m9272a(org.json.JSONObject r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "timeToNextCall"
            boolean r2 = r6.has(r1)
            r3 = 0
            if (r2 == 0) goto L_0x0028
            int r1 = r6.getInt(r1)     // Catch:{ JSONException -> 0x0013 }
            goto L_0x0029
        L_0x0013:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Exception while reading cdb time to next call"
            r2.append(r4)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            r2.toString()
        L_0x0028:
            r1 = 0
        L_0x0029:
            java.lang.String r2 = "slots"
            boolean r4 = r6.has(r2)
            if (r4 == 0) goto L_0x007b
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            org.json.JSONArray r4 = r6.getJSONArray(r2)     // Catch:{ JSONException -> 0x003b }
            goto L_0x0050
        L_0x003b:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Exception while reading slots array"
            r2.append(r5)
            java.lang.String r6 = r6.getMessage()
            r2.append(r6)
            r2.toString()
        L_0x0050:
            int r6 = r4.length()
            if (r3 >= r6) goto L_0x007b
            org.json.JSONObject r6 = r4.getJSONObject(r3)     // Catch:{ Exception -> 0x0063 }
            com.criteo.publisher.model.w r2 = new com.criteo.publisher.model.w     // Catch:{ Exception -> 0x0063 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0063 }
            r0.add(r2)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0078
        L_0x0063:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Exception while reading slot from slots array"
            r2.append(r5)
            java.lang.String r6 = r6.getMessage()
            r2.append(r6)
            r2.toString()
        L_0x0078:
            int r3 = r3 + 1
            goto L_0x0050
        L_0x007b:
            com.criteo.publisher.model.o r6 = new com.criteo.publisher.model.o
            r6.<init>(r0, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.model.C2454o.m9272a(org.json.JSONObject):com.criteo.publisher.model.o");
    }

    /* renamed from: b */
    public int mo10379b() {
        return this.f7908b;
    }

    public String toString() {
        return "CdbResponse{slots=" + this.f7907a + ", timeToNextCall=" + this.f7908b + '}';
    }

    /* renamed from: a */
    public List<C2465w> mo10378a() {
        return this.f7907a;
    }

    /* renamed from: a */
    public C2465w mo10377a(String str) {
        for (C2465w next : this.f7907a) {
            if (str.equals(next.mo10408e())) {
                return next;
            }
        }
        return null;
    }
}
