package p118io.fabric.sdk.android.services.network;

import java.io.InputStream;

/* renamed from: io.fabric.sdk.android.services.network.f */
/* compiled from: PinningInfoProvider */
public interface C6202f {
    String getKeyStorePassword();

    InputStream getKeyStoreStream();

    long getPinCreationTimeInMillis();

    String[] getPins();
}
