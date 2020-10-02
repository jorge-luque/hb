package admost.sdk;

import admost.sdk.base.AdMostUtil;
import admost.sdk.listener.AdMostCustomViewListener;
import admost.sdk.listener.AdMostViewListener;
import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class AdMostCustomView extends AdMostView {
    private volatile Data adData;
    /* access modifiers changed from: private */
    public View curtainView;
    /* access modifiers changed from: private */
    public AdMostCustomViewListener externalListener;
    private AdMostViewListener internalListener;
    private boolean privacyIconClicked;
    /* access modifiers changed from: private */
    public View privacyView;

    public static class Data {
        View callToActionButton;
        int duration = 5;
        int ecpm;
        String network;
        boolean preventClicks;

        protected Data() {
        }

        public View getCallToActionButton() {
            return this.callToActionButton;
        }

        public int getDuration() {
            return this.duration;
        }

        public int getEcpm() {
            return this.ecpm;
        }

        public String getNetwork() {
            return this.network;
        }

        public boolean preventsClicks() {
            return this.preventClicks;
        }

        public String toString() {
            return "Data{duration=" + this.duration + ", preventClicks=" + this.preventClicks + ", callToActionButton=" + this.callToActionButton + ", ecpm=" + this.ecpm + ", network='" + this.network + '\'' + '}';
        }
    }

    public AdMostCustomView(Activity activity, String str, int i, AdMostCustomViewListener adMostCustomViewListener, AdMostViewBinder adMostViewBinder) {
        super(activity, str, i, (AdMostViewListener) null, adMostViewBinder);
        this.externalListener = adMostCustomViewListener;
        setListener(getInternalListener());
    }

    public static boolean contains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private AdMostViewListener getInternalListener() {
        AdMostViewListener adMostViewListener = this.internalListener;
        if (adMostViewListener != null) {
            return adMostViewListener;
        }
        C01111 r0 = new AdMostViewListener() {
            public void onClick(String str) {
                if (AdMostCustomView.this.externalListener != null) {
                    AdMostCustomView.this.externalListener.onClick(AdMostCustomView.this.getAdData());
                }
            }

            public void onFail(int i) {
                if (AdMostCustomView.this.externalListener != null) {
                    AdMostCustomView.this.externalListener.onFail(i, AdMostUtil.getAdErrorName(i));
                }
            }

            public void onReady(String str, int i, View view) {
                View view2;
                int i2;
                AdMostViewBinder viewBinder = AdMostCustomView.this.getViewBinder();
                Data adData = AdMostCustomView.this.getAdData();
                adData.preventClicks = viewBinder != null && viewBinder.preventClicks;
                adData.network = str;
                adData.ecpm = i;
                if (viewBinder == null) {
                    view2 = null;
                } else {
                    view2 = view.findViewById(viewBinder.callToActionId);
                }
                adData.callToActionButton = view2;
                adData.duration = AdMostCustomView.this.getCustomNativeAdDuration();
                if (adData.preventClicks) {
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C0164R.C0166id.ad_progress_layout);
                    View unused = AdMostCustomView.this.curtainView = new View(view.getContext());
                    View unused2 = AdMostCustomView.this.privacyView = view.findViewById(viewBinder.privacyIconId);
                    AdMostCustomView.this.curtainView.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return AdMostCustomView.this.onTouch(motionEvent);
                        }
                    });
                    int i3 = -1;
                    relativeLayout.addView(AdMostCustomView.this.curtainView, new RelativeLayout.LayoutParams(-1, -1));
                    if (viewBinder != null && (i2 = viewBinder.mainImageId) > 0) {
                        AdMostCustomView.preventClicksForViews(view.findViewById(i2), false, new int[0]);
                    }
                    int[] iArr = new int[1];
                    if (viewBinder != null) {
                        i3 = viewBinder.privacyIconId;
                    }
                    iArr[0] = i3;
                    AdMostCustomView.preventClicksForViews(relativeLayout, true, iArr);
                }
                if (AdMostCustomView.this.externalListener != null) {
                    AdMostCustomView.this.externalListener.onReady(adData, view);
                }
            }
        };
        this.internalListener = r0;
        return r0;
    }

    private boolean isViewInBounds(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getDrawingRect(rect);
        view.getLocationOnScreen(iArr);
        rect.offset(iArr[0], iArr[1]);
        "click : (" + i + "," + i2 + ")  location : (" + iArr[0] + "," + iArr[1] + ") outrec t/b/l/r: (" + rect.top + "/" + rect.bottom + "/" + rect.left + "/" + rect.right + ")";
        return rect.contains(i, i2);
    }

    /* access modifiers changed from: private */
    public static void preventClicksForViews(View view, boolean z, int... iArr) {
        if (view != null) {
            if ((view instanceof ViewGroup) && z) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    preventClicksForViews(viewGroup.getChildAt(i), z, iArr);
                }
            } else if (iArr == null || !contains(iArr, view.getId())) {
                view.setClickable(false);
                view.setFocusable(false);
                view.setFocusableInTouchMode(false);
            }
        }
    }

    public void destroy() {
        super.destroy();
        this.adData = null;
        this.externalListener = null;
        this.internalListener = null;
    }

    public final Data getAdData() {
        if (this.adData == null) {
            synchronized (this) {
                if (this.adData == null) {
                    this.adData = new Data();
                }
            }
        }
        return this.adData;
    }

    public boolean goToAdUrl() {
        if (getAdData().callToActionButton == null) {
            return false;
        }
        getAdData().callToActionButton.performClick();
        return true;
    }

    public boolean onTouch(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.curtainView.getLocationOnScreen(iArr);
        if (!this.privacyIconClicked && !isViewInBounds(this.privacyView, ((int) motionEvent.getX()) + iArr[0], ((int) motionEvent.getY()) + iArr[1])) {
            return true;
        }
        this.privacyIconClicked = false;
        return false;
    }

    public AdMostCustomView(Activity activity, String str, AdMostCustomViewListener adMostCustomViewListener, AdMostViewBinder adMostViewBinder) {
        super(activity, str, (AdMostViewListener) null, adMostViewBinder);
        this.externalListener = adMostCustomViewListener;
        setListener(getInternalListener());
    }
}
