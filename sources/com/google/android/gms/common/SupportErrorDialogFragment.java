package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.C0909b;
import androidx.fragment.app.C0917h;
import com.google.android.gms.common.internal.Preconditions;

public class SupportErrorDialogFragment extends C0909b {
    private Dialog mDialog = null;
    private DialogInterface.OnCancelListener zaan = null;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, (DialogInterface.OnCancelListener) null);
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.zaan;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.mDialog == null) {
            setShowsDialog(false);
        }
        return this.mDialog;
    }

    public void show(C0917h hVar, String str) {
        super.show(hVar, str);
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        supportErrorDialogFragment.mDialog = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.zaan = onCancelListener;
        }
        return supportErrorDialogFragment;
    }
}
