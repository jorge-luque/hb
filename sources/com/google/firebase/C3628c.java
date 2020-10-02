package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* renamed from: com.google.firebase.c */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public final class C3628c {

    /* renamed from: a */
    private final String f10167a;

    /* renamed from: b */
    private final String f10168b;

    /* renamed from: c */
    private final String f10169c;

    /* renamed from: d */
    private final String f10170d;

    /* renamed from: e */
    private final String f10171e;

    /* renamed from: f */
    private final String f10172f;

    /* renamed from: g */
    private final String f10173g;

    /* renamed from: com.google.firebase.c$b */
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public static final class C3630b {

        /* renamed from: a */
        private String f10174a;

        /* renamed from: b */
        private String f10175b;

        /* renamed from: c */
        private String f10176c;

        /* renamed from: d */
        private String f10177d;

        /* renamed from: e */
        private String f10178e;

        /* renamed from: f */
        private String f10179f;

        /* renamed from: g */
        private String f10180g;

        /* renamed from: a */
        public C3630b mo27214a(String str) {
            this.f10174a = Preconditions.checkNotEmpty(str, "ApiKey must be set.");
            return this;
        }

        /* renamed from: b */
        public C3630b mo27216b(String str) {
            this.f10175b = Preconditions.checkNotEmpty(str, "ApplicationId must be set.");
            return this;
        }

        /* renamed from: c */
        public C3630b mo27217c(String str) {
            this.f10178e = str;
            return this;
        }

        /* renamed from: d */
        public C3630b mo27218d(String str) {
            this.f10180g = str;
            return this;
        }

        /* renamed from: a */
        public C3628c mo27215a() {
            return new C3628c(this.f10175b, this.f10174a, this.f10176c, this.f10177d, this.f10178e, this.f10179f, this.f10180g);
        }
    }

    /* renamed from: a */
    public static C3628c m12356a(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C3628c(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    /* renamed from: b */
    public String mo27208b() {
        return this.f10168b;
    }

    /* renamed from: c */
    public String mo27209c() {
        return this.f10171e;
    }

    /* renamed from: d */
    public String mo27210d() {
        return this.f10173g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3628c)) {
            return false;
        }
        C3628c cVar = (C3628c) obj;
        if (!Objects.equal(this.f10168b, cVar.f10168b) || !Objects.equal(this.f10167a, cVar.f10167a) || !Objects.equal(this.f10169c, cVar.f10169c) || !Objects.equal(this.f10170d, cVar.f10170d) || !Objects.equal(this.f10171e, cVar.f10171e) || !Objects.equal(this.f10172f, cVar.f10172f) || !Objects.equal(this.f10173g, cVar.f10173g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f10168b, this.f10167a, this.f10169c, this.f10170d, this.f10171e, this.f10172f, this.f10173g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f10168b).add("apiKey", this.f10167a).add("databaseUrl", this.f10169c).add("gcmSenderId", this.f10171e).add("storageBucket", this.f10172f).add("projectId", this.f10173g).toString();
    }

    private C3628c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f10168b = str;
        this.f10167a = str2;
        this.f10169c = str3;
        this.f10170d = str4;
        this.f10171e = str5;
        this.f10172f = str6;
        this.f10173g = str7;
    }

    /* renamed from: a */
    public String mo27207a() {
        return this.f10167a;
    }
}
