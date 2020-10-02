package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.internal.C5103fz;
import com.tapjoy.internal.C5160hk;
import java.util.Observer;

/* renamed from: com.tapjoy.internal.fx */
public final class C5101fx extends C5160hk {

    /* renamed from: b */
    private final C5103fz f13960b = new C5103fz() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* synthetic */ TJPlacement mo31253a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            C5160hk.C5161a aVar = (C5160hk.C5161a) obj;
            TJPlacement createPlacement = TJPlacementManager.createPlacement(TapjoyConnectCore.getContext(), aVar.f14142b, false, tJPlacementListener);
            createPlacement.pushId = aVar.f14141a;
            return createPlacement;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final boolean mo31255a() {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public final /* synthetic */ C5103fz.C5104a mo31268b(Object obj) {
            C5160hk.C5161a aVar = (C5160hk.C5161a) obj;
            return new C5103fz.C5104a(aVar, aVar.f14144d);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ String mo31254a(Object obj) {
            C5160hk.C5161a aVar = (C5160hk.C5161a) obj;
            if (aVar != null) {
                return aVar.f14142b;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final boolean mo31267a(Observer observer) {
            if (TapjoyConnectCore.isViewOpen()) {
                TJPlacementManager.dismissContentShowing(true);
            }
            return super.mo31267a(observer);
        }
    };

    static {
        C5160hk.m17380a((C5160hk) new C5101fx());
    }

    private C5101fx() {
    }

    /* renamed from: a */
    public static void m17218a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31265a(C5160hk.C5161a aVar) {
        this.f13960b.mo31269c(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean mo31266b() {
        return this.f13960b.f13962b != null;
    }
}
