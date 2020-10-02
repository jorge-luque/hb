package com.criteo.publisher.advancednative;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.criteo.publisher.C2433m;
import com.criteo.publisher.p060s.C2508a;
import java.net.URL;

@Keep
public class RendererHelper {
    /* access modifiers changed from: private */
    public final C2365h imageLoaderHolder;
    private final C2508a uiExecutor;

    /* renamed from: com.criteo.publisher.advancednative.RendererHelper$a */
    class C2350a extends C2433m {

        /* renamed from: c */
        final /* synthetic */ URL f7717c;

        C2350a(URL url) {
            this.f7717c = url;
        }

        /* renamed from: a */
        public void mo10204a() throws Throwable {
            RendererHelper.this.imageLoaderHolder.mo10221a().preload(this.f7717c);
        }
    }

    /* renamed from: com.criteo.publisher.advancednative.RendererHelper$b */
    class C2351b extends C2433m {

        /* renamed from: c */
        final /* synthetic */ URL f7719c;

        /* renamed from: d */
        final /* synthetic */ ImageView f7720d;

        /* renamed from: e */
        final /* synthetic */ Drawable f7721e;

        C2351b(URL url, ImageView imageView, Drawable drawable) {
            this.f7719c = url;
            this.f7720d = imageView;
            this.f7721e = drawable;
        }

        /* renamed from: a */
        public void mo10204a() throws Throwable {
            RendererHelper.this.imageLoaderHolder.mo10221a().loadImageInto(this.f7719c, this.f7720d, this.f7721e);
        }
    }

    public RendererHelper(C2365h hVar, C2508a aVar) {
        this.imageLoaderHolder = hVar;
        this.uiExecutor = aVar;
    }

    /* access modifiers changed from: package-private */
    public void preloadMedia(URL url) {
        new C2350a(url).run();
    }

    public void setMediaInView(CriteoMedia criteoMedia, CriteoMediaView criteoMediaView) {
        setMediaInView(criteoMedia.getImageUrl(), criteoMediaView.getImageView(), criteoMediaView.getPlaceholder());
    }

    /* access modifiers changed from: package-private */
    public void setMediaInView(URL url, ImageView imageView, Drawable drawable) {
        this.uiExecutor.execute(new C2351b(url, imageView, drawable));
    }
}
