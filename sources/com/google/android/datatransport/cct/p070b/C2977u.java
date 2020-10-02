package com.google.android.datatransport.cct.p070b;

import android.util.SparseArray;
import com.google.android.datatransport.cct.p070b.C2960j;
import com.vungle.warren.VungleApiClient;

/* renamed from: com.google.android.datatransport.cct.b.u */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public abstract class C2977u {

    /* renamed from: com.google.android.datatransport.cct.b.u$a */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static abstract class C2978a {
        /* renamed from: a */
        public abstract C2978a mo12934a(C2979b bVar);

        /* renamed from: a */
        public abstract C2978a mo12935a(C2980c cVar);

        /* renamed from: a */
        public abstract C2977u mo12936a();
    }

    /* renamed from: com.google.android.datatransport.cct.b.u$b */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public enum C2979b {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        

        /* renamed from: w */
        private static final SparseArray<C2979b> f8303w = null;

        /* renamed from: a */
        private final int f8304a;

        static {
            UNKNOWN_MOBILE_SUBTYPE = new C2979b("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
            GPRS = new C2979b("GPRS", 1, 1);
            EDGE = new C2979b("EDGE", 2, 2);
            UMTS = new C2979b("UMTS", 3, 3);
            CDMA = new C2979b("CDMA", 4, 4);
            EVDO_0 = new C2979b("EVDO_0", 5, 5);
            EVDO_A = new C2979b("EVDO_A", 6, 6);
            RTT = new C2979b("RTT", 7, 7);
            HSDPA = new C2979b("HSDPA", 8, 8);
            HSUPA = new C2979b("HSUPA", 9, 9);
            HSPA = new C2979b("HSPA", 10, 10);
            IDEN = new C2979b("IDEN", 11, 11);
            EVDO_B = new C2979b("EVDO_B", 12, 12);
            LTE = new C2979b(VungleApiClient.ConnectionTypeDetail.LTE, 13, 13);
            EHRPD = new C2979b("EHRPD", 14, 14);
            HSPAP = new C2979b("HSPAP", 15, 15);
            GSM = new C2979b("GSM", 16, 16);
            TD_SCDMA = new C2979b("TD_SCDMA", 17, 17);
            IWLAN = new C2979b("IWLAN", 18, 18);
            LTE_CA = new C2979b("LTE_CA", 19, 19);
            COMBINED = new C2979b("COMBINED", 20, 100);
            SparseArray<C2979b> sparseArray = new SparseArray<>();
            f8303w = sparseArray;
            sparseArray.put(0, UNKNOWN_MOBILE_SUBTYPE);
            f8303w.put(1, GPRS);
            f8303w.put(2, EDGE);
            f8303w.put(3, UMTS);
            f8303w.put(4, CDMA);
            f8303w.put(5, EVDO_0);
            f8303w.put(6, EVDO_A);
            f8303w.put(7, RTT);
            f8303w.put(8, HSDPA);
            f8303w.put(9, HSUPA);
            f8303w.put(10, HSPA);
            f8303w.put(11, IDEN);
            f8303w.put(12, EVDO_B);
            f8303w.put(13, LTE);
            f8303w.put(14, EHRPD);
            f8303w.put(15, HSPAP);
            f8303w.put(16, GSM);
            f8303w.put(17, TD_SCDMA);
            f8303w.put(18, IWLAN);
            f8303w.put(19, LTE_CA);
        }

        private C2979b(int i) {
            this.f8304a = i;
        }

        /* renamed from: a */
        public static C2979b m9836a(int i) {
            return f8303w.get(i);
        }

        public int zza() {
            return this.f8304a;
        }
    }

    /* renamed from: com.google.android.datatransport.cct.b.u$c */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public enum C2980c {
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17),
        NONE(-1);
        

        /* renamed from: u */
        private static final SparseArray<C2980c> f8324u = null;

        /* renamed from: a */
        private final int f8325a;

        static {
            MOBILE = new C2980c("MOBILE", 0, 0);
            WIFI = new C2980c("WIFI", 1, 1);
            MOBILE_MMS = new C2980c("MOBILE_MMS", 2, 2);
            MOBILE_SUPL = new C2980c("MOBILE_SUPL", 3, 3);
            MOBILE_DUN = new C2980c("MOBILE_DUN", 4, 4);
            MOBILE_HIPRI = new C2980c("MOBILE_HIPRI", 5, 5);
            WIMAX = new C2980c("WIMAX", 6, 6);
            BLUETOOTH = new C2980c("BLUETOOTH", 7, 7);
            DUMMY = new C2980c("DUMMY", 8, 8);
            ETHERNET = new C2980c("ETHERNET", 9, 9);
            MOBILE_FOTA = new C2980c("MOBILE_FOTA", 10, 10);
            MOBILE_IMS = new C2980c("MOBILE_IMS", 11, 11);
            MOBILE_CBS = new C2980c("MOBILE_CBS", 12, 12);
            WIFI_P2P = new C2980c("WIFI_P2P", 13, 13);
            MOBILE_IA = new C2980c("MOBILE_IA", 14, 14);
            MOBILE_EMERGENCY = new C2980c("MOBILE_EMERGENCY", 15, 15);
            PROXY = new C2980c("PROXY", 16, 16);
            VPN = new C2980c("VPN", 17, 17);
            NONE = new C2980c("NONE", 18, -1);
            SparseArray<C2980c> sparseArray = new SparseArray<>();
            f8324u = sparseArray;
            sparseArray.put(0, MOBILE);
            f8324u.put(1, WIFI);
            f8324u.put(2, MOBILE_MMS);
            f8324u.put(3, MOBILE_SUPL);
            f8324u.put(4, MOBILE_DUN);
            f8324u.put(5, MOBILE_HIPRI);
            f8324u.put(6, WIMAX);
            f8324u.put(7, BLUETOOTH);
            f8324u.put(8, DUMMY);
            f8324u.put(9, ETHERNET);
            f8324u.put(10, MOBILE_FOTA);
            f8324u.put(11, MOBILE_IMS);
            f8324u.put(12, MOBILE_CBS);
            f8324u.put(13, WIFI_P2P);
            f8324u.put(14, MOBILE_IA);
            f8324u.put(15, MOBILE_EMERGENCY);
            f8324u.put(16, PROXY);
            f8324u.put(17, VPN);
            f8324u.put(-1, NONE);
        }

        private C2980c(int i) {
            this.f8325a = i;
        }

        /* renamed from: a */
        public static C2980c m9837a(int i) {
            return f8324u.get(i);
        }

        public int zza() {
            return this.f8325a;
        }
    }

    /* renamed from: a */
    public static C2978a m9832a() {
        return new C2960j.C2962b();
    }
}
