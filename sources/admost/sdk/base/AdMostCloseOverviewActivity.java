package admost.sdk.base;

import admost.sdk.C0164R;
import android.app.Activity;
import android.os.Bundle;

public class AdMostCloseOverviewActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0164R.layout.admost_close_overview);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        finish();
    }
}
