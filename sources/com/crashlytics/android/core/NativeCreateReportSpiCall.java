package com.crashlytics.android.core;

import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p118io.fabric.sdk.android.p200m.p202b.C6116v;
import p118io.fabric.sdk.android.services.network.C6199c;
import p118io.fabric.sdk.android.services.network.C6200d;
import p118io.fabric.sdk.android.services.network.HttpRequest;

class NativeCreateReportSpiCall extends C6078a implements CreateReportSpiCall {
    private static final String APP_META_FILE_MULTIPART_PARAM = "app_meta_file";
    private static final String BINARY_IMAGES_FILE_MULTIPART_PARAM = "binary_images_file";
    private static final String DEVICE_META_FILE_MULTIPART_PARAM = "device_meta_file";
    private static final String GZIP_FILE_CONTENT_TYPE = "application/octet-stream";
    private static final String KEYS_FILE_MULTIPART_PARAM = "keys_file";
    private static final String LOGS_FILE_MULTIPART_PARAM = "logs_file";
    private static final String METADATA_FILE_MULTIPART_PARAM = "crash_meta_file";
    private static final String MINIDUMP_FILE_MULTIPART_PARAM = "minidump_file";
    private static final String OS_META_FILE_MULTIPART_PARAM = "os_meta_file";
    private static final String REPORT_IDENTIFIER_PARAM = "report_id";
    private static final String SESSION_META_FILE_MULTIPART_PARAM = "session_meta_file";
    private static final String USER_META_FILE_MULTIPART_PARAM = "user_meta_file";

    public NativeCreateReportSpiCall(C6069h hVar, String str, String str2, C6200d dVar) {
        super(hVar, str, str2, dVar, C6199c.POST);
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, String str) {
        httpRequest.mo34341c(C6078a.HEADER_USER_AGENT, C6078a.CRASHLYTICS_USER_AGENT + this.kit.getVersion());
        httpRequest.mo34341c(C6078a.HEADER_CLIENT_TYPE, "android");
        httpRequest.mo34341c(C6078a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        httpRequest.mo34341c(C6078a.HEADER_API_KEY, str);
        return httpRequest;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        httpRequest.mo34348e(REPORT_IDENTIFIER_PARAM, report.getIdentifier());
        for (File file : report.getFiles()) {
            if (file.getName().equals("minidump")) {
                httpRequest.mo34330a(MINIDUMP_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            } else if (file.getName().equals("metadata")) {
                httpRequest.mo34330a(METADATA_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            } else if (file.getName().equals("binaryImages")) {
                httpRequest.mo34330a(BINARY_IMAGES_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            } else if (file.getName().equals("session")) {
                httpRequest.mo34330a(SESSION_META_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            } else if (file.getName().equals(TapjoyConstants.TJC_APP_PLACEMENT)) {
                httpRequest.mo34330a(APP_META_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            } else if (file.getName().equals(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX)) {
                httpRequest.mo34330a(DEVICE_META_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            } else if (file.getName().equals("os")) {
                httpRequest.mo34330a(OS_META_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            } else if (file.getName().equals(QumparaOfferwallUtil.TABLE_NAME)) {
                httpRequest.mo34330a(USER_META_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            } else if (file.getName().equals("logs")) {
                httpRequest.mo34330a(LOGS_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            } else if (file.getName().equals("keys")) {
                httpRequest.mo34330a(KEYS_FILE_MULTIPART_PARAM, file.getName(), GZIP_FILE_CONTENT_TYPE, file);
            }
        }
        return httpRequest;
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        HttpRequest applyMultipartDataTo = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createReportRequest.apiKey), createReportRequest.report);
        C6072k f = C6059c.m19630f();
        f.mo34093d(CrashlyticsCore.TAG, "Sending report to: " + getUrl());
        int g = applyMultipartDataTo.mo34351g();
        C6072k f2 = C6059c.m19630f();
        f2.mo34093d(CrashlyticsCore.TAG, "Result was: " + g);
        return C6116v.m19833a(g) == 0;
    }
}
