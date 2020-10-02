package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzckw extends zzckt {
    private String zzgbw;
    private int zzgbx = zzclb.zzgbz;

    public zzckw(Context context) {
        this.zzgbu = new zzaqr(context, zzq.zzlk().zzxx(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgbs) {
                this.zzgbs = true;
                try {
                    if (this.zzgbx == zzclb.zzgca) {
                        this.zzgbu.zzus().zzc(this.zzgbt, new zzcks(this));
                    } else if (this.zzgbx == zzclb.zzgcb) {
                        this.zzgbu.zzus().zza(this.zzgbw, (zzard) new zzcks(this));
                    } else {
                        this.zzdej.setException(new zzclc(0));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdej.setException(new zzclc(0));
                } catch (Throwable th) {
                    zzq.zzla().zza(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zzdej.setException(new zzclc(0));
                }
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzazw.zzed("Cannot connect to remote service, fallback to local instance.");
        this.zzdej.setException(new zzclc(0));
    }

    public final zzdri<InputStream> zzgk(String str) {
        synchronized (this.mLock) {
            if (this.zzgbx != zzclb.zzgbz && this.zzgbx != zzclb.zzgcb) {
                zzdri<InputStream> immediateFailedFuture = zzdqw.immediateFailedFuture(new zzclc(1));
                return immediateFailedFuture;
            } else if (this.zzgbr) {
                zzbaj<InputStream> zzbaj = this.zzdej;
                return zzbaj;
            } else {
                this.zzgbx = zzclb.zzgcb;
                this.zzgbr = true;
                this.zzgbw = str;
                this.zzgbu.checkAvailabilityAndConnect();
                this.zzdej.addListener(new zzcky(this), zzbab.zzdzw);
                zzbaj<InputStream> zzbaj2 = this.zzdej;
                return zzbaj2;
            }
        }
    }

    public final zzdri<InputStream> zzi(zzarj zzarj) {
        synchronized (this.mLock) {
            if (this.zzgbx != zzclb.zzgbz && this.zzgbx != zzclb.zzgca) {
                zzdri<InputStream> immediateFailedFuture = zzdqw.immediateFailedFuture(new zzclc(1));
                return immediateFailedFuture;
            } else if (this.zzgbr) {
                zzbaj<InputStream> zzbaj = this.zzdej;
                return zzbaj;
            } else {
                this.zzgbx = zzclb.zzgca;
                this.zzgbr = true;
                this.zzgbt = zzarj;
                this.zzgbu.checkAvailabilityAndConnect();
                this.zzdej.addListener(new zzckz(this), zzbab.zzdzw);
                zzbaj<InputStream> zzbaj2 = this.zzdej;
                return zzbaj2;
            }
        }
    }
}
