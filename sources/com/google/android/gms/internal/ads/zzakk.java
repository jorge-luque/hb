package com.google.android.gms.internal.ads;

import com.loopj.android.http.C4250c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzakk {
    private static final Charset UTF_8 = Charset.forName(C4250c.DEFAULT_CHARSET);
    public static final zzakl<JSONObject> zzddu = new zzakm();
    public static final zzakj<InputStream> zzddv = zzakn.zzddw;

    static final /* synthetic */ InputStream zze(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
