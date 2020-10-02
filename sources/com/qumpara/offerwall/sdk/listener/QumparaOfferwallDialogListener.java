package com.qumpara.offerwall.sdk.listener;

import android.app.Dialog;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;

public interface QumparaOfferwallDialogListener {
    void onActionButtonClicked(QumparaOfferwallModels.OfferwallItem offerwallItem, Dialog dialog);

    void onDialogShown(Dialog dialog);

    void onDialogShownError();

    void onDismissed(String str, Dialog dialog);
}
