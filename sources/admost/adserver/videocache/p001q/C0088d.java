package admost.adserver.videocache.p001q;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: admost.adserver.videocache.q.d */
/* compiled from: Files */
class C0088d {

    /* renamed from: admost.adserver.videocache.q.d$b */
    /* compiled from: Files */
    private static final class C0090b implements Comparator<File> {
        private C0090b() {
        }

        /* renamed from: a */
        private int m273a(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return m273a(file.lastModified(), file2.lastModified());
        }
    }

    /* renamed from: a */
    static List<File> m268a(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new C0090b());
        return asList;
    }

    /* renamed from: b */
    static void m269b(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", new Object[]{file.getAbsolutePath()}));
        }
    }

    /* renamed from: c */
    static void m270c(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            m271d(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    /* renamed from: d */
    private static void m271d(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }

    /* renamed from: e */
    static void m272e(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                m270c(file);
                if (file.lastModified() < currentTimeMillis) {
                    Log.w("ADMOST-VIDEO", "file.lastModified() < now . Path: " + file.getAbsolutePath());
                }
            }
        }
    }
}
