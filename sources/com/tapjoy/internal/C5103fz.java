package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.TapjoyLog;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.tapjoy.internal.fz */
abstract class C5103fz {

    /* renamed from: b */
    volatile C5104a f13962b;

    /* renamed from: com.tapjoy.internal.fz$a */
    class C5104a implements TJPlacementListener, Observer {

        /* renamed from: b */
        private final Object f13964b;

        /* renamed from: c */
        private final C5080fi f13965c;

        /* renamed from: d */
        private volatile boolean f13966d;

        /* renamed from: e */
        private TJPlacement f13967e;

        C5104a(C5103fz fzVar, Object obj) {
            this(obj, new C5080fi(TapjoyConstants.TIMER_INCREMENT));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo31270a() {
            synchronized (this) {
                if (!this.f13966d) {
                    if (this.f13965c.mo31235a()) {
                        m17232a("Timed out");
                        return;
                    }
                    if (!TapjoyConnectCore.isConnected()) {
                        C5096fs.f13948a.addObserver(this);
                        if (TapjoyConnectCore.isConnected()) {
                            C5096fs.f13948a.deleteObserver(this);
                        } else {
                            return;
                        }
                    }
                    if (this.f13967e == null) {
                        if (!C5103fz.this.mo31255a()) {
                            m17232a("Cannot request");
                            return;
                        }
                        TJPlacement a = C5103fz.this.mo31253a(TapjoyConnectCore.getContext(), this, this.f13964b);
                        this.f13967e = a;
                        a.requestContent();
                    } else if (this.f13967e.isContentReady()) {
                        if (C5103fz.this.mo31267a((Observer) this)) {
                            this.f13967e.showContent();
                            m17232a((String) null);
                        }
                    }
                }
            }
        }

        public final void onClick(TJPlacement tJPlacement) {
        }

        public final void onContentDismiss(TJPlacement tJPlacement) {
        }

        public final void onContentReady(TJPlacement tJPlacement) {
            mo31270a();
        }

        public final void onContentShow(TJPlacement tJPlacement) {
        }

        public final void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
        }

        public final void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
            m17232a(tJError.message);
        }

        public final void onRequestSuccess(TJPlacement tJPlacement) {
        }

        public final void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i) {
        }

        public final void update(Observable observable, Object obj) {
            mo31270a();
        }

        C5104a(Object obj, C5080fi fiVar) {
            this.f13964b = obj;
            this.f13965c = fiVar;
        }

        /* renamed from: a */
        private void m17232a(String str) {
            synchronized (this) {
                String a = C5103fz.this.mo31254a(this.f13964b);
                if (str == null) {
                    TapjoyLog.m16652i("SystemPlacement", "Placement " + a + " is presented now");
                } else {
                    TapjoyLog.m16652i("SystemPlacement", "Cannot show placement " + a + " now (" + str + ")");
                }
                this.f13966d = true;
                this.f13967e = null;
                C5096fs.f13948a.deleteObserver(this);
                C5096fs.f13952e.deleteObserver(this);
                C5096fs.f13950c.deleteObserver(this);
            }
            C5103fz fzVar = C5103fz.this;
            synchronized (fzVar) {
                if (fzVar.f13962b == this) {
                    fzVar.f13962b = null;
                }
            }
        }
    }

    C5103fz() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract TJPlacement mo31253a(Context context, TJPlacementListener tJPlacementListener, Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo31254a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo31255a() {
        return !TapjoyConnectCore.isFullScreenViewOpen();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C5104a mo31268b(Object obj) {
        return new C5104a(this, obj);
    }

    /* renamed from: c */
    public final boolean mo31269c(Object obj) {
        if (!mo31255a()) {
            return false;
        }
        C5104a aVar = null;
        synchronized (this) {
            if (this.f13962b == null) {
                aVar = mo31268b(obj);
                this.f13962b = aVar;
            }
        }
        if (aVar == null) {
            return false;
        }
        aVar.mo31270a();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo31267a(Observer observer) {
        if (TapjoyConnectCore.isFullScreenViewOpen()) {
            C5096fs.f13952e.addObserver(observer);
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                return false;
            }
            C5096fs.f13952e.deleteObserver(observer);
        }
        if (C3145gz.m10321a().mo18556d()) {
            return true;
        }
        C5096fs.f13950c.addObserver(observer);
        if (!C3145gz.m10321a().mo18556d()) {
            return false;
        }
        C5096fs.f13950c.deleteObserver(observer);
        return true;
    }
}
