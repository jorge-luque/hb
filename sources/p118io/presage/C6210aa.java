package p118io.presage;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: io.presage.aa */
public final class C6210aa {
    /* renamed from: a */
    public static final List<String> m20765a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return C6447ez.m21319a();
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }
}
