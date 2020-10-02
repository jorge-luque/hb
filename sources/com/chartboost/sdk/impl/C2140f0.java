package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.chartboost.sdk.impl.f0 */
public class C2140f0 {

    /* renamed from: a */
    private String f7162a;

    /* renamed from: b */
    private ArrayList<C2127c0> f7163b;

    public C2140f0() {
        this.f7162a = "";
        this.f7163b = new ArrayList<>();
    }

    /* renamed from: b */
    private String m8502b() {
        Iterator<C2127c0> it = this.f7163b.iterator();
        String str = "";
        int i = 0;
        while (it.hasNext()) {
            str = "Bid " + i + " : " + it.next().toString() + "\n";
            i++;
        }
        return str;
    }

    /* renamed from: a */
    public ArrayList<C2127c0> mo9329a() {
        return this.f7163b;
    }

    public String toString() {
        return "seat: " + this.f7162a + "\nbid: " + m8502b() + "\n";
    }

    public C2140f0(String str, ArrayList<C2127c0> arrayList) {
        this.f7162a = str;
        this.f7163b = arrayList;
    }
}
