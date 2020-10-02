package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games.zzb;
import com.google.android.gms.internal.games.zzd;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzbq extends zzb implements zzbr {
    zzbq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    public final Bundle getConnectionHint() throws RemoteException {
        Parcel zza = zza(5004, zza());
        Bundle bundle = (Bundle) zzd.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final void zza(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(5001, zza);
    }

    public final void zzb(zzbn zzbn, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzd.writeBoolean(zza, z);
        zzb(5020, zza);
    }

    public final String zzbc() throws RemoteException {
        Parcel zza = zza(5007, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final Intent zzbi() throws RemoteException {
        Parcel zza = zza(GamesStatusCodes.STATUS_VIDEO_STORAGE_ERROR, zza());
        Intent intent = (Intent) zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zzbk() throws RemoteException {
        Parcel zza = zza(9005, zza());
        Intent intent = (Intent) zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zzbl() throws RemoteException {
        Parcel zza = zza(GamesStatusCodes.STATUS_VIDEO_ALREADY_CAPTURING, zza());
        Intent intent = (Intent) zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zzbm() throws RemoteException {
        Parcel zza = zza(9007, zza());
        Intent intent = (Intent) zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zzbr() throws RemoteException {
        Parcel zza = zza(9010, zza());
        Intent intent = (Intent) zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final Intent zzbt() throws RemoteException {
        Parcel zza = zza(9012, zza());
        Intent intent = (Intent) zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final int zzbv() throws RemoteException {
        Parcel zza = zza(9019, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final String zzbx() throws RemoteException {
        Parcel zza = zza(5003, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final int zzbz() throws RemoteException {
        Parcel zza = zza(8024, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final void zzc(zzbn zzbn, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzb(8006, zza);
    }

    public final int zzcb() throws RemoteException {
        Parcel zza = zza(12035, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final int zzcd() throws RemoteException {
        Parcel zza = zza(12036, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final boolean zzch() throws RemoteException {
        Parcel zza = zza(22030, zza());
        boolean zza2 = zzd.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zzcl() throws RemoteException {
        zzb(5006, zza());
    }

    public final String zzcm() throws RemoteException {
        Parcel zza = zza(5012, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final DataHolder zzcn() throws RemoteException {
        Parcel zza = zza(5013, zza());
        DataHolder dataHolder = (DataHolder) zzd.zza(zza, DataHolder.CREATOR);
        zza.recycle();
        return dataHolder;
    }

    public final DataHolder zzco() throws RemoteException {
        Parcel zza = zza(5502, zza());
        DataHolder dataHolder = (DataHolder) zzd.zza(zza, DataHolder.CREATOR);
        zza.recycle();
        return dataHolder;
    }

    public final Intent zzcp() throws RemoteException {
        Parcel zza = zza(19002, zza());
        Intent intent = (Intent) zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final void zzd(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzb(5028, zza);
    }

    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE, zza);
    }

    public final void zzf(zzbn zzbn, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzb(8014, zza);
    }

    public final void zzg(zzbn zzbn, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzb(12020, zza);
    }

    public final void zzn(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzb(5036, zza);
    }

    public final void zza(zzbn zzbn) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzb(5002, zza);
    }

    public final void zze(zzbn zzbn, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzb(8010, zza);
    }

    public final void zzc(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(8013, zza);
    }

    public final void zzd(zzbn zzbn, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzb(8009, zza);
    }

    public final void zzf(zzbn zzbn, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzd.writeBoolean(zza, z);
        zzb(17001, zza);
    }

    public final void zza(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeStrongBinder(iBinder);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(5005, zza);
    }

    public final void zzc(zzbn zzbn, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzd.writeBoolean(zza, z);
        zzb(8027, zza);
    }

    public final void zze(zzbn zzbn, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzd.writeBoolean(zza, z);
        zzb(12016, zza);
    }

    public final void zzb(zzbn zzbn, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(5024, zza);
    }

    public final void zzd(zzbn zzbn, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzd.writeBoolean(zza, z);
        zzb(12002, zza);
    }

    public final void zza(zzbn zzbn, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeInt(i);
        zzd.writeBoolean(zza, z);
        zzd.writeBoolean(zza, z2);
        zzb(5015, zza);
    }

    public final Intent zzc(int i, int i2, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zzd.writeBoolean(zza, z);
        Parcel zza2 = zza(GamesStatusCodes.STATUS_VIDEO_OUT_OF_DISK_SPACE, zza);
        Intent intent = (Intent) zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final void zzd(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(22027, zza);
    }

    public final void zzb(zzbn zzbn) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzb(5026, zza);
    }

    public final void zzd(zzbn zzbn) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzb(22028, zza);
    }

    public final void zza(zzbn zzbn, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzd.writeBoolean(zza, z);
        zzb(5019, zza);
    }

    public final void zzb(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzb(5029, zza);
    }

    public final void zzc(zzbn zzbn) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzb(21007, zza);
    }

    public final void zzb(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(5059, zza);
    }

    public final void zzc(zzbn zzbn, long j) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeLong(j);
        zzb(22026, zza);
    }

    public final void zza(zzbn zzbn, Bundle bundle, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzd.zza(zza, (Parcelable) bundle);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzb(5021, zza);
    }

    public final int zzb(byte[] bArr, String str, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeByteArray(bArr);
        zza.writeString(str);
        zza.writeStringArray(strArr);
        Parcel zza2 = zza(5034, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    public final void zza(zzbn zzbn, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(5023, zza);
    }

    public final void zzb(zzbn zzbn, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzd.writeBoolean(zza, z);
        zzb(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, zza);
    }

    public final void zzb(zzbn zzbn, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(7003, zza);
    }

    public final void zza(zzbn zzbn, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(5025, zza);
    }

    public final void zzb(zzbn zzbn, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzb(8005, zza);
    }

    public final void zza(zzbn zzbn, long j) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeLong(j);
        zzb(5058, zza);
    }

    public final void zzb(zzbn zzbn, long j) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeLong(j);
        zzb(8012, zza);
    }

    public final void zza(zzbn zzbn, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeStrongBinder(iBinder);
        zza.writeInt(i);
        zza.writeStringArray(strArr);
        zzd.zza(zza, (Parcelable) bundle);
        zzd.writeBoolean(zza, false);
        zza.writeLong(j);
        zzb(5030, zza);
    }

    public final void zzb(zzbn zzbn, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzd.writeBoolean(zza, z);
        zzb(13006, zza);
    }

    public final Intent zzb(String str, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        Parcel zza2 = zza(18001, zza);
        Intent intent = (Intent) zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final void zza(zzbn zzbn, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeStrongBinder(iBinder);
        zza.writeString(str);
        zzd.writeBoolean(zza, false);
        zza.writeLong(j);
        zzb(5031, zza);
    }

    public final void zzb(zzbn zzbn, int i) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeInt(i);
        zzb(22016, zza);
    }

    public final void zza(zzbn zzbn, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzb(5032, zza);
    }

    public final int zza(zzbn zzbn, byte[] bArr, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeByteArray(bArr);
        zza.writeString(str);
        zza.writeString(str2);
        Parcel zza2 = zza(5033, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    public final void zza(zzbn zzbn, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzd.writeBoolean(zza, z);
        zzb(6001, zza);
    }

    public final void zza(zzbn zzbn, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzd.writeBoolean(zza, z);
        zzb(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, zza);
    }

    public final void zza(zzbn zzbn, String str, long j, String str2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeLong(j);
        zza.writeString(str2);
        zzb(7002, zza);
    }

    public final void zza(zzbn zzbn, String str, String str2, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzb(GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED, zza);
    }

    public final void zza(zzbn zzbn, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeStringArray(strArr);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(8004, zza);
    }

    public final void zza(zzbn zzbn, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeByteArray(bArr);
        zza.writeString(str2);
        zza.writeTypedArray(participantResultArr, 0);
        zzb(8007, zza);
    }

    public final void zza(zzbn zzbn, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeByteArray(bArr);
        zza.writeTypedArray(participantResultArr, 0);
        zzb(8008, zza);
    }

    public final void zza(zzbn zzbn, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeString(str2);
        zzb(8011, zza);
    }

    public final Intent zza(int i, int i2, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zzd.writeBoolean(zza, z);
        Parcel zza2 = zza(9008, zza);
        Intent intent = (Intent) zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final Intent zza(RoomEntity roomEntity, int i) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) roomEntity);
        zza.writeInt(i);
        Parcel zza2 = zza(9011, zza);
        Intent intent = (Intent) zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final void zza(zzbn zzbn, String str, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeInt(i);
        zzd.writeBoolean(zza, z);
        zzd.writeBoolean(zza, z2);
        zzb(9020, zza);
    }

    public final void zza(zzbn zzbn, int i) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeInt(i);
        zzb(10016, zza);
    }

    public final void zza(zzbn zzbn, int i, int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeInt(i);
        zza.writeIntArray(iArr);
        zzb(10018, zza);
    }

    public final Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.writeBoolean(zza, z);
        zzd.writeBoolean(zza, z2);
        zza.writeInt(i);
        Parcel zza2 = zza(12001, zza);
        Intent intent = (Intent) zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final void zza(zzbn zzbn, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) snapshotMetadataChangeEntity);
        zzd.zza(zza, (Parcelable) contents);
        zzb(12007, zza);
    }

    public final void zza(Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) contents);
        zzb(12019, zza);
    }

    public final void zza(zzbn zzbn, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (Parcelable) snapshotMetadataChangeEntity);
        zzd.zza(zza, (Parcelable) contents);
        zzb(12033, zza);
    }

    public final void zza(zzbn zzbn, boolean z, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zzd.writeBoolean(zza, z);
        zza.writeStringArray(strArr);
        zzb(12031, zza);
    }

    public final void zza(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzb(12017, zza);
    }

    public final void zza(zzbn zzbn, String str, boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbn);
        zza.writeString(str);
        zzd.writeBoolean(zza, z);
        zza.writeInt(i);
        zzb(15001, zza);
    }

    public final void zza(zzbp zzbp, long j) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzbp);
        zza.writeLong(j);
        zzb(15501, zza);
    }

    public final Intent zza(PlayerEntity playerEntity) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) playerEntity);
        Parcel zza2 = zza(15503, zza);
        Intent intent = (Intent) zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    public final void zza(String str, zzbn zzbn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzbn);
        zzb(20001, zza);
    }
}
