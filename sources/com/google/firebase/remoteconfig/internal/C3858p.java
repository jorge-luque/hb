package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.C3862k;
import com.google.firebase.remoteconfig.internal.C3845f;
import com.google.firebase.remoteconfig.p131m.C3865b;
import com.google.firebase.remoteconfig.p131m.C3868d;
import com.google.firebase.remoteconfig.p131m.C3874h;
import com.google.firebase.remoteconfig.p131m.C3877j;
import com.google.protobuf.C3995f;
import com.google.protobuf.InvalidProtocolBufferException;
import com.loopj.android.http.C4250c;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p190g.p191a.p192a.C5920d;

/* renamed from: com.google.firebase.remoteconfig.internal.p */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3858p {

    /* renamed from: d */
    private static final Charset f10657d = Charset.forName(C4250c.DEFAULT_CHARSET);

    /* renamed from: e */
    static final ThreadLocal<DateFormat> f10658e = new C3859a();

    /* renamed from: a */
    private final Context f10659a;

    /* renamed from: b */
    private final String f10660b;

    /* renamed from: c */
    private final SharedPreferences f10661c;

    /* renamed from: com.google.firebase.remoteconfig.internal.p$a */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    class C3859a extends ThreadLocal<DateFormat> {
        C3859a() {
        }

        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        }
    }

    /* renamed from: com.google.firebase.remoteconfig.internal.p$b */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    private static class C3860b {

        /* renamed from: a */
        private C3845f f10662a;

        /* renamed from: b */
        private C3845f f10663b;

        /* renamed from: c */
        private C3845f f10664c;

        /* synthetic */ C3860b(C3859a aVar) {
            this();
        }

        private C3860b() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m13074a(C3845f fVar) {
            this.f10663b = fVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m13078b(C3845f fVar) {
            this.f10664c = fVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m13082c(C3845f fVar) {
            this.f10662a = fVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public C3845f m13072a() {
            return this.f10663b;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public C3845f m13076b() {
            return this.f10664c;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public C3845f m13080c() {
            return this.f10662a;
        }
    }

    public C3858p(Context context, String str) {
        this.f10659a = context;
        this.f10660b = str;
        this.f10661c = context.getSharedPreferences("com.google.firebase.remoteconfig_legacy_settings", 0);
    }

    /* renamed from: b */
    private Map<String, C3860b> m13067b() {
        C3877j c = m13069c();
        HashMap hashMap = new HashMap();
        if (c == null) {
            return hashMap;
        }
        Map<String, C3845f> a = m13063a(c.mo27623a());
        Map<String, C3845f> a2 = m13063a(c.mo27625c());
        Map<String, C3845f> a3 = m13063a(c.mo27624b());
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(a.keySet());
        hashSet.addAll(a2.keySet());
        hashSet.addAll(a3.keySet());
        for (String str : hashSet) {
            C3860b bVar = new C3860b((C3859a) null);
            if (a.containsKey(str)) {
                bVar.m13074a(a.get(str));
            }
            if (a2.containsKey(str)) {
                bVar.m13082c(a2.get(str));
            }
            if (a3.containsKey(str)) {
                bVar.m13078b(a3.get(str));
            }
            hashMap.put(str, bVar);
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x001e A[SYNTHETIC, Splitter:B:17:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0025 A[SYNTHETIC, Splitter:B:25:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x002c A[SYNTHETIC, Splitter:B:33:0x002c] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.firebase.remoteconfig.p131m.C3877j m13069c() {
        /*
            r4 = this;
            android.content.Context r0 = r4.f10659a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r2 = "persisted_config"
            java.io.FileInputStream r0 = r0.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x0029, IOException -> 0x0022, all -> 0x0018 }
            com.google.firebase.remoteconfig.m.j r1 = com.google.firebase.remoteconfig.p131m.C3877j.parseFrom(r0)     // Catch:{ FileNotFoundException -> 0x002a, IOException -> 0x0023, all -> 0x0016 }
            if (r0 == 0) goto L_0x0015
            r0.close()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            return r1
        L_0x0016:
            r1 = move-exception
            goto L_0x001c
        L_0x0018:
            r0 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            throw r1
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0028
            r0.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            return r1
        L_0x0029:
            r0 = r1
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.C3858p.m13069c():com.google.firebase.remoteconfig.m.j");
    }

    /* renamed from: a */
    public boolean mo27601a() {
        if (!this.f10661c.getBoolean("save_legacy_configs", true)) {
            return false;
        }
        m13066a(m13067b());
        this.f10661c.edit().putBoolean("save_legacy_configs", false).commit();
        return true;
    }

    /* renamed from: a */
    private void m13066a(Map<String, C3860b> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            C3860b bVar = (C3860b) next.getValue();
            C3842e a = mo27600a(str, "fetch");
            C3842e a2 = mo27600a(str, "activate");
            C3842e a3 = mo27600a(str, "defaults");
            if (bVar.m13080c() != null) {
                a.mo27561a(bVar.m13080c());
            }
            if (bVar.m13072a() != null) {
                a2.mo27561a(bVar.m13072a());
            }
            if (bVar.m13076b() != null) {
                a3.mo27561a(bVar.m13076b());
            }
        }
    }

    /* renamed from: a */
    private Map<String, C3845f> m13063a(C3865b bVar) {
        HashMap hashMap = new HashMap();
        Date date = new Date(bVar.mo27610b());
        JSONArray b = m13068b(bVar.getExperimentPayloadList());
        for (C3874h next : bVar.mo27609a()) {
            String namespace = next.getNamespace();
            if (namespace.startsWith("configns:")) {
                namespace = namespace.substring(9);
            }
            C3845f.C3847b e = C3845f.m13003e();
            e.mo27575a(m13064a(next.mo27620a()));
            e.mo27574a(date);
            if (namespace.equals("firebase")) {
                e.mo27576a(b);
            }
            try {
                hashMap.put(namespace, e.mo27578a());
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private JSONArray m13068b(List<C3995f> list) {
        JSONArray jSONArray = new JSONArray();
        for (C3995f a : list) {
            C5920d a2 = m13062a(a);
            if (a2 != null) {
                try {
                    jSONArray.put(m13065a(a2));
                } catch (JSONException unused) {
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    private C5920d m13062a(C3995f fVar) {
        try {
            C3995f.C4000e it = fVar.iterator();
            int size = fVar.size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = ((Byte) it.next()).byteValue();
            }
            return C5920d.parseFrom(bArr);
        } catch (InvalidProtocolBufferException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private JSONObject m13065a(C5920d dVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("experimentId", dVar.mo33709c());
        jSONObject.put("variantId", dVar.mo33717k());
        jSONObject.put("experimentStartTime", f10658e.get().format(new Date(dVar.mo33710d())));
        jSONObject.put("triggerEvent", dVar.mo33714h());
        jSONObject.put("triggerTimeoutMillis", dVar.mo33715i());
        jSONObject.put("timeToLiveMillis", dVar.mo33712f());
        return jSONObject;
    }

    /* renamed from: a */
    private Map<String, String> m13064a(List<C3868d> list) {
        HashMap hashMap = new HashMap();
        for (C3868d next : list) {
            hashMap.put(next.getKey(), next.getValue().mo28107a(f10657d));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3842e mo27600a(String str, String str2) {
        return C3862k.m13085a(this.f10659a, this.f10660b, str, str2);
    }
}
