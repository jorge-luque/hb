package p118io.presage;

import android.content.SharedPreferences;

/* renamed from: io.presage.ah */
public final class C6217ah {
    /* renamed from: a */
    public static final String m20780a(SharedPreferences sharedPreferences, String str, String str2) {
        String string = sharedPreferences.getString(str, str2);
        return string == null ? str2 : string;
    }
}
