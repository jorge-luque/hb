package p118io.presage.core;

import admost.sdk.base.AdMost;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: io.presage.core.e2 */
public abstract class C6298e2 extends JobService {
    public boolean IIIIIIII;
    public BroadcastReceiver IIIIIIIl;

    /* renamed from: io.presage.core.e2$IIIIIIII */
    public class IIIIIIII extends BroadcastReceiver {
        public IIIIIIII(C6298e2 e2Var) {
        }

        public void onReceive(Context context, Intent intent) {
            intent.getAction();
            if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                IIIIlIll.IIIIIIII(context, 400);
            }
        }
    }

    public void onDestroy() {
        if (!this.IIIIIIII) {
            try {
                if (this.IIIIIIIl != null) {
                    unregisterReceiver(this.IIIIIIIl);
                }
            } catch (IllegalArgumentException unused) {
            }
        } else {
            IIIIlIll.IIIIIIII(getApplicationContext(), IIIIllIl.IIIIIIII(getApplicationContext()).IIIIIIII(), false);
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        IIIIlIll.IIIIIIII((Context) this, (int) AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID);
        this.IIIIIIII = true;
        if (jobParameters.getExtras().containsKey("25dfee1e")) {
            this.IIIIIIII = jobParameters.getExtras().getBoolean("25dfee1e", true);
        }
        if (this.IIIIIIII) {
            jobFinished(jobParameters, false);
        } else {
            this.IIIIIIIl = new IIIIIIII(this);
            registerReceiver(this.IIIIIIIl, new IntentFilter("android.intent.action.USER_PRESENT"));
        }
        return !this.IIIIIIII;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return !this.IIIIIIII;
    }
}
