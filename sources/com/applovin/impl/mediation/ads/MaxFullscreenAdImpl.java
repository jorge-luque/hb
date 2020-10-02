package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import com.applovin.impl.mediation.C1695b;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.mediation.p045b.C1699c;
import com.applovin.impl.sdk.C1836b;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MaxFullscreenAdImpl extends C1694a implements C1836b.C1838a {

    /* renamed from: a */
    private final C1687a f5258a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1836b f5259b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1695b f5260c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f5261d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1699c f5262e = null;

    /* renamed from: f */
    private C1693c f5263f = C1693c.IDLE;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AtomicBoolean f5264g = new AtomicBoolean();
    protected final C1688b listenerWrapper;

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$a */
    public interface C1687a {
        Activity getActivity();
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$b */
    private class C1688b implements MaxAdListener, MaxRewardedAdListener {
        private C1688b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            C1994j.m7930d(MaxFullscreenAdImpl.this.adListener, maxAd);
        }

        public void onAdDisplayFailed(final MaxAd maxAd, final int i) {
            MaxFullscreenAdImpl.this.m6422a(C1693c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.f5259b.mo8292a();
                    MaxFullscreenAdImpl.this.m6421a();
                    MaxFullscreenAdImpl.this.sdk.mo8606z().mo8749b((C1697a) maxAd);
                    C1994j.m7910a(MaxFullscreenAdImpl.this.adListener, maxAd, i);
                }
            });
        }

        public void onAdDisplayed(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f5259b.mo8292a();
            C1994j.m7924b(MaxFullscreenAdImpl.this.adListener, maxAd);
        }

        public void onAdHidden(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f5260c.mo7760a(maxAd);
            MaxFullscreenAdImpl.this.m6422a(C1693c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.m6421a();
                    MaxFullscreenAdImpl.this.sdk.mo8606z().mo8749b((C1697a) maxAd);
                    C1994j.m7928c(MaxFullscreenAdImpl.this.adListener, maxAd);
                }
            });
        }

        public void onAdLoadFailed(final String str, final int i) {
            MaxFullscreenAdImpl.this.m6428b();
            MaxFullscreenAdImpl.this.m6422a(C1693c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    C1994j.m7912a(MaxFullscreenAdImpl.this.adListener, str, i);
                }
            });
        }

        public void onAdLoaded(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.m6425a((C1699c) maxAd);
            if (MaxFullscreenAdImpl.this.f5264g.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.loadRequestBuilder.mo7881a("expired_ad_ad_unit_id");
            } else {
                MaxFullscreenAdImpl.this.m6422a(C1693c.READY, (Runnable) new Runnable() {
                    public void run() {
                        C1994j.m7909a(MaxFullscreenAdImpl.this.adListener, maxAd);
                    }
                });
            }
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1994j.m7932f(MaxFullscreenAdImpl.this.adListener, maxAd);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1994j.m7931e(MaxFullscreenAdImpl.this.adListener, maxAd);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1994j.m7911a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward);
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c */
    public enum C1693c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, C1687a aVar, String str2, C1941j jVar) {
        super(str, maxAdFormat, str2, jVar);
        this.f5258a = aVar;
        this.listenerWrapper = new C1688b();
        this.f5259b = new C1836b(jVar, this);
        this.f5260c = new C1695b(jVar, this.listenerWrapper);
        C1977q.m7748f(str2, "Created new " + str2 + " (" + this + ")");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6421a() {
        C1699c cVar;
        synchronized (this.f5261d) {
            cVar = this.f5262e;
            this.f5262e = null;
        }
        this.sdk.mo8605y().destroyAd(cVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0151  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6422a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c r7, java.lang.Runnable r8) {
        /*
            r6 = this;
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = r6.f5263f
            java.lang.Object r1 = r6.f5261d
            monitor-enter(r1)
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.IDLE     // Catch:{ all -> 0x017c }
            r3 = 1
            r4 = 0
            if (r0 != r2) goto L_0x0039
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.LOADING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0011
            goto L_0x0125
        L_0x0011:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0017
            goto L_0x0125
        L_0x0017:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.SHOWING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0020
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "No ad is loading or loaded"
            goto L_0x004b
        L_0x0020:
            com.applovin.impl.sdk.q r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            r3.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
        L_0x0035:
            r0.mo8746e(r2, r3)     // Catch:{ all -> 0x017c }
            goto L_0x004e
        L_0x0039:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.LOADING     // Catch:{ all -> 0x017c }
            if (r0 != r2) goto L_0x007c
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.IDLE     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0043
            goto L_0x0125
        L_0x0043:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.LOADING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0051
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "An ad is already loading"
        L_0x004b:
            com.applovin.impl.sdk.C1977q.m7751i(r0, r2)     // Catch:{ all -> 0x017c }
        L_0x004e:
            r3 = 0
            goto L_0x0125
        L_0x0051:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.READY     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0057
            goto L_0x0125
        L_0x0057:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.SHOWING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0060
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "An ad is not ready to be shown yet"
            goto L_0x004b
        L_0x0060:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0066
            goto L_0x0125
        L_0x0066:
            com.applovin.impl.sdk.q r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            r3.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x0035
        L_0x007c:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.READY     // Catch:{ all -> 0x017c }
            if (r0 != r2) goto L_0x00bd
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.IDLE     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0086
            goto L_0x0125
        L_0x0086:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.LOADING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x008f
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "An ad is already loaded"
            goto L_0x004b
        L_0x008f:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.READY     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x009a
            com.applovin.impl.sdk.q r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r3 = "An ad is already marked as ready"
            goto L_0x0035
        L_0x009a:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.SHOWING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00a0
            goto L_0x0125
        L_0x00a0:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00a6
            goto L_0x0125
        L_0x00a6:
            com.applovin.impl.sdk.q r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            r3.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x0035
        L_0x00bd:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.SHOWING     // Catch:{ all -> 0x017c }
            if (r0 != r2) goto L_0x0102
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.IDLE     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00c6
            goto L_0x0125
        L_0x00c6:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.LOADING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00d0
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "Can not load another ad while the ad is showing"
            goto L_0x004b
        L_0x00d0:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.READY     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00dc
            com.applovin.impl.sdk.q r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r3 = "An ad is already showing, ignoring"
            goto L_0x0035
        L_0x00dc:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.SHOWING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00e6
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "The ad is already showing, not showing another one"
            goto L_0x004b
        L_0x00e6:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00eb
            goto L_0x0125
        L_0x00eb:
            com.applovin.impl.sdk.q r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            r3.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x0035
        L_0x0102:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C1693c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r0 != r2) goto L_0x010c
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "No operations are allowed on a destroyed instance"
            goto L_0x004b
        L_0x010c:
            com.applovin.impl.sdk.q r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unknown state: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r6.f5263f     // Catch:{ all -> 0x017c }
            r3.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x0035
        L_0x0125:
            if (r3 == 0) goto L_0x0151
            com.applovin.impl.sdk.q r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Transitioning from "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r6.f5263f     // Catch:{ all -> 0x017c }
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = " to "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            r4.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "..."
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x017c }
            r0.mo8742b(r2, r4)     // Catch:{ all -> 0x017c }
            r6.f5263f = r7     // Catch:{ all -> 0x017c }
            goto L_0x0173
        L_0x0151:
            com.applovin.impl.sdk.q r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Not allowed transition from "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r6.f5263f     // Catch:{ all -> 0x017c }
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = " to "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            r4.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x017c }
            r0.mo8745d(r2, r7)     // Catch:{ all -> 0x017c }
        L_0x0173:
            monitor-exit(r1)     // Catch:{ all -> 0x017c }
            if (r3 == 0) goto L_0x017b
            if (r8 == 0) goto L_0x017b
            r8.run()
        L_0x017b:
            return
        L_0x017c:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x017c }
            goto L_0x0180
        L_0x017f:
            throw r7
        L_0x0180:
            goto L_0x017f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.m6422a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c, java.lang.Runnable):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6425a(C1699c cVar) {
        long l = cVar.mo7780l() - (SystemClock.elapsedRealtime() - cVar.mo7775h());
        if (l > TimeUnit.SECONDS.toMillis(2)) {
            this.f5262e = cVar;
            C1977q qVar = this.logger;
            String str = this.tag;
            qVar.mo8742b(str, "Handle ad loaded for regular ad: " + cVar);
            C1977q qVar2 = this.logger;
            String str2 = this.tag;
            qVar2.mo8742b(str2, "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(l) + " seconds from now for " + getAdUnitId() + "...");
            this.f5259b.mo8293a(l);
            return;
        }
        this.logger.mo8742b(this.tag, "Loaded an expired ad, running expire logic...");
        onAdExpired();
    }

    /* renamed from: a */
    private void m6426a(C1699c cVar, Context context, final Runnable runnable) {
        if (cVar == null || !cVar.mo7807x() || C1992h.m7853a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(cVar.mo7808y()).setMessage(cVar.mo7809z()).setPositiveButton(cVar.mo7794A(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6428b() {
        C1699c cVar;
        if (this.f5264g.compareAndSet(true, false)) {
            synchronized (this.f5261d) {
                cVar = this.f5262e;
                this.f5262e = null;
            }
            this.sdk.mo8605y().destroyAd(cVar);
            this.loadRequestBuilder.mo7881a("expired_ad_ad_unit_id");
        }
    }

    public void destroy() {
        m6422a(C1693c.DESTROYED, (Runnable) new Runnable() {
            public void run() {
                synchronized (MaxFullscreenAdImpl.this.f5261d) {
                    if (MaxFullscreenAdImpl.this.f5262e != null) {
                        C1977q qVar = MaxFullscreenAdImpl.this.logger;
                        String str = MaxFullscreenAdImpl.this.tag;
                        qVar.mo8742b(str, "Destroying ad for '" + MaxFullscreenAdImpl.this.adUnitId + "'; current ad: " + MaxFullscreenAdImpl.this.f5262e + "...");
                        MaxFullscreenAdImpl.this.sdk.mo8605y().destroyAd(MaxFullscreenAdImpl.this.f5262e);
                    }
                }
            }
        });
    }

    public boolean isReady() {
        boolean z;
        synchronized (this.f5261d) {
            z = this.f5262e != null && this.f5262e.mo7765a() && this.f5263f == C1693c.READY;
        }
        return z;
    }

    public void loadAd(final Activity activity) {
        C1977q qVar = this.logger;
        String str = this.tag;
        qVar.mo8742b(str, "Loading ad for '" + this.adUnitId + "'...");
        if (isReady()) {
            C1977q qVar2 = this.logger;
            String str2 = this.tag;
            qVar2.mo8742b(str2, "An ad is already loaded for '" + this.adUnitId + "'");
            C1994j.m7909a(this.adListener, (MaxAd) this.f5262e);
            return;
        }
        m6422a(C1693c.LOADING, (Runnable) new Runnable() {
            public void run() {
                Activity activity = activity;
                if (activity == null) {
                    activity = MaxFullscreenAdImpl.this.sdk.mo8572ah();
                }
                Activity activity2 = activity;
                MediationServiceImpl y = MaxFullscreenAdImpl.this.sdk.mo8605y();
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                y.loadAd(maxFullscreenAdImpl.adUnitId, maxFullscreenAdImpl.adFormat, maxFullscreenAdImpl.loadRequestBuilder.mo7883a(), activity2, MaxFullscreenAdImpl.this.listenerWrapper);
            }
        });
    }

    public void onAdExpired() {
        C1977q qVar = this.logger;
        String str = this.tag;
        qVar.mo8742b(str, "Ad expired " + getAdUnitId());
        this.f5264g.set(true);
        Activity activity = this.f5258a.getActivity();
        if (activity == null && (activity = this.sdk.mo8565aa().mo8070a()) == null) {
            m6428b();
            this.listenerWrapper.onAdLoadFailed(this.adUnitId, MaxErrorCodes.NO_ACTIVITY);
            return;
        }
        this.loadRequestBuilder.mo7882a("expired_ad_ad_unit_id", getAdUnitId());
        this.sdk.mo8605y().loadAd(this.adUnitId, this.adFormat, this.loadRequestBuilder.mo7883a(), activity, this.listenerWrapper);
    }

    public void showAd(final String str, final Activity activity) {
        if (activity == null) {
            activity = this.sdk.mo8572ah();
        }
        if (activity == null) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        } else if (((Boolean) this.sdk.mo8549a(C1840b.f5750C)).booleanValue() && (this.sdk.mo8547Z().mo8733a() || this.sdk.mo8547Z().mo8735b())) {
            C1977q.m7751i(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
            C1994j.m7910a(this.adListener, (MaxAd) this.f5262e, -23);
        } else if (!((Boolean) this.sdk.mo8549a(C1840b.f5751D)).booleanValue() || C1992h.m7853a((Context) activity)) {
            m6426a(this.f5262e, (Context) activity, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.m6422a(C1693c.SHOWING, (Runnable) new Runnable() {
                        public void run() {
                            MaxFullscreenAdImpl.this.f5260c.mo7761b(MaxFullscreenAdImpl.this.f5262e);
                            MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                            C1977q qVar = maxFullscreenAdImpl.logger;
                            String str = maxFullscreenAdImpl.tag;
                            qVar.mo8742b(str, "Showing ad for '" + MaxFullscreenAdImpl.this.adUnitId + "'; loaded ad: " + MaxFullscreenAdImpl.this.f5262e + "...");
                            MediationServiceImpl y = MaxFullscreenAdImpl.this.sdk.mo8605y();
                            C1699c b = MaxFullscreenAdImpl.this.f5262e;
                            C16843 r2 = C16843.this;
                            y.showFullscreenAd(b, str, activity);
                        }
                    });
                }
            });
        } else {
            C1977q.m7751i(this.tag, "Attempting to show ad with no internet connection");
            C1994j.m7910a(this.adListener, (MaxAd) this.f5262e, -5201);
        }
    }

    public String toString() {
        return this.tag + "{adUnitId='" + this.adUnitId + '\'' + ", adListener=" + this.adListener + ", isReady=" + isReady() + '}';
    }
}
