package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3495d;
import p113i.C3548y;
import p119j.C3586u;

class NetworkRequestHandler extends RequestHandler {
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private final Downloader downloader;
    private final Stats stats;

    static class ContentLengthException extends IOException {
        ContentLengthException(String str) {
            super(str);
        }
    }

    static final class ResponseException extends IOException {
        final int code;
        final int networkPolicy;

        ResponseException(int i, int i2) {
            super("HTTP " + i);
            this.code = i;
            this.networkPolicy = i2;
        }
    }

    NetworkRequestHandler(Downloader downloader2, Stats stats2) {
        this.downloader = downloader2;
        this.stats = stats2;
    }

    private static C3548y createRequest(Request request, int i) {
        C3495d dVar;
        if (i == 0) {
            dVar = null;
        } else if (NetworkPolicy.isOfflineOnly(i)) {
            dVar = C3495d.f9678n;
        } else {
            C3495d.C3496a aVar = new C3495d.C3496a();
            if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                aVar.mo19359b();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                aVar.mo19360c();
            }
            dVar = aVar.mo19358a();
        }
        C3548y.C3549a aVar2 = new C3548y.C3549a();
        aVar2.mo19618b(request.uri.toString());
        if (dVar != null) {
            aVar2.mo19609a(dVar);
        }
        return aVar2.mo19616a();
    }

    public boolean canHandleRequest(Request request) {
        String scheme = request.uri.getScheme();
        return SCHEME_HTTP.equals(scheme) || SCHEME_HTTPS.equals(scheme);
    }

    /* access modifiers changed from: package-private */
    public int getRetryCount() {
        return 2;
    }

    public RequestHandler.Result load(Request request, int i) throws IOException {
        C3480a0 load = this.downloader.load(createRequest(request, i));
        C3484b0 d = load.mo19284d();
        if (load.mo19291y()) {
            Picasso.LoadedFrom loadedFrom = load.mo19287u() == null ? Picasso.LoadedFrom.NETWORK : Picasso.LoadedFrom.DISK;
            if (loadedFrom == Picasso.LoadedFrom.DISK && d.contentLength() == 0) {
                d.close();
                throw new ContentLengthException("Received response with 0 content-length header.");
            }
            if (loadedFrom == Picasso.LoadedFrom.NETWORK && d.contentLength() > 0) {
                this.stats.dispatchDownloadFinished(d.contentLength());
            }
            return new RequestHandler.Result((C3586u) d.source(), loadedFrom);
        }
        d.close();
        throw new ResponseException(load.mo19288v(), request.networkPolicy);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    /* access modifiers changed from: package-private */
    public boolean supportsReplay() {
        return true;
    }
}
