package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzjx {
    private static volatile boolean zzol = false;
    private static final Class<?> zzom = zzch();
    private static volatile zzjx zzon;
    static final zzjx zzoo = new zzjx(true);
    private final Map<zza, zzkk.zzd<?, ?>> zzop;

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    zzjx() {
        this.zzop = new HashMap();
    }

    static zzjx zzcg() {
        return zzki.zza(zzjx.class);
    }

    private static Class<?> zzch() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzjx zzci() {
        return zzjw.zzcf();
    }

    public static zzjx zzcj() {
        zzjx zzjx = zzon;
        if (zzjx == null) {
            synchronized (zzjx.class) {
                zzjx = zzon;
                if (zzjx == null) {
                    zzjx = zzjw.zzcg();
                    zzon = zzjx;
                }
            }
        }
        return zzjx;
    }

    public final <ContainingType extends zzlq> zzkk.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzop.get(new zza(containingtype, i));
    }

    private zzjx(boolean z) {
        this.zzop = Collections.emptyMap();
    }
}
