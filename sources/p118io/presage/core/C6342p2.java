package p118io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: io.presage.core.p2 */
public abstract class C6342p2 extends C6350r2 {
    public ComponentName IIIIIIll = IIIIIIll();

    public C6342p2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
    }

    public void IIIIIIIl() {
        PackageManager packageManager = this.IIIIIIII.getPackageManager();
        if (packageManager.getComponentEnabledSetting(this.IIIIIIll) != 2) {
            packageManager.setComponentEnabledSetting(this.IIIIIIll, 2, 1);
        }
    }

    public void IIIIIIlI() {
        PackageManager packageManager = this.IIIIIIII.getPackageManager();
        if (packageManager.getComponentEnabledSetting(this.IIIIIIll) != 1) {
            packageManager.setComponentEnabledSetting(this.IIIIIIll, 1, 1);
        }
    }

    public abstract ComponentName IIIIIIll();
}
