package com.google.android.gms.games;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class PageDirection {
    public static final int NEXT = 0;
    public static final int NONE = -1;
    public static final int PREV = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public @interface Direction {
    }

    private PageDirection() {
        throw new AssertionError("Uninstantiable");
    }
}
