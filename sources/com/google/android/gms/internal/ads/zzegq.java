package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzegq extends zzegr {
    private Logger logger;

    public zzegq(String str) {
        this.logger = Logger.getLogger(str);
    }

    public final void zzig(String str) {
        this.logger.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
