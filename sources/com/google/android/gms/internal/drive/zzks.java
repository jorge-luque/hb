package com.google.android.gms.internal.drive;

public enum zzks {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzjc.class, zzjc.class, zzjc.zznq),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zztb;
    private final Class<?> zztc;
    private final Object zztd;

    private zzks(Class<?> cls, Class<?> cls2, Object obj) {
        this.zztb = cls;
        this.zztc = cls2;
        this.zztd = obj;
    }

    public final Class<?> zzdo() {
        return this.zztc;
    }
}
