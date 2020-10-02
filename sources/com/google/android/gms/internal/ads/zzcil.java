package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.Clock;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcil {
    private final Clock zzbnt;

    public zzcil(Clock clock) {
        this.zzbnt = clock;
    }

    public final void zza(List<Object> list, String str, String str2, Object... objArr) {
        if (zzabn.zzcxb.get().booleanValue()) {
            long currentTimeMillis = this.zzbnt.currentTimeMillis();
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(currentTimeMillis);
                jsonWriter.name(ShareConstants.FEED_SOURCE_PARAM).value(str);
                jsonWriter.name(TapjoyConstants.TJC_SDK_TYPE_DEFAULT).value(str2);
                jsonWriter.name("components").beginArray();
                for (Object obj : list) {
                    jsonWriter.value(obj.toString());
                }
                jsonWriter.endArray();
                jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginArray();
                int length = objArr.length;
                for (int i = 0; i < length; i++) {
                    Object obj2 = objArr[i];
                    jsonWriter.value(obj2 != null ? obj2.toString() : null);
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException e) {
                zzazw.zzc("unable to log", e);
            }
            String valueOf = String.valueOf(stringWriter.toString());
            zzazw.zzfb(valueOf.length() != 0 ? "AD-DBG ".concat(valueOf) : new String("AD-DBG "));
        }
    }
}
