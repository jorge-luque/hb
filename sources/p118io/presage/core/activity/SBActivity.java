package p118io.presage.core.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import com.ogury.p159cm.OguryChoiceManager;
import p118io.presage.core.IIIIIIIl;

/* renamed from: io.presage.core.activity.SBActivity */
public class SBActivity extends Activity {
    public Handler IIIIIIII;

    /* renamed from: io.presage.core.activity.SBActivity$IIIIIIII */
    public class IIIIIIII implements Runnable {
        public IIIIIIII() {
        }

        public void run() {
            SBActivity.this.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
        super.onCreate(bundle);
        this.IIIIIIII = new Handler();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(0);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new IIIIIIIl(this));
        setContentView(linearLayout);
    }

    public void onResume() {
        super.onResume();
        try {
            this.IIIIIIII.postDelayed(new IIIIIIII(), 100);
        } catch (Exception unused) {
        }
    }

    public void onStart() {
        super.onStart();
    }
}
