package com.ogury.crashreport;

import android.content.Context;
import java.io.File;
import java.io.PrintWriter;

/* compiled from: FileStore.kt */
public final class Helvetica {

    /* renamed from: a */
    private final File f12189a;

    /* compiled from: FileStore.kt */
    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte b) {
            this();
        }
    }

    static {
        new rtf1((byte) 0);
    }

    public Helvetica(Context context) {
        tx7920.m15333b(context, "context");
        File file = new File(context.getFilesDir(), "presageDir");
        this.f12189a = file;
        file.mkdirs();
    }

    /* renamed from: a */
    public final File[] mo29578a() {
        File[] listFiles = this.f12189a.listFiles();
        return listFiles == null ? new File[0] : listFiles;
    }

    /* renamed from: a */
    public final boolean mo29577a(String str) {
        tx7920.m15333b(str, "fileName");
        return new File(this.f12189a, str).createNewFile();
    }

    /* renamed from: a */
    public static void m15273a(File file) {
        tx7920.m15333b(file, "file");
        try {
            new PrintWriter(file).print("");
        } catch (Exception e) {
            C4454f0 f0Var = C4454f0.f12201a;
            C4454f0.m15288a(e);
        }
    }
}
