package com.miniclip.framework;

import android.app.Activity;

public interface MiniclipFacilitator {
    boolean addListener(ActivityListener activityListener);

    Activity getActivity();

    void queueEvent(ThreadingContext threadingContext, Runnable runnable);

    boolean removeListener(ActivityListener activityListener);
}
