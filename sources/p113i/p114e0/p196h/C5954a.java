package p113i.p114e0.p196h;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import p119j.C3585t;
import p119j.C3586u;
import p119j.C6589n;

/* renamed from: i.e0.h.a */
/* compiled from: FileSystem */
public interface C5954a {

    /* renamed from: a */
    public static final C5954a f15224a = new C5955a();

    /* renamed from: i.e0.h.a$a */
    /* compiled from: FileSystem */
    class C5955a implements C5954a {
        C5955a() {
        }

        /* renamed from: a */
        public C3586u mo33753a(File file) throws FileNotFoundException {
            return C6589n.m21622c(file);
        }

        /* renamed from: b */
        public C3585t mo33755b(File file) throws FileNotFoundException {
            try {
                return C6589n.m21619b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return C6589n.m21619b(file);
            }
        }

        /* renamed from: c */
        public boolean mo33756c(File file) {
            return file.exists();
        }

        /* renamed from: d */
        public void mo33757d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (file2.delete()) {
                        i++;
                    } else {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }

        /* renamed from: e */
        public C3585t mo33759e(File file) throws FileNotFoundException {
            try {
                return C6589n.m21612a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return C6589n.m21612a(file);
            }
        }

        /* renamed from: f */
        public long mo33760f(File file) {
            return file.length();
        }

        /* renamed from: a */
        public void mo33754a(File file, File file2) throws IOException {
            mo33757d(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }
    }

    /* renamed from: a */
    C3586u mo33753a(File file) throws FileNotFoundException;

    /* renamed from: a */
    void mo33754a(File file, File file2) throws IOException;

    /* renamed from: b */
    C3585t mo33755b(File file) throws FileNotFoundException;

    /* renamed from: c */
    boolean mo33756c(File file);

    /* renamed from: d */
    void mo33757d(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    /* renamed from: e */
    C3585t mo33759e(File file) throws FileNotFoundException;

    /* renamed from: f */
    long mo33760f(File file);
}
