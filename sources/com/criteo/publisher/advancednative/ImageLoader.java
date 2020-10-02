package com.criteo.publisher.advancednative;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Keep;
import java.net.URL;

@Keep
public interface ImageLoader {
    void loadImageInto(URL url, ImageView imageView, Drawable drawable) throws Exception;

    void preload(URL url) throws Exception;
}
