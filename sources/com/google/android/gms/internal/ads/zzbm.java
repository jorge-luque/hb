package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;
import com.ogury.p159cm.OguryChoiceManager;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public final class zzbm {

    /* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
    public static final class zza extends zzecd<zza, C6822zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zza zzdz;
        private static volatile zzedx<zza> zzea;
        private int zzdl;
        private String zzdm = "";
        private long zzdn;
        private String zzdo = "";
        private String zzdp = "";
        private String zzdq = "";
        private long zzdr;
        private long zzds;
        private String zzdt = "";
        private long zzdu;
        private String zzdv = "";
        private String zzdw = "";
        private zzecl<zzb> zzdx = zzecd.zzbfa();
        private int zzdy;

        /* renamed from: com.google.android.gms.internal.ads.zzbm$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
        public static final class C6822zza extends zzecd.zza<zza, C6822zza> implements zzedq {
            private C6822zza() {
                super(zza.zzdz);
            }

            public final C6822zza zza(zzc zzc) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zza) this.zzhxt).zzb(zzc);
                return this;
            }

            public final C6822zza zzc(long j) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zza) this.zzhxt).zzd(j);
                return this;
            }

            public final C6822zza zzi(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zza) this.zzhxt).zzn(str);
                return this;
            }

            public final C6822zza zzj(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zza) this.zzhxt).zzo(str);
                return this;
            }

            public final C6822zza zzk(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zza) this.zzhxt).zzp(str);
                return this;
            }

            public final C6822zza zzl(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zza) this.zzhxt).zzq(str);
                return this;
            }

            public final C6822zza zzm(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zza) this.zzhxt).zzr(str);
                return this;
            }

            /* synthetic */ C6822zza(zzbl zzbl) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
        public static final class zzb extends zzecd<zzb, C6823zza> implements zzedq {
            private static volatile zzedx<zzb> zzea;
            /* access modifiers changed from: private */
            public static final zzb zzed;
            private int zzdl;
            private String zzeb = "";
            private String zzec = "";

            /* renamed from: com.google.android.gms.internal.ads.zzbm$zza$zzb$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
            public static final class C6823zza extends zzecd.zza<zzb, C6823zza> implements zzedq {
                private C6823zza() {
                    super(zzb.zzed);
                }

                /* synthetic */ C6823zza(zzbl zzbl) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzed = zzb;
                zzecd.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbl.zzdk[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C6823zza((zzbl) null);
                    case 3:
                        return zzecd.zza((zzedo) zzed, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzdl", "zzeb", "zzec"});
                    case 4:
                        return zzed;
                    case 5:
                        zzedx<zzb> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zzb.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzed);
                                    zzea = zzedx;
                                }
                            }
                        }
                        return zzedx;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
        public enum zzc implements zzecf {
            UNKNOWN(0),
            ENABLED(1),
            DISABLED(2);
            
            private static final zzeci<zzc> zzeh = null;
            private final int value;

            static {
                zzeh = new zzbn();
            }

            private zzc(int i) {
                this.value = i;
            }

            public static zzc zze(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return ENABLED;
                }
                if (i != 2) {
                    return null;
                }
                return DISABLED;
            }

            public static zzech zzx() {
                return zzbp.zzej;
            }

            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            public final int zzw() {
                return this.value;
            }
        }

        static {
            zza zza = new zza();
            zzdz = zza;
            zzecd.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        public final void zzb(zzc zzc2) {
            this.zzdy = zzc2.zzw();
            this.zzdl |= 2048;
        }

        /* access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzdl |= 2;
            this.zzdn = j;
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzdl |= 1;
            this.zzdm = str;
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzdl |= 4;
            this.zzdo = str;
        }

        /* access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zzdl |= 8;
            this.zzdp = str;
        }

        /* access modifiers changed from: private */
        public final void zzq(String str) {
            str.getClass();
            this.zzdl |= 16;
            this.zzdq = str;
        }

        /* access modifiers changed from: private */
        public final void zzr(String str) {
            str.getClass();
            this.zzdl |= OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
            this.zzdw = str;
        }

        public static C6822zza zzt() {
            return (C6822zza) zzdz.zzbev();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbl.zzdk[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C6822zza((zzbl) null);
                case 3:
                    return zzecd.zza((zzedo) zzdz, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\b\u0007\t\u0002\b\n\b\t\u000b\b\n\f\u001b\r\f\u000b", new Object[]{"zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzdr", "zzds", "zzdt", "zzdu", "zzdv", "zzdw", "zzdx", zzb.class, "zzdy", zzc.zzx()});
                case 4:
                    return zzdz;
                case 5:
                    zzedx<zza> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zza.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzdz);
                                zzea = zzedx;
                            }
                        }
                    }
                    return zzedx;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
