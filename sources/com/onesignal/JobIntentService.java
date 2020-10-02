package com.onesignal;

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
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

abstract class JobIntentService extends Service {

    /* renamed from: g */
    static final Object f12236g = new Object();

    /* renamed from: h */
    static final HashMap<ComponentNameWithWakeful, WorkEnqueuer> f12237h = new HashMap<>();

    /* renamed from: a */
    CompatJobEngine f12238a;

    /* renamed from: b */
    WorkEnqueuer f12239b;

    /* renamed from: c */
    CommandProcessor f12240c;

    /* renamed from: d */
    boolean f12241d = false;

    /* renamed from: e */
    boolean f12242e = false;

    /* renamed from: f */
    final ArrayList<CompatWorkItem> f12243f = new ArrayList<>();

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a = JobIntentService.this.mo29637a();
                if (a == null) {
                    return null;
                }
                JobIntentService.this.mo29635a(a.getIntent());
                a.complete();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled(Void voidR) {
            JobIntentService.this.mo29641d();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.mo29641d();
        }
    }

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.mContext = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.mLaunchWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.mRunWakeLock = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        public void enqueueWork(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.mComponentName);
            if (this.mContext.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.mLaunchingService) {
                        this.mLaunchingService = true;
                        if (!this.mServiceProcessing) {
                            this.mLaunchWakeLock.acquire(60000);
                        }
                    }
                }
            }
        }

        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.mServiceProcessing) {
                    if (this.mLaunchingService) {
                        this.mLaunchWakeLock.acquire(60000);
                    }
                    this.mServiceProcessing = false;
                    this.mRunWakeLock.release();
                }
            }
        }

        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.mServiceProcessing) {
                    this.mServiceProcessing = true;
                    this.mRunWakeLock.acquire(600000);
                    this.mLaunchWakeLock.release();
                }
            }
        }

        public void serviceStartReceived() {
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }
    }

    final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;

        CompatWorkItem(Intent intent, int i) {
            this.mIntent = intent;
            this.mStartId = i;
        }

        public void complete() {
            JobIntentService.this.stopSelf(this.mStartId);
        }

        public Intent getIntent() {
            return this.mIntent;
        }
    }

    private static class ComponentNameWithWakeful {
        private ComponentName componentName;
        private boolean useWakefulService;

        ComponentNameWithWakeful(ComponentName componentName2, boolean z) {
            this.componentName = componentName2;
            this.useWakefulService = z;
        }
    }

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock = new Object();
        JobParameters mParams;
        final JobIntentService mService;

        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.mJobWork = jobWorkItem;
            }

            public void complete() {
                synchronized (JobServiceEngineImpl.this.mLock) {
                    if (JobServiceEngineImpl.this.mParams != null) {
                        try {
                            JobServiceEngineImpl.this.mParams.completeWork(this.mJobWork);
                        } catch (SecurityException e) {
                            Log.e(JobServiceEngineImpl.TAG, "SecurityException: Failed to run mParams.completeWork(mJobWork)!", e);
                        } catch (IllegalArgumentException e2) {
                            Log.e(JobServiceEngineImpl.TAG, "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!", e2);
                        }
                    }
                }
            }

            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.mService = jobIntentService;
        }

        public IBinder compatGetBinder() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
            if (r1 == null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r1.getIntent().setExtrasClassLoader(r5.mService.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
            return new com.onesignal.JobIntentService.JobServiceEngineImpl.WrapperWorkItem(r5, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.onesignal.JobIntentService.GenericWorkItem dequeueWork() {
            /*
                r5 = this;
                java.lang.Object r0 = r5.mLock
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r5.mParams     // Catch:{ all -> 0x0031 }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0031 }
                return r2
            L_0x000a:
                android.app.job.JobParameters r1 = r5.mParams     // Catch:{ SecurityException -> 0x0027 }
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ SecurityException -> 0x0027 }
                monitor-exit(r0)     // Catch:{ all -> 0x0031 }
                if (r1 == 0) goto L_0x0026
                android.content.Intent r0 = r1.getIntent()
                com.onesignal.JobIntentService r2 = r5.mService
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                com.onesignal.JobIntentService$JobServiceEngineImpl$WrapperWorkItem r0 = new com.onesignal.JobIntentService$JobServiceEngineImpl$WrapperWorkItem
                r0.<init>(r1)
                return r0
            L_0x0026:
                return r2
            L_0x0027:
                r1 = move-exception
                java.lang.String r3 = "JobServiceEngineImpl"
                java.lang.String r4 = "Failed to run mParams.dequeueWork()!"
                android.util.Log.e(r3, r4, r1)     // Catch:{ all -> 0x0031 }
                monitor-exit(r0)     // Catch:{ all -> 0x0031 }
                return r2
            L_0x0031:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0031 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.JobIntentService.JobServiceEngineImpl.dequeueWork():com.onesignal.JobIntentService$GenericWorkItem");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.mParams = jobParameters;
            this.mService.mo29638a(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b = this.mService.mo29639b();
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return b;
        }
    }

    static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(componentName);
            ensureJobId(i);
            this.mJobInfo = new JobInfo.Builder(i, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public void enqueueWork(Intent intent) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(intent));
        }
    }

    static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        WorkEnqueuer(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        /* access modifiers changed from: package-private */
        public abstract void enqueueWork(Intent intent);

        /* access modifiers changed from: package-private */
        public void ensureJobId(int i) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = i;
            } else if (this.mJobId != i) {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.mJobId);
            }
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    /* renamed from: a */
    public static void m15346a(Context context, Class cls, int i, Intent intent, boolean z) {
        m15345a(context, new ComponentName(context, cls), i, intent, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo29635a(Intent intent);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo29639b() {
        CommandProcessor commandProcessor = this.f12240c;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.f12241d);
        }
        return mo29640c();
    }

    /* renamed from: c */
    public boolean mo29640c() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo29641d() {
        ArrayList<CompatWorkItem> arrayList = this.f12243f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f12240c = null;
                if (this.f12243f != null && this.f12243f.size() > 0) {
                    mo29638a(false);
                } else if (!this.f12242e) {
                    this.f12239b.serviceProcessingFinished();
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.f12238a;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f12238a = new JobServiceEngineImpl(this);
            this.f12239b = null;
        }
        this.f12239b = m15344a((Context) this, new ComponentName(this, getClass()), false, 0, true);
    }

    public void onDestroy() {
        super.onDestroy();
        mo29639b();
        synchronized (this.f12243f) {
            this.f12242e = true;
            this.f12239b.serviceProcessingFinished();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.f12239b.serviceStartReceived();
        synchronized (this.f12243f) {
            ArrayList<CompatWorkItem> arrayList = this.f12243f;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i2));
            mo29638a(true);
        }
        return 3;
    }

    /* renamed from: a */
    public static void m15345a(Context context, ComponentName componentName, int i, Intent intent, boolean z) {
        if (intent != null) {
            synchronized (f12236g) {
                WorkEnqueuer a = m15344a(context, componentName, true, i, z);
                a.ensureJobId(i);
                try {
                    a.enqueueWork(intent);
                } catch (IllegalStateException e) {
                    if (z) {
                        m15344a(context, componentName, true, i, false).enqueueWork(intent);
                    } else {
                        throw e;
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    /* renamed from: a */
    static WorkEnqueuer m15344a(Context context, ComponentName componentName, boolean z, int i, boolean z2) {
        WorkEnqueuer workEnqueuer;
        ComponentNameWithWakeful componentNameWithWakeful = new ComponentNameWithWakeful(componentName, z2);
        WorkEnqueuer workEnqueuer2 = f12237h.get(componentNameWithWakeful);
        if (workEnqueuer2 != null) {
            return workEnqueuer2;
        }
        if (Build.VERSION.SDK_INT < 26 || z2) {
            workEnqueuer = new CompatWorkEnqueuer(context, componentName);
        } else if (z) {
            workEnqueuer = new JobWorkEnqueuer(context, componentName, i);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        WorkEnqueuer workEnqueuer3 = workEnqueuer;
        f12237h.put(componentNameWithWakeful, workEnqueuer3);
        return workEnqueuer3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29638a(boolean z) {
        if (this.f12240c == null) {
            this.f12240c = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.f12239b;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.f12240c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public GenericWorkItem mo29637a() {
        GenericWorkItem dequeueWork;
        CompatJobEngine compatJobEngine = this.f12238a;
        if (compatJobEngine != null && (dequeueWork = compatJobEngine.dequeueWork()) != null) {
            return dequeueWork;
        }
        synchronized (this.f12243f) {
            if (this.f12243f.size() <= 0) {
                return null;
            }
            GenericWorkItem remove = this.f12243f.remove(0);
            return remove;
        }
    }
}
