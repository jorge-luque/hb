package com.unity3d.services.core.configuration;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InitializationNotificationCenter implements IInitializationNotificationCenter {
    private static InitializationNotificationCenter instance;
    private HashMap<Integer, WeakReference<IInitializationListener>> _sdkListeners = new HashMap<>();

    public static InitializationNotificationCenter getInstance() {
        if (instance == null) {
            instance = new InitializationNotificationCenter();
        }
        return instance;
    }

    public void addListener(IInitializationListener iInitializationListener) {
        synchronized (this._sdkListeners) {
            if (iInitializationListener != null) {
                this._sdkListeners.put(new Integer(iInitializationListener.hashCode()), new WeakReference(iInitializationListener));
            }
        }
    }

    public void removeListener(IInitializationListener iInitializationListener) {
        synchronized (this._sdkListeners) {
            if (iInitializationListener != null) {
                removeListener(new Integer(iInitializationListener.hashCode()));
            }
        }
    }

    public void triggerOnSdkInitializationFailed(String str, final int i) {
        synchronized (this._sdkListeners) {
            final String str2 = "SDK Failed to Initialize due to " + str;
            DeviceLog.error(str2);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : this._sdkListeners.entrySet()) {
                if (((WeakReference) next.getValue()).get() != null) {
                    final IInitializationListener iInitializationListener = (IInitializationListener) ((WeakReference) next.getValue()).get();
                    Utilities.runOnUiThread(new Runnable() {
                        public void run() {
                            iInitializationListener.onSdkInitializationFailed(str2, i);
                        }
                    });
                } else {
                    arrayList.add(next.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this._sdkListeners.remove((Integer) it.next());
            }
        }
    }

    public void triggerOnSdkInitialized() {
        synchronized (this._sdkListeners) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : this._sdkListeners.entrySet()) {
                if (((WeakReference) next.getValue()).get() != null) {
                    final IInitializationListener iInitializationListener = (IInitializationListener) ((WeakReference) next.getValue()).get();
                    Utilities.runOnUiThread(new Runnable() {
                        public void run() {
                            iInitializationListener.onSdkInitialized();
                        }
                    });
                } else {
                    arrayList.add(next.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this._sdkListeners.remove((Integer) it.next());
            }
        }
    }

    private void removeListener(Integer num) {
        this._sdkListeners.remove(num);
    }
}