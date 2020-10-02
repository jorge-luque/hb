package com.google.android.gms.internal.ads;

import com.facebook.internal.Utility;
import com.google.android.gms.internal.ads.zzecd;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzefy {

    /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
    public static final class zza extends zzecd<zza, C6829zza> implements zzedq {
        private static volatile zzedx<zza> zzea;
        /* access modifiers changed from: private */
        public static final zza zziex;
        private int zzdl;
        private int zzieq;
        private zzb zzier;
        private zzeaq zzies;
        private zzeaq zziet;
        private boolean zzieu;
        private boolean zziev;
        private byte zziew = 2;

        /* renamed from: com.google.android.gms.internal.ads.zzefy$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class C6829zza extends zzecd.zza<zza, C6829zza> implements zzedq {
            private C6829zza() {
                super(zza.zziex);
            }

            /* synthetic */ C6829zza(zzefx zzefx) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class zzb extends zzecd<zzb, C6830zza> implements zzedq {
            private static volatile zzedx<zzb> zzea;
            /* access modifiers changed from: private */
            public static final zzb zzifc;
            private int zzdl;
            private String zziey = "";
            private String zziez = "";
            private String zzifa = "";
            private int zzifb;

            /* renamed from: com.google.android.gms.internal.ads.zzefy$zza$zzb$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class C6830zza extends zzecd.zza<zzb, C6830zza> implements zzedq {
                private C6830zza() {
                    super(zzb.zzifc);
                }

                /* synthetic */ C6830zza(zzefx zzefx) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzifc = zzb;
                zzecd.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzefx.zzdk[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C6830zza((zzefx) null);
                    case 3:
                        return zzecd.zza((zzedo) zzifc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzdl", "zziey", "zziez", "zzifa", "zzifb"});
                    case 4:
                        return zzifc;
                    case 5:
                        zzedx<zzb> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zzb.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzifc);
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

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public enum zzc implements zzecf {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzeci<zzc> zzeh = null;
            private final int value;

            static {
                zzeh = new zzefz();
            }

            private zzc(int i) {
                this.value = i;
            }

            public static zzc zzhn(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            public static zzech zzx() {
                return zzega.zzej;
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
            zziex = zza;
            zzecd.zza(zza.class, zza);
        }

        private zza() {
            zzeaq zzeaq = zzeaq.zzhtf;
            this.zzies = zzeaq;
            this.zziet = zzeaq;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzefx.zzdk[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C6829zza((zzefx) null);
                case 3:
                    return zzecd.zza((zzedo) zziex, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzdl", "zzieq", zzc.zzx(), "zzier", "zzies", "zziet", "zzieu", "zziev"});
                case 4:
                    return zziex;
                case 5:
                    zzedx<zza> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zza.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zziex);
                                zzea = zzedx;
                            }
                        }
                    }
                    return zzedx;
                case 6:
                    return Byte.valueOf(this.zziew);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zziew = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
    public static final class zzb extends zzecd<zzb, C6832zzb> implements zzedq {
        private static volatile zzedx<zzb> zzea;
        /* access modifiers changed from: private */
        public static final zzb zzify;
        private int zzbxl;
        private int zzdl;
        private zzeaq zzies = zzeaq.zzhtf;
        private byte zziew = 2;
        private String zziez = "";
        private int zzifj;
        private String zzifk = "";
        private String zzifl = "";
        private zza zzifm;
        private zzecl<zzh> zzifn = zzecd.zzbfa();
        private String zzifo = "";
        private zzf zzifp;
        private boolean zzifq;
        private zzecl<String> zzifr = zzecd.zzbfa();
        private String zzifs = "";
        private boolean zzift;
        private boolean zzifu;
        private zzi zzifv;
        private zzecl<String> zzifw = zzecd.zzbfa();
        private zzecl<String> zzifx = zzecd.zzbfa();

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class zza extends zzecd<zza, C6831zza> implements zzedq {
            private static volatile zzedx<zza> zzea;
            /* access modifiers changed from: private */
            public static final zza zziga;
            private int zzdl;
            private String zzifz = "";

            /* renamed from: com.google.android.gms.internal.ads.zzefy$zzb$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class C6831zza extends zzecd.zza<zza, C6831zza> implements zzedq {
                private C6831zza() {
                    super(zza.zziga);
                }

                public final C6831zza zzhz(String str) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zzhv(str);
                    return this;
                }

                /* synthetic */ C6831zza(zzefx zzefx) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zziga = zza;
                zzecd.zza(zza.class, zza);
            }

            private zza() {
            }

            public static C6831zza zzbhw() {
                return (C6831zza) zziga.zzbev();
            }

            /* access modifiers changed from: private */
            public final void zzhv(String str) {
                str.getClass();
                this.zzdl |= 1;
                this.zzifz = str;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzefx.zzdk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C6831zza((zzefx) null);
                    case 3:
                        return zzecd.zza((zzedo) zziga, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdl", "zzifz"});
                    case 4:
                        return zziga;
                    case 5:
                        zzedx<zza> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zza.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zziga);
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

        /* renamed from: com.google.android.gms.internal.ads.zzefy$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class C6832zzb extends zzecd.zza<zzb, C6832zzb> implements zzedq {
            private C6832zzb() {
                super(zzb.zzify);
            }

            public final String getUrl() {
                return ((zzb) this.zzhxt).getUrl();
            }

            public final C6832zzb zzb(zzg zzg) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zza(zzg);
                return this;
            }

            public final List<zzh> zzbhr() {
                return Collections.unmodifiableList(((zzb) this.zzhxt).zzbhr());
            }

            public final String zzbhs() {
                return ((zzb) this.zzhxt).zzbhs();
            }

            public final C6832zzb zzbhy() {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zzbht();
                return this;
            }

            public final C6832zzb zzhw(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).setUrl(str);
                return this;
            }

            public final C6832zzb zzhx(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zzhu(str);
                return this;
            }

            public final C6832zzb zzhy(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zzdy(str);
                return this;
            }

            public final C6832zzb zzo(Iterable<String> iterable) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zzm(iterable);
                return this;
            }

            public final C6832zzb zzp(Iterable<String> iterable) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zzn(iterable);
                return this;
            }

            /* synthetic */ C6832zzb(zzefx zzefx) {
                this();
            }

            public final C6832zzb zzb(zza zza) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zza(zza);
                return this;
            }

            public final C6832zzb zzb(zzh zzh) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zza(zzh);
                return this;
            }

            public final C6832zzb zzb(zzf zzf) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zza(zzf);
                return this;
            }

            public final C6832zzb zzb(zzi zzi) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zza(zzi);
                return this;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class zzc extends zzecd<zzc, zza> implements zzedq {
            private static volatile zzedx<zzc> zzea;
            /* access modifiers changed from: private */
            public static final zzc zzigc;
            private int zzdl;
            private zzeaq zzhoa;
            private byte zziew = 2;
            private zzeaq zzigb;

            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class zza extends zzecd.zza<zzc, zza> implements zzedq {
                private zza() {
                    super(zzc.zzigc);
                }

                public final zza zzao(zzeaq zzeaq) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzc) this.zzhxt).zzan(zzeaq);
                    return this;
                }

                public final zza zzap(zzeaq zzeaq) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzc) this.zzhxt).zzae(zzeaq);
                    return this;
                }

                /* synthetic */ zza(zzefx zzefx) {
                    this();
                }
            }

            static {
                zzc zzc = new zzc();
                zzigc = zzc;
                zzecd.zza(zzc.class, zzc);
            }

            private zzc() {
                zzeaq zzeaq = zzeaq.zzhtf;
                this.zzigb = zzeaq;
                this.zzhoa = zzeaq;
            }

            /* access modifiers changed from: private */
            public final void zzae(zzeaq zzeaq) {
                zzeaq.getClass();
                this.zzdl |= 2;
                this.zzhoa = zzeaq;
            }

            /* access modifiers changed from: private */
            public final void zzan(zzeaq zzeaq) {
                zzeaq.getClass();
                this.zzdl |= 1;
                this.zzigb = zzeaq;
            }

            public static zza zzbhz() {
                return (zza) zzigc.zzbev();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzefx.zzdk[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza((zzefx) null);
                    case 3:
                        return zzecd.zza((zzedo) zzigc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzdl", "zzigb", "zzhoa"});
                    case 4:
                        return zzigc;
                    case 5:
                        zzedx<zzc> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zzc.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzigc);
                                    zzea = zzedx;
                                }
                            }
                        }
                        return zzedx;
                    case 6:
                        return Byte.valueOf(this.zziew);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zziew = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class zze extends zzecd<zze, C6836zzb> implements zzedq {
            private static volatile zzedx<zze> zzea;
            /* access modifiers changed from: private */
            public static final zze zzigp;
            private int zzdl;
            private byte zziew = 2;
            private zzecl<zzc> zzige = zzecd.zzbfa();
            private zzeaq zzigf;
            private zzeaq zzigg;
            private int zzigh;
            private zza zzign;
            private zzeaq zzigo;

            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class zza extends zzecd<zza, C6835zza> implements zzedq {
                private static volatile zzedx<zza> zzea;
                /* access modifiers changed from: private */
                public static final zza zzigs;
                private int zzdl;
                private zzeaq zzigl;
                private int zzigq;
                private zzeaq zzigr;

                /* renamed from: com.google.android.gms.internal.ads.zzefy$zzb$zze$zza$zza  reason: collision with other inner class name */
                /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
                public static final class C6835zza extends zzecd.zza<zza, C6835zza> implements zzedq {
                    private C6835zza() {
                        super(zza.zzigs);
                    }

                    /* synthetic */ C6835zza(zzefx zzefx) {
                        this();
                    }
                }

                static {
                    zza zza = new zza();
                    zzigs = zza;
                    zzecd.zza(zza.class, zza);
                }

                private zza() {
                    zzeaq zzeaq = zzeaq.zzhtf;
                    this.zzigr = zzeaq;
                    this.zzigl = zzeaq;
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzefx.zzdk[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C6835zza((zzefx) null);
                        case 3:
                            return zzecd.zza((zzedo) zzigs, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdl", "zzigq", "zzigr", "zzigl"});
                        case 4:
                            return zzigs;
                        case 5:
                            zzedx<zza> zzedx = zzea;
                            if (zzedx == null) {
                                synchronized (zza.class) {
                                    zzedx = zzea;
                                    if (zzedx == null) {
                                        zzedx = new zzecd.zzc<>(zzigs);
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

            /* renamed from: com.google.android.gms.internal.ads.zzefy$zzb$zze$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class C6836zzb extends zzecd.zza<zze, C6836zzb> implements zzedq {
                private C6836zzb() {
                    super(zze.zzigp);
                }

                /* synthetic */ C6836zzb(zzefx zzefx) {
                    this();
                }
            }

            static {
                zze zze = new zze();
                zzigp = zze;
                zzecd.zza(zze.class, zze);
            }

            private zze() {
                zzeaq zzeaq = zzeaq.zzhtf;
                this.zzigf = zzeaq;
                this.zzigg = zzeaq;
                this.zzigo = zzeaq;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzefx.zzdk[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C6836zzb((zzefx) null);
                    case 3:
                        return zzecd.zza((zzedo) zzigp, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzdl", "zzign", "zzige", zzc.class, "zzigf", "zzigg", "zzigh", "zzigo"});
                    case 4:
                        return zzigp;
                    case 5:
                        zzedx<zze> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zze.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzigp);
                                    zzea = zzedx;
                                }
                            }
                        }
                        return zzedx;
                    case 6:
                        return Byte.valueOf(this.zziew);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zziew = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public enum zzg implements zzecf {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzeci<zzg> zzeh = null;
            private final int value;

            static {
                zzeh = new zzegd();
            }

            private zzg(int i) {
                this.value = i;
            }

            public static zzg zzhp(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzech zzx() {
                return zzege.zzej;
            }

            public final String toString() {
                return "<" + zzg.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            public final int zzw() {
                return this.value;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class zzi extends zzecd<zzi, zza> implements zzedq {
            private static volatile zzedx<zzi> zzea;
            /* access modifiers changed from: private */
            public static final zzi zziib;
            private int zzdl;
            private String zzihy = "";
            private long zzihz;
            private boolean zziia;

            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class zza extends zzecd.zza<zzi, zza> implements zzedq {
                private zza() {
                    super(zzi.zziib);
                }

                public final zza zzbw(boolean z) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzi) this.zzhxt).zzbx(z);
                    return this;
                }

                public final zza zzft(long j) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzi) this.zzhxt).zzfu(j);
                    return this;
                }

                public final zza zzie(String str) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzi) this.zzhxt).zzif(str);
                    return this;
                }

                /* synthetic */ zza(zzefx zzefx) {
                    this();
                }
            }

            static {
                zzi zzi = new zzi();
                zziib = zzi;
                zzecd.zza(zzi.class, zzi);
            }

            private zzi() {
            }

            public static zza zzbil() {
                return (zza) zziib.zzbev();
            }

            /* access modifiers changed from: private */
            public final void zzbx(boolean z) {
                this.zzdl |= 4;
                this.zziia = z;
            }

            /* access modifiers changed from: private */
            public final void zzfu(long j) {
                this.zzdl |= 2;
                this.zzihz = j;
            }

            /* access modifiers changed from: private */
            public final void zzif(String str) {
                str.getClass();
                this.zzdl |= 1;
                this.zzihy = str;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzefx.zzdk[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza((zzefx) null);
                    case 3:
                        return zzecd.zza((zzedo) zziib, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzdl", "zzihy", "zzihz", "zziia"});
                    case 4:
                        return zziib;
                    case 5:
                        zzedx<zzi> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zzi.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zziib);
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

        static {
            zzb zzb = new zzb();
            zzify = zzb;
            zzecd.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void setUrl(String str) {
            str.getClass();
            this.zzdl |= 4;
            this.zziez = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg2) {
            this.zzbxl = zzg2.zzw();
            this.zzdl |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzbht() {
            this.zzdl &= -65;
            this.zzifo = zzify.zzifo;
        }

        public static C6832zzb zzbhu() {
            return (C6832zzb) zzify.zzbev();
        }

        /* access modifiers changed from: private */
        public final void zzdy(String str) {
            str.getClass();
            this.zzdl |= 64;
            this.zzifo = str;
        }

        /* access modifiers changed from: private */
        public final void zzhu(String str) {
            str.getClass();
            this.zzdl |= 8;
            this.zzifk = str;
        }

        /* access modifiers changed from: private */
        public final void zzm(Iterable<String> iterable) {
            if (!this.zzifw.zzbci()) {
                this.zzifw = zzecd.zza(this.zzifw);
            }
            zzeag.zza(iterable, this.zzifw);
        }

        /* access modifiers changed from: private */
        public final void zzn(Iterable<String> iterable) {
            if (!this.zzifx.zzbci()) {
                this.zzifx = zzecd.zza(this.zzifx);
            }
            zzeag.zza(iterable, this.zzifx);
        }

        public final String getUrl() {
            return this.zziez;
        }

        public final List<zzh> zzbhr() {
            return this.zzifn;
        }

        public final String zzbhs() {
            return this.zzifo;
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class zzf extends zzecd<zzf, C6837zzb> implements zzedq {
            private static volatile zzedx<zzf> zzea;
            /* access modifiers changed from: private */
            public static final zzf zzigv;
            private int zzbxl;
            private int zzdl;
            private String zzigt = "";
            private zzeaq zzigu = zzeaq.zzhtf;

            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public enum zza implements zzecf {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzeci<zza> zzeh = null;
                private final int value;

                static {
                    zzeh = new zzegc();
                }

                private zza(int i) {
                    this.value = i;
                }

                public static zza zzho(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                public static zzech zzx() {
                    return zzegb.zzej;
                }

                public final String toString() {
                    return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
                }

                public final int zzw() {
                    return this.value;
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzefy$zzb$zzf$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class C6837zzb extends zzecd.zza<zzf, C6837zzb> implements zzedq {
                private C6837zzb() {
                    super(zzf.zzigv);
                }

                public final C6837zzb zzar(zzeaq zzeaq) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzf) this.zzhxt).zzaq(zzeaq);
                    return this;
                }

                public final C6837zzb zzb(zza zza) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzf) this.zzhxt).zza(zza);
                    return this;
                }

                public final C6837zzb zzia(String str) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzf) this.zzhxt).setMimeType(str);
                    return this;
                }

                /* synthetic */ C6837zzb(zzefx zzefx) {
                    this();
                }
            }

            static {
                zzf zzf = new zzf();
                zzigv = zzf;
                zzecd.zza(zzf.class, zzf);
            }

            private zzf() {
            }

            /* access modifiers changed from: private */
            public final void setMimeType(String str) {
                str.getClass();
                this.zzdl |= 2;
                this.zzigt = str;
            }

            /* access modifiers changed from: private */
            public final void zza(zza zza2) {
                this.zzbxl = zza2.zzw();
                this.zzdl |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzaq(zzeaq zzeaq) {
                zzeaq.getClass();
                this.zzdl |= 4;
                this.zzigu = zzeaq;
            }

            public static C6837zzb zzbig() {
                return (C6837zzb) zzigv.zzbev();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzefx.zzdk[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C6837zzb((zzefx) null);
                    case 3:
                        return zzecd.zza((zzedo) zzigv, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzdl", "zzbxl", zza.zzx(), "zzigt", "zzigu"});
                    case 4:
                        return zzigv;
                    case 5:
                        zzedx<zzf> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zzf.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzigv);
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

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class zzh extends zzecd<zzh, C6838zzb> implements zzedq {
            private static volatile zzedx<zzh> zzea;
            /* access modifiers changed from: private */
            public static final zzh zzihs;
            private int zzdl;
            private byte zziew = 2;
            private String zziez = "";
            private int zzihk;
            private zzd zzihl;
            private zze zzihm;
            private int zzihn;
            private zzeck zziho = zzecd.zzbey();
            private String zzihp = "";
            private int zzihq;
            private zzecl<String> zzihr = zzecd.zzbfa();

            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public enum zza implements zzecf {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzeci<zza> zzeh = null;
                private final int value;

                static {
                    zzeh = new zzegf();
                }

                private zza(int i) {
                    this.value = i;
                }

                public static zza zzhq(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                public static zzech zzx() {
                    return zzegg.zzej;
                }

                public final String toString() {
                    return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
                }

                public final int zzw() {
                    return this.value;
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzefy$zzb$zzh$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class C6838zzb extends zzecd.zza<zzh, C6838zzb> implements zzedq {
                private C6838zzb() {
                    super(zzh.zzihs);
                }

                public final C6838zzb zzb(zzd zzd) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzh) this.zzhxt).zza(zzd);
                    return this;
                }

                public final C6838zzb zzhr(int i) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzh) this.zzhxt).setId(i);
                    return this;
                }

                public final C6838zzb zzic(String str) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzh) this.zzhxt).setUrl(str);
                    return this;
                }

                public final C6838zzb zzid(String str) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzh) this.zzhxt).zzib(str);
                    return this;
                }

                /* synthetic */ C6838zzb(zzefx zzefx) {
                    this();
                }

                public final C6838zzb zzb(zza zza) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzh) this.zzhxt).zza(zza);
                    return this;
                }
            }

            static {
                zzh zzh = new zzh();
                zzihs = zzh;
                zzecd.zza(zzh.class, zzh);
            }

            private zzh() {
            }

            /* access modifiers changed from: private */
            public final void setId(int i) {
                this.zzdl |= 1;
                this.zzihk = i;
            }

            /* access modifiers changed from: private */
            public final void setUrl(String str) {
                str.getClass();
                this.zzdl |= 2;
                this.zziez = str;
            }

            /* access modifiers changed from: private */
            public final void zza(zzd zzd) {
                zzd.getClass();
                this.zzihl = zzd;
                this.zzdl |= 4;
            }

            public static C6838zzb zzbij() {
                return (C6838zzb) zzihs.zzbev();
            }

            /* access modifiers changed from: private */
            public final void zzib(String str) {
                str.getClass();
                if (!this.zzihr.zzbci()) {
                    this.zzihr = zzecd.zza(this.zzihr);
                }
                this.zzihr.add(str);
            }

            public final String getUrl() {
                return this.zziez;
            }

            public final int zzbii() {
                return this.zzihr.size();
            }

            /* access modifiers changed from: private */
            public final void zza(zza zza2) {
                this.zzihq = zza2.zzw();
                this.zzdl |= 64;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzefx.zzdk[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C6838zzb((zzefx) null);
                    case 3:
                        return zzecd.zza((zzedo) zzihs, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzdl", "zzihk", "zziez", "zzihl", "zzihm", "zzihn", "zziho", "zzihp", "zzihq", zza.zzx(), "zzihr"});
                    case 4:
                        return zzihs;
                    case 5:
                        zzedx<zzh> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zzh.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzihs);
                                    zzea = zzedx;
                                }
                            }
                        }
                        return zzedx;
                    case 6:
                        return Byte.valueOf(this.zziew);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zziew = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            zza2.getClass();
            this.zzifm = zza2;
            this.zzdl |= 32;
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
        public static final class zzd extends zzecd<zzd, C6834zzb> implements zzedq {
            private static volatile zzedx<zzd> zzea;
            /* access modifiers changed from: private */
            public static final zzd zzigi;
            private int zzdl;
            private byte zziew = 2;
            private zza zzigd;
            private zzecl<zzc> zzige = zzecd.zzbfa();
            private zzeaq zzigf;
            private zzeaq zzigg;
            private int zzigh;

            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class zza extends zzecd<zza, C6833zza> implements zzedq {
                private static volatile zzedx<zza> zzea;
                /* access modifiers changed from: private */
                public static final zza zzigm;
                private int zzdl;
                private zzeaq zzigj;
                private zzeaq zzigk;
                private zzeaq zzigl;

                /* renamed from: com.google.android.gms.internal.ads.zzefy$zzb$zzd$zza$zza  reason: collision with other inner class name */
                /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
                public static final class C6833zza extends zzecd.zza<zza, C6833zza> implements zzedq {
                    private C6833zza() {
                        super(zza.zzigm);
                    }

                    /* synthetic */ C6833zza(zzefx zzefx) {
                        this();
                    }
                }

                static {
                    zza zza = new zza();
                    zzigm = zza;
                    zzecd.zza(zza.class, zza);
                }

                private zza() {
                    zzeaq zzeaq = zzeaq.zzhtf;
                    this.zzigj = zzeaq;
                    this.zzigk = zzeaq;
                    this.zzigl = zzeaq;
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzefx.zzdk[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C6833zza((zzefx) null);
                        case 3:
                            return zzecd.zza((zzedo) zzigm, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdl", "zzigj", "zzigk", "zzigl"});
                        case 4:
                            return zzigm;
                        case 5:
                            zzedx<zza> zzedx = zzea;
                            if (zzedx == null) {
                                synchronized (zza.class) {
                                    zzedx = zzea;
                                    if (zzedx == null) {
                                        zzedx = new zzecd.zzc<>(zzigm);
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

            /* renamed from: com.google.android.gms.internal.ads.zzefy$zzb$zzd$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
            public static final class C6834zzb extends zzecd.zza<zzd, C6834zzb> implements zzedq {
                private C6834zzb() {
                    super(zzd.zzigi);
                }

                public final C6834zzb zzb(zzc zzc) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzd) this.zzhxt).zza(zzc);
                    return this;
                }

                /* synthetic */ C6834zzb(zzefx zzefx) {
                    this();
                }
            }

            static {
                zzd zzd = new zzd();
                zzigi = zzd;
                zzecd.zza(zzd.class, zzd);
            }

            private zzd() {
                zzeaq zzeaq = zzeaq.zzhtf;
                this.zzigf = zzeaq;
                this.zzigg = zzeaq;
            }

            /* access modifiers changed from: private */
            public final void zza(zzc zzc) {
                zzc.getClass();
                if (!this.zzige.zzbci()) {
                    this.zzige = zzecd.zza(this.zzige);
                }
                this.zzige.add(zzc);
            }

            public static C6834zzb zzbib() {
                return (C6834zzb) zzigi.zzbev();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzefx.zzdk[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new C6834zzb((zzefx) null);
                    case 3:
                        return zzecd.zza((zzedo) zzigi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzdl", "zzigd", "zzige", zzc.class, "zzigf", "zzigg", "zzigh"});
                    case 4:
                        return zzigi;
                    case 5:
                        zzedx<zzd> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zzd.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzigi);
                                    zzea = zzedx;
                                }
                            }
                        }
                        return zzedx;
                    case 6:
                        return Byte.valueOf(this.zziew);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zziew = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh2) {
            zzh2.getClass();
            if (!this.zzifn.zzbci()) {
                this.zzifn = zzecd.zza(this.zzifn);
            }
            this.zzifn.add(zzh2);
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf2) {
            zzf2.getClass();
            this.zzifp = zzf2;
            this.zzdl |= OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi2) {
            zzi2.getClass();
            this.zzifv = zzi2;
            this.zzdl |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzefx.zzdk[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C6832zzb((zzefx) null);
                case 3:
                    return zzecd.zza((zzedo) zzify, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzdl", "zziez", "zzifk", "zzifl", "zzifn", zzh.class, "zzifq", "zzifr", "zzifs", "zzift", "zzifu", "zzbxl", zzg.zzx(), "zzifj", zza.zzc.zzx(), "zzifm", "zzifo", "zzifp", "zzies", "zzifv", "zzifw", "zzifx"});
                case 4:
                    return zzify;
                case 5:
                    zzedx<zzb> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzb.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzify);
                                zzea = zzedx;
                            }
                        }
                    }
                    return zzedx;
                case 6:
                    return Byte.valueOf(this.zziew);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zziew = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
