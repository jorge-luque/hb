package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.p012a.C0653d;
import com.facebook.FacebookSdk;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        bundle = bundle == null ? new Bundle() : bundle;
        String dialogAuthority = ServerProtocol.getDialogAuthority();
        this.uri = Utility.buildUri(dialogAuthority, FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + str, bundle);
    }

    public void openCustomTab(Activity activity, String str) {
        C0653d a = new C0653d.C0654a().mo3656a();
        a.f1619a.setPackage(str);
        a.f1619a.addFlags(1073741824);
        a.mo3654a(activity, this.uri);
    }
}
