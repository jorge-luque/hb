package com.miniclip.framework;

import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public final class Miniclip {
    private static final LinkedHashSet<ActivityListener> activityListeners = new LinkedHashSet<>();
    private static MiniclipFacilitator facilitator;
    private static final Map<ThreadingContext, List<Runnable>> queuedEvents = new HashMap();

    public static boolean addListener(ActivityListener activityListener) {
        boolean add = activityListeners.add(activityListener);
        MiniclipFacilitator miniclipFacilitator = facilitator;
        return miniclipFacilitator != null ? miniclipFacilitator.addListener(activityListener) : add;
    }

    public static Activity getActivity() {
        MiniclipFacilitator miniclipFacilitator = facilitator;
        if (miniclipFacilitator != null) {
            return miniclipFacilitator.getActivity();
        }
        return null;
    }

    public static void queueEvent(ThreadingContext threadingContext, Runnable runnable) {
        MiniclipFacilitator miniclipFacilitator = facilitator;
        if (miniclipFacilitator != null) {
            miniclipFacilitator.queueEvent(threadingContext, runnable);
            return;
        }
        List list = queuedEvents.get(threadingContext);
        if (list == null) {
            list = new ArrayList();
            queuedEvents.put(threadingContext, list);
        }
        list.add(runnable);
    }

    public static boolean removeListener(ActivityListener activityListener) {
        boolean remove = activityListeners.remove(activityListener);
        MiniclipFacilitator miniclipFacilitator = facilitator;
        return miniclipFacilitator != null ? miniclipFacilitator.removeListener(activityListener) : remove;
    }

    public static void setFacilitator(MiniclipFacilitator miniclipFacilitator) {
        facilitator = miniclipFacilitator;
        if (miniclipFacilitator != null) {
            Iterator it = activityListeners.iterator();
            while (it.hasNext()) {
                miniclipFacilitator.addListener((ActivityListener) it.next());
            }
            while (!queuedEvents.isEmpty()) {
                ThreadingContext next = queuedEvents.keySet().iterator().next();
                for (Runnable queueEvent : queuedEvents.remove(next)) {
                    miniclipFacilitator.queueEvent(next, queueEvent);
                }
            }
        }
    }
}
