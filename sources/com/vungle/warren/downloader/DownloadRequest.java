package com.vungle.warren.downloader;

import android.text.TextUtils;
import com.vungle.warren.downloader.Downloader;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class DownloadRequest {
    private AtomicBoolean cancelled;
    public final String cookieString;

    /* renamed from: id */
    final String f14485id;
    public final int networkType;
    public final String path;
    public final boolean pauseOnConnectionLost;
    private final AtomicInteger priority;
    public final String url;

    public @interface Priority {
        public static final int CRITICAL = -2147483647;
        public static final int HIGH = 1;
        public static final int HIGHEST = 0;
        public static final int LOWEST = Integer.MAX_VALUE;
    }

    public DownloadRequest(String str, String str2) {
        this(3, 0, str, str2, false, (String) null);
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        this.cancelled.set(true);
    }

    @Priority
    public int getPriority() {
        return this.priority.get();
    }

    /* access modifiers changed from: package-private */
    public boolean isCancelled() {
        return this.cancelled.get();
    }

    public void setPriority(@Priority int i) {
        this.priority.set(i);
    }

    public DownloadRequest(String str, String str2, String str3) {
        this(3, 0, str, str2, false, str3);
    }

    public DownloadRequest(@Downloader.NetworkType int i, @Priority int i2, String str, String str2, boolean z, String str3) {
        this.priority = new AtomicInteger();
        this.cancelled = new AtomicBoolean(false);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Url or path is empty");
        }
        this.networkType = i;
        this.priority.set(i2);
        this.url = str;
        this.path = str2;
        this.f14485id = UUID.nameUUIDFromBytes((str2 + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + str).getBytes()).toString();
        this.pauseOnConnectionLost = z;
        this.cookieString = str3;
    }
}
