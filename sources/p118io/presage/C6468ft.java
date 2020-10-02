package p118io.presage;

import com.facebook.internal.NativeProtocol;

/* renamed from: io.presage.ft */
public final class C6468ft {

    /* renamed from: a */
    public static final C6467fs f17031a;

    static {
        C6467fs fsVar;
        Object newInstance;
        Object newInstance2;
        Class<C6467fs> cls = C6467fs.class;
        int a = m21354a();
        if (a >= 65544) {
            try {
                newInstance2 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                C6514hl.m21414a((Object) newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance2 != null) {
                    fsVar = (C6467fs) newInstance2;
                    f17031a = fsVar;
                }
                throw new C6434em("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            } catch (ClassCastException e) {
                ClassLoader classLoader = newInstance2.getClass().getClassLoader();
                ClassLoader classLoader2 = cls.getClassLoader();
                Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e);
                C6514hl.m21414a((Object) initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause;
            } catch (ClassNotFoundException unused) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    C6514hl.m21414a((Object) newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance3 != null) {
                        try {
                            fsVar = (C6467fs) newInstance3;
                        } catch (ClassCastException e2) {
                            ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                            ClassLoader classLoader4 = cls.getClassLoader();
                            Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e2);
                            C6514hl.m21414a((Object) initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            throw initCause2;
                        }
                    } else {
                        throw new C6434em("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused2) {
                }
            }
        }
        if (a >= 65543) {
            try {
                newInstance = Class.forName("io.presage.fv").newInstance();
                C6514hl.m21414a(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance != null) {
                    fsVar = (C6467fs) newInstance;
                    f17031a = fsVar;
                }
                throw new C6434em("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            } catch (ClassCastException e3) {
                ClassLoader classLoader5 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader6 = cls.getClassLoader();
                Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e3);
                C6514hl.m21414a((Object) initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause3;
            } catch (ClassNotFoundException unused3) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    C6514hl.m21414a(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance4 != null) {
                        try {
                            fsVar = (C6467fs) newInstance4;
                        } catch (ClassCastException e4) {
                            ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                            ClassLoader classLoader8 = cls.getClassLoader();
                            Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e4);
                            C6514hl.m21414a((Object) initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            throw initCause4;
                        }
                    } else {
                        throw new C6434em("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused4) {
                }
            }
        }
        fsVar = new C6467fs();
        f17031a = fsVar;
    }

    /* renamed from: a */
    private static final int m21354a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
        int a = C6562jf.m21515a((CharSequence) property, 0, 6);
        if (a < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
            }
        } else {
            int i = a + 1;
            int a2 = C6562jf.m21515a((CharSequence) property, i, 4);
            if (a2 < 0) {
                a2 = property.length();
            }
            if (property != null) {
                String substring = property.substring(0, a);
                C6514hl.m21414a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (property != null) {
                    String substring2 = property.substring(i, a2);
                    C6514hl.m21414a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    try {
                        return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
                    } catch (NumberFormatException unused2) {
                        return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
                    }
                } else {
                    throw new C6434em("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new C6434em("null cannot be cast to non-null type java.lang.String");
            }
        }
    }
}
