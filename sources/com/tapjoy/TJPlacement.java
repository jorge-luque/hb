package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.C3137gf;
import com.tapjoy.internal.C3145gz;
import com.tapjoy.internal.C3166jq;
import com.tapjoy.internal.C5087fn;
import com.tapjoy.internal.C5093fq;
import com.tapjoy.internal.C5100fw;
import com.tapjoy.internal.C5119ge;
import com.tapjoy.internal.C5132gs;
import com.tapjoy.internal.C5135gv;
import com.tapjoy.internal.C5151he;
import java.util.HashMap;
import java.util.UUID;

public class TJPlacement {

    /* renamed from: a */
    TJPlacementListener f13057a;

    /* renamed from: b */
    private TJCorePlacement f13058b;

    /* renamed from: c */
    private TJPlacementListener f13059c;

    /* renamed from: d */
    private TJPlacementVideoListener f13060d;

    /* renamed from: e */
    private String f13061e;
    public String pushId;

    @Deprecated
    public TJPlacement(Context context, String str, TJPlacementListener tJPlacementListener) {
        TJCorePlacement a = TJPlacementManager.m16592a(str);
        a = a == null ? TJPlacementManager.m16593a(str, "", "", false, false) : a;
        a.setContext(context);
        m16590a(a, tJPlacementListener);
    }

    /* renamed from: a */
    private void m16590a(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        this.f13058b = tJCorePlacement;
        this.f13061e = UUID.randomUUID().toString();
        this.f13059c = tJPlacementListener;
        this.f13057a = tJPlacementListener != null ? (TJPlacementListener) C5087fn.m17200a(tJPlacementListener, TJPlacementListener.class) : null;
        FiveRocksIntegration.addPlacementCallback(getName(), this);
    }

