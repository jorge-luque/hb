package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.tapjoy.TapjoyAuctionFlags;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcat {
    private final Executor executor;
    private final zzaci zzdhc;
    private final zzawt zzduw;
    private final Executor zzfhi;
    private final zzdhe zzfll;
    private final zzbzx zzfqb;
    private final zzcab zzfrc;
    private final zzbzs zzfrk;
    private final zzcbb zzftp;

    public zzcat(zzawt zzawt, zzdhe zzdhe, zzcab zzcab, zzbzx zzbzx, zzcbb zzcbb, Executor executor2, Executor executor3, zzbzs zzbzs) {
        this.zzduw = zzawt;
        this.zzfll = zzdhe;
        this.zzdhc = zzdhe.zzdhc;
        this.zzfrc = zzcab;
        this.zzfqb = zzbzx;
        this.zzftp = zzcbb;
        this.zzfhi = executor2;
        this.executor = executor3;
        this.zzfrk = zzbzs;
    }

    public final void zza(zzcbj zzcbj) {
        this.zzfhi.execute(new zzcas(this, zzcbj));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzfqb.zzala() == null) {
            return;
        }
        if (2 == this.zzfqb.zzakw() || 1 == this.zzfqb.zzakw()) {
            this.zzduw.zza(this.zzfll.zzgux, String.valueOf(this.zzfqb.zzakw()), z);
        } else if (6 == this.zzfqb.zzakw()) {
            this.zzduw.zza(this.zzfll.zzgux, TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE, z);
            this.zzduw.zza(this.zzfll.zzgux, "1", z);
        }
    }

    public final void zzc(zzcbj zzcbj) {
        if (zzcbj != null && this.zzftp != null && zzcbj.zzalw() != null && this.zzfrc.zzali()) {
            try {
                zzcbj.zzalw().addView(this.zzftp.zzamh());
            } catch (zzbew e) {
                zzawr.zza("web view can not be obtained", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzcbj zzcbj) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        IObjectWrapper iObjectWrapper;
        Drawable drawable;
        int i = 0;
        IObjectWrapper iObjectWrapper2 = null;
        if (this.zzfrc.zzalk() || this.zzfrc.zzalj()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
            int i2 = 0;
            while (true) {
                if (i2 < 2) {
                    View zzgd = zzcbj.zzgd(strArr[i2]);
                    if (zzgd != null && (zzgd instanceof ViewGroup)) {
                        viewGroup = (ViewGroup) zzgd;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        viewGroup = null;
        boolean z = viewGroup != null;
        Context context = zzcbj.zzahe().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.zzfqb.zzakx() != null) {
            view = this.zzfqb.zzakx();
            zzaci zzaci = this.zzdhc;
            if (zzaci != null && !z) {
                zza(layoutParams, zzaci.zzbla);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(this.zzfqb.zzsb() instanceof zzacd)) {
            view = null;
        } else {
            zzacd zzacd = (zzacd) this.zzfqb.zzsb();
            if (!z) {
                zza(layoutParams, zzacd.zzru());
            }
            zzacc zzacc = new zzacc(context, zzacd, layoutParams);
            zzacc.setContentDescription((CharSequence) zzvj.zzpv().zzd(zzzz.zzcox));
            view = zzacc;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcbj.zzahe().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout zzalw = zzcbj.zzalw();
                if (zzalw != null) {
                    zzalw.addView(adChoicesView);
                }
            }
            zzcbj.zza(zzcbj.zzamb(), view, true);
        }
        String[] strArr2 = zzcar.zzfth;
        int length = strArr2.length;
        while (true) {
            if (i >= length) {
                viewGroup2 = null;
                break;
            }
            View zzgd2 = zzcbj.zzgd(strArr2[i]);
            if (zzgd2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzgd2;
                break;
            }
            i++;
        }
        this.executor.execute(new zzcav(this, viewGroup2));
        if (viewGroup2 == null) {
            return;
        }
        if (!zza(viewGroup2)) {
            viewGroup2.removeAllViews();
            View zzahe = zzcbj.zzahe();
            Context context2 = zzahe != null ? zzahe.getContext() : null;
            if (context2 != null) {
                if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcow)).booleanValue()) {
                    zzacr zzsl = this.zzfrk.zzsl();
                    if (zzsl != null) {
                        try {
                            iObjectWrapper = zzsl.zzry();
                        } catch (RemoteException unused) {
                            zzazw.zzfc("Could not get main image drawable");
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    zzacs zzaky = this.zzfqb.zzaky();
                    if (zzaky != null) {
                        try {
                            iObjectWrapper = zzaky.zzrv();
                        } catch (RemoteException unused2) {
                            zzazw.zzfc("Could not get drawable from image");
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (iObjectWrapper != null && (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) != null) {
                    ImageView imageView = new ImageView(context2);
                    imageView.setImageDrawable(drawable);
                    if (zzcbj != null) {
                        iObjectWrapper2 = zzcbj.zzamc();
                    }
                    if (iObjectWrapper2 != null) {
                        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsy)).booleanValue()) {
                            imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapper2));
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            viewGroup2.addView(imageView);
                        }
                    }
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    viewGroup2.addView(imageView);
                }
            }
        } else if (this.zzfqb.zzalb() != null) {
            this.zzfqb.zzalb().zza((zzacg) new zzcau(this, zzcbj, viewGroup2));
        }
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* access modifiers changed from: private */
    public static boolean zza(zzcbj zzcbj, String[] strArr) {
        Map<String, WeakReference<View>> zzalz = zzcbj.zzalz();
        if (zzalz == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzalz.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzala = this.zzfqb.zzala();
        if (zzala == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzala.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzala.getParent()).removeView(zzala);
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcpa)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzala, layoutParams);
        return true;
    }
}
