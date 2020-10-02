package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.common.util.IOUtils;
import com.tapjoy.TJAdUnitConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdgy {
    public final List<zzdgo> zzguo;
    public final zzdgq zzgup;
    public final List<zzdgx> zzguq;

    private zzdgy(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        List<zzdgo> emptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzdgq zzdgq = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        emptyList = new ArrayList<>();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            emptyList.add(new zzdgo(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (nextName2.equals("common")) {
                        zzdgq = new zzdgq(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    Map<String, String> map = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if (TJAdUnitConstants.String.VIDEO_INFO.equals(nextName3)) {
                            map = zzayu.zzb(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList.add(new zzdgx(str, map));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzguq = arrayList;
        this.zzguo = emptyList;
        this.zzgup = zzdgq == null ? new zzdgq(new JsonReader(new StringReader("{}"))) : zzdgq;
    }

    public static zzdgy zza(Reader reader) throws zzdgp {
        try {
            zzdgy zzdgy = new zzdgy(new JsonReader(reader));
            IOUtils.closeQuietly((Closeable) reader);
            return zzdgy;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzdgp("unable to parse ServerResponse", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th;
        }
    }
}
