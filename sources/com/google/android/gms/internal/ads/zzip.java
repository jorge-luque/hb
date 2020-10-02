package com.google.android.gms.internal.ads;

import com.ogury.p159cm.OguryChoiceManager;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzip {
    private static final int[] zzalx = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzaly = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzalz = {64, 112, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE, 192, 224, 256, 384, 448, 512, 640, 768, 896, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, CodedOutputStream.DEFAULT_BUFFER_SIZE, 6144, 7680};

    public static int zzj(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) << 5;
    }
}
