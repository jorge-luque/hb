package com.crashlytics.android.answers;

import java.io.File;
import java.util.List;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p118io.fabric.sdk.android.p200m.p202b.C6116v;
import p118io.fabric.sdk.android.p200m.p203c.C6126f;
import p118io.fabric.sdk.android.services.network.C6199c;
import p118io.fabric.sdk.android.services.network.C6200d;
import p118io.fabric.sdk.android.services.network.HttpRequest;

class SessionAnalyticsFilesSender extends C6078a implements C6126f {
    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(C6069h hVar, String str, String str2, C6200d dVar, String str3) {
        super(hVar, str, str2, dVar, C6199c.POST);
        this.apiKey = str3;
    }

    public boolean send(List<File> list) {
        HttpRequest httpRequest = getHttpRequest();
        httpRequest.mo34341c(C6078a.HEADER_CLIENT_TYPE, "android");
        httpRequest.mo34341c(C6078a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        httpRequest.mo34341c(C6078a.HEADER_API_KEY, this.apiKey);
        int i = 0;
        for (File next : list) {
            httpRequest.mo34330a(FILE_PARAM_NAME + i, next.getName(), FILE_CONTENT_TYPE, next);
            i++;
        }
        C6072k f = C6059c.m19630f();
        f.mo34093d(Answers.TAG, "Sending " + list.size() + " analytics files to " + getUrl());
        int g = httpRequest.mo34351g();
        C6072k f2 = C6059c.m19630f();
        f2.mo34093d(Answers.TAG, "Response code for analytics file send is " + g);
        if (C6116v.m19833a(g) == 0) {
            return true;
        }
        return false;
    }
}
