package com.ogury.crashreport;

import java.io.File;

/* compiled from: CrashUploader.kt */
public final class fswiss {

    /* renamed from: a */
    private final cocoartf1671 f12210a;

    /* renamed from: b */
    private final fonttbl f12211b;

    /* compiled from: CrashUploader.kt */
    static final class ansi extends tx8640 implements tx6480<vieww10800> {

        /* renamed from: a */
        private /* synthetic */ fswiss f12212a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ansi(fswiss fswiss) {
            super(0);
            this.f12212a = fswiss;
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ Object mo29600a() {
            fswiss.m15292a(this.f12212a);
            return vieww10800.f12233a;
        }
    }

    /* compiled from: CrashUploader.kt */
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

    public fswiss(cocoartf1671 cocoartf1671, fonttbl fonttbl) {
        tx7920.m15333b(cocoartf1671, "crashFileStore");
        tx7920.m15333b(fonttbl, "crashReportDao");
        this.f12210a = cocoartf1671;
        this.f12211b = fonttbl;
    }

    /* renamed from: a */
    public static final /* synthetic */ void m15292a(fswiss fswiss) {
        try {
            for (File file : fswiss.f12210a.mo29592a()) {
                String a = cocoartf1671.m15283a(file);
                if (!(a.length() == 0)) {
                    ansicpg1252 ansicpg1252 = ansicpg1252.f12190a;
                    String str = "[" + a + ']';
                    fonttbl fonttbl = fswiss.f12211b;
                    String name = file.getName();
                    tx7920.m15330a((Object) name, "file.name");
                    if (ansicpg1252.m15278a(str, fonttbl.mo29596a(name)) < 500) {
                        cocoartf1671 cocoartf1671 = fswiss.f12210a;
                        tx7920.m15333b(file, "file");
                        Helvetica.m15273a(file);
                    }
                }
            }
        } catch (Exception e) {
            C4454f0 f0Var = C4454f0.f12201a;
            C4454f0.m15288a(e);
        }
    }
}
