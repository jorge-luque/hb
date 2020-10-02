package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3014g;
import java.util.Map;
import p093e.p101c.p102a.p103a.C3380d;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.c */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3008c extends C3014g {

    /* renamed from: a */
    private final C3469a f8372a;

    /* renamed from: b */
    private final Map<C3380d, C3014g.C3016b> f8373b;

    C3008c(C3469a aVar, Map<C3380d, C3014g.C3016b> map) {
        if (aVar != null) {
            this.f8372a = aVar;
            if (map != null) {
                this.f8373b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3469a mo12977a() {
        return this.f8372a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Map<C3380d, C3014g.C3016b> mo12978b() {
        return this.f8373b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3014g)) {
            return false;
        }
        C3014g gVar = (C3014g) obj;
        if (!this.f8372a.equals(gVar.mo12977a()) || !this.f8373b.equals(gVar.mo12978b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f8372a.hashCode() ^ 1000003) * 1000003) ^ this.f8373b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f8372a + ", values=" + this.f8373b + "}";
    }
}
