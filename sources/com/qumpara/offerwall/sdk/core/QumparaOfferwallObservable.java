package com.qumpara.offerwall.sdk.core;

import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import java.util.ArrayList;
import java.util.Observable;

class QumparaOfferwallObservable extends Observable {
    private static QumparaOfferwallObservable instance = new QumparaOfferwallObservable();

    QumparaOfferwallObservable() {
    }

    public static QumparaOfferwallObservable getInstance() {
        return instance;
    }

    public void onReceive(int i, String... strArr) {
        synchronized (this) {
            setChanged();
            notifyObservers(new Object[]{Integer.valueOf(i), strArr});
        }
    }

    public void onReceive(int i, ArrayList<QumparaOfferwallModels.OfferwallItem> arrayList) {
        synchronized (this) {
            setChanged();
            notifyObservers(new Object[]{Integer.valueOf(i), arrayList});
        }
    }

    public void onReceive(int i, QumparaOfferwallModels.SpendVirtualCurrencyResponse spendVirtualCurrencyResponse) {
        synchronized (this) {
            setChanged();
            notifyObservers(new Object[]{Integer.valueOf(i), spendVirtualCurrencyResponse});
        }
    }
}
