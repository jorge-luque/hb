package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: androidx.core.app.f */
/* compiled from: JobIntentService */
public abstract class C0713f extends Service {

    /* renamed from: g */
    static final HashMap<ComponentName, C0722h> f1783g = new HashMap<>();

    /* renamed from: a */
    C0715b f1784a;

    /* renamed from: b */
    C0722h f1785b;

    /* renamed from: c */
    C0714a f1786c;

    /* renamed from: d */
    boolean f1787d = false;

    /* renamed from: e */
    boolean f1788e = false;

    /* renamed from: f */
    final ArrayList<C0717d> f1789f;

    /* renamed from: androidx.core.app.f$b */
    /* compiled from: JobIntentService */
    interface C0715b {
        IBinder compatGetBinder();

        C0718e dequeueWork();
    }

    /* renamed from: androidx.core.app.f$c */
    /* compiled from: JobIntentService */
    static final class C0716c extends C0722h {

        /* renamed from: d */
        private final PowerManager.WakeLock f1791d;

        /* renamed from: e */
        private final PowerManager.WakeLock f1792e;

        /* renamed from: f */
        boolean f1793f;

        /* renamed from: g */
        boolean f1794g;

        C0716c(Context context, ComponentName componentName) {
            super(componentName);
            context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f1791d = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f1792e = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        /* renamed from: a */
        public void mo3892a() {
            synchronized (this) {
                if (this.f1794g) {
                    if (this.f1793f) {
                        this.f1791d.acquire(60000);
                    }
                    this.f1794g = false;
                    this.f1792e.release();
                }
            }
        }

        /* renamed from: b */
        public void mo3893b() {
            synchronized (this) {
                if (!this.f1794g) {
                    this.f1794g = true;
                    this.f1792e.acquire(600000);
                    this.f1791d.release();
                }
            }
        }

        /* renamed from: c */
        public void mo3894c() {
            synchronized (this) {
                this.f1793f = false;
            }
        }
    }

    /* renamed from: androidx.core.app.f$d */
    /* compiled from: JobIntentService */
    final class C0717d implements C0718e {

        /* renamed from: a */
        final Intent f1795a;

        /* renamed from: b */
        final int f1796b;

        C0717d(Intent intent, int i) {
            this.f1795a = intent;
            this.f1796b = i;
        }

        public void complete() {
            C0713f.this.stopSelf(this.f1796b);
        }

        public Intent getIntent() {
            return this.f1795a;
        }
    }

    /* renamed from: androidx.core.app.f$e */
    /* compiled from: JobIntentService */
    interface C0718e {
        void complete();

        Intent getIntent();
    }

    /* renamed from: androidx.core.app.f$f */
    /* compiled from: JobIntentService */
    static final class C0719f extends JobServiceEngine implements C0715b {

        /* renamed from: a */
        final C0713f f1798a;

        /* renamed from: b */
        final Object f1799b = new Object();

        /* renamed from: c */
        JobParameters f1800c;

        /* renamed from: androidx.core.app.f$f$a */
        /* compiled from: JobIntentService */
        final class C0720a implements C0718e {

            /* renamed from: a */
            final JobWorkItem f1801a;

            C0720a(JobWorkItem jobWorkItem) {
                this.f1801a = jobWorkItem;
            }

            public void complete() {
                synchronized (C0719f.this.f1799b) {
                    if (C0719f.this.f1800c != null) {
                        C0719f.this.f1800c.completeWork(this.f1801a);
                    }
                }
            }

            public Intent getIntent() {
                return this.f1801a.getIntent();
            }
        }

        C0719f(C0713f fVar) {
            super(fVar);
            this.f1798a = fVar;
        }

        public IBinder compatGetBinder() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f1798a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            return new androidx.core.app.C0713f.C0719f.C0720a(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r1 == null) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.C0713f.C0718e dequeueWork() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f1799b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f1800c     // Catch:{ all -> 0x0027 }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x000a:
                android.app.job.JobParameters r1 = r3.f1800c     // Catch:{ all -> 0x0027 }
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x0027 }
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                if (r1 == 0) goto L_0x0026
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.f r2 = r3.f1798a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.f$f$a r0 = new androidx.core.app.f$f$a
                r0.<init>(r1)
                return r0
            L_0x0026:
                return r2
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.C0713f.C0719f.dequeueWork():androidx.core.app.f$e");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f1800c = jobParameters;
            this.f1798a.mo3876a(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b = this.f1798a.mo3877b();
            synchronized (this.f1799b) {
                this.f1800c = null;
            }
            return b;
        }
    }

