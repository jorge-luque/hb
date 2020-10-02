package com.onesignal;

import android.content.Context;
import android.net.Uri;
import com.onesignal.C4739z;
import java.security.SecureRandom;
import org.json.JSONObject;

/* renamed from: com.onesignal.a0 */
/* compiled from: NotificationGenerationJob */
class C4467a0 {

    /* renamed from: a */
    Context f12267a;

    /* renamed from: b */
    JSONObject f12268b;

    /* renamed from: c */
    boolean f12269c;

    /* renamed from: d */
    boolean f12270d;

    /* renamed from: e */
    boolean f12271e;

    /* renamed from: f */
    Long f12272f;

    /* renamed from: g */
    CharSequence f12273g;

    /* renamed from: h */
    CharSequence f12274h;

    /* renamed from: i */
    Uri f12275i;

    /* renamed from: j */
    Integer f12276j;

    /* renamed from: k */
    Integer f12277k;

    /* renamed from: l */
    Uri f12278l;

    /* renamed from: m */
    C4739z.C4740a f12279m;

    C4467a0(Context context) {
        this.f12267a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Integer mo29697a() {
        if (this.f12279m == null) {
            this.f12279m = new C4739z.C4740a();
        }
        C4739z.C4740a aVar = this.f12279m;
        if (aVar.f12866b == null) {
            aVar.f12866b = Integer.valueOf(new SecureRandom().nextInt());
        }
        return this.f12279m.f12866b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo29699b() {
        Integer num;
        C4739z.C4740a aVar = this.f12279m;
        if (aVar == null || (num = aVar.f12866b) == null) {
            return -1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo29700c() {
        return C4564n1.m15812b(this.f12268b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public CharSequence mo29701d() {
        CharSequence charSequence = this.f12273g;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f12268b.optString("alert", (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public CharSequence mo29702e() {
        CharSequence charSequence = this.f12274h;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f12268b.optString("title", (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo29703f() {
        C4739z.C4740a aVar = this.f12279m;
        return (aVar == null || aVar.f12865a == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo29704g() {
        return mo29699b() != -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29698a(Integer num) {
        if (num != null) {
            C4739z.C4740a aVar = this.f12279m;
            if (aVar == null || aVar.f12866b == null) {
                if (this.f12279m == null) {
                    this.f12279m = new C4739z.C4740a();
                }
                this.f12279m.f12866b = num;
            }
        }
    }
}
