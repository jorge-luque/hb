package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import java.io.IOException;
import p118io.fabric.sdk.android.p200m.p202b.C6117w;
import p118io.fabric.sdk.android.p200m.p203c.C6127g;
import p118io.fabric.sdk.android.p200m.p204d.C6130a;

class AnswersFilesManagerProvider {
    static final String SESSION_ANALYTICS_FILE_NAME = "session_analytics.tap";
    static final String SESSION_ANALYTICS_TO_SEND_DIR = "session_analytics_to_send";
    final Context context;
    final C6130a fileStore;

    public AnswersFilesManagerProvider(Context context2, C6130a aVar) {
        this.context = context2;
        this.fileStore = aVar;
    }

    public SessionAnalyticsFilesManager getAnalyticsFilesManager() throws IOException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return new SessionAnalyticsFilesManager(this.context, new SessionEventTransform(), new C6117w(), new C6127g(this.context, this.fileStore.mo34239a(), SESSION_ANALYTICS_FILE_NAME, SESSION_ANALYTICS_TO_SEND_DIR));
        }
        throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    }
}
