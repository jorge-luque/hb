package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tapjoy.internal.fl */
public final class C5083fl {

    /* renamed from: a */
    private static final C5083fl f13918a = new C5083fl();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Application f13919b;

    /* renamed from: c */
    private Application.ActivityLifecycleCallbacks f13920c;

    /* renamed from: d */
    private final HashSet f13921d = new HashSet();

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m17195b(Activity activity) {
        return activity.getClass().getName() + "@" + System.identityHashCode(activity);
    }

    /* renamed from: b */
    static /* synthetic */ Application m17194b() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, (Object[]) null);
    }

    /* renamed from: a */
    public static void m17193a(Context context) {
        if (Build.VERSION.SDK_INT >= 14 && context != null) {
            C5083fl flVar = f13918a;
            Context applicationContext = context.getApplicationContext();
            if (flVar.f13919b == null) {
                try {
                    if (applicationContext instanceof Application) {
                        flVar.f13919b = (Application) applicationContext;
                    } else {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        TapjoyUtil.runOnMainThread(new Runnable() {
                            public final void run() {
                                try {
                                    Application unused = C5083fl.this.f13919b = C5083fl.m17194b();
                                } catch (Exception e) {
                                    TapjoyLog.m16654w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
                                } catch (Throwable th) {
                                    countDownLatch.countDown();
                                    throw th;
                                }
                                countDownLatch.countDown();
                            }
                        });
                        countDownLatch.await();
                    }
                } catch (Exception e) {
                    TapjoyLog.m16654w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
                }
                if (flVar.f13919b == null) {
                    return;
                }
            }
            synchronized (flVar) {
                if (flVar.f13920c == null) {
                    Activity c = C3123b.m10222c();
                    if (c != null) {
                        flVar.f13921d.add(m17195b(c));
                    }
                    final HashSet hashSet = flVar.f13921d;
                    C50852 r1 = new Application.ActivityLifecycleCallbacks() {
                        public final void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        public final void onActivityDestroyed(Activity activity) {
                        }

                        public final void onActivityPaused(Activity activity) {
                        }

                        public final void onActivityResumed(Activity activity) {
                        }

                        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        public final void onActivityStarted(Activity activity) {
                            hashSet.add(C5083fl.m17195b(activity));
                            if (hashSet.size() == 1) {
                                C5125gn.m17283a();
                            }
                            C3123b.m10218a(activity);
                        }

                        public final void onActivityStopped(Activity activity) {
                            hashSet.remove(C5083fl.m17195b(activity));
                            if (hashSet.size() <= 0) {
                                C5125gn.m17288b();
                            }
                        }
                    };
                    flVar.f13920c = r1;
                    flVar.f13919b.registerActivityLifecycleCallbacks(r1);
                    C5125gn.m17283a();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m17192a() {
        if (Build.VERSION.SDK_INT >= 14) {
            C5083fl flVar = f13918a;
            if (flVar.f13919b != null) {
                synchronized (flVar) {
                    if (flVar.f13920c != null) {
                        flVar.f13919b.unregisterActivityLifecycleCallbacks(flVar.f13920c);
                        flVar.f13920c = null;
                    }
                }
            }
        }
    }
}
