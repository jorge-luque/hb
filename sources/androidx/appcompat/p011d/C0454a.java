package androidx.appcompat.p011d;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.appcompat.R$bool;

/* renamed from: androidx.appcompat.d.a */
/* compiled from: ActionBarPolicy */
public class C0454a {

    /* renamed from: a */
    private Context f642a;

    private C0454a(Context context) {
        this.f642a = context;
    }

    /* renamed from: a */
    public static C0454a m719a(Context context) {
        return new C0454a(context);
    }

    /* renamed from: b */
    public int mo2294b() {
        return this.f642a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: c */
    public int mo2295c() {
        Configuration configuration = this.f642a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    /* renamed from: d */
    public boolean mo2296d() {
        return this.f642a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs);
    }

    /* renamed from: e */
    public boolean mo2297e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f642a).hasPermanentMenuKey();
    }

    /* renamed from: a */
    public boolean mo2293a() {
        return this.f642a.getApplicationInfo().targetSdkVersion < 14;
    }
}
