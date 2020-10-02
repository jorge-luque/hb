package com.google.firebase.iid;

/* renamed from: com.google.firebase.iid.j */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3716j implements Runnable {

    /* renamed from: a */
    private final C3704f f10335a;

    C3716j(C3704f fVar) {
        this.f10335a = fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r3 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r3).length() + 8);
        r5.append("Sending ");
        r5.append(r3);
        r5.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        r3 = r0.f10324f.f10312a;
        r4 = r0.f10320b;
        r5 = android.os.Message.obtain();
        r5.what = r1.f10360c;
        r5.arg1 = r1.f10358a;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.mo27355a());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.f10361d);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.f10321c.mo27356a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009f, code lost:
        r0.mo27329a(2, r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            com.google.firebase.iid.f r0 = r8.f10335a
        L_0x0002:
            monitor-enter(r0)
            int r1 = r0.f10319a     // Catch:{ all -> 0x00a8 }
            r2 = 2
            if (r1 == r2) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            return
        L_0x000a:
            java.util.Queue<com.google.firebase.iid.p<?>> r1 = r0.f10322d     // Catch:{ all -> 0x00a8 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0017
            r0.mo27332b()     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            return
        L_0x0017:
            java.util.Queue<com.google.firebase.iid.p<?>> r1 = r0.f10322d     // Catch:{ all -> 0x00a8 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x00a8 }
            com.google.firebase.iid.p r1 = (com.google.firebase.iid.C3729p) r1     // Catch:{ all -> 0x00a8 }
            android.util.SparseArray<com.google.firebase.iid.p<?>> r3 = r0.f10323e     // Catch:{ all -> 0x00a8 }
            int r4 = r1.f10358a     // Catch:{ all -> 0x00a8 }
            r3.put(r4, r1)     // Catch:{ all -> 0x00a8 }
            com.google.firebase.iid.e r3 = r0.f10324f     // Catch:{ all -> 0x00a8 }
            java.util.concurrent.ScheduledExecutorService r3 = r3.f10313b     // Catch:{ all -> 0x00a8 }
            com.google.firebase.iid.l r4 = new com.google.firebase.iid.l     // Catch:{ all -> 0x00a8 }
            r4.<init>(r0, r1)     // Catch:{ all -> 0x00a8 }
            r5 = 30
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00a8 }
            r3.schedule(r4, r5, r7)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            r3 = 3
            java.lang.String r4 = "MessengerIpcClient"
            boolean r3 = android.util.Log.isLoggable(r4, r3)
            if (r3 == 0) goto L_0x0060
            java.lang.String r3 = java.lang.String.valueOf(r1)
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Sending "
            r5.append(r4)
            r5.append(r3)
            r5.toString()
        L_0x0060:
            com.google.firebase.iid.e r3 = r0.f10324f
            android.content.Context r3 = r3.f10312a
            android.os.Messenger r4 = r0.f10320b
            android.os.Message r5 = android.os.Message.obtain()
            int r6 = r1.f10360c
            r5.what = r6
            int r6 = r1.f10358a
            r5.arg1 = r6
            r5.replyTo = r4
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            boolean r6 = r1.mo27355a()
            java.lang.String r7 = "oneWay"
            r4.putBoolean(r7, r6)
            java.lang.String r3 = r3.getPackageName()
            java.lang.String r6 = "pkg"
            r4.putString(r6, r3)
            android.os.Bundle r1 = r1.f10361d
            java.lang.String r3 = "data"
            r4.putBundle(r3, r1)
            r5.setData(r4)
            com.google.firebase.iid.o r1 = r0.f10321c     // Catch:{ RemoteException -> 0x009e }
            r1.mo27356a(r5)     // Catch:{ RemoteException -> 0x009e }
            goto L_0x0002
        L_0x009e:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            r0.mo27329a(r2, r1)
            goto L_0x0002
        L_0x00a8:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            goto L_0x00ac
        L_0x00ab:
            throw r1
        L_0x00ac:
            goto L_0x00ab
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.C3716j.run():void");
    }
}
