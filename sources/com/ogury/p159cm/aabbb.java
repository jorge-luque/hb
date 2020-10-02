package com.ogury.p159cm;

/* renamed from: com.ogury.cm.aabbb */
public final class aabbb {

    /* renamed from: a */
    public static final aaaaa f12010a = new aaaaa((baaca) null);

    /* renamed from: com.ogury.cm.aabbb$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
            if (r3.equals("assetKey-unknown") != false) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
            if (r3.equals("no-such-assetKey") != false) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
            r1 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
            if (r3.equals("assetType-not-matching") != false) goto L_0x0080;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x007e, code lost:
            if (r3.equals("bundle-not-matching") != false) goto L_0x0080;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0080, code lost:
            r1 = 2;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.ogury.core.OguryError m15000a(java.lang.String r3) {
            /*
                if (r3 == 0) goto L_0x00ab
                org.json.JSONObject r3 = com.ogury.p159cm.ConsentActivity.aaaaa.m14882a((java.lang.String) r3)
                if (r3 == 0) goto L_0x00ab
                java.lang.String r0 = "error"
                boolean r1 = r3.has(r0)
                if (r1 == 0) goto L_0x00ab
                com.ogury.cm.aabbb$aaaaa r1 = com.ogury.p159cm.aabbb.f12010a
                java.lang.String r1 = "sdk"
                boolean r2 = r3.has(r1)
                if (r2 == 0) goto L_0x0036
                org.json.JSONObject r1 = r3.optJSONObject(r1)     // Catch:{ Exception -> 0x002e }
                com.ogury.cm.abbba$aaaaa r2 = com.ogury.p159cm.abbba.f12082a     // Catch:{ Exception -> 0x002e }
                java.lang.String r2 = "sdkObject"
                com.ogury.p159cm.accbb.m15215a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x002e }
                com.ogury.p159cm.abbba.aaaaa.m15134a(r1)     // Catch:{ Exception -> 0x002e }
                com.ogury.cm.abbba$aaaaa r2 = com.ogury.p159cm.abbba.f12082a     // Catch:{ Exception -> 0x002e }
                com.ogury.p159cm.abbba.aaaaa.m15135b(r1)     // Catch:{ Exception -> 0x002e }
                goto L_0x0036
            L_0x002e:
                r1 = move-exception
                com.ogury.cm.aaccc r2 = com.ogury.p159cm.aaccc.f12045a
                java.lang.String r2 = "Error while parsing json config: "
                com.ogury.p159cm.aaccc.m15048a(r2, r1)
            L_0x0036:
                java.lang.String r3 = r3.optString(r0)
                r1 = 4
                if (r3 != 0) goto L_0x003e
                goto L_0x009e
            L_0x003e:
                int r2 = r3.hashCode()
                switch(r2) {
                    case -1570691213: goto L_0x0094;
                    case -398774240: goto L_0x008d;
                    case -303694790: goto L_0x0082;
                    case -92841694: goto L_0x0078;
                    case 85866586: goto L_0x006f;
                    case 199821065: goto L_0x0065;
                    case 680846796: goto L_0x005c;
                    case 1299590356: goto L_0x0051;
                    case 1884026692: goto L_0x0046;
                    default: goto L_0x0045;
                }
            L_0x0045:
                goto L_0x009e
            L_0x0046:
                java.lang.String r2 = "edit-disabled-device-id-restricted"
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L_0x009e
                r1 = 1007(0x3ef, float:1.411E-42)
                goto L_0x009e
            L_0x0051:
                java.lang.String r2 = "region-restricted"
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L_0x009e
                r1 = 1000(0x3e8, float:1.401E-42)
                goto L_0x009e
            L_0x005c:
                java.lang.String r2 = "assetKey-unknown"
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L_0x009e
                goto L_0x006d
            L_0x0065:
                java.lang.String r2 = "no-such-assetKey"
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L_0x009e
            L_0x006d:
                r1 = 1
                goto L_0x009e
            L_0x006f:
                java.lang.String r2 = "assetType-not-matching"
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L_0x009e
                goto L_0x0080
            L_0x0078:
                java.lang.String r2 = "bundle-not-matching"
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L_0x009e
            L_0x0080:
                r1 = 2
                goto L_0x009e
            L_0x0082:
                java.lang.String r2 = "edit-disabled-georestricted-user"
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L_0x009e
                r1 = 1008(0x3f0, float:1.413E-42)
                goto L_0x009e
            L_0x008d:
                java.lang.String r2 = "domain-not-matching"
                boolean r2 = r3.equals(r2)
                goto L_0x009e
            L_0x0094:
                java.lang.String r2 = "edit-disabled-user-has-paid"
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L_0x009e
                r1 = 1006(0x3ee, float:1.41E-42)
            L_0x009e:
                com.ogury.core.OguryError r2 = new com.ogury.core.OguryError
                com.ogury.p159cm.accbb.m15215a((java.lang.Object) r3, (java.lang.String) r0)
                java.lang.String r3 = com.ogury.p159cm.aabba.aaaaa.m14999b(r3)
                r2.<init>(r1, r3)
                return r2
            L_0x00ab:
                com.ogury.core.OguryError r3 = new com.ogury.core.OguryError
                r0 = 1004(0x3ec, float:1.407E-42)
                java.lang.String r1 = "parsing-error"
                java.lang.String r1 = com.ogury.p159cm.aabba.aaaaa.m14999b(r1)
                r3.<init>(r0, r1)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ogury.p159cm.aabbb.aaaaa.m15000a(java.lang.String):com.ogury.core.OguryError");
        }
    }
}
