package com.crashlytics.android.core;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6089h;

class ReportUploader {
    static final Map<String, String> HEADER_INVALID_CLS_FILE = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    /* access modifiers changed from: private */
    public static final short[] RETRY_INTERVALS = {10, 20, 30, 60, 120, 300};
    private final String apiKey;
    private final CreateReportSpiCall createReportCall;
    private final Object fileAccessLock = new Object();
    /* access modifiers changed from: private */
    public final HandlingExceptionCheck handlingExceptionCheck;
    private final ReportFilesProvider reportFilesProvider;
    /* access modifiers changed from: private */
    public Thread uploadThread;

    static final class AlwaysSendCheck implements SendCheck {
        AlwaysSendCheck() {
        }

        public boolean canSendReports() {
            return true;
        }
    }

    interface HandlingExceptionCheck {
        boolean isHandlingException();
    }

    interface ReportFilesProvider {
        File[] getCompleteSessionFiles();

        File[] getInvalidSessionFiles();

        File[] getNativeReportFiles();
    }

    interface SendCheck {
        boolean canSendReports();
    }

    private class Worker extends C6089h {
        private final float delay;
        private final SendCheck sendCheck;

        Worker(float f, SendCheck sendCheck2) {
            this.delay = f;
            this.sendCheck = sendCheck2;
        }

        private void attemptUploadWithRetry() {
            C6072k f = C6059c.m19630f();
            f.mo34093d(CrashlyticsCore.TAG, "Starting report processing in " + this.delay + " second(s)...");
            float f2 = this.delay;
            if (f2 > 0.0f) {
                try {
                    Thread.sleep((long) (f2 * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<Report> findReports = ReportUploader.this.findReports();
            if (!ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                if (findReports.isEmpty() || this.sendCheck.canSendReports()) {
                    int i = 0;
                    while (!findReports.isEmpty() && !ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                        C6072k f3 = C6059c.m19630f();
                        f3.mo34093d(CrashlyticsCore.TAG, "Attempting to send " + findReports.size() + " report(s)");
                        for (Report forceUpload : findReports) {
                            ReportUploader.this.forceUpload(forceUpload);
                        }
                        findReports = ReportUploader.this.findReports();
                        if (!findReports.isEmpty()) {
                            int i2 = i + 1;
                            long j = (long) ReportUploader.RETRY_INTERVALS[Math.min(i, ReportUploader.RETRY_INTERVALS.length - 1)];
                            C6072k f4 = C6059c.m19630f();
                            f4.mo34093d(CrashlyticsCore.TAG, "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                            } catch (InterruptedException unused2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                C6072k f5 = C6059c.m19630f();
                f5.mo34093d(CrashlyticsCore.TAG, "User declined to send. Removing " + findReports.size() + " Report(s).");
                for (Report remove : findReports) {
                    remove.remove();
                }
            }
        }

        public void onRun() {
            try {
                attemptUploadWithRetry();
            } catch (Exception e) {
                C6059c.m19630f().mo34090b(CrashlyticsCore.TAG, "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            Thread unused = ReportUploader.this.uploadThread = null;
        }
    }

    public ReportUploader(String str, CreateReportSpiCall createReportSpiCall, ReportFilesProvider reportFilesProvider2, HandlingExceptionCheck handlingExceptionCheck2) {
        if (createReportSpiCall != null) {
            this.createReportCall = createReportSpiCall;
            this.apiKey = str;
            this.reportFilesProvider = reportFilesProvider2;
            this.handlingExceptionCheck = handlingExceptionCheck2;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    /* access modifiers changed from: package-private */
    public List<Report> findReports() {
        File[] completeSessionFiles;
        File[] invalidSessionFiles;
        File[] nativeReportFiles;
        C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Checking for crash reports...");
        synchronized (this.fileAccessLock) {
            completeSessionFiles = this.reportFilesProvider.getCompleteSessionFiles();
            invalidSessionFiles = this.reportFilesProvider.getInvalidSessionFiles();
            nativeReportFiles = this.reportFilesProvider.getNativeReportFiles();
        }
        LinkedList linkedList = new LinkedList();
        if (completeSessionFiles != null) {
            for (File file : completeSessionFiles) {
                C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Found crash report " + file.getPath());
                linkedList.add(new SessionReport(file));
            }
        }
        HashMap hashMap = new HashMap();
        if (invalidSessionFiles != null) {
            for (File file2 : invalidSessionFiles) {
                String sessionIdFromSessionFile = CrashlyticsController.getSessionIdFromSessionFile(file2);
                if (!hashMap.containsKey(sessionIdFromSessionFile)) {
                    hashMap.put(sessionIdFromSessionFile, new LinkedList());
                }
                ((List) hashMap.get(sessionIdFromSessionFile)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Found invalid session: " + str);
            List list = (List) hashMap.get(str);
            linkedList.add(new InvalidSessionReport(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (nativeReportFiles != null) {
            for (File nativeSessionReport : nativeReportFiles) {
                linkedList.add(new NativeSessionReport(nativeSessionReport));
            }
        }
        if (linkedList.isEmpty()) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "No reports found.");
        }
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public boolean forceUpload(Report report) {
        boolean z;
        synchronized (this.fileAccessLock) {
            z = false;
            try {
                boolean invoke = this.createReportCall.invoke(new CreateReportRequest(this.apiKey, report));
                C6072k f = C6059c.m19630f();
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics report upload ");
                sb.append(invoke ? "complete: " : "FAILED: ");
                sb.append(report.getIdentifier());
                f.mo34095e(CrashlyticsCore.TAG, sb.toString());
                if (invoke) {
                    report.remove();
                    z = true;
                }
            } catch (Exception e) {
                C6072k f2 = C6059c.m19630f();
                f2.mo34090b(CrashlyticsCore.TAG, "Error occurred sending report " + report, e);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isUploading() {
        return this.uploadThread != null;
    }

    public synchronized void uploadReports(float f, SendCheck sendCheck) {
        if (this.uploadThread != null) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Report upload has already been started.");
            return;
        }
        Thread thread = new Thread(new Worker(f, sendCheck), "Crashlytics Report Uploader");
        this.uploadThread = thread;
        thread.start();
    }
}
