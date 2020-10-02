package com.squareup.picasso;

import android.content.Context;
import com.applovin.sdk.AppLovinEventTypes;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import p119j.C6589n;

class ContentStreamRequestHandler extends RequestHandler {
    final Context context;

    ContentStreamRequestHandler(Context context2) {
        this.context = context2;
    }

    public boolean canHandleRequest(Request request) {
        return AppLovinEventTypes.USER_VIEWED_CONTENT.equals(request.uri.getScheme());
    }

    /* access modifiers changed from: package-private */
    public InputStream getInputStream(Request request) throws FileNotFoundException {
        return this.context.getContentResolver().openInputStream(request.uri);
    }

    public RequestHandler.Result load(Request request, int i) throws IOException {
        return new RequestHandler.Result(C6589n.m21616a(getInputStream(request)), Picasso.LoadedFrom.DISK);
    }
}
