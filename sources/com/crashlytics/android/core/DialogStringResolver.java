package com.crashlytics.android.core;

import android.content.Context;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p205e.C6148o;

class DialogStringResolver {
    private static final String PROMPT_MESSAGE_RES_NAME = "com.crashlytics.CrashSubmissionPromptMessage";
    private static final String PROMPT_TITLE_RES_NAME = "com.crashlytics.CrashSubmissionPromptTitle";
    private static final String SUBMISSION_ALWAYS_SEND_RES_NAME = "com.crashlytics.CrashSubmissionAlwaysSendTitle";
    private static final String SUBMISSION_CANCEL_RES_NAME = "com.crashlytics.CrashSubmissionCancelTitle";
    private static final String SUBMISSION_SEND_RES_NAME = "com.crashlytics.CrashSubmissionSendTitle";
    private final Context context;
    private final C6148o promptData;

    public DialogStringResolver(Context context2, C6148o oVar) {
        this.context = context2;
        this.promptData = oVar;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private String resourceOrFallbackValue(String str, String str2) {
        return stringOrFallback(C6090i.m19740b(this.context, str), str2);
    }

    private String stringOrFallback(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    public String getAlwaysSendButtonTitle() {
        return resourceOrFallbackValue(SUBMISSION_ALWAYS_SEND_RES_NAME, this.promptData.f16163g);
    }

    public String getCancelButtonTitle() {
        return resourceOrFallbackValue(SUBMISSION_CANCEL_RES_NAME, this.promptData.f16161e);
    }

    public String getMessage() {
        return resourceOrFallbackValue(PROMPT_MESSAGE_RES_NAME, this.promptData.f16158b);
    }

    public String getSendButtonTitle() {
        return resourceOrFallbackValue(SUBMISSION_SEND_RES_NAME, this.promptData.f16159c);
    }

    public String getTitle() {
        return resourceOrFallbackValue(PROMPT_TITLE_RES_NAME, this.promptData.f16157a);
    }
}
