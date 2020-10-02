package com.ogury.p159cm;

import com.ogury.core.OguryError;
import java.util.Date;

/* renamed from: com.ogury.cm.aacca */
public final class aacca {

    /* renamed from: a */
    public static final aacca f12035a = new aacca();

    /* renamed from: b */
    private static int f12036b = 1;

    /* renamed from: c */
    private static ababa f12037c = new ababb();

    /* renamed from: d */
    private static accca f12038d = new accca();

    /* renamed from: e */
    private static Date f12039e = new Date();

    /* renamed from: f */
    private static abbca f12040f = new abbca(true, (OguryError) null, 2, (baaca) null);

    /* renamed from: g */
    private static String f12041g = "";

    /* renamed from: h */
    private static String f12042h = "";

    /* renamed from: i */
    private static String f12043i = "";

    private aacca() {
    }

    /* renamed from: a */
    public static int m15027a() {
        return f12036b;
    }

    /* renamed from: a */
    public static void m15028a(int i) {
        f12036b = i;
    }

    /* renamed from: a */
    public static void m15029a(long j) {
        f12039e.setTime(j);
    }

    /* renamed from: a */
    public static void m15030a(ababa ababa) {
        accbb.m15218b(ababa, "<set-?>");
        f12037c = ababa;
    }

    /* renamed from: a */
    public static void m15031a(abbca abbca) {
        accbb.m15218b(abbca, "<set-?>");
        f12040f = abbca;
    }

    /* renamed from: a */
    public static void m15032a(String str) {
        accbb.m15218b(str, "<set-?>");
        f12041g = str;
    }

    /* renamed from: a */
    public static void m15033a(Date date) {
        accbb.m15218b(date, "<set-?>");
        f12039e = date;
    }

    /* renamed from: b */
    public static ababa m15034b() {
        return f12037c;
    }

    /* renamed from: b */
    public static void m15035b(ababa ababa) {
        accbb.m15218b(ababa, "consentResult");
        m15044i();
        f12038d = new accca();
        f12039e = new Date();
        f12041g = "";
        f12042h = "";
        f12043i = "";
        f12037c = ababa;
    }

    /* renamed from: b */
    public static void m15036b(String str) {
        accbb.m15218b(str, "<set-?>");
        f12042h = str;
    }

    /* renamed from: c */
    public static accca m15037c() {
        return f12038d;
    }

    /* renamed from: c */
    public static void m15038c(String str) {
        accbb.m15218b(str, "<set-?>");
        f12043i = str;
    }

    /* renamed from: d */
    public static Date m15039d() {
        return f12039e;
    }

    /* renamed from: e */
    public static abbca m15040e() {
        return f12040f;
    }

    /* renamed from: f */
    public static String m15041f() {
        return f12041g;
    }

    /* renamed from: g */
    public static String m15042g() {
        return f12042h;
    }

    /* renamed from: h */
    public static String m15043h() {
        return f12043i;
    }

    /* renamed from: i */
    public static void m15044i() {
        f12040f = new abbca(true, (OguryError) null, 2, (baaca) null);
    }

    /* renamed from: j */
    public static boolean m15045j() {
        return f12040f.mo29482a();
    }
}
