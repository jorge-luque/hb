package com.onesignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.k0 */
/* compiled from: OSInAppMessage */
class C4535k0 {

    /* renamed from: a */
    public String f12392a;

    /* renamed from: b */
    public HashMap<String, HashMap<String, String>> f12393b;

    /* renamed from: c */
    public ArrayList<ArrayList<C4523i1>> f12394c;

    /* renamed from: d */
    private Set<String> f12395d;

    /* renamed from: e */
    private C4563n0 f12396e = new C4563n0();

    /* renamed from: f */
    private double f12397f;

    /* renamed from: g */
    private boolean f12398g = false;

    /* renamed from: h */
    private boolean f12399h = false;

    /* renamed from: i */
    private boolean f12400i;

    /* renamed from: j */
    boolean f12401j;

    C4535k0(boolean z) {
        this.f12401j = z;
    }

    /* renamed from: a */
    private HashMap<String, HashMap<String, String>> m15606a(JSONObject jSONObject) throws JSONException {
        HashMap<String, HashMap<String, String>> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            HashMap hashMap2 = new HashMap();
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                hashMap2.put(next2, jSONObject2.getString(next2));
            }
            hashMap.put(next, hashMap2);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29814b(boolean z) {
        this.f12399h = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public double mo29816c() {
        return this.f12397f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C4563n0 mo29817d() {
        return this.f12396e;
    }

    /* renamed from: e */
    public boolean mo29818e() {
        return this.f12398g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4535k0.class != obj.getClass()) {
            return false;
        }
        return this.f12392a.equals(((C4535k0) obj).f12392a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo29820f() {
        return this.f12399h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo29821g() {
        if (this.f12400i) {
            return false;
        }
        this.f12400i = true;
        return true;
    }

    public int hashCode() {
        return this.f12392a.hashCode();
    }

    public String toString() {
        return "OSInAppMessage{messageId='" + this.f12392a + '\'' + ", triggers=" + this.f12394c + ", clickedClickIds=" + this.f12395d + ", displayStats=" + this.f12396e + ", actionTaken=" + this.f12400i + ", isPreview=" + this.f12401j + '}';
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Set<String> mo29813b() {
        return this.f12395d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo29815b(String str) {
        return !this.f12395d.contains(str);
    }

    C4535k0(String str, Set<String> set, boolean z, C4563n0 n0Var) {
        this.f12392a = str;
        this.f12395d = set;
        this.f12398g = z;
        this.f12396e = n0Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ArrayList<ArrayList<C4523i1>> mo29808a(JSONArray jSONArray) throws JSONException {
        ArrayList<ArrayList<C4523i1>> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList2.add(new C4523i1(jSONArray2.getJSONObject(i2)));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    C4535k0(JSONObject jSONObject) throws JSONException {
        this.f12392a = jSONObject.getString("id");
        this.f12393b = m15606a(jSONObject.getJSONObject("variants"));
        this.f12394c = mo29808a(jSONObject.getJSONArray("triggers"));
        this.f12395d = new HashSet();
        if (jSONObject.has("redisplay")) {
            this.f12396e = new C4563n0(jSONObject.getJSONObject("redisplay"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29810a(double d) {
        this.f12397f = d;
    }

    /* renamed from: a */
    public void mo29812a(boolean z) {
        this.f12398g = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29809a() {
        this.f12395d.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29811a(String str) {
        this.f12395d.add(str);
    }
}
