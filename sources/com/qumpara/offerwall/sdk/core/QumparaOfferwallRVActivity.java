package com.qumpara.offerwall.sdk.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.drive.DriveFile;
import com.ogury.p159cm.OguryChoiceManager;
import com.qumpara.lib_qumpara_ads.R$drawable;
import com.qumpara.lib_qumpara_ads.R$id;
import com.qumpara.lib_qumpara_ads.R$layout;
import com.qumpara.lib_qumpara_ads.R$string;
import com.qumpara.offerwall.sdk.core.QumparaGenericRequest;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallRecyclerViewAdapter;
import com.qumpara.offerwall.sdk.img.FastImageView;
import com.qumpara.offerwall.sdk.listener.QumparaOfferwallDialogListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class QumparaOfferwallRVActivity extends Activity {
    /* access modifiers changed from: private */
    public QumparaOfferwallRecyclerViewAdapter mAdapter;
    /* access modifiers changed from: private */
    public Dialog mCampaignDetailDialog;
    /* access modifiers changed from: private */
    public QumparaOfferwallDialogListener mCampaignDetailDialogListener;
    private ImageView mCloseIcon;
    /* access modifiers changed from: private */
    public QumparaOfferwallModels.OfferwallResponse mOfferwallResponse;
    private LinearLayout mQumparaHelpLayout;
    private RelativeLayout mQumparaRedeemCodebar;
    private LinearLayout mQumparaStoreLayout;
    private RelativeLayout mQumparaToolbar;
    private RecyclerView mRecyclerView;
    private Dialog mRedeemCodeDialog;
    private QumparaOfferwallDialogListener mRedeemDialogListener;
    private View mSendCodeButton;
    private TextView mToolbarText;
    /* access modifiers changed from: private */
    public Dialog mWebviewDialog;
    private Observer redeemCodeObserver;
    /* access modifiers changed from: private */
    public boolean sendCodeButtonClicked = false;

    /* access modifiers changed from: private */
    public Observer addEngagementObserver(final Dialog dialog) {
        if (dialog == null) {
            return null;
        }
        C47757 r0 = new Observer() {
            public void update(Observable observable, Object obj) {
                Object[] objArr = (Object[]) obj;
                int intValue = ((Integer) objArr[0]).intValue();
                if (intValue == 8) {
                    if (((TextView) dialog.findViewById(R$id.item_reward_detail)) != null) {
                        try {
                            ArrayList arrayList = (ArrayList) objArr[1];
                            if (arrayList != null && arrayList.size() > 0) {
                                QumparaOfferwallRVActivity.this.mOfferwallResponse.getOfferwallItems().get(QumparaOfferwallRVActivity.this.mOfferwallResponse.getOfferwallItems().indexOf(arrayList.get(0))).setRedirectURL(((QumparaOfferwallModels.OfferwallItem) arrayList.get(0)).getRedirectURL());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (intValue == 10) {
                    QumparaOfferwallRVActivity.this.enableEngagementDialogButtons(dialog);
                } else if (intValue == 11) {
                    QumparaOfferwallRVActivity.this.enableEngagementDialogButtons(dialog);
                }
            }
        };
        QumparaOfferwallObservable.getInstance().addObserver(r0);
        return r0;
    }

    private void addRedeemCodeObserver(Dialog dialog) {
        if (this.redeemCodeObserver == null) {
            this.redeemCodeObserver = new Observer() {
                public void update(Observable observable, Object obj) {
                    String str;
                    Object[] objArr = (Object[]) obj;
                    int intValue = ((Integer) objArr[0]).intValue();
                    if (intValue == 13) {
                        String string = QumparaOfferwallRVActivity.this.getString(R$string.qumpara_offerwall_success_code_title);
                        QumparaOfferwallRVActivity.this.showDialog(QumparaOfferwallRVActivity.this.getString(R$string.qumpara_offerwall_success_code_subtitle), string);
                    } else if (intValue == 14) {
                        String string2 = QumparaOfferwallRVActivity.this.getString(R$string.qumpara_offerwall_error_code_title);
                        if (objArr.length > 1 && (objArr[1] instanceof String[])) {
                            String[] strArr = (String[]) objArr[1];
                            if (strArr.length >= 3) {
                                try {
                                    str = QumparaOfferwallUtil.getLocalizedErrorMessage(Integer.valueOf(strArr[1]).intValue());
                                } catch (Exception unused) {
                                    str = QumparaOfferwall.getContext().getString(R$string.qumpara_offerwall_error_unknown);
                                }
                                QumparaOfferwallRVActivity.this.showDialog(str, string2);
                            }
                        }
                        str = "";
                        QumparaOfferwallRVActivity.this.showDialog(str, string2);
                    }
                    boolean unused2 = QumparaOfferwallRVActivity.this.sendCodeButtonClicked = false;
                }
            };
            QumparaOfferwallObservable.getInstance().addObserver(this.redeemCodeObserver);
        }
    }

    private void clearGC() {
        try {
            this.mAdapter.setClickListener((QumparaOfferwallRecyclerViewAdapter.ItemClickListener) null);
            this.mQumparaStoreLayout.setOnClickListener((View.OnClickListener) null);
            this.mQumparaHelpLayout.setOnClickListener((View.OnClickListener) null);
            this.mCloseIcon.setOnClickListener((View.OnClickListener) null);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.mRedeemCodeDialog = null;
            this.mWebviewDialog = null;
            this.mCampaignDetailDialog = null;
            this.mRecyclerView = null;
            this.mRedeemDialogListener = null;
            this.mCampaignDetailDialogListener = null;
            this.mAdapter = null;
            throw th;
        }
        this.mRedeemCodeDialog = null;
        this.mWebviewDialog = null;
        this.mCampaignDetailDialog = null;
        this.mRecyclerView = null;
        this.mRedeemDialogListener = null;
        this.mCampaignDetailDialogListener = null;
        this.mAdapter = null;
    }

    /* access modifiers changed from: private */
    public void enableEngagementDialogButtons(final Dialog dialog) {
        QumparaOfferwall.runOnUIThread().post(new Runnable() {
            public void run() {
                dialog.setCancelable(true);
                ViewGroup viewGroup = (ViewGroup) dialog.findViewById(R$id.container_root);
                ((ViewGroup) dialog.findViewById(R$id.item_asset_layout)).setEnabled(true);
                ((ImageView) dialog.findViewById(R$id.icon_close)).setEnabled(true);
                if (dialog.findViewById(R$id.id_progress_layout) != null) {
                    viewGroup.removeView(dialog.findViewById(R$id.id_progress_layout));
                }
            }
        });
    }

    private void enableRedeemDialogButtons(final Dialog dialog) {
        QumparaOfferwall.runOnUIThread().post(new Runnable() {
            public void run() {
                dialog.setCancelable(true);
                ViewGroup viewGroup = (ViewGroup) dialog.findViewById(R$id.container_root);
                viewGroup.setBackgroundResource(R$drawable.qumpara_offerwall_dialog_corner);
                ((Button) dialog.findViewById(R$id.send_code_button)).setEnabled(true);
                ((ImageView) dialog.findViewById(R$id.icon_close)).setEnabled(true);
                if (dialog.findViewById(R$id.id_progress_layout) != null) {
                    viewGroup.removeView(dialog.findViewById(R$id.id_progress_layout));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void exit() {
        try {
            FastImageView.cancelAllTasks(this);
            QumparaOfferwallObservable.getInstance().onReceive(5, new String[0]);
            QumparaOfferwallObservable.getInstance().deleteObservers();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            clearGC();
            finish();
            throw th;
        }
        clearGC();
        finish();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00cc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initUI() {
        /*
            r15 = this;
            int r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.getDeviceWidth(r15)
            float r0 = (float) r0
            int r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.pxToDp(r0)
            int r1 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.getDeviceHeight(r15)
            float r1 = (float) r1
            int r1 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.pxToDp(r1)
            android.content.res.Resources r2 = r15.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.orientation
            int r3 = com.qumpara.lib_qumpara_ads.R$dimen.QumparaListViewItemMargin
            android.content.Context r4 = r15.getApplicationContext()
            int r3 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.pxOfDimen(r3, r4)
            int r4 = com.qumpara.lib_qumpara_ads.R$dimen.QumparaListViewItemMarginLeftRight
            android.content.Context r5 = r15.getApplicationContext()
            int r4 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.pxOfDimen(r4, r5)
            r5 = 3
            r6 = 2
            if (r2 != r6) goto L_0x006c
            int r2 = com.qumpara.lib_qumpara_ads.R$dimen.QumparaListViewItemMarginLandscape
            android.content.Context r3 = r15.getApplicationContext()
            int r3 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.pxOfDimen(r2, r3)
            int r2 = com.qumpara.lib_qumpara_ads.R$dimen.QumparaListViewItemMarginLandscapeLeftRight
            android.content.Context r4 = r15.getApplicationContext()
            int r4 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.pxOfDimen(r2, r4)
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            double r1 = r1.doubleValue()
            double r6 = (double) r0
            java.lang.Double.isNaN(r6)
            double r1 = r1 / r6
            r6 = 4603309323120478781(0x3fe23d70a3d70a3d, double:0.57)
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0069
            int r1 = com.qumpara.lib_qumpara_ads.R$dimen.QumparaListViewItemMarginLandscapeLongPhone
            android.content.Context r2 = r15.getApplicationContext()
            int r3 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.pxOfDimen(r1, r2)
        L_0x0069:
            r8 = r3
            r1 = 3
            goto L_0x006e
        L_0x006c:
            r8 = r3
            r1 = 2
        L_0x006e:
            r2 = 160(0xa0, float:2.24E-43)
            int r3 = r1 + 1
            int r6 = r4 * r3
            int r6 = r0 - r6
            int r6 = r6 / r1
            if (r6 <= r2) goto L_0x007e
            int r2 = r1 * 160
            int r0 = r0 - r2
            int r0 = r0 / r3
            goto L_0x007f
        L_0x007e:
            r0 = r4
        L_0x007f:
            com.qumpara.offerwall.sdk.core.QumparaOfferwallRecyclerViewAdapter r2 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallRecyclerViewAdapter
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallResponse r3 = r15.mOfferwallResponse
            java.util.ArrayList r11 = r3.getOfferwallItems()
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallResponse r3 = r15.mOfferwallResponse
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$MetaData r12 = r3.getMeta()
            r9 = r2
            r10 = r15
            r13 = r1
            r14 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            r15.mAdapter = r2
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallResponse r2 = r15.mOfferwallResponse
            r3 = 4
            java.lang.String r2 = r2.getColor(r3)
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallResponse r3 = r15.mOfferwallResponse
            r4 = 5
            java.lang.String r3 = r3.getColor(r4)
            boolean r4 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.isNullOrEmpty(r2)
            if (r4 != 0) goto L_0x00ba
            android.widget.RelativeLayout r4 = r15.mQumparaToolbar
            int r6 = com.qumpara.lib_qumpara_ads.R$color.QumparaOfferwallToolbarBackground
            com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.arrangeViewGradientColorFromRemoteConfig(r4, r2, r3, r6)
            android.widget.RelativeLayout r4 = r15.mQumparaRedeemCodebar
            if (r4 == 0) goto L_0x00ba
            int r6 = com.qumpara.lib_qumpara_ads.R$color.QumparaOfferwallToolbarBackground
            com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.arrangeViewGradientColorFromRemoteConfig(r4, r2, r3, r6)
        L_0x00ba:
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallResponse r2 = r15.mOfferwallResponse
            r3 = 6
            java.lang.String r2 = r2.getColor(r3)
            if (r2 == 0) goto L_0x00cc
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ Exception -> 0x00cc }
            android.widget.TextView r3 = r15.mToolbarText     // Catch:{ Exception -> 0x00cc }
            r3.setTextColor(r2)     // Catch:{ Exception -> 0x00cc }
        L_0x00cc:
            android.view.View r2 = r15.mSendCodeButton     // Catch:{ Exception -> 0x00db }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallResponse r3 = r15.mOfferwallResponse     // Catch:{ Exception -> 0x00db }
            r4 = 1
            java.lang.String r3 = r3.getColor(r4)     // Catch:{ Exception -> 0x00db }
            int r4 = com.qumpara.lib_qumpara_ads.R$color.QumparaOfferwallButtonColor     // Catch:{ Exception -> 0x00db }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.arrangeViewColorFromRemoteConfig(r2, r3, r4)     // Catch:{ Exception -> 0x00db }
            goto L_0x00dc
        L_0x00db:
        L_0x00dc:
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$OfferwallResponse r2 = r15.mOfferwallResponse
            java.lang.String r2 = r2.getColor(r5)
            android.view.View r3 = r15.mSendCodeButton
            boolean r4 = r3 instanceof android.widget.Button
            if (r4 == 0) goto L_0x00f3
            if (r2 == 0) goto L_0x00f3
            android.widget.Button r3 = (android.widget.Button) r3     // Catch:{ Exception -> 0x00f3 }
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ Exception -> 0x00f3 }
            r3.setTextColor(r2)     // Catch:{ Exception -> 0x00f3 }
        L_0x00f3:
            androidx.recyclerview.widget.RecyclerView r2 = r15.mRecyclerView
            com.qumpara.offerwall.sdk.helper.GridSpacingItemDecoration r3 = new com.qumpara.offerwall.sdk.helper.GridSpacingItemDecoration
            r10 = 1
            r11 = 0
            r6 = r3
            r7 = r1
            r9 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            r2.mo5259a((androidx.recyclerview.widget.RecyclerView.C1053n) r3)
            androidx.recyclerview.widget.RecyclerView r0 = r15.mRecyclerView
            androidx.recyclerview.widget.GridLayoutManager r2 = new androidx.recyclerview.widget.GridLayoutManager
            r2.<init>(r15, r1)
            r0.mo5261a((androidx.recyclerview.widget.RecyclerView.C1054o) r2)
            androidx.recyclerview.widget.RecyclerView r0 = r15.mRecyclerView
            com.qumpara.offerwall.sdk.core.QumparaOfferwallRecyclerViewAdapter r1 = r15.mAdapter
            r0.mo5258a((androidx.recyclerview.widget.RecyclerView.C1043g) r1)
            r0 = 0
            r15.addRedeemCodeObserver(r0)
            r15.setClickListeners()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaOfferwallRVActivity.initUI():void");
    }

    private void onShowError() {
        QumparaOfferwallObservable.getInstance().onReceive(6, new String[0]);
        finish();
    }

    private void setClickListeners() {
        this.mAdapter.setClickListener(new QumparaOfferwallRecyclerViewAdapter.ItemClickListener() {
            public void onItemClick(View view, int i) {
                final QumparaOfferwallModels.OfferwallItem item = QumparaOfferwallRVActivity.this.mAdapter.getItem(i);
                if (!QumparaOfferwallUtil.isNullOrEmpty(item.getId())) {
                    QumparaOfferwallDialogListener unused = QumparaOfferwallRVActivity.this.mCampaignDetailDialogListener = new QumparaOfferwallDialogListener() {
                        private Observer observer;

                        public void onActionButtonClicked(QumparaOfferwallModels.OfferwallItem offerwallItem, Dialog dialog) {
                            if (!QumparaOfferwallAPI.postEngagement(offerwallItem)) {
                                QumparaOfferwallRVActivity qumparaOfferwallRVActivity = QumparaOfferwallRVActivity.this;
                                qumparaOfferwallRVActivity.showDialog(qumparaOfferwallRVActivity.getString(R$string.qumpara_offerwall_error_internet), QumparaOfferwallRVActivity.this.getString(R$string.qumpara_offerwall_error_code_title));
                            }
                        }

                        public void onDialogShown(Dialog dialog) {
                            if (dialog != null) {
                                this.observer = QumparaOfferwallRVActivity.this.addEngagementObserver(dialog);
                                QumparaOfferwallAPI.getCampaignById(item.getId());
                            }
                        }

                        public void onDialogShownError() {
                        }

                        public void onDismissed(String str, Dialog dialog) {
                            if (this.observer != null) {
                                QumparaOfferwallObservable.getInstance().deleteObserver(this.observer);
                            }
                            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                            this.observer = null;
                        }
                    };
                    Dialog unused2 = QumparaOfferwallRVActivity.this.mCampaignDetailDialog = QumparaOfferwallUtil.showCampaignDetailDialog(new WeakReference(QumparaOfferwallRVActivity.this), item, QumparaOfferwallRVActivity.this.mCampaignDetailDialogListener, QumparaOfferwallRVActivity.this.mOfferwallResponse);
                }
            }
        });
        this.mQumparaStoreLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                intent.setData(Uri.parse("https://www.qumpara.com"));
                QumparaOfferwallRVActivity.this.startActivity(intent);
            }
        });
        this.mQumparaHelpLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QumparaOfferwallModels.OfferwallStatus instance = QumparaOfferwallModels.OfferwallStatus.getInstance();
                if (!instance.isHelpClicked()) {
                    instance.setHelpClicked(true);
                    QumparaOfferwallModels.OfferwallStatus.putInstance(instance);
                }
                Dialog unused = QumparaOfferwallRVActivity.this.mWebviewDialog = QumparaOfferwallUtil.showWebViewDialog(new WeakReference(QumparaOfferwallRVActivity.this), QumparaOfferwallRVActivity.this.mOfferwallResponse.getMeta().getHelpUrl());
            }
        });
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QumparaOfferwallRVActivity.this.exit();
            }
        });
        this.mSendCodeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!QumparaOfferwallRVActivity.this.sendCodeButtonClicked) {
                    boolean unused = QumparaOfferwallRVActivity.this.sendCodeButtonClicked = true;
                    EditText editText = (EditText) QumparaOfferwallRVActivity.this.findViewById(R$id.code_edittext);
                    if (editText != null) {
                        String trim = editText.getText().toString().trim();
                        if (QumparaOfferwallUtil.isNullOrEmpty(trim)) {
                            QumparaOfferwallRVActivity qumparaOfferwallRVActivity = QumparaOfferwallRVActivity.this;
                            qumparaOfferwallRVActivity.showDialog(qumparaOfferwallRVActivity.getString(R$string.qumpara_offerwall_error_code_subtitle), QumparaOfferwallRVActivity.this.getString(R$string.qumpara_offerwall_error_code_title));
                            boolean unused2 = QumparaOfferwallRVActivity.this.sendCodeButtonClicked = false;
                            return;
                        }
                        QumparaOfferwallAPI.postRedeemCode(trim, QumparaOfferwallModels.Identifiers.getInstance().getIdfa(), QumparaOfferwallModels.Identifiers.getInstance().getApplicationId(), QumparaOfferwallModels.Identifiers.getInstance().getApplicationUserId());
                        QumparaOfferwallObservable.getInstance().onReceive(15, trim);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void showDialog(final String str, final String str2) {
        QumparaOfferwall.runOnUIThread().post(new Runnable() {
            public void run() {
                ContextThemeWrapper contextThemeWrapper;
                if (Build.VERSION.SDK_INT >= 11) {
                    contextThemeWrapper = new ContextThemeWrapper(QumparaOfferwallRVActivity.this, 16973941);
                } else {
                    contextThemeWrapper = new ContextThemeWrapper(QumparaOfferwallRVActivity.this, 16973837);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(contextThemeWrapper);
                builder.setMessage(str).setTitle(str2).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
        setContentView(R$layout.qumpara_offerwall_rv_main_screen);
        QumparaOfferwallResponseCache fromCache = QumparaOfferwallResponseCache.getFromCache(QumparaGenericRequest.RequestType.GET_OFFERWALL_REQUEST, QumparaOfferwallModels.Identifiers.getInstance().getApplicationId());
        if (fromCache == null) {
            onShowError();
            return;
        }
        this.mOfferwallResponse = QumparaOfferwallAPI.mapOfferwallResponse(fromCache.getJsonObject());
        this.mQumparaHelpLayout = (LinearLayout) findViewById(R$id.qumparaHelpLayout);
        this.mQumparaStoreLayout = (LinearLayout) findViewById(R$id.qumparaStoreLayout);
        this.mQumparaToolbar = (RelativeLayout) findViewById(R$id.qumparaToolbar);
        this.mQumparaRedeemCodebar = (RelativeLayout) findViewById(R$id.qumparaRedeemCodeBar);
        this.mSendCodeButton = findViewById(R$id.send_code_button);
        this.mRecyclerView = (RecyclerView) findViewById(R$id.offerwall_recyclerview);
        this.mCloseIcon = (ImageView) findViewById(R$id.closeIcon);
        this.mToolbarText = (TextView) findViewById(R$id.toolbarText);
        initUI();
        QumparaOfferwallModels.OfferwallStatus instance = QumparaOfferwallModels.OfferwallStatus.getInstance();
        if (!instance.isOfferwallOpened()) {
            instance.setOfferwallOpened(true);
            QumparaOfferwallModels.OfferwallStatus.putInstance(instance);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        QumparaOfferwallObservable.getInstance().deleteObserver(this.redeemCodeObserver);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        exit();
        return false;
    }
}
