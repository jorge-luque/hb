package androidx.browser.p012a;

import android.os.Bundle;

/* renamed from: androidx.browser.a.a */
/* compiled from: CustomTabColorSchemeParams */
public final class C0643a {

    /* renamed from: a */
    public final Integer f1593a;

    /* renamed from: b */
    public final Integer f1594b;

    /* renamed from: c */
    public final Integer f1595c;

    /* renamed from: androidx.browser.a.a$a */
    /* compiled from: CustomTabColorSchemeParams */
    public static final class C0644a {

        /* renamed from: a */
        private Integer f1596a;

        /* renamed from: b */
        private Integer f1597b;

        /* renamed from: c */
        private Integer f1598c;

        /* renamed from: a */
        public C0643a mo3640a() {
            return new C0643a(this.f1596a, this.f1597b, this.f1598c);
        }
    }

    C0643a(Integer num, Integer num2, Integer num3) {
        this.f1593a = num;
        this.f1594b = num2;
        this.f1595c = num3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bundle mo3639a() {
        Bundle bundle = new Bundle();
        Integer num = this.f1593a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f1594b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f1595c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        return bundle;
    }
}
