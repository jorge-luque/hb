package p118io.presage.common;

import android.content.Context;
import p118io.presage.Machecoulais;

/* renamed from: io.presage.common.PresageSdk */
public final class PresageSdk {

    /* renamed from: a */
    public static final PresageSdk f16922a = new PresageSdk();

    /* renamed from: b */
    private static final Machecoulais f16923b = new Machecoulais();

    private PresageSdk() {
    }

    /* renamed from: a */
    public static boolean m21151a() {
        return f16923b.mo34575a();
    }

    /* renamed from: b */
    public static boolean m21152b() {
        return f16923b.mo34576b();
    }

    /* renamed from: c */
    public static boolean m21153c() {
        return f16923b.mo34577c();
    }

    public static final String getAdsSdkVersion() {
        return Machecoulais.m20449d();
    }

    public static final void init(Context context, String str) {
        f16923b.mo34572a(context, str);
    }

    public static final void setMediationName(String str) {
        f16923b.mo34574a(str);
    }

    public final void addSdkInitCallback(PresageSdkInitCallback presageSdkInitCallback) {
        f16923b.mo34573a(presageSdkInitCallback);
    }
}
