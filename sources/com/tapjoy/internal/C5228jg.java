package com.tapjoy.internal;

import java.io.PrintStream;
import java.util.Map;

/* renamed from: com.tapjoy.internal.jg */
public final class C5228jg {
    /* renamed from: a */
    public static void m17570a(StringBuffer stringBuffer, Object obj, Map map) {
        if (obj == null) {
            stringBuffer.append("null");
        } else if (!obj.getClass().isArray()) {
            try {
                stringBuffer.append(obj.toString());
            } catch (Throwable th) {
                PrintStream printStream = System.err;
                printStream.println("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]");
                th.printStackTrace();
                stringBuffer.append("[FAILED toString()]");
            }
        } else if (obj instanceof boolean[]) {
            m17579a(stringBuffer, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            m17571a(stringBuffer, (byte[]) obj);
        } else if (obj instanceof char[]) {
            m17572a(stringBuffer, (char[]) obj);
        } else if (obj instanceof short[]) {
            m17578a(stringBuffer, (short[]) obj);
        } else if (obj instanceof int[]) {
            m17575a(stringBuffer, (int[]) obj);
        } else if (obj instanceof long[]) {
            m17576a(stringBuffer, (long[]) obj);
        } else if (obj instanceof float[]) {
            m17574a(stringBuffer, (float[]) obj);
        } else if (obj instanceof double[]) {
            m17573a(stringBuffer, (double[]) obj);
        } else {
            m17577a(stringBuffer, (Object[]) obj, map);
        }
    }

    /* renamed from: a */
    private static void m17577a(StringBuffer stringBuffer, Object[] objArr, Map map) {
        stringBuffer.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, (Object) null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                m17570a(stringBuffer, objArr[i], map);
                if (i != length - 1) {
                    stringBuffer.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            stringBuffer.append("...");
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m17579a(StringBuffer stringBuffer, boolean[] zArr) {
        stringBuffer.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(zArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m17571a(StringBuffer stringBuffer, byte[] bArr) {
        stringBuffer.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(bArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m17572a(StringBuffer stringBuffer, char[] cArr) {
        stringBuffer.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(cArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m17578a(StringBuffer stringBuffer, short[] sArr) {
        stringBuffer.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(sArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m17575a(StringBuffer stringBuffer, int[] iArr) {
        stringBuffer.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(iArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m17576a(StringBuffer stringBuffer, long[] jArr) {
        stringBuffer.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(jArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m17574a(StringBuffer stringBuffer, float[] fArr) {
        stringBuffer.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(fArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* renamed from: a */
    private static void m17573a(StringBuffer stringBuffer, double[] dArr) {
        stringBuffer.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(dArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }
}
