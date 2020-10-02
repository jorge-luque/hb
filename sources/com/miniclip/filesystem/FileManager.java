package com.miniclip.filesystem;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.drive.DriveFile;
import com.miniclip.framework.Miniclip;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileManager {
    public static final int STORAGE_TYPE_BUNDLE = 0;
    public static final int STORAGE_TYPE_SAVE = 1;
    public static final int STORAGE_TYPE_TEMP = 2;

    public static AssetFileDescriptor getAssetFileDescriptor(int i, String str) throws IOException {
        return getAssetFileDescriptor(Miniclip.getActivity(), i, str);
    }

    public static AssetFileDescriptor getAssetFileDescriptor(Context context, int i, String str) throws IOException {
        String str2;
        if (i == 0) {
            return context.getAssets().openFd(str);
        }
        if (i == 1) {
            str2 = context.getFilesDir().getAbsolutePath() + "/Contents/Documents/";
        } else if (i == 2) {
            str2 = context.getFilesDir().getAbsolutePath() + "/Contents/Caches/";
        } else {
            throw new FileNotFoundException("Unknown storage type: " + i);
        }
        File file = new File(str2 + str);
        return new AssetFileDescriptor(ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY), 0, file.length());
    }
}
