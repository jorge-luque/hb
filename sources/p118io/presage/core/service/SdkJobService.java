package p118io.presage.core.service;

import admost.sdk.base.AdMost;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import p118io.presage.core.C6302f2;
import p118io.presage.core.C6317j1;
import p118io.presage.core.IIIIIIll;
import p118io.presage.core.IIIIlIlI;
import p118io.presage.core.IIIIlIll;

/* renamed from: io.presage.core.service.SdkJobService */
public class SdkJobService extends JobService implements IIIIlIlI {
    public Context IIIIIIII;
    public IIIIIIll IIIIIIIl;
    public JobParameters IIIIIIlI;
    public Handler IIIIIIll;
    public BroadcastReceiver IIIIIlII;

    /* renamed from: io.presage.core.service.SdkJobService$IIIIIIII */
    public class IIIIIIII implements C6317j1 {

        /* renamed from: io.presage.core.service.SdkJobService$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6861IIIIIIII extends BroadcastReceiver {

            /* renamed from: io.presage.core.service.SdkJobService$IIIIIIII$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
            public class C6862IIIIIIII implements Runnable {
                public C6862IIIIIIII() {
                }

                public void run() {
                    SdkJobService sdkJobService = SdkJobService.this;
                    sdkJobService.IIIIIIIl.IIIIIIII(false, sdkJobService, AdMost.AD_ERROR_WATERFALL_EMPTY);
                }
            }

            public C6861IIIIIIII() {
            }

            public void onReceive(Context context, Intent intent) {
                intent.getAction();
                SdkJobService.this.IIIIIIll.postDelayed(new C6862IIIIIIII(), 50);
                if (Build.VERSION.SDK_INT >= 26) {
                    Context context2 = SdkJobService.this.IIIIIIII;
                    if (C6302f2.IIIIlIlI == null) {
                        C6302f2.IIIIlIlI = new C6302f2(context2);
                    }
                    C6302f2.IIIIlIlI.IIIIIllI();
                }
            }
        }

        public IIIIIIII() {
        }

        public void IIIIIIII(boolean z, Exception exc) {
            if (z) {
                SdkJobService sdkJobService = SdkJobService.this;
                Context context = sdkJobService.IIIIIIII;
                if (IIIIIIll.IIIIIIll == null) {
                    IIIIIIll.IIIIIIll = new IIIIIIll(context);
                }
                sdkJobService.IIIIIIIl = IIIIIIll.IIIIIIll;
                SdkJobService.this.IIIIIIll = new Handler();
                SdkJobService.this.IIIIIlII = new C6861IIIIIIII();
                IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
                SdkJobService sdkJobService2 = SdkJobService.this;
                sdkJobService2.registerReceiver(sdkJobService2.IIIIIlII, intentFilter);
                int i = SdkJobService.this.IIIIIIlI.getTransientExtras().getInt("c133dd6f", -1);
                String string = SdkJobService.this.IIIIIIlI.getTransientExtras().getString("34eb4c4e");
                if (string == null) {
                    SdkJobService sdkJobService3 = SdkJobService.this;
                    sdkJobService3.jobFinished(sdkJobService3.IIIIIIlI, false);
                }
                if (string.equals("80437a44")) {
                    SdkJobService sdkJobService4 = SdkJobService.this;
                    IIIIIIll iIIIIIll = sdkJobService4.IIIIIIIl;
                    String string2 = sdkJobService4.IIIIIIlI.getTransientExtras().getString("0f902406");
                    iIIIIIll.IIIIIIII(0, SdkJobService.this, i, string2);
                    return;
                } else if (string.equals("2b020927")) {
                    SdkJobService sdkJobService5 = SdkJobService.this;
                    sdkJobService5.IIIIIIIl.IIIIIIII(1, sdkJobService5, i, new Object[0]);
                    return;
                } else if (string.equals("df77b6b3")) {
                    SdkJobService sdkJobService6 = SdkJobService.this;
                    sdkJobService6.IIIIIIIl.IIIIIIII(2, sdkJobService6, i, new Object[0]);
                    return;
                }
            }
            SdkJobService sdkJobService7 = SdkJobService.this;
            sdkJobService7.jobFinished(sdkJobService7.IIIIIIlI, false);
        }
    }

    public void IIIIIIII() {
        try {
            if (this.IIIIIIlI != null) {
                jobFinished(this.IIIIIIlI, false);
            }
        } catch (Exception unused) {
        }
    }

    public void onCreate() {
    }

    public void onDestroy() {
        try {
            if (this.IIIIIlII != null) {
                unregisterReceiver(this.IIIIIlII);
            }
        } catch (IllegalArgumentException unused) {
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        if (jobParameters.getTransientExtras() == null) {
            jobFinished(jobParameters, false);
            return false;
        }
        this.IIIIIIII = getApplicationContext();
        this.IIIIIIlI = jobParameters;
        try {
            IIIIlIll.IIIIIIII((C6317j1) new IIIIIIII());
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        IIIIIIll iIIIIIll = this.IIIIIIIl;
        if (iIIIIIll != null) {
            iIIIIIll.IIIIIIII(true, this, 600);
        }
        return true;
    }

    public void onTrimMemory(int i) {
    }
}
