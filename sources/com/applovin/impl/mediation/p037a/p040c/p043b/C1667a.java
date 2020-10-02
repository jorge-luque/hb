package com.applovin.impl.mediation.p037a.p040c.p043b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;
import com.applovin.impl.mediation.p037a.p038a.C1651d;
import com.applovin.impl.mediation.p037a.p040c.p043b.C1672b;
import com.applovin.sdk.C2057R;

/* renamed from: com.applovin.impl.mediation.a.c.b.a */
public class C1667a extends Activity {

    /* renamed from: a */
    private ListView f5210a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2057R.layout.mediation_debugger_detail_activity);
        this.f5210a = (ListView) findViewById(C2057R.C2059id.listView);
    }

    public void setNetwork(C1651d dVar) {
        setTitle(dVar.mo7658f());
        C1672b bVar = new C1672b(dVar, this);
        bVar.mo7719a((C1672b.C1673a) new C1672b.C1673a() {
            /* renamed from: a */
            public void mo7704a(String str) {
                new AlertDialog.Builder(C1667a.this, 16974130).setTitle(C2057R.string.applovin_instructions_dialog_title).setMessage(str).setNegativeButton(17039370, (DialogInterface.OnClickListener) null).create().show();
            }
        });
        this.f5210a.setAdapter(bVar);
    }
}
