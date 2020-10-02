package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbdu implements zzaga<zzbbx> {
    private static Integer zzb(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzazw.zzfc(sb.toString());
            return null;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdl zzbdl;
        zzbbx zzbbx = (zzbbx) obj;
        if (zzazw.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzazw.zzed(sb.toString());
        }
        zzq.zzls();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        String valueOf2 = String.valueOf(str2);
                        zzazw.zzfc(valueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(valueOf2) : new String("Malformed demuxed URL list for precache: "));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (zzbdm.zzd(zzbbx) != null) {
                    zzazw.zzfc("Precache task is already running.");
                    return;
                } else if (zzbbx.zzzi() == null) {
                    zzazw.zzfc("Precache requires a dependency provider.");
                    return;
                } else {
                    zzbby zzbby = new zzbby((String) map.get("flags"));
                    Integer zzb = zzb(map, "player");
                    if (zzb == null) {
                        zzb = 0;
                    }
                    zzbdl = zzbbx.zzzi().zzblp.zza(zzbbx, zzb.intValue(), (String) null, zzbby);
                    new zzbdk(zzbbx, zzbdl, str, strArr).zzwn();
                }
            } else {
                zzbdk zzd = zzbdm.zzd(zzbbx);
                if (zzd != null) {
                    zzbdl = zzd.zzegn;
                } else {
                    zzazw.zzfc("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb2 = zzb(map, "minBufferMs");
            if (zzb2 != null) {
                zzbdl.zzde(zzb2.intValue());
            }
            Integer zzb3 = zzb(map, "maxBufferMs");
            if (zzb3 != null) {
                zzbdl.zzdf(zzb3.intValue());
            }
            Integer zzb4 = zzb(map, "bufferForPlaybackMs");
            if (zzb4 != null) {
                zzbdl.zzdg(zzb4.intValue());
            }
            Integer zzb5 = zzb(map, "bufferForPlaybackAfterRebufferMs");
            if (zzb5 != null) {
                zzbdl.zzdh(zzb5.intValue());
            }
        } else if (!zzbdm.zzc(zzbbx)) {
            zzazw.zzfc("Precache abort but no precache task running.");
        }
    }
}
