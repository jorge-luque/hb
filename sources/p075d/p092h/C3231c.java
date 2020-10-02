package p075d.p092h;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* renamed from: d.h.c */
/* compiled from: MultiDexExtractor */
final class C3231c implements Closeable {

    /* renamed from: a */
    private final File f9003a;

    /* renamed from: b */
    private final long f9004b;

    /* renamed from: c */
    private final File f9005c;

    /* renamed from: d */
    private final RandomAccessFile f9006d;

    /* renamed from: e */
    private final FileChannel f9007e;

    /* renamed from: f */
    private final FileLock f9008f;

    /* renamed from: d.h.c$a */
    /* compiled from: MultiDexExtractor */
    class C3232a implements FileFilter {
        C3232a() {
        }

        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* renamed from: d.h.c$b */
    /* compiled from: MultiDexExtractor */
    private static class C3233b extends File {

        /* renamed from: a */
        public long f9010a = -1;

        public C3233b(File file, String str) {
            super(file, str);
        }
    }

    C3231c(File file, File file2) throws IOException {
        "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")";
        this.f9003a = file;
        this.f9005c = file2;
        this.f9004b = m10678b(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f9006d = randomAccessFile;
        try {
            this.f9007e = randomAccessFile.getChannel();
            try {
                "Blocking on lock " + file3.getPath();
                this.f9008f = this.f9007e.lock();
                file3.getPath() + " locked";
            } catch (IOException e) {
                e = e;
                m10675a((Closeable) this.f9007e);
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                m10675a((Closeable) this.f9007e);
                throw e;
            } catch (Error e3) {
                e = e3;
                m10675a((Closeable) this.f9007e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            m10675a((Closeable) this.f9006d);
            throw e4;
        }
    }

    /* renamed from: b */
    private static long m10678b(File file) throws IOException {
        long a = C3234d.m10682a(file);
        return a == -1 ? a - 1 : a;
    }

    /* renamed from: d */
    private void m10679d() {
        File[] listFiles = this.f9005c.listFiles(new C3232a());
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f9005c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            "Trying to delete old file " + file.getPath() + " of size " + file.length();
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                "Deleted old file " + file.getPath();
            }
        }
    }

    /* renamed from: t */
    private List<C3233b> m10680t() throws IOException {
        C3233b bVar;
        boolean z;
        String str = this.f9003a.getName() + ".classes";
        m10679d();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f9003a);
        try {
            ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
            int i = 2;
            while (entry != null) {
                bVar = new C3233b(this.f9005c, str + i + ".zip");
                arrayList.add(bVar);
                "Extraction is needed for file " + bVar;
                int i2 = 0;
                boolean z2 = false;
                while (i2 < 3 && !z2) {
                    int i3 = i2 + 1;
                    m10676a(zipFile, entry, (File) bVar, str);
                    bVar.f9010a = m10678b(bVar);
                    z = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                    sb.append(" '");
                    sb.append(bVar.getAbsolutePath());
                    sb.append("': length ");
                    int i4 = i3;
                    sb.append(bVar.length());
                    sb.append(" - crc: ");
                    sb.append(bVar.f9010a);
                    sb.toString();
                    if (!z) {
                        bVar.delete();
                        if (bVar.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + bVar.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i2 = i4;
                }
                if (z2) {
                    i++;
                    entry = zipFile.getEntry("classes" + i + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + bVar.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to close resource", e);
            }
            return arrayList;
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to read crc from " + bVar.getAbsolutePath(), e2);
            z = false;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<? extends File> mo18877a(Context context, String str, boolean z) throws IOException {
        List<C3233b> list;
        "MultiDexExtractor.load(" + this.f9003a.getPath() + ", " + z + ", " + str + ")";
        if (this.f9008f.isValid()) {
            if (z || m10677a(context, this.f9003a, this.f9004b, str)) {
                list = m10680t();
                m10674a(context, str, m10671a(this.f9003a), this.f9004b, list);
            } else {
                try {
                    list = m10673a(context, str);
                } catch (IOException e) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                    list = m10680t();
                    m10674a(context, str, m10671a(this.f9003a), this.f9004b, list);
                }
            }
            "load found " + list.size() + " secondary dex files";
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public void close() throws IOException {
        this.f9008f.release();
        this.f9007e.close();
        this.f9006d.close();
    }

    /* renamed from: a */
    private List<C3233b> m10673a(Context context, String str) throws IOException {
        String str2 = str;
        String str3 = this.f9003a.getName() + ".classes";
        SharedPreferences a = m10672a(context);
        int i = a.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            C3233b bVar = new C3233b(this.f9005c, str3 + i2 + ".zip");
            if (bVar.isFile()) {
                bVar.f9010a = m10678b(bVar);
                long j = a.getLong(str2 + "dex.crc." + i2, -1);
                long j2 = a.getLong(str2 + "dex.time." + i2, -1);
                long lastModified = bVar.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = a;
                    if (j == bVar.f9010a) {
                        arrayList.add(bVar);
                        i2++;
                        a = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + bVar + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + bVar.f9010a);
            }
            throw new IOException("Missing extracted secondary dex file '" + bVar.getPath() + "'");
        }
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m10677a(Context context, File file, long j, String str) {
        SharedPreferences a = m10672a(context);
        if (a.getLong(str + "timestamp", -1) == m10671a(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("crc");
            return a.getLong(sb.toString(), -1) != j;
        }
    }

    /* renamed from: a */
    private static long m10671a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* renamed from: a */
    private static void m10674a(Context context, String str, long j, long j2, List<C3233b> list) {
        SharedPreferences.Editor edit = m10672a(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (C3233b next : list) {
            edit.putLong(str + "dex.crc." + i, next.f9010a);
            edit.putLong(str + "dex.time." + i, next.lastModified());
            i++;
        }
        edit.commit();
    }

    /* renamed from: a */
    private static SharedPreferences m10672a(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    /* renamed from: a */
    private static void m10676a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        "Extracting " + createTempFile.getPath();
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                "Renaming to " + file.getPath();
                if (createTempFile.renameTo(file)) {
                    m10675a((Closeable) inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            m10675a((Closeable) inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m10675a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }
}
