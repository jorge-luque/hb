package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.p122a.C3619a;
import com.google.firebase.iid.C3690a;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.C3855m;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.remoteconfig.internal.k */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3852k {

    /* renamed from: j */
    public static final long f10634j = TimeUnit.HOURS.toSeconds(12);

    /* renamed from: k */
    static final int[] f10635k = {2, 4, 8, 16, 32, 64, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE, 256};

    /* renamed from: a */
    private final FirebaseInstanceId f10636a;

    /* renamed from: b */
    private final C3619a f10637b;

    /* renamed from: c */
    private final Executor f10638c;

    /* renamed from: d */
    private final Clock f10639d;

    /* renamed from: e */
    private final Random f10640e;

    /* renamed from: f */
    private final C3842e f10641f;

    /* renamed from: g */
    private final ConfigFetchHttpClient f10642g;

    /* renamed from: h */
    private final C3855m f10643h;

    /* renamed from: i */
    private final Map<String, String> f10644i;

    /* renamed from: com.google.firebase.remoteconfig.internal.k$a */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static class C3853a {

        /* renamed from: a */
        private final int f10645a;

        /* renamed from: b */
        private final C3845f f10646b;

        /* renamed from: c */
        private final String f10647c;

        private C3853a(Date date, int i, C3845f fVar, String str) {
            this.f10645a = i;
            this.f10646b = fVar;
            this.f10647c = str;
        }

        /* renamed from: a */
        public static C3853a m13036a(C3845f fVar, String str) {
            return new C3853a(fVar.mo27570c(), 0, fVar, str);
        }

        /* renamed from: b */
        public static C3853a m13038b(Date date) {
            return new C3853a(date, 2, (C3845f) null, (String) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo27583c() {
            return this.f10645a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public String mo27582b() {
            return this.f10647c;
        }

        /* renamed from: a */
        public static C3853a m13037a(Date date) {
            return new C3853a(date, 1, (C3845f) null, (String) null);
        }

        /* renamed from: a */
        public C3845f mo27581a() {
            return this.f10646b;
        }
    }

    public C3852k(FirebaseInstanceId firebaseInstanceId, C3619a aVar, Executor executor, Clock clock, Random random, C3842e eVar, ConfigFetchHttpClient configFetchHttpClient, C3855m mVar, Map<String, String> map) {
        this.f10636a = firebaseInstanceId;
        this.f10637b = aVar;
        this.f10638c = executor;
        this.f10639d = clock;
        this.f10640e = random;
        this.f10641f = eVar;
        this.f10642g = configFetchHttpClient;
        this.f10643h = mVar;
        this.f10644i = map;
    }

    /* renamed from: b */
    private boolean m13033b(int i) {
        return i == 429 || i == 502 || i == 503 || i == 504;
    }

    /* renamed from: a */
    public Task<C3853a> mo27579a() {
        return mo27580a(this.f10643h.mo27593e());
    }

    /* renamed from: b */
    private String m13030b(long j) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", new Object[]{DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j))});
    }

    /* renamed from: a */
    public Task<C3853a> mo27580a(long j) {
        if (this.f10643h.mo27594f()) {
            j = 0;
        }
        return this.f10641f.mo27565b().continueWithTask(this.f10638c, C3848g.m13012a(this, j));
    }

    /* renamed from: b */
    private Task<C3853a> m13028b(C3690a aVar, Date date) {
        try {
            C3853a a = m13022a(aVar, date);
            if (a.mo27583c() != 0) {
                return Tasks.forResult(a);
            }
            return this.f10641f.mo27561a(a.mo27581a()).onSuccessTask(this.f10638c, C3851j.m13015a(a));
        } catch (FirebaseRemoteConfigException e) {
            return Tasks.forException(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Task<C3853a> m13017a(Task<C3845f> task, long j) {
        Task<TContinuationResult> task2;
        Date date = new Date(this.f10639d.currentTimeMillis());
        if (task.isSuccessful() && m13026a(j, date)) {
            return Tasks.forResult(C3853a.m13038b(date));
        }
        Date a = m13024a(date);
        if (a != null) {
            task2 = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(m13030b(a.getTime() - date.getTime()), a.getTime()));
        } else {
            task2 = this.f10636a.mo27297b().continueWithTask(this.f10638c, C3849h.m13013a(this, date));
        }
        return task2.continueWithTask(this.f10638c, C3850i.m13014a(this, date));
    }

    /* renamed from: b */
    private void m13032b(Date date) {
        int b = this.f10643h.mo27585a().mo27599b() + 1;
        this.f10643h.mo27586a(b, new Date(date.getTime() + m13016a(b)));
    }

    /* renamed from: b */
    private Map<String, String> m13031b() {
        HashMap hashMap = new HashMap();
        C3619a aVar = this.f10637b;
        if (aVar == null) {
            return hashMap;
        }
        for (Map.Entry next : aVar.mo27197a(false).entrySet()) {
            hashMap.put((String) next.getKey(), next.getValue().toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    static /* synthetic */ Task m13020a(C3852k kVar, Date date, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to get Firebase Instance ID token for fetch.", task.getException()));
        }
        return kVar.m13028b((C3690a) task.getResult(), date);
    }

    /* renamed from: a */
    private boolean m13026a(long j, Date date) {
        Date d = this.f10643h.mo27592d();
        if (d.equals(C3855m.f10650d)) {
            return false;
        }
        return date.before(new Date(d.getTime() + TimeUnit.SECONDS.toMillis(j)));
    }

    /* renamed from: a */
    private Date m13024a(Date date) {
        Date a = this.f10643h.mo27585a().mo27598a();
        if (date.before(a)) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private C3853a m13022a(C3690a aVar, Date date) throws FirebaseRemoteConfigException {
        try {
            C3853a fetch = this.f10642g.fetch(this.f10642g.mo27556a(), aVar.getId(), aVar.getToken(), m13031b(), this.f10643h.mo27591c(), this.f10644i, date);
            if (fetch.mo27582b() != null) {
                this.f10643h.mo27588a(fetch.mo27582b());
            }
            this.f10643h.mo27595g();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e) {
            C3855m.C3856a a = m13023a(e.mo27540a(), date);
            if (m13027a(a, e.mo27540a())) {
                throw new FirebaseRemoteConfigFetchThrottledException(a.mo27598a().getTime());
            }
            throw m13021a(e);
        }
    }

    /* renamed from: a */
    private FirebaseRemoteConfigServerException m13021a(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int a = firebaseRemoteConfigServerException.mo27540a();
        if (a == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (a == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else if (a == 429) {
            throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
        } else if (a != 500) {
            switch (a) {
                case 502:
                case 503:
                case 504:
                    str = "The server is unavailable. Please try again later.";
                    break;
                default:
                    str = "The server returned an unexpected error.";
                    break;
            }
        } else {
            str = "There was an internal server error.";
        }
        int a2 = firebaseRemoteConfigServerException.mo27540a();
        return new FirebaseRemoteConfigServerException(a2, "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    /* renamed from: a */
    private C3855m.C3856a m13023a(int i, Date date) {
        if (m13033b(i)) {
            m13032b(date);
        }
        return this.f10643h.mo27585a();
    }

    /* renamed from: a */
    private long m13016a(int i) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f10635k;
        long millis = timeUnit.toMillis((long) iArr[Math.min(i, iArr.length) - 1]);
        return (millis / 2) + ((long) this.f10640e.nextInt((int) millis));
    }

    /* renamed from: a */
    private boolean m13027a(C3855m.C3856a aVar, int i) {
        return aVar.mo27599b() > 1 || i == 429;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13025a(Task<C3853a> task, Date date) {
        if (task.isSuccessful()) {
            this.f10643h.mo27589a(date);
            return;
        }
        Exception exception = task.getException();
        if (exception != null) {
            if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
                this.f10643h.mo27597i();
            } else {
                this.f10643h.mo27596h();
            }
        }
    }
}
