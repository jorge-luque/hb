package com.miniclip.p155ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miniclip.framework.AbstractActivityListener;
import com.miniclip.framework.Miniclip;
import com.miniclip.framework.ThreadingContext;
import com.miniclip.mcprime.C4277R;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.miniclip.ui.AlertPopup */
public class AlertPopup implements DialogInterface.OnClickListener {
    /* access modifiers changed from: private */
    public static float MAX_HEIGHT_RELATIVE_TO_SCREEN_FOR_MESSAGE_BOX = 0.3f;
    private AbstractActivityListener activityListener;
    private String[] mButtonTitles;
    /* access modifiers changed from: private */
    public boolean mCancelable;
    /* access modifiers changed from: private */
    public AlertDialog mDialog;
    private String mMessage;
    /* access modifiers changed from: private */
    public long mNativeDialogId;
    /* access modifiers changed from: private */
    public Number mNativeObjectReference;
    private boolean mShowActivityIndicator;
    private String mTitle;
    private boolean[] mUseBoldFonts;

    /* renamed from: com.miniclip.ui.AlertPopup$a */
    class C4289a extends AbstractActivityListener {
        C4289a() {
        }

        public void onDestroy() {
            if (AlertPopup.this.mDialog != null) {
                AlertPopup.this.mDialog.dismiss();
            }
            AlertPopup.nativeClearRunningPopups();
        }
    }

    /* renamed from: com.miniclip.ui.AlertPopup$b */
    class C4290b implements Runnable {
        C4290b() {
        }

        public void run() {
            AlertPopup.this.showDialog();
        }
    }

    /* renamed from: com.miniclip.ui.AlertPopup$c */
    class C4291c implements Runnable {
        C4291c() {
        }

        public void run() {
            AlertPopup.this.closeDialog();
        }
    }

    /* renamed from: com.miniclip.ui.AlertPopup$d */
    class C4292d implements DialogInterface.OnKeyListener {
        C4292d() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (!AlertPopup.this.mCancelable || i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            AlertPopup alertPopup = AlertPopup.this;
            alertPopup.nativeBackButtonCallback(((Long) alertPopup.mNativeObjectReference).longValue());
            return true;
        }
    }

    /* renamed from: com.miniclip.ui.AlertPopup$e */
    class C4293e implements DialogInterface.OnShowListener {
        C4293e() {
        }

        public void onShow(DialogInterface dialogInterface) {
            if (AlertPopup.this.mNativeObjectReference != null) {
                AlertPopup alertPopup = AlertPopup.this;
                alertPopup.nativePopupDidAppear(alertPopup.mNativeObjectReference.longValue());
                return;
            }
            "Tried calling nativePopupDidAppear with null messageId: " + AlertPopup.this.mNativeDialogId;
        }
    }

    /* renamed from: com.miniclip.ui.AlertPopup$f */
    class C4294f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        final /* synthetic */ TextView f11457a;

        C4294f(TextView textView) {
            this.f11457a = textView;
        }

