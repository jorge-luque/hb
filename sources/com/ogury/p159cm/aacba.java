package com.ogury.p159cm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.Comparator;

/* renamed from: com.ogury.cm.aacba */
public final class aacba {

    /* renamed from: a */
    public static final aacba f12030a = new aacba();

    /* renamed from: com.ogury.cm.aacba$aaaaa */
    static final class aaaaa implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f12031a;

        /* renamed from: b */
        final /* synthetic */ aacac f12032b;

        aaaaa(Context context, aacac aacac) {
            this.f12031a = context;
            this.f12032b = aacac;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
            if (r0 != null) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
            throw new java.lang.IllegalStateException("aaid is null");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
            r0 = com.ogury.p159cm.aacba.m15021a(com.ogury.p159cm.aacba.f12030a, r2.f12031a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            r0 = android.provider.Settings.Secure.getString(r2.f12031a.getContentResolver(), com.tapjoy.TapjoyConstants.TJC_ADVERTISING_ID);
            com.ogury.p159cm.accbb.m15215a((java.lang.Object) r0, "Settings.Secure.getStrin…solver, \"advertising_id\")");
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0019 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r2 = this;
                com.ogury.cm.aacbb r0 = com.ogury.p159cm.aacbb.f12034a     // Catch:{ Exception -> 0x0019 }
                android.content.Context r0 = r2.f12031a     // Catch:{ Exception -> 0x0019 }
                com.ogury.cm.acabb r0 = com.ogury.p159cm.aacbb.m15023a(r0)     // Catch:{ Exception -> 0x0019 }
                if (r0 == 0) goto L_0x0011
                java.lang.String r0 = r0.mo29517a()     // Catch:{ Exception -> 0x0019 }
                if (r0 == 0) goto L_0x0011
                goto L_0x003d
            L_0x0011:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0019 }
                java.lang.String r1 = "androidAdvertisingId is null"
                r0.<init>(r1)     // Catch:{ Exception -> 0x0019 }
                throw r0     // Catch:{ Exception -> 0x0019 }
            L_0x0019:
                android.content.Context r0 = r2.f12031a     // Catch:{ Exception -> 0x0035 }
                android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x0035 }
                java.lang.String r1 = "advertising_id"
                java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r1)     // Catch:{ Exception -> 0x0035 }
                java.lang.String r1 = "Settings.Secure.getStrin…solver, \"advertising_id\")"
                com.ogury.p159cm.accbb.m15215a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0035 }
                if (r0 == 0) goto L_0x002d
                goto L_0x003d
            L_0x002d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0035 }
                java.lang.String r1 = "aaid is null"
                r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
                throw r0     // Catch:{ Exception -> 0x0035 }
            L_0x0035:
                com.ogury.cm.aacba r0 = com.ogury.p159cm.aacba.f12030a
                android.content.Context r1 = r2.f12031a
                java.lang.String r0 = com.ogury.p159cm.aacba.m15020a(r1)
            L_0x003d:
                com.ogury.cm.aacac r1 = r2.f12032b
                r1.mo29386a(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ogury.p159cm.aacba.aaaaa.run():void");
        }
    }

    /* renamed from: com.ogury.cm.aacba$aaaab */
    static final class aaaab<T> implements Comparator<ApplicationInfo> {

        /* renamed from: a */
        public static final aaaab f12033a = new aaaab();

        aaaab() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            String str = ((ApplicationInfo) obj).packageName;
            String str2 = ((ApplicationInfo) obj2).packageName;
            accbb.m15215a((Object) str2, "rhs.packageName");
            return str.compareTo(str2);
        }
    }

    private aacba() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m15020a(android.content.Context r7) {
        /*
            r0 = 128(0x80, float:1.794E-43)
            java.lang.String r1 = "00000000-0000-0000-0000-000000000000"
            r2 = 0
            if (r7 != 0) goto L_0x0008
            goto L_0x0059
        L_0x0008:
            android.content.pm.PackageManager r3 = r7.getPackageManager()     // Catch:{ Exception -> 0x009b }
            if (r3 != 0) goto L_0x000f
            goto L_0x0059
        L_0x000f:
            java.util.List r3 = r3.getInstalledApplications(r0)     // Catch:{ Exception -> 0x009b }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x009b }
            r4.<init>()     // Catch:{ Exception -> 0x009b }
            boolean r5 = r3.isEmpty()     // Catch:{ Exception -> 0x009b }
            if (r5 == 0) goto L_0x001f
            goto L_0x0059
        L_0x001f:
            java.util.Iterator r2 = r3.iterator()     // Catch:{ Exception -> 0x009b }
        L_0x0023:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x009b }
            r5 = 1
            if (r3 == 0) goto L_0x003d
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x009b }
            android.content.pm.ApplicationInfo r3 = (android.content.pm.ApplicationInfo) r3     // Catch:{ Exception -> 0x009b }
            int r6 = r3.flags     // Catch:{ Exception -> 0x009b }
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0023
            java.lang.String r5 = r3.packageName     // Catch:{ Exception -> 0x009b }
            if (r5 == 0) goto L_0x0023
            r4.add(r3)     // Catch:{ Exception -> 0x009b }
            goto L_0x0023
        L_0x003d:
            com.ogury.cm.aacba$aaaab r2 = com.ogury.p159cm.aacba.aaaab.f12033a     // Catch:{ Exception -> 0x009b }
            java.lang.String r3 = "receiver$0"
            com.ogury.p159cm.accbb.m15218b(r4, r3)     // Catch:{ Exception -> 0x009b }
            java.lang.String r3 = "comparator"
            com.ogury.p159cm.accbb.m15218b(r2, r3)     // Catch:{ Exception -> 0x009b }
            int r3 = r4.size()     // Catch:{ Exception -> 0x009b }
            if (r3 <= r5) goto L_0x0052
            java.util.Collections.sort(r4, r2)     // Catch:{ Exception -> 0x009b }
        L_0x0052:
            r2 = 0
            java.lang.Object r2 = r4.get(r2)     // Catch:{ Exception -> 0x009b }
            android.content.pm.ApplicationInfo r2 = (android.content.pm.ApplicationInfo) r2     // Catch:{ Exception -> 0x009b }
        L_0x0059:
            if (r2 != 0) goto L_0x005c
            return r1
        L_0x005c:
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch:{  }
            java.lang.String r2 = r2.packageName     // Catch:{  }
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r2, r0)     // Catch:{  }
            long r0 = r7.firstInstallTime     // Catch:{  }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.nio.charset.Charset r0 = com.ogury.p159cm.babaa.f12165a
            if (r7 == 0) goto L_0x0093
            byte[] r7 = r7.getBytes(r0)
            java.lang.String r0 = "(this as java.lang.String).getBytes(charset)"
            com.ogury.p159cm.accbb.m15215a((java.lang.Object) r7, (java.lang.String) r0)
            java.util.UUID r7 = java.util.UUID.nameUUIDFromBytes(r7)
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = "UUID.nameUUIDFromBytes((…toByteArray()).toString()"
            com.ogury.p159cm.accbb.m15215a((java.lang.Object) r7, (java.lang.String) r0)
            return r7
        L_0x0093:
            com.ogury.cm.acbab r7 = new com.ogury.cm.acbab
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r7.<init>(r0)
            throw r7
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ogury.p159cm.aacba.m15020a(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    public static void m15022a(Context context, aacac aacac) {
        accbb.m15218b(context, "context");
        accbb.m15218b(aacac, "aaidCallback");
        new Thread(new aaaaa(context, aacac)).start();
    }
}
