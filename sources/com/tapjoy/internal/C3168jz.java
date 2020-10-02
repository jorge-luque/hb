package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.jz */
public final class C3168jz {

    /* renamed from: a */
    static final Logger f8844a = Logger.getLogger(C3168jz.class.getName());

    private C3168jz() {
    }

    /* renamed from: a */
    public static void m10439a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                try {
                    f8844a.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
                } catch (IOException e2) {
                    f8844a.log(Level.SEVERE, "IOException should not have been thrown.", e2);
                }
            }
        }
    }
}
