package com.criteo.publisher.advancednative;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.net.URL;

/* renamed from: com.criteo.publisher.advancednative.g */
public class C2364g implements ImageLoader {

    /* renamed from: a */
    private final Picasso f7742a;

    public C2364g(Picasso picasso) {
        this.f7742a = picasso;
    }

    public void loadImageInto(URL url, ImageView imageView, Drawable drawable) {
        this.f7742a.load(url.toString()).placeholder(drawable).into(imageView);
    }

    public void preload(URL url) {
        this.f7742a.load(url.toString()).fetch();
    }
}
