package com.google.android.gms.internal.drive;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzd;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.events.zzl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public final class zzaw extends GmsClient<zzeo> {
    private final String zzeb;
    protected final boolean zzec;
    private volatile DriveId zzed;
    private volatile DriveId zzee;
    private volatile boolean zzef = false;
    @GuardedBy("changeEventCallbackMap")
    @VisibleForTesting
    private final Map<DriveId, Map<ChangeListener, zzee>> zzeg = new HashMap();
    @GuardedBy("changesAvailableEventCallbackMap")
    @VisibleForTesting
    private final Map<zzd, zzee> zzeh = new HashMap();
    @GuardedBy("uploadProgressEventCallbackMap")
    @VisibleForTesting
    private final Map<DriveId, Map<zzl, zzee>> zzei = new HashMap();
    @GuardedBy("pinnedDownloadProgressEventCallbackMap")
    @VisibleForTesting
    private final Map<DriveId, Map<zzl, zzee>> zzej = new HashMap();
    private final Bundle zzz;

    public zzaw(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzeb = clientSettings.getRealClientPackageName();
        this.zzz = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        int size = queryIntentServices.size();
        if (size == 0) {
            this.zzec = false;
        } else if (size == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            if (serviceInfo.exported) {
                this.zzec = true;
                return;
            }
            String str = serviceInfo.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 60);
            sb.append("Drive event service ");
            sb.append(str);
            sb.append(" must be exported in AndroidManifest.xml");
            throw new IllegalStateException(sb.toString());
        } else {
            String action = intent.getAction();
            StringBuilder sb2 = new StringBuilder(String.valueOf(action).length() + 72);
            sb2.append("AndroidManifest.xml can only define one service that handles the ");
            sb2.append(action);
            sb2.append(" action");
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
        if (queryLocalInterface instanceof zzeo) {
            return (zzeo) queryLocalInterface;
        }
        return new zzep(iBinder);
    }

    public final void disconnect() {
        if (isConnected()) {
            try {
                ((zzeo) getService()).zza(new zzad());
            } catch (RemoteException unused) {
            }
        }
        super.disconnect();
        synchronized (this.zzeg) {
            this.zzeg.clear();
        }
        synchronized (this.zzeh) {
            this.zzeh.clear();
        }
        synchronized (this.zzei) {
            this.zzei.clear();
        }
        synchronized (this.zzej) {
            this.zzej.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        String packageName = getContext().getPackageName();
        Preconditions.checkNotNull(packageName);
        Preconditions.checkState(!getClientSettings().getAllRequestedScopes().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzeb)) {
            bundle.putString("proxy_package_name", this.zzeb);
        }
        bundle.putAll(this.zzz);
        return bundle;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    /* access modifiers changed from: protected */
    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(zzaw.class.getClassLoader());
            this.zzed = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzee = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            this.zzef = true;
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    public final boolean requiresAccount() {
        return true;
    }

    public final boolean requiresSignIn() {
        return !getContext().getPackageName().equals(this.zzeb) || !UidVerifier.isGooglePlayServicesUid(getContext(), Process.myUid());
    }

    /* access modifiers changed from: package-private */
    public final PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        Preconditions.checkArgument(zzj.zza(1, driveId));
        Preconditions.checkNotNull(changeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkState(isConnected(), "Client must be connected");
        synchronized (this.zzeg) {
            Map map = this.zzeg.get(driveId);
            if (map == null) {
                map = new HashMap();
                this.zzeg.put(driveId, map);
            }
            zzee zzee2 = (zzee) map.get(changeListener);
            if (zzee2 == null) {
                zzee2 = new zzee(getLooper(), getContext(), 1, changeListener);
                map.put(changeListener, zzee2);
            } else if (zzee2.zzg(1)) {
                zzat zzat = new zzat(googleApiClient, Status.RESULT_SUCCESS);
                return zzat;
            }
            zzee2.zzf(1);
            BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzax(this, googleApiClient, new zzj(1, driveId), zzee2));
            return execute;
        }
    }

    public final DriveId zzae() {
        return this.zzed;
    }

    public final DriveId zzaf() {
        return this.zzee;
    }

    public final boolean zzag() {
        return this.zzef;
    }

    public final boolean zzah() {
        return this.zzec;
    }

    /* access modifiers changed from: package-private */
    public final PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        Preconditions.checkArgument(zzj.zza(1, driveId));
        Preconditions.checkState(isConnected(), "Client must be connected");
        Preconditions.checkNotNull(changeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.zzeg) {
            Map map = this.zzeg.get(driveId);
            if (map == null) {
                zzat zzat = new zzat(googleApiClient, Status.RESULT_SUCCESS);
                return zzat;
            }
            zzee zzee2 = (zzee) map.remove(changeListener);
            if (zzee2 == null) {
                zzat zzat2 = new zzat(googleApiClient, Status.RESULT_SUCCESS);
                return zzat2;
            }
            if (map.isEmpty()) {
                this.zzeg.remove(driveId);
            }
            BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzay(this, googleApiClient, new zzgs(driveId, 1), zzee2));
            return execute;
        }
    }
}
