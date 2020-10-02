package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.C2086a;
import com.chartboost.sdk.Model.C2087b;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.y */
public class C2233y extends C2086a {

    /* renamed from: t */
    public int f7542t;

    /* renamed from: u */
    private C2136e0 f7543u = null;

    public C2233y(int i, JSONObject jSONObject) throws JSONException {
        this.f7542t = i;
        this.f6896b = 1;
        C2136e0 b = C2123b0.m8447b(jSONObject);
        this.f7543u = b;
        C2127c0 b2 = m8870b(m8872c(b.mo9326c()).mo9329a());
        C2132d0 c = b2.mo9287c();
        m8869a(this.f7543u.mo9324a());
        this.f6897c.put("body", this.f6912r);
        this.f6902h = b2.mo9286b();
        this.f6910p = c.mo9311c();
        this.f6900f = c.mo9309a();
        this.f6901g = c.mo9310b();
        this.f6908n.put("imptrackers", c.mo9312d());
        m8868a(b2);
    }

    /* renamed from: b */
    private String m8871b() {
        int i = this.f7542t;
        if (i == 0) {
            return "8";
        }
        if (i != 1) {
            return i != 3 ? "" : "10";
        }
        return "9";
    }

    /* renamed from: c */
    private C2140f0 m8872c(ArrayList<C2140f0> arrayList) {
        return !arrayList.isEmpty() ? arrayList.get(0) : new C2140f0();
    }

    /* renamed from: a */
    public C2136e0 mo9595a() {
        return this.f7543u;
    }

    /* renamed from: a */
    private void m8868a(C2127c0 c0Var) {
        String b = m8871b();
        String str = this.f7542t == 0 ? "true" : "false";
        this.f6898d.put("{% encoding %}", "base64");
        this.f6898d.put("{% adm %}", c0Var.mo9285a());
        this.f6898d.put("{{ ad_type }}", b);
        this.f6898d.put("{{ show_close_button }}", str);
        this.f6898d.put("{{ preroll_popup }}", "false");
        this.f6898d.put("{{ post_video_reward_toaster_enabled }}", "false");
        if (this.f7542t == 3) {
            this.f6898d.put("{% is_banner %}", "true");
        }
    }

    /* renamed from: b */
    private C2127c0 m8870b(ArrayList<C2127c0> arrayList) {
        return !arrayList.isEmpty() ? arrayList.get(0) : new C2127c0();
    }

    /* renamed from: a */
    private void m8869a(ArrayList<C2087b> arrayList) {
        if (!arrayList.isEmpty()) {
            this.f6912r = arrayList.get(0);
        } else {
            this.f6912r = new C2087b("", "", "");
        }
    }
}
