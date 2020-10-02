package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import p075d.p090g.p091a.C3218a;

public class CustomTabActivity extends Activity {
    public static final String CUSTOM_TAB_REDIRECT_ACTION = (CustomTabActivity.class.getSimpleName() + ".action_customTabRedirect");
    private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
    public static final String DESTROY_ACTION = (CustomTabActivity.class.getSimpleName() + ".action_destroy");
    private BroadcastReceiver closeReceiver;

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            C3218a.m10641a((Context) this).mo18872a(intent2);
            this.closeReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    CustomTabActivity.this.finish();
                }
            };
            C3218a.m10641a((Context) this).mo18871a(this.closeReceiver, new IntentFilter(DESTROY_ACTION));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(CUSTOM_TAB_REDIRECT_ACTION);
        intent.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C3218a.m10641a((Context) this).mo18870a(this.closeReceiver);
        super.onDestroy();
    }
}
