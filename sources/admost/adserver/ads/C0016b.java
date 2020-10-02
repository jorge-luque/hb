package admost.adserver.ads;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Hashtable;
import p030c.p031a.p032a.C1178a;

/* renamed from: admost.adserver.ads.b */
/* compiled from: AdMostNativeAd */
public interface C0016b {
    /* renamed from: a */
    void mo31a(Context context, String str, Hashtable<String, Object> hashtable, int i, String str2, C1178a aVar);

    /* renamed from: a */
    void mo32a(View view);

    /* renamed from: a */
    void mo33a(ImageView imageView);

    /* renamed from: a */
    void mo34a(TextView textView);

    /* renamed from: a */
    void mo35a(int[] iArr);

    /* renamed from: b */
    C0023e mo36b(View view);

    /* renamed from: b */
    void mo37b(ImageView imageView);

    /* renamed from: b */
    void mo38b(TextView textView);

    /* renamed from: c */
    void mo39c(TextView textView);

    void destroy();

    C0017c getData();

    void pause();

    void resume();
}
