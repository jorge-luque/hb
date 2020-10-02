package com.onesignal;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.C4564n1;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.onesignal.w1 */
/* compiled from: OneSignalPrefs */
class C4698w1 {

    /* renamed from: a */
    public static final String f12761a = C4564n1.class.getSimpleName();

    /* renamed from: b */
    static HashMap<String, HashMap<String, Object>> f12762b;

    /* renamed from: c */
    public static C4699a f12763c;

    /* renamed from: com.onesignal.w1$a */
    /* compiled from: OneSignalPrefs */
    public static class C4699a extends HandlerThread {

        /* renamed from: a */
        private Handler f12764a;

        /* renamed from: b */
        private long f12765b = 0;

        /* renamed from: c */
        private Error f12766c;

        /* renamed from: d */
        private RuntimeException f12767d;

        /* renamed from: e */
        private Throwable f12768e;

        /* renamed from: com.onesignal.w1$a$a */
        /* compiled from: OneSignalPrefs */
        class C4700a implements Runnable {
            C4700a() {
            }

            public void run() {
                C4699a.this.m16356a();
            }
        }

        C4699a(String str) {
            super(str);
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public synchronized void m16360c() {
            if (C4564n1.f12495e != null) {
                if (this.f12764a == null) {
                    m16361d();
                    this.f12764a = new Handler(getLooper());
                }
                this.f12764a.removeCallbacksAndMessages((Object) null);
                if (this.f12765b == 0) {
                    this.f12765b = System.currentTimeMillis();
                }
                this.f12764a.postDelayed(m16358b(), (this.f12765b - System.currentTimeMillis()) + 200);
            }
        }

        /* renamed from: d */
        private void m16361d() {
            Error error = this.f12766c;
            if (error == null) {
                RuntimeException runtimeException = this.f12767d;
                if (runtimeException != null) {
                    throw runtimeException;
                } else if (this.f12768e == null) {
                    try {
                        start();
                    } catch (InternalError e) {
                        this.f12766c = e;
                        throw e;
                    } catch (OutOfMemoryError e2) {
                        this.f12766c = e2;
                        throw e2;
                    } catch (Error e3) {
                        this.f12766c = e3;
                        throw e3;
                    } catch (IllegalThreadStateException e4) {
                        IllegalThreadStateException illegalThreadStateException = new IllegalThreadStateException("Thread has state: " + getState());
                        illegalThreadStateException.setStackTrace(e4.getStackTrace());
                        this.f12767d = illegalThreadStateException;
                        throw illegalThreadStateException;
                    } catch (RuntimeException e5) {
                        this.f12767d = e5;
                        throw e5;
                    } catch (Throwable th) {
                        this.f12768e = th;
                        throw th;
                    }
                } else {
                    RuntimeException runtimeException2 = new RuntimeException(this.f12768e.getClass().getName() + ": " + this.f12768e.getMessage(), this.f12768e);
                    runtimeException2.setStackTrace(this.f12768e.getStackTrace());
                    throw runtimeException2;
                }
            } else {
                throw error;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m16356a() {
            for (String next : C4698w1.f12762b.keySet()) {
                SharedPreferences.Editor edit = C4698w1.m16349b(next).edit();
                HashMap hashMap = C4698w1.f12762b.get(next);
                synchronized (hashMap) {
                    for (String str : hashMap.keySet()) {
                        Object obj = hashMap.get(str);
                        if (obj instanceof String) {
                            edit.putString(str, (String) obj);
                        } else if (obj instanceof Boolean) {
                            edit.putBoolean(str, ((Boolean) obj).booleanValue());
                        } else if (obj instanceof Integer) {
                            edit.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            edit.putLong(str, ((Long) obj).longValue());
                        } else if (obj instanceof Set) {
                            edit.putStringSet(str, (Set) obj);
                        }
                    }
                    hashMap.clear();
                }
                edit.apply();
            }
            this.f12765b = System.currentTimeMillis();
        }

        /* renamed from: b */
        private Runnable m16358b() {
            return new C4700a();
        }
    }

    static {
        m16346a();
    }

    /* renamed from: b */
    public static void m16350b() {
        f12763c.m16360c();
    }

    /* renamed from: a */
    public static void m16346a() {
        HashMap<String, HashMap<String, Object>> hashMap = new HashMap<>();
        f12762b = hashMap;
        hashMap.put(f12761a, new HashMap());
        f12762b.put("GTPlayerPurchases", new HashMap());
        f12762b.put("OneSignalTriggers", new HashMap());
        f12763c = new C4699a("OSH_WritePrefs");
    }

    /* renamed from: b */
    public static void m16353b(String str, String str2, String str3) {
        m16347a(str, str2, (Object) str3);
    }

    /* renamed from: b */
    public static void m16354b(String str, String str2, Set<String> set) {
        m16347a(str, str2, (Object) set);
    }

    /* renamed from: b */
    public static void m16355b(String str, String str2, boolean z) {
        m16347a(str, str2, (Object) Boolean.valueOf(z));
    }

    /* renamed from: b */
    public static void m16351b(String str, String str2, int i) {
        m16347a(str, str2, (Object) Integer.valueOf(i));
    }

    /* renamed from: b */
    public static void m16352b(String str, String str2, long j) {
        m16347a(str, str2, (Object) Long.valueOf(j));
    }

    /* renamed from: a */
    private static void m16347a(String str, String str2, Object obj) {
        HashMap hashMap = f12762b.get(str);
        synchronized (hashMap) {
            hashMap.put(str2, obj);
        }
        m16350b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized SharedPreferences m16349b(String str) {
        synchronized (C4698w1.class) {
            if (C4564n1.f12495e == null) {
                C4564n1.m15790a(C4564n1.C4566a0.WARN, "OneSignal.appContext null, could not read " + str + " from getSharedPreferences.", new Throwable());
                return null;
            }
            SharedPreferences sharedPreferences = C4564n1.f12495e.getSharedPreferences(str, 0);
            return sharedPreferences;
        }
    }

    /* renamed from: a */
    static String m16344a(String str, String str2, String str3) {
        return (String) m16343a(str, str2, String.class, str3);
    }

    /* renamed from: a */
    static boolean m16348a(String str, String str2, boolean z) {
        return ((Boolean) m16343a(str, str2, Boolean.class, Boolean.valueOf(z))).booleanValue();
    }

    /* renamed from: a */
    static int m16340a(String str, String str2, int i) {
        return ((Integer) m16343a(str, str2, Integer.class, Integer.valueOf(i))).intValue();
    }

    /* renamed from: a */
    static long m16341a(String str, String str2, long j) {
        return ((Long) m16343a(str, str2, Long.class, Long.valueOf(j))).longValue();
    }

    /* renamed from: a */
    public static Set<String> m16345a(String str, String str2, Set<String> set) {
        return (Set) m16343a(str, str2, Set.class, set);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r4 = m16349b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        if (r4 == null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r6.equals(java.lang.String.class) == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        return r4.getString(r5, (java.lang.String) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r6.equals(java.lang.Boolean.class) == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        return java.lang.Boolean.valueOf(r4.getBoolean(r5, ((java.lang.Boolean) r7).booleanValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        if (r6.equals(java.lang.Integer.class) == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        return java.lang.Integer.valueOf(r4.getInt(r5, ((java.lang.Integer) r7).intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r6.equals(java.lang.Long.class) == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0086, code lost:
        return java.lang.Long.valueOf(r4.getLong(r5, ((java.lang.Long) r7).longValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008d, code lost:
        if (r6.equals(java.util.Set.class) == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0095, code lost:
        return r4.getStringSet(r5, (java.util.Set) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009a, code lost:
        if (r6.equals(r0) == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a4, code lost:
        return java.lang.Boolean.valueOf(r4.contains(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a5, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a7, code lost:
        return r7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object m16343a(java.lang.String r4, java.lang.String r5, java.lang.Class r6, java.lang.Object r7) {
        /*
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Object>> r1 = f12762b
            java.lang.Object r1 = r1.get(r4)
            java.util.HashMap r1 = (java.util.HashMap) r1
            monitor-enter(r1)
            boolean r2 = r6.equals(r0)     // Catch:{ all -> 0x00aa }
            if (r2 == 0) goto L_0x001e
            boolean r2 = r1.containsKey(r5)     // Catch:{ all -> 0x00aa }
            if (r2 == 0) goto L_0x001e
            r4 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x00aa }
            monitor-exit(r1)     // Catch:{ all -> 0x00aa }
            return r4
        L_0x001e:
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x00aa }
            if (r2 != 0) goto L_0x00a8
            boolean r3 = r1.containsKey(r5)     // Catch:{ all -> 0x00aa }
            if (r3 == 0) goto L_0x002c
            goto L_0x00a8
        L_0x002c:
            monitor-exit(r1)     // Catch:{ all -> 0x00aa }
            android.content.SharedPreferences r4 = m16349b(r4)
            if (r4 == 0) goto L_0x00a7
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0042
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r4 = r4.getString(r5, r7)
            return r4
        L_0x0042:
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0059
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            boolean r4 = r4.getBoolean(r5, r6)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        L_0x0059:
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0070
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            int r4 = r4.getInt(r5, r6)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            return r4
        L_0x0070:
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0087
            java.lang.Long r7 = (java.lang.Long) r7
            long r6 = r7.longValue()
            long r4 = r4.getLong(r5, r6)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            return r4
        L_0x0087:
            java.lang.Class<java.util.Set> r1 = java.util.Set.class
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0096
            java.util.Set r7 = (java.util.Set) r7
            java.util.Set r4 = r4.getStringSet(r5, r7)
            return r4
        L_0x0096:
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x00a5
            boolean r4 = r4.contains(r5)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        L_0x00a5:
            r4 = 0
            return r4
        L_0x00a7:
            return r7
        L_0x00a8:
            monitor-exit(r1)     // Catch:{ all -> 0x00aa }
            return r2
        L_0x00aa:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00aa }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4698w1.m16343a(java.lang.String, java.lang.String, java.lang.Class, java.lang.Object):java.lang.Object");
    }
}
