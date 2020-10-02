package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.onesignal.C4564n1;
import com.onesignal.C4686w;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.onesignal.a2 */
/* compiled from: OneSignalSyncServiceUtils */
class C4469a2 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Long f12282a = 0L;

    /* renamed from: b */
    private static Thread f12283b;

    /* renamed from: com.onesignal.a2$a */
    /* compiled from: OneSignalSyncServiceUtils */
    static class C4470a extends C4472c {

        /* renamed from: a */
        Service f12284a;

        C4470a(Service service) {
            this.f12284a = service;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo29707a() {
            C4564n1.m15789a(C4564n1.C4566a0.DEBUG, "LegacySyncRunnable:Stopped");
            this.f12284a.stopSelf();
        }
    }

    /* renamed from: com.onesignal.a2$b */
    /* compiled from: OneSignalSyncServiceUtils */
    static class C4471b extends C4472c {

        /* renamed from: a */
        private JobService f12285a;

        /* renamed from: b */
        private JobParameters f12286b;

        C4471b(JobService jobService, JobParameters jobParameters) {
            this.f12285a = jobService;
            this.f12286b = jobParameters;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo29707a() {
            C4564n1.m15789a(C4564n1.C4566a0.DEBUG, "LollipopSyncRunnable:JobFinished");
            this.f12285a.jobFinished(this.f12286b, false);
        }
    }

    /* renamed from: com.onesignal.a2$c */
    /* compiled from: OneSignalSyncServiceUtils */
    static abstract class C4472c implements Runnable {

        /* renamed from: com.onesignal.a2$c$a */
        /* compiled from: OneSignalSyncServiceUtils */
        class C4473a implements C4686w.C4691e {

            /* renamed from: a */
            final /* synthetic */ BlockingQueue f12287a;

            C4473a(C4472c cVar, BlockingQueue blockingQueue) {
                this.f12287a = blockingQueue;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.onesignal.w$g} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.onesignal.w$g} */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo29709a(com.onesignal.C4686w.C4693g r2) {
                /*
                    r1 = this;
                    if (r2 == 0) goto L_0x0003
                    goto L_0x0008
                L_0x0003:
                    java.lang.Object r2 = new java.lang.Object
                    r2.<init>()
                L_0x0008:
                    java.util.concurrent.BlockingQueue r0 = r1.f12287a
                    r0.offer(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4469a2.C4472c.C4473a.mo29709a(com.onesignal.w$g):void");
            }

            public C4686w.C4696j getType() {
                return C4686w.C4696j.SYNC_SERVICE;
            }
        }

        C4472c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo29707a();

        public final void run() {
            synchronized (C4469a2.class) {
                Long unused = C4469a2.f12282a = 0L;
            }
            if (C4564n1.m15759I() == null) {
                mo29707a();
                return;
            }
            C4564n1.f12493c = C4564n1.m15753C();
            C4742z1.m16477g();
            try {
                ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
                C4686w.m16319a(C4564n1.f12495e, false, new C4473a(this, arrayBlockingQueue));
                Object take = arrayBlockingQueue.take();
                if (take instanceof C4686w.C4693g) {
                    C4742z1.m16464a((C4686w.C4693g) take);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            C4742z1.m16474e(true);
            C4619q.m15979d().mo29913c();
            mo29707a();
        }
    }

    C4469a2() {
    }

    /* renamed from: b */
    private static boolean m15412b() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* renamed from: c */
    static void m15414c(Context context) {
        C4564n1.m15789a(C4564n1.C4566a0.VERBOSE, "scheduleSyncTask:SYNC_AFTER_BG_DELAY_MS: 30000");
        m15417d(context, 30000);
    }

    /* renamed from: d */
    private static PendingIntent m15416d(Context context) {
        return PendingIntent.getService(context, 2071862118, new Intent(context, SyncService.class), 134217728);
    }

    /* renamed from: a */
    static void m15408a(Context context, long j) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.VERBOSE;
        C4564n1.m15789a(a0Var, "scheduleLocationUpdateTask:delayMs: " + j);
        m15417d(context, j);
    }

    /* renamed from: b */
    private static boolean m15413b(Context context) {
        return C4507g.m15529a(context, "android.permission.RECEIVE_BOOT_COMPLETED") == 0;
    }

    /* renamed from: d */
    private static synchronized void m15417d(Context context, long j) {
        synchronized (C4469a2.class) {
            if (f12282a.longValue() == 0 || System.currentTimeMillis() + j <= f12282a.longValue()) {
                if (j < 5000) {
                    j = 5000;
                }
                if (m15412b()) {
                    m15415c(context, j);
                } else {
                    m15411b(context, j);
                }
                f12282a = Long.valueOf(System.currentTimeMillis() + j);
            }
        }
    }

    /* renamed from: b */
    private static void m15411b(Context context, long j) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.VERBOSE;
        C4564n1.m15789a(a0Var, "scheduleServiceSyncTask:atTime: " + j);
        ((AlarmManager) context.getSystemService("alarm")).set(0, System.currentTimeMillis() + j + j, m15416d(context));
    }

    /* renamed from: c */
    private static void m15415c(Context context, long j) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.VERBOSE;
        C4564n1.m15789a(a0Var, "scheduleSyncServiceAsJob:atTime: " + j);
        JobInfo.Builder builder = new JobInfo.Builder(2071862118, new ComponentName(context, SyncJobService.class));
        builder.setMinimumLatency(j).setRequiredNetworkType(1);
        if (m15413b(context)) {
            builder.setPersisted(true);
        }
        try {
            int schedule = ((JobScheduler) context.getSystemService("jobscheduler")).schedule(builder.build());
            C4564n1.C4566a0 a0Var2 = C4564n1.C4566a0.INFO;
            C4564n1.m15789a(a0Var2, "scheduleSyncServiceAsJob:result: " + schedule);
        } catch (NullPointerException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", (Throwable) e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m15407a(android.content.Context r3) {
        /*
            java.lang.Class<com.onesignal.a2> r0 = com.onesignal.C4469a2.class
            monitor-enter(r0)
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0039 }
            f12282a = r1     // Catch:{ all -> 0x0039 }
            boolean r1 = com.onesignal.C4686w.m16326b((android.content.Context) r3)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)
            return
        L_0x0013:
            boolean r1 = m15412b()     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0028
            java.lang.String r1 = "jobscheduler"
            java.lang.Object r3 = r3.getSystemService(r1)     // Catch:{ all -> 0x0039 }
            android.app.job.JobScheduler r3 = (android.app.job.JobScheduler) r3     // Catch:{ all -> 0x0039 }
            r1 = 2071862118(0x7b7e1b66, float:1.3193991E36)
            r3.cancel(r1)     // Catch:{ all -> 0x0039 }
            goto L_0x0037
        L_0x0028:
            java.lang.String r1 = "alarm"
            java.lang.Object r1 = r3.getSystemService(r1)     // Catch:{ all -> 0x0039 }
            android.app.AlarmManager r1 = (android.app.AlarmManager) r1     // Catch:{ all -> 0x0039 }
            android.app.PendingIntent r3 = m15416d(r3)     // Catch:{ all -> 0x0039 }
            r1.cancel(r3)     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r0)
            return
        L_0x0039:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4469a2.m15407a(android.content.Context):void");
    }

    /* renamed from: a */
    static void m15409a(Context context, C4472c cVar) {
        C4564n1.m15865k(context);
        Thread thread = new Thread(cVar, "OS_SYNCSRV_BG_SYNC");
        f12283b = thread;
        thread.start();
    }

    /* renamed from: a */
    static boolean m15410a() {
        Thread thread = f12283b;
        if (thread == null || !thread.isAlive()) {
            return false;
        }
        f12283b.interrupt();
        return true;
    }
}
