package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.C2087b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.chartboost.sdk.impl.e0 */
public class C2136e0 {

    /* renamed from: a */
    private String f7152a;

    /* renamed from: b */
    private String f7153b;

    /* renamed from: c */
    private String f7154c;

    /* renamed from: d */
    private String f7155d;

    /* renamed from: e */
    private ArrayList<C2140f0> f7156e;

    /* renamed from: f */
    private ArrayList<C2087b> f7157f;

    public C2136e0() {
        this.f7152a = "";
        this.f7153b = "";
        this.f7154c = "USD";
        this.f7155d = "";
        this.f7156e = new ArrayList<>();
        this.f7157f = new ArrayList<>();
    }

    /* renamed from: d */
    private String m8488d() {
        Iterator<C2140f0> it = this.f7156e.iterator();
        String str = "";
        int i = 0;
        while (it.hasNext()) {
            str = "Seatbid " + i + " : " + it.next().toString() + "\n";
            i++;
        }
        return str;
    }

    /* renamed from: a */
    public ArrayList<C2087b> mo9324a() {
        return this.f7157f;
    }

    /* renamed from: b */
    public HashMap<String, C2087b> mo9325b() {
        HashMap<String, C2087b> hashMap = new HashMap<>();
        Iterator<C2087b> it = this.f7157f.iterator();
        while (it.hasNext()) {
            C2087b next = it.next();
            hashMap.put(next.f6915b, next);
        }
        return hashMap;
    }

    /* renamed from: c */
    public ArrayList<C2140f0> mo9326c() {
        return this.f7156e;
    }

    public String toString() {
        return "id: " + this.f7152a + "\nnbr: " + this.f7153b + "\ncurrency: " + this.f7154c + "\nbidId: " + this.f7155d + "\nseatbid: " + m8488d() + "\n";
    }

    public C2136e0(String str, String str2, String str3, String str4, ArrayList<C2140f0> arrayList, ArrayList<C2087b> arrayList2) {
        this.f7152a = str;
        this.f7153b = str2;
        this.f7154c = str3;
        this.f7155d = str4;
        this.f7156e = arrayList;
        this.f7157f = arrayList2;
    }
}
