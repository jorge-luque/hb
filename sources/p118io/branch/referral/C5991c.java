package p118io.branch.referral;

import android.os.AsyncTask;
import android.os.Build;

/* renamed from: io.branch.referral.c */
/* compiled from: BranchAsyncTask */
public abstract class C5991c<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    /* renamed from: a */
    public AsyncTask<Params, Progress, Result> mo33821a(Params... paramsArr) {
        if (Build.VERSION.SDK_INT < 11) {
            return execute(paramsArr);
        }
        try {
            return executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
        } catch (Throwable unused) {
            return execute(paramsArr);
        }
    }
}
