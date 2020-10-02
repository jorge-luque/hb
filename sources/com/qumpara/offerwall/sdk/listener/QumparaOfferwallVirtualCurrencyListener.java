package com.qumpara.offerwall.sdk.listener;

import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import java.util.ArrayList;

public interface QumparaOfferwallVirtualCurrencyListener {
    void fail(int i, String str);

    void success(ArrayList<QumparaOfferwallModels.OfferwallItemPrize> arrayList);
}
