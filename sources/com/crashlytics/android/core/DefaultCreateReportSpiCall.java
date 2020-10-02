package com.crashlytics.android.core;

import java.io.File;
import java.util.Map;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p118io.fabric.sdk.android.p200m.p202b.C6116v;
import p118io.fabric.sdk.android.services.network.C6199c;
import p118io.fabric.sdk.android.services.network.C6200d;
import p118io.fabric.sdk.android.services.network.HttpRequest;

class DefaultCreateReportSpiCall extends C6078a implements CreateReportSpiCall {
    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";
    static final String MULTI_FILE_PARAM = "report[file";

    public DefaultCreateReportSpiCall(C6069h hVar, String str, String str2, C6200d dVar) {
        super(hVar, str, str2, dVar, C6199c.POST);
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        httpRequest.mo34341c(C6078a.HEADER_API_KEY, createReportRequest.apiKey);
        httpRequest.mo34341c(C6078a.HEADER_CLIENT_TYPE, "android");
        httpRequest.mo34341c(C6078a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        for (Map.Entry<String, String> a : createReportRequest.report.getCustomHeaders().entrySet()) {
            httpRequest.mo34333a(a);
        }
        return httpRequest;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        httpRequest.mo34348e(IDENTIFIER_PARAM, report.getIdentifier());
        if (report.getFiles().length == 1) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Adding single file " + report.getFileName() + " to report " + report.getIdentifier());
            httpRequest.mo34330a(FILE_PARAM, report.getFileName(), FILE_CONTENT_TYPE, report.getFile());
            return httpRequest;
        }
        int i = 0;
        for (File file : report.getFiles()) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Adding file " + file.getName() + " to report " + report.getIdentifier());
            StringBuilder sb = new StringBuilder();
            sb.append(MULTI_FILE_PARAM);
            sb.append(i);
            sb.append("]");
            httpRequest.mo34330a(sb.toString(), file.getName(), FILE_CONTENT_TYPE, file);
            i++;
        }
        return httpRequest;
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        HttpRequest applyMultipartDataTo = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createReportRequest), createReportRequest.report);
        C6072k f = C6059c.m19630f();
        f.mo34093d(CrashlyticsCore.TAG, "Sending report to: " + getUrl());
        int g = applyMultipartDataTo.mo34351g();
        C6072k f2 = C6059c.m19630f();
        f2.mo34093d(CrashlyticsCore.TAG, "Create report request ID: " + applyMultipartDataTo.mo34343c(C6078a.HEADER_REQUEST_ID));
        C6072k f3 = C6059c.m19630f();
        f3.mo34093d(CrashlyticsCore.TAG, "Result was: " + g);
        return C6116v.m19833a(g) == 0;
    }

    DefaultCreateReportSpiCall(C6069h hVar, String str, String str2, C6200d dVar, C6199c cVar) {
        super(hVar, str, str2, dVar, cVar);
    }
}
