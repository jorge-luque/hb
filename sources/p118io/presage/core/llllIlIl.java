package p118io.presage.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* renamed from: io.presage.core.llllIlIl */
public class llllIlIl {
    public static final String IIIIIIII = C6288c0.IIIIIIIl;
    public static final String IIIIIIIl = C6288c0.IIIIIIII;
    public static final String IIIIIIlI = C6288c0.IIIIIIlI;

    public static String IIIIIIII(Context context) {
        StringBuilder sb;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return IIIIIIII;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                return IIIIIIII;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                return IIIIIIII;
            }
            if (networkCapabilities.hasTransport(1)) {
                return activeNetworkInfo.getTypeName();
            }
            if (!networkCapabilities.hasTransport(0)) {
                return activeNetworkInfo.getTypeName();
            }
            sb = new StringBuilder();
        } else if (activeNetworkInfo.getType() == 1) {
            return activeNetworkInfo.getTypeName();
        } else {
            if (activeNetworkInfo.getType() != 0) {
                return activeNetworkInfo.getTypeName();
            }
            sb = new StringBuilder();
        }
        sb.append(activeNetworkInfo.getTypeName());
        sb.append(" - ");
        sb.append(activeNetworkInfo.getSubtypeName());
        return sb.toString();
    }

    public static String IIIIIIIl(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return IIIIIIIl;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return activeNetworkInfo.getType() == 1 ? activeNetworkInfo.getTypeName() : activeNetworkInfo.getType() == 0 ? activeNetworkInfo.getSubtypeName() : activeNetworkInfo.getTypeName();
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return IIIIIIIl;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return networkCapabilities == null ? IIIIIIIl : networkCapabilities.hasTransport(1) ? activeNetworkInfo.getTypeName() : networkCapabilities.hasTransport(0) ? activeNetworkInfo.getSubtypeName() : activeNetworkInfo.getTypeName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean IIIIIIlI(android.content.Context r6) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r1 = r6.getSystemService(r0)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            r4 = 0
            r5 = 1
            if (r2 < r3) goto L_0x0023
            android.net.Network r2 = r1.getActiveNetwork()
            if (r2 != 0) goto L_0x0017
            goto L_0x0032
        L_0x0017:
            android.net.NetworkCapabilities r1 = r1.getNetworkCapabilities(r2)
            if (r1 != 0) goto L_0x001e
            goto L_0x0032
        L_0x001e:
            boolean r1 = r1.hasTransport(r5)
            goto L_0x0033
        L_0x0023:
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 != 0) goto L_0x002a
            goto L_0x0032
        L_0x002a:
            int r1 = r1.getType()
            if (r1 != r5) goto L_0x0032
            r1 = 1
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            if (r1 != 0) goto L_0x0061
            java.lang.Object r6 = r6.getSystemService(r0)
            android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x004f
            android.net.Network r0 = r6.getActiveNetwork()
            android.net.NetworkCapabilities r6 = r6.getNetworkCapabilities(r0)
            if (r6 != 0) goto L_0x004a
            goto L_0x005e
        L_0x004a:
            boolean r6 = r6.hasTransport(r4)
            goto L_0x005f
        L_0x004f:
            android.net.NetworkInfo r6 = r6.getActiveNetworkInfo()
            if (r6 != 0) goto L_0x0056
            goto L_0x005e
        L_0x0056:
            int r6 = r6.getType()
            if (r6 != 0) goto L_0x005e
            r6 = 1
            goto L_0x005f
        L_0x005e:
            r6 = 0
        L_0x005f:
            if (r6 == 0) goto L_0x0062
        L_0x0061:
            r4 = 1
        L_0x0062:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.llllIlIl.IIIIIIlI(android.content.Context):boolean");
    }
}
