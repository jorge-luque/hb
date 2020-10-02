package p118io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: io.presage.core.lIllIlll */
public class lIllIlll {
    public SharedPreferences IIIIIIII;
    public SharedPreferences.Editor IIIIIIIl;
    public String IIIIIIlI;
    public long IIIIIIll;

    public lIllIlll(Context context, String str, String str2, long j) {
        this.IIIIIIlI = str2;
        this.IIIIIIll = j;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.IIIIIIII = sharedPreferences;
        this.IIIIIIIl = sharedPreferences.edit();
    }
}
