package com.ogury.crashreport;

/* compiled from: PhoneInfo.kt */
public final class red255 {

    /* renamed from: a */
    public static final rtf1 f12223a = new rtf1((byte) 0);

    /* renamed from: b */
    private final String f12224b;

    /* renamed from: c */
    private final String f12225c;

    /* renamed from: d */
    private final green255 f12226d;

    /* compiled from: PhoneInfo.kt */
    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte b) {
            this();
        }
    }

    public red255(String str, String str2, green255 green255) {
        tx7920.m15333b(str, "phoneModel");
        tx7920.m15333b(str2, "androidVersion");
        tx7920.m15333b(green255, "memory");
        this.f12224b = str;
        this.f12225c = str2;
        this.f12226d = green255;
    }

    /* renamed from: a */
    public final String mo29609a() {
        return this.f12224b;
    }

    /* renamed from: b */
    public final String mo29610b() {
        return this.f12225c;
    }

    /* renamed from: c */
    public final green255 mo29611c() {
        return this.f12226d;
    }
}
