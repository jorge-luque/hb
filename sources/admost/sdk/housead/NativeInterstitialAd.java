package admost.sdk.housead;

import admost.sdk.C0164R;
import admost.sdk.listener.AdMostAdListenerForNetworkAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class NativeInterstitialAd extends Activity {
    private static AdMostAdListenerForNetworkAdapter adMostAdListener;
    private static View interstitialView;

    private void destroy() {
        interstitialView = null;
        adMostAdListener = null;
    }

    /* access modifiers changed from: private */
    public void exit() {
        AdMostAdListenerForNetworkAdapter adMostAdListenerForNetworkAdapter = adMostAdListener;
        if (adMostAdListenerForNetworkAdapter != null) {
            adMostAdListenerForNetworkAdapter.onDismiss("");
        }
        destroy();
        finish();
    }

    public static void setView(View view, AdMostAdListenerForNetworkAdapter adMostAdListenerForNetworkAdapter) {
        interstitialView = view;
        adMostAdListener = adMostAdListenerForNetworkAdapter;
    }

    private void showNativeInterstitial() {
        setContentView(C0164R.layout.admost_full_screen_container);
        try {
            ((RelativeLayout) findViewById(C0164R.C0166id.amr_container_view)).addView(interstitialView);
            interstitialView.findViewById(C0164R.C0166id.amr_ad_close).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    NativeInterstitialAd.this.exit();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        showNativeInterstitial();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        exit();
        return false;
    }
}
