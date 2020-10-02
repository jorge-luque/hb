package admost.adserver.videocache.p001q;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: admost.adserver.videocache.q.e */
/* compiled from: LruDiskUsage */
public abstract class C0091e implements C0085a {

    /* renamed from: a */
    private final ExecutorService f238a = Executors.newSingleThreadExecutor();

    /* renamed from: admost.adserver.videocache.q.e$a */
    /* compiled from: LruDiskUsage */
    private class C0092a implements Callable<Void> {

        /* renamed from: a */
        private final File f239a;

        public C0092a(File file) {
            this.f239a = file;
        }

        public Void call() throws Exception {
            C0091e.this.m277b(this.f239a);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m277b(File file) throws IOException {
        C0088d.m272e(file);
        m278b(C0088d.m268a(file.getParentFile()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo153a(File file, long j, int i);

    /* renamed from: a */
    public void mo149a(File file) throws IOException {
        this.f238a.submit(new C0092a(file));
    }

    /* renamed from: a */
    private long m275a(List<File> list) {
        long j = 0;
        for (File length : list) {
            j += length.length();
        }
        return j;
    }

    /* renamed from: b */
    private void m278b(List<File> list) {
        long a = m275a(list);
        int size = list.size();
        for (File next : list) {
            if (!mo153a(next, a, size)) {
                long length = next.length();
                if (next.delete()) {
                    size--;
                    a -= length;
                    "Cache file " + next + " is deleted because it exceeds cache limit";
                } else {
                    Log.w("ADMOST-VIDEO", "Error deleting file " + next + " for trimming cache");
                }
            }
        }
    }
}
