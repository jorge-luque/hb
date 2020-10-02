package com.ogury.p159cm;

import com.ogury.p159cm.OguryChoiceManager;
import com.ogury.p159cm.abbcb;

/* renamed from: com.ogury.cm.aaabc */
public final class aaabc extends aaaba {

    /* renamed from: com.ogury.cm.aaabc$aaaaa */
    static final class aaaaa extends accbc implements accac<Integer, Boolean> {

        /* renamed from: a */
        final /* synthetic */ aaabc f11977a;

        /* renamed from: b */
        final /* synthetic */ int f11978b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaaaa(aaabc aaabc, int i) {
            super(1);
            this.f11977a = aaabc;
            this.f11978b = i;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29401a(Object obj) {
            ((Number) obj).intValue();
            return Boolean.valueOf(babac.m15265a((CharSequence) aaabc.m14951f().mo29445i(), (CharSequence) String.valueOf(this.f11978b), false, 2, (Object) null));
        }
    }

    public aaabc() {
        aacca aacca = aacca.f12035a;
        aacca.m15028a(1);
        aacca aacca2 = aacca.f12035a;
        aacca.m15030a((ababa) new ababb());
        abbcb.aaaaa aaaaa2 = abbcb.f12089a;
        mo29393a(abbcb.aaaaa.m15151a());
    }

    /* renamed from: b */
    public static boolean m14950b(String str) {
        accbb.m15218b(str, "vendor");
        int i = aaaca.f11979a[m14951f().mo29430a().ordinal()];
        if (i == 1) {
            return true;
        }
        if (!(i == 2 || i == 3)) {
            ababb f = m14951f();
            if ((f.mo29443g().length() > 0) && (!accbb.m15217a((Object) f.mo29443g(), (Object) "null"))) {
                return babac.m15265a((CharSequence) f.mo29443g(), (CharSequence) str, false, 2, (Object) null);
            }
            if (!babac.m15265a((CharSequence) f.mo29444h(), (CharSequence) str, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static ababb m14951f() {
        aacca aacca = aacca.f12035a;
        return (ababb) ababa.m15062f();
    }

    /* renamed from: a */
    public final void mo29389a() {
        aacca aacca = aacca.f12035a;
        aacca.m15030a((ababa) new ababb());
    }

    /* renamed from: a */
    public final boolean mo29405a(OguryChoiceManager.TcfV1.Purpose purpose) {
        accbb.m15218b(purpose, "purpose");
        int ordinal = purpose.ordinal() + 1;
        return aaaba.m14923a(ordinal, new Integer[0], (accac<? super Integer, Boolean>) new aaaaa(this, ordinal));
    }

    /* renamed from: b */
    public final /* synthetic */ ababa mo29397b() {
        return m14951f();
    }

    /* renamed from: c */
    public final Integer[] mo29399c() {
        return new Integer[]{1};
    }
}
