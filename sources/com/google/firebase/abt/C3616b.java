package com.google.firebase.abt;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.p122a.C3619a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.firebase.abt.b */
/* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
public class C3616b {

    /* renamed from: a */
    private final C3619a f10128a;

    /* renamed from: b */
    private final String f10129b;

    /* renamed from: c */
    private Integer f10130c = null;

    public C3616b(Context context, C3619a aVar, String str) {
        this.f10128a = aVar;
        this.f10129b = str;
    }

    /* renamed from: b */
    private ArrayList<C3619a.C3620a> m12322b(List<C3619a.C3620a> list, Set<String> set) {
        ArrayList<C3619a.C3620a> arrayList = new ArrayList<>();
        for (C3619a.C3620a next : list) {
            if (!set.contains(next.f10140b)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private static List<C3615a> m12326c(List<Map<String, String>> list) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> a : list) {
            arrayList.add(C3615a.m12313a(a));
        }
        return arrayList;
    }

    /* renamed from: d */
    private void m12328d(List<C3615a> list) throws AbtException {
        if (list.isEmpty()) {
            mo27187a();
            return;
        }
        HashSet hashSet = new HashSet();
        for (C3615a a : list) {
            hashSet.add(a.mo27185a());
        }
        List<C3619a.C3620a> b = m12323b();
        HashSet hashSet2 = new HashSet();
        for (C3619a.C3620a aVar : b) {
            hashSet2.add(aVar.f10140b);
        }
        m12321a((Collection<C3619a.C3620a>) m12322b(b, hashSet));
        m12324b(m12318a(list, hashSet2));
    }

    /* renamed from: a */
    public void mo27188a(List<Map<String, String>> list) throws AbtException {
        m12327d();
        if (list != null) {
            m12328d(m12326c(list));
            return;
        }
        throw new IllegalArgumentException("The replacementExperiments list is null.");
    }

    /* renamed from: c */
    private int m12325c() {
        if (this.f10130c == null) {
            this.f10130c = Integer.valueOf(this.f10128a.getMaxUserProperties(this.f10129b));
        }
        return this.f10130c.intValue();
    }

    /* renamed from: a */
    public void mo27187a() throws AbtException {
        m12327d();
        m12321a((Collection<C3619a.C3620a>) m12323b());
    }

    /* renamed from: b */
    private void m12324b(List<C3615a> list) {
        ArrayDeque arrayDeque = new ArrayDeque(m12323b());
        int c = m12325c();
        for (C3615a next : list) {
            while (arrayDeque.size() >= c) {
                m12320a(((C3619a.C3620a) arrayDeque.pollFirst()).f10140b);
            }
            C3619a.C3620a a = next.mo27184a(this.f10129b);
            m12319a(a);
            arrayDeque.offer(a);
        }
    }

    /* renamed from: a */
    private ArrayList<C3615a> m12318a(List<C3615a> list, Set<String> set) {
        ArrayList<C3615a> arrayList = new ArrayList<>();
        for (C3615a next : list) {
            if (!set.contains(next.mo27185a())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m12321a(Collection<C3619a.C3620a> collection) {
        for (C3619a.C3620a aVar : collection) {
            m12320a(aVar.f10140b);
        }
    }

    /* renamed from: a */
    private void m12319a(C3619a.C3620a aVar) {
        this.f10128a.mo27198a(aVar);
    }

    /* renamed from: a */
    private void m12320a(String str) {
        this.f10128a.clearConditionalUserProperty(str, (String) null, (Bundle) null);
    }

    /* renamed from: b */
    private List<C3619a.C3620a> m12323b() {
        return this.f10128a.getConditionalUserProperties(this.f10129b, "");
    }

    /* renamed from: d */
    private void m12327d() throws AbtException {
        if (this.f10128a == null) {
            throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }
}
