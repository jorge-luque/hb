package com.crashlytics.android.answers;

import android.content.Context;
import java.io.IOException;
import java.util.UUID;
import p118io.fabric.sdk.android.p200m.p202b.C6096k;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;
import p118io.fabric.sdk.android.p200m.p203c.C6123c;
import p118io.fabric.sdk.android.p200m.p205e.C6135b;

class SessionAnalyticsFilesManager extends C6120b<SessionEvent> {
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private C6135b analyticsSettingsData;

    SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, C6096k kVar, C6123c cVar) throws IOException {
        super(context, sessionEventTransform, kVar, cVar, 100);
    }

    /* access modifiers changed from: protected */
    public String generateUniqueRollOverFileName() {
        UUID randomUUID = UUID.randomUUID();
        return SESSION_ANALYTICS_TO_SEND_FILE_PREFIX + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + randomUUID.toString() + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + this.currentTimeProvider.mo34175a() + SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION;
    }

    /* access modifiers changed from: protected */
    public int getMaxByteSizePerFile() {
        C6135b bVar = this.analyticsSettingsData;
        return bVar == null ? super.getMaxByteSizePerFile() : bVar.f16116c;
    }

    /* access modifiers changed from: protected */
    public int getMaxFilesToKeep() {
        C6135b bVar = this.analyticsSettingsData;
        return bVar == null ? super.getMaxFilesToKeep() : bVar.f16117d;
    }

    /* access modifiers changed from: package-private */
    public void setAnalyticsSettingsData(C6135b bVar) {
        this.analyticsSettingsData = bVar;
    }
}
