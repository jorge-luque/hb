package com.ryanharter.auto.value.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateTypeAdapter {
    static {
        new TypeAdapterFactory() {

            /* renamed from: a */
            private final Class<?> f8645a = Array.newInstance(Type.class, 0).getClass();

            /* renamed from: b */
            private final Map<Class<?>, Constructor<? extends TypeAdapter>> f8646b = Collections.synchronizedMap(new LinkedHashMap());

            /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                r5 = r3.getDeclaredConstructor(new java.lang.Class[]{r0, r6.f8645a});
                r5.setAccessible(true);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
                r5 = m10172a(r7.getSuperclass());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x008f, code lost:
                if (r5 != null) goto L_0x0091;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
                r5.setAccessible(true);
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:23:? A[ExcHandler: ClassNotFoundException (unused java.lang.ClassNotFoundException), SYNTHETIC, Splitter:B:10:0x002b] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private java.lang.reflect.Constructor<? extends com.google.gson.TypeAdapter> m10172a(java.lang.Class<?> r7) {
                /*
                    r6 = this;
                    java.lang.Class<com.google.gson.Gson> r0 = com.google.gson.Gson.class
                    java.util.Map<java.lang.Class<?>, java.lang.reflect.Constructor<? extends com.google.gson.TypeAdapter>> r1 = r6.f8646b
                    java.lang.Object r1 = r1.get(r7)
                    java.lang.reflect.Constructor r1 = (java.lang.reflect.Constructor) r1
                    if (r1 == 0) goto L_0x000d
                    return r1
                L_0x000d:
                    java.lang.String r1 = r7.getName()
                    java.lang.String r2 = "android."
                    boolean r2 = r1.startsWith(r2)
                    if (r2 != 0) goto L_0x009a
                    java.lang.String r2 = "java."
                    boolean r2 = r1.startsWith(r2)
                    if (r2 != 0) goto L_0x009a
                    java.lang.String r2 = "kotlin."
                    boolean r2 = r1.startsWith(r2)
                    if (r2 == 0) goto L_0x002a
                    goto L_0x009a
                L_0x002a:
                    r2 = 1
                    java.lang.String r3 = r7.getName()     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    java.lang.String r4 = "$"
                    java.lang.String r5 = "_"
                    java.lang.String r3 = r3.replace(r4, r5)     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    java.lang.ClassLoader r4 = r7.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    r5.<init>()     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    r5.append(r3)     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    java.lang.String r3 = "_GsonTypeAdapter"
                    r5.append(r3)     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    java.lang.String r3 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    java.lang.Class r3 = r4.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    r4 = 0
                    java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x005d, ClassNotFoundException -> 0x0086 }
                    r5[r4] = r0     // Catch:{ NoSuchMethodException -> 0x005d, ClassNotFoundException -> 0x0086 }
                    java.lang.reflect.Constructor r5 = r3.getDeclaredConstructor(r5)     // Catch:{ NoSuchMethodException -> 0x005d, ClassNotFoundException -> 0x0086 }
                    r5.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x005d, ClassNotFoundException -> 0x0086 }
                    goto L_0x0094
                L_0x005d:
                    r5 = 2
                    java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    r5[r4] = r0     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    java.lang.Class<?> r0 = r6.f8645a     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    r5[r2] = r0     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    java.lang.reflect.Constructor r5 = r3.getDeclaredConstructor(r5)     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    r5.setAccessible(r2)     // Catch:{ ClassNotFoundException -> 0x0086, NoSuchMethodException -> 0x006e }
                    goto L_0x0094
                L_0x006e:
                    r7 = move-exception
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Unable to find binding constructor for "
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r1 = r2.toString()
                    r0.<init>(r1, r7)
                    throw r0
                L_0x0086:
                    java.lang.Class r0 = r7.getSuperclass()
                    java.lang.reflect.Constructor r5 = r6.m10172a(r0)
                    if (r5 == 0) goto L_0x0094
                    r5.setAccessible(r2)
                L_0x0094:
                    java.util.Map<java.lang.Class<?>, java.lang.reflect.Constructor<? extends com.google.gson.TypeAdapter>> r0 = r6.f8646b
                    r0.put(r7, r5)
                    return r5
                L_0x009a:
                    r7 = 0
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ryanharter.auto.value.gson.GenerateTypeAdapter.C31081.m10172a(java.lang.Class):java.lang.reflect.Constructor");
            }

            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (!rawType.isAnnotationPresent(GenerateTypeAdapter.class)) {
                    return null;
                }
                Class<? super Object> superclass = rawType.getSuperclass();
                if (superclass.isAnnotationPresent(GenerateTypeAdapter.class)) {
                    return gson.getAdapter(superclass);
                }
                Constructor<? extends TypeAdapter> a = m10172a(rawType);
                if (a == null) {
                    return null;
                }
                try {
                    if (a.getParameterTypes().length == 1) {
                        return (TypeAdapter) a.newInstance(new Object[]{gson});
                    }
                    return (TypeAdapter) a.newInstance(new Object[]{gson, ((ParameterizedType) typeToken.getType()).getActualTypeArguments()});
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Unable to invoke " + a, e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Unable to invoke " + a, e2);
                } catch (InvocationTargetException e3) {
                    Throwable cause = e3.getCause();
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    } else if (cause instanceof Error) {
                        throw ((Error) cause);
                    } else {
                        throw new RuntimeException("Could not create generated TypeAdapter instance for type " + rawType, cause);
                    }
                }
            }
        };
    }
}
