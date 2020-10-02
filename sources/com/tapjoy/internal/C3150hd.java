package com.tapjoy.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hd */
public final class C3150hd {

    /* renamed from: a */
    private final File f8787a;

    public C3150hd(File file) {
        this.f8787a = file;
    }

    /* renamed from: a */
    public final synchronized boolean mo18596a() {
        FileOutputStream fileOutputStream;
        if (mo18597b() != null) {
            return false;
        }
        try {
            File file = this.f8787a;
            String uuid = UUID.randomUUID().toString();
            fileOutputStream = new FileOutputStream(file);
            C3124bg.m10226a((OutputStream) fileOutputStream, uuid);
            C3168jz.m10439a(fileOutputStream);
            if (mo18597b() != null) {
                return true;
            }
            return false;
        } catch (IOException e) {
            try {
                this.f8787a.delete();
                throw e;
            } catch (IOException unused) {
                return false;
            }
        } catch (Throwable th) {
            C3168jz.m10439a(fileOutputStream);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public final String mo18597b() {
        if (!this.f8787a.exists()) {
            return null;
        }
        try {
            String a = C3124bg.m10225a(this.f8787a, C4888ak.f13355c);
            if (a.length() > 0) {
                return a;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }
}
