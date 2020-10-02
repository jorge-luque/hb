package com.iab.omid.library.oguryco.adsession;

import android.view.View;
import com.iab.omid.library.oguryco.p150b.C4201a;
import com.iab.omid.library.oguryco.p150b.C4205c;
import com.iab.omid.library.oguryco.p150b.C4209f;
import com.iab.omid.library.oguryco.p152d.C4221e;
import com.iab.omid.library.oguryco.p153e.C4223a;
import com.iab.omid.library.oguryco.publisher.AdSessionStatePublisher;
import com.iab.omid.library.oguryco.publisher.C4226a;
import com.iab.omid.library.oguryco.publisher.C4227b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.adsession.a */
public class C4199a extends AdSession {

    /* renamed from: a */
    private static final Pattern f11266a = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: b */
    private final AdSessionContext f11267b;

    /* renamed from: c */
    private final AdSessionConfiguration f11268c;

    /* renamed from: d */
    private final List<C4205c> f11269d = new ArrayList();

    /* renamed from: e */
    private C4223a f11270e;

    /* renamed from: f */
    private AdSessionStatePublisher f11271f;

    /* renamed from: g */
    private boolean f11272g = false;

    /* renamed from: h */
    private boolean f11273h = false;

    /* renamed from: i */
    private String f11274i;

    /* renamed from: j */
    private boolean f11275j;

    /* renamed from: k */
    private boolean f11276k;

    C4199a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f11268c = adSessionConfiguration;
        this.f11267b = adSessionContext;
        this.f11274i = UUID.randomUUID().toString();
        m14113c((View) null);
        this.f11271f = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new C4226a(adSessionContext.getWebView()) : new C4227b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f11271f.mo28764a();
        C4201a.m14135a().mo28718a(this);
        this.f11271f.mo28768a(adSessionConfiguration);
    }

    /* renamed from: a */
    private C4205c m14110a(View view) {
        for (C4205c next : this.f11269d) {
            if (next.mo28731a().get() == view) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m14111a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50 || !f11266a.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
        }
    }

    /* renamed from: b */
    private void m14112b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    /* renamed from: c */
    private void m14113c(View view) {
        this.f11270e = new C4223a(view);
    }

    /* renamed from: d */
    private void m14114d(View view) {
        Collection<C4199a> b = C4201a.m14135a().mo28719b();
        if (b != null && b.size() > 0) {
            for (C4199a next : b) {
                if (next != this && next.mo28663d() == view) {
                    next.f11270e.clear();
                }
            }
        }
    }

    /* renamed from: j */
    private void m14115j() {
        if (this.f11275j) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    /* renamed from: k */
    private void m14116k() {
        if (this.f11276k) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    /* renamed from: a */
    public List<C4205c> mo28659a() {
        return this.f11269d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28660a(JSONObject jSONObject) {
        m14116k();
        getAdSessionStatePublisher().mo28776a(jSONObject);
        this.f11276k = true;
    }

    public void addFriendlyObstruction(View view) {
        addFriendlyObstruction(view, FriendlyObstructionPurpose.OTHER, (String) null);
    }

    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (!this.f11273h) {
            m14112b(view);
            m14111a(str);
            if (m14110a(view) == null) {
                this.f11269d.add(new C4205c(view, friendlyObstructionPurpose, str));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo28661b() {
        m14115j();
        getAdSessionStatePublisher().mo28784g();
        this.f11275j = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo28662c() {
        m14116k();
        getAdSessionStatePublisher().mo28786h();
        this.f11276k = true;
    }

    /* renamed from: d */
    public View mo28663d() {
        return (View) this.f11270e.get();
    }

    /* renamed from: e */
    public boolean mo28664e() {
        return this.f11272g && !this.f11273h;
    }

    public void error(ErrorType errorType, String str) {
        if (!this.f11273h) {
            C4221e.m14230a((Object) errorType, "Error type is null");
            C4221e.m14232a(str, "Message is null");
            getAdSessionStatePublisher().mo28769a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    /* renamed from: f */
    public boolean mo28665f() {
        return this.f11272g;
    }

    public void finish() {
        if (!this.f11273h) {
            this.f11270e.clear();
            removeAllFriendlyObstructions();
            this.f11273h = true;
            getAdSessionStatePublisher().mo28783f();
            C4201a.m14135a().mo28722c(this);
            getAdSessionStatePublisher().mo28778b();
            this.f11271f = null;
        }
    }

    /* renamed from: g */
    public boolean mo28666g() {
        return this.f11273h;
    }

    public String getAdSessionId() {
        return this.f11274i;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f11271f;
    }

    /* renamed from: h */
    public boolean mo28667h() {
        return this.f11268c.isNativeImpressionOwner();
    }

    /* renamed from: i */
    public boolean mo28668i() {
        return this.f11268c.isNativeMediaEventsOwner();
    }

    public void registerAdView(View view) {
        if (!this.f11273h) {
            C4221e.m14230a((Object) view, "AdView is null");
            if (mo28663d() != view) {
                m14113c(view);
                getAdSessionStatePublisher().mo28787i();
                m14114d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f11273h) {
            this.f11269d.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.f11273h) {
            m14112b(view);
            C4205c a = m14110a(view);
            if (a != null) {
                this.f11269d.remove(a);
            }
        }
    }

    public void start() {
        if (!this.f11272g) {
            this.f11272g = true;
            C4201a.m14135a().mo28720b(this);
            this.f11271f.mo28765a(C4209f.m14178a().mo28757d());
            this.f11271f.mo28770a(this, this.f11267b);
        }
    }
}
