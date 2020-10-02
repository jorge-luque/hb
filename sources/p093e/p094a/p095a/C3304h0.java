package p093e.p094a.p095a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyConstants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/* renamed from: e.a.a.h0 */
/* compiled from: MacAddressUtil */
public class C3304h0 {
    /* renamed from: a */
    public static String m10987a(Context context) {
        String b = m10989b(context);
        if (b == null) {
            return null;
        }
        return m10990b(b.toUpperCase(Locale.US));
    }

    /* renamed from: b */
    private static String m10989b(Context context) {
        String a = m10988a("wlan0");
        if (a != null) {
            return a;
        }
        String a2 = m10988a("eth0");
        if (a2 != null) {
            return a2;
        }
        try {
            String macAddress = ((WifiManager) context.getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI)).getConnectionInfo().getMacAddress();
            if (macAddress != null) {
                return macAddress;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m10988a(String str) {
        try {
            StringBuilder sb = new StringBuilder(1000);
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/class/net/" + str + "/address"), OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            char[] cArr = new char[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    sb.append(String.valueOf(cArr, 0, read));
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static String m10990b(String str) {
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll("\\s", "");
        if (TextUtils.isEmpty(replaceAll)) {
            return null;
        }
        return replaceAll;
    }
}
