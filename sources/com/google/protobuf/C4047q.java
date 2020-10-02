package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.protobuf.q */
/* compiled from: LazyField */
public class C4047q extends C4051r {

    /* renamed from: e */
    private final C4054u f10854e;

    /* renamed from: com.google.protobuf.q$b */
    /* compiled from: LazyField */
    static class C4049b<K> implements Map.Entry<K, Object> {

        /* renamed from: a */
        private Map.Entry<K, C4047q> f10855a;

        public K getKey() {
            return this.f10855a.getKey();
        }

        public Object getValue() {
            C4047q value = this.f10855a.getValue();
            if (value == null) {
                return null;
            }
            return value.mo28237a();
        }

        public Object setValue(Object obj) {
            if (obj instanceof C4054u) {
                return this.f10855a.getValue().mo28249c((C4054u) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private C4049b(Map.Entry<K, C4047q> entry) {
            this.f10855a = entry;
        }
    }

    /* renamed from: com.google.protobuf.q$c */
    /* compiled from: LazyField */
    static class C4050c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a */
        private Iterator<Map.Entry<K, Object>> f10856a;

        public C4050c(Iterator<Map.Entry<K, Object>> it) {
            this.f10856a = it;
        }

        public boolean hasNext() {
            return this.f10856a.hasNext();
        }

        public void remove() {
            this.f10856a.remove();
        }

        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f10856a.next();
            return next.getValue() instanceof C4047q ? new C4049b(next) : next;
        }
    }

    /* renamed from: a */
    public C4054u mo28237a() {
        return mo28248b(this.f10854e);
    }

    public boolean equals(Object obj) {
        return mo28237a().equals(obj);
    }

    public int hashCode() {
        return mo28237a().hashCode();
    }

    public String toString() {
        return mo28237a().toString();
    }
}
