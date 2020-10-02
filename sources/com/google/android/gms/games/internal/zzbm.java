package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.internal.games.zza;
import com.google.android.gms.internal.games.zzd;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class zzbm extends zza implements zzbn {
    public zzbm() {
        super("com.google.android.gms.games.internal.IGamesCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 6001) {
            onP2PConnected(parcel.readString());
        } else if (i == 6002) {
            onP2PDisconnected(parcel.readString());
        } else if (i == 12011) {
            zzb((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
        } else if (i == 12012) {
            zzd(parcel.readInt(), parcel.readString());
        } else if (i == 13001) {
            zzan((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
        } else if (i == 13002) {
            zze(parcel.readInt());
        } else if (i == 19001) {
            zza(parcel.readInt(), (VideoCapabilities) zzd.zza(parcel, VideoCapabilities.CREATOR));
        } else if (i != 19002) {
            switch (i) {
                case 5001:
                    zza(parcel.readInt(), parcel.readString());
                    break;
                case 5002:
                    zza((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5003:
                    zzb(parcel.readInt(), parcel.readString());
                    break;
                case 5004:
                    zzc((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5005:
                    zza((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), (DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5006:
                    zzd((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5007:
                    zze((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5008:
                    zzf((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5009:
                    zzg((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5010:
                    zzh((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5011:
                    zzi((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                default:
                    switch (i) {
                        case 5016:
                            onSignOutComplete();
                            break;
                        case 5017:
                            zzk((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5018:
                            zzs((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5019:
                            zzt((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5020:
                            onLeftRoom(parcel.readInt(), parcel.readString());
                            break;
                        case 5021:
                            zzu((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5022:
                            zzv((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5023:
                            zzw((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5024:
                            zzx((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5025:
                            zzy((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5026:
                            zza((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5027:
                            zzb((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5028:
                            zzc((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5029:
                            zzd((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5030:
                            zze((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5031:
                            zzf((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5032:
                            onRealTimeMessageReceived((RealTimeMessage) zzd.zza(parcel, RealTimeMessage.CREATOR));
                            break;
                        case 5033:
                            zza(parcel.readInt(), parcel.readInt(), parcel.readString());
                            break;
                        case 5034:
                            zza(parcel.readInt(), parcel.readString(), zzd.zza(parcel));
                            break;
                        case 5035:
                            zzaa((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5036:
                            zzc(parcel.readInt());
                            break;
                        case 5037:
                            zzl((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5038:
                            zzz((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5039:
                            zzab((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5040:
                            zzd(parcel.readInt());
                            break;
                        case 9001:
                            zzj((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 11001:
                            zzc(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                            break;
                        case 12001:
                            zzag((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 14001:
                            zza((DataHolder[]) parcel.createTypedArray(DataHolder.CREATOR));
                            break;
                        case 15001:
                            zzao((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 17002:
                            zzf(parcel.readInt());
                            break;
                        case 19008:
                            zzg(parcel.readInt());
                            break;
                        case 19009:
                            zzh(parcel.readInt());
                            break;
                        case 19010:
                            zzi(parcel.readInt());
                            break;
                        case 20001:
                            zzap((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20002:
                            zzaq((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20003:
                            zzar((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20004:
                            zzas((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20005:
                            zzat((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20006:
                            zzau((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20007:
                            zzav((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20008:
                            zzaw((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20009:
                            zzax((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20012:
                            zzc((Status) zzd.zza(parcel, Status.CREATOR));
                            break;
                        case 20019:
                            onCaptureOverlayStateChanged(parcel.readInt());
                            break;
                        case 20020:
                            zze(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                            break;
                        case 23001:
                            zzl(parcel.readInt());
                            break;
                        case 23002:
                            zzj(parcel.readInt());
                            break;
                        case 23003:
                            zzk(parcel.readInt());
                            break;
                        default:
                            switch (i) {
                                case GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED:
                                    zzac((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE:
                                    zza(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                                    break;
                                case GamesStatusCodes.STATUS_QUEST_NOT_STARTED:
                                    zzn((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8004:
                                    zzo((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8005:
                                    zzp((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8006:
                                    zzq((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8007:
                                    zzc(parcel.readInt(), parcel.readString());
                                    break;
                                case 8008:
                                    zzr((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8009:
                                    onTurnBasedMatchRemoved(parcel.readString());
                                    break;
                                case 8010:
                                    onInvitationRemoved(parcel.readString());
                                    break;
                                default:
                                    switch (i) {
                                        case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED:
                                            zzm((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                            break;
                                        case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED:
                                            zzb(parcel.readString());
                                            break;
                                        case GamesActivityResultCodes.RESULT_LICENSE_FAILED:
                                            zzad((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                            break;
                                        case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED:
                                            zzae((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                            break;
                                        case GamesActivityResultCodes.RESULT_LEFT_ROOM:
                                            zzb(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                                            break;
                                        case GamesActivityResultCodes.RESULT_NETWORK_FAILURE:
                                            zzaf((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                            break;
                                        default:
                                            switch (i) {
                                                case 12004:
                                                    zza((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), (Contents) zzd.zza(parcel, Contents.CREATOR));
                                                    break;
                                                case 12005:
                                                    zzah((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                case 12006:
                                                    zzai((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                case 12007:
                                                    zzaj((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                case 12008:
                                                    zzam((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 12014:
                                                            zzak((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                            break;
                                                        case 12015:
                                                            zzd(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                                                            break;
                                                        case 12016:
                                                            zzal((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                            break;
                                                        case 12017:
                                                            zza((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.readString(), (Contents) zzd.zza(parcel, Contents.CREATOR), (Contents) zzd.zza(parcel, Contents.CREATOR), (Contents) zzd.zza(parcel, Contents.CREATOR));
                                                            break;
                                                        default:
                                                            return false;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            zza(parcel.readInt(), zzd.zza(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
