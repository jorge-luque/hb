package com.google.firebase.abt;

import android.text.TextUtils;
import com.google.firebase.analytics.p122a.C3619a;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.firebase.abt.a */
/* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
public class C3615a {

    /* renamed from: g */
    private static final String[] f10120g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* renamed from: h */
    static final DateFormat f10121h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* renamed from: a */
    private final String f10122a;

    /* renamed from: b */
    private final String f10123b;

    /* renamed from: c */
    private final String f10124c;

    /* renamed from: d */
    private final Date f10125d;

    /* renamed from: e */
    private final long f10126e;

    /* renamed from: f */
    private final long f10127f;

    public C3615a(String str, String str2, String str3, Date date, long j, long j2) {
        this.f10122a = str;
        this.f10123b = str2;
        this.f10124c = str3;
        this.f10125d = date;
        this.f10126e = j;
        this.f10127f = j2;
    }

    /* renamed from: a */
    static C3615a m12313a(Map<String, String> map) throws AbtException {
        m12314b(map);
        try {
            return new C3615a(map.get("experimentId"), map.get("variantId"), map.containsKey("triggerEvent") ? map.get("triggerEvent") : "", f10121h.parse(map.get("experimentStartTime")), Long.parseLong(map.get("triggerTimeoutMillis")), Long.parseLong(map.get("timeToLiveMillis")));
        } catch (ParseException e) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e);
        } catch (NumberFormatException e2) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo27186b() {
        return this.f10125d.getTime();
    }

    /* renamed from: b */
    private static void m12314b(Map<String, String> map) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (String str : f10120g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", new Object[]{arrayList}));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo27185a() {
        return this.f10122a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3619a.C3620a mo27184a(String str) {
        C3619a.C3620a aVar = new C3619a.C3620a();
        aVar.f10139a = str;
        aVar.f10151m = mo27186b();
        aVar.f10140b = this.f10122a;
        aVar.f10141c = this.f10123b;
        aVar.f10142d = TextUtils.isEmpty(this.f10124c) ? null : this.f10124c;
        aVar.f10143e = this.f10126e;
        aVar.f10148j = this.f10127f;
        return aVar;
    }
}
