package com.crashlytics.android.core;

import com.crashlytics.android.core.BinaryImagesConverter;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;

class Sha1FileIdStrategy implements BinaryImagesConverter.FileIdStrategy {
    Sha1FileIdStrategy() {
    }

    private static String getFileSHA(String str) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            try {
                String a = C6090i.m19724a((InputStream) bufferedInputStream2);
                C6090i.m19732a((Closeable) bufferedInputStream2);
                return a;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                C6090i.m19732a((Closeable) bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C6090i.m19732a((Closeable) bufferedInputStream);
            throw th;
        }
    }

    public String createId(File file) throws IOException {
        return getFileSHA(file.getPath());
    }
}
