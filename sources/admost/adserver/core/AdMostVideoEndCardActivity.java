package admost.adserver.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.kokteyl.lib_admost.R$id;
import com.kokteyl.lib_admost.R$layout;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TJAdUnitConstants;

public class AdMostVideoEndCardActivity extends Activity {

    /* renamed from: a */
    private String f122a;

    /* renamed from: b */
    private String f123b;

    /* renamed from: c */
    private String f124c;

    /* renamed from: d */
    private String f125d;

    /* renamed from: e */
    private String f126e;

    /* renamed from: f */
    private String f127f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f128g;

    /* renamed from: h */
    private String f129h;

    /* renamed from: i */
    private String f130i;

    /* renamed from: admost.adserver.core.AdMostVideoEndCardActivity$a */
    class C0043a implements ImageLoader.ImageListener {

        /* renamed from: admost.adserver.core.AdMostVideoEndCardActivity$a$a */
        class C0044a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.ImageContainer f132a;

            C0044a(ImageLoader.ImageContainer imageContainer) {
                this.f132a = imageContainer;
            }

            public void run() {
                ImageLoader.ImageContainer imageContainer = this.f132a;
                if (imageContainer != null && imageContainer.getBitmap() != null) {
                    ((ImageView) AdMostVideoEndCardActivity.this.findViewById(R$id.ad_app_icon)).setImageBitmap(this.f132a.getBitmap());
                }
            }
        }

        C0043a() {
        }

        public void onErrorResponse(VolleyError volleyError) {
        }

        public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
            new Handler().post(new C0044a(imageContainer));
        }
    }

    /* renamed from: admost.adserver.core.AdMostVideoEndCardActivity$b */
    class C0045b implements ImageLoader.ImageListener {

        /* renamed from: admost.adserver.core.AdMostVideoEndCardActivity$b$a */
        class C0046a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.ImageContainer f135a;

            C0046a(ImageLoader.ImageContainer imageContainer) {
                this.f135a = imageContainer;
            }

            public void run() {
                ImageLoader.ImageContainer imageContainer = this.f135a;
                if (imageContainer != null && imageContainer.getBitmap() != null) {
                    ImageView imageView = (ImageView) AdMostVideoEndCardActivity.this.findViewById(R$id.ad_image);
                    imageView.setImageBitmap(this.f135a.getBitmap());
                    if (!AdMostVideoEndCardActivity.this.f128g.equals(TJAdUnitConstants.String.LANDSCAPE)) {
                        imageView.setLayoutParams(new LinearLayout.LayoutParams(imageView.getLayoutParams().width, C0055e.m146a((Activity) AdMostVideoEndCardActivity.this).x));
                    }
                }
            }
        }

        C0045b() {
        }

        public void onErrorResponse(VolleyError volleyError) {
        }

        public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
            new Handler().post(new C0046a(imageContainer));
        }
    }

    /* renamed from: admost.adserver.core.AdMostVideoEndCardActivity$c */
    class C0047c implements View.OnClickListener {
        C0047c() {
        }

        public void onClick(View view) {
            AdMostVideoEndCardActivity.this.m121b();
        }
    }

    /* renamed from: admost.adserver.core.AdMostVideoEndCardActivity$d */
    class C0048d implements View.OnClickListener {
        C0048d() {
        }

        public void onClick(View view) {
            AdMostVideoEndCardActivity.this.m120a();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
        String stringExtra = getIntent().getStringExtra("AD_ORIENTATION");
        this.f128g = stringExtra;
        setRequestedOrientation(true ^ stringExtra.equals(TJAdUnitConstants.String.LANDSCAPE) ? 1 : 0);
        this.f122a = getIntent().getStringExtra("AD_PLACE_ID");
        this.f123b = getIntent().getStringExtra("AD_CALL_TO_ACTION_TEXT");
        this.f124c = getIntent().getStringExtra("AD_ICON_URL");
        this.f125d = getIntent().getStringExtra("AD_APP_DESC");
        this.f126e = getIntent().getStringExtra("AD_IMAGE_URL");
        this.f127f = getIntent().getStringExtra("AD_CLICK_URL");
        this.f129h = getIntent().getStringExtra("AD_APP_NAME");
        this.f130i = getIntent().getStringExtra("AD_CLICK_MESSAGE");
        setContentView(this.f128g.equals(TJAdUnitConstants.String.LANDSCAPE) ? R$layout.admost_adserver_end_card_landscape : R$layout.admost_adserver_end_card);
        C0059g.m162a((Context) this).mo104a().get(this.f124c, new C0043a());
        C0059g.m162a((Context) this).mo104a().get(this.f126e, new C0045b());
        ((TextView) findViewById(R$id.ad_body)).setText(this.f125d);
        ((TextView) findViewById(R$id.ad_headline)).setText(this.f129h);
        ((TextView) findViewById(R$id.ad_call_to_action)).setText(this.f123b);
        findViewById(R$id.amr_ad_close).setOnClickListener(new C0047c());
        findViewById(R$id.ad_call_to_action).setOnClickListener(new C0048d());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        m121b();
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m120a() {
        try {
            if (this.f127f != null && this.f127f.length() > 1) {
                C0050b.m130a().mo89a(2, this.f122a, this.f130i);
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f127f)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m121b() {
        C0050b.m130a().mo89a(4, this.f122a, "");
        finish();
    }
}
