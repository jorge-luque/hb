package p118io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: io.presage.core.CoreSdkType */
public class CoreSdkType {
    public static final String IIIIIIlI = lllIllll.IIIIIIII;
    public static final String IIIIIIll = lllIllll.IIIIIIIl;
    public Integer IIIIIIII;
    public SharedPreferences IIIIIIIl;

    public CoreSdkType(Context context) {
        this.IIIIIIIl = context.getSharedPreferences(IIIIIIlI, 0);
    }

    public int getType() {
        if (this.IIIIIIII == null) {
            this.IIIIIIII = Integer.valueOf(this.IIIIIIIl.getInt(IIIIIIll, 0));
        }
        return this.IIIIIIII.intValue();
    }

    public void setType(int i) {
        this.IIIIIIII = Integer.valueOf(i);
        this.IIIIIIIl.edit().putInt(IIIIIIll, this.IIIIIIII.intValue()).apply();
    }
}
