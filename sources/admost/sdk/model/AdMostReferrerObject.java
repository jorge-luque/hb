package admost.sdk.model;

import android.content.Context;
import android.content.Intent;

public class AdMostReferrerObject {
    private Context context;
    private Intent intent;
    private String referrer;

    public AdMostReferrerObject(Context context2, Intent intent2, String str) {
        this.context = context2;
        this.intent = intent2;
        this.referrer = str;
    }

    public Context getContext() {
        return this.context;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public void setIntent(Intent intent2) {
        this.intent = intent2;
    }

    public void setReferrer(String str) {
        this.referrer = str;
    }
}
