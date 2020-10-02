package com.google.zxing;

/* renamed from: com.google.zxing.c */
/* compiled from: EncodeHintType */
public enum C4063c {
    ERROR_CORRECTION,
    CHARACTER_SET,
    DATA_MATRIX_SHAPE,
    MIN_SIZE,
    MAX_SIZE,
    MARGIN,
    PDF417_COMPACT,
    PDF417_COMPACTION,
    PDF417_DIMENSIONS,
    AZTEC_LAYERS,
    QR_VERSION,
    GS1_FORMAT;

    static {
        ERROR_CORRECTION = new C4063c("ERROR_CORRECTION", 0);
        CHARACTER_SET = new C4063c("CHARACTER_SET", 1);
        DATA_MATRIX_SHAPE = new C4063c("DATA_MATRIX_SHAPE", 2);
        MIN_SIZE = new C4063c("MIN_SIZE", 3);
        MAX_SIZE = new C4063c("MAX_SIZE", 4);
        MARGIN = new C4063c("MARGIN", 5);
        PDF417_COMPACT = new C4063c("PDF417_COMPACT", 6);
        PDF417_COMPACTION = new C4063c("PDF417_COMPACTION", 7);
        PDF417_DIMENSIONS = new C4063c("PDF417_DIMENSIONS", 8);
        AZTEC_LAYERS = new C4063c("AZTEC_LAYERS", 9);
        QR_VERSION = new C4063c("QR_VERSION", 10);
        GS1_FORMAT = new C4063c("GS1_FORMAT", 11);
    }
}