    public static void dismissContent() {
        TJPlacementManager.dismissContentShowing("true".equals(TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISMISS_CONTENT_ALL")));
    }

    public String getGUID() {
        return this.f13061e;
    }

    public TJPlacementListener getListener() {
        return this.f13059c;
    }

    public String getName() {
        return this.f13058b.getPlacementData() != null ? this.f13058b.getPlacementData().getPlacementName() : "";
    }

    public TJPlacementVideoListener getVideoListener() {
        return this.f13060d;
    }

    public boolean isContentAvailable() {
        this.f13058b.f12999f.mo31264a(1);
        return this.f13058b.isContentAvailable();
    }

    public boolean isContentReady() {
        boolean isContentReady = this.f13058b.isContentReady();
        C5100fw fwVar = this.f13058b.f12999f;
        if (isContentReady) {
            fwVar.mo31264a(4);
        } else {
            fwVar.mo31264a(2);
        }
        return isContentReady;
    }

    public boolean isLimited() {
        return this.f13058b.isLimited();
    }

    public void requestContent() {
        boolean z;
        String name = getName();
        TapjoyLog.m16652i("TJPlacement", "requestContent() called for placement " + name);
        C3137gf.m10280a("TJPlacement.requestContent").mo18524a("placement", (Object) name).mo18524a("placement_type", (Object) this.f13058b.f12996c.getPlacementType());
        if (C5119ge.m17262a() != null && C3166jq.m10436c(C5119ge.m17262a().f14010b)) {
            TapjoyLog.m16654w("TJPlacement", "[INFO] Your application calls requestContent without having previously called setUserConsent. You can review Tapjoy supported consent API here - https://dev.tapjoy.com/sdk-integration/#sdk11122_gdpr_release.");
        }
        if (!isLimited()) {
            z = TapjoyConnectCore.isConnected();
        } else {
            z = TapjoyConnectCore.isLimitedConnected();
        }
        if (!z) {
            C3137gf.m10287b("TJPlacement.requestContent").mo18527b("not connected").mo18529c();
            m16591a(new TJError(0, "SDK not connected -- connect must be called first with a successful callback"));
        } else if (this.f13058b.getContext() == null) {
            C3137gf.m10287b("TJPlacement.requestContent").mo18527b("no context").mo18529c();
            m16591a(new TJError(0, "Context is null -- TJPlacement requires a valid Context."));
        } else if (C3166jq.m10436c(name)) {
            C3137gf.m10287b("TJPlacement.requestContent").mo18527b("invalid name").mo18529c();
            m16591a(new TJError(0, "Invalid placement name -- TJPlacement requires a valid placement name."));
        } else {
            try {
                this.f13058b.mo30684a(this);
            } finally {
                C3137gf.m10290d("TJPlacement.requestContent");
            }
        }
    }

    public void setAdapterVersion(String str) {
        this.f13058b.f13007n = str;
    }

    public void setAuctionData(HashMap hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            TapjoyLog.m16649d("TJPlacement", "auctionData can not be null or empty");
            return;
        }
        TJCorePlacement tJCorePlacement = this.f13058b;
        tJCorePlacement.f13010q = hashMap;
        String b = tJCorePlacement.mo30688b();
        if (!C3166jq.m10436c(b)) {
            tJCorePlacement.f12996c.setAuctionMediationURL(TapjoyConnectCore.getPlacementURL() + "v1/apps/" + b + "/bid_content?");
            return;
        }
        TapjoyLog.m16652i(TJCorePlacement.f12993a, "Placement auction data can not be set for a null app ID");
    }

    public void setMediationId(String str) {
        this.f13058b.f13009p = str;
    }

    public void setMediationName(String str) {
        TapjoyLog.m16649d("TJPlacement", "setMediationName=" + str);
        if (!C3166jq.m10436c(str)) {
            TJCorePlacement tJCorePlacement = this.f13058b;
            Context context = tJCorePlacement != null ? tJCorePlacement.getContext() : null;
            TJCorePlacement a = TJPlacementManager.m16593a(getName(), str, "", false, isLimited());
            this.f13058b = a;
            a.f13008o = str;
            a.f13006m = str;
            a.f12996c.setPlacementType(str);
            String b = a.mo30688b();
            if (!C3166jq.m10436c(b)) {
                a.f12996c.setMediationURL(TapjoyConnectCore.getPlacementURL() + "v1/apps/" + b + "/mediation_content?");
            } else {
                TapjoyLog.m16652i(TJCorePlacement.f12993a, "Placement mediation name can not be set for a null app ID");
            }
            if (context != null) {
                this.f13058b.setContext(context);
            }
        }
    }

    public void setVideoListener(TJPlacementVideoListener tJPlacementVideoListener) {
        this.f13060d = tJPlacementVideoListener;
    }

    public void showContent() {
        String name = getName();
        TapjoyLog.m16652i("TJPlacement", "showContent() called for placement " + name);
        TJCorePlacement tJCorePlacement = this.f13058b;
        C3137gf.m10280a("TJPlacement.showContent").mo18524a("placement", (Object) tJCorePlacement.f12996c.getPlacementName()).mo18524a("placement_type", (Object) tJCorePlacement.f12996c.getPlacementType()).mo18524a("content_type", (Object) tJCorePlacement.mo30683a());
        C5100fw fwVar = tJCorePlacement.f12999f;
        fwVar.mo31264a(8);
        C5093fq fqVar = fwVar.f13955a;
        if (fqVar != null) {
            fqVar.mo31256a();
        }
        if (!this.f13058b.isContentAvailable()) {
            TapjoyLog.m16650e("TJPlacement", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "No placement content available. Can not show content for non-200 placement."));
            C3137gf.m10287b("TJPlacement.showContent").mo18527b("no content").mo18529c();
            return;
        }
        try {
            TJCorePlacement tJCorePlacement2 = this.f13058b;
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                TapjoyLog.m16654w(TJCorePlacement.f12993a, "Only one view can be presented at a time.");
                C3137gf.m10287b("TJPlacement.showContent").mo18527b("another content showing").mo18529c();
            } else {
                if (TapjoyConnectCore.isViewOpen()) {
                    TapjoyLog.m16654w(TJCorePlacement.f12993a, "Will close N2E content.");
                    TJPlacementManager.dismissContentShowing(false);
                }
                tJCorePlacement2.mo30687a("SHOW", this);
                C3137gf.C3139a d = C3137gf.m10290d("TJPlacement.showContent");
                int i = 1;
                if (tJCorePlacement2.f13000g.isPrerendered()) {
                    d.mo18524a("prerendered", (Object) true);
                }
                if (tJCorePlacement2.isContentReady()) {
                    d.mo18524a("content_ready", (Object) true);
                }
                tJCorePlacement2.f12999f.f13958d = d;
                String uuid = UUID.randomUUID().toString();
                if (tJCorePlacement2.f13002i != null) {
                    tJCorePlacement2.f13002i.f8791f = uuid;
                    if (tJCorePlacement2.f13002i != null) {
                        if (tJCorePlacement2.f13002i instanceof C5135gv) {
                            i = 3;
                        } else {
                            i = tJCorePlacement2.f13002i instanceof C5151he ? 2 : 0;
                        }
                    }
                    TapjoyConnectCore.viewWillOpen(uuid, i);
                    tJCorePlacement2.f13002i.f8790e = new C5132gs(uuid) {

                        /* renamed from: a */
                        final /* synthetic */ String f13029a;

                        {
                            this.f13029a = r2;
                        }

                        /* renamed from: a */
                        public final void mo30698a(Context context, String str, String str2) {
                            if (str2 == null) {
                                TJCorePlacement.this.f12996c.setRedirectURL(str);
                            } else {
                                TJCorePlacement.this.f12996c.setBaseURL(str);
                                TJCorePlacement.this.f12996c.setHttpResponse(str2);
                            }
                            TJCorePlacement.this.f12996c.setHasProgressSpinner(true);
                            TJCorePlacement.this.f12996c.setContentViewId(this.f13029a);
                            Intent intent = new Intent(TJCorePlacement.this.f12995b, TJAdUnitActivity.class);
                            intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, TJCorePlacement.this.f12996c);
                            intent.setFlags(DriveFile.MODE_READ_ONLY);
                            context.startActivity(intent);
                        }
                    };
                    C3145gz.m10325a((Runnable) new Runnable() {
                        public final void run() {
                            TJCorePlacement.this.f13002i.mo18598a(C3145gz.m10321a().f8772p, TJCorePlacement.this.f12999f);
                        }
                    });
                } else {
                    tJCorePlacement2.f12996c.setContentViewId(uuid);
                    Intent intent = new Intent(tJCorePlacement2.f12995b, TJAdUnitActivity.class);
                    intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, tJCorePlacement2.f12996c);
                    intent.setFlags(DriveFile.MODE_READ_ONLY);
                    tJCorePlacement2.f12995b.startActivity(intent);
                }
                tJCorePlacement2.f12998e = 0;
                tJCorePlacement2.f13004k = false;
                tJCorePlacement2.f13005l = false;
            }
        } finally {
            C3137gf.m10290d("TJPlacement.showContent");
        }
    }

    TJPlacement(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        m16590a(tJCorePlacement, tJPlacementListener);
    }

    /* renamed from: a */
    private void m16591a(TJError tJError) {
        this.f13058b.mo30685a(this, TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, tJError);
    }
}
