package com.applovin.impl.mediation.p037a.p040c.p043b;

import admost.sdk.base.AdMostAdNetwork;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.mediation.p037a.p038a.C1647a;
import com.applovin.impl.mediation.p037a.p038a.C1649c;
import com.applovin.impl.mediation.p037a.p038a.C1651d;
import com.applovin.impl.mediation.p037a.p038a.C1653e;
import com.applovin.impl.mediation.p037a.p038a.C1654f;
import com.applovin.impl.mediation.p037a.p038a.C1655g;
import com.applovin.impl.mediation.p037a.p040c.C1658a;
import com.applovin.impl.mediation.p037a.p040c.p043b.p044a.C1669a;
import com.applovin.impl.sdk.utils.C1990f;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.C2057R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.a.c.b.b */
public class C1672b extends C1658a {

    /* renamed from: c */
    private final C1649c f5223c = new C1655g("INTEGRATIONS");

    /* renamed from: d */
    private final C1649c f5224d = new C1655g("PERMISSIONS");

    /* renamed from: e */
    private final C1649c f5225e = new C1655g("CONFIGURATION");

    /* renamed from: f */
    private final C1649c f5226f = new C1655g("DEPENDENCIES");

    /* renamed from: g */
    private final C1649c f5227g = new C1655g("");

    /* renamed from: h */
    private SpannedString f5228h;

    /* renamed from: i */
    private C1673a f5229i;

    /* renamed from: com.applovin.impl.mediation.a.c.b.b$a */
    public interface C1673a {
        /* renamed from: a */
        void mo7704a(String str);
    }

    C1672b(C1651d dVar, Context context) {
        super(context);
        if (dVar.mo7652a() == C1651d.C1652a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.f5228h = new SpannedString(spannableString);
        } else {
            this.f5228h = new SpannedString("");
        }
        this.f5189b.add(this.f5223c);
        this.f5189b.add(mo7716a(dVar));
        this.f5189b.add(mo7720b(dVar));
        this.f5189b.add(mo7722c(dVar));
        this.f5189b.addAll(mo7718a(dVar.mo7663k()));
        this.f5189b.addAll(mo7717a(dVar.mo7665m()));
        this.f5189b.addAll(mo7721b(dVar.mo7664l()));
        this.f5189b.add(this.f5227g);
    }

    /* renamed from: a */
    private int m6374a(boolean z) {
        return z ? C2057R.C2058drawable.applovin_ic_check_mark : C2057R.C2058drawable.applovin_ic_x_mark;
    }

    /* renamed from: b */
    private int m6375b(boolean z) {
        return C1990f.m7835a(z ? C2057R.color.applovin_sdk_checkmarkColor : C2057R.color.applovin_sdk_xmarkColor, this.f5188a);
    }

    /* renamed from: b */
    private boolean m6376b(int i) {
        return (i == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || i == MaxAdapter.InitializationStatus.INITIALIZING.getCode()) ? false : true;
    }

    /* renamed from: a */
    public C1649c mo7716a(C1651d dVar) {
        C1669a.C1671a a = C1669a.m6360l().mo7710a("SDK").mo7714b(dVar.mo7659g()).mo7709a(TextUtils.isEmpty(dVar.mo7659g()) ? C1649c.C1650a.DETAIL : C1649c.C1650a.RIGHT_DETAIL);
        if (TextUtils.isEmpty(dVar.mo7659g())) {
            a.mo7707a(m6374a(dVar.mo7654c())).mo7713b(m6375b(dVar.mo7654c()));
        }
        return a.mo7712a();
    }

    /* renamed from: a */
    public List<C1649c> mo7717a(C1653e eVar) {
        ArrayList arrayList = new ArrayList(2);
        if (eVar.mo7668a()) {
            boolean b = eVar.mo7669b();
            arrayList.add(this.f5225e);
            arrayList.add(C1669a.m6360l().mo7710a("Cleartext Traffic").mo7708a(b ? null : this.f5228h).mo7715c(eVar.mo7670c()).mo7707a(m6374a(b)).mo7713b(m6375b(b)).mo7711a(!b).mo7712a());
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<C1649c> mo7718a(List<C1654f> list) {
        ArrayList arrayList = new ArrayList(list.size() + 1);
        if (list.size() > 0) {
            arrayList.add(this.f5224d);
            for (C1654f next : list) {
                boolean c = next.mo7673c();
                arrayList.add(C1669a.m6360l().mo7710a(next.mo7671a()).mo7708a(c ? null : this.f5228h).mo7715c(next.mo7672b()).mo7707a(m6374a(c)).mo7713b(m6375b(c)).mo7711a(!c).mo7712a());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7679a(C1649c cVar) {
        if (this.f5229i != null && (cVar instanceof C1669a)) {
            String k = ((C1669a) cVar).mo7705k();
            if (!TextUtils.isEmpty(k)) {
                this.f5229i.mo7704a(k);
            }
        }
    }

    /* renamed from: a */
    public void mo7719a(C1673a aVar) {
        this.f5229i = aVar;
    }

    /* renamed from: b */
    public C1649c mo7720b(C1651d dVar) {
        C1669a.C1671a a = C1669a.m6360l().mo7710a(AdMostAdNetwork.AdapterHelper.DEFAULT_ADAPTER_SUFFIX).mo7714b(dVar.mo7660h()).mo7709a(TextUtils.isEmpty(dVar.mo7660h()) ? C1649c.C1650a.DETAIL : C1649c.C1650a.RIGHT_DETAIL);
        if (TextUtils.isEmpty(dVar.mo7660h())) {
            a.mo7707a(m6374a(dVar.mo7656d())).mo7713b(m6375b(dVar.mo7656d()));
        }
        return a.mo7712a();
    }

    /* renamed from: b */
    public List<C1649c> mo7721b(List<C1647a> list) {
        ArrayList arrayList = new ArrayList(list.size() + 1);
        if (list.size() > 0) {
            arrayList.add(this.f5226f);
            for (C1647a next : list) {
                boolean c = next.mo7637c();
                arrayList.add(C1669a.m6360l().mo7710a(next.mo7635a()).mo7708a(c ? null : this.f5228h).mo7715c(next.mo7636b()).mo7707a(m6374a(c)).mo7713b(m6375b(c)).mo7711a(!c).mo7712a());
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public C1649c mo7722c(C1651d dVar) {
        boolean b = m6376b(dVar.mo7653b());
        return C1669a.m6360l().mo7710a("Adapter Initialized").mo7707a(m6374a(b)).mo7713b(m6375b(b)).mo7712a();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{listItems=" + this.f5189b + "}";
    }
}
