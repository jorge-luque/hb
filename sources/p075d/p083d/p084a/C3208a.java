package p075d.p083d.p084a;

import admost.sdk.base.AdMost;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* renamed from: d.d.a.a */
/* compiled from: ExifInterface */
public class C3208a {

    /* renamed from: A */
    private static final C3211c f8923A = new C3211c("StripOffsets", 273, 3);

    /* renamed from: B */
    private static final C3211c[] f8924B = {new C3211c("ThumbnailImage", 256, 7), new C3211c("CameraSettingsIFDPointer", 8224, 4), new C3211c("ImageProcessingIFDPointer", 8256, 4)};

    /* renamed from: C */
    private static final C3211c[] f8925C = {new C3211c("PreviewImageStart", 257, 4), new C3211c("PreviewImageLength", 258, 4)};

    /* renamed from: D */
    private static final C3211c[] f8926D = {new C3211c("AspectFrame", 4371, 3)};

    /* renamed from: E */
    private static final C3211c[] f8927E;

    /* renamed from: F */
    static final C3211c[][] f8928F;

    /* renamed from: G */
    private static final C3211c[] f8929G = {new C3211c("SubIFDPointer", 330, 4), new C3211c("ExifIFDPointer", 34665, 4), new C3211c("GPSInfoIFDPointer", 34853, 4), new C3211c("InteroperabilityIFDPointer", 40965, 4), new C3211c("CameraSettingsIFDPointer", 8224, 1), new C3211c("ImageProcessingIFDPointer", 8256, 1)};

    /* renamed from: H */
    private static final HashMap<Integer, C3211c>[] f8930H;

    /* renamed from: I */
    private static final HashMap<String, C3211c>[] f8931I;

