package com.applovin.impl.mediation.p037a.p040c.p041a;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.applovin.impl.adview.C1515a;
import com.applovin.impl.mediation.p037a.p038a.C1651d;
import com.applovin.impl.mediation.p037a.p040c.p041a.C1664b;
import com.applovin.impl.mediation.p037a.p040c.p043b.C1667a;
import com.applovin.impl.sdk.C1798a;
import com.applovin.impl.sdk.utils.C1984a;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.sdk.C2057R;

/* renamed from: com.applovin.impl.mediation.a.c.a.a */
public class C1659a extends Activity {

    /* renamed from: a */
    private C1664b f5191a;

    /* renamed from: b */
    private DataSetObserver f5192b;

    /* renamed from: c */
    private FrameLayout f5193c;

    /* renamed from: d */
    private ListView f5194d;

    /* renamed from: e */
    private C1515a f5195e;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6334a() {
        startActivity(new Intent(this, MaxDebuggerDetailActivity.class));
    }

    /* renamed from: b */
    private void m6336b() {
        m6338c();
        C1515a aVar = new C1515a(this, 50, 16842874);
        this.f5195e = aVar;
        aVar.setColor(-3355444);
        this.f5193c.addView(this.f5195e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f5193c.bringChildToFront(this.f5195e);
        this.f5195e.mo7293a();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6338c() {
        C1515a aVar = this.f5195e;
        if (aVar != null) {
            aVar.mo7294b();
            this.f5193c.removeView(this.f5195e);
            this.f5195e = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(C2057R.layout.mediation_debugger_activity);
        this.f5193c = (FrameLayout) findViewById(16908290);
        this.f5194d = (ListView) findViewById(C2057R.C2059id.listView);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f5191a.unregisterDataSetObserver(this.f5192b);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f5194d.setAdapter(this.f5191a);
        if (!this.f5191a.mo7699a()) {
            m6336b();
        }
    }

    public void setListAdapter(C1664b bVar, final C1798a aVar) {
        DataSetObserver dataSetObserver;
        C1664b bVar2 = this.f5191a;
        if (!(bVar2 == null || (dataSetObserver = this.f5192b) == null)) {
            bVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f5191a = bVar;
        C16601 r3 = new DataSetObserver() {
            public void onChanged() {
                C1659a.this.m6338c();
            }
        };
        this.f5192b = r3;
        this.f5191a.registerDataSetObserver(r3);
        this.f5191a.mo7697a((C1664b.C1666a) new C1664b.C1666a() {
            /* renamed from: a */
            public void mo7694a(final C1651d dVar) {
                aVar.mo8071a(new C1984a() {
                    public void onActivityDestroyed(Activity activity) {
                        if (activity instanceof C1667a) {
                            aVar.mo8073b(this);
                        }
                    }

                    public void onActivityStarted(Activity activity) {
                        if (activity instanceof C1667a) {
                            ((C1667a) activity).setNetwork(dVar);
                        }
                    }
                });
                C1659a.this.m6334a();
            }
        });
    }
}
