package p118io.presage.ads;

import android.content.Context;
import android.util.Log;

/* renamed from: io.presage.ads.AdsSdkType */
public class AdsSdkType {
    public Context IIIIIIII;

    public AdsSdkType(Context context) {
        this.IIIIIIII = context;
    }

    public void setType(int i) {
        try {
            Class<?> cls = Class.forName("io.presage.common.SdkType");
            Object invoke = cls.getMethod("create", new Class[]{Context.class}).invoke((Object) null, new Object[]{this.IIIIIIII});
            cls.getMethod("setType", new Class[]{Integer.TYPE}).invoke(invoke, new Object[]{Integer.valueOf(i)});
        } catch (Exception e) {
            Log.e("Presage.Ads", "An error occurred while initializing", e);
        }
    }
}
