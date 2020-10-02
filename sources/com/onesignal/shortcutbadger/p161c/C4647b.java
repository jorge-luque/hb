package com.onesignal.shortcutbadger.p161c;

import android.database.Cursor;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.onesignal.shortcutbadger.c.b */
/* compiled from: CloseHelper */
public class C4647b {
    /* renamed from: a */
    public static void m16103a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    /* renamed from: a */
    public static void m16104a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
