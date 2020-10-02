package admost.adserver.videocache.p001q;

import admost.adserver.videocache.C0061a;
import admost.adserver.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: admost.adserver.videocache.q.b */
/* compiled from: FileCache */
public class C0086b implements C0061a {

    /* renamed from: a */
    private final C0085a f235a;

    /* renamed from: b */
    public File f236b;

    /* renamed from: c */
    private RandomAccessFile f237c;

    public C0086b(File file, C0085a aVar) throws ProxyCacheException {
        File file2;
        if (aVar != null) {
            try {
                this.f235a = aVar;
                C0088d.m269b(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + ".download");
                }
                this.f236b = file2;
                this.f237c = new RandomAccessFile(this.f236b, exists ? "r" : "rw");
            } catch (IOException e) {
                throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* renamed from: a */
    public synchronized int mo105a(byte[] bArr, long j, int i) throws ProxyCacheException {
        try {
            this.f237c.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)}), e);
        }
        return this.f237c.read(bArr, 0, i);
    }

    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.f236b, e);
        }
        return (long) ((int) this.f237c.length());
    }

    public synchronized void close() throws ProxyCacheException {
        try {
            this.f237c.close();
            this.f235a.mo149a(this.f236b);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.f236b, e);
        }
    }

    public synchronized void complete() throws ProxyCacheException {
        if (!mo107a()) {
            close();
            File file = new File(this.f236b.getParentFile(), this.f236b.getName().substring(0, this.f236b.getName().length() - 9));
            if (this.f236b.renameTo(file)) {
                this.f236b = file;
                try {
                    this.f237c = new RandomAccessFile(this.f236b, "r");
                    this.f235a.mo149a(this.f236b);
                } catch (IOException e) {
                    throw new ProxyCacheException("Error opening " + this.f236b + " as disc cache", e);
                }
            } else {
                throw new ProxyCacheException("Error renaming file " + this.f236b + " to " + file + " for completion!");
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo106a(byte[] bArr, int i) throws ProxyCacheException {
        try {
            if (!mo107a()) {
                this.f237c.seek(available());
                this.f237c.write(bArr, 0, i);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.f236b + " is completed!");
            }
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.f237c, Integer.valueOf(bArr.length)}), e);
        }
    }

    /* renamed from: a */
    public synchronized boolean mo107a() {
        return !m263a(this.f236b);
    }

    /* renamed from: a */
    private boolean m263a(File file) {
        return file.getName().endsWith(".download");
    }
}
