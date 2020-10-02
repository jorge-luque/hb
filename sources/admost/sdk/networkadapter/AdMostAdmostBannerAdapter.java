package admost.sdk.networkadapter;

import admost.adserver.ads.AdMostBannerAd;
import admost.adserver.ads.C0016b;
import admost.adserver.ads.C0017c;
import admost.adserver.ads.C0018d;
import admost.adserver.core.C0055e;
import admost.sdk.AdMostViewBinder;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostPreferences;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import java.lang.ref.WeakReference;
import p030c.p031a.p032a.C1178a;

public class AdMostAdmostBannerAdapter extends AdMostBannerInterface {
    private VideoView replaceVideoView(ImageView imageView, int i) {
        int i2;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int i3 = layoutParams.height;
        if (i3 > 0 && layoutParams.width <= 0) {
            layoutParams.width = (i3 * 16) / 9;
        } else if (layoutParams.height <= 0 && (i2 = layoutParams.width) > 0) {
            layoutParams.height = (i2 * 9) / 16;
        }
        VideoView videoView = new VideoView(imageView.getContext());
        ((ViewGroup) imageView.getParent()).addView(videoView, ((ViewGroup) imageView.getParent()).indexOfChild(imageView), layoutParams);
        ((ViewGroup) imageView.getParent()).removeView(imageView);
        videoView.setId(i);
        return videoView;
    }

    /* access modifiers changed from: protected */
    public void destroyBanner() {
        ((AdMostBannerAd) this.mAd).mo2a();
    }

    /* access modifiers changed from: protected */
    public void destroyNative() {
        Object obj = this.mAd;
        if (obj instanceof C0016b) {
            ((C0016b) obj).destroy();
        }
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        Object obj = this.mAd;
        if (obj == null) {
            return null;
        }
        return ((AdMostBannerAd) obj).mo1a(weakReference);
    }

    /* access modifiers changed from: protected */
    public View getNativeAdView(LayoutInflater layoutInflater, AdMostViewBinder adMostViewBinder, WeakReference<Activity> weakReference, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(adMostViewBinder.layoutId, viewGroup, false);
        try {
            C0016b bVar = (C0016b) this.mAd;
            C0017c data = bVar.getData();
            if (data == null) {
                return inflate;
            }
            ImageView imageView = (ImageView) inflate.findViewById(adMostViewBinder.iconImageId);
            ImageView imageView2 = (ImageView) inflate.findViewById(adMostViewBinder.mainImageId);
            TextView textView = (TextView) inflate.findViewById(adMostViewBinder.callToActionId);
            TextView textView2 = (TextView) inflate.findViewById(adMostViewBinder.titleId);
            TextView textView3 = (TextView) inflate.findViewById(adMostViewBinder.textId);
            ImageView imageView3 = (ImageView) inflate.findViewById(adMostViewBinder.privacyIconId);
            if (imageView2 != null) {
                if (data.f37c == null || data.f37c.isEmpty()) {
                    bVar.mo32a((View) imageView2);
                    imageView2.setImageBitmap(C0055e.m145a(C0055e.m147a(inflate.getContext(), data.f36b)));
                } else {
                    VideoView replaceVideoView = replaceVideoView(imageView2, adMostViewBinder.mainImageId);
                    replaceVideoView.setVideoURI(Uri.fromFile(C0055e.m147a(inflate.getContext(), data.f37c)));
                    bVar.mo32a((View) replaceVideoView);
                }
            }
            if (imageView != null) {
                imageView.setImageBitmap(C0055e.m145a(C0055e.m147a(inflate.getContext(), data.f35a)));
            }
            bVar.mo37b(imageView);
            if (textView != null) {
                textView.setText(data.f41g);
            }
            bVar.mo38b(textView);
            if (textView2 != null) {
                textView2.setText(data.f40f);
            }
            bVar.mo39c(textView2);
            if (textView3 != null) {
                textView3.setText(data.f39e);
            }
            bVar.mo34a(textView3);
            if (!(imageView3 == null || data.f42h == null || data.f42h.isEmpty())) {
                imageView3.setVisibility(0);
            }
            bVar.mo33a(imageView3);
            bVar.mo35a(new int[]{adMostViewBinder.privacyIconId, adMostViewBinder.titleId, adMostViewBinder.mainImageId, adMostViewBinder.textId, adMostViewBinder.callToActionId, adMostViewBinder.iconImageId});
            return bVar.mo36b(inflate);
        } catch (Exception e) {
            e.printStackTrace();
            return inflate;
        }
    }

