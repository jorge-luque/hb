package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import p075d.p083d.p084a.C3208a;
import p119j.C6589n;

class FileRequestHandler extends ContentStreamRequestHandler {
    FileRequestHandler(Context context) {
        super(context);
    }

    static int getFileExifRotation(Uri uri) throws IOException {
        return new C3208a(uri.getPath()).mo18836a("Orientation", 1);
    }

    public boolean canHandleRequest(Request request) {
        return "file".equals(request.uri.getScheme());
    }

    public RequestHandler.Result load(Request request, int i) throws IOException {
        return new RequestHandler.Result((Bitmap) null, C6589n.m21616a(getInputStream(request)), Picasso.LoadedFrom.DISK, getFileExifRotation(request.uri));
    }
}
