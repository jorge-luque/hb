package p118io.presage.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.HashSet;

/* renamed from: io.presage.core.IlIlIlII */
public class IlIlIlII extends IIllllll {
    public IlIlIlII(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 8;
    }

    public Object IIIIIIll() {
        return IlIlIlII.class;
    }

    public void IIIIIlIl() {
        HashSet hashSet = new HashSet();
        HashSet<String> IIIIIIll = IIIIlIll.IIIIIIll(this.IIIIIIlI);
        if (!IIIIIIll.isEmpty()) {
            try {
                for (PackageInfo next : IIIIlIll.IIIIIIlI(this.IIIIIIlI)) {
                    try {
                        hashSet.add(new IIlIIlII(next, (this.IIIIIIlI.getPackageManager().getApplicationInfo(next.packageName, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).flags & 129) != 0, IIIIIIll.contains(this.IIIIIIlI.getPackageName())));
                    } catch (PackageManager.NameNotFoundException e) {
                        IIIIIIII(e, 0);
                    }
                }
                if (!hashSet.isEmpty()) {
                    IIIIIIIl(new IIlIIlIl(C6325l1.IIIIIIII(), hashSet));
                }
            } catch (Exception e2) {
                IIIIIIII(e2, 1);
            }
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
    }
}
