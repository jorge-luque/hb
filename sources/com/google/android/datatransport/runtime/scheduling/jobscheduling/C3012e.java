package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.loopj.android.http.C4250c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.p105t.C3416a;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;
import p093e.p101c.p102a.p103a.p104i.p110x.C3475a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.e */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class C3012e implements C3030s {

    /* renamed from: a */
    private final Context f8380a;

    /* renamed from: b */
    private final C3435c f8381b;

    /* renamed from: c */
    private final C3014g f8382c;

    public C3012e(Context context, C3435c cVar, C3014g gVar) {
        this.f8380a = context;
        this.f8381b = cVar;
        this.f8382c = gVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo12992a(C3406l lVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f8380a.getPackageName().getBytes(Charset.forName(C4250c.DEFAULT_CHARSET)));
        adler32.update(lVar.mo19184a().getBytes(Charset.forName(C4250c.DEFAULT_CHARSET)));
        adler32.update(ByteBuffer.allocate(4).putInt(C3475a.m11523a(lVar.mo19186c())).array());
        if (lVar.mo19185b() != null) {
            adler32.update(lVar.mo19185b());
        }
        return (int) adler32.getValue();
    }

    /* renamed from: a */
    private boolean m9900a(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo next : jobScheduler.getAllPendingJobs()) {
            int i3 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i) {
                if (i3 >= i2) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo12974a(C3406l lVar, int i) {
        ComponentName componentName = new ComponentName(this.f8380a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f8380a.getSystemService("jobscheduler");
        int a = mo12992a(lVar);
        if (m9900a(jobScheduler, a, i)) {
            C3416a.m11379a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", (Object) lVar);
            return;
        }
        long b = this.f8381b.mo19245b(lVar);
        C3014g gVar = this.f8382c;
        JobInfo.Builder builder = new JobInfo.Builder(a, componentName);
        gVar.mo12995a(builder, lVar.mo19186c(), b, i);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", lVar.mo19184a());
        persistableBundle.putInt("priority", C3475a.m11523a(lVar.mo19186c()));
        if (lVar.mo19185b() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(lVar.mo19185b(), 0));
        }
        builder.setExtras(persistableBundle);
        C3416a.m11381a("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", lVar, Integer.valueOf(a), Long.valueOf(this.f8382c.mo12994a(lVar.mo19186c(), b, i)), Long.valueOf(b), Integer.valueOf(i));
        jobScheduler.schedule(builder.build());
    }
}
