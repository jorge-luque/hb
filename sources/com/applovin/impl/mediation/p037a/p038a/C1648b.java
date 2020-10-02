package com.applovin.impl.mediation.p037a.p038a;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: com.applovin.impl.mediation.a.a.b */
public class C1648b {

    /* renamed from: a */
    public TextView f5141a;

    /* renamed from: b */
    public TextView f5142b;

    /* renamed from: c */
    public ImageView f5143c;

    /* renamed from: d */
    public ImageView f5144d;

    /* renamed from: e */
    private C1649c f5145e;

    /* renamed from: a */
    public C1649c mo7638a() {
        return this.f5145e;
    }

    /* renamed from: a */
    public void mo7639a(C1649c cVar) {
        this.f5145e = cVar;
        this.f5141a.setText(cVar.mo7641c());
        if (this.f5142b != null) {
            if (!TextUtils.isEmpty(cVar.mo7642d())) {
                this.f5142b.setVisibility(0);
                this.f5142b.setText(cVar.mo7642d());
            } else {
                this.f5142b.setVisibility(8);
            }
        }
        if (this.f5143c != null) {
            if (cVar.mo7645g() > 0) {
                this.f5143c.setImageResource(cVar.mo7645g());
                this.f5143c.setColorFilter(cVar.mo7646h());
                this.f5143c.setVisibility(0);
            } else {
                this.f5143c.setVisibility(8);
            }
        }
        if (this.f5144d == null) {
            return;
        }
        if (cVar.mo7647i() > 0) {
            this.f5144d.setImageResource(cVar.mo7647i());
            this.f5144d.setColorFilter(cVar.mo7648j());
            this.f5144d.setVisibility(0);
            return;
        }
        this.f5144d.setVisibility(8);
    }
}
