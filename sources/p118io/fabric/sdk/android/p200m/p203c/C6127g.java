package p118io.fabric.sdk.android.p200m.p203c;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: io.fabric.sdk.android.m.c.g */
/* compiled from: GZIPQueueFileEventStorage */
public class C6127g extends C6128h {
    public C6127g(Context context, File file, String str, String str2) throws IOException {
        super(context, file, str, str2);
    }

    /* renamed from: a */
    public OutputStream mo34237a(File file) throws IOException {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
