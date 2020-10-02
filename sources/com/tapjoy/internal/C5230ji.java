package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* renamed from: com.tapjoy.internal.ji */
public final class C5230ji {

    /* renamed from: com.tapjoy.internal.ji$a */
    public static class C5231a {

        /* renamed from: a */
        final Bundle f14347a;

        /* renamed from: b */
        final C5237jl[] f14348b;

        /* renamed from: c */
        final C5237jl[] f14349c;

        /* renamed from: d */
        boolean f14350d;

        /* renamed from: e */
        public int f14351e;

        /* renamed from: f */
        public CharSequence f14352f;

        /* renamed from: g */
        public PendingIntent f14353g;
    }

    /* renamed from: com.tapjoy.internal.ji$b */
    public static class C5232b extends C5234d {

        /* renamed from: e */
        private CharSequence f14354e;

        /* renamed from: a */
        public final C5232b mo31441a(CharSequence charSequence) {
            this.f14396b = C5233c.m17585d(charSequence);
            return this;
        }

        /* renamed from: b */
        public final C5232b mo31443b(CharSequence charSequence) {
            this.f14354e = C5233c.m17585d(charSequence);
            return this;
        }

        /* renamed from: a */
        public final void mo31442a(C5229jh jhVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(jhVar.mo31440a()).setBigContentTitle(this.f14396b).bigText(this.f14354e);
                if (this.f14398d) {
                    bigText.setSummaryText(this.f14397c);
                }
            }
        }
    }

    /* renamed from: com.tapjoy.internal.ji$c */
    public static class C5233c {

        /* renamed from: A */
        Bundle f14355A;

        /* renamed from: B */
        int f14356B = 0;

        /* renamed from: C */
        int f14357C = 0;

        /* renamed from: D */
        Notification f14358D;

        /* renamed from: E */
        RemoteViews f14359E;

        /* renamed from: F */
        RemoteViews f14360F;

        /* renamed from: G */
        RemoteViews f14361G;

        /* renamed from: H */
        String f14362H;

        /* renamed from: I */
        int f14363I = 0;

        /* renamed from: J */
        String f14364J;

        /* renamed from: K */
        long f14365K;

        /* renamed from: L */
        int f14366L = 0;

        /* renamed from: M */
        Notification f14367M;
        @Deprecated

        /* renamed from: N */
        public ArrayList f14368N;

        /* renamed from: a */
        public Context f14369a;

        /* renamed from: b */
        public ArrayList f14370b = new ArrayList();

        /* renamed from: c */
        CharSequence f14371c;

        /* renamed from: d */
        CharSequence f14372d;

        /* renamed from: e */
        PendingIntent f14373e;

        /* renamed from: f */
        PendingIntent f14374f;

        /* renamed from: g */
        RemoteViews f14375g;

        /* renamed from: h */
        Bitmap f14376h;

        /* renamed from: i */
        CharSequence f14377i;

        /* renamed from: j */
        int f14378j;

        /* renamed from: k */
        int f14379k;

        /* renamed from: l */
        boolean f14380l = true;

        /* renamed from: m */
        boolean f14381m;

        /* renamed from: n */
        C5234d f14382n;

        /* renamed from: o */
        CharSequence f14383o;

        /* renamed from: p */
        CharSequence[] f14384p;

        /* renamed from: q */
        int f14385q;

        /* renamed from: r */
        int f14386r;

        /* renamed from: s */
        boolean f14387s;

        /* renamed from: t */
        String f14388t;

        /* renamed from: u */
        boolean f14389u;

        /* renamed from: v */
        String f14390v;

        /* renamed from: w */
        boolean f14391w = false;

        /* renamed from: x */
        boolean f14392x;

        /* renamed from: y */
        boolean f14393y;

        /* renamed from: z */
        String f14394z;

        public C5233c(Context context, String str) {
            Notification notification = new Notification();
            this.f14367M = notification;
            this.f14369a = context;
            this.f14362H = str;
            notification.when = System.currentTimeMillis();
            this.f14367M.audioStreamType = -1;
            this.f14379k = 0;
            this.f14368N = new ArrayList();
        }

        /* renamed from: a */
        public final C5233c mo31445a(int i) {
            this.f14367M.icon = i;
            return this;
        }

        /* renamed from: b */
        public final C5233c mo31451b(CharSequence charSequence) {
            this.f14372d = m17585d(charSequence);
            return this;
        }

        /* renamed from: c */
        public final C5233c mo31453c(CharSequence charSequence) {
            this.f14367M.tickerText = m17585d(charSequence);
            return this;
        }

        /* renamed from: d */
        public final Notification mo31454d() {
            Notification notification;
            C5235jj jjVar = new C5235jj(this);
            C5234d dVar = jjVar.f14400b.f14382n;
            if (dVar != null) {
                dVar.mo31442a((C5229jh) jjVar);
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                notification = jjVar.f14399a.build();
            } else if (i >= 24) {
                notification = jjVar.f14399a.build();
                if (jjVar.f14405g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || jjVar.f14405g != 2)) {
                        C5235jj.m17599a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.f14405g == 1) {
                        C5235jj.m17599a(notification);
                    }
                }
            } else if (i >= 21) {
                jjVar.f14399a.setExtras(jjVar.f14404f);
                notification = jjVar.f14399a.build();
                RemoteViews remoteViews = jjVar.f14401c;
                if (remoteViews != null) {
                    notification.contentView = remoteViews;
                }
                RemoteViews remoteViews2 = jjVar.f14402d;
                if (remoteViews2 != null) {
                    notification.bigContentView = remoteViews2;
                }
                RemoteViews remoteViews3 = jjVar.f14406h;
                if (remoteViews3 != null) {
                    notification.headsUpContentView = remoteViews3;
                }
                if (jjVar.f14405g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || jjVar.f14405g != 2)) {
                        C5235jj.m17599a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.f14405g == 1) {
                        C5235jj.m17599a(notification);
                    }
                }
            } else if (i >= 20) {
                jjVar.f14399a.setExtras(jjVar.f14404f);
                notification = jjVar.f14399a.build();
                RemoteViews remoteViews4 = jjVar.f14401c;
                if (remoteViews4 != null) {
                    notification.contentView = remoteViews4;
                }
                RemoteViews remoteViews5 = jjVar.f14402d;
                if (remoteViews5 != null) {
                    notification.bigContentView = remoteViews5;
                }
                if (jjVar.f14405g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || jjVar.f14405g != 2)) {
                        C5235jj.m17599a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.f14405g == 1) {
                        C5235jj.m17599a(notification);
                    }
                }
            } else if (i >= 19) {
                SparseArray a = C5236jk.m17604a(jjVar.f14403e);
                if (a != null) {
                    jjVar.f14404f.putSparseParcelableArray("android.support.actionExtras", a);
                }
                jjVar.f14399a.setExtras(jjVar.f14404f);
                notification = jjVar.f14399a.build();
                RemoteViews remoteViews6 = jjVar.f14401c;
                if (remoteViews6 != null) {
                    notification.contentView = remoteViews6;
                }
                RemoteViews remoteViews7 = jjVar.f14402d;
                if (remoteViews7 != null) {
                    notification.bigContentView = remoteViews7;
                }
            } else if (i >= 16) {
                notification = jjVar.f14399a.build();
                Bundle a2 = C5230ji.m17581a(notification);
                Bundle bundle = new Bundle(jjVar.f14404f);
                for (String str : jjVar.f14404f.keySet()) {
                    if (a2.containsKey(str)) {
                        bundle.remove(str);
                    }
                }
                a2.putAll(bundle);
                SparseArray a3 = C5236jk.m17604a(jjVar.f14403e);
                if (a3 != null) {
                    C5230ji.m17581a(notification).putSparseParcelableArray("android.support.actionExtras", a3);
                }
                RemoteViews remoteViews8 = jjVar.f14401c;
                if (remoteViews8 != null) {
                    notification.contentView = remoteViews8;
                }
                RemoteViews remoteViews9 = jjVar.f14402d;
                if (remoteViews9 != null) {
                    notification.bigContentView = remoteViews9;
                }
            } else {
                notification = jjVar.f14399a.getNotification();
            }
            RemoteViews remoteViews10 = jjVar.f14400b.f14359E;
            if (remoteViews10 != null) {
                notification.contentView = remoteViews10;
            }
            if (Build.VERSION.SDK_INT >= 16 && dVar != null) {
                C5230ji.m17581a(notification);
            }
            return notification;
        }

        /* renamed from: a */
        public final C5233c mo31449a(CharSequence charSequence) {
            this.f14371c = m17585d(charSequence);
            return this;
        }

        /* renamed from: b */
        public final C5233c mo31450b() {
            this.f14367M.defaults = 1;
            return this;
        }

        /* renamed from: c */
        public final C5233c mo31452c() {
            this.f14379k = 0;
            return this;
        }

        /* renamed from: a */
        public final C5233c mo31446a(PendingIntent pendingIntent) {
            this.f14373e = pendingIntent;
            return this;
        }

        /* renamed from: a */
        public final C5233c mo31447a(Bitmap bitmap) {
            this.f14376h = bitmap;
            return this;
        }

        /* renamed from: a */
        public final C5233c mo31448a(C5234d dVar) {
            if (this.f14382n != dVar) {
                this.f14382n = dVar;
                if (dVar != null) {
                    dVar.mo31455a(this);
                }
            }
            return this;
        }

        /* renamed from: a */
        public final C5233c mo31444a() {
            this.f14367M.flags |= 16;
            return this;
        }

        /* renamed from: d */
        protected static CharSequence m17585d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* renamed from: com.tapjoy.internal.ji$d */
    public static abstract class C5234d {

        /* renamed from: a */
        protected C5233c f14395a;

        /* renamed from: b */
        CharSequence f14396b;

        /* renamed from: c */
        CharSequence f14397c;

        /* renamed from: d */
        boolean f14398d = false;

        /* renamed from: a */
        public void mo31442a(C5229jh jhVar) {
        }

        /* renamed from: a */
        public final void mo31455a(C5233c cVar) {
            if (this.f14395a != cVar) {
                this.f14395a = cVar;
                if (cVar != null) {
                    cVar.mo31448a(this);
                }
            }
        }
    }

    /* renamed from: a */
    public static Bundle m17581a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return C5236jk.m17603a(notification);
        }
        return null;
    }
}
