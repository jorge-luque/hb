package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.C0725i;
import androidx.core.graphics.drawable.IconCompat;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.core.app.j */
/* compiled from: NotificationCompatBuilder */
class C0734j implements C0724h {

    /* renamed from: a */
    private final Notification.Builder f1870a;

    /* renamed from: b */
    private final C0725i.C0730e f1871b;

    /* renamed from: c */
    private RemoteViews f1872c;

    /* renamed from: d */
    private RemoteViews f1873d;

    /* renamed from: e */
    private final List<Bundle> f1874e = new ArrayList();

    /* renamed from: f */
    private final Bundle f1875f = new Bundle();

    /* renamed from: g */
    private int f1876g;

    /* renamed from: h */
    private RemoteViews f1877h;

    C0734j(C0725i.C0730e eVar) {
        ArrayList<String> arrayList;
        this.f1871b = eVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1870a = new Notification.Builder(eVar.f1839a, eVar.f1830I);
        } else {
            this.f1870a = new Notification.Builder(eVar.f1839a);
        }
        Notification notification = eVar.f1837P;
        this.f1870a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f1846h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f1842d).setContentText(eVar.f1843e).setContentInfo(eVar.f1848j).setContentIntent(eVar.f1844f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f1845g, (notification.flags & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) != 0).setLargeIcon(eVar.f1847i).setNumber(eVar.f1849k).setProgress(eVar.f1856r, eVar.f1857s, eVar.f1858t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f1870a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1870a.setSubText(eVar.f1854p).setUsesChronometer(eVar.f1852n).setPriority(eVar.f1850l);
            Iterator<C0725i.C0726a> it = eVar.f1840b.iterator();
            while (it.hasNext()) {
                m2306a(it.next());
            }
            Bundle bundle = eVar.f1823B;
            if (bundle != null) {
                this.f1875f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.f1862x) {
                    this.f1875f.putBoolean("android.support.localOnly", true);
                }
                String str = eVar.f1859u;
                if (str != null) {
                    this.f1875f.putString("android.support.groupKey", str);
                    if (eVar.f1860v) {
                        this.f1875f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1875f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = eVar.f1861w;
                if (str2 != null) {
                    this.f1875f.putString("android.support.sortKey", str2);
                }
            }
            this.f1872c = eVar.f1827F;
            this.f1873d = eVar.f1828G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1870a.setShowWhen(eVar.f1851m);
            if (Build.VERSION.SDK_INT < 21 && (arrayList = eVar.f1838Q) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f1875f;
                ArrayList<String> arrayList2 = eVar.f1838Q;
                bundle2.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1870a.setLocalOnly(eVar.f1862x).setGroup(eVar.f1859u).setGroupSummary(eVar.f1860v).setSortKey(eVar.f1861w);
            this.f1876g = eVar.f1834M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1870a.setCategory(eVar.f1822A).setColor(eVar.f1824C).setVisibility(eVar.f1825D).setPublicVersion(eVar.f1826E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = eVar.f1838Q.iterator();
            while (it2.hasNext()) {
                this.f1870a.addPerson(it2.next());
            }
            this.f1877h = eVar.f1829H;
            if (eVar.f1841c.size() > 0) {
                Bundle bundle3 = eVar.mo3933b().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle();
                for (int i = 0; i < eVar.f1841c.size(); i++) {
                    bundle4.putBundle(Integer.toString(i), C0735k.m2312a(eVar.f1841c.get(i)));
                }
                bundle3.putBundle("invisible_actions", bundle4);
                eVar.mo3933b().putBundle("android.car.EXTENSIONS", bundle3);
                this.f1875f.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1870a.setExtras(eVar.f1823B).setRemoteInputHistory(eVar.f1855q);
            RemoteViews remoteViews = eVar.f1827F;
            if (remoteViews != null) {
                this.f1870a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.f1828G;
            if (remoteViews2 != null) {
                this.f1870a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.f1829H;
            if (remoteViews3 != null) {
                this.f1870a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1870a.setBadgeIconType(eVar.f1831J).setShortcutId(eVar.f1832K).setTimeoutAfter(eVar.f1833L).setGroupAlertBehavior(eVar.f1834M);
            if (eVar.f1864z) {
                this.f1870a.setColorized(eVar.f1863y);
            }
            if (!TextUtils.isEmpty(eVar.f1830I)) {
                this.f1870a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1870a.setAllowSystemGeneratedContextualActions(eVar.f1835N);
            this.f1870a.setBubbleMetadata(C0725i.C0729d.m2260a(eVar.f1836O));
        }
    }

    /* renamed from: a */
    public Notification.Builder mo3900a() {
        return this.f1870a;
    }

    /* renamed from: b */
    public Notification mo3956b() {
        Bundle a;
        RemoteViews d;
        RemoteViews b;
        C0725i.C0733h hVar = this.f1871b.f1853o;
        if (hVar != null) {
            hVar.mo3914a((C0724h) this);
        }
        RemoteViews c = hVar != null ? hVar.mo3954c(this) : null;
        Notification c2 = mo3957c();
        if (c != null) {
            c2.contentView = c;
        } else {
            RemoteViews remoteViews = this.f1871b.f1827F;
            if (remoteViews != null) {
                c2.contentView = remoteViews;
            }
        }
        if (!(Build.VERSION.SDK_INT < 16 || hVar == null || (b = hVar.mo3953b(this)) == null)) {
            c2.bigContentView = b;
        }
        if (!(Build.VERSION.SDK_INT < 21 || hVar == null || (d = this.f1871b.f1853o.mo3955d(this)) == null)) {
            c2.headsUpContentView = d;
        }
        if (!(Build.VERSION.SDK_INT < 16 || hVar == null || (a = C0725i.m2241a(c2)) == null)) {
            hVar.mo3951a(a);
        }
        return c2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Notification mo3957c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f1870a.build();
        }
        if (i >= 24) {
            Notification build = this.f1870a.build();
            if (this.f1876g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f1876g != 2)) {
                    m2305a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f1876g == 1) {
                    m2305a(build);
                }
            }
            return build;
        } else if (i >= 21) {
            this.f1870a.setExtras(this.f1875f);
            Notification build2 = this.f1870a.build();
            RemoteViews remoteViews = this.f1872c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1873d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f1877h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f1876g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f1876g != 2)) {
                    m2305a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f1876g == 1) {
                    m2305a(build2);
                }
            }
            return build2;
        } else if (i >= 20) {
            this.f1870a.setExtras(this.f1875f);
            Notification build3 = this.f1870a.build();
            RemoteViews remoteViews4 = this.f1872c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1873d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f1876g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f1876g != 2)) {
                    m2305a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f1876g == 1) {
                    m2305a(build3);
                }
            }
            return build3;
        } else if (i >= 19) {
            SparseArray<Bundle> a = C0735k.m2314a(this.f1874e);
            if (a != null) {
                this.f1875f.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f1870a.setExtras(this.f1875f);
            Notification build4 = this.f1870a.build();
            RemoteViews remoteViews6 = this.f1872c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1873d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i < 16) {
            return this.f1870a.getNotification();
        } else {
            Notification build5 = this.f1870a.build();
            Bundle a2 = C0725i.m2241a(build5);
            Bundle bundle = new Bundle(this.f1875f);
            for (String str : this.f1875f.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            SparseArray<Bundle> a3 = C0735k.m2314a(this.f1874e);
            if (a3 != null) {
                C0725i.m2241a(build5).putSparseParcelableArray("android.support.actionExtras", a3);
            }
            RemoteViews remoteViews8 = this.f1872c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f1873d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }

    /* renamed from: a */
    private void m2306a(C0725i.C0726a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        Icon icon;
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            if (i >= 23) {
                IconCompat f = aVar.mo3906f();
                if (f == null) {
                    icon = null;
                } else {
                    icon = f.mo4225e();
                }
                builder = new Notification.Action.Builder(icon, aVar.mo3910j(), aVar.mo3901a());
            } else {
                builder = new Notification.Action.Builder(aVar.mo3905e(), aVar.mo3910j(), aVar.mo3901a());
            }
            if (aVar.mo3907g() != null) {
                for (RemoteInput addRemoteInput : C0743m.m2339a(aVar.mo3907g())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.mo3904d() != null) {
                bundle = new Bundle(aVar.mo3904d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo3902b());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.mo3902b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.mo3908h());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.mo3908h());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.mo3911k());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.mo3909i());
            builder.addExtras(bundle);
            this.f1870a.addAction(builder.build());
        } else if (i >= 16) {
            this.f1874e.add(C0735k.m2310a(this.f1870a, aVar));
        }
    }

    /* renamed from: a */
    private void m2305a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & -2;
        notification.defaults = i;
        notification.defaults = i & -3;
    }
}
