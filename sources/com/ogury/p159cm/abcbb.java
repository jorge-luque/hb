package com.ogury.p159cm;

/* renamed from: com.ogury.cm.abcbb */
public final class abcbb {

    /* renamed from: a */
    public static final abcbb f12098a = new abcbb();

    private abcbb() {
    }

    /* renamed from: a */
    public static String m15165a(int i) {
        switch (i) {
            case -2:
                return "cloud-service-permission-denied";
            case -1:
                return "cloud-service-network-connection-failed";
            case 0:
                return "ok";
            case 1:
                return "payment-cancelled";
            case 2:
                return "cloud-service-network-connection-failed";
            case 3:
                return "payment-not-allowed";
            case 4:
                return "store-product-not-available";
            case 5:
                return "client-invalid";
            case 7:
                return "item-already-owned";
            default:
                return "unknown";
        }
    }
}
