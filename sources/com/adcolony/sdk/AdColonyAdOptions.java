package com.adcolony.sdk;

import org.json.JSONObject;

public class AdColonyAdOptions {

    /* renamed from: a */
    boolean f3257a;

    /* renamed from: b */
    boolean f3258b;

    /* renamed from: c */
    AdColonyUserMetadata f3259c;

    /* renamed from: d */
    JSONObject f3260d = C1437s.m5599b();

    public AdColonyAdOptions enableConfirmationDialog(boolean z) {
        this.f3257a = z;
        C1437s.m5603b(this.f3260d, "confirmation_enabled", true);
        return this;
    }

    public AdColonyAdOptions enableResultsDialog(boolean z) {
        this.f3258b = z;
        C1437s.m5603b(this.f3260d, "results_enabled", true);
        return this;
    }

    public Object getOption(String str) {
        return C1437s.m5598b(this.f3260d, str);
    }

    @Deprecated
    public AdColonyUserMetadata getUserMetadata() {
        return this.f3259c;
    }

    public AdColonyAdOptions setOption(String str, boolean z) {
        if (C1359k0.m5333g(str)) {
            C1437s.m5603b(this.f3260d, str, z);
        }
        return this;
    }

    @Deprecated
    public AdColonyAdOptions setUserMetadata(AdColonyUserMetadata adColonyUserMetadata) {
        this.f3259c = adColonyUserMetadata;
        C1437s.m5594a(this.f3260d, "user_metadata", adColonyUserMetadata.f3319b);
        return this;
    }

    public AdColonyAdOptions setOption(String str, double d) {
        if (C1359k0.m5333g(str)) {
            C1437s.m5590a(this.f3260d, str, d);
        }
        return this;
    }

    public AdColonyAdOptions setOption(String str, String str2) {
        if (str != null) {
            C1437s.m5592a(this.f3260d, str, str2);
        }
        return this;
    }
}
