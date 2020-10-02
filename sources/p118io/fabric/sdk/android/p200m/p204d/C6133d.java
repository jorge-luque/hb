package p118io.fabric.sdk.android.p200m.p204d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import p118io.fabric.sdk.android.C6069h;

/* renamed from: io.fabric.sdk.android.m.d.d */
/* compiled from: PreferenceStoreImpl */
public class C6133d implements C6132c {

    /* renamed from: a */
    private final SharedPreferences f16111a;

    /* renamed from: b */
    private final String f16112b;

    /* renamed from: c */
    private final Context f16113c;

    public C6133d(Context context, String str) {
        if (context != null) {
            this.f16113c = context;
            this.f16112b = str;
            this.f16111a = context.getSharedPreferences(str, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    /* renamed from: a */
    public SharedPreferences.Editor mo34241a() {
        return this.f16111a.edit();
    }

    public SharedPreferences get() {
        return this.f16111a;
    }

    @TargetApi(9)
    /* renamed from: a */
    public boolean mo34242a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }

    @Deprecated
    public C6133d(C6069h hVar) {
        this(hVar.getContext(), hVar.getClass().getName());
    }
}
