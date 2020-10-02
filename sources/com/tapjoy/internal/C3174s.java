package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.s */
public final class C3174s extends ContentHandler {

    /* renamed from: a */
    public static final C3174s f8852a = new C3174s();

    private C3174s() {
    }

    @Nullable
    /* renamed from: a */
    private static Bitmap m10463a(URLConnection uRLConnection) {
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            return C5267t.f14458a.mo18608b(inputStream);
        } finally {
            inputStream.close();
        }
    }

    @Nullable
    public final /* synthetic */ Object getContent(URLConnection uRLConnection) {
        return m10463a(uRLConnection);
    }

    @Nullable
    /* renamed from: a */
    public static Bitmap m10462a(InputStream inputStream) {
        try {
            return C5267t.f14458a.mo18608b(inputStream);
        } finally {
            inputStream.close();
        }
    }
}
