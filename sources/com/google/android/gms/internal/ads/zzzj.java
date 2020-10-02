package com.google.android.gms.internal.ads;

import android.os.Environment;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzzj implements Callable<Boolean> {
    zzzj() {
    }

    public final /* synthetic */ Object call() throws Exception {
        return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
    }
}
