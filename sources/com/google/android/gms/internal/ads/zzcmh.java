package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcmh implements zzdkb<zzcmg, zzcmj> {
    private final String zzdms;
    private final zzasa zzgci;
    private final String zzgcy;
    private final Context zzvf;

    public zzcmh(Context context, String str, zzasa zzasa, String str2) {
        this.zzvf = context;
        this.zzgcy = str;
        this.zzgci = zzasa;
        this.zzdms = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r2 = new java.io.InputStreamReader(r6.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        com.google.android.gms.ads.internal.zzq.zzkw();
        r0 = com.google.android.gms.internal.ads.zzaxa.zza(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r7.zzex(r0);
        r5.zzgcz = r8;
        r5.zzdnr = r0;
        r5.zzab = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01b5, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01c7, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzvj.zzpv().zzd(com.google.android.gms.internal.ads.zzzz.zzcro)).booleanValue() == false) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01d2, code lost:
        throw new com.google.android.gms.internal.ads.zzclp("No Fill", 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01d3, code lost:
        r5.zzgda = com.google.android.gms.ads.internal.zzq.zzld().elapsedRealtime() - r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r6.disconnect();
        r1.zzgci.zzve();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01e6, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01e7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01e8, code lost:
        r7 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzcmj zza(java.lang.String r21, com.google.android.gms.internal.ads.zzarp r22, org.json.JSONObject r23, java.lang.String r24) throws com.google.android.gms.internal.ads.zzclp {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "Received error HTTP response code: "
            java.lang.String r2 = "doritos_v2"
            java.lang.String r3 = "doritos"
            java.lang.String r4 = ""
            int r5 = r22.getErrorCode()     // Catch:{ IOException -> 0x027b }
            r6 = -2
            r7 = 0
            r8 = 1
            if (r5 == r6) goto L_0x0040
            int r0 = r22.getErrorCode()     // Catch:{ IOException -> 0x027b }
            if (r0 != r8) goto L_0x0038
            java.util.List r0 = r22.zzuv()     // Catch:{ IOException -> 0x027b }
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = ", "
            java.util.List r2 = r22.zzuv()     // Catch:{ IOException -> 0x027b }
            java.lang.String r0 = android.text.TextUtils.join(r0, r2)     // Catch:{ IOException -> 0x027b }
            com.google.android.gms.internal.ads.zzazw.zzfa(r0)     // Catch:{ IOException -> 0x027b }
        L_0x002c:
            com.google.android.gms.internal.ads.zzclp r0 = new com.google.android.gms.internal.ads.zzclp     // Catch:{ IOException -> 0x027b }
            java.lang.String r2 = "Error building request URL."
            int r3 = r22.getErrorCode()     // Catch:{ IOException -> 0x027b }
            r0.<init>(r2, r3)     // Catch:{ IOException -> 0x027b }
            throw r0     // Catch:{ IOException -> 0x027b }
        L_0x0038:
            com.google.android.gms.internal.ads.zzclp r0 = new com.google.android.gms.internal.ads.zzclp     // Catch:{ IOException -> 0x027b }
            java.lang.String r2 = "Internal error."
            r0.<init>(r2, r7)     // Catch:{ IOException -> 0x027b }
            throw r0     // Catch:{ IOException -> 0x027b }
        L_0x0040:
            com.google.android.gms.internal.ads.zzcmj r5 = new com.google.android.gms.internal.ads.zzcmj     // Catch:{ IOException -> 0x027b }
            r5.<init>()     // Catch:{ IOException -> 0x027b }
            java.lang.String r6 = "SDK version: "
            java.lang.String r9 = r1.zzgcy     // Catch:{ IOException -> 0x027b }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ IOException -> 0x027b }
            int r10 = r9.length()     // Catch:{ IOException -> 0x027b }
            if (r10 == 0) goto L_0x0058
            java.lang.String r6 = r6.concat(r9)     // Catch:{ IOException -> 0x027b }
            goto L_0x005e
        L_0x0058:
            java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x027b }
            r9.<init>(r6)     // Catch:{ IOException -> 0x027b }
            r6 = r9
        L_0x005e:
            com.google.android.gms.internal.ads.zzazw.zzfb(r6)     // Catch:{ IOException -> 0x027b }
            java.lang.String r6 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r9 = java.lang.String.valueOf(r21)     // Catch:{ IOException -> 0x027b }
            int r10 = r9.length()     // Catch:{ IOException -> 0x027b }
            if (r10 == 0) goto L_0x0072
            java.lang.String r6 = r6.concat(r9)     // Catch:{ IOException -> 0x027b }
            goto L_0x0078
        L_0x0072:
            java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x027b }
            r9.<init>(r6)     // Catch:{ IOException -> 0x027b }
            r6 = r9
        L_0x0078:
            com.google.android.gms.internal.ads.zzazw.zzed(r6)     // Catch:{ IOException -> 0x027b }
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x027b }
            r9 = r21
            r6.<init>(r9)     // Catch:{ IOException -> 0x027b }
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ IOException -> 0x027b }
            r9.<init>()     // Catch:{ IOException -> 0x027b }
            com.google.android.gms.common.util.Clock r10 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ IOException -> 0x027b }
            long r10 = r10.elapsedRealtime()     // Catch:{ IOException -> 0x027b }
            r12 = 0
        L_0x0090:
            com.google.android.gms.internal.ads.zzasa r13 = r1.zzgci     // Catch:{ IOException -> 0x027b }
            r13.zzvd()     // Catch:{ IOException -> 0x027b }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ IOException -> 0x027b }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x027b }
            com.google.android.gms.internal.ads.zzaxa r13 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x0271 }
            android.content.Context r14 = r1.zzvf     // Catch:{ all -> 0x0271 }
            java.lang.String r15 = r1.zzgcy     // Catch:{ all -> 0x0271 }
            r13.zza((android.content.Context) r14, (java.lang.String) r15, (boolean) r7, (java.net.HttpURLConnection) r6)     // Catch:{ all -> 0x0271 }
            boolean r13 = android.text.TextUtils.isEmpty(r24)     // Catch:{ all -> 0x0271 }
            if (r13 != 0) goto L_0x00b4
            java.lang.String r13 = "Cookie"
            r14 = r24
            r6.addRequestProperty(r13, r14)     // Catch:{ all -> 0x0271 }
            goto L_0x00b6
        L_0x00b4:
            r14 = r24
        L_0x00b6:
            boolean r13 = r22.zzuy()     // Catch:{ all -> 0x0271 }
            if (r13 == 0) goto L_0x00f3
            java.lang.String r13 = "pii"
            r15 = r23
            org.json.JSONObject r13 = r15.optJSONObject(r13)     // Catch:{ all -> 0x0271 }
            if (r13 == 0) goto L_0x00ed
            java.lang.String r16 = r13.optString(r3, r4)     // Catch:{ all -> 0x0271 }
            boolean r16 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x0271 }
            if (r16 != 0) goto L_0x00d9
            java.lang.String r7 = "x-afma-drt-cookie"
            java.lang.String r8 = r13.optString(r3, r4)     // Catch:{ all -> 0x0271 }
            r6.addRequestProperty(r7, r8)     // Catch:{ all -> 0x0271 }
        L_0x00d9:
            java.lang.String r7 = r13.optString(r2, r4)     // Catch:{ all -> 0x0271 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0271 }
            if (r7 != 0) goto L_0x00f5
            java.lang.String r7 = "x-afma-drt-v2-cookie"
            java.lang.String r8 = r13.optString(r2, r4)     // Catch:{ all -> 0x0271 }
            r6.addRequestProperty(r7, r8)     // Catch:{ all -> 0x0271 }
            goto L_0x00f5
        L_0x00ed:
            java.lang.String r7 = "DSID signal does not exist."
            com.google.android.gms.internal.ads.zzawr.zzeg(r7)     // Catch:{ all -> 0x0271 }
            goto L_0x00f5
        L_0x00f3:
            r15 = r23
        L_0x00f5:
            if (r22 == 0) goto L_0x012a
            java.lang.String r8 = r22.zzux()     // Catch:{ all -> 0x0271 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0271 }
            if (r8 != 0) goto L_0x012a
            r8 = 1
            r6.setDoOutput(r8)     // Catch:{ all -> 0x0271 }
            java.lang.String r8 = r22.zzux()     // Catch:{ all -> 0x0271 }
            byte[] r8 = r8.getBytes()     // Catch:{ all -> 0x0271 }
            int r13 = r8.length     // Catch:{ all -> 0x0271 }
            r6.setFixedLengthStreamingMode(r13)     // Catch:{ all -> 0x0271 }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0124 }
            java.io.OutputStream r7 = r6.getOutputStream()     // Catch:{ all -> 0x0124 }
            r13.<init>(r7)     // Catch:{ all -> 0x0124 }
            r13.write(r8)     // Catch:{ all -> 0x0121 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r13)     // Catch:{ all -> 0x0271 }
            goto L_0x012b
        L_0x0121:
            r0 = move-exception
            r7 = r13
            goto L_0x0126
        L_0x0124:
            r0 = move-exception
            r7 = 0
        L_0x0126:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ all -> 0x0271 }
            throw r0     // Catch:{ all -> 0x0271 }
        L_0x012a:
            r8 = 0
        L_0x012b:
            com.google.android.gms.internal.ads.zzazq r7 = new com.google.android.gms.internal.ads.zzazq     // Catch:{ all -> 0x0271 }
            r7.<init>()     // Catch:{ all -> 0x0271 }
            r7.zza((java.net.HttpURLConnection) r6, (byte[]) r8)     // Catch:{ all -> 0x0271 }
            int r8 = r6.getResponseCode()     // Catch:{ all -> 0x0271 }
            java.util.Map r13 = r6.getHeaderFields()     // Catch:{ all -> 0x0271 }
            java.util.Set r13 = r13.entrySet()     // Catch:{ all -> 0x0271 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x0271 }
        L_0x0143:
            boolean r17 = r13.hasNext()     // Catch:{ all -> 0x0271 }
            if (r17 == 0) goto L_0x0184
            java.lang.Object r17 = r13.next()     // Catch:{ all -> 0x0271 }
            java.util.Map$Entry r17 = (java.util.Map.Entry) r17     // Catch:{ all -> 0x0271 }
            java.lang.Object r18 = r17.getKey()     // Catch:{ all -> 0x0271 }
            r19 = r2
            r2 = r18
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0271 }
            java.lang.Object r17 = r17.getValue()     // Catch:{ all -> 0x0271 }
            r18 = r3
            r3 = r17
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0271 }
            boolean r17 = r9.containsKey(r2)     // Catch:{ all -> 0x0271 }
            if (r17 == 0) goto L_0x0173
            java.lang.Object r2 = r9.get(r2)     // Catch:{ all -> 0x0271 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0271 }
            r2.addAll(r3)     // Catch:{ all -> 0x0271 }
            goto L_0x017f
        L_0x0173:
            r17 = r4
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0271 }
            r4.<init>(r3)     // Catch:{ all -> 0x0271 }
            r9.put(r2, r4)     // Catch:{ all -> 0x0271 }
            r4 = r17
        L_0x017f:
            r3 = r18
            r2 = r19
            goto L_0x0143
        L_0x0184:
            r19 = r2
            r18 = r3
            r17 = r4
            r7.zza((java.net.HttpURLConnection) r6, (int) r8)     // Catch:{ all -> 0x0271 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 300(0x12c, float:4.2E-43)
            if (r8 < r2) goto L_0x01f0
            if (r8 >= r3) goto L_0x01f0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x01ea }
            java.io.InputStream r0 = r6.getInputStream()     // Catch:{ all -> 0x01ea }
            r2.<init>(r0)     // Catch:{ all -> 0x01ea }
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x01e7 }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaxa.zza((java.io.InputStreamReader) r2)     // Catch:{ all -> 0x01e7 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ all -> 0x0271 }
            r7.zzex(r0)     // Catch:{ all -> 0x0271 }
            r5.zzgcz = r8     // Catch:{ all -> 0x0271 }
            r5.zzdnr = r0     // Catch:{ all -> 0x0271 }
            r5.zzab = r9     // Catch:{ all -> 0x0271 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0271 }
            if (r0 == 0) goto L_0x01d3
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcro     // Catch:{ all -> 0x0271 }
            com.google.android.gms.internal.ads.zzzv r2 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x0271 }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x0271 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0271 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0271 }
            if (r0 == 0) goto L_0x01ca
            goto L_0x01d3
        L_0x01ca:
            com.google.android.gms.internal.ads.zzclp r0 = new com.google.android.gms.internal.ads.zzclp     // Catch:{ all -> 0x0271 }
            java.lang.String r2 = "No Fill"
            r3 = 3
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0271 }
            throw r0     // Catch:{ all -> 0x0271 }
        L_0x01d3:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ all -> 0x0271 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x0271 }
            long r2 = r2 - r10
            r5.zzgda = r2     // Catch:{ all -> 0x0271 }
            r6.disconnect()     // Catch:{ IOException -> 0x027b }
            com.google.android.gms.internal.ads.zzasa r0 = r1.zzgci     // Catch:{ IOException -> 0x027b }
            r0.zzve()     // Catch:{ IOException -> 0x027b }
            return r5
        L_0x01e7:
            r0 = move-exception
            r7 = r2
            goto L_0x01ec
        L_0x01ea:
            r0 = move-exception
            r7 = 0
        L_0x01ec:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ all -> 0x0271 }
            throw r0     // Catch:{ all -> 0x0271 }
        L_0x01f0:
            if (r8 < r3) goto L_0x0248
            r2 = 400(0x190, float:5.6E-43)
            if (r8 >= r2) goto L_0x0248
            java.lang.String r2 = "Location"
            java.lang.String r2 = r6.getHeaderField(r2)     // Catch:{ all -> 0x0271 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0271 }
            if (r3 != 0) goto L_0x023b
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x0271 }
            r3.<init>(r2)     // Catch:{ all -> 0x0271 }
            r2 = 1
            int r12 = r12 + r2
            com.google.android.gms.internal.ads.zzzk<java.lang.Integer> r4 = com.google.android.gms.internal.ads.zzzz.zzcqv     // Catch:{ all -> 0x0271 }
            com.google.android.gms.internal.ads.zzzv r7 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x0271 }
            java.lang.Object r4 = r7.zzd(r4)     // Catch:{ all -> 0x0271 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x0271 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0271 }
            if (r12 > r4) goto L_0x022e
            r6.disconnect()     // Catch:{ IOException -> 0x027b }
            com.google.android.gms.internal.ads.zzasa r4 = r1.zzgci     // Catch:{ IOException -> 0x027b }
            r4.zzve()     // Catch:{ IOException -> 0x027b }
            r6 = r3
            r4 = r17
            r3 = r18
            r2 = r19
            r7 = 0
            r8 = 1
            goto L_0x0090
        L_0x022e:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)     // Catch:{ all -> 0x0271 }
            com.google.android.gms.internal.ads.zzclp r0 = new com.google.android.gms.internal.ads.zzclp     // Catch:{ all -> 0x0271 }
            java.lang.String r2 = "Too many redirects"
            r0.<init>(r2)     // Catch:{ all -> 0x0271 }
            throw r0     // Catch:{ all -> 0x0271 }
        L_0x023b:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)     // Catch:{ all -> 0x0271 }
            com.google.android.gms.internal.ads.zzclp r0 = new com.google.android.gms.internal.ads.zzclp     // Catch:{ all -> 0x0271 }
            java.lang.String r2 = "No location header to follow redirect"
            r0.<init>(r2)     // Catch:{ all -> 0x0271 }
            throw r0     // Catch:{ all -> 0x0271 }
        L_0x0248:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0271 }
            r3 = 46
            r2.<init>(r3)     // Catch:{ all -> 0x0271 }
            r2.append(r0)     // Catch:{ all -> 0x0271 }
            r2.append(r8)     // Catch:{ all -> 0x0271 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0271 }
            com.google.android.gms.internal.ads.zzazw.zzfc(r2)     // Catch:{ all -> 0x0271 }
            com.google.android.gms.internal.ads.zzclp r2 = new com.google.android.gms.internal.ads.zzclp     // Catch:{ all -> 0x0271 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0271 }
            r4.<init>(r3)     // Catch:{ all -> 0x0271 }
            r4.append(r0)     // Catch:{ all -> 0x0271 }
            r4.append(r8)     // Catch:{ all -> 0x0271 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0271 }
            r2.<init>(r0)     // Catch:{ all -> 0x0271 }
            throw r2     // Catch:{ all -> 0x0271 }
        L_0x0271:
            r0 = move-exception
            r6.disconnect()     // Catch:{ IOException -> 0x027b }
            com.google.android.gms.internal.ads.zzasa r2 = r1.zzgci     // Catch:{ IOException -> 0x027b }
            r2.zzve()     // Catch:{ IOException -> 0x027b }
            throw r0     // Catch:{ IOException -> 0x027b }
        L_0x027b:
            r0 = move-exception
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.String r3 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x0291
            java.lang.String r2 = r2.concat(r3)
            goto L_0x0297
        L_0x0291:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x0297:
            com.google.android.gms.internal.ads.zzazw.zzfc(r2)
            com.google.android.gms.internal.ads.zzclp r2 = new com.google.android.gms.internal.ads.zzclp
            java.lang.String r3 = "Error connecting to ad server:"
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x02b1
            java.lang.String r0 = r3.concat(r0)
            goto L_0x02b6
        L_0x02b1:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L_0x02b6:
            r3 = 2
            r2.<init>(r0, r3)
            goto L_0x02bc
        L_0x02bb:
            throw r2
        L_0x02bc:
            goto L_0x02bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmh.zza(java.lang.String, com.google.android.gms.internal.ads.zzarp, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzcmj");
    }

    public final /* synthetic */ Object apply(Object obj) throws Exception {
        zzcmg zzcmg = (zzcmg) obj;
        return zza(zzcmg.zzgcs.getUrl(), zzcmg.zzgcs, zzcmg.zzgcr, this.zzdms);
    }
}
