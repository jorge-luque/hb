package com.applovin.impl.mediation.p037a.p038a;

import android.text.SpannedString;
import com.applovin.sdk.C2057R;

/* renamed from: com.applovin.impl.mediation.a.a.c */
public abstract class C1649c {

    /* renamed from: a */
    protected C1650a f5146a;

    /* renamed from: b */
    protected SpannedString f5147b;

    /* renamed from: c */
    protected SpannedString f5148c;

    /* renamed from: com.applovin.impl.mediation.a.a.c$a */
    public enum C1650a {
        SECTION(0),
        SIMPLE(1),
        DETAIL(2),
        RIGHT_DETAIL(3),
        COUNT(4);
        

        /* renamed from: f */
        private final int f5155f;

        private C1650a(int i) {
            this.f5155f = i;
        }

        /* renamed from: a */
        public int mo7649a() {
            return this.f5155f;
        }

        /* renamed from: b */
        public int mo7650b() {
            if (this == SECTION) {
                return C2057R.layout.list_section;
            }
            if (this == SIMPLE) {
                return 17367043;
            }
            return this == DETAIL ? C2057R.layout.list_item_detail : C2057R.layout.list_item_right_detail;
        }
    }

    public C1649c(C1650a aVar) {
        this.f5146a = aVar;
    }

    /* renamed from: a */
    public static int m6288a() {
        return C1650a.COUNT.mo7649a();
    }

    /* renamed from: b */
    public boolean mo7640b() {
        return false;
    }

    /* renamed from: c */
    public SpannedString mo7641c() {
        return this.f5147b;
    }

    /* renamed from: d */
    public SpannedString mo7642d() {
        return this.f5148c;
    }

    /* renamed from: e */
    public int mo7643e() {
        return this.f5146a.mo7649a();
    }

    /* renamed from: f */
    public int mo7644f() {
        return this.f5146a.mo7650b();
    }

    /* renamed from: g */
    public int mo7645g() {
        return 0;
    }

    /* renamed from: h */
    public int mo7646h() {
        return 0;
    }

    /* renamed from: i */
    public int mo7647i() {
        return 0;
    }

    /* renamed from: j */
    public int mo7648j() {
        return 0;
    }
}
