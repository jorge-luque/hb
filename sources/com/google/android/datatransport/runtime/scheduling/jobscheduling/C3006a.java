package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.drive.DriveFile;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.p105t.C3416a;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;
import p093e.p101c.p102a.p103a.p104i.p110x.C3475a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.a */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class C3006a implements C3030s {

    /* renamed from: a */
    private final Context f8366a;

    /* renamed from: b */
    private final C3435c f8367b;

    /* renamed from: c */
    private AlarmManager f8368c;

    /* renamed from: d */
    private final C3014g f8369d;

    /* renamed from: e */
    private final C3469a f8370e;

    public C3006a(Context context, C3435c cVar, C3469a aVar, C3014g gVar) {
        this(context, cVar, (AlarmManager) context.getSystemService("alarm"), aVar, gVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo12975a(Intent intent) {
        return PendingIntent.getBroadcast(this.f8366a, 0, intent, DriveFile.MODE_WRITE_ONLY) != null;
    }

    /* renamed from: a */
    public void mo12974a(C3406l lVar, int i) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", lVar.mo19184a());
        builder.appendQueryParameter("priority", String.valueOf(C3475a.m11523a(lVar.mo19186c())));
        if (lVar.mo19185b() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(lVar.mo19185b(), 0));
        }
        Intent intent = new Intent(this.f8366a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i);
        if (mo12975a(intent)) {
            C3416a.m11379a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", (Object) lVar);
            return;
        }
        long b = this.f8367b.mo19245b(lVar);
        long a = this.f8369d.mo12994a(lVar.mo19186c(), b, i);
        C3416a.m11381a("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", lVar, Long.valueOf(a), Long.valueOf(b), Integer.valueOf(i));
        this.f8368c.set(3, this.f8370e.mo19256a() + a, PendingIntent.getBroadcast(this.f8366a, 0, intent, 0));
    }

    C3006a(Context context, C3435c cVar, AlarmManager alarmManager, C3469a aVar, C3014g gVar) {
        this.f8366a = context;
        this.f8367b = cVar;
        this.f8368c = alarmManager;
        this.f8370e = aVar;
        this.f8369d = gVar;
    }
}
