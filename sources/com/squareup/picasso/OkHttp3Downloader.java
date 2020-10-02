package com.squareup.picasso;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import p113i.C3480a0;
import p113i.C3487c;
import p113i.C3497e;
import p113i.C3542v;
import p113i.C3548y;

public final class OkHttp3Downloader implements Downloader {
    private final C3487c cache;
    final C3497e.C3498a client;
    private boolean sharedClient;

    public OkHttp3Downloader(Context context) {
        this(Utils.createDefaultCacheDir(context));
    }

    public C3480a0 load(C3548y yVar) throws IOException {
        return this.client.mo19365a(yVar).execute();
    }

    public void shutdown() {
        C3487c cVar;
        if (!this.sharedClient && (cVar = this.cache) != null) {
            try {
                cVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public OkHttp3Downloader(File file) {
        this(file, Utils.calculateDiskCacheSize(file));
    }

    public OkHttp3Downloader(Context context, long j) {
        this(Utils.createDefaultCacheDir(context), j);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OkHttp3Downloader(java.io.File r3, long r4) {
        /*
            r2 = this;
            i.v$b r0 = new i.v$b
            r0.<init>()
            i.c r1 = new i.c
            r1.<init>(r3, r4)
            r0.mo19582a((p113i.C3487c) r1)
            i.v r3 = r0.mo19585a()
            r2.<init>((p113i.C3542v) r3)
            r3 = 0
            r2.sharedClient = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.OkHttp3Downloader.<init>(java.io.File, long):void");
    }

    public OkHttp3Downloader(C3542v vVar) {
        this.sharedClient = true;
        this.client = vVar;
        this.cache = vVar.mo19556b();
    }

    public OkHttp3Downloader(C3497e.C3498a aVar) {
        this.sharedClient = true;
        this.client = aVar;
        this.cache = null;
    }
}
