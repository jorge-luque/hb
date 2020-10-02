package p118io.presage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: io.presage.hg */
public final class C6509hg implements C6508hf, C6535if<Object> {

    /* renamed from: a */
    public static final CamembertauCalvados f17042a = new CamembertauCalvados((byte) 0);

    /* renamed from: c */
    private static final Map<Class<? extends Object<?>>, Integer> f17043c;

    /* renamed from: d */
    private static final HashMap<String, String> f17044d;

    /* renamed from: e */
    private static final HashMap<String, String> f17045e;

    /* renamed from: f */
    private static final HashMap<String, String> f17046f;

    /* renamed from: g */
    private static final Map<String, String> f17047g;

    /* renamed from: b */
    private final Class<?> f17048b;

    /* renamed from: io.presage.hg$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    static {
        int i = 0;
        List b = C6447ez.m21320b(C6481gf.class, C6482gg.class, C6493gr.class, C6497gv.class, C6498gw.class, C6499gx.class, C6500gy.class, C6501gz.class, C6503ha.class, C6504hb.class, C6483gh.class, C6484gi.class, C6485gj.class, C6486gk.class, C6487gl.class, C6488gm.class, C6489gn.class, C6490go.class, C6491gp.class, C6492gq.class, C6494gs.class, C6495gt.class, C6496gu.class);
        ArrayList arrayList = new ArrayList(C6449fa.m21332a(b));
        for (Object next : b) {
            int i2 = i + 1;
            if (i < 0) {
                C6447ez.m21321b();
            }
            arrayList.add(C6433el.m21305a((Class) next, Integer.valueOf(i)));
            i = i2;
        }
        f17043c = C6465fq.m21350a(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f17044d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f17045e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(f17044d);
        hashMap3.putAll(f17045e);
        Collection<String> values = f17044d.values();
        C6514hl.m21414a((Object) values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            C6514hl.m21414a((Object) str, "kotlinName");
            sb.append(C6562jf.m21534c(str, str));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            C6431ej a = C6433el.m21305a(sb2, str + ".Companion");
            hashMap3.put(a.mo35393a(), a.mo35394b());
        }
        for (Map.Entry next2 : f17043c.entrySet()) {
            hashMap3.put(((Class) next2.getKey()).getName(), "kotlin.Function".concat(String.valueOf(((Number) next2.getValue()).intValue())));
        }
        f17046f = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C6464fp.m21347a(hashMap3.size()));
        for (Map.Entry entry : hashMap3.entrySet()) {
            linkedHashMap.put(entry.getKey(), C6562jf.m21534c((String) entry.getValue(), (String) entry.getValue()));
        }
        f17047g = linkedHashMap;
    }

    public C6509hg(Class<?> cls) {
        this.f17048b = cls;
    }

    /* renamed from: a */
    public final Class<?> mo35521a() {
        return this.f17048b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C6509hg) && C6514hl.m21416a((Object) C6480ge.m21373a(this), (Object) C6480ge.m21373a((C6535if) obj));
    }

    public final int hashCode() {
        return C6480ge.m21373a(this).hashCode();
    }

    public final String toString() {
        return mo35521a().toString() + " (Kotlin reflection is not available)";
    }
}
