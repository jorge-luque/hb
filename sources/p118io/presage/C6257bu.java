package p118io.presage;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.webkit.DownloadListener;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.vungle.warren.p074ui.JavascriptBridge;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* renamed from: io.presage.bu */
public final class C6257bu implements DownloadListener {

    /* renamed from: a */
    private final Context f16860a;

    public C6257bu(Context context) {
        this.f16860a = context;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String str5;
        if (C6214ae.m20773a(this.f16860a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Uri parse = Uri.parse(str);
            C6514hl.m21414a((Object) parse, ShareConstants.MEDIA_URI);
            String path = parse.getPath();
            List<String> b = path != null ? new C6550iu("/").mo35562b(path) : null;
            if (b == null || !(!b.isEmpty())) {
                str5 = UUID.randomUUID().toString();
                C6514hl.m21414a((Object) str5, "UUID.randomUUID().toString()");
            } else {
                str5 = (String) C6456fh.m21338b(b);
            }
            DownloadManager.Request request = new DownloadManager.Request(parse);
            request.setTitle(str5);
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, JavascriptBridge.MraidHandler.DOWNLOAD_ACTION);
            Object systemService = this.f16860a.getSystemService(JavascriptBridge.MraidHandler.DOWNLOAD_ACTION);
            if (systemService != null) {
                ((DownloadManager) systemService).enqueue(request);
                Context context = this.f16860a;
                C6518hp hpVar = C6518hp.f17054a;
                String format = String.format("Start downloading %s", Arrays.copyOf(new Object[]{str5}, 1));
                C6514hl.m21414a((Object) format, "java.lang.String.format(format, *args)");
                Toast.makeText(context, format, 0).show();
                return;
            }
            throw new C6434em("null cannot be cast to non-null type android.app.DownloadManager");
        }
    }
}
