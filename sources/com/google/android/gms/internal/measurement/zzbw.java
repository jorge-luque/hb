package com.google.android.gms.internal.measurement;

import com.facebook.internal.Utility;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.internal.measurement.zzfi;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public final class zzbw {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zza extends zzfi<zza, C6846zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzhc<zza> zzi;
        private int zzc;
        private int zzd;
        private zzi zze;
        private zzi zzf;
        private boolean zzg;

        /* renamed from: com.google.android.gms.internal.measurement.zzbw$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class C6846zza extends zzfi.zzb<zza, C6846zza> implements zzgv {
            private C6846zza() {
                super(zza.zzh);
            }

            public final C6846zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i);
                return this;
            }

            /* synthetic */ C6846zza(zzbx zzbx) {
                this();
            }

            public final C6846zza zza(zzi.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza((zzi) ((zzfi) zza.zzu()));
                return this;
            }

            public final C6846zza zza(zzi zzi) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(zzi);
                return this;
            }

            public final C6846zza zza(boolean z) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(z);
                return this;
            }
        }

        static {
            zza zza = new zza();
            zzh = zza;
            zzfi.zza(zza.class, zza);
        }

        private zza() {
        }

        public static C6846zza zzh() {
            return (C6846zza) zzh.zzbk();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final zzi zzc() {
            zzi zzi2 = this.zze;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final zzi zze() {
            zzi zzi2 = this.zzf;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final boolean zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzi zzi2) {
            zzi2.getClass();
            this.zzf = zzi2;
            this.zzc |= 4;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi2) {
            zzi2.getClass();
            this.zze = zzi2;
            this.zzc |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C6846zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhc<zza> zzhc = zzi;
                    if (zzhc == null) {
                        synchronized (zza.class) {
                            zzhc = zzi;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzh);
                                zzi = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzb extends zzfi<zzb, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzb zzf;
        private static volatile zzhc<zzb> zzg;
        private int zzc;
        private int zzd;
        private long zze;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzb, zza> implements zzgv {
            private zza() {
                super(zzb.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i);
                return this;
            }

            /* synthetic */ zza(zzbx zzbx) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzf = zzb;
            zzfi.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        public static zza zze() {
            return (zza) zzf.zzbk();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final long zzd() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhc<zzb> zzhc = zzg;
                    if (zzhc == null) {
                        synchronized (zzb.class) {
                            zzhc = zzg;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzf);
                                zzg = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzc extends zzfi<zzc, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzc zzi;
        private static volatile zzhc<zzc> zzj;
        private int zzc;
        private zzfq<zze> zzd = zzfi.zzbq();
        private String zze = "";
        private long zzf;
        private long zzg;
        private int zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzc, zza> implements zzgv {
            private zza() {
                super(zzc.zzi);
            }

            public final List<zze> zza() {
                return Collections.unmodifiableList(((zzc) this.zza).zza());
            }

            public final int zzb() {
                return ((zzc) this.zza).zzb();
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzm();
                return this;
            }

            public final String zzd() {
                return ((zzc) this.zza).zzc();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzd();
            }

            public final long zzf() {
                return ((zzc) this.zza).zze();
            }

            public final long zzg() {
                return ((zzc) this.zza).zzg();
            }

            /* synthetic */ zza(zzbx zzbx) {
                this();
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(i);
                return this;
            }

            public final zze zza(int i) {
                return ((zzc) this.zza).zza(i);
            }

            public final zza zza(int i, zze zze) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, zze);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(j);
                return this;
            }

            public final zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, (zze) ((zzfi) zza.zzu()));
                return this;
            }

            public final zza zza(zze zze) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(zze);
                return this;
            }

            public final zza zza(zze.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zze) ((zzfi) zza.zzu()));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzi = zzc2;
            zzfi.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        public static zza zzj() {
            return (zza) zzi.zzbk();
        }

        private final void zzl() {
            zzfq<zze> zzfq = this.zzd;
            if (!zzfq.zza()) {
                this.zzd = zzfi.zza(zzfq);
            }
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzfi.zzbq();
        }

        public final List<zze> zza() {
            return this.zzd;
        }

        public final int zzb() {
            return this.zzd.size();
        }

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 2) != 0;
        }

        public final long zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 4) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 8) != 0;
        }

        public final int zzi() {
            return this.zzh;
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            zzl();
            this.zzd.remove(i);
        }

        public final zze zza(int i) {
            return this.zzd.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.set(i, zze2);
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.add(zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzl();
            zzdq.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzf = j;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", zze.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhc<zzc> zzhc = zzj;
                    if (zzhc == null) {
                        synchronized (zzc.class) {
                            zzhc = zzj;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzi);
                                zzj = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zze extends zzfi<zze, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zze zzj;
        private static volatile zzhc<zze> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private long zzf;
        private float zzg;
        private double zzh;
        private zzfq<zze> zzi = zzfi.zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zze, zza> implements zzgv {
            private zza() {
                super(zze.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzb(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzo();
                return this;
            }

            public final int zzd() {
                return ((zze) this.zza).zzj();
            }

            public final zza zze() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzq();
                return this;
            }

            /* synthetic */ zza(zzbx zzbx) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzm();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzn();
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(j);
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(d);
                return this;
            }

            public final zza zza(zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zze((zze) ((zzfi) zza.zzu()));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(iterable);
                return this;
            }
        }

        static {
            zze zze2 = new zze();
            zzj = zze2;
            zzfi.zza(zze.class, zze2);
        }

        private zze() {
        }

        public static zza zzk() {
            return (zza) zzj.zzbk();
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzc &= -3;
            this.zze = zzj.zze;
        }

        /* access modifiers changed from: private */
        public final void zzn() {
            this.zzc &= -5;
            this.zzf = 0;
        }

        /* access modifiers changed from: private */
        public final void zzo() {
            this.zzc &= -17;
            this.zzh = 0.0d;
        }

        private final void zzp() {
            zzfq<zze> zzfq = this.zzi;
            if (!zzfq.zza()) {
                this.zzi = zzfi.zza(zzfq);
            }
        }

        /* access modifiers changed from: private */
        public final void zzq() {
            this.zzi = zzfi.zzbq();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final String zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final long zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 16) != 0;
        }

        public final double zzh() {
            return this.zzh;
        }

        public final List<zze> zzi() {
            return this.zzi;
        }

        public final int zzj() {
            return this.zzi.size();
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zze(zze zze2) {
            zze2.getClass();
            zzp();
            this.zzi.add(zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        public final void zza(double d) {
            this.zzc |= 16;
            this.zzh = d;
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzp();
            zzdq.zza(iterable, this.zzi);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            Class<zze> cls = zze.class;
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", cls});
                case 4:
                    return zzj;
                case 5:
                    zzhc<zze> zzhc = zzk;
                    if (zzhc == null) {
                        synchronized (cls) {
                            zzhc = zzk;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzj);
                                zzk = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzf extends zzfi<zzf, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzf zzd;
        private static volatile zzhc<zzf> zze;
        private zzfq<zzg> zzc = zzfi.zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzf, zza> implements zzgv {
            private zza() {
                super(zzf.zzd);
            }

            public final zzg zza(int i) {
                return ((zzf) this.zza).zza(0);
            }

            /* synthetic */ zza(zzbx zzbx) {
                this();
            }

            public final zza zza(zzg.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza((zzg) ((zzfi) zza.zzu()));
                return this;
            }
        }

        static {
            zzf zzf = new zzf();
            zzd = zzf;
            zzfi.zza(zzf.class, zzf);
        }

        private zzf() {
        }

        public static zza zzb() {
            return (zza) zzd.zzbk();
        }

        public final List<zzg> zza() {
            return this.zzc;
        }

        public final zzg zza(int i) {
            return this.zzc.get(0);
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg) {
            zzg.getClass();
            zzfq<zzg> zzfq = this.zzc;
            if (!zzfq.zza()) {
                this.zzc = zzfi.zza(zzfq);
            }
            this.zzc.add(zzg);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzg.class});
                case 4:
                    return zzd;
                case 5:
                    zzhc<zzf> zzhc = zze;
                    if (zzhc == null) {
                        synchronized (zzf.class) {
                            zzhc = zze;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzd);
                                zze = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzg extends zzfi<zzg, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzg zzav;
        private static volatile zzhc<zzg> zzaw;
        private int zzaa;
        private String zzab = "";
        private String zzac = "";
        private boolean zzad;
        private zzfq<zza> zzae = zzfi.zzbq();
        private String zzaf = "";
        private int zzag;
        private int zzah;
        private int zzai;
        private String zzaj = "";
        private long zzak;
        private long zzal;
        private String zzam = "";
        private String zzan = "";
        private int zzao;
        private String zzap = "";
        private zzh zzaq;
        private zzfo zzar = zzfi.zzbo();
        private long zzas;
        private long zzat;
        private String zzau = "";
        private int zzc;
        private int zzd;
        private int zze;
        private zzfq<zzc> zzf = zzfi.zzbq();
        private zzfq<zzk> zzg = zzfi.zzbq();
        private long zzh;
        private long zzi;
        private long zzj;
        private long zzk;
        private long zzl;
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private int zzq;
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private long zzu;
        private long zzv;
        private String zzw = "";
        private boolean zzx;
        private String zzy = "";
        private long zzz;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzg, zza> implements zzgv {
            private zza() {
                super(zzg.zzav);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(1);
                return this;
            }

            public final int zzb() {
                return ((zzg) this.zza).zzd();
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbv();
                return this;
            }

            public final List<zzk> zzd() {
                return Collections.unmodifiableList(((zzg) this.zza).zze());
            }

            public final int zze() {
                return ((zzg) this.zza).zzf();
            }

            public final long zzf() {
                return ((zzg) this.zza).zzj();
            }

            public final long zzg() {
                return ((zzg) this.zza).zzl();
            }

            public final zza zzh() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbx();
                return this;
            }

            public final zza zzi() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzby();
                return this;
            }

            public final String zzj() {
                return ((zzg) this.zza).zzx();
            }

            public final zza zzk() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbz();
                return this;
            }

            public final String zzl() {
                return ((zzg) this.zza).zzam();
            }

            public final zza zzm() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzca();
                return this;
            }

            public final zza zzn(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzn((String) null);
                return this;
            }

            public final zza zzo(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzo(str);
                return this;
            }

            public final zza zzp(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzp(str);
                return this;
            }

            /* synthetic */ zza(zzbx zzbx) {
                this();
            }

            public final zzc zzb(int i) {
                return ((zzg) this.zza).zza(i);
            }

            public final zza zze(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(i);
                return this;
            }

            public final zza zzf(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(i);
                return this;
            }

            public final zza zzg(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(str);
                return this;
            }

            public final zza zzj(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(str);
                return this;
            }

            public final zza zzl(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(str);
                return this;
            }

            public final zza zzb(Iterable<? extends zzk> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(iterable);
                return this;
            }

            public final zzk zzd(int i) {
                return ((zzg) this.zza).zzb(i);
            }

            public final List<zzc> zza() {
                return Collections.unmodifiableList(((zzg) this.zza).zzc());
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(i);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(j);
                return this;
            }

            public final zza zzh(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(str);
                return this;
            }

            public final zza zzi(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(str);
                return this;
            }

            public final zza zzk(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(str);
                return this;
            }

            public final zza zzm(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzm(str);
                return this;
            }

            public final zza zzn() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcb();
                return this;
            }

            public final String zzo() {
                return ((zzg) this.zza).zzbe();
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(j);
                return this;
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(str);
                return this;
            }

            public final zza zzg(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(j);
                return this;
            }

            public final zza zzj(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(j);
                return this;
            }

            public final zza zzl(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(j);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(j);
                return this;
            }

            public final zza zza(int i, zzc.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, (zzc) ((zzfi) zza.zzu()));
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(j);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(str);
                return this;
            }

            public final zza zzh(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(j);
                return this;
            }

            public final zza zzi(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(j);
                return this;
            }

            public final zza zzk(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(j);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(str);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(j);
                return this;
            }

            public final zza zzg(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(i);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(Iterable<? extends Integer> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(iterable);
                return this;
            }

            public final zza zzh(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(i);
                return this;
            }

            public final zza zzi(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(i);
                return this;
            }

            public final zza zza(zzc.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzc) ((zzfi) zza.zzu()));
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(Iterable<? extends zza> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(iterable);
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(int i, zzk zzk) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, zzk);
                return this;
            }

            public final zza zza(zzk zzk) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(zzk);
                return this;
            }

            public final zza zza(zzk.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzk) ((zzfi) zza.zzu()));
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(z);
                return this;
            }

            public final zza zza(zzh.zzb zzb) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzh) ((zzfi) zzb.zzu()));
                return this;
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzav = zzg2;
            zzfi.zza(zzg.class, zzg2);
        }

        private zzg() {
        }

        public static zza zzbf() {
            return (zza) zzav.zzbk();
        }

        private final void zzbu() {
            zzfq<zzc> zzfq = this.zzf;
            if (!zzfq.zza()) {
                this.zzf = zzfi.zza(zzfq);
            }
        }

        /* access modifiers changed from: private */
        public final void zzbv() {
            this.zzf = zzfi.zzbq();
        }

        private final void zzbw() {
            zzfq<zzk> zzfq = this.zzg;
            if (!zzfq.zza()) {
                this.zzg = zzfi.zza(zzfq);
            }
        }

        /* access modifiers changed from: private */
        public final void zzbx() {
            this.zzc &= -17;
            this.zzk = 0;
        }

        /* access modifiers changed from: private */
        public final void zzby() {
            this.zzc &= -33;
            this.zzl = 0;
        }

        /* access modifiers changed from: private */
        public final void zzbz() {
            this.zzc &= -2097153;
            this.zzab = zzav.zzab;
        }

        /* access modifiers changed from: private */
        public final void zzca() {
            this.zzae = zzfi.zzbq();
        }

        /* access modifiers changed from: private */
        public final void zzcb() {
            this.zzc &= Integer.MAX_VALUE;
            this.zzam = zzav.zzam;
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            this.zzc |= 1;
            this.zze = i;
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzbu();
            this.zzf.remove(i);
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzaa() {
            return this.zzu;
        }

        public final boolean zzab() {
            return (this.zzc & 32768) != 0;
        }

        public final long zzac() {
            return this.zzv;
        }

        public final String zzad() {
            return this.zzw;
        }

        public final boolean zzae() {
            return (this.zzc & MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES) != 0;
        }

        public final boolean zzaf() {
            return this.zzx;
        }

        public final String zzag() {
            return this.zzy;
        }

        public final boolean zzah() {
            return (this.zzc & 524288) != 0;
        }

        public final long zzai() {
            return this.zzz;
        }

        public final boolean zzaj() {
            return (this.zzc & 1048576) != 0;
        }

        public final int zzak() {
            return this.zzaa;
        }

        public final String zzal() {
            return this.zzab;
        }

        public final String zzam() {
            return this.zzac;
        }

        public final boolean zzan() {
            return (this.zzc & 8388608) != 0;
        }

        public final boolean zzao() {
            return this.zzad;
        }

        public final List<zza> zzap() {
            return this.zzae;
        }

        public final String zzaq() {
            return this.zzaf;
        }

        public final boolean zzar() {
            return (this.zzc & 33554432) != 0;
        }

        public final int zzas() {
            return this.zzag;
        }

        public final String zzat() {
            return this.zzaj;
        }

        public final boolean zzau() {
            return (this.zzc & DriveFile.MODE_WRITE_ONLY) != 0;
        }

        public final long zzav() {
            return this.zzak;
        }

        public final boolean zzaw() {
            return (this.zzc & 1073741824) != 0;
        }

        public final long zzax() {
            return this.zzal;
        }

        public final String zzay() {
            return this.zzam;
        }

        public final boolean zzaz() {
            return (this.zzd & 2) != 0;
        }

        public final int zzb() {
            return this.zze;
        }

        public final int zzba() {
            return this.zzao;
        }

        public final String zzbb() {
            return this.zzap;
        }

        public final boolean zzbc() {
            return (this.zzd & 16) != 0;
        }

        public final long zzbd() {
            return this.zzas;
        }

        public final String zzbe() {
            return this.zzau;
        }

        public final List<zzc> zzc() {
            return this.zzf;
        }

        public final int zzf() {
            return this.zzg.size();
        }

        public final boolean zzg() {
            return (this.zzc & 2) != 0;
        }

        public final long zzh() {
            return this.zzh;
        }

        public final boolean zzi() {
            return (this.zzc & 4) != 0;
        }

        public final long zzj() {
            return this.zzi;
        }

        public final boolean zzk() {
            return (this.zzc & 8) != 0;
        }

        public final long zzl() {
            return this.zzj;
        }

        public final boolean zzm() {
            return (this.zzc & 16) != 0;
        }

        public final long zzn() {
            return this.zzk;
        }

        public final boolean zzo() {
            return (this.zzc & 32) != 0;
        }

        public final long zzp() {
            return this.zzl;
        }

        public final String zzq() {
            return this.zzm;
        }

        public final String zzr() {
            return this.zzn;
        }

        public final String zzs() {
            return this.zzo;
        }

        public final String zzt() {
            return this.zzp;
        }

        public final boolean zzu() {
            return (this.zzc & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) != 0;
        }

        public final int zzv() {
            return this.zzq;
        }

        public final String zzw() {
            return this.zzr;
        }

        public final String zzx() {
            return this.zzs;
        }

        public final String zzy() {
            return this.zzt;
        }

        public final boolean zzz() {
            return (this.zzc & 16384) != 0;
        }

        /* access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 8;
            this.zzj = j;
        }

        /* access modifiers changed from: private */
        public final void zzf(int i) {
            zzbw();
            this.zzg.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zzg(int i) {
            this.zzc |= OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
            this.zzq = i;
        }

        /* access modifiers changed from: private */
        public final void zzh(String str) {
            str.getClass();
            this.zzc |= 65536;
            this.zzw = str;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzy = str;
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzc |= 2097152;
            this.zzab = str;
        }

        /* access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzc |= 4194304;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zzc |= 16777216;
            this.zzaf = str;
        }

        /* access modifiers changed from: private */
        public final void zzm(String str) {
            str.getClass();
            this.zzc |= DriveFile.MODE_READ_ONLY;
            this.zzaj = str;
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzc |= Integer.MIN_VALUE;
            this.zzam = str;
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzd |= 4;
            this.zzap = str;
        }

        /* access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zzd |= 64;
            this.zzau = str;
        }

        public final zzc zza(int i) {
            return this.zzf.get(i);
        }

        public final zzk zzb(int i) {
            return this.zzg.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzbu();
            this.zzf.set(i, zzc2);
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends zzk> iterable) {
            zzbw();
            zzdq.zza(iterable, this.zzg);
        }

        public final int zzd() {
            return this.zzf.size();
        }

        public final List<zzk> zze() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzo = str;
        }

        /* access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzc |= 16;
            this.zzk = j;
        }

        /* access modifiers changed from: private */
        public final void zze(long j) {
            this.zzc |= 32;
            this.zzl = j;
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
            this.zzs = str;
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzc |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            this.zzt = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzi = j;
        }

        /* access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzc |= 524288;
            this.zzz = j;
        }

        /* access modifiers changed from: private */
        public final void zzi(int i) {
            this.zzc |= 33554432;
            this.zzag = i;
        }

        /* access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzc |= 1073741824;
            this.zzal = j;
        }

        /* access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzd |= 16;
            this.zzas = j;
        }

        /* access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzd |= 32;
            this.zzat = j;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            zzc2.getClass();
            zzbu();
            this.zzf.add(zzc2);
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 512;
            this.zzp = str;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 2048;
            this.zzr = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
            this.zzn = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zza> iterable) {
            zzfq<zza> zzfq = this.zzae;
            if (!zzfq.zza()) {
                this.zzae = zzfi.zza(zzfq);
            }
            zzdq.zza(iterable, this.zzae);
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzc |= 16384;
            this.zzu = j;
        }

        /* access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzc |= 32768;
            this.zzv = j;
        }

        /* access modifiers changed from: private */
        public final void zzh(int i) {
            this.zzc |= 1048576;
            this.zzaa = i;
        }

        /* access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzc |= DriveFile.MODE_WRITE_ONLY;
            this.zzak = j;
        }

        /* access modifiers changed from: private */
        public final void zzj(int i) {
            this.zzd |= 2;
            this.zzao = i;
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zzc> iterable) {
            zzbu();
            zzdq.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends Integer> iterable) {
            zzfo zzfo = this.zzar;
            if (!zzfo.zza()) {
                int size = zzfo.size();
                this.zzar = zzfo.zzb(size == 0 ? 10 : size << 1);
            }
            zzdq.zza(iterable, this.zzar);
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8388608;
            this.zzad = z;
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzk zzk2) {
            zzk2.getClass();
            zzbw();
            this.zzg.set(i, zzk2);
        }

        /* access modifiers changed from: private */
        public final void zza(zzk zzk2) {
            zzk2.getClass();
            zzbw();
            this.zzg.add(zzk2);
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzh = j;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzm = str;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES;
            this.zzx = z;
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh2) {
            zzh2.getClass();
            this.zzaq = zzh2;
            this.zzd |= 8;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzav, "\u0001+\u0000\u0002\u00012+\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", zzk.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", zza.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau"});
                case 4:
                    return zzav;
                case 5:
                    zzhc<zzg> zzhc = zzaw;
                    if (zzhc == null) {
                        synchronized (zzg.class) {
                            zzhc = zzaw;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzav);
                                zzaw = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzi extends zzfi<zzi, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzi zzg;
        private static volatile zzhc<zzi> zzh;
        private zzfr zzc = zzfi.zzbp();
        private zzfr zzd = zzfi.zzbp();
        private zzfq<zzb> zze = zzfi.zzbq();
        private zzfq<zzj> zzf = zzfi.zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzi, zza> implements zzgv {
            private zza() {
                super(zzi.zzg);
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzc(Iterable<? extends zzb> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzd(Iterable<? extends zzj> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(iterable);
                return this;
            }

            /* synthetic */ zza(zzbx zzbx) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzl();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzm();
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(i);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zze(i);
                return this;
            }
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzfi.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        public static zza zzi() {
            return (zza) zzg.zzbk();
        }

        public static zzi zzj() {
            return zzg;
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc = zzfi.zzbp();
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzfi.zzbp();
        }

        private final void zzn() {
            zzfq<zzb> zzfq = this.zze;
            if (!zzfq.zza()) {
                this.zze = zzfi.zza(zzfq);
            }
        }

        private final void zzo() {
            zzfq<zzj> zzfq = this.zzf;
            if (!zzfq.zza()) {
                this.zzf = zzfi.zza(zzfq);
            }
        }

        public final List<Long> zza() {
            return this.zzc;
        }

        public final int zzb() {
            return this.zzc.size();
        }

        public final List<Long> zzc() {
            return this.zzd;
        }

        public final int zzd() {
            return this.zzd.size();
        }

        public final List<zzb> zze() {
            return this.zze;
        }

        public final int zzf() {
            return this.zze.size();
        }

        public final List<zzj> zzg() {
            return this.zzf;
        }

        public final int zzh() {
            return this.zzf.size();
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzfr zzfr = this.zzc;
            if (!zzfr.zza()) {
                this.zzc = zzfi.zza(zzfr);
            }
            zzdq.zza(iterable, this.zzc);
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends Long> iterable) {
            zzfr zzfr = this.zzd;
            if (!zzfr.zza()) {
                this.zzd = zzfi.zza(zzfr);
            }
            zzdq.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zzb> iterable) {
            zzn();
            zzdq.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            zzn();
            this.zze.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzo();
            this.zzf.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends zzj> iterable) {
            zzo();
            zzdq.zza(iterable, this.zzf);
        }

        public final zzb zza(int i) {
            return this.zze.get(i);
        }

        public final zzj zzb(int i) {
            return this.zzf.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", zzb.class, "zzf", zzj.class});
                case 4:
                    return zzg;
                case 5:
                    zzhc<zzi> zzhc = zzh;
                    if (zzhc == null) {
                        synchronized (zzi.class) {
                            zzhc = zzh;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzg);
                                zzh = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzj extends zzfi<zzj, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzj zzf;
        private static volatile zzhc<zzj> zzg;
        private int zzc;
        private int zzd;
        private zzfr zze = zzfi.zzbp();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzj, zza> implements zzgv {
            private zza() {
                super(zzj.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb(i);
                return this;
            }

            /* synthetic */ zza(zzbx zzbx) {
                this();
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza(iterable);
                return this;
            }
        }

        static {
            zzj zzj = new zzj();
            zzf = zzj;
            zzfi.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        public static zza zze() {
            return (zza) zzf.zzbk();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<Long> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final long zza(int i) {
            return this.zze.zzb(i);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzfr zzfr = this.zze;
            if (!zzfr.zza()) {
                this.zze = zzfi.zza(zzfr);
            }
            zzdq.zza(iterable, this.zze);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhc<zzj> zzhc = zzg;
                    if (zzhc == null) {
                        synchronized (zzj.class) {
                            zzhc = zzg;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzf);
                                zzg = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzk extends zzfi<zzk, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzk zzj;
        private static volatile zzhc<zzk> zzk;
        private int zzc;
        private long zzd;
        private String zze = "";
        private String zzf = "";
        private long zzg;
        private float zzh;
        private double zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzk, zza> implements zzgv {
            private zza() {
                super(zzk.zzj);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(j);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzn();
                return this;
            }

            /* synthetic */ zza(zzbx zzbx) {
                this();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(str);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(j);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzl();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzm();
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(d);
                return this;
            }
        }

        static {
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzfi.zza(zzk.class, zzk2);
        }

        private zzk() {
        }

        public static zza zzj() {
            return (zza) zzj.zzbk();
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc &= -5;
            this.zzf = zzj.zzf;
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzc &= -9;
            this.zzg = 0;
        }

        /* access modifiers changed from: private */
        public final void zzn() {
            this.zzc &= -33;
            this.zzi = 0.0d;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final String zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 32) != 0;
        }

        public final double zzi() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        public final void zza(double d) {
            this.zzc |= 32;
            this.zzi = d;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhc<zzk> zzhc = zzk;
                    if (zzhc == null) {
                        synchronized (zzk.class) {
                            zzhc = zzk;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzj);
                                zzk = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzd extends zzfi<zzd, zza> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzd zzf;
        private static volatile zzhc<zzd> zzg;
        private int zzc;
        private String zzd = "";
        private long zze;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzd, zza> implements zzgv {
            private zza() {
                super(zzd.zzf);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzbx zzbx) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzf = zzd2;
            zzfi.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zza() {
            return (zza) zzf.zzbk();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhc<zzd> zzhc = zzg;
                    if (zzhc == null) {
                        synchronized (zzd.class) {
                            zzhc = zzg;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzf);
                                zzg = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzh extends zzfi<zzh, zzb> implements zzgv {
        /* access modifiers changed from: private */
        public static final zzh zzf;
        private static volatile zzhc<zzh> zzg;
        private int zzc;
        private int zzd = 1;
        private zzfq<zzd> zze = zzfi.zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public enum zza implements zzfn {
            RADS(1),
            PROVISIONING(2);
            
            private static final zzfm<zza> zzc = null;
            private final int zzd;

            static {
                zzc = new zzbz();
            }

            private zza(int i) {
                this.zzd = i;
            }

            public static zzfp zzb() {
                return zzby.zza;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            public final int zza() {
                return this.zzd;
            }

            public static zza zza(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zzb extends zzfi.zzb<zzh, zzb> implements zzgv {
            private zzb() {
                super(zzh.zzf);
            }

            public final zzb zza(zzd.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza((zzd) ((zzfi) zza.zzu()));
                return this;
            }

            /* synthetic */ zzb(zzbx zzbx) {
                this();
            }
        }

        static {
            zzh zzh = new zzh();
            zzf = zzh;
            zzfi.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            zzd2.getClass();
            zzfq<zzd> zzfq = this.zze;
            if (!zzfq.zza()) {
                this.zze = zzfi.zza(zzfq);
            }
            this.zze.add(zzd2);
        }

        public static zzb zza() {
            return (zzb) zzf.zzbk();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb((zzbx) null);
                case 3:
                    return zzfi.zza((zzgt) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zzd.class});
                case 4:
                    return zzf;
                case 5:
                    zzhc<zzh> zzhc = zzg;
                    if (zzhc == null) {
                        synchronized (zzh.class) {
                            zzhc = zzg;
                            if (zzhc == null) {
                                zzhc = new zzfi.zza<>(zzf);
                                zzg = zzhc;
                            }
                        }
                    }
                    return zzhc;
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
