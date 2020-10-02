package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPrivacyPolicy;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tapjoy.internal.er */
public abstract class C5032er {

    /* renamed from: c */
    private static final C5032er f13629c;

    /* renamed from: d */
    private static C5032er f13630d;

    /* renamed from: a */
    protected volatile boolean f13631a = false;

    /* renamed from: b */
    protected volatile boolean f13632b = false;

    static {
        C5101fx.m17218a();
        C5091fp.m17203a();
        C5036et etVar = new C5036et();
        f13629c = etVar;
        f13630d = etVar;
    }

    C5032er() {
    }

    /* renamed from: a */
    public static C5032er m17003a() {
        return f13630d;
    }

    /* renamed from: a */
    public abstract TJPlacement mo31136a(String str, TJPlacementListener tJPlacementListener);

    /* renamed from: a */
    public abstract void mo31137a(float f);

    /* renamed from: a */
    public abstract void mo31138a(int i);

    /* renamed from: a */
    public abstract void mo31139a(int i, TJAwardCurrencyListener tJAwardCurrencyListener);

    /* renamed from: a */
    public abstract void mo31140a(int i, TJSpendCurrencyListener tJSpendCurrencyListener);

    /* renamed from: a */
    public abstract void mo31141a(int i, String str);

    /* renamed from: a */
    public abstract void mo31142a(Activity activity);

    /* renamed from: a */
    public abstract void mo31143a(Context context, Map map);

    /* renamed from: a */
    public abstract void mo31144a(GLSurfaceView gLSurfaceView);

    /* renamed from: a */
    public abstract void mo31145a(TJEarnedCurrencyListener tJEarnedCurrencyListener);

    /* renamed from: a */
    public abstract void mo31146a(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener);

    /* renamed from: a */
    public abstract void mo31147a(TJVideoListener tJVideoListener);

    /* renamed from: a */
    public abstract void mo31148a(String str);

    /* renamed from: a */
    public abstract void mo31149a(String str, long j);

    /* renamed from: a */
    public abstract void mo31150a(String str, TJSetUserIDListener tJSetUserIDListener);

    /* renamed from: a */
    public abstract void mo31151a(String str, String str2);

    /* renamed from: a */
    public abstract void mo31152a(String str, String str2, double d, String str3);

    /* renamed from: a */
    public abstract void mo31153a(String str, String str2, long j);

    /* renamed from: a */
    public abstract void mo31154a(String str, String str2, String str3, String str4);

    /* renamed from: a */
    public abstract void mo31155a(String str, String str2, String str3, String str4, long j);

    /* renamed from: a */
    public abstract void mo31156a(String str, String str2, String str3, String str4, String str5, long j);

    /* renamed from: a */
    public abstract void mo31157a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2);

    /* renamed from: a */
    public abstract void mo31158a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3);

    /* renamed from: a */
    public abstract void mo31159a(String str, String str2, String str3, String str4, Map map);

    /* renamed from: a */
    public abstract void mo31160a(Set set);

    /* renamed from: a */
    public abstract void mo31161a(boolean z);

    /* renamed from: a */
    public abstract boolean mo31162a(Context context, String str);

    /* renamed from: a */
    public abstract boolean mo31163a(Context context, String str, TJConnectListener tJConnectListener);

    /* renamed from: a */
    public abstract boolean mo31164a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener);

    /* renamed from: b */
    public abstract TJPlacement mo31165b(String str, TJPlacementListener tJPlacementListener);

    /* renamed from: b */
    public abstract String mo31166b();

    /* renamed from: b */
    public abstract void mo31167b(int i);

    /* renamed from: b */
    public abstract void mo31168b(Activity activity);

    /* renamed from: b */
    public abstract void mo31169b(String str);

    /* renamed from: b */
    public abstract void mo31170b(String str, String str2, String str3, String str4);

    /* renamed from: b */
    public abstract void mo31171b(boolean z);

    /* renamed from: c */
    public abstract float mo31172c();

    /* renamed from: c */
    public abstract void mo31173c(Activity activity);

    /* renamed from: c */
    public abstract void mo31174c(String str);

    /* renamed from: c */
    public abstract void mo31175c(boolean z);

    /* renamed from: d */
    public abstract void mo31176d();

    /* renamed from: d */
    public abstract void mo31177d(String str);

    /* renamed from: d */
    public abstract void mo31178d(boolean z);

    /* renamed from: e */
    public abstract void mo31179e();

    /* renamed from: e */
    public abstract void mo31180e(String str);

    /* renamed from: f */
    public abstract Set mo31181f();

    /* renamed from: f */
    public abstract void mo31182f(String str);

    /* renamed from: g */
    public abstract String mo31183g(String str);

    /* renamed from: g */
    public abstract void mo31184g();

    /* renamed from: h */
    public abstract void mo31185h(String str);

    /* renamed from: h */
    public abstract boolean mo31186h();

    /* renamed from: i */
    public abstract void mo31187i(String str);

    /* renamed from: i */
    public abstract boolean mo31188i();

    /* renamed from: j */
    public abstract void mo31189j(String str);

    /* renamed from: j */
    public abstract boolean mo31190j();

    /* renamed from: k */
    public abstract String mo31191k();

    /* renamed from: l */
    public abstract String mo31192l();

    /* renamed from: m */
    public abstract TJPrivacyPolicy mo31193m();
}
