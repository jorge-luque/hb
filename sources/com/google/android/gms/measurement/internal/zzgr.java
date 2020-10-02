package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
abstract class zzgr extends zzgs {
    private boolean zza;

    zzgr(zzfx zzfx) {
        super(zzfx);
        this.zzz.zza(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f_ */
    public void mo26456f_() {
    }

    /* access modifiers changed from: protected */
    public final void zzaa() {
        if (!zzz()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzab() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zze()) {
            this.zzz.zzaf();
            this.zza = true;
        }
    }

    public final void zzac() {
        if (!this.zza) {
            mo26456f_();
            this.zzz.zzaf();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean zze();

    /* access modifiers changed from: package-private */
    public final boolean zzz() {
        return this.zza;
    }
}
