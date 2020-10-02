package p118io.presage.core;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* renamed from: io.presage.core.lIllIIII */
public class lIllIIII {
    public static final String IIIIIIII = C6279a.IIIIIIlI;
    public static final String IIIIIIIl = C6279a.IIIIIlII;
    public static final String IIIIIIlI = C6279a.IIIIIllI;
    public static final String IIIIIIll = C6279a.IIIIIlIl;
    public static final String IIIIIlII = C6279a.IIIIIIll;
    public static final String IIIIIlIl = C6279a.IIIIIlll;
    public static final String IIIIIllI = C6279a.IIIIlIII;

    public static lIlIlllI IIIIIIII(InputStream inputStream, boolean z) {
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
            long currentTimeMillis = System.currentTimeMillis();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            long j = 0;
            long j2 = currentTimeMillis;
            long j3 = -1;
            long j4 = -1;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals(IIIIIIII)) {
                    str = jsonReader.nextString();
                } else if (nextName.equals(IIIIIlII)) {
                    str3 = jsonReader.nextString();
                } else if (nextName.equals(IIIIIlIl)) {
                    str2 = jsonReader.nextString();
                } else if (nextName.equals(IIIIIIIl)) {
                    j3 = jsonReader.nextLong();
                } else if (nextName.equals(IIIIIIll)) {
                    j4 = jsonReader.nextLong();
                } else if (nextName.equals(IIIIIIlI)) {
                    j = jsonReader.nextLong();
                } else if (nextName.equals(IIIIIllI)) {
                    j2 = jsonReader.nextLong();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            lIlIlllI lilillli = new lIlIlllI(str, j3, j, str2, j4, str3, j2);
            if (z) {
                inputStream.close();
            }
            return lilillli;
        } catch (Exception e) {
            lIIIIlIl.IIIIIIII(e, 0);
            return null;
        } catch (Throwable th) {
            if (z) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static JSONObject IIIIIIII(lIlIlllI lilillli) {
        if (lilillli == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IIIIIIII, lilillli.IIIIIIIl);
            jSONObject.put(IIIIIIIl, Long.valueOf(lilillli.IIIIIIlI));
            jSONObject.put(IIIIIIlI, Long.valueOf(lilillli.IIIIIIll));
            jSONObject.put(IIIIIlIl, lilillli.IIIIIlII);
            jSONObject.put(IIIIIIll, Long.valueOf(lilillli.IIIIIllI));
            jSONObject.put(IIIIIlII, lilillli.IIIIIlIl);
            jSONObject.put(IIIIIllI, Long.valueOf(lilillli.IIIIIIII));
            return jSONObject;
        } catch (Exception e) {
            lIIIIlIl.IIIIIIII(e, 0);
            return null;
        }
    }
}
