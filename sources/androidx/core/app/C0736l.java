package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.p004v4.app.INotificationSideChannel;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: androidx.core.app.l */
/* compiled from: NotificationManagerCompat */
public final class C0736l {

    /* renamed from: c */
    private static final Object f1881c = new Object();

    /* renamed from: d */
    private static String f1882d;

    /* renamed from: e */
    private static Set<String> f1883e = new HashSet();

    /* renamed from: f */
    private static final Object f1884f = new Object();

    /* renamed from: g */
    private static C0740d f1885g;

    /* renamed from: a */
    private final Context f1886a;

    /* renamed from: b */
    private final NotificationManager f1887b;

    /* renamed from: androidx.core.app.l$a */
    /* compiled from: NotificationManagerCompat */
    private static class C0737a implements C0742e {

        /* renamed from: a */
        final String f1888a;

        /* renamed from: b */
        final int f1889b;

        /* renamed from: c */
        final String f1890c;

        /* renamed from: d */
        final boolean f1891d = false;

        C0737a(String str, int i, String str2) {
            this.f1888a = str;
            this.f1889b = i;
            this.f1890c = str2;
        }

        /* renamed from: a */
        public void mo3963a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.f1891d) {
                iNotificationSideChannel.cancelAll(this.f1888a);
            } else {
                iNotificationSideChannel.cancel(this.f1888a, this.f1889b, this.f1890c);
            }
        }

        public String toString() {
            return "CancelTask[" + "packageName:" + this.f1888a + ", id:" + this.f1889b + ", tag:" + this.f1890c + ", all:" + this.f1891d + "]";
        }
    }

    /* renamed from: androidx.core.app.l$b */
    /* compiled from: NotificationManagerCompat */
    private static class C0738b implements C0742e {

        /* renamed from: a */
        final String f1892a;

        /* renamed from: b */
        final int f1893b;

        /* renamed from: c */
        final String f1894c;

        /* renamed from: d */
        final Notification f1895d;

        C0738b(String str, int i, String str2, Notification notification) {
            this.f1892a = str;
            this.f1893b = i;
            this.f1894c = str2;
            this.f1895d = notification;
        }

        /* renamed from: a */
        public void mo3963a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f1892a, this.f1893b, this.f1894c, this.f1895d);
        }

        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f1892a + ", id:" + this.f1893b + ", tag:" + this.f1894c + "]";
        }
    }

    /* renamed from: androidx.core.app.l$c */
    /* compiled from: NotificationManagerCompat */
    private static class C0739c {

        /* renamed from: a */
        final ComponentName f1896a;

        /* renamed from: b */
        final IBinder f1897b;

        C0739c(ComponentName componentName, IBinder iBinder) {
            this.f1896a = componentName;
            this.f1897b = iBinder;
        }
    }

    /* renamed from: androidx.core.app.l$d */
    /* compiled from: NotificationManagerCompat */
    private static class C0740d implements Handler.Callback, ServiceConnection {

        /* renamed from: a */
        private final Context f1898a;

        /* renamed from: b */
        private final HandlerThread f1899b;

        /* renamed from: c */
        private final Handler f1900c;

        /* renamed from: d */
        private final Map<ComponentName, C0741a> f1901d = new HashMap();

        /* renamed from: e */
        private Set<String> f1902e = new HashSet();

        /* renamed from: androidx.core.app.l$d$a */
        /* compiled from: NotificationManagerCompat */
        private static class C0741a {

            /* renamed from: a */
            final ComponentName f1903a;

            /* renamed from: b */
            boolean f1904b = false;

            /* renamed from: c */
            INotificationSideChannel f1905c;

            /* renamed from: d */
            ArrayDeque<C0742e> f1906d = new ArrayDeque<>();

            /* renamed from: e */
            int f1907e = 0;

            C0741a(ComponentName componentName) {
                this.f1903a = componentName;
            }
        }

        C0740d(Context context) {
            this.f1898a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f1899b = handlerThread;
            handlerThread.start();
            this.f1900c = new Handler(this.f1899b.getLooper(), this);
        }

        /* renamed from: b */
        private void m2333b(C0742e eVar) {
            m2327a();
            for (C0741a next : this.f1901d.values()) {
                next.f1906d.add(eVar);
                m2334c(next);
            }
        }

        /* renamed from: c */
        private void m2334c(C0741a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                "Processing component " + aVar.f1903a + ", " + aVar.f1906d.size() + " queued tasks";
            }
            if (!aVar.f1906d.isEmpty()) {
                if (!m2330a(aVar) || aVar.f1905c == null) {
                    m2335d(aVar);
                    return;
                }
                while (true) {
                    C0742e peek = aVar.f1906d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            "Sending task " + peek;
                        }
                        peek.mo3963a(aVar.f1905c);
                        aVar.f1906d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            "Remote service has died: " + aVar.f1903a;
                        }
                    } catch (RemoteException e) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f1903a, e);
                    }
                }
                if (!aVar.f1906d.isEmpty()) {
                    m2335d(aVar);
                }
            }
        }

        /* renamed from: d */
        private void m2335d(C0741a aVar) {
            if (!this.f1900c.hasMessages(3, aVar.f1903a)) {
                int i = aVar.f1907e + 1;
                aVar.f1907e = i;
                if (i > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.f1906d.size() + " tasks to " + aVar.f1903a + " after " + aVar.f1907e + " retries");
                    aVar.f1906d.clear();
                    return;
                }
                int i2 = (1 << (i - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    "Scheduling retry for " + i2 + " ms";
                }
                this.f1900c.sendMessageDelayed(this.f1900c.obtainMessage(3, aVar.f1903a), (long) i2);
            }
        }

        /* renamed from: a */
        public void mo3966a(C0742e eVar) {
            this.f1900c.obtainMessage(0, eVar).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                m2333b((C0742e) message.obj);
                return true;
            } else if (i == 1) {
                C0739c cVar = (C0739c) message.obj;
                m2329a(cVar.f1896a, cVar.f1897b);
                return true;
            } else if (i == 2) {
                m2331b((ComponentName) message.obj);
                return true;
            } else if (i != 3) {
                return false;
            } else {
                m2328a((ComponentName) message.obj);
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                "Connected to service " + componentName;
            }
            this.f1900c.obtainMessage(1, new C0739c(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                "Disconnected from service " + componentName;
            }
            this.f1900c.obtainMessage(2, componentName).sendToTarget();
        }

        /* renamed from: a */
        private void m2329a(ComponentName componentName, IBinder iBinder) {
            C0741a aVar = this.f1901d.get(componentName);
            if (aVar != null) {
                aVar.f1905c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f1907e = 0;
                m2334c(aVar);
            }
        }

        /* renamed from: b */
        private void m2331b(ComponentName componentName) {
            C0741a aVar = this.f1901d.get(componentName);
            if (aVar != null) {
                m2332b(aVar);
            }
        }

        /* renamed from: a */
        private void m2328a(ComponentName componentName) {
            C0741a aVar = this.f1901d.get(componentName);
            if (aVar != null) {
                m2334c(aVar);
            }
        }

        /* renamed from: b */
        private void m2332b(C0741a aVar) {
            if (aVar.f1904b) {
                this.f1898a.unbindService(this);
                aVar.f1904b = false;
            }
            aVar.f1905c = null;
        }

        /* renamed from: a */
        private void m2327a() {
            Set<String> b = C0736l.m2319b(this.f1898a);
            if (!b.equals(this.f1902e)) {
                this.f1902e = b;
                List<ResolveInfo> queryIntentServices = this.f1898a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (b.contains(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f1901d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            "Adding listener record for " + componentName2;
                        }
                        this.f1901d.put(componentName2, new C0741a(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, C0741a>> it = this.f1901d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next2 = it.next();
                    if (!hashSet.contains(next2.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            "Removing listener record for " + next2.getKey();
                        }
                        m2332b((C0741a) next2.getValue());
                        it.remove();
                    }
                }
            }
        }

        /* renamed from: a */
        private boolean m2330a(C0741a aVar) {
            if (aVar.f1904b) {
                return true;
            }
            boolean bindService = this.f1898a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f1903a), this, 33);
            aVar.f1904b = bindService;
            if (bindService) {
                aVar.f1907e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f1903a);
                this.f1898a.unbindService(this);
            }
            return aVar.f1904b;
        }
    }

    /* renamed from: androidx.core.app.l$e */
    /* compiled from: NotificationManagerCompat */
    private interface C0742e {
        /* renamed from: a */
        void mo3963a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    private C0736l(Context context) {
        this.f1886a = context;
        this.f1887b = (NotificationManager) context.getSystemService("notification");
    }

    /* renamed from: a */
    public static C0736l m2316a(Context context) {
        return new C0736l(context);
    }

    /* renamed from: b */
    public static Set<String> m2319b(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f1881c) {
            if (string != null) {
                if (!string.equals(f1882d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f1883e = hashSet;
                    f1882d = string;
                }
            }
            set = f1883e;
        }
        return set;
    }

    /* renamed from: a */
    public void mo3958a(int i) {
        mo3960a((String) null, i);
    }

    /* renamed from: a */
    public void mo3960a(String str, int i) {
        this.f1887b.cancel(str, i);
        if (Build.VERSION.SDK_INT <= 19) {
            m2317a((C0742e) new C0737a(this.f1886a.getPackageName(), i, str));
        }
    }

    /* renamed from: a */
    public void mo3959a(int i, Notification notification) {
        mo3961a((String) null, i, notification);
    }

    /* renamed from: a */
    public void mo3961a(String str, int i, Notification notification) {
        if (m2318a(notification)) {
            m2317a((C0742e) new C0738b(this.f1886a.getPackageName(), i, str, notification));
            this.f1887b.cancel(str, i);
            return;
        }
        this.f1887b.notify(str, i, notification);
    }

    /* renamed from: a */
    public boolean mo3962a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return this.f1887b.areNotificationsEnabled();
        }
        if (i < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f1886a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f1886a.getApplicationInfo();
        String packageName = this.f1886a.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m2318a(Notification notification) {
        Bundle a = C0725i.m2241a(notification);
        return a != null && a.getBoolean("android.support.useSideChannel");
    }

    /* renamed from: a */
    private void m2317a(C0742e eVar) {
        synchronized (f1884f) {
            if (f1885g == null) {
                f1885g = new C0740d(this.f1886a.getApplicationContext());
            }
            f1885g.mo3966a(eVar);
        }
    }
}
