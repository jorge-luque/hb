package com.miniclip.framework;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

public class ExternalApplication {

    /* renamed from: com.miniclip.framework.ExternalApplication$a */
    static class C4271a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f11431a;

        C4271a(String str) {
            this.f11431a = str;
        }

        public void run() {
            Miniclip.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f11431a)));
        }
    }

    public static boolean isAppInstalled(String str) {
        try {
            Miniclip.getActivity().getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void launch(String str) {
        Miniclip.queueEvent(ThreadingContext.AndroidUi, new C4271a(str));
    }
}
