package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzckr extends zzckt {
    public zzckr(Context context) {
        this.zzgbu = new zzaqr(context, zzq.zzlk().zzxx(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgbs) {
                this.zzgbs = true;
                try {
                    this.zzgbu.zzus().zza(this.zzgbt, (zzard) new zzcks(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdej.setException(new zzclc(0));
                } catch (Throwable th) {
                    zzq.zzla().zza(th, "RemoteAdRequestClientTask.onConnected");
                    this.zzdej.setException(new zzclc(0));
                }
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzazw.zzed("Cannot connect to remote service, fallback to local instance.");
        this.zzdej.setException(new zzclc(0));
    }

    public final zzdri<InputStream> zzg(zzarj zzarj) {
        synchronized (this.mLock) {
            if (this.zzgbr) {
                zzbaj<InputStream> zzbaj = this.zzdej;
                return zzbaj;
            }
            this.zzgbr = true;
            this.zzgbt = zzarj;
            this.zzgbu.checkAvailabilityAndConnect();
            this.zzdej.addListener(new zzckq(this), zzbab.zzdzw);
            zzbaj<InputStream> zzbaj2 = this.zzdej;
            return zzbaj2;
        }
    }
}
