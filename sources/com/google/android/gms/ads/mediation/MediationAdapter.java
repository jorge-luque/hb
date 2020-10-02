package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    public static class zza {
        private int zzema;

        public final Bundle zzact() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzema);
            return bundle;
        }

        public final zza zzdo(int i) {
            this.zzema = 1;
            return this;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
