package com.crashlytics.android.answers;

import android.content.Context;
import java.util.Map;
import java.util.UUID;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p202b.C6107s;

class SessionMetadataCollector {
    private final Context context;
    private final C6107s idManager;
    private final String versionCode;
    private final String versionName;

    public SessionMetadataCollector(Context context2, C6107s sVar, String str, String str2) {
        this.context = context2;
        this.idManager = sVar;
        this.versionCode = str;
        this.versionName = str2;
    }

    public SessionEventMetadata getMetadata() {
        Map<C6107s.C6108a, String> e = this.idManager.mo34193e();
        String n = C6090i.m19759n(this.context);
        String j = this.idManager.mo34198j();
        String g = this.idManager.mo34195g();
        return new SessionEventMetadata(this.idManager.mo34191c(), UUID.randomUUID().toString(), this.idManager.mo34192d(), this.idManager.mo34199k(), e.get(C6107s.C6108a.FONT_TOKEN), n, j, g, this.versionCode, this.versionName);
    }
}
