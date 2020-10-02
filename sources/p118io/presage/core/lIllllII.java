package p118io.presage.core;

import java.io.File;

/* renamed from: io.presage.core.lIllllII */
public class lIllllII implements Comparable<lIllllII> {
    public File IIIIIIII;
    public String IIIIIIIl;
    public long IIIIIIlI;
    public long IIIIIIll;

    public lIllllII(File file) {
        String name = file.getName();
        long length = file.length();
        long lastModified = file.lastModified();
        this.IIIIIIII = file;
        this.IIIIIIIl = name;
        this.IIIIIIlI = length;
        this.IIIIIIll = lastModified;
    }

    public lIllllII(File file, String str, long j, long j2) {
        this.IIIIIIII = file;
        this.IIIIIIIl = str;
        this.IIIIIIlI = j;
        this.IIIIIIll = j2;
    }

    public int compareTo(Object obj) {
        lIllllII lillllii = (lIllllII) obj;
        if (lillllii != null) {
            int i = (this.IIIIIIll > lillllii.IIIIIIll ? 1 : (this.IIIIIIll == lillllii.IIIIIIll ? 0 : -1));
            int i2 = i < 0 ? -1 : i == 0 ? 0 : 1;
            return i2 == 0 ? this.IIIIIIII.compareTo(lillllii.IIIIIIII) : i2;
        }
        throw null;
    }

    public boolean equals(Object obj) {
        lIllllII lillllii;
        File file;
        File file2;
        if (!(obj instanceof lIllllII) || (lillllii = (lIllllII) obj) == null || (file = lillllii.IIIIIIII) == null || (file2 = this.IIIIIIII) == null) {
            return false;
        }
        return file2.equals(file);
    }

    public lIllllII(File file, long j, long j2) {
        String name = file.getName();
        this.IIIIIIII = file;
        this.IIIIIIIl = name;
        this.IIIIIIlI = j;
        this.IIIIIIll = j2;
    }
}
