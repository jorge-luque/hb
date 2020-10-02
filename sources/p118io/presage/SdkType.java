package p118io.presage;

import android.content.Context;
import p118io.presage.ads.AdsSdkType;
import p118io.presage.core.CoreSdkType;

/* renamed from: io.presage.SdkType */
public class SdkType {
    public Context IIIIIIII;

    public SdkType(Context context) {
        this.IIIIIIII = context;
    }

    public void setType(int i) {
        new CoreSdkType(this.IIIIIIII).setType(i);
        new AdsSdkType(this.IIIIIIII).setType(i);
    }
}
