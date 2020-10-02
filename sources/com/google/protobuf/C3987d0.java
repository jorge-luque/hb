package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* renamed from: com.google.protobuf.d0 */
/* compiled from: UnsafeUtil */
final class C3987d0 {

    /* renamed from: a */
    private static final Unsafe f10754a = m13289c();

    /* renamed from: b */
    private static final boolean f10755b = m13293g();

    /* renamed from: c */
    private static final boolean f10756c = m13292f();

    /* renamed from: d */
    private static final long f10757d = ((long) m13283a());

    /* renamed from: com.google.protobuf.d0$a */
    /* compiled from: UnsafeUtil */
    static class C3988a implements PrivilegedExceptionAction<Unsafe> {
        C3988a() {
        }

        public Unsafe run() throws Exception {
            Class<Unsafe> cls = Unsafe.class;
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get((Object) null);
                if (cls.isInstance(obj)) {
                    return cls.cast(obj);
                }
            }
            return null;
        }
    }

    static {
        m13284a(m13285a((Class<?>) Buffer.class, "address"));
    }

    /* renamed from: a */
    static byte m13282a(byte[] bArr, long j) {
        return f10754a.getByte(bArr, j);
    }

    /* renamed from: b */
    static long m13287b() {
        return f10757d;
    }

    /* renamed from: c */
    private static Unsafe m13289c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C3988a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: d */
    static boolean m13290d() {
        return f10756c;
    }

    /* renamed from: e */
    static boolean m13291e() {
        return f10755b;
    }

    /* renamed from: f */
    private static boolean m13292f() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f10754a;
        if (unsafe != null) {
            try {
                Class<?> cls2 = unsafe.getClass();
                cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
                cls2.getMethod("getByte", new Class[]{cls, Long.TYPE});
                cls2.getMethod("putByte", new Class[]{cls, Long.TYPE, Byte.TYPE});
                cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
                cls2.getMethod("copyMemory", new Class[]{cls, Long.TYPE, cls, Long.TYPE, Long.TYPE});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: g */
    private static boolean m13293g() {
        Unsafe unsafe = f10754a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getByte", new Class[]{Long.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
                cls.getMethod("getLong", new Class[]{Long.TYPE});
                cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    static void m13286a(byte[] bArr, long j, byte b) {
        f10754a.putByte(bArr, j, b);
    }

    /* renamed from: b */
    static long m13288b(byte[] bArr, long j) {
        return f10754a.getLong(bArr, j);
    }

    /* renamed from: a */
    private static int m13283a() {
        if (f10756c) {
            return f10754a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    /* renamed from: a */
    private static long m13284a(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = f10754a) == null) {
            return -1;
        }
        return unsafe.objectFieldOffset(field);
    }

    /* renamed from: a */
    private static Field m13285a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }
}