    /* access modifiers changed from: protected */
    public boolean loadBanner(WeakReference<Activity> weakReference) {
        final AdMostBannerAd adMostBannerAd = new AdMostBannerAd(AdMost.getInstance().getContext());
        if (!this.mBannerResponseItem.Network.equals(AdMostAdNetwork.ADMOST)) {
            adMostBannerAd.mo7b(AdMostPreferences.getInstance().getAdvId());
        } else {
            try {
                adMostBannerAd.mo4a(AdMostPreferences.getInstance().getAdvId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Context context = AdMost.getInstance().getContext();
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        adMostBannerAd.mo3a(context, adMostBannerResponseItem.AdSpaceId, adMostBannerResponseItem != null ? adMostBannerResponseItem.NetworkData : null, this.mBannerResponseItem.ZoneSize, new C1178a() {
            public void onClicked() {
                AdMostAdmostBannerAdapter.this.onAmrClick();
            }

            public void onFail(int i) {
                AdMostAdmostBannerAdapter adMostAdmostBannerAdapter = AdMostAdmostBannerAdapter.this;
                adMostAdmostBannerAdapter.onAmrFail(adMostAdmostBannerAdapter.mBannerResponseItem, i, "onFail");
            }

            public void onReady() {
                AdMostAdmostBannerAdapter adMostAdmostBannerAdapter = AdMostAdmostBannerAdapter.this;
                adMostAdmostBannerAdapter.mAd = adMostBannerAd;
                adMostAdmostBannerAdapter.onAmrReady();
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean loadNative(WeakReference<Activity> weakReference) {
        final C0018d dVar = new C0018d();
        Context context = AdMost.getInstance().getContext();
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        dVar.mo31a(context, adMostBannerResponseItem.AdSpaceId, adMostBannerResponseItem != null ? adMostBannerResponseItem.NetworkData : null, this.mBannerResponseItem.ZoneSize, AdMostPreferences.getInstance().getAdvId(), new C1178a() {
            public void onClicked() {
                AdMostAdmostBannerAdapter.this.onAmrClick();
            }

            public void onFail(int i) {
                AdMostAdmostBannerAdapter adMostAdmostBannerAdapter = AdMostAdmostBannerAdapter.this;
                adMostAdmostBannerAdapter.onAmrFail(adMostAdmostBannerAdapter.mBannerResponseItem, i, "onFail");
            }

            public void onReady() {
                AdMostAdmostBannerAdapter adMostAdmostBannerAdapter = AdMostAdmostBannerAdapter.this;
                adMostAdmostBannerAdapter.mAd = dVar;
                adMostAdmostBannerAdapter.onAmrReady();
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    public void pauseBanner() {
        Object obj = this.mAd;
        if (obj != null) {
            ((AdMostBannerAd) obj).mo6b();
        }
    }

    /* access modifiers changed from: protected */
    public void pauseNative() {
        Object obj = this.mAd;
        if (obj instanceof C0016b) {
            ((C0016b) obj).pause();
        }
    }

    /* access modifiers changed from: protected */
    public void resumeBanner() {
        Object obj = this.mAd;
        if (obj != null) {
            ((AdMostBannerAd) obj).mo8c();
        }
    }

    /* access modifiers changed from: protected */
    public void resumeNative() {
        Object obj = this.mAd;
        if (obj instanceof C0016b) {
            ((C0016b) obj).resume();
        }
    }
}
