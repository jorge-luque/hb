package com.tapjoy.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/* renamed from: com.tapjoy.internal.gj */
public class C3141gj extends Observable {

    /* renamed from: b */
    public final List f8744b = new ArrayList();

    /* renamed from: com.tapjoy.internal.gj$a */
    public class C3142a {

        /* renamed from: a */
        public final String f8745a;

        /* renamed from: b */
        public volatile Map f8746b;

        C3142a(String str) {
            this.f8745a = str;
        }

        /* renamed from: a */
        public final Object mo18536a(String str) {
            Map map = this.f8746b;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C3142a mo18531a(String str) {
        C3142a aVar = new C3142a(str);
        this.f8744b.add(aVar);
        return aVar;
    }

    /* renamed from: b */
    public final long mo18533b(String str) {
        for (C3142a a : this.f8744b) {
            Object a2 = a.mo18536a(str);
            if (a2 != null) {
                if (a2 instanceof Number) {
                    return ((Number) a2).longValue();
                }
                if (a2 instanceof String) {
                    try {
                        return Long.parseLong((String) a2);
                    } catch (IllegalArgumentException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return 0;
    }

    /* renamed from: c */
    public final C5122gi mo18534c(String str) {
        double parseDouble;
        for (C3142a a : this.f8744b) {
            Object a2 = a.mo18536a(str);
            if (a2 instanceof List) {
                List list = (List) a2;
                try {
                    long a3 = m10308a(list.get(0));
                    long a4 = m10308a(list.get(1));
                    long a5 = m10308a(list.get(2));
                    Object obj = list.get(3);
                    if (obj instanceof Number) {
                        parseDouble = ((Number) obj).doubleValue();
                    } else if (obj instanceof String) {
                        parseDouble = Double.parseDouble((String) obj);
                    } else {
                        throw new IllegalArgumentException();
                    }
                    return new C5122gi(a3, a4, a5, parseDouble);
                } catch (RuntimeException unused) {
                }
            }
        }
        return C5122gi.f14022a;
    }

    /* access modifiers changed from: protected */
    public void setChanged() {
        super.setChanged();
        notifyObservers();
    }

    /* renamed from: a */
    public final boolean mo18532a(String str, boolean z) {
        for (C3142a a : this.f8744b) {
            Object a2 = a.mo18536a(str);
            if (a2 != null) {
                if (a2 instanceof Boolean) {
                    return ((Boolean) a2).booleanValue();
                }
                if (!(a2 instanceof String)) {
                    continue;
                } else if ("true".equals(a2)) {
                    return true;
                } else {
                    if ("false".equals(a2)) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private static long m10308a(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            return Long.parseLong((String) obj);
        }
        throw new IllegalArgumentException();
    }
}
