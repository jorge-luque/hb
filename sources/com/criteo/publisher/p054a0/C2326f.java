package com.criteo.publisher.p054a0;

import com.criteo.publisher.model.C2453n;
import com.criteo.publisher.model.C2462t;
import com.criteo.publisher.model.C2464v;
import com.criteo.publisher.model.C2466x;
import com.criteo.publisher.model.p055z.C2487m;
import com.criteo.publisher.model.p055z.C2488n;
import com.criteo.publisher.model.p055z.C2490o;
import com.criteo.publisher.model.p055z.C2491p;
import com.criteo.publisher.model.p055z.C2492q;
import com.criteo.publisher.model.p055z.C2493r;
import com.criteo.publisher.p061t.C2540m;
import com.criteo.publisher.p061t.C2551t;
import com.criteo.publisher.p066y.p067b.C2584c;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* renamed from: com.criteo.publisher.a0.f */
final class C2326f extends C2337l {
    C2326f() {
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (C2453n.class.isAssignableFrom(rawType)) {
            return C2453n.m9265a(gson);
        }
        if (C2584c.class.isAssignableFrom(rawType)) {
            return C2584c.m9696a(gson);
        }
        if (C2540m.class.isAssignableFrom(rawType)) {
            return C2540m.m9537a(gson);
        }
        if (C2551t.class.isAssignableFrom(rawType)) {
            return C2551t.m9580a(gson);
        }
        if (C2551t.C2552a.class.isAssignableFrom(rawType)) {
            return C2551t.C2552a.m9585a(gson);
        }
        if (C2551t.C2553b.class.isAssignableFrom(rawType)) {
            return C2551t.C2553b.m9594a(gson);
        }
        if (C2487m.class.isAssignableFrom(rawType)) {
            return C2487m.m9381a(gson);
        }
        if (C2488n.class.isAssignableFrom(rawType)) {
            return C2488n.m9387a(gson);
        }
        if (C2490o.class.isAssignableFrom(rawType)) {
            return C2490o.m9410a(gson);
        }
        if (C2491p.class.isAssignableFrom(rawType)) {
            return C2491p.m9412a(gson);
        }
        if (C2492q.class.isAssignableFrom(rawType)) {
            return C2492q.m9414a(gson);
        }
        if (C2493r.class.isAssignableFrom(rawType)) {
            return C2493r.m9418a(gson);
        }
        if (C2462t.class.isAssignableFrom(rawType)) {
            return C2462t.m9301a(gson);
        }
        if (C2464v.class.isAssignableFrom(rawType)) {
            return C2464v.m9308a(gson);
        }
        if (C2466x.class.isAssignableFrom(rawType)) {
            return C2466x.m9332a(gson);
        }
        return null;
    }
}
