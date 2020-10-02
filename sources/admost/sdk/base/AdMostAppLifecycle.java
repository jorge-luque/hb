package admost.sdk.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

@TargetApi(14)
public class AdMostAppLifecycle implements Application.ActivityLifecycleCallbacks {
    Listener listener;

    public interface Listener {
        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    public AdMostAppLifecycle(Listener listener2) {
        this.listener = listener2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        this.listener.onActivityDestroyed(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.listener.onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        this.listener.onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.listener.onActivityStarted(activity);
    }

    public void onActivityStopped(Activity activity) {
        this.listener.onActivityStopped(activity);
    }
}
