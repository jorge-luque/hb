package com.chartboost.sdk.impl;

/* renamed from: com.chartboost.sdk.impl.p */
public class C2195p {
    /* JADX WARNING: Can't wrap try/catch for region: R(5:41|42|43|44|45) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00e7 */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010a A[SYNTHETIC, Splitter:B:64:0x010a] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0111 A[SYNTHETIC, Splitter:B:68:0x0111] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m8731a(java.io.File r13, java.util.Map<java.lang.String, java.lang.String> r14) throws java.lang.Exception {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ OutOfMemoryError -> 0x0100, all -> 0x00fd }
            r1.<init>(r13)     // Catch:{ OutOfMemoryError -> 0x0100, all -> 0x00fd }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ OutOfMemoryError -> 0x00fb }
            r2.<init>(r1)     // Catch:{ OutOfMemoryError -> 0x00fb }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            r0.<init>()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.util.Set r14 = r14.entrySet()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
        L_0x0018:
            boolean r3 = r14.hasNext()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.String r4 = "{%"
            java.lang.String r5 = "{{"
            if (r3 == 0) goto L_0x0042
            java.lang.Object r3 = r14.next()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.Object r6 = r3.getKey()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            boolean r5 = r6.startsWith(r5)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            if (r5 != 0) goto L_0x003a
            boolean r4 = r6.startsWith(r4)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            if (r4 == 0) goto L_0x0018
        L_0x003a:
            java.lang.Object r3 = r3.getValue()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            r0.put(r6, r3)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            goto L_0x0018
        L_0x0042:
            java.util.Set r14 = r0.entrySet()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.util.Iterator r0 = r14.iterator()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            r3 = 0
            r6 = 0
        L_0x004c:
            boolean r7 = r0.hasNext()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            if (r7 == 0) goto L_0x0066
            java.lang.Object r7 = r0.next()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            int r7 = r7.length()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            int r7 = r7 * 3
            int r6 = r6 + r7
            goto L_0x004c
        L_0x0066:
            long r7 = r13.length()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            int r13 = (int) r7     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            int r13 = r13 + r6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            r0.<init>(r13)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            r6 = 2048(0x800, float:2.87E-42)
            r13.<init>(r6)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
        L_0x0078:
            java.lang.String r6 = r2.readLine()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            if (r6 == 0) goto L_0x00da
            int r7 = r6.indexOf(r5)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            int r8 = r6.indexOf(r4)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            r9 = -1
            if (r7 == r9) goto L_0x0090
            if (r8 == r9) goto L_0x0090
            int r7 = java.lang.Math.min(r7, r8)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            goto L_0x0094
        L_0x0090:
            int r7 = java.lang.Math.max(r7, r8)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
        L_0x0094:
            if (r7 != r9) goto L_0x009a
            r0.append(r6)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            goto L_0x00d4
        L_0x009a:
            r13.setLength(r3)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            r13.append(r6)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.util.Iterator r6 = r14.iterator()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
        L_0x00a4:
            boolean r8 = r6.hasNext()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            if (r8 == 0) goto L_0x00d1
            java.lang.Object r8 = r6.next()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.Object r10 = r8.getKey()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.Object r8 = r8.getValue()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            int r11 = r10.length()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
        L_0x00c0:
            int r7 = r13.indexOf(r10, r7)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            if (r9 == r7) goto L_0x00a4
            int r12 = r7 + r11
            r13.replace(r7, r12, r8)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            int r12 = r8.length()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            int r7 = r7 + r12
            goto L_0x00c0
        L_0x00d1:
            r0.append(r13)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
        L_0x00d4:
            java.lang.String r6 = "\n"
            r0.append(r6)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            goto L_0x0078
        L_0x00da:
            java.lang.String r13 = r0.toString()     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            boolean r14 = r13.contains(r5)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            if (r14 != 0) goto L_0x00eb
            r2.close()     // Catch:{ IOException -> 0x00e7 }
        L_0x00e7:
            r1.close()     // Catch:{ IOException -> 0x00ea }
        L_0x00ea:
            return r13
        L_0x00eb:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            java.lang.String r14 = "Missing required template parameter"
            r13.<init>(r14)     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
            throw r13     // Catch:{ OutOfMemoryError -> 0x00f6, all -> 0x00f3 }
        L_0x00f3:
            r13 = move-exception
            r0 = r2
            goto L_0x0108
        L_0x00f6:
            r13 = move-exception
            r0 = r2
            goto L_0x0102
        L_0x00f9:
            r13 = move-exception
            goto L_0x0108
        L_0x00fb:
            r13 = move-exception
            goto L_0x0102
        L_0x00fd:
            r13 = move-exception
            r1 = r0
            goto L_0x0108
        L_0x0100:
            r13 = move-exception
            r1 = r0
        L_0x0102:
            java.lang.Exception r14 = new java.lang.Exception     // Catch:{ all -> 0x00f9 }
            r14.<init>(r13)     // Catch:{ all -> 0x00f9 }
            throw r14     // Catch:{ all -> 0x00f9 }
        L_0x0108:
            if (r0 == 0) goto L_0x010f
            r0.close()     // Catch:{ IOException -> 0x010e }
            goto L_0x010f
        L_0x010e:
        L_0x010f:
            if (r1 == 0) goto L_0x0114
            r1.close()     // Catch:{ IOException -> 0x0114 }
        L_0x0114:
            goto L_0x0116
        L_0x0115:
            throw r13
        L_0x0116:
            goto L_0x0115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2195p.m8731a(java.io.File, java.util.Map):java.lang.String");
    }
}
