package p118io.presage.core;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.facebook.places.model.PlaceFields;

/* renamed from: io.presage.core.IlIIlllI */
public class IlIIlllI extends IIllllll {
    public IlIIlllI(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 18;
    }

    public Object IIIIIIll() {
        return IlIIlllI.class;
    }

    public void IIIIIlIl() {
        TelephonyManager telephonyManager = (TelephonyManager) this.IIIIIIlI.getSystemService(PlaceFields.PHONE);
        if (telephonyManager == null) {
            IIIIIIII(0);
            return;
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        String networkOperator = telephonyManager.getNetworkOperator();
        if ((networkOperatorName != null && !networkOperatorName.isEmpty()) || (networkOperator != null && !networkOperator.isEmpty())) {
            IIIIIIII((IIIlIIlI) new IIIlllII(C6325l1.IIIIIIII(), networkOperatorName, networkOperator));
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
    }
}
