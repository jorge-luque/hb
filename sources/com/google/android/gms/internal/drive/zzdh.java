package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.zzk;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdh extends TaskApiCall<zzaw, DriveFile> {
    private final DriveFolder zzfj;
    private final MetadataChangeSet zzgc;
    private ExecutionOptions zzgd;
    private String zzge = null;
    private zzk zzgf;
    private final DriveContents zzo;

    zzdh(DriveFolder driveFolder, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions, String str) {
        this.zzfj = driveFolder;
        this.zzgc = metadataChangeSet;
        this.zzo = driveContents;
        this.zzgd = executionOptions;
        Preconditions.checkNotNull(driveFolder, "DriveFolder must not be null");
        Preconditions.checkNotNull(driveFolder.getDriveId(), "Folder's DriveId must not be null");
        Preconditions.checkNotNull(metadataChangeSet, "MetadataChangeSet must not be null");
        Preconditions.checkNotNull(executionOptions, "ExecutionOptions must not be null");
        zzk zzg = zzk.zzg(metadataChangeSet.getMimeType());
        this.zzgf = zzg;
        if (zzg != null && zzg.isFolder()) {
            throw new IllegalArgumentException("May not create folders using this method. Use DriveFolderManagerClient#createFolder() instead of mime type application/vnd.google-apps.folder");
        } else if (driveContents == null) {
        } else {
            if (!(driveContents instanceof zzbi)) {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            } else if (driveContents.getDriveId() != null) {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            } else if (driveContents.zzk()) {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzgd.zza(zzaw);
        MetadataChangeSet metadataChangeSet = this.zzgc;
        metadataChangeSet.zzq().zza(zzaw.getContext());
        int zza = zzbs.zza(this.zzo, this.zzgf);
        zzk zzk = this.zzgf;
        ((zzeo) zzaw.getService()).zza(new zzw(this.zzfj.getDriveId(), metadataChangeSet.zzq(), zza, (zzk == null || !zzk.zzbh()) ? 0 : 1, this.zzgd), (zzeq) new zzhj(taskCompletionSource));
    }
}
