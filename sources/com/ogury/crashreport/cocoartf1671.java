package com.ogury.crashreport;

import android.content.Context;
import android.os.Build;
import com.ogury.crashreport.green255;
import com.ogury.crashreport.red255;
import com.ogury.crashreport.rtf1;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/* compiled from: CrashFileStore.kt */
public final class cocoartf1671 {

    /* renamed from: a */
    private final rtf1 f12193a;

    /* renamed from: b */
    private final cocoasubrtf100 f12194b;

    /* renamed from: c */
    private final Helvetica f12195c;

    public cocoartf1671(Context context, cocoasubrtf100 cocoasubrtf100, Helvetica helvetica) {
        tx7920.m15333b(context, "context");
        tx7920.m15333b(cocoasubrtf100, "crashFormatter");
        tx7920.m15333b(helvetica, "fileStore");
        this.f12194b = cocoasubrtf100;
        this.f12195c = helvetica;
        rtf1.C6851rtf1 rtf1 = rtf1.f12227a;
        this.f12193a = rtf1.C6851rtf1.m15316a(context);
    }

    /* renamed from: a */
    public final void mo29591a(Throwable th) throws IOException {
        green255 green255;
        File file;
        Throwable th2 = th;
        tx7920.m15333b(th2, "throwable");
        red255.rtf1 rtf1 = red255.f12223a;
        String str = Build.MODEL;
        tx7920.m15330a((Object) str, "Build.MODEL");
        String str2 = Build.VERSION.RELEASE;
        tx7920.m15330a((Object) str2, "Build.VERSION.RELEASE");
        green255.rtf1 rtf12 = green255.f12213a;
        Runtime runtime = Runtime.getRuntime();
        if (runtime != null) {
            green255 = new green255(runtime.freeMemory(), runtime.totalMemory(), runtime.maxMemory(), true);
        } else {
            green255 = new green255(0, 0, 0, false, 15);
        }
        ansi a = this.f12194b.mo29593a(th2, new red255(str, str2, green255), this.f12193a, this.f12195c);
        if (!(a instanceof colortbl) && (a instanceof blue255)) {
            blue255 blue255 = (blue255) a;
            String b = blue255.mo29583b();
            File[] a2 = this.f12195c.mo29578a();
            int length = a2.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    file = null;
                    break;
                }
                file = a2[i];
                String name = file.getName();
                tx7920.m15330a((Object) name, "file.name");
                if (C4457hh.m15301a(name, b, false, 2)) {
                    break;
                }
                i++;
            }
            if (file != null) {
                String a3 = blue255.mo29582a();
                String a4 = m15283a(file);
                PrintWriter printWriter = new PrintWriter(file);
                if (a4.length() == 0) {
                    z = true;
                }
                if (z) {
                    printWriter.print(a3);
                } else {
                    printWriter.print(a4 + ',' + a3);
                }
                printWriter.close();
            }
        }
    }

    /* renamed from: a */
    public static String m15283a(File file) throws Exception {
        tx7920.m15333b(file, "file");
        String str = tx4320.m15322a(file, (Charset) null, 1);
        tx7920.m15330a((Object) str, "sb.toString()");
        return str;
    }

    /* renamed from: a */
    public final File[] mo29592a() {
        return this.f12195c.mo29578a();
    }
}
