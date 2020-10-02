package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tapjoy.internal.t */
public final class C5267t implements C4907bd {

    /* renamed from: a */
    public static final C5267t f14458a = new C5267t();

    private C5267t() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo18607a(OutputStream outputStream, Object obj) {
        if (!((Bitmap) obj).compress(Bitmap.CompressFormat.PNG, 100, outputStream)) {
            throw new RuntimeException();
        }
    }

    /* renamed from: a */
    public final Bitmap mo18608b(final InputStream inputStream) {
        try {
            return (Bitmap) C5275y.m17679a(new C4905bb() {
                public final /* synthetic */ Object call() {
                    InputStream inputStream = inputStream;
                    if (inputStream instanceof C4906bc) {
                        return BitmapFactory.decodeStream(inputStream);
                    }
                    return BitmapFactory.decodeStream(new C4906bc(inputStream));
                }
            });
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
