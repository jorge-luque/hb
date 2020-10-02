package com.crashlytics.android.core;

import com.loopj.android.http.C4250c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p202b.C6111u;

class QueueFileLogStore implements FileLogStore {
    private C6111u logFile;
    private final int maxLogSize;
    private final File workingFile;

    public class LogBytes {
        public final byte[] bytes;
        public final int offset;

        public LogBytes(byte[] bArr, int i) {
            this.bytes = bArr;
            this.offset = i;
        }
    }

    public QueueFileLogStore(File file, int i) {
        this.workingFile = file;
        this.maxLogSize = i;
    }

    private void doWriteToLog(long j, String str) {
        if (this.logFile != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i = this.maxLogSize / 4;
                if (str.length() > i) {
                    str = "..." + str.substring(str.length() - i);
                }
                this.logFile.mo34203a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")}).getBytes(C4250c.DEFAULT_CHARSET));
                while (!this.logFile.mo34208t() && this.logFile.mo34211v() > this.maxLogSize) {
                    this.logFile.mo34210u();
                }
            } catch (IOException e) {
                C6059c.m19630f().mo34090b(CrashlyticsCore.TAG, "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }

    private LogBytes getLogBytes() {
        if (!this.workingFile.exists()) {
            return null;
        }
        openLogFile();
        C6111u uVar = this.logFile;
        if (uVar == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[uVar.mo34211v()];
        try {
            this.logFile.mo34202a((C6111u.C6115d) new C6111u.C6115d() {
                public void read(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e) {
            C6059c.m19630f().mo34090b(CrashlyticsCore.TAG, "A problem occurred while reading the Crashlytics log file.", e);
        }
        return new LogBytes(bArr, iArr[0]);
    }

    private void openLogFile() {
        if (this.logFile == null) {
            try {
                this.logFile = new C6111u(this.workingFile);
            } catch (IOException e) {
                C6072k f = C6059c.m19630f();
                f.mo34090b(CrashlyticsCore.TAG, "Could not open log file: " + this.workingFile, e);
            }
        }
    }

    public void closeLogFile() {
        C6090i.m19733a((Closeable) this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = null;
    }

    public void deleteLogFile() {
        closeLogFile();
        this.workingFile.delete();
    }

    public ByteString getLogAsByteString() {
        LogBytes logBytes = getLogBytes();
        if (logBytes == null) {
            return null;
        }
        return ByteString.copyFrom(logBytes.bytes, 0, logBytes.offset);
    }

    public byte[] getLogAsBytes() {
        LogBytes logBytes = getLogBytes();
        if (logBytes == null) {
            return null;
        }
        return logBytes.bytes;
    }

    public void writeToLog(long j, String str) {
        openLogFile();
        doWriteToLog(j, str);
    }
}
