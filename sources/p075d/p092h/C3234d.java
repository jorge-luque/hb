package p075d.p092h;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* renamed from: d.h.d */
/* compiled from: ZipUtil */
final class C3234d {

    /* renamed from: d.h.d$a */
    /* compiled from: ZipUtil */
    static class C3235a {

        /* renamed from: a */
        long f9011a;

        /* renamed from: b */
        long f9012b;

        C3235a() {
        }
    }

    /* renamed from: a */
    static long m10682a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return m10683a(randomAccessFile, m10684a(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }

    /* renamed from: a */
    static C3235a m10684a(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j = 0;
        if (length >= 0) {
            long j2 = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            if (j2 >= 0) {
                j = j2;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    C3235a aVar = new C3235a();
                    aVar.f9012b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    aVar.f9011a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return aVar;
                }
                length--;
            } while (length >= j);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }

    /* renamed from: a */
    static long m10683a(RandomAccessFile randomAccessFile, C3235a aVar) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = aVar.f9012b;
        randomAccessFile.seek(aVar.f9011a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        }
        return crc32.getValue();
    }
}
