package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzach;
import com.google.android.gms.internal.ads.zzacj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public class MediaView extends FrameLayout {
    private MediaContent zzbkq;
    private boolean zzbkr;
    private zzach zzbks;
    private ImageView.ScaleType zzbkt;
    private boolean zzbku;
    private zzacj zzbkv;

    public MediaView(Context context) {
        super(context);
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzbku = true;
        this.zzbkt = scaleType;
        zzacj zzacj = this.zzbkv;
        if (zzacj != null) {
            zzacj.setImageScaleType(scaleType);
        }
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzbkr = true;
        this.zzbkq = mediaContent;
        zzach zzach = this.zzbks;
        if (zzach != null) {
            zzach.setMediaContent(mediaContent);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzach zzach) {
        this.zzbks = zzach;
        if (this.zzbkr) {
            zzach.setMediaContent(this.zzbkq);
        }
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzacj zzacj) {
        this.zzbkv = zzacj;
        if (this.zzbku) {
            zzacj.setImageScaleType(this.zzbkt);
        }
    }
}
