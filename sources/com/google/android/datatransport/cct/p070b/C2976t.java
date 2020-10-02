package com.google.android.datatransport.cct.p070b;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.Reader;

/* renamed from: com.google.android.datatransport.cct.b.t */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public abstract class C2976t {
    /* renamed from: a */
    public static C2976t m9830a(Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (!jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    return new C2959i(Long.parseLong(jsonReader.nextString()));
                } else {
                    C2959i iVar = new C2959i(jsonReader.nextLong());
                    jsonReader.close();
                    return iVar;
                }
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    /* renamed from: a */
    public abstract long mo12925a();
}
