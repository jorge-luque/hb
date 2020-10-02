package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzazq {
    private static boolean enabled = false;
    private static Object lock = new Object();
    private static Clock zzbnt = DefaultClock.getInstance();
    private static boolean zzdzh = false;
    private static final Set<String> zzdzi = new HashSet(Arrays.asList(new String[0]));
    private final List<String> zzdzj;

    public zzazq() {
        this((String) null);
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (lock) {
            z = zzdzh && enabled;
        }
        return z;
    }

    public static void zzar(boolean z) {
        synchronized (lock) {
            zzdzh = true;
            enabled = z;
        }
    }

    private final void zzb(String str, String str2, Map<String, ?> map, byte[] bArr) {
        zza("onNetworkRequest", (zzazt) new zzazp(str, str2, map, bArr));
    }

    public static boolean zzbq(Context context) {
        if (Build.VERSION.SDK_INT < 17 || !zzabi.zzcwh.get().booleanValue()) {
            return false;
        }
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            zzazw.zzd("Fail to determine debug setting.", e);
            return false;
        }
    }

    private final void zzey(String str) {
        zza("onNetworkRequestError", (zzazt) new zzazu(str));
    }

    private static synchronized void zzez(String str) {
        synchronized (zzazq.class) {
            zzazw.zzfb("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzazw.zzfb(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzazw.zzfb("GMA Debug FINISH");
        }
    }

    public static void zzyg() {
        synchronized (lock) {
            zzdzh = false;
            enabled = false;
            zzazw.zzfc("Ad debug logging enablement is out of date.");
        }
    }

    public static boolean zzyh() {
        boolean z;
        synchronized (lock) {
            z = zzdzh;
        }
        return z;
    }

    public final void zza(HttpURLConnection httpURLConnection, byte[] bArr) {
        HashMap hashMap;
        if (isEnabled()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    public final void zzex(String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(byte[] bArr) {
        zza("onNetworkResponseBody", (zzazt) new zzazr(bArr));
    }

    public zzazq(String str) {
        List<String> list;
        if (!isEnabled()) {
            list = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            list = Arrays.asList(strArr);
        }
        this.zzdzj = list;
    }

    private final void zzb(Map<String, ?> map, int i) {
        zza("onNetworkResponse", (zzazt) new zzazs(i, map));
    }

    public final void zza(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String str = null;
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String valueOf = String.valueOf(e.getMessage());
                    zzazw.zzfc(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzey(str);
            }
        }
    }

    public final void zza(Map<String, ?> map, int i) {
        if (isEnabled()) {
            zzb(map, i);
            if (i < 200 || i >= 300) {
                zzey((String) null);
            }
        }
    }

    private static void zza(JsonWriter jsonWriter, Map<String, ?> map) throws IOException {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                String str = (String) next.getKey();
                if (!zzdzi.contains(str)) {
                    if (!(next.getValue() instanceof List)) {
                        if (!(next.getValue() instanceof String)) {
                            zzazw.zzfa("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value((String) next.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String value : (List) next.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(str);
                            jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value(value);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    private final void zza(String str, zzazt zzazt) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zzbnt.currentTimeMillis());
            jsonWriter.name(TapjoyConstants.TJC_SDK_TYPE_DEFAULT).value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.zzdzj) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            zzazt.zzb(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzazw.zzc("unable to log", e);
        }
        zzez(stringWriter.toString());
    }

    static final /* synthetic */ void zza(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        if (str != null) {
            jsonWriter.name(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION).value(str);
        }
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(encode);
        } else {
            String zzev = zzazm.zzev(encode);
            if (zzev != null) {
                jsonWriter.name("bodydigest").value(zzev);
            }
        }
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(ShareConstants.MEDIA_URI).value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }
}
