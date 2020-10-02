package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: io.presage.v */
public final class C6576v {
    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public static final NetworkInfo m21575a(Context context) {
        if (!C6214ae.m20773a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return null;
        }
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            return ((ConnectivityManager) systemService).getActiveNetworkInfo();
        }
        throw new C6434em("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    /* renamed from: b */
    public static final boolean m21577b(Context context) {
        NetworkInfo a = m21575a(context);
        return a != null && a.isConnected();
    }

    /* renamed from: a */
    public static final boolean m21576a(NetworkInfo networkInfo) {
        return networkInfo.isConnected() && networkInfo.getType() == 1;
    }
}
