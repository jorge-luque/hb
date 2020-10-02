package com.applovin.impl.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.t */
public class C2032t {

    /* renamed from: a */
    public static final C2032t f6742a = new C2032t();

    /* renamed from: b */
    protected String f6743b;

    /* renamed from: c */
    protected final List<C2032t> f6744c;

    /* renamed from: d */
    private final C2032t f6745d;

    /* renamed from: e */
    private final String f6746e;

    /* renamed from: f */
    private final Map<String, String> f6747f;

    private C2032t() {
        this.f6745d = null;
        this.f6746e = "";
        this.f6747f = Collections.emptyMap();
        this.f6743b = "";
        this.f6744c = Collections.emptyList();
    }

    public C2032t(String str, Map<String, String> map, C2032t tVar) {
        this.f6745d = tVar;
        this.f6746e = str;
        this.f6747f = Collections.unmodifiableMap(map);
        this.f6744c = new ArrayList();
    }

    /* renamed from: a */
    public String mo8823a() {
        return this.f6746e;
    }

    /* renamed from: a */
    public List<C2032t> mo8824a(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(this.f6744c.size());
            for (C2032t next : this.f6744c) {
                if (str.equalsIgnoreCase(next.mo8823a())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public C2032t mo8825b(String str) {
        if (str != null) {
            for (C2032t next : this.f6744c) {
                if (str.equalsIgnoreCase(next.mo8823a())) {
                    return next;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public Map<String, String> mo8826b() {
        return this.f6747f;
    }

    /* renamed from: c */
    public C2032t mo8827c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        } else if (this.f6744c.size() <= 0) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            while (!arrayList.isEmpty()) {
                C2032t tVar = (C2032t) arrayList.get(0);
                arrayList.remove(0);
                if (str.equalsIgnoreCase(tVar.mo8823a())) {
                    return tVar;
                }
                arrayList.addAll(tVar.mo8829d());
            }
            return null;
        }
    }

    /* renamed from: c */
    public String mo8828c() {
        return this.f6743b;
    }

    /* renamed from: d */
    public List<C2032t> mo8829d() {
        return Collections.unmodifiableList(this.f6744c);
    }

    public String toString() {
        return "XmlNode{elementName='" + this.f6746e + '\'' + ", text='" + this.f6743b + '\'' + ", attributes=" + this.f6747f + '}';
    }
}