        public void onGlobalLayout() {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Miniclip.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (((float) this.f11457a.getHeight()) > ((float) displayMetrics.heightPixels) * AlertPopup.MAX_HEIGHT_RELATIVE_TO_SCREEN_FOR_MESSAGE_BOX) {
                TextView textView = this.f11457a;
                textView.setTextSize(0, textView.getTextSize() - 1.0f);
                return;
            }
            AlertPopup.this.adjustButtonsLayout();
            this.f11457a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AlertPopup.this.mDialog.show();
        }
    }

    /* renamed from: com.miniclip.ui.AlertPopup$g */
    class C4295g implements View.OnClickListener {
        C4295g() {
        }

        public void onClick(View view) {
            AlertPopup.this.onDialogButtonClick(-2);
        }
    }

    /* renamed from: com.miniclip.ui.AlertPopup$h */
    class C4296h implements View.OnClickListener {
        C4296h() {
        }

        public void onClick(View view) {
            AlertPopup.this.onDialogButtonClick(-3);
        }
    }

    /* renamed from: com.miniclip.ui.AlertPopup$i */
    class C4297i implements View.OnClickListener {
        C4297i() {
        }

        public void onClick(View view) {
            AlertPopup.this.onDialogButtonClick(-1);
        }
    }

    AlertPopup(long j, long j2) {
        C4289a aVar = new C4289a();
        this.activityListener = aVar;
        Miniclip.addListener(aVar);
        this.mNativeObjectReference = Long.valueOf(j);
        this.mNativeDialogId = j2;
    }

    /* access modifiers changed from: private */
    public void adjustButtonsLayout() {
        List<Integer> activeButtons = getActiveButtons();
        if (activeButtons.size() != 0) {
            LinearLayout linearLayout = (LinearLayout) this.mDialog.getButton(-1).getParent();
            if (activeButtons.size() > 1 && linearLayout.getOrientation() == 1) {
                for (int childCount = linearLayout.getChildCount(); childCount >= 0; childCount--) {
                    linearLayout.bringChildToFront(linearLayout.getChildAt(childCount));
                }
            }
            if (activeButtons.size() == this.mUseBoldFonts.length) {
                for (int i = 0; i < activeButtons.size(); i++) {
                    Button button = this.mDialog.getButton(activeButtons.get(i).intValue());
                    if (button != null) {
                        if (this.mUseBoldFonts[i]) {
                            button.setTypeface(button.getTypeface(), 1);
                        } else {
                            button.setTypeface(button.getTypeface(), 0);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void closeDialog() {
        " Closing AlertDialog with id: " + this.mNativeDialogId;
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            "Trying to dismiss dialog in invalid state " + this.mNativeDialogId;
            return;
        }
        Number number = this.mNativeObjectReference;
        if (number == null) {
            "Dismissing Dialog without native object associated id" + this.mNativeDialogId;
            this.mDialog.dismiss();
            return;
        }
        nativePopupWillDisappear(number.longValue());
        this.mDialog.dismiss();
        nativePopupDidDisappear(this.mNativeObjectReference.longValue());
    }

    private List<Integer> getActiveButtons() {
        List<Integer> asList = Arrays.asList(new Integer[]{-3, -2, -1});
        for (int i = 0; i < asList.size(); i++) {
            Button button = this.mDialog.getButton(asList.get(i).intValue());
            if (button == null || TextUtils.isEmpty(button.getText())) {
                return asList.subList(i + 1, asList.size());
            }
        }
        return asList;
    }

    private native void handleButtonPressNative(long j, int i);

    /* access modifiers changed from: private */
    public native void nativeBackButtonCallback(long j);

    /* access modifiers changed from: private */
    public static native void nativeClearRunningPopups();

    /* access modifiers changed from: private */
    public native void nativePopupDidAppear(long j);

    private native void nativePopupDidDisappear(long j);

    private native void nativePopupWillAppear(long j);

    private native void nativePopupWillDisappear(long j);

    /* access modifiers changed from: private */
    public void onDialogButtonClick(int i) {
        int buttonIndexAjustment = buttonIndexAjustment(this.mDialog, i);
        Number number = this.mNativeObjectReference;
        if (number != null) {
            handleButtonPressNative(((Long) number).longValue(), buttonIndexAjustment);
        }
    }

    private void overrideOnClickButtons() {
        this.mDialog.getButton(-2).setOnClickListener(new C4295g());
        this.mDialog.getButton(-3).setOnClickListener(new C4296h());
        this.mDialog.getButton(-1).setOnClickListener(new C4297i());
    }

    /* access modifiers changed from: private */
    public void showDialog() {
        " Creating a dialog for message: " + this.mNativeDialogId + " withTitle:" + '\"' + this.mTitle + '\"' + " withMessage: " + '\"' + this.mMessage + '\"' + " and with " + this.mButtonTitles.length + " buttons.";
        if (this.mDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Miniclip.getActivity());
            if (!this.mTitle.equals("")) {
                builder.setTitle(this.mTitle);
            }
            if (this.mButtonTitles.length < 4 && !this.mMessage.equals("")) {
                builder.setMessage(this.mMessage);
            }
            String[] strArr = this.mButtonTitles;
            if (strArr.length == 1) {
                builder.setPositiveButton(strArr[0], (DialogInterface.OnClickListener) null);
            } else if (strArr.length == 2) {
                builder.setNegativeButton(strArr[0], (DialogInterface.OnClickListener) null);
                builder.setPositiveButton(this.mButtonTitles[1], (DialogInterface.OnClickListener) null);
            } else if (strArr.length == 3) {
                builder.setMessage(this.mMessage);
                builder.setNeutralButton(this.mButtonTitles[0], (DialogInterface.OnClickListener) null);
                builder.setNegativeButton(this.mButtonTitles[1], (DialogInterface.OnClickListener) null);
                builder.setPositiveButton(this.mButtonTitles[2], (DialogInterface.OnClickListener) null);
            } else if (strArr.length > 3) {
                if (!this.mTitle.equals("")) {
                    if (!this.mMessage.equals("")) {
                        builder.setTitle(this.mTitle + "\n" + this.mMessage);
                    } else {
                        builder.setTitle(this.mTitle);
                    }
                } else if (!this.mMessage.equals("")) {
                    builder.setTitle(this.mMessage);
                } else {
                    return;
                }
                builder.setItems(this.mButtonTitles, this);
            }
            if (this.mShowActivityIndicator) {
                builder.setView(Miniclip.getActivity().getLayoutInflater().inflate(C4277R.layout.progress_view, (ViewGroup) null));
            }
            AlertDialog create = builder.create();
            this.mDialog = create;
            create.setCancelable(true);
            this.mDialog.setOnKeyListener(new C4292d());
            this.mDialog.setCanceledOnTouchOutside(false);
            Number number = this.mNativeObjectReference;
            if (number != null) {
                nativePopupWillAppear(number.longValue());
            } else {
                "Tried calling nativePopupWillAppear with null messageId: " + this.mNativeDialogId;
            }
            this.mDialog.setOnShowListener(new C4293e());
            try {
                this.mDialog.show();
                this.mDialog.hide();
                if (this.mButtonTitles.length <= 3) {
                    overrideOnClickButtons();
                }
                if (!tryToAdjustDialogLayout()) {
                    this.mDialog.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean tryToAdjustDialogLayout() {
        TextView textView = (TextView) this.mDialog.findViewById(16908299);
        if (textView == null) {
            return false;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new C4294f(textView));
        return true;
    }

    /* access modifiers changed from: package-private */
    public int buttonIndexAjustment(AlertDialog alertDialog, int i) {
        String str;
        if (i < 0) {
            String str2 = (String) alertDialog.getButton(-3).getText();
            Button button = alertDialog.getButton(-2);
            if (button == null) {
                str = "";
            } else {
                str = String.valueOf(button.getText());
            }
            if (str2 == "") {
                if (str != "") {
                    if (i == -1) {
                        return 1;
                    }
                    if (i == -2) {
                        return 0;
                    }
                }
                return 0;
            } else if (i == -1) {
                return 2;
            } else {
                if (i == -2) {
                    return 1;
                }
                if (i == -3) {
                    return 0;
                }
            }
        }
        return i;
    }

    public void dismissAlertPopup() {
        Miniclip.queueEvent(ThreadingContext.AndroidUi, new C4291c());
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        onDialogButtonClick(i);
    }

    public void showAlertPopup(String str, String str2, boolean z, boolean z2, String[] strArr, boolean[] zArr) {
        this.mTitle = str;
        this.mMessage = str2;
        this.mCancelable = z;
        this.mButtonTitles = strArr;
        this.mShowActivityIndicator = z2;
        this.mUseBoldFonts = zArr;
        Miniclip.queueEvent(ThreadingContext.AndroidUi, new C4290b());
    }
}
