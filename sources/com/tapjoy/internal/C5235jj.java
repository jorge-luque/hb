package com.tapjoy.internal;

import android.app.Notification;
import android.app.RemoteInput;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.internal.C5230ji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tapjoy.internal.jj */
final class C5235jj implements C5229jh {

    /* renamed from: a */
    final Notification.Builder f14399a;

    /* renamed from: b */
    final C5230ji.C5233c f14400b;

    /* renamed from: c */
    RemoteViews f14401c;

    /* renamed from: d */
    RemoteViews f14402d;

    /* renamed from: e */
    final List f14403e = new ArrayList();

    /* renamed from: f */
    final Bundle f14404f = new Bundle();

    /* renamed from: g */
    int f14405g;

    /* renamed from: h */
    RemoteViews f14406h;

    C5235jj(C5230ji.C5233c cVar) {
        ArrayList arrayList;
        this.f14400b = cVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f14399a = new Notification.Builder(cVar.f14369a, cVar.f14362H);
        } else {
            this.f14399a = new Notification.Builder(cVar.f14369a);
        }
        Notification notification = cVar.f14367M;
        this.f14399a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.f14375g).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.f14371c).setContentText(cVar.f14372d).setContentInfo(cVar.f14377i).setContentIntent(cVar.f14373e).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.f14374f, (notification.flags & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) != 0).setLargeIcon(cVar.f14376h).setNumber(cVar.f14378j).setProgress(cVar.f14385q, cVar.f14386r, cVar.f14387s);
        if (Build.VERSION.SDK_INT < 21) {
            this.f14399a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f14399a.setSubText(cVar.f14383o).setUsesChronometer(cVar.f14381m).setPriority(cVar.f14379k);
            Iterator it = cVar.f14370b.iterator();
            while (it.hasNext()) {
                m17600a((C5230ji.C5231a) it.next());
            }
            Bundle bundle = cVar.f14355A;
            if (bundle != null) {
                this.f14404f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (cVar.f14391w) {
                    this.f14404f.putBoolean("android.support.localOnly", true);
                }
                String str = cVar.f14388t;
                if (str != null) {
                    this.f14404f.putString("android.support.groupKey", str);
                    if (cVar.f14389u) {
                        this.f14404f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f14404f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = cVar.f14390v;
                if (str2 != null) {
                    this.f14404f.putString("android.support.sortKey", str2);
                }
            }
            this.f14401c = cVar.f14359E;
            this.f14402d = cVar.f14360F;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f14399a.setShowWhen(cVar.f14380l);
            if (Build.VERSION.SDK_INT < 21 && (arrayList = cVar.f14368N) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f14404f;
                ArrayList arrayList2 = cVar.f14368N;
                bundle2.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f14399a.setLocalOnly(cVar.f14391w).setGroup(cVar.f14388t).setGroupSummary(cVar.f14389u).setSortKey(cVar.f14390v);
            this.f14405g = cVar.f14366L;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f14399a.setCategory(cVar.f14394z).setColor(cVar.f14356B).setVisibility(cVar.f14357C).setPublicVersion(cVar.f14358D).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = cVar.f14368N.iterator();
            while (it2.hasNext()) {
                this.f14399a.addPerson((String) it2.next());
            }
            this.f14406h = cVar.f14361G;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f14399a.setExtras(cVar.f14355A).setRemoteInputHistory(cVar.f14384p);
            RemoteViews remoteViews = cVar.f14359E;
            if (remoteViews != null) {
                this.f14399a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = cVar.f14360F;
            if (remoteViews2 != null) {
                this.f14399a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = cVar.f14361G;
            if (remoteViews3 != null) {
                this.f14399a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f14399a.setBadgeIconType(cVar.f14363I).setShortcutId(cVar.f14364J).setTimeoutAfter(cVar.f14365K).setGroupAlertBehavior(cVar.f14366L);
            if (cVar.f14393y) {
                this.f14399a.setColorized(cVar.f14392x);
            }
            if (!TextUtils.isEmpty(cVar.f14362H)) {
                this.f14399a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
    }

    /* renamed from: a */
    public final Notification.Builder mo31440a() {
        return this.f14399a;
    }

    /* renamed from: a */
    private void m17600a(C5230ji.C5231a aVar) {
        Bundle bundle;
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            Notification.Action.Builder builder = new Notification.Action.Builder(aVar.f14351e, aVar.f14352f, aVar.f14353g);
            C5237jl[] jlVarArr = aVar.f14348b;
            if (jlVarArr != null) {
                for (RemoteInput addRemoteInput : C5237jl.m17606a(jlVarArr)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.f14347a != null) {
                bundle = new Bundle(aVar.f14347a);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f14350d);
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.f14350d);
            }
            builder.addExtras(bundle);
            this.f14399a.addAction(builder.build());
        } else if (i >= 16) {
            this.f14403e.add(C5236jk.m17602a(this.f14399a, aVar));
        }
    }

    /* renamed from: a */
    static void m17599a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & -2;
        notification.defaults = i;
        notification.defaults = i & -3;
    }
}
