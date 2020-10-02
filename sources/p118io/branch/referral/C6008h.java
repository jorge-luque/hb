package p118io.branch.referral;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;
import p118io.branch.referral.C6008h;

/* renamed from: io.branch.referral.h */
/* compiled from: BranchUrlBuilder */
abstract class C6008h<T extends C6008h> {

    /* renamed from: a */
    protected JSONObject f15375a;

    /* renamed from: b */
    protected String f15376b;

    /* renamed from: c */
    protected String f15377c;

    /* renamed from: d */
    protected String f15378d;

    /* renamed from: e */
    protected String f15379e;

    /* renamed from: f */
    protected String f15380f;

    /* renamed from: g */
    protected int f15381g = 0;

    /* renamed from: h */
    protected int f15382h = 0;

    /* renamed from: i */
    protected ArrayList<String> f15383i;

    /* renamed from: j */
    protected C3555b f15384j = C3555b.m12034k();

    /* renamed from: k */
    private boolean f15385k;

    /* renamed from: l */
    private final Context f15386l;

    protected C6008h(Context context) {
        this.f15386l = context.getApplicationContext();
        this.f15385k = true;
    }

    /* renamed from: a */
    public T mo33889a(List<String> list) {
        if (this.f15383i == null) {
            this.f15383i = new ArrayList<>();
        }
        this.f15383i.addAll(list);
        return this;
    }

    /* renamed from: a */
    public T mo33888a(String str, Object obj) {
        try {
            if (this.f15375a == null) {
                this.f15375a = new JSONObject();
            }
            this.f15375a.put(str, obj);
        } catch (JSONException unused) {
        }
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo33890a() {
        if (this.f15384j == null) {
            return null;
        }
        return this.f15384j.mo19624a(new C6040t(this.f15386l, this.f15380f, this.f15381g, this.f15382h, this.f15383i, this.f15376b, this.f15377c, this.f15378d, this.f15379e, C6010i.m19311b(this.f15375a), (C3555b.C3559d) null, false, this.f15385k));
    }
}
