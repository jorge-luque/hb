package com.vungle.warren.p074ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import com.vungle.warren.p074ui.CloseDelegate;
import com.vungle.warren.p074ui.OrientationDelegate;
import com.vungle.warren.p074ui.contract.AdContract;
import com.vungle.warren.p074ui.contract.AdContract.AdvertisementPresenter;
import com.vungle.warren.utility.ExternalRouter;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.vungle.warren.ui.view.BaseAdView */
public abstract class BaseAdView<T extends AdContract.AdvertisementPresenter> implements AdContract.AdView<T> {
    protected final String TAG = getClass().getSimpleName();
    private final CloseDelegate closeDelegate;
    protected final Context context;
    protected Dialog currentDialog;
    protected Handler handler = new Handler(Looper.getMainLooper());
    private final OrientationDelegate orientationDelegate;
    protected final FullAdWidget view;

    /* renamed from: com.vungle.warren.ui.view.BaseAdView$DialogClickListenerProxy */
    private static class DialogClickListenerProxy implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        private AtomicReference<DialogInterface.OnClickListener> ckickRef = new AtomicReference<>();
        private AtomicReference<DialogInterface.OnDismissListener> dismissRef = new AtomicReference<>();

        public DialogClickListenerProxy(DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
            this.ckickRef.set(onClickListener);
            this.dismissRef.set(onDismissListener);
        }

        /* access modifiers changed from: private */
        public void autoRelease(Dialog dialog) {
            dialog.setOnDismissListener(this);
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            DialogInterface.OnClickListener onClickListener = this.ckickRef.get();
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i);
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = this.dismissRef.get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
            this.dismissRef.set((Object) null);
            this.ckickRef.set((Object) null);
        }
    }

    public BaseAdView(Context context2, FullAdWidget fullAdWidget, OrientationDelegate orientationDelegate2, CloseDelegate closeDelegate2) {
        this.view = fullAdWidget;
        this.context = context2;
        this.orientationDelegate = orientationDelegate2;
        this.closeDelegate = closeDelegate2;
    }

    public void close() {
        this.closeDelegate.close();
    }

    public void destroyAdView() {
        this.view.release();
    }

    public String getWebsiteUrl() {
        return this.view.getUrl();
    }

    public boolean hasWebView() {
        return this.view.hasWebView();
    }

    public void open(String str) {
        "Opening " + str;
        if (!ExternalRouter.launch(str, this.context)) {
            Log.e(this.TAG, "Cannot open url " + str);
        }
    }

    public void pauseWeb() {
        this.view.pauseWeb();
    }

    public void removeWebView() {
        this.view.removeWebView();
    }

    public void resumeWeb() {
        this.view.resumeWeb();
    }

    public void setImmersiveMode() {
        this.view.setImmersiveMode();
    }

    public void setOrientation(int i) {
        this.orientationDelegate.setOrientation(i);
    }

    public void showCloseButton() {
        this.view.showCloseButton(true);
    }

    public void showDialog(String str, String str2, String str3, String str4, final DialogInterface.OnClickListener onClickListener) {
        Context context2 = this.context;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context2, context2.getApplicationInfo().theme));
        DialogClickListenerProxy dialogClickListenerProxy = new DialogClickListenerProxy(new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                BaseAdView.this.currentDialog = null;
                DialogInterface.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
            }
        }, new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                BaseAdView.this.currentDialog = null;
            }
        });
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        builder.setPositiveButton(str3, dialogClickListenerProxy);
        builder.setNegativeButton(str4, dialogClickListenerProxy);
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        this.currentDialog = create;
        dialogClickListenerProxy.autoRelease(create);
        this.currentDialog.show();
    }
}
