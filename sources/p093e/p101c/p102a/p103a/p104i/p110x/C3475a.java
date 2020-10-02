package p093e.p101c.p102a.p103a.p104i.p110x;

import android.util.SparseArray;
import java.util.EnumMap;
import p093e.p101c.p102a.p103a.C3380d;

/* renamed from: e.c.a.a.i.x.a */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3475a {

    /* renamed from: a */
    private static SparseArray<C3380d> f9594a = new SparseArray<>();

    /* renamed from: b */
    private static EnumMap<C3380d, Integer> f9595b;

    static {
        EnumMap<C3380d, Integer> enumMap = new EnumMap<>(C3380d.class);
        f9595b = enumMap;
        enumMap.put(C3380d.f9442a, 0);
        f9595b.put(C3380d.VERY_LOW, 1);
        f9595b.put(C3380d.HIGHEST, 2);
        for (C3380d next : f9595b.keySet()) {
            f9594a.append(f9595b.get(next).intValue(), next);
        }
    }

    /* renamed from: a */
    public static C3380d m11524a(int i) {
        C3380d dVar = f9594a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }

    /* renamed from: a */
    public static int m11523a(C3380d dVar) {
        Integer num = f9595b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }
}
