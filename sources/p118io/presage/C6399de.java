package p118io.presage;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import com.loopj.android.http.C4250c;

/* renamed from: io.presage.de */
public final class C6399de {
    /* renamed from: a */
    public static final void m21253a(C6396db dbVar, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(C6245bi.m20901b(dbVar));
            sb.append(" >> ");
            sb.append(str);
            dbVar.loadUrl("javascript:".concat(String.valueOf(str)));
        } catch (Throwable th) {
            Laguiole laguiole = Laguiole.f16541a;
            Laguiole.m20426a(th);
        }
    }

    /* renamed from: a */
    public static final void m21252a(C6396db dbVar, PontlEveque pontlEveque) {
        boolean z = true;
        String h = pontlEveque.mo34625h().length() > 0 ? pontlEveque.mo34625h() : "http://ads-test.st.ogury.com/";
        if (pontlEveque.mo34610c().length() <= 0) {
            z = false;
        }
        try {
            dbVar.loadDataWithBaseURL(h, z ? pontlEveque.mo34610c() : "The ad contains no ad_content", "text/html", C4250c.DEFAULT_CHARSET, (String) null);
        } catch (Throwable th) {
            Laguiole laguiole = Laguiole.f16541a;
            Laguiole.m20426a(th);
        }
    }

    /* renamed from: a */
    public static final C6396db m21251a(Context context, PontlEveque pontlEveque) {
        try {
            C6396db dbVar = new C6396db(context, pontlEveque);
            dbVar.setBackgroundColor(0);
            if (Build.VERSION.SDK_INT >= 19) {
                dbVar.setLayerType(2, (Paint) null);
            }
            return dbVar;
        } catch (Throwable th) {
            Laguiole laguiole = Laguiole.f16541a;
            Laguiole.m20426a(th);
            return null;
        }
    }
}
