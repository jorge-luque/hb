package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzape extends RemoteCreator<zzaph> {
    public zzape() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzaph) {
            return (zzaph) queryLocalInterface;
        }
        return new zzapk(iBinder);
    }

    public final zzapg zzc(Activity activity) {
        try {
            IBinder zzae = ((zzaph) getRemoteCreatorInstance(activity)).zzae(ObjectWrapper.wrap(activity));
            if (zzae == null) {
                return null;
            }
            IInterface queryLocalInterface = zzae.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzapg) {
                return (zzapg) queryLocalInterface;
            }
            return new zzapi(zzae);
        } catch (RemoteException e) {
            zzazw.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            zzazw.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}
