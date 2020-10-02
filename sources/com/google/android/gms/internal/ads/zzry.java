package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzry {
    private final Object zzbsi = new Object();
    @GuardedBy("poolLock")
    private boolean zzbsj = false;
}
