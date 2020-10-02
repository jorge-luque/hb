package com.google.android.gms.internal.ads;

import admost.sdk.base.AdMostExperimentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbdi implements zzaga<zzbbx> {
    private boolean zzegl;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzvj.zzpr();
            return zzazm.zzc(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzazw.zzfc(sb.toString());
            return i;
        }
    }

    private static void zza(zzbbk zzbbk, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbbk.zzde(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzazw.zzfc(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzbbk.zzdf(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbbk.zzdg(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbbk.zzdh(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbbk.zzdi(Integer.parseInt(str5));
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int i;
        zzbbx zzbbx = (zzbbx) obj;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (str == null) {
            zzazw.zzfc("Action missing from video GMSG.");
            return;
        }
        if (zzazw.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzazw.zzed(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzazw.zzfc("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbbx.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException unused) {
                zzazw.zzfc("Invalid color parameter in video GMSG.");
            }
        } else {
            if ("decoderProps".equals(str)) {
                String str3 = (String) map.get("mimeTypes");
                if (str3 == null) {
                    zzazw.zzfc("No MIME types specified for decoder properties inspection.");
                    zzbbk.zza(zzbbx, "missingMimeTypes");
                    return;
                }
                HashMap hashMap = new HashMap();
                for (String str4 : str3.split(",")) {
                    hashMap.put(str4, zzazk.zzeu(str4.trim()));
                }
                zzbbk.zza(zzbbx, (Map<String, List<Map<String, Object>>>) hashMap);
                return;
            }
            zzbbq zzze = zzbbx.zzze();
            if (zzze == null) {
                zzazw.zzfc("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = AdMostExperimentManager.EXPERIMENT_TYPE_NEW_INSTALL.equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzbbx.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                int min = Math.min(zza3, zzbbx.zzzm() - zza);
                int min2 = Math.min(zza4, zzbbx.zzzl() - zza2);
                try {
                    i = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException unused2) {
                    i = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzze.zzza() != null) {
                    zzze.zze(zza, zza2, min, min2);
                    return;
                }
                zzze.zza(zza, zza2, min, min2, i, parseBoolean, new zzbby((String) map.get("flags")));
                zzbbk zzza = zzze.zzza();
                if (zzza != null) {
                    zza(zzza, (Map<String, String>) map);
                    return;
                }
                return;
            }
            zzbfe zzzf = zzbbx.zzzf();
            if (zzzf != null) {
                if ("timeupdate".equals(str)) {
                    String str5 = (String) map.get(TJAdUnitConstants.String.VIDEO_CURRENT_TIME);
                    if (str5 == null) {
                        zzazw.zzfc("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzzf.zze(Float.parseFloat(str5));
                        return;
                    } catch (NumberFormatException unused3) {
                        String valueOf = String.valueOf(str5);
                        zzazw.zzfc(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                        return;
                    }
                } else if ("skip".equals(str)) {
                    zzzf.zzacj();
                    return;
                }
            }
            zzbbk zzza2 = zzze.zzza();
            if (zzza2 == null) {
                zzbbk.zzb(zzbbx);
            } else if (TJAdUnitConstants.String.CLICK.equals(str)) {
                Context context2 = zzbbx.getContext();
                int zza5 = zza(context2, map, "x", 0);
                int zza6 = zza(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                zzza2.zze(obtain);
                obtain.recycle();
            } else if (TJAdUnitConstants.String.VIDEO_CURRENT_TIME.equals(str)) {
                String str6 = (String) map.get("time");
                if (str6 == null) {
                    zzazw.zzfc("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzza2.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                } catch (NumberFormatException unused4) {
                    String valueOf2 = String.valueOf(str6);
                    zzazw.zzfc(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                }
            } else if (MessengerShareContentUtility.SHARE_BUTTON_HIDE.equals(str)) {
                zzza2.setVisibility(4);
            } else if ("load".equals(str)) {
                zzza2.zzhx();
            } else if ("loadControl".equals(str)) {
                zza(zzza2, (Map<String, String>) map);
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzza2.zzyu();
                } else {
                    zzza2.zzyv();
                }
            } else if ("pause".equals(str)) {
                zzza2.pause();
            } else if ("play".equals(str)) {
                zzza2.play();
            } else if ("show".equals(str)) {
                zzza2.setVisibility(0);
            } else if ("src".equals(str)) {
                String str7 = (String) map.get("src");
                String[] strArr = {str7};
                String str8 = (String) map.get("demuxed");
                if (str8 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str8);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            strArr2[i2] = jSONArray.getString(i2);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused5) {
                        String valueOf3 = String.valueOf(str8);
                        zzazw.zzfc(valueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(valueOf3) : new String("Malformed demuxed URL list for playback: "));
                        strArr = new String[]{str7};
                    }
                }
                zzza2.zzc(str7, strArr);
            } else if ("touchMove".equals(str)) {
                Context context3 = zzbbx.getContext();
                zzza2.zza((float) zza(context3, map, "dx", 0), (float) zza(context3, map, "dy", 0));
                if (!this.zzegl) {
                    zzbbx.zzun();
                    this.zzegl = true;
                }
            } else if ("volume".equals(str)) {
                String str9 = (String) map.get("volume");
                if (str9 == null) {
                    zzazw.zzfc("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzza2.setVolume(Float.parseFloat(str9));
                } catch (NumberFormatException unused6) {
                    String valueOf4 = String.valueOf(str9);
                    zzazw.zzfc(valueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
                }
            } else if ("watermark".equals(str)) {
                zzza2.zzyw();
            } else {
                String valueOf5 = String.valueOf(str);
                zzazw.zzfc(valueOf5.length() != 0 ? "Unknown video action: ".concat(valueOf5) : new String("Unknown video action: "));
            }
        }
    }
}
