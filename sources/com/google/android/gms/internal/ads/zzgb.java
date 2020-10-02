package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public enum zzgb implements zzecf {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6);
    
    private static final zzeci<zzgb> zzeh = null;
    private final int value;

    static {
        zzeh = new zzge();
    }

    private zzgb(int i) {
        this.value = i;
    }

    public final String toString() {
        return "<" + zzgb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    public final int zzw() {
        return this.value;
    }
}