    /* renamed from: J */
    private static final HashSet<String> f8932J = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));

    /* renamed from: K */
    private static final HashMap<Integer, Integer> f8933K = new HashMap<>();

    /* renamed from: L */
    static final Charset f8934L;

    /* renamed from: M */
    static final byte[] f8935M;

    /* renamed from: m */
    public static final int[] f8936m = {8, 8, 8};

    /* renamed from: n */
    public static final int[] f8937n = {8};

    /* renamed from: o */
    static final byte[] f8938o = {-1, -40, -1};

    /* renamed from: p */
    private static final byte[] f8939p = {79, 76, 89, 77, 80, 0};

    /* renamed from: q */
    private static final byte[] f8940q = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: r */
    private static SimpleDateFormat f8941r;

    /* renamed from: s */
    static final String[] f8942s = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* renamed from: t */
    static final int[] f8943t = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: u */
    static final byte[] f8944u = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: v */
    private static final C3211c[] f8945v = {new C3211c("NewSubfileType", 254, 4), new C3211c("SubfileType", 255, 4), new C3211c("ImageWidth", 256, 3, 4), new C3211c("ImageLength", 257, 3, 4), new C3211c("BitsPerSample", 258, 3), new C3211c("Compression", 259, 3), new C3211c("PhotometricInterpretation", 262, 3), new C3211c("ImageDescription", 270, 2), new C3211c("Make", 271, 2), new C3211c("Model", 272, 2), new C3211c("StripOffsets", 273, 3, 4), new C3211c("Orientation", 274, 3), new C3211c("SamplesPerPixel", 277, 3), new C3211c("RowsPerStrip", 278, 3, 4), new C3211c("StripByteCounts", 279, 3, 4), new C3211c("XResolution", 282, 5), new C3211c("YResolution", 283, 5), new C3211c("PlanarConfiguration", 284, 3), new C3211c("ResolutionUnit", 296, 3), new C3211c("TransferFunction", AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN, 3), new C3211c("Software", AdMost.AD_ERROR_FAILED_TO_SHOW, 2), new C3211c("DateTime", 306, 2), new C3211c("Artist", 315, 2), new C3211c("WhitePoint", 318, 5), new C3211c("PrimaryChromaticities", 319, 5), new C3211c("SubIFDPointer", 330, 4), new C3211c("JPEGInterchangeFormat", 513, 4), new C3211c("JPEGInterchangeFormatLength", 514, 4), new C3211c("YCbCrCoefficients", 529, 5), new C3211c("YCbCrSubSampling", 530, 3), new C3211c("YCbCrPositioning", 531, 3), new C3211c("ReferenceBlackWhite", 532, 5), new C3211c("Copyright", 33432, 2), new C3211c("ExifIFDPointer", 34665, 4), new C3211c("GPSInfoIFDPointer", 34853, 4), new C3211c("SensorTopBorder", 4, 4), new C3211c("SensorLeftBorder", 5, 4), new C3211c("SensorBottomBorder", 6, 4), new C3211c("SensorRightBorder", 7, 4), new C3211c("ISO", 23, 3), new C3211c("JpgFromRaw", 46, 7)};

    /* renamed from: w */
    private static final C3211c[] f8946w = {new C3211c("ExposureTime", 33434, 5), new C3211c("FNumber", 33437, 5), new C3211c("ExposureProgram", 34850, 3), new C3211c("SpectralSensitivity", 34852, 2), new C3211c("PhotographicSensitivity", 34855, 3), new C3211c("OECF", 34856, 7), new C3211c("ExifVersion", 36864, 2), new C3211c("DateTimeOriginal", 36867, 2), new C3211c("DateTimeDigitized", 36868, 2), new C3211c("ComponentsConfiguration", 37121, 7), new C3211c("CompressedBitsPerPixel", 37122, 5), new C3211c("ShutterSpeedValue", 37377, 10), new C3211c("ApertureValue", 37378, 5), new C3211c("BrightnessValue", 37379, 10), new C3211c("ExposureBiasValue", 37380, 10), new C3211c("MaxApertureValue", 37381, 5), new C3211c("SubjectDistance", 37382, 5), new C3211c("MeteringMode", 37383, 3), new C3211c("LightSource", 37384, 3), new C3211c("Flash", 37385, 3), new C3211c("FocalLength", 37386, 5), new C3211c("SubjectArea", 37396, 3), new C3211c("MakerNote", 37500, 7), new C3211c("UserComment", 37510, 7), new C3211c("SubSecTime", 37520, 2), new C3211c("SubSecTimeOriginal", 37521, 2), new C3211c("SubSecTimeDigitized", 37522, 2), new C3211c("FlashpixVersion", 40960, 7), new C3211c("ColorSpace", 40961, 3), new C3211c("PixelXDimension", 40962, 3, 4), new C3211c("PixelYDimension", 40963, 3, 4), new C3211c("RelatedSoundFile", 40964, 2), new C3211c("InteroperabilityIFDPointer", 40965, 4), new C3211c("FlashEnergy", 41483, 5), new C3211c("SpatialFrequencyResponse", 41484, 7), new C3211c("FocalPlaneXResolution", 41486, 5), new C3211c("FocalPlaneYResolution", 41487, 5), new C3211c("FocalPlaneResolutionUnit", 41488, 3), new C3211c("SubjectLocation", 41492, 3), new C3211c("ExposureIndex", 41493, 5), new C3211c("SensingMethod", 41495, 3), new C3211c("FileSource", 41728, 7), new C3211c("SceneType", 41729, 7), new C3211c("CFAPattern", 41730, 7), new C3211c("CustomRendered", 41985, 3), new C3211c("ExposureMode", 41986, 3), new C3211c("WhiteBalance", 41987, 3), new C3211c("DigitalZoomRatio", 41988, 5), new C3211c("FocalLengthIn35mmFilm", 41989, 3), new C3211c("SceneCaptureType", 41990, 3), new C3211c("GainControl", 41991, 3), new C3211c("Contrast", 41992, 3), new C3211c("Saturation", 41993, 3), new C3211c("Sharpness", 41994, 3), new C3211c("DeviceSettingDescription", 41995, 7), new C3211c("SubjectDistanceRange", 41996, 3), new C3211c("ImageUniqueID", 42016, 2), new C3211c("DNGVersion", 50706, 1), new C3211c("DefaultCropSize", 50720, 3, 4)};

    /* renamed from: x */
    private static final C3211c[] f8947x = {new C3211c("GPSVersionID", 0, 1), new C3211c("GPSLatitudeRef", 1, 2), new C3211c("GPSLatitude", 2, 5), new C3211c("GPSLongitudeRef", 3, 2), new C3211c("GPSLongitude", 4, 5), new C3211c("GPSAltitudeRef", 5, 1), new C3211c("GPSAltitude", 6, 5), new C3211c("GPSTimeStamp", 7, 5), new C3211c("GPSSatellites", 8, 2), new C3211c("GPSStatus", 9, 2), new C3211c("GPSMeasureMode", 10, 2), new C3211c("GPSDOP", 11, 5), new C3211c("GPSSpeedRef", 12, 2), new C3211c("GPSSpeed", 13, 5), new C3211c("GPSTrackRef", 14, 2), new C3211c("GPSTrack", 15, 5), new C3211c("GPSImgDirectionRef", 16, 2), new C3211c("GPSImgDirection", 17, 5), new C3211c("GPSMapDatum", 18, 2), new C3211c("GPSDestLatitudeRef", 19, 2), new C3211c("GPSDestLatitude", 20, 5), new C3211c("GPSDestLongitudeRef", 21, 2), new C3211c("GPSDestLongitude", 22, 5), new C3211c("GPSDestBearingRef", 23, 2), new C3211c("GPSDestBearing", 24, 5), new C3211c("GPSDestDistanceRef", 25, 2), new C3211c("GPSDestDistance", 26, 5), new C3211c("GPSProcessingMethod", 27, 7), new C3211c("GPSAreaInformation", 28, 7), new C3211c("GPSDateStamp", 29, 2), new C3211c("GPSDifferential", 30, 3)};

    /* renamed from: y */
    private static final C3211c[] f8948y = {new C3211c("InteroperabilityIndex", 1, 2)};

    /* renamed from: z */
    private static final C3211c[] f8949z = {new C3211c("NewSubfileType", 254, 4), new C3211c("SubfileType", 255, 4), new C3211c("ThumbnailImageWidth", 256, 3, 4), new C3211c("ThumbnailImageLength", 257, 3, 4), new C3211c("BitsPerSample", 258, 3), new C3211c("Compression", 259, 3), new C3211c("PhotometricInterpretation", 262, 3), new C3211c("ImageDescription", 270, 2), new C3211c("Make", 271, 2), new C3211c("Model", 272, 2), new C3211c("StripOffsets", 273, 3, 4), new C3211c("Orientation", 274, 3), new C3211c("SamplesPerPixel", 277, 3), new C3211c("RowsPerStrip", 278, 3, 4), new C3211c("StripByteCounts", 279, 3, 4), new C3211c("XResolution", 282, 5), new C3211c("YResolution", 283, 5), new C3211c("PlanarConfiguration", 284, 3), new C3211c("ResolutionUnit", 296, 3), new C3211c("TransferFunction", AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN, 3), new C3211c("Software", AdMost.AD_ERROR_FAILED_TO_SHOW, 2), new C3211c("DateTime", 306, 2), new C3211c("Artist", 315, 2), new C3211c("WhitePoint", 318, 5), new C3211c("PrimaryChromaticities", 319, 5), new C3211c("SubIFDPointer", 330, 4), new C3211c("JPEGInterchangeFormat", 513, 4), new C3211c("JPEGInterchangeFormatLength", 514, 4), new C3211c("YCbCrCoefficients", 529, 5), new C3211c("YCbCrSubSampling", 530, 3), new C3211c("YCbCrPositioning", 531, 3), new C3211c("ReferenceBlackWhite", 532, 5), new C3211c("Copyright", 33432, 2), new C3211c("ExifIFDPointer", 34665, 4), new C3211c("GPSInfoIFDPointer", 34853, 4), new C3211c("DNGVersion", 50706, 1), new C3211c("DefaultCropSize", 50720, 3, 4)};

    /* renamed from: a */
    private final String f8950a;

    /* renamed from: b */
    private final AssetManager.AssetInputStream f8951b;

    /* renamed from: c */
    private int f8952c;

    /* renamed from: d */
    private final HashMap<String, C3210b>[] f8953d = new HashMap[f8928F.length];

    /* renamed from: e */
    private Set<Integer> f8954e = new HashSet(f8928F.length);

    /* renamed from: f */
    private ByteOrder f8955f = ByteOrder.BIG_ENDIAN;

    /* renamed from: g */
    private int f8956g;

    /* renamed from: h */
    private int f8957h;

    /* renamed from: i */
    private int f8958i;

    /* renamed from: j */
    private int f8959j;

    /* renamed from: k */
    private int f8960k;

    /* renamed from: l */
    private int f8961l;

    /* renamed from: d.d.a.a$d */
    /* compiled from: ExifInterface */
    private static class C3212d {

        /* renamed from: a */
        public final long f8975a;

        /* renamed from: b */
        public final long f8976b;

        C3212d(long j, long j2) {
            if (j2 == 0) {
                this.f8975a = 0;
                this.f8976b = 1;
                return;
            }
            this.f8975a = j;
            this.f8976b = j2;
        }

        /* renamed from: a */
        public double mo18866a() {
            double d = (double) this.f8975a;
            double d2 = (double) this.f8976b;
            Double.isNaN(d);
            Double.isNaN(d2);
            return d / d2;
        }

        public String toString() {
            return this.f8975a + "/" + this.f8976b;
        }
    }

    static {
        Arrays.asList(new Integer[]{1, 6, 3, 8});
        Arrays.asList(new Integer[]{2, 7, 4, 5});
        C3211c[] cVarArr = {new C3211c("ColorSpace", 55, 3)};
        f8927E = cVarArr;
        C3211c[] cVarArr2 = f8945v;
        f8928F = new C3211c[][]{cVarArr2, f8946w, f8947x, f8948y, f8949z, cVarArr2, f8924B, f8925C, f8926D, cVarArr};
        new C3211c("JPEGInterchangeFormat", 513, 4);
        new C3211c("JPEGInterchangeFormatLength", 514, 4);
        C3211c[][] cVarArr3 = f8928F;
        f8930H = new HashMap[cVarArr3.length];
        f8931I = new HashMap[cVarArr3.length];
        Charset forName = Charset.forName("US-ASCII");
        f8934L = forName;
        f8935M = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        f8941r = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < f8928F.length; i++) {
            f8930H[i] = new HashMap<>();
            f8931I[i] = new HashMap<>();
            for (C3211c cVar : f8928F[i]) {
                f8930H[i].put(Integer.valueOf(cVar.f8971a), cVar);
                f8931I[i].put(cVar.f8972b, cVar);
            }
        }
        f8933K.put(Integer.valueOf(f8929G[0].f8971a), 5);
        f8933K.put(Integer.valueOf(f8929G[1].f8971a), 1);
        f8933K.put(Integer.valueOf(f8929G[2].f8971a), 2);
        f8933K.put(Integer.valueOf(f8929G[3].f8971a), 3);
        f8933K.put(Integer.valueOf(f8929G[4].f8971a), 7);
        f8933K.put(Integer.valueOf(f8929G[5].f8971a), 8);
        Pattern.compile(".*[1-9].*");
        Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    public C3208a(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.f8951b = null;
            this.f8950a = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    m10602a((InputStream) fileInputStream2);
                    m10601a((Closeable) fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    m10601a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                m10601a((Closeable) fileInputStream);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    /* renamed from: b */
    private C3210b m10607b(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < f8928F.length; i++) {
            C3210b bVar = this.f8953d[i].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* renamed from: c */
    private boolean m10616c(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private boolean m10619d(byte[] bArr) throws IOException {
        C3209a aVar = new C3209a(bArr);
        ByteOrder e = m10620e(aVar);
        this.f8955f = e;
        aVar.mo18838a(e);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 85;
    }

    /* renamed from: e */
    private ByteOrder m10620e(C3209a aVar) throws IOException {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    /* renamed from: f */
    private void m10621f(C3209a aVar) throws IOException {
        HashMap<String, C3210b> hashMap = this.f8953d[4];
        C3210b bVar = hashMap.get("Compression");
        if (bVar != null) {
            int b = bVar.mo18861b(this.f8955f);
            this.f8956g = b;
            if (b != 1) {
                if (b == 6) {
                    m10600a(aVar, (HashMap) hashMap);
                    return;
                } else if (b != 7) {
                    return;
                }
            }
            if (m10604a((HashMap) hashMap)) {
                m10610b(aVar, (HashMap) hashMap);
                return;
            }
            return;
        }
        this.f8956g = 6;
        m10600a(aVar, (HashMap) hashMap);
    }

    /* renamed from: a */
    public String mo18837a(String str) {
        C3210b b = m10607b(str);
        if (b != null) {
            if (!f8932J.contains(str)) {
                return b.mo18862c(this.f8955f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = b.f8968a;
                if (i == 5 || i == 10) {
                    C3212d[] dVarArr = (C3212d[]) b.mo18863d(this.f8955f);
                    if (dVarArr == null || dVarArr.length != 3) {
                        Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                        return null;
                    }
                    return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) dVarArr[0].f8975a) / ((float) dVarArr[0].f8976b))), Integer.valueOf((int) (((float) dVarArr[1].f8975a) / ((float) dVarArr[1].f8976b))), Integer.valueOf((int) (((float) dVarArr[2].f8975a) / ((float) dVarArr[2].f8976b)))});
                }
                Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + b.f8968a);
                return null;
            }
            try {
                return Double.toString(b.mo18860a(this.f8955f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* renamed from: d.d.a.a$a */
    /* compiled from: ExifInterface */
    private static class C3209a extends InputStream implements DataInput {

        /* renamed from: e */
        private static final ByteOrder f8962e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f */
        private static final ByteOrder f8963f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a */
        private DataInputStream f8964a;

        /* renamed from: b */
        private ByteOrder f8965b;

        /* renamed from: c */
        final int f8966c;

        /* renamed from: d */
        int f8967d;

        public C3209a(InputStream inputStream) throws IOException {
            this.f8965b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f8964a = dataInputStream;
            int available = dataInputStream.available();
            this.f8966c = available;
            this.f8967d = 0;
            this.f8964a.mark(available);
        }

        /* renamed from: a */
        public void mo18838a(ByteOrder byteOrder) {
            this.f8965b = byteOrder;
        }

        public int available() throws IOException {
            return this.f8964a.available();
        }

        /* renamed from: d */
        public int mo18840d() {
            return this.f8967d;
        }

        /* renamed from: e */
        public void mo18841e(long j) throws IOException {
            int i = this.f8967d;
            if (((long) i) > j) {
                this.f8967d = 0;
                this.f8964a.reset();
                this.f8964a.mark(this.f8966c);
            } else {
                j -= (long) i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int read() throws IOException {
            this.f8967d++;
            return this.f8964a.read();
        }

        public boolean readBoolean() throws IOException {
            this.f8967d++;
            return this.f8964a.readBoolean();
        }

        public byte readByte() throws IOException {
            int i = this.f8967d + 1;
            this.f8967d = i;
            if (i <= this.f8966c) {
                int read = this.f8964a.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.f8967d += 2;
            return this.f8964a.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f8967d + i2;
            this.f8967d = i3;
            if (i3 > this.f8966c) {
                throw new EOFException();
            } else if (this.f8964a.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public int readInt() throws IOException {
            int i = this.f8967d + 4;
            this.f8967d = i;
            if (i <= this.f8966c) {
                int read = this.f8964a.read();
                int read2 = this.f8964a.read();
                int read3 = this.f8964a.read();
                int read4 = this.f8964a.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f8965b;
                    if (byteOrder == f8962e) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f8963f) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f8965b);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            return null;
        }

        public long readLong() throws IOException {
            int i = this.f8967d + 8;
            this.f8967d = i;
            if (i <= this.f8966c) {
                int read = this.f8964a.read();
                int read2 = this.f8964a.read();
                int read3 = this.f8964a.read();
                int read4 = this.f8964a.read();
                int read5 = this.f8964a.read();
                int read6 = this.f8964a.read();
                int read7 = this.f8964a.read();
                int read8 = this.f8964a.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f8965b;
                    if (byteOrder == f8962e) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    int i2 = read2;
                    if (byteOrder == f8963f) {
                        return (((long) read) << 56) + (((long) i2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.f8965b);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            int i = this.f8967d + 2;
            this.f8967d = i;
            if (i <= this.f8966c) {
                int read = this.f8964a.read();
                int read2 = this.f8964a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f8965b;
                    if (byteOrder == f8962e) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f8963f) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f8965b);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.f8967d += 2;
            return this.f8964a.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.f8967d++;
            return this.f8964a.readUnsignedByte();
        }

        public int readUnsignedShort() throws IOException {
            int i = this.f8967d + 2;
            this.f8967d = i;
            if (i <= this.f8966c) {
                int read = this.f8964a.read();
                int read2 = this.f8964a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f8965b;
                    if (byteOrder == f8962e) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f8963f) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f8965b);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.f8966c - this.f8967d);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.f8964a.skipBytes(min - i2);
            }
            this.f8967d += i2;
            return i2;
        }

        /* renamed from: t */
        public long mo18859t() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.f8964a.read(bArr, i, i2);
            this.f8967d += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            int length = this.f8967d + bArr.length;
            this.f8967d = length;
            if (length > this.f8966c) {
                throw new EOFException();
            } else if (this.f8964a.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public C3209a(byte[] bArr) throws IOException {
            this((InputStream) new ByteArrayInputStream(bArr));
        }
    }

    /* renamed from: b */
    private boolean m10613b(byte[] bArr) throws IOException {
        C3209a aVar = new C3209a(bArr);
        ByteOrder e = m10620e(aVar);
        this.f8955f = e;
        aVar.mo18838a(e);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 20306 || readShort == 21330;
    }

    /* renamed from: c */
    private void m10614c(C3209a aVar) throws IOException {
        C3210b bVar;
        m10598a(aVar, aVar.available());
        m10609b(aVar, 0);
        m10618d(aVar, 0);
        m10618d(aVar, 5);
        m10618d(aVar, 4);
        m10611b((InputStream) aVar);
        if (this.f8952c == 8 && (bVar = this.f8953d[1].get("MakerNote")) != null) {
            C3209a aVar2 = new C3209a(bVar.f8970c);
            aVar2.mo18838a(this.f8955f);
            aVar2.mo18841e(6);
            m10609b(aVar2, 9);
            C3210b bVar2 = this.f8953d[9].get("ColorSpace");
            if (bVar2 != null) {
                this.f8953d[1].put("ColorSpace", bVar2);
            }
        }
    }

    /* renamed from: d.d.a.a$b */
    /* compiled from: ExifInterface */
    private static class C3210b {

        /* renamed from: a */
        public final int f8968a;

        /* renamed from: b */
        public final int f8969b;

        /* renamed from: c */
        public final byte[] f8970c;

        C3210b(int i, int i2, byte[] bArr) {
            this.f8968a = i;
            this.f8969b = i2;
            this.f8970c = bArr;
        }

        /* renamed from: a */
        public static C3210b m10632a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C3208a.f8943t[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new C3210b(3, iArr.length, wrap.array());
        }

        /* renamed from: b */
        public int mo18861b(ByteOrder byteOrder) {
            Object d = mo18863d(byteOrder);
            if (d == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (d instanceof String) {
                return Integer.parseInt((String) d);
            } else {
                if (d instanceof long[]) {
                    long[] jArr = (long[]) d;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d instanceof int[]) {
                    int[] iArr = (int[]) d;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        /* renamed from: c */
        public String mo18862c(ByteOrder byteOrder) {
            Object d = mo18863d(byteOrder);
            if (d == null) {
                return null;
            }
            if (d instanceof String) {
                return (String) d;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (d instanceof long[]) {
                long[] jArr = (long[]) d;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (d instanceof int[]) {
                int[] iArr = (int[]) d;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (d instanceof double[]) {
                double[] dArr = (double[]) d;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(d instanceof C3212d[])) {
                return null;
            } else {
                C3212d[] dVarArr = (C3212d[]) d;
                while (i < dVarArr.length) {
                    sb.append(dVarArr[i].f8975a);
                    sb.append('/');
                    sb.append(dVarArr[i].f8976b);
                    i++;
                    if (i != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:164:0x01ab A[SYNTHETIC, Splitter:B:164:0x01ab] */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object mo18863d(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                d.d.a.a$a r3 = new d.d.a.a$a     // Catch:{ IOException -> 0x0195, all -> 0x0193 }
                byte[] r4 = r10.f8970c     // Catch:{ IOException -> 0x0195, all -> 0x0193 }
                r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0195, all -> 0x0193 }
                r3.mo18838a(r11)     // Catch:{ IOException -> 0x0191 }
                int r11 = r10.f8968a     // Catch:{ IOException -> 0x0191 }
                r4 = 1
                r5 = 0
                switch(r11) {
                    case 1: goto L_0x014c;
                    case 2: goto L_0x00fd;
                    case 3: goto L_0x00e3;
                    case 4: goto L_0x00c9;
                    case 5: goto L_0x00a6;
                    case 6: goto L_0x014c;
                    case 7: goto L_0x00fd;
                    case 8: goto L_0x008c;
                    case 9: goto L_0x0072;
                    case 10: goto L_0x004d;
                    case 11: goto L_0x0032;
                    case 12: goto L_0x0018;
                    default: goto L_0x0016;
                }     // Catch:{ IOException -> 0x0191 }
            L_0x0016:
                goto L_0x0188
            L_0x0018:
                int r11 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x001c:
                int r4 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x0029
                double r6 = r3.readDouble()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x001c
            L_0x0029:
                r3.close()     // Catch:{ IOException -> 0x002d }
                goto L_0x0031
            L_0x002d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0031:
                return r11
            L_0x0032:
                int r11 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x0036:
                int r4 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x0044
                float r4 = r3.readFloat()     // Catch:{ IOException -> 0x0191 }
                double r6 = (double) r4     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x0036
            L_0x0044:
                r3.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x004c
            L_0x0048:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x004c:
                return r11
            L_0x004d:
                int r11 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                d.d.a.a$d[] r11 = new p075d.p083d.p084a.C3208a.C3212d[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x0051:
                int r4 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x0069
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0191 }
                long r6 = (long) r4     // Catch:{ IOException -> 0x0191 }
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0191 }
                long r8 = (long) r4     // Catch:{ IOException -> 0x0191 }
                d.d.a.a$d r4 = new d.d.a.a$d     // Catch:{ IOException -> 0x0191 }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x0051
            L_0x0069:
                r3.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0071
            L_0x006d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0071:
                return r11
            L_0x0072:
                int r11 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x0076:
                int r4 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x0083
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x0076
            L_0x0083:
                r3.close()     // Catch:{ IOException -> 0x0087 }
                goto L_0x008b
            L_0x0087:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x008b:
                return r11
            L_0x008c:
                int r11 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x0090:
                int r4 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x009d
                short r4 = r3.readShort()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x0090
            L_0x009d:
                r3.close()     // Catch:{ IOException -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00a5:
                return r11
            L_0x00a6:
                int r11 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                d.d.a.a$d[] r11 = new p075d.p083d.p084a.C3208a.C3212d[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x00aa:
                int r4 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x00c0
                long r6 = r3.mo18859t()     // Catch:{ IOException -> 0x0191 }
                long r8 = r3.mo18859t()     // Catch:{ IOException -> 0x0191 }
                d.d.a.a$d r4 = new d.d.a.a$d     // Catch:{ IOException -> 0x0191 }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x00aa
            L_0x00c0:
                r3.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00c8
            L_0x00c4:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00c8:
                return r11
            L_0x00c9:
                int r11 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x00cd:
                int r4 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x00da
                long r6 = r3.mo18859t()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x00cd
            L_0x00da:
                r3.close()     // Catch:{ IOException -> 0x00de }
                goto L_0x00e2
            L_0x00de:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00e2:
                return r11
            L_0x00e3:
                int r11 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x00e7:
                int r4 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x00f4
                int r4 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x00e7
            L_0x00f4:
                r3.close()     // Catch:{ IOException -> 0x00f8 }
                goto L_0x00fc
            L_0x00f8:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00fc:
                return r11
            L_0x00fd:
                int r11 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                byte[] r6 = p075d.p083d.p084a.C3208a.f8944u     // Catch:{ IOException -> 0x0191 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0191 }
                if (r11 < r6) goto L_0x011e
                r11 = 0
            L_0x0105:
                byte[] r6 = p075d.p083d.p084a.C3208a.f8944u     // Catch:{ IOException -> 0x0191 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0191 }
                if (r11 >= r6) goto L_0x0119
                byte[] r6 = r10.f8970c     // Catch:{ IOException -> 0x0191 }
                byte r6 = r6[r11]     // Catch:{ IOException -> 0x0191 }
                byte[] r7 = p075d.p083d.p084a.C3208a.f8944u     // Catch:{ IOException -> 0x0191 }
                byte r7 = r7[r11]     // Catch:{ IOException -> 0x0191 }
                if (r6 == r7) goto L_0x0116
                r4 = 0
                goto L_0x0119
            L_0x0116:
                int r11 = r11 + 1
                goto L_0x0105
            L_0x0119:
                if (r4 == 0) goto L_0x011e
                byte[] r11 = p075d.p083d.p084a.C3208a.f8944u     // Catch:{ IOException -> 0x0191 }
                int r5 = r11.length     // Catch:{ IOException -> 0x0191 }
            L_0x011e:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0191 }
                r11.<init>()     // Catch:{ IOException -> 0x0191 }
            L_0x0123:
                int r4 = r10.f8969b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x013f
                byte[] r4 = r10.f8970c     // Catch:{ IOException -> 0x0191 }
                byte r4 = r4[r5]     // Catch:{ IOException -> 0x0191 }
                if (r4 != 0) goto L_0x012e
                goto L_0x013f
            L_0x012e:
                r6 = 32
                if (r4 < r6) goto L_0x0137
                char r4 = (char) r4     // Catch:{ IOException -> 0x0191 }
                r11.append(r4)     // Catch:{ IOException -> 0x0191 }
                goto L_0x013c
            L_0x0137:
                r4 = 63
                r11.append(r4)     // Catch:{ IOException -> 0x0191 }
            L_0x013c:
                int r5 = r5 + 1
                goto L_0x0123
            L_0x013f:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0191 }
                r3.close()     // Catch:{ IOException -> 0x0147 }
                goto L_0x014b
            L_0x0147:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x014b:
                return r11
            L_0x014c:
                byte[] r11 = r10.f8970c     // Catch:{ IOException -> 0x0191 }
                int r11 = r11.length     // Catch:{ IOException -> 0x0191 }
                if (r11 != r4) goto L_0x0176
                byte[] r11 = r10.f8970c     // Catch:{ IOException -> 0x0191 }
                byte r11 = r11[r5]     // Catch:{ IOException -> 0x0191 }
                if (r11 < 0) goto L_0x0176
                byte[] r11 = r10.f8970c     // Catch:{ IOException -> 0x0191 }
                byte r11 = r11[r5]     // Catch:{ IOException -> 0x0191 }
                if (r11 > r4) goto L_0x0176
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0191 }
                char[] r4 = new char[r4]     // Catch:{ IOException -> 0x0191 }
                byte[] r6 = r10.f8970c     // Catch:{ IOException -> 0x0191 }
                byte r6 = r6[r5]     // Catch:{ IOException -> 0x0191 }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x0191 }
                r4[r5] = r6     // Catch:{ IOException -> 0x0191 }
                r11.<init>(r4)     // Catch:{ IOException -> 0x0191 }
                r3.close()     // Catch:{ IOException -> 0x0171 }
                goto L_0x0175
            L_0x0171:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0175:
                return r11
            L_0x0176:
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0191 }
                byte[] r4 = r10.f8970c     // Catch:{ IOException -> 0x0191 }
                java.nio.charset.Charset r5 = p075d.p083d.p084a.C3208a.f8934L     // Catch:{ IOException -> 0x0191 }
                r11.<init>(r4, r5)     // Catch:{ IOException -> 0x0191 }
                r3.close()     // Catch:{ IOException -> 0x0183 }
                goto L_0x0187
            L_0x0183:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0187:
                return r11
            L_0x0188:
                r3.close()     // Catch:{ IOException -> 0x018c }
                goto L_0x0190
            L_0x018c:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0190:
                return r2
            L_0x0191:
                r11 = move-exception
                goto L_0x0197
            L_0x0193:
                r11 = move-exception
                goto L_0x01a9
            L_0x0195:
                r11 = move-exception
                r3 = r2
            L_0x0197:
                java.lang.String r4 = "IOException occurred during reading a value"
                android.util.Log.w(r1, r4, r11)     // Catch:{ all -> 0x01a7 }
                if (r3 == 0) goto L_0x01a6
                r3.close()     // Catch:{ IOException -> 0x01a2 }
                goto L_0x01a6
            L_0x01a2:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x01a6:
                return r2
            L_0x01a7:
                r11 = move-exception
                r2 = r3
            L_0x01a9:
                if (r2 == 0) goto L_0x01b3
                r2.close()     // Catch:{ IOException -> 0x01af }
                goto L_0x01b3
            L_0x01af:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x01b3:
                goto L_0x01b5
            L_0x01b4:
                throw r11
            L_0x01b5:
                goto L_0x01b4
            */
            throw new UnsupportedOperationException("Method not decompiled: p075d.p083d.p084a.C3208a.C3210b.mo18863d(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + C3208a.f8942s[this.f8968a] + ", data length:" + this.f8970c.length + ")";
        }

        /* renamed from: a */
        public static C3210b m10628a(int i, ByteOrder byteOrder) {
            return m10632a(new int[]{i}, byteOrder);
        }

        /* renamed from: a */
        public static C3210b m10633a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C3208a.f8943t[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new C3210b(4, jArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C3210b m10629a(long j, ByteOrder byteOrder) {
            return m10633a(new long[]{j}, byteOrder);
        }

        /* renamed from: a */
        public static C3210b m10631a(String str) {
            byte[] bytes = (str + 0).getBytes(C3208a.f8934L);
            return new C3210b(2, bytes.length, bytes);
        }

        /* renamed from: a */
        public static C3210b m10634a(C3212d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C3208a.f8943t[5] * dVarArr.length)]);
            wrap.order(byteOrder);
            for (C3212d dVar : dVarArr) {
                wrap.putInt((int) dVar.f8975a);
                wrap.putInt((int) dVar.f8976b);
            }
            return new C3210b(5, dVarArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C3210b m10630a(C3212d dVar, ByteOrder byteOrder) {
            return m10634a(new C3212d[]{dVar}, byteOrder);
        }

        /* renamed from: a */
        public double mo18860a(ByteOrder byteOrder) {
            Object d = mo18863d(byteOrder);
            if (d == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (d instanceof String) {
                return Double.parseDouble((String) d);
            } else {
                if (d instanceof long[]) {
                    long[] jArr = (long[]) d;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d instanceof int[]) {
                    int[] iArr = (int[]) d;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d instanceof double[]) {
                    double[] dArr = (double[]) d;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d instanceof C3212d[]) {
                    C3212d[] dVarArr = (C3212d[]) d;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].mo18866a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }
    }

    /* renamed from: d.d.a.a$c */
    /* compiled from: ExifInterface */
    static class C3211c {

        /* renamed from: a */
        public final int f8971a;

        /* renamed from: b */
        public final String f8972b;

        /* renamed from: c */
        public final int f8973c;

        /* renamed from: d */
        public final int f8974d;

        C3211c(String str, int i, int i2) {
            this.f8972b = str;
            this.f8971a = i;
            this.f8973c = i2;
            this.f8974d = -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo18865a(int i) {
            int i2;
            int i3 = this.f8973c;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.f8974d) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((this.f8973c == 9 || this.f8974d == 9) && i == 8) {
                return true;
            }
            if ((this.f8973c == 12 || this.f8974d == 12) && i == 11) {
                return true;
            }
            return false;
        }

        C3211c(String str, int i, int i2, int i3) {
            this.f8972b = str;
            this.f8971a = i;
            this.f8973c = i2;
            this.f8974d = i3;
        }
    }

    /* renamed from: d */
    private void m10617d(C3209a aVar) throws IOException {
        m10614c(aVar);
        if (this.f8953d[0].get("JpgFromRaw") != null) {
            m10599a(aVar, this.f8961l, 5);
        }
        C3210b bVar = this.f8953d[0].get("ISO");
        C3210b bVar2 = this.f8953d[1].get("PhotographicSensitivity");
        if (bVar != null && bVar2 == null) {
            this.f8953d[1].put("PhotographicSensitivity", bVar);
        }
    }

    /* renamed from: b */
    private void m10608b(C3209a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        m10599a(aVar, i, 5);
        aVar.mo18841e((long) i2);
        aVar.mo18838a(ByteOrder.BIG_ENDIAN);
        int readInt = aVar.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == f8923A.f8971a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                C3210b a = C3210b.m10628a((int) readShort, this.f8955f);
                C3210b a2 = C3210b.m10628a((int) readShort2, this.f8955f);
                this.f8953d[0].put("ImageLength", a);
                this.f8953d[0].put("ImageWidth", a2);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    /* renamed from: d */
    private void m10618d(C3209a aVar, int i) throws IOException {
        C3210b bVar;
        C3210b bVar2;
        C3210b bVar3 = this.f8953d[i].get("DefaultCropSize");
        C3210b bVar4 = this.f8953d[i].get("SensorTopBorder");
        C3210b bVar5 = this.f8953d[i].get("SensorLeftBorder");
        C3210b bVar6 = this.f8953d[i].get("SensorBottomBorder");
        C3210b bVar7 = this.f8953d[i].get("SensorRightBorder");
        if (bVar3 != null) {
            if (bVar3.f8968a == 5) {
                C3212d[] dVarArr = (C3212d[]) bVar3.mo18863d(this.f8955f);
                if (dVarArr == null || dVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                    return;
                }
                bVar2 = C3210b.m10630a(dVarArr[0], this.f8955f);
                bVar = C3210b.m10630a(dVarArr[1], this.f8955f);
            } else {
                int[] iArr = (int[]) bVar3.mo18863d(this.f8955f);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                bVar2 = C3210b.m10628a(iArr[0], this.f8955f);
                bVar = C3210b.m10628a(iArr[1], this.f8955f);
            }
            this.f8953d[i].put("ImageWidth", bVar2);
            this.f8953d[i].put("ImageLength", bVar);
        } else if (bVar4 == null || bVar5 == null || bVar6 == null || bVar7 == null) {
            m10615c(aVar, i);
        } else {
            int b = bVar4.mo18861b(this.f8955f);
            int b2 = bVar6.mo18861b(this.f8955f);
            int b3 = bVar7.mo18861b(this.f8955f);
            int b4 = bVar5.mo18861b(this.f8955f);
            if (b2 > b && b3 > b4) {
                C3210b a = C3210b.m10628a(b2 - b, this.f8955f);
                C3210b a2 = C3210b.m10628a(b3 - b4, this.f8955f);
                this.f8953d[i].put("ImageLength", a);
                this.f8953d[i].put("ImageWidth", a2);
            }
        }
    }

    /* renamed from: a */
    public int mo18836a(String str, int i) {
        C3210b b = m10607b(str);
        if (b == null) {
            return i;
        }
        try {
            return b.mo18861b(this.f8955f);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    /* renamed from: a */
    private void m10602a(InputStream inputStream) throws IOException {
        int i = 0;
        while (i < f8928F.length) {
            try {
                this.f8953d[i] = new HashMap<>();
                i++;
            } catch (IOException unused) {
            } catch (Throwable th) {
                m10595a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.f8952c = m10594a(bufferedInputStream);
        C3209a aVar = new C3209a((InputStream) bufferedInputStream);
        switch (this.f8952c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                m10614c(aVar);
                break;
            case 4:
                m10599a(aVar, 0, 0);
                break;
            case 7:
                m10597a(aVar);
                break;
            case 9:
                m10608b(aVar);
                break;
            case 10:
                m10617d(aVar);
                break;
        }
        m10621f(aVar);
        m10595a();
    }

    /* renamed from: c */
    private void m10615c(C3209a aVar, int i) throws IOException {
        C3210b bVar;
        C3210b bVar2 = this.f8953d[i].get("ImageLength");
        C3210b bVar3 = this.f8953d[i].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = this.f8953d[i].get("JPEGInterchangeFormat")) != null) {
            m10599a(aVar, bVar.mo18861b(this.f8955f), i);
        }
    }

    /* renamed from: a */
    private int m10594a(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (m10605a(bArr)) {
            return 4;
        }
        if (m10616c(bArr)) {
            return 9;
        }
        if (m10613b(bArr)) {
            return 7;
        }
        return m10619d(bArr) ? 10 : 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f5  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10609b(p075d.p083d.p084a.C3208a.C3209a r24, int r25) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            java.util.Set<java.lang.Integer> r3 = r0.f8954e
            int r4 = r1.f8967d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            int r3 = r1.f8967d
            int r3 = r3 + 2
            int r4 = r1.f8966c
            if (r3 <= r4) goto L_0x001a
            return
        L_0x001a:
            short r3 = r24.readShort()
            int r4 = r1.f8967d
            int r5 = r3 * 12
            int r4 = r4 + r5
            int r5 = r1.f8966c
            if (r4 > r5) goto L_0x0326
            if (r3 > 0) goto L_0x002b
            goto L_0x0326
        L_0x002b:
            r5 = 0
        L_0x002c:
            java.lang.String r9 = "ExifInterface"
            if (r5 >= r3) goto L_0x02b7
            int r10 = r24.readUnsignedShort()
            int r11 = r24.readUnsignedShort()
            int r12 = r24.readInt()
            int r13 = r24.mo18840d()
            long r13 = (long) r13
            r15 = 4
            long r13 = r13 + r15
            java.util.HashMap<java.lang.Integer, d.d.a.a$c>[] r17 = f8930H
            r4 = r17[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            java.lang.Object r4 = r4.get(r8)
            d.d.a.a$c r4 = (p075d.p083d.p084a.C3208a.C3211c) r4
            r8 = 7
            if (r4 != 0) goto L_0x006b
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r6 = "Skip the tag entry since tag number is not defined: "
            r15.append(r6)
            r15.append(r10)
            java.lang.String r6 = r15.toString()
            android.util.Log.w(r9, r6)
            goto L_0x00e7
        L_0x006b:
            if (r11 <= 0) goto L_0x00d3
            int[] r6 = f8943t
            int r6 = r6.length
            if (r11 < r6) goto L_0x0073
            goto L_0x00d3
        L_0x0073:
            boolean r6 = r4.mo18865a(r11)
            if (r6 != 0) goto L_0x009c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since data format ("
            r6.append(r7)
            java.lang.String[] r7 = f8942s
            r7 = r7[r11]
            r6.append(r7)
            java.lang.String r7 = ") is unexpected for tag: "
            r6.append(r7)
            java.lang.String r7 = r4.f8972b
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r9, r6)
            goto L_0x00e7
        L_0x009c:
            if (r11 != r8) goto L_0x00a0
            int r11 = r4.f8973c
        L_0x00a0:
            long r6 = (long) r12
            int[] r15 = f8943t
            r15 = r15[r11]
            r16 = r9
            long r8 = (long) r15
            long r6 = r6 * r8
            r8 = 0
            int r15 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r15 < 0) goto L_0x00bc
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r15 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r15 <= 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            r8 = 1
            r9 = r16
            goto L_0x00ea
        L_0x00bc:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Skip the tag entry since the number of components is invalid: "
            r8.append(r9)
            r8.append(r12)
            java.lang.String r8 = r8.toString()
            r9 = r16
            android.util.Log.w(r9, r8)
            goto L_0x00e9
        L_0x00d3:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since data format is invalid: "
            r6.append(r7)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r9, r6)
        L_0x00e7:
            r6 = 0
        L_0x00e9:
            r8 = 0
        L_0x00ea:
            if (r8 != 0) goto L_0x00f5
            r1.mo18841e(r13)
            r16 = r3
            r18 = r5
            goto L_0x02ae
        L_0x00f5:
            java.lang.String r8 = "Compression"
            r15 = 4
            int r18 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r18 <= 0) goto L_0x01a2
            int r15 = r24.readInt()
            r16 = r3
            int r3 = r0.f8952c
            r18 = r5
            r5 = 7
            if (r3 != r5) goto L_0x0165
            java.lang.String r3 = r4.f8972b
            java.lang.String r5 = "MakerNote"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0117
            r0.f8958i = r15
            goto L_0x0160
        L_0x0117:
            r3 = 6
            if (r2 != r3) goto L_0x0160
            java.lang.String r5 = r4.f8972b
            java.lang.String r3 = "ThumbnailImage"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0160
            r0.f8959j = r15
            r0.f8960k = r12
            java.nio.ByteOrder r3 = r0.f8955f
            r5 = 6
            d.d.a.a$b r3 = p075d.p083d.p084a.C3208a.C3210b.m10628a((int) r5, (java.nio.ByteOrder) r3)
            int r5 = r0.f8959j
            r20 = r11
            r19 = r12
            long r11 = (long) r5
            java.nio.ByteOrder r5 = r0.f8955f
            d.d.a.a$b r5 = p075d.p083d.p084a.C3208a.C3210b.m10629a((long) r11, (java.nio.ByteOrder) r5)
            int r11 = r0.f8960k
            long r11 = (long) r11
            java.nio.ByteOrder r2 = r0.f8955f
            d.d.a.a$b r2 = p075d.p083d.p084a.C3208a.C3210b.m10629a((long) r11, (java.nio.ByteOrder) r2)
            java.util.HashMap<java.lang.String, d.d.a.a$b>[] r11 = r0.f8953d
            r12 = 4
            r11 = r11[r12]
            r11.put(r8, r3)
            java.util.HashMap<java.lang.String, d.d.a.a$b>[] r3 = r0.f8953d
            r3 = r3[r12]
            java.lang.String r11 = "JPEGInterchangeFormat"
            r3.put(r11, r5)
            java.util.HashMap<java.lang.String, d.d.a.a$b>[] r3 = r0.f8953d
            r3 = r3[r12]
            java.lang.String r5 = "JPEGInterchangeFormatLength"
            r3.put(r5, r2)
            goto L_0x0179
        L_0x0160:
            r20 = r11
            r19 = r12
            goto L_0x0179
        L_0x0165:
            r20 = r11
            r19 = r12
            r2 = 10
            if (r3 != r2) goto L_0x0179
            java.lang.String r2 = r4.f8972b
            java.lang.String r3 = "JpgFromRaw"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0179
            r0.f8961l = r15
        L_0x0179:
            long r2 = (long) r15
            long r11 = r2 + r6
            int r5 = r1.f8966c
            r21 = r4
            long r4 = (long) r5
            int r22 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r22 > 0) goto L_0x0189
            r1.mo18841e(r2)
            goto L_0x01ac
        L_0x0189:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip the tag entry since data offset is invalid: "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r9, r2)
            r1.mo18841e(r13)
            goto L_0x02ae
        L_0x01a2:
            r16 = r3
            r21 = r4
            r18 = r5
            r20 = r11
            r19 = r12
        L_0x01ac:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = f8933K
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            r3 = 8
            r4 = 3
            if (r2 == 0) goto L_0x0245
            r5 = -1
            r11 = r20
            if (r11 == r4) goto L_0x01e2
            r4 = 4
            if (r11 == r4) goto L_0x01dd
            if (r11 == r3) goto L_0x01d8
            r3 = 9
            if (r11 == r3) goto L_0x01d3
            r3 = 13
            if (r11 == r3) goto L_0x01d3
        L_0x01d0:
            r3 = 0
            goto L_0x01e8
        L_0x01d3:
            int r3 = r24.readInt()
            goto L_0x01e6
        L_0x01d8:
            short r3 = r24.readShort()
            goto L_0x01e6
        L_0x01dd:
            long r5 = r24.mo18859t()
            goto L_0x01d0
        L_0x01e2:
            int r3 = r24.readUnsignedShort()
        L_0x01e6:
            long r5 = (long) r3
            goto L_0x01d0
        L_0x01e8:
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x022d
            int r3 = r1.f8966c
            long r3 = (long) r3
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x022d
            java.util.Set<java.lang.Integer> r3 = r0.f8954e
            int r4 = (int) r5
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x020b
            r1.mo18841e(r5)
            int r2 = r2.intValue()
            r0.m10609b((p075d.p083d.p084a.C3208a.C3209a) r1, (int) r2)
            goto L_0x0241
        L_0x020b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r5)
            java.lang.String r2 = ")"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.w(r9, r2)
            goto L_0x0241
        L_0x022d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r9, r2)
        L_0x0241:
            r1.mo18841e(r13)
            goto L_0x02ae
        L_0x0245:
            r11 = r20
            int r2 = (int) r6
            byte[] r2 = new byte[r2]
            r1.readFully(r2)
            d.d.a.a$b r5 = new d.d.a.a$b
            r6 = r19
            r5.<init>(r11, r6, r2)
            java.util.HashMap<java.lang.String, d.d.a.a$b>[] r2 = r0.f8953d
            r2 = r2[r25]
            r6 = r21
            java.lang.String r7 = r6.f8972b
            r2.put(r7, r5)
            java.lang.String r2 = r6.f8972b
            java.lang.String r7 = "DNGVersion"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x026b
            r0.f8952c = r4
        L_0x026b:
            java.lang.String r2 = r6.f8972b
            java.lang.String r4 = "Make"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x027f
            java.lang.String r2 = r6.f8972b
            java.lang.String r4 = "Model"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x028d
        L_0x027f:
            java.nio.ByteOrder r2 = r0.f8955f
            java.lang.String r2 = r5.mo18862c(r2)
            java.lang.String r4 = "PENTAX"
            boolean r2 = r2.contains(r4)
            if (r2 != 0) goto L_0x02a0
        L_0x028d:
            java.lang.String r2 = r6.f8972b
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x02a2
            java.nio.ByteOrder r2 = r0.f8955f
            int r2 = r5.mo18861b(r2)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r4) goto L_0x02a2
        L_0x02a0:
            r0.f8952c = r3
        L_0x02a2:
            int r2 = r24.mo18840d()
            long r2 = (long) r2
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x02ae
            r1.mo18841e(r13)
        L_0x02ae:
            int r5 = r18 + 1
            short r5 = (short) r5
            r2 = r25
            r3 = r16
            goto L_0x002c
        L_0x02b7:
            int r2 = r24.mo18840d()
            r3 = 4
            int r2 = r2 + r3
            int r3 = r1.f8966c
            if (r2 > r3) goto L_0x0326
            int r2 = r24.readInt()
            long r3 = (long) r2
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0312
            int r5 = r1.f8966c
            if (r2 >= r5) goto L_0x0312
            java.util.Set<java.lang.Integer> r5 = r0.f8954e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x02fd
            r1.mo18841e(r3)
            java.util.HashMap<java.lang.String, d.d.a.a$b>[] r2 = r0.f8953d
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x02ee
            r0.m10609b((p075d.p083d.p084a.C3208a.C3209a) r1, (int) r3)
            goto L_0x0326
        L_0x02ee:
            java.util.HashMap<java.lang.String, d.d.a.a$b>[] r2 = r0.f8953d
            r3 = 5
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0326
            r0.m10609b((p075d.p083d.p084a.C3208a.C3209a) r1, (int) r3)
            goto L_0x0326
        L_0x02fd:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r9, r1)
            goto L_0x0326
        L_0x0312:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r9, r1)
        L_0x0326:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p075d.p083d.p084a.C3208a.m10609b(d.d.a.a$a, int):void");
    }

    /* renamed from: a */
    private static boolean m10605a(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = f8938o;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0088 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f7 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10599a(p075d.p083d.p084a.C3208a.C3209a r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r10.mo18838a(r0)
            long r0 = (long) r11
            r10.mo18841e(r0)
            byte r0 = r10.readByte()
            java.lang.String r1 = "Invalid marker: "
            r2 = -1
            if (r0 != r2) goto L_0x0153
            r3 = 1
            int r11 = r11 + r3
            byte r4 = r10.readByte()
            r5 = -40
            if (r4 != r5) goto L_0x0138
            int r11 = r11 + r3
        L_0x001d:
            byte r0 = r10.readByte()
            if (r0 != r2) goto L_0x011b
            int r11 = r11 + r3
            byte r0 = r10.readByte()
            int r11 = r11 + r3
            r1 = -39
            if (r0 == r1) goto L_0x0115
            r1 = -38
            if (r0 != r1) goto L_0x0033
            goto L_0x0115
        L_0x0033:
            int r1 = r10.readUnsignedShort()
            int r1 = r1 + -2
            int r11 = r11 + 2
            java.lang.String r4 = "Invalid length"
            if (r1 < 0) goto L_0x010f
            r5 = -31
            r6 = 0
            java.lang.String r7 = "Invalid exif"
            if (r0 == r5) goto L_0x00ba
            r5 = -2
            if (r0 == r5) goto L_0x0090
            switch(r0) {
                case -64: goto L_0x0057;
                case -63: goto L_0x0057;
                case -62: goto L_0x0057;
                case -61: goto L_0x0057;
                default: goto L_0x004c;
            }
        L_0x004c:
            switch(r0) {
                case -59: goto L_0x0057;
                case -58: goto L_0x0057;
                case -57: goto L_0x0057;
                default: goto L_0x004f;
            }
        L_0x004f:
            switch(r0) {
                case -55: goto L_0x0057;
                case -54: goto L_0x0057;
                case -53: goto L_0x0057;
                default: goto L_0x0052;
            }
        L_0x0052:
            switch(r0) {
                case -51: goto L_0x0057;
                case -50: goto L_0x0057;
                case -49: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x00e4
        L_0x0057:
            int r0 = r10.skipBytes(r3)
            if (r0 != r3) goto L_0x0088
            java.util.HashMap<java.lang.String, d.d.a.a$b>[] r0 = r9.f8953d
            r0 = r0[r12]
            int r5 = r10.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r9.f8955f
            d.d.a.a$b r5 = p075d.p083d.p084a.C3208a.C3210b.m10629a((long) r5, (java.nio.ByteOrder) r7)
            java.lang.String r6 = "ImageLength"
            r0.put(r6, r5)
            java.util.HashMap<java.lang.String, d.d.a.a$b>[] r0 = r9.f8953d
            r0 = r0[r12]
            int r5 = r10.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r9.f8955f
            d.d.a.a$b r5 = p075d.p083d.p084a.C3208a.C3210b.m10629a((long) r5, (java.nio.ByteOrder) r7)
            java.lang.String r6 = "ImageWidth"
            r0.put(r6, r5)
            int r1 = r1 + -5
            goto L_0x00e4
        L_0x0088:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "Invalid SOFx"
            r10.<init>(r11)
            throw r10
        L_0x0090:
            byte[] r0 = new byte[r1]
            int r5 = r10.read(r0)
            if (r5 != r1) goto L_0x00b4
            java.lang.String r1 = "UserComment"
            java.lang.String r5 = r9.mo18837a((java.lang.String) r1)
            if (r5 != 0) goto L_0x00b2
            java.util.HashMap<java.lang.String, d.d.a.a$b>[] r5 = r9.f8953d
            r5 = r5[r3]
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r8 = f8934L
            r7.<init>(r0, r8)
            d.d.a.a$b r0 = p075d.p083d.p084a.C3208a.C3210b.m10631a((java.lang.String) r7)
            r5.put(r1, r0)
        L_0x00b2:
            r1 = 0
            goto L_0x00e4
        L_0x00b4:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x00ba:
            r0 = 6
            if (r1 >= r0) goto L_0x00be
            goto L_0x00e4
        L_0x00be:
            byte[] r5 = new byte[r0]
            int r8 = r10.read(r5)
            if (r8 != r0) goto L_0x0109
            int r11 = r11 + 6
            int r1 = r1 + -6
            byte[] r0 = f8935M
            boolean r0 = java.util.Arrays.equals(r5, r0)
            if (r0 != 0) goto L_0x00d3
            goto L_0x00e4
        L_0x00d3:
            if (r1 <= 0) goto L_0x0103
            r9.f8957h = r11
            byte[] r0 = new byte[r1]
            int r5 = r10.read(r0)
            if (r5 != r1) goto L_0x00fd
            int r11 = r11 + r1
            r9.m10603a((byte[]) r0, (int) r12)
            goto L_0x00b2
        L_0x00e4:
            if (r1 < 0) goto L_0x00f7
            int r0 = r10.skipBytes(r1)
            if (r0 != r1) goto L_0x00ef
            int r11 = r11 + r1
            goto L_0x001d
        L_0x00ef:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "Invalid JPEG segment"
            r10.<init>(r11)
            throw r10
        L_0x00f7:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r4)
            throw r10
        L_0x00fd:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x0103:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x0109:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x010f:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r4)
            throw r10
        L_0x0115:
            java.nio.ByteOrder r11 = r9.f8955f
            r10.mo18838a(r11)
            return
        L_0x011b:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Invalid marker:"
            r11.append(r12)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0138:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0153:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            goto L_0x016f
        L_0x016e:
            throw r10
        L_0x016f:
            goto L_0x016e
        */
        throw new UnsupportedOperationException("Method not decompiled: p075d.p083d.p084a.C3208a.m10599a(d.d.a.a$a, int, int):void");
    }

    /* renamed from: a */
    private void m10597a(C3209a aVar) throws IOException {
        m10614c(aVar);
        C3210b bVar = this.f8953d[1].get("MakerNote");
        if (bVar != null) {
            C3209a aVar2 = new C3209a(bVar.f8970c);
            aVar2.mo18838a(this.f8955f);
            byte[] bArr = new byte[f8939p.length];
            aVar2.readFully(bArr);
            aVar2.mo18841e(0);
            byte[] bArr2 = new byte[f8940q.length];
            aVar2.readFully(bArr2);
            if (Arrays.equals(bArr, f8939p)) {
                aVar2.mo18841e(8);
            } else if (Arrays.equals(bArr2, f8940q)) {
                aVar2.mo18841e(12);
            }
            m10609b(aVar2, 6);
            C3210b bVar2 = this.f8953d[7].get("PreviewImageStart");
            C3210b bVar3 = this.f8953d[7].get("PreviewImageLength");
            if (!(bVar2 == null || bVar3 == null)) {
                this.f8953d[5].put("JPEGInterchangeFormat", bVar2);
                this.f8953d[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            C3210b bVar4 = this.f8953d[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.mo18863d(this.f8955f);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i = (iArr[2] - iArr[0]) + 1;
                    int i2 = (iArr[3] - iArr[1]) + 1;
                    if (i < i2) {
                        int i3 = i + i2;
                        i2 = i3 - i2;
                        i = i3 - i2;
                    }
                    C3210b a = C3210b.m10628a(i, this.f8955f);
                    C3210b a2 = C3210b.m10628a(i2, this.f8955f);
                    this.f8953d[0].put("ImageWidth", a);
                    this.f8953d[0].put("ImageLength", a2);
                }
            }
        }
    }

    /* renamed from: b */
    private void m10610b(C3209a aVar, HashMap hashMap) throws IOException {
        C3210b bVar = (C3210b) hashMap.get("StripOffsets");
        C3210b bVar2 = (C3210b) hashMap.get("StripByteCounts");
        if (bVar != null && bVar2 != null) {
            long[] a = m10606a(bVar.mo18863d(this.f8955f));
            long[] a2 = m10606a(bVar2.mo18863d(this.f8955f));
            if (a == null) {
                Log.w("ExifInterface", "stripOffsets should not be null.");
            } else if (a2 == null) {
                Log.w("ExifInterface", "stripByteCounts should not be null.");
            } else {
                long j = 0;
                for (long j2 : a2) {
                    j += j2;
                }
                byte[] bArr = new byte[((int) j)];
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < a.length; i3++) {
                    int i4 = (int) a[i3];
                    int i5 = (int) a2[i3];
                    int i6 = i4 - i;
                    aVar.mo18841e((long) i6);
                    int i7 = i + i6;
                    byte[] bArr2 = new byte[i5];
                    aVar.read(bArr2);
                    i = i7 + i5;
                    System.arraycopy(bArr2, 0, bArr, i2, i5);
                    i2 += i5;
                }
            }
        }
    }

    /* renamed from: a */
    private void m10603a(byte[] bArr, int i) throws IOException {
        C3209a aVar = new C3209a(bArr);
        m10598a(aVar, bArr.length);
        m10609b(aVar, i);
    }

    /* renamed from: a */
    private void m10595a() {
        String a = mo18837a("DateTimeOriginal");
        if (a != null && mo18837a("DateTime") == null) {
            this.f8953d[0].put("DateTime", C3210b.m10631a(a));
        }
        if (mo18837a("ImageWidth") == null) {
            this.f8953d[0].put("ImageWidth", C3210b.m10629a(0, this.f8955f));
        }
        if (mo18837a("ImageLength") == null) {
            this.f8953d[0].put("ImageLength", C3210b.m10629a(0, this.f8955f));
        }
        if (mo18837a("Orientation") == null) {
            this.f8953d[0].put("Orientation", C3210b.m10629a(0, this.f8955f));
        }
        if (mo18837a("LightSource") == null) {
            this.f8953d[1].put("LightSource", C3210b.m10629a(0, this.f8955f));
        }
    }

    /* renamed from: b */
    private boolean m10612b(HashMap hashMap) throws IOException {
        C3210b bVar = (C3210b) hashMap.get("ImageLength");
        C3210b bVar2 = (C3210b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.mo18861b(this.f8955f) <= 512 && bVar2.mo18861b(this.f8955f) <= 512;
    }

    /* renamed from: b */
    private void m10611b(InputStream inputStream) throws IOException {
        m10596a(0, 5);
        m10596a(0, 4);
        m10596a(5, 4);
        C3210b bVar = this.f8953d[1].get("PixelXDimension");
        C3210b bVar2 = this.f8953d[1].get("PixelYDimension");
        if (!(bVar == null || bVar2 == null)) {
            this.f8953d[0].put("ImageWidth", bVar);
            this.f8953d[0].put("ImageLength", bVar2);
        }
        if (this.f8953d[4].isEmpty() && m10612b((HashMap) this.f8953d[5])) {
            HashMap<String, C3210b>[] hashMapArr = this.f8953d;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        boolean b = m10612b((HashMap) this.f8953d[4]);
    }

    /* renamed from: a */
    private void m10598a(C3209a aVar, int i) throws IOException {
        ByteOrder e = m10620e(aVar);
        this.f8955f = e;
        aVar.mo18838a(e);
        int readUnsignedShort = aVar.readUnsignedShort();
        int i2 = this.f8952c;
        if (i2 == 7 || i2 == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i) {
                throw new IOException("Invalid first Ifd offset: " + readInt);
            }
            int i3 = readInt - 8;
            if (i3 > 0 && aVar.skipBytes(i3) != i3) {
                throw new IOException("Couldn't jump to first Ifd: " + i3);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* renamed from: a */
    private void m10600a(C3209a aVar, HashMap hashMap) throws IOException {
        int i;
        C3210b bVar = (C3210b) hashMap.get("JPEGInterchangeFormat");
        C3210b bVar2 = (C3210b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar != null && bVar2 != null) {
            int b = bVar.mo18861b(this.f8955f);
            int min = Math.min(bVar2.mo18861b(this.f8955f), aVar.available() - b);
            int i2 = this.f8952c;
            if (i2 == 4 || i2 == 9 || i2 == 10) {
                i = this.f8957h;
            } else {
                if (i2 == 7) {
                    i = this.f8958i;
                }
                if (b > 0 && min > 0 && this.f8950a == null && this.f8951b == null) {
                    aVar.mo18841e((long) b);
                    aVar.readFully(new byte[min]);
                    return;
                }
                return;
            }
            b += i;
            if (b > 0) {
            }
        }
    }

    /* renamed from: a */
    private boolean m10604a(HashMap hashMap) throws IOException {
        C3210b bVar;
        C3210b bVar2 = (C3210b) hashMap.get("BitsPerSample");
        if (bVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) bVar2.mo18863d(this.f8955f);
        if (Arrays.equals(f8936m, iArr)) {
            return true;
        }
        if (this.f8952c != 3 || (bVar = (C3210b) hashMap.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int b = bVar.mo18861b(this.f8955f);
        if ((b != 1 || !Arrays.equals(iArr, f8937n)) && (b != 6 || !Arrays.equals(iArr, f8936m))) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m10596a(int i, int i2) throws IOException {
        if (!this.f8953d[i].isEmpty() && !this.f8953d[i2].isEmpty()) {
            C3210b bVar = this.f8953d[i].get("ImageLength");
            C3210b bVar2 = this.f8953d[i].get("ImageWidth");
            C3210b bVar3 = this.f8953d[i2].get("ImageLength");
            C3210b bVar4 = this.f8953d[i2].get("ImageWidth");
            if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null) {
                int b = bVar.mo18861b(this.f8955f);
                int b2 = bVar2.mo18861b(this.f8955f);
                int b3 = bVar3.mo18861b(this.f8955f);
                int b4 = bVar4.mo18861b(this.f8955f);
                if (b < b3 && b2 < b4) {
                    HashMap<String, C3210b>[] hashMapArr = this.f8953d;
                    HashMap<String, C3210b> hashMap = hashMapArr[i];
                    hashMapArr[i] = hashMapArr[i2];
                    hashMapArr[i2] = hashMap;
                }
            }
        }
    }

    /* renamed from: a */
    private static void m10601a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private static long[] m10606a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = (long) iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
