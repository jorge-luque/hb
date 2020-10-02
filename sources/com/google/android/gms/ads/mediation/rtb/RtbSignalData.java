package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public class RtbSignalData {
    private final Bundle zzcen;
    private final AdSize zzdi;
    private final List<MediationConfiguration> zzenf;
    private final Context zzvf;

    public RtbSignalData(Context context, List<MediationConfiguration> list, Bundle bundle, AdSize adSize) {
        this.zzvf = context;
        this.zzenf = list;
        this.zzcen = bundle;
        this.zzdi = adSize;
    }

    public AdSize getAdSize() {
        return this.zzdi;
    }

    @Deprecated
    public MediationConfiguration getConfiguration() {
        List<MediationConfiguration> list = this.zzenf;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.zzenf.get(0);
    }

    public List<MediationConfiguration> getConfigurations() {
        return this.zzenf;
    }

    public Context getContext() {
        return this.zzvf;
    }

    public Bundle getNetworkExtras() {
        return this.zzcen;
    }
}
