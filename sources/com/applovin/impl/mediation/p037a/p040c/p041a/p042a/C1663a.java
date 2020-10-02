package com.applovin.impl.mediation.p037a.p040c.p041a.p042a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.applovin.impl.mediation.p037a.p038a.C1649c;
import com.applovin.impl.mediation.p037a.p038a.C1651d;
import com.applovin.impl.sdk.utils.C1990f;
import com.applovin.sdk.C2057R;
import com.google.android.gms.games.Notifications;

/* renamed from: com.applovin.impl.mediation.a.c.a.a.a */
public class C1663a extends C1649c {

    /* renamed from: d */
    private final C1651d f5201d;

    /* renamed from: e */
    private final Context f5202e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1663a(C1651d dVar, Context context) {
        super(dVar.mo7652a() == C1651d.C1652a.MISSING ? C1649c.C1650a.SIMPLE : C1649c.C1650a.DETAIL);
        this.f5201d = dVar;
        this.f5202e = context;
    }

    /* renamed from: a */
    private SpannedString m6340a(String str, int i) {
        return m6341a(str, i, 16);
    }

    /* renamed from: a */
    private SpannedString m6341a(String str, int i, int i2) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, spannableString.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(i2, true), 0, spannableString.length(), 33);
        return new SpannedString(spannableString);
    }

    /* renamed from: l */
    private SpannedString m6342l() {
        int i;
        String str;
        if (this.f5201d.mo7654c()) {
            if (!TextUtils.isEmpty(this.f5201d.mo7659g())) {
                str = "SDK " + this.f5201d.mo7659g();
            } else {
                str = this.f5201d.mo7656d() ? "Retrieving SDK Version..." : "SDK Found";
            }
            i = -7829368;
        } else {
            i = -65536;
            str = "SDK Missing";
        }
        return m6340a(str, i);
    }

    /* renamed from: m */
    private SpannedString m6343m() {
        int i;
        String str;
        if (this.f5201d.mo7656d()) {
            if (!TextUtils.isEmpty(this.f5201d.mo7660h())) {
                str = "Adapter " + this.f5201d.mo7660h();
            } else {
                str = "Adapter Found";
            }
            i = -7829368;
        } else {
            i = -65536;
            str = "Adapter Missing";
        }
        return m6340a(str, i);
    }

    /* renamed from: n */
    private SpannedString m6344n() {
        return m6340a("Invalid Integration", -65536);
    }

    /* renamed from: o */
    private SpannedString m6345o() {
        return m6340a("Latest Version: Adapter " + this.f5201d.mo7661i(), Color.rgb(255, Notifications.NOTIFICATION_TYPES_ALL, 0));
    }

    /* renamed from: b */
    public boolean mo7640b() {
        return this.f5201d.mo7652a() != C1651d.C1652a.MISSING;
    }

    /* renamed from: c */
    public SpannedString mo7641c() {
        SpannedString spannedString = this.f5147b;
        if (spannedString != null) {
            return spannedString;
        }
        SpannedString a = m6341a(this.f5201d.mo7658f(), this.f5201d.mo7652a() == C1651d.C1652a.MISSING ? -7829368 : -16777216, 18);
        this.f5147b = a;
        return a;
    }

    /* renamed from: d */
    public SpannedString mo7642d() {
        SpannedString spannedString = this.f5148c;
        if (spannedString != null) {
            return spannedString;
        }
        if (this.f5201d.mo7652a() != C1651d.C1652a.MISSING) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(m6342l());
            spannableStringBuilder.append(m6340a(", ", -7829368));
            spannableStringBuilder.append(m6343m());
            if (this.f5201d.mo7657e()) {
                spannableStringBuilder.append(new SpannableString("\n"));
                spannableStringBuilder.append(m6345o());
            }
            if (this.f5201d.mo7652a() == C1651d.C1652a.INVALID_INTEGRATION) {
                spannableStringBuilder.append(new SpannableString("\n"));
                spannableStringBuilder.append(m6344n());
            }
            this.f5148c = new SpannedString(spannableStringBuilder);
        } else {
            this.f5148c = new SpannedString("");
        }
        return this.f5148c;
    }

    /* renamed from: g */
    public int mo7645g() {
        int j = this.f5201d.mo7662j();
        return j > 0 ? j : C2057R.C2058drawable.applovin_ic_mediation_placeholder_network;
    }

    /* renamed from: i */
    public int mo7647i() {
        return mo7640b() ? C2057R.C2058drawable.applovin_ic_disclosure_arrow : super.mo7645g();
    }

    /* renamed from: j */
    public int mo7648j() {
        return C1990f.m7835a(C2057R.color.applovin_sdk_disclosureButtonColor, this.f5202e);
    }

    /* renamed from: k */
    public C1651d mo7695k() {
        return this.f5201d;
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + this.f5147b + ", detailText=" + this.f5148c + ", network=" + this.f5201d + "}";
    }
}
