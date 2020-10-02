package p075d.p090g.p091a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: d.g.a.a */
/* compiled from: LocalBroadcastManager */
public final class C3218a {

    /* renamed from: f */
    private static final Object f8982f = new Object();

    /* renamed from: g */
    private static C3218a f8983g;

    /* renamed from: a */
    private final Context f8984a;

    /* renamed from: b */
    private final HashMap<BroadcastReceiver, ArrayList<C3221c>> f8985b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, ArrayList<C3221c>> f8986c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C3220b> f8987d = new ArrayList<>();

    /* renamed from: e */
    private final Handler f8988e;

    /* renamed from: d.g.a.a$a */
    /* compiled from: LocalBroadcastManager */
    class C3219a extends Handler {
        C3219a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                C3218a.this.mo18869a();
            }
        }
    }

    /* renamed from: d.g.a.a$b */
    /* compiled from: LocalBroadcastManager */
    private static final class C3220b {

        /* renamed from: a */
        final Intent f8990a;

        /* renamed from: b */
        final ArrayList<C3221c> f8991b;

        C3220b(Intent intent, ArrayList<C3221c> arrayList) {
            this.f8990a = intent;
            this.f8991b = arrayList;
        }
    }

    /* renamed from: d.g.a.a$c */
    /* compiled from: LocalBroadcastManager */
    private static final class C3221c {

        /* renamed from: a */
        final IntentFilter f8992a;

        /* renamed from: b */
        final BroadcastReceiver f8993b;

        /* renamed from: c */
        boolean f8994c;

        /* renamed from: d */
        boolean f8995d;

        C3221c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f8992a = intentFilter;
            this.f8993b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            sb.append("Receiver{");
            sb.append(this.f8993b);
            sb.append(" filter=");
            sb.append(this.f8992a);
            if (this.f8995d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private C3218a(Context context) {
        this.f8984a = context;
        this.f8988e = new C3219a(context.getMainLooper());
    }

    /* renamed from: a */
    public static C3218a m10641a(Context context) {
        C3218a aVar;
        synchronized (f8982f) {
            if (f8983g == null) {
                f8983g = new C3218a(context.getApplicationContext());
            }
            aVar = f8983g;
        }
        return aVar;
    }

    /* renamed from: a */
    public void mo18871a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f8985b) {
            C3221c cVar = new C3221c(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.f8985b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f8985b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = this.f8986c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f8986c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    /* renamed from: a */
    public void mo18870a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f8985b) {
            ArrayList remove = this.f8985b.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    C3221c cVar = (C3221c) remove.get(size);
                    cVar.f8995d = true;
                    for (int i = 0; i < cVar.f8992a.countActions(); i++) {
                        String action = cVar.f8992a.getAction(i);
                        ArrayList arrayList = this.f8986c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                C3221c cVar2 = (C3221c) arrayList.get(size2);
                                if (cVar2.f8993b == broadcastReceiver) {
                                    cVar2.f8995d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f8986c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0150, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo18872a(android.content.Intent r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<d.g.a.a$c>> r2 = r1.f8985b
            monitor-enter(r2)
            java.lang.String r10 = r23.getAction()     // Catch:{ all -> 0x0152 }
            android.content.Context r3 = r1.f8984a     // Catch:{ all -> 0x0152 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x0152 }
            android.net.Uri r12 = r23.getData()     // Catch:{ all -> 0x0152 }
            java.lang.String r13 = r23.getScheme()     // Catch:{ all -> 0x0152 }
            java.util.Set r14 = r23.getCategories()     // Catch:{ all -> 0x0152 }
            int r3 = r23.getFlags()     // Catch:{ all -> 0x0152 }
            r3 = r3 & 8
            r9 = 1
            if (r3 == 0) goto L_0x002d
            r16 = 1
            goto L_0x002f
        L_0x002d:
            r16 = 0
        L_0x002f:
            if (r16 == 0) goto L_0x0051
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r3.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "Resolving type "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.append(r11)     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = " scheme "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.append(r13)     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = " of intent "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.append(r0)     // Catch:{ all -> 0x0152 }
            r3.toString()     // Catch:{ all -> 0x0152 }
        L_0x0051:
            java.util.HashMap<java.lang.String, java.util.ArrayList<d.g.a.a$c>> r3 = r1.f8986c     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = r23.getAction()     // Catch:{ all -> 0x0152 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0152 }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x0152 }
            if (r8 == 0) goto L_0x014f
            if (r16 == 0) goto L_0x0072
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r3.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "Action list: "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.append(r8)     // Catch:{ all -> 0x0152 }
            r3.toString()     // Catch:{ all -> 0x0152 }
        L_0x0072:
            r3 = 0
            r7 = r3
            r6 = 0
        L_0x0075:
            int r3 = r8.size()     // Catch:{ all -> 0x0152 }
            if (r6 >= r3) goto L_0x011f
            java.lang.Object r3 = r8.get(r6)     // Catch:{ all -> 0x0152 }
            r5 = r3
            d.g.a.a$c r5 = (p075d.p090g.p091a.C3218a.C3221c) r5     // Catch:{ all -> 0x0152 }
            if (r16 == 0) goto L_0x0096
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r3.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "Matching against filter "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            android.content.IntentFilter r4 = r5.f8992a     // Catch:{ all -> 0x0152 }
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.toString()     // Catch:{ all -> 0x0152 }
        L_0x0096:
            boolean r3 = r5.f8994c     // Catch:{ all -> 0x0152 }
            if (r3 == 0) goto L_0x00a6
            r18 = r6
            r20 = r8
            r19 = r10
            r21 = r11
            r11 = 1
            r10 = r7
            goto L_0x0113
        L_0x00a6:
            android.content.IntentFilter r3 = r5.f8992a     // Catch:{ all -> 0x0152 }
            java.lang.String r17 = "LocalBroadcastManager"
            r4 = r10
            r15 = r5
            r5 = r11
            r18 = r6
            r6 = r13
            r19 = r10
            r10 = r7
            r7 = r12
            r20 = r8
            r8 = r14
            r21 = r11
            r11 = 1
            r9 = r17
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0152 }
            if (r3 < 0) goto L_0x00e7
            if (r16 == 0) goto L_0x00d8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r4.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = "  Filter matched!  match=0x"
            r4.append(r5)     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x0152 }
            r4.append(r3)     // Catch:{ all -> 0x0152 }
            r4.toString()     // Catch:{ all -> 0x0152 }
        L_0x00d8:
            if (r10 != 0) goto L_0x00e0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0152 }
            r7.<init>()     // Catch:{ all -> 0x0152 }
            goto L_0x00e1
        L_0x00e0:
            r7 = r10
        L_0x00e1:
            r7.add(r15)     // Catch:{ all -> 0x0152 }
            r15.f8994c = r11     // Catch:{ all -> 0x0152 }
            goto L_0x0114
        L_0x00e7:
            if (r16 == 0) goto L_0x0113
            r4 = -4
            if (r3 == r4) goto L_0x0101
            r4 = -3
            if (r3 == r4) goto L_0x00fe
            r4 = -2
            if (r3 == r4) goto L_0x00fb
            r4 = -1
            if (r3 == r4) goto L_0x00f8
            java.lang.String r3 = "unknown reason"
            goto L_0x0103
        L_0x00f8:
            java.lang.String r3 = "type"
            goto L_0x0103
        L_0x00fb:
            java.lang.String r3 = "data"
            goto L_0x0103
        L_0x00fe:
            java.lang.String r3 = "action"
            goto L_0x0103
        L_0x0101:
            java.lang.String r3 = "category"
        L_0x0103:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r4.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = "  Filter did not match: "
            r4.append(r5)     // Catch:{ all -> 0x0152 }
            r4.append(r3)     // Catch:{ all -> 0x0152 }
            r4.toString()     // Catch:{ all -> 0x0152 }
        L_0x0113:
            r7 = r10
        L_0x0114:
            int r6 = r18 + 1
            r10 = r19
            r8 = r20
            r11 = r21
            r9 = 1
            goto L_0x0075
        L_0x011f:
            r10 = r7
            r11 = 1
            if (r10 == 0) goto L_0x014f
            r3 = 0
        L_0x0124:
            int r4 = r10.size()     // Catch:{ all -> 0x0152 }
            if (r3 >= r4) goto L_0x0136
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x0152 }
            d.g.a.a$c r4 = (p075d.p090g.p091a.C3218a.C3221c) r4     // Catch:{ all -> 0x0152 }
            r5 = 0
            r4.f8994c = r5     // Catch:{ all -> 0x0152 }
            int r3 = r3 + 1
            goto L_0x0124
        L_0x0136:
            java.util.ArrayList<d.g.a.a$b> r3 = r1.f8987d     // Catch:{ all -> 0x0152 }
            d.g.a.a$b r4 = new d.g.a.a$b     // Catch:{ all -> 0x0152 }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x0152 }
            r3.add(r4)     // Catch:{ all -> 0x0152 }
            android.os.Handler r0 = r1.f8988e     // Catch:{ all -> 0x0152 }
            boolean r0 = r0.hasMessages(r11)     // Catch:{ all -> 0x0152 }
            if (r0 != 0) goto L_0x014d
            android.os.Handler r0 = r1.f8988e     // Catch:{ all -> 0x0152 }
            r0.sendEmptyMessage(r11)     // Catch:{ all -> 0x0152 }
        L_0x014d:
            monitor-exit(r2)     // Catch:{ all -> 0x0152 }
            return r11
        L_0x014f:
            monitor-exit(r2)     // Catch:{ all -> 0x0152 }
            r0 = 0
            return r0
        L_0x0152:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0152 }
            goto L_0x0156
        L_0x0155:
            throw r0
        L_0x0156:
            goto L_0x0155
        */
        throw new UnsupportedOperationException("Method not decompiled: p075d.p090g.p091a.C3218a.mo18872a(android.content.Intent):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r4 = r2[r3];
        r5 = r4.f8991b.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r6 >= r5) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r7 = r4.f8991b.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        if (r7.f8995d != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r7.f8993b.onReceive(r10.f8984a, r4.f8990a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r3 = 0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18869a() {
        /*
            r10 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<d.g.a.a$c>> r0 = r10.f8985b
            monitor-enter(r0)
            java.util.ArrayList<d.g.a.a$b> r1 = r10.f8987d     // Catch:{ all -> 0x0044 }
            int r1 = r1.size()     // Catch:{ all -> 0x0044 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x000d:
            d.g.a.a$b[] r2 = new p075d.p090g.p091a.C3218a.C3220b[r1]     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<d.g.a.a$b> r3 = r10.f8987d     // Catch:{ all -> 0x0044 }
            r3.toArray(r2)     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<d.g.a.a$b> r3 = r10.f8987d     // Catch:{ all -> 0x0044 }
            r3.clear()     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            r0 = 0
            r3 = 0
        L_0x001c:
            if (r3 >= r1) goto L_0x0000
            r4 = r2[r3]
            java.util.ArrayList<d.g.a.a$c> r5 = r4.f8991b
            int r5 = r5.size()
            r6 = 0
        L_0x0027:
            if (r6 >= r5) goto L_0x0041
            java.util.ArrayList<d.g.a.a$c> r7 = r4.f8991b
            java.lang.Object r7 = r7.get(r6)
            d.g.a.a$c r7 = (p075d.p090g.p091a.C3218a.C3221c) r7
            boolean r8 = r7.f8995d
            if (r8 != 0) goto L_0x003e
            android.content.BroadcastReceiver r7 = r7.f8993b
            android.content.Context r8 = r10.f8984a
            android.content.Intent r9 = r4.f8990a
            r7.onReceive(r8, r9)
        L_0x003e:
            int r6 = r6 + 1
            goto L_0x0027
        L_0x0041:
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0044:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            goto L_0x0048
        L_0x0047:
            throw r1
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: p075d.p090g.p091a.C3218a.mo18869a():void");
    }
}
