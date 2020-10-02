package p118io.presage.core;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: io.presage.core.IlIIllII */
public class IlIIllII extends IIllllll {
    public static final String IIIIlllI = C6283b.IIIIIIII;

    public IlIIllII(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 25;
    }

    public Object IIIIIIll() {
        return IlIIllII.class;
    }

    @SuppressLint({"MissingPermission"})
    public void IIIIIlIl() {
        BluetoothAdapter defaultAdapter;
        if (IIIIlIll.IIIIIIII(this.IIIIIIlI, "android.permission.BLUETOOTH") && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null && defaultAdapter.isEnabled()) {
            Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
            if (bondedDevices.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (BluetoothDevice next : bondedDevices) {
                    try {
                        arrayList.add(new IIIllIII(next.getName(), new C6377y1().IIIIIIII(1).IIIIIIII(IIIIlllI.getBytes(), 0).IIIIIIII(next.getAddress())));
                    } catch (Exception unused) {
                    }
                }
                IIIIIIII((IIIlIIlI) new IIIllIIl(C6325l1.IIIIIIII(), arrayList));
            }
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
    }
}
