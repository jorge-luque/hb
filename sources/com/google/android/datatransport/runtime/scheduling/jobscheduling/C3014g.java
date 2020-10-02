package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3009d;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p093e.p101c.p102a.p103a.C3380d;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class C3014g {

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g$a */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static class C3015a {

        /* renamed from: a */
        private C3469a f8385a;

        /* renamed from: b */
        private Map<C3380d, C3016b> f8386b = new HashMap();

        /* renamed from: a */
        public C3015a mo12997a(C3469a aVar) {
            this.f8385a = aVar;
            return this;
        }

        /* renamed from: a */
        public C3015a mo12996a(C3380d dVar, C3016b bVar) {
            this.f8386b.put(dVar, bVar);
            return this;
        }

        /* renamed from: a */
        public C3014g mo12998a() {
            if (this.f8385a == null) {
                throw new NullPointerException("missing required property: clock");
            } else if (this.f8386b.keySet().size() >= C3380d.m11266a().length) {
                Map<C3380d, C3016b> map = this.f8386b;
                this.f8386b = new HashMap();
                return C3014g.m9905a(this.f8385a, map);
            } else {
                throw new IllegalStateException("Not all priorities have been configured");
            }
        }
    }

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class C3016b {

        /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g$b$a */
        /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
        public static abstract class C3017a {
            /* renamed from: a */
            public abstract C3017a mo12988a(long j);

            /* renamed from: a */
            public abstract C3017a mo12989a(Set<C3018c> set);

            /* renamed from: a */
            public abstract C3016b mo12990a();

            /* renamed from: b */
            public abstract C3017a mo12991b(long j);
        }

        /* renamed from: d */
        public static C3017a m9916d() {
            C3009d.C3011b bVar = new C3009d.C3011b();
            bVar.mo12989a((Set<C3018c>) Collections.emptySet());
            return bVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract long mo12982a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract Set<C3018c> mo12983b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract long mo12984c();
    }

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g$c */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public enum C3018c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING;

        static {
            NETWORK_UNMETERED = new C3018c("NETWORK_UNMETERED", 0);
            DEVICE_IDLE = new C3018c("DEVICE_IDLE", 1);
            DEVICE_CHARGING = new C3018c("DEVICE_CHARGING", 2);
        }
    }

    /* renamed from: a */
    public static C3014g m9904a(C3469a aVar) {
        C3015a c = m9908c();
        C3380d dVar = C3380d.f9442a;
        C3016b.C3017a d = C3016b.m9916d();
        d.mo12988a(30000);
        d.mo12991b(86400000);
        c.mo12996a(dVar, d.mo12990a());
        C3380d dVar2 = C3380d.HIGHEST;
        C3016b.C3017a d2 = C3016b.m9916d();
        d2.mo12988a(1000);
        d2.mo12991b(86400000);
        c.mo12996a(dVar2, d2.mo12990a());
        C3380d dVar3 = C3380d.VERY_LOW;
        C3016b.C3017a d3 = C3016b.m9916d();
        d3.mo12988a(86400000);
        d3.mo12991b(86400000);
        d3.mo12989a((Set<C3018c>) m9906a((T[]) new C3018c[]{C3018c.NETWORK_UNMETERED, C3018c.DEVICE_IDLE}));
        c.mo12996a(dVar3, d3.mo12990a());
        c.mo12997a(aVar);
        return c.mo12998a();
    }

    /* renamed from: c */
    public static C3015a m9908c() {
        return new C3015a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C3469a mo12977a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract Map<C3380d, C3016b> mo12978b();

    /* renamed from: a */
    static C3014g m9905a(C3469a aVar, Map<C3380d, C3016b> map) {
        return new C3008c(aVar, map);
    }

    /* renamed from: a */
    public long mo12994a(C3380d dVar, long j, int i) {
        long a = j - mo12977a().mo19256a();
        C3016b bVar = mo12978b().get(dVar);
        return Math.min(Math.max(((long) Math.pow(2.0d, (double) (i - 1))) * bVar.mo12982a(), a), bVar.mo12984c());
    }

    /* renamed from: a */
    public JobInfo.Builder mo12995a(JobInfo.Builder builder, C3380d dVar, long j, int i) {
        builder.setMinimumLatency(mo12994a(dVar, j, i));
        m9907a(builder, mo12978b().get(dVar).mo12983b());
        return builder;
    }

    /* renamed from: a */
    private void m9907a(JobInfo.Builder builder, Set<C3018c> set) {
        if (set.contains(C3018c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(C3018c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(C3018c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    /* renamed from: a */
    private static <T> Set<T> m9906a(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }
}