    /* renamed from: androidx.core.app.f$g */
    /* compiled from: JobIntentService */
    static final class C0721g extends C0722h {

        /* renamed from: d */
        private final JobInfo f1803d;

        C0721g(Context context, ComponentName componentName, int i) {
            super(componentName);
            mo3899a(i);
            this.f1803d = new JobInfo.Builder(i, this.f1804a).setOverrideDeadline(0).build();
            JobScheduler jobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    /* renamed from: androidx.core.app.f$h */
    /* compiled from: JobIntentService */
    static abstract class C0722h {

        /* renamed from: a */
        final ComponentName f1804a;

        /* renamed from: b */
        boolean f1805b;

        /* renamed from: c */
        int f1806c;

        C0722h(ComponentName componentName) {
            this.f1804a = componentName;
        }

        /* renamed from: a */
        public void mo3892a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3899a(int i) {
            if (!this.f1805b) {
                this.f1805b = true;
                this.f1806c = i;
            } else if (this.f1806c != i) {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.f1806c);
            }
        }

        /* renamed from: b */
        public void mo3893b() {
        }

        /* renamed from: c */
        public void mo3894c() {
        }
    }

    public C0713f() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1789f = null;
        } else {
            this.f1789f = new ArrayList<>();
        }
    }

    /* renamed from: a */
    static C0722h m2217a(Context context, ComponentName componentName, boolean z, int i) {
        C0722h hVar;
        C0722h hVar2 = f1783g.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new C0716c(context, componentName);
        } else if (z) {
            hVar = new C0721g(context, componentName, i);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        C0722h hVar3 = hVar;
        f1783g.put(componentName, hVar3);
        return hVar3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3875a(Intent intent);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3877b() {
        C0714a aVar = this.f1786c;
        if (aVar != null) {
            aVar.cancel(this.f1787d);
        }
        return mo3878c();
    }

    /* renamed from: c */
    public boolean mo3878c() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo3879d() {
        ArrayList<C0717d> arrayList = this.f1789f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1786c = null;
                if (this.f1789f != null && this.f1789f.size() > 0) {
                    mo3876a(false);
                } else if (!this.f1788e) {
                    this.f1785b.mo3892a();
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        C0715b bVar = this.f1784a;
        if (bVar != null) {
            return bVar.compatGetBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1784a = new C0719f(this);
            this.f1785b = null;
            return;
        }
        this.f1784a = null;
        this.f1785b = m2217a(this, new ComponentName(this, C0713f.class), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<C0717d> arrayList = this.f1789f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1788e = true;
                this.f1785b.mo3892a();
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.f1789f == null) {
            return 2;
        }
        this.f1785b.mo3894c();
        synchronized (this.f1789f) {
            ArrayList<C0717d> arrayList = this.f1789f;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new C0717d(intent, i2));
            mo3876a(true);
        }
        return 3;
    }

    /* renamed from: androidx.core.app.f$a */
    /* compiled from: JobIntentService */
    final class C0714a extends AsyncTask<Void, Void, Void> {
        C0714a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                C0718e a = C0713f.this.mo3874a();
                if (a == null) {
                    return null;
                }
                C0713f.this.mo3875a(a.getIntent());
                a.complete();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            C0713f.this.mo3879d();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Void voidR) {
            C0713f.this.mo3879d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3876a(boolean z) {
        if (this.f1786c == null) {
            this.f1786c = new C0714a();
            C0722h hVar = this.f1785b;
            if (hVar != null && z) {
                hVar.mo3893b();
            }
            this.f1786c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0718e mo3874a() {
        C0715b bVar = this.f1784a;
        if (bVar != null) {
            return bVar.dequeueWork();
        }
        synchronized (this.f1789f) {
            if (this.f1789f.size() <= 0) {
                return null;
            }
            C0718e remove = this.f1789f.remove(0);
            return remove;
        }
    }
}
