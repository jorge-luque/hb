package p118io.presage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* renamed from: io.presage.bp */
public final class C6252bp {

    /* renamed from: a */
    public static final CamembertauCalvados f16836a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final SharedPreferences f16837b;

    /* renamed from: c */
    private final Context f16838c;

    /* renamed from: io.presage.bp$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public C6252bp(Context context) {
        this.f16838c = context;
        this.f16837b = context.getSharedPreferences("PERSISTED_SETS", 0);
    }

    /* renamed from: a */
    public final boolean mo34812a(String str) {
        Set<String> stringSet = this.f16837b.getStringSet("shortcutIdentifierList", (Set) null);
        if (stringSet != null) {
            return stringSet.contains(str);
        }
        return false;
    }

    /* renamed from: b */
    public final String mo34813b(String str) {
        String string = this.f16837b.getString("argsJson:".concat(String.valueOf(str)), "");
        return string == null ? "" : string;
    }

    /* renamed from: c */
    public final boolean mo34814c(String str) {
        String string = this.f16837b.getString("argsJson:".concat(String.valueOf(str)), "");
        return string != null && string.length() > 0;
    }

    /* renamed from: a */
    public final String mo34811a(String str, String str2) {
        this.f16837b.edit().putString("argsJson:".concat(String.valueOf(str)), str2).apply();
        return str;
    }
}
