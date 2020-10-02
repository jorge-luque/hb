package com.tapjoy.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.bg */
public final class C3124bg {
    /* renamed from: a */
    public static String m10225a(File file, Charset charset) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return C5250jy.m17615a(new InputStreamReader(fileInputStream, charset));
        } finally {
            C3168jz.m10439a(fileInputStream);
        }
    }

    /* renamed from: a */
    public static void m10226a(OutputStream outputStream, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, C4888ak.f13355c);
        outputStreamWriter.write(str);
        outputStreamWriter.flush();
    }

    @Nullable
    /* renamed from: a */
    public static String m10224a(File file) {
        try {
            return m10225a(file, C4888ak.f13355c);
        } catch (IOException unused) {
            return null;
        }
    }
}
