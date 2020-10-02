package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface zzbr extends IInterface {
    Bundle getConnectionHint() throws RemoteException;

    int zza(zzbn zzbn, byte[] bArr, String str, String str2) throws RemoteException;

    Intent zza(int i, int i2, boolean z) throws RemoteException;

    Intent zza(PlayerEntity playerEntity) throws RemoteException;

    Intent zza(RoomEntity roomEntity, int i) throws RemoteException;

    Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException;

    void zza(long j) throws RemoteException;

    void zza(IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(Contents contents) throws RemoteException;

    void zza(zzbn zzbn) throws RemoteException;

    void zza(zzbn zzbn, int i) throws RemoteException;

    void zza(zzbn zzbn, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException;

    void zza(zzbn zzbn, int i, boolean z, boolean z2) throws RemoteException;

    void zza(zzbn zzbn, int i, int[] iArr) throws RemoteException;

    void zza(zzbn zzbn, long j) throws RemoteException;

    void zza(zzbn zzbn, Bundle bundle, int i, int i2) throws RemoteException;

    void zza(zzbn zzbn, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException;

    void zza(zzbn zzbn, IBinder iBinder, String str, boolean z, long j) throws RemoteException;

    void zza(zzbn zzbn, String str) throws RemoteException;

    void zza(zzbn zzbn, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void zza(zzbn zzbn, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(zzbn zzbn, String str, int i, boolean z, boolean z2) throws RemoteException;

    void zza(zzbn zzbn, String str, long j, String str2) throws RemoteException;

    void zza(zzbn zzbn, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(zzbn zzbn, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    void zza(zzbn zzbn, String str, String str2) throws RemoteException;

    void zza(zzbn zzbn, String str, String str2, int i, int i2) throws RemoteException;

    void zza(zzbn zzbn, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    void zza(zzbn zzbn, String str, boolean z) throws RemoteException;

    void zza(zzbn zzbn, String str, boolean z, int i) throws RemoteException;

    void zza(zzbn zzbn, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException;

    void zza(zzbn zzbn, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException;

    void zza(zzbn zzbn, boolean z) throws RemoteException;

    void zza(zzbn zzbn, boolean z, String[] strArr) throws RemoteException;

    void zza(zzbp zzbp, long j) throws RemoteException;

    void zza(String str, int i) throws RemoteException;

    void zza(String str, zzbn zzbn) throws RemoteException;

    int zzb(byte[] bArr, String str, String[] strArr) throws RemoteException;

    Intent zzb(String str, int i, int i2) throws RemoteException;

    void zzb(long j) throws RemoteException;

    void zzb(zzbn zzbn) throws RemoteException;

    void zzb(zzbn zzbn, int i) throws RemoteException;

    void zzb(zzbn zzbn, long j) throws RemoteException;

    void zzb(zzbn zzbn, String str) throws RemoteException;

    void zzb(zzbn zzbn, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void zzb(zzbn zzbn, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzb(zzbn zzbn, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzb(zzbn zzbn, String str, boolean z) throws RemoteException;

    void zzb(zzbn zzbn, boolean z) throws RemoteException;

    void zzb(String str, int i) throws RemoteException;

    String zzbc() throws RemoteException;

    Intent zzbi() throws RemoteException;

    Intent zzbk() throws RemoteException;

    Intent zzbl() throws RemoteException;

    Intent zzbm() throws RemoteException;

    Intent zzbr() throws RemoteException;

    Intent zzbt() throws RemoteException;

    int zzbv() throws RemoteException;

    String zzbx() throws RemoteException;

    int zzbz() throws RemoteException;

    Intent zzc(int i, int i2, boolean z) throws RemoteException;

    void zzc(long j) throws RemoteException;

    void zzc(zzbn zzbn) throws RemoteException;

    void zzc(zzbn zzbn, long j) throws RemoteException;

    void zzc(zzbn zzbn, String str) throws RemoteException;

    void zzc(zzbn zzbn, boolean z) throws RemoteException;

    int zzcb() throws RemoteException;

    int zzcd() throws RemoteException;

    boolean zzch() throws RemoteException;

    void zzcl() throws RemoteException;

    String zzcm() throws RemoteException;

    DataHolder zzcn() throws RemoteException;

    DataHolder zzco() throws RemoteException;

    Intent zzcp() throws RemoteException;

    void zzd(long j) throws RemoteException;

    void zzd(zzbn zzbn) throws RemoteException;

    void zzd(zzbn zzbn, String str) throws RemoteException;

    void zzd(zzbn zzbn, boolean z) throws RemoteException;

    void zzd(String str, int i) throws RemoteException;

    void zze(zzbn zzbn, String str) throws RemoteException;

    void zze(zzbn zzbn, boolean z) throws RemoteException;

    void zze(String str) throws RemoteException;

    void zzf(zzbn zzbn, String str) throws RemoteException;

    void zzf(zzbn zzbn, boolean z) throws RemoteException;

    void zzg(zzbn zzbn, String str) throws RemoteException;

    void zzn(int i) throws RemoteException;
}
