package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzj;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
import p075d.p080b.C3204g;

/* renamed from: com.google.firebase.iid.w */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3743w {

    /* renamed from: g */
    private static int f10381g;

    /* renamed from: h */
    private static PendingIntent f10382h;
    @GuardedBy("responseCallbacks")

    /* renamed from: a */
    private final C3204g<String, TaskCompletionSource<Bundle>> f10383a = new C3204g<>();

    /* renamed from: b */
    private final Context f10384b;

    /* renamed from: c */
    private final C3731q f10385c;

    /* renamed from: d */
    private Messenger f10386d;

    /* renamed from: e */
    private Messenger f10387e;

    /* renamed from: f */
    private zzj f10388f;

    public C3743w(Context context, C3731q qVar) {
        this.f10384b = context;
        this.f10385c = qVar;
        this.f10386d = new Messenger(new C3749z(this, Looper.getMainLooper()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12641a(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzj.C3751a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzj) {
                        this.f10388f = (zzj) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f10387e = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra("error");
                        if (stringExtra2 == null) {
                            String valueOf = String.valueOf(intent2.getExtras());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                            sb.append("Unexpected response, no error or registration id ");
                            sb.append(valueOf);
                            Log.w("FirebaseInstanceId", sb.toString());
                            return;
                        }
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String valueOf2 = String.valueOf(stringExtra2);
                            if (valueOf2.length() != 0) {
                                "Received InstanceID error ".concat(valueOf2);
                            } else {
                                new String("Received InstanceID error ");
                            }
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length <= 2 || !"ID".equals(split[1])) {
                                String valueOf3 = String.valueOf(stringExtra2);
                                Log.w("FirebaseInstanceId", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
                                return;
                            }
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(":")) {
                                str2 = str2.substring(1);
                            }
                            m12643a(str, intent2.putExtra("error", str2).getExtras());
                            return;
                        }
                        synchronized (this.f10383a) {
                            for (int i = 0; i < this.f10383a.size(); i++) {
                                m12643a(this.f10383a.mo18803b(i), intent2.getExtras());
                            }
                        }
                        return;
                    }
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", group2);
                        m12643a(group, extras);
                        return;
                    } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf4 = String.valueOf(stringExtra);
                        if (valueOf4.length() != 0) {
                            "Unexpected response string: ".concat(valueOf4);
                            return;
                        } else {
                            new String("Unexpected response string: ");
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf5 = String.valueOf(action);
                    if (valueOf5.length() != 0) {
                        "Unexpected response action: ".concat(valueOf5);
                        return;
                    } else {
                        new String("Unexpected response action: ");
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        Log.w("FirebaseInstanceId", "Dropping invalid message");
    }

    /* renamed from: b */
    private final Bundle m12644b(Bundle bundle) throws IOException {
        Bundle c = m12645c(bundle);
        if (c == null || !c.containsKey("google.messenger")) {
            return c;
        }
        Bundle c2 = m12645c(bundle);
        if (c2 == null || !c2.containsKey("google.messenger")) {
            return c2;
        }
        return null;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* renamed from: c */
    private final android.os.Bundle m12645c(android.os.Bundle r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = m12639a()
            com.google.android.gms.tasks.TaskCompletionSource r1 = new com.google.android.gms.tasks.TaskCompletionSource
            r1.<init>()
            d.b.g<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.f10383a
            monitor-enter(r2)
            d.b.g<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r3 = r7.f10383a     // Catch:{ all -> 0x0117 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0117 }
            monitor-exit(r2)     // Catch:{ all -> 0x0117 }
            com.google.firebase.iid.q r2 = r7.f10385c
            int r2 = r2.mo27362b()
            if (r2 == 0) goto L_0x010f
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.google.android.gms"
            r2.setPackage(r3)
            com.google.firebase.iid.q r3 = r7.f10385c
            int r3 = r3.mo27362b()
            r4 = 2
            if (r3 != r4) goto L_0x0033
            java.lang.String r3 = "com.google.iid.TOKEN_REQUEST"
            r2.setAction(r3)
            goto L_0x0038
        L_0x0033:
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTER"
            r2.setAction(r3)
        L_0x0038:
            r2.putExtras(r8)
            android.content.Context r8 = r7.f10384b
            m12640a((android.content.Context) r8, (android.content.Intent) r2)
            java.lang.String r8 = java.lang.String.valueOf(r0)
            int r8 = r8.length()
            int r8 = r8 + 5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r8)
            java.lang.String r8 = "|ID|"
            r3.append(r8)
            r3.append(r0)
            java.lang.String r8 = "|"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            java.lang.String r3 = "kid"
            r2.putExtra(r3, r8)
            r8 = 3
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r8)
            if (r3 == 0) goto L_0x0090
            android.os.Bundle r3 = r2.getExtras()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            int r5 = r5 + 8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Sending "
            r6.append(r5)
            r6.append(r3)
            r6.toString()
        L_0x0090:
            android.os.Messenger r3 = r7.f10386d
            java.lang.String r5 = "google.messenger"
            r2.putExtra(r5, r3)
            android.os.Messenger r3 = r7.f10387e
            if (r3 != 0) goto L_0x009f
            com.google.firebase.iid.zzj r3 = r7.f10388f
            if (r3 == 0) goto L_0x00bc
        L_0x009f:
            android.os.Message r3 = android.os.Message.obtain()
            r3.obj = r2
            android.os.Messenger r5 = r7.f10387e     // Catch:{ RemoteException -> 0x00b5 }
            if (r5 == 0) goto L_0x00af
            android.os.Messenger r5 = r7.f10387e     // Catch:{ RemoteException -> 0x00b5 }
            r5.send(r3)     // Catch:{ RemoteException -> 0x00b5 }
            goto L_0x00cf
        L_0x00af:
            com.google.firebase.iid.zzj r5 = r7.f10388f     // Catch:{ RemoteException -> 0x00b5 }
            r5.mo27381a(r3)     // Catch:{ RemoteException -> 0x00b5 }
            goto L_0x00cf
        L_0x00b5:
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r8 = android.util.Log.isLoggable(r3, r8)
        L_0x00bc:
            com.google.firebase.iid.q r8 = r7.f10385c
            int r8 = r8.mo27362b()
            if (r8 != r4) goto L_0x00ca
            android.content.Context r8 = r7.f10384b
            r8.sendBroadcast(r2)
            goto L_0x00cf
        L_0x00ca:
            android.content.Context r8 = r7.f10384b
            r8.startService(r2)
        L_0x00cf:
            com.google.android.gms.tasks.Task r8 = r1.getTask()     // Catch:{ InterruptedException | TimeoutException -> 0x00f3, ExecutionException -> 0x00ec }
            r1 = 30000(0x7530, double:1.4822E-319)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException | TimeoutException -> 0x00f3, ExecutionException -> 0x00ec }
            java.lang.Object r8 = com.google.android.gms.tasks.Tasks.await(r8, r1, r3)     // Catch:{ InterruptedException | TimeoutException -> 0x00f3, ExecutionException -> 0x00ec }
            android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ InterruptedException | TimeoutException -> 0x00f3, ExecutionException -> 0x00ec }
            d.b.g<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r7.f10383a
            monitor-enter(r1)
            d.b.g<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.f10383a     // Catch:{ all -> 0x00e7 }
            r2.remove(r0)     // Catch:{ all -> 0x00e7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
            return r8
        L_0x00e7:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
            throw r8
        L_0x00ea:
            r8 = move-exception
            goto L_0x0102
        L_0x00ec:
            r8 = move-exception
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00ea }
            r1.<init>(r8)     // Catch:{ all -> 0x00ea }
            throw r1     // Catch:{ all -> 0x00ea }
        L_0x00f3:
            java.lang.String r8 = "FirebaseInstanceId"
            java.lang.String r1 = "No response"
            android.util.Log.w(r8, r1)     // Catch:{ all -> 0x00ea }
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = "TIMEOUT"
            r8.<init>(r1)     // Catch:{ all -> 0x00ea }
            throw r8     // Catch:{ all -> 0x00ea }
        L_0x0102:
            d.b.g<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r7.f10383a
            monitor-enter(r1)
            d.b.g<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.f10383a     // Catch:{ all -> 0x010c }
            r2.remove(r0)     // Catch:{ all -> 0x010c }
            monitor-exit(r1)     // Catch:{ all -> 0x010c }
            throw r8
        L_0x010c:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x010c }
            throw r8
        L_0x010f:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "MISSING_INSTANCEID_SERVICE"
            r8.<init>(r0)
            throw r8
        L_0x0117:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0117 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.C3743w.m12645c(android.os.Bundle):android.os.Bundle");
    }

    /* renamed from: a */
    private static synchronized void m12640a(Context context, Intent intent) {
        synchronized (C3743w.class) {
            if (f10382h == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f10382h = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(TapjoyConstants.TJC_APP_PLACEMENT, f10382h);
        }
    }

    /* renamed from: a */
    private final void m12643a(String str, Bundle bundle) {
        synchronized (this.f10383a) {
            TaskCompletionSource remove = this.f10383a.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.setResult(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Bundle mo27372a(Bundle bundle) throws IOException {
        if (this.f10385c.mo27365e() < 12000000) {
            return m12644b(bundle);
        }
        try {
            return (Bundle) Tasks.await(C3701e.m12590a(this.f10384b).mo27323b(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                sb.toString();
            }
            if (!(e.getCause() instanceof zzam) || ((zzam) e.getCause()).mo27380a() != 4) {
                return null;
            }
            return m12644b(bundle);
        }
    }

    /* renamed from: a */
    private static synchronized String m12639a() {
        String num;
        synchronized (C3743w.class) {
            int i = f10381g;
            f10381g = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }
}
