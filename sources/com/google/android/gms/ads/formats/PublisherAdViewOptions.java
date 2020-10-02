package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzaep;
import com.google.android.gms.internal.ads.zzuq;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwh;
import com.google.android.gms.internal.ads.zzzc;

@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", mo15196id = 1)
    private final boolean zzbli;
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", mo15196id = 2, type = "android.os.IBinder")
    private final zzwh zzblj;
    private AppEventListener zzblk;
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", mo15196id = 3)
    private final IBinder zzbll;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbli = false;
        /* access modifiers changed from: private */
        public AppEventListener zzblk;
        /* access modifiers changed from: private */
        public ShouldDelayBannerRenderingListener zzblm;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzblk = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbli = z;
            return this;
        }

        @KeepForSdk
        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzblm = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzbli = builder.zzbli;
        AppEventListener zzb = builder.zzblk;
        this.zzblk = zzb;
        zzzc zzzc = null;
        this.zzblj = zzb != null ? new zzuq(this.zzblk) : null;
        this.zzbll = builder.zzblm != null ? new zzzc(builder.zzblm) : zzzc;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzblk;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbli;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzwh zzwh = this.zzblj;
        SafeParcelWriter.writeIBinder(parcel, 2, zzwh == null ? null : zzwh.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzbll, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzwh zzjt() {
        return this.zzblj;
    }

    public final zzaem zzju() {
        return zzaep.zzy(this.zzbll);
    }

    @SafeParcelable.Constructor
    PublisherAdViewOptions(@SafeParcelable.Param(mo15199id = 1) boolean z, @SafeParcelable.Param(mo15199id = 2) IBinder iBinder, @SafeParcelable.Param(mo15199id = 3) IBinder iBinder2) {
        this.zzbli = z;
        this.zzblj = iBinder != null ? zzwg.zze(iBinder) : null;
        this.zzbll = iBinder2;
    }
}
