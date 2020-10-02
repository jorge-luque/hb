package com.miniclip.network;

public interface HttpConnectionListener {
    void downloadComplete(int i, int i2, byte[] bArr);

    void downloadFailed(int i, String str);
}
