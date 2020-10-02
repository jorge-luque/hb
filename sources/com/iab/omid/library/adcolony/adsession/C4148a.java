package com.iab.omid.library.adcolony.adsession;

import android.view.View;
import com.iab.omid.library.adcolony.p144b.C4150a;
import com.iab.omid.library.adcolony.p144b.C4154c;
import com.iab.omid.library.adcolony.p144b.C4158f;
import com.iab.omid.library.adcolony.p146d.C4170e;
import com.iab.omid.library.adcolony.p147e.C4172a;
import com.iab.omid.library.adcolony.publisher.AdSessionStatePublisher;
import com.iab.omid.library.adcolony.publisher.C4175a;
import com.iab.omid.library.adcolony.publisher.C4176b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.adsession.a */
public class C4148a extends AdSession {

    /* renamed from: k */
    private static final Pattern f11143k = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a */
    private final AdSessionContext f11144a;

    /* renamed from: b */
    private final AdSessionConfiguration f11145b;

    /* renamed from: c */
    private final List<C4154c> f11146c = new ArrayList();

    /* renamed from: d */
    private C4172a f11147d;

    /* renamed from: e */
    private AdSessionStatePublisher f11148e;

    /* renamed from: f */
    private boolean f11149f = false;

    /* renamed from: g */
    private boolean f11150g = false;

    /* renamed from: h */
    private String f11151h;

    /* renamed from: i */
    private boolean f11152i;

    /* renamed from: j */
    private boolean f11153j;

    C4148a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f11145b = adSessionConfiguration;
        this.f11144a = adSessionContext;
        this.f11151h = UUID.randomUUID().toString();
        m13884c((View) null);
        this.f11148e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new C4175a(adSessionContext.getWebView()) : new C4176b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f11148e.mo28550a();
        C4150a.m13906a().mo28504a(this);
        this.f11148e.mo28554a(adSessionConfiguration);
    }

    /* renamed from: a */
    private C4154c m13881a(View view) {
        for (C4154c next : this.f11146c) {
            if (next.mo28517a().get() == view) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m13882a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50 || !f11143k.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
        }
    }

    /* renamed from: b */
    private void m13883b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    /* renamed from: c */
    private void m13884c(View view) {
        this.f11147d = new C4172a(view);
    }

    /* renamed from: d */
    private void m13885d(View view) {
        Collection<C4148a> b = C4150a.m13906a().mo28505b();
        if (b != null && b.size() > 0) {
            for (C4148a next : b) {
                if (next != this && next.mo28473d() == view) {
                    next.f11147d.clear();
                }
            }
        }
    }

    /* renamed from: j */
    private void m13886j() {
        if (this.f11152i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    /* renamed from: k */
    private void m13887k() {
        if (this.f11153j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    /* renamed from: a */
    public List<C4154c> mo28469a() {
        return this.f11146c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28470a(JSONObject jSONObject) {
        m13887k();
        getAdSessionStatePublisher().mo28562a(jSONObject);
        this.f11153j = true;
    }

    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (!this.f11150g) {
            m13883b(view);
            m13882a(str);
            if (m13881a(view) == null) {
                this.f11146c.add(new C4154c(view, friendlyObstructionPurpose, str));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo28471b() {
        m13886j();
        getAdSessionStatePublisher().mo28570g();
        this.f11152i = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo28472c() {
        m13887k();
        getAdSessionStatePublisher().mo28572h();
        this.f11153j = true;
    }

    /* renamed from: d */
    public View mo28473d() {
        return (View) this.f11147d.get();
    }

    /* renamed from: e */
    public boolean mo28474e() {
        return this.f11149f && !this.f11150g;
    }

    public void error(ErrorType errorType, String str) {
        if (!this.f11150g) {
            C4170e.m14001a((Object) errorType, "Error type is null");
            C4170e.m14003a(str, "Message is null");
            getAdSessionStatePublisher().mo28555a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    /* renamed from: f */
    public boolean mo28475f() {
        return this.f11149f;
    }

    public void finish() {
        if (!this.f11150g) {
            this.f11147d.clear();
            removeAllFriendlyObstructions();
            this.f11150g = true;
            getAdSessionStatePublisher().mo28569f();
            C4150a.m13906a().mo28508c(this);
            getAdSessionStatePublisher().mo28564b();
            this.f11148e = null;
        }
    }

    /* renamed from: g */
    public boolean mo28476g() {
        return this.f11150g;
    }

    public String getAdSessionId() {
        return this.f11151h;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f11148e;
    }

    /* renamed from: h */
    public boolean mo28477h() {
        return this.f11145b.isNativeImpressionOwner();
    }

    /* renamed from: i */
    public boolean mo28478i() {
        return this.f11145b.isNativeMediaEventsOwner();
    }

    public void registerAdView(View view) {
        if (!this.f11150g) {
            C4170e.m14001a((Object) view, "AdView is null");
            if (mo28473d() != view) {
                m13884c(view);
                getAdSessionStatePublisher().mo28573i();
                m13885d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f11150g) {
            this.f11146c.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.f11150g) {
            m13883b(view);
            C4154c a = m13881a(view);
            if (a != null) {
                this.f11146c.remove(a);
            }
        }
    }

    public void start() {
        if (!this.f11149f) {
            this.f11149f = true;
            C4150a.m13906a().mo28506b(this);
            this.f11148e.mo28551a(C4158f.m13949a().mo28543d());
            this.f11148e.mo28556a(this, this.f11144a);
        }
    }
}
