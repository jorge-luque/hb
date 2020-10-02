package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.iid.C3747y;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
public class FirebaseMessagingService extends C3811k {

    /* renamed from: f */
    private static final Queue<String> f10501f = new ArrayDeque(10);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Intent mo27474a(Intent intent) {
        return C3747y.m12648b().mo27376a();
    }

    /* renamed from: a */
    public void mo27475a() {
    }

    /* renamed from: a */
    public void mo27476a(RemoteMessage remoteMessage) {
    }

    /* renamed from: a */
    public void mo27477a(String str) {
    }

    /* renamed from: a */
    public void mo27478a(String str, Exception exc) {
    }

    /* renamed from: b */
    public void mo27479b(String str) {
    }

    /* renamed from: b */
    public final boolean mo27480b(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!C3821u.m12902d(intent)) {
            return true;
        }
        C3821u.m12893a(intent);
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00eb, code lost:
        if (r1.equals("gcm") != false) goto L_0x00f9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bf  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27481c(android.content.Intent r13) {
        /*
            r12 = this;
            java.lang.String r0 = r13.getAction()
            java.lang.String r1 = "com.google.android.c2dm.intent.RECEIVE"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0015
            goto L_0x0053
        L_0x0015:
            java.lang.String r1 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0027
            boolean r0 = com.google.firebase.messaging.C3821u.m12902d(r13)
            if (r0 == 0) goto L_0x0052
            com.google.firebase.messaging.C3821u.m12898b(r13)
            return
        L_0x0027:
            java.lang.String r1 = "com.google.firebase.messaging.NEW_TOKEN"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = "token"
            java.lang.String r13 = r13.getStringExtra(r0)
            r12.mo27479b((java.lang.String) r13)
            return
        L_0x0039:
            java.lang.String r0 = "Unknown intent action: "
            java.lang.String r13 = r13.getAction()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r1 = r13.length()
            if (r1 == 0) goto L_0x004d
            r0.concat(r13)
            goto L_0x0052
        L_0x004d:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r0)
        L_0x0052:
            return
        L_0x0053:
            java.lang.String r0 = "google.message_id"
            java.lang.String r1 = r13.getStringExtra(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            r4 = 2
            if (r2 == 0) goto L_0x0066
            com.google.android.gms.tasks.Task r2 = com.google.android.gms.tasks.Tasks.forResult(r3)
            goto L_0x0076
        L_0x0066:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r2.putString(r0, r1)
            com.google.firebase.iid.e r5 = com.google.firebase.iid.C3701e.m12590a((android.content.Context) r12)
            com.google.android.gms.tasks.Task r2 = r5.mo27322a(r4, r2)
        L_0x0076:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            r6 = 1
            r7 = 3
            r8 = 0
            java.lang.String r9 = "FirebaseMessaging"
            if (r5 == 0) goto L_0x0083
        L_0x0081:
            r1 = 0
            goto L_0x00bd
        L_0x0083:
            java.util.Queue<java.lang.String> r5 = f10501f
            boolean r5 = r5.contains(r1)
            if (r5 == 0) goto L_0x00a8
            boolean r5 = android.util.Log.isLoggable(r9, r7)
            if (r5 == 0) goto L_0x00a6
            java.lang.String r5 = "Received duplicate message: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r10 = r1.length()
            if (r10 == 0) goto L_0x00a1
            r5.concat(r1)
            goto L_0x00a6
        L_0x00a1:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r5)
        L_0x00a6:
            r1 = 1
            goto L_0x00bd
        L_0x00a8:
            java.util.Queue<java.lang.String> r5 = f10501f
            int r5 = r5.size()
            r10 = 10
            if (r5 < r10) goto L_0x00b7
            java.util.Queue<java.lang.String> r5 = f10501f
            r5.remove()
        L_0x00b7:
            java.util.Queue<java.lang.String> r5 = f10501f
            r5.add(r1)
            goto L_0x0081
        L_0x00bd:
            if (r1 != 0) goto L_0x01c2
            java.lang.String r1 = "message_type"
            java.lang.String r1 = r13.getStringExtra(r1)
            java.lang.String r5 = "gcm"
            if (r1 != 0) goto L_0x00ca
            r1 = r5
        L_0x00ca:
            r10 = -1
            int r11 = r1.hashCode()
            switch(r11) {
                case -2062414158: goto L_0x00ee;
                case 102161: goto L_0x00e7;
                case 814694033: goto L_0x00dd;
                case 814800675: goto L_0x00d3;
                default: goto L_0x00d2;
            }
        L_0x00d2:
            goto L_0x00f8
        L_0x00d3:
            java.lang.String r5 = "send_event"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00f8
            r8 = 2
            goto L_0x00f9
        L_0x00dd:
            java.lang.String r5 = "send_error"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00f8
            r8 = 3
            goto L_0x00f9
        L_0x00e7:
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00ee:
            java.lang.String r5 = "deleted_messages"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00f8
            r8 = 1
            goto L_0x00f9
        L_0x00f8:
            r8 = -1
        L_0x00f9:
            if (r8 == 0) goto L_0x0147
            if (r8 == r6) goto L_0x0142
            if (r8 == r4) goto L_0x0139
            if (r8 == r7) goto L_0x011d
            java.lang.String r13 = "Received message with unknown type: "
            java.lang.String r0 = java.lang.String.valueOf(r1)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x0112
            java.lang.String r13 = r13.concat(r0)
            goto L_0x0118
        L_0x0112:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r13)
            r13 = r0
        L_0x0118:
            android.util.Log.w(r9, r13)
            goto L_0x01c2
        L_0x011d:
            java.lang.String r0 = r13.getStringExtra(r0)
            if (r0 != 0) goto L_0x0129
            java.lang.String r0 = "message_id"
            java.lang.String r0 = r13.getStringExtra(r0)
        L_0x0129:
            com.google.firebase.messaging.SendException r1 = new com.google.firebase.messaging.SendException
            java.lang.String r3 = "error"
            java.lang.String r13 = r13.getStringExtra(r3)
            r1.<init>(r13)
            r12.mo27478a(r0, r1)
            goto L_0x01c2
        L_0x0139:
            java.lang.String r13 = r13.getStringExtra(r0)
            r12.mo27477a((java.lang.String) r13)
            goto L_0x01c2
        L_0x0142:
            r12.mo27475a()
            goto L_0x01c2
        L_0x0147:
            boolean r0 = com.google.firebase.messaging.C3821u.m12902d(r13)
            if (r0 == 0) goto L_0x0150
            com.google.firebase.messaging.C3821u.m12894a((android.content.Intent) r13, (p093e.p101c.p102a.p103a.C3382f<java.lang.String>) r3)
        L_0x0150:
            boolean r0 = com.google.firebase.messaging.C3821u.m12903e(r13)
            if (r0 == 0) goto L_0x0173
            e.c.a.a.g r0 = com.google.firebase.messaging.FirebaseMessaging.f10497d
            if (r0 == 0) goto L_0x016e
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.String r3 = "json"
            e.c.a.a.b r3 = p093e.p101c.p102a.p103a.C3378b.m11260a(r3)
            e.c.a.a.e r4 = com.google.firebase.messaging.C3819s.f10559a
            java.lang.String r5 = "FCM_CLIENT_EVENT_LOGGING"
            e.c.a.a.f r0 = r0.mo19151a(r5, r1, r3, r4)
            com.google.firebase.messaging.C3821u.m12894a((android.content.Intent) r13, (p093e.p101c.p102a.p103a.C3382f<java.lang.String>) r0)
            goto L_0x0173
        L_0x016e:
            java.lang.String r0 = "TransportFactory is null. Skip exporting message delivery metrics to Big Query"
            android.util.Log.e(r9, r0)
        L_0x0173:
            android.os.Bundle r0 = r13.getExtras()
            if (r0 != 0) goto L_0x017e
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
        L_0x017e:
            java.lang.String r1 = "androidx.contentpager.content.wakelockid"
            r0.remove(r1)
            boolean r1 = com.google.firebase.messaging.C3823w.m12913a((android.os.Bundle) r0)
            if (r1 == 0) goto L_0x01ba
            com.google.firebase.messaging.w r1 = new com.google.firebase.messaging.w
            r1.<init>(r0)
            com.google.android.gms.common.util.concurrent.NamedThreadFactory r3 = new com.google.android.gms.common.util.concurrent.NamedThreadFactory
            java.lang.String r4 = "Firebase-Messaging-Network-Io"
            r3.<init>(r4)
            java.util.concurrent.ExecutorService r3 = java.util.concurrent.Executors.newSingleThreadExecutor(r3)
            com.google.firebase.messaging.h r4 = new com.google.firebase.messaging.h
            r4.<init>(r12, r1, r3)
            boolean r1 = r4.mo27501a()     // Catch:{ all -> 0x01b5 }
            if (r1 == 0) goto L_0x01a8
            r3.shutdown()
            goto L_0x01c2
        L_0x01a8:
            r3.shutdown()
            boolean r1 = com.google.firebase.messaging.C3821u.m12902d(r13)
            if (r1 == 0) goto L_0x01ba
            com.google.firebase.messaging.C3821u.m12900c(r13)
            goto L_0x01ba
        L_0x01b5:
            r13 = move-exception
            r3.shutdown()
            throw r13
        L_0x01ba:
            com.google.firebase.messaging.RemoteMessage r13 = new com.google.firebase.messaging.RemoteMessage
            r13.<init>(r0)
            r12.mo27476a((com.google.firebase.messaging.RemoteMessage) r13)
        L_0x01c2:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x01d4, InterruptedException -> 0x01d2, TimeoutException -> 0x01d0 }
            r0 = 1
            long r0 = r13.toMillis(r0)     // Catch:{ ExecutionException -> 0x01d4, InterruptedException -> 0x01d2, TimeoutException -> 0x01d0 }
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException -> 0x01d4, InterruptedException -> 0x01d2, TimeoutException -> 0x01d0 }
            com.google.android.gms.tasks.Tasks.await(r2, r0, r13)     // Catch:{ ExecutionException -> 0x01d4, InterruptedException -> 0x01d2, TimeoutException -> 0x01d0 }
            return
        L_0x01d0:
            r13 = move-exception
            goto L_0x01d5
        L_0x01d2:
            r13 = move-exception
            goto L_0x01d5
        L_0x01d4:
            r13 = move-exception
        L_0x01d5:
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r0 = java.lang.String.valueOf(r13)
            int r0 = r0.length()
            int r0 = r0 + 20
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Message ack failed: "
            r1.append(r0)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            android.util.Log.w(r9, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.mo27481c(android.content.Intent):void");
    }
}
