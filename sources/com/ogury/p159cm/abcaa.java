package com.ogury.p159cm;

import android.content.Context;
import android.content.SharedPreferences;
import com.ogury.p159cm.ConsentActivity;

/* renamed from: com.ogury.cm.abcaa */
public final class abcaa extends abbcb {

    /* renamed from: b */
    public static final aaaaa f12092b = new aaaaa((baaca) null);

    /* renamed from: c */
    private String f12093c = "cacheConsentV2";

    /* renamed from: com.ogury.cm.abcaa$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    /* renamed from: b */
    private static ababc m15156b() {
        aacca aacca = aacca.f12035a;
        return (ababc) ababa.m15062f();
    }

    /* renamed from: a */
    public final String mo29487a() {
        return this.f12093c;
    }

    /* renamed from: a */
    public final boolean mo29490a(String str, Context context) {
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(context, "context");
        if (!super.mo29490a(str, context)) {
            return true;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.f12093c, 0);
        ababc b = m15156b();
        b.mo29447a(sharedPreferences.getInt("purposes", 0));
        String string = sharedPreferences.getString("acceptedVendors", "");
        accbb.m15215a((Object) string, "prefs.getString(ACCEPTED_VENDORS, \"\")");
        Object[] array = ConsentActivity.aaaaa.m14881a(ConsentActivity.aaaaa.m14884b(string)).toArray(new Integer[0]);
        if (array != null) {
            b.mo29449a((Integer[]) array);
            b.mo29453c(sharedPreferences.getInt("specialFeatures", 0));
            String string2 = sharedPreferences.getString("vendorsLi", "");
            accbb.m15215a((Object) string2, "prefs.getString(VENDORS_LI, \"\")");
            Object[] array2 = ConsentActivity.aaaaa.m14881a(ConsentActivity.aaaaa.m14884b(string2)).toArray(new Integer[0]);
            if (array2 != null) {
                b.mo29452b((Integer[]) array2);
                b.mo29450b(sharedPreferences.getInt("purposesLi", 0));
                String string3 = sharedPreferences.getString("vendorPurposesAndSF", "");
                accbb.m15215a((Object) string3, "prefs.getString(VENDOR_PURPOSES_AND_SF, \"\")");
                b.mo29451b(ConsentActivity.aaaaa.m14882a(string3));
                b.mo29454d(sharedPreferences.getInt("maxVendorId", 0));
                return true;
            }
            throw new acbab("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new acbab("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo29491d(Context context) {
        accbb.m15218b(context, "context");
        super.mo29491d(context);
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f12093c, 0).edit();
        edit.putInt("purposes", m15156b().mo29457i());
        edit.putString("acceptedVendors", acbbb.m15200a(m15156b().mo29455g(), (CharSequence) null, "[", "]", 0, (CharSequence) null, (accac) null, 57, (Object) null));
        edit.putInt("specialFeatures", m15156b().mo29459k());
        edit.putString("vendorsLi", acbbb.m15200a(m15156b().mo29456h(), (CharSequence) null, "[", "]", 0, (CharSequence) null, (accac) null, 57, (Object) null));
        edit.putInt("purposesLi", m15156b().mo29458j());
        edit.putString("vendorPurposesAndSF", String.valueOf(m15156b().mo29461m()));
        edit.putInt("maxVendorId", m15156b().mo29462n());
        edit.apply();
    }
}
