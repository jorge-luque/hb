package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzeq implements zzhj {
    private final zzel zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzeq(zzel zzel) {
        zzel zzel2 = (zzel) zzfk.zza(zzel, "input");
        this.zza = zzel2;
        zzel2.zzc = this;
    }

    public static zzeq zza(zzel zzel) {
        zzeq zzeq = zzel.zzc;
        if (zzeq != null) {
            return zzeq;
        }
        return new zzeq(zzel);
    }

    public final int zzb() {
        return this.zzb;
    }

    public final boolean zzc() throws IOException {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzb(i);
    }

    public final double zzd() throws IOException {
        zza(1);
        return this.zza.zzb();
    }

    public final float zze() throws IOException {
        zza(5);
        return this.zza.zzc();
    }

    public final long zzf() throws IOException {
        zza(0);
        return this.zza.zzd();
    }

    public final long zzg() throws IOException {
        zza(0);
        return this.zza.zze();
    }

    public final int zzh() throws IOException {
        zza(0);
        return this.zza.zzf();
    }

    public final long zzi() throws IOException {
        zza(1);
        return this.zza.zzg();
    }

    public final int zzj() throws IOException {
        zza(5);
        return this.zza.zzh();
    }

    public final boolean zzk() throws IOException {
        zza(0);
        return this.zza.zzi();
    }

    public final String zzl() throws IOException {
        zza(2);
        return this.zza.zzj();
    }

    public final String zzm() throws IOException {
        zza(2);
        return this.zza.zzk();
    }

    public final zzdz zzn() throws IOException {
        zza(2);
        return this.zza.zzl();
    }

    public final int zzo() throws IOException {
        zza(0);
        return this.zza.zzm();
    }

    public final int zzp() throws IOException {
        zza(0);
        return this.zza.zzn();
    }

    public final int zzq() throws IOException {
        zza(5);
        return this.zza.zzo();
    }

    public final long zzr() throws IOException {
        zza(1);
        return this.zza.zzp();
    }

    public final int zzs() throws IOException {
        zza(0);
        return this.zza.zzq();
    }

    public final long zzt() throws IOException {
        zza(0);
        return this.zza.zzr();
    }

    public final <T> T zzb(zzhi<T> zzhi, zzev zzev) throws IOException {
        zza(3);
        return zzd(zzhi, zzev);
    }

    private final <T> T zzc(zzhi<T> zzhi, zzev zzev) throws IOException {
        int zzm = this.zza.zzm();
        zzel zzel = this.zza;
        if (zzel.zza < zzel.zzb) {
            int zzc2 = zzel.zzc(zzm);
            T zza2 = zzhi.zza();
            this.zza.zza++;
            zzhi.zza(zza2, this, zzev);
            zzhi.zzc(zza2);
            this.zza.zza(0);
            zzel zzel2 = this.zza;
            zzel2.zza--;
            zzel2.zzd(zzc2);
            return zza2;
        }
        throw new zzft("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzhi<T> zzhi, zzev zzev) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza2 = zzhi.zza();
            zzhi.zza(zza2, this, zzev);
            zzhi.zzc(zza2);
            if (this.zzb == this.zzc) {
                return zza2;
            }
            throw zzft.zzg();
        } finally {
            this.zzc = i;
        }
    }

    public final int zza() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zza();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final void zze(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfl.zzd(this.zza.zzf());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfl.zzd(this.zza.zzf());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgh) {
            zzgh zzgh = (zzgh) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzgh.zza(this.zza.zzg());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzgh.zza(this.zza.zzg());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzg(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzfl.zzd(this.zza.zzh());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzfl.zzd(this.zza.zzh());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzdx) {
            zzdx zzdx = (zzdx) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzdx.zza(this.zza.zzi());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzdx.zza(this.zza.zzi());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzj(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzk(List<zzdz> list) throws IOException {
        int zza2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzn());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        throw zzft.zzf();
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfl.zzd(this.zza.zzm());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfl.zzd(this.zza.zzm());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfl.zzd(this.zza.zzn());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfl.zzd(this.zza.zzn());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzn(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzfl.zzd(this.zza.zzo());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzfl.zzd(this.zza.zzo());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzo(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgh) {
            zzgh zzgh = (zzgh) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzgh.zza(this.zza.zzp());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzgh.zza(this.zza.zzp());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzp(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzfl.zzd(this.zza.zzq());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzfl.zzd(this.zza.zzq());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzq(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgh) {
            zzgh zzgh = (zzgh) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgh.zza(this.zza.zzr());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgh.zza(this.zza.zzr());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzb(List<Float> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzfh) {
            zzfh zzfh = (zzfh) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzfh.zza(this.zza.zzc());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzfh.zza(this.zza.zzc());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzft.zzf();
            }
        }
    }

    private final void zza(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzft.zzf();
        }
    }

    public final <T> T zza(zzhi<T> zzhi, zzev zzev) throws IOException {
        zza(2);
        return zzc(zzhi, zzev);
    }

    public final void zza(List<Double> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzet) {
            zzet zzet = (zzet) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzet.zza(this.zza.zzb());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzet.zza(this.zza.zzb());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzd(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgh) {
            zzgh zzgh = (zzgh) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgh.zza(this.zza.zze());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgh.zza(this.zza.zze());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final void zzc(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzgh) {
            zzgh zzgh = (zzgh) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgh.zza(this.zza.zzd());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgh.zza(this.zza.zzd());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzft.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzft.zzf();
            }
        }
    }

    public final <T> void zzb(List<T> list, zzhi<T> zzhi, zzev zzev) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzhi, zzev));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzft.zzf();
    }

    private static void zzb(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzft.zzg();
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zza2;
        int zza3;
        if ((this.zzb & 7) != 2) {
            throw zzft.zzf();
        } else if (!(list instanceof zzga) || z) {
            do {
                list.add(z ? zzm() : zzl());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        } else {
            zzga zzga = (zzga) list;
            do {
                zzga.zza(zzn());
                if (!this.zza.zzt()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
        }
    }

    private final void zzd(int i) throws IOException {
        if (this.zza.zzu() != i) {
            throw zzft.zza();
        }
    }

    private static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzft.zzg();
        }
    }

    public final <T> void zza(List<T> list, zzhi<T> zzhi, zzev zzev) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzhi, zzev));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzft.zzf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzc() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.measurement.zzft("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.measurement.zzgk<K, V> r9, com.google.android.gms.internal.measurement.zzev r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zza((int) r0)
            com.google.android.gms.internal.measurement.zzel r1 = r7.zza
            int r1 = r1.zzm()
            com.google.android.gms.internal.measurement.zzel r2 = r7.zza
            int r1 = r2.zzc(r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L_0x0014:
            int r4 = r7.zza()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.measurement.zzel r5 = r7.zza     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzt()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzc()     // Catch:{ zzfs -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.measurement.zzft r4 = new com.google.android.gms.internal.measurement.zzft     // Catch:{ zzfs -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzfs -> 0x004e }
            throw r4     // Catch:{ zzfs -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.measurement.zzir r4 = r9.zzc     // Catch:{ zzfs -> 0x004e }
            V r5 = r9.zzd     // Catch:{ zzfs -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzfs -> 0x004e }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.measurement.zzir) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzev) r10)     // Catch:{ zzfs -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.measurement.zzir r4 = r9.zza     // Catch:{ zzfs -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza((com.google.android.gms.internal.measurement.zzir) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzev) r5)     // Catch:{ zzfs -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzc()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.measurement.zzft r8 = new com.google.android.gms.internal.measurement.zzft     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.measurement.zzel r8 = r7.zza
            r8.zzd(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.measurement.zzel r9 = r7.zza
            r9.zzd(r1)
            goto L_0x006c
        L_0x006b:
            throw r8
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeq.zza(java.util.Map, com.google.android.gms.internal.measurement.zzgk, com.google.android.gms.internal.measurement.zzev):void");
    }

    private final Object zza(zzir zzir, Class<?> cls, zzev zzev) throws IOException {
        switch (zzep.zza[zzir.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzk());
            case 2:
                return zzn();
            case 3:
                return Double.valueOf(zzd());
            case 4:
                return Integer.valueOf(zzp());
            case 5:
                return Integer.valueOf(zzj());
            case 6:
                return Long.valueOf(zzi());
            case 7:
                return Float.valueOf(zze());
            case 8:
                return Integer.valueOf(zzh());
            case 9:
                return Long.valueOf(zzg());
            case 10:
                zza(2);
                return zzc(zzhe.zza().zza(cls), zzev);
            case 11:
                return Integer.valueOf(zzq());
            case 12:
                return Long.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Long.valueOf(zzt());
            case 15:
                return zzm();
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
