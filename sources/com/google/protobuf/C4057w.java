package com.google.protobuf;

import com.google.protobuf.C4023n;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

/* renamed from: com.google.protobuf.w */
/* compiled from: MessageLiteToString */
final class C4057w {
    /* renamed from: a */
    static String m13524a(C4054u uVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        m13526a(uVar, sb, 0);
        return sb.toString();
    }

    /* renamed from: a */
    private static void m13526a(C4054u uVar, StringBuilder sb, int i) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : uVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String replaceFirst : treeSet) {
            String replaceFirst2 = replaceFirst.replaceFirst("get", "");
            boolean z = true;
            if (replaceFirst2.endsWith("List") && !replaceFirst2.endsWith("OrBuilderList")) {
                String str = replaceFirst2.substring(0, 1).toLowerCase() + replaceFirst2.substring(1, replaceFirst2.length() - 4);
                Method method2 = (Method) hashMap.get("get" + replaceFirst2);
                if (method2 != null) {
                    m13527a(sb, i, m13525a(str), C4023n.invokeOrDie(method2, uVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + replaceFirst2)) != null) {
                if (replaceFirst2.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + replaceFirst2.substring(0, replaceFirst2.length() - 5))) {
                    }
                }
                String str2 = replaceFirst2.substring(0, 1).toLowerCase() + replaceFirst2.substring(1);
                Method method3 = (Method) hashMap.get("get" + replaceFirst2);
                Method method4 = (Method) hashMap.get("has" + replaceFirst2);
                if (method3 != null) {
                    Object invokeOrDie = C4023n.invokeOrDie(method3, uVar, new Object[0]);
                    if (method4 != null) {
                        z = ((Boolean) C4023n.invokeOrDie(method4, uVar, new Object[0])).booleanValue();
                    } else if (m13528a(invokeOrDie)) {
                        z = false;
                    }
                    if (z) {
                        m13527a(sb, i, m13525a(str2), invokeOrDie);
                    }
                }
            }
        }
        if (uVar instanceof C4023n.C4029e) {
            Iterator<Map.Entry<C4023n.C4031g, Object>> b = ((C4023n.C4029e) uVar).f10833a.mo28172b();
            while (b.hasNext()) {
                Map.Entry next = b.next();
                m13527a(sb, i, "[" + ((C4023n.C4031g) next.getKey()).mo28225a() + "]", next.getValue());
            }
        }
        C3985c0 c0Var = ((C4023n) uVar).unknownFields;
        if (c0Var != null) {
            c0Var.mo28085a(sb, i);
        }
    }

    /* renamed from: a */
    private static boolean m13528a(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Float) {
            if (((Float) obj).floatValue() == 0.0f) {
                return true;
            }
            return false;
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return true;
            }
            return false;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof C3995f) {
                return obj.equals(C3995f.f10759b);
            }
            if (obj instanceof C4054u) {
                if (obj == ((C4054u) obj).getDefaultInstanceForType()) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Enum) || ((Enum) obj).ordinal() != 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    /* renamed from: a */
    static final void m13527a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object a : (List) obj) {
                m13527a(sb, i, str, a);
            }
            return;
        }
        sb.append(10);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(C3981b0.m13252a((String) obj));
            sb.append('\"');
        } else if (obj instanceof C3995f) {
            sb.append(": \"");
            sb.append(C3981b0.m13251a((C3995f) obj));
            sb.append('\"');
        } else if (obj instanceof C4023n) {
            sb.append(" {");
            m13526a((C4023n) obj, sb, i + 2);
            sb.append("\n");
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append("}");
        } else {
            sb.append(": ");
            sb.append(obj.toString());
        }
    }

    /* renamed from: a */
    private static final String m13525a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR);
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
